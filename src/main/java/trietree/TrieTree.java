package trietree;

public class TrieTree {
    public Node root = new Node();

    public void insert(String s) {
        char[] charArray = s.toCharArray();
        Node cur = root;

        for (char c : charArray) {
            if (cur.dict[c - 'a'] == null) cur.dict[c - 'a'] = new Node();
            cur = cur.dict[c - 'a'];
        }
        cur.word = s;
    }

    public boolean startWith(String prefix){
        char[] charArray = prefix.toCharArray();
        Node cur = root;

        for (char c : charArray) {
            if(cur.dict[c - 'a'] == null) return false;
            cur = cur.dict[c - 'a'];
        }
        return true;
    }
}


class Node{
    public Node[] dict = new Node[26];
    String word;
}
