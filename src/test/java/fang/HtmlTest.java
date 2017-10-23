package fang;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.WebWindow;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.Cookie;

import java.net.URL;
import java.util.Iterator;
import java.util.Set;

/**
 * Author: fangxueshun
 * Description:
 * Date: 2017/6/26
 * Time: 17:21
 */
public class HtmlTest {
    public static void main(String[] args) throws Exception{
        long var1 = System.currentTimeMillis();
        final WebClient wc=new WebClient(BrowserVersion.FIREFOX_52);
//        URL link=new URL("https://www.alarabiya.net/culture-and-art.html");
        URL link=new URL("http://www.alroeya.ae/123142/");
        WebRequest request=new WebRequest(link);
//        request.setAdditionalHeader("Referer", "http://radar2.net/Article-2.html");//设置请求报文头里的refer字段
        ////设置请求报文头里的User-Agent字段
        request.setAdditionalHeader("UserWithNoOverrideRemoveAll-Agent", "Mozilla/5.0 (Windows NT 5.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");
        //wc.addRequestHeader("UserWithNoOverrideRemoveAll-Agent", "Mozilla/5.0 (Windows NT 5.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");
        //wc.addRequestHeader和request.setAdditionalHeader功能应该是一样的。选择一个即可。
        //其他报文头字段可以根据需要添加
        // 1 启动JS
        wc.getOptions().setJavaScriptEnabled(true);
        // 2 禁用Css，可避免自动二次请求CSS进行渲染
        wc.getOptions().setCssEnabled(false);
        // 3 启动客户端重定向
        wc.getOptions().setRedirectEnabled(true);

        // 4 js运行错误时，是否抛出异常
        wc.getOptions().setThrowExceptionOnScriptError(false);
//        wc.getOptions().setAppletEnabled(false);
//        wc.getOptions().setActiveXNative(false);
//        wc.getOptions().setThrowExceptionOnFailingStatusCgitode(false);
//        wc.getOptions().setDoNotTrackEnabled(true);
//        wc.getOptions().setPopupBlockerEnabled(false);
//        wc.getOptions().setGeolocationEnabled(false);
        // 5 设置超时
        wc.getOptions().setTimeout(50000);

        HtmlPage htmlPage = wc.getPage(request);
        // 等待JS驱动dom完成获得还原后的网页
        wc.waitForBackgroundJavaScript(10000);
        wc.getOptions().setTimeout(10000);
        //设置cookie。如果你有cookie，可以在这里设置
//        Set<Cookie> cookies=null;
//        Iterator<Cookie> i = cookies.iterator();
//        while (i.hasNext())
//        {
//            wc.getCookieManager().addCookie(i.next());
//        }
//        webClient.addRequestHeader("UserWithNoOverrideRemoveAll-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36");
        // 等待JS驱动dom完成获得还原后的网页
        wc.waitForBackgroundJavaScript(1000);
        System.out.println(htmlPage.asXml());


        System.out.println("-----------"+(System.currentTimeMillis()-var1)/1000+"--------");
//        WebRequest request2=new WebRequest(link);
//        HtmlPage htmlPage2 = wc.getPage(request2);
//        System.out.println("-----------"+(System.currentTimeMillis()-var1)/1000+"--------");
    }
}
