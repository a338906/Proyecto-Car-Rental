package main;

import com.raven.component.Header;
import com.raven.component.Menu;
import com.raven.component.PanelCancelReservation;
import com.raven.component.PanelSearchReservation;
import com.raven.component.PanelSearchReservation1;
import com.raven.component.PanelSlideReservation;
import com.raven.event.EventMenuSelected;
import com.raven.event.EventShowPopupMenu;
import com.raven.form.Form1;
import com.raven.form.Form_Home;
import com.raven.form.Form_ReservationMain;
import com.raven.form.MainForm;
import com.raven.swing.MenuItem;
import com.raven.swing.PopupMenu;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import component.login.PanelClose;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Main extends javax.swing.JFrame {

    private MigLayout layout;
    private Menu menu;
    private Header header;
    private MainForm main;
    private Animator animator;
    public int UserID;

    public Main(int UserID) {
        initComponents();
        setUserID(UserID);
        init();
    }

    private void init() {
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(layout);
        menu = new Menu();
        header = new Header(getUserID());
        main = new MainForm();
        menu.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int menuIndex, int subMenuIndex) {
                System.out.println("Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
                if (menuIndex == 0) {
                    main.showForm(new Form_Home());
                }
                if (menuIndex == 1) {
                    main.showForm(new Form_ReservationMain(getUserID()));
                }
                if (menuIndex == 2) {
                    if (subMenuIndex == 0) {
                        main.showForm(new Form1());
                    } else if (subMenuIndex == 1) {
                        PanelCancelReservation cr = new PanelCancelReservation();
                        JDialog cancelDialog = new JDialog();
                        cancelDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                        cancelDialog.add(cr);
                        cancelDialog.getRootPane().setOpaque(false);
                        cancelDialog.setUndecorated(true);
                        cancelDialog.setBackground(new Color(0, 0, 0, 0));
                        cancelDialog.pack();
                        cancelDialog.setLocationRelativeTo(rootPane);
                        cancelDialog.setVisible(true);
                    }
                }
                if (menuIndex == 3) {
                    if (subMenuIndex == 0) {
                        PanelSearchReservation sr = new PanelSearchReservation();
                        JDialog codeDialog = new JDialog();
                        codeDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                        codeDialog.add(sr);
                        codeDialog.getRootPane().setOpaque(false);
                        codeDialog.setUndecorated(true);
                        codeDialog.setBackground(new Color(0, 0, 0, 0));
                        codeDialog.pack();
                        codeDialog.setLocationRelativeTo(rootPane);
                        codeDialog.setVisible(true);
                    } else if (subMenuIndex == 1) {
                        PanelSearchReservation1 sr1 = new PanelSearchReservation1();
                        JDialog codeDialog = new JDialog();
                        codeDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                        codeDialog.add(sr1);
                        codeDialog.getRootPane().setOpaque(false);
                        codeDialog.setUndecorated(true);
                        codeDialog.setBackground(new Color(0, 0, 0, 0));
                        codeDialog.pack();
                        codeDialog.setLocationRelativeTo(rootPane);
                        codeDialog.setVisible(true);
                    }
                }
                if (menuIndex == 4) {
                }
                if (menuIndex == 5) {
                    main.showForm(new PanelSlideReservation());
                }
                if (menuIndex == 6) {
                    PanelClose close = new PanelClose();
                    JDialog closeDialog = new JDialog();
                    closeDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                    closeDialog.add(close);
                    closeDialog.getRootPane().setOpaque(false);
                    closeDialog.setUndecorated(true);
                    closeDialog.setBackground(new Color(0, 0, 0, 0));
                    closeDialog.pack();
                    closeDialog.setLocationRelativeTo(rootPane);
                    closeDialog.setVisible(true);
                }
            }
        });
        menu.addEventShowPopup(new EventShowPopupMenu() {
            @Override
            public void showPopup(Component com) {
                MenuItem item = (MenuItem) com;
                PopupMenu popup = new PopupMenu(Main.this, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());
                int x = Main.this.getX() + 52;
                int y = Main.this.getY() + com.getY() + 86;
                popup.setLocation(x, y);
                popup.setVisible(true);
            }
        });
        menu.initMenuItem();
        bg.add(menu, "w 230!, spany 2");    // Span Y 2cell
        bg.add(header, "h 50!, wrap");
        bg.add(main, "w 100%, h 100%");
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menu.isShowMenu()) {
                    width = 60 + (170 * (1f - fraction));
                } else {
                    width = 60 + (170 * fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!, spany2");
                menu.revalidate();
            }

            @Override
            public void end() {
                menu.setShowMenu(!menu.isShowMenu());
                menu.setEnableMenu(true);
            }

        };
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        header.addMenuEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
                menu.setEnableMenu(false);
                if (menu.isShowMenu()) {
                    menu.hideallMenu();
                }
            }
        });
        //  Init google icon font
        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
        //  Start with this form
        main.showForm(new Form_Home());
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(245, 245, 245));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1366, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 783, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
