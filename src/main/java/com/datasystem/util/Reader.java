package com.datasystem.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reader {
    private static final Logger LOGGER = Logger.getLogger(Reader.class.getName());


    public Reader() {
    }

    public static List<String> fileReader(File file) {

        List<String> lines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getPath()))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                if (!line.startsWith("00")) {
                    lines.set(lines.size() - 1, lines.get(lines.size() - 1).concat(line));
                } else {
                    lines.add(line);
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "ERROR! Is not possible to read the file " + e.getMessage());
        }
        return lines;
    }
}
