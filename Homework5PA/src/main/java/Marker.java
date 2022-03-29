import Catalog.Catalog;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Marker {
    public static void generate(Catalog c){

    Configuration configuration = new Configuration(Configuration.VERSION_2_3_27);
    try
    {
        configuration.setDirectoryForTemplateLoading(new File("C:\\Users\\Bogdanel\\Documents\\IdeaProjects\\PA\\Homework5PA\\src\\main\\Marker"));
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setLogTemplateExceptions(false);
        configuration.setWrapUncheckedExceptions(true);
        configuration.setFallbackOnNullLoopVariable(false);


        Map<String,Object> root = new HashMap();
        root.put("catalog", c.getCatalog());
        /* Get the template (uses cache internally) */
        Template temp = configuration.getTemplate("test.ftl");

        /* Merge data-model with template */
        OutputStream outputStream= new FileOutputStream("C:\\Users\\Bogdanel\\Documents\\IdeaProjects\\PA\\Homework5PA\\src\\main\\Marker\\index.html");
        Writer out = new OutputStreamWriter(outputStream);
        temp.process(root, out);

        out.close();
        openHTML("C:\\Users\\Bogdanel\\Documents\\IdeaProjects\\PA\\Homework5PA\\src\\main\\Marker\\index.html");
    }
    catch(Exception e)
    {
        System.out.println(e.getMessage());
    }
    }

    private static void openHTML(String location)
    {
        try{
            if (!Desktop.isDesktopSupported()) System.out.println("DESKTOP IS NOT SUPPORTED");

            Desktop desktop = Desktop.getDesktop();

            File file = new File(location);

            if (file.exists()) desktop.open(file);
            else System.out.println("FILE DOESN'T EXIST");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }




    }
}

