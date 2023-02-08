def add_suffix(word):
    # ajoute l'extension .suffix au string en entrée
    word = str(word)
    return word + ".suffix"

class FilterModule(object):
    ''' Ansible core jinja2 filters '''

    def filters(self):
        return {
            'add_suffix': add_suffix
        }

# test = "test"
# print(f"Le mot '{test}' a été modifié en '{add_suffix(test)}'")