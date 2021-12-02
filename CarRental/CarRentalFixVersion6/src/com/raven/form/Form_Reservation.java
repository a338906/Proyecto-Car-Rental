package com.raven.form;

import com.raven.datechooser.SelectedDate;
import component.login.Message;
import javax.swing.*;
import java.sql.*;
import connection.DatabaseConnection;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Form_Reservation extends javax.swing.JPanel {

    public Form_Reservation() {
        initComponents();
        setOpaque(false);
        init();
    }

    public void init() {
        SelectedDate d = date.getSelectedDate();
        date1.setSelectedDate(new SelectedDate(d.getDay() + 1, d.getMonth(), d.getYear()));

        try {
            String sql = "SELECT State, City FROM Lugar";

            PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet r = p.executeQuery();

            while (r.next()) {
                comboPUL.addItem(r.getString("State") + ", " + r.getString("City"));
                comboDOL.addItem(r.getString("State") + ", " + r.getString("City"));
            }

            comboPUL.setSelectedIndex(-1);
            comboDOL.setSelectedIndex(-1);

            r.close();
            p.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        date = new com.raven.datechooser.DateChooser();
        date1 = new com.raven.datechooser.DateChooser();
        background1 = new com.raven.form.Background();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        close1Button1 = new swing.login.Close1Button();
        panelRound2 = new swing.login.PanelRound();
        comboDOL = new swing.login.Combobox();
        comboPUL = new swing.login.Combobox();
        txtPUD = new swing.login.TextField();
        txtDOD = new swing.login.TextField();
        comboPUT = new swing.login.Combobox();
        comboDOT = new swing.login.Combobox();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        date.setTextRefernce(txtPUD);

        date1.setTextRefernce(txtDOD);
        date1.getAccessibleContext().setAccessibleParent(null);

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(159, 159, 159));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/reservation.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setOpaque(false);

        close1Button1.setBackground(new java.awt.Color(0, 102, 255));
        close1Button1.setForeground(new java.awt.Color(255, 255, 255));
        close1Button1.setText("SELECCIONAR MI CARRO");
        close1Button1.setEffectColor(new java.awt.Color(255, 255, 255));
        close1Button1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(281, Short.MAX_VALUE)
                .addComponent(close1Button1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(281, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(close1Button1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        comboDOL.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        comboDOL.setLabeText("Lugar a dejar el vehiculo");
        comboDOL.setLineColor(new java.awt.Color(0, 102, 255));

        comboPUL.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        comboPUL.setLabeText("Lugar a recoger el vehiculo");
        comboPUL.setLineColor(new java.awt.Color(0, 102, 255));

        txtPUD.setBackground(new java.awt.Color(255, 255, 255));
        txtPUD.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtPUD.setLabelText("Fecha a recoger el vehiculo");
        txtPUD.setLineColor(new java.awt.Color(0, 102, 255));

        txtDOD.setBackground(new java.awt.Color(255, 255, 255));
        txtDOD.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtDOD.setLabelText("Fecha a dejar el vehiculo");
        txtDOD.setLineColor(new java.awt.Color(0, 102, 255));

        comboPUT.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "12:00 AM", "12:30 AM", "1:00 AM", "1:30 AM", "2:00 AM", "2:30 AM", "3:00 AM", "3:30 AM", "4:00 AM", "4:30 AM", "5:00 AM", "5:30 AM", "6:00 AM", "6:30 AM", "7:00 AM", "7:30 AM", "8:00 AM", "8:30 AM", "9:00 AM", "9:30 AM", "10:00 AM", "10:30 AM", "11:00 AM", "11:30 AM", "12:00 PM", "12:30 PM", "1:00 PM", "1:30 PM", "2:00 PM", "2:30 PM", "3:00 PM", "3:30 PM", "4:00 PM", "4:30 PM", "5:00 PM", "5:30 PM", "6:00 PM", "6:30 PM", "7:00 PM", "7:30 PM", "8:00 PM", "8:30 PM", "9:00 PM", "9:30 PM", "10:00 PM", "10:30 PM", "11:00 PM", "11:30 PM" }));
        comboPUT.setSelectedIndex(24);
        comboPUT.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        comboPUT.setLabeText("Hora para recoger el vehiculo");
        comboPUT.setLineColor(new java.awt.Color(0, 102, 255));

        comboDOT.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "12:00 AM", "12:30 AM", "1:00 AM", "1:30 AM", "2:00 AM", "2:30 AM", "3:00 AM", "3:30 AM", "4:00 AM", "4:30 AM", "5:00 AM", "5:30 AM", "6:00 AM", "6:30 AM", "7:00 AM", "7:30 AM", "8:00 AM", "8:30 AM", "9:00 AM", "9:30 AM", "10:00 AM", "10:30 AM", "11:00 AM", "11:30 AM", "12:00 PM", "12:30 PM", "1:00 PM", "1:30 PM", "2:00 PM", "2:30 PM", "3:00 PM", "3:30 PM", "4:00 PM", "4:30 PM", "5:00 PM", "5:30 PM", "6:00 PM", "6:30 PM", "7:00 PM", "7:30 PM", "8:00 PM", "8:30 PM", "9:00 PM", "9:30 PM", "10:00 PM", "10:30 PM", "11:00 PM", "11:30 PM" }));
        comboDOT.setSelectedIndex(24);
        comboDOT.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        comboDOT.setLabeText("Hora para dejar el vehiculo");
        comboDOT.setLineColor(new java.awt.Color(0, 102, 255));

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addComponent(comboPUL, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPUD, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addComponent(comboDOL, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDOD, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboPUT, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(comboDOT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboPUL, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPUD, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboPUT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboDOL, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDOD, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDOT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout background1Layout = new javax.swing.GroupLayout(background1);
        background1.setLayout(background1Layout);
        background1Layout.setHorizontalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        background1Layout.setVerticalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(background1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(148, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/Part1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel3))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleParent(this);
    }// </editor-fold>//GEN-END:initComponents

    public void addEventContinue(ActionListener event) {
        close1Button1.addActionListener(event);
    }

    public boolean checkEmpty() {
        return !(comboPUL.getSelectedItem() == null || comboDOL.getSelectedItem() == null
                || comboDOT.getSelectedItem() == null || comboPUT.getSelectedItem() == null
                || txtDOD.getText().equals("") || txtPUD.getText().equals(""));
    }

    public boolean checkEqual() {
        return !(txtDOD.getText().trim().equals(txtPUD.getText().trim()));
    }

    public long getHour() {
        String put = comboPUT.getSelectedItem().toString();
        String dot = comboDOT.getSelectedItem().toString();
        put = timeConversion(put);
        dot = timeConversion(dot);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime dateTime1 = LocalTime.parse(put, formatter);
        LocalTime dateTime2 = LocalTime.parse(dot, formatter);
        long diffInMin = java.time.Duration.between(dateTime1, dateTime2).toMinutes();
        return diffInMin;
    }
    
    public float getDays() {
        String put = comboPUT.getSelectedItem().toString();
        String dot = comboDOT.getSelectedItem().toString();
        put = timeConversion(put);
        dot = timeConversion(dot);
        String pud = txtPUD.getText();
        String dod = txtDOD.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dateTime1 = LocalDateTime.parse(pud + " " + put, formatter);
        LocalDateTime dateTime2 = LocalDateTime.parse(dod + " " + dot, formatter);
        long diffInDays = java.time.Duration.between(dateTime1, dateTime2).toDays();
        int diffDays2 = (int) diffInDays;
        float days = (float) diffDays2;
        return days;
    }

    public long getDate() {
        String pud = getPud();
        String dod = getDod();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");;
        LocalDate dateTime1 = LocalDate.parse(pud, formatter);
        LocalDate dateTime2 = LocalDate.parse(dod, formatter);
        long diffInHours = ChronoUnit.DAYS.between(dateTime1, dateTime2);
        return diffInHours;
    }

    
    
    public String timeConversion(String selectedValue) {
        if (selectedValue.contains("AM")) {
            selectedValue = selectedValue.replace(" AM", "");
            if (selectedValue.contains("12:")) {
                selectedValue = selectedValue.replace("12", "00");
            } else if (selectedValue.contains("11:")) {
                selectedValue = selectedValue.replace("11", "11");
            } else if (selectedValue.contains("1:")) {
                selectedValue = selectedValue.replace("1", "01");
            } else if (selectedValue.contains("2:")) {
                selectedValue = selectedValue.replace("2", "02");
            } else if (selectedValue.contains("3:")) {
                selectedValue = selectedValue.replace("3:", "03:");
            } else if (selectedValue.contains("4:")) {
                selectedValue = selectedValue.replace("4", "04");
            } else if (selectedValue.contains("5:")) {
                selectedValue = selectedValue.replace("5", "05");
            } else if (selectedValue.contains("6:")) {
                selectedValue = selectedValue.replace("6", "06");
            } else if (selectedValue.contains("7:")) {
                selectedValue = selectedValue.replace("7", "07");
            } else if (selectedValue.contains("8:")) {
                selectedValue = selectedValue.replace("8", "08");
            } else if (selectedValue.contains("9:")) {
                selectedValue = selectedValue.replace("9", "09");
            }
        } else if (selectedValue.contains("PM")) {
            selectedValue = selectedValue.replace(" PM", "");
            if (selectedValue.contains("12:")) {

            } else if (selectedValue.contains("11:")) {
                selectedValue = selectedValue.replace("11", "23");
            } else if (selectedValue.contains("1:")) {
                selectedValue = selectedValue.replace("1", "13");
            } else if (selectedValue.contains("2:")) {
                selectedValue = selectedValue.replace("2", "14");
            } else if (selectedValue.contains("3:")) {
                selectedValue = selectedValue.replace("3:", "15:");
            } else if (selectedValue.contains("4:")) {
                selectedValue = selectedValue.replace("4", "16");
            } else if (selectedValue.contains("5:")) {
                selectedValue = selectedValue.replace("5", "17");
            } else if (selectedValue.contains("6:")) {
                selectedValue = selectedValue.replace("6", "18");
            } else if (selectedValue.contains("7:")) {
                selectedValue = selectedValue.replace("7", "19");
            } else if (selectedValue.contains("8:")) {
                selectedValue = selectedValue.replace("8", "20");
            } else if (selectedValue.contains("9:")) {
                selectedValue = selectedValue.replace("9", "21");
            } else if (selectedValue.contains("10:")) {
                selectedValue = selectedValue.replace("10", "22");
            }
        }
        return selectedValue;
    }

    public void clean() {
        txtDOD.setBackground(new Color(255, 255, 255));
        txtDOD.setLineColor(new Color(0, 102, 255));
        txtPUD.setBackground(new Color(255, 255, 255));
        txtPUD.setLineColor(new Color(0, 102, 255));
        comboDOL.setBackground(new Color(255, 255, 255));
        comboDOL.setLineColor(new Color(0, 102, 255));
        txtDOD.setBackground(new Color(255, 255, 255));
        txtDOD.setLineColor(new Color(0, 102, 255));
        comboDOT.setBackground(new Color(255, 255, 255));
        comboDOT.setLineColor(new Color(0, 102, 255));
    }

    public void cleanDodDot(int type) {
        if (type == 0) {
            txtDOD.setText("");
            txtDOD.setBackground(new Color(255, 255, 255));
            txtDOD.setLineColor(new Color(0, 102, 255));
        } else {
            comboDOT.setSelectedIndex(-1);
            comboDOT.setBackground(new Color(255, 255, 255));
            comboDOT.setLineColor(new Color(0, 102, 255));
        }
    }

    public void errorDodDot(int type) {
        if (type == 0) {
            txtDOD.setBackground(new Color(255, 204, 204));
            txtDOD.setLineColor(Color.red);
        } else {
            comboDOT.setBackground(new Color(255, 204, 204));
            comboDOT.setLineColor(Color.red);
        }
    }

    public void error() {
        if (txtDOD.getText().trim().equals("")) {
            txtDOD.setBackground(new Color(255, 204, 204));
            txtDOD.setLineColor(Color.red);
        }
        if (txtPUD.getText().trim().equals("")) {
            txtPUD.setBackground(new Color(255, 204, 204));
            txtPUD.setLineColor(Color.red);
        }
        if (comboDOL.getSelectedItem() == null) {
            comboDOL.setBackground(new Color(255, 204, 204));
            comboDOL.setLineColor(Color.red);
        }
        if (comboPUL.getSelectedItem() == null) {
            comboPUL.setBackground(new Color(255, 204, 204));
            comboPUL.setLineColor(Color.red);
        }

        if (comboDOT.getSelectedItem() == null) {
            comboDOT.setBackground(new Color(255, 204, 204));
            comboDOT.setLineColor(Color.red);
        }
        if (comboPUT.getSelectedItem() == null) {
            comboPUT.setBackground(new Color(255, 204, 204));
            comboPUT.setLineColor(Color.red);
        }
    }

    public String getDod() {
        return txtDOD.getText().trim();
    }

    public String getPud() {
        return txtPUD.getText().trim();
    }

    public String selectDol() {
        String selectedValue = comboDOL.getSelectedItem().toString();
        return selectedValue;
    }

    public String selectPul() {
        String selectedValue = comboPUL.getSelectedItem().toString();
        return selectedValue;
    }
    
    public String selectDot() {
        String selectedValue = comboDOT.getSelectedItem().toString();
        return selectedValue;
    }

    public String selectPut() {
        String selectedValue = comboPUT.getSelectedItem().toString();
        return selectedValue;
    }

    public void showMessage(Message.MessageType messageType, String message, ActionEvent e) {
        JDialog messageDialog = new JDialog();
        messageDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        Message ms = new Message();
        ms.showMessage(messageType, message);
        messageDialog.add(ms);
        messageDialog.getRootPane().setOpaque(false);
        messageDialog.setUndecorated(true);
        messageDialog.setBackground(new Color(0, 0, 0, 0));
        messageDialog.pack();
        messageDialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor((Component) e.getSource()));
        messageDialog.setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.form.Background background1;
    private swing.login.Close1Button close1Button1;
    private swing.login.Combobox comboDOL;
    private swing.login.Combobox comboDOT;
    private swing.login.Combobox comboPUL;
    private swing.login.Combobox comboPUT;
    private com.raven.datechooser.DateChooser date;
    private com.raven.datechooser.DateChooser date1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private swing.login.PanelRound panelRound2;
    private swing.login.TextField txtDOD;
    private swing.login.TextField txtPUD;
    // End of variables declaration//GEN-END:variables
}
