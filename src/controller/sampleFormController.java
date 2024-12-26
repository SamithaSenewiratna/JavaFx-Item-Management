package controller;

import DB.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Item;

import java.io.IOException;

import static com.sun.xml.internal.ws.streaming.XMLStreamReaderUtil.close;

public class sampleFormController {


    public TextField txtID;
    public TextField txtName;
    public TextField txtQty;
    public TextField txtPrice;
    public TextField txtDiscription;

    public void btnAddOnAction(ActionEvent actionEvent) {


        String id = txtID.getText();
        String name = txtName.getText();
        int qty = Integer.parseInt(txtQty.getText());
        double price = Double.parseDouble(txtPrice.getText());
        String discription = txtDiscription.getText();

        System.out.println(new Item(id, name, qty, price, discription));
        DBConnection.getInstance().getConnection().add(new Item(id,name,qty,price,discription));


    }


    public void btnCanselOnAction(ActionEvent actionEvent) {



    }

    public void btnViewItemOnAction(ActionEvent actionEvent) throws IOException {

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/view_order.fxml"))));
        stage.show();

    }

    public void btnAddItemOnAction(ActionEvent actionEvent) throws IOException {

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/addItemForm.fxml"))));
        stage.show();


    }

    public void btnDeleteItemOnAction(ActionEvent actionEvent) throws IOException {

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/delete_form.fxml"))));
        stage.show();
    }
}


