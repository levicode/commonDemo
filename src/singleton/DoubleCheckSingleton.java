package singleton;

public class DoubleCheckSingleton {

    private DoubleCheckSingleton() {
        System.out.println("DoubleCheckSingleton is created");
    }

    private static DoubleCheckSingleton doubleCheckSingleton;

    public static DoubleCheckSingleton getInstance() {
        if (doubleCheckSingleton == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (doubleCheckSingleton == null) {
                    doubleCheckSingleton = new DoubleCheckSingleton();
                }
            }
        }
        return doubleCheckSingleton;
    }

    public static void main(String[] args) {
        DoubleCheckSingleton doubleCheckSingleton1 = DoubleCheckSingleton.getInstance();
        DoubleCheckSingleton doubleCheckSingleton2 = DoubleCheckSingleton.getInstance();
        System.out.println("equals: " + (doubleCheckSingleton1 == doubleCheckSingleton2));
    }
}
