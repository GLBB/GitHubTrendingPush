package cn.gl.download;

import org.junit.Test;

public class DownloadPageTest {

    /**
     * 下载页面测试
     */
    @Test
    public void test1(){
        DownloadPage downloadPage = new DownloadPage();
        String url = "https://github.com/trending";
        String page = downloadPage.getPage(url);
        System.out.println(page);
    }
}
