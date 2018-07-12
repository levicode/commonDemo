package singleton;

public class HungrySingleton {

    private HungrySingleton() {
        System.out.println("HungrySingleton is created");
    }

    private static final HungrySingleton HUNGRY_SINGLETON = new HungrySingleton();

    public static HungrySingleton getInstance() {
        return HUNGRY_SINGLETON;
    }

    public static void main(String[] args) {
        HungrySingleton singleton1 = HungrySingleton.getInstance();
        HungrySingleton singleton2 = HungrySingleton.getInstance();
        System.out.println("equals: " + (singleton1 == singleton2));
    }
}
