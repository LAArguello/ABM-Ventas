/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.ui.grilla;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import ventasdao.objetos.Producto;

/**
 *
 * @author Arguello Leonel
 */
public class GrillaProductoFactura extends AbstractTableModel{
        private ArrayList<Producto> productos = new ArrayList<>();
    
    
    
    public GrillaProductoFactura(ArrayList<Producto> datos) {
        this.productos = datos;
    }
    
    

    @Override
    public int getRowCount() {
        return productos.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
         return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Producto producto =  productos.get(rowIndex);
        switch(columnIndex){
              case 0: return producto.getId();
              case 1: return producto.getNombre();
              case 2: return producto.getPrecio();
              
              default: return "";
          }
        
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "ID";
            case 1: return "NOMBRE";
            case 2: return "Precio";
            default: return "";
        
        
        } //To change body of generated methods, choose Tools | Templates.
    }
    public Producto getProductoFromRow(int rowIndex){
        return productos.get(rowIndex);
    }

   
}
