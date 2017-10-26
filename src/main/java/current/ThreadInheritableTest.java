package current;

import java.util.Random;

/**
 * Author: fangxueshun
 * Description: 线程值继承，子线程可以拿到父线程的ThreadLoal值
 * 模拟带有编号的厨师做饼干，饼干编号要和厨师编号一致
 * Date: 2017/10/19
 * Time: 23:19
 */
public class ThreadInheritableTest {
    /*1.首先要理解 为什么 在 新线程中得不到值，是因为我们其实是根据 Thread.currentThread()，拿到该线程的 threadlocals，
    从而进一步得到我们之前预先 set 好的值。那么如果我们新开一个线程，这个时候，由于 Thread.currentThread() 已经变了，从而导致获得的 threadlocals 不一样，我们之前并没有在这个新的线程的 threadlocals 中放入值，那么我就再通过 threadlocal.get()方法 是不可能拿到值的。
      2.那么解决办法就是 我们在新线程中，要把父线程的 threadlocals 的值 给复制到 新线程中的 threadlocals 中来。这样，我们在新线程中得到的 threadlocals 才会有东西，再通过 threadlocal.get() 中的 threadlocal，就会得到值。*/

    /*编号*/
    public static class Number {
        public static ThreadLocal<Integer> cookNumber = new InheritableThreadLocal<>() ;


    }

    public  class MakeCookie extends Thread{
        ThreadLocal number;
        String fatherThreadName;
        public MakeCookie(ThreadLocal number,String fatherThreadName){
            this.number = number;
            this.fatherThreadName = fatherThreadName;
        }
        @Override
        public void run(){
            Random random = new Random();
            int costTime = random.nextInt(1000);
            try {
                Thread.sleep(costTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(fatherThreadName+"的子线程---"+Thread.currentThread().getName()+":"+"做小饼干成功！编号:"+number.get()+",耗时:"+costTime+"ms");
        }
    }

}
