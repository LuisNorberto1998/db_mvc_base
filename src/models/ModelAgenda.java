/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Salvador Hernandez Mendoza
 */
public class ModelAgenda {

    private Connection conexion;
    private Statement st;
    private ResultSet rs;

    private Integer id;
    private String nombre;
    private String email;

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public Statement getSt() {
        return st;
    }

    public void setSt(Statement st) {
        this.st = st;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void cambiarDatos() {
        try {
            this.setId(rs.getInt("id_contacto"));
            this.setNombre(rs.getString("nombre"));
            this.setEmail(rs.getString("email"));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error ModelAgenda 001: \n" + e.getMessage());
        }
    }

    /**
     * Método que realiza las siguietnes acciones: 1.- Conecta con la base
     * agenda_mvc. 2.- Consulta todo los registros de la tabla contactos. 3.-
     * Obtiene el nombre y el email y los guarda en las variables globales
     * nombre y email.
     */
    public void conectarDB() {
        try {
            conexion = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda_mvc", "user_mvc", "pass_mvc.2018");
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT * FROM contactos;");
            rs.next();
            id = rs.getInt("id_contacto");
            nombre = rs.getString("nombre");
            email = rs.getString("email");

            this.setId(id);
            this.setEmail(email);
            this.setNombre(nombre);
        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, "Error ModelAgenda 002: " + sql.getMessage());
        }

    }

    /**
     * Método que realiza las siguiente acciones: 1.- Moverse al primer registro
     * 2.- obtener el valor del nombre de rs y guardarlo en la variable nombre
     * 3.- obtener el valor del email de rs y guardarlo en la variable email
     */
    public void moverPrimerRegistro() {
        System.out.print("Programa accion moverPrimerRegistro");
        try {
            rs.first();
            cambiarDatos();
        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, "Error ModelAgenda 004: " + sql.getMessage());
        }
    }

    /**
     * Método que realiza las siguiente acciones: 1.- Moverse al siguiente
     * registro 2.- obtener el valor del nombre de rs y guardarlo en la variable
     * nombre 3.- obtener el valor del email de rs y guardarlo en la variable
     * email
     */
    public void moverSiguienteRegistro() {

        try {
            if (!rs.isLast()) {
                rs.next();
                cambiarDatos();
                System.out.print("Programa accion moverSiguienteRegistro");
            }

        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, "Error ModelAgenda 005: " + sql.getMessage());
        }
    }

    /**
     * Método que realiza las siguiente acciones: 1.- Moverse al anterior
     * registro 2.- obtener el valor del nombre de rs y guardarlo en la variable
     * nombre 3.- obtener el valor del email de rs y guardarlo en la variable
     * email
     */
    public void moverAnteriorRegistro() {

        try {
            if (!rs.isFirst()) {
                rs.previous();
                cambiarDatos();
                System.out.print("Programa accion moverAnteriorRegistro");

            }

        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, "Error ModelAgenda 006: " + sql.getMessage());
        }
    }

    /**
     * Método que realiza las siguiente acciones: 1.- Moverse al ultimo registro
     * 2.- obtener el valor del nombre de rs y guardarlo en la variable nombre
     * 3.- obtener el valor del email de rs y guardarlo en la variable email
     */
    public void moverUltimoRegistro() {
        System.out.print("Programa accion moverUltimoRegistro");
        try {
            rs.last();
            cambiarDatos();
        } catch (SQLException sql) {
            JOptionPane.showMessageDialog(null, "Error ModelAgenda 007: " + sql.getMessage());
        }
    }

}
