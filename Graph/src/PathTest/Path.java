package PathTest;

import java.util.Stack;
import java.util.Vector;

/**
 * @author Jiani WANG
 * @create 2020-04-24 11:40
 */
public class Path {
    private Graph G;
    private int s;  //起点
    private boolean[] visited;
    private int[] from;

    public Path(Graph G, int s){
        this.G = G;
        assert s>=0 && s<G.V();
        visited = new boolean[G.V()];
        from = new int[G.V()];
        for (int i = 0; i <G.V() ; i++) {
            from[i] =-1;
            visited[i] = false;
        }
        this.s = s;
        dfs(s);  //寻找从s点到其他点的路径
    }
    private void dfs(int v){
        assert v>=0 && v<G.V();
        visited[v] = true;
        for(int i: G.adj(v)){
            if(!visited[i]){
                from[i] = v;
                dfs(i);
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
    public void showPath(int w){
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
}
