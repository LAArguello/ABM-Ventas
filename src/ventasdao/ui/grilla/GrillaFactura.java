/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventasdao.ui.grilla;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import ventasdao.objetos.Factura;

/**
 *
 * @author Arguello Leonel
 */
public class GrillaFactura extends AbstractTableModel{
        private ArrayList<Factura> facturas = new ArrayList<>();
    
    
    
    public GrillaFactura(ArrayList<Factura> datos) {
        this.facturas = datos;
    }
    
    

    @Override
    public int getRowCount() {
        return facturas.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
         return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Factura factura= facturas.get(rowIndex);
        switch(columnIndex){
              case 0: return factura.getId();
              case 1: return factura.getFecha();
              case 2: return factura.getId_cliente();
              case 3: return factura.getProductos();
              case 4: return factura.getCantidad_producto();
              case 5: return factura.getForma_pago();
              case 6: return factura.getObservacion();
              case 7: return factura.getTotal();
              default: return "";
          }
        
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
             case 0: return "ID";
              case 1: return "Fecha";
              case 2: return "ID_Cliente";
              case 3: return "Productos";
              case 4: return "Cantidad";
              case 5: return "Forma_Pago";
              case 6: return "Observacion";
              case 7: return "Total";
            default: return "";
        
        
        } //To change body of generated methods, choose Tools | Templates.
    }
    public Factura getProductoFromRow(int rowIndex){
        return facturas.get(rowIndex);
    }

   
}
