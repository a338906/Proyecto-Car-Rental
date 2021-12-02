package com.raven.component;

import com.raven.form.Form_Reservation1;
import com.raven.model.ModelCar;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;

public class Car extends javax.swing.JPanel {

    public String carSelected;

    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    private Color color1;
    private Color color2;

    public void addEventContinue(ActionListener event) {
        buttonCounter.addActionListener(event);
    }

    public Car() {
        initComponents();
        setOpaque(false);
        setColor1(new Color(255, 255, 255));
        setColor2(new Color(255, 255, 255));
    }

    public void setData(ModelCar data) {
        lbCar.setIcon(data.getCarIcon());
        lbName.setText(data.getName());
        lbTypeCar.setText(data.getTypeCar());
        lbSeat.setText(String.valueOf(data.getSeat()) + " Asientos");
        if (data.getSmall() > 1) {
            lbSmall.setText(String.valueOf(data.getSmall()) + " Maletas Pequeñas");
        } else {
            lbSmall.setText(String.valueOf(data.getSmall()) + " Maleta Pequeña");
        }
        if (data.getLarge() > 1) {
            lbLarge.setText(String.valueOf(data.getLarge()) + " Maletas Grandes");
        } else {
            lbLarge.setText(String.valueOf(data.getLarge()) + " Maleta Grande");
        }
        lbDoor.setText(String.valueOf(data.getDoor()) + " Puertas");
        lbGas.setText(String.valueOf(data.getGas()) + " KPL");
        lbType.setText(data.getType());

        lbSeat.setIcon(data.getSeatIcon());
        lbSmall.setIcon(data.getSmallIcon());
        lbDoor.setIcon(data.getDoorIcon());
        lbGas.setIcon(data.getGasIcon());
        lbLarge.setIcon(data.getLargeIcon());
        lbType.setIcon(data.getTypeIcon());

        lbPriceCounter.setText("$" + String.valueOf(data.getPriceCounter()) + "0");
        lbPriceNow.setText("$" + String.valueOf(data.getPriceNow()) + "0");
        txtDifference.setText("Paga ahora y ahorra $" + String.valueOf(data.getDifference()) + "0");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbCar = new javax.swing.JLabel();
        lbTypeCar = new javax.swing.JLabel();
        lbPriceCounter = new javax.swing.JLabel();
        lbPriceNow = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        panelRound11 = new swing.login.PanelRound1();
        lbDoor = new javax.swing.JLabel();
        lbSeat = new javax.swing.JLabel();
        lbType = new javax.swing.JLabel();
        lbGas = new javax.swing.JLabel();
        lbSmall = new javax.swing.JLabel();
        lbLarge = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDifference = new javax.swing.JLabel();
        buttonCounter = new swing.login.Button1();
        buttonNow = new swing.login.Button1();

        lbCar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/mazda_cx5.png"))); // NOI18N

        lbTypeCar.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbTypeCar.setForeground(new java.awt.Color(51, 51, 51));
        lbTypeCar.setText("Type of Car");

        lbPriceCounter.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceCounter.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceCounter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceCounter.setText("$ Values");

        lbPriceNow.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceNow.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceNow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceNow.setText("$ Values");

        lbName.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbName.setForeground(new java.awt.Color(51, 51, 51));
        lbName.setText("Name of car");

        lbDoor.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbDoor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbDoor.setText("1");

        lbSeat.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSeat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSeat.setText("1");

        lbType.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbType.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbType.setText("1");

        lbGas.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbGas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbGas.setText("1");

        lbSmall.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSmall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSmall.setText("1");

        lbLarge.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbLarge.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbLarge.setText("1");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Libre de humo");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Caracteristicas del Vehiculo");

        javax.swing.GroupLayout panelRound11Layout = new javax.swing.GroupLayout(panelRound11);
        panelRound11.setLayout(panelRound11Layout);
        panelRound11Layout.setHorizontalGroup(
            panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound11Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbSeat)
                            .addComponent(lbDoor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbGas)
                            .addComponent(lbType))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge)
                            .addComponent(lbSmall))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound11Layout.setVerticalGroup(
            panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound11Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSmall))
                    .addGroup(panelRound11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbType))
                    .addGroup(panelRound11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDoor))
                    .addGroup(panelRound11Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge)
                            .addComponent(lbGas)
                            .addComponent(lbSeat))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        txtDifference.setBackground(new java.awt.Color(51, 51, 51));
        txtDifference.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txtDifference.setForeground(new java.awt.Color(51, 51, 51));
        txtDifference.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDifference.setText("Paga ahora y ahorra $1");

        buttonCounter.setBackground(new java.awt.Color(255, 255, 255));
        buttonCounter.setText("PAGAR EN CAJA");
        buttonCounter.setColor2(new java.awt.Color(204, 204, 204));
        buttonCounter.setEffectColor(new java.awt.Color(0, 0, 0));
        buttonCounter.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonCounter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCounterActionPerformed(evt);
            }
        });

        buttonNow.setBackground(new java.awt.Color(0, 102, 255));
        buttonNow.setForeground(new java.awt.Color(255, 255, 255));
        buttonNow.setText("PAGAR YA");
        buttonNow.setColor1(new java.awt.Color(0, 102, 255));
        buttonNow.setColor2(new java.awt.Color(0, 102, 255));
        buttonNow.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonNow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTypeCar)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(lbCar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addComponent(panelRound11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCounter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceCounter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceNow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonNow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDifference, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbCar, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbPriceCounter)
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonCounter, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbPriceNow)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonNow, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panelRound11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(txtDifference))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lbName))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbTypeCar)))
                .addContainerGap())
        );

        buttonNow.getAccessibleContext().setAccessibleName("buttonNow");
    }// </editor-fold>//GEN-END:initComponents

    private void buttonNowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNowActionPerformed
        setCarName("");
        setColor1(new Color(255, 255, 255));
        setColor2(new Color(255, 255, 255));
    }//GEN-LAST:event_buttonNowActionPerformed

    private void buttonCounterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCounterActionPerformed
        setColor1(new Color(255, 255, 255));
        setColor2(new Color(255, 255, 255));
    }//GEN-LAST:event_buttonCounterActionPerformed
    
    public String getCarName() {
        return carSelected;
    }

    public void setCarName(String carSelected) {
        this.carSelected = carSelected;
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.setColor(new Color(255, 255, 255, 50));
        g2.fillOval(getWidth() - (getHeight() / 2), 10, getHeight(), getHeight());
        g2.fillOval(getWidth() - (getHeight() / 2) - 20, getHeight() / 2 + 20, getHeight(), getHeight());
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.login.Button1 buttonCounter;
    private swing.login.Button1 buttonNow;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbCar;
    private javax.swing.JLabel lbDoor;
    private javax.swing.JLabel lbGas;
    private javax.swing.JLabel lbLarge;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbPriceCounter;
    private javax.swing.JLabel lbPriceNow;
    private javax.swing.JLabel lbSeat;
    private javax.swing.JLabel lbSmall;
    private javax.swing.JLabel lbType;
    private javax.swing.JLabel lbTypeCar;
    private swing.login.PanelRound1 panelRound11;
    private javax.swing.JLabel txtDifference;
    // End of variables declaration//GEN-END:variables
}
