# Financial Mobile Application

## 🚀 Project Overview
The Financial Mobile Application empowers users to analyze financial data and make smarter decisions, blending the power of native Android (Kotlin) with advanced Python-based machine learning models. This project demonstrates seamless cross-language integration and real-world ML deployment on mobile.

---

## ✨ Key Features

- **Advanced Sentiment Analysis**
  - Enter any financial statement and get a nuanced sentiment analysis (positive/negative).
  - Handles complex sentences and financial-specific language, including negations (e.g., "inflation is not decreasing" is correctly classified as negative).
  - Combines a pre-trained Python ML model with Kotlin-side logic for domain-aware results.

- **Loan Approval Prediction**
  - Input parameters such as income, credit history, and property area to predict loan approval instantly.
  - Powered by an embedded Python model for accurate, offline predictions.

- **Live Financial News**
  - Access the latest financial news within the app via a built-in WebView.

---

## 🛠️ Technology Stack
- **Android (Kotlin)**: Modern, maintainable UI and business logic
- **Python (via Chaquopy)**: Machine learning inference and data processing
- **Machine Learning**: Pre-trained scikit-learn models (sentiment & loan prediction)
- **Chaquopy**: Python-Java bridge for seamless cross-language calls

---

## 💡 How Sentiment Analysis Works

1. **User Input**: User enters a financial statement in the app.
2. **Python Model Inference**: Kotlin code sends the text to a Python function (`perform_sentiment_analysis`) using Chaquopy.
3. **Smart Sentence Splitting**: The Python code splits complex sentences at conjunctions ("and", "but", etc.) for granular analysis.
4. **Negation Handling**: The Python code detects negation words ("not", "never", etc.) and flips sentiment accordingly.
5. **Kotlin-Side Enhancement**: Kotlin adds a final layer of domain-specific checks, ensuring phrases like "inflation is not decreasing" are classified as negative, even if the model misses subtle cases.
6. **Result Display**: The app shows each sentence part with its corresponding sentiment.

**Example:**
> Input: `inflation is not decreasing`
>
> Output: `inflation is not decreasing - Negative`

---

## 📱 How to Run
1. **Clone the repository**
   ```bash
   git clone <repository-url>
   ```
2. **Open in Android Studio**
3. **Sync Gradle and dependencies**
4. **Run on an emulator or Android device**



## 🌟 Why This Project Stands Out
- **Real Machine Learning on Mobile**: Not just API calls—actual ML models run locally on-device.
- **Cross-Language Engineering**: Demonstrates advanced integration between Kotlin and Python.
- **Domain-Aware Sentiment Analysis**: Special logic for financial language, improving accuracy over generic models.
- **Recruiter-Ready**: Clean code, clear architecture, and practical business value.

---

## 🤝 Let's Connect
If you’re a recruiter or developer interested in mobile ML, let’s talk! This project is a showcase of practical AI, cross-platform skills, and user-focused design.

---

