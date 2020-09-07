package unionfindset;

// 标准并查集写法
public class UFS {

    protected static final int MAXN = 1000;

    protected int[] fa = new int[MAXN];

    //1、初始化并查集，每个元素的根节点都为自己
    public void init(int n){
        for(int i=1; i<=n; i++) fa[i] = i;
    }

    //2、查询x的根节点
    public int find(int x){
        if(fa[x] == x) return x;  //表示已经找到根节点了
        else return find(fa[x]);  //沿着节点继续往上查找
    }

    //3、合并i所在的集合到j
    public void merge(int i, int j){
        fa[find(i)] = find(j);
    }
}
