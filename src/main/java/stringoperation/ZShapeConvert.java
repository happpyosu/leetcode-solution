package stringoperation;

import java.util.List;

public class ZShapeConvert {

    public static void main(String[] args) {
        ZShapeConvert z = new ZShapeConvert();
        String convert = z.convert("LEETCODEISHIRING", 3);
        System.out.println(convert);
    }


    public String convert(String s, int numRows) {
        StringBuilder[] sbs = new StringBuilder[numRows];

        for(int i=0; i<sbs.length; i++){
            sbs[i] = new StringBuilder();
        }

        int cur = 0;
        int p = -1;

        boolean flag = true; // 递增行号还是递减行号

        while (cur < s.length()){
            if(flag) {
                sbs[++p].append(s.charAt(cur++));
                if(p == numRows - 1) flag = false;
            }
            else {
                sbs[--p].append(s.charAt(cur++));
                if(p == 0) flag = true;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(StringBuilder a : sbs){
            sb.append(a);
        }

        return sb.toString();

    }

}
