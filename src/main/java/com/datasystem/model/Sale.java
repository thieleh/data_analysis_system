package com.datasystem.model;

import java.util.List;

public class Sale {

    private Integer id;
    private List<Item> itens;
    private String salesmanName;

    public Sale(){

    }

    public Sale(Integer id, List<Item> itens, String salesmanName) {
        this.id = id;
        this.itens = itens;
        this.salesmanName = salesmanName;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMostExpensiveSale(){
        itens.sort((first, second) -> Double.compare(second.getQuantity() * second.getPrice(), first.getQuantity() * first.getPrice()));
        return (itens.get(0).getQuantity() * itens.get(0).getPrice());
    }

    @Override
    public String toString() {
        return "SALE {" +
                "ID: " + id +
                ", itens: " + itens +
                ", SalesmanName: '" + salesmanName + '\'' +
                '}';
    }


}
