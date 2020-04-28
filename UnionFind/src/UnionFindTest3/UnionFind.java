package UnionFindTest3;

/**
 * @author Jiani WANG
 * @create 2020-04-23 20:38
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
            rank[i] =1;
        }
    }
    public int Find(int p){
        assert p>=0 && p<count;
        while(p!=parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    public boolean isConnected(int p, int q){
        return Find(p)==Find(q);
    }
    public void Union(int p,int q){
        int pRoot = Find(p);
        int qRoot = Find(q);
        if(pRoot == qRoot){
            return;
        }
        if(rank[pRoot]<rank[qRoot]){
            parent[pRoot] = qRoot;
        }
        else if(rank[qRoot] < rank[pRoot]){
            parent[qRoot] = pRoot;
        }
        else{
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        }
    }

}
