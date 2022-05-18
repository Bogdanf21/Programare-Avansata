package com.Time;

import com.Entity.City;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import java.io.*;

public class TimeLogger {

    long start;
    @PrePersist
    public void logStartTime (City city)
    {
        start=System.currentTimeMillis();
    }

    @PostPersist
    public void logEndTime (City city)
    {
        long time= System.currentTimeMillis()-start;
        try {
            File log = new File("/home/bogdan/Desktop/log.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(log,true));
            writer.write("Insertion time for "+city.getName() +" is " + time + " ms.\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
