package LazyPrimMST;

/**
 * @author Jiani WANG
 * @create 2020-04-25 10:41
 */
public class Edge <W extends Number & Comparable> implements Comparable<Edge>{
    int a,b;
    W weight;
    public Edge(int a, int b, W weight){
        this.a = a;
        this.b = b;
        this.weight = weight;
    }
    public Edge(Edge<W> e)
    {
        this.a = e.a;
        this.b = e.b;
        this.weight = e.weight;
    }

    public int v(){ return a;} // 返回第一个顶点
    public int w(){ return b;} // 返回第二个顶点
    public W wt(){ return weight;}    // 返回权值

    int other(int x){
        assert x==a || x==b;
        return x==a? b:a;
    }
    public String toString(){
        return "" + a + "-" + b + ": " + weight;
    }

    @Override
    public int compareTo(Edge that) {
        if(weight.compareTo(that.wt())<0)
            return -1;
        else if(weight.compareTo(that.wt())==0)
            return 0;
        else
            return 1;
    }
}
