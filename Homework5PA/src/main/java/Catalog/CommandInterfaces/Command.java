package Catalog.CommandInterfaces;

import Catalog.Catalog;

import java.io.IOException;

public  interface Command {
   public Catalog catalog = null;
    public void execute() throws IOException, LoadCommand.InvalidCatalogException;
}
