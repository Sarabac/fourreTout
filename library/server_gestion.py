import time, subprocess, socket
from mysql_creation import *
from datetime import datetime


# ==============================
# fonctions

def start_server(path: str) -> subprocess.Popen:
    return subprocess.Popen(["node", path])

def loop_check(path: str, host: str, SERVER_PORT: str):
    i = 0
    # init_schema(Params)
    while i < 120:
        sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        result = sock.connect_ex((host,SERVER_PORT))
        if result == 0:
            # print("Success port open :)")
            pass
        else:
            f = open("./library/sauv.txt", "a")
            f.writelines([f"Oups, port not opened ! Server restart... ({datetime.now()})", "\n"])
            # print("Oups, port not open ! Server restart")
            # append_error(Params)
            f.close()
            start_server(path)
        sock.close()

        time.sleep(1)
        i += 1

# ==============================
# main

SERVER_PORT = 3001
path = "./template/server1.js"
host = "localhost"
Params = ConnectParam(
    database="error_db",
    host="localhost",
    password="password",
    user="root"
)

loop_check(path, host, SERVER_PORT)
