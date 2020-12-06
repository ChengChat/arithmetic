package test;

public class ValueTransfer {
    public static void main(String[] args) {
        Object a = new Object();
        System.out.println(a);
        changeReference(a);
        System.out.println(a);
   }

    private static void changeReference(Object a) {
        a = new Object();
        System.out.println(a);
    }
}
