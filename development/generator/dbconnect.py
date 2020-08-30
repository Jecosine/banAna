'''
Date: 2020-07-25 13:23:41
LastEditors: Jecosine
LastEditTime: 2020-08-22 02:18:40
'''
from mysql.connector import connect


class DBConnection:
    def __init__(self):
        self.con = None
        self.cursor = None
        self.init_database()
    def init_database(self):
        self.con = connect(user="root", password="123456", database="bananadb")
        self.cursor = self.con.cursor()
    def save_database(self):
        self.con.commit()
    def close_save(self):
        self.con.commit()
        self.cursor.close()
