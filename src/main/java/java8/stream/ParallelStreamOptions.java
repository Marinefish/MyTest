package java8.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Author: fangxueshun
 * Description:
 * Date: 2017/10/26
 * Time: 23:47
 */
public class ParallelStreamOptions {

    public static List<Integer> outofOrder(Collection<Integer> collection ){
        List<Integer> integers = new ArrayList<>();
        collection.parallelStream().forEach(number ->integers.add(number));
        return integers;
    }
}
