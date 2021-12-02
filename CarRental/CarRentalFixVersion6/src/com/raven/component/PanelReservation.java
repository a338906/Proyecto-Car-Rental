package com.raven.component;

import component.login.*;
import connection.DatabaseConnection;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Random;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileSystemView;

public class PanelReservation extends javax.swing.JPanel {

    public PanelReservation() {
        initComponents();
        setBackground(new Color(255, 255, 255, 0));
    }

    public void fillCombobox() {
        String sql = "SELECT Aerolinea FROM AEROLINEA";
        try {
            PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                comboAirline.addItem(r.getString("Aerolinea"));
            }
            r.close();
            p.close();
            comboAirline.setSelectedIndex(-1);
        } catch (SQLException e) {
            System.err.println(e);
        }
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
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtAddress = new swing.login.TextField();
        txtPostal = new swing.login.TextField();
        jLabel6 = new javax.swing.JLabel();
        card = new com.raven.component.Card1();
        jPanel1 = new javax.swing.JPanel();
        comboAirline = new swing.login.Combobox();
        txtFlight = new swing.login.TextField();
        cmd = new swing.login.Button();
        jPanel2 = new javax.swing.JPanel();
        txtPhone = new swing.login.TextField();
        txtLicense = new swing.login.TextField();
        txtState = new swing.login.TextField();
        txtLast = new swing.login.TextField();
        txtEmail = new swing.login.TextField();
        txtName = new swing.login.TextField();
        comboAge = new swing.login.Combobox();

        comboCard.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "American Express", "Discover Network", "Mastercard", "Visa" }));
        comboCard.setSelectedIndex(-1);
        comboCard.setLabeText("Tipo de Tarjeta");
        comboCard.setLineColor(new java.awt.Color(0, 102, 255));
        comboCard.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboCardItemStateChanged(evt);
            }
        });

        comboMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        comboMonth.setSelectedIndex(-1);
        comboMonth.setLabeText("Mes Exp");
        comboMonth.setLightWeightPopupEnabled(false);
        comboMonth.setLineColor(new java.awt.Color(0, 102, 255));
        comboMonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboMonthItemStateChanged(evt);
            }
        });

        comboYear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031" }));
        comboYear.setSelectedIndex(-1);
        comboYear.setLabeText("Año Exp");
        comboYear.setLineColor(new java.awt.Color(0, 102, 255));
        comboYear.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboYearItemStateChanged(evt);
            }
        });

        txtCard.setLabelText("Numero de Tarjeta");
        txtCard.setLineColor(new java.awt.Color(0, 102, 255));
        txtCard.setSelectionColor(new java.awt.Color(0, 102, 255));
        txtCard.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCardFocusLost(evt);
            }
        });
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

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("INFORMACION DE VUELO");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/login/logo_1.png"))); // NOI18N
        jLabel1.setText("RENCAR");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("INGRESA LA INFORMACION");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));

        txtAddress.setLabelText("Direccion y Numero");
        txtAddress.setLineColor(new java.awt.Color(0, 102, 255));
        txtAddress.setSelectionColor(new java.awt.Color(0, 102, 255));
        txtAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAddressKeyTyped(evt);
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

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("INFORMACION DE PAGO");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        card.setBackground(new java.awt.Color(102, 102, 102));
        card.setColor2(new java.awt.Color(102, 102, 102));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        comboAirline.setLabeText("Aerolinea (opcional)");
        comboAirline.setLightWeightPopupEnabled(false);
        comboAirline.setLineColor(new java.awt.Color(0, 102, 255));

        txtFlight.setLabelText("Numero de Vuelo (opcional)");
        txtFlight.setLineColor(new java.awt.Color(0, 102, 255));
        txtFlight.setSelectionColor(new java.awt.Color(0, 102, 255));
        txtFlight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFlightKeyTyped(evt);
            }
        });

        cmd.setBackground(new java.awt.Color(0, 102, 255));
        cmd.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        cmd.setForeground(new java.awt.Color(255, 255, 255));
        cmd.setText("CREAR RESERVACION");
        cmd.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        cmd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmdMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cmdMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(128, Short.MAX_VALUE)
                .addComponent(comboAirline, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(txtFlight, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmd, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFlight, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboAirline, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(cmd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txtPhone.setLabelText("Telefono");
        txtPhone.setLineColor(new java.awt.Color(0, 102, 255));
        txtPhone.setSelectionColor(new java.awt.Color(0, 102, 255));
        txtPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhoneKeyTyped(evt);
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

        txtState.setLabelText("Estado de Tramite de la Licencia (lugar)");
        txtState.setLineColor(new java.awt.Color(0, 102, 255));
        txtState.setSelectionColor(new java.awt.Color(0, 102, 255));
        txtState.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStateKeyTyped(evt);
            }
        });

        txtLast.setLabelText("Apellido");
        txtLast.setLineColor(new java.awt.Color(0, 102, 255));
        txtLast.setSelectionColor(new java.awt.Color(0, 102, 255));
        txtLast.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLastFocusLost(evt);
            }
        });
        txtLast.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLastKeyTyped(evt);
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

        txtName.setLabelText("Nombre");
        txtName.setLineColor(new java.awt.Color(0, 102, 255));
        txtName.setSelectionColor(new java.awt.Color(0, 102, 255));
        txtName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNameFocusLost(evt);
            }
        });
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNameKeyTyped(evt);
            }
        });

        comboAge.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "25+", "24", "23", "22", "21", "20", "19", "18" }));
        comboAge.setSelectedIndex(-1);
        comboAge.setLabeText("Edad");
        comboAge.setLineColor(new java.awt.Color(0, 102, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLast, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(comboAge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(txtLicense, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLast, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLicense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCard, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelRound1Layout.createSequentialGroup()
                                        .addComponent(comboCard, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(comboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(panelRound1Layout.createSequentialGroup()
                                        .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)))
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtPostal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCVV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboYear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                        .addComponent(card, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(17, 17, 17)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboYear, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboCard, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCVV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(card, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(49, 49, 49)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

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

    private void txtFlightKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFlightKeyTyped
        char c = evt.getKeyChar();
        if (txtFlight.getText().length() >= 4) {
            evt.consume();
        } else {
            if (c >= '0' && c <= '9') {
            } else {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtFlightKeyTyped

    private void cmdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdMouseEntered
        cmd.setBackground(new Color(0, 132, 255));
    }//GEN-LAST:event_cmdMouseEntered

    private void cmdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdMouseExited
        cmd.setBackground(new Color(0, 102, 255));
    }//GEN-LAST:event_cmdMouseExited

    private void comboCardItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboCardItemStateChanged
        String item = (String) comboCard.getSelectedItem();
        if (item.equals("Visa")) {
            card.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/visa.png")));
            card.setColor1(new Color(102, 204, 255));
            card.setColor2(new Color(0, 51, 204));
        } else if (item.equals("Mastercard")) {
            card.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/mastercard.png")));
            card.setColor1(new Color(200, 200, 200));
            card.setColor2(new Color(150, 150, 150));
        } else if (item.equals("American Express")) {
            card.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/american.png")));
            card.setColor1(new Color(0, 204, 204));
            card.setColor2(new Color(0, 102, 102));
        } else if (item.equals("Discover Network")) {
            card.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/discover.png")));
            card.setColor1(new Color(204, 204, 0));
            card.setColor2(new Color(153, 153, 0));
        }
        card.repaint();
    }//GEN-LAST:event_comboCardItemStateChanged

    private void comboMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboMonthItemStateChanged
        card.setMonth((String) comboMonth.getSelectedItem());
    }//GEN-LAST:event_comboMonthItemStateChanged

    private void comboYearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboYearItemStateChanged
        card.setYear((String) comboYear.getSelectedItem());
    }//GEN-LAST:event_comboYearItemStateChanged

    private void txtCardFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCardFocusLost
        card.setCard(getCard());
    }//GEN-LAST:event_txtCardFocusLost

    private void txtNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusLost
        card.setName(getNames());
    }//GEN-LAST:event_txtNameFocusLost

    private void txtLastFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLastFocusLost
        card.setLastName(getLastName());
    }//GEN-LAST:event_txtLastFocusLost

    public boolean checkReservation() {
        if (!emailValidate(txtEmail.getText().trim())) {
            showMessage(Message.MessageType.ERROR, "Correo no valido");
        } else if (!errorFlight()) {
            showMessage(Message.MessageType.ERROR, "Llene los campos de vuelo");
        }
        return !(txtName.getText().trim().equals("") || txtLast.getText().trim().equals("") || txtEmail.getText().trim().equals("")
                || txtPostal.getText().trim().equals("") || txtAddress.getText().trim().equals("") || txtPhone.getText().trim().equals("")
                || comboAge.getSelectedItem().toString().equals("") || txtCard.getText().trim().equals("") || txtCVV.getText().trim().equals("")
                || txtLicense.getText().trim().equals("") || txtState.getText().trim().equals("")
                || comboCard.getSelectedItem().toString().equals("") || comboMonth.getSelectedItem().toString().equals("")
                || comboYear.getSelectedItem().toString().equals("") || !emailValidate(txtEmail.getText().trim()) || !errorFlight());
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

    public String getLicense() {
        return txtLicense.getText().trim();
    }

    public String getState() {
        return txtState.getText().trim();
    }

    public String getFlight() {
        return txtFlight.getText().trim();
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

    public String selectAirline() {
        String selectedValue = "";
        if (comboAirline.getSelectedItem() != null) {
            selectedValue = comboAirline.getSelectedItem().toString();
        }
        return selectedValue;
    }

    public boolean errorFlight() {
        return !(comboAirline.getSelectedItem() != null && txtFlight.getText().equals("") || comboAirline.getSelectedItem() == null && !txtFlight.getText().equals(""));
    }

    public void error() {
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
        if (txtEmail.getText().trim().equals("") || !emailValidate(txtEmail.getText().trim())) {
            txtEmail.setBackground(new Color(255, 204, 204));
            txtEmail.setLineColor(Color.red);
        } else {
            txtEmail.setBackground(new Color(255, 255, 255));
            txtEmail.setLineColor(new Color(0, 102, 255));
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
        if (comboAirline.getSelectedItem() != null && txtFlight.getText().equals("")) {
            txtFlight.setBackground(new Color(255, 204, 204));
            txtFlight.setLineColor(Color.red);
        } else {
            txtFlight.setBackground(new Color(255, 255, 255));
            txtFlight.setLineColor(new Color(0, 102, 255));
        }
        if (comboAirline.getSelectedItem() == null && !txtFlight.getText().equals("")) {
            comboAirline.setBackground(new Color(255, 204, 204));
            comboAirline.setLineColor(Color.red);
        } else {
            comboAirline.setBackground(new Color(255, 255, 255));
            comboAirline.setLineColor(new Color(0, 102, 255));
        }
    }

    private boolean emailValidate(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public void addEventContinue(ActionListener event) {
        cmd.addActionListener(event);
    }

    public void showMessage(Message.MessageType messageType, String message) {
        JDialog messageDialog = new JDialog();
        messageDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        Message ms = new Message();
        ms.showMessage(messageType, message);
        messageDialog.add(ms);
        messageDialog.getRootPane().setOpaque(false);
        messageDialog.setUndecorated(true);
        messageDialog.setBackground(new Color(0, 0, 0, 0));
        messageDialog.setLocationRelativeTo(this);
        messageDialog.pack();
        messageDialog.setVisible(true);
    }

    public static enum MessageType {
        SUCCESS, ERROR, COMMENT
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.component.Card1 card;
    private swing.login.Button cmd;
    private swing.login.Combobox comboAge;
    private swing.login.Combobox comboAirline;
    private swing.login.Combobox comboCard;
    private swing.login.Combobox comboMonth;
    private swing.login.Combobox comboYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private swing.login.PanelRound panelRound1;
    private swing.login.TextField txtAddress;
    private swing.login.TextField txtCVV;
    private swing.login.TextField txtCard;
    private swing.login.TextField txtEmail;
    private swing.login.TextField txtFlight;
    private swing.login.TextField txtLast;
    private swing.login.TextField txtLicense;
    private swing.login.TextField txtName;
    private swing.login.TextField txtPhone;
    private swing.login.TextField txtPostal;
    private swing.login.TextField txtState;
    // End of variables declaration//GEN-END:variables
}
