from vosk import Model, KaldiRecognizer
import pyaudio
import turtle

# Load the Vosk model and recognizer
model = Model(r"C:\Users\poh_b\Documents\SP\DCPE 2024 Sem 2\ET0743 - 5G & AIOT\Practical\Lab 5\vosk-model-small-en-us-0.15")
recognizer = KaldiRecognizer(model, 16000)

# Initialize PyAudio and the microphone stream
mic = pyaudio.PyAudio()
stream = mic.open(format=pyaudio.paInt16, channels=1, rate=16000, input=True, frames_per_buffer=1024)
stream.start_stream()

# Initialize the TurtleSim window
window = turtle.Screen()
window.title("Voice Control TurtleSim")
t = turtle.Turtle()

# Define function to move the turtle
def move_turtle(direction):
    if direction == "left":
        t.left(90)
    elif direction == "right":
        t.right(90)
    elif direction == "up":
        t.forward(10)
    elif direction == "down":
        t.backward(10)

try:
    while True:
        data = stream.read(16000)
        
        if recognizer.AcceptWaveform(data):
            result = recognizer.Result()
            recognized_text = result[14:-3].strip().lower()
            
            print("Recognized:", recognized_text)
            
            if recognized_text == "stop":
                break
            else:
                move_turtle(recognized_text)
        
except KeyboardInterrupt:
    pass

# Close the microphone stream and exit
stream.stop_stream()
stream.close()
mic.terminate()
turtle.bye()
