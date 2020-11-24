/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.ui.abm;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import ventasdao.controladores.ClienteControlador;
import ventasdao.controladores.ControladorFactura;
import ventasdao.controladores.ControladorProducto;
import ventasdao.objetos.Cliente;
import ventasdao.objetos.Factura;
import ventasdao.objetos.Producto;
import ventasdao.ui.grilla.GrillaFactura;

/**
 *
 * @author Arguello Leonel
 */
public class AbmFactura extends javax.swing.JInternalFrame {

    private Factura factura;
    private GrillaFactura grillafactura;
    private ControladorFactura controladorFactura;
    private ClienteControlador clienteControlador;
    private ControladorProducto productoControlador;
    private DefaultComboBoxModel modelcombo;
    private DefaultComboBoxModel modelcombo2;
            Float preciotemporal= 0f;
            Float cantidadtemporal=0f;
            String Productos="";




    /**
     * Creates new form AbmFactura
     * @throws java.lang.Exception
     */
    public AbmFactura() throws Exception  {
        initComponents();
        controladorFactura= new ControladorFactura();
        clienteControlador= new ClienteControlador();
        productoControlador= new ControladorProducto();
         ArrayList<Factura> facturas = new ArrayList<>();

        try {
            facturas = controladorFactura.listar();
        } catch (Exception e) {
            e.printStackTrace ();
        }
        grillafactura= new GrillaFactura(facturas);
            tablefacturas.setModel(grillafactura);

       
            
        try {
            ArrayList<Cliente> clientes = clienteControlador.listar();
                    modelcombo= new DefaultComboBoxModel(clientes.toArray());
                    CB_Cliente.setModel(modelcombo);
           
        } catch (Exception ex) {
            Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
             ArrayList<Producto> productos = productoControlador.listar();
                    modelcombo2= new DefaultComboBoxModel(productos.toArray());
                    CB_Producto.setModel(modelcombo2);
                    
         } catch (Exception ex) {
            Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private void limpiarCampos() {
     DateFactura.setDate(null);
     CB_Cliente.setSelectedItem(null);
     CB_Producto.setSelectedItem(null);
     JCantidad.setText(null);
     JObservacion.setText(null);
     CB_Pago.setSelectedItem(null);
     JTotal.setText(null);
     Jidfactura.setText(null);

    }
       public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
      public static boolean isNumeric(String str) { 
  try {  
    Float.parseFloat(str);  
    return true;
  } catch(NumberFormatException e){  
    return false;  
  }  
}
            /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CB_Cliente = new javax.swing.JComboBox<>();
        DateFactura = new com.toedter.calendar.JDateChooser();
        CB_Producto = new javax.swing.JComboBox<>();
        JObservacion = new javax.swing.JTextField();
        B_Producto = new javax.swing.JButton();
        JCantidad = new javax.swing.JTextField();
        CB_Pago = new javax.swing.JComboBox<>();
        lTotal = new javax.swing.JLabel();
        lTotal1 = new javax.swing.JLabel();
        lTotal2 = new javax.swing.JLabel();
        lTotal3 = new javax.swing.JLabel();
        lTotal4 = new javax.swing.JLabel();
        lTotal5 = new javax.swing.JLabel();
        lTotal6 = new javax.swing.JLabel();
        lTotal7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablefacturas = new javax.swing.JTable();
        JTotal = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Jidfactura = new javax.swing.JTextField();

        CB_Cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CB_Producto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        B_Producto.setText("Añadir Producto");
        B_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_ProductoActionPerformed(evt);
            }
        });

        JCantidad.setText("1");

        CB_Pago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tarjeta de Credito", "Tarjeta de Debito", "Efectivo", "Mercadopago" }));

        lTotal1.setText("Fecha");

        lTotal2.setText("Cliente");

        lTotal3.setText("Producto");

        lTotal4.setText("Cantidad");

        lTotal5.setText("Observacion");

        lTotal6.setText("Total");

        lTotal7.setText("Forma de pago");

        jButton1.setText("Facturar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tablefacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablefacturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablefacturasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablefacturas);

        JTotal.setText("$");

        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Jidfactura.setEditable(false);
        Jidfactura.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(315, 315, 315)
                .addComponent(lTotal)
                .addContainerGap(590, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(Jidfactura, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lTotal1)
                            .addComponent(lTotal2)
                            .addComponent(lTotal3)
                            .addComponent(lTotal4)
                            .addComponent(lTotal5)
                            .addComponent(lTotal7)
                            .addComponent(lTotal6))
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(B_Producto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CB_Producto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CB_Cliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DateFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JObservacion)
                            .addComponent(JCantidad)
                            .addComponent(CB_Pago, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Jidfactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(DateFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lTotal1))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(CB_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lTotal2))
                                        .addGap(18, 18, 18)
                                        .addComponent(CB_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lTotal3))
                                .addGap(18, 18, 18)
                                .addComponent(JCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lTotal4))
                        .addGap(12, 12, 12)
                        .addComponent(B_Producto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lTotal5)
                                .addGap(45, 45, 45))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lTotal7)
                                    .addComponent(CB_Pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lTotal6)
                            .addComponent(JTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lTotal)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B_ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_ProductoActionPerformed
        
        Producto producto= new Producto();
        producto.setNombre(CB_Producto.getSelectedItem().toString());
        
        Producto productoobtenido= new Producto();
        try {
            productoobtenido = productoControlador.objeto(producto.getNombre());
        } catch (Exception ex) {
            Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
       Productos= Productos + ", " + productoobtenido.getNombre();
        Boolean prueba1= AbmFactura.isNumeric(JCantidad.getText());
        if (prueba1 == false){
        AbmFactura.infoBox("ingrese cantidades numericas!", "ERROR");
       
        } else {
            if (Float.parseFloat(JCantidad.getText()) <= 0){
                AbmFactura.infoBox("ingrese cantidades mayores a 0!", "ERROR");
        
            } else {

        Float cantidadproducto= Float.parseFloat(JCantidad.getText());

        float precioproducto= Float.parseFloat(JCantidad.getText()) * productoobtenido.getPrecio();
                preciotemporal= preciotemporal + precioproducto;
                cantidadtemporal= cantidadtemporal + cantidadproducto;
                       JTotal.setText(preciotemporal.toString());
        }
        }
    }//GEN-LAST:event_B_ProductoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        int lenght= JObservacion.getText().length();
        
        if(lenght < 3){
       AbmFactura.infoBox("Los caracteres ingresados son insuficientes, ingrese al menos tres", "ERROR");
   
        }else{
            Boolean prueba2= AbmFactura.isNumeric(JTotal.getText());
        
        if (prueba2 == false){
        AbmFactura.infoBox("ingrese cantidades numericas!", "ERROR");
       
        } else {
            if (Float.parseFloat(JTotal.getText())<= 0){
     AbmFactura.infoBox("ingrese cantidades mayores a 0!", "ERROR");
            } else{
        Factura factura = new Factura();
        factura.setFecha(DateFactura.getDate());
        factura.setProductos(Productos);
        factura.setId_cliente((Cliente) CB_Cliente.getSelectedItem());
        factura.setCantidad_producto(cantidadtemporal);
        factura.setObservacion(JObservacion.getText());
       factura.setForma_pago((String) CB_Pago.getSelectedItem());
        factura.setTotal(Float.parseFloat(JTotal.getText()));
        
       
        try {
            controladorFactura.crear(factura);
             limpiarCampos();
        
        } catch (Exception ex) {
            Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         ArrayList<Factura> facturas = new ArrayList<>();

        try {
            facturas = controladorFactura.listar();
        } catch (Exception e) {
            e.printStackTrace ();
        }
        grillafactura= new GrillaFactura(facturas);
            tablefacturas.setModel(grillafactura);
        }
        }
        }
    

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
int lenght= JObservacion.getText().length();
        
        if(lenght < 3){
       AbmFactura.infoBox("Los caracteres ingresados son insuficientes, ingrese al menos tres", "ERROR");
   
        }else{
            Boolean prueba2= AbmFactura.isNumeric(JTotal.getText());
        
        if (prueba2 == false){
        AbmFactura.infoBox("ingrese cantidades numericas!", "ERROR");
       
        } else {
            if (Float.parseFloat(JTotal.getText())<= 0){
     AbmFactura.infoBox("ingrese cantidades mayores a 0!", "ERROR");
            } else {
        Factura factura = new Factura();
        factura.setFecha(DateFactura.getDate());
        factura.setProductos(Productos);
        factura.setId_cliente((Cliente) CB_Cliente.getSelectedItem());
        factura.setCantidad_producto(cantidadtemporal);
        factura.setObservacion(JObservacion.getText());
       factura.setForma_pago((String) CB_Pago.getSelectedItem());
        factura.setTotal(Float.parseFloat(JTotal.getText()));
        factura.setId(Integer.parseInt(Jidfactura.getText()));

        
        try {
            controladorFactura.modificar(factura);
            limpiarCampos();
        
        } catch (Exception ex) {
            Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ArrayList<Factura> facturas = new ArrayList<>();

        try {
            facturas = controladorFactura.listar();
        } catch (Exception e) {
            e.printStackTrace ();
        }
        grillafactura= new GrillaFactura(facturas);
            tablefacturas.setModel(grillafactura);
        
        }
        
        }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       Factura factura= new Factura();
       factura.setId(Integer.parseInt(Jidfactura.getText()));
       
        try {
            controladorFactura.eliminar(factura);
             limpiarCampos();

// TODO add your handling code here:
        } catch (Exception ex) {
            Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
         ArrayList<Factura> facturas = new ArrayList<>();

        try {
            facturas = controladorFactura.listar();
        } catch (Exception e) {
            e.printStackTrace ();
        }
        grillafactura= new GrillaFactura(facturas);
            tablefacturas.setModel(grillafactura);
        



    }//GEN-LAST:event_jButton3ActionPerformed

    private void tablefacturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablefacturasMouseClicked
        Factura factura= grillafactura.getFacturaFromRow(tablefacturas.getSelectedRow());
        Jidfactura.setText(factura.getId().toString());
        DateFactura.setDate(factura.getFecha());
        
            
        
             CB_Cliente.setSelectedItem(null);

      
        CB_Producto.setSelectedItem(factura.getProductos());
        JCantidad.setText(factura.getCantidad_producto().toString());
        JObservacion.setText(factura.getObservacion());
        CB_Pago.setSelectedItem(factura.getForma_pago());
        JTotal.setText(null);
        
        
        ArrayList<Factura> facturas = new ArrayList<>();

        try {
            facturas = controladorFactura.listar();
        } catch (Exception e) {
            e.printStackTrace ();
        }
        grillafactura= new GrillaFactura(facturas);
            tablefacturas.setModel(grillafactura);
        
    }//GEN-LAST:event_tablefacturasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_Producto;
    private javax.swing.JComboBox<String> CB_Cliente;
    private javax.swing.JComboBox<String> CB_Pago;
    private javax.swing.JComboBox<String> CB_Producto;
    private com.toedter.calendar.JDateChooser DateFactura;
    private javax.swing.JTextField JCantidad;
    private javax.swing.JTextField JObservacion;
    private javax.swing.JTextField JTotal;
    private javax.swing.JTextField Jidfactura;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lTotal;
    private javax.swing.JLabel lTotal1;
    private javax.swing.JLabel lTotal2;
    private javax.swing.JLabel lTotal3;
    private javax.swing.JLabel lTotal4;
    private javax.swing.JLabel lTotal5;
    private javax.swing.JLabel lTotal6;
    private javax.swing.JLabel lTotal7;
    private javax.swing.JTable tablefacturas;
    // End of variables declaration//GEN-END:variables
}
