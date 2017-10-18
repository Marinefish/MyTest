package current;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Author: fangxueshun
 * Description:
 * Date: 2017/10/18
 * Time: 23:11
 */
public class ThreadJoinTest {
    @Test
    public void testNoJoin() throws Exception {
        long time = System.currentTimeMillis();
        System.out.println("当前线程为："+Thread.currentThread().getName());
        ThreadJoin threadJoin = new ThreadJoin();
        threadJoin.start();
        threadJoin.join(60);
        System.out.println("在threadJoin线程执行后执行");
        System.out.println("共消耗时间"+(System.currentTimeMillis()-time)+"ms,后面要sleep");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sleep 5s 结束");
    }

}