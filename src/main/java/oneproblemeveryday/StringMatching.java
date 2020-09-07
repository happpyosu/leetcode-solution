package oneproblemeveryday;

import java.util.ArrayList;
import java.util.List;

// leetcode 1408
public class StringMatching {

    public static void main(String[] args) {
        StringMatching s = new StringMatching();

        String[] words = {"leetcode","et","code"};

        List<String> matching = s.stringMatching(words);

        System.out.println(matching);


    }


    public List<String> stringMatching(String[] words) {
        List<String> retList = new ArrayList<>();

        for(int i=0; i<words.length; i++){
            for(int j=0; j<words.length; j++){
                if(i != j && words[j].contains(words[i])){
                    retList.add(words[i]);
                    break;
                }
            }
        }
        return retList;
    }

}
