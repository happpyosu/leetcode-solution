package dfs;

// 解码方式
// leetcode 91
public class NumDecodings {

    public static void main(String[] args) {
        NumDecodings n = new NumDecodings();
        int numDecodings = n.numDecodings("2260");
        System.out.println(numDecodings);
    }

    public int numDecodings(String s) {
        dfs(s, 0);
        return count;
    }


    private int count = 0;

    private void dfs(String s, int start){
        if(start >= s.length()){
            count++;
            return;
        }

        int i = start; int j = i + 1;

        if(s.charAt(i) == '0') return;

        dfs(s, i+1);

        if(j < s.length()){
            if(s.charAt(j) == '0') {
                if(s.charAt(i) >= '1' && s.charAt(i) <= '2') dfs(s, j+1);
            }else {
                if(s.charAt(i) > '0' && s.charAt(i) <= '2'){
                    String tmp = "" + s.charAt(i) + s.charAt(j);
                    if(Integer.parseInt(tmp) <= 26) dfs(s, j+1);
                }
            }
        }

    }


}
