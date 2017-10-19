package current;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Author: fangxueshun
 * Description:
 * Date: 2017/10/19
 * Time: 23:55
 */
public class MakeCookieTest {
    @Test
    public void TestInheritable() throws Exception {
        //3个线程，每个线程做三个饼干
        for(int i=0;i<3;i++){
            ThreadLocal<Integer> number = ThreadInheritableTest.Number.cookNumber;
            int j = i;
            new Thread(() -> {
                number.set(j+1);
                System.out.println(Thread.currentThread().getName()+":"+number.get());
                for(int m=0;m<3;m++){
                    new ThreadInheritableTest().new MakeCookie(number,Thread.currentThread().getName()).start();
                }
            }).start();
        }
        Thread.sleep(5000);
    }

}