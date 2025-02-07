import numpy as np
import streamlit as st
import tensorflow as tf
from PIL import Image, ImageOps

def import_and_predict(image_data, model):
    
        size = (75,75)    
        image = ImageOps.fit(image_data, size, Image.LANCZOS)
        image = image.convert('RGB')
        image = np.asarray(image)
        image = (image.astype(np.float32) / 255.0)

        img_reshape = image[np.newaxis,...]

        prediction = model.predict(img_reshape)
        
        return prediction

model = tf.keras.models.load_model('C:/Users/poh_b/Documents/SP/DCPE 2024 Sem 2/ET0732 - MLAI/p2241520_lushiqi_p2241885_PohBoonSiong/my_custom_model.hdf5') #loading a trained model

st.write("""
# Cans and Bottles Classification
Upload an image of a Can or Bottle to classify.
""")

file = st.file_uploader("Please upload an image file", type=["jpg", "png"])
#
if file is None:
    st.text("You haven't uploaded an image file")
else:
    image = Image.open(file)
    st.image(image, use_column_width=True)
    prediction = import_and_predict(image, model)
    
    if np.argmax(prediction) == 0:
        st.write("is a Bottle!")
    elif np.argmax(prediction) == 1:
        st.write("It is a Can!")
    else:
        st.write("Unkown!")
    
    st.text("Probability (0: Bottle, 1: Can, 2: Unkown!)")
    st.write(prediction)
