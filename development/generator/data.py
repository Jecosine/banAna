import faker
from generator.dbconnect import *
from generator.entities import *
import uuid
# connect database

db = DBConnection()
fk = faker.Faker(locale='zh_CN')
# generate user data
def get_users(n):
  return [get_user() for i in range(n)]
  pass
def get_user():
  return User()
# user = User()
# generate business data
# generate item data