public class DeadLockTest {
    private static long sleepMillis;
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public static void main(String[] args) {
        sleepMillis = Long.parseLong(args[0]);
        DeadLockTest test = new DeadLockTest();
        test.doTest();
    }

    private void doTest() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock12();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock21();
            }
        });
        t1.start();
        t2.start();
    }

    private void lock12() {
        synchronized (lock1) {
            sleep();
            synchronized (lock2) {
                sleep();
            }
        }
    }

    private void lock21() {
        synchronized (lock2) {
            sleep();
            synchronized (lock1) {
                sleep();
            }
        }
    }

    private void sleep() {
        try {
            Thread.sleep(sleepMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
