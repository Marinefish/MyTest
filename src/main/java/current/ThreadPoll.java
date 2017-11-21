package current;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.*;

/**
 * description
 *
 * @author fangxueshun
 * @date 2017/11/13
 */
public class ThreadPoll {
//    private static ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(15);
//    private static ThreadPoolExecutor newFixedThreadPool = new ThreadPoolExecutor(15,15,0,TimeUnit.SECONDS,new LinkedBlockingDeque<>(1000));
    private static BlockingQueue<Integer> integers;
    private static Stack<Integer> integersStack;
    private static BlockingQueue<Integer> blockingQueue = new LinkedBlockingDeque<>(15);
    static {
        integers = new LinkedBlockingDeque<>(15);
        integersStack = new Stack<>();
        for(int i=0;i<800;i++){
                integersStack.push(i);

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        new Thread(()->{
            while (!integersStack.isEmpty()){
                try {
                    blockingQueue.put(integersStack.pop());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        for(int i=0;i<30;i++){

            new Thread(()->{
                while (true){
                    Integer task = null;
                    if(blockingQueue.isEmpty()){
                        System.out.println("queue empty,sleep 1s");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        continue;
                    }
                    try {
                        task = blockingQueue.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                task = integersStack.pop();
                    Integer lostTime = random.nextInt(500);
                    System.out.println("---"+Thread.currentThread().getName()+":执行任务-->"+task+"开始，执行时间"+lostTime+"ms-----");
                    try {
                        Thread.sleep(lostTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("执行任务-->"+task+"完毕-----");
                }

            }).start();
        }
    }
}
