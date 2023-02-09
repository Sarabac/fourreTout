def add_suffix(word):
    # ajoute un suffix au string en entrée
    word = str(word)
    return word + ".Stupefix"

def add_prefix(word):
    # ajoute un prefix au string en entrée
    word = str(word)
    return "Prefafix-" + word

def no_space(word):
    if " " in word:
        new_word = word.replace(" ", "-")
        return new_word
    else:
        return word


class FilterModule(object):
    ''' Ansible core jinja2 filters '''

    def filters(self):
        return {
            'add_suffix': add_suffix,
            'add_prefix': add_prefix,
            'no_space': no_space
        }

# test = "test"
# print(f"Le mot '{test}' a été modifié en '{add_suffix(test)}'")