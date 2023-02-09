import os
import time
import subprocess

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
