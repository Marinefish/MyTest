package current;

import java.util.Random;

/**
 * Author: fangxueshun
 * Description:线程等待和通知测试
 * Date: 2017/10/17
 * Time: 22:11
 */
public class ThreadWaitAndNotify {

    /**
     * wait 和notify时为了解决线程间的通讯问题而实现的方法。调用wait方法后会马上释放锁，而notify方法不会释放锁
     * */
    //打印方法
    private void print(String content) {
        new Thread(()->{
            Random random = new Random();
            int costTime = random.nextInt(5000);
            System.out.printf("正在打印:%s", content);

            System.out.println("");
            try {
                Thread.sleep(costTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf(content+":打印花费时间%s", costTime);
            System.out.println("");
            System.out.printf("%s:打印完毕!", content);
            System.out.println(content + ":开始调用通知方法");
            synchronized (content) {
                content.notify();
            }
            System.out.println(content + ":通知完毕");
        }).start();

    }

    //内容接受方法，可以同时接受多个对象，但是调用打印方法时，打印时间不确定,异步方法
    public void accept(String content) {
        //异步方法，开启新的线程调用打印方法
        new Thread(() -> {
            System.out.println(content + ":开始等待打印");
            print(content);
            synchronized (content) {
                try {
                    content.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(content + ":等待打印结束");
        }).start();

    }

}
