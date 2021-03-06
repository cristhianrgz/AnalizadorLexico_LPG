 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;


import java.awt.Color;
import java.awt.Component;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javafx.stage.FileChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import jdk.nashorn.internal.parser.Lexer;

/**
 *
 * @author criss
 */
public class VenPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VenPrincipal
     */
    JFileChooser seleccionar = new JFileChooser();
    FileOutputStream salida;
    FileInputStream entrada;
    File archivo;
    TextLineNumber lineas;
    final Highlighter hilit;
    final Highlighter.HighlightPainter painter;
    final static Color HILIT_COLOR = Color.LIGHT_GRAY;
    final Color entryBg;
    public static int linea;
    public static String token;
    Font font = new Font("Consolas", Font.BOLD, 14);
    DefaultTableModel tokens;
    
    //Para tabla de id
    public static ArrayList<String> ids = new ArrayList<String>();  

    
    public VenPrincipal() {
        initComponents();
        this.setTitle("IDE - LPG");
        this.getContentPane().setBackground(Color.WHITE);
        Font font = new Font("Consolas", Font.PLAIN, 14);
        panelNum.setFont(font);
        cerrar();
        
        //Creación de tabla de Tokens
        tokens = (DefaultTableModel) tbtokens.getModel();
        tokens.addColumn("No.Linea");
        tokens.addColumn("Lexema");
        tokens.addColumn("Comp_Lexico"); 
        
        setLocationRelativeTo(null);
        lineas = new TextLineNumber(panelNum);
        lineas.setCurrentLineForeground(new Color(0, 0, 255));//current line
        lineas.setForeground(Color.BLACK);//color linea
        //Panel de numero de lineas
        lineas = new TextLineNumber(panelNum);
        lineas.setCurrentLineForeground(new Color(0, 0, 255));//current line
        lineas.setForeground(Color.BLACK);//color linea
        jScrollPane4.setRowHeaderView(lineas);
        jScrollPane4.setViewportView(panelNum);  
        hilit = new DefaultHighlighter();
        painter = new DefaultHighlighter.DefaultHighlightPainter(HILIT_COLOR);
        panelNum.setHighlighter(hilit);
        entryBg = panelNum.getBackground();
    }
   
    
    //MANEJO DE ARCHIVOS
    //GUARDAR ARCHIVO
    public String guardarArchivo(File archivo, String documento){
        String mensaje = null;
        try{
            salida = new FileOutputStream(archivo);
            byte [] bytxt = documento.getBytes();
            salida.write(bytxt);
            mensaje = "El archivo se ha guarado exitosamente";
            
        }catch(Exception ex){
            
        }
        return mensaje;
    }
    
    //ABRIR ARCHIVO
    public String abrirArchivo(File archivo){
        String documento = "";
        try{
            entrada = new FileInputStream(archivo);
            int ascci;
            while((ascci = entrada.read()) != -1){
                char caracter = (char) ascci;
                documento +=caracter;
            }
        }catch(Exception ex){
        }
        return documento;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtaSalida = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        Analizar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbtokens = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        panelNum = new javax.swing.JTextPane();
        MnuBar = new javax.swing.JMenuBar();
        Archivo = new javax.swing.JMenu();
        Nuevo = new javax.swing.JMenuItem();
        Abrir = new javax.swing.JMenuItem();
        Guardar = new javax.swing.JMenuItem();
        GuardarComo = new javax.swing.JMenuItem();
        Salir = new javax.swing.JMenuItem();
        tablas_simbolos = new javax.swing.JMenu();
        go_PR = new javax.swing.JMenuItem();
        go_ID = new javax.swing.JMenuItem();
        Compilar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel2.setForeground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("Salida - Analizador Léxico LPG");

        txtaSalida.setEditable(false);
        txtaSalida.setColumns(20);
        txtaSalida.setRows(5);
        txtaSalida.setBorder(null);
        jScrollPane2.setViewportView(txtaSalida);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 496, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jPanel4.setBackground(new java.awt.Color(0, 102, 153));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 728, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Analizar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Analizar.setForeground(new java.awt.Color(0, 51, 102));
        Analizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Analizar.setText("Tabla de Tokens");
        Analizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AnalizarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Analizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Analizar, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        tbtokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbtokens);

        jScrollPane4.setViewportView(panelNum);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(333, 333, 333)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        MnuBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        MnuBar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        Archivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anadir.png"))); // NOI18N
        Archivo.setText("Archivo");
        Archivo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        Nuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        Nuevo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agregar-documentos.png"))); // NOI18N
        Nuevo.setText("Nuevo");
        Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoActionPerformed(evt);
            }
        });
        Archivo.add(Nuevo);

        Abrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        Abrir.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Abrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/abrir-documento.png"))); // NOI18N
        Abrir.setText("Abrir");
        Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirActionPerformed(evt);
            }
        });
        Archivo.add(Abrir);

        Guardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        Guardar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/expediente.png"))); // NOI18N
        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });
        Archivo.add(Guardar);

        GuardarComo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        GuardarComo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        GuardarComo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/guardar.png"))); // NOI18N
        GuardarComo.setText("Guardar como");
        GuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarComoActionPerformed(evt);
            }
        });
        Archivo.add(GuardarComo);

        Salir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        Salir.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logout.png"))); // NOI18N
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        Archivo.add(Salir);

        MnuBar.add(Archivo);

        tablas_simbolos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tabla.png"))); // NOI18N
        tablas_simbolos.setText("Tablas de Simbólos");
        tablas_simbolos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        go_PR.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        go_PR.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        go_PR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/palabras-clave.png"))); // NOI18N
        go_PR.setText("Palabras Reservadas");
        go_PR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                go_PRActionPerformed(evt);
            }
        });
        tablas_simbolos.add(go_PR);

        go_ID.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        go_ID.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        go_ID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/votante.png"))); // NOI18N
        go_ID.setText("Identificadores");
        go_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                go_IDActionPerformed(evt);
            }
        });
        tablas_simbolos.add(go_ID);

        MnuBar.add(tablas_simbolos);

        Compilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/play.png"))); // NOI18N
        Compilar.setText("Compilar");
        Compilar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Compilar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CompilarMouseClicked(evt);
            }
        });
        MnuBar.add(Compilar);

        setJMenuBar(MnuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoActionPerformed

        panelNum.setText("");
        panelNum.setText("");
        tokens.setRowCount(0);
        txtaSalida.setText("");
    }//GEN-LAST:event_NuevoActionPerformed

    private void AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirActionPerformed
        if(seleccionar.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION){
            try{
              archivo = seleccionar.getSelectedFile();
              if(archivo.canRead()){
                  if(archivo.getName().endsWith("lpg")){
                      String documento = abrirArchivo(archivo);
                      panelNum.setText(documento);
                  }
                  else{
                    showMessageDialog(null,"No se pudo abrir el archivo seleccionado,\nsolo se permiten archivos \".lpg\"","ERROR",JOptionPane.ERROR_MESSAGE);
                  }
              }
            }catch(Exception ex){}
        }
        
    }//GEN-LAST:event_AbrirActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        if(seleccionar.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION){
            archivo=seleccionar.getSelectedFile();
            if(archivo.getName().endsWith("lpg")){
                String documento = panelNum.getText();
                String mensaje = guardarArchivo(archivo, documento);
                if(mensaje != null){
                    showMessageDialog(null,mensaje,"EXITO",JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    showMessageDialog(null,"No se pudo guardar el archivo","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                showMessageDialog(null,"Solo se permiten archivos con extensión .lpg","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_GuardarActionPerformed

    private void GuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarComoActionPerformed
            guardarArchivo();
    }//GEN-LAST:event_GuardarComoActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
       // JOptionPane.showMessageDialog(null, archivo.escribir_archivo(txtaCodigo.getText()));
        this.dispose();
    }//GEN-LAST:event_SalirActionPerformed

    private void go_PRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_go_PRActionPerformed
        new TablaPR().setVisible(true);
    }//GEN-LAST:event_go_PRActionPerformed

    private void go_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_go_IDActionPerformed
        new TablaID().setVisible(true);
    }//GEN-LAST:event_go_IDActionPerformed
    
    //Función analizar
    public void analizarCod(){
        txtaSalida.setText("");
        tokens.setRowCount(0);  
        if(panelNum.getText().equals("")){
            showMessageDialog(null,"No hay código para analizar.","ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else{
           try{
               probarLexer();
           }catch(IOException ex){
               System.out.println(ex.getMessage());
           }
        }
    }
    
    //Función guardarArchivo
    public void guardarArchivo(){
        if(seleccionar.showDialog(null, "Guardar como") == JFileChooser.APPROVE_OPTION){
            archivo=seleccionar.getSelectedFile();
            if(archivo.getName().endsWith("lpg")){
                String documento = panelNum.getText();
                String mensaje = guardarArchivo(archivo, documento);
                if(mensaje != null){
                    showMessageDialog(null,mensaje,"EXITO",JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    showMessageDialog(null,"No se pudo guardar el archivo,\nsolo se permiten archivos \".lpg\"","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                showMessageDialog(null,"Solo se permiten archivos con extensión .lpg","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private void AnalizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AnalizarMouseClicked
        /*if(flArchivo.exists())
        {
            cadena="\n";
            Panterior=-1;Pactual=-1;
            if(txtaCodigo.getText().equals("")){
                showMessageDialog(null,"área de texto vacia");
            }
            else{
                //        token.setRowCount(0);
                errores.clear();
                errorS.clear();
                r=1;
                txtaSalida.setText("");
                Validar_Cadenas();
                Errores();
                //if(errores.isEmpty()){
                    VSintactico();
                    ErroresS();

                    //}
                if(cad.equals(""))
                txtaSalida.setForeground(Color.darkGray);
                txtaSalida.setText("¡Compilación exitosa!");    //Ventana errores}

            if (!(cad.equals("")))   {
                txtaSalida.setForeground(Color.BLUE);
                txtaSalida.setText(cad);    //Ventana errores
            }
            System.out.println(cadena);
        }
        }
        else{
            cadena="\n";
            Panterior=-1;Pactual=-1;
            if(txtaCodigo.getText().equals("")){
                showMessageDialog(null,"área de texto vacia");
            }
            else{
                //archivo.escribir_archivo(txtaCodigo.getText());
                // token.setRowCount(0);
                errores.clear();
                errorS.clear();
                r=1;
                txtaSalida.setText("");
                Validar_Cadenas();
                Errores();
                // if(errores.isEmpty()){
                    VSintactico();
                    ErroresS();

                    //}
                if(cad.equals(""))
                txtaSalida.setForeground(Color.darkGray);
                txtaSalida.setText("¡Compilación exitosa!");    //Ventana errores}

            if (!(cad.equals("")))   {
                txtaSalida.setForeground(Color.BLUE);
                txtaSalida.setText(cad);    //Ventana errores
            }
            System.out.println(cadena);
        }
        }*/

    }//GEN-LAST:event_AnalizarMouseClicked

    private void CompilarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CompilarMouseClicked
         analizarCod();// TODO add your handling code here:
    }//GEN-LAST:event_CompilarMouseClicked

    public void cerrar(){
        try {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter(){
               public void windowClosing(WindowEvent e) {
                   confirmarSalida();
               }
            });
            this.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void confirmarSalida(){
        int valor= JOptionPane.showConfirmDialog(this,"  ¿Quieres salir del programa? \nSe perderán todos los cambios realizados.", "Salir...",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (valor==JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VenPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VenPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VenPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VenPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VenPrincipal().setVisible(true);
            }
        });
    }
    
    public void probarLexer() throws IOException {
      guardarInfoCod c = new guardarInfoCod();
      File fichero = new File("fichero.lpg");
      PrintWriter writer;
      try{
          writer = new PrintWriter(fichero);
          writer.print(panelNum.getText());
          writer.close();
      }catch(Exception ex){
          Logger.getLogger(VenPrincipal.class.getName()).log(Level.SEVERE,null,ex);
      }
      Reader reader;
      reader = new BufferedReader(new FileReader("fichero.lpg"));
      lexer lex = new lexer(reader);
      String Resultado = "";
      String ResultError = "";
      while(true){
          token tok = lex.yylex();
          if(tok == null){
              Resultado = Resultado +"FIN";
              return;
          }
          
          switch(tok){
              case ERROR:
                  ResultError = ResultError +"* ERROR LEXICO 1. En la linea "+(c.linea+1)+".  El símbolo: [ "+lex.lexeme+" ]  NO ES VALIDO para el Lenguaje (LPG) *"+"\n";
                  txtaSalida.setText(ResultError);
                  txtaSalida.setForeground(Color.RED);
                  break;

              case p_reservada: 
                    tokens.addRow(new Object[]{(c.linea+1),lex.lexeme,tok});
                  break;
              case t_dato: 
                   tokens.addRow(new Object[]{(c.linea+1),lex.lexeme,tok});
                  break;
              case numero: 
                    tokens.addRow(new Object[]{(c.linea+1),lex.lexeme,tok});
                  break;
              case identificador: 
                   tokens.addRow(new Object[]{(c.linea+1),lex.lexeme,tok});
                   ids.add(lex.lexeme);
                  break;        
              case op_aritmetico: 
                    tokens.addRow(new Object[]{(c.linea+1),lex.lexeme,tok});
                    
                  break;
              case op_incremento: 
                    tokens.addRow(new Object[]{(c.linea+1),lex.lexeme,tok});
                  break;
              case op_decremento: 
                    tokens.addRow(new Object[]{(c.linea+1),lex.lexeme,tok});
                  break;
              case comillas: 
                    tokens.addRow(new Object[]{(c.linea+1),lex.lexeme,tok});
                  break;
              case op_logico:
                    tokens.addRow(new Object[]{(c.linea+1),lex.lexeme,tok});
                  break;
              case op_relacional: 
                    tokens.addRow(new Object[]{(c.linea+1),lex.lexeme,tok});
                  break;

              case op_asignacion: 
                    tokens.addRow(new Object[]{(c.linea+1),lex.lexeme,tok});
                  break;
              case simbol_p: 
                    tokens.addRow(new Object[]{(c.linea+1),lex.lexeme,tok});
                  break;
              case p_coma: 
                    tokens.addRow(new Object[]{(c.linea+1),lex.lexeme,tok});
                  break;
              case otros: 
                    tokens.addRow(new Object[]{(c.linea+1),lex.lexeme,tok});
                  break;
              case parentesis_a: 
                    tokens.addRow(new Object[]{(c.linea+1),lex.lexeme,tok});
                  break;
              case parentesis_c: 
                    tokens.addRow(new Object[]{(c.linea+1),lex.lexeme,tok});
                  break;
              case corchete_a: 
                    tokens.addRow(new Object[]{(c.linea+1),lex.lexeme,tok});
                  break;
              case corchete_c:
                    tokens.addRow(new Object[]{(c.linea+1),lex.lexeme,tok});
                  break;
              case llave_a: 
                    tokens.addRow(new Object[]{(c.linea+1),lex.lexeme,tok});
                  break;
              case llave_c: 
                    tokens.addRow(new Object[]{(c.linea+1),lex.lexeme,tok});
                  break;
              case dos_puntos:
                  tokens.addRow(new Object[]{(c.linea+1),lex.lexeme,tok});
                  break;
                  
          }
          if(ResultError.equals("")){
                    txtaSalida.setText(" \n  * El análisis se ha completado correctamente * ");
                    txtaSalida.setForeground(new Color(73,156,34));

                    
                    txtaSalida.setFont(font);
                  }
      }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Abrir;
    private javax.swing.JLabel Analizar;
    private javax.swing.JMenu Archivo;
    private javax.swing.JMenu Compilar;
    private javax.swing.JMenuItem Guardar;
    private javax.swing.JMenuItem GuardarComo;
    private javax.swing.JMenuBar MnuBar;
    private javax.swing.JMenuItem Nuevo;
    private javax.swing.JMenuItem Salir;
    private javax.swing.JMenuItem go_ID;
    private javax.swing.JMenuItem go_PR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextPane panelNum;
    private javax.swing.JMenu tablas_simbolos;
    public javax.swing.JTable tbtokens;
    private javax.swing.JTextArea txtaSalida;
    // End of variables declaration//GEN-END:variables

}
