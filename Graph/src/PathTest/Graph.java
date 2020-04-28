package PathTest;

/**
 * @author Jiani WANG
 * @create 2020-04-24 10:26
 */
// 图的接口
public interface Graph {

    public int V();
    public int E();
    public void addEdge(int v, int w);
    boolean hasEdge(int v, int w);
    void show();
    public Iterable<Integer> adj(int v);
}