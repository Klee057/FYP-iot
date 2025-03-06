import subprocess
import threading
import time
from gpiozero import DistanceSensor
from gpiozero import LED
from time import sleep
ultrasonic = DistanceSensor(echo=17, trigger=4, threshold_distance=0.5)
# subprocess.run(["python", "web.py"])

print("Ultrasonic sensor startedddd")
led = LED(22)  # Assuming the LED is connected to GPIO pin 22
onFlash = threading.Event()
# stop.set()

led.on()
def flash_led(onFlash):
    while onFlash.is_set():
        # print("LED flashing")
        # Toggle the LED on
        led.on()
        # Wait for 0.5 seconds
        sleep(0.4)
        # Toggle the LED off
        led.off()
        # Wait for 0.5 seconds
        sleep(0.4)
# stop = threading.Event()
def call_recognition():
    # call the recognition script
    print("Object detected within threshold distance!", ultrasonic.distance * 100, "cm")
    # stop.clear()
    onFlash.set()
    led_thread = threading.Thread(target=flash_led, args=(onFlash,))
    led_thread.start()
    print("LED flashing")
    subprocess.run(["python", "web.py"])
    print("After web.py")
    onFlash.set()
    led_thread.join()
    # Ensure the LED is off
    led.off()


    # print("Hello")
# Define a function to be called when the object detects an object within the threshold distance
# Assign the function to the 'when_in_range' event of the DistanceSensor object
# Keep the program running to listen for events
try:
    ultrasonic.when_in_range = call_recognition
    onFlash.clear()
    flash_led(onFlash)

    while True:
        # print(f"Distance: {ultrasonic.distance * 100:.2f} cm")
        # print(ultrasonic.distance, 'm')
        time.sleep(0.1)
except KeyboardInterrupt:
    print("Program terminated by user")
# ultrasonic = DistanceSensor(echo=17, trigger=4)
# while True:
#     print(ultrasonic.distance)

# cd ~/project && source env/bin/activate && cd facial-recognition2 && python ultrasonic.py