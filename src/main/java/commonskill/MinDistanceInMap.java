package commonskill;

public class MinDistanceInMap {


    private static int[][] testMap;

    private  static final int inf = 65535;

    static {

        testMap = new int[][]{
                {0, 2, 6, 4},
                {inf, 0, 3, inf},
                {7, inf, 0, 1},
                {5, inf, 12, 0}
        };

    }



    public static int floyd(int[][] map, int start, int end){
        int n = map.length;
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(map[i][k] + map[k][j] < map[i][j]){
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
        return map[start][end];
    }

    public static int dijkstra(int[][] map, int start, int end){

        int n = map.length;

        boolean[] visited = new boolean[n];
        int[] distance = new int[n];

        for(int i=0; i<n; i++) visited[i] = (i==start);
        for(int i=0; i<n; i++) distance[i] = map[start][i];

        for(int i=0; i<n; i++){

            // 1、找到一个没有访问过的节点index且start -> index是distance数组中最小的那个节点
            int index = -1; int min = inf;
            for(int k=0; k<n; k++){
                if(!visited[k] && distance[k] < min) {
                    index = k;
                    min = distance[k];
                }
            }

            // 2、将找到的那个最小节点放入已访问的集合中
            if(index != -1) visited[index] = true;

            // 3、更新distance数组，看一下以index节点为中转的方案是不是好于当前方案
            for(int j=0; j<n; j++){
                if(!visited[j] && map[index][j] != inf && min + map[index][j] < distance[j]){
                    distance[j] = min + map[index][j];
                }
            }
        }

        return distance[end];
    }


    public static void main(String[] args) {
        int min = MinDistanceInMap.dijkstra(MinDistanceInMap.testMap, 3, 3);
        System.out.println(min);
    }


}
