package DB;

import model.Item;

import java.util.ArrayList;
import java.util.List;

public class DBConnection {

    private static DBConnection instance;

    private List<Item> itemList;
    private DBConnection() {
        itemList = new ArrayList<>();
    }

    public List<Item> getConnection() {
        return itemList;
    }

    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }


    public Item getItemById(String id) {
        for (Item item : itemList) {
            if (item.getID().equalsIgnoreCase(id)) {
                return item;
            }
        }
        return null;
    }

    public boolean deleteItemById(String id) {
        Item itemToDelete = getItemById(id);
        if (itemToDelete != null) {
            itemList.remove(itemToDelete);
            return true;
        }
        return false;
    }



}
