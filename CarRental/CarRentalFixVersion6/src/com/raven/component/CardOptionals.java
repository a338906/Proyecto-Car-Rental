package com.raven.component;

import com.raven.model.ModelCard;
import com.raven.model.ModelOptionals;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class CardOptionals extends javax.swing.JPanel {

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

    public CardOptionals() {
        initComponents();
        setOpaque(false);
        setColor1(new Color(255, 255, 255));
        setColor2(new Color(255, 255, 255));
        jScrollPane1.setBackground(new Color(245, 245, 245));
        com.raven.swing.scrollbar.ScrollBarCustom sb = new com.raven.swing.scrollbar.ScrollBarCustom();
        sb.setUnitIncrement(50);
        sb.setForeground(new Color(0, 102, 255));
        sb.setBackground(new Color(200, 200, 200));
        jScrollPane1.setBorder(null);
    }

    public void setData(ModelOptionals data) {
        lbTitle.setText(data.getTitle());
        lbDescription.setText(data.getDescription());
        lbIcon.setIcon(data.getIcon());
        add.setText("AGREGAR POR $" + data.getCost() + " CADA DIA");
    }

    public void addEventSelect(ActionListener event) {
        add.addActionListener(event);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitle = new javax.swing.JLabel();
        lbIcon = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lbDescription = new javax.swing.JTextArea();
        add = new swing.login.Button1();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        lbTitle.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Title");

        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/optionals/additional.png"))); // NOI18N

        lbDescription.setEditable(false);
        lbDescription.setColumns(13);
        lbDescription.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lbDescription.setLineWrap(true);
        lbDescription.setRows(5);
        lbDescription.setText("Asegure el vehículo y evite pagar por daños que le ocurran a nuestro vehículo sin ningún costo adicional suyo además de no aumentar su póliza de seguro debido a un accidente.");
        lbDescription.setWrapStyleWord(true);
        lbDescription.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        lbDescription.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(lbDescription);

        add.setBackground(new java.awt.Color(0, 102, 255));
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("Value, boton");
        add.setColor1(new java.awt.Color(0, 102, 255));
        add.setColor2(new java.awt.Color(0, 102, 255));
        add.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
            .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gra = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
        g2.setPaint(gra);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.login.Button1 add;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea lbDescription;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbTitle;
    // End of variables declaration//GEN-END:variables
}
