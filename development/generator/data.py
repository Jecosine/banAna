'''
Date: 2020-07-25 13:20:38
LastEditors: Jecosine
LastEditTime: 2020-08-31 01:46:31
'''
import faker
from generator.dbconnect import *
from generator.entities import *
import uuid
import random
import hashlib
import json
# connect database

db = DBConnection()
fk = faker.Faker(locale='zh_CN')
# generate user data

gender = ['u', 'f', 'm']
user_columns = ['userId', 'userName', 'gender', 'password']

def get_users(n):
    a = [get_user() for i in range(n)]
    return [(i.id, i.name, i.gender) for i in a]



def get_user():
    username = fk.user_name()+''.join(fk.random_letters(5))
    username = username[:20] if (len(username) > 20) else username
    return User(uuid.uuid4().hex[:10], username, random.choice(gender))
# user = User()
# generate business data
# generate item data

def insert_users(n):
    users = get_users(n)
    sql = "insert into user values (%s, %s, %s)"
    db.cursor.executemany(sql, users)
    db.save_database()


def get_all_users():
    sql = "select * from user"
    db.cursor.execute(sql)
    res = db.cursor.fetchall()
    return res

def shift_list(i):
    i = list(i)
    return i + [i.pop(0)]

def update_all_user(res):
    sql = "update user set " + ', '.join(["{}=%s".format(i) for i in user_columns[1:]]) + " where {}=%s".format(user_columns[0])
    res = [shift_list(i) for i in res]
    db.cursor.executemany(sql, res)
    db.save_database()

def refresh_password(res):
    for i in range(len(res)):
        res[i] = list(res[i])
        res[i][3] = hashlib.md5(fk.password().encode(encoding='UTF-8')).hexdigest()
    return res


# cate
def get_cate():
    with open("cateData.json", 'rb') as f:
        a = f.read().decode('utf-8')
    a = json.loads(a)
    return a

l = []
def get_types(a, l):
    for i in a:
        # l.append({'id':i["id"], 'title':i["title"], 'parent':i['parent']})
        l.append((i["id"], i["title"],0 if i['parent']=="" else i["parent"], 0))
        if i.get("children"):
            get_types(i["children"], l)


