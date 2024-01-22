package com.example.financialmobileapplication

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.chaquo.python.PyObject
import com.chaquo.python.Python
import java.io.BufferedInputStream
import java.io.BufferedOutputStream
import java.io.File
import java.io.FileOutputStream

class predict_loan_page: AppCompatActivity() {

    private lateinit var genderEditText: EditText
    private lateinit var marriedEditText: EditText
    private lateinit var dependentsEditText: EditText
    private lateinit var educationEditText: EditText
    private lateinit var selfEmployedEditText: EditText
    private lateinit var incomeEditText: EditText
    private lateinit var coapplicantIncomeEditText: EditText
    private lateinit var loanAmountEditText: EditText
    private lateinit var loanAmountTermEditText: EditText
    private lateinit var creditHistoryEditText: EditText
    private lateinit var propertyAreaEditText: EditText
    private lateinit var caluclateButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.predict_load_layout)

        genderEditText = findViewById(R.id.genderedittext)
        marriedEditText = findViewById(R.id.marriedEdittext)
        dependentsEditText = findViewById(R.id.dependentsEdittext)
        educationEditText = findViewById(R.id.EducationEdittext)
        selfEmployedEditText = findViewById(R.id.self_employedEdittext)
        incomeEditText = findViewById(R.id.incomeEdittext)
        coapplicantIncomeEditText = findViewById(R.id.CoapplicantIncomeEdittext)
        loanAmountEditText = findViewById(R.id.LoanAmountEdittext)
        loanAmountTermEditText = findViewById(R.id.Loan_Amount_TermEdittext)
        creditHistoryEditText = findViewById(R.id.Credit_HistoryEdittext)
        propertyAreaEditText = findViewById(R.id.Property_AreaEdittext)
        caluclateButton=findViewById(R.id.caluclateButton)
        val resultTextView=findViewById<TextView>(R.id.resultTextView)

        caluclateButton.setOnClickListener {
            val gender = genderEditText.text.toString().toInt()
            val married = marriedEditText.text.toString().toInt()
            val dependents = dependentsEditText.text.toString().toInt()
            val education = educationEditText.text.toString().toInt()
            val selfEmployed = selfEmployedEditText.text.toString().toInt()
            val income = incomeEditText.text.toString().toDouble()
            val coapplicantIncome = coapplicantIncomeEditText.text.toString().toDouble()
            val loanAmount = loanAmountEditText.text.toString().toDouble()
            val loanAmountTerm = loanAmountTermEditText.text.toString().toInt()
            val creditHistory = creditHistoryEditText.text.toString().toInt()
            val propertyArea = propertyAreaEditText.text.toString().toInt()

            val result = Python.getInstance().getModule("loan_status_predictor").callAttr("load_model", gender, married, dependents, education, selfEmployed,
                income, coapplicantIncome, loanAmount, loanAmountTerm, creditHistory, propertyArea)

            if (result.toString().equals("[1]"))
                resultTextView.text="Loan Approved"

            else
                resultTextView.text="Loan Not Approved"

            Toast.makeText(this,resultTextView.text,Toast.LENGTH_SHORT).show()


        }

        //val python = Python.getInstance()







    }

}


