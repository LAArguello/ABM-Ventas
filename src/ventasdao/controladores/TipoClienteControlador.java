/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.controladores;

import java.sql.SQLException;
import java.util.List;
import ventasdao.objetos.TipoCliente;
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
/**
 *
 * @author Arguello Leonel
 */
public class TipoClienteControlador implements ICrud<TipoCliente>{
     private Connection connection;
    
    private Statement stmt;
    
    private PreparedStatement ps;
    
    private ResultSet rs;
    
    private String sql;

    @Override
    public boolean crear(TipoCliente entidad) throws SQLException, Exception {

        connection = Conexion.obtenerConexion ();
        String sql = "INSERT INTO cliente_tipo (nombre,descripcion) VALUES (?,?)";
        
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getDescripcion());
            ps.executeUpdate();
            connection.close();
            

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(TipoCliente entidad) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoCliente extraer(int id) throws SQLException, Exception {
    connection = Conexion.obtenerConexion();
            sql = "SELECT * FROM cliente_tipo WHERE id = ?";
            ps = connection.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            
            this.rs   = ps.executeQuery();
            
            connection.close();
            
            this.rs.next();
            TipoCliente tipocliente= new TipoCliente();
            tipocliente.setId(id);
            tipocliente.setNombre(rs.getString("nombre"));
            tipocliente.setDescripcion(rs.getString("descripcion"));
            
            return tipocliente;

    }

    @Override
    public boolean modificar(TipoCliente entidad) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TipoCliente> listar() throws SQLException, Exception {
          connection = Conexion.obtenerConexion ();
        try{
            
            this.stmt = connection.createStatement();
            this.sql = "SELECT * FROM cliente_tipo";
            this.rs   = stmt.executeQuery(sql);
            connection.close();
            
            ArrayList<TipoCliente> tipo_cliente = new ArrayList();
            
            while(rs.next()){
                
                TipoCliente tipoCliente = new TipoCliente();
                tipoCliente.setId(rs.getInt("id"));
                tipoCliente.setNombre(rs.getString("nombre"));
                tipoCliente.setDescripcion(rs.getString("descripcion"));
                
                
                
                tipo_cliente.add(tipoCliente);
                
            }
            return tipo_cliente;
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    

    }
    
}
