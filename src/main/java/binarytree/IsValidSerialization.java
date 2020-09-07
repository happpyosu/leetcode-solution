package binarytree;

public class IsValidSerialization {

    public boolean isValidSerialization(String preorder) {
        int slots = 1;
        for (String s : preorder.split(",")){
            slots--;
            if(slots < 0) return false;
            if(!s.equals("#")){
                slots += 2;
            }

        }
        return slots == 0;
    }


}
