package com.datasystem.model;

public class Costumer {

    private String cnpj;
    private String name;
    private String businessArea;

    public Costumer(){
    }

    public Costumer( String cnpj, String name, String businessArea ) {
        this.cnpj = cnpj;
        this.name = name;
        this.businessArea = businessArea;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea( String businessArea ) {
        this.businessArea = businessArea;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj( String cnpj ) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "COSTUMER {" +
                "cnpj: '" + cnpj + '\'' +
                ", name: '" + name + '\'' +
                ", businessArea: '" + businessArea + '\'' +
                '}';
    }
}
