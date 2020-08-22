import requests
from bs4 import BeautifulSoup as bs
from fake_useragent import UserAgent
import time

ua = UserAgent()
header = {
  "user-agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.61 Safari/537.36",
  "referer": "http://sports.sina.com.cn/"
}
sina_link = ["http://sports.sina.com.cn/","http://finance.sina.com.cn/","http://ent.sina.com.cn/", "http://tech.sina.com.cn/", "http://edu.sina.com.cn/"]
cate_list = ["体育","财经","娱乐","科技","教育"]

def alist2links(l):
  links = []
  for i in l:
    if not i.attrs.get("href"):
      continue
    link = i.attrs["href"].split("shtml")[0]
    if(len(link.split("/")[-1]) == 20):
      links.append(link + "shtml")
  return links

def get_link(cate):
  header["referer"] = sina_link[cate]
  res = requests.get(sina_link[cate], headers = header)
  bsobj = bs(res.text,"html.parser")
  a = bsobj.findAll("a")
  a = alist2links(a)
  return a
def get_time():
  return time.strftime("%Y-%m-%d", time.localtime())

def mainprocess():
  for i in range(5):
    print("fetching %s ... " % cate_list[i], end="")
    l = get_link(i)
    print(len(l))
    with open(cate_list[i]+".txt", "a+") as f:
      for j in l:
        f.write(j+"\n")
    print("√")
    time.sleep(1)


if __name__ == "__main__":
  mainprocess()