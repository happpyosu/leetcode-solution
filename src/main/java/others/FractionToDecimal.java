package others;

import java.util.HashMap;
import java.util.Map;

//给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
//
//如果小数部分为循环小数，则将循环的部分括在括号内。
//todo
// 处理大数
// 处理正负号
public class FractionToDecimal {


    public static void main(String[] args) {
        FractionToDecimal f = new FractionToDecimal();
        f.fractionToDecimal(10, 3);
    }

    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";

        StringBuilder sb = new StringBuilder();
        if(numerator < 0 ^ denominator < 0) sb.append("-");

        long num = Math.abs(Long.valueOf(numerator));
        long den = Math.abs(Long.valueOf(denominator));

        sb.append(String.valueOf(num / den));
        long remain = num % den;

        if(remain == 0) return sb.toString();

        sb.append('.');
        Map<Long, Integer> map = new HashMap<>();
        while (remain != 0){
            if(map.containsKey(remain)){
                sb.insert(map.get(remain), "(");
                sb.append(")");
                break;
            }

            map.put(remain, sb.length());
            remain *= 10;
            sb.append(String.valueOf(remain / den));
            remain %= den;
        }

        return sb.toString();
    }

}
