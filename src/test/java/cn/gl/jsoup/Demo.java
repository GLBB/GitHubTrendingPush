package cn.gl.jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;

public class Demo {

    private String getFileContent(String path) throws IOException {
        try(
                InputStreamReader inputStreamReader = new InputStreamReader(
                        new FileInputStream(path), "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader)
        ) {
            StringBuilder stringBuilder = new StringBuilder();
            String temp = "";
            while ((temp = bufferedReader.readLine()) != null) {
                stringBuilder.append(temp);
            }
            return stringBuilder.toString();
        }
    }

    /**
     * 快速开始
     */
    @Test
    public void test1() throws IOException {
        String path = "src/test/resources/cn/gl/jsoup/Demo.html";
        String html = getFileContent(path);
        Document doc = Jsoup.parse(html);
        String title = doc.title();
        System.out.println(title);
    }

//    从一个URL加载一个Document
    @Test
    public void test2() throws IOException {
        Connection connect = Jsoup.connect("https://github.com/trending");
        Document document = connect.get();
        Charset charset = document.charset();
        System.out.println(charset);
    }

//    使用DOM方法来遍历一个文档
    @Test
    public void test3() throws IOException {
        Connection connection = Jsoup.connect("https://github.com/trending");
        Document document = connection.get();
        Elements elementsByClass = document.getElementsByClass("repo-list");
        Element element = elementsByClass.get(0);
        Elements linkes = element.getElementsByTag("a");
        for (Element link : linkes) {
            String href = link.attr("href");
            String text = link.text();
            System.out.println(href + "   |text: " + text);
        }
    }

//    从元素抽取属性，文本和HTML
    @Test
    public void test4(){
        String html = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
        Document doc = Jsoup.parse(html);
        Element link = doc.select("a").first();

        String text = doc.body().text();
        System.out.println(text);

        String href = link.attr("href");
        System.out.println(href);

        String text1 = link.text();
        System.out.println(text1);

        String s = link.outerHtml();
        System.out.println(s);

        String html1 = link.html();
        System.out.println(html1);
    }

//    处理URLs
    @Test
    public void test5() throws IOException {
        Document doc = Jsoup.connect("https://github.com/trending").get();
        Element element = doc.select(".repo-list").get(0);
        Element link = element.select("a").first();
        String relHref = link.attr("href");
        System.out.println(relHref);
        String absHref = link.attr("abs:href");
        System.out.println(absHref);
    }
}

