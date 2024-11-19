# https://towardsdatascience.com/how-to-build-your-own-chatbot-using-deep-learning-bb41f970e281

# Import necessary libraries
import json 
import numpy as np 
import tensorflow as tf
from tensorflow import keras
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense, Embedding, GlobalAveragePooling1D
from tensorflow.keras.preprocessing.text import Tokenizer
from tensorflow.keras.preprocessing.sequence import pad_sequences
from sklearn.preprocessing import LabelEncoder


# Load the intent data from the 'intents.json' file
with open('intents.json') as file:
    data = json.load(file)


# Initialize lists to store training data
training_sentences = []
training_labels = []
labels = []
responses = []


# Extract patterns, labels, and responses from the intent data
for intent in data['intents']:
    for pattern in intent['patterns']:
        training_sentences.append(pattern)
        training_labels.append(intent['tag'])
    responses.append(intent['responses'])

    # Add unique intent tags to the 'labels' list
    if intent['tag'] not in labels:
        labels.append(intent['tag'])


# Calculate the number of unique classes
num_classes = len(labels)


# Encode the training labels using LabelEncoder
lbl_encoder = LabelEncoder()
lbl_encoder.fit(training_labels)
training_labels = lbl_encoder.transform(training_labels)


# Set hyperparameters for tokenization and padding
vocab_size = 1000
embedding_dim = 16
max_len = 20
oov_token = "<OOV>"


# Tokenize and pad the sequences
tokenizer = Tokenizer(num_words=vocab_size, oov_token=oov_token)
tokenizer.fit_on_texts(training_sentences)
word_index = tokenizer.word_index
sequences = tokenizer.texts_to_sequences(training_sentences)
padded_sequences = pad_sequences(sequences, truncating='post', maxlen=max_len)


# Build a Sequential model with an Embedding layer
model = Sequential()
model.add(Embedding(vocab_size, embedding_dim, input_length=max_len))
model.add(GlobalAveragePooling1D())
model.add(Dense(16, activation='relu'))
model.add(Dense(16, activation='relu'))
model.add(Dense(num_classes, activation='softmax'))

# Compile the model
model.compile(loss='sparse_categorical_crossentropy', 
              optimizer='adam', metrics=['accuracy'])

# Display a summary of the model architecture
model.summary()


# Set the number of training epochs
epochs = 500
# Train the model on the padded sequences and training labels
history = model.fit(padded_sequences, np.array(training_labels), epochs=epochs)


# to save the trained model
model.save("chat_model")

import pickle

# to save the fitted tokenizer
with open('tokenizer.pickle', 'wb') as handle:
    pickle.dump(tokenizer, handle, protocol=pickle.HIGHEST_PROTOCOL)
    
# to save the fitted label encoder
with open('label_encoder.pickle', 'wb') as ecn_file:
    pickle.dump(lbl_encoder, ecn_file, protocol=pickle.HIGHEST_PROTOCOL)
