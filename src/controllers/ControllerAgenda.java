/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelAgenda;
import views.ViewAgenda;

/**
 *
 * @author Salvador Hernandez Mendoza
 */
public class ControllerAgenda {

    ModelAgenda modelAgenda;
    ViewAgenda viewAgenda;

    /**
     * Objeto de tipo ActionListener para atrapar los eventos actionPerformed y
     * llamar a los metodos para ver los registros almacenados en la bd.
     */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewAgenda.jbtn_primero) {
                jbtn_primero_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_anterior) {
                jbtn_anterior_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_siguiente) {
                jbtn_siguiente_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_ultimo) {
                jbtn_ultimo_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_nuevo) {
                jbtn_nuevoR_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_insertar) {
                jbtn_insertarR_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_modificar) {
                jbtn_cambiarR_actionPerformed();
            } else if (e.getSource() == viewAgenda.jbtn_eliminar) {
                jbtn_eliminarR_actionPerformed();
            }

        }

    };

    /**
     * Constructor de Controlador para unir el ModelAgenda y ViewAgenda
     *
     * @param modelAgenda objeto de tipo ModelAgenda
     * @param viewAgenda objeto de tipo ViewAgenda
     */
    public ControllerAgenda(ModelAgenda modelAgenda, ViewAgenda viewAgenda) {
        this.modelAgenda = modelAgenda;
        this.viewAgenda = viewAgenda;
        initComponents();
        setActionListener();
        initDB();
    }

    /**
     * Método que llama al método conectarBD del modelo y muestra el nombre y
     * email del primer registro en las cajas de texto de ViewAgenda.
     */
    public void initDB() {
        modelAgenda.conectarDB();
        viewAgenda.jtf_id.setText(String.valueOf(modelAgenda.getId().toString()));
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
        viewAgenda.jtf_email.setText(modelAgenda.getEmail());
    }

    /**
     * Metodo para inicializar la ViewAgenda
     */
    public void initComponents() {
        viewAgenda.setTitle("Actividad 12 - Base de datos MVC v 0.1");
        viewAgenda.setResizable(false);
        viewAgenda.setLocationRelativeTo(null);
        viewAgenda.setVisible(true);
        viewAgenda.jbtn_insertar.setEnabled(false);
        viewAgenda.jtf_id.setEnabled(false);
    }

    /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    public void setActionListener() {
        viewAgenda.jbtn_primero.addActionListener(actionListener);
        viewAgenda.jbtn_anterior.addActionListener(actionListener);
        viewAgenda.jbtn_siguiente.addActionListener(actionListener);
        viewAgenda.jbtn_ultimo.addActionListener(actionListener);
        viewAgenda.jbtn_nuevo.addActionListener(actionListener);
        viewAgenda.jbtn_insertar.addActionListener(actionListener);
        viewAgenda.jbtn_modificar.addActionListener(actionListener);
        viewAgenda.jbtn_eliminar.addActionListener(actionListener);
    }

    /**
     * Método para ver el primer registro de la tabla contactos
     */
    private void jbtn_primero_actionPerformed() {
        System.out.println("Action del boton jbtn_primero");
        modelAgenda.moverPrimerRegistro();
        viewAgenda.jtf_id.setText(modelAgenda.getId().toString());
        viewAgenda.jtf_email.setText(modelAgenda.getEmail());
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
        //invocar al metodo moverPrimerRegistro
        //mostrar nombre en la vista
        //mostar email en la vista
    }

    /**
     * Método para ver el registro anterior de la tabla contactos
     */
    private void jbtn_anterior_actionPerformed() {
        System.out.println("Action del boton jbtn_anterior");
        modelAgenda.moverAnteriorRegistro();
        viewAgenda.jtf_id.setText(modelAgenda.getId().toString());
        viewAgenda.jtf_email.setText(modelAgenda.getEmail());
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
        //invocar al metodo moverAnteriorRegistro
        //mostrar nombre en la vista
        //mostar email en la vista
    }

    /**
     * Método para ver el último registro de la tabla contactos
     */
    private void jbtn_ultimo_actionPerformed() {
        System.out.println("Action del boton jbtn_ultimo");
        modelAgenda.moverUltimoRegistro();
        viewAgenda.jtf_id.setText(modelAgenda.getId().toString());
        viewAgenda.jtf_email.setText(modelAgenda.getEmail());
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
        //invocar al metodo moverUltimoRegistro
        //mostrar nombre en la vista
        //mostar email en la vista
    }

    /**
     * Método para ver el siguiente registro de la tabla contactos
     */
    private void jbtn_siguiente_actionPerformed() {
        System.out.println("Action del boton jbtn_siguiente");
        modelAgenda.moverSiguienteRegistro();
        viewAgenda.jtf_id.setText(modelAgenda.getId().toString());
        viewAgenda.jtf_email.setText(modelAgenda.getEmail());
        viewAgenda.jtf_nombre.setText(modelAgenda.getNombre());
        //invocar al metodo moverSiguienteRegistro
        //mostrar nombre en la vista
        //mostar email en la vista
    }

    /**
     * Método para ver insertar nuevo registro en la tabla de contactos
     */
    private void jbtn_nuevoR_actionPerformed() {
        System.out.println("Accion de boton nuevo registro");
        viewAgenda.jbtn_insertar.setEnabled(true);
        viewAgenda.jbtn_modificar.setEnabled(false);
        viewAgenda.jbtn_eliminar.setEnabled(false);
        viewAgenda.jbtn_nuevo.setEnabled(false);

        for (Component component : viewAgenda.jPanelComponents.getComponents()) {
            viewAgenda.jbtn_primero.setEnabled(false);
            viewAgenda.jbtn_siguiente.setEnabled(false);
            viewAgenda.jbtn_anterior.setEnabled(false);
            viewAgenda.jbtn_ultimo.setEnabled(false);

        }

    }

    private void jbtn_insertarR_actionPerformed() {
        viewAgenda.jbtn_insertar.setEnabled(false);
        viewAgenda.jbtn_modificar.setEnabled(true);
        viewAgenda.jbtn_eliminar.setEnabled(true);
        viewAgenda.jbtn_nuevo.setEnabled(true);

        for (Component component : viewAgenda.jPanelComponents.getComponents()) {
            viewAgenda.jbtn_primero.setEnabled(true);
            viewAgenda.jbtn_siguiente.setEnabled(true);
            viewAgenda.jbtn_anterior.setEnabled(true);
            viewAgenda.jbtn_ultimo.setEnabled(true);
        }
    }

    /**
     * Método para modificar un registro en la tabla de contactos
     */
    private void jbtn_cambiarR_actionPerformed() {
        System.out.println("Accion de boton modificar registro");
    }

    /**
     * Método para eliminar registro en la tabla de contactos
     */
    private void jbtn_eliminarR_actionPerformed() {
        System.out.println("Accion de boton eliminar registro");
    }
}
