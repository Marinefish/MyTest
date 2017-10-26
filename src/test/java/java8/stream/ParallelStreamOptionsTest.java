package java8.stream;

import org.junit.Test;

import java.util.Arrays;

import static java.lang.System.out;
import static org.junit.Assert.*;

/**
 * Author: fangxueshun
 * Description:
 * Date: 2017/10/26
 * Time: 23:53
 */
public class ParallelStreamOptionsTest {
    @Test
    public void outofOrder() throws Exception {
        ParallelStreamOptions.outofOrder(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)).forEach(out::println);
    }

}