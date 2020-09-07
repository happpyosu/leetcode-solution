package commonskill;

public class HammingWeight {

    public static int hammingWeight(int x){
        int count = 0;
        while (x != 0){
            x &= x - 1;
            count++;
        }
        return count;
    }

}
