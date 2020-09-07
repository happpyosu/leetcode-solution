package oneproblemeveryday;

import java.util.HashSet;
import java.util.Set;

// day0802
// 翻转卡片游戏
public class FlipCardGame {

    public static void main(String[] args) {
        FlipCardGame f = new FlipCardGame();

        int[] fronts = {1,2};
        int[] backs = {2,1};
        int minCard = f.flipGame(fronts, backs);

        System.out.println(minCard);
    }


    public int flipGame(int[] fronts, int[] backs) {
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<fronts.length; i++){

            int f = fronts[i];
            int b = backs[i];

            if(f != b){
                set.add(f);
                set.add(b);
            }


        }

        int minCard = Integer.MAX_VALUE;
        for(int card : set){
            for(int i=0; i<fronts.length; i++){
                if(fronts[i] == card) flipOneCard(fronts, backs, i);
            }
            boolean flag = true;

            for (int front : fronts) {
                if (front == card) {
                    flag = false;
                    break;
                }
            }

            if(flag){
                minCard = Math.min(minCard, card);
            }
        }

        if(minCard == Integer.MAX_VALUE) return 0;
        return minCard;
    }

    private void flipOneCard(int[] fronts, int[] backs, int index){
        int temp = fronts[index];
        fronts[index] = backs[index];
        backs[index] = temp;

    }

}
