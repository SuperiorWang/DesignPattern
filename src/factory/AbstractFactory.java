package factory;

/**
 * 抽象工厂模式
 */
interface IProduct1 {
    public void show();
}

interface IProduct2 {
    public void show();
}

interface IFactory {
    public IProduct1 createIProduct1();
    public IProduct2 createIProduct2();
}

class Product1  implements IProduct1 {
    @Override
    public void show() {
        System.out.println("这是1类型产品");
    }
}

class Product2 implements IProduct2 {
    @Override
    public void show() {
        System.out.println("这是2类型产品");
    }
}

class ABFactory implements IFactory {
    @Override
    public IProduct1 createIProduct1() {
        return new Product1();
    }

    @Override
    public IProduct2 createIProduct2() {
        return new Product2();
    }
}


public class AbstractFactory {
    public static void main(String[] args) {
        IFactory factory = new ABFactory();
        factory.createIProduct1().show();
        factory.createIProduct2().show();
    }
}













