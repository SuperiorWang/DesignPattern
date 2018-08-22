package singleton;

/** 单例饿汉模式
 *
 */
public class StarvingModel {
    private static StarvingModel instance = new StarvingModel();
    private StarvingModel() {}
    public static StarvingModel getInstance() {
        return instance;
    }
}


/**
 * 饿汉模式变种
 */
class Single {
    private static Single instance = null;
    static {
        instance = new Single();
    }

    private Single(){}

    public static Single getInstance() {
        return instance;
    }
}