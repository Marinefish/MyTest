package watcher;

/**
 * Author: fangxueshun
 * Description:
 * Date: 2017/5/15
 * Time: 11:27
 */
public interface Observer {
    public void update();
    public void setSubject(Subject subject);
}
