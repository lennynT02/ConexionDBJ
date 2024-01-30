package Clase_15;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {
    String servidor;
    String  usuario;
    String contraseña;
    String mensaje;
    public conexion(String servidor, String usuario, String contraseña) {
        this.servidor = servidor;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }
    public conexion(){
    }
    public void conexionlocaL(String servidor,String usuario,String contraseña){
        try(Connection connection= DriverManager.getConnection(servidor,usuario,contraseña)){
            if(connection != null){
                System.out.println("Conexion Correcta");
            }

        }catch (Exception e){
            System.out.println("Error. La conexion esta deshabilitada");
            e.printStackTrace();

        }
    }
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}