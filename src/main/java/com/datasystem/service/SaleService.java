package com.datasystem.service;

import com.datasystem.model.Item;
import com.datasystem.model.Sale;

import java.util.List;

public class SaleService {

    public Integer mostExpansiveSale(List<Sale> sales) {
        if (sales.isEmpty()){
            throw new IllegalArgumentException("Ther is no sale registered.");
        }
        double expensivePrice = 0.0;
        Integer expensiveId = 0;

        for (Sale sale : sales) {
            double subtotal = salePrice(sale);
            if (subtotal > expensivePrice) {
                expensivePrice = subtotal;
                expensiveId = sale.getId();
            }
        }
        return expensiveId;
    }

    public String worstSalesman(List<Sale> sales) {
        if (sales.isEmpty()){
            throw new IllegalArgumentException("There is no sale registered.");
        }
        sales.sort((first, second) -> Double.compare(second.getMostExpensiveSale(), first.getMostExpensiveSale()));
        sales.sort((first, second) -> Double.compare(salePrice(second), salePrice(first)));
        return sales.get(sales.size()-1).getSalesmanName();

    }

    public Double salePrice(Sale sale) {
        double total = 0;

        for (Item item : sale.getItens()) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }
}