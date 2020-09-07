package greedy;

import java.util.Arrays;

public class VideoStitching {

    public static void main(String[] args) {
        int[][] clips = {
                {0,2}, {4,6}, {8,10}, {1,9}, {1,5}, {5,9}
        };

        VideoStitching v = new VideoStitching();
        int i = v.videoStitching(clips, 10);
        System.out.println(i);

    }


    public int videoStitching(int[][] clips, int T) {

        Arrays.sort(clips, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        if(clips[0][0] != 0) return -1;

        int i = 0, t = clips[0][1], count = 1;
        while (t < T){
            int maxT = t;
            while (i+1 < clips.length && clips[i+1][0] <= t){
                if(clips[i+1][1] > maxT) maxT = clips[++i][1];
                else ++i;
            }
            if(maxT == t){ //已经无法继续推进了
                break;
            }
            t = maxT;
            count++;
        }

        return t >= T ? count : -1;
    }

}
