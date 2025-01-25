import numpy as np
import streamlit as st
import tensorflow as tf
from PIL import Image, ImageOps

# Load the Saved Model
model = tf.keras.models.load_model('C:/Python/rps/my_model.keras')

# Prediction Function
def import_and_predict(image_data, model):
    size = (75, 75)
    image = ImageOps.fit(image_data, size, Image.LANCZOS)
    image = image.convert('RGB')
    image = np.asarray(image)
    image = (image.astype(np.float32) / 255.0)
    img_reshape = image[np.newaxis, ...]
    prediction = model.predict(img_reshape)
    return prediction

# Streamlit App
st.write("""
# Cans and Bottles Classification
Upload an image of a Can or Bottle to classify.
""")

file = st.file_uploader("Upload an Image", type=["jpg", "png"])

if file is None:
    st.text("Please upload an image file.")
else:
    image = Image.open(file)
    st.image(image, use_column_width=True)
    prediction = import_and_predict(image, model)
    labels = ["Bottles", "Cans"]
    st.write(f"Prediction: **{labels[np.argmax(prediction)]}**")
    st.text("Prediction Probabilities:")
    st.write(prediction)
