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
import java.sql.SQLException;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import service.login.ServiceUser;
import verify.login.EncryptDecrypt;
import verify.login.InvalidPasswordException;
import verify.login.PasswordValidator;

public class PanelNewPassword extends javax.swing.JPanel implements ActionListener {

    private ServiceUser serviceUser;
    boolean show = false;
    Timer alphaTimer = new Timer(20, this);
    float alphaValue = 0f;
    private boolean exit = false;
    private boolean show1 = true;

    public PanelNewPassword() {
        initComponents();
        serviceUser = new ServiceUser();
        setOpaque(false);
        txtPass.setEchoChar('\u2022');
        txtPass1.setEchoChar('\u2022');
        alphaTimer.start();
    }

    private String passwordVerify(String password, ActionEvent evt) {
        try {
            PasswordValidator.isValid(password);
            return null;
        } catch (InvalidPasswordException e) {
            e.getMessage();
            showMessage(Message.MessageType.ERROR, e.printMessage(),evt);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new swing.login.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPass = new swing.login.PasswordField();
        txtPass1 = new swing.login.PasswordField();
        showButton = new swing.login.Close1Button();
        showButton1 = new swing.login.Close1Button();
        cmd = new swing.login.Button();
        close1Button1 = new swing.login.Close1Button();

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(63, 63, 63));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("OLVIDE MI CONTRASEÑA");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ingrese su correo electronico:");

        txtPass.setLabelText("Contraseña");
        txtPass.setLineColor(new java.awt.Color(0, 102, 255));
        txtPass.setSelectionColor(new java.awt.Color(0, 102, 255));
        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPassKeyTyped(evt);
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

        showButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/login/show.png"))); // NOI18N
        showButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButtonActionPerformed(evt);
            }
        });

        showButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/login/show.png"))); // NOI18N
        showButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButton1ActionPerformed(evt);
            }
        });

        cmd.setBackground(new java.awt.Color(0, 102, 255));
        cmd.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        cmd.setForeground(new java.awt.Color(255, 255, 255));
        cmd.setText("Modificar Contraseña");
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

        close1Button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/login/close.png"))); // NOI18N
        close1Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close1Button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cmd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                        .addComponent(txtPass1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtPass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(showButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(showButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(close1Button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(close1Button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(showButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(cmd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(395, Short.MAX_VALUE)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(395, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(243, Short.MAX_VALUE)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(242, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtPass1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPass1KeyTyped
        char c = evt.getKeyChar();
        if (String.valueOf(txtPass1.getPassword()).length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPass1KeyTyped

    private void txtPassKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyTyped
        char c = evt.getKeyChar();
        if (String.valueOf(txtPass.getPassword()).length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPassKeyTyped

    private void cmdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdMouseEntered
        cmd.setBackground(new Color(0, 132, 255));
    }//GEN-LAST:event_cmdMouseEntered

    private void cmdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdMouseExited
        cmd.setBackground(new Color(0, 102, 255));
    }//GEN-LAST:event_cmdMouseExited

    private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButtonActionPerformed
        if (show == false) {
            txtPass.setEchoChar((char) 0);
            showButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/login/show.png")));
            show = true;
        } else {
            showButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/login/hide.png")));
            txtPass.setEchoChar('\u2022');
            show = false;
        }
    }//GEN-LAST:event_showButtonActionPerformed

    private void showButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButton1ActionPerformed
        if (show == false) {
            txtPass1.setEchoChar((char) 0);
            showButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/login/show.png")));
            show = true;
        } else {
            showButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/login/hide.png")));
            txtPass1.setEchoChar('\u2022');
            show = false;
        }
    }//GEN-LAST:event_showButton1ActionPerformed

    private void cmdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdActionPerformed
        if (!getPassword().equals("") || !getPassword1().equals("")) {
            String pass = passwordVerify(getPassword(),evt);

            if (getPassword().equals(getPassword1())) {
                if (pass == null) {
                    try {
                        String sql = "UPDATE USUARIO SET Pass=? WHERE UserID=?";
                        PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
                        String passwordEncrypted = EncryptDecrypt.encrpytString(getPassword());
                        p.setString(1, passwordEncrypted);
                        p.setInt(2, getUserID());
                        p.executeUpdate();
                        p.close();
                        exit = true;
                        close1Button1.doClick();
                        showMessage(Message.MessageType.SUCCESS, "Contraseña actualizada con exito.",evt);
                    } catch (Exception e) {
                        showMessage(Message.MessageType.ERROR, "Error con la base de datos.",evt);
                    }
                }
            } else {
                showMessage(Message.MessageType.ERROR, "Las contraseñas no coinciden.",evt);
            }
        } else {
            showMessage(Message.MessageType.ERROR, "Campos vacios.",evt);
        }
    }//GEN-LAST:event_cmdActionPerformed

    private void close1Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close1Button1ActionPerformed
        if (show1) {
            alphaValue = 0.5f;
            show1 = false;
            alphaTimer.start();
        } else {
            JComponent comp = (JComponent) evt.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            if (!exit) {
                try {
                    serviceUser.doneVerify(getUserID());
                } catch (SQLException ex) {
                }
                showMessage(Message.MessageType.COMMENT, "Cambio de contraseña cancelado.",evt);
                win.dispose();
            } else {
                win.dispose();
            }
        }
    }//GEN-LAST:event_close1Button1ActionPerformed

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setColor(new Color(50, 50, 50));
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(grphcs);
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
            close1Button1.doClick();
        }
    }

    public String getPassword() {
        return String.valueOf(txtPass.getPassword());
    }

    public String getPassword1() {
        return String.valueOf(txtPass1.getPassword());
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    private int userID;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.login.Close1Button close1Button1;
    private swing.login.Button cmd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private swing.login.PanelRound panelRound1;
    private swing.login.Close1Button showButton;
    private swing.login.Close1Button showButton1;
    private swing.login.PasswordField txtPass;
    private swing.login.PasswordField txtPass1;
    // End of variables declaration//GEN-END:variables
}
