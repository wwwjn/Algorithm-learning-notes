package LazyPrimMST;

import java.util.Vector;

/**
 * @author Jiani WANG
 * @create 2020-04-25 10:46
 */
public class DenseGraph<W extends Number & Comparable> implements WeightedGraph<W> {
    private int n;
    private int m;
    private boolean directed; //定向的
    private Edge<W>[][] g; //邻接矩阵表示一张图

    public DenseGraph(int n, boolean directed){
        this.n = n;
        this.m = 0;
        this.directed = directed;
        this.g = new Edge[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j]=null;
            }
        }
    }

    @Override
    public int V() {
        return n;
    }

    @Override
    public int E() {
        return m;
    }

    @Override
    public void addEdge(Edge e) {
        assert e.v() >=0 && e.v() < n;
        assert e.w() >=0 && e.v() < n;
        if(hasEdge(e.v(),e.w()))
            return;
        g[e.v()][e.w()] = new Edge<W>(e);
        if(e.v()!=e.w() && !directed){
            //无向图的话需要在矩阵中添加两个边
            g[e.w()][e.v()] = new Edge<W>(e);
        }
        m++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n ;
        assert w >= 0 && w < n ;
        return g[v][w] != null;
    }

    @Override
    public void show() {
        for( int i = 0 ; i < n ; i ++ ){
            for( int j = 0 ; j < n ; j ++ )
                if( g[i][j] != null )
                    System.out.print(g[i][j].wt()+"\t");
                else
                    System.out.print("NULL\t");
            System.out.println();
        }
    }

    @Override
    public Iterable<Edge<W>> adj(int v) {
        assert v>=0 && v<n;
        Vector<Edge<W>> adjV = new Vector<Edge<W>>();
        for (int i = 0; i < n; i++) {
            if(g[v][i]!=null){
                adjV.add(g[v][i]);
            }
        }
        return adjV;
    }
}
