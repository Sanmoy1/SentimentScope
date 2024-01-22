package com.example.financialmobileapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform

class MainActivity : AppCompatActivity() {

    private lateinit var news_id: Button
    private lateinit var load_prediction_button:Button
    private lateinit var sentiment_analysisButton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        news_id=findViewById(R.id.news_id)
        load_prediction_button=findViewById(R.id.load_prediction_button)
        sentiment_analysisButton=findViewById(R.id.sentiment_analysisButton)

        news_id.setOnClickListener {
            val intent= Intent(this,WebViewActivity::class.java)
            startActivity(intent)
        }

        if (!Python.isStarted()) {
            Python.start(AndroidPlatform(this))
        }
        load_prediction_button.setOnClickListener {
            val intent=Intent(this,predict_loan_page::class.java)
            startActivity(intent)
        }
        sentiment_analysisButton.setOnClickListener {
            val intent=Intent(this,Sentiment_analysis::class.java)
            startActivity(intent)
        }

    }
}