package model;

public class SaleOrder {

    private int seq;
    private int orderid;
    private int quantity;
    private double totalprice;
    private String orderstatus;
    private int foodid;
    private int employeeid;
    private double cash;
    private String paymentMethod;
    private String timestamp;

    public SaleOrder(){

    }

    public SaleOrder(int orderid, int quantity, double totalprice, String orderstatus, int foodid, int employeeid, String timestamp){
        this.orderid = orderid;
        this.quantity = quantity;
        this.totalprice = totalprice;
        this.orderstatus = orderstatus;
        this.foodid = foodid;
        this.employeeid = employeeid;
        this.timestamp = timestamp;
    }

    public SaleOrder(int seq, int orderid, int quantity, double totalprice, String orderstatus, int foodid, int employeeid, String timestamp){
        this.seq = seq;
        this.orderid = orderid;
        this.quantity = quantity;
        this.totalprice = totalprice;
        this.orderstatus = orderstatus;
        this.foodid = foodid;
        this.employeeid = employeeid;
        this.timestamp = timestamp;
    }

    public int getSeq(){
        return seq;
    }

    public void setSeq(int seq){
        this.seq = seq;
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

    public double getTotalPrice() {
        return totalprice;
    }

    public void setTotalPrice(double totalprice) {
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

    public double getCash(){
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public String getPaymentMethod(){
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getTimestamp(){
        return timestamp;
    }

    public void setTimestamp(String timestamp){
        this.timestamp = timestamp;
    }

}
