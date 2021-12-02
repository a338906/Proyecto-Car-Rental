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
public class Background1 extends JPanel {

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final Image img;

    public Background1() {
        img = new ImageIcon("C:\\Users\\NekoG\\Desktop\\JAVA\\icon\\24px\\car\\home.jpg").getImage();
    }

    public void paintComponent(Graphics grphcs) {
        grphcs.drawImage(img, 0, 0, null);
    }
}
