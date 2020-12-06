package test;

public class D extends C{
    public int a = 2;
    public D(){
        System.out.println("D 构造函数");
    }

    public D(int i){
        System.out.println("D 有参构造函数");
    }

    static{
        System.out.println("D 静态代码块");
    }

    {
        System.out.println("D 构造代码块");
    }

    public static void main(String[] args) {
        C c = new D(1);
        System.out.println(c.a);

        String a = "1";
        int b = 1;
        int d = 1;
        System.out.println(a + b + d);

    }

}
