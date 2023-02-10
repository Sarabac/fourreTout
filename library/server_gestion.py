import os, time, subprocess, socket

# ==============================
# fonctions

def check_server(hostname: str) -> bool:
    response = os.system("ping -c 1 " + hostname)
    return response == 0
    
def start_server(path: str) -> subprocess.Popen:
    return subprocess.Popen(["node", path])

def loop_check(path: str, host: str, SERVER_PORT: str):
    i = 0
    while i < 120:
        sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        result = sock.connect_ex((host,SERVER_PORT))
        if result == 0:
            print("Success port open :)")
        else:
            print("Oups, port not open !")
            start_server(path)
        sock.close()

        time.sleep(1)
        i += 1

# ==============================



# ==============================
# main

SERVER_PORT = 3001
path = "./template/server1.js"
host = "localhost"

loop_check(path, host, SERVER_PORT)