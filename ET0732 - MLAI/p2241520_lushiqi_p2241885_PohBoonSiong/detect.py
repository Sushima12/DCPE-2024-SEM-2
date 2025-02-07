from PIL import Image, ImageOps
import tensorflow as tf
import cv2
import numpy as np

def import_and_predict(image_data, model):
    size = (75, 75)    
    image = ImageOps.fit(image_data, size, Image.LANCZOS)
    image = image.convert('RGB')
    image = np.asarray(image)
    image = (image.astype(np.float32) / 255.0)
    img_reshape = image[np.newaxis, ...]
    prediction = model.predict(img_reshape)
    return prediction

# Load the model
model = tf.keras.models.load_model('C:/Users/poh_b/Documents/SP/DCPE 2024 Sem 2/ET0732 - MLAI/p2241520_lushiqi_p2241885_PohBoonSiong/my_custom_model.hdf5')

# Open webcam
cap = cv2.VideoCapture(0)

if not cap.isOpened():
    print("Error: Camera not accessible!")
    exit()

while True:
    ret, frame = cap.read()
    if not ret:
        break
    
    # Preprocess frame
    image = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)
    image_pil = Image.fromarray(image)

    # Prediction
    prediction = import_and_predict(image_pil, model)
    confidence = np.max(prediction) * 100  # Calculate confidence percentage

    if np.argmax(prediction) == 0:
        predict = f"Bottle ({confidence:.2f}%)"
    elif np.argmax(prediction) == 1:
        predict = f"Can ({confidence:.2f}%)"
    else:
        predict = f"Unknown ({confidence:.2f}%)"

    # Display predictions on frame
    cv2.putText(frame, predict, (10, 30), cv2.FONT_HERSHEY_SIMPLEX, 0.9, (0, 255, 0), 2)

    # Adding a bounding box effect for "Wow Factor"
    height, width, _ = frame.shape
    box_color = (255, 0, 0) if np.argmax(prediction) == 0 else (0, 255, 0) if np.argmax(prediction) == 1 else (0, 0, 255)
    cv2.rectangle(frame, (5, 5), (width - 5, height - 5), box_color, 2)

    # Display the webcam feed with predictions
    cv2.imshow("Classification", frame)

    # Exit on 'q' key
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

cap.release()
cv2.destroyAllWindows()