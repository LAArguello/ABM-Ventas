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
import java.util.logging.Level;
import java.util.logging.Logger;

import ventasdao.dominio.Conexion;
import ventasdao.objetos.Cliente;
import ventasdao.objetos.TipoCliente;

/**
 *
 * @author Hugo Chanampe
 */
public class ClienteControlador implements ICrud<Cliente>{
    
    private Connection connection;
    
    private Statement stmt;
    
    private PreparedStatement ps;
    
    private ResultSet rs;
    
    private String sql;
    
    private TipoCliente tipcli;
    

    //public void modificarCategoria(Categoria c);
    //public Categoria obtenerCategoria(Integer id);
    //public void eliminarCategoria(Categoria c);
    
    @Override
    public boolean crear(Cliente entidad) throws SQLException, Exception{

        connection = Conexion.obtenerConexion ();
        String sql = "INSERT INTO clientes (nombre,documento,apellido,cliente_tipo_id) VALUES (?,?,?,?)";
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getDocumento());
            ps.setString(3, entidad.getApellido ());
            ps.setInt(4,entidad.getTipocliente().getId());
            ps.executeUpdate();
            connection.close();
            

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(Cliente entidad)throws SQLException,Exception {
        
     connection = Conexion.obtenerConexion();
        String sql = "DELETE FROM clientes WHERE id = ?";
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, entidad.getId());
            ps.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaControlador.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }   
    

    @Override
    public ArrayList<Cliente> listar() throws SQLException,Exception{
        
     connection = Conexion.obtenerConexion ();
        try{
            
            this.stmt = connection.createStatement();
            this.sql = "SELECT * FROM clientes";
            this.rs   = stmt.executeQuery(sql);
            connection.close();
            
            ArrayList<Cliente> clientes = new ArrayList();
            
            while(rs.next()){
                tipcli= new TipoCliente();
                
                Cliente cliente = new Cliente();
                
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido (rs.getString("apellido"));
                cliente.setDocumento(rs.getString("documento"));
                tipcli.setId(rs.getInt("cliente_tipo_id"));
                cliente.setTipocliente(tipcli);

                
                        //System.out.println(cliente);
                
                
                clientes.add(cliente);
                
            }
            //System.out.println(cont);
            return clientes;
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    

    }

    @Override
    public boolean modificar(Cliente entidad) throws SQLException, Exception {
           connection = Conexion.obtenerConexion();
        this.sql= "UPDATE clientes SET nombre=?, apellido=?, documento=?, cliente_tipo_id=? WHERE id=?";
          try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getApellido());
            ps.setString(3, entidad.getDocumento());
            ps.setInt(4, entidad.getTipocliente().getId());
            ps.setInt(5,entidad.getId());
            ps.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

     

    @Override
    public Cliente extraer(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
