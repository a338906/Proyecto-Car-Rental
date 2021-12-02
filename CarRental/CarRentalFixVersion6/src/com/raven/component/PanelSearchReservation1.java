package com.raven.component;

import component.login.*;
import connection.DatabaseConnection;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;
import service.login.ServiceUser;
import swing.login.EventCallBack;
import swing.login.EventTextField;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class PanelSearchReservation1 extends javax.swing.JPanel implements ActionListener {

    Timer alphaTimer = new Timer(20, this);
    float alphaValue = 0f;
    private boolean show = true;

    private ServiceUser serviceUser;

    public PanelSearchReservation1() {
        initComponents();
        serviceUser = new ServiceUser();
        setOpaque(false);
        setVisible(show);
        alphaTimer.start();
        textFieldAnimation.addEvent(new EventTextField() {
            @Override
            public void onPressed(EventCallBack call) {
                String email = getInputEmail();
                if (!email.equals("")) {
                    try {
                        Thread.sleep(2000);
                        String sql = "SELECT ReservacionID FROM RESERVACION WHERE Correo=? AND Telefono=? AND Apellido=?";
                        PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
                        p.setString(1, email.toUpperCase());
                        p.setString(2, lbPhone.getText().trim());
                        p.setString(3, lbLastName.getText().trim().toUpperCase());
                        ResultSet r = p.executeQuery();
                        if (r.next()) {
                            showMessage(Message.MessageType.SUCCESS, "Reservacion encontrada.");
                            String code = r.getString("ReservacionID");
                            call.done();
                            showMessage(Message.MessageType.COMMENT, "Su codigo de reservacion es: " + code);
                            close1Button1.doClick();
                        } else {
                            showMessage(Message.MessageType.ERROR, "No hay ninguna reservacion con este codigo.");
                            call.done();
                        }
                        r.close();
                        p.close();
                    } catch (Exception e) {
                        showMessage(Message.MessageType.ERROR, "" + e);
                        call.done();
                    }
                } else {
                    showMessage(Message.MessageType.ERROR, "Campo vacio.");
                    call.done();
                }
            }

            @Override
            public void onCancel() {

            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new swing.login.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textFieldAnimation = new swing.login.TextFieldAnimation();
        close1Button1 = new swing.login.Close1Button();
        lbLastName = new swing.login.MyTextField();
        jLabel3 = new javax.swing.JLabel();
        lbPhone = new swing.login.MyTextField();
        jLabel4 = new javax.swing.JLabel();

        setOpaque(false);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(63, 63, 63));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("POR NUMERO DE RESERVACION");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ingrese el correo en la reservacion");

        textFieldAnimation.setBackground(new java.awt.Color(235, 235, 235));
        textFieldAnimation.setAnimationColor(new java.awt.Color(0, 102, 255));
        textFieldAnimation.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        textFieldAnimation.setHintText("Buscar reservacion ...");
        textFieldAnimation.setSelectionColor(new java.awt.Color(0, 102, 255));

        close1Button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/login/close.png"))); // NOI18N
        close1Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close1Button1ActionPerformed(evt);
            }
        });

        lbLastName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lbLastName.setSelectionColor(new java.awt.Color(0, 102, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ingrese su apellido:");

        lbPhone.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lbPhone.setSelectionColor(new java.awt.Color(0, 102, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Ingrese el telefono en la reservacion:");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGap(0, 41, Short.MAX_VALUE)
                .addComponent(textFieldAnimation, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(close1Button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(close1Button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(textFieldAnimation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(784, Short.MAX_VALUE)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(784, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(362, Short.MAX_VALUE)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(361, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void close1Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close1Button1ActionPerformed
        if (show) {
            alphaValue = 0.5f;
            show = false;
            alphaTimer.start();
        } else {
            JComponent comp = (JComponent) evt.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
        }
    }//GEN-LAST:event_close1Button1ActionPerformed

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));
        g2.setColor(new Color(50, 50, 50));
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (show) {
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
            close1Button1.doClick();
        }
    }

    public String getInputEmail() {
        return textFieldAnimation.getText().trim();
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
        messageDialog.pack();
        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Dimension screenSize = toolkit.getScreenSize();
        int x = (screenSize.width - ms.getWidth() + 120) / 2;
        int y = (screenSize.height - ms.getHeight()) / 2;
        messageDialog.setLocation(x, y);
        messageDialog.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.login.Close1Button close1Button1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private swing.login.MyTextField lbLastName;
    private swing.login.MyTextField lbPhone;
    private swing.login.PanelRound panelRound1;
    private swing.login.TextFieldAnimation textFieldAnimation;
    // End of variables declaration//GEN-END:variables
}
