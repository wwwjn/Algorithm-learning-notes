package BFSTest;

import java.util.Vector;

/**
 * @author Jiani WANG
 * @create 2020-04-23 22:59
 */
public class DenseGraph implements Graph {
    private int n,m;
    private Boolean directed;
    private Boolean[][] g; //邻接矩阵

    public DenseGraph(int n, boolean directed){
        assert n>= 0;
        this.n = n; //矩阵为n*n
        this.m = 0;  //边的个数
        g = new Boolean[n][n];
    }
    public int V(){  //节点个数
        return n;
    }
    public int E(){  //边的个数
        return m;
    }

    public void addEdge(int v, int w) {  // 起点是顶点v，重点是w
        assert v>=0 && v<n;
        assert w>=0 && w<n;
        if(hasEdge(v,w)){
            return;
        }
        g[v][w] = true;
        if(!directed){
            g[w][v] = true;
        }
        m++;
    }
    public boolean hasEdge(int v, int w){
        assert v >= 0 && v < n ;
        assert w >= 0 && w < n ;
        return g[v][w];
    }
    // 显示图的信息
    public void show(){

        for( int i = 0 ; i < n ; i ++ ){
            for( int j = 0 ; j < n ; j ++ )
                System.out.print(g[i][j]+"\t");
            System.out.println();
        }
    }

    // 返回图中一个顶点的所有邻边
    // 由于java使用引用机制，返回一个Vector不会带来额外开销,
    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        Vector<Integer> adjV = new Vector<Integer>();
        for(int i = 0 ; i < n ; i ++ )
            if( g[v][i] )
                adjV.add(i);
        return adjV;
    }
}
