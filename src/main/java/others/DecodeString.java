package others;

public class DecodeString {

    public static void main(String[] args) {
        DecodeString d = new DecodeString();
        String string = d.decodeString("3[a2[c]]");
        System.out.println(string);

    }

    public String decodeString(String s) {
        int count = 0;
        for (int i=0; i<s.length(); i++){
            if(s.charAt(i) == '[') count++;
        }

        StringBuilder sb = new StringBuilder(s);

        while (count > 0) {
            int cur = 0;
            int left = 0;
            for(int i=0; i<sb.length(); i++){
                if(sb.charAt(i) == '[') cur++;
                if(cur == count){
                    left = i;
                    break;
                }
            }
            int right = left;
            for(int i=left+1; i<sb.length(); i++){
                if(sb.charAt(i) == ']') {
                    right = i;
                    break;
                }
            }

            int k = left - 1; StringBuilder times = new StringBuilder();
            while (k >= 0 && Character.isDigit(sb.charAt(k))) times.insert(0, sb.charAt(k--));
            int t = Integer.parseInt(times.toString());

            StringBuilder rep = new StringBuilder();
            String unit = sb.substring(left+1, right);
            while (t-- > 0) rep.append(unit);
            sb.replace(k+1, right+1, rep.toString());
            count--;
        }

        return sb.toString();

    }

}
