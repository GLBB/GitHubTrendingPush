package cn.gl.url;

import cn.gl.pojo.Repository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetRepo {
    /**
     * 得到页面的仓库列表中的URI
     * 仓库链接都在标签 <h3></h3> 中
     * @param URL 连接页面
     */
    static final Logger logger = LoggerFactory.getLogger(GetRepo.class);

    private static String downloadPage(String URL){
        

        return null;
    }

    public static List<Repository> getRepos(String URL){
        logger.info("仓库抓取过程中");

        ArrayList<Repository> repoList = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(URL).get();
            Elements lis = doc.select("li.col-12"); // 多个 li 标签
            for (Element li : lis) {
                Element h3 = li.select("h3").first();
                Element repoLink = h3.select("a").first();
                String[] repoAndAuthor = repoLink.text().split("/");
                String author = repoAndAuthor[0].trim();
                String repoName = repoAndAuthor[1].trim();
                String repoURL = repoLink.attr("abs:href");

                String intro = li.select("div.py-1").text();

                String lang = li.select("[itemprop=programmingLanguage]").text();

                String todayStar = li.select("span").last().text();

                Repository repo = new Repository();
                repo.setAuthor(author);
                repo.setName(repoName);
                repo.setURL(repoURL);
                repo.setIntro(intro);
                repo.setLang(lang);
                repo.setTodayStar(todayStar);

                repoList.add(repo);
            }

            logger.info("抓取仓库马上结束, 抓取的仓库有 {} 个", repoList.size());
            return repoList;
        } catch (IOException e) {
            logger.error("出现错误：{}", e);
            e.printStackTrace();
        }
        logger.error("仓库返回 null");
        return null;
    }
}
