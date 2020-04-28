package BasicGraph;

import java.util.Vector;

/**
 * @author Jiani WANG
 * @create 2020-04-24 9:24
 */
public class SparseGraph {
    private int n;
    private int m;
    private boolean directed;
    private Vector<Integer>[] g;

    public SparseGraph(int n, boolean directed){
        assert n>=0;
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = new Vector[n];
        for (int i = 0; i < n ; i++) {
            g[i] = new Vector<Integer>();
        }
    }
    public int V(){return n;}
    public int E(){return m;}

    public void addEdge(int v, int w){
        assert v>=0 && v<n;
        assert w >=0 && w<n;
        g[v].add(w);
        if(v!= w && !directed ){
            g[w].add(v);
        }
        m++;
    }

    boolean hasEdge(int v, int w){
        assert v>=0 && v<n;
        assert w >=0 && w<n;
        for (int i = 0; i < g[v].size(); i++) {
            if (g[v].elementAt(i) == w) {
                return true;
            }
        }
        return false;
    }
    // 显示图的信息
    public void show(){

        for( int i = 0 ; i < n ; i ++ ){
            System.out.print("vertex " + i + ":\t");
            for( int j = 0 ; j < g[i].size() ; j ++ )
                System.out.print(g[i].elementAt(j) + "\t");
            System.out.println();
        }
    }

    // 返回图中一个顶点的所有邻边
    // 由于java使用引用机制，返回一个Vector不会带来额外开销,
    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        return g[v];
    }

    public static void main(String[] args){
        SparseGraph graph = new SparseGraph(7, false);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 6);
        graph.addEdge(2, 3);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.show();
    }
}
