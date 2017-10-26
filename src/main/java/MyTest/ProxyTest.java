package MyTest;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;

/**
 * description
 *
 * @author fangxueshun
 * @date 2017/9/5
 */
public class ProxyTest {
    public static void main(String[] args) throws Exception{

        long var1 = System.currentTimeMillis();
//        String url = "http://pv.sohu.com/cityjson?ie=utf-8";
        String url = "http://www.bbc.com/arabic";
//        String url = "https://www.google.de/";
//        String url = "http://jingyan.baidu.com";
        String addr = "62.138.16.87";
        String agent = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2914.3 Safari/537.36";
        int port = 	3128;
        InetSocketAddress socketAddress = new InetSocketAddress(addr,port);
        Proxy.Type type = Proxy.Type.HTTP;
        Proxy proxy = new Proxy(type,socketAddress);
        System.out.println(url);
        Connection.Response response1 = Jsoup.connect(url).ignoreHttpErrors(true)
                .userAgent(agent)
                .method(Connection.Method.GET).timeout(90000).execute();
        long var2 = System.currentTimeMillis();
        System.out.println("不使用代理请求时间"+(var2-var1)+"毫秒");
        System.out.println("返回状态码"+response1.statusCode());
        //        System.out.println(response1.body());
        Connection.Response response2 = Jsoup.connect(url).ignoreHttpErrors(true)
                .userAgent(agent)
                .method(Connection.Method.GET).proxy(proxy).timeout(90000).execute();

        long var3 = System.currentTimeMillis();
//        System.out.println(response2.body());
        System.out.println("使用代理请求时间"+(var3-var2)+"毫秒");
        System.out.println("返回状态码"+response2.statusCode());
    }
}
