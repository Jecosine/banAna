'''
Date: 2020-09-01 08:25:56
LastEditors: Jecosine
LastEditTime: 2020-09-01 11:51:00
'''
import requests, json
from bs4 import BeautifulSoup as bs
from entities import *
import time, random
import os
header = {
    "authority": "s.taobao.com",
    "Connection": "close",
    "method": "GET",
    "path": "/search?q=%E7%BD%90%E5%A4%B4",
    "scheme": "https",
    "accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
    "accept-encoding": "gzip, deflate, br",
    "accept-language": "en-US,en;q=0.9",
    "cache-control": "max-age=0",
    "cookie": "miid=64701631356235077; tg=0; thw=cn; tracknick=ssterbn; enc=%2B2fo3lfZQYGYkeDbygR78aKw5g0ffv7Vj5Hj%2FE4PHNE0sAJ16KRIcwf9noQ%2BO8kx8GxjctBsMA16E%2BH9FSzP3w%3D%3D; hng=CN%7Czh-CN%7CCNY%7C156; cna=ZrK6F9DgnGsCAXjvrMyL6Zcc; t=6118bfc0cc83c3b506b31f8fec8e0e05; cookie2=1a607747accbf7c1e54499131cbe25f4; v=0; alitrackid=www.taobao.com; lastalitrackid=www.taobao.com; _samesite_flag_=true; sgcookie=EI%2B%2B7eEY0Rj7lbxreUjzg; uc3=vt3=F8dCufXBxARzp6EQjzs%3D&lg2=U%2BGCWk%2F75gdr5Q%3D%3D&id2=UNk%2FSAmLHA659Q%3D%3D&nk2=EE2hco6oSg%3D%3D; csg=fc1f9fd9; lgc=ssterbn; dnk=ssterbn; skt=2320177accecab6e; existShop=MTU5ODU3MjkxOQ%3D%3D; uc4=id4=0%40Ug41ScrCICCOKFQS03t%2Bo7PH%2FX0d&nk4=0%40EpRXjaKQBrXF4ZocVtJveCgF; _cc_=U%2BGCWk%2F7og%3D%3D; mt=ci=64_1; _utk=VocP@qJyn^AtWdm; _tb_token_=f84a38d4757fd; _m_h5_tk=f3624e43e2f63c802bd48e38a2f253ec_1598929987849; _m_h5_tk_enc=16651b58c6e730aff32c38ae01a09779; uc1=cookie16=WqG3DMC9UpAPBHGz5QBErFxlCA%3D%3D&pas=0&existShop=false&cookie21=URm48syIYRhCU6d3XQ%3D%3D&cookie14=UoTV5OMU5mZD1w%3D%3D; JSESSIONID=001D0BFC8F6C7E82E921EE19BE8904B4; tfstk=cfhdBeDI3hxH014tuvpgPGPeMc8cak-LXwZlwEF3ydsPi6fRNsx-ijdb0pa5v5LO.; l=eBL-q3mqv8ao72myBO5ahurza77OfIdb41PzaNbMiInca6ZdtKKgZNQ4Opu6Sdtj_tCKoetyVFjMrdLHR3AmiNAJz3h2q_rtexvO.; isg=BLW1YiBfBjkwIma0oS0pbUxpxDFvMmlEq_jFfDfbnyyyDtUA_4G1FiqMXNo4SYH8",
    "dnt": "1",
    "sec-fetch-dest": "document",
    "sec-fetch-mode": "navigate",
    "sec-fetch-site": "same-origin",
    "sec-fetch-user": "?1",
    "upgrade-insecure-requests": "1",
    "user-agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.135 Safari/537.36"
}


def get_url(item_name, page):
    url = "https://s.taobao.com/search?q={}&s={}"
    return url.format(item_name, page * 44 + (0 if page == 0 else 1))

def dfs(a, l):
    if not a.get("children"):
        l.append([a["id"], a["title"]])
        return
    for i in a["children"]:
        dfs(i, l)

def get_cate():
    with open("cateData.json", 'rb') as f:
        a = f.read().decode('utf-8')
    a = json.loads(a)
    # a = a["data"]
    l = []
    for i in a:
        dfs(i, l)
    return l

def get_content(curpath, url, s):
    # s = requests.Session()
    res = s.get(url, headers=header, timeout=(3.05, 24))
    html = res.content
    with open(curpath, 'wb') as f:
        r = f.write(html)
    print(str(r) + " written --- ", end="")
    if r == 0:
        print("  -- ERROR: Please Check file !! --")

def mainprocess():
    cnt = 0
    l = get_cate()
    requests.adapters.DEFAULT_RETRIES = 15
    print("starting ...")
    length = len(l)
    for i in range(604, length):
        id, name = l[i]
        # if cnt > 200:
            # break
        print("processing: %s - %s..." % (str(cnt), name))
        cnt += 1
        s = requests.Session()
        s.keep_alive = False
        for p in range(4):
            print("  page %s..." % str(p), end="")
            if not os.path.exists("data/%s" % id):
                os.mkdir("data/%s" % id)
            get_content("data/%s/%s.html"%(id, str(p)), get_url(name, p), s)
            print("done")
            time.sleep(random.random() * 2)
        s.close()

if __name__ == "__main__":
    mainprocess()