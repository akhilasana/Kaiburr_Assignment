import nltk
nltk.download('punkt')
nltk.download('stopwords')
nltk.download('wordnet')

import re
import nltk
import pandas as pd
from nltk.tokenize import word_tokenize
from nltk.corpus import stopwords
from nltk.stem import WordNetLemmatizer

# Ensure you have downloaded 'punkt', 'stopwords', and 'wordnet' beforehand

def preprocess_text(text):
    """
    Text preprocessing function for VS Code execution
    """
    if not isinstance(text, str):
        return ''
    
    # Convert to lowercase
    text = text.lower()
    
    # Remove URLs
    text = re.sub(r'http\S+|www\S+|https\S+', '', text)
    
    # Remove email addresses
    text = re.sub(r'\S+@\S+', '', text)
    
    # Remove special characters, numbers, and punctuation
    text = re.sub(r'[^a-zA-Z\s]', '', text)
    
    # Remove 'XXXX' patterns
    text = re.sub(r'xxxx+', ' ', text)
    
    # Remove extra whitespace
    text = re.sub(r'\s+', ' ', text).strip()
    
    # Tokenization
    tokens = word_tokenize(text)
    
    # Remove stopwords
    stop_words = set(stopwords.words('english'))
    tokens = [token for token in tokens if token not in stop_words]
    
    # Lemmatization
    lemmatizer = WordNetLemmatizer()
    tokens = [lemmatizer.lemmatize(token) for token in tokens]
    
    # Join tokens back into text
    return ' '.join(tokens)

# Sample DataFrame for testing
df = pd.DataFrame({'combined_text': [
    "This is a sample complaint! Visit http://example.com or email me at test@example.com."
]})

# Apply preprocessing
df['processed_text'] = df['combined_text'].apply(preprocess_text)

# Print result
print(df[['combined_text', 'processed_text']])
