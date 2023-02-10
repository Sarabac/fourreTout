#!/usr/bin/python
import threading
from library.server_gestion import *
from ansible.module_utils.basic import AnsibleModule  

def main():
    module = AnsibleModule(
        argument_spec=dict(
            path = dict(required=True, type='str'),
            hostname = dict(required=True, type='str')
        )
    )

    path_local = module.params.get('path')
    hostname_local = module.params.get('hostname')

    threading.Thread(target=loop_check(path_local, hostname_local)).start()

    module.exit_json(changed=False, msg="OK")  
    
if __name__ == "__main__":
	main()