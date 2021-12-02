package component.login;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import service.login.ServiceUser;

public class PanelVerifyCode extends javax.swing.JPanel implements ActionListener {

    private ServiceUser serviceUser;
    Timer alphaTimer = new Timer(20, this);
    float alphaValue = 0f;
    private boolean show = true;
    private int close = 0;

    public PanelVerifyCode() {
        initComponents();
        serviceUser = new ServiceUser();
        initComponents();
        setOpaque(false);
        setVisible(show);
        alphaTimer.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new swing.login.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCode = new swing.login.MyTextField();
        ButtonOK = new swing.login.CloseButton();
        ButtonCancel = new swing.login.CloseButton();

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(63, 63, 63));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CODIGO DE VERIFICACION");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Entre a su correo para verificar el codigo.");

        txtCode.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        ButtonOK.setBackground(new java.awt.Color(0, 153, 0));
        ButtonOK.setForeground(new java.awt.Color(255, 255, 255));
        ButtonOK.setText("Verificar");
        ButtonOK.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ButtonOK.setPreferredSize(new java.awt.Dimension(71, 25));
        ButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonOKActionPerformed(evt);
            }
        });

        ButtonCancel.setBackground(new java.awt.Color(0, 102, 255));
        ButtonCancel.setForeground(new java.awt.Color(255, 255, 255));
        ButtonCancel.setText("Despues");
        ButtonCancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ButtonCancel.setPreferredSize(new java.awt.Dimension(71, 25));
        ButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(ButtonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(ButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(74, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonOK, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(400, Short.MAX_VALUE)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(400, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(293, Short.MAX_VALUE)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(292, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelActionPerformed
        if (show) {
            alphaValue = 0.5f;
            show = false;
            alphaTimer.start();
            close = 1;
        } else {
            JComponent comp = (JComponent) evt.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
        }
    }//GEN-LAST:event_ButtonCancelActionPerformed

    private void ButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonOKActionPerformed
        if (show) {
            alphaValue = 0.5f;
            show = false;
            alphaTimer.start();
            close = 2;
        } else {
            int id = getUserID();
            try {
                if (serviceUser.verifyCodeWithUser(id, getInputCode())) {
                    serviceUser.doneVerify(id);
                    JComponent comp = (JComponent) evt.getSource();
                    Window win = SwingUtilities.getWindowAncestor(comp);
                    win.dispose();
                    showMessage(Message.MessageType.SUCCESS, "Verificacion y registro completado.", evt);
                } else {
                    showMessage(Message.MessageType.ERROR, "Codigo de verificacion incorrecto.", evt);
                }
            } catch (SQLException e) {
                showMessage(Message.MessageType.ERROR, "Error", evt);
            }
        }
    }//GEN-LAST:event_ButtonOKActionPerformed

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));
        g2.setColor(new Color(50, 50, 50));
        g2.fillRect(0, 0, getWidth(), getHeight());
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
            if (close == 1) {
                ButtonCancel.doClick();
            } else {
                ButtonOK.doClick();
            }
        }
    }

    public String getInputCode() {
        return txtCode.getText().trim();
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    private int userID;

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.login.CloseButton ButtonCancel;
    private swing.login.CloseButton ButtonOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private swing.login.PanelRound panelRound1;
    private swing.login.MyTextField txtCode;
    // End of variables declaration//GEN-END:variables
}
