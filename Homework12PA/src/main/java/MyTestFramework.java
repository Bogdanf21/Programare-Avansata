
import JavaP.ClassInspector;
import JavaP.ClassTester;

import java.util.List;


public class MyTestFramework {
    public static void main(String[] args)  {

        FolderClassLoader folderClassLoader = new FolderClassLoader();
       List<Class> classes = folderClassLoader.loadFrom(args[0]);
       ClassInspector classInspector = new ClassInspector(classes);
       classInspector.inspect();
       ClassTester classTester = new ClassTester();
       classTester.runTestCases(classes);
    }



}















/*
    private static void compulsory(Class clazz)
    {
        System.out.println("------------  General info -------------");
        System.out.println("Package name: " + clazz.getPackageName());
        System.out.println(" ----------- Methods  --------------- ");

        for (Method m : clazz.getMethods())
            System.out.println("Method " + m.getName() + "  args:" + Arrays.toString(m.getParameters()) + " return type " + m.getReturnType());

        System.out.println("------------ RUNNING ----------");
        int passed = 0, failed = 0;
        for (Method m : clazz.getMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                try {
                    m.invoke(null);
                    passed++;
                } catch (Throwable ex) {
                    System.out.printf("Test %s failed: %s %n",
                            m, ex.getCause());
                    failed++;
                }
            }
        }
        System.out.printf("Passed: %d, Failed %d%n", passed, failed);
    }

    private static String getClassPathFromAboslutePath(String arg) {
        StringBuilder sb = new StringBuilder(arg);
        int lastSlash = sb.lastIndexOf("/");
        sb.delete(lastSlash,arg.length());
        System.out.println("CLASSPATH : " + sb.toString());
        return sb.toString();
    }

    private static String getClassNameFromAbsolutePath(String arg) {
        String[] bits = arg.split("/");
        String className = bits[bits.length-1].split("\\.")[0];
        System.out.println("CLASSNAME : " + className);
        return className;
    }

    public static void listClassesForFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listClassesForFolder(fileEntry);
            } else {
                System.out.println(fileEntry.getName());
            }
        }
    }
*/
