package KruskalMST;

import java.util.Vector;

/**
 * @author Jiani WANG
 * @create 2020-04-27 9:31
 */
public class Prim<Weight extends Number & Comparable> {
    private WeightedGraph<Weight> G;
    private IndexMinHeap<Weight> ipq;
    private Edge<Weight>[] EdgeTo; // 访问的点所对应的边, 算法辅助数据结构
    private boolean[] marked;
    private Vector<Edge<Weight>> mst;
    private Number mstWeight;

    public Prim(WeightedGraph<Weight> graph){
        G = graph;
        ipq = new IndexMinHeap<Weight>(G.E());
        marked = new boolean[G.V()];
        EdgeTo = new Edge[G.V()];
        for (int i = 0; i < G.V() ; i++) {
            EdgeTo[i] = null;
            marked[i] = false;
        }
        mst = new Vector<Edge<Weight>>();
        //Prim
        visit(0);
        while(!ipq.isEmpty()){
            int v = ipq.extractMinIndex();
            assert EdgeTo[v] != null;
            mst.add(EdgeTo[v]);
            // 访问和这条边连接的还没有被访问过的节点
            visit(v);
        }
        // 计算最小生成树的权值
        mstWeight = mst.elementAt(0).wt();
        for( int i = 1 ; i < mst.size() ; i ++ )
            mstWeight = mstWeight.doubleValue() + mst.elementAt(i).wt().doubleValue();

    }
    //访问结点v
    private void visit(int v){
        assert !marked[v];
        marked[v] = true;
        for(Edge<Weight> e: G.adj(v)){
            int w = e.other(v);
            if(!marked[w]){
                if(EdgeTo[w]==null){
                    EdgeTo[w] = e;
                    ipq.insert(w,e.wt());
                }
                else if(EdgeTo[w].wt().compareTo(e.wt())>0){
                    EdgeTo[w] = e;
                    ipq.change(w,e.wt());
                }
            }
        }
    }
    // 返回最小生成树的所有边
    Vector<Edge<Weight>> mstEdges(){
        return mst;
    };

    // 返回最小生成树的权值
    Number result(){
        return mstWeight;
    };


}
