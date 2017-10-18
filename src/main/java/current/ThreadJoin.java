package current;

import java.util.Random;

/**
 * Author: fangxueshun
 * Description:
 * Date: 2017/10/18
 * Time: 23:09
 */
public class ThreadJoin extends Thread{
    @Override
    public void run(){
        Random random = new Random();
        int sleepTime = random.nextInt(5000);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"线程执行了"+sleepTime+"ms");
    }
}
