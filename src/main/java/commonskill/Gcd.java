package commonskill;

public class Gcd {

    public static int gcd(int x, int y){
        int max = Math.max(x, y);
        int min = Math.min(x, y);
        int c = max % min;

        while (c != 0){
            max = min;
            min = c;
            c = max % min;
        }

        return min;
    }

}
