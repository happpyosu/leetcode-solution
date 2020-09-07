package unionfindset;

// 2、带合并路径的并查集写法
public class OptUFS extends UFS{

    // 1、优化点1：用rank数组记录节点i的最大
    protected int[] rank = new int[MAXN];

    public static void main(String[] args) {
    }


    @Override
    public int find(int x) {
        if(fa[x] == x) return x;
        else {
            fa[x] = find(fa[x]);  //把fa
            return fa[x];
        }
    }

    @Override
    public void merge(int i, int j) {
        int x = find(i); int y = find(j);
        if(rank[x] <= rank[y]) fa[x] = y;
        else fa[y] = x;  //把较矮的树挂到高的树根上，较高的树根的rank保持不变

        if(rank[x] == rank[y] && x != y) rank[y]++;

    }
}
