import os
from bs4 import BeautifulSoup as bs
def get_file_list(cate):
  fl = os.listdir(str(cate))
  return fl
c=0
pics = []
def get_content(cate, fname):
  global pics, c
  id = fname.split("shtml")[0][:-1]
  with open("{}/{}".format(cate, fname), 'rb') as f:
    content = f.read().decode("utf-8", "ignore")
  content = bs(content, "html.parser")
  
  art = content.find("div", {"class": "article"})
  if art == None:
    return False
  title = content.find("h1").get_text().strip()
  ps = art.children
  ps = [i for i in ps if i != "\n"]
  final = []
  # add pic
  for i in ps:
    if str(type(i)) == "<class 'bs4.element.Comment'>":
      continue
    if str(type(i)) != "<class 'bs4.element.Tag'>":
      break
    if i.name == "p":
      final.append(i)
      continue
    cls = i.attrs.get("class")
    cls = [] if cls == None else cls 
    if "img_wrapper" in cls:
      if i.find("img") != None:
        url = i.find("img").attrs.get("src")
        # print(url)
        if url != None:
          i.find("img").attrs["src"] = "http:" + url
          pics.append("http:"+url)
          final.append(i)
          c+=1
  final = [str(i) for i in final]
  # write to file
  with open("{}/dat/{}.dat".format(cate, id), 'wb') as f:
    f.write((''.join(final)).encode("utf-8"))
  return True
def fetch():
  global c, pics
  for i in range(0, 5):
    c=0
    pics = []
    print("fetching pic in cate %s"% str(i) + "...0000", end="")
    fl = get_file_list(i)
    fl = [i for i in fl if i.endswith("shtml")]
    l = len(fl)
    for j in range(l):
      if j > 300:
        break
      print("\b\b\b\b%s" % str(j).zfill(4), end="")
      if not get_content(i, fl[j]):
        os.remove("{}/{}".format(i,fl[j]))
    print("total pic: %s"%str(c))
    with open("{}/pics.txt".format(i), 'w') as f:
      f.write("\n".join(pics))
  
if __name__ == "__main__":
  fetch()
