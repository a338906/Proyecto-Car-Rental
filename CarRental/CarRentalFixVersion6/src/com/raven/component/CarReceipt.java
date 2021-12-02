package com.raven.component;

import com.raven.form.Form_Reservation1;
import com.raven.model.ModelCar;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;

public class CarReceipt extends javax.swing.JPanel {

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
    
    public CarReceipt() {
        initComponents();
        setOpaque(false);
        setColor1(new Color(255, 255, 255));
        setColor2(new Color(255, 255, 255));
    }

    public void setData(ModelCar data) {
        lbCar.setIcon(data.getCarIcon());
        lbName.setText(data.getName());
        lbTypeCar.setText(data.getTypeCar());
        lbSeat.setText(String.valueOf(data.getSeat()));
        if (data.getSmall() > 1) {
            lbSmall.setText(String.valueOf(data.getSmall()));
        } else {
            lbSmall.setText(String.valueOf(data.getSmall()));
        }
        if (data.getLarge() > 1) {
            lbLarge.setText(String.valueOf(data.getLarge()));
        } else {
            lbLarge.setText(String.valueOf(data.getLarge()));
        }
        lbDoor.setText(String.valueOf(data.getDoor()));
        lbGas.setText(String.valueOf(data.getGas()));
        lbType.setText(data.getType());

        lbSeat.setIcon(data.getSeatIcon());
        lbSmall.setIcon(data.getSmallIcon());
        lbDoor.setIcon(data.getDoorIcon());
        lbGas.setIcon(data.getGasIcon());
        lbLarge.setIcon(data.getLargeIcon());
        lbType.setIcon(data.getTypeIcon());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbCar = new javax.swing.JLabel();
        panelRound11 = new swing.login.PanelRound1();
        lbDoor = new javax.swing.JLabel();
        lbSeat = new javax.swing.JLabel();
        lbType = new javax.swing.JLabel();
        lbGas = new javax.swing.JLabel();
        lbSmall = new javax.swing.JLabel();
        lbLarge = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        lbTypeCar = new javax.swing.JLabel();

        lbCar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/mazda_cx5.png"))); // NOI18N

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

        lbName.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        lbName.setForeground(new java.awt.Color(51, 51, 51));
        lbName.setText("Name of car");

        lbTypeCar.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lbTypeCar.setForeground(new java.awt.Color(51, 51, 51));
        lbTypeCar.setText("Type of Car");

        javax.swing.GroupLayout panelRound11Layout = new javax.swing.GroupLayout(panelRound11);
        panelRound11.setLayout(panelRound11Layout);
        panelRound11Layout.setHorizontalGroup(
            panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound11Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(lbDoor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbType)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbSmall)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbSeat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbGas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbLarge)
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(panelRound11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbName, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(lbTypeCar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound11Layout.setVerticalGroup(
            panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound11Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lbName))
                    .addComponent(lbTypeCar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbType)
                    .addComponent(lbDoor)
                    .addComponent(lbLarge)
                    .addComponent(lbGas)
                    .addComponent(lbSeat)
                    .addComponent(lbSmall))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(lbCar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelRound11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(lbCar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
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
    private javax.swing.JLabel lbCar;
    private javax.swing.JLabel lbDoor;
    private javax.swing.JLabel lbGas;
    private javax.swing.JLabel lbLarge;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbSeat;
    private javax.swing.JLabel lbSmall;
    private javax.swing.JLabel lbType;
    private javax.swing.JLabel lbTypeCar;
    private swing.login.PanelRound1 panelRound11;
    // End of variables declaration//GEN-END:variables
}
