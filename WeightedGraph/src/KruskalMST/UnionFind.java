package KruskalMST;

/**
 * @author Jiani WANG
 * @create 2020-04-28 9:14
 */
public class UnionFind {
    private int[] rank;
    private int[] parent;
    private int count;

    public UnionFind(int count){
        rank = new int[count];
        parent = new int[count];
        this.count = count;
        for (int i = 0; i < count; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }
    int find(int p){
        while(p!=parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p; //找到的是p结点所属的根
    }
    boolean isConnected(int p, int q){
        return find(p) == find(q);
    }
    void unionElements(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot){
            return;
        }
        if(rank[pRoot]<rank[qRoot]){
            parent[pRoot] = qRoot;
        }
        else if(rank[pRoot]>rank[qRoot]){
            parent[qRoot] = pRoot;
        }
        else{
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        }
    }
}
