package others;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strArr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams g = new GroupAnagrams();
        List<List<String>> list = g.groupAnagrams(strArr);

        for (List<String> strings : list) {
            System.out.println(strings);
        }


    }


    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Map<Character, Integer>, List<String>> map = new HashMap<>();

        for (String str : strs) {
            Map<Character, Integer> m = getMap(str);
            if (!map.containsKey(m)) {
                map.put(m, new ArrayList<>());
            }
            map.get(m).add(str);
        }

        return new ArrayList<>(map.values());
    }

    private Map<Character, Integer> getMap(String s){
        char[] array = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : array) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return map;
    }




}
