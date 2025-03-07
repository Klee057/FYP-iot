# FYP- IoT: Smart Automated home system
This project aims to design and implement a more cost-effective digital door lock. It
will take form in a digital facial recognition door lock, and it is designed to have a low energy
consumption and an integrated supply of energy. The IoT-enabled home system consists of
raspberry pi, a camera, and a servomotor.\
Furthermore, the system will be designed to seamlessly integrate with smartphones through a
distinctive mobile application, providing users with a user-friendly interface for control and
monitoring

# Features
## Person Detection
Uses an ultrasonic sensor to detect a person within 0.5 meters.\
- Image Retrieval from Firebase\
- 
Retrieves stored facial images from Firebase for comparison.\
- Face Recognition & Matching

## Compares detected face with stored face encodings
If the face is recognized, the door unlocks automatically.\
If the face is unknown, an alert is triggered.\
- Unknown Face Alert\

## Raspberry Pi and Android application communication
Displays an “alertTextView” dialog on app if the face is unrecognized.\
Allows the administrator to verify and approve access.\
- Administrator Override\

Admin can press "Enter" to send a command to the Raspberry Pi to unlock the door manually via a Servo motor.\

# Demo of facial recognition Android application:
https://youtu.be/qUYd8dFTbM4
