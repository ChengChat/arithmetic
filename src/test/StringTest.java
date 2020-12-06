package test;

public class StringTest {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = new String("abc");
        String intern = str2.intern();
        System.out.println(str1 == str2.intern());
        /*
            在JDK 1.7的intern()实现不会再复制实例，只是在常量池中记录首次出现的实例引用。
            因此，如果把下面一句注释掉，则str3 == str3.intern()为true。
            而如果不注释下面一句，则调用intern()时 "计算机软件" 不是在常量池中首次出现，字符串常量池中已经有了它的引用，
            则 str3 == str3.intern() 时，两个引用地址不同，为false
         */
//        String s = "计算机软件";
        //str3生成的对象在堆中，此时常量池中没有跟str3内容相同的字符串，
        // 所以在调用intern方法时，会在常量池中添加此对象的引用，所以返回为true
        String str3 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str3 == str3.intern());
        String str4 = new StringBuilder("ja").append("va").toString();
        System.out.println(str4 == str4.intern());

        String s = "张三/名词";
        System.out.println(s.substring(0,s.indexOf("/") ));
    }
}
