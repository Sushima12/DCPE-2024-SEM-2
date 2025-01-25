import pickle
from tensorflow.keras.applications.inception_v3 import InceptionV3
from tensorflow.keras.layers import Flatten, Dense, Dropout, BatchNormalization
from tensorflow.keras.models import Model
from tensorflow.keras.preprocessing.image import ImageDataGenerator
from tensorflow.keras.callbacks import ReduceLROnPlateau, EarlyStopping, ModelCheckpoint
from tensorflow.keras.regularizers import l2
import tensorflow as tf

# Data Augmentation with More Variability
def image_gen_w_aug(train_parent_directory, test_parent_directory):
    train_datagen = ImageDataGenerator(
        rescale=1/255,
        rotation_range=50,
        zoom_range=0.5,
        width_shift_range=0.4,
        height_shift_range=0.4,
        shear_range=0.4,
        brightness_range=[0.5, 1.5],
        horizontal_flip=True,
        fill_mode='nearest',
        validation_split=0.3
    )
    test_datagen = ImageDataGenerator(rescale=1/255)
    
    train_generator = train_datagen.flow_from_directory(
        train_parent_directory,
        target_size=(75, 75),
        batch_size=32,
        class_mode='categorical',
        subset='training'
    )
    val_generator = train_datagen.flow_from_directory(
        train_parent_directory,
        target_size=(75, 75),
        batch_size=32,
        class_mode='categorical',
        subset='validation'
    )
    test_generator = test_datagen.flow_from_directory(
        test_parent_directory,
        target_size=(75, 75),
        batch_size=32,
        class_mode='categorical'
    )
    return train_generator, val_generator, test_generator

# Dataset Paths
train_dir = 'C:/Python/rps/datasets/train/'
test_dir = 'C:/Python/rps/datasets/test/'

# Load Data
train_generator, val_generator, test_generator = image_gen_w_aug(train_dir, test_dir)
print("Updated class indices:", train_generator.class_indices)

# Pre-trained Model
pre_trained_model = InceptionV3(input_shape=(75, 75, 3), include_top=False, weights='imagenet')
for layer in pre_trained_model.layers[:-30]:  # Freeze more layers to prevent overfitting
    layer.trainable = False

# Build Model
x = Flatten()(pre_trained_model.output)
x = Dense(512, activation='relu', kernel_regularizer=l2(0.03))(x)
x = BatchNormalization()(x)
x = Dropout(0.6)(x)  # Increased dropout
x = Dense(128, activation='relu', kernel_regularizer=l2(0.03))(x)
x = BatchNormalization()(x)
x = Dropout(0.5)(x)
x = Dense(3, activation='softmax')(x)  # Adjust number of classes if necessary

model = Model(pre_trained_model.input, x)
model.compile(optimizer=tf.keras.optimizers.Adam(learning_rate=1e-4),
              loss='categorical_crossentropy', metrics=['accuracy'])

# Callbacks
early_stopping = EarlyStopping(monitor='val_loss', patience=8, restore_best_weights=True, verbose=1)
lr_scheduler = ReduceLROnPlateau(monitor='val_loss', factor=0.5, patience=4, verbose=1)
model_checkpoint = ModelCheckpoint('C:/Python/rps/best_model.keras', save_best_only=True, monitor='val_accuracy', mode='max')

# Train Model
history = model.fit(
    train_generator, 
    validation_data=val_generator, 
    epochs=40,  # Fewer epochs to avoid overfitting
    callbacks=[early_stopping, lr_scheduler, model_checkpoint], 
    verbose=1
)

# Save Model and History
model.save('C:/Python/rps/final_model.keras')
print("Model saved as 'final_model.keras'.")

with open('C:/Python/rps/training_history.pkl', 'wb') as file:
    pickle.dump(history.history, file)
print("Training history saved as 'training_history.pkl'.")
