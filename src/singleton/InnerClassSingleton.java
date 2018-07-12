package singleton;

public class InnerClassSingleton {

    private InnerClassSingleton() {
        System.out.println("InnerClassSingleton is created");
    }

    private static class SingletonHolder {
        private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static void main(String[] args) {
        InnerClassSingleton innerClassSingleton1 = InnerClassSingleton.getInstance();
        InnerClassSingleton innerClassSingleton2 = InnerClassSingleton.getInstance();
        System.out.println("equals: " + (innerClassSingleton1 == innerClassSingleton2));
    }
}
