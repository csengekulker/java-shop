package views;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import models.*;

public class MainView extends VBox {
  
  Label productsLabel;
  DataService service;
  ArrayList<Product> products;
  TableView<Product> tableView;

  public MainView() {
    initData();
    initTable();
    
    // productsLabel = new Label(products.get(1).getName());

    // this.getChildren().add(productsLabel);
  }

  private void initData() {
    service = new DataService(
            new MariadbDatabase(
            "shop",
            "shop",
            "titok")
    );

    products = service.getProducts();
  }

  private void initTable() {
    tableView = new TableView<>();

    TableColumn<Product, Integer> idCol = new TableColumn<>("#");
    idCol.setMinWidth(20);
    idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

    TableColumn<Product, String> nameCol = new TableColumn<>("Név");
    nameCol.setMinWidth(50);
    nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
    
    TableColumn<Product, String> itemNumberCol = new TableColumn<>("Cikkszám");
    itemNumberCol.setMinWidth(50);
    itemNumberCol.setCellValueFactory(new PropertyValueFactory<>("itemNumber"));
    
    TableColumn<Product, Integer> countCol = new TableColumn<>("Db");
    countCol.setMinWidth(50);
    countCol.setCellValueFactory(new PropertyValueFactory<>("count"));

    TableColumn<Product, Double> priceCol = new TableColumn<>("Ár");
    priceCol.setMinWidth(50);
    priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

    tableView.setItems(this.getProducts());

    tableView.getColumns().add(idCol);
    tableView.getColumns().add(nameCol);
    tableView.getColumns().add(itemNumberCol);
    tableView.getColumns().add(countCol);
    tableView.getColumns().add(priceCol);

    this.getChildren().add(tableView);
  }

  private ObservableList<Product> getProducts() {
    
    return FXCollections.observableArrayList(service.getProducts());
  }
}