package test;

public class C {
    public int a = 1;
    public C(){
        System.out.println("C 构造函数");
    }

    static{
        System.out.println("C 静态代码块");
    }

    {
        System.out.println("C 构造代码块");
    }
}
