from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Conv2D, MaxPooling2D, Flatten, Dense, Dropout, BatchNormalization, Input
from tensorflow.keras.preprocessing.image import ImageDataGenerator
from tensorflow.keras.callbacks import ReduceLROnPlateau, EarlyStopping, ModelCheckpoint
from tensorflow.keras.regularizers import l2
import tensorflow as tf
import matplotlib.pyplot as plt

# Hyperparameters
batch_size = 32                         # Batch size for training
epochs = 50                             # Number of training epochs
img_size = (75, 75)                     # I  mage dimensions 
lr = 1e-4                               # Learning rate
loss_func = 'categorical_crossentropy'  # Loss function
optim = tf.keras.optimizers.Adam(learning_rate=lr)    # Optimizer

# Data Augmentation
def image_gen_w_aug(train_parent_directory, test_parent_directory):
    train_datagen = ImageDataGenerator(
        rescale=1/255,
        rotation_range=50,
        zoom_range=0.5,
        width_shift_range=0.4,
        height_shift_range=0.4,
        shear_range=0.4,
        brightness_range=[0.3, 1.5],
        horizontal_flip=True,
        fill_mode='nearest',
        validation_split=0.3
    )
    test_datagen = ImageDataGenerator(rescale=1/255)

    train_generator = train_datagen.flow_from_directory(
        train_parent_directory,
        target_size=img_size,
        batch_size=batch_size,
        class_mode='categorical',
        subset='training'
    )
    val_generator = train_datagen.flow_from_directory(
        train_parent_directory,
        target_size=img_size,
        batch_size=batch_size,
        class_mode='categorical',
        subset='validation'
    )
    test_generator = test_datagen.flow_from_directory(
        test_parent_directory,
        target_size=img_size,
        batch_size=batch_size,
        class_mode='categorical'
    )
    return train_generator, val_generator, test_generator

# Dataset Paths
train_dir = 'C:/Users/poh_b/Documents/SP/DCPE 2024 Sem 2/ET0732 - MLAI/p2241520_lushiqi_p2241885_PohBoonSiong/datasets/train'  # Training dataset directory
test_dir = 'C:/Users/poh_b/Documents/SP/DCPE 2024 Sem 2/ET0732 - MLAI/p2241520_lushiqi_p2241885_PohBoonSiong/datasets/test'    # Testing dataset directory
val_dir = 'C:/Users/poh_b/Documents/SP/DCPE 2024 Sem 2/ET0732 - MLAI/p2241520_lushiqi_p2241885_PohBoonSiong/datasets/val'      # Validating dataset directory

# Load Data
train_generator, val_generator, test_generator = image_gen_w_aug(train_dir, test_dir)

# Define Custom Neural Network
def create_custom_model(input_shape):
    model = Sequential([
        Input(shape=input_shape),
        Conv2D(32, (3, 3), activation='relu', padding='same'),
        BatchNormalization(),
        MaxPooling2D(pool_size=(2, 2)),

        Conv2D(64, (3, 3), activation='relu', padding='same'),
        BatchNormalization(),
        MaxPooling2D(pool_size=(2, 2)),

        Conv2D(128, (3, 3), activation='relu', padding='same'),
        BatchNormalization(),
        MaxPooling2D(pool_size=(2, 2)),

        Flatten(),
        Dense(512, activation='relu', kernel_regularizer=l2(0.01)),
        Dropout(0.5),
        Dense(128, activation='relu', kernel_regularizer=l2(0.01)),
        Dropout(0.4),
        Dense(3, activation='softmax')  # Output layer for 3 classes
    ])
    return model

# Model Setup
input_shape = (75, 75, 3)
model = create_custom_model(input_shape)
model.compile(optimizer=optim, loss=loss_func, metrics=['accuracy'])

# Display Model Summary
model.summary()

# Callbacks
early_stopping = EarlyStopping(monitor='val_loss', patience=8, restore_best_weights=True, verbose=1)
lr_scheduler = ReduceLROnPlateau(monitor='val_loss', factor=0.5, patience=4, verbose=1)
model_checkpoint = ModelCheckpoint('C:/Users/poh_b/Documents/SP/DCPE 2024 Sem 2/ET0732 - MLAI/p2241520_lushiqi_p2241885_PohBoonSiong/best_custom_model.keras', save_best_only=True, monitor='val_accuracy', mode='max')

# Training
history = model.fit(
    train_generator,
    validation_data=val_generator,
    epochs=epochs,
    callbacks=[early_stopping, lr_scheduler, model_checkpoint],
    verbose=1
)

# Plot Training History
plt.figure(figsize=(12, 4))

plt.subplot(1, 2, 1)
plt.plot(history.history['accuracy'], label='Training Accuracy')
plt.plot(history.history['val_accuracy'], label='Validation Accuracy')
plt.title('Model Accuracy')
plt.xlabel('Epoch')
plt.ylabel('Accuracy')
plt.legend()

plt.subplot(1, 2, 2)
plt.plot(history.history['loss'], label='Training Loss')
plt.plot(history.history['val_loss'], label='Validation Loss')
plt.title('Model Loss')
plt.xlabel('Epoch')
plt.ylabel('Loss')
plt.legend()

plt.tight_layout()
plt.show()

model_path = 'C:/Python/MLAI/my_custom_model.hdf5'
tf.keras.models.save_model(model, model_path)
print(f"Model saved to {model_path}")