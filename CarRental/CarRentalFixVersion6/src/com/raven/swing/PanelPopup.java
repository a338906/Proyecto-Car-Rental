package com.raven.swing;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class PanelPopup extends JPanel {

    public PanelPopup() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#3242B6"), 0, 100, Color.decode("#157FDE"));
        g2.setPaint(g);
        g2.fillRect(8, 0, getSize().width - 8, getSize().height);
        int x[] = {0, 10, 10};
        int y[] = {53, 46, 60};
        g2.fillPolygon(x, y, x.length);
        super.paintComponent(grphcs);
    }
}
