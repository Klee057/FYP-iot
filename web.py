import json
import signal
from threading import Thread
import threading
import time
from http import server
import facepart
import logging
import socketserver
import io
import subprocess
import picamera
from threading import Condition, Timer

with open("index.html", "r", encoding="utf-8") as file:
    PAGE = file.read()
    # endThread = True
class StreamingHandler(server.BaseHTTPRequestHandler):
 def do_GET(self):
    global recognised
    endThread = True
    recognised = "Unknown"
    if self.path == '/':
        self.send_response(301)
        self.send_header('Location', '/index.html')
        self.end_headers()
    elif self.path == '/index.html':
        content = PAGE.encode('utf-8')
        self.send_response(200)
        self.send_header('Content-Type', 'text/html')
        self.send_header('Content-Length', len(content))
        self.end_headers()
        self.wfile.write(content)
    if self.path == '/get-recognized-face':
        self.send_response(200)
        self.send_header('Content-type', 'application/json')
        self.end_headers()
        self.wfile.write(json.dumps({"name": output.face_name}).encode())
    elif self.path == '/stream.mjpg':
        self.send_response(200)
        self.send_header('Content-Type', 'multipart/x-mixed-replace; boundary=FRAME')
        self.end_headers()
        try:
            while True:
                with output.condition:
                    output.condition.wait()
                    frame = output.frame
                self.wfile.write(b'--FRAME\r\n')
                self.send_header('Content-Type', 'image/jpeg')
                self.send_header('Content-Length', len(frame))
                self.end_headers()
                self.wfile.write(frame)
                self.wfile.write(b'\r\n')
                if output.face_detected and endThread:
                    Timer(1, shutdown_server).start()
                    endThread = False
        except Exception as e:
            print(f"Stream stopped: {e}")
    else:
        self.send_error(404)
        self.end_headers()

class StreamingServer(socketserver.ThreadingMixIn, server.HTTPServer):
    allow_reuse_address = True
    daemon_threads = True

def shutdown_server():
    print("Shutting down server...")
    # time.sleep(1)
    server.shutdown()
    server.server_close()

def shutdown_server_enable_ultrasonic():
    print("ultrasonic sensor...")
    # time.sleep(1)
    server.shutdown()
    server.server_close()
    # subprocess.run(["python", "ultrasonic.py"]) ####
    # time.sleep(1)
with picamera.PiCamera(resolution='640x480', framerate=24) as camera:
    output = facepart.StreamingOutput()
    camera.start_recording(output, format='mjpeg')
    time.sleep(1)
    try:
        address = ('', 8000)
        server = StreamingServer(address, StreamingHandler)
        Timer(12, shutdown_server_enable_ultrasonic).start()
        server.serve_forever()

        print("TIMER SHUT DOWN")
        # server_thread = threading.Thread(target=server.serve_forever)
        # server_thread.start()
        # threading.Timer(20, shutdown_server).start()

        # print("server started@ http://172.20.93.16:8000/  output->", output.face_recognized)
        # http://192.168.6.242:8000/index.html  hotspot
    finally:
        # server.shutdown()
        print("finallyyy")

        # camera.stop_recording()
        # camera.close()



# output = facepart.StreamingOutput()
# run_server()