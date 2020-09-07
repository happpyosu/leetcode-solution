package trietree;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

    private List<String> retList = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        TrieTree trieTree = new TrieTree();

        for (String word : words) {
            if(!trieTree.startWith(word)) {
                trieTree.insert(word);
            }
        }

        int rows = board.length;
        int cols = board[0].length;

        for(int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                recur(board, i, j, trieTree.root);
            }
        }

        return retList;

    }

    private void recur(char[][] board, int row, int col, Node node){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) return;

        char c = board[row][col];

        if(c == '#' || node.dict[c - 'a'] == null) return;
        Node cur = node.dict[c - 'a'];
        if(cur.word != null){
            retList.add(cur.word);
            cur.word = null; //防止重复添加，或者用set也可以避免重复添加
        }

        board[row][col] = '#';  // todo 注意标记走过的路径
        recur(board, row-1, col, cur);
        recur(board, row+1, col, cur);
        recur(board, row, col-1, cur);
        recur(board, row, col+1, cur);
        board[row][col] = c;

    }

}
