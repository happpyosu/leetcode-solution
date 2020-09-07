package stringoperation;

// todo
public class IsFlipedString {

    public boolean isFlipedString(String s1, String s2) {
        s1 = s1 + s1;
        return s1.contains(s2);
    }

}
