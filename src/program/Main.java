package program;

import entity.DAO;
import entity.Order;
import entity.OrderDAO;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Main extends JFrame {
    private static DAO OrderDAO;

    private JPanel DonutGuiPanel;
    private JLabel ShopName;
    private JLabel MenuLable;
    private JLabel OrderLable;
    private JTable OrderTable;
    private JScrollPane OrderScrollPane;
    private JList MenuList;
    private JScrollPane MenuScrollPane;
    private JButton OrderButton;
    private JSpinner QTYspinner;
    private JLabel QTYLable;

    public Main() {
        setContentPane(DonutGuiPanel);
        setTitle("DonutShop GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);


        //Hardcoded button
        OrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) OrderTable.getModel();
                model.addRow(new Object[]{"1", "Donut1", "Sprinkles", "2", "$1.99", "$3.98"});
            }
        });
        //Attempt at list (doesn't work)
//        MenuList.addListSelectionListener(new ListSelectionListener() {
//            @Override
//            public void valueChanged(ListSelectionEvent e) {
//                String OrderItem = MenuList.getSelectedValue().toString();
//                addOrder(OrderItem);
//
 //            }
//        });
    }
    public static void main(String[] args) {
        new Main();
    }

    //Database Attempt
    private static void addOrder(int OrderID, String OrderItem, String OrderOptions, int OrderQTY, int OrderPrice, int OrderTotal) {
        Order order;
        order = new Order(OrderID, OrderItem, OrderOptions, OrderQTY, OrderPrice, OrderTotal);
        OrderDAO.insert(order);
    }
    //fetch
    private void refreshOrdersTable() {
        List<Order> orders = OrderDAO.getAll();
        DefaultTableModel model = (DefaultTableModel) OrderTable.getModel();
        //Clear all items in OrderTable
        for(int i = model.getRowCount() - 1; i >= 0; i-- ) {
            model.removeRow(i);
        }
        for (Order order : orders) {
            Object[] row = new Object[6];
            row[0] = order.getOrderID();
            row[1] = order.getOrderItem();
            row[2] = order.getOrderOptions();
            row[3] = order.getOrderQTY();
            row[4] = order.getOrderPrice();
            row[5] = order.getOrderTotal();
            model.addRow(row);
        }
    }

    private void createUIComponents() {
        OrderTable = new JTable(
                new DefaultTableModel(
                        new Object [][] {

                        },
                        new String [] {
                                "ID", "Item", "Options", "QTY", "Price", "Total"
                        }
                )

        );

    }
}
