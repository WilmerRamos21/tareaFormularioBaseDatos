import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class bienvenidaForm {
    private JTable datosUsuario;
    public JPanel tablaDatos;
    private JLabel Bienvenida;



    public bienvenidaForm(String nombre) {
        // Mostrar mensaje de bienvenida
        Bienvenida.setText("¡Bienvenido " + nombre + "!");
        // Inicializar la tabla con un modelo vacío
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Cedula");
        datosUsuario.setModel(tableModel);
        // Cargar datos desde la base de datos
        cargarDatos(tableModel);
    }
        private void cargarDatos (DefaultTableModel tableModel){
            String url = "jdbc:mysql://localhost:3306/usuarios25a";
            String user = "root";
            String password = "";

            try {
                Connection conn = DriverManager.getConnection(url, user, password);
                System.out.println("Cargando datos en la tabla...");
                String query = "SELECT * FROM datosTabla";
                PreparedStatement pst = conn.prepareStatement(query);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    String nombre = rs.getString("Nombre");
                    String cedula = rs.getString("Cedula");

                    tableModel.addRow(new Object[]{nombre, cedula});
                }
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al cargar los datos en la tabla.");
            }
        }
    }



