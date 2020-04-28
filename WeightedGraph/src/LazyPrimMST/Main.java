package LazyPrimMST;

/**
 * @author Jiani WANG
 * @create 2020-04-25 11:32
 */
import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        String filename = "testG_w.txt";
        int V = 8;

        SparseGraph<Double> g = new SparseGraph<Double>(V, false);
        ReadWeightedGraph readGraph = new ReadWeightedGraph(g, filename);
        g.show();

        // Test Lazy Prim MST
        System.out.println("Test Lazy Prim MST:");
        LazyPrim<Double> lazyPrimMST = new LazyPrim<Double>(g);
        Vector<Edge<Double>> mst = lazyPrimMST.mstEdges();
        for( int i = 0 ; i < mst.size() ; i ++ )
            System.out.println(mst.elementAt(i));
        System.out.println("The MST weight is: " + lazyPrimMST.result());

        System.out.println();
    }
}

