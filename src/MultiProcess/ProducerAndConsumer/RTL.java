package MultiProcess.ProducerAndConsumer;



import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者和消费者，ReentrantLock的实现
 *
 * @author TJ
 * @date 2020年9月23日
 */
public class RTL {
    private static Integer count = 0;
    private static final Integer FULL = 10;
    //创建一个锁对象
    private Lock lock = new ReentrantLock();
    //创建两个条件变量，一个为缓冲区非满，一个为缓冲区非空
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public static void main(String[] args) {
        RTL reenTrantLock = new RTL();
//        for (int i = 0 ; i < 10 ; i ++){
//            new Thread(reenTrantLock.new Producer()).start();
//            new Thread(reenTrantLock.new Consumer()).start();
//        }
        new Thread(reenTrantLock.new Producer()).start();
        new Thread(reenTrantLock.new Consumer()).start();
        new Thread(reenTrantLock.new Producer()).start();
        new Thread(reenTrantLock.new Consumer()).start();
        new Thread(reenTrantLock.new Producer()).start();
        new Thread(reenTrantLock.new Consumer()).start();
        new Thread(reenTrantLock.new Producer()).start();
        new Thread(reenTrantLock.new Consumer()).start();
    }
    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //获取锁
                lock.lock();
                try {
                    while (count == FULL) {
                        try {
                            notFull.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName()
                            + "生产者生产，目前总共有" + count);
                    //唤醒消费者
                    notEmpty.signal();
                } finally {
                    //释放锁
                    lock.unlock();
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                lock.lock();
                try {
                    while (count == 0) {
                        try {
                            notEmpty.await();
                        } catch (Exception e) {

                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName()
                            + "消费者消费，目前总共有" + count);
                    notFull.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}

