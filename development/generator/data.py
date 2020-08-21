'''
Date: 2020-07-25 13:20:38
LastEditors: Jecosine
LastEditTime: 2020-08-22 02:19:27
'''
import faker
from generator.dbconnect import *
from generator.entities import *
import uuid
import random
# connect database

db = DBConnection()
fk = faker.Faker(locale='zh_CN')
# generate user data

gender = ['u', 'f', 'm']


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