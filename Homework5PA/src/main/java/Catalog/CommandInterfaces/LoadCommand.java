package Catalog.CommandInterfaces;

import Catalog.Catalog;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class LoadCommand implements Command{
    Catalog catalog;
    String path;
    public LoadCommand(Catalog c,String path)
    {
        this.catalog = c;
        this.path = path;
    }

    public void execute() throws IOException,InvalidCatalogException {
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = objectMapper.readValue(
                new File(path),
                Catalog.class);
    }

    public static class InvalidCatalogException extends Exception {
        public InvalidCatalogException(Exception ex) {
            super("Invalid catalog file.", ex);
        }
    }
}
