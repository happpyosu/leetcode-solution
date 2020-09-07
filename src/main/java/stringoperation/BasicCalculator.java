package stringoperation;

public class BasicCalculator {


    public static void main(String[] args) {
        BasicCalculator b = new BasicCalculator();
        int res = b.calculate("3 + 5/2");
        System.out.println(res);
    }

    public int calculate(String s) {
        StringBuilder sb = new StringBuilder(s.replace(" ", ""));
        if(Character.isDigit(sb.charAt(0))) sb.insert(0, "+");
        cal(sb, '*', '/');
        cal(sb, '+', '-');

        return Integer.parseInt(sb.toString().replace(" ", ""));

    }


    private void cal(StringBuilder sb, char op1, char op2){
        for(int i=0; i<sb.length(); i++){
            char c = sb.charAt(i);
            if(c == op1 || c == op2){
                if(i == 0) continue;
                int a = i-1; int b = i+1;
                while (a >= 0 && Character.isDigit(sb.charAt(a))) a--;
                while (b < sb.length() && Character.isDigit(sb.charAt(b))) b++;

                int left = Integer.parseInt(sb.substring(a, i));
                int right = Integer.parseInt(sb.substring(i+1, b));
                int result; char op = sb.charAt(i);
                if(op == '+') result = left + right;
                else if(op == '-') result = left - right;
                else if(op == '*') result = left * right;
                else  result = left / right;

                String r = result >= 0 ? "+" + result : String.valueOf(result);
                sb.replace(a, b, r);
                i=0;
            }
        }

    }



}
