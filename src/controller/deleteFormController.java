package controller;

import DB.DBConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Item;

public class deleteFormController {
    public TextField txtID;
    public TextField txtName;
    public TextField txtprice;
    public TextField txtDiscription;
    public TextField txtQty;

    public void btnSearch(ActionEvent actionEvent) {
        Item item = searchItem(txtID.getText());
        if (item != null) {
            txtName.setText(item.getName());
            txtQty.setText(String.valueOf(item.getQty()));
            txtprice.setText(String.valueOf(item.getPrice()));
            txtDiscription.setText(item.getDiscrition());
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Item Not Found");
            alert.setHeaderText(null);
            alert.setContentText("Item not found.");
            alert.showAndWait();
        }



    }


    private Item searchItem(String id) {
        return DBConnection.getInstance().getItemById(id);
    }




    public void btnDelete(ActionEvent actionEvent) {


        String id = txtID.getText();

        if (id.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter an ID to delete.");
            alert.showAndWait();
            return;
        }

        boolean isDeleted = DBConnection.getInstance().deleteItemById(id);

        if (isDeleted) {
            clearFields();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Item with ID " + id + " has been successfully deleted.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Item Not Found");
            alert.setHeaderText(null);
            alert.setContentText("No item found with ID " + id + ".");
            alert.showAndWait();
        }


    }

    private void clearFields() {
        txtID.setText("");
        txtName.setText("");
        txtQty.setText("");
        txtprice.setText("");
        txtDiscription.setText("");

    }


}


