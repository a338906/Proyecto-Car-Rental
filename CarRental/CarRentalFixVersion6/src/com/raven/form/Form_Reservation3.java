package com.raven.form;

import com.raven.component.CarReceipt;
import com.raven.model.ModelCar;
import com.raven.model.ModelDetails;
import component.login.Message;
import connection.DatabaseConnection;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

public final class Form_Reservation3 extends javax.swing.JPanel {

    public String carSelected;
    public String typeRent;
    float days;
    float packCost;
    float packCost2;
    float packCost3;
    float packCost4;
    float optionalCost = 0;
    float priceCounter = 0;
    float priceNow = 0;
    float priceSubtotal = 0;
    float priceTotal = 0;
    float iva = 0.16f;
    String code;

    public Form_Reservation3() {
        initComponents();
    }

    public void startForm() {
        GridLayout layout = new GridLayout(0, 1);
        layout.setVgap(10);
        panelBg.setLayout(layout);
        setOpaque(false);
        jScrollPane1.setBackground(new Color(245, 245, 245));
        com.raven.swing.scrollbar.ScrollBarCustom sb = new com.raven.swing.scrollbar.ScrollBarCustom();
        sb.setUnitIncrement(50);
        sb.setForeground(new Color(0, 102, 255));
        sb.setBackground(new Color(200, 200, 200));
        panelReservation.fillCombobox();
        jScrollPane1.setVerticalScrollBar(sb);
        jScrollPane1.setBorder(null);
        panelBg.setVisible(true);
        setVisible(true);
    }

    public boolean checkForEmpty() {
        return (!panelReservation.checkReservation());
    }

    public void errorFound() {
        panelReservation.error();
    }

    public void restartReceipt(String carName, Boolean[] optionalList) {
        panelOptionals.removeAll();
        int count = 0;
        optionalCost = 0;
        GridLayout layout = new GridLayout(0, 1);
        layout.setVgap(2);
        panelOptionals.setLayout(layout);
        panelReceipt.removeAll();
        CarReceipt carReceipt = new CarReceipt();
        ModelCar car = getCar(carName);
        carReceipt.setData(car);
        carReceipt.setCarName(car.getName());
        jScrollPane2.setBackground(new Color(245, 245, 245));
        com.raven.swing.scrollbar.ScrollBarCustom sb2 = new com.raven.swing.scrollbar.ScrollBarCustom();
        sb2.setUnitIncrement(10);
        sb2.setForeground(new Color(0, 102, 255));
        sb2.setBackground(new Color(200, 200, 200));
        jScrollPane2.setVerticalScrollBar(sb2);
        panelReceipt.add(carReceipt);
        for (int i = 0; i < optionalList.length; i++) {
            if (!optionalList[i]) {
                count++;
            }
            switch (i) {
                case 0:
                    if (optionalList[i]) {
                        JLabel label = new JLabel("Paquete de Entretenimiento");
                        label.setIcon(new ImageIcon(getClass().getResource("/icon/dashboard/yes.png")));
                        label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
                        label.setForeground(new Color(0, 102, 0));
                        panelOptionals.add(label);
                        optionalCost += getPackCost();
                        break;
                    }
                case 1:
                    if (optionalList[i]) {
                        JLabel label1 = new JLabel("Paquete de Cobertura");
                        label1.setIcon(new ImageIcon(getClass().getResource("/icon/dashboard/yes.png")));
                        label1.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
                        label1.setForeground(new Color(0, 102, 0));
                        panelOptionals.add(label1);
                        optionalCost += getPackCost2();
                    }
                    break;
                case 2:
                    if (optionalList[i]) {
                        JLabel label2 = new JLabel("Paquete de Servicios");
                        label2.setIcon(new ImageIcon(getClass().getResource("/icon/dashboard/yes.png")));
                        label2.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
                        label2.setForeground(new Color(0, 102, 0));
                        panelOptionals.add(label2);
                        optionalCost += getPackCost3();
                    }
                    break;
                case 3:
                    if (optionalList[i]) {
                        JLabel label3 = new JLabel("Paquete de Proteccion");
                        label3.setIcon(new ImageIcon(getClass().getResource("/icon/dashboard/yes.png")));
                        label3.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
                        label3.setForeground(new Color(0, 102, 0));
                        panelOptionals.add(label3);
                        optionalCost += getPackCost4();
                    }
                    break;
                case 4:
                    if (optionalList[i]) {
                        JLabel label4 = new JLabel("Cobertura de Vehículo");
                        label4.setIcon(new ImageIcon(getClass().getResource("/icon/dashboard/yes.png")));
                        label4.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
                        label4.setForeground(new Color(0, 102, 0));
                        panelOptionals.add(label4);
                        optionalPrice(i);
                    }
                    break;
                case 5:
                    if (optionalList[i]) {
                        JLabel label5 = new JLabel("Cobertura por Responsabilidad");
                        label5.setIcon(new ImageIcon(getClass().getResource("/icon/dashboard/yes.png")));
                        label5.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
                        label5.setForeground(new Color(0, 102, 0));
                        panelOptionals.add(label5);
                        optionalPrice(i);
                    }
                    break;
                case 6:
                    if (optionalList[i]) {
                        JLabel label6 = new JLabel("Cobertura Personal");
                        label6.setIcon(new ImageIcon(getClass().getResource("/icon/dashboard/yes.png")));
                        label6.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
                        label6.setForeground(new Color(0, 102, 0));
                        panelOptionals.add(label6);
                        optionalPrice(i);
                    }
                    break;
                case 7:
                    if (optionalList[i]) {
                        JLabel label7 = new JLabel("Cobertura de Objetos Personales");
                        label7.setIcon(new ImageIcon(getClass().getResource("/icon/dashboard/yes.png")));
                        label7.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
                        label7.setForeground(new Color(0, 102, 0));
                        panelOptionals.add(label7);
                        optionalPrice(i);
                    }
                    break;
                case 8:
                    if (optionalList[i]) {
                        JLabel label8 = new JLabel("Radio Satelital");
                        label8.setIcon(new ImageIcon(getClass().getResource("/icon/dashboard/yes.png")));
                        label8.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
                        label8.setForeground(new Color(0, 102, 0));
                        panelOptionals.add(label8);
                        optionalPrice(i);
                    }
                    break;
                case 9:
                    if (optionalList[i]) {
                        JLabel label9 = new JLabel("Wi-Fi Movil");
                        label9.setIcon(new ImageIcon(getClass().getResource("/icon/dashboard/yes.png")));
                        label9.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
                        label9.setForeground(new Color(0, 102, 0));
                        panelOptionals.add(label9);
                        optionalPrice(i);
                    }
                    break;
                case 10:
                    if (optionalList[i]) {
                        JLabel label10 = new JLabel("Asientos para Bebé");
                        label10.setIcon(new ImageIcon(getClass().getResource("/icon/dashboard/yes.png")));
                        label10.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
                        label10.setForeground(new Color(0, 102, 0));
                        panelOptionals.add(label10);
                        optionalPrice(i);
                    }
                    break;
                case 11:
                    if (optionalList[i]) {
                        JLabel label11 = new JLabel("Servicio 24/7");
                        label11.setIcon(new ImageIcon(getClass().getResource("/icon/dashboard/yes.png")));
                        label11.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
                        label11.setForeground(new Color(0, 102, 0));
                        panelOptionals.add(label11);
                        optionalPrice(i);
                    }
                    break;
                case 12:
                    if (optionalList[i]) {
                        JLabel label12 = new JLabel("Conductor Adicional");
                        label12.setIcon(new ImageIcon(getClass().getResource("/icon/dashboard/yes.png")));
                        label12.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
                        label12.setForeground(new Color(0, 102, 0));
                        panelOptionals.add(label12);
                        optionalPrice(i);
                    }
                    break;
                case 13:
                    if (optionalList[i]) {
                        JLabel label13 = new JLabel("Plan de Abastecimiento");
                        label13.setIcon(new ImageIcon(getClass().getResource("/icon/dashboard/yes.png")));
                        label13.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
                        label13.setForeground(new Color(0, 102, 0));
                        panelOptionals.add(label13);
                        optionalPrice(i);
                    }
                    break;
            }
            if (count == 14) {
                JLabel label = new JLabel("Ningun opcional seleccionado");
                label.setIcon(new ImageIcon(getClass().getResource("/icon/dashboard/no.png")));
                label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
                label.setForeground(Color.red);
                panelOptionals.add(label);
            }
        }
        String typeRent = getTypeRent();
        DecimalFormatSymbols df = new DecimalFormatSymbols();
        df.setDecimalSeparator('.');
        DecimalFormat format1 = new DecimalFormat("#,###,###.00", df);
        priceCounter = 0;
        priceNow = 0;
        priceSubtotal = 0;
        priceTotal = 0;
        iva = 0.16f;
        String sql = "SELECT mostrador_costo, prepago_costo FROM vehiculo a INNER JOIN tipo_vehiculo b\n"
                + " ON a.id_tipo = b.id_tipo WHERE a.vehiculos=?";
        try {
            PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            p.setString(1, carName);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                if (getDays() != 0) {
                    priceCounter = r.getFloat("mostrador_costo") * getDays();
                    priceNow = r.getFloat("prepago_costo") * getDays();
                } else {
                    priceCounter = r.getFloat("mostrador_costo");
                    priceNow = r.getFloat("prepago_costo");
                }
            }
            r.close();
            p.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        if (getDays() != 0) {
            optionalCost *= getDays();
        }
        txtCostOptional.setText("$" + String.valueOf(format1.format(optionalCost)));
        if (typeRent.equals("Now")) {
            txtCostBase.setText("$" + String.valueOf(format1.format(priceNow)));
            priceSubtotal = priceNow + optionalCost;
            txtTotal.setText("Total a Prepagar");
            txtCostDiscount.setText("$" + String.valueOf(format1.format(priceCounter - priceNow)));
        } else {
            txtCostBase.setText("$" + String.valueOf(format1.format(priceCounter)));
            priceSubtotal = priceCounter + optionalCost;
            txtCostDiscount.setText("$0.00");
        }
        txtCostSubtotal.setText("$" + String.valueOf(format1.format(priceSubtotal)));
        iva *= priceSubtotal;
        txtCostTax.setText("$" + String.valueOf(format1.format(iva)));
        priceTotal = iva + priceSubtotal;
        txtCostTotal.setText("$" + String.valueOf(format1.format(priceTotal)));
        format1 = new DecimalFormat("#,###,###", df);
        if (getDays() == 0) {
            txtDayValues.setText("1");
        } else {
            txtDayValues.setText(String.valueOf(format1.format(getDays())));
        }
    }

    public void optionalPrice(int idOptional) {
        try {
            String sql = "SELECT Costo, OpcionalID FROM Opcional";
            PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                switch (idOptional) {
                    case 4:
                        if (r.getInt("OpcionalID") == 1) {
                            optionalCost += r.getFloat("Costo");
                        }
                        break;
                    case 5:
                        if (r.getInt("OpcionalID") == 2) {
                            optionalCost += r.getFloat("Costo");
                        }
                        break;
                    case 6:
                        if (r.getInt("OpcionalID") == 3) {
                            optionalCost += r.getFloat("Costo");
                        }
                        break;
                    case 7:
                        if (r.getInt("OpcionalID") == 4) {
                            optionalCost += r.getFloat("Costo");
                        }
                        break;
                    case 8:
                        if (r.getInt("OpcionalID") == 5) {
                            optionalCost += r.getFloat("Costo");
                        }
                        break;
                    case 9:
                        if (r.getInt("OpcionalID") == 6) {
                            optionalCost += r.getFloat("Costo");
                        }
                        break;
                    case 10:
                        if (r.getInt("OpcionalID") == 7) {
                            optionalCost += r.getFloat("Costo");
                        }
                        break;
                    case 11:
                        if (r.getInt("OpcionalID") == 8) {
                            optionalCost += r.getFloat("Costo");
                        }
                        break;
                    case 12:
                        if (r.getInt("OpcionalID") == 9) {
                            optionalCost += r.getFloat("Costo");
                        }
                        break;
                    case 13:
                        if (r.getInt("OpcionalID") == 10) {
                            optionalCost += r.getFloat("Costo");
                        }
                        break;
                }
            }
            r.close();
            p.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public ModelCar getCar(String carName) {
        ModelCar carData = new ModelCar();
        String sql = "SELECT imagen, tipo, mostrador_costo, prepago_costo, asientos, maletasp, puertas,\n"
                + " gasolina, maletasg, tipo_manejo, disponibilidad FROM vehiculo a INNER JOIN tipo_vehiculo b\n"
                + " ON a.id_tipo = b.id_tipo WHERE a.vehiculos=?";
        try {
            PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            p.setString(1, carName);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                Icon carIcon = new ImageIcon(r.getBytes("imagen"));
                String typeCar = r.getString("tipo");
                float priceCounter = r.getFloat("mostrador_costo");
                float priceNow = r.getFloat("prepago_costo");
                int seats = r.getInt("asientos");
                int small = r.getInt("maletasp");
                int doors = r.getInt("puertas");
                int gas = r.getInt("gasolina");
                int large = r.getInt("maletasg");
                String drive = r.getString("tipo_manejo");
                int amount = r.getInt("disponibilidad");
                float difference = priceCounter - priceNow;

                carData = new ModelCar(carIcon, typeCar, carName, priceCounter, priceNow, seats, small, doors, gas, large, drive, amount,
                        new ImageIcon(getClass().getResource("/icon/dashboard/seat.png")),
                        new ImageIcon(getClass().getResource("/icon/dashboard/lugage_small.png")),
                        new ImageIcon(getClass().getResource("/icon/dashboard/door.png")),
                        new ImageIcon(getClass().getResource("/icon/dashboard/gas.png")),
                        new ImageIcon(getClass().getResource("/icon/dashboard/lugage_big.png")),
                        new ImageIcon(getClass().getResource("/icon/dashboard/drive.png")),
                        difference);
            }
            r.close();
            p.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return carData;
    }

    public void addEventContinue(ActionListener event) {
        panelReservation.addEventContinue(event);
    }

    public void addEventBack(ActionListener event) {
        buttonBack.addActionListener(event);
    }

    public void retrievePickUp(ModelDetails dataPickUp) {
        detailsPU.setData(dataPickUp);
    }

    public void retrieveReturn(ModelDetails dataReturn) {
        detailsReturn.setData(dataReturn);
    }

    public float getOptionalCost() {
        return optionalCost;
    }

    public void setOptionalCost(float optionalCost) {
        this.optionalCost = optionalCost;
    }

    public float getDays() {
        return days;
    }

    public void setDays(float days) {
        this.days = days;
    }

    public String getCarSelected() {
        return carSelected;
    }

    public void setCarSelected(String carSelected) {
        this.carSelected = carSelected;
    }

    public String getTypeRent() {
        return typeRent;
    }

    public void setTypeRent(String typeRent) {
        this.typeRent = typeRent;
    }

    public float getPackCost() {
        return packCost;
    }

    public void setPackCost(float packCost) {
        this.packCost = packCost;
    }

    public float getPackCost2() {
        return packCost2;
    }

    public void setPackCost2(float packCost2) {
        this.packCost2 = packCost2;
    }

    public float getPackCost3() {
        return packCost3;
    }

    public void setPackCost3(float packCost3) {
        this.packCost3 = packCost3;
    }

    public float getPackCost4() {
        return packCost4;
    }

    public void setPackCost4(float packCost4) {
        this.packCost4 = packCost4;
    }

    public void insert(String pud, String dod, String pul, String dol, String put, String dot, Boolean[] optionalList, int UserID) {
        String sql = "INSERT INTO Reservacion(RESERVACIONID,PUD,DOD,PUL,DOL,PUT,DOT,CARNAME,PAQUETE,"
                + "PAQUETE2,PAQUETE3,PAQUETE4,OPCIONAL,OPCIONAL2,OPCIONAL3,OPCIONAL4,OPCIONAL5,OPCIONAL6,OPCIONAL7,"
                + "OPCIONAL8,OPCIONAL9,OPCIONAL10,COSTOBASE,COSTOOPCIONAL, IVA,SUBTOTAL,TOTAL,DESCONTADO,USERID,NOMBRE,APELLIDO,"
                + "CORREO,TELEFONO,EDAD,LICENCIA,ESTADO,TARJETA,TIPOTARJETA,MESEXP,YEAREXP,DIRECCION,CODIGOPOSTAL,AEROLINEA,VUELO)"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            code = generateReservationCode();
            p.setString(1, code);
            p.setString(2, pud);
            p.setString(3, dod);
            p.setString(4, pul);
            p.setString(5, dol);
            p.setString(6, put);
            p.setString(7, dot);
            p.setString(8, getCarSelected());
            for (int i = 0; i < optionalList.length; i++) {
                switch (i) {
                    case 0:
                        if (optionalList[i]) {
                            p.setString(9, "True");
                            break;
                        } else {
                            p.setString(9, "");
                        }
                    case 1:
                        if (optionalList[i]) {
                            p.setString(10, "True");
                        } else {
                            p.setString(10, "");
                        }
                        break;
                    case 2:
                        if (optionalList[i]) {
                            p.setString(11, "True");
                        } else {
                            p.setString(11, "");
                        }
                        break;
                    case 3:
                        if (optionalList[i]) {
                            p.setString(12, "True");
                        } else {
                            p.setString(12, "");
                        }
                        break;
                    case 4:
                        if (optionalList[i]) {
                            p.setString(13, "True");
                        } else {
                            p.setString(13, "");
                        }
                        break;
                    case 5:
                        if (optionalList[i]) {
                            p.setString(14, "True");
                        } else {
                            p.setString(14, "");
                        }
                        break;
                    case 6:
                        if (optionalList[i]) {
                            p.setString(15, "True");
                        } else {
                            p.setString(15, "");
                        }
                        break;
                    case 7:
                        if (optionalList[i]) {
                            p.setString(16, "True");
                        } else {
                            p.setString(16, "");
                        }
                        break;
                    case 8:
                        if (optionalList[i]) {
                            p.setString(17, "True");
                        } else {
                            p.setString(17, "");
                        }
                        break;
                    case 9:
                        if (optionalList[i]) {
                            p.setString(18, "True");
                        } else {
                            p.setString(18, "");
                        }
                        break;
                    case 10:
                        if (optionalList[i]) {
                            p.setString(19, "True");
                        } else {
                            p.setString(19, "");
                        }
                        break;
                    case 11:
                        if (optionalList[i]) {
                            p.setString(20, "True");
                        } else {
                            p.setString(20, "");
                        }
                        break;
                    case 12:
                        if (optionalList[i]) {
                            p.setString(21, "True");
                        } else {
                            p.setString(21, "");
                        }
                        break;
                    case 13:
                        if (optionalList[i]) {
                            p.setString(22, "True");
                        } else {
                            p.setString(22, "");
                        }
                        break;
                }
            }
            if (typeRent.equals("Now")) {
                p.setString(23, String.valueOf(priceNow));
            } else {
                p.setString(23, String.valueOf(priceCounter));
            }
            p.setString(24, String.valueOf(optionalCost));
            p.setString(25, String.valueOf(iva));
            p.setString(26, String.valueOf(priceSubtotal));
            p.setString(27, String.valueOf(priceTotal));
            if (typeRent.equals("Now")) {
                p.setString(28, String.valueOf(priceCounter - priceNow));
            } else {
                p.setString(28, "0.00");
            }
            p.setInt(29, UserID);
            p.setString(30, panelReservation.getNames().toUpperCase());
            p.setString(31, panelReservation.getLastName().toUpperCase());
            p.setString(32, panelReservation.getEmail().toUpperCase());
            p.setString(33, panelReservation.getPhone());
            p.setString(34, panelReservation.selectAge());
            p.setString(35, panelReservation.getLicense());
            p.setString(36, panelReservation.getState());
            p.setString(37, panelReservation.getCard());
            p.setString(38, panelReservation.selectCard());
            p.setString(39, panelReservation.selectMonth());
            p.setString(40, panelReservation.selectYear());
            p.setString(41, panelReservation.getAddress().toUpperCase());
            p.setString(42, panelReservation.getPostal());
            if (panelReservation.selectAirline() != null) {
                p.setString(43, panelReservation.selectAirline());
                p.setString(44, panelReservation.getFlight());
            } else {
                p.setString(43, "");
                p.setString(44, "");
            }
            p.executeUpdate();
            p.close();
            showMessage(Message.MessageType.SUCCESS, "Reservacion creada con exito.");
        } catch (SQLException ex) {
            System.err.println(ex);

        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String generateReservationCode() throws SQLException {
        DecimalFormat df = new DecimalFormat("000000");
        DecimalFormat df2 = new DecimalFormat("0");
        Random ran = new Random();
        String code = df.format(ran.nextInt(100000));
        String code2 = df2.format(ran.nextInt(10));
        while (checkDuplicateCode(code)) {
            code = df.format(ran.nextInt(100000));
            code2 = df2.format(ran.nextInt(10));
        }
        code = code + "MX" + code2;
        setCode(code);
        return code;
    }

    private boolean checkDuplicateCode(String code) throws SQLException {
        boolean duplicate = false;
        PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement("SELECT ReservacionID FROM Reservacion WHERE ReservacionID=?");
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
        messageDialog.setLocationRelativeTo(this);
        messageDialog.pack();
        messageDialog.setVisible(true);
    }

    public static enum MessageType {
        SUCCESS, ERROR, COMMENT
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panelBg = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        detailsPU = new com.raven.component.DetailsCard();
        jSeparator1 = new javax.swing.JSeparator();
        detailsReturn = new com.raven.component.DetailsCard();
        jSeparator3 = new javax.swing.JSeparator();
        panelReceipt = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        panelCost = new javax.swing.JPanel();
        txtBase = new javax.swing.JLabel();
        txtOptional = new javax.swing.JLabel();
        txtTax = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JLabel();
        txtDiscount = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        txtCostBase = new javax.swing.JLabel();
        txtCostTax = new javax.swing.JLabel();
        txtCostOptional = new javax.swing.JLabel();
        txtCostTotal = new javax.swing.JLabel();
        txtCostDiscount = new javax.swing.JLabel();
        txtCostSubtotal = new javax.swing.JLabel();
        txtDays = new javax.swing.JLabel();
        txtDayValues = new javax.swing.JLabel();
        panelReservation = new com.raven.component.PanelReservation();
        jSeparator5 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        panelOptionals = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        buttonBack = new swing.login.Close1Button();

        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setHorizontalScrollBar(null);

        panelBg.setLayout(new java.awt.CardLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        detailsPU.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        detailsReturn.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator3.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        panelReceipt.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator2.setForeground(new java.awt.Color(153, 153, 153));

        jSeparator4.setForeground(new java.awt.Color(153, 153, 153));

        panelCost.setBackground(new java.awt.Color(255, 255, 255));

        txtBase.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtBase.setText("Costo Base");

        txtOptional.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtOptional.setText("Opcionales");

        txtTax.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtTax.setText("I.V.A.");

        txtSubtotal.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtSubtotal.setText("Subtotal");

        txtDiscount.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtDiscount.setForeground(new java.awt.Color(51, 102, 255));
        txtDiscount.setText("Ahorraste");

        txtTotal.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(51, 102, 255));
        txtTotal.setText("Total");

        txtCostBase.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtCostBase.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtCostBase.setText("$");

        txtCostTax.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtCostTax.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtCostTax.setText("$");

        txtCostOptional.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtCostOptional.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtCostOptional.setText("$");

        txtCostTotal.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtCostTotal.setForeground(new java.awt.Color(51, 102, 255));
        txtCostTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtCostTotal.setText("$");

        txtCostDiscount.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtCostDiscount.setForeground(new java.awt.Color(51, 102, 255));
        txtCostDiscount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtCostDiscount.setText("$");

        txtCostSubtotal.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtCostSubtotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtCostSubtotal.setText("$");

        txtDays.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtDays.setForeground(new java.awt.Color(51, 102, 255));
        txtDays.setText("Dias Rentados");

        txtDayValues.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtDayValues.setForeground(new java.awt.Color(51, 102, 255));
        txtDayValues.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtDayValues.setText("Dias");

        javax.swing.GroupLayout panelCostLayout = new javax.swing.GroupLayout(panelCost);
        panelCost.setLayout(panelCostLayout);
        panelCostLayout.setHorizontalGroup(
            panelCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCostLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDays, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtOptional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTax, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSubtotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDiscount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCostTax, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCostOptional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCostBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCostTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCostDiscount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCostSubtotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDayValues, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelCostLayout.setVerticalGroup(
            panelCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCostLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDays)
                    .addComponent(txtDayValues))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBase)
                    .addComponent(txtCostBase))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOptional)
                    .addComponent(txtCostOptional))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTax)
                    .addComponent(txtCostTax))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSubtotal)
                    .addComponent(txtCostSubtotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal)
                    .addComponent(txtCostTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiscount)
                    .addComponent(txtCostDiscount))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelReservation.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator5.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jScrollPane2.setBorder(null);

        panelOptionals.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelOptionalsLayout = new javax.swing.GroupLayout(panelOptionals);
        panelOptionals.setLayout(panelOptionalsLayout);
        panelOptionalsLayout.setHorizontalGroup(
            panelOptionalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 409, Short.MAX_VALUE)
        );
        panelOptionalsLayout.setVerticalGroup(
            panelOptionalsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(panelOptionals);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(panelReservation, javax.swing.GroupLayout.DEFAULT_SIZE, 941, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(detailsPU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(panelReceipt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(detailsReturn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jSeparator4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelCost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jSeparator2)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(detailsPU, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(detailsReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(panelReceipt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator5)
                            .addComponent(jScrollPane2)))
                    .addComponent(panelCost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelReservation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBg.add(jPanel2, "card2");

        jScrollPane1.setViewportView(panelBg);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/Part4.png"))); // NOI18N

        buttonBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/login/back1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.login.Close1Button buttonBack;
    private com.raven.component.DetailsCard detailsPU;
    private com.raven.component.DetailsCard detailsReturn;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JPanel panelBg;
    private javax.swing.JPanel panelCost;
    private javax.swing.JPanel panelOptionals;
    private javax.swing.JPanel panelReceipt;
    private com.raven.component.PanelReservation panelReservation;
    private javax.swing.JLabel txtBase;
    private javax.swing.JLabel txtCostBase;
    private javax.swing.JLabel txtCostDiscount;
    private javax.swing.JLabel txtCostOptional;
    private javax.swing.JLabel txtCostSubtotal;
    private javax.swing.JLabel txtCostTax;
    private javax.swing.JLabel txtCostTotal;
    private javax.swing.JLabel txtDayValues;
    private javax.swing.JLabel txtDays;
    private javax.swing.JLabel txtDiscount;
    private javax.swing.JLabel txtOptional;
    private javax.swing.JLabel txtSubtotal;
    private javax.swing.JLabel txtTax;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
}
