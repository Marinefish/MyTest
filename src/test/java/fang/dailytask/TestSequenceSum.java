package fang.dailytask;

import com.fang.dailytask.SequenceSum;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Author: fangxueshun
 * Description: 最大子序列求和测
 * Date: 2017/3/1
 * Time: 19:29
 */
public class TestSequenceSum {

    @Test
    /*空序列*/
    public final void testEmptySequences(){
        SequenceSum sequenceSum = new SequenceSum();
        int[] testSequence = {};
        int sum = sequenceSum.sum(testSequence);
        assertEquals(0,sum);
    }
    @Test
    /*负数序列*/
    public final void testNegativeSequences(){
        SequenceSum sequenceSum = new SequenceSum();
        int[] testSequence = {-1,-2,-3,-4};
        int sum = sequenceSum.sum(testSequence);
        assertEquals(0,sum);
    }

    @Test
    /*正常序列*/
    public final void testNormalSequences(){
        SequenceSum sequenceSum = new SequenceSum();
        int[] testSequence1 = {-2 ,11 ,-4 ,13, -5 ,-2};
        int sum1 = sequenceSum.sum(testSequence1);
        int[] testSequence2 = {-6, 2, 4, -7, 5, 3, 2, -1, 6, -9 ,10 };
        int sum2 = sequenceSum.sum(testSequence2);
        assertEquals(20,sum1);
        assertEquals(16,sum2);
    }
}
