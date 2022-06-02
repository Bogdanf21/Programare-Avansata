package app;


import java.io.*;

class C1{
    static String f()
    {
        return "M1 din C1";
    }
    String g()
    {
        return "M2 din C1";
    }
}

class C2 extends C1{
    static String f(){
        return "M1  din C2";

    }
    String g()
    {
        return "M2 din C2";
    }
}

public class Test
{
    public static void main(String[] args) {
       C2 object = new C2();
        System.out.println(object.g());
       Double.isInfinite(1/0);



    }
}