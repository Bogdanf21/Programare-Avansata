import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FolderClassLoader {

List<Class> classList = new ArrayList<>();
    public List<Class> loadFrom(String absoluteRootFolderPath)
    {
        classList = new ArrayList<>();


        try (Stream<Path> paths = Files.walk(Paths.get(absoluteRootFolderPath))) {
            paths
                    .filter(Files::isRegularFile)
                    .forEach(filePath -> {
                        System.out.println("TOBELOADED: " + filePath.toString());
                      Class loadedClass = loadClass(filePath.toString());
                      classList.add(loadedClass);
                    });

            return classList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }





    // -------------------------------------------------
    private String getClassPathFromAbsolutePath(String arg) {
        StringBuilder sb = new StringBuilder(arg);
        int lastSlashPosition = sb.lastIndexOf("/");
        sb.delete(lastSlashPosition, arg.length());
        System.out.println("CLASSPATH : " + sb.toString());
        return sb.toString();
    }

    private String getClassNameFromAbsolutePath(String arg) {
        String[] bits = arg.split("/");
        String className = bits[bits.length - 1].split("\\.")[0];
        System.out.println("CLASSNAME : " + className);
        return className;
    }

    private Class loadClass(String absolutePath) {
        String className = getClassNameFromAbsolutePath(absolutePath);
        String classPath = getClassPathFromAbsolutePath(absolutePath);

        try {
            URLClassLoader urlClassLoader = URLClassLoader.newInstance(new URL[]{
                    new URL(
                            "file:///" + classPath
                    )
            });
            Class loadedClass = urlClassLoader.loadClass(className);
            printInfo(loadedClass);
            return loadedClass;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    private void printInfo(Class loadedClass) {
       // compulsory(loadedClass);
    }

}
