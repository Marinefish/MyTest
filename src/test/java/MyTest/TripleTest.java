package myTest;

import org.junit.Test;

/**
 * Author: fangxueshun
 * Description: 最大子序列求和
 * Date: 2017/4/9
 * Time: 16:50
 */
public class TripleTest {
    @Test
    public void getInstance() throws Exception {
        Triple triple = Triple.getInstance(1);
        Triple triple1 = Triple.getInstance(0);
        Triple triple2 = Triple.getInstance(2);
        Triple triple3 = Triple.getInstance(1);

        System.out.println(triple.toString());
        System.out.println(triple1.toString());
        System.out.println(triple2.toString());
        System.out.println(triple3.toString());
    }

}