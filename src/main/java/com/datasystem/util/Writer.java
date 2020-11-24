package com.datasystem.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Writer {
    private static final Logger LOGGER = Logger.getLogger(Writer.class.getName());
    public static void writer(File file, Integer amountSalesmen, Integer amountCostumers,
                              Integer idMostExpansiveSale, String worstSalesman) {

        String[] lines = new String[]{
                "Amount of Salesmen: " + amountSalesmen,
                "Amount clients: " + amountCostumers,
                "ID of the most expensive sale: " + idMostExpansiveSale,
                "Worst salesman ever: " + worstSalesman
        };

        String fileName = file.getName().replaceFirst(" ", "").toLowerCase();
        String path = file.getParent().replace("in", "out/") + fileName + ".done" + ".dat";

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            Arrays.stream(lines).forEach(line -> {
                try {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "ERROR! It was not possible to write in the file " + Arrays.toString(e.getStackTrace()));
        }
    }
}
