#!/usr/bin/python

from ansible.module_utils.basic import AnsibleModule  

def main():
  module = AnsibleModule(
	argument_spec=dict(
    path = dict(required=True, type='str')
    )
  )

  path_local = module.params.get('path')

  new_file = open(path_local, 'w')
  new_file.close()

  module.exit_json(changed=False, msg="OK")  
    
if __name__ == "__main__":
	main()