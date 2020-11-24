package com.datasystem;

import com.datasystem.controller.Controller;
import com.datasystem.model.ModelLists;
import com.datasystem.util.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Optional;

public class App {

    public static void main(String[] args) throws IOException, InterruptedException {

        Controller fileController = new Controller();

        Directory.newDirectory("data");

        WatchService watcher = FileSystems.getDefault().newWatchService();
        String pathDirectory = System.getProperty("user.home") + "/data/in/";
        Path directory = Paths.get(pathDirectory);
        directory.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY);

        while (true) {
            System.out.println("Please insert a flat file in your 'data/in' directory...");

            WatchKey key = watcher.take();
            Optional<WatchEvent<?>> watchEvent = key.pollEvents().stream().findFirst();
            if (watchEvent.isPresent()) {
                Path path = (Path) watchEvent.get().context();
                File dir = new File(directory + "/" + path);
                List<String> file = Reader.fileReader(dir);
                ModelLists modelLists = FileParser.fileParser(file);

                Writer.writer(dir, fileController.amountSalesmen(modelLists),
                        fileController.amountCostumers(modelLists),
                        fileController.idMostExpansiveSale(modelLists),
                        fileController.worstSalesman(modelLists));

                System.out.println("*** REPORT CREATED in your 'data/out' directory. ***\n");
            }
            boolean valid = key.reset();
            if (!valid) {
                break;
            }
        }
    }
}

