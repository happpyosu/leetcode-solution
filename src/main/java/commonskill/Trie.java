package commonskill;

public class Trie {

    public static class TrieNode {
        // 下一个前缀树的节点
        public TrieNode[] children = new TrieNode[26];

        // 是否到达了一个单词的结尾
        public boolean isWordEnd = false;

        // 如果已经到达了一个单词的结尾，则更新这个单词
        public String str;
    }

    // ----------------------------------------------------

    public TrieNode root = new TrieNode();

    // 将一个单词正序插入前缀树
    public void insert(String s) {
        char[] charArray = s.toCharArray();
        TrieNode p = root;

        for (char c : charArray) {
            if (p.children[c - 'a'] == null) p.children[c - 'a'] = new TrieNode();
            p = p.children[c - 'a'];
        }

        p.str = s;
        p.isWordEnd = true;
    }

    // 将一个单词倒序插入前缀树
    public void reverseInsert(String s) {
        char[] charArray = new StringBuilder(s).reverse().toString().toCharArray();
        TrieNode p = root;

        for (char c : charArray) {
            if (p.children[c - 'a'] == null) p.children[c - 'a'] = new TrieNode();
            p = p.children[c - 'a'];
        }

        p.str = s;
        p.isWordEnd = true;
    }

    // 查询一个单词是不是在前缀树中
    public boolean search(String word) {
        char[] charArray = word.toCharArray();
        TrieNode p = root;
        for (char c : charArray) {
            if (p.children[c - 'a'] != null) p = p.children[c - 'a'];
            else return false;
        }
        return p.isWordEnd;
    }

    public boolean startsWith(String prefix) {
        char[] charArray = prefix.toCharArray();
        TrieNode p = root;
        for (char c : charArray) {
            if (p.children[c - 'a'] != null) p = p.children[c - 'a'];
            else return false;
        }
        return true;
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("playground");
        trie.insert("play");

        System.out.println(trie.search("hello"));
        System.out.println(trie.search("playground"));

    }


}