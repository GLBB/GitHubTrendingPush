#!/usr/bin/python
# -*- coding: utf-8 -*-

import pymysql
from qqbot import qqbotsched

class Repository(object):
    def __init__(self, id=None, name=None, URL=None, todayStar=None, intro=None,
                 lang=None, author=None, firstDate=None, send=None):
        self.id = id
        self.name = name
        self.URL = URL
        self.todayStar = todayStar
        self.intro = intro
        self.lang = lang
        self.author = author
        self.firstDate = firstDate
        self.send = send

    def __str__(self):
        return "Repository:{id:%s, name:%s, URL:%s, todayStar:%s, intro:%s, lang:%s, author:%s, firstDate:%s, send:%s}" \
               % (self.id, self.name, self.URL, self.todayStar, self.intro, self.lang, self.author, self.firstDate, self.send)



def getRepo():
    conn = pymysql.connect(host="******", port=***, user="***",
                           passwd="*****", db="******")
    cursor = conn.cursor()
    sql = "select * from Repository where send = 0"
    effict_rows = cursor.execute(sql)
    repoList = list()
    if effict_rows != 0:
        allRepo = cursor.fetchall()
        cursor.close()
        conn.close()
        for repo in allRepo:
            id, name, URL, todayStar, intro, lang, author, firstDate, send = repo
            repoList.append(Repository(id, name, URL, todayStar, intro, lang, author, firstDate, send))
    return repoList


def isChines(str):
    for ch in str:
        if "\u4e00" <= ch and ch <= "\u9fff":
            return True
    return False

def getChineseRepo(repolist):
    chineseRepo = list()
    for repo in repolist:
        if (isChines(repo.intro)):
            chineseRepo.append(repo)
    return chineseRepo

def setSend(repo):
    sql = "update Repository set send = %s where id = %s" % (1, repo.id)
    conn = pymysql.connect(host="111.230.246.155", port=3306, user="root",
                           passwd="CQUT_gl986144668", db="GitHubTrendingPush")
    cursor = conn.cursor()
    cursor.execute(sql)
    conn.commit()
    cursor.close()
    conn.close()

def pickOne():
    repoList = getRepo()
    chineseRepo = getChineseRepo(repoList)
    if chineseRepo == None or len(chineseRepo) == 0:
        setSend(repoList[0])
        return repoList[0]
    else:
        setSend(chineseRepo[0])
        return chineseRepo[0]

@qqbotsched(hour='11,18', minute='02')
def pushRepo(bot):
    with open("qqbot-log.txt","a") as f:
        f.write("定时任务开始运行")
    group = bot.List('group', 'test')[0]   # NiX-Team  就差一个程序员了
    repo = pickOne()
    message = "/可爱推荐:\n" \
              "仓库名称: %s\n" \
              "今天收到星星: %s    lang: %s\n" \
              "URL: %s\n" \
              "简介: %s\n" % (repo.name, repo.todayStar, repo.lang, repo.URL, repo.intro)
    bot.SendTo(group, message)

if __name__ == "__main__":
    repo = pickOne()
    print(repo)
