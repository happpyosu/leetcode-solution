package others;

import java.util.Arrays;

// leetcode 179
// 最大数
// todo
public class LargestNumber {

    public static void main(String[] args) {
        LargestNumber l = new LargestNumber();
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(l.largestNumber(nums));
    }

    public String largestNumber(int[] nums) {
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, (o1, o2) -> {
            String s1 = o1 + String.valueOf(o2);
            String s2 = o2 + String.valueOf(o1);
            return s2.compareTo(s1);
        });

        StringBuilder sb = new StringBuilder();

        for (Integer integer : arr) {
            sb.append(integer);
        }

        return sb.toString();
    }

    public String largestNumber2(int[] nums) {
        String[] arr = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        Arrays.sort(arr, ((o1, o2) -> {
            String s1 = o1 + o2;
            String s2 = o2 + o1;
            return s2.compareTo(s1);
        }));

        StringBuilder sb = new StringBuilder();

        for (String s : arr) {
            sb.append(s);
        }

        if(sb.charAt(0) == '0') return "0";
        return sb.toString();


    }

}
