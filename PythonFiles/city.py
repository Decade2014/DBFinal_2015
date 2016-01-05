#-*- coding:utf8 -*-
import sys
import codecs
reload(sys)
f=open('weatherdata.txt','r')
#f = codecs.open('weatherdata.txt','r','utf-8')
content=f.readlines()
citypair={}
sys.setdefaultencoding('utf-8')
for it in content:
    a=it.split()[0]
    b=it.split()[1]
    citypair[a]=b
#print(len(citypair['北京']))
city={v:k for  k,v in citypair.items()}

'''for i in city.keys():
    print i,city[i]'''

