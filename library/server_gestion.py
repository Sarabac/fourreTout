import os, time, subprocess
import threading, configparser

config = configparser.ConfigParser()
config.read('data.ini')

SERVER_PORT = []
path = []
host = config['server1']['host']

def check_server(hostname: str) -> bool:
    response = os.system("ping -c 1 " + hostname)
    return response == 0
    
def start_server(path: str) -> subprocess.Popen:
    return subprocess.Popen(["node", path])

def loop_check(path: str, hostname: str):
    i = 0
    while i < 120:
        if not check_server(hostname):
            start_server(path)

        time.sleep(1)
        i += 1

for i in range (4):
    SERVER_PORT.append(config[f"server{i+1}"]['SERVER_PORT'])
    path.append(config[f"server{i+1}"]['path'])
    threading.Thread(target=loop_check(path[i], f"{host}:{SERVER_PORT[i]}")).start()

#print(path)