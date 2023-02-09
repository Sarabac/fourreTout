from library.module.mysql_creation import *
import unittest

class MysqlTest(unittest.TestCase):
    
    def test_dataclass(self):
        params = {
            "host": "h",
            "database": "d",
            "password": "p",
            "user": "u"
        }
        connectParam = ConnectParam(**params)
        param2 = ConnectParam(
            host= "h",
            database= "d",
            password="p",
            user= "u"
        )
        
        self.assertEqual(dict(connectParam), params)
        self.assertEqual(param2, params)
        