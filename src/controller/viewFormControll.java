package controller;

import DB.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Item;

import java.util.ArrayList;

public class viewFormControll {


    public TableView tblView;
    public TableColumn colID;
    public TableColumn colName;
    public TableColumn colQty;
    public TableColumn colPrice;
    public TableColumn colDiscription;

    ArrayList<Item> ItemList = new ArrayList<>();

    public void btnRealodOnAction(ActionEvent mouseEvent) {



        ObservableList<Item> itemObservableList = FXCollections.observableArrayList();
        colID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("Qty"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        colDiscription.setCellValueFactory(new PropertyValueFactory<>( "Discrition"));

        DBConnection.getInstance().getConnection().forEach(obj->{
            itemObservableList.add(obj);
        });

        tblView.setItems(itemObservableList);

    }
}
