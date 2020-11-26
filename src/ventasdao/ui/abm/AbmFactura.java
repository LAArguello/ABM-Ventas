/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventasdao.ui.abm;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import ventasdao.controladores.ClienteControlador;
import ventasdao.controladores.ControladorFactura;
import ventasdao.controladores.ControladorProducto;
import ventasdao.controladores.LineaFacturaControlador;
import ventasdao.dominio.Conexion;
import ventasdao.objetos.Cliente;
import ventasdao.objetos.Factura;
import ventasdao.objetos.Lineafactura;
import ventasdao.objetos.Producto;
import ventasdao.ui.grilla.GrillaFactura;
import ventasdao.ui.grilla.GrillaLineaFactura;

/**
 *
 * @author Arguello Leonel
 */
public class AbmFactura extends javax.swing.JInternalFrame {

    private GrillaFactura grillafactura;
    private GrillaLineaFactura grillalinea;
    private LineaFacturaControlador controladorlineafactura;
    private ControladorFactura controladorFactura;
    private ClienteControlador clienteControlador;
    private ControladorProducto productoControlador;
    private DefaultComboBoxModel modelcombo;
    private DefaultComboBoxModel modelcombo2;
    private Factura facturafinal;
   
            Float preciotemporal= 0f;
            Float cantidadtemporal=0f;
            Float precioproductoglobal=0f;
            Float totalf=0f;
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
        controladorlineafactura= new LineaFacturaControlador();
        ArrayList<Lineafactura> lineafactura= new ArrayList<>();

        try {
             lineafactura = controladorlineafactura.listar();
        } catch (Exception e) {
            e.printStackTrace ();
        }
        grillalinea= new GrillaLineaFactura(lineafactura);
            tablefacturas.setModel(grillalinea);

       ArrayList<Factura> facturas = new ArrayList<>();

        try {
            facturas = controladorFactura.listar();
        } catch (Exception e) {
            e.printStackTrace ();
        }
        grillafactura= new GrillaFactura(facturas);
            tabladefacturas.setModel(grillafactura);
       
            
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
          Factura factura= new Factura();
java.util.Date fechaParseada= new SimpleDateFormat("dd/MM/yyyy").parse("26/11/2020");
DateFactura.setDate(fechaParseada);
        factura.setFecha(DateFactura.getDate());
        factura.setForma_pago("temporal");
        factura.setId_cliente((Cliente) CB_Cliente.getSelectedItem());
        factura.setObservacion("temporal");
        factura.setTotal(0f);
        
         try {
            controladorFactura.crear(factura);
            facturafinal= new Factura();
            facturafinal=controladorFactura.SelectFactura(factura.getTotal());
            jidfactura.setText(facturafinal.getId().toString());
        
        } catch (Exception ex) {
            Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        
    }
    private void limpiarCampos() throws ParseException {
java.util.Date fechaParseada= new SimpleDateFormat("dd/MM/yyyy").parse("26/11/2020");
DateFactura.setDate(fechaParseada);
CB_Cliente.setSelectedItem(null);
     CB_Producto.setSelectedItem(null);
     JCantidad.setText(null);
     JObservacion.setText(null);
     CB_Pago.setSelectedItem(null);
     JTotal.setText(null);
     jidlinea.setText(null);

    }
    
    private void limpiarcamposproducto() throws ParseException {

     CB_Producto.setSelectedItem(null);
     JCantidad.setText(null);
     

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
        jidlinea = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jidfactura = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabladefacturas = new javax.swing.JTable();
        lTotal8 = new javax.swing.JLabel();
        subtotal = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();

        CB_Cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        DateFactura.setMaxSelectableDate(new java.util.Date(253370779281000L));
        DateFactura.setMinSelectableDate(new java.util.Date(-62135755119000L));

        CB_Producto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        B_Producto.setText("Añadir");
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

        jidlinea.setEditable(false);
        jidlinea.setEnabled(false);
        jidlinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jidlineaActionPerformed(evt);
            }
        });

        jButton4.setText("Editar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Eliminar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jidfactura.setEditable(false);
        jidfactura.setEnabled(false);

        tabladefacturas.setModel(new javax.swing.table.DefaultTableModel(
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
        tabladefacturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabladefacturasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabladefacturas);

        lTotal8.setText("Precio Producto");

        jButton6.setText("Precio P");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lTotal1)
                                    .addComponent(lTotal2)
                                    .addComponent(lTotal3)
                                    .addComponent(lTotal4)
                                    .addComponent(lTotal8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(DateFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(CB_Producto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(CB_Cliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(JCantidad)
                                        .addComponent(subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jidlinea, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jidfactura, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lTotal5)
                                            .addComponent(lTotal6)
                                            .addComponent(lTotal7))
                                        .addGap(36, 36, 36)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(JObservacion)
                                                .addComponent(CB_Pago, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(JTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton3))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                            .addComponent(jScrollPane3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(384, 384, 384)
                        .addComponent(lTotal)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jidlinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(85, 85, 85))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(DateFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CB_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CB_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(JCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(lTotal1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(lTotal2)
                                                    .addComponent(jidfactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(43, 43, 43))
                                            .addComponent(lTotal3))
                                        .addGap(38, 38, 38))
                                    .addComponent(lTotal4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lTotal8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lTotal)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(B_Producto)
                            .addComponent(jButton4)
                            .addComponent(jButton5)
                            .addComponent(jButton6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CB_Pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lTotal5)
                                .addGap(18, 18, 18)
                                .addComponent(lTotal7)))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lTotal6)
                            .addComponent(JTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addGap(136, 136, 136))))
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
        Boolean prueba1= AbmFactura.isNumeric(JCantidad.getText());
        if (prueba1 == false){
        AbmFactura.infoBox("ingrese cantidades numericas!", "ERROR");
       
        } else {
            if (Float.parseFloat(JCantidad.getText()) <= 0){
                AbmFactura.infoBox("ingrese cantidades mayores a 0!", "ERROR");
        
            } else {


        Float precioproducto= Float.parseFloat(JCantidad.getText()) * productoobtenido.getPrecio();
                preciotemporal= preciotemporal + precioproducto;
                cantidadtemporal=Float.parseFloat(JCantidad.getText());
                       JTotal.setText(preciotemporal.toString());
        }
        }
        Lineafactura lineafactura= new Lineafactura();       
        lineafactura.setProducto(productoobtenido);
        lineafactura.setCantidad(cantidadtemporal);
        lineafactura.setFactura(facturafinal);
        lineafactura.setSubtotal(Float.parseFloat(subtotal.getText()));
        
          try {
         controladorlineafactura.crear(lineafactura);
         limpiarcamposproducto();
        
        } catch (Exception ex) {
            Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
          ArrayList<Lineafactura> linefactura= new ArrayList<>();

        try {
             linefactura = controladorlineafactura.listar();
        } catch (Exception e) {
            e.printStackTrace ();
        }
        grillalinea= new GrillaLineaFactura(linefactura);
            tablefacturas.setModel(grillalinea);  
            
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
        factura.setId_cliente((Cliente) CB_Cliente.getSelectedItem());
        factura.setObservacion(JObservacion.getText());
       factura.setForma_pago((String) CB_Pago.getSelectedItem());
        factura.setTotal(Float.parseFloat(JTotal.getText()));
        factura.setId(Integer.parseInt(jidfactura.getText()));
        
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
            tabladefacturas.setModel(grillafactura);
        
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
        factura.setId_cliente((Cliente) CB_Cliente.getSelectedItem());
        factura.setObservacion(JObservacion.getText());
       factura.setForma_pago((String) CB_Pago.getSelectedItem());
        factura.setTotal(Float.parseFloat(JTotal.getText()));
        factura.setId(Integer.parseInt(jidfactura.getText()));

        
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
            tabladefacturas.setModel(grillafactura);
        
        }
        }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       Factura factura= new Factura();
       factura.setId(Integer.parseInt(jidfactura.getText()));
       
        try {
            controladorFactura.eliminar(factura);

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
            tabladefacturas.setModel(grillafactura);
        



    }//GEN-LAST:event_jButton3ActionPerformed

    private void tablefacturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablefacturasMouseClicked
        Lineafactura lifactura= grillalinea.getLineaFacturaFromRow(tablefacturas.getSelectedRow());
        CB_Producto.setSelectedItem(lifactura.getProducto().getNombre());
        JCantidad.setText(lifactura.getCantidad().toString());
        jidfactura.setText(lifactura.getFactura().getId().toString());
        jidlinea.setText(lifactura.getId().toString());
        subtotal.setText(lifactura.getSubtotal().toString());
        JTotal.setText(lifactura.getSubtotal().toString());
                
        
       
        
         /*   
        
             CB_Cliente.setSelectedItem(null);

      
        CB_Producto.setSelectedItem(factura.getProductos());
        JCantidad.setText(factura.getCantidad_producto().toString());
        JObservacion.setText(factura.getObservacion());
        CB_Pago.setSelectedItem(factura.getForma_pago());
        JTotal.setText(null);*/
        
        
     ArrayList<Lineafactura> lineafactura= new ArrayList<>();

        try {
             lineafactura = controladorlineafactura.listar();
        } catch (Exception e) {
            e.printStackTrace ();
        }
        grillalinea= new GrillaLineaFactura(lineafactura);
            tablefacturas.setModel(grillalinea);
        
    }//GEN-LAST:event_tablefacturasMouseClicked

    private void jidlineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jidlineaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jidlineaActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       
        Producto producto= new Producto();
        producto.setNombre(CB_Producto.getSelectedItem().toString());
        
        Producto productoobtenido= new Producto();
        
        
        try {
            productoobtenido = productoControlador.objeto(producto.getNombre());
        } catch (Exception ex) {
            Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        Boolean prueba1= AbmFactura.isNumeric(JCantidad.getText());
        if (prueba1 == false){
        AbmFactura.infoBox("ingrese cantidades numericas!", "ERROR");
       
        } else {
            if (Float.parseFloat(JCantidad.getText()) <= 0){
                AbmFactura.infoBox("ingrese cantidades mayores a 0!", "ERROR");
        
            } else {

      
        }
        }
        Factura factura= new Factura();
        factura.setId(Integer.parseInt(jidfactura.getText()));
        Lineafactura lineafactura= new Lineafactura();    
        lineafactura.setFactura(factura);
        lineafactura.setProducto(productoobtenido);
        lineafactura.setSubtotal(Float.parseFloat(subtotal.getText()));
        lineafactura.setCantidad(Float.parseFloat(JCantidad.getText()));
        lineafactura.setId(Integer.parseInt(jidlinea.getText()));
        
          try {
            controladorlineafactura.modificar(lineafactura);
            limpiarcamposproducto();
        
        } catch (Exception ex) {
            Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
         ArrayList<Lineafactura> lineasfactura= new ArrayList<>();
        try {
           lineasfactura= controladorlineafactura.listar();
        } catch (Exception ex) {
            Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Float sumando=0f;
        int a =lineasfactura.size();
        for (int i=0;i<a;i++){
            Lineafactura sumandolineas= new Lineafactura();
            sumandolineas=lineasfactura.get(i);
                sumando= sumando + sumandolineas.getSubtotal();
        
        }
                   
        factura.setTotal(sumando);
        try {
            controladorFactura.modificarlinea(factura);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
          ArrayList<Lineafactura> linefactura= new ArrayList<>();

        try {
             linefactura = controladorlineafactura.listar();
        } catch (Exception e) {
            e.printStackTrace ();
        }
        grillalinea= new GrillaLineaFactura(linefactura);
            tablefacturas.setModel(grillalinea);   
             ArrayList<Factura> facturas = new ArrayList<>();

        try {
            facturas = controladorFactura.listar();
        } catch (Exception e) {
            e.printStackTrace ();
        }
        grillafactura= new GrillaFactura(facturas);
            tabladefacturas.setModel(grillafactura);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       
       Lineafactura lifac= new Lineafactura();
       lifac.setId(Integer.parseInt(jidlinea.getText()));
       lifac.setSubtotal(Float.parseFloat(subtotal.getText()));
        Factura factura= new Factura();
        factura.setId(Integer.parseInt(jidfactura.getText()));
        try {
            Factura total= new Factura();
            total=controladorFactura.SelectTotal(Integer.parseInt(jidfactura.getText()));
            totalf=total.getTotal();
        } catch (Exception ex) {
            Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        Float restando=totalf;
        
       restando= restando - lifac.getSubtotal();
        factura.setTotal(restando);
         try {
            controladorFactura.modificarlinea(factura);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       try {
           controladorlineafactura.eliminar(lifac);
           limpiarcamposproducto();

        } catch (Exception ex) {
            Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        ArrayList<Lineafactura> linefactura= new ArrayList<>();

        try {
             linefactura = controladorlineafactura.listar();
        } catch (Exception e) {
            e.printStackTrace ();
        }
        grillalinea= new GrillaLineaFactura(linefactura);
            tablefacturas.setModel(grillalinea);   
             ArrayList<Factura> facturas = new ArrayList<>();

        try {
            facturas = controladorFactura.listar();
        } catch (Exception e) {
            e.printStackTrace ();
        }
        grillafactura= new GrillaFactura(facturas);
            tabladefacturas.setModel(grillafactura);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tabladefacturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabladefacturasMouseClicked
        Factura factura=grillafactura.getFacturaFromRow(tabladefacturas.getSelectedRow());
        DateFactura.setDate(factura.getFecha());
        CB_Cliente.setSelectedItem(factura.getId_cliente());
        JObservacion.setText(factura.getObservacion());
        CB_Pago.setSelectedItem(factura.getForma_pago());
        JTotal.setText(factura.getTotal().toString());
        jidfactura.setText(factura.getId().toString());
        
                
        // TODO add your handling code here:
    }//GEN-LAST:event_tabladefacturasMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
              Producto producto= new Producto();
        producto.setNombre(CB_Producto.getSelectedItem().toString());
        
        Producto productoobtenido= new Producto();
        
        
        try {
            productoobtenido = productoControlador.objeto(producto.getNombre());
        } catch (Exception ex) {
            Logger.getLogger(AbmFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
   Float precioproducto= Float.parseFloat(JCantidad.getText()) * productoobtenido.getPrecio();

           
            subtotal.setText(precioproducto.toString());
             JTotal.setText(precioproducto.toString());
       
       
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_Producto;
    private javax.swing.JComboBox<String> CB_Cliente;
    private javax.swing.JComboBox<String> CB_Pago;
    private javax.swing.JComboBox<String> CB_Producto;
    private com.toedter.calendar.JDateChooser DateFactura;
    private javax.swing.JTextField JCantidad;
    private javax.swing.JTextField JObservacion;
    private javax.swing.JTextField JTotal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jidfactura;
    private javax.swing.JTextField jidlinea;
    private javax.swing.JLabel lTotal;
    private javax.swing.JLabel lTotal1;
    private javax.swing.JLabel lTotal2;
    private javax.swing.JLabel lTotal3;
    private javax.swing.JLabel lTotal4;
    private javax.swing.JLabel lTotal5;
    private javax.swing.JLabel lTotal6;
    private javax.swing.JLabel lTotal7;
    private javax.swing.JLabel lTotal8;
    private javax.swing.JTextField subtotal;
    private javax.swing.JTable tabladefacturas;
    private javax.swing.JTable tablefacturas;
    // End of variables declaration//GEN-END:variables
}
