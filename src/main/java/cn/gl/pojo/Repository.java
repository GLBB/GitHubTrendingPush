package cn.gl.pojo;

import java.util.Date;

public class Repository {
    private Integer id;
    private String name;
    private String URL;
    private String todayStar;
    private String intro;
    private String lang;  // 用什么语言写的
    private String author;
    private Date firstDate;  // 第一次发现仓库的时间
    private Boolean send; // 该 repo 是否推送过

    public Boolean getSend() {
        return send;
    }

    public void setSend(Boolean send) {
        this.send = send;
    }

    public Date getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(Date firstDate) {
        this.firstDate = firstDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getTodayStar() {
        return todayStar;
    }

    public void setTodayStar(String todayStar) {
        this.todayStar = todayStar;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", URL='" + URL + '\'' +
                ", todayStar='" + todayStar + '\'' +
                ", intro='" + intro + '\'' +
                ", lang='" + lang + '\'' +
                ", author='" + author + '\'' +
                ", firstDate=" + firstDate +
                ", send=" + send +
                '}';
    }
}
