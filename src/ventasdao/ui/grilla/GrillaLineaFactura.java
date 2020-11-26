/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.ui.grilla;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import ventasdao.objetos.Lineafactura;

/**
 *
 * @author Arguello Leonel
 */
public class GrillaLineaFactura extends AbstractTableModel {
    private ArrayList<Lineafactura> lineafactura = new ArrayList<>();
    
    
    
    public GrillaLineaFactura (ArrayList<Lineafactura> datos) {
        this.lineafactura = datos;
    }

    @Override
    public int getRowCount() {
   return lineafactura.size();
    }

    @Override
    public int getColumnCount() {
     return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Lineafactura linfactura= lineafactura.get(rowIndex);
        switch(columnIndex){
              case 0: return linfactura.getId();
              case 1: return linfactura.getProducto().getNombre();
              case 2: return linfactura.getCantidad();
              case 3: return linfactura.getFactura().getId();
              case 4: return linfactura.getSubtotal();
              default: return "";
    }
    }
    @Override
    public String getColumnName(int column) {
        switch(column){
             case 0: return "ID";
              case 1: return "Producto";
              case 2: return "Cantidad";
              case 3: return "IDfactura";
              case 4: return "subtotal";
            default: return "";
        
        
       
    }
        
    }
     public Lineafactura getLineaFacturaFromRow(int rowIndex){
        return lineafactura.get(rowIndex);
    }

}
    
    
    

