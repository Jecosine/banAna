'''
Date: 2020-07-25 13:32:05
LastEditors: Jecosine
LastEditTime: 2020-08-22 02:10:41
'''


class User:
    def __init__(self, id, name, gender):
        self.id = id
        self.name = name
        self.gender = gender
    def __str__(self):
        return "{}<{}>".format(name, id)
    def to_data(self):
        pass
