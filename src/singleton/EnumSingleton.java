package singleton;

public enum  EnumSingleton {
    INSTANCE;

    EnumSingleton() {
        System.out.println("EnumSingleton is created");
    }

    public static void main(String[] args) {
        EnumSingleton enumSingleton1 = EnumSingleton.INSTANCE;
        EnumSingleton enumSingleton2 = EnumSingleton.INSTANCE;
        System.out.println("equals: " + (enumSingleton1 == enumSingleton2));
    }
}
