package consistentHashing;

public class Test {

    public static void main(String[] args) {
        Cluster cluster =createCluster();

        Entry[] entries = {
                new Entry("i"),
                new Entry("have"),
                new Entry("have"),
                new Entry("a"),
                new Entry("dream"),
                new Entry("is"),
                new Entry("to"),
                new Entry("be"),
                new Entry("a"),
                new Entry("software"),
                new Entry("enginering")
        };

        for (Entry entry : entries) {
            cluster.put(entry);
        }

        cluster.addServer(new Server("192.168.0.5"));

        findEntries(cluster, entries);
    }

    private static Cluster createCluster() {
        Cluster cluster = new Cluster();
        cluster.addServer(new Server("192.168.0.0"));
        cluster.addServer(new Server("192.168.0.1"));
        cluster.addServer(new Server("192.168.0.2"));
        cluster.addServer(new Server("192.168.0.3"));
        cluster.addServer(new Server("192.168.0.4"));
        return cluster;
    }

    private static void findEntries(Cluster cluster, Entry[] entries) {
        for (Entry entry : entries) {
            if (cluster.get(entry) == entry) {
                System.out.println("find entry: " + entry);
            } else {
                System.out.println("entry lost: " + entry);
            }
        }
    }
}
