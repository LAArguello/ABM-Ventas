/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ventasdao.dominio.Conexion;
import ventasdao.objetos.Factura;
import ventasdao.objetos.Lineafactura;
import ventasdao.objetos.Producto;

/**
 *
 * @author Arguello Leonel
 */
public class LineaFacturaControlador  implements ICrud<Lineafactura>{
    private Connection connection;
    
    private Statement stmt;
    
    private PreparedStatement ps;
    
    private ResultSet rs;
    
    private String sql;
    
    ControladorProducto controladorproducto;
    ControladorFactura controladorfactura;
   

    @Override
    public boolean crear(Lineafactura entidad) throws SQLException, Exception {
connection = Conexion.obtenerConexion ();
 String sql = "INSERT INTO lineafactura (idproducto, cantidad, idfactura, subtotal) VALUES (?,?,?,?)";
 try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, entidad.getProducto().getId());
            ps.setFloat(2, entidad.getCantidad());
            ps.setInt(3, entidad.getFactura().getId());
            ps.setFloat(4, entidad.getSubtotal());
            ps.executeUpdate();
            connection.close();
            

        } catch (SQLException ex) {
            Logger.getLogger(LineaFacturaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(Lineafactura entidad) throws SQLException, Exception {
 connection = Conexion.obtenerConexion();
        String sql = "DELETE FROM lineafactura WHERE id = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, entidad.getId());
            ps.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(LineaFacturaControlador.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public Lineafactura extraer(int id) throws SQLException, Exception {
connection = Conexion.obtenerConexion();
            sql = "SELECT * FROM lineafactura WHERE id = ?";
            ps = connection.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            
            this.rs   = ps.executeQuery();
            
            connection.close();
            
            this.rs.next();
            Lineafactura lineafactura= new Lineafactura();
            lineafactura.setId(id);
            lineafactura.setFactura(getfactura(rs.getInt("idfactura")));
            lineafactura.setProducto(getproducto(rs.getInt("idproducto")));
            lineafactura.setCantidad(rs.getFloat("cantidad"));
            lineafactura.setSubtotal(rs.getFloat("subtotal"));
            
            
            return lineafactura;

    }

    @Override
    public boolean modificar(Lineafactura entidad) throws SQLException, Exception {
connection = Conexion.obtenerConexion();
        this.sql= "UPDATE lineafactura SET idproducto=?, cantidad=?, idfactura=?, subtotal=? WHERE id=?";
              
        try {
         ps = connection.prepareStatement(sql);
            ps.setInt(1, entidad.getProducto().getId());
            ps.setFloat(2, entidad.getCantidad());
                ps.setInt(3, entidad.getFactura().getId());
                ps.setFloat(4, entidad.getSubtotal());
            ps.setInt(5, entidad.getId());
           

            ps.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(LineaFacturaControlador.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
    }

    @Override
    public ArrayList<Lineafactura> listar() throws SQLException, Exception {
 connection = Conexion.obtenerConexion ();
        try{
            
            this.stmt = connection.createStatement();
            this.sql = "SELECT * FROM lineafactura";
            this.rs   = stmt.executeQuery(sql);
            connection.close();
            
            ArrayList<Lineafactura> lineafactura = new ArrayList();
            
            while(rs.next()){
                Lineafactura lineaFactura= new Lineafactura();
                lineaFactura.setId(rs.getInt("id"));
                lineaFactura.setProducto(getproducto(rs.getInt("idproducto")));
                lineaFactura.setFactura(getfactura(rs.getInt("idfactura")));
                lineaFactura.setCantidad(rs.getFloat("cantidad"));
                lineaFactura.setSubtotal(rs.getFloat("subtotal"));
                
                
                
                lineafactura.add(lineaFactura);
                
            }
            return lineafactura;
        } catch(SQLException ex){
        }
        return null;
    }
    public ArrayList<Lineafactura> listarlist(int id) throws SQLException, Exception {
      connection = Conexion.obtenerConexion ();
   
      sql = "SELECT subtotal FROM lineafactura WHERE id = ?";
            ps = connection.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            this.rs   = ps.executeQuery();
            
            connection.close();
            
             ArrayList<Lineafactura> lineafactura = new ArrayList();
            
            while(rs.next()){
                Lineafactura lineaFactura= new Lineafactura();
                lineaFactura.setId(id);
                lineaFactura.setSubtotal(rs.getFloat("subtotal"));
                lineafactura.add(lineaFactura);
            }
            return lineafactura;
           
    }
            
           
    
      private Factura getfactura(Integer id) throws Exception{
     this.controladorfactura = new ControladorFactura();
     Factura factura= controladorfactura.extraer(id);
     return factura;
 }   
      private Producto getproducto(Integer id) throws Exception{
     this.controladorproducto = new ControladorProducto();
     Producto producto= controladorproducto.extraer(id);
     return producto;
 }   
}
   