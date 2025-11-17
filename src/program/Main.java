package program;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Main extends JFrame {

    private JPanel DonutGuiPanel;
    private JLabel ShopName;
    private JLabel FilterLable;
    private JLabel MenuLable;
    private JLabel OrderLable;
    private JList list1;
    private JTable table1;

    public Main() {
        setContentPane(DonutGuiPanel);
        setTitle("DonutShop GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
    public static void main(String[] args) {
        new Main();
    }
}
