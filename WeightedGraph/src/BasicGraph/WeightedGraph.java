package BasicGraph;

/**
 * @author Jiani WANG
 * @create 2020-04-25 10:52
 */
public interface WeightedGraph<Weight extends Number & Comparable> {
    public int V();
    public int E();
    public void addEdge(Edge<Weight> e);
    boolean hasEdge( int v , int w );
    void show();
    public Iterable<Edge<Weight>> adj(int v);
}
