import com.datasystem.model.Item;
import com.datasystem.model.Sale;
import com.datasystem.service.SaleService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


import java.util.ArrayList;
import java.util.List;



import static org.junit.Assert.assertEquals;


public class ServiceTest {

    SaleService saleService = new SaleService();

    @Test
    public void mostExpensiveSaleTest() {
        List<Item> itemSoldSalesman1 = new ArrayList<>();
        List<Item> itemSoldSalesman2 = new ArrayList<>();
        Item item = new Item(1, 10, 86.00);
        Item item2 = new Item(2, 5, 31.25);
        Item item3 = new Item(3, 1, 4.90);
        itemSoldSalesman1.add(item);
        itemSoldSalesman1.add(item2);
        itemSoldSalesman1.add(item3);
        itemSoldSalesman2.add(item3);
        List<Sale> sales = new ArrayList<>();
        Sale sale1 = new Sale(1, itemSoldSalesman1, "Thiele");
        Sale sale2 = new Sale(2, itemSoldSalesman2, "Bibiana");
        sales.add(sale1);
        sales.add(sale2);

        Assertions.assertEquals(1, saleService.mostExpansiveSale(sales));
    }

    @Test
    public void worstSalesmanTest() {
        List<Item> itemSoldSalesman1 = new ArrayList<>();
        List<Item> itemSoldSalesman2 = new ArrayList<>();
        Item item = new Item(1, 50, 10.0);
        Item item2 = new Item(2, 20, 50.0);
        Item item3 = new Item(3, 2, 2.0);
        itemSoldSalesman1.add(item);
        itemSoldSalesman1.add(item2);
        itemSoldSalesman2.add(item2);
        itemSoldSalesman2.add(item3);
        List<Sale> sales = new ArrayList<>();
        Sale sale1 = new Sale(1, itemSoldSalesman1, "Thiele");
        Sale sale2 = new Sale(2, itemSoldSalesman2, "Bibiana");
        sales.add(sale1);
        sales.add(sale2);

        assertEquals("Bibiana", saleService.worstSalesman(sales));
    }

    @Test
    public void salePriceTest() {
        List<Item> itens = new ArrayList<>();
        Item item = new Item(1, 2, 160.0);
        Item item2 = new Item(2, 4, 75.0);
        itens.add(item);
        itens.add(item2);
        Sale sale = new Sale(1, itens, "Thiele");

        Assertions.assertEquals(620.0, saleService.salePrice(sale));
    }

}
