package PrimMST;

import KruskalMST.LazyPrim;
import KruskalMST.Prim;
import KruskalMST.ReadWeightedGraph;
import KruskalMST.SparseGraph;

/**
 * @author Jiani WANG
 * @create 2020-04-25 11:32
 */

public class Main {

    // 测试我们实现的两种Prim算法的性能差距
    // 可以看出这一节使用索引堆实现的Prim算法优于上一小节的Lazy Prim算法
    public static void main(String[] args) {

        String filename1 = "testG1w.txt";
        int V1 = 8;

        String filename2 = "testG2w.txt";
        int V2 = 250;

        String filename3 = "testG3w.txt";
        int V3 = 1000;

        String filename4 = "testG4w.txt";
        int V4 = 10000;

        //String filename5 = "testG5.txt";
        //int V5 = 1000000;


        // 文件读取
        SparseGraph<Double> g1 = new SparseGraph<Double>(V1, false);
        ReadWeightedGraph readGraph1 = new ReadWeightedGraph(g1, filename1);
        System.out.println( filename1 + " load successfully.");

        SparseGraph<Double> g2 = new SparseGraph<Double>(V2, false);
        ReadWeightedGraph readGraph2 = new ReadWeightedGraph(g2, filename2);
        System.out.println( filename2 + " load successfully.");

        SparseGraph<Double> g3 = new SparseGraph<Double>(V3, false);
        ReadWeightedGraph readGraph3 = new ReadWeightedGraph(g3, filename3);
        System.out.println( filename3 + " load successfully.");

        SparseGraph<Double> g4 = new SparseGraph<Double>(V4, false);
        ReadWeightedGraph readGraph4 = new ReadWeightedGraph(g4, filename4);
        System.out.println( filename4 + " load successfully.");

//        SparseWeightedGraph<Double> g5 = new SparseWeightedGraph<Double>(V5, false);
//        ReadWeightedGraph readGraph5 = new ReadWeightedGraph(g5, filename5);
//        System.out.println( filename5 + " load successfully.");

        System.out.println();


        long startTime, endTime;

        // Test Lazy Prim MST
        System.out.println("Test Lazy Prim MST:");

        startTime = System.currentTimeMillis();
        LazyPrim<Double> lazyPrimMST1 = new LazyPrim<Double>(g1);
        endTime = System.currentTimeMillis();
        System.out.println("Test for G1: " + (endTime-startTime) + "ms.");

        startTime = System.currentTimeMillis();
        LazyPrim<Double> lazyPrimMST2 = new LazyPrim<Double>(g2);
        endTime = System.currentTimeMillis();
        System.out.println("Test for G2: " + (endTime-startTime) + "ms.");

        startTime = System.currentTimeMillis();
        LazyPrim<Double> lazyPrimMST3 = new LazyPrim<Double>(g3);
        endTime = System.currentTimeMillis();
        System.out.println("Test for G3: " + (endTime-startTime) + "ms.");

        startTime = System.currentTimeMillis();
        LazyPrim<Double> lazyPrimMST4 = new LazyPrim<Double>(g4);
        endTime = System.currentTimeMillis();
        System.out.println("Test for G4: " + (endTime-startTime) + "ms.");

//        startTime = System.currentTimeMillis();
//        LazyPrimMST<Double> lazyPrimMST5 = new LazyPrimMST<Double>(g5);
//        endTime = System.currentTimeMillis();
//        System.out.println("Test for G5: " + (endTime-startTime) + "ms.");

        System.out.println();


        // Test Prim MST
        System.out.println("Test Prim MST:");

        startTime = System.currentTimeMillis();
        Prim<Double> primMST1 = new Prim<Double>(g1);
        endTime = System.currentTimeMillis();
        System.out.println("Test for G1: " + (endTime-startTime) + "ms.");

        startTime = System.currentTimeMillis();
        Prim<Double> primMST2 = new Prim<Double>(g2);
        endTime = System.currentTimeMillis();
        System.out.println("Test for G2: " + (endTime-startTime) + "ms.");

        startTime = System.currentTimeMillis();
        Prim<Double> primMST3 = new Prim<Double>(g3);
        endTime = System.currentTimeMillis();
        System.out.println("Test for G3: " + (endTime-startTime) + "ms.");

        startTime = System.currentTimeMillis();
        Prim<Double> primMST4 = new Prim<Double>(g4);
        endTime = System.currentTimeMillis();
        System.out.println("Test for G4: " + (endTime-startTime) + "ms.");

//        startTime = System.currentTimeMillis();
//        PrimMST<Double> primMST5 = new PrimMST<Double>(g5);
//        endTime = System.currentTimeMillis();
//        System.out.println("Test for G5: " + (endTime-startTime) + "ms.");

        System.out.println();
    }
}
