package org.com.almacen.model;

public class Drone {

    private String codigo;
    private String descripcion;
    private String tipo;
    private double precioVenta;
    private int stock;

    public Drone(){
    }

    public Drone(String codigo, String descripcion,String tipo ,double precioVenta, int stock) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.precioVenta = precioVenta;
        this.stock = stock;
    }

    //
    public String getCodigo(){
        return codigo;
    }
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    //
    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    //
    public String getTipo(){
        return tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    //
    public double getPrecioVenta(){
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta){
        this.precioVenta = precioVenta;
    }
    //
    public int getStock(){
        return stock;
    }

    public void setStock(int stock){
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Drone{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", tipo='" + tipo + '\'' +
                ", precioVenta=" + precioVenta +
                ", stock=" + stock +
                '}';
    }

}
