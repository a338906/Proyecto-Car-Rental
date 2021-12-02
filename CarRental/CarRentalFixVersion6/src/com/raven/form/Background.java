package com.raven.form;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author NekoG
 */
public class Background extends JPanel {

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final Image img;

    public Background() {
        img = new ImageIcon("C:\\Users\\NekoG\\Desktop\\JAVA\\icon\\24px\\car\\road-wallpaper.jpg").getImage();
    }

    public void paintComponent(Graphics grphcs) {
        grphcs.drawImage(img, -1800, -1000, null);
    }
}
