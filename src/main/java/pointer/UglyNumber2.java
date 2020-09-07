package pointer;

// todo
public class UglyNumber2 {

    public static void main(String[] args) {
        UglyNumber2 u = new UglyNumber2();
        int uglyNumber = u.nthUglyNumber(7);
        System.out.println(uglyNumber);
    }

    public int nthUglyNumber(int n) {
        int i=0, j=0, k=0;
        int[] temp = new int[n];
        temp[0] = 1;

        int cur = 1;

        while (cur < n){
            int b = Math.min(temp[i] * 2, Math.min(temp[j] * 3, temp[k] * 5));

            if(temp[i] * 2 == b) i++;
            else if(temp[j] * 3 == b) j++;
            else k++;

            if(b != temp[cur-1]) temp[cur++] = b;
        }
        return temp[n-1];
    }

}
