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
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ventasdao.dominio.Conexion;
import ventasdao.objetos.Factura;
import ventasdao.objetos.Producto;
import ventasdao.objetos.Cliente;

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
    
    private ControladorProducto controladorProducto;
    
    private ClienteControlador controladorCliente;

    @Override
    public boolean crear(Factura entidad) throws SQLException, Exception {
        connection = Conexion.obtenerConexion ();
 String sql = "INSERT INTO factura (fecha,cliente,productos,cantidad,forma_pago,observacion,total) VALUES (?,?,?,?,?,?,?)";
        Date fecha= new Date (entidad.getFecha().getTime());
        try {
            ps = connection.prepareStatement(sql);
            ps.setDate(1, fecha);
            ps.setInt(2, entidad.getId_cliente().getId());
            ps.setString(3,entidad.getProductos());
            ps.setFloat(4, entidad.getCantidad_producto());
            ps.setString(5, entidad.getForma_pago());
            ps.setString(6, entidad.getObservacion());
            ps.setFloat(7, entidad.getTotal());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Factura entidad) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                factura.setProductos(rs.getString("productos"));
                factura.setCantidad_producto(rs.getFloat("cantidad"));
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
    
    
       private Cliente getcliente(Integer id) throws Exception{
     this.controladorCliente = new ClienteControlador();
     Cliente cliente= controladorCliente.extraer(id);
     return cliente;
 }   
}
