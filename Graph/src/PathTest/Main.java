package PathTest;

/**
 * @author Jiani WANG
 * @create 2020-04-24 11:19
 */

// 测试图的联通分量算法
public class Main {
    // 测试寻路算法
    public static void main(String[] args) {
        String filename = "testG.txt";
        SparseGraph g = new SparseGraph(7, false);
        ReadGraph readGraph = new ReadGraph(g, filename);
        g.show();
        System.out.println();

        Path path = new Path(g,0);
        System.out.println("Path from 0 to 6 : ");
        path.showPath(6);
    }
}

