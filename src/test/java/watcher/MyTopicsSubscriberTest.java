package watcher;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Author: fangxueshun
 * Description:
 * Date: 2017/5/15
 * Time: 12:00
 */
public class MyTopicsSubscriberTest {

    @Test
    public void testObserverPattern(){
        MyTopic topic = new MyTopic();

        Observer observer1 = new MyTopicsSubscriber("observer1");
        Observer observer2 = new MyTopicsSubscriber("observer2");
        Observer observer3 = new MyTopicsSubscriber("observer3");

        topic.register(observer1);
        topic.register(observer2);
        topic.register(observer3);

        observer1.setSubject(topic);
        observer2.setSubject(topic);
        observer3.setSubject(topic);

        topic.postMessage("主题改变了！");
        observer1.update();
    }
}