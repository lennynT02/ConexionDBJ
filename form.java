package Clase_15;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class form {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JLabel titulo;
    private JButton conexion;
    private JLabel texto1;
    private JLabel texto2;
    private JLabel texto3;
    private JLabel texto4;
    private JButton insertard;
    private JButton borrar;
    JPanel panel1;

    public form() {
        conexion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Nombre de la clase de la conexion
                conexion miconexion=new conexion();
                // Conexion con la base de datos
                miconexion.conexionlocaL("jdbc:mysql://localhost:3306/estudiantes","root","");
                //
                //mensaje1.setText(miconexion.getMensaje());

            }
        });
        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");

            }
        });
        insertard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // para almacenar los paramteros que vamos a enviar
                datos insertarDatos=new datos();
                //insertarDatos.ingresoDatos("Frank","123456789",8,7);
                // Elemntos que esten guardados en en textfield1
                //textField1.getText()
                // Toma los valores de los textfield en los numeros cambiamos a enteros porque estan en texto y por eso el error
                insertarDatos.ingresoDatos(textField1.getText(),textField2.getText(),Integer.parseInt(textField3.getText()),Integer.parseInt(textField4.getText()));

            }
        });
    }
}