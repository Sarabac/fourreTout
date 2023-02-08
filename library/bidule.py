#!/usr/bin/python

from ansible.module_utils.basic import AnsibleModule  

def main():
    module=AnsibleModule(
        argument_spec=dict(
        name = dict(required=True, type='str' ),
        path = dict(required=True, type = 'str'),
        )
    )
    nom_newmodule=module.params.get('name')
    requete=nom_newmodule

    open( requete,'w')

    module.exit_json(changed=True, results="ok")

if __name__ == '__main__':
    main()

 
