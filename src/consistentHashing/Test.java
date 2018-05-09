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

        cluster.addServer(new Server("france"));

        findEntries(cluster, entries);
    }

    private static Cluster createCluster() {
        Cluster cluster = new Cluster();
        cluster.addServer(new Server("china"));
        cluster.addServer(new Server("japan"));
        cluster.addServer(new Server("korea"));
        cluster.addServer(new Server("usa"));
        cluster.addServer(new Server("italy"));
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
