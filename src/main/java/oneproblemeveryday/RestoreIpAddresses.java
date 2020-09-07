package oneproblemeveryday;

import java.util.ArrayList;
import java.util.List;

// leetcode93 复原IP地址
public class RestoreIpAddresses {

    public static void main(String[] args) {
        RestoreIpAddresses r = new RestoreIpAddresses();
        String testStr = "100000";
        List<String> strings = r.restoreIpAddresses(testStr);
        System.out.println(strings);
    }


    public List<String> restoreIpAddresses(String s) {
        dfs(s, 4, new StringBuilder());
        return list;
    }

    List<String> list = new ArrayList<>();

    private void dfs(String remain, int remainDots, StringBuilder sb){
        if(remain.length() == 0 && remainDots == 0) {
            list.add(sb.deleteCharAt(sb.length() - 1).toString());
            return;
        }
        if(remainDots == 0) return;
        if(remainDots > 0 && remain.length() == 0) return;

        if(remain.charAt(0) == '0'){
            String cut = remain.substring(0, 1);
            String left = remain.substring(1);
            StringBuilder builder = new StringBuilder(sb);
            builder.append(cut).append('.');
            dfs(left, remainDots - 1, builder);
        }
        else {
            for(int i=0; i <= 2 && i < remain.length(); i++){
                String cut = remain.substring(0, i+1);
                String left = remain.substring(i+1);

                if(Integer.parseInt(cut) <= 255){
                    StringBuilder builder = new StringBuilder(sb);
                    builder.append(cut).append('.');
                    dfs(left, remainDots - 1, builder);
                }
            }
        }

    }



}
