package watcher;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: fangxueshun
 * Description:
 * Date: 2017/5/15
 * Time: 11:30
 */
public class MyTopic implements Subject {
    private List<Observer> observers;
    private String message;
    private boolean isChanged;
    private final Object MUTEX = new Object();

    public MyTopic(){
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer observer){
        if(null == observer) throw  new NullPointerException("Null Observer");
        if(!observers.contains(observer)) observers.add(observer);
    }

    @Override
    public void unRegister(Observer observer){
        if(null!=observer){
            if(observers.contains(observer)) observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers(){
        List<Observer> observersLocal = null;
        synchronized (MUTEX){
            if(!isChanged)
                return;
            observersLocal = new ArrayList<>(this.observers);
            this.isChanged = false;
        }
        for(Observer observer:observersLocal){
            observer.update();
        }
    }

    @Override
    public Object getUpdate(Observer observer){
        return this.message;

    }

    public void postMessage(String msg){
        System.out.println("Message Posted to Topic");
        this.message = msg;
        this.isChanged = true;
        notifyObservers();
    }
}
