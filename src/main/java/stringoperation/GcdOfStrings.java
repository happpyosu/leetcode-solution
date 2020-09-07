package stringoperation;


// 1071. 字符串的最大公因子
// 输入：str1 = "ABCABC", str2 = "ABC"
// 输出："ABC"

// trick str1 + str2 = str2 + str1
// todo
public class GcdOfStrings {

    public static void main(String[] args) {
        GcdOfStrings g = new GcdOfStrings();
        String s = g.gcdOfStrings("ABCABC", "ABC");
        System.out.println(s);
    }


    public String gcdOfStrings(String str1, String str2) {
        if(!(str1 + str2).equals(str2 + str1)) return "";

        int gcd = gcd(str1.length(), str2.length());

        return str1.substring(0, gcd);

    }

    private int gcd(int a, int b){

        while (b != 0){
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

}
