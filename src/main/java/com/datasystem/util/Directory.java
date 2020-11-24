package com.datasystem.util;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Directory {

    private static final Logger LOGGER = Logger.getLogger(Directory.class.getName());


    public static void newDirectory(String directory) {

        File directoryData = new File(System.getProperty("user.home") + "/" + directory);
        if (!directoryData.exists()) {
            directoryData.mkdir();
            LOGGER.log(Level.INFO, "Directory created " + System.getProperty("user.home") + "/" + directory);
        }

        File directoryIn = new File(directoryData.getPath() + "/in/");
        if (!directoryIn.exists()) {
            directoryIn.mkdir();
            LOGGER.log(Level.INFO, "Directory created " + directoryData.getPath() + "/in/");
        }
        File directoryOut = new File(directoryData.getPath() + "/out/");
        if (!directoryOut.exists()) {
            directoryOut.mkdir();
            LOGGER.log(Level.INFO, "Directory created " + directoryData.getPath() + "/out/");
        }
    }
}
