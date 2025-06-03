package com.example.financialmobileapplication

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.chaquo.python.PyObject
import com.chaquo.python.Python

class Sentiment_analysis:AppCompatActivity() {

    private lateinit var user_textEdittext:EditText
    private lateinit var predicted_analysisTextview:TextView
    private lateinit var predictButton:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sentiment_analysis_page)

        user_textEdittext=findViewById(R.id.user_textEdittext)
        predicted_analysisTextview=findViewById(R.id.predicted_analysisTextview)
        predictButton=findViewById(R.id.predictButton)



        predictButton.setOnClickListener {
            val userText=user_textEdittext.text.toString()
            val result = Python.getInstance().getModule("sentiment_analysis").callAttr("perform_sentiment_analysis",userText)
            handleSentimentAnalysisResult(result)
            //predicted_analysisTextview.text= result.asList().toString()
        }




        //handleSentimentAnalysisResult(result)
    }
    private fun handleSentimentAnalysisResult(result: PyObject) {
        // Check if the result is a list

            val resultList = result.asList()

            // Create a StringBuilder to build the result text
            val resultTextBuilder = StringBuilder()

            // Iterate through the result list and append to the StringBuilder
            for (item in resultList) {
                val part = item.asList()[0].toString()
                var sentiment = item.asList()[1].toString().capitalize()

                if ((part.contains("not") || part.contains("n't")) &&
                    (part.contains("decrease") || part.contains("decreasing") ||
                            part.contains("improve") || part.contains("improving") ||
                            part.contains("increase") || part.contains("increasing") ||
                            part.contains("better") || part.contains("worse"))) {

                    if ((part.contains("not") || part.contains("n't")) &&
                        sentiment == "Positive" &&
                        (part.contains("decrease") || part.contains("decreasing") ||
                                part.contains("worse"))) {
                        sentiment = "Negative"
                    } else if ((part.contains("not") || part.contains("n't")) &&
                        sentiment == "Negative" &&
                        (part.contains("increase") || part.contains("increasing") ||
                                part.contains("improve") || part.contains("improving") ||
                                part.contains("better"))) {
                        sentiment = "Positive"
                    }
                }
                resultTextBuilder.append("$part - $sentiment\n")
            }

            // Update the TextView with the result text
            predicted_analysisTextview.text = resultTextBuilder.toString()

    }
}