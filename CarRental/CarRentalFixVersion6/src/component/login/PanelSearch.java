package component.login;

import main.Login;
import model.login.ModelMessage;
import swing.login.EventTextField;
import connection.DatabaseConnection;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;
import service.login.ServiceUser;
import swing.login.EventCallBack;
import swing.login.EventTextField;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Random;
import javax.swing.Timer;
import service.login.ServiceMail;

public class PanelSearch extends javax.swing.JPanel implements ActionListener {

    Timer alphaTimer = new Timer(20, this);
    float alphaValue = 0f;
    private boolean show = true;

    private ServiceUser serviceUser;

    public PanelSearch() {
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
                        int id = findEmail(email);
                        if (id != 0) {
                            String code = generateVerifyCode();
                            ModelMessage ms = new ServiceMail().sendMain(email, code);
                            String sql2 = "UPDATE USUARIO SET VerifyCode=? WHERE UserID=?";
                            PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql2);
                            p.setString(1, code);
                            p.setInt(2, id);
                            p.executeUpdate();
                            p.close();
                            call.done();

                            show = false;
                            close1Button1.doClick();

                            JDialog verifyCode = new JDialog();
                            verifyCode.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                            PanelVerifyCode1 vc = new PanelVerifyCode1();
                            vc.setUserID(id);
                            verifyCode.add(vc);
                            verifyCode.getRootPane().setOpaque(false);
                            verifyCode.setUndecorated(true);
                            verifyCode.setBackground(new Color(0, 0, 0, 0));
                            verifyCode.pack();
                            verifyCode.setLocationRelativeTo(null);
                            verifyCode.setVisible(true);
                        } else {
                            showMessage(Message.MessageType.ERROR, "No hay ninguna cuenta asociada a este correo. ");
                            call.done();
                        }
                    } catch (Exception e) {
                        showMessage(Message.MessageType.ERROR, "Error con la base de datos.");
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

    int findEmail(String email) throws InterruptedException, SQLException, FileNotFoundException {
        int id = 0;
        String sql = "Select UserID from USUARIO where Email=?";
        PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
        p.setString(1, email);
        ResultSet r = p.executeQuery();
        if (r.next()) {
            id = r.getInt("UserID");
        }
        r.close();
        p.close();
        return id;
    }

    private String generateVerifyCode() throws SQLException {
        DecimalFormat df = new DecimalFormat("000000");
        Random ran = new Random();
        String code = df.format(ran.nextInt(1000000));
        while (checkDuplicateCode(code)) {
            code = df.format(ran.nextInt(1000000));
        }
        return code;
    }

    private boolean checkDuplicateCode(String code) throws SQLException {
        boolean duplicate = false;
        PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement("SELECT UserID FROM USUARIO WHERE VerifyCode=?");
        p.setString(1, code);
        ResultSet r = p.executeQuery();
        if (r.next()) {
            duplicate = true;
        }
        r.close();
        p.close();
        return duplicate;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new swing.login.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textFieldAnimation = new swing.login.TextFieldAnimation();
        close1Button1 = new swing.login.Close1Button();

        setOpaque(false);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(63, 63, 63));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("OLVIDE MI CONTRASEÑA");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ingrese su correo electronico:");

        textFieldAnimation.setBackground(new java.awt.Color(235, 235, 235));
        textFieldAnimation.setAnimationColor(new java.awt.Color(0, 102, 255));
        textFieldAnimation.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        textFieldAnimation.setSelectionColor(new java.awt.Color(0, 102, 255));

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
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(close1Button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(textFieldAnimation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(424, Short.MAX_VALUE)
                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(424, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(306, Short.MAX_VALUE)
                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(306, Short.MAX_VALUE))
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
    private swing.login.PanelRound panelRound1;
    private swing.login.TextFieldAnimation textFieldAnimation;
    // End of variables declaration//GEN-END:variables
}
