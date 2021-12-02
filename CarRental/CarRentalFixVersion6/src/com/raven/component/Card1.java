package com.raven.component;

import com.raven.model.Model_Card;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.Icon;

public class Card1 extends javax.swing.JPanel {

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

    public Card1() {
        initComponents();
        setOpaque(false);
        color1 = Color.BLACK;
        color2 = Color.WHITE;
    }

    public void setData(Model_Card data) {
        lbIcon.setIcon(data.getIcon());
        lbName.setText(data.getTitle());
        lbValues.setText(data.getValues());
        lbMonth.setText(data.getDescription());
    }
    
    public void setIcon(Icon icon) {
        lbIcon.setIcon(icon);
    }
    
    public void setCard(String name) {
        lbValues.setText(name);
    }
    
    public void setName(String name) {
        lbName.setText(name);
    }
    
    public void setLastName(String lastName) {
        lbLast.setText(lastName);
    }

    public void setMonth(String month) {
        lbMonth.setText(month);
    }
    
    public void setYear(String year) {
        lbYear.setText(year);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbIcon = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        lbValues = new javax.swing.JLabel();
        lbMonth = new javax.swing.JLabel();
        lbValues1 = new javax.swing.JLabel();
        lbDate1 = new javax.swing.JLabel();
        lbYear = new javax.swing.JLabel();
        lbMonth1 = new javax.swing.JLabel();
        lbLast = new javax.swing.JLabel();

        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/default.png"))); // NOI18N

        lbName.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lbName.setForeground(new java.awt.Color(255, 255, 255));
        lbName.setText("Nombre");

        lbValues.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbValues.setForeground(new java.awt.Color(255, 255, 255));
        lbValues.setText("____");

        lbMonth.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbMonth.setForeground(new java.awt.Color(255, 255, 255));
        lbMonth.setText("##");

        lbValues1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbValues1.setForeground(new java.awt.Color(255, 255, 255));
        lbValues1.setText("**** **** ****");

        lbDate1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbDate1.setForeground(new java.awt.Color(255, 255, 255));
        lbDate1.setText("Exp");

        lbYear.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbYear.setForeground(new java.awt.Color(255, 255, 255));
        lbYear.setText("##");

        lbMonth1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbMonth1.setForeground(new java.awt.Color(255, 255, 255));
        lbMonth1.setText("/");

        lbLast.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lbLast.setForeground(new java.awt.Color(255, 255, 255));
        lbLast.setText("Apellido");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbValues1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbValues))
                    .addComponent(lbIcon)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbLast))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbDate1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbMonth)
                        .addGap(6, 6, 6)
                        .addComponent(lbMonth1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbYear)))
                .addContainerGap(208, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbValues)
                    .addComponent(lbValues1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbName)
                    .addComponent(lbLast))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMonth)
                    .addComponent(lbDate1)
                    .addComponent(lbYear)
                    .addComponent(lbMonth1))
                .addContainerGap(28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JLabel lbDate1;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbLast;
    private javax.swing.JLabel lbMonth;
    private javax.swing.JLabel lbMonth1;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbValues;
    private javax.swing.JLabel lbValues1;
    private javax.swing.JLabel lbYear;
    // End of variables declaration//GEN-END:variables
}
