package BFSTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

/**
 * @author Jiani WANG
 * @create 2020-04-25 9:55
 */
public class ShortPath {
    private Graph G;
    private int s;
    private boolean[] visited;
    private int[] from;
    private int[] order;  //到起点的距离

    public ShortPath(int s, Graph graph){
        assert s>=0 && s< graph.V();
        this.G = graph;
        visited = new boolean[G.V()];
        from = new int[G.V()];
        order = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            visited[i] =false;
            from[i] = -1;
            order[i] = -1;
        }
        //寻路算法
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        visited[s] =true;
        order[s]=0;
        while(!q.isEmpty()){
            int v = q.remove();
            for(int i:G.adj(v)){
                if(!visited[i]){
                    q.add(i);
                    from[i] = v;
                    visited[i] = true;
                    order[i] = order[v]+1;
                }
            }
        }
    }
    boolean hasPath(int w){
        assert w>=0 && w<G.V();
        return visited[w];
    }
    Vector<Integer> path(int w){
        assert hasPath(w);
        Stack<Integer> s = new Stack<Integer>();
        int p = w;
        while(p!=-1){
            s.push(p);
            p = from[p];
        }
        Vector<Integer> res = new Vector<Integer>();
        while(!s.empty()){
            res.add(s.pop());
        }
        return res;
    }
    void showPath(int w){
        assert hasPath(w) ;
        Vector<Integer> vec = path(w);
        for( int i = 0 ; i < vec.size() ; i ++ ){
            System.out.print(vec.elementAt(i));
            if( i == vec.size() - 1 )
                System.out.println();
            else
                System.out.print(" -> ");
        }
    }
    public int length(int w){
        assert w >= 0 && w < G.V();
        return order[w];
    }

}
