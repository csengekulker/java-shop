package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataService {
    Database database;
    Connection con;
    public DataService(Database database) {
        this.database = database;
        this.con = this.database.connect();

    }

    public ArrayList<Product> getProducts() {
        ArrayList<Product> products = null;
        try {
            products = tryGetProducts();
        } catch (SQLException e) {
            System.err.println("Hiba! A termékek lekérdezése sikertelen.");
        }

        return products;
    }

    public ArrayList<Product> tryGetProducts() throws SQLException {
        String sql = "select * from products";
        Statement stmt = this.con.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        ArrayList<Product> products = new ArrayList<>();

        while(res.next()) {

            Product product = new Product();
            product.id = res.getInt("id");
            product.name = res.getString("name");
            product.itemNumber = res.getString("itemNumber");
            product.count = res.getInt("count");
            product.price = res.getDouble("price");

            products.add(product);
        }

        return products;

    }
}
