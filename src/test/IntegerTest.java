package test;

import javafx.collections.WeakMapChangeListener;

import java.util.AbstractSet;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

public class IntegerTest {
    static {
        System.out.println("IntegerTest类加载了");
    }
    public IntegerTest() {
        System.out.println("IntegerTest空参构造函数被执行了");
    }
    public IntegerTest(int i) {
        System.out.println("IntegerTest有参构造函数被执行了 " + i);
    }


    public static void main(String[] args) {
        Integer i1 = 222;
        Integer i2 = 222;
        System.out.println(i1 == i2);
        Integer i3 = 13;
        Integer i4 = 13;
        System.out.println(i3 == i4);
        Integer i5 = new Integer(13);
        Integer i6 = new Integer(13);
        System.out.println(i5 == i6);
        int i7 = 13;
        // i5自动拆箱
        System.out.println(i5 == i7);

        IntegerTest.staticMethod();
        IntegerTest integerTest = new IntegerTest(2);
        System.out.println(integerTest);
        IntegerTest[] list = new IntegerTest[10];
        System.out.println(list[0]);

        Integer na = Integer.valueOf(1);
        Integer d = 1;
        int n = 1;
        System.out.println(na == d);
        System.out.println(n == na);
        Integer temp = null;
        Integer test = test(temp);
        System.out.println(test);

    }

    private static Integer test(int temp) {
        return 10;
    }

    private static void staticMethod() {
        System.out.println("staticMethod（）方法被执行了");
    }
}
