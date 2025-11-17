package program;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Main extends JFrame {

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

        DefaultTableModel model = (DefaultTableModel) OrderTable.getModel();

        // Add rows
        model.addRow(new Object[]{"round", "red"});
        model.addRow(new Object[]{"square", "green"});

    }
    public static void main(String[] args) {
        new Main();
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
