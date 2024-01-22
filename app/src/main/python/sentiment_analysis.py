import pandas as pd
import pickle
import os
import joblib
import re
def perform_sentiment_analysis(sentence):
    # Get the current script directory
    script_dir = os.path.dirname(os.path.abspath(__file__))

    # Construct the path to the sentiment model
    model_path = os.path.join(script_dir, 'sentiment.pkl')

    # Load the sentiment model using joblib
    model = joblib.load(model_path)

    # Use dummy data for sentiment analysis

    #sentence = "Stock market is not performing well, but nifty is performing good"
    input_parts = split_sentence(sentence)
    results= []
    for part in input_parts:
            result = model.predict([part])[0]

            # Check for negation words
            if contains_negation(part):
                result = 'negative' if result == 'positive' else 'positive'

            results.append((part, result))

    for part, sentiment in results:
        print(f'{part} - {sentiment.capitalize()}')
    print(sentence)
    return results
    #result = model.predict([sentence])
    #print(f"{sentence} - {result}")

def split_sentence(text):
    conjunctions = re.compile(r'\b(?:and|or|so|since|for|because|as|but|yet)\b', re.IGNORECASE)
    parts = re.split(conjunctions, text)
    return [part.strip() for part in parts if part.strip()]

def contains_negation(text):
    negation_words = re.compile(r'\b(?:not|no|never|none|nobody|nowhere|nothing|neither|nor|n\'t)\b', re.IGNORECASE)
    return bool(negation_words.search(text))

    # Perform sentiment analysis on dummy data
    """ for sentence in dummy_data:
        result = model.predict([sentence])


        #sentiment_result = "Positive" if result[0] == 'positive' else "Negative"


        print(f"{sentence} - {result}") """


