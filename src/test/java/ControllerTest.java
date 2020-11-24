import com.datasystem.controller.Controller;
import com.datasystem.model.Costumer;
import com.datasystem.model.ModelLists;
import com.datasystem.model.Salesman;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

public class ControllerTest {

    Controller controller = new Controller();

    @Test
    public void amountOfCostumersTest(){
        Costumer costumer1 = new Costumer();
        Costumer costumer2 = new Costumer();
        Costumer costumer3 = new Costumer();
        Costumer costumer4 = new Costumer();
        Costumer costumer5 = new Costumer();

        List<Costumer> costumers = new ArrayList<>();
        costumers.add(costumer1);
        costumers.add(costumer2);
        costumers.add(costumer3);
        costumers.add(costumer4);
        costumers.add(costumer5);
        ModelLists modelLists = new ModelLists();
        modelLists.setCostumers(costumers);

        Assertions.assertNotNull(controller.amountCostumers(modelLists));
    }

    @Test
    public void amountOfSalesmenTest(){
        Salesman salesman1 = new Salesman();
        Salesman salesman2 = new Salesman();
        Salesman salesman3 = new Salesman();
        Salesman salesman4 = new Salesman();
        Salesman salesman5 = new Salesman();

        List<Salesman> salemen = new ArrayList<>();
        salemen.add(salesman1);
        salemen.add(salesman2);
        salemen.add(salesman3);
        salemen.add(salesman4);
        salemen.add(salesman5);
        ModelLists modelLists = new ModelLists();
        modelLists.setSalemen(salemen);

        Assertions.assertNotNull(controller.amountSalesmen(modelLists));
    }
}
