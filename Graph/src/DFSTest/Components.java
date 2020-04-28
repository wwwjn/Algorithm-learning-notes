package DFSTest;

/**
 * @author Jiani WANG
 * @create 2020-04-24 10:25
 */
public class Components {
    private Graph g; //用接口来声明对象
    private boolean[] isVisited;  //该节点是否被访问过
    private int[] id;  //每个结点属于哪个连通分量
    private int ccount;  //联通分量个数

    public void dfs(int v){  //从v开始
        isVisited[v] = true;
        id[v] = ccount;
        for(int i: g.adj(v)){
            if(!isVisited[i]){
                dfs(i);
            }
        }
    }

    public Components(Graph graph){
        g = graph;
        isVisited = new boolean[g.V()];
        id = new int[g.V()];
        ccount = 0;
        for (int i = 0; i < g.V() ; i++) {
            isVisited[i] = false;
            id[i] = -1;
        }
        for (int i = 0; i < g.V(); i++) {
            if(!isVisited[i]){
                dfs(i);
                ccount++;
            }
        }
    }
    public int count(){
        return ccount;
    }

    public boolean isConnected(int v, int w){
        assert v>=0 && v< g.V();
        assert w >=0 && w<g.V();
        return id[v] == id[w];
    }

}
