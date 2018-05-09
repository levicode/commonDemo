package consistentHashing;

public class Cluster {
    private static final int SERVER_MAX_SIZE = 1024;

    private Server[] servers;

    private int size;

    public Cluster() {
        servers = new Server[SERVER_MAX_SIZE];
        size = 0;
    }

    public void put(Entry entry) {
        int index = getServerIndex(entry);
        servers[index].put(entry);
    }

    public Entry get(Entry entry) {
        int index = getServerIndex(entry);
        return servers[index].get(entry);
    }

    public boolean addServer(Server server) {
        if (size >= SERVER_MAX_SIZE) {
            return false;
        }
        servers[size++] = server;
        return true;
    }

    private int getServerIndex(Entry entry) {
        return entry.hashCode() % size;
    }
}
