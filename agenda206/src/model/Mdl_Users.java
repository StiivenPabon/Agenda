/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author scorpion
 */
public class Mdl_Users extends Mdl_Personas{
    private int iduser;
    private String clave;
    private String tipouser;
    private String nombreuser;
    private String ufecharegistro;
    private String ufechamodificacion;
    private String uestado;
    private String confirmarClave;

    public Mdl_Users() {
    }

    public Mdl_Users(int iduser, String clave, String tipouser, String nombreuser, String ufecharegistro, String ufechamodificacion, String uestado) {
        this.iduser = iduser;
        this.clave = clave;
        this.tipouser = tipouser;
        this.nombreuser = nombreuser;
        this.ufecharegistro = ufecharegistro;
        this.ufechamodificacion = ufechamodificacion;
        this.uestado = uestado;
    }

    public Mdl_Users(int iduser, String clave, String tipouser, String nombreuser, String ufecharegistro, String ufechamodificacion, String uestado, int idpersona, String nombres, String apellidos, String fecharegistro, String fechamodificacion, String estado) {
        super(idpersona, nombres, apellidos, fecharegistro, fechamodificacion, estado);
        this.iduser = iduser;
        this.clave = clave;
        this.tipouser = tipouser;
        this.nombreuser = nombreuser;
        this.ufecharegistro = ufecharegistro;
        this.ufechamodificacion = ufechamodificacion;
        this.uestado = uestado;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipouser() {
        return tipouser;
    }

    public void setTipouser(String tipouser) {
        this.tipouser = tipouser;
    }

    public String getNombreuser() {
        return nombreuser;
    }

    public void setNombreuser(String nombreuser) {
        this.nombreuser = nombreuser;
    }

    public String getUfecharegistro() {
        return ufecharegistro;
    }

    public void setUfecharegistro(String ufecharegistro) {
        this.ufecharegistro = ufecharegistro;
    }

    public String getUfechamodificacion() {
        return ufechamodificacion;
    }

    public void setUfechamodificacion(String ufechamodificacion) {
        this.ufechamodificacion = ufechamodificacion;
    }

    public String getUestado() {
        return uestado;
    }

    public void setUestado(String uestado) {
        this.uestado = uestado;
    }

    public String getConfirmarClave() {
        return confirmarClave;
    }

    public void setConfirmarClave(String confirmarClave) {
        this.confirmarClave = confirmarClave;
    }
}
