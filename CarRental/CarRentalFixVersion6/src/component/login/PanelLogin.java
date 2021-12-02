package component.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

public class PanelLogin extends javax.swing.JPanel {

    public PanelLogin() {
        initComponents();
        txtPass.setEchoChar('\u2022');
        setOpaque(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new swing.login.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUser = new swing.login.TextField();
        txtPass = new swing.login.PasswordField();
        cmd = new swing.login.Button();
        cmdForgot = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        cmdRegister = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cmdGuest = new javax.swing.JButton();
        close2Button1 = new swing.login.Close2Button();
        minimizeButton = new swing.login.Close2Button();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setPreferredSize(new java.awt.Dimension(350, 500));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/login/logo.png"))); // NOI18N
        jLabel1.setText("RENCAR");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("BIENVENIDO A ");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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

        cmd.setBackground(new java.awt.Color(0, 102, 255));
        cmd.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        cmd.setForeground(new java.awt.Color(255, 255, 255));
        cmd.setText("Iniciar Sesion");
        cmd.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        cmd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmdMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cmdMouseExited(evt);
            }
        });

        cmdForgot.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cmdForgot.setForeground(new java.awt.Color(0, 102, 255));
        cmdForgot.setText("¿Olvidaste tu contraseña?");
        cmdForgot.setBorder(null);
        cmdForgot.setBorderPainted(false);
        cmdForgot.setContentAreaFilled(false);
        cmdForgot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmdForgotMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cmdForgotMouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("¿No tienes una cuenta?");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        cmdRegister.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cmdRegister.setForeground(new java.awt.Color(0, 102, 255));
        cmdRegister.setText("Registrate");
        cmdRegister.setBorder(null);
        cmdRegister.setBorderPainted(false);
        cmdRegister.setContentAreaFilled(false);
        cmdRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmdRegisterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cmdRegisterMouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("O");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        cmdGuest.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cmdGuest.setForeground(new java.awt.Color(0, 102, 255));
        cmdGuest.setText("Inicia sesion como invitado");
        cmdGuest.setBorder(null);
        cmdGuest.setBorderPainted(false);
        cmdGuest.setContentAreaFilled(false);
        cmdGuest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmdGuestMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cmdGuestMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdRegister))
                            .addComponent(jSeparator1)
                            .addComponent(txtUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmdForgot, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmdGuest, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(cmd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmdForgot)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmdRegister))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmdGuest)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 140, -1, -1));

        close2Button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/login/close.png"))); // NOI18N
        close2Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close2Button1ActionPerformed(evt);
            }
        });
        add(close2Button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 10, -1, -1));

        minimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/login/minimize.png"))); // NOI18N
        add(minimizeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 10, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/login/background.png"))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void cmdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdMouseEntered
        cmd.setBackground(new Color(0, 132, 255));
    }//GEN-LAST:event_cmdMouseEntered

    private void cmdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdMouseExited
        cmd.setBackground(new Color(0, 102, 255));
    }//GEN-LAST:event_cmdMouseExited

    private void cmdRegisterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdRegisterMouseEntered
        Font myFont = new Font("sansserif", Font.BOLD, 14);
        cmdRegister.setFont(myFont);
    }//GEN-LAST:event_cmdRegisterMouseEntered

    private void cmdRegisterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdRegisterMouseExited
        Font myFont = new Font("sansserif", Font.PLAIN, 14);
        cmdRegister.setFont(myFont);
    }//GEN-LAST:event_cmdRegisterMouseExited

    private void cmdForgotMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdForgotMouseEntered
        Font myFont = new Font("sansserif", Font.BOLD, 14);
        cmdForgot.setFont(myFont);
    }//GEN-LAST:event_cmdForgotMouseEntered

    private void cmdForgotMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdForgotMouseExited
        Font myFont = new Font("sansserif", Font.PLAIN, 14);
        cmdForgot.setFont(myFont);
    }//GEN-LAST:event_cmdForgotMouseExited

    private void txtPassKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyTyped
        char c = evt.getKeyChar();
        if (String.valueOf(txtPass.getPassword()).length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPassKeyTyped

    private void txtUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyTyped
        char c = evt.getKeyChar();
        if (txtUser.getText().length() >= 30) {
            evt.consume();
        }
    }//GEN-LAST:event_txtUserKeyTyped

    private void cmdGuestMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdGuestMouseEntered
        Font myFont = new Font("sansserif", Font.BOLD, 14);
        cmdGuest.setFont(myFont);
    }//GEN-LAST:event_cmdGuestMouseEntered

    private void cmdGuestMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdGuestMouseExited
        Font myFont = new Font("sansserif", Font.PLAIN, 14);
        cmdGuest.setFont(myFont);
    }//GEN-LAST:event_cmdGuestMouseExited

    private void close2Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close2Button1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_close2Button1ActionPerformed

    public void addEventLogin(ActionListener event) {
        cmd.addActionListener(event);
    }

    public void addEventForgot(ActionListener event) {
        cmdForgot.addActionListener(event);
    }

    public void addEventRegister(ActionListener event) {
        cmdRegister.addActionListener(event);
    }

    public void addEventGuest(ActionListener event) {
        cmdGuest.addActionListener(event);
    }

    public void addEventMinimize(ActionListener event) {
        minimizeButton.addActionListener(event);
    }
    
    public boolean checkUser() {
        return !(txtUser.getText().trim().equals("") || String.valueOf(txtPass.getPassword()).trim().equals(""));
    }

    public String getUserName() {
        return txtUser.getText().trim();
    }

    public String getPassword() {
        return String.valueOf(txtPass.getPassword());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.login.Close2Button close2Button1;
    private swing.login.Button cmd;
    private javax.swing.JButton cmdForgot;
    private javax.swing.JButton cmdGuest;
    private javax.swing.JButton cmdRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private swing.login.Close2Button minimizeButton;
    private swing.login.PanelRound panelRound1;
    private swing.login.PasswordField txtPass;
    private swing.login.TextField txtUser;
    // End of variables declaration//GEN-END:variables
}
