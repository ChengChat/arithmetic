package classice.question29;

/**
 * TODO 死锁
 */
public class Main {
    Object o1 = new Object();
    Object o2 = new Object();


    public static void main(String[] args) {
        Main m = new Main();
        Thread thread1 = new Thread(() -> m.method1());
        Thread thread2 = new Thread(() -> m.method2());
        thread1.start();
        thread2.start();
    }

    public void method1() {
        synchronized (o1){
            try {
                Thread.sleep(1000);
                synchronized (o2){
                    System.out.println("method1执行了");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void method2() {
        synchronized (o2){
            try {
                Thread.sleep(1000);
                synchronized (o1){
                    System.out.println("method2执行了");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
