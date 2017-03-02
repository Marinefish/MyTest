package fang.dailytask;

import com.fang.dailytask.DuplicateRemoval;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Author: fangxueshun
 * Description: 快速去重验证
 * Date: 2017/3/2
 * Time: 23:08
 */
public class TestDuplicateRemoval {

    @Test
    //int类型验证 TODO 待完善
    public final void testIntType(){
        DuplicateRemoval duplicateRemoval = new DuplicateRemoval();
        int[] nums= {234,123,234,45,6,6,444,444,444};
        int[] targetNums = {234,123,45,6,444};
        assertEquals(Arrays.asList(targetNums),duplicateRemoval.removalDup(Arrays.asList(nums)));
    }

    @Test
    //String类型验证 TODO 待完善
    public final void testStringType(){
        DuplicateRemoval duplicateRemoval = new DuplicateRemoval();
        List<String> sourece= new ArrayList<>();
        sourece.add("122");
        sourece.add("122");
        sourece.add("123");
        List<String> target = new ArrayList<>();
        target.add("122");
        target.add("123");
        assertEquals(target,duplicateRemoval.removalDup(sourece));
    }

}
