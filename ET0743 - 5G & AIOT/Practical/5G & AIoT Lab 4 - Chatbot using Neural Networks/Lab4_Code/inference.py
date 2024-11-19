import json 
import numpy as np
from tensorflow import keras
from sklearn.preprocessing import LabelEncoder

import colorama 
colorama.init()
from colorama import Fore, Style, Back

import random
import pickle

# Load the intents from the JSON file
with open("intents.json") as file:
    data = json.load(file)


def chat():
    # load the pre-trained neural network model
    model = keras.models.load_model('chat_model')

    # load the tokenizer object used for word tokenization
    with open('tokenizer.pickle', 'rb') as handle:
        tokenizer = pickle.load(handle)

    # load the label encoder object used for encoding and decoding labels
    with open('label_encoder.pickle', 'rb') as enc:
        lbl_encoder = pickle.load(enc)

    #  set the maximum length for input sequences
    max_len = 20
    
    while True:
        # prompt the user for input
        print(Fore.LIGHTBLUE_EX + "User: " + Style.RESET_ALL, end="")
        inp = input()

        # check if the user wants to quit the chat
        if inp.lower() == "quit":
            break

        # preprocess user input for prediction
        result = model.predict(keras.preprocessing.sequence.pad_sequences(tokenizer.texts_to_sequences([inp]),
                                             truncating='post', maxlen=max_len))
        
        # decode the predicted label using the label encoder
        tag = lbl_encoder.inverse_transform([np.argmax(result)])

        # find the intent in the data corresponding to the predicted label
        for i in data['intents']:
            if i['tag'] == tag:
                # print a response from the selected intent
                print(Fore.GREEN + "ChatBot:" + Style.RESET_ALL , np.random.choice(i['responses']))

print(Fore.YELLOW + "Start messaging with the bot (type quit to stop)!" + Style.RESET_ALL)
# start the chat
chat()
