# **Task 5: Text Classification on Consumer Complaint Dataset**

This project **classifies consumer complaints** into the following categories using **Machine Learning**:

## 📌 Categories
0️⃣ Credit reporting, repair, or other  
1️⃣ Debt collection  
2️⃣ Consumer Loan  
3️⃣ Mortgage  

## 🚀 Setup Instructions

### ** Prerequisites**
- Install **Python 3.9+**
- Install required libraries:
```sh
pip install pandas numpy scikit-learn nltk

2. DataSet Description
1. Download consumer_complaints.csv from the link https://catalog.data.gov/dataset/consumer-complaint-database
2. Ensure it has Complaint ID, Consumer complaint narrative, and Product columns.

3. Run the Model Training 
Use the script python kaibur.py to:
1. Load and preprocess data (tokenization, stopword removal, etc.).
2. Train a multi-class classification model.
3. Evaluate the model (accuracy, precision, recall).

Command : python kaibur.py

4. Make Predictions
Use predict.py (or a notebook) to classify new complaints:

Command: python predict.py --text "My mortgage was unfairly processed"
Expected output: A label from {0, 1, 2, 3}.

## 🛠️ Steps

1️⃣ **Exploratory Data Analysis (EDA)**
 1. Check dataset size, distribution of categories.
 2. Identify missing values in Consumer complaint narrative.

2️⃣ **Text Preprocessing** (Tokenization, Stopword Removal, TF-IDF)
1. Tokenization, removing punctuation, lowercasing.
2. Removing stopwords (NLTK or spaCy).
3. Converting to TF-IDF or word embeddings.

3️⃣ **Train Multi-class Classification Model**  (Random Forest, Logistic Regression)
1. Try Logistic Regression, Naive Bayes, or Random Forest.
2. Compare performance on a validation set

4️⃣ **Evaluate Model Performance**  (Accuracy, Precision, Recall, F1 Score)
1. Use metrics like Accuracy, F1-Score, Precision, Recall.
2. Show confusion matrix or classification report.

5️⃣ **Predict Complaint Categories**
1. Preprocess new complaint text.
2. Predict the category (0–3).

6. Screenshots
1. Hyperparameter Tuning
The image shows the results of hyperparameter tuning for a Logistic Regression model.
(https://github.com/user-attachments/assets/eee9f377-4071-4694-8ffb-39a3f10f228d)

2. Confusion Matrix (Logistic Regression)
The confusion matrix for Logistic Regression shows correct predictions along the diagonal.
(https://github.com/user-attachments/assets/ff198192-65a9-4477-bf42-268088ca7459)

3. Confusion Matrix (Random Forest)
The confusion matrix for Random Forest shows better classification performance.
(https://github.com/user-attachments/assets/5f408bd1-1b66-48b0-a674-f9d6033ae915)

4. Top 20 Features (Random Forest)
The bar chart shows the most important features in a Random Forest model.
(https://github.com/user-attachments/assets/af82a256-7212-4281-bf2c-d070604c2896)

5. Model Predictions
The image shows predictions from Random Forest and Logistic Regression models.
(https://github.com/user-attachments/assets/c9534d7d-62a4-463b-a3b6-3f7a4c58261b)
