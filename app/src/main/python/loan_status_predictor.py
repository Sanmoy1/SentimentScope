import pandas as pd
import pickle
import os
import joblib

def load_model():
    script_dir = os.path.dirname(os.path.abspath(__file__))
    print(script_dir)
    model_path = os.path.join(script_dir, 'loan_status_predict.pkl')

    model = joblib.load(model_path)
    print(type(model))
    print(dir(model))
    # Create a DataFrame with the user input
    user_data = pd.DataFrame({
        'Gender': [1],
        'Married': [0],
        'Dependents': [1],
        'Education': [1],
        'Self_Employed': [0],
        'ApplicantIncome': [25000],
        'CoapplicantIncome': [0],
        'LoanAmount': [250000],
        'Loan_Amount_Term': [24],
        'Credit_History': [1],
        'Property_Area': [1]
    })

        # Make prediction using the model
    result = model.predict(user_data)
    if result == 1:
        print("Loan Approved")
    else:
        print("Loan Not Approved")
    return result

