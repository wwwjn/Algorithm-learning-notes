package BFSTest;

/**
 * @author Jiani WANG
 * @create 2020-04-25 10:31
 */
public class Main {
    public static void main(String[] args) {
        String filename = "testG.txt";
        Graph g = new SparseGraph(7, false);
        ReadGraph readGraph = new ReadGraph(g, filename);
        g.show();

        // 比较使用深度优先遍历和广度优先遍历获得路径的不同
        // 广度优先遍历获得的是无权图的最短路径
        Path dfs = new Path(g,0);
        System.out.print("DFS : ");
        dfs.showPath(6);

        ShortPath bfs = new ShortPath(0,g);
        System.out.print("BFS : ");
        bfs.showPath(6);

        System.out.println();

        filename = "testG1.txt";
        SparseGraph g2 = new SparseGraph(13, false);
        ReadGraph readGraph2 = new ReadGraph(g2, filename);
        g2.show();

        // 比较使用深度优先遍历和广度优先遍历获得路径的不同
        // 广度优先遍历获得的是无权图的最短路径
        Path dfs2 = new Path(g2,0);
        System.out.print("DFS : ");
        dfs2.showPath(3);

        ShortPath bfs2 = new ShortPath(0,g);
        System.out.print("BFS : ");
        bfs.showPath(3);
    }
}
