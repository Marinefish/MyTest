package current;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Author: fangxueshun
 * Description:
 * Date: 2017/10/17
 * Time: 22:20
 */
public class HpPrintTest {
    @Test
    public void print() throws Exception {
        ThreadWaitAndNotify hpPrint = new ThreadWaitAndNotify();
        hpPrint.accept("test1");
        hpPrint.accept("test2");
        hpPrint.accept("test3");
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}