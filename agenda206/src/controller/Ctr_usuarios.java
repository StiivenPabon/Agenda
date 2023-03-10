/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import conexion.Conexion;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Mdl_Personas;
import model.Mdl_Users;

/**
 *
 * @author scorpion
 */
public class Ctr_usuarios {

    public ArrayList<Mdl_Users> consultar() {
        ArrayList<Mdl_Users> listauser = new ArrayList();
        Conexion conectar = new Conexion();
        Ctr_Personas cp = new Ctr_Personas();
        Mdl_Personas persona = new Mdl_Personas();
        String sql = "SELECT * FROM users WHERE estado = '1'";
        ResultSet rs;
        try {
            rs = conectar.consultar(sql);
            while(rs.next()){
                Mdl_Users user = new Mdl_Users();
                user.setIduser(rs.getInt("IDUSER"));
                user.setClave(rs.getString("CLAVE"));
                user.setTipouser(rs.getString("TIPO_USER"));
                user.setNombreuser(rs.getString("NOMBRE_USER"));
                user.setUestado(rs.getString("ESTADO"));
                user.setUfechamodificacion(rs.getString("FECHA_MODIFICACION"));
                user.setUfecharegistro(rs.getString("FECHA_REGISTRO"));
                persona = cp.consultar(rs.getInt("PERSONA"));
                user.setApellidos(persona.getApellidos());
                user.setNombres(persona.getNombres());
                user.setEstado(persona.getEstado());
                user.setFechamodificacion(persona.getFechamodificacion());
                user.setFecharegistro(persona.getFecharegistro());
                user.setIdpersona(persona.getIdpersona());
                listauser.add(user);
            }
        } catch (Exception error) {
            System.out.println("Error en la consulta de usuario :"+error);
            JOptionPane.showMessageDialog(null,"Error en la consulta de usuario");
        }
        return listauser;
    }

}
