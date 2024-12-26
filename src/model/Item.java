package model;

public class Item {

    private String ID;
    private String Name;
    private int Qty;
    private Double Price;
    private String Discrition;

    public Item() {
    }

    public Item( String ID,String name, int qty, Double price, String discrition) {
        this.Name = name;
        this.ID = ID;
        this.Qty = qty;
        this.Price = price;
        this.Discrition = discrition;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        this.Qty = qty;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        this.Price = price;
    }

    public String getDiscrition() {
        return Discrition;
    }

    public void setDiscrition(String discrition) {
        this.Discrition = discrition;
    }

    @Override
    public String toString() {
        return "Item{" +
                "ID='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                ", Qty=" + Qty +
                ", Price=" + Price +
                ", Discrition='" + Discrition + '\'' +
                '}';
    }



}
