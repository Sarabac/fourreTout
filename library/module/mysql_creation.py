from typing import TypedDict
import mysql.connector

class ConnectParam(TypedDict):
    host: str
    user: str
    password: str
    database: str
    
def append_error(params: ConnectParam):
    with mysql.connector.connect(**params) as db:
        with db.cursor() as cur:
            with open("sql/insert.sql", "r") as sql_file:
                cur.execute(sql_file.read(), multi = True)
        db.commit()
    db.close()
    