package consistentHashing;

import java.util.HashMap;
import java.util.Map;

public class Server {
    private String name;

    private Map<Entry, Entry> entries;

    public Server(String name) {
        this.name = name;
        entries = new HashMap<>();
    }

    public void put(Entry entry) {
        entries.put(entry, entry);
    }

    public Entry get(Entry entry) {
        return entries.get(entry);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
