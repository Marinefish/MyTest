package fang;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.Cookie;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.net.URL;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

/**
 * Author: fangxueshun
 * Description:
 * Date: 2017/6/26
 * Time: 17:21
 */
public class HtmlTest {
    public static void main(String[] args) throws Exception{
//        LogManager.getLogManager().reset();
        long var1 = System.currentTimeMillis();
        String url = "http://www.alayam.com/plugin/getNewsListByCategory?IssueID=0&CategoryName=alayam&SubCategoryName=sports&PageNumber=1&RowsPerPage=30";
        WebClient webClient=new WebClient(BrowserVersion.INTERNET_EXPLORER);//设置浏览器的User-Agent
//        WebRequest webRequest = new WebRequest(new URL(url));
//        webRequest.setCharset("utf-8");
        webClient.setJavaScriptTimeout(8000);//设置JS执行的超时时间
        webClient.getOptions().setThrowExceptionOnScriptError(false);//当JS执行出错的时候是否抛出异常
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);//当HTTP的状态非200时是否抛出异常
        webClient.getOptions().setTimeout(90000);//设置“浏览器”的请求超时时间
        webClient.getOptions().setCssEnabled(false);//是否启用CSS
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());//很重要，设置支持AJAX

        HtmlPage htmlPage = webClient.getPage(url);
        webClient.waitForBackgroundJavaScript(10000);//设置JS后台等待执行时间
        webClient.waitForBackgroundJavaScriptStartingBefore(10000);

        System.out.println(htmlPage.asXml());
        System.out.println("消耗时间"+(System.currentTimeMillis()-var1)+"毫秒");


    }
}
