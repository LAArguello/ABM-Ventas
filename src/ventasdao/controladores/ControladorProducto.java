package ventasdao.controladores;

import ventasdao.objetos.Producto;

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
import ventasdao.objetos.Cliente;
import ventasdao.objetos.TipoCliente;
import ventasdao.objetos.Categoria;


public class ControladorProducto implements ICrud<Producto> {

   
    private Connection connection;
    
    private Statement stmt;
    
    private PreparedStatement ps;
    
    private ResultSet rs;
    
    private String sql;
    
    private Categoria cat;
    private CategoriaControlador categoriaControlador;


    @Override
    public boolean crear(Producto entidad) throws SQLException, ClassNotFoundException {
         connection = Conexion.obtenerConexion ();
        String sql = "INSERT INTO productos (nombre,descripcion,precio,fecha_alta,categoria_id) VALUES (?,?,?,?,?)";
        Date fecha= new Date (entidad.getFecha_alta().getTime());
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getDescripcion());
            ps.setFloat(3, entidad.getPrecio());
            ps.setDate(4, fecha);
            ps.setInt(5,entidad.getCategoria().getId());
            ps.executeUpdate();
            connection.close();
            

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(Producto entidad) throws SQLException, ClassNotFoundException {
        connection = Conexion.obtenerConexion();
        String sql = "DELETE FROM productos WHERE id = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, entidad.getId());
            ps.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorProducto.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    

    @Override
    public boolean modificar(Producto entidad) throws SQLException, ClassNotFoundException, Exception {
          connection = Conexion.obtenerConexion();
                  Date fecha= new Date (entidad.getFecha_alta().getTime());

        this.sql= "UPDATE productos SET nombre=?, descripcion=?, precio=?, fecha_alta=?, categoria_id=? WHERE id=?";
          try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getDescripcion() );
            ps.setFloat(3,entidad.getPrecio() );
            ps.setDate(4,fecha);
            ps.setInt(5, entidad.getCategoria().getId());
            ps.setInt(6,entidad.getId());
            ps.executeUpdate();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorProducto.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
    }
    

    @Override
       public ArrayList<Producto> listar() throws SQLException,Exception{       
      connection = Conexion.obtenerConexion ();
        try{
            
            this.stmt = connection.createStatement();
            this.sql = "SELECT * FROM productos";
            this.rs   = stmt.executeQuery(sql);
            connection.close();
            
            ArrayList<Producto> productos = new ArrayList();
            
            while(rs.next()){
                Producto producto= new Producto();
                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getFloat("precio"));
                producto.setFecha_alta(rs.getDate("fecha_alta"));
                producto.setCategoria(getCategoria(rs.getInt("categoria_id")));
                productos.add(producto);
                
            }
            return productos;
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    
    }
    
    private Categoria getCategoria(Integer id) throws Exception{
     this.categoriaControlador = new CategoriaControlador();
     Categoria categoria = categoriaControlador.extraer(id);
     return categoria;
 }   
    
    
    @Override
    public Producto extraer(int id) throws SQLException, Exception {
            connection = Conexion.obtenerConexion();
            sql = "SELECT * FROM productos WHERE id = ?";
            ps = connection.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            
            this.rs   = ps.executeQuery();
            
            connection.close();
            
            this.rs.next();
            Producto producto= new Producto();
                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getFloat("precio"));
                producto.setFecha_alta(rs.getDate("fecha_alta"));
                producto.setCategoria(getCategoria(rs.getInt("categoria_id")));

            return producto;
    }
    
}

