package controller;

import DB.DBConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Item;

import static sun.net.www.MimeTable.loadTable;

public class addFormController {
    public TextField txtID;
    public TextField txtName;
    public TextField txtQty;
    public TextField txtprice;
    public TextField txtDiscription;

    public void btnAddOnAction(ActionEvent actionEvent) {



        String id = txtID.getText();
        String name = txtName.getText();
        int qty = Integer.parseInt(txtQty.getText());
        double price = Double.parseDouble(txtprice.getText());
        String discription = txtDiscription.getText();

//        System.out.println(new Item(id, name, qty, price, discription));
        DBConnection.getInstance().getConnection().add(new Item(id,name,qty,price,discription));

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Item with ID " + id + " has been successfully added.");
        alert.showAndWait();
        clearFields();


    }

    private void clearFields() {
        txtID.setText("");
        txtName.setText("");
        txtQty.setText("");
        txtprice.setText("");
        txtDiscription.setText("");

    }
}
