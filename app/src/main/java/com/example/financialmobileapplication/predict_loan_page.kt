package com.example.financialmobileapplication

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.chaquo.python.PyObject
import com.chaquo.python.Python
import java.io.BufferedInputStream
import java.io.BufferedOutputStream
import java.io.File
import java.io.FileOutputStream

class predict_loan_page: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.predict_load_layout)

        val resultTextView=findViewById<TextView>(R.id.resultTextView)

        val python = Python.getInstance()

        //val loanStatusPredictor = python.getModule("loan_status_predictor")
        val result = Python.getInstance().getModule("loan_status_predictor").callAttr("load_model")
        resultTextView.text=result.toString()

        //val model=loanStatusPredictor.callAttr("main")
        //resultTextView.text=model.toString()

        // Load the model from the pickle file
        //val modelPath = "${externalCacheDir?.absolutePath}/loan_status_predict.pkl"

        /*val modelPath = cacheDir.absolutePath + "/loan_status_predict.pkl"
        val modelInputStream = resources.openRawResource(R.raw.loan_status_predict)
        modelInputStream.copyTo(FileOutputStream(modelPath))*/



        //val model = loanStatusPredictor.callAttr("load_model", modelPath)



        // Example: Make a prediction with provided feature values
        /*val features = arrayListOf(1, 0, 1, 1, 0, 25000, 0, 250000, 24, 1, 1)
        val prediction = loanStatusPredictor.callAttr("predict_loan_status", model, features)

        resultTextView.text= prediction.toString()*/

        // Use the prediction as needed
        //println("Loan Status Prediction: $prediction")
        /*if (model != null && model.toString() != "None") {
            // Model loaded successfully
            // Example: Make a prediction with provided feature values
            val features = arrayListOf(1, 0, 1, 1, 0, 25000, 0, 250000, 24, 1, 1)
            val prediction = loanStatusPredictor.callAttr("predict_loan_status", model, features)

            if (prediction != null && prediction.toString() != "None" && prediction.toString() != "Error") {
                // Use the prediction as needed
                resultTextView.text = prediction.toString()
            } else {
                resultTextView.text = "Error predicting loan status: ${prediction?.toString() ?: "Unknown error"}"
            }

        } else {
            resultTextView.text = "Error loading the model: Null model"
        }*/

        //val features = arrayListOf(1, 1, 2, 0, 0, 2889, 0.0, 45, 180, 0, 1)
        //val prediction = loanStatusPredictor.callAttr("predict_loan_status", model, features)

        //resultTextView.text = if (prediction.toInt() == 1) "Loan Approved" else "Loan Not Approved"


    }
}


