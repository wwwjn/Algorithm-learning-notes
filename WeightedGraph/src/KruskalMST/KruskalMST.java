package KruskalMST;

import java.util.Vector;

/**
 * @author Jiani WANG
 * @create 2020-04-28 9:12
 */
public class KruskalMST<Weight extends Number & Comparable> {
    private Vector<Edge<Weight>> mst;  //最小生成树
    private Number mstWeight;

    public KruskalMST(WeightedGraph graph){
        mst = new Vector<Edge<Weight>>();

        MinHeap<Edge<Weight>> pq = new MinHeap<Edge<Weight>>(graph.E());
        for (int i = 0; i < graph.V(); i++) {
            for(Object item: graph.adj(i)){
                Edge<Weight> e = (Edge<Weight>)item;
                if(e.v() <= e.w()){  //只能处理无向图
                    pq.insert(e);
                }
            }
        }

        UnionFind uf = new UnionFind(graph.V());
        while(!pq.isEmpty() && mst.size() < graph.V()-1 ){
            Edge<Weight> e = pq.extractMin();
            if(uf.isConnected(e.v(),e.w())){
                continue;
            }
            else {
                mst.add(e);
                uf.unionElements(e.v(),e.w());
            }
        }
        // 计算最小生成树的权值
        mstWeight = mst.elementAt(0).wt();
        for( int i = 1 ; i < mst.size() ; i ++ )
            mstWeight = mstWeight.doubleValue() + mst.elementAt(i).wt().doubleValue();

    }
    // 返回最小生成树的所有边
    Vector<Edge<Weight>> mstEdges(){
        return mst;
    }

    // 返回最小生成树的权值
    Number result(){
        return mstWeight;
    }


    // 测试 Kruskal
    public static void main(String[] args) {

        String filename = "testG1w.txt";
        int V = 8;

        SparseGraph<Double> g = new SparseGraph<Double>(V, false);
        ReadWeightedGraph readGraph = new ReadWeightedGraph(g, filename);

        // Test Kruskal
        System.out.println("Test Kruskal:");
        KruskalMST<Double> kruskalMST = new KruskalMST<Double>(g);
        Vector<Edge<Double>> mst = kruskalMST.mstEdges();
        for( int i = 0 ; i < mst.size() ; i ++ )
            System.out.println(mst.elementAt(i));
        System.out.println("The MST weight is: " + kruskalMST.result());

        System.out.println();
    }


}
