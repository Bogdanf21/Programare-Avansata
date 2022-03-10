package Implementations;
import Identifiable.java.Identifiable;
import Storage.java.Storage;


public class Router extends Node implements Identifiable, Storage {
    private String address;
    private int storageCapacity;

    @Override
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int getStorageCapacity() {
        return storageCapacity;
    }
}