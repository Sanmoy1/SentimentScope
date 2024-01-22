import pandas as pd
import pickle
import os
import joblib

def load_model(gender, married, dependents, education, self_employed, applicant_income,
               coapplicant_income, loan_amount, loan_amount_term, credit_history, property_area):
    script_dir = os.path.dirname(os.path.abspath(__file__))
    model_path = os.path.join(script_dir, 'loan_status_predict.pkl')

    model = joblib.load(model_path)

    # Create a DataFrame with the user input
    user_data = pd.DataFrame({
        'Gender': [gender],
        'Married': [married],
        'Dependents': [dependents],
        'Education': [education],
        'Self_EEmployed': [self_employed],
        'ApplicantIncome': [applicant_income],
        'CoapplicantIncome': [coapplicant_income],
        'LoanAmount': [loan_amount],
        'Loan_Amount_Term': [loan_amount_term],
        'Credit_History': [credit_history],
        'Property_Area': [property_area]
    })

    # Make prediction using the model
    result = model.predict(user_data)
    if result == 1:
        print("Loan Approved")
    else:
        print("Loan Not Approved")
    return result
