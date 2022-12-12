package model;

public class SaleOrder {
    private int orderid;
    private int quantity;
    private int totalprice;
    private String orderstatus;
    private int foodid;
    private int employeeid;

    public SaleOrder(){

    }

    public SaleOrder(int orderid, int quantity, int totalprice, String orderstatus, int foodid, int employeeid){
        this.orderid = orderid;
        this.quantity = quantity;
        this.totalprice = totalprice;
        this.orderstatus = orderstatus;
        this.foodid = foodid;
        this.employeeid = employeeid;
    }

    public int getOrderID() {
        return orderid;
    }

    public void setOrderID(int orderid) {
        this.orderid = orderid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return totalprice;
    }

    public void setTotalPrice(int totalprice) {
        this.totalprice = totalprice;
    }

    public String getOrderStatus() {
        return orderstatus;
    }

    public void setOrderStatus(String orderstatus) {
        this.orderstatus = orderstatus;
    }

    public int getFoodID() {
        return foodid;
    }

    public void setFoodID(int foodid) {
        this.foodid = foodid;
    }

    public int getEmployeeID() {
        return employeeid;
    }

    public void setEmployeeID(int employeeid) {
        this.employeeid = employeeid;
    }
}
