package trietree;

import java.util.*;

public class WordDragon {

    public static void main(String[] args) {
        WordDragon w = new WordDragon();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        String[] wordListArray = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        Collections.addAll(wordList, wordListArray);

        int length = w.ladderLength(beginWord, endWord, wordList);
        System.out.println(length );
    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(wordList.size() == 0 || !wordList.contains(endWord)) return 0;

        wordSet.remove(beginWord);

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int wordLen = beginWord.length();
        int step = 1;

        queue.add(beginWord);

        while (!queue.isEmpty()){
            int currentSize = queue.size();   //按层遍历可以先记录当前层的数量
            for (int i=0; i<currentSize; i++){
                String word = queue.poll();
                char[] charArray = word.toCharArray();

                for(int j=0; j<wordLen; j++){
                    char originChar = charArray[j];

                    for (char k ='a'; k <= 'z'; k++){
                        if(k == originChar) continue;
                        charArray[j] = k;
                        String nextWord = String.valueOf(charArray);

                        if(wordSet.contains(nextWord)){
                            if(nextWord.equals(endWord)){
                                return step + 1;
                            }

                            if(!visited.contains(nextWord)){
                                queue.add(nextWord);
                                visited.add(nextWord);
                            }
                        }
                    }

                    charArray[j] = originChar;
                }
            }
            step++;
        }

        return 0;

    }

}
