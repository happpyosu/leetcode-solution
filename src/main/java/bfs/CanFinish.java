package bfs;

import java.util.*;

//207. 课程表
public class CanFinish {

    public static void main(String[] args) {
        CanFinish c = new CanFinish();
        int[][] pre = {
                {1, 0}, {0, 1}
        };

        boolean b = c.canFinish(2, pre);
        System.out.println(b);
    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer>[] setList = new Set[numCourses];

        for(int i=0; i<setList.length; i++) setList[i] = new HashSet<Integer>();

        for (int[] prerequisite : prerequisites) setList[prerequisite[0]].add(prerequisite[1]);

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<setList.length; i++){
            if(setList[i].size() == 0) {
                queue.add(i);
                setList[i] = null;
            }
        }

        while (!queue.isEmpty()){
            int courseIndex = queue.poll();
            for (Set<Integer> set : setList) {
                if (set != null) {
                    set.remove(courseIndex);
                }
            }
            for(int i=0; i<setList.length; i++){
                if(setList[i] != null && setList[i].size() == 0) {
                    queue.add(i);
                    setList[i] = null;
                }
            }
        }

        for (Set<Integer> set : setList) {
            if (set != null) return false;
        }

        return true;
    }

}
