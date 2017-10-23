package set;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: fangxueshun
 * Description:
 * Date: 2017/10/23
 * Time: 23:22
 */
public class ListRemoveAllTest {
    @Test
    public void testRemoveAll() {
        List<ListRemoveAll.UserWithNoOverrideRemoveAll> noOverrideRemoveAlls = new ArrayList<>();

        ListRemoveAll.UserWithNoOverrideRemoveAll user = new ListRemoveAll.UserWithNoOverrideRemoveAll("小明", 15, "男");
        noOverrideRemoveAlls.add(user);
        noOverrideRemoveAlls.add(new ListRemoveAll.UserWithNoOverrideRemoveAll("小明", 15, "男"));
        noOverrideRemoveAlls.removeAll(Arrays.asList(user));
        System.out.println("未重写equals方法:" + noOverrideRemoveAlls.toString());

        List<ListRemoveAll.UserWithOverrideRemoveAll> overrideRemoveAlls = new ArrayList<>();
        ListRemoveAll.UserWithOverrideRemoveAll user2 = new ListRemoveAll.UserWithOverrideRemoveAll("小明", 15, "男");
        overrideRemoveAlls.add(user2);
        overrideRemoveAlls.add(new ListRemoveAll.UserWithOverrideRemoveAll("小明", 15, "男"));
        overrideRemoveAlls.removeAll(Arrays.asList(user2));
        System.out.println("重写equals方法:" + overrideRemoveAlls.toString());
    }

}