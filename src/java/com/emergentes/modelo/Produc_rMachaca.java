
package com.emergentes.modelo;

/**
 *
 * @author Ruben
 */
public class Produc_rMachaca {
    private int id;
    private String descripcion;
    private int cantidad;
    private double precio;
    private String categoria;

    public Produc_rMachaca() {
        id = 0;
        descripcion = "";
        cantidad = 0;
        precio = 0.0;
        categoria = "";
    }
    

    public Produc_rMachaca(int id, String descripcion, int cantidad, double  precio, String categoria) {
        this.id = id;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
    
}
