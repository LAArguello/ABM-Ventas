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
import javax.swing.JOptionPane;
import ventasdao.controladores.ClienteControlador;
import ventasdao.objetos.Categoria;
import ventasdao.objetos.Cliente;
import ventasdao.objetos.TipoCliente;
import ventasdao.ui.grilla.GrillaCliente;
import ventasdao.controladores.TipoClienteControlador;
/**
 *
 * @author Arguello Leonel
 */
public class Abmcliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form AbmCategoria
     */
     private Cliente cliente;
   private TipoCliente tipcli;
    private GrillaCliente grillaCliente;
    private ClienteControlador clienteControlador = new ClienteControlador();
    private TipoClienteControlador tipoclienteControlador= new TipoClienteControlador();
   
    
   
    public Abmcliente() {
        initComponents();
        
        ArrayList<Cliente> clientes;
        try {
            clientes = clienteControlador.listar();
            grillaCliente = new GrillaCliente(clientes);
        } catch (Exception e) {
            e.printStackTrace ();
        } 
        jtListadoCliente.setModel(grillaCliente);
        
        
        
        ArrayList<TipoCliente> tiposCliente;
        
         try {
             tiposCliente= tipoclienteControlador.listar();
         } catch (Exception ex) {
             Logger.getLogger(Abmcliente.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
     private void limpiarCampos() {
       jtextid.setText(" ");
       Jtextnombre.setText(" ");
       Jtextapellido.setText(" ");
       Jtextdocumento.setText(" ");
    }
    

    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
      public static boolean isNumeric(String str) { 
  try {  
    Double.parseDouble(str);  
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jtListadoCliente = new javax.swing.JTable();
        nombre = new java.awt.Label();
        nombre1 = new java.awt.Label();
        nombre2 = new java.awt.Label();
        nombre3 = new java.awt.Label();
        Jtextnombre = new javax.swing.JTextField();
        Jtextapellido = new javax.swing.JTextField();
        Jtextdocumento = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jtextid = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        listtipocliente = new java.awt.List();

        setClosable(true);

        jtListadoCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4","Title 5"
            }
        ));
        jtListadoCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListadoClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtListadoCliente);

        nombre.setText("Apellido");

        nombre1.setText("Nombre");

        nombre2.setText("Documento");

        nombre3.setText("Tipo Cliente");

        jButton1.setText("Modificar");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jtextid.setEditable(false);
        jtextid.setBackground(new java.awt.Color(0, 0, 0));
        jtextid.setEnabled(false);

        jButton2.setText("Ingresar");
        jButton2.setToolTipText("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar");
        jButton3.setToolTipText("");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombre3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButton2)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(45, 45, 45)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Jtextnombre)
                                .addComponent(Jtextapellido, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                .addComponent(Jtextdocumento, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                .addComponent(jtextid))
                            .addComponent(listtipocliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(56, 56, 56)
                    .addComponent(nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(614, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jtextid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Jtextnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nombre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Jtextapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Jtextdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nombre3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(listtipocliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addContainerGap(93, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(77, 77, 77)
                    .addComponent(nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(274, Short.MAX_VALUE)))
        );

        nombre.getAccessibleContext().setAccessibleName("nombre");
        nombre.getAccessibleContext().setAccessibleDescription("");
        listtipocliente.add("Consumidor Final");
        listtipocliente.add("Responsable Inscripto");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

          cliente = new Cliente();
          tipcli= new TipoCliente();
        cliente.setDocumento(Jtextdocumento.getText());
        cliente.setNombre(Jtextnombre.getText());
        cliente.setApellido(Jtextapellido.getText()); 
        String tipoc = (listtipocliente.getItem(listtipocliente.getSelectedIndex()));
         if ("Consumidor Final".equals(tipoc)){
          tipcli.setNombre(tipoc);
          tipcli.setId(1);
          tipcli.setDescripcion("se define como la persona que realmente utiliza un producto");
          
        }
        else if("Responsable Inscripto".equals(tipoc)){
            tipcli.setNombre(tipoc);
            tipcli.setId(2);
            tipcli.setDescripcion("aquel contribuyente que tiene la obligaciÃ³n de presentar y pagar IVA");
        }
        cliente.setTipocliente(tipcli); 
        cliente.setId(Integer.parseInt(jtextid.getText()));
        
        int lenght=Jtextnombre.getText().length();
        int lenght2=Jtextapellido.getText().length();
        int lenght3=Jtextdocumento.getText().length();
        if (lenght < 3){
       Abmcliente.infoBox("Los caracteres ingresados son insuficientes, ingrese al menos tres", "ERROR");

        } else {
            if(lenght2 < 3){
           Abmcliente.infoBox("Los caracteres ingresados son insuficientes, ingrese al menos tres", "ERROR");
            } else {
               if (lenght3 < 3) {
                   
    AbmCategoria.infoBox("Los caracteres ingresados son insuficientes, ingrese el documento entero", "ERROR");

               } else {  
                   Boolean prueba= Abmcliente.isNumeric(Jtextdocumento.getText());
                  
                   if(prueba == false){
                   
            Abmcliente.infoBox("Ingrese numeros para el DNI", "ERROR");
             
                   } else{
        try {
            clienteControlador.modificar(cliente);
            limpiarCampos();
        } catch (Exception ex) {
             Logger.getLogger(Abmcliente.class.getName()).log(Level.SEVERE, null, ex);
         }

         ArrayList<Cliente> clientes;
        try {
            clientes = clienteControlador.listar();
            grillaCliente = new GrillaCliente(clientes);
        } catch (Exception e) {
            e.printStackTrace ();
        } 
        jtListadoCliente.setModel(grillaCliente);
               }
            }
        }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtListadoClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListadoClienteMouseClicked
        // TODO add your handling code here:
         Cliente cliente = grillaCliente.getClienteFromRow(jtListadoCliente.getSelectedRow());
         
               Jtextapellido.setText(cliente.getApellido());
               Jtextnombre.setText(cliente.getNombre());
               Jtextdocumento.setText(cliente.getDocumento());
               jtextid.setText(cliente.getId().toString() );
               if(cliente.getTipocliente().getId()==1){
                  listtipocliente.select(0);
               } else if(cliente.getTipocliente().getId()==2){
        listtipocliente.select(1);
    }
                ArrayList<Cliente> clientes;
        try {
            clientes = clienteControlador.listar();
            grillaCliente = new GrillaCliente(clientes);
        } catch (Exception e) {
            e.printStackTrace ();
        } 
        jtListadoCliente.setModel(grillaCliente);
               
    }//GEN-LAST:event_jtListadoClienteMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
          cliente = new Cliente();
          tipcli= new TipoCliente();
        cliente.setDocumento(Jtextdocumento.getText());
        cliente.setNombre(Jtextnombre.getText());
        cliente.setApellido(Jtextapellido.getText()); 
        String tipoc = (listtipocliente.getItem(listtipocliente.getSelectedIndex()));
         if ("Consumidor Final".equals(tipoc)){
          tipcli.setNombre(tipoc);
          tipcli.setId(1);
          tipcli.setDescripcion("se define como la persona que realmente utiliza un producto");
          
        }
        else if("Responsable Inscripto".equals(tipoc)){
            tipcli.setNombre(tipoc);
            tipcli.setId(2);
            tipcli.setDescripcion("aquel contribuyente que tiene la obligaciÃ³n de presentar y pagar IVA");
        }
        cliente.setTipocliente(tipcli); 
        int lenght=Jtextnombre.getText().length();
        int lenght2=Jtextapellido.getText().length();
        int lenght3=Jtextdocumento.getText().length();
        if (lenght < 3){
       Abmcliente.infoBox("Los caracteres ingresados son insuficientes, ingrese al menos tres", "ERROR");

        } else {
            if(lenght2 < 3){
           Abmcliente.infoBox("Los caracteres ingresados son insuficientes, ingrese al menos tres", "ERROR");
            } else {
               if (lenght3 < 3) {
    AbmCategoria.infoBox("Los caracteres ingresados son insuficientes, ingrese al menos tres", "ERROR");

               } else {
                   Boolean prueba= Abmcliente.isNumeric(Jtextdocumento.getText());
                  
                   if(prueba == false){
                   
            Abmcliente.infoBox("Ingrese numeros para el DNI", "ERROR");
             
                   } else {
                    try {
            clienteControlador.crear(cliente);
            limpiarCampos();
        } catch (Exception ex) {
             Logger.getLogger(Abmcliente.class.getName()).log(Level.SEVERE, null, ex);
         }

        ArrayList<Cliente> clientes;
        try {
            clientes = clienteControlador.listar();
            grillaCliente = new GrillaCliente(clientes);
        } catch (Exception e) {
            e.printStackTrace ();
        } 
        jtListadoCliente.setModel(grillaCliente);
        
                   
               }
            }
        }
        
        
        }
        
        
      
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        cliente= new Cliente();
        cliente.setId(Integer.parseInt(jtextid.getText()));
           
       try {
            clienteControlador.eliminar(cliente);
            limpiarCampos();
        } catch (Exception ex) {
             Logger.getLogger(Abmcliente.class.getName()).log(Level.SEVERE, null, ex);
         }

         ArrayList<Cliente> clientes;
        try {
            clientes = clienteControlador.listar();
            grillaCliente = new GrillaCliente(clientes);
        } catch (Exception e) {
            e.printStackTrace ();
        } 
        jtListadoCliente.setModel(grillaCliente);
               
            
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Jtextapellido;
    private javax.swing.JTextField Jtextdocumento;
    private javax.swing.JTextField Jtextnombre;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtListadoCliente;
    private javax.swing.JTextField jtextid;
    private java.awt.List listtipocliente;
    private java.awt.Label nombre;
    private java.awt.Label nombre1;
    private java.awt.Label nombre2;
    private java.awt.Label nombre3;
    // End of variables declaration//GEN-END:variables
}
