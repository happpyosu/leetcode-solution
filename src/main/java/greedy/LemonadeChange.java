package greedy;

public class LemonadeChange {

    public static void main(String[] args) {
        LemonadeChange l = new LemonadeChange();
        int[] test = {5,5,10,10,20};
        boolean b = l.lemonadeChange(test);
        System.out.println(b);
    }

    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten =  0;

        for (int bill : bills) {
            if (bill == 5) five++;
            else if (bill == 10) {
                if (five > 0) {
                    --five;
                    ++ten;
                } else return false;
            } else {
                if (five > 0) {
                    if (ten * 10 + five * 5 >= 15) {
                        if (ten > 0) {
                            --ten;
                            --five;
                        } else {
                            five -= 3;
                        }
                    } else return false;
                } else return false;
            }
        }

        return true;


    }


}
