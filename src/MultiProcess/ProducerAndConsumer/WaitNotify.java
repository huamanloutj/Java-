package MultiProcess.ProducerAndConsumer;

public class WaitNotify {
    private static Integer count = 0;
    private static final Integer FULL = 10;
    private static String LOCK = "lock";

    public static void main(String[] args) {
        WaitNotify wn = new WaitNotify();
//        for (int i = 0 ; i < 10 ; i ++){
//            new Thread(wn.new Producer()).start();
//        }
//        for (int i = 0 ; i < 10 ; i ++){
//            new Thread(wn.new Consumer()).start();
//        }
        new Thread(wn.new Producer()).start();
        new Thread(wn.new Consumer()).start();
        new Thread(wn.new Producer()).start();
        new Thread(wn.new Consumer()).start();
        new Thread(wn.new Producer()).start();
        new Thread(wn.new Consumer()).start();
        new Thread(wn.new Producer()).start();
        new Thread(wn.new Consumer()).start();
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    while (count == FULL) {
                        try {
                            LOCK.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前总共有" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    while (count == 0) {
                        try {
                            LOCK.wait();
                        } catch (Exception e) {
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }
}
