package component.login;

import main.Main;
import model.login.ModelMessage;
import model.login.ModelUser;
import connection.DatabaseConnection;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Path2D;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import service.login.ServiceMail;
import service.login.ServiceUser;
import verify.login.EncryptDecrypt;

public class PanelSlide extends javax.swing.JLayeredPane {

    public void setFram(JFrame fram) {
        this.fram = fram;
    }

    private final Animator animator;
    private float animate = 1f;
    private boolean slideLeft;
    private final PanelLogin login;
    private PanelRegister register;
    private final PanelLoading loading;
    private Thread th;
    private MigLayout layout;
    private JFrame fram;
    private ServiceUser serviceUser;
    public int UserIDFinal;

    public PanelSlide() {
        initComponents();
        setPreferredSize(new Dimension(1200, 800));
        layout = new MigLayout("inset 0", "[fill]", "[fill]");
        setLayout(layout);
        login = new PanelLogin();
        loading = new PanelLoading();
        serviceUser = new ServiceUser();
        loading.setVisible(false);
        Color color = new Color(32, 34, 47);
        setBackground(color);
        loading.setBackground(color);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void begin() {
                if (slideLeft) {
                    loading.setVisible(true);
                } else {
                    login.setVisible(true);
                }
            }

            @Override
            public void timingEvent(float fraction) {
                double width = getWidth();
                animate = fraction;
                float a = easeOutQuint(fraction);
                int x = (int) (a * width);
                loading.setAnimate(slideLeft, fraction);
                layout.setComponentConstraints(loading, "pos " + x + " 0 100% 100%");
                revalidate();
                repaint();
            }

            @Override
            public void end() {
                if (slideLeft) {
                    login.setVisible(false);
                } else {
                    loading.setVisible(false);
                    loading.reset();
                }
            }
        };
        animator = new Animator(1000, target);
        animator.setResolution(0);
        add(loading, " pos 0 0 0 0, w 0!");
        add(login);
        login.addEventLogin(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    if (login.checkUser()) {
                        showSlide(true);
                        login(login.getUserName(), login.getPassword());
                    } else {
                        showMessage(Message.MessageType.ERROR, "Campos vacios.");
                    }
                }
            }
        });
        login.addEventRegister(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    JDialog dregister = new JDialog();
                    register = new PanelRegister();
                    dregister.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                    dregister.add(register);
                    dregister.getRootPane().setOpaque(false);
                    dregister.setUndecorated(true);
                    dregister.setBackground(new Color(0, 0, 0, 0));
                    dregister.pack();
                    dregister.setLocationRelativeTo(null);
                    dregister.repaint();
                    dregister.setVisible(true);
                    if (register.getExit() != 0) {
                        showSlide(true);
                        register(register.getUserName(), register.getNames(), register.getLastName(), register.getEmail(), register.getAddress(),
                                register.getPostal(), register.getPhone(), register.getPassword(), register.getCard(),
                                register.getDiscount(), register.getLicense(), register.getState(), register.selectCard(),
                                register.selectMonth(), register.selectYear(), register.selectAge());
                    }
                }
            }
        });
        login.addEventGuest(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    showSlide(true);
                    login("guest", "guest");
                }
            }
        });
        login.addEventForgot(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    JDialog search = new JDialog();
                    search.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                    PanelSearch pc = new PanelSearch();
                    search.add(pc);
                    search.getRootPane().setOpaque(false);
                    search.setUndecorated(true);
                    search.setBackground(new Color(0, 0, 0, 0));
                    search.pack();
                    search.setLocationRelativeTo(null);
                    search.setVisible(true);
                }
            }
        });
        login.addEventMinimize(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    fram.setState(fram.ICONIFIED);
                }
            }
        });

        loading.addEventContinue(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Main main = new Main(getUserID());
                System.out.println(getUserID());
                main.setVisible(true);
                fram.dispose();
            }
        });
        loading.addEventBack(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    th.interrupt();
                    showSlide(false);
                }
            }
        });
        loading.addEventBackRegister(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    th.interrupt();
                    showSlide(false);
                }
            }
        });
    }

    public void showSlide(boolean show) {
        slideLeft = show;
        animator.start();
    }

    private void login(String userName, String password) {
        th = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    String sql = "Select UserID, UserName, Pass, Profile, VerifyCode, Status, Email from USUARIO where UserName=?";
                    PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
                    p.setString(1, userName);

                    ResultSet r = p.executeQuery();
                    r.next();

                    int id = r.getInt("UserID");
                    String user = r.getString("UserName");
                    String passToDecrypt = r.getString("Pass");

                    if (EncryptDecrypt.decrpytString(passToDecrypt).equals(password)) {
                        Icon profile;

                        if (r.getObject("Profile") != null) {
                            profile = new ImageIcon(r.getBytes("Profile"));
                        } else {
                            profile = new ImageIcon(getClass().getResource("/icon/login/user.png"));
                        }

                        String email = r.getString("Email");
                        String code = r.getString("VerifyCode");
                        String status = r.getString("Status");

                        if (status.equals("Verificado")) {
                            ModelUser data = new ModelUser(id, user, profile, email, null, code, status);
                            setUserID(id);
                            loading.doneLogin(data);
                        } else {
                            ModelMessage ms = new ServiceMail().sendMain(email, code);

                            JDialog verifyCode = new JDialog();
                            verifyCode.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                            PanelVerifyCode vc = new PanelVerifyCode();
                            vc.setUserID(id);
                            verifyCode.add(vc);
                            verifyCode.getRootPane().setOpaque(false);
                            verifyCode.setUndecorated(true);
                            verifyCode.setBackground(new Color(0, 0, 0, 0));
                            verifyCode.pack();
                            verifyCode.setLocationRelativeTo(null);
                            verifyCode.setVisible(true);

                            String sql2 = "Select Status from USUARIO where UserName=?";
                            p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql2);
                            p.setString(1, userName);
                            r = p.executeQuery();
                            r.next();
                            status = r.getString("Status");
                            setUserID(id);
                            if ("Verificado".equals(status)) {
                                ModelUser data = new ModelUser(id, user, profile, email, null, null, status);
                                loading.doneLogin(data);
                                r.close();
                            } else {
                                loading.showError("Verifique antes su cuenta.");
                            }
                        }
                    } else {
                        loading.showError("Usuario o contraseña incorrecta.");
                        r.close();
                    }
                } catch (InterruptedException e) {

                } catch (Exception e) {
                    loading.showError("Error con la base de datos.");
                }
            }
        });
        th.start();
    }

    private void register(String userName, String name, String lastName, String email, String address, String postal, String phone, String password,
            String card, String discount, String license, String state, String typeCard, String month, String year, String age) {
        th = new Thread(new Runnable() {
            int id = 0;

            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    String sql = "INSERT INTO USUARIO(UserName, Pass, Email, VerifyCode, Status)VALUES(?,?,?,?,?)";
                    String sql2 = "INSERT INTO PERFIL(pname, lastname, age, address, postal, phone, typecard, monthexp, yearexp, card, license, statelic, discount)"
                            + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
                    String passwordEncrypted = EncryptDecrypt.encrpytString(password);
                    String code = generateVerifyCode();
                    p.setString(1, userName);
                    p.setString(2, passwordEncrypted);
                    p.setString(3, email);
                    p.setString(4, code);
                    p.setString(5, "Sin Verificar");
                    p.executeUpdate();

                    p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql2);
                    p.setString(1, name);
                    p.setString(2, lastName);
                    p.setString(3, age);
                    p.setString(4, address);
                    p.setString(5, postal);
                    p.setString(6, phone);
                    p.setString(7, typeCard);
                    p.setString(8, month);
                    p.setString(9, year);
                    p.setString(10, card);
                    p.setString(11, license);
                    p.setString(12, state);
                    p.setString(13, discount);
                    p.executeUpdate();

                    String sql3 = "SELECT UserID FROM USUARIO WHERE UserName=?";
                    p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql3);
                    p.setString(1, userName);
                    ResultSet r = p.executeQuery();

                    if (r.next()) {
                        id = r.getInt("UserID");
                    } else {
                        loading.showError("El usuario no existe.");
                    }

                    r.close();
                    p.close();

                    ModelMessage ms = new ServiceMail().sendMain(email, code);
                    if (ms.isSuccess()) {
                        JDialog verifyCode = new JDialog();
                        verifyCode.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                        PanelVerifyCode vc = new PanelVerifyCode();
                        vc.setUserID(id);
                        verifyCode.add(vc);
                        verifyCode.getRootPane().setOpaque(false);
                        verifyCode.setUndecorated(true);
                        verifyCode.setBackground(new Color(0, 0, 0, 0));
                        verifyCode.pack();
                        verifyCode.setLocationRelativeTo(null);
                        verifyCode.setVisible(true);

                        loginreg(userName);
                    } else {
                        loading.showError(ms.getMessage());
                    }
                } catch (InterruptedException e) {
                    loading.showError("Excepcion por interrupcion.");
                } catch (Exception e) {
                    loading.showError("Error al insertar en la base.");
                }
            }
        });
        th.start();
    }

    public void loginreg(String userName) {
        th = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    String sql = "SELECT UserID, Email, Profile, VerifyCode, Status FROM USUARIO WHERE UserName=?";
                    PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
                    p.setString(1, userName);
                    ResultSet r = p.executeQuery();
                    if (r.next()) {
                        int id = r.getInt("UserID");
                        Icon profile;
                        if (r.getObject("Profile") != null) {
                            profile = new ImageIcon(r.getBytes("Profile"));
                        } else {
                            profile = new ImageIcon(getClass().getResource("/icon/login/user.png"));
                        }
                        String email = r.getString("Email");
                        String status = r.getString("Status");
                        String code = r.getString("VerifyCode");
                        ModelUser data = new ModelUser(id, userName, profile, email, null, code, status);   //FALTA TERMINAR PUEDE GENERAR FALLO !!!!!                     
                        loading.doneLogin(data);
                        if (!status.equals("Verificado")) {
                            showMessage(Message.MessageType.ERROR, "La cuenta no ha sido verificada.");
                        }
                        setUserID(id);
                    } else {
                        loading.showError("Fallo al momento de iniciar sesion.");
                    }
                    r.close();

                } catch (InterruptedException e) {

                } catch (Exception e) {
                    loading.showError("Error despues de insertar en la base.");
                }
            }
        });
        th.start();
    }

    public int getUserID() {
        return UserIDFinal;
    }

    public void setUserID(int UserIDFinal) {
        this.UserIDFinal = UserIDFinal;
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
        messageDialog.setLocationRelativeTo(fram);
        messageDialog.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 337, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs);
        if (slideLeft == false) {
            Graphics2D g2 = (Graphics2D) grphcs.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int width = getWidth();
            int height = getHeight();
            float x = easeOutQuint(animate) * width;
            float y = 0;
            int centerY = height / 2;
            Path2D.Float p = new Path2D.Float();
            p.moveTo(x, y);
            p.lineTo(x, height);
            p.curveTo(x, height, easeOutBounce(animate) * width, centerY, x, y);
            g2.setColor(getBackground());
            g2.fill(p);
            g2.dispose();
        }
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

    private float easeOutQuint(float x) {
        double v = 1 - Math.pow(1 - x, 5);
        if (slideLeft) {
            return (float) (1f - v);
        } else {
            return (float) v;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
