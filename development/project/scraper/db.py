import mysql.connector as connector
import uuid
from faker import Faker
import os
from bs4 import BeautifulSoup as bs

fk = Faker(locale="zh_CN")
cate_list = ["体育","财经","娱乐","科技","教育"]
def get_pid():
  uid = "".join(str(uuid.uuid4()).split("-"))[:10]
  return uid

conn = connector.connect(user="root", password="200120817", database="news", host="10.129.47.28")
cursor = conn.cursor()
# class Passage:
  # def __init__(self, id, uid, view):
user_dict = {}

def get_data(cate, fname):
  global user_dict, fk, cate_list
  # global conn, cursor
  pid = fname.split("shtml")[0][:-1]
  with open("{}/{}".format(cate, fname), 'rb') as f:
    content = f.read().decode("utf-8", "ignore")
  content = bs(content, "html.parser")
  name = content.find("meta", {"name":"mediaid"})
  if name == None:
    return False
  name = name.attrs.get("content")
  if(user_dict.get(name) != None):
    uid = user_dict[name]["uid"]
    email = user_dict[name]["email"]
    user_dict[name]["product_count"] += 1
  else:
    user_dict[name] = {}
    uid = get_pid()
    email = fk.email()
    user_dict[name]["uid"] = uid
    user_dict[name]["email"] = email
    user_dict[name]["product_count"] = 1
  category = cate_list[cate]
  thumb = content.find("meta", {"property":"og:image"})
  title = content.find("h1").get_text().strip()
  if thumb != None:
    thumb = thumb.attrs.get("content")
    if thumb == None:
      thumb = ""
    else:
      thumb = thumb.strip()
  # insert into passage
  row = [pid, uid, title, category, thumb]
  cursor.execute("insert into passage (pid, uid, title, category, thumb) values (%s, %s, %s, %s, %s)", row)
  # print(row)
  return True

def get_file_list(cate):
  fl = os.listdir(str(cate))
  return fl

def fetch():
  global conn, cursor, fk
  for i in range(0, 5):
    print("fetching pic in cate %s"% str(i) + "...0000", end="")
    fl = get_file_list(i)
    fl = [i for i in fl if i.endswith("shtml")]
    l = len(fl)
    for j in range(l):
      if j > 300:
        break
      print("\b\b\b\b%s" % str(j).zfill(4), end="")
      if not get_data(i, fl[j]):
        continue
    conn.commit()
  cursor.close()
  with open("ud.txt","wb") as f:
    f.write(str(user_dict).encode("utf-8", "ignore"))

def insertUser():
  with open("ud.txt", "rb") as f:
    content = f.read().decode("utf-8")
  ud = eval(content)
  for i, j in ud.items():
    dt = [j["uid"], i, j["email"], fk.phone_number(), j["product_count"], '1']
    cursor.execute("insert into user (uid, username, email, phone, product_count, type) values (%s, %s, %s, %s, %s, %s)", dt)
  conn.commit()
  cursor.close()
  conn.close()
    

if __name__ == "__main__":
  # fetch()
  insertUser()
 



  
