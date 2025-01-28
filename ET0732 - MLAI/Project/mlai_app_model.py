from tensorflow.keras.applications.inception_v3 import InceptionV3
from tensorflow.keras.layers import Flatten, Dense, Dropout, BatchNormalization
from tensorflow.keras.models import Model
from tensorflow.keras.preprocessing.image import ImageDataGenerator
from tensorflow.keras.callbacks import ReduceLROnPlateau, EarlyStopping, ModelCheckpoint
from tensorflow.keras.regularizers import l2
import tensorflow as tf
import matplotlib.pyplot as plt

# Hyperparameters
batch_size = 32                         # Batch size for training
epochs = 50                             # Number of training epochs
img_size = (75, 75)                     # Image dimensions
lr = 1e-4                               # Learning rate
loss_func = 'categorical_crossentropy'  # Loss function
optim = tf.keras.optimizers.Adam(learning_rate=lr)  # Optimizer

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
train_dir = 'C:/Python/MLAI/datasets/train/'  # Training dataset directory
test_dir = 'C:/Python/MLAI/datasets/test/'    # Testing dataset directory

# Load Data
train_generator, val_generator, test_generator = image_gen_w_aug(train_dir, test_dir)

# Model Setup
pre_trained_model = InceptionV3(input_shape=(75, 75, 3), include_top=False, weights='imagenet')
for layer in pre_trained_model.layers[:-30]:  # Freeze all but the last 30 layers
    layer.trainable = False

x = Flatten()(pre_trained_model.output)
x = Dense(512, activation='relu', kernel_regularizer=l2(0.01))(x)
x = BatchNormalization()(x)
x = Dropout(0.5)(x)
x = Dense(128, activation='relu', kernel_regularizer=l2(0.01))(x)
x = BatchNormalization()(x)
x = Dropout(0.4)(x)
x = Dense(3, activation='softmax')(x)  # Output layer

model = Model(pre_trained_model.input, x)
model.compile(optimizer=optim, loss=loss_func, metrics=['accuracy'])

# Callbacks
early_stopping = EarlyStopping(monitor='val_loss', patience=8, restore_best_weights=True, verbose=1)
lr_scheduler = ReduceLROnPlateau(monitor='val_loss', factor=0.5, patience=4, verbose=1)
model_checkpoint = ModelCheckpoint('C:/Python/MLAI/best_model.keras', save_best_only=True, monitor='val_accuracy', mode='max')

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

# Evaluation and Save
test_loss, test_accuracy = model.evaluate(test_generator)
print(f"Test Loss: {test_loss:.4f}")
print(f"Test Accuracy: {test_accuracy:.4f}")

model_path = 'C:/Python/MLAI/my_model.hdf5'
tf.keras.models.save_model(model, model_path)
print(f"Model saved to {model_path}")
