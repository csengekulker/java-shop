package models;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Restapi {
    
    public Restapi() {
        String str = this.getProductsAsString();
        System.out.println(str);
    }

    public String getProductsAsString() {
        String text = null;

        try {
            text = tryGetProductsAsString();
        } catch (IOException e) {
            System.err.println("A REST API lekérdezése sikertelen");
        }

        return text;
    }

    public String tryGetProductsAsString() throws IOException {
        String host = "http://[::1]:3000/";
        String endpoint = "products";

        URL url = new URL(host + endpoint);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();

        http.setRequestMethod("GET");
        http.connect();

        int responseCode = http.getResponseCode();

        StringBuilder text = new StringBuilder();

        if (responseCode == 200) {
            System.out.println("OK");
            InputStream inputStream = http.getInputStream();
            Reader reader = new InputStreamReader(inputStream, "UTF-8");
            Scanner sc = new Scanner(reader);

            while(sc.hasNextLine()) {
                text.append(sc.nextLine());
            }

            sc.close();
        } else {
            System.out.println("A lekérdezés sikertelen" + responseCode);
        }

        return text.toString();
    }

    public ArrayList<Product> getProducts() {

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        String text = getProductsAsString();
        Product[] productArray = gson.fromJson(text, Product[].class);

        ArrayList<Product> productList = new ArrayList<>(
            Arrays.asList(productArray)
        );

        return productList;
    }
}
