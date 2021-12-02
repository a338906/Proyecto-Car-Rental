/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.form;

import com.raven.model.ModelDetails;
import component.login.Message;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author NekoG
 */
public class Form_ReservationMain extends javax.swing.JPanel {

    ModelDetails dataPickUp = new ModelDetails();
    ModelDetails dataReturn = new ModelDetails();
    boolean noAdd = false;
    public static final Locale LOCALE_MX = new Locale("es", "MX");

    public Form_ReservationMain(int UserID) {
        initComponents();
        form1.addEventContinue(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                form1.error();
                if (form1.checkEmpty()) {
                    if (form1.getHour() <= 0 && form1.getDate() <= 0) {
                        if (form1.getDate() < 0) {
                            form1.errorDodDot(0);
                            form1.showMessage(Message.MessageType.ERROR, "Ingrese una fecha valida.", ae);
                            form1.cleanDodDot(0);
                        } else {
                            form1.errorDodDot(1);
                            form1.showMessage(Message.MessageType.ERROR, "Ingrese una hora valida.", ae);
                            form1.cleanDodDot(1);
                        }
                    } else if (form1.getHour() > 0 && form1.getDate() < 0) {
                        form1.errorDodDot(0);
                        form1.showMessage(Message.MessageType.ERROR, "Ingrese una fecha valida.", ae);
                        form1.cleanDodDot(0);
                    } else {

                        final String OLD_FORMAT = "dd/MM/yyyy";
                        final String NEW_FORMAT = "E, dd MMM yyyy";

                        String oldDateStringPickUp = form1.getPud();
                        String oldDateStringReturn = form1.getDod();

                        String newDateStringPickUp;
                        String newDateStringReturn;

                        SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT, LOCALE_MX);

                        Date dPickUp;
                        Date dReturn;
                        try {
                            dPickUp = sdf.parse(oldDateStringPickUp);
                            dReturn = sdf.parse(oldDateStringReturn);
                            sdf.applyPattern(NEW_FORMAT);

                            newDateStringPickUp = sdf.format(dPickUp);
                            newDateStringReturn = sdf.format(dReturn);

                            dataPickUp.setTitle("Recoges");
                            dataPickUp.setDate(newDateStringPickUp.concat(", " + form1.selectPut()));
                            dataPickUp.setLocation(form1.selectPul());

                            dataReturn.setTitle("Regresas");
                            dataReturn.setDate(newDateStringReturn.concat(", " + form1.selectDot()));
                            dataReturn.setLocation(form1.selectDol());

                            removeAll();
                            add(form2);
                            repaint();
                            revalidate();

                            form2.retrievePickUp(dataPickUp);
                            form2.retrieveReturn(dataReturn);
                            form2.setDays(form1.getDays());
                            form2.startForm();
                        } catch (ParseException ex) {
                            System.err.println(ex);
                        }
                    }
                } else {
                    form1.showMessage(Message.MessageType.ERROR, "Campos vacios.", ae);
                    form1.clean();
                }
            }
        });

        form2.addEventBack(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                removeAll();
                add(form1);
                repaint();
                revalidate();
            }
        });

        form2.addEventContinue(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                removeAll();
                add(form3);
                repaint();
                revalidate();
                form3.retrievePickUp(dataPickUp);
                form3.retrieveReturn(dataReturn);
                if (!noAdd) {
                    form3.startForm(form2.getCarSelected());
                } else {
                    form3.restartReceipt(form2.getCarSelected());
                }
            }
        });

        form3.addEventBack(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                removeAll();
                add(form2);
                repaint();
                revalidate();
                noAdd = true;
            }
        });

        form3.addEventContinue(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                removeAll();
                add(form4);
                repaint();
                revalidate();
                form4.retrievePickUp(dataPickUp);
                form4.retrieveReturn(dataReturn);
                form4.setTypeRent(form2.getTypeRent());
                form4.setPackCost(form3.getPackCost());
                form4.setPackCost2(form3.getPackCost2());
                form4.setPackCost3(form3.getPackCost3());
                form4.setPackCost4(form3.getPackCost4());
                form4.setDays(form1.getDays());
                if (!noAdd) {
                    form4.startForm();
                }
                form4.restartReceipt(form2.getCarSelected(), form3.optionalsList());
            }
        });

        form4.addEventBack(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                removeAll();
                add(form3);
                repaint();
                revalidate();
                noAdd = true;
            }
        });

        form4.addEventContinue(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (form4.checkForEmpty()) {
                    form4.errorFound();
                } else {
                    form4.errorFound();
                    form4.insert(form1.getPud(), form1.getDod(), dataPickUp.getLocation(), dataReturn.getLocation(), form1.selectDot(), form1.selectPut(), form3.optionalsList(), UserID);

                    removeAll();
                    add(form5);
                    repaint();
                    revalidate();
                    form5.setCode(form4.getCode());
                }
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        form1 = new com.raven.form.Form_Reservation();
        form2 = new com.raven.form.Form_Reservation1();
        form3 = new com.raven.form.Form_Reservation2();
        form4 = new com.raven.form.Form_Reservation3();
        form5 = new com.raven.form.Form_Reservation4();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.CardLayout());
        add(form1, "card2");
        add(form2, "card3");
        add(form3, "card4");
        add(form4, "card5");
        add(form5, "card6");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.form.Form_Reservation form1;
    private com.raven.form.Form_Reservation1 form2;
    private com.raven.form.Form_Reservation2 form3;
    private com.raven.form.Form_Reservation3 form4;
    private com.raven.form.Form_Reservation4 form5;
    // End of variables declaration//GEN-END:variables
}
