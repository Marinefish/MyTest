package watcher;

/**
 * Author: fangxueshun
 * Description:
 * Date: 2017/5/15
 * Time: 11:54
 */
public class MyTopicsSubscriber implements Observer {
    private String subName;
    private Subject topic;

    public MyTopicsSubscriber(String subName){
        this.subName = subName;
    }

    @Override
    public void update(){
        String message = (String) topic.getUpdate(this);
        if(null == message){
            System.out.println(subName+": No new Message");
        }else System.out.println(subName+"：Consuming message--"+message);
    }

    @Override
    public void setSubject(Subject subject){
        this.topic = subject;
    }
}
