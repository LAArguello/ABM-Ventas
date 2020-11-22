/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.objetos;

/**
 *
 * @author Arguello Leonel
 */
public class Cliente {
    
    private Integer id;
    private String documento;
    private String nombre;
    private String apellido;
   private TipoCliente tipocliente;

    public TipoCliente getTipocliente() {
        return tipocliente;
   
    }
    public void setTipocliente(TipoCliente tipocliente) {
        this.tipocliente = tipocliente;
    }




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getDocumento() { return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

@Override
    public String toString() {
        return nombre + " "+ apellido; //To change body of generated methods, choose Tools | Templates.
     
}
}
