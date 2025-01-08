import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class form1 {
    public JPanel loginPanel;
    private JTextField usuarioTxt;
    private JTextField contraseniaTxt;
    private JButton loginBtn;

    public form1() {
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/usuarios25a";
                String user = "root";
                String password = "";
                String username = usuarioTxt.getText();
                String pass = contraseniaTxt.getText();


                try {
                    Connection conn = DriverManager.getConnection(url, user, password);
                    System.out.println("Se ha conectado con la base de datos.");
                    Statement stmt = conn.createStatement();
                    // Consulta SQL con parámetros
                    String query = "SELECT * FROM datosTabla WHERE Nombre = ? AND Cedula = ?";
                    PreparedStatement pst = conn.prepareStatement(query);
                    // Asignar valores a los parámetros
                    pst.setString(1, username);
                    pst.setString(2, pass);
                    // Ejecutar la consulta
                    ResultSet rs = pst.executeQuery();
                    // Procesar los resultados
                    if (rs.next()) {
                        // Login
                        String nombre = rs.getString("Nombre");
                        JOptionPane.showMessageDialog(null, "¡Bienvenido " + nombre + "!");
                        // Abrir el segundo formulario y pasar datos
                        JFrame frame = new JFrame("Tabla de Datos de Usuarios");
                        frame.setContentPane(new bienvenidaForm(nombre).tablaDatos);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.pack();
                        frame.setVisible(true);
                        // Cerrar el formulario de login
                        SwingUtilities.getWindowAncestor(loginPanel).dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
                    }
                    conn.close();
                } catch (SQLException e1) {
                    throw new RuntimeException(e1);
                }
            }
        });
    }
}
