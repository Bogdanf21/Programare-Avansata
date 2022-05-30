import org.testng.annotations.Test;

public class MyProgram2 {
    protected int aProtectedInt = 3;
    @Test
    public static void programMethod1() { }
    public static void programMethod2() { }
    @Test public static void programMethod3() {
        throw new RuntimeException("Boom");
    }
    public static void programMethod4() { }
    @Test public static void programMethod5() { }
    public static void programMethod6() { }
    @Test public static void programMethod7() {
        throw new RuntimeException("Crash");
    }
    public static void programMethod8() { }
    @Test public void programMethodNonStaticTest() {}
    @Test public void programMethodNonStaticTestWithArgInt(int someInt) {throw new RuntimeException("IntError >.<");}
    @Test public void programMethodStaticTestWithArgString(String someString) {};
    @Test private void programMethodPrivateTestWithArgLong(Long someLong) {throw new RuntimeException("Long crash !!");}
}