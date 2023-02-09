import os
import subprocess

def check_server(hostname: str) -> bool:
    response = os.system("ping -c 1 " + hostname)
    return response == 0
    
def start_server(path: str) -> subprocess.Popen:
    return subprocess.Popen(["node", path])