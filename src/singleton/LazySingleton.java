package singleton;

public class LazySingleton {

    private LazySingleton() {
        System.out.println("LazySingleton is created");
    }

    private static LazySingleton lazySingleton;

    public static LazySingleton getInstance() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

    public static void main(String[] args) {
        LazySingleton lazySingleton1 = LazySingleton.getInstance();
        LazySingleton lazySingleton2 = LazySingleton.getInstance();
        System.out.println("equals: " + (lazySingleton1 == lazySingleton2));
    }
}
