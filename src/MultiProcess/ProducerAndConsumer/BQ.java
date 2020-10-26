package MultiProcess.ProducerAndConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 使用BlockingQueue实现生产者消费者模型
 * @author ZGJ
 * @date 2017年6月29日
 */
public class BQ {
    private static Integer count = 0;
    //创建一个阻塞队列
    final BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {
        BQ bq = new BQ();
        new Thread(bq.new Producer()).start();
        new Thread(bq.new Consumer()).start();
        new Thread(bq.new Producer()).start();
        new Thread(bq.new Consumer()).start();
        new Thread(bq.new Producer()).start();
        new Thread(bq.new Consumer()).start();
        new Thread(bq.new Producer()).start();
        new Thread(bq.new Consumer()).start();
    }
    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    blockingQueue.put(1);
                    System.out.println(blockingQueue);
                    count++;
                    System.out.println(Thread.currentThread().getName()
                            + "生产者生产，目前总共有" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                try {
                    blockingQueue.take();
                    count--;
                    System.out.println(Thread.currentThread().getName()
                            + "消费者消费，目前总共有" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
