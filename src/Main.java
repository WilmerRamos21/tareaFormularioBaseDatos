import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        JFrame frame = new JFrame(" Login de usuario ");
        frame.setContentPane(new form1().loginPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setPreferredSize(new Dimension(600, 400));
        frame.setVisible(true);
        frame.pack();
    }
}