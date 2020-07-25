from mysql.connector import connect

class DBConnection:
  def __init__(self):
    self.con = None
    self.cursor = None
    self.init_database()
  
  def init_database(self):
    self.con = connect(user="root", password="123456", database="bananadb")
    self.cursor = con.cursor()

  def save_database(self):
    self.con.commit()

  def close_save(self):
    self.con.commit()
    self.cursor.close()