package Week4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GetResult1 {
    final static Lock lock = new ReentrantLock();
    final static Condition lockCondition = lock.newCondition();
    public static int result;
    public static void main(String[] args) throws InterruptedException {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                lock.lock();
                result = AddNumber(3);
                lockCondition.signal();
                lock.unlock();
                System.out.println("结束计算");
            }
        };

        Thread t = new Thread(task);
        t.start();
        lock.lock();
        try {
            lockCondition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
        System.out.println("结果: " + result);
        System.out.println("退出主线程结束。。");
    }

    private static int AddNumber(int num){
        return num + 1;
    }
}
