#coding: utf-8
import urllib
from urllib import urlopen
import json
import mysql.connector
from city import citypair
import gzip
import StringIO
import sys
reload(sys)
sys.setdefaultencoding('utf-8');
con=mysql.connector.connect(user='root',password='',charset='utf8')
cursor=con.cursor()

#cursor.execute('drop database if exists weather')
#cursor.execute('create database weather character set utf8')
cursor.execute('use finalproj')
#cursor.execute('drop table if exists ww')
#cursor.execute('CREATE TABLE ww (city VARCHAR(20) PRIMARY KEY,weather VARCHAR(20),fir VARCHAR(10),conn VARCHAR(5),sec VARCHAR(10))  ENGINE=INNODB DEFAULT CHARSET=UTF8')

#cityname =input('你想查哪个城市的天气？\n')
#cityname='北京'
#citycode = citypair.get
mycity={v:k for  k,v in citypair.items()}
    #cityname =input('你想查哪个城市的天气？\n')
    #citycode = citypair.get(cityname)
j=0
for i in mycity.keys():
    if j==10:
        break
    citycode=i
    print citycode
    url = ('http://wthrcdn.etouch.cn/weather_mini?citykey=%s'%citycode)
    data = urllib.urlopen(url).read() #type str
    data = StringIO.StringIO(data)
    gzipper = gzip.GzipFile(fileobj=data)
    content=gzipper.read()
    #print content
    #print (json.loads(content))
    data = json.loads(content)
    if(data['desc'] == "OK"):
        result = data['data']
        #str_temp = ('%s %s ') % (result['wendu'],result['ganmao'])
        todayHighTemperature=result['forecast'][0]['high']
        todayLowTemperature=result['forecast'][0]['low']
        todayWeather=result['forecast'][0]['type']
        todayFengxiang=result['forecast'][0]['fengxiang']
        todayDate=result['forecast'][0]['date']
        theCity=result['city']

        tomorrowHighTemperature=result['forecast'][1]['high']
        tomorrowLowTemperature=result['forecast'][1]['low']
        tomorrowWeather=result['forecast'][1]['type']
        tomorrowFengxiang=result['forecast'][1]['fengxiang']
        tomorrowDate=result['forecast'][1]['date']

        yesterdayHighTemperature=result['yesterday']['high']
        yesterdayLowTemperature=result['yesterday']['low']
        yesterdayWeather=result['yesterday']['type']
        yesterdayFengxiang=result['yesterday']['fx']
        yesterdayDate=result['yesterday']['date']
        #print(str_temp)
        #print todayHighTemperature+todayLowTemperature+todayWeather+todayFengxiang+" "+theCity

# for TODAY
    cursor.execute('select * from today where city="%s"' % theCity)
    values=cursor.fetchone()
    if values==None:
        values='helloworld!'
    else:
        values=values[0]
        print "the city is "+values

    if values==theCity:
        print 'equal'
        cursor.execute('update today set weather="%s" where city="%s"' % (todayWeather,theCity))
        cursor.execute('update today set low="%s" where city="%s"' % (todayLowTemperature,theCity))
        cursor.execute('update today set high="%s" where city="%s"' % (todayHighTemperature,theCity))
        cursor.execute('update today set fx="%s" where city="%s"' % (todayFengxiang,theCity))
        cursor.execute('update today set info="%s" where city="%s"' % (todayDate,theCity))
    else:
        cursor.execute('insert into today values("%s","%s","%s","%s","%s","%s")'%(theCity,todayWeather,todayHighTemperature,todayLowTemperature,todayFengxiang,todayDate))

    con.commit()
#for Yesterday
    cursor.execute('select * from yesterday where city="%s"' % theCity)
    values=cursor.fetchone()
    if values==None:
        values='helloworld!'
    else:
        values=values[0]
        print "the city is "+values

    if values==theCity:
        cursor.execute('update yesterday set weather="%s" where city="%s"' % (yesterdayWeather,theCity))
        cursor.execute('update yesterday set low="%s" where city="%s"' % (yesterdayLowTemperature,theCity))
        cursor.execute('update yesterday set high="%s" where city="%s"' % (yesterdayHighTemperature,theCity))
        cursor.execute('update yesterday set fx="%s" where city="%s"' % (yesterdayFengxiang,theCity))
        cursor.execute('update yesterday set info="%s" where city="%s"' % (yesterdayDate,theCity))
    else:
        cursor.execute('insert into yesterday values("%s","%s","%s","%s","%s","%s")'%(theCity,yesterdayWeather,yesterdayHighTemperature,yesterdayLowTemperature,yesterdayFengxiang,yesterdayDate))

    con.commit()

# for tomorrow
    cursor.execute('select * from tomorrow where city="%s"' % theCity)
    values=cursor.fetchone()
    if values==None:
        values='helloworld!'
    else:
        values=values[0]
        print "the city is "+values

    if values==theCity:
        cursor.execute('update tomorrow set weather="%s" where city="%s"' % (tomorrowWeather,theCity))
        cursor.execute('update tomorrow set low="%s" where city="%s"' % (tomorrowLowTemperature,theCity))
        cursor.execute('update tomorrow set high="%s" where city="%s"' % (tomorrowHighTemperature,theCity))
        cursor.execute('update tomorrow set fx="%s" where city="%s"' % (tomorrowFengxiang,theCity))
        cursor.execute('update tomorrow set info="%s" where city="%s"' % (tomorrowDate,theCity))
    else:
        cursor.execute('insert into tomorrow values("%s","%s","%s","%s","%s","%s")'%(theCity,tomorrowWeather,tomorrowHighTemperature,tomorrowLowTemperature,tomorrowFengxiang,tomorrowDate))

    con.commit()

    j=j+1