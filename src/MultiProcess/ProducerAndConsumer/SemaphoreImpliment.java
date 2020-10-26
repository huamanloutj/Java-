package MultiProcess.ProducerAndConsumer;

import java.util.concurrent.Semaphore;
/**
 * 使用semaphore信号量实现
 * @author ZGJ
 * @date 2020年9月23日
 */
public class SemaphoreImpliment {
    private static Integer count = 0;
    //创建三个信号量
    final Semaphore notFull = new Semaphore(10);
    final Semaphore notEmpty = new Semaphore(0);
    final Semaphore mutex = new Semaphore(1);

    public static void main(String[] args) {
        SemaphoreImpliment semaphore= new SemaphoreImpliment();
        new Thread(semaphore.new Producer()).start();
        new Thread(semaphore.new Consumer()).start();
        new Thread(semaphore.new Producer()).start();
        new Thread(semaphore.new Consumer()).start();
        new Thread(semaphore.new Producer()).start();
        new Thread(semaphore.new Consumer()).start();
        new Thread(semaphore.new Producer()).start();
        new Thread(semaphore.new Consumer()).start();
    }
    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++){
            //while(true){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    notFull.acquire();
                    System.out.println("********" + notFull);
                    mutex.acquire();
                    count++;
                    System.out.println(Thread.currentThread().getName()
                            + "生产者生产，目前总共有" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    mutex.release();
                    notEmpty.release();
                }
            }
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++){
                //while (true){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                try {
                    notEmpty.acquire();
                    mutex.acquire();
                    count--;
                    System.out.println(Thread.currentThread().getName()
                            + "消费者消费，目前总共有" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    mutex.release();
                    notFull.release();
                }
            }
        }
    }
}
