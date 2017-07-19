package watcher;

/**
 * Author: fangxueshun
 * Description:
 * Date: 2017/5/15
 * Time: 11:24
 */
public interface Subject {

    public void register(Observer observer);
    public void unRegister(Observer observer);
    public void notifyObservers();
    public Object getUpdate(Observer observer);
}

