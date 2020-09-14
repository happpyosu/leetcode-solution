package commonskill;

// 匈牙利问题的解法
public class Hungarian {

    // M, N分别表示左、右侧集合的元素数量
    private int M, N;

    // 邻接图矩阵
    private boolean[][] map;

    // 记录当前右侧元素所对应的左侧元素
    private int[] p;

    // 记录当前右侧元素是不是已经被访问过了
    private boolean[] vis;

    // 尝试去匹配左边图集合中的第i个元素
    private boolean match(int i){
        for(int j=0; j<N; j++){
            if(map[i][j] && !vis[j]){
                vis[j] = true;
                if(p[j] == -1 || match(p[j])){
                    p[j] = i;
                    return true;
                }
            }
        }
        return false;
    }


    public Hungarian(int M, int N, boolean[][] map){
        this.M = M;
        this.N = N;
        this.map = map;
        this.vis = new boolean[N];
        this.p = new int[N];
    }

    public int hungarian(){
        int cnt = 0;
        for(int i=0; i<M; i++){
            if(match(i)) cnt++;
        }

        return cnt;
    }

}
