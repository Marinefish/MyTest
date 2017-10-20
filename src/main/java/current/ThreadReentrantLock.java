package current;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: fangxueshun
 * Description:
 * Date: 2017/10/20
 * Time: 22:53
 */
public class ThreadReentrantLock {
    private Lock lock = new ReentrantLock();
    public void printNumberHasLock(){
        lock.lock();
        print();
        lock.unlock();
    }

    synchronized public  void synPrint(){
        print();
    }

    public void print(){
        for(int i=0;i<3;i++){
            System.out.println("current thread name:"+Thread.currentThread().getName()+",the number is:"+(i+1));
        }
    }
}
