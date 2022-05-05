package Catalog.CommandInterfaces;

import Catalog.Catalog;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class SaveCommand implements Command {
    private Catalog catalog;
    private String path;

    public SaveCommand(Catalog catalog, String path)
    {
        this.catalog = catalog;
        this.path = path;
    }

    public void execute() throws IOException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
                new File(path), catalog);
    }
}
