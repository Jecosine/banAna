'''
Date: 2020-07-25 13:32:05
LastEditors: Jecosine
LastEditTime: 2020-09-01 08:53:34
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

class Item:
    def __init__(self, id, name, pics, price, sale, tmid, shoptmid, cateid):
        self.id = id
        self.name = name
        self.pics = pics
        self.price = price
        self.sale = sale
        self.tmid = tmid
        self.shoptmid = shoptmid
        self.cateid = cateid
    def __str__(self):
        return "{}<{}>".format(name, id)
    def to_data(self):
        pass



class Shop:
    def __init__(self, id, name, shopmid, location):
        self.id = id
        self.name = name
        self.gender = gender
    def __str__(self):
        return "{}<{}>".format(name, id)
    def to_data(self):
        pass