package DFSTest;

/**
 * @author Jiani WANG
 * @create 2020-04-24 11:19
 */

// 测试图的联通分量算法
public class Main {

    public static void main(String[] args) {

        // TestG1.txt
        String filename1 = "testG1.txt"; //ReadGraph默认是在工程下面的文件
        SparseGraph g1 = new SparseGraph(13, false);
        ReadGraph readGraph1 = new ReadGraph(g1, filename1);
        Components component1 = new Components(g1);
        System.out.println("TestG1.txt, Component Count: " + component1.count());
        System.out.println();

        // TestG2.txt
        String filename2 = "testG2.txt";
        SparseGraph g2 = new SparseGraph(6, false);
        ReadGraph readGraph2 = new ReadGraph((Graph) g2, filename2);
        Components component2 = new Components((Graph) g2);
        System.out.println("TestG2.txt, Component Count: " + component2.count());
    }
}

