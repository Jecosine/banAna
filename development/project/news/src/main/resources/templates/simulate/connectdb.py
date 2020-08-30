from mysql import connector
from faker import Faker
import time, random
con = connector.connect(user="root",password="123456", database="news", buffered = True) 
cursor = con.cursor()
mf = Faker(locale="zh_CN")

userlist = [mf.name() for i in range(61)]
part_dict = {"体育":1, "财经": 2, "科技": 3, "娱乐": 4}
# user_dict = {i:{"email":}}
cursor.execute("select uid from user")
dataset = cursor.fetchall()
sql = "update user set realname=%s where uid=%s"
sql1 = "update user set password=%s"
for i in range(len(userlist)):
  # cursor.execute(sql, [userlist[i], dataset[i][0]])
  cursor.execute(sql1, ["123456"])

con.commit()


sql3 = "select pid, category from passage"
cursor.execute(sql3)
fetup = cursor.fetchall()
for i in range(len(fetup)):
  fetup[i] = list(fetup[i])
  fetup[i][1] = str(fetup[i][1])

for i in range(len(fetup)):
  cursor.execute("update passage set part_id=%s where pid=%s", [fetup[i][1], fetup[i][0]])

con.commit()


user_part = set()
cursor.execute("select uid, part_id from passage")
fetup = cursor.fetchall()
for i in fetup:
  user_part.add(i)
user_part = list(user_part)
for i in user_part:
  cursor.execute("insert into user_part values (%s, %s)", i)

con.commit()



start_date = 22
end_date = 26
updata = []
# startdate = time.strftime("%Y-%m-%d", time.localtime())
for i in user_part:
  for j in range(start_date, end_date+1):
    updata.append([i[0], i[1], '2020-06-%s'%str(j), random.randint(0, 12)])

for i in updata:
  cursor.execute("insert into edit_passage_log (uid, part_id, datetime, count) values (%s, %s, %s, %s)", i)

con.commit()


start_date = 1
end_date = 26
cursor.execute("select pid, part_id from passage")

allpassage = cursor.fetchall()

updata1 = []

for i in range(len(allpassage)):
  for j in range(start_date, end_date+1):
    updata1.append([allpassage[i][0], '2020-06-%s' % str(j).zfill(2), random.randint(500, 5000), allpassage[i][1]])

for i in updata1:
  cursor.execute("insert into passage_log values (%s, %s, %s, %s)", i)
