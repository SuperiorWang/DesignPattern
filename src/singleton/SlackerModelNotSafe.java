package singleton;

/** 单例模式
 *  懒汉模式
 *  线程不安全的懒汉模式
 */

public class SlackerModelNotSafe {
    private static  SlackerModelNotSafe instance;
    private SlackerModelNotSafe(){}

    public static SlackerModelNotSafe getInstance() {
        if (instance == null) {
            instance =  new SlackerModelNotSafe();
        }
        return instance;
    }
}
