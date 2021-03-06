/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pecosa.model;

import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author OGPL
 */
@ManagedBean
@RequestScoped
public class VerificarDistribucion implements Serializable {

    private Integer cantidad;
    private String fecha;
    private Integer id_numero;
    private Integer codigo;
    private Integer id_usuario;
    private Integer id_distribucion;
    private String flac;
    
    public VerificarDistribucion() {
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getId_numero() {
        return id_numero;
    }

    public void setId_numero(Integer id_numero) {
        this.id_numero = id_numero;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Integer getId_distribucion() {
        return id_distribucion;
    }

    public void setId_distribucion(Integer id_distribucion) {
        this.id_distribucion = id_distribucion;
    }

    public String getFlac() {
        return flac;
    }

    public void setFlac(String flac) {
        this.flac = flac;
    }

}
