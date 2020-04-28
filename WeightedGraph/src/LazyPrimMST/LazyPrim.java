package LazyPrimMST;

import java.util.Vector;

/**
 * @author Jiani WANG
 * @create 2020-04-27 9:31
 */
public class LazyPrim<Weight extends Number & Comparable> {
    private WeightedGraph<Weight> G;
    private MinHeap<Edge<Weight>> pq;
    private boolean[] marked;
    private Vector<Edge<Weight>> mst;
    private Number mstWeight;

    public LazyPrim(WeightedGraph<Weight> graph){
        G = graph;
        pq = new MinHeap<Edge<Weight>>(G.E());
        marked = new boolean[G.V()];
        mst = new Vector<Edge<Weight>>();


        //LazyPrim
        visit(0);
        while(!pq.isEmpty()){
            Edge<Weight> e = pq.extractMin();
            if(marked[e.v()] == marked[e.w()]){  //如果两端都访问过了
                continue;
            }
            mst.add(e);
            // 访问和这条边连接的还没有被访问过的节点
            if( !marked[e.v()] )
                visit( e.v() );
            else
                visit( e.w() );
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
            if(!marked[e.other(v)]){
                pq.insert(e);
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
