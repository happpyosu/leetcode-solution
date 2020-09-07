package dp;

import commonskill.Trie;
import datastruct.TreeNode;

// 17.13 恢复空格
// todo
public class RecoverSpace {

    public static void main(String[] args) {
        RecoverSpace r = new RecoverSpace();
        String[] dict = {"looked","just","like","her","brother"};
        int i = r.respace(dict, "jesslookedjustliketimherbrother");
        System.out.println(i);
    }

    public int respace(String[] dictionary, String sentence) {
        Trie trie = new Trie();
        for (String word : dictionary) {
            trie.reverseInsert(word);
        }

        int[] dp = new int[sentence.length() + 1];
        dp[0] = 0;

        for(int i=1; i<dp.length; i++){
            dp[i] = dp[i-1] + 1;
             Trie.TrieNode p  = trie.root;
             int j = i;
             while (j - 1 >= 0 && p.children[sentence.charAt(j - 1) - 'a'] != null){
                 p = p.children[sentence.charAt(j-1) - 'a'];
                 if(p.isWordEnd) dp[i] = Math.min(dp[i], dp[j-1]);
                 j--;
             }
        }
        return dp[dp.length - 1];
    }
}
