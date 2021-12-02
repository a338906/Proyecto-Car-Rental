package component.login;

import connection.DatabaseConnection;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import service.login.ServiceUser;
import verify.login.InvalidPasswordException;
import verify.login.PasswordValidator;
import verify.login.UserValidate;

public class PanelRegister extends javax.swing.JPanel implements ActionListener {

    private PanelSlide slide;
    boolean show = false;
    float alphaValue = 0f;
    Timer alphaTimer = new Timer(20, this);
    boolean show1 = true;
    private ServiceUser serviceUser;
    private Thread th;
    int exit = 0;

    public PanelRegister() {
        initComponents();
        slide = new PanelSlide();
        serviceUser = new ServiceUser();
        setVisible(show1);
        setOpaque(show);
        alphaTimer.start();
        txtPass.setEchoChar('\u2022');
        txtPass1.setEchoChar('\u2022');
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new swing.login.PanelRound();
        comboCard = new swing.login.Combobox();
        comboMonth = new swing.login.Combobox();
        comboYear = new swing.login.Combobox();
        txtCard = new swing.login.TextField();
        txtCVV = new swing.login.TextField();
        jLabel3 = new javax.swing.JLabel();
        txtUser = new swing.login.TextField();
        txtPass = new swing.login.PasswordField();
        txtLicense = new swing.login.TextField();
        txtState = new swing.login.TextField();
        cmd = new swing.login.Button();
        jLabel5 = new javax.swing.JLabel();
        close1Button = new swing.login.Close1Button();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtName = new swing.login.TextField();
        jLabel10 = new javax.swing.JLabel();
        txtLast = new swing.login.TextField();
        jSeparator1 = new javax.swing.JSeparator();
        txtAddress = new swing.login.TextField();
        showButton = new swing.login.Close1Button();
        txtPostal = new swing.login.TextField();
        txtPass1 = new swing.login.PasswordField();
        txtEmail = new swing.login.TextField();
        txtPhone = new swing.login.TextField();
        comboAge = new swing.login.Combobox();
        txtDiscount = new swing.login.TextField();
        jLabel6 = new javax.swing.JLabel();

        comboCard.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "American Express", "Discover Network", "Mastercard", "Visa" }));
        comboCard.setSelectedIndex(-1);
        comboCard.setLabeText("Tipo de Tarjeta");
        comboCard.setLineColor(new java.awt.Color(0, 102, 255));

        comboMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        comboMonth.setSelectedIndex(-1);
        comboMonth.setLabeText("Mes Exp");
        comboMonth.setLightWeightPopupEnabled(false);
        comboMonth.setLineColor(new java.awt.Color(0, 102, 255));

        comboYear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031" }));
        comboYear.setSelectedIndex(-1);
        comboYear.setLabeText("Año Exp");
        comboYear.setLineColor(new java.awt.Color(0, 102, 255));

        txtCard.setLabelText("Numero de Tarjeta");
        txtCard.setLineColor(new java.awt.Color(0, 102, 255));
        txtCard.setSelectionColor(new java.awt.Color(0, 102, 255));
        txtCard.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCardKeyTyped(evt);
            }
        });

        txtCVV.setLabelText("CVV");
        txtCVV.setLineColor(new java.awt.Color(0, 102, 255));
        txtCVV.setSelectionColor(new java.awt.Color(0, 102, 255));
        txtCVV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCVVKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("INFORMACION PERSONAL");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtUser.setLabelText("Nombre de Usuario");
        txtUser.setLineColor(new java.awt.Color(0, 102, 255));
        txtUser.setSelectionColor(new java.awt.Color(0, 102, 255));
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUserKeyTyped(evt);
            }
        });

        txtPass.setLabelText("Contraseña");
        txtPass.setLineColor(new java.awt.Color(0, 102, 255));
        txtPass.setSelectionColor(new java.awt.Color(0, 102, 255));
        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPassKeyTyped(evt);
            }
        });

        txtLicense.setLabelText("Numero de Licencia");
        txtLicense.setLineColor(new java.awt.Color(0, 102, 255));
        txtLicense.setSelectionColor(new java.awt.Color(0, 102, 255));
        txtLicense.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLicenseKeyTyped(evt);
            }
        });

        txtState.setLabelText("Estado de Tramite (lugar)");
        txtState.setLineColor(new java.awt.Color(0, 102, 255));
        txtState.setSelectionColor(new java.awt.Color(0, 102, 255));
        txtState.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStateKeyTyped(evt);
            }
        });

        cmd.setBackground(new java.awt.Color(0, 102, 255));
        cmd.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        cmd.setForeground(new java.awt.Color(255, 255, 255));
        cmd.setText("Crear Cuenta");
        cmd.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        cmd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmdMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cmdMouseExited(evt);
            }
        });
        cmd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("INFORMACION DE CONDUCTOR");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        close1Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/login/close.png"))); // NOI18N
        close1Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                close1ButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                close1ButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                close1ButtonMousePressed(evt);
            }
        });
        close1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close1ButtonActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("INFORMACION DE CUENTA");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/login/logo_1.png"))); // NOI18N
        jLabel1.setText("RENCAR");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("RENCAR unicamente almacenara los ultimos cuatro digitos de su tarjeta.");

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CREA TU CUENTA");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Nosotros unicamente recibiremos un token para recibir el pago de su");

        txtName.setLabelText("Nombre");
        txtName.setLineColor(new java.awt.Color(0, 102, 255));
        txtName.setSelectionColor(new java.awt.Color(0, 102, 255));
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNameKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("reservacion. ");

        txtLast.setLabelText("Apellido");
        txtLast.setLineColor(new java.awt.Color(0, 102, 255));
        txtLast.setSelectionColor(new java.awt.Color(0, 102, 255));
        txtLast.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLastKeyTyped(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));

        txtAddress.setLabelText("Direccion y Numero");
        txtAddress.setLineColor(new java.awt.Color(0, 102, 255));
        txtAddress.setSelectionColor(new java.awt.Color(0, 102, 255));
        txtAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAddressKeyTyped(evt);
            }
        });

        showButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/login/show.png"))); // NOI18N
        showButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                showButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                showButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                showButtonMousePressed(evt);
            }
        });
        showButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButtonActionPerformed(evt);
            }
        });

        txtPostal.setLabelText("Codigo Postal ");
        txtPostal.setLineColor(new java.awt.Color(0, 102, 255));
        txtPostal.setSelectionColor(new java.awt.Color(0, 102, 255));
        txtPostal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPostalKeyTyped(evt);
            }
        });

        txtPass1.setLabelText("Verificar Contraseña");
        txtPass1.setLineColor(new java.awt.Color(0, 102, 255));
        txtPass1.setSelectionColor(new java.awt.Color(0, 102, 255));
        txtPass1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPass1KeyTyped(evt);
            }
        });

        txtEmail.setLabelText("Correo");
        txtEmail.setLineColor(new java.awt.Color(0, 102, 255));
        txtEmail.setSelectionColor(new java.awt.Color(0, 102, 255));
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });

        txtPhone.setLabelText("Telefono");
        txtPhone.setLineColor(new java.awt.Color(0, 102, 255));
        txtPhone.setSelectionColor(new java.awt.Color(0, 102, 255));
        txtPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhoneKeyTyped(evt);
            }
        });

        comboAge.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "25+", "24", "23", "22", "21", "20", "19", "18" }));
        comboAge.setSelectedIndex(-1);
        comboAge.setLabeText("Edad");
        comboAge.setLineColor(new java.awt.Color(0, 102, 255));

        txtDiscount.setLabelText("Codigo de Descuento de 6 Digitos (Opcional)");
        txtDiscount.setLineColor(new java.awt.Color(0, 102, 255));
        txtDiscount.setSelectionColor(new java.awt.Color(0, 102, 255));
        txtDiscount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDiscountKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("INFORMACION DE PAGO");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPass1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(showButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtLast, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(comboAge, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(comboCard, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(comboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(comboYear, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txtPostal, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtCard, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtCVV, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(txtLicense, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(cmd, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(186, 186, 186)
                        .addComponent(close1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1))
                    .addComponent(close1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jLabel4)
                .addGap(17, 17, 17)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel3)
                .addGap(11, 11, 11)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtLast, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(11, 11, 11)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(showButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPass1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(11, 11, 11)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboCard, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboYear, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel9)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel10)))
                .addGap(11, 11, 11)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCVV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(11, 11, 11)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLicense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(cmd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(227, Short.MAX_VALUE)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(227, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void close1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close1ButtonActionPerformed
        if (show1) {
            alphaValue = 0.5f;
            show1 = false;
            alphaTimer.start();
        } else {
            JComponent comp = (JComponent) evt.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
        }
    }//GEN-LAST:event_close1ButtonActionPerformed

    private void close1ButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close1ButtonMouseEntered
        close1Button.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_close1ButtonMouseEntered

    private void close1ButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close1ButtonMouseExited
        close1Button.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_close1ButtonMouseExited

    private void close1ButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close1ButtonMousePressed
        close1Button.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_close1ButtonMousePressed

    private void cmdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdMouseEntered
        cmd.setBackground(new Color(0, 132, 255));
    }//GEN-LAST:event_cmdMouseEntered

    private void cmdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdMouseExited
        cmd.setBackground(new Color(0, 102, 255));
    }//GEN-LAST:event_cmdMouseExited

    private void txtPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneKeyTyped
        char c = evt.getKeyChar();
        if (txtPhone.getText().length() >= 15) {
            evt.consume();
        } else {
            if (Character.isLetter(c) && !evt.isAltDown()) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtPhoneKeyTyped

    private void txtNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyTyped
        char c = evt.getKeyChar();
        if (txtName.getText().length() >= 100) {
            evt.consume();
        } else {
            if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
                txtName.setEditable(true);
            } else {
                txtName.setEditable(false);
            }
        }
    }//GEN-LAST:event_txtNameKeyTyped

    private void txtLastKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLastKeyTyped
        char c = evt.getKeyChar();
        if (txtLast.getText().length() >= 100) {
            evt.consume();
        } else {
            if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)) {
                txtLast.setEditable(true);
            } else {
                txtLast.setEditable(false);
            }
        }
    }//GEN-LAST:event_txtLastKeyTyped

    private void txtCardKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCardKeyTyped
        char c = evt.getKeyChar();
        if (txtCard.getText().length() >= 16) {
            evt.consume();
        } else {
            if (c >= '0' && c <= '9') {
            } else {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtCardKeyTyped

    private void txtCVVKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCVVKeyTyped
        char c = evt.getKeyChar();
        if (txtCVV.getText().length() >= 4) {
            evt.consume();
        } else {
            if (c >= '0' && c <= '9') {
            } else {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtCVVKeyTyped

    private void txtUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyTyped
        char c = evt.getKeyChar();
        if (txtUser.getText().length() >= 30) {
            evt.consume();
        }
    }//GEN-LAST:event_txtUserKeyTyped

    private void txtPassKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyTyped
        char c = evt.getKeyChar();
        if (String.valueOf(txtPass.getPassword()).length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPassKeyTyped

    private void txtPass1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPass1KeyTyped
        char c = evt.getKeyChar();
        if (String.valueOf(txtPass1.getPassword()).length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPass1KeyTyped

    private void txtDiscountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiscountKeyTyped
        char c = evt.getKeyChar();
        if (txtDiscount.getText().length() >= 6) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDiscountKeyTyped

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped
        char c = evt.getKeyChar();
        if (txtEmail.getText().length() >= 255) {
            evt.consume();
        }
    }//GEN-LAST:event_txtEmailKeyTyped

    private void txtAddressKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddressKeyTyped
        char c = evt.getKeyChar();
        if (txtAddress.getText().length() >= 100) {
            evt.consume();
        } else {
        }
    }//GEN-LAST:event_txtAddressKeyTyped

    private void txtPostalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPostalKeyTyped
        char c = evt.getKeyChar();
        if (txtPostal.getText().length() >= 10) {
            evt.consume();
        } else {
            if (c >= '0' && c <= '9') {
            } else {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtPostalKeyTyped

    private void txtLicenseKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLicenseKeyTyped
        char c = evt.getKeyChar();
        if (txtLicense.getText().length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtLicenseKeyTyped

    private void txtStateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStateKeyTyped
        char c = evt.getKeyChar();
        if (txtState.getText().length() >= 100) {
            evt.consume();
        }
    }//GEN-LAST:event_txtStateKeyTyped

    private void showButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showButtonMouseEntered
        showButton.setBackground(new Color(240, 240, 240));
    }//GEN-LAST:event_showButtonMouseEntered

    private void showButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showButtonMouseExited
        showButton.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_showButtonMouseExited

    private void showButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showButtonMousePressed
        showButton.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_showButtonMousePressed

    private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButtonActionPerformed
        if (show == false) {
            txtPass.setEchoChar((char) 0);
            txtPass1.setEchoChar((char) 0);
            showButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/login/show.png")));
            show = true;
        } else {
            showButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/login/hide.png")));
            txtPass.setEchoChar('\u2022');
            txtPass1.setEchoChar('\u2022');
            show = false;
        }
    }//GEN-LAST:event_showButtonActionPerformed

    private void cmdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdActionPerformed
        error(null, null, null, null);

        String user = null;
        String email = null;
        String discount = null;
        String pass = passwordVerify(getPassword(), evt);

        int regverify = registerVerify(getUserName(), getEmail(), evt);

        if (!UserValidate.isValidUsername(getUserName()) && !getUserName().equals("")) {
            user = "Error";
            showMessage(Message.MessageType.ERROR, "Ingrese un nombre de usuario valido.", evt);
        }
        if (regverify == 1) {
            user = "Error";
        }

        if (!emailValidate(getEmail()) && !getEmail().equals("")) {
            showMessage(Message.MessageType.ERROR, "El correo no es valido.", evt);
            email = "Error";
        } else if (regverify == 2) {
            email = "Error";
        }

        try {
            if (!checkDiscount(getDiscount()) && !getDiscount().equals("")) {
                showMessage(Message.MessageType.ERROR, "El descuento no existe.", evt);
                discount = "Error";
            }
        } catch (SQLException e) {
            showMessage(Message.MessageType.ERROR, "Error al validar descuento.", evt);
        }

        if (!getPassword().equals(getPassword1())) {
            showMessage(Message.MessageType.ERROR, "Las contraseñas no coinciden.", evt);
        }
        if (checkUserRegister() && UserValidate.isValidUsername(getUserName()) && regverify == 0 && emailValidate(getEmail()) && getDiscount().equals("")) {
            showMessage(Message.MessageType.SUCCESS, "Todos los campos cumplen con las condiciones.", evt);
            close1Button.doClick();
            exit = -1;
        } else if (!checkUserRegister()) {
            showMessage(Message.MessageType.ERROR, "Campos vacios.", evt);
        }

        error(pass, user, email, discount);
    }//GEN-LAST:event_cmdActionPerformed

    public boolean checkUserRegister() {
        return !(txtUser.getText().trim().equals("") || String.valueOf(txtPass.getPassword()).trim().equals("")
                || String.valueOf(txtPass1.getPassword()).trim().equals("") || txtName.getText().trim().equals("")
                || txtLast.getText().trim().equals("") || txtEmail.getText().trim().equals("") || txtPostal.getText().trim().equals("")
                || txtAddress.getText().trim().equals("") || txtPhone.getText().trim().equals("")
                || comboAge.getSelectedItem().toString().equals("") || txtCard.getText().trim().equals("") || txtCVV.getText().trim().equals("")
                || txtLicense.getText().trim().equals("") || txtState.getText().trim().equals("")
                || comboCard.getSelectedItem().toString().equals("") || comboMonth.getSelectedItem().toString().equals("")
                || comboYear.getSelectedItem().toString().equals(""));
    }

    public int getExit() {
        return exit;
    }

    public String getUserName() {
        return txtUser.getText().trim().toLowerCase();
    }

    public String getNames() {
        return txtName.getText().trim();
    }

    public String getLastName() {
        return txtLast.getText().trim();
    }

    public String getEmail() {
        return txtEmail.getText().trim().toLowerCase();
    }

    public String getAddress() {
        return txtAddress.getText().trim();
    }

    public String getPostal() {
        return txtPostal.getText().trim();
    }

    public String getPhone() {
        return txtPhone.getText().trim();
    }

    public String getPassword() {
        return String.valueOf(txtPass.getPassword());
    }

    public String getPassword1() {
        return String.valueOf(txtPass1.getPassword());
    }

    public String getCard() {
        String card = txtCard.getText().trim();
        String lastFourDigits;
        if (card.length() > 3) {
            lastFourDigits = card.substring(card.length() - 4);
        } else {
            lastFourDigits = card;
        }
        return lastFourDigits;
    }

    public String getDiscount() {
        return txtDiscount.getText().trim().toUpperCase();
    }

    public String getLicense() {
        return txtCard.getText().trim();
    }

    public String getState() {
        return txtCard.getText().trim();
    }

    public String selectCard() {
        String selectedValue = comboCard.getSelectedItem().toString();
        return selectedValue;
    }

    public String selectMonth() {
        String selectedValue = comboMonth.getSelectedItem().toString();
        return selectedValue;
    }

    public String selectYear() {
        String selectedValue = comboYear.getSelectedItem().toString();
        return selectedValue;
    }

    public String selectAge() {
        String selectedValue = comboAge.getSelectedItem().toString();
        return selectedValue;
    }

    public void error(String passError, String userError, String email, String discount) {
        if (txtUser.getText().trim().equals("") || userError != null) {
            txtUser.setBackground(new Color(255, 204, 204));
            txtUser.setLineColor(Color.red);
        } else {
            txtUser.setBackground(new Color(255, 255, 255));
            txtUser.setLineColor(new Color(0, 102, 255));
        }
        if (String.valueOf(txtPass.getPassword()).trim().equals("") || passError != null) {
            txtPass.setBackground(new Color(255, 204, 204));
            txtPass.setLineColor(Color.red);
        } else {
            txtPass.setBackground(new Color(255, 255, 255));
            txtPass.setLineColor(new Color(0, 102, 255));
        }
        if (String.valueOf(txtPass1.getPassword()).trim().equals("") || !(Arrays.equals(txtPass.getPassword(), txtPass1.getPassword()))) {
            txtPass1.setBackground(new Color(255, 204, 204));
            txtPass1.setLineColor(Color.red);
        } else {
            txtPass1.setBackground(new Color(255, 255, 255));
            txtPass1.setLineColor(new Color(0, 102, 255));
        }
        if (txtName.getText().trim().equals("")) {
            txtName.setBackground(new Color(255, 204, 204));
            txtName.setLineColor(Color.red);
        } else {
            txtName.setBackground(new Color(255, 255, 255));
            txtName.setLineColor(new Color(0, 102, 255));
        }
        if (txtLast.getText().trim().equals("")) {
            txtLast.setBackground(new Color(255, 204, 204));
            txtLast.setLineColor(Color.red);
        } else {
            txtLast.setBackground(new Color(255, 255, 255));
            txtLast.setLineColor(new Color(0, 102, 255));
        }
        if (txtEmail.getText().trim().equals("") || email != null) {
            txtEmail.setBackground(new Color(255, 204, 204));
            txtEmail.setLineColor(Color.red);
        } else {
            txtEmail.setBackground(new Color(255, 255, 255));
            txtEmail.setLineColor(new Color(0, 102, 255));
        }
        if (discount != null) {
            txtDiscount.setBackground(new Color(255, 204, 204));
            txtDiscount.setLineColor(Color.red);
        } else {
            txtDiscount.setBackground(new Color(255, 255, 255));
            txtDiscount.setLineColor(new Color(0, 102, 255));
        }
        if (txtAddress.getText().trim().equals("")) {
            txtAddress.setBackground(new Color(255, 204, 204));
            txtAddress.setLineColor(Color.red);
        } else {
            txtAddress.setBackground(new Color(255, 255, 255));
            txtAddress.setLineColor(new Color(0, 102, 255));
        }
        if (txtPhone.getText().trim().equals("")) {
            txtPhone.setBackground(new Color(255, 204, 204));
            txtPhone.setLineColor(Color.red);
        } else {
            txtPhone.setBackground(new Color(255, 255, 255));
            txtPhone.setLineColor(new Color(0, 102, 255));
        }
        if (txtCard.getText().trim().equals("")) {
            txtCard.setBackground(new Color(255, 204, 204));
            txtCard.setLineColor(Color.red);
        } else {
            txtCard.setBackground(new Color(255, 255, 255));
            txtCard.setLineColor(new Color(0, 102, 255));
        }
        if (txtCVV.getText().trim().equals("")) {
            txtCVV.setBackground(new Color(255, 204, 204));
            txtCVV.setLineColor(Color.red);
        } else {
            txtCVV.setBackground(new Color(255, 255, 255));
            txtCVV.setLineColor(new Color(0, 102, 255));
        }
        if (txtLicense.getText().trim().equals("")) {
            txtLicense.setBackground(new Color(255, 204, 204));
            txtLicense.setLineColor(Color.red);
        } else {
            txtLicense.setBackground(new Color(255, 255, 255));
            txtLicense.setLineColor(new Color(0, 102, 255));
        }
        if (txtState.getText().trim().equals("")) {
            txtState.setBackground(new Color(255, 204, 204));
            txtState.setLineColor(Color.red);
        } else {
            txtState.setBackground(new Color(255, 255, 255));
            txtState.setLineColor(new Color(0, 102, 255));
        }
        if (txtPostal.getText().trim().equals("")) {
            txtPostal.setBackground(new Color(255, 204, 204));
            txtPostal.setLineColor(Color.red);
        } else {
            txtPostal.setBackground(new Color(255, 255, 255));
            txtPostal.setLineColor(new Color(0, 102, 255));
        }
        if (comboAge.getSelectedItem() == null) {
            comboAge.setBackground(new java.awt.Color(255, 204, 204));
            comboAge.setLineColor(Color.red);
        } else {
            comboAge.setBackground(new Color(255, 255, 255));
            comboAge.setLineColor(new Color(0, 102, 255));
        }
        if (comboCard.getSelectedItem() == null) {
            comboCard.setBackground(new Color(255, 204, 204));
            comboCard.setLineColor(Color.red);
        } else {
            comboCard.setBackground(new Color(255, 255, 255));
            comboCard.setLineColor(new Color(0, 102, 255));
        }
        if (comboMonth.getSelectedItem() == null) {
            comboMonth.setBackground(new Color(255, 204, 204));
            comboMonth.setLineColor(Color.red);
        } else {
            comboMonth.setBackground(new Color(255, 255, 255));
            comboMonth.setLineColor(new Color(0, 102, 255));
        }
        if (comboYear.getSelectedItem() == null) {
            comboYear.setBackground(new Color(255, 204, 204));
            comboYear.setLineColor(Color.red);
        } else {
            comboYear.setBackground(new Color(255, 255, 255));
            comboYear.setLineColor(new Color(0, 102, 255));
        }
    }

    private boolean checkDiscount(String discount) throws SQLException {
        boolean found = false;
        PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement("SELECT Descuento FROM DESCUENTO WHERE Num_Descuento=?");
        p.setString(1, discount);
        ResultSet r = p.executeQuery();
        if (r.next()) {
            found = true;
        }
        r.close();
        p.close();
        return found;
    }

    private boolean emailValidate(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    private int registerVerify(String userName, String email, ActionEvent evt) {
        try {
            if (serviceUser.checkDuplicateUser(userName)) {
                showMessage(Message.MessageType.ERROR, "El usuario ya existe.", evt);
                return 1;
            }
            if (serviceUser.checkDuplicateEmail(email)) {
                showMessage(Message.MessageType.ERROR, "El correo ya existe.", evt);
                return 2;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            return -1;
        }
    }

    private String passwordVerify(String password, ActionEvent evt) {
        try {
            PasswordValidator.isValid(password);
            return null;
        } catch (InvalidPasswordException e) {
            e.getMessage();
            showMessage(Message.MessageType.ERROR, e.printMessage(), evt);
            return "Error";
        }
    }

    public void showMessage(Message.MessageType messageType, String message, ActionEvent e) {
        JDialog messageDialog = new JDialog();
        messageDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        Message ms = new Message();
        ms.showMessage(messageType, message);
        messageDialog.add(ms);
        messageDialog.getRootPane().setOpaque(false);
        messageDialog.setUndecorated(true);
        messageDialog.setBackground(new Color(0, 0, 0, 0));
        messageDialog.pack();
        messageDialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor((Component) e.getSource()));
        messageDialog.setVisible(true);
    }

    public static enum MessageType {
        SUCCESS, ERROR, COMMENT
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setColor(new Color(50, 50, 50));
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));
        g2.fillRect(0, 0, getWidth(), getHeight());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (show1) {
            alphaValue = alphaValue + 0.05f;
            if (alphaValue > 0.5f) {
                alphaValue = 0.5f;
                alphaTimer.stop();
            }
        } else {
            alphaValue = alphaValue - 0.05f;
            if (alphaValue < 0) {
                alphaValue = 0;
                alphaTimer.stop();
            }
        }
        repaint();
        if (alphaValue == 0) {
            close1Button.doClick();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.login.Close1Button close1Button;
    private swing.login.Button cmd;
    private swing.login.Combobox comboAge;
    private swing.login.Combobox comboCard;
    private swing.login.Combobox comboMonth;
    private swing.login.Combobox comboYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private swing.login.PanelRound panelRound1;
    private swing.login.Close1Button showButton;
    private swing.login.TextField txtAddress;
    private swing.login.TextField txtCVV;
    private swing.login.TextField txtCard;
    private swing.login.TextField txtDiscount;
    private swing.login.TextField txtEmail;
    private swing.login.TextField txtLast;
    private swing.login.TextField txtLicense;
    private swing.login.TextField txtName;
    private swing.login.PasswordField txtPass;
    private swing.login.PasswordField txtPass1;
    private swing.login.TextField txtPhone;
    private swing.login.TextField txtPostal;
    private swing.login.TextField txtState;
    private swing.login.TextField txtUser;
    // End of variables declaration//GEN-END:variables
}
