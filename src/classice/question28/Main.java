package classice.question28;

import java.util.Scanner;


public class Main {
    int[] arr = {1, 2, 3, 4, 5, 6};
    int index = 0;

    public static void main(String[] args) {
        Main m = new Main();
        Thread thread1 = new Thread(() -> m.print());
        Thread thread2 = new Thread(() -> m.print());
        thread1.start();
        thread2.start();
    }

    public synchronized void print() {
        while (index < arr.length) {
            System.out.println(arr[index++]);
            this.notifyAll();
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();
    }
}
