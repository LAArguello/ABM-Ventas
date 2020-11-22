package ventasdao.objetos;

import java.util.Date;

public class Producto {
    private Integer id;
    
    private Categoria categoria;

    private String nombre;

    private String descripcion;

    private Float precio;
    
    private Date fecha_alta;

    public Producto() {
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
      //return nombre +" "+ ", Precio:"+" "+ precio +"$"; 
//To change body of generated methods, choose Tools | Templates.
return nombre;
    }
   
}
