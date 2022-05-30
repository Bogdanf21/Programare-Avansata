package JavaP;

import org.testng.annotations.Test;

import javax.naming.directory.NoSuchAttributeException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ClassTester {
    public void runTestCases(List<Class> classList) {
        classList.forEach(clazz -> {
            System.out.println("------------------ RUNNING FOR  " + clazz.getName() + "  --------------");
            int passed = 0;
            int failed = 0;
            Random random = new Random();
            for (Method m : clazz.getMethods()) {

                if (!m.isAnnotationPresent(Test.class)) continue;

                try {
                    Class<?> arguments[] = null;
                    //get the required arguments
                    if(m.getParameterTypes().length != 0) {
                        arguments = new Class<?>[m.getParameterTypes().length];
                        for(Class<?> param : m.getParameterTypes()) {
                            try {
                                arguments[0] = param.getComponentType();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }


                    if (arguments == null)
                        m.invoke(clazz.getDeclaredConstructor(null).newInstance());
                     else
                    {


                        m.invoke(clazz.getDeclaredConstructor(null).newInstance(),10);
                    }


                    passed++;
                } catch (Throwable ex) {
                    System.out.printf("Test %s failed: %s %n",
                            m, ex.getCause());
                    failed++;
                }

            }
            System.out.printf("Passed: %d, Failed %d%n", passed, failed);

        });


    }
}
