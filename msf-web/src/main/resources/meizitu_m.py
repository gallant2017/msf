from bs4 import BeautifulSoup
import urllib.request
import pymysql
import re
import os 

def reptile(url):
	
	response = urllib.request.urlopen(url).read().decode('gbk')
	soup = BeautifulSoup(response,'html.parser')#创建对象
	title=soup.find("title").text
	imgs= soup.find("div", attrs={"id": "picture"}).find_all("img")
	
	conn = pymysql.connect(host="127.0.0.1", user="root",password="root",database="msf",charset="utf8")
	cursor = conn.cursor()

	cursor.execute("insert into topic(title,memo1) values('{0}','{1}')".format(title,title))
	topic_id=cursor.lastrowid

	img_folder='img/{}'.format(topic_id)
	if not os.path.exists(img_folder):
		os.mkdir(img_folder)
	i=0;
	for img in imgs:
		link = img.get('src')
		name = img.get('alt')
		print("正在下载%s的图片"%name)
		i+=1
		try:
			imrUrl='{0}/{1}.jpg'.format(img_folder,i)
			urllib.request.urlretrieve(link,imrUrl)
			cursor.execute("insert into topic_img(topic_id,url,memo1) values({0},'{1}','{2}')".format(topic_id,imrUrl,name))
		except Exception as e:
			print(e)

	conn.commit()
	cursor.close()
	conn.close()

reptile("http://m.meizitu.com/a/5462.html")

