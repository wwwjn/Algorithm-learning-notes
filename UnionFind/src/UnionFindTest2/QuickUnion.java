package UnionFindTest2;

import UnionFindTest.QuickFind;

/**
 * @author Jiani WANG
 * @create 2020-04-23 20:26
 */
public class QuickUnion {
    private int count;
    private int[] parent;

    public QuickUnion(int n){
        parent = new int[n];
        this.count = n;
        for (int i = 0; i < n ; i++) {
            parent[i] = i;
        }
    }
    public int Find(int p){
        assert p>=0 && p<count;
        while(parent[p]!=p){
            p = parent[p];
        }
        return p;
    }
    public boolean isConnected(int p, int q){
        return Find(p) == Find(q);
    }
    public void Union(int p, int q){
        int pRoot = Find(p);
        int qRoot = Find(q);
        if(pRoot!=qRoot){
            parent[pRoot] = qRoot;
        }
    }
}
