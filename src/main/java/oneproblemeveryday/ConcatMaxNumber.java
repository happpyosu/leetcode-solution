package oneproblemeveryday;

import java.util.Arrays;
import java.util.Stack;

// leetcode 321 拼接最大数
// hard
public class ConcatMaxNumber {

    public static void main(String[] args) {

        ConcatMaxNumber c = new ConcatMaxNumber();

        int[] nums1 = {3, 9};
        int[] nums2 = {8, 9};

        int[] maxNumber = c.maxNumber(nums1, nums2, 3);

        System.out.println(Arrays.toString(maxNumber));


    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

        String maxStr = "0";

        for(int i=0; i<=k; i++){
            int len1 = i; int len2 = k - i;
            if(len1 > nums1.length || len2 > nums2.length) continue;

            String s1 = getMax(nums1, len1);
            String s2 = getMax(nums2, len2);

            String res;

            if(s1.equals("")) res = s2;
            else if(s2.equals("")) res = s1;
            else res = maxMergeTwoString(s1, s2);


            if(res.compareTo(maxStr) > 0){
                maxStr = res;
            }
        }

        int[] arr = new int[k];
        int index = 0;

        while (index < k){
            arr[index] = maxStr.charAt(index) - '0';
            index++;
        }

        return arr;

    }

    // 从nums中取出k个元素，得到最大字典序排序的字符串
    private String getMax(int[] nums, int k){
        Stack<Integer> stack = new Stack<>();
        int d = nums.length - k;
        for(int x : nums){
            while (d > 0 && !stack.isEmpty() && stack.peek() < x){
               stack.pop();
               d--;
            }
            stack.push(x);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        String temp =  sb.reverse().toString().substring(0, k);
        return temp;
    }

    private String maxMergeTwoString(String s1, String s2){
        StringBuilder sb = new StringBuilder();

        StringBuilder sb1 = new StringBuilder(s1);
        StringBuilder sb2 = new StringBuilder(s2);

        while (sb1.length() > 0 && sb2.length() > 0){
            if(sb1.toString().compareTo(sb2.toString()) > 0){
                sb.append(sb1.charAt(0));
                sb1.deleteCharAt(0);
            }else {
                sb.append(sb2.charAt(0));
                sb2.deleteCharAt(0);
            }
        }

        if(sb1.length() > 0) sb.append(sb1);
        else sb.append(sb2);

        return sb.toString();

    }

}
