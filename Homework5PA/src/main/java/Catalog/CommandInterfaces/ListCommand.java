package Catalog.CommandInterfaces;

import Catalog.Catalog;

public class ListCommand implements Command{

    Catalog catalog;

    public ListCommand(Catalog c)
    {
        this.catalog = c;
    }

    public void execute() {
        StringBuilder builder = new StringBuilder();
        catalog.getCatalog().forEach(i -> {
                    builder.append("Type = ").append(String.valueOf(i)).append(" ID = ").append(i.getId());
                    builder.append(" Title = ").append(i.getLocation());
                    builder.append(" Location = ").append(i.getLocation());
                    builder.append("\n");
                    builder.append(i.getProperties());
                    builder.append("\n");
                    builder.append("Concepts:");
                    builder.append(i.getConcepts());
                }
        );
        System.out.println(builder);
    }


    public static class InvalidCatalogException extends Exception {
        public InvalidCatalogException(Exception ex) {
            super("Invalid catalog file.", ex);
        }
    }
}
