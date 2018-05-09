package consistentHashing;

public class Entry {
    private String key;

    public Entry(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return key;
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }
}
