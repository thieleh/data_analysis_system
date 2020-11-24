package com.datasystem.controller;

import com.datasystem.model.ModelLists;
import com.datasystem.service.SaleService;

public class Controller {
    SaleService saleService = new SaleService();

    public Integer amountCostumers(ModelLists modelLists) {
        return modelLists.getCostumers().size();
    }

    public Integer amountSalesmen(ModelLists modelLists) {
        return modelLists.getSalemen().size();
    }

    public Integer idMostExpansiveSale(ModelLists modelLists) {
            return saleService.mostExpansiveSale(modelLists.getSales());
    }

    public String worstSalesman(ModelLists modelLists) {
        return saleService.worstSalesman(modelLists.getSales());
    }
}
