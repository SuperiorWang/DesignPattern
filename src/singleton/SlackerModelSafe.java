package singleton;

/**  单例模式
 *   懒汉模式
 *   线程安全的懒汉模式
 *   效率很低
 */

public class SlackerModelSafe {
    private static SlackerModelSafe instance;
    private SlackerModelSafe() {}
    public static synchronized SlackerModelSafe getInstance() {
        if (instance == null) {
            instance = new SlackerModelSafe();
        }
        return instance;
    }
}

/**
 *  双重校验锁
 *  这是懒汉模式的升级版
 *  双重检查锁定才能正常达到单例效果
 */

class Singletion {
    private volatile static Singletion singletion;
    private Singletion(){}
    public static Singletion getSingletion() {
        if (singletion == null) {
            synchronized (Singletion.class) {
                if (singletion == null) {
                    singletion = new Singletion();
                }
            }
        }
        return singletion;
    }
}