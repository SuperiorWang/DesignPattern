package factory;

/**
 *   简单工厂模式
 *
 */

interface Food{
    abstract void desc();
}


class A implements Food {
    @Override
    public void desc() {
        System.out.print("This is A food");
    }
}

class B implements Food {
    @Override
    public void desc() {
        System.out.print("This is B food");
    }
}

class C implements Food {
    @Override
    public void desc() {
        System.out.print("This is C food");
    }
}

class StaticFactory{
    public StaticFactory(){};
    public static Food getA() {
        return new A();
    }

    public static Food getB() {
        return new B();
    }

    public static Food getC() {
        return new C();
    }
}


class Factory {
    public static Food createFood(String name){
        Food food = null;
        if (name.equals("A")) {
            return StaticFactory.getA();
        }else if (name.equals("B")) {
            return StaticFactory.getB();
        }else  if (name.equals("C")) {
            return StaticFactory.getC();
        }else {
            System.out.println("args error");
            return food;
        }
    }
}

public class SimpleFactory {
    public static void main(String[] args) {
        Factory factory = new Factory();
        Food food = factory.createFood("C");
        food.desc();
    }

}


