package singleton;

/** 单例模式
 *  静态内部类
 *  唯一的好处是只有在getInstance的时候才new出来，延迟加载。节省内存
 */
class Singleton {
    private static class SingletionHolder{
        private static final Singleton INSTANCE = new Singleton();
    }

    private Singleton() {}

    public static final Singleton getInstance() {
        return SingletionHolder.INSTANCE;
    }

}




