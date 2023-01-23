import models.DataService;
import models.MariadbDatabase;
import models.Product;
import models.Restapi;

import java.util.ArrayList;


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Adatbázis elérés");

        DataService dataService = new DataService(
            new MariadbDatabase(
            "shop",
            "shop",
            "titok")
        );

        ArrayList<Product> products = dataService.getProducts();

        new Restapi();
        
    }
}
