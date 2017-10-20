package current;

import org.junit.Test;

/**
 * Author: fangxueshun
 * Description:
 * Date: 2017/10/20
 * Time: 23:03
 */
public class ThreadReentrantLockTest {
    @Test
    public void printNumberHasLock() throws Exception {
        ThreadReentrantLock reentrantLock = new ThreadReentrantLock();
        for(int i=0;i<10;i++){
            Thread thread = new Thread(()->{
//                ThreadReentrantLock reentrantLock = new ThreadReentrantLock();
                reentrantLock.printNumberHasLock();
            });
            thread.start();

        }
        Thread.sleep(1000);
    }

    @Test
    public void synPrint() throws Exception{
        ThreadReentrantLock reentrantLock = new ThreadReentrantLock();
        for(int i=0;i<10;i++){
            Thread thread = new Thread(()->{
//                ThreadReentrantLock reentrantLock = new ThreadReentrantLock();
                reentrantLock.synPrint();
            });
            thread.start();

        }
        Thread.sleep(1000);
    }

    @Test
    public void print() throws Exception {
        ThreadReentrantLock reentrantLock = new ThreadReentrantLock();
        for(int i=0;i<10;i++){
           Thread thread = new Thread(()->{
//                ThreadReentrantLock reentrantLock = new ThreadReentrantLock();
               reentrantLock.print();
            });
           thread.start();

        }
        Thread.sleep(1000);
    }

}