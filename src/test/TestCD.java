package test;

public class TestCD {
    public static void main(String[] args) {
        /*
         静态代码块可以完成类的初始化。
         静态代码块随着类的加载而执行，而且只执行一次（new 多个对象就只执行一次）。
         如果和主函数在同一类中，优先于主函数执行。

         构造代码块：是给所有的对象进行初始化，也就是说，所有的对象都会调用一个代码块。
         只要对象一建立。就会调用这个代码块。

         构造函数：是给与之对应的对象进行初始化。它具有针对性。
         */
        D d = new D();
        System.out.println();
        D d1 = new D();
    }
}
