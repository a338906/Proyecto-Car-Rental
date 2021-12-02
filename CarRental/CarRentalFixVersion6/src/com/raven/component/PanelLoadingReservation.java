package com.raven.component;

import model.login.ModelUser;
import connection.DatabaseConnection;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.geom.Path2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileFilter;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class PanelLoadingReservation extends javax.swing.JLayeredPane {

    public ModelUser getData() {
        return data;
    }

    private final Animator animator;
    private boolean slideLeft;
    private float animate;
    private boolean isMessage;
    private ModelUser data;

    public PanelLoadingReservation() {
        initComponents();
        loading.setVisible(true);
        profile.setVisible(false);
        message.setVisible(false);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void begin() {
                if (isMessage) {
                    message.setVisible(true);
                } else {
                    profile.setVisible(true);
                }
            }

            @Override
            public void timingEvent(float fraction) {
                if (isMessage) {
                    message.setAlpha(fraction);
                    loading.setAlpha(1f - fraction);
                } else {
                    profile.setAlpha(fraction);
                    loading.setAlpha(1f - fraction);
                }
                repaint();
            }
        };
        animator = new Animator(500, target);
        animator.setResolution(0);
    }

    public void setAnimate(boolean slideLeft, float animate) {
        this.slideLeft = slideLeft;
        this.animate = animate;
    }

    public void addEventBack(ActionListener event) {
        cmdCancel2.addActionListener(event);
    }

    public void addEventContinue(ActionListener event) {
        cmdContinue.addActionListener(event);
    }

    public void doneLogin(ModelUser data) {
        isMessage = false;
        this.data = data;
        pic.setIcon(data.getProfile());
        cmdContinue.setText("Continuar como " + data.getUserName());
        animator.start();
    }

    public void showError(String ms) {
        lbMessage.setText(ms);
        isMessage = true;
        animator.start();
    }

    public void reset() {
        loading.setAlpha(1f);
        loading.setVisible(true);
        profile.setVisible(false);
        message.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profile = new swing.login.PanelTransparent();
        cmdCancel1 = new swing.login.Button();
        pic = new swing.login.ImageAvatar();
        cmdEdit = new swing.login.CloseButton();
        cmdContinue = new swing.login.Button();
        loading = new swing.login.PanelTransparent();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        message = new swing.login.PanelTransparent();
        cmdCancel2 = new swing.login.Button();
        lbMessage = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        cmdCancel1.setBackground(new java.awt.Color(32, 34, 47));
        cmdCancel1.setForeground(new java.awt.Color(255, 255, 255));
        cmdCancel1.setText("Cerrar Sesion");
        cmdCancel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        cmdCancel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmdCancel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cmdCancel1MouseExited(evt);
            }
        });

        pic.setBackground(new java.awt.Color(52, 54, 67));
        pic.setForeground(new java.awt.Color(52, 54, 67));
        pic.setBorderSize(3);
        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/login/user.png"))); // NOI18N
        pic.setOpaque(true);

        cmdEdit.setBackground(new java.awt.Color(52, 54, 67));
        cmdEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/login/edit.png"))); // NOI18N
        cmdEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmdEditMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cmdEditMouseExited(evt);
            }
        });
        cmdEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout picLayout = new javax.swing.GroupLayout(pic);
        pic.setLayout(picLayout);
        picLayout.setHorizontalGroup(
            picLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, picLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmdEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        picLayout.setVerticalGroup(
            picLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, picLayout.createSequentialGroup()
                .addGap(0, 106, Short.MAX_VALUE)
                .addComponent(cmdEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        cmdContinue.setBackground(new java.awt.Color(52, 54, 67));
        cmdContinue.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        cmdContinue.setForeground(new java.awt.Color(255, 255, 255));
        cmdContinue.setText("Continuar");
        cmdContinue.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        cmdContinue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmdContinueMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cmdContinueMouseExited(evt);
            }
        });

        javax.swing.GroupLayout profileLayout = new javax.swing.GroupLayout(profile);
        profile.setLayout(profileLayout);
        profileLayout.setHorizontalGroup(
            profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileLayout.createSequentialGroup()
                .addContainerGap(126, Short.MAX_VALUE)
                .addComponent(cmdCancel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 124, Short.MAX_VALUE))
            .addGroup(profileLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdContinue, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        profileLayout.setVerticalGroup(
            profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profileLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(cmdContinue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(cmdCancel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        add(profile, "card2");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/login/loading.gif"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/login/loading3.gif"))); // NOI18N

        javax.swing.GroupLayout loadingLayout = new javax.swing.GroupLayout(loading);
        loading.setLayout(loadingLayout);
        loadingLayout.setHorizontalGroup(
            loadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadingLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(loadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        loadingLayout.setVerticalGroup(
            loadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loadingLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(131, 131, 131)
                .addComponent(jLabel2)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        add(loading, "card2");

        cmdCancel2.setBackground(new java.awt.Color(32, 34, 47));
        cmdCancel2.setForeground(new java.awt.Color(255, 255, 255));
        cmdCancel2.setText("Reintentar");
        cmdCancel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        cmdCancel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmdCancel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cmdCancel2MouseExited(evt);
            }
        });

        lbMessage.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbMessage.setForeground(new java.awt.Color(204, 0, 0));
        lbMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMessage.setText("Message");

        javax.swing.GroupLayout messageLayout = new javax.swing.GroupLayout(message);
        message.setLayout(messageLayout);
        messageLayout.setHorizontalGroup(
            messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, messageLayout.createSequentialGroup()
                .addContainerGap(125, Short.MAX_VALUE)
                .addComponent(cmdCancel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
            .addGroup(messageLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        messageLayout.setVerticalGroup(
            messageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, messageLayout.createSequentialGroup()
                .addContainerGap(151, Short.MAX_VALUE)
                .addComponent(lbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addComponent(cmdCancel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        add(message, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void cmdEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEditActionPerformed
        JFileChooser ch = new JFileChooser();
        ch.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File file) {
                String name = file.getName().toLowerCase();
                return file.isDirectory() || name.endsWith(".png") || name.endsWith(".jpg");
            }

            @Override
            public String getDescription() {
                return "Image File";
            }
        });
        int option = ch.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = ch.getSelectedFile();
            ImageIcon icon = new ImageIcon(file.getAbsolutePath());
            pic.setIcon(icon);
            repaint();
            try {
                String sql = "UPDATE USUARIO SET Profile=? WHERE UserID=?";
                PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
                FileInputStream fin = new FileInputStream(file.getAbsolutePath());
                p.setBlob(1, fin);
                p.setInt(2, data.getUserID());
                p.executeUpdate();
                data.setProfile(icon);
            } catch (IOException | SQLException e) {
                System.err.println(e);
            }
        }
    }//GEN-LAST:event_cmdEditActionPerformed

    private void cmdCancel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdCancel1MouseEntered
        cmdCancel1.setBackground(new Color(52, 54, 67));
    }//GEN-LAST:event_cmdCancel1MouseEntered

    private void cmdCancel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdCancel1MouseExited
        cmdCancel1.setBackground(new Color(32, 34, 47));
    }//GEN-LAST:event_cmdCancel1MouseExited

    private void cmdContinueMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdContinueMouseEntered
        cmdContinue.setBackground(new Color(70, 70, 84));
    }//GEN-LAST:event_cmdContinueMouseEntered

    private void cmdContinueMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdContinueMouseExited
        cmdContinue.setBackground(new Color(52, 54, 67));
    }//GEN-LAST:event_cmdContinueMouseExited

    private void cmdEditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdEditMouseEntered
        cmdEdit.setBackground(new Color(70, 70, 84));
    }//GEN-LAST:event_cmdEditMouseEntered

    private void cmdEditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdEditMouseExited
        cmdEdit.setBackground(new Color(52, 54, 67));
    }//GEN-LAST:event_cmdEditMouseExited

    private void cmdCancel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdCancel2MouseExited
        cmdCancel2.setBackground(new Color(32, 34, 47));
    }//GEN-LAST:event_cmdCancel2MouseExited

    private void cmdCancel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdCancel2MouseEntered
        cmdCancel2.setBackground(new Color(52, 54, 67));
    }//GEN-LAST:event_cmdCancel2MouseEntered

    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        int width = getWidth();
        int height = getHeight();
        int x = 0;
        int y = 0;
        if (slideLeft) {
            int centerY = height / 2;
            Path2D.Float p = new Path2D.Float();
            p.moveTo(x, y);
            p.lineTo(width, y);
            p.lineTo(width, height);
            p.lineTo(x, height);
            p.curveTo(x, height, easeOutBounce(animate) * width, centerY, x, y);
            g2.fill(p);
        } else {
            g2.fillRect(x, y, width, height);
        }
        g2.dispose();
        super.paint(grphcs);
    }

    private float easeOutBounce(float x) {
        float n1 = 7.5625f;
        float d1 = 2.75f;
        double v;
        if (x < 1 / d1) {
            v = n1 * x * x;
        } else if (x < 2 / d1) {
            v = n1 * (x -= 1.5 / d1) * x + 0.75;
        } else if (x < 2.5 / d1) {
            v = n1 * (x -= 2.25 / d1) * x + 0.9375;
        } else {
            v = n1 * (x -= 2.625 / d1) * x + 0.984375;
        }
        if (slideLeft) {
            return (float) (1f - v);
        } else {
            return (float) v;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.login.Button cmdCancel1;
    private swing.login.Button cmdCancel2;
    private swing.login.Button cmdContinue;
    private swing.login.CloseButton cmdEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbMessage;
    private swing.login.PanelTransparent loading;
    private swing.login.PanelTransparent message;
    private swing.login.ImageAvatar pic;
    private swing.login.PanelTransparent profile;
    // End of variables declaration//GEN-END:variables
}
