package UnionFindTest3;

/**
 * @author Jiani WANG
 * @create 2020-04-23 20:10
 */
public class QuickFind {
    private int[] id;
    private int count;
    public QuickFind(int n){
        count =n;
        id = new int[n];
        for (int i =0;i<n;i++){
            id[i]=i;
        }
    }
    public int Find(int p){
        assert p>=0 && p<count;
        return id[p];
    }
    public boolean isConnected(int p, int q) {
        assert p>=0 && p < count;
        assert q>=0 && q < count;
        if(id[p]==id[q])
            return true;
        else
            return false;
    }
    public void Union(int p, int q){
        assert p>=0 && p < count;
        assert q>=0 && q < count;
        if (id[p]==id[q]){
            return;
        }
        else{
            int pID = id[p];
            int qID = id[q];
            for (int i = 0; i < count; i++) {
                if(id[i]==pID)
                    id[i] = qID;
            }
        }
    }
}
