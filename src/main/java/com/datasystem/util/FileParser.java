package com.datasystem.util;

import com.datasystem.model.*;


import java.util.ArrayList;
import java.util.List;

public class FileParser {

    public static ModelLists fileParser(List<String> line) {

        List<Salesman> salemen = new ArrayList<>();
        List<Costumer> costumers = new ArrayList<>();
        List<Item> itens = new ArrayList<>();
        List<Sale> sales = new ArrayList<>();


        for (Object lists : line) {

            String[] fields = lists.toString().split("ç");
            String key = fields[0];
            switch (key) {
                case "001" -> salemen.add(new Salesman(fields[1], fields[2], Double.parseDouble(fields[3])));
                case "002" -> costumers.add(new Costumer(fields[1], fields[2], fields[3]));
                case "003" -> {
                    String[] internFields = fields[2].replace("[", "").replace("]", "").split(",");
                    List<Item> saleItens = new ArrayList<>();
                    for (String itemWords : internFields) {
                        internFields = itemWords.split("-");
                        itens.add(new Item(Integer.parseInt(internFields[0]), Integer.parseInt(internFields[1]), Double.parseDouble(internFields[2])));
                        saleItens.add(new Item(Integer.parseInt(internFields[0]), Integer.parseInt(internFields[1]), Double.parseDouble(internFields[2])));
                    }

                    sales.add(new Sale(Integer.parseInt(fields[1]), saleItens, fields[3]));
                }
            }
        }
        return new ModelLists(salemen, costumers, itens, sales);
    }
}
