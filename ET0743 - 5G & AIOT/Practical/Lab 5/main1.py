from vosk import Model, KaldiRecognizer
import pyaudio

# Load the Vosk model and recognizer
#Change your directory to where the downloaded speech recognition model zip file is located (Directory must not have spaces!!!)
model = Model(r"C:\Users\poh_b\Documents\SP\DCPE 2024 Sem 2\ET0743 - 5G & AIOT\Practical\Lab 5\vosk-model-small-en-us-0.15")
recognizer = KaldiRecognizer(model, 16000)

# Initialize PyAudio and the microphone stream
mic = pyaudio.PyAudio()
stream = mic.open(format=pyaudio.paInt16, channels=1, rate=16000, input=True, frames_per_buffer=8192)
stream.start_stream()

try:
    print("Say something:")
    while True:
        data = stream.read(4096)
        if recognizer.AcceptWaveform(data):
            result = recognizer.Result()
            recognized_text = result[14:-3].strip().lower()
            if recognized_text:
                print("Recognized:", recognized_text)
         

except KeyboardInterrupt:
    pass

# Close the microphone stream and exit
stream.stop_stream()
stream.close()
mic.terminate()
