/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
/**
 *
 * @author Gokhan
 */
public class Order
{
    private int OrderID;
    private String OrderItem;
    private String OrderOptions;
    private int OrderQTY;
    private int OrderPrice;
    private int OrderTotal;

    public Order(int Order_ID, String OrderItem, String OrderOptions, int OrderQTY, int OrderPrice, int OrderTotal){
        this.OrderID = Order_ID;
        this.OrderItem = OrderItem;
        this.OrderOptions = OrderOptions;
        this.OrderQTY = OrderQTY;
        this.OrderPrice = OrderPrice;
        this.OrderTotal = OrderTotal;
    }
    public int getOrderID(){ return OrderID; }

    public String getOrderItem(){ return OrderItem; }

    public String getOrderOptions(){ return OrderOptions; }

    public int getOrderQTY(){ return OrderQTY; }

    public int getOrderPrice(){ return OrderPrice; }

    public int getOrderTotal(){ return OrderTotal; }

    @Override
    public String toString(){
        return "Order{" + "OrderID=" + OrderID + ", OrderItem=" + OrderItem + ", OrderOptions=" + OrderOptions + ", OrderQTY="  + OrderQTY + ", OrderPrice=" + OrderPrice + ", OrderTotal=" + OrderTotal + '}';
    }
}

