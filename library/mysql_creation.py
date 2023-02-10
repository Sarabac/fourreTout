from typing import TypedDict
import mysql.connector

class ConnectParam(TypedDict):
    host: str
    user: str
    password: str
    database: str
    
def append_error(params: ConnectParam):
    """
    Ajoute une ligne d'erreur dans la base de donnee
    Args:
        params (ConnectParam): objet pour parametrer la connection.
    """
    with mysql.connector.connect(**params) as db:
        with db.cursor() as cur:
            with open("sql/insert.sql", "r") as sql_file:
                cur.execute(sql_file.read(), multi = True)
        db.commit()
    db.close()
    
def init_schema(params: ConnectParam):
    """
    Initialise la database si elle n'a pas la table error_db.
    Sinon ne fait rien.
    Args:
        params (ConnectParam): objet pour parametrer la connection.
    """    
    with mysql.connector.connect(**params) as db:
        with db.cursor() as cur:
            with open("sql/init.sql", "r") as sql_file:
                cur.execute(sql_file.read(), multi = True)
        db.commit()
    db.close()
     