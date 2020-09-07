package designpattern;

import java.security.Signature;

public class Singleton {

    public static class cls{
        private static final Object obj = new Object();
    }

    private Singleton() {
    }

    public static Object getObj(){
        return cls.obj;
    }

}



