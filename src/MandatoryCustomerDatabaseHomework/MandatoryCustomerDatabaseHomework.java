/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MandatoryCustomerDatabaseHomework;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.*;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class MandatoryCustomerDatabaseHomework extends Application {
    
    CheckBox nameCheckbox = new CheckBox("Name");
    CheckBox addressCheckbox = new CheckBox("Address");
    CheckBox cityCheckbox = new CheckBox("City");
    CheckBox stateCheckbox = new CheckBox("State");
    CheckBox zipCheckbox = new CheckBox("Zip Code");
    
    TextField whereTextfield = new TextField();
    
    TableView<Customer> table = new TableView<Customer>();
    private TableColumn nameColumn = new TableColumn("Name");
    private TableColumn addressColumn = new TableColumn("Address");
    private TableColumn cityColumn = new TableColumn("City");
    private TableColumn stateColumn = new TableColumn("State");
    private TableColumn zipColumn = new TableColumn("Zip");
    
    // 
    private ObservableList<Customer> customersTableData = FXCollections.observableArrayList();

    
    @Override
    public void start(Stage primaryStage) {   
        
        // Set up column checkboxes
        Label checkboxLabel = new Label("Select columns to display:");
        GridPane checkboxGrid = new GridPane();
        checkboxGrid.add(nameCheckbox, 0, 0);
        nameCheckbox.setSelected(true);
        checkboxGrid.add(addressCheckbox, 1, 0);
        addressCheckbox.setSelected(true);
        checkboxGrid.add(cityCheckbox, 2, 0);
        cityCheckbox.setSelected(true);
        checkboxGrid.add(stateCheckbox, 0, 1);
        stateCheckbox.setSelected(true);
        checkboxGrid.add(zipCheckbox, 1, 1);
        zipCheckbox.setSelected(true);
        
        // Set up "where" label
        Label whereLabel = new Label("Enter SQL WHERE clause below, or leave blank to skip. \n" +
                                     "(Example: WHERE name > 'm')");
        
        // Set up button
        Button getDataButton = new Button();
        getDataButton.setText("Get Customer Data");
        getDataButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                getData(whereTextfield.getText().trim());
                table.setItems(customersTableData);
                nameColumn.setVisible(nameCheckbox.isSelected());
                addressColumn.setVisible(addressCheckbox.isSelected());
                cityColumn.setVisible(cityCheckbox.isSelected());
                stateColumn.setVisible(stateCheckbox.isSelected());
                zipColumn.setVisible(zipCheckbox.isSelected());
            }
        });
        
        // Set up table
        nameColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("name"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("address"));
        cityColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("city"));
        stateColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("state"));
        zipColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("zip"));
        table.setItems(customersTableData);
        table.getColumns().addAll(nameColumn, addressColumn, cityColumn, stateColumn, zipColumn);
        
        getData("");
        
        // Lay out UI elements
        VBox layout = new VBox(10, 
                               checkboxLabel,
                               checkboxGrid,
                               whereLabel,
                               whereTextfield, 
                               getDataButton, 
                               table);
        
        Scene scene = new Scene(layout, 600, 600);
        
        primaryStage.setTitle("PC Parts Customers");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void getData(String whereClause) {
        customersTableData.clear();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver is good");
	} 
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        String host = "jdbc:mysql://localhost:3306/pcparts";
        String username = "root";
        String password = "root";
        
        String query;
        if (whereClause.length() > 0) {
            query = "select * from customers where " + whereClause + ";";
        } 
        else {
            query = "select * from customers;";
        }
     	
        try {
            Connection connect = DriverManager.getConnection(host, username, password);
            Statement st = connect.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            while (resultSet.next()) {
                Customer newCustomer = new Customer(
                    resultSet.getString("name"),
                    resultSet.getString("address"),
                    resultSet.getString("city"),
                    resultSet.getString("state"),
                    resultSet.getString("zip")
                );
                System.out.println(newCustomer.getName());
                customersTableData.add(newCustomer);

             }
        }
        catch (SQLException e) {
                e.printStackTrace();
        }
    }

    public static class Customer {
 
        private final SimpleStringProperty name;
        private final SimpleStringProperty address;
        private final SimpleStringProperty city;
        private final SimpleStringProperty state;
        private final SimpleStringProperty zip;
 
         Customer(String name, 
                         String address, 
                         String city,
                         String state,
                         String zip) {
            this.name = new SimpleStringProperty(name);
            this.address = new SimpleStringProperty(address);
            this.city = new SimpleStringProperty(city);
            this.state = new SimpleStringProperty(state);
            this.zip = new SimpleStringProperty(zip);
        }
 
        public String getName() {
            return name.get();
        }
 
        public void setName(String name) {
            this.name.set(name);
        }
 
        public String getAddress() {
            return address.get();
        }
 
        public void setAddress(String address) {
            this.address.set(address);
        }
 
        public String getCity() {
            return city.get();
        }
 
        public void setCity(String city) {
            this.city.set(city);
        }
        
        public String getState() {
            return state.get();
        }
 
        public void setState(String state) {
            this.state.set(state);
        }
 
        public String getZip() {
            return zip.get();
        }
 
        public void setZip(String zip) {
            this.zip.set(zip);
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
