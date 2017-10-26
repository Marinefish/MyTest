package set;

/**
 * Author: fangxueshun
 * Description:验证java removeAll方法
 * Date: 2017/10/23
 * Time: 23:16
 */
public class ListRemoveAll {
    public static class UserWithNoOverrideRemoveAll {
        private String userName;
        private Integer age ;
        private String  sex;
        public UserWithNoOverrideRemoveAll(String userName, Integer age, String sex){
            this.age = age;
            this.sex = sex;
            this.userName = userName;

        }

        @Override
        public String toString(){
            return "userName:"+userName+",age"+age+",sex"+sex;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
    }

    public static class UserWithOverrideRemoveAll extends  UserWithNoOverrideRemoveAll{
        public UserWithOverrideRemoveAll(String userName, Integer age, String sex) {
            super(userName, age, sex);
        }

        @Override
        public boolean equals(Object removeAll){
            if(!(removeAll instanceof UserWithOverrideRemoveAll)){
                return false;
            }
            UserWithOverrideRemoveAll tem = (UserWithOverrideRemoveAll)removeAll;

            if(!tem.getAge().equals(super.age) || !tem.getSex().equals(super.sex)||!tem.getUserName().equals(super.userName)){
                return false;
            }
            return true;
        }
    }
}
