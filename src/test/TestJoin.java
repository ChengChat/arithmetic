package test;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class TestJoin implements Runnable {


    public static void main(String[] sure) throws InterruptedException {
        Thread t = new Thread(new TestJoin());
        long start = System.currentTimeMillis();
        t.start();
        //oin()方法的作用是阻塞当前线程，直到调用join()的线程结束销毁，
        // 或者指定阻塞时长，若线程没停止但是超时，取消阻塞
        t.join(3000);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println("Main finished");
        TestJoin testJoin = new TestJoin();

    }

    public synchronized void a(){
        System.out.println("a start");
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("a stop");
    }

    public synchronized void b(){
        System.out.println("b start");

        System.out.println("b stop");
        notify();
    }

    @Override
    public void run() {
        synchronized (currentThread()) {
            for (int i = 1; i <= 5; i++) {
                try {
                    sleep(1000);//睡眠5秒，循环是为了方便输出信息
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("睡眠" + i);
            }
            System.out.println("TestJoin finished");//t线程结束
        }
    }

}
