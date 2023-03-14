package offer.base.quesion02;

public class Singleton {
    private Singleton(){};

    /**
        静态初始化器， 由JVM来保证线程安全
     */
    private static class SingletonHolder {
        private static Singleton singleton = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonHolder.singleton;
    }
}
