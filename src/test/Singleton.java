package test;

public class Singleton {

    private Singleton(){}
    private static class InnerSingleton{
        private static Singleton singleton = new Singleton();
    }
    public static Singleton getSingleton(){
        return InnerSingleton.singleton;
    }
}
