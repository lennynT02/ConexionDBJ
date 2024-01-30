package Clase_15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class datos {
    // Establecer los parametros
    String nombre;
    String cedula;
    int nota1;
    int nota2;

    // Constructor

    public datos(String nombre, String cedula, int nota1, int nota2) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }
    //
    public datos(){

    }
    // Otro metodo personalizado para probar la conexion a la base de datos
    public void ingresoDatos(String nombre,String cedula,int nota1,int nota2) {
        try(Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/estudiantes","root","")){
            // Formato para insertar los valores
            String sql="INSERT INTO calificaciones(nombre,cedula,calificacion1,calificacion2)VALUES(?,?,?,?)";
            //Para verificar si no estar repetidos los datos
            try (PreparedStatement preparedStatement=connection.prepareStatement(sql)){
                // Setear los valores
               preparedStatement.setString(1,nombre);
               preparedStatement.setString(2,cedula);
               preparedStatement.setString(3, String.valueOf(nota1));
               preparedStatement.setString(4, String.valueOf(nota2));
               int filasAfectadas=preparedStatement.executeUpdate();
               if(filasAfectadas>0){
                   System.out.println("Inserccion exitosa");

               }else{
                   System.out.println("Inserto de datos fallido");
               }

            }catch (Exception e){
                e.printStackTrace();
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}