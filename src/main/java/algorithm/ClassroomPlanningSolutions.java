package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Author: fangxueshun
 * Description: 教室规划问题求解
 * 问题描述：有n门课程要在同一间教室上课，教室使用的方式是独享的，每门课程上课时间在[0,24]时间内，课程集合为{C1,C2...Cn}
 * 设计算法对教室的使用满足上述要求，同时上课的课程门数最多
 * Date: 2017/10/24
 * Time: 23:10
 */
public class ClassroomPlanningSolutions {
    /*传入课程和对应上课时间的map，返回教室上课科目列表*/
    public List<String> solution(Map<String,ClassTime> subjectsMap){
        List<String> subjectList = new ArrayList<>();
        return subjectList;

    }

    public static class ClassTime{
        Integer startTime;
        Integer endTime;

        public ClassTime(Integer startTime,Integer endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }
        public Integer getStartTime() {
            return startTime;
        }

        public void setStartTime(Integer startTime) {
            this.startTime = startTime;
        }

        public Integer getEndTime() {
            return endTime;
        }

        public void setEndTime(Integer endTime) {
            this.endTime = endTime;
        }
    }
}
