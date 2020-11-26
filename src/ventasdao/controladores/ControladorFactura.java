/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.controladores;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ventasdao.dominio.Conexion;
import ventasdao.objetos.Factura;
import ventasdao.objetos.Producto;
import ventasdao.objetos.Cliente;
import ventasdao.objetos.Lineafactura;

/**
 *
 * @author Arguello Leonel
 */
public class ControladorFactura implements ICrud<Factura> {
     private Connection connection;
    
    private Statement stmt;
    
    private PreparedStatement ps;
    
    private ResultSet rs;
    
    private String sql;
    
    
    private ClienteControlador controladorCliente;

    @Override
    public boolean crear(Factura entidad) throws SQLException, Exception {
        connection = Conexion.obtenerConexion ();
 String sql = "INSERT INTO factura (fecha, cliente, forma_pago, observacion, total) VALUES (?,?,?,?,?)";
       Date fecha= new Date (entidad.getFecha().getTime());
        try {
            ps = connection.prepareStatement(sql);
            ps.setDate(1, fecha);
            ps.setInt(2, entidad.getId_cliente().getId());
            ps.setString(3, entidad.getForma_pago());
            ps.setString(4, entidad.getObservacion());
            ps.setFloat(5, entidad.getTotal());
            ps.executeUpdate();
            connection.close();
            

        } catch (SQLException ex) {
            Logger.getLogger(ControladorFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(Factura entidad) throws SQLException, Exception {
        connection = Conexion.obtenerConexion();
        String sql = "DELETE FROM factura WHERE id = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, entidad.getId());
            ps.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorFactura.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
        
    }

    @Override
    public Factura extraer(int id) throws SQLException, Exception {
connection = Conexion.obtenerConexion();
            sql = "SELECT * FROM factura WHERE id = ?";
            ps = connection.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            
            this.rs   = ps.executeQuery();
            
            connection.close();
            
            this.rs.next();
            Factura factura= new Factura();
            factura.setId(id);
            factura.setId_cliente(getcliente(rs.getInt("cliente")));
            factura.setFecha(rs.getDate("fecha"));
            factura.setForma_pago(rs.getString("forma_pago"));
            factura.setObservacion(rs.getString("observacion"));
            factura.setTotal(rs.getFloat("total"));
            
            return factura;

    }

    @Override
    public boolean modificar(Factura entidad) throws SQLException, ClassNotFoundException, Exception  {
   connection = Conexion.obtenerConexion();
        this.sql= "UPDATE factura SET fecha=?, cliente=?, forma_pago=?, observacion=?, total=? WHERE id=?";
              
        try {
           Date fecha= new Date (entidad.getFecha().getTime());

            ps = connection.prepareStatement(sql);
            ps.setDate(1, fecha);
            ps.setInt(2, entidad.getId_cliente().getId());
            ps.setString(3, entidad.getForma_pago());
            ps.setString(4, entidad.getObservacion());
            ps.setFloat(5, entidad.getTotal());
            ps.setInt(6, entidad.getId());
           

            ps.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorFactura.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
    }

    @Override
    public ArrayList<Factura> listar() throws SQLException, Exception {
 connection = Conexion.obtenerConexion ();
        try{
            
            this.stmt = connection.createStatement();
            this.sql = "SELECT * FROM factura";
            this.rs   = stmt.executeQuery(sql);
            connection.close();
            
            ArrayList<Factura> facturas = new ArrayList();
            
            while(rs.next()){
                Factura factura= new Factura();
              
                factura.setId(rs.getInt("id"));
                factura.setFecha(rs.getDate("fecha"));
                factura.setId_cliente(getcliente(rs.getInt("cliente")));
                factura.setForma_pago(rs.getString("forma_pago"));
                factura.setObservacion(rs.getString("observacion"));
                factura.setTotal(rs.getFloat("total"));
                
                facturas.add(factura);
                
            }
            return facturas;
        } catch(SQLException ex){
        }
        return null;
    }
     public boolean modificarlinea(Factura entidad) throws SQLException, ClassNotFoundException, Exception  {
   connection = Conexion.obtenerConexion();
        this.sql= "UPDATE factura SET total=? WHERE id=?";
              
        try {

            ps = connection.prepareStatement(sql);
            ps.setFloat(1, entidad.getTotal());
            ps.setInt(2, entidad.getId());
            ps.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorFactura.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
    }
    public Factura SelectFactura(Float total) throws SQLException, Exception  {
   connection = Conexion.obtenerConexion();
        this.sql= "SELECT id FROM factura WHERE total = ?";
              
            ps = connection.prepareStatement(sql);
            
            ps.setFloat(1, total);
            this.rs   = ps.executeQuery();
            
            connection.close();
            
            this.rs.next();
            Factura factura= new Factura();
            factura.setTotal(total);
            factura.setId(rs.getInt("id"));
            
            return factura;
    
    }
      public Factura SelectTotal(int id) throws SQLException, Exception  {
   connection = Conexion.obtenerConexion();
        this.sql= "SELECT total FROM factura WHERE id = ?";
              
            ps = connection.prepareStatement(sql);
            
            ps.setInt(1, id);
            this.rs   = ps.executeQuery();
            
            connection.close();
            
            this.rs.next();
            Factura factura= new Factura();
            factura.setId(id);
            factura.setTotal(rs.getFloat("total"));
            return factura;
    
    }
    
       private Cliente getcliente(Integer id) throws Exception{
     this.controladorCliente = new ClienteControlador();
     Cliente cliente= controladorCliente.extraer(id);
     return cliente;
 }   
}
