package oneproblemeveryday;

import java.util.ArrayList;
import java.util.List;

public class SplitIntoFibonacci {

    public static void main(String[] args) {
        SplitIntoFibonacci s = new SplitIntoFibonacci();

        String test1 = "539834657215398346785398346991079669377161950407626991734534318677529701785098211336528511";
        List<Integer> list = s.splitIntoFibonacci(test1);

        System.out.println(list);

    }


    public List<Integer> splitIntoFibonacci(String S) {
        for(int i=0; i<S.length() - 2; i++){
            for(int j=i+1; j<S.length() - 1; j++){
                String s1 = S.substring(0, i+1);
                String s2 = S.substring(i+1, j+1);

                if(s1.charAt(0) == '0' && s1.length() > 1) continue;
                if(s2.charAt(0) == '0' && s2.length() > 1) continue;

                long num1 = Long.parseLong(s1);
                long num2 = Long.parseLong(s2);

                if(num1 > Integer.MAX_VALUE) return new ArrayList<>();
                if(num2 > Integer.MAX_VALUE) break;

                List<Integer> temp = new ArrayList<>();

                dfs(S.substring(j+1), temp, num1, num2);

                if(list != null) {
                    temp.add(0, (int) num2);
                    temp.add(0, (int) num1);
                    return list;
                }

            }
        }

        return new ArrayList<>();
    }

    private List<Integer> list = null;

    private void dfs(String left, List<Integer> list, long num1, long num2){
        long sum = num1 + num2;

        if(sum > Integer.MAX_VALUE) return;

        String sumStr = String.valueOf(sum);

        if(left.startsWith(sumStr)){
            left = left.replaceFirst(sumStr, "");
            list.add((int) sum);
            if(left.length() == 0){
                this.list = list;
                return;
            }
            dfs(left, list, num2, sum);
        }
    }


}
