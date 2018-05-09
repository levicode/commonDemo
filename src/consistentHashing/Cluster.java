package consistentHashing;

import java.util.SortedMap;
import java.util.TreeMap;

public class Cluster {
    private static final int SERVER_MAX_SIZE = 1024;

    private SortedMap<Integer, Server> servers;

    private int size;

    public Cluster() {
        servers = new TreeMap<>();
        size = 0;
    }

    public void put(Entry entry) {
        Server server = routeServer(entry.hashCode());
        server.put(entry);
    }

    public Entry get(Entry entry) {
        Server server = routeServer(entry.hashCode());
        return server.get(entry);
    }

    public boolean addServer(Server server) {
        if (size >= SERVER_MAX_SIZE) {
            return false;
        }
        servers.put(server.hashCode(), server);
        return true;
    }

    private Server routeServer(int hash) {
        if (servers.isEmpty()) {
            return null;
        }
        if (!servers.containsKey(hash)) {
            SortedMap<Integer, Server> tailMap = servers.tailMap(hash);
            hash = tailMap.isEmpty() ? servers.firstKey() : tailMap.firstKey();
        }
        return servers.get(hash);
    }
}
