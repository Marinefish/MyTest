package algorithm;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Author: fangxueshun
 * Description:
 * Date: 2017/10/24
 * Time: 23:20
 */
public class ClassroomPlanningSolutionsTest {
    @Test
    public void solution() throws Exception {
        Gson gson = new Gson();
        ClassroomPlanningSolutions planningSolutions = new ClassroomPlanningSolutions();
        Map<String,ClassroomPlanningSolutions.ClassTime> subjectsMap = new HashMap<>();
        ClassroomPlanningSolutions.ClassTime classTime1 = new ClassroomPlanningSolutions.ClassTime(0,3);
        ClassroomPlanningSolutions.ClassTime classTime2 = new ClassroomPlanningSolutions.ClassTime(2,3);
        ClassroomPlanningSolutions.ClassTime classTime3 = new ClassroomPlanningSolutions.ClassTime(4,7);
        ClassroomPlanningSolutions.ClassTime classTime4 = new ClassroomPlanningSolutions.ClassTime(3,8);
        ClassroomPlanningSolutions.ClassTime classTime5 = new ClassroomPlanningSolutions.ClassTime(6,10);
        ClassroomPlanningSolutions.ClassTime classTime6 = new ClassroomPlanningSolutions.ClassTime(8,10);
        ClassroomPlanningSolutions.ClassTime classTime7 = new ClassroomPlanningSolutions.ClassTime(9,11);
        ClassroomPlanningSolutions.ClassTime classTime8 = new ClassroomPlanningSolutions.ClassTime(11,15);
        ClassroomPlanningSolutions.ClassTime classTime9 = new ClassroomPlanningSolutions.ClassTime(12,15);
        ClassroomPlanningSolutions.ClassTime classTime10 = new ClassroomPlanningSolutions.ClassTime(10,13);
        ClassroomPlanningSolutions.ClassTime classTime11 = new ClassroomPlanningSolutions.ClassTime(13,17);
        ClassroomPlanningSolutions.ClassTime classTime12 = new ClassroomPlanningSolutions.ClassTime(15,18);

        subjectsMap.put("subject1",classTime1);
        subjectsMap.put("subject2",classTime2);
        subjectsMap.put("subject3",classTime3);
        subjectsMap.put("subject4",classTime4);
        subjectsMap.put("subject5",classTime5);
        subjectsMap.put("subject6",classTime6);
        subjectsMap.put("subject7",classTime7);
        subjectsMap.put("subject8",classTime8);
        subjectsMap.put("subject9",classTime9);
        subjectsMap.put("subject10",classTime10);
        subjectsMap.put("subject11",classTime11);
        subjectsMap.put("subject12",classTime12);
        System.out.println(gson.toJson(planningSolutions.solution(subjectsMap)));

    }


}