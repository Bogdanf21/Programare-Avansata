package Catalog.CommandInterfaces;

import Catalog.Catalog;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class SaveCommand implements Command {
    public static void execute(Catalog catalog, String path) throws IOException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
                new File(path), catalog);
    }
}
