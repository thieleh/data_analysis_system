package com.datasystem.model;

import java.util.List;

public class ModelLists {

    private List<Salesman> salemen;
    private List<Costumer> costumers;
    private List<Item> itens;
    private List<Sale> sales;

    public ModelLists(){}

    public ModelLists(List<Salesman> salemen, List<Costumer> costumers, List<Item> itens, List<Sale> sales ) {
        this.salemen = salemen;
        this.costumers = costumers;
        this.itens = itens;
        this.sales = sales;
    }

    public List<Costumer> getCostumers() {
        return costumers;
    }

    public void setCostumers(List<Costumer> costumers) {
        this.costumers = costumers;
    }

    public List<Salesman> getSalemen() {
        return salemen;
    }

    public void setSalemen( List<Salesman> salemen ) {
        this.salemen = salemen;
    }

    public List<Item> getItens  () {
        return itens;
    }

    public void setItens( List<Item> itens ) {
        this.itens = itens;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales( List<Sale> sales ) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "FileLists{" +
                "salemen: " + salemen +
                ", costumers: " + costumers +
                ", itens: " + itens +
                ", sales: " + sales +
                '}';
    }
}
