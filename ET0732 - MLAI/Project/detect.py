from PIL import Image, ImageOps
import tensorflow as tf
import cv2
import numpy as np

# Load the Saved Model
model = tf.keras.models.load_model('C:/Python/rps/my_model.hdf5')

def import_and_predict(image_data, model):
    size = (75, 75)
    image = ImageOps.fit(image_data, size, Image.LANCZOS)
    image = image.convert('RGB')
    image = np.asarray(image)
    image = (image.astype(np.float32) / 255.0)
    img_reshape = image[np.newaxis, ...]
    prediction = model.predict(img_reshape)
    return prediction

# Start Webcam
cap = cv2.VideoCapture(0)
if not cap.isOpened():
    print("Error: Could not open webcam.")
    exit()

labels = ["Bottles", "Cans", "Unknown"]
confidence_threshold = 50.0  # Confidence threshold for classification

while cap.isOpened():
    ret, frame = cap.read()
    if not ret:
        print("Error: Failed to grab frame.")
        break

    resized_frame = cv2.resize(frame, (75, 75))
    image = Image.fromarray(cv2.cvtColor(resized_frame, cv2.COLOR_BGR2RGB))
    prediction = import_and_predict(image, model)
    
    confidence = np.max(prediction) * 100
    if confidence < confidence_threshold:
        label = "Unknown"
    else:
        label = labels[np.argmax(prediction)]
    
    # Display Prediction on the Frame
    text = f"{label}: {confidence:.2f}%"
    cv2.putText(frame, text, (10, 30), cv2.FONT_HERSHEY_SIMPLEX, 0.9, (255, 0, 0), 2)
    cv2.imshow("Cans and Bottles Detection", frame)
    
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

# Release resources
cap.release()
cv2.destroyAllWindows()
