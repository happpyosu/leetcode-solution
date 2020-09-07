package dfs;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static void main(String[] args) {
        GenerateParenthesis g = new GenerateParenthesis();
        List<String> list = g.generateParenthesis(4);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public List<String> generateParenthesis(int n) {
        if(n <= 0) return list;
        gen(new StringBuilder(), n, 0, 0);

        return list;
    }

    private final List<String> list = new ArrayList<>();

    private void gen(StringBuilder sb, int n, int left, int right){
        if(left > n || right > n) return;

        if(left == n && right == n) {
            list.add(sb.toString());
            return;
        }

        if(left < n){
            sb.append('(');
            gen(sb, n, left+1, right);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(right < n && right < left){
            sb.append(')');
            gen(sb, n, left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

}
