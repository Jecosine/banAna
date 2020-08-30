import requests
from bs4 import BeautifulSoup as bs
from fake_useragent import UserAgent
import time, random, os
import uuid

s = requests.session()
requests.adapters.DEFAULT_RETRIES = 5
s.keep_alive = False
ua = UserAgent()
header = {
  "user-agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.61 Safari/537.36",
  "referer": "http://sports.sina.com.cn/"
}
sina_link = ["http://sports.sina.com.cn/","http://finance.sina.com.cn/","http://ent.sina.com.cn/", "http://tech.sina.com.cn/", "http://edu.sina.com.cn/"]
cate_list = ["体育","财经","娱乐","科技","教育"]

def get_pid():
  uid = "".join(str(uuid.uuid4()).split("-"))[:10]
  return uid

def get_passage(cate, link):
  global s
  header["referer"] = sina_link[cate]
  res = s.get(link, headers = header)
  content = res.content
  res.close()
  # text = res.text
  with open(str(cate)+ "/" + get_pid() + ".shtml", "wb") as f:
    f.write(content)
  # return content, text

def get_passages(cate):
  a = []
  with open(cate_list[cate]+".txt", "r") as f:
    a = f.read().split("\n")[:-1]
  # get_passage(cate, a[0])
  c = 0
  l = len(a)
  x = 0
  if cate == 0:
    x = 495
  for i in range(x, l):
    c += 1
    print("\b\b\b\b%s"%str(i).zfill(4), end="")
    get_passage(cate, a[i])
    time.sleep(random.random())

def mainprocess():
  for i in range(1, 5):
    print("fetching passages in " + cate_list[i] + " ... ", end="")
    get_passages(i)
    print("")

if __name__ == "__main__":
  mainprocess()