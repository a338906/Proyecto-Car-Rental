package com.raven.form;

import javax.swing.*;
import java.sql.*;
import connection.DatabaseConnection;
import com.raven.model.ModelCar;
import com.raven.model.ModelDetails;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

public final class Form_Reservation1 extends javax.swing.JPanel {

    public Form_Reservation1() {
        initComponents();
    }

    public void startForm() {
        GridLayout layout = new GridLayout(0, 1);
        layout.setVgap(10);
        panelRound2.setLayout(layout);
        setOpaque(false);
        initTableData("","");
        fillCombobox();
        jScrollPane1.setBackground(new Color(245, 245, 245));
        com.raven.swing.scrollbar.ScrollBarCustom sb = new com.raven.swing.scrollbar.ScrollBarCustom();
        sb.setUnitIncrement(50);
        sb.setForeground(new Color(0, 102, 255));
        sb.setBackground(new Color(200, 200, 200));
        jScrollPane1.setVerticalScrollBar(sb);
        jScrollPane1.setBorder(null);
        panelRound2.setVisible(true);
        setVisible(true);
    }
    
    public void fillCombobox() {
        try {
            String sql = "SELECT Tipo FROM TIPO_VEHICULO";
            PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                comboSelect.addItem(r.getString("Tipo"));
            }
            r.close();
            p.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        comboSelect.setSelectedIndex(-1);
    }

    public void retrievePickUp(ModelDetails dataPickUp) {
        detailsPU.setData(dataPickUp);
    }

    public void retrieveReturn(ModelDetails dataReturn) {
        detailsReturn.setData(dataReturn);
    }
    
    float days;

    public float getDays() {
        return days;
    }

    public void setDays(float days) {
        this.days = days;
    }

    public void initTableData(String select, String order) {
        ArrayList<ModelCar> cars = carList(select, order);
        DecimalFormatSymbols df = new DecimalFormatSymbols();
        df.setDecimalSeparator('.');

        DecimalFormat format1 = new DecimalFormat("#,###,###.00", df);
        for (int i = 0; i < cars.size(); i++) {
            float payNow;
            float payCounter;
            if (getDays() != 0) {
                payNow = cars.get(i).getPriceNow() * getDays();
                payCounter = cars.get(i).getPriceCounter() * getDays();
            } else {
                payNow = cars.get(i).getPriceNow();
                payCounter = cars.get(i).getPriceCounter();
            }
            ModelCar car = new ModelCar(cars.get(i).getCarIcon(), cars.get(i).getTypeCar(), cars.get(i).getName(), payCounter,
                    payNow, cars.get(i).getSeat(), cars.get(i).getSmall(), cars.get(i).getDoor(), cars.get(i).getGas(),
                    cars.get(i).getLarge(), cars.get(i).getType(), cars.get(i).getAmount(), cars.get(i).getSeatIcon(), cars.get(i).getSmallIcon(),
                    cars.get(i).getDoorIcon(), cars.get(i).getGasIcon(), cars.get(i).getLargeIcon(), cars.get(i).getTypeIcon(), cars.get(i).getDifference());

            String pN = String.valueOf(format1.format(payNow));
            String pC = String.valueOf(format1.format(payCounter));
            String pD = String.valueOf(format1.format(payCounter-payNow));
            switch (i) {
                case 0:
                    if (car.getAmount() != 0) {
                        lbCar.setIcon(car.getCarIcon());
                        lbName.setText(car.getName());
                        lbTypeCar.setText(car.getTypeCar());
                        lbSeat.setText(String.valueOf(car.getSeat()) + " Asientos");
                        if (car.getSmall() > 1) {
                            lbSmall.setText(String.valueOf(car.getSmall()) + " Maletas Pequeñas");
                        } else {
                            lbSmall.setText(String.valueOf(car.getSmall()) + " Maleta Pequeña");
                        }
                        if (car.getLarge() > 1) {
                            lbLarge.setText(String.valueOf(car.getLarge()) + " Maletas Grandes");
                        } else {
                            lbLarge.setText(String.valueOf(car.getLarge()) + " Maleta Grande");
                        }
                        lbDoor.setText(String.valueOf(car.getDoor()) + " Puertas");
                        lbGas.setText(String.valueOf(car.getGas()) + " KPL");
                        lbType.setText(car.getType());

                        lbSeat.setIcon(car.getSeatIcon());
                        lbSmall.setIcon(car.getSmallIcon());
                        lbDoor.setIcon(car.getDoorIcon());
                        lbGas.setIcon(car.getGasIcon());
                        lbLarge.setIcon(car.getLargeIcon());
                        lbType.setIcon(car.getTypeIcon());

                        lbPriceCounter.setText("$" + pC);
                        lbPriceNow.setText("$" + pN);
                        txtDifference.setText("Paga ahora y ahorra $" + pD);
                        panelRound2.add(car0);
                    }
                    break;
                case 1:
                    if (car.getAmount() != 0) {
                        lbCar1.setIcon(car.getCarIcon());
                        lbName1.setText(car.getName());
                        lbTypeCar1.setText(car.getTypeCar());
                        lbSeat1.setText(String.valueOf(car.getSeat()) + " Asientos");
                        if (car.getSmall() > 1) {
                            lbSmall1.setText(String.valueOf(car.getSmall()) + " Maletas Pequeñas");
                        } else {
                            lbSmall1.setText(String.valueOf(car.getSmall()) + " Maleta Pequeña");
                        }
                        if (car.getLarge() > 1) {
                            lbLarge1.setText(String.valueOf(car.getLarge()) + " Maletas Grandes");
                        } else {
                            lbLarge1.setText(String.valueOf(car.getLarge()) + " Maleta Grande");
                        }
                        lbDoor1.setText(String.valueOf(car.getDoor()) + " Puertas");
                        lbGas1.setText(String.valueOf(car.getGas()) + " KPL");
                        lbType1.setText(car.getType());

                        lbSeat1.setIcon(car.getSeatIcon());
                        lbSmall1.setIcon(car.getSmallIcon());
                        lbDoor1.setIcon(car.getDoorIcon());
                        lbGas1.setIcon(car.getGasIcon());
                        lbLarge1.setIcon(car.getLargeIcon());
                        lbType1.setIcon(car.getTypeIcon());

                        lbPriceCounter1.setText("$" + pC);
                        lbPriceNow1.setText("$" + pN);
                        txtDifference1.setText("Paga ahora y ahorra $" + pD);
                        panelRound2.add(car1);
                    }
                    break;
                case 2:
                    if (car.getAmount() != 0) {
                        lbCar2.setIcon(car.getCarIcon());
                        lbName2.setText(car.getName());
                        lbTypeCar2.setText(car.getTypeCar());
                        lbSeat2.setText(String.valueOf(car.getSeat()) + " Asientos");
                        if (car.getSmall() > 1) {
                            lbSmall2.setText(String.valueOf(car.getSmall()) + " Maletas Pequeñas");
                        } else {
                            lbSmall2.setText(String.valueOf(car.getSmall()) + " Maleta Pequeña");
                        }
                        if (car.getLarge() > 1) {
                            lbLarge2.setText(String.valueOf(car.getLarge()) + " Maletas Grandes");
                        } else {
                            lbLarge2.setText(String.valueOf(car.getLarge()) + " Maleta Grande");
                        }
                        lbDoor2.setText(String.valueOf(car.getDoor()) + " Puertas");
                        lbGas2.setText(String.valueOf(car.getGas()) + " KPL");
                        lbType2.setText(car.getType());

                        lbSeat2.setIcon(car.getSeatIcon());
                        lbSmall2.setIcon(car.getSmallIcon());
                        lbDoor2.setIcon(car.getDoorIcon());
                        lbGas2.setIcon(car.getGasIcon());
                        lbLarge2.setIcon(car.getLargeIcon());
                        lbType2.setIcon(car.getTypeIcon());

                        lbPriceCounter2.setText("$" + pC);
                        lbPriceNow2.setText("$" + pN);
                        txtDifference2.setText("Paga ahora y ahorra $" + pD);
                        panelRound2.add(car2);
                    }
                    break;
                case 3:
                    if (car.getAmount() != 0) {
                        lbCar3.setIcon(car.getCarIcon());
                        lbCar3.setIcon(car.getCarIcon());
                        lbName3.setText(car.getName());
                        lbTypeCar3.setText(car.getTypeCar());
                        lbSeat3.setText(String.valueOf(car.getSeat()) + " Asientos");
                        if (car.getSmall() > 1) {
                            lbSmall3.setText(String.valueOf(car.getSmall()) + " Maletas Pequeñas");
                        } else {
                            lbSmall3.setText(String.valueOf(car.getSmall()) + " Maleta Pequeña");
                        }
                        if (car.getLarge() > 1) {
                            lbLarge3.setText(String.valueOf(car.getLarge()) + " Maletas Grandes");
                        } else {
                            lbLarge3.setText(String.valueOf(car.getLarge()) + " Maleta Grande");
                        }
                        lbDoor3.setText(String.valueOf(car.getDoor()) + " Puertas");
                        lbGas3.setText(String.valueOf(car.getGas()) + " KPL");
                        lbType3.setText(car.getType());

                        lbSeat3.setIcon(car.getSeatIcon());
                        lbSmall3.setIcon(car.getSmallIcon());
                        lbDoor3.setIcon(car.getDoorIcon());
                        lbGas3.setIcon(car.getGasIcon());
                        lbLarge3.setIcon(car.getLargeIcon());
                        lbType3.setIcon(car.getTypeIcon());

                        lbPriceCounter3.setText("$" + pC);
                        lbPriceNow3.setText("$" + pN);
                        txtDifference3.setText("Paga ahora y ahorra $" + pD);
                        panelRound2.add(car3);
                    }
                    break;
                case 4:
                    if (car.getAmount() != 0) {
                        lbCar4.setIcon(car.getCarIcon());
                        lbName4.setText(car.getName());
                        lbTypeCar4.setText(car.getTypeCar());
                        lbSeat4.setText(String.valueOf(car.getSeat()) + " Asientos");
                        if (car.getSmall() > 1) {
                            lbSmall4.setText(String.valueOf(car.getSmall()) + " Maletas Pequeñas");
                        } else {
                            lbSmall4.setText(String.valueOf(car.getSmall()) + " Maleta Pequeña");
                        }
                        if (car.getLarge() > 1) {
                            lbLarge4.setText(String.valueOf(car.getLarge()) + " Maletas Grandes");
                        } else {
                            lbLarge4.setText(String.valueOf(car.getLarge()) + " Maleta Grande");
                        }
                        lbDoor4.setText(String.valueOf(car.getDoor()) + " Puertas");
                        lbGas4.setText(String.valueOf(car.getGas()) + " KPL");
                        lbType4.setText(car.getType());

                        lbSeat4.setIcon(car.getSeatIcon());
                        lbSmall4.setIcon(car.getSmallIcon());
                        lbDoor4.setIcon(car.getDoorIcon());
                        lbGas4.setIcon(car.getGasIcon());
                        lbLarge4.setIcon(car.getLargeIcon());
                        lbType4.setIcon(car.getTypeIcon());

                        lbPriceCounter4.setText("$" + pC);
                        lbPriceNow4.setText("$" + pN);
                        txtDifference4.setText("Paga ahora y ahorra $" +pD);
                        panelRound2.add(car4);
                    }
                    break;
                case 5:
                    if (car.getAmount() != 0) {
                        lbCar5.setIcon(car.getCarIcon());
                        lbName5.setText(car.getName());
                        lbTypeCar5.setText(car.getTypeCar());
                        lbSeat5.setText(String.valueOf(car.getSeat()) + " Asientos");
                        if (car.getSmall() > 1) {
                            lbSmall5.setText(String.valueOf(car.getSmall()) + " Maletas Pequeñas");
                        } else {
                            lbSmall5.setText(String.valueOf(car.getSmall()) + " Maleta Pequeña");
                        }
                        if (car.getLarge() > 1) {
                            lbLarge5.setText(String.valueOf(car.getLarge()) + " Maletas Grandes");
                        } else {
                            lbLarge5.setText(String.valueOf(car.getLarge()) + " Maleta Grande");
                        }
                        lbDoor5.setText(String.valueOf(car.getDoor()) + " Puertas");
                        lbGas5.setText(String.valueOf(car.getGas()) + " KPL");
                        lbType5.setText(car.getType());

                        lbSeat5.setIcon(car.getSeatIcon());
                        lbSmall5.setIcon(car.getSmallIcon());
                        lbDoor5.setIcon(car.getDoorIcon());
                        lbGas5.setIcon(car.getGasIcon());
                        lbLarge5.setIcon(car.getLargeIcon());
                        lbType5.setIcon(car.getTypeIcon());

                        lbPriceCounter5.setText("$" + pC);
                        lbPriceNow5.setText("$" + pN);
                        txtDifference5.setText("Paga ahora y ahorra $" + pD);
                        panelRound2.add(car5);
                    }
                    break;
                case 6:
                    if (car.getAmount() != 0) {
                        lbCar6.setIcon(car.getCarIcon());
                        lbName6.setText(car.getName());
                        lbTypeCar6.setText(car.getTypeCar());
                        lbSeat6.setText(String.valueOf(car.getSeat()) + " Asientos");
                        if (car.getSmall() > 1) {
                            lbSmall6.setText(String.valueOf(car.getSmall()) + " Maletas Pequeñas");
                        } else {
                            lbSmall6.setText(String.valueOf(car.getSmall()) + " Maleta Pequeña");
                        }
                        if (car.getLarge() > 1) {
                            lbLarge6.setText(String.valueOf(car.getLarge()) + " Maletas Grandes");
                        } else {
                            lbLarge6.setText(String.valueOf(car.getLarge()) + " Maleta Grande");
                        }
                        lbDoor6.setText(String.valueOf(car.getDoor()) + " Puertas");
                        lbGas6.setText(String.valueOf(car.getGas()) + " KPL");
                        lbType6.setText(car.getType());

                        lbSeat6.setIcon(car.getSeatIcon());
                        lbSmall6.setIcon(car.getSmallIcon());
                        lbDoor6.setIcon(car.getDoorIcon());
                        lbGas6.setIcon(car.getGasIcon());
                        lbLarge6.setIcon(car.getLargeIcon());
                        lbType6.setIcon(car.getTypeIcon());

                        lbPriceCounter6.setText("$" + String.valueOf(car.getPriceCounter()));
                        lbPriceNow6.setText("$" + String.valueOf(car.getPriceNow()));
                        txtDifference6.setText("Paga ahora y ahorra $" + String.valueOf(car.getDifference()));
                        panelRound2.add(car6);
                    }
                    break;
                case 7:
                    if (car.getAmount() != 0) {
                        lbCar7.setIcon(car.getCarIcon());
                        lbName7.setText(car.getName());
                        lbTypeCar7.setText(car.getTypeCar());
                        lbSeat7.setText(String.valueOf(car.getSeat()) + " Asientos");
                        if (car.getSmall() > 1) {
                            lbSmall7.setText(String.valueOf(car.getSmall()) + " Maletas Pequeñas");
                        } else {
                            lbSmall7.setText(String.valueOf(car.getSmall()) + " Maleta Pequeña");
                        }
                        if (car.getLarge() > 1) {
                            lbLarge7.setText(String.valueOf(car.getLarge()) + " Maletas Grandes");
                        } else {
                            lbLarge7.setText(String.valueOf(car.getLarge()) + " Maleta Grande");
                        }
                        lbDoor7.setText(String.valueOf(car.getDoor()) + " Puertas");
                        lbGas7.setText(String.valueOf(car.getGas()) + " KPL");
                        lbType7.setText(car.getType());

                        lbSeat7.setIcon(car.getSeatIcon());
                        lbSmall7.setIcon(car.getSmallIcon());
                        lbDoor7.setIcon(car.getDoorIcon());
                        lbGas7.setIcon(car.getGasIcon());
                        lbLarge7.setIcon(car.getLargeIcon());
                        lbType7.setIcon(car.getTypeIcon());

                        lbPriceCounter7.setText("$" + pC);
                        lbPriceNow7.setText("$" + pN);
                        txtDifference7.setText("Paga ahora y ahorra $" + pD);
                        panelRound2.add(car7);
                    }
                    break;
                case 8:
                    if (car.getAmount() != 0) {
                        lbCar8.setIcon(car.getCarIcon());
                        lbName8.setText(car.getName());
                        lbTypeCar8.setText(car.getTypeCar());
                        lbSeat8.setText(String.valueOf(car.getSeat()) + " Asientos");
                        if (car.getSmall() > 1) {
                            lbSmall8.setText(String.valueOf(car.getSmall()) + " Maletas Pequeñas");
                        } else {
                            lbSmall8.setText(String.valueOf(car.getSmall()) + " Maleta Pequeña");
                        }
                        if (car.getLarge() > 1) {
                            lbLarge8.setText(String.valueOf(car.getLarge()) + " Maletas Grandes");
                        } else {
                            lbLarge8.setText(String.valueOf(car.getLarge()) + " Maleta Grande");
                        }
                        lbDoor8.setText(String.valueOf(car.getDoor()) + " Puertas");
                        lbGas8.setText(String.valueOf(car.getGas()) + " KPL");
                        lbType8.setText(car.getType());

                        lbSeat8.setIcon(car.getSeatIcon());
                        lbSmall8.setIcon(car.getSmallIcon());
                        lbDoor8.setIcon(car.getDoorIcon());
                        lbGas8.setIcon(car.getGasIcon());
                        lbLarge8.setIcon(car.getLargeIcon());
                        lbType8.setIcon(car.getTypeIcon());

                        lbPriceCounter6.setText("$" + pC);
                        lbPriceNow6.setText("$" + pN);
                        txtDifference6.setText("Paga ahora y ahorra $" + pD);
                        panelRound2.add(car8);
                    }
                    break;
                case 9:
                    if (car.getAmount() != 0) {
                        lbCar9.setIcon(car.getCarIcon());
                        lbName9.setText(car.getName());
                        lbTypeCar9.setText(car.getTypeCar());
                        lbSeat9.setText(String.valueOf(car.getSeat()) + " Asientos");
                        if (car.getSmall() > 1) {
                            lbSmall9.setText(String.valueOf(car.getSmall()) + " Maletas Pequeñas");
                        } else {
                            lbSmall9.setText(String.valueOf(car.getSmall()) + " Maleta Pequeña");
                        }
                        if (car.getLarge() > 1) {
                            lbLarge9.setText(String.valueOf(car.getLarge()) + " Maletas Grandes");
                        } else {
                            lbLarge9.setText(String.valueOf(car.getLarge()) + " Maleta Grande");
                        }
                        lbDoor9.setText(String.valueOf(car.getDoor()) + " Puertas");
                        lbGas9.setText(String.valueOf(car.getGas()) + " KPL");
                        lbType9.setText(car.getType());

                        lbSeat9.setIcon(car.getSeatIcon());
                        lbSmall9.setIcon(car.getSmallIcon());
                        lbDoor9.setIcon(car.getDoorIcon());
                        lbGas9.setIcon(car.getGasIcon());
                        lbLarge9.setIcon(car.getLargeIcon());
                        lbType9.setIcon(car.getTypeIcon());

                        lbPriceCounter9.setText("$" + pC);
                        lbPriceNow9.setText("$" + pN);
                        txtDifference9.setText("Paga ahora y ahorra $" + pD);
                        panelRound2.add(car9);
                    }
                    break;
                case 10:
                    if (car.getAmount() != 0) {
                        lbCar10.setIcon(car.getCarIcon());
                        lbName10.setText(car.getName());
                        lbTypeCar10.setText(car.getTypeCar());
                        lbSeat10.setText(String.valueOf(car.getSeat()) + " Asientos");
                        if (car.getSmall() > 1) {
                            lbSmall10.setText(String.valueOf(car.getSmall()) + " Maletas Pequeñas");
                        } else {
                            lbSmall10.setText(String.valueOf(car.getSmall()) + " Maleta Pequeña");
                        }
                        if (car.getLarge() > 1) {
                            lbLarge10.setText(String.valueOf(car.getLarge()) + " Maletas Grandes");
                        } else {
                            lbLarge10.setText(String.valueOf(car.getLarge()) + " Maleta Grande");
                        }
                        lbDoor10.setText(String.valueOf(car.getDoor()) + " Puertas");
                        lbGas10.setText(String.valueOf(car.getGas()) + " KPL");
                        lbType10.setText(car.getType());

                        lbSeat10.setIcon(car.getSeatIcon());
                        lbSmall10.setIcon(car.getSmallIcon());
                        lbDoor10.setIcon(car.getDoorIcon());
                        lbGas10.setIcon(car.getGasIcon());
                        lbLarge10.setIcon(car.getLargeIcon());
                        lbType10.setIcon(car.getTypeIcon());

                        lbPriceCounter10.setText("$" + pC);
                        lbPriceNow10.setText("$" + pN);
                        txtDifference10.setText("Paga ahora y ahorra $" + pD);
                        panelRound2.add(car10);
                    }
                    break;
                case 11:
                    if (car.getAmount() != 0) {
                        lbCar11.setIcon(car.getCarIcon());
                        lbName11.setText(car.getName());
                        lbTypeCar11.setText(car.getTypeCar());
                        lbSeat11.setText(String.valueOf(car.getSeat()) + " Asientos");
                        if (car.getSmall() > 1) {
                            lbSmall11.setText(String.valueOf(car.getSmall()) + " Maletas Pequeñas");
                        } else {
                            lbSmall11.setText(String.valueOf(car.getSmall()) + " Maleta Pequeña");
                        }
                        if (car.getLarge() > 1) {
                            lbLarge11.setText(String.valueOf(car.getLarge()) + " Maletas Grandes");
                        } else {
                            lbLarge11.setText(String.valueOf(car.getLarge()) + " Maleta Grande");
                        }
                        lbDoor11.setText(String.valueOf(car.getDoor()) + " Puertas");
                        lbGas11.setText(String.valueOf(car.getGas()) + " KPL");
                        lbType11.setText(car.getType());

                        lbSeat11.setIcon(car.getSeatIcon());
                        lbSmall11.setIcon(car.getSmallIcon());
                        lbDoor11.setIcon(car.getDoorIcon());
                        lbGas11.setIcon(car.getGasIcon());
                        lbLarge11.setIcon(car.getLargeIcon());
                        lbType11.setIcon(car.getTypeIcon());

                        lbPriceCounter11.setText("$" + pC);
                        lbPriceNow11.setText("$" + pN);
                        txtDifference11.setText("Paga ahora y ahorra $" + pD);
                        panelRound2.add(car11);
                    }
                    break;
                case 12:
                    if (car.getAmount() != 0) {
                        lbCar12.setIcon(car.getCarIcon());
                        lbName12.setText(car.getName());
                        lbTypeCar12.setText(car.getTypeCar());
                        lbSeat12.setText(String.valueOf(car.getSeat()) + " Asientos");
                        if (car.getSmall() > 1) {
                            lbSmall12.setText(String.valueOf(car.getSmall()) + " Maletas Pequeñas");
                        } else {
                            lbSmall12.setText(String.valueOf(car.getSmall()) + " Maleta Pequeña");
                        }
                        if (car.getLarge() > 1) {
                            lbLarge12.setText(String.valueOf(car.getLarge()) + " Maletas Grandes");
                        } else {
                            lbLarge12.setText(String.valueOf(car.getLarge()) + " Maleta Grande");
                        }
                        lbDoor12.setText(String.valueOf(car.getDoor()) + " Puertas");
                        lbGas12.setText(String.valueOf(car.getGas()) + " KPL");
                        lbType12.setText(car.getType());

                        lbSeat12.setIcon(car.getSeatIcon());
                        lbSmall12.setIcon(car.getSmallIcon());
                        lbDoor12.setIcon(car.getDoorIcon());
                        lbGas12.setIcon(car.getGasIcon());
                        lbLarge12.setIcon(car.getLargeIcon());
                        lbType12.setIcon(car.getTypeIcon());

                        lbPriceCounter12.setText("$" + pC);
                        lbPriceNow12.setText("$" + pN);
                        txtDifference12.setText("Paga ahora y ahorra $" + pD);
                        panelRound2.add(car12);
                    }
                    break;
                case 13:
                    if (car.getAmount() != 0) {
                        lbCar13.setIcon(car.getCarIcon());
                        lbName13.setText(car.getName());
                        lbTypeCar13.setText(car.getTypeCar());
                        lbSeat13.setText(String.valueOf(car.getSeat()) + " Asientos");
                        if (car.getSmall() > 1) {
                            lbSmall13.setText(String.valueOf(car.getSmall()) + " Maletas Pequeñas");
                        } else {
                            lbSmall13.setText(String.valueOf(car.getSmall()) + " Maleta Pequeña");
                        }
                        if (car.getLarge() > 1) {
                            lbLarge13.setText(String.valueOf(car.getLarge()) + " Maletas Grandes");
                        } else {
                            lbLarge13.setText(String.valueOf(car.getLarge()) + " Maleta Grande");
                        }
                        lbDoor13.setText(String.valueOf(car.getDoor()) + " Puertas");
                        lbGas13.setText(String.valueOf(car.getGas()) + " KPL");
                        lbType13.setText(car.getType());

                        lbSeat13.setIcon(car.getSeatIcon());
                        lbSmall13.setIcon(car.getSmallIcon());
                        lbDoor13.setIcon(car.getDoorIcon());
                        lbGas13.setIcon(car.getGasIcon());
                        lbLarge13.setIcon(car.getLargeIcon());
                        lbType13.setIcon(car.getTypeIcon());

                        lbPriceCounter13.setText("$" + pC);
                        lbPriceNow13.setText("$" + pN);
                        txtDifference13.setText("Paga ahora y ahorra $" + pD);
                        panelRound2.add(car13);
                    }
                    break;
                case 14:
                    if (car.getAmount() != 0) {
                        lbCar14.setIcon(car.getCarIcon());
                        lbName14.setText(car.getName());
                        lbTypeCar14.setText(car.getTypeCar());
                        lbSeat14.setText(String.valueOf(car.getSeat()) + " Asientos");
                        if (car.getSmall() > 1) {
                            lbSmall14.setText(String.valueOf(car.getSmall()) + " Maletas Pequeñas");
                        } else {
                            lbSmall14.setText(String.valueOf(car.getSmall()) + " Maleta Pequeña");
                        }
                        if (car.getLarge() > 1) {
                            lbLarge14.setText(String.valueOf(car.getLarge()) + " Maletas Grandes");
                        } else {
                            lbLarge14.setText(String.valueOf(car.getLarge()) + " Maleta Grande");
                        }
                        lbDoor14.setText(String.valueOf(car.getDoor()) + " Puertas");
                        lbGas14.setText(String.valueOf(car.getGas()) + " KPL");
                        lbType14.setText(car.getType());

                        lbSeat14.setIcon(car.getSeatIcon());
                        lbSmall14.setIcon(car.getSmallIcon());
                        lbDoor14.setIcon(car.getDoorIcon());
                        lbGas14.setIcon(car.getGasIcon());
                        lbLarge14.setIcon(car.getLargeIcon());
                        lbType14.setIcon(car.getTypeIcon());

                        lbPriceCounter14.setText("$" + pC);
                        lbPriceNow14.setText("$" + pN);
                        txtDifference14.setText("Paga ahora y ahorra $" + pD);
                        panelRound2.add(car14);
                    }
                    break;
                case 15:
                    if (car.getAmount() != 0) {
                        lbCar15.setIcon(car.getCarIcon());
                        lbName15.setText(car.getName());
                        lbTypeCar15.setText(car.getTypeCar());
                        lbSeat15.setText(String.valueOf(car.getSeat()) + " Asientos");
                        if (car.getSmall() > 1) {
                            lbSmall15.setText(String.valueOf(car.getSmall()) + " Maletas Pequeñas");
                        } else {
                            lbSmall15.setText(String.valueOf(car.getSmall()) + " Maleta Pequeña");
                        }
                        if (car.getLarge() > 1) {
                            lbLarge15.setText(String.valueOf(car.getLarge()) + " Maletas Grandes");
                        } else {
                            lbLarge15.setText(String.valueOf(car.getLarge()) + " Maleta Grande");
                        }
                        lbDoor15.setText(String.valueOf(car.getDoor()) + " Puertas");
                        lbGas15.setText(String.valueOf(car.getGas()) + " KPL");
                        lbType15.setText(car.getType());

                        lbSeat15.setIcon(car.getSeatIcon());
                        lbSmall15.setIcon(car.getSmallIcon());
                        lbDoor15.setIcon(car.getDoorIcon());
                        lbGas15.setIcon(car.getGasIcon());
                        lbLarge15.setIcon(car.getLargeIcon());
                        lbType15.setIcon(car.getTypeIcon());

                        lbPriceCounter15.setText("$" + pC);
                        lbPriceNow15.setText("$" + pN);
                        txtDifference15.setText("Paga ahora y ahorra $" + pD);
                        panelRound2.add(car15);
                    }
                    break;
                case 16:
                    if (car.getAmount() != 0) {
                        lbCar16.setIcon(car.getCarIcon());
                        lbName16.setText(car.getName());
                        lbTypeCar16.setText(car.getTypeCar());
                        lbSeat16.setText(String.valueOf(car.getSeat()) + " Asientos");
                        if (car.getSmall() > 1) {
                            lbSmall16.setText(String.valueOf(car.getSmall()) + " Maletas Pequeñas");
                        } else {
                            lbSmall16.setText(String.valueOf(car.getSmall()) + " Maleta Pequeña");
                        }
                        if (car.getLarge() > 1) {
                            lbLarge16.setText(String.valueOf(car.getLarge()) + " Maletas Grandes");
                        } else {
                            lbLarge16.setText(String.valueOf(car.getLarge()) + " Maleta Grande");
                        }
                        lbDoor16.setText(String.valueOf(car.getDoor()) + " Puertas");
                        lbGas16.setText(String.valueOf(car.getGas()) + " KPL");
                        lbType16.setText(car.getType());

                        lbSeat16.setIcon(car.getSeatIcon());
                        lbSmall16.setIcon(car.getSmallIcon());
                        lbDoor16.setIcon(car.getDoorIcon());
                        lbGas16.setIcon(car.getGasIcon());
                        lbLarge16.setIcon(car.getLargeIcon());
                        lbType16.setIcon(car.getTypeIcon());

                        lbPriceCounter16.setText("$" + pC);
                        lbPriceNow16.setText("$" + pN);
                        txtDifference16.setText("Paga ahora y ahorra $" + pD);
                        panelRound12.add(car16);
                    }
                    break;
                case 17:
                    if (car.getAmount() != 0) {
                        lbCar17.setIcon(car.getCarIcon());
                        lbName17.setText(car.getName());
                        lbTypeCar17.setText(car.getTypeCar());
                        lbSeat17.setText(String.valueOf(car.getSeat()) + " Asientos");
                        if (car.getSmall() > 1) {
                            lbSmall17.setText(String.valueOf(car.getSmall()) + " Maletas Pequeñas");
                        } else {
                            lbSmall17.setText(String.valueOf(car.getSmall()) + " Maleta Pequeña");
                        }
                        if (car.getLarge() > 1) {
                            lbLarge17.setText(String.valueOf(car.getLarge()) + " Maletas Grandes");
                        } else {
                            lbLarge17.setText(String.valueOf(car.getLarge()) + " Maleta Grande");
                        }
                        lbDoor17.setText(String.valueOf(car.getDoor()) + " Puertas");
                        lbGas17.setText(String.valueOf(car.getGas()) + " KPL");
                        lbType17.setText(car.getType());

                        lbSeat17.setIcon(car.getSeatIcon());
                        lbSmall17.setIcon(car.getSmallIcon());
                        lbDoor17.setIcon(car.getDoorIcon());
                        lbGas17.setIcon(car.getGasIcon());
                        lbLarge17.setIcon(car.getLargeIcon());
                        lbType17.setIcon(car.getTypeIcon());

                        lbPriceCounter17.setText("$" + pC);
                        lbPriceNow17.setText("$" + pN);
                        txtDifference17.setText("Paga ahora y ahorra $" + pD);
                        panelRound2.add(car17);
                    }
                    break;
                case 18:
                    if (car.getAmount() != 0) {
                        lbCar18.setIcon(car.getCarIcon());
                        lbName18.setText(car.getName());
                        lbTypeCar18.setText(car.getTypeCar());
                        lbSeat18.setText(String.valueOf(car.getSeat()) + " Asientos");
                        if (car.getSmall() > 1) {
                            lbSmall18.setText(String.valueOf(car.getSmall()) + " Maletas Pequeñas");
                        } else {
                            lbSmall18.setText(String.valueOf(car.getSmall()) + " Maleta Pequeña");
                        }
                        if (car.getLarge() > 1) {
                            lbLarge18.setText(String.valueOf(car.getLarge()) + " Maletas Grandes");
                        } else {
                            lbLarge18.setText(String.valueOf(car.getLarge()) + " Maleta Grande");
                        }
                        lbDoor18.setText(String.valueOf(car.getDoor()) + " Puertas");
                        lbGas18.setText(String.valueOf(car.getGas()) + " KPL");
                        lbType18.setText(car.getType());

                        lbSeat18.setIcon(car.getSeatIcon());
                        lbSmall18.setIcon(car.getSmallIcon());
                        lbDoor18.setIcon(car.getDoorIcon());
                        lbGas18.setIcon(car.getGasIcon());
                        lbLarge18.setIcon(car.getLargeIcon());
                        lbType18.setIcon(car.getTypeIcon());

                        lbPriceCounter18.setText("$" + pC);
                        lbPriceNow18.setText("$" + pN);
                        txtDifference18.setText("Paga ahora y ahorra $" + pD);
                        panelRound2.add(car18);
                    }
                    break;
            }
        }

    }

    public ArrayList<ModelCar> carList(String selection, String order) {
        ArrayList<ModelCar> carList = new ArrayList<>();
        String sql = "";
        if (selection.equals("Todos")) {
            sql = "SELECT imagen, tipo, vehiculos, mostrador_costo, prepago_costo, asientos, maletasp, puertas,\n"
                    + " gasolina, maletasg, tipo_manejo, disponibilidad FROM vehiculo a INNER JOIN tipo_vehiculo b\n"
                    + " ON a.id_tipo = b.id_tipo";
        } else if (!selection.equals("")) {
            sql = "SELECT imagen, tipo, vehiculos, mostrador_costo, prepago_costo, asientos, maletasp, puertas,\n"
                    + " gasolina, maletasg, tipo_manejo, disponibilidad FROM vehiculo a INNER JOIN tipo_vehiculo b\n"
                    + " ON a.id_tipo = b.id_tipo WHERE b.tipo='" + selection + "'";
        } else {
            sql = "SELECT imagen, tipo, vehiculos, mostrador_costo, prepago_costo, asientos, maletasp, puertas,\n"
                    + " gasolina, maletasg, tipo_manejo, disponibilidad FROM vehiculo a INNER JOIN tipo_vehiculo b\n"
                    + " ON a.id_tipo = b.id_tipo";
        }

        if (order.equals("Precio (Menor a Mayor)")) {
            sql = sql + " ORDER BY b.mostrador_costo ASC";
        } else if (order.equals("Alfabeticamente")) {
            sql = sql + " ORDER BY a.vehiculos ASC";
        } else if (order.equals("Kilometraje (Mayor a Menor)")) {
            sql = sql + " ORDER BY b.gasolina DESC";
        } else if (order.equals("Numero de Asientos")) {
            sql = sql + " ORDER BY b.asientos DESC";
        }

        try {
            PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet r = p.executeQuery();
            ModelCar car;
            while (r.next()) {
                Icon carIcon = new ImageIcon(r.getBytes("imagen"));
                String typeCar = r.getString("tipo");
                String carName = r.getString("vehiculos");
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

                car = new ModelCar(carIcon, typeCar, carName, priceCounter, priceNow, seats, small, doors, gas, large, drive, amount,
                        new ImageIcon(getClass().getResource("/icon/dashboard/seat.png")),
                        new ImageIcon(getClass().getResource("/icon/dashboard/lugage_small.png")),
                        new ImageIcon(getClass().getResource("/icon/dashboard/door.png")),
                        new ImageIcon(getClass().getResource("/icon/dashboard/gas.png")),
                        new ImageIcon(getClass().getResource("/icon/dashboard/lugage_big.png")),
                        new ImageIcon(getClass().getResource("/icon/dashboard/drive.png")),
                        difference);
                carList.add(car);
            }
            r.close();
            p.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return carList;
    }

    public void clear() {
        car0.setBackground(Color.WHITE);
        car1.setBackground(Color.WHITE);
        car2.setBackground(Color.WHITE);
        car3.setBackground(Color.WHITE);
        car4.setBackground(Color.WHITE);
        car5.setBackground(Color.WHITE);
        car6.setBackground(Color.WHITE);
        car7.setBackground(Color.WHITE);
        car8.setBackground(Color.WHITE);
        car9.setBackground(Color.WHITE);
        car10.setBackground(Color.WHITE);
        car11.setBackground(Color.WHITE);
        car12.setBackground(Color.WHITE);
        car13.setBackground(Color.WHITE);
        car14.setBackground(Color.WHITE);
        car15.setBackground(Color.WHITE);
        car16.setBackground(Color.WHITE);
        car17.setBackground(Color.WHITE);
        car18.setBackground(Color.WHITE);
        setCarSelected("");
    }

    public String carSelected;
    public String typeRent;

    public void addEventContinue(ActionListener event) {
        buttonContinue.addActionListener(event);
    }
    
    public void addEventBack(ActionListener event) {
        buttonBack.addActionListener(event);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContinue = new javax.swing.JPanel();
        buttonContinue = new swing.login.Button();
        jLabel2 = new javax.swing.JLabel();
        car0 = new javax.swing.JPanel();
        lbCar = new javax.swing.JLabel();
        lbTypeCar = new javax.swing.JLabel();
        lbPriceCounter = new javax.swing.JLabel();
        lbPriceNow = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        panelRound11 = new swing.login.PanelRound1();
        lbDoor = new javax.swing.JLabel();
        lbSeat = new javax.swing.JLabel();
        lbType = new javax.swing.JLabel();
        lbGas = new javax.swing.JLabel();
        lbSmall = new javax.swing.JLabel();
        lbLarge = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDifference = new javax.swing.JLabel();
        buttonCounter = new swing.login.Button1();
        buttonNow = new swing.login.Button1();
        car1 = new javax.swing.JPanel();
        lbCar1 = new javax.swing.JLabel();
        lbTypeCar1 = new javax.swing.JLabel();
        lbPriceCounter1 = new javax.swing.JLabel();
        lbPriceNow1 = new javax.swing.JLabel();
        lbName1 = new javax.swing.JLabel();
        panelRound12 = new swing.login.PanelRound1();
        lbDoor1 = new javax.swing.JLabel();
        lbSeat1 = new javax.swing.JLabel();
        lbType1 = new javax.swing.JLabel();
        lbGas1 = new javax.swing.JLabel();
        lbSmall1 = new javax.swing.JLabel();
        lbLarge1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDifference1 = new javax.swing.JLabel();
        buttonCounter1 = new swing.login.Button1();
        buttonNow1 = new swing.login.Button1();
        car3 = new javax.swing.JPanel();
        lbCar3 = new javax.swing.JLabel();
        lbTypeCar3 = new javax.swing.JLabel();
        lbPriceCounter3 = new javax.swing.JLabel();
        lbPriceNow3 = new javax.swing.JLabel();
        lbName3 = new javax.swing.JLabel();
        panelRound14 = new swing.login.PanelRound1();
        lbDoor3 = new javax.swing.JLabel();
        lbSeat3 = new javax.swing.JLabel();
        lbType3 = new javax.swing.JLabel();
        lbGas3 = new javax.swing.JLabel();
        lbSmall3 = new javax.swing.JLabel();
        lbLarge3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtDifference3 = new javax.swing.JLabel();
        buttonCounter3 = new swing.login.Button1();
        buttonNow3 = new swing.login.Button1();
        car4 = new javax.swing.JPanel();
        lbCar4 = new javax.swing.JLabel();
        lbTypeCar4 = new javax.swing.JLabel();
        lbPriceCounter4 = new javax.swing.JLabel();
        lbPriceNow4 = new javax.swing.JLabel();
        lbName4 = new javax.swing.JLabel();
        panelRound15 = new swing.login.PanelRound1();
        lbDoor4 = new javax.swing.JLabel();
        lbSeat4 = new javax.swing.JLabel();
        lbType4 = new javax.swing.JLabel();
        lbGas4 = new javax.swing.JLabel();
        lbSmall4 = new javax.swing.JLabel();
        lbLarge4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtDifference4 = new javax.swing.JLabel();
        buttonCounter4 = new swing.login.Button1();
        buttonNow4 = new swing.login.Button1();
        car5 = new javax.swing.JPanel();
        lbCar5 = new javax.swing.JLabel();
        lbTypeCar5 = new javax.swing.JLabel();
        lbPriceCounter5 = new javax.swing.JLabel();
        lbPriceNow5 = new javax.swing.JLabel();
        lbName5 = new javax.swing.JLabel();
        panelRound16 = new swing.login.PanelRound1();
        lbDoor5 = new javax.swing.JLabel();
        lbSeat5 = new javax.swing.JLabel();
        lbType5 = new javax.swing.JLabel();
        lbGas5 = new javax.swing.JLabel();
        lbSmall5 = new javax.swing.JLabel();
        lbLarge5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtDifference5 = new javax.swing.JLabel();
        buttonCounter5 = new swing.login.Button1();
        buttonNow5 = new swing.login.Button1();
        car6 = new javax.swing.JPanel();
        lbCar6 = new javax.swing.JLabel();
        lbTypeCar6 = new javax.swing.JLabel();
        lbPriceCounter6 = new javax.swing.JLabel();
        lbPriceNow6 = new javax.swing.JLabel();
        lbName6 = new javax.swing.JLabel();
        panelRound17 = new swing.login.PanelRound1();
        lbDoor6 = new javax.swing.JLabel();
        lbSeat6 = new javax.swing.JLabel();
        lbType6 = new javax.swing.JLabel();
        lbGas6 = new javax.swing.JLabel();
        lbSmall6 = new javax.swing.JLabel();
        lbLarge6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtDifference6 = new javax.swing.JLabel();
        buttonCounter6 = new swing.login.Button1();
        buttonNow6 = new swing.login.Button1();
        car7 = new javax.swing.JPanel();
        lbCar7 = new javax.swing.JLabel();
        lbTypeCar7 = new javax.swing.JLabel();
        lbPriceCounter7 = new javax.swing.JLabel();
        lbPriceNow7 = new javax.swing.JLabel();
        lbName7 = new javax.swing.JLabel();
        panelRound18 = new swing.login.PanelRound1();
        lbDoor7 = new javax.swing.JLabel();
        lbSeat7 = new javax.swing.JLabel();
        lbType7 = new javax.swing.JLabel();
        lbGas7 = new javax.swing.JLabel();
        lbSmall7 = new javax.swing.JLabel();
        lbLarge7 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtDifference7 = new javax.swing.JLabel();
        buttonCounter7 = new swing.login.Button1();
        buttonNow7 = new swing.login.Button1();
        car8 = new javax.swing.JPanel();
        lbCar8 = new javax.swing.JLabel();
        lbTypeCar8 = new javax.swing.JLabel();
        lbPriceCounter8 = new javax.swing.JLabel();
        lbPriceNow8 = new javax.swing.JLabel();
        lbName8 = new javax.swing.JLabel();
        panelRound19 = new swing.login.PanelRound1();
        lbDoor8 = new javax.swing.JLabel();
        lbSeat8 = new javax.swing.JLabel();
        lbType8 = new javax.swing.JLabel();
        lbGas8 = new javax.swing.JLabel();
        lbSmall8 = new javax.swing.JLabel();
        lbLarge8 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtDifference8 = new javax.swing.JLabel();
        buttonCounter8 = new swing.login.Button1();
        buttonNow8 = new swing.login.Button1();
        car9 = new javax.swing.JPanel();
        lbCar9 = new javax.swing.JLabel();
        lbTypeCar9 = new javax.swing.JLabel();
        lbPriceCounter9 = new javax.swing.JLabel();
        lbPriceNow9 = new javax.swing.JLabel();
        lbName9 = new javax.swing.JLabel();
        panelRound20 = new swing.login.PanelRound1();
        lbDoor9 = new javax.swing.JLabel();
        lbSeat9 = new javax.swing.JLabel();
        lbType9 = new javax.swing.JLabel();
        lbGas9 = new javax.swing.JLabel();
        lbSmall9 = new javax.swing.JLabel();
        lbLarge9 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtDifference9 = new javax.swing.JLabel();
        buttonCounter9 = new swing.login.Button1();
        buttonNow9 = new swing.login.Button1();
        car10 = new javax.swing.JPanel();
        lbCar10 = new javax.swing.JLabel();
        lbTypeCar10 = new javax.swing.JLabel();
        lbPriceCounter10 = new javax.swing.JLabel();
        lbPriceNow10 = new javax.swing.JLabel();
        lbName10 = new javax.swing.JLabel();
        panelRound21 = new swing.login.PanelRound1();
        lbDoor10 = new javax.swing.JLabel();
        lbSeat10 = new javax.swing.JLabel();
        lbType10 = new javax.swing.JLabel();
        lbGas10 = new javax.swing.JLabel();
        lbSmall10 = new javax.swing.JLabel();
        lbLarge10 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtDifference10 = new javax.swing.JLabel();
        buttonCounter10 = new swing.login.Button1();
        buttonNow10 = new swing.login.Button1();
        car11 = new javax.swing.JPanel();
        lbCar11 = new javax.swing.JLabel();
        lbTypeCar11 = new javax.swing.JLabel();
        lbPriceCounter11 = new javax.swing.JLabel();
        lbPriceNow11 = new javax.swing.JLabel();
        lbName11 = new javax.swing.JLabel();
        panelRound22 = new swing.login.PanelRound1();
        lbDoor11 = new javax.swing.JLabel();
        lbSeat11 = new javax.swing.JLabel();
        lbType11 = new javax.swing.JLabel();
        lbGas11 = new javax.swing.JLabel();
        lbSmall11 = new javax.swing.JLabel();
        lbLarge11 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtDifference11 = new javax.swing.JLabel();
        buttonCounter11 = new swing.login.Button1();
        buttonNow11 = new swing.login.Button1();
        car12 = new javax.swing.JPanel();
        lbCar12 = new javax.swing.JLabel();
        lbTypeCar12 = new javax.swing.JLabel();
        lbPriceCounter12 = new javax.swing.JLabel();
        lbPriceNow12 = new javax.swing.JLabel();
        lbName12 = new javax.swing.JLabel();
        panelRound23 = new swing.login.PanelRound1();
        lbDoor12 = new javax.swing.JLabel();
        lbSeat12 = new javax.swing.JLabel();
        lbType12 = new javax.swing.JLabel();
        lbGas12 = new javax.swing.JLabel();
        lbSmall12 = new javax.swing.JLabel();
        lbLarge12 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtDifference12 = new javax.swing.JLabel();
        buttonCounter12 = new swing.login.Button1();
        buttonNow12 = new swing.login.Button1();
        car13 = new javax.swing.JPanel();
        lbCar13 = new javax.swing.JLabel();
        lbTypeCar13 = new javax.swing.JLabel();
        lbPriceCounter13 = new javax.swing.JLabel();
        lbPriceNow13 = new javax.swing.JLabel();
        lbName13 = new javax.swing.JLabel();
        panelRound24 = new swing.login.PanelRound1();
        lbDoor13 = new javax.swing.JLabel();
        lbSeat13 = new javax.swing.JLabel();
        lbType13 = new javax.swing.JLabel();
        lbGas13 = new javax.swing.JLabel();
        lbSmall13 = new javax.swing.JLabel();
        lbLarge13 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtDifference13 = new javax.swing.JLabel();
        buttonCounter13 = new swing.login.Button1();
        buttonNow13 = new swing.login.Button1();
        car14 = new javax.swing.JPanel();
        lbCar14 = new javax.swing.JLabel();
        lbTypeCar14 = new javax.swing.JLabel();
        lbPriceCounter14 = new javax.swing.JLabel();
        lbPriceNow14 = new javax.swing.JLabel();
        lbName14 = new javax.swing.JLabel();
        panelRound25 = new swing.login.PanelRound1();
        lbDoor14 = new javax.swing.JLabel();
        lbSeat14 = new javax.swing.JLabel();
        lbType14 = new javax.swing.JLabel();
        lbGas14 = new javax.swing.JLabel();
        lbSmall14 = new javax.swing.JLabel();
        lbLarge14 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtDifference14 = new javax.swing.JLabel();
        buttonCounter14 = new swing.login.Button1();
        buttonNow14 = new swing.login.Button1();
        car15 = new javax.swing.JPanel();
        lbCar15 = new javax.swing.JLabel();
        lbTypeCar15 = new javax.swing.JLabel();
        lbPriceCounter15 = new javax.swing.JLabel();
        lbPriceNow15 = new javax.swing.JLabel();
        lbName15 = new javax.swing.JLabel();
        panelRound26 = new swing.login.PanelRound1();
        lbDoor15 = new javax.swing.JLabel();
        lbSeat15 = new javax.swing.JLabel();
        lbType15 = new javax.swing.JLabel();
        lbGas15 = new javax.swing.JLabel();
        lbSmall15 = new javax.swing.JLabel();
        lbLarge15 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtDifference15 = new javax.swing.JLabel();
        buttonCounter15 = new swing.login.Button1();
        buttonNow15 = new swing.login.Button1();
        car16 = new javax.swing.JPanel();
        lbCar16 = new javax.swing.JLabel();
        lbTypeCar16 = new javax.swing.JLabel();
        lbPriceCounter16 = new javax.swing.JLabel();
        lbPriceNow16 = new javax.swing.JLabel();
        lbName16 = new javax.swing.JLabel();
        panelRound27 = new swing.login.PanelRound1();
        lbDoor16 = new javax.swing.JLabel();
        lbSeat16 = new javax.swing.JLabel();
        lbType16 = new javax.swing.JLabel();
        lbGas16 = new javax.swing.JLabel();
        lbSmall16 = new javax.swing.JLabel();
        lbLarge16 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txtDifference16 = new javax.swing.JLabel();
        buttonCounter16 = new swing.login.Button1();
        buttonNow16 = new swing.login.Button1();
        car17 = new javax.swing.JPanel();
        lbCar17 = new javax.swing.JLabel();
        lbTypeCar17 = new javax.swing.JLabel();
        lbPriceCounter17 = new javax.swing.JLabel();
        lbPriceNow17 = new javax.swing.JLabel();
        lbName17 = new javax.swing.JLabel();
        panelRound28 = new swing.login.PanelRound1();
        lbDoor17 = new javax.swing.JLabel();
        lbSeat17 = new javax.swing.JLabel();
        lbType17 = new javax.swing.JLabel();
        lbGas17 = new javax.swing.JLabel();
        lbSmall17 = new javax.swing.JLabel();
        lbLarge17 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        txtDifference17 = new javax.swing.JLabel();
        buttonCounter17 = new swing.login.Button1();
        buttonNow17 = new swing.login.Button1();
        car18 = new javax.swing.JPanel();
        lbCar18 = new javax.swing.JLabel();
        lbTypeCar18 = new javax.swing.JLabel();
        lbPriceCounter18 = new javax.swing.JLabel();
        lbPriceNow18 = new javax.swing.JLabel();
        lbName18 = new javax.swing.JLabel();
        panelRound29 = new swing.login.PanelRound1();
        lbDoor18 = new javax.swing.JLabel();
        lbSeat18 = new javax.swing.JLabel();
        lbType18 = new javax.swing.JLabel();
        lbGas18 = new javax.swing.JLabel();
        lbSmall18 = new javax.swing.JLabel();
        lbLarge18 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txtDifference18 = new javax.swing.JLabel();
        buttonCounter18 = new swing.login.Button1();
        buttonNow18 = new swing.login.Button1();
        car2 = new javax.swing.JPanel();
        lbCar2 = new javax.swing.JLabel();
        lbTypeCar2 = new javax.swing.JLabel();
        lbPriceCounter2 = new javax.swing.JLabel();
        lbPriceNow2 = new javax.swing.JLabel();
        lbName2 = new javax.swing.JLabel();
        panelRound13 = new swing.login.PanelRound1();
        lbDoor2 = new javax.swing.JLabel();
        lbSeat2 = new javax.swing.JLabel();
        lbType2 = new javax.swing.JLabel();
        lbGas2 = new javax.swing.JLabel();
        lbSmall2 = new javax.swing.JLabel();
        lbLarge2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtDifference2 = new javax.swing.JLabel();
        buttonCounter2 = new swing.login.Button1();
        buttonNow2 = new swing.login.Button1();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelRound2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        buttonBack = new swing.login.Close1Button();
        comboSelect = new swing.login.Combobox();
        comboOrder = new swing.login.Combobox();
        detailsReturn = new com.raven.component.DetailsCard();
        detailsPU = new com.raven.component.DetailsCard();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        panelBar = new javax.swing.JPanel();
        buttonSearch = new swing.login.Button();

        panelContinue.setBackground(new java.awt.Color(255, 255, 255));

        buttonContinue.setBackground(new java.awt.Color(0, 153, 255));
        buttonContinue.setForeground(new java.awt.Color(255, 255, 255));
        buttonContinue.setText("CONTINUAR");
        buttonContinue.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Vehiculo seleccionado, si desea este presione continuar.");

        javax.swing.GroupLayout panelContinueLayout = new javax.swing.GroupLayout(panelContinue);
        panelContinue.setLayout(panelContinueLayout);
        panelContinueLayout.setHorizontalGroup(
            panelContinueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContinueLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonContinue, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelContinueLayout.setVerticalGroup(
            panelContinueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContinueLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContinueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonContinue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        car0.setBackground(new java.awt.Color(255, 255, 255));

        lbCar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/mazda_cx5.png"))); // NOI18N

        lbTypeCar.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbTypeCar.setForeground(new java.awt.Color(51, 51, 51));
        lbTypeCar.setText("Type of Car");

        lbPriceCounter.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceCounter.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceCounter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceCounter.setText("$ Values");

        lbPriceNow.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceNow.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceNow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceNow.setText("$ Values");

        lbName.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbName.setForeground(new java.awt.Color(51, 51, 51));
        lbName.setText("Name of car");

        lbDoor.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbDoor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbDoor.setText("1");

        lbSeat.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSeat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSeat.setText("1");

        lbType.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbType.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbType.setText("1");

        lbGas.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbGas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbGas.setText("1");

        lbSmall.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSmall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSmall.setText("1");

        lbLarge.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbLarge.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbLarge.setText("1");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Libre de humo");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Caracteristicas del Vehiculo");

        javax.swing.GroupLayout panelRound11Layout = new javax.swing.GroupLayout(panelRound11);
        panelRound11.setLayout(panelRound11Layout);
        panelRound11Layout.setHorizontalGroup(
            panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound11Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbSeat)
                            .addComponent(lbDoor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbGas)
                            .addComponent(lbType))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge)
                            .addComponent(lbSmall))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound11Layout.setVerticalGroup(
            panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound11Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSmall))
                    .addGroup(panelRound11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbType))
                    .addGroup(panelRound11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDoor))
                    .addGroup(panelRound11Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge)
                            .addComponent(lbGas)
                            .addComponent(lbSeat))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        txtDifference.setBackground(new java.awt.Color(51, 51, 51));
        txtDifference.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txtDifference.setForeground(new java.awt.Color(51, 51, 51));
        txtDifference.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDifference.setText("Paga ahora y ahorra $1");

        buttonCounter.setBackground(new java.awt.Color(255, 255, 255));
        buttonCounter.setText("PAGAR EN CAJA");
        buttonCounter.setColor2(new java.awt.Color(204, 204, 204));
        buttonCounter.setEffectColor(new java.awt.Color(0, 0, 0));
        buttonCounter.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonCounter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCounterActionPerformed(evt);
            }
        });

        buttonNow.setBackground(new java.awt.Color(0, 102, 255));
        buttonNow.setForeground(new java.awt.Color(255, 255, 255));
        buttonNow.setText("PAGAR YA");
        buttonNow.setColor1(new java.awt.Color(0, 102, 255));
        buttonNow.setColor2(new java.awt.Color(0, 102, 255));
        buttonNow.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonNow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout car0Layout = new javax.swing.GroupLayout(car0);
        car0.setLayout(car0Layout);
        car0Layout.setHorizontalGroup(
            car0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car0Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(car0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTypeCar)
                    .addGroup(car0Layout.createSequentialGroup()
                        .addGroup(car0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(car0Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(lbCar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addComponent(panelRound11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(car0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCounter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceCounter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceNow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonNow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDifference, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        car0Layout.setVerticalGroup(
            car0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car0Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbPriceCounter)
                .addGap(8, 8, 8)
                .addGroup(car0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car0Layout.createSequentialGroup()
                        .addComponent(buttonCounter, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbPriceNow)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonNow, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelRound11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(txtDifference)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(car0Layout.createSequentialGroup()
                .addGroup(car0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car0Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lbName))
                    .addComponent(lbCar, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(car0Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbTypeCar)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        car1.setBackground(new java.awt.Color(255, 255, 255));

        lbCar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/mazda_cx5.png"))); // NOI18N

        lbTypeCar1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbTypeCar1.setForeground(new java.awt.Color(51, 51, 51));
        lbTypeCar1.setText("Type of Car");

        lbPriceCounter1.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceCounter1.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceCounter1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceCounter1.setText("$ Values");

        lbPriceNow1.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceNow1.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceNow1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceNow1.setText("$ Values");

        lbName1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbName1.setForeground(new java.awt.Color(51, 51, 51));
        lbName1.setText("Name of car");

        lbDoor1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbDoor1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbDoor1.setText("1");

        lbSeat1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSeat1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSeat1.setText("1");

        lbType1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbType1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbType1.setText("1");

        lbGas1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbGas1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbGas1.setText("1");

        lbSmall1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSmall1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSmall1.setText("1");

        lbLarge1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbLarge1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbLarge1.setText("1");

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Libre de humo");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Caracteristicas del Vehiculo");

        javax.swing.GroupLayout panelRound12Layout = new javax.swing.GroupLayout(panelRound12);
        panelRound12.setLayout(panelRound12Layout);
        panelRound12Layout.setHorizontalGroup(
            panelRound12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound12Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelRound12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbSeat1)
                            .addComponent(lbDoor1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbGas1)
                            .addComponent(lbType1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge1)
                            .addComponent(lbSmall1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound12Layout.setVerticalGroup(
            panelRound12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound12Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelRound12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound12Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSmall1))
                    .addGroup(panelRound12Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbType1))
                    .addGroup(panelRound12Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDoor1))
                    .addGroup(panelRound12Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(panelRound12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge1)
                            .addComponent(lbGas1)
                            .addComponent(lbSeat1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        txtDifference1.setBackground(new java.awt.Color(51, 51, 51));
        txtDifference1.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txtDifference1.setForeground(new java.awt.Color(51, 51, 51));
        txtDifference1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDifference1.setText("Paga ahora y ahorra $1");

        buttonCounter1.setBackground(new java.awt.Color(255, 255, 255));
        buttonCounter1.setText("PAGAR EN CAJA");
        buttonCounter1.setColor2(new java.awt.Color(204, 204, 204));
        buttonCounter1.setEffectColor(new java.awt.Color(0, 0, 0));
        buttonCounter1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonCounter1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCounter1ActionPerformed(evt);
            }
        });

        buttonNow1.setBackground(new java.awt.Color(0, 102, 255));
        buttonNow1.setForeground(new java.awt.Color(255, 255, 255));
        buttonNow1.setText("PAGAR YA");
        buttonNow1.setColor1(new java.awt.Color(0, 102, 255));
        buttonNow1.setColor2(new java.awt.Color(0, 102, 255));
        buttonNow1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonNow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNow1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout car1Layout = new javax.swing.GroupLayout(car1);
        car1.setLayout(car1Layout);
        car1Layout.setHorizontalGroup(
            car1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(car1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTypeCar1)
                    .addGroup(car1Layout.createSequentialGroup()
                        .addGroup(car1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbName1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(car1Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(lbCar1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addComponent(panelRound12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(car1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCounter1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceCounter1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceNow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonNow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDifference1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        car1Layout.setVerticalGroup(
            car1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbPriceCounter1)
                .addGap(8, 8, 8)
                .addGroup(car1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car1Layout.createSequentialGroup()
                        .addComponent(buttonCounter1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbPriceNow1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonNow1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelRound12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(txtDifference1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(car1Layout.createSequentialGroup()
                .addGroup(car1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lbName1))
                    .addComponent(lbCar1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(car1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbTypeCar1)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        car3.setBackground(new java.awt.Color(255, 255, 255));

        lbCar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/mazda_cx5.png"))); // NOI18N

        lbTypeCar3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbTypeCar3.setForeground(new java.awt.Color(51, 51, 51));
        lbTypeCar3.setText("Type of Car");

        lbPriceCounter3.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceCounter3.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceCounter3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceCounter3.setText("$ Values");

        lbPriceNow3.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceNow3.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceNow3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceNow3.setText("$ Values");

        lbName3.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbName3.setForeground(new java.awt.Color(51, 51, 51));
        lbName3.setText("Name of car");

        lbDoor3.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbDoor3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbDoor3.setText("1");

        lbSeat3.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSeat3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSeat3.setText("1");

        lbType3.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbType3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbType3.setText("1");

        lbGas3.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbGas3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbGas3.setText("1");

        lbSmall3.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSmall3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSmall3.setText("1");

        lbLarge3.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbLarge3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbLarge3.setText("1");

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Libre de humo");

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Caracteristicas del Vehiculo");

        javax.swing.GroupLayout panelRound14Layout = new javax.swing.GroupLayout(panelRound14);
        panelRound14.setLayout(panelRound14Layout);
        panelRound14Layout.setHorizontalGroup(
            panelRound14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound14Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelRound14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbSeat3)
                            .addComponent(lbDoor3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbGas3)
                            .addComponent(lbType3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge3)
                            .addComponent(lbSmall3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound14Layout.setVerticalGroup(
            panelRound14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound14Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelRound14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound14Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSmall3))
                    .addGroup(panelRound14Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbType3))
                    .addGroup(panelRound14Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDoor3))
                    .addGroup(panelRound14Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(panelRound14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge3)
                            .addComponent(lbGas3)
                            .addComponent(lbSeat3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addContainerGap())
        );

        txtDifference3.setBackground(new java.awt.Color(51, 51, 51));
        txtDifference3.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txtDifference3.setForeground(new java.awt.Color(51, 51, 51));
        txtDifference3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDifference3.setText("Paga ahora y ahorra $1");

        buttonCounter3.setBackground(new java.awt.Color(255, 255, 255));
        buttonCounter3.setText("PAGAR EN CAJA");
        buttonCounter3.setColor2(new java.awt.Color(204, 204, 204));
        buttonCounter3.setEffectColor(new java.awt.Color(0, 0, 0));
        buttonCounter3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonCounter3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCounter3ActionPerformed(evt);
            }
        });

        buttonNow3.setBackground(new java.awt.Color(0, 102, 255));
        buttonNow3.setForeground(new java.awt.Color(255, 255, 255));
        buttonNow3.setText("PAGAR YA");
        buttonNow3.setColor1(new java.awt.Color(0, 102, 255));
        buttonNow3.setColor2(new java.awt.Color(0, 102, 255));
        buttonNow3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonNow3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNow3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout car3Layout = new javax.swing.GroupLayout(car3);
        car3.setLayout(car3Layout);
        car3Layout.setHorizontalGroup(
            car3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(car3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTypeCar3)
                    .addGroup(car3Layout.createSequentialGroup()
                        .addGroup(car3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbName3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(car3Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(lbCar3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addComponent(panelRound14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(car3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCounter3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceCounter3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceNow3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonNow3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDifference3, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        car3Layout.setVerticalGroup(
            car3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbPriceCounter3)
                .addGap(8, 8, 8)
                .addGroup(car3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car3Layout.createSequentialGroup()
                        .addComponent(buttonCounter3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbPriceNow3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonNow3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelRound14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(txtDifference3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(car3Layout.createSequentialGroup()
                .addGroup(car3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car3Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lbName3))
                    .addComponent(lbCar3, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(car3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbTypeCar3)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        car4.setBackground(new java.awt.Color(255, 255, 255));

        lbCar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/mazda_cx5.png"))); // NOI18N

        lbTypeCar4.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbTypeCar4.setForeground(new java.awt.Color(51, 51, 51));
        lbTypeCar4.setText("Type of Car");

        lbPriceCounter4.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceCounter4.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceCounter4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceCounter4.setText("$ Values");

        lbPriceNow4.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceNow4.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceNow4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceNow4.setText("$ Values");

        lbName4.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbName4.setForeground(new java.awt.Color(51, 51, 51));
        lbName4.setText("Name of car");

        lbDoor4.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbDoor4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbDoor4.setText("1");

        lbSeat4.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSeat4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSeat4.setText("1");

        lbType4.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbType4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbType4.setText("1");

        lbGas4.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbGas4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbGas4.setText("1");

        lbSmall4.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSmall4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSmall4.setText("1");

        lbLarge4.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbLarge4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbLarge4.setText("1");

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Libre de humo");

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Caracteristicas del Vehiculo");

        javax.swing.GroupLayout panelRound15Layout = new javax.swing.GroupLayout(panelRound15);
        panelRound15.setLayout(panelRound15Layout);
        panelRound15Layout.setHorizontalGroup(
            panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound15Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbSeat4)
                            .addComponent(lbDoor4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbGas4)
                            .addComponent(lbType4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge4)
                            .addComponent(lbSmall4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound15Layout.setVerticalGroup(
            panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound15Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound15Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSmall4))
                    .addGroup(panelRound15Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbType4))
                    .addGroup(panelRound15Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDoor4))
                    .addGroup(panelRound15Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(panelRound15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge4)
                            .addComponent(lbGas4)
                            .addComponent(lbSeat4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addContainerGap())
        );

        txtDifference4.setBackground(new java.awt.Color(51, 51, 51));
        txtDifference4.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txtDifference4.setForeground(new java.awt.Color(51, 51, 51));
        txtDifference4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDifference4.setText("Paga ahora y ahorra $1");

        buttonCounter4.setBackground(new java.awt.Color(255, 255, 255));
        buttonCounter4.setText("PAGAR EN CAJA");
        buttonCounter4.setColor2(new java.awt.Color(204, 204, 204));
        buttonCounter4.setEffectColor(new java.awt.Color(0, 0, 0));
        buttonCounter4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonCounter4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCounter4ActionPerformed(evt);
            }
        });

        buttonNow4.setBackground(new java.awt.Color(0, 102, 255));
        buttonNow4.setForeground(new java.awt.Color(255, 255, 255));
        buttonNow4.setText("PAGAR YA");
        buttonNow4.setColor1(new java.awt.Color(0, 102, 255));
        buttonNow4.setColor2(new java.awt.Color(0, 102, 255));
        buttonNow4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonNow4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNow4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout car4Layout = new javax.swing.GroupLayout(car4);
        car4.setLayout(car4Layout);
        car4Layout.setHorizontalGroup(
            car4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(car4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTypeCar4)
                    .addGroup(car4Layout.createSequentialGroup()
                        .addGroup(car4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbName4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(car4Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(lbCar4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addComponent(panelRound15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(car4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCounter4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceCounter4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceNow4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonNow4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDifference4, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        car4Layout.setVerticalGroup(
            car4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbPriceCounter4)
                .addGap(8, 8, 8)
                .addGroup(car4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car4Layout.createSequentialGroup()
                        .addComponent(buttonCounter4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbPriceNow4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonNow4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelRound15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(txtDifference4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(car4Layout.createSequentialGroup()
                .addGroup(car4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car4Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lbName4))
                    .addComponent(lbCar4, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(car4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbTypeCar4)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        car5.setBackground(new java.awt.Color(255, 255, 255));

        lbCar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/mazda_cx5.png"))); // NOI18N

        lbTypeCar5.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbTypeCar5.setForeground(new java.awt.Color(51, 51, 51));
        lbTypeCar5.setText("Type of Car");

        lbPriceCounter5.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceCounter5.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceCounter5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceCounter5.setText("$ Values");

        lbPriceNow5.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceNow5.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceNow5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceNow5.setText("$ Values");

        lbName5.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbName5.setForeground(new java.awt.Color(51, 51, 51));
        lbName5.setText("Name of car");

        lbDoor5.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbDoor5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbDoor5.setText("1");

        lbSeat5.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSeat5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSeat5.setText("1");

        lbType5.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbType5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbType5.setText("1");

        lbGas5.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbGas5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbGas5.setText("1");

        lbSmall5.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSmall5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSmall5.setText("1");

        lbLarge5.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbLarge5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbLarge5.setText("1");

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Libre de humo");

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Caracteristicas del Vehiculo");

        javax.swing.GroupLayout panelRound16Layout = new javax.swing.GroupLayout(panelRound16);
        panelRound16.setLayout(panelRound16Layout);
        panelRound16Layout.setHorizontalGroup(
            panelRound16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound16Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelRound16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbSeat5)
                            .addComponent(lbDoor5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbGas5)
                            .addComponent(lbType5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge5)
                            .addComponent(lbSmall5))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound16Layout.setVerticalGroup(
            panelRound16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound16Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelRound16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound16Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSmall5))
                    .addGroup(panelRound16Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbType5))
                    .addGroup(panelRound16Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDoor5))
                    .addGroup(panelRound16Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(panelRound16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge5)
                            .addComponent(lbGas5)
                            .addComponent(lbSeat5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addContainerGap())
        );

        txtDifference5.setBackground(new java.awt.Color(51, 51, 51));
        txtDifference5.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txtDifference5.setForeground(new java.awt.Color(51, 51, 51));
        txtDifference5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDifference5.setText("Paga ahora y ahorra $1");

        buttonCounter5.setBackground(new java.awt.Color(255, 255, 255));
        buttonCounter5.setText("PAGAR EN CAJA");
        buttonCounter5.setColor2(new java.awt.Color(204, 204, 204));
        buttonCounter5.setEffectColor(new java.awt.Color(0, 0, 0));
        buttonCounter5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonCounter5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCounter5ActionPerformed(evt);
            }
        });

        buttonNow5.setBackground(new java.awt.Color(0, 102, 255));
        buttonNow5.setForeground(new java.awt.Color(255, 255, 255));
        buttonNow5.setText("PAGAR YA");
        buttonNow5.setColor1(new java.awt.Color(0, 102, 255));
        buttonNow5.setColor2(new java.awt.Color(0, 102, 255));
        buttonNow5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonNow5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNow5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout car5Layout = new javax.swing.GroupLayout(car5);
        car5.setLayout(car5Layout);
        car5Layout.setHorizontalGroup(
            car5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(car5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTypeCar5)
                    .addGroup(car5Layout.createSequentialGroup()
                        .addGroup(car5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbName5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(car5Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(lbCar5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addComponent(panelRound16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(car5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCounter5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceCounter5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceNow5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonNow5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDifference5, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        car5Layout.setVerticalGroup(
            car5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbPriceCounter5)
                .addGap(8, 8, 8)
                .addGroup(car5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car5Layout.createSequentialGroup()
                        .addComponent(buttonCounter5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbPriceNow5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonNow5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelRound16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(txtDifference5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(car5Layout.createSequentialGroup()
                .addGroup(car5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car5Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lbName5))
                    .addComponent(lbCar5, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(car5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbTypeCar5)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        car6.setBackground(new java.awt.Color(255, 255, 255));

        lbCar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/mazda_cx5.png"))); // NOI18N

        lbTypeCar6.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbTypeCar6.setForeground(new java.awt.Color(51, 51, 51));
        lbTypeCar6.setText("Type of Car");

        lbPriceCounter6.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceCounter6.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceCounter6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceCounter6.setText("$ Values");

        lbPriceNow6.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceNow6.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceNow6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceNow6.setText("$ Values");

        lbName6.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbName6.setForeground(new java.awt.Color(51, 51, 51));
        lbName6.setText("Name of car");

        lbDoor6.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbDoor6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbDoor6.setText("1");

        lbSeat6.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSeat6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSeat6.setText("1");

        lbType6.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbType6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbType6.setText("1");

        lbGas6.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbGas6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbGas6.setText("1");

        lbSmall6.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSmall6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSmall6.setText("1");

        lbLarge6.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbLarge6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbLarge6.setText("1");

        jLabel16.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Libre de humo");

        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Caracteristicas del Vehiculo");

        javax.swing.GroupLayout panelRound17Layout = new javax.swing.GroupLayout(panelRound17);
        panelRound17.setLayout(panelRound17Layout);
        panelRound17Layout.setHorizontalGroup(
            panelRound17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound17Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelRound17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbSeat6)
                            .addComponent(lbDoor6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbGas6)
                            .addComponent(lbType6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge6)
                            .addComponent(lbSmall6))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound17Layout.setVerticalGroup(
            panelRound17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound17Layout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelRound17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound17Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSmall6))
                    .addGroup(panelRound17Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbType6))
                    .addGroup(panelRound17Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDoor6))
                    .addGroup(panelRound17Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(panelRound17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge6)
                            .addComponent(lbGas6)
                            .addComponent(lbSeat6))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addContainerGap())
        );

        txtDifference6.setBackground(new java.awt.Color(51, 51, 51));
        txtDifference6.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txtDifference6.setForeground(new java.awt.Color(51, 51, 51));
        txtDifference6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDifference6.setText("Paga ahora y ahorra $1");

        buttonCounter6.setBackground(new java.awt.Color(255, 255, 255));
        buttonCounter6.setText("PAGAR EN CAJA");
        buttonCounter6.setColor2(new java.awt.Color(204, 204, 204));
        buttonCounter6.setEffectColor(new java.awt.Color(0, 0, 0));
        buttonCounter6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonCounter6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCounter6ActionPerformed(evt);
            }
        });

        buttonNow6.setBackground(new java.awt.Color(0, 102, 255));
        buttonNow6.setForeground(new java.awt.Color(255, 255, 255));
        buttonNow6.setText("PAGAR YA");
        buttonNow6.setColor1(new java.awt.Color(0, 102, 255));
        buttonNow6.setColor2(new java.awt.Color(0, 102, 255));
        buttonNow6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonNow6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNow6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout car6Layout = new javax.swing.GroupLayout(car6);
        car6.setLayout(car6Layout);
        car6Layout.setHorizontalGroup(
            car6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(car6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTypeCar6)
                    .addGroup(car6Layout.createSequentialGroup()
                        .addGroup(car6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbName6, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(car6Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(lbCar6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addComponent(panelRound17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(car6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCounter6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceCounter6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceNow6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonNow6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDifference6, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        car6Layout.setVerticalGroup(
            car6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car6Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(lbPriceCounter6)
                .addGap(8, 8, 8)
                .addGroup(car6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car6Layout.createSequentialGroup()
                        .addComponent(buttonCounter6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbPriceNow6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonNow6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelRound17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(txtDifference6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(car6Layout.createSequentialGroup()
                .addGroup(car6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car6Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lbName6))
                    .addComponent(lbCar6, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(car6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbTypeCar6)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        car7.setBackground(new java.awt.Color(255, 255, 255));

        lbCar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/mazda_cx5.png"))); // NOI18N

        lbTypeCar7.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbTypeCar7.setForeground(new java.awt.Color(51, 51, 51));
        lbTypeCar7.setText("Type of Car");

        lbPriceCounter7.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceCounter7.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceCounter7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceCounter7.setText("$ Values");

        lbPriceNow7.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceNow7.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceNow7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceNow7.setText("$ Values");

        lbName7.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbName7.setForeground(new java.awt.Color(51, 51, 51));
        lbName7.setText("Name of car");

        lbDoor7.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbDoor7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbDoor7.setText("1");

        lbSeat7.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSeat7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSeat7.setText("1");

        lbType7.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbType7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbType7.setText("1");

        lbGas7.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbGas7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbGas7.setText("1");

        lbSmall7.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSmall7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSmall7.setText("1");

        lbLarge7.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbLarge7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbLarge7.setText("1");

        jLabel18.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Libre de humo");

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Caracteristicas del Vehiculo");

        javax.swing.GroupLayout panelRound18Layout = new javax.swing.GroupLayout(panelRound18);
        panelRound18.setLayout(panelRound18Layout);
        panelRound18Layout.setHorizontalGroup(
            panelRound18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound18Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelRound18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbSeat7)
                            .addComponent(lbDoor7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbGas7)
                            .addComponent(lbType7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge7)
                            .addComponent(lbSmall7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound18Layout.setVerticalGroup(
            panelRound18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound18Layout.createSequentialGroup()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelRound18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound18Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSmall7))
                    .addGroup(panelRound18Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbType7))
                    .addGroup(panelRound18Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDoor7))
                    .addGroup(panelRound18Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(panelRound18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge7)
                            .addComponent(lbGas7)
                            .addComponent(lbSeat7))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addContainerGap())
        );

        txtDifference7.setBackground(new java.awt.Color(51, 51, 51));
        txtDifference7.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txtDifference7.setForeground(new java.awt.Color(51, 51, 51));
        txtDifference7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDifference7.setText("Paga ahora y ahorra $1");

        buttonCounter7.setBackground(new java.awt.Color(255, 255, 255));
        buttonCounter7.setText("PAGAR EN CAJA");
        buttonCounter7.setColor2(new java.awt.Color(204, 204, 204));
        buttonCounter7.setEffectColor(new java.awt.Color(0, 0, 0));
        buttonCounter7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonCounter7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCounter7ActionPerformed(evt);
            }
        });

        buttonNow7.setBackground(new java.awt.Color(0, 102, 255));
        buttonNow7.setForeground(new java.awt.Color(255, 255, 255));
        buttonNow7.setText("PAGAR YA");
        buttonNow7.setColor1(new java.awt.Color(0, 102, 255));
        buttonNow7.setColor2(new java.awt.Color(0, 102, 255));
        buttonNow7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonNow7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNow7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout car7Layout = new javax.swing.GroupLayout(car7);
        car7.setLayout(car7Layout);
        car7Layout.setHorizontalGroup(
            car7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(car7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTypeCar7)
                    .addGroup(car7Layout.createSequentialGroup()
                        .addGroup(car7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbName7, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(car7Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(lbCar7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addComponent(panelRound18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(car7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCounter7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceCounter7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceNow7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonNow7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDifference7, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        car7Layout.setVerticalGroup(
            car7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbPriceCounter7)
                .addGap(8, 8, 8)
                .addGroup(car7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car7Layout.createSequentialGroup()
                        .addComponent(buttonCounter7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbPriceNow7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonNow7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelRound18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(txtDifference7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(car7Layout.createSequentialGroup()
                .addGroup(car7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car7Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lbName7))
                    .addComponent(lbCar7, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(car7Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbTypeCar7)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        car8.setBackground(new java.awt.Color(255, 255, 255));

        lbCar8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/mazda_cx5.png"))); // NOI18N

        lbTypeCar8.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbTypeCar8.setForeground(new java.awt.Color(51, 51, 51));
        lbTypeCar8.setText("Type of Car");

        lbPriceCounter8.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceCounter8.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceCounter8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceCounter8.setText("$ Values");

        lbPriceNow8.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceNow8.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceNow8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceNow8.setText("$ Values");

        lbName8.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbName8.setForeground(new java.awt.Color(51, 51, 51));
        lbName8.setText("Name of car");

        lbDoor8.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbDoor8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbDoor8.setText("1");

        lbSeat8.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSeat8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSeat8.setText("1");

        lbType8.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbType8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbType8.setText("1");

        lbGas8.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbGas8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbGas8.setText("1");

        lbSmall8.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSmall8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSmall8.setText("1");

        lbLarge8.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbLarge8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbLarge8.setText("1");

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Libre de humo");

        jLabel21.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Caracteristicas del Vehiculo");

        javax.swing.GroupLayout panelRound19Layout = new javax.swing.GroupLayout(panelRound19);
        panelRound19.setLayout(panelRound19Layout);
        panelRound19Layout.setHorizontalGroup(
            panelRound19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound19Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelRound19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbSeat8)
                            .addComponent(lbDoor8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbGas8)
                            .addComponent(lbType8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge8)
                            .addComponent(lbSmall8))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound19Layout.setVerticalGroup(
            panelRound19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound19Layout.createSequentialGroup()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelRound19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound19Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSmall8))
                    .addGroup(panelRound19Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbType8))
                    .addGroup(panelRound19Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDoor8))
                    .addGroup(panelRound19Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(panelRound19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge8)
                            .addComponent(lbGas8)
                            .addComponent(lbSeat8))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addContainerGap())
        );

        txtDifference8.setBackground(new java.awt.Color(51, 51, 51));
        txtDifference8.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txtDifference8.setForeground(new java.awt.Color(51, 51, 51));
        txtDifference8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDifference8.setText("Paga ahora y ahorra $1");

        buttonCounter8.setBackground(new java.awt.Color(255, 255, 255));
        buttonCounter8.setText("PAGAR EN CAJA");
        buttonCounter8.setColor2(new java.awt.Color(204, 204, 204));
        buttonCounter8.setEffectColor(new java.awt.Color(0, 0, 0));
        buttonCounter8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonCounter8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCounter8ActionPerformed(evt);
            }
        });

        buttonNow8.setBackground(new java.awt.Color(0, 102, 255));
        buttonNow8.setForeground(new java.awt.Color(255, 255, 255));
        buttonNow8.setText("PAGAR YA");
        buttonNow8.setColor1(new java.awt.Color(0, 102, 255));
        buttonNow8.setColor2(new java.awt.Color(0, 102, 255));
        buttonNow8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonNow8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNow8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout car8Layout = new javax.swing.GroupLayout(car8);
        car8.setLayout(car8Layout);
        car8Layout.setHorizontalGroup(
            car8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(car8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTypeCar8)
                    .addGroup(car8Layout.createSequentialGroup()
                        .addGroup(car8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbName8, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(car8Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(lbCar8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addComponent(panelRound19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(car8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCounter8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceCounter8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceNow8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonNow8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDifference8, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        car8Layout.setVerticalGroup(
            car8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbPriceCounter8)
                .addGap(8, 8, 8)
                .addGroup(car8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car8Layout.createSequentialGroup()
                        .addComponent(buttonCounter8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbPriceNow8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonNow8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelRound19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(txtDifference8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(car8Layout.createSequentialGroup()
                .addGroup(car8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car8Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lbName8))
                    .addComponent(lbCar8, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(car8Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbTypeCar8)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        car9.setBackground(new java.awt.Color(255, 255, 255));

        lbCar9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/mazda_cx5.png"))); // NOI18N

        lbTypeCar9.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbTypeCar9.setForeground(new java.awt.Color(51, 51, 51));
        lbTypeCar9.setText("Type of Car");

        lbPriceCounter9.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceCounter9.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceCounter9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceCounter9.setText("$ Values");

        lbPriceNow9.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceNow9.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceNow9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceNow9.setText("$ Values");

        lbName9.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbName9.setForeground(new java.awt.Color(51, 51, 51));
        lbName9.setText("Name of car");

        lbDoor9.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbDoor9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbDoor9.setText("1");

        lbSeat9.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSeat9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSeat9.setText("1");

        lbType9.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbType9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbType9.setText("1");

        lbGas9.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbGas9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbGas9.setText("1");

        lbSmall9.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSmall9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSmall9.setText("1");

        lbLarge9.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbLarge9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbLarge9.setText("1");

        jLabel22.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Libre de humo");

        jLabel23.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(51, 51, 51));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Caracteristicas del Vehiculo");

        javax.swing.GroupLayout panelRound20Layout = new javax.swing.GroupLayout(panelRound20);
        panelRound20.setLayout(panelRound20Layout);
        panelRound20Layout.setHorizontalGroup(
            panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound20Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbSeat9)
                            .addComponent(lbDoor9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbGas9)
                            .addComponent(lbType9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge9)
                            .addComponent(lbSmall9))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound20Layout.setVerticalGroup(
            panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound20Layout.createSequentialGroup()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound20Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSmall9))
                    .addGroup(panelRound20Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbType9))
                    .addGroup(panelRound20Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDoor9))
                    .addGroup(panelRound20Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(panelRound20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge9)
                            .addComponent(lbGas9)
                            .addComponent(lbSeat9))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addContainerGap())
        );

        txtDifference9.setBackground(new java.awt.Color(51, 51, 51));
        txtDifference9.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txtDifference9.setForeground(new java.awt.Color(51, 51, 51));
        txtDifference9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDifference9.setText("Paga ahora y ahorra $1");

        buttonCounter9.setBackground(new java.awt.Color(255, 255, 255));
        buttonCounter9.setText("PAGAR EN CAJA");
        buttonCounter9.setColor2(new java.awt.Color(204, 204, 204));
        buttonCounter9.setEffectColor(new java.awt.Color(0, 0, 0));
        buttonCounter9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonCounter9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCounter9ActionPerformed(evt);
            }
        });

        buttonNow9.setBackground(new java.awt.Color(0, 102, 255));
        buttonNow9.setForeground(new java.awt.Color(255, 255, 255));
        buttonNow9.setText("PAGAR YA");
        buttonNow9.setColor1(new java.awt.Color(0, 102, 255));
        buttonNow9.setColor2(new java.awt.Color(0, 102, 255));
        buttonNow9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonNow9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNow9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout car9Layout = new javax.swing.GroupLayout(car9);
        car9.setLayout(car9Layout);
        car9Layout.setHorizontalGroup(
            car9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(car9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTypeCar9)
                    .addGroup(car9Layout.createSequentialGroup()
                        .addGroup(car9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbName9, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(car9Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(lbCar9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addComponent(panelRound20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(car9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCounter9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceCounter9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceNow9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonNow9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDifference9, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        car9Layout.setVerticalGroup(
            car9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car9Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbPriceCounter9)
                .addGap(8, 8, 8)
                .addGroup(car9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car9Layout.createSequentialGroup()
                        .addComponent(buttonCounter9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbPriceNow9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonNow9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelRound20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(txtDifference9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(car9Layout.createSequentialGroup()
                .addGroup(car9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car9Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lbName9))
                    .addComponent(lbCar9, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(car9Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbTypeCar9)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        car10.setBackground(new java.awt.Color(255, 255, 255));

        lbCar10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/mazda_cx5.png"))); // NOI18N

        lbTypeCar10.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbTypeCar10.setForeground(new java.awt.Color(51, 51, 51));
        lbTypeCar10.setText("Type of Car");

        lbPriceCounter10.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceCounter10.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceCounter10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceCounter10.setText("$ Values");

        lbPriceNow10.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceNow10.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceNow10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceNow10.setText("$ Values");

        lbName10.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbName10.setForeground(new java.awt.Color(51, 51, 51));
        lbName10.setText("Name of car");

        lbDoor10.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbDoor10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbDoor10.setText("1");

        lbSeat10.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSeat10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSeat10.setText("1");

        lbType10.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbType10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbType10.setText("1");

        lbGas10.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbGas10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbGas10.setText("1");

        lbSmall10.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSmall10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSmall10.setText("1");

        lbLarge10.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbLarge10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbLarge10.setText("1");

        jLabel24.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Libre de humo");

        jLabel25.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(51, 51, 51));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Caracteristicas del Vehiculo");

        javax.swing.GroupLayout panelRound21Layout = new javax.swing.GroupLayout(panelRound21);
        panelRound21.setLayout(panelRound21Layout);
        panelRound21Layout.setHorizontalGroup(
            panelRound21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound21Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelRound21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbSeat10)
                            .addComponent(lbDoor10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbGas10)
                            .addComponent(lbType10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge10)
                            .addComponent(lbSmall10))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound21Layout.setVerticalGroup(
            panelRound21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound21Layout.createSequentialGroup()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelRound21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound21Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSmall10))
                    .addGroup(panelRound21Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbType10))
                    .addGroup(panelRound21Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDoor10))
                    .addGroup(panelRound21Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(panelRound21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge10)
                            .addComponent(lbGas10)
                            .addComponent(lbSeat10))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addContainerGap())
        );

        txtDifference10.setBackground(new java.awt.Color(51, 51, 51));
        txtDifference10.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txtDifference10.setForeground(new java.awt.Color(51, 51, 51));
        txtDifference10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDifference10.setText("Paga ahora y ahorra $1");

        buttonCounter10.setBackground(new java.awt.Color(255, 255, 255));
        buttonCounter10.setText("PAGAR EN CAJA");
        buttonCounter10.setColor2(new java.awt.Color(204, 204, 204));
        buttonCounter10.setEffectColor(new java.awt.Color(0, 0, 0));
        buttonCounter10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonCounter10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCounter10ActionPerformed(evt);
            }
        });

        buttonNow10.setBackground(new java.awt.Color(0, 102, 255));
        buttonNow10.setForeground(new java.awt.Color(255, 255, 255));
        buttonNow10.setText("PAGAR YA");
        buttonNow10.setColor1(new java.awt.Color(0, 102, 255));
        buttonNow10.setColor2(new java.awt.Color(0, 102, 255));
        buttonNow10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonNow10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNow10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout car10Layout = new javax.swing.GroupLayout(car10);
        car10.setLayout(car10Layout);
        car10Layout.setHorizontalGroup(
            car10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car10Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(car10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTypeCar10)
                    .addGroup(car10Layout.createSequentialGroup()
                        .addGroup(car10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbName10, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(car10Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(lbCar10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addComponent(panelRound21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(car10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCounter10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceCounter10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceNow10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonNow10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDifference10, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        car10Layout.setVerticalGroup(
            car10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car10Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbPriceCounter10)
                .addGap(8, 8, 8)
                .addGroup(car10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car10Layout.createSequentialGroup()
                        .addComponent(buttonCounter10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbPriceNow10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonNow10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelRound21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(txtDifference10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(car10Layout.createSequentialGroup()
                .addGroup(car10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car10Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lbName10))
                    .addComponent(lbCar10, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(car10Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbTypeCar10)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        car11.setBackground(new java.awt.Color(255, 255, 255));

        lbCar11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/mazda_cx5.png"))); // NOI18N

        lbTypeCar11.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbTypeCar11.setForeground(new java.awt.Color(51, 51, 51));
        lbTypeCar11.setText("Type of Car");

        lbPriceCounter11.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceCounter11.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceCounter11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceCounter11.setText("$ Values");

        lbPriceNow11.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceNow11.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceNow11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceNow11.setText("$ Values");

        lbName11.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbName11.setForeground(new java.awt.Color(51, 51, 51));
        lbName11.setText("Name of car");

        lbDoor11.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbDoor11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbDoor11.setText("1");

        lbSeat11.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSeat11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSeat11.setText("1");

        lbType11.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbType11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbType11.setText("1");

        lbGas11.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbGas11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbGas11.setText("1");

        lbSmall11.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSmall11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSmall11.setText("1");

        lbLarge11.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbLarge11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbLarge11.setText("1");

        jLabel26.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Libre de humo");

        jLabel27.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(51, 51, 51));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Caracteristicas del Vehiculo");

        javax.swing.GroupLayout panelRound22Layout = new javax.swing.GroupLayout(panelRound22);
        panelRound22.setLayout(panelRound22Layout);
        panelRound22Layout.setHorizontalGroup(
            panelRound22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound22Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelRound22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbSeat11)
                            .addComponent(lbDoor11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbGas11)
                            .addComponent(lbType11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge11)
                            .addComponent(lbSmall11))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound22Layout.setVerticalGroup(
            panelRound22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound22Layout.createSequentialGroup()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelRound22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound22Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSmall11))
                    .addGroup(panelRound22Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbType11))
                    .addGroup(panelRound22Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDoor11))
                    .addGroup(panelRound22Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(panelRound22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge11)
                            .addComponent(lbGas11)
                            .addComponent(lbSeat11))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addContainerGap())
        );

        txtDifference11.setBackground(new java.awt.Color(51, 51, 51));
        txtDifference11.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txtDifference11.setForeground(new java.awt.Color(51, 51, 51));
        txtDifference11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDifference11.setText("Paga ahora y ahorra $1");

        buttonCounter11.setBackground(new java.awt.Color(255, 255, 255));
        buttonCounter11.setText("PAGAR EN CAJA");
        buttonCounter11.setColor2(new java.awt.Color(204, 204, 204));
        buttonCounter11.setEffectColor(new java.awt.Color(0, 0, 0));
        buttonCounter11.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonCounter11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCounter11ActionPerformed(evt);
            }
        });

        buttonNow11.setBackground(new java.awt.Color(0, 102, 255));
        buttonNow11.setForeground(new java.awt.Color(255, 255, 255));
        buttonNow11.setText("PAGAR YA");
        buttonNow11.setColor1(new java.awt.Color(0, 102, 255));
        buttonNow11.setColor2(new java.awt.Color(0, 102, 255));
        buttonNow11.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonNow11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNow11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout car11Layout = new javax.swing.GroupLayout(car11);
        car11.setLayout(car11Layout);
        car11Layout.setHorizontalGroup(
            car11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car11Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(car11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTypeCar11)
                    .addGroup(car11Layout.createSequentialGroup()
                        .addGroup(car11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbName11, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(car11Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(lbCar11)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addComponent(panelRound22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(car11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCounter11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceCounter11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceNow11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonNow11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDifference11, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        car11Layout.setVerticalGroup(
            car11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car11Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbPriceCounter11)
                .addGap(8, 8, 8)
                .addGroup(car11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car11Layout.createSequentialGroup()
                        .addComponent(buttonCounter11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbPriceNow11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonNow11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelRound22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(txtDifference11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(car11Layout.createSequentialGroup()
                .addGroup(car11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car11Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lbName11))
                    .addComponent(lbCar11, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(car11Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbTypeCar11)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        car12.setBackground(new java.awt.Color(255, 255, 255));

        lbCar12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/mazda_cx5.png"))); // NOI18N

        lbTypeCar12.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbTypeCar12.setForeground(new java.awt.Color(51, 51, 51));
        lbTypeCar12.setText("Type of Car");

        lbPriceCounter12.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceCounter12.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceCounter12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceCounter12.setText("$ Values");

        lbPriceNow12.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceNow12.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceNow12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceNow12.setText("$ Values");

        lbName12.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbName12.setForeground(new java.awt.Color(51, 51, 51));
        lbName12.setText("Name of car");

        lbDoor12.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbDoor12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbDoor12.setText("1");

        lbSeat12.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSeat12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSeat12.setText("1");

        lbType12.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbType12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbType12.setText("1");

        lbGas12.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbGas12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbGas12.setText("1");

        lbSmall12.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSmall12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSmall12.setText("1");

        lbLarge12.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbLarge12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbLarge12.setText("1");

        jLabel28.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Libre de humo");

        jLabel29.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(51, 51, 51));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Caracteristicas del Vehiculo");

        javax.swing.GroupLayout panelRound23Layout = new javax.swing.GroupLayout(panelRound23);
        panelRound23.setLayout(panelRound23Layout);
        panelRound23Layout.setHorizontalGroup(
            panelRound23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound23Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelRound23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbSeat12)
                            .addComponent(lbDoor12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbGas12)
                            .addComponent(lbType12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge12)
                            .addComponent(lbSmall12))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound23Layout.setVerticalGroup(
            panelRound23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound23Layout.createSequentialGroup()
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelRound23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound23Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSmall12))
                    .addGroup(panelRound23Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbType12))
                    .addGroup(panelRound23Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDoor12))
                    .addGroup(panelRound23Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(panelRound23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge12)
                            .addComponent(lbGas12)
                            .addComponent(lbSeat12))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jLabel28)
                .addContainerGap())
        );

        txtDifference12.setBackground(new java.awt.Color(51, 51, 51));
        txtDifference12.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txtDifference12.setForeground(new java.awt.Color(51, 51, 51));
        txtDifference12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDifference12.setText("Paga ahora y ahorra $1");

        buttonCounter12.setBackground(new java.awt.Color(255, 255, 255));
        buttonCounter12.setText("PAGAR EN CAJA");
        buttonCounter12.setColor2(new java.awt.Color(204, 204, 204));
        buttonCounter12.setEffectColor(new java.awt.Color(0, 0, 0));
        buttonCounter12.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonCounter12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCounter12ActionPerformed(evt);
            }
        });

        buttonNow12.setBackground(new java.awt.Color(0, 102, 255));
        buttonNow12.setForeground(new java.awt.Color(255, 255, 255));
        buttonNow12.setText("PAGAR YA");
        buttonNow12.setColor1(new java.awt.Color(0, 102, 255));
        buttonNow12.setColor2(new java.awt.Color(0, 102, 255));
        buttonNow12.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonNow12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNow12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout car12Layout = new javax.swing.GroupLayout(car12);
        car12.setLayout(car12Layout);
        car12Layout.setHorizontalGroup(
            car12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car12Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(car12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTypeCar12)
                    .addGroup(car12Layout.createSequentialGroup()
                        .addGroup(car12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbName12, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(car12Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(lbCar12)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addComponent(panelRound23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(car12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCounter12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceCounter12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceNow12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonNow12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDifference12, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        car12Layout.setVerticalGroup(
            car12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car12Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbPriceCounter12)
                .addGap(8, 8, 8)
                .addGroup(car12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car12Layout.createSequentialGroup()
                        .addComponent(buttonCounter12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbPriceNow12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonNow12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelRound23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(txtDifference12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(car12Layout.createSequentialGroup()
                .addGroup(car12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car12Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lbName12))
                    .addComponent(lbCar12, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(car12Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbTypeCar12)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        car13.setBackground(new java.awt.Color(255, 255, 255));

        lbCar13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/mazda_cx5.png"))); // NOI18N

        lbTypeCar13.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbTypeCar13.setForeground(new java.awt.Color(51, 51, 51));
        lbTypeCar13.setText("Type of Car");

        lbPriceCounter13.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceCounter13.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceCounter13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceCounter13.setText("$ Values");

        lbPriceNow13.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceNow13.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceNow13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceNow13.setText("$ Values");

        lbName13.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbName13.setForeground(new java.awt.Color(51, 51, 51));
        lbName13.setText("Name of car");

        lbDoor13.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbDoor13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbDoor13.setText("1");

        lbSeat13.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSeat13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSeat13.setText("1");

        lbType13.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbType13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbType13.setText("1");

        lbGas13.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbGas13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbGas13.setText("1");

        lbSmall13.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSmall13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSmall13.setText("1");

        lbLarge13.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbLarge13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbLarge13.setText("1");

        jLabel30.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Libre de humo");

        jLabel31.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(51, 51, 51));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Caracteristicas del Vehiculo");

        javax.swing.GroupLayout panelRound24Layout = new javax.swing.GroupLayout(panelRound24);
        panelRound24.setLayout(panelRound24Layout);
        panelRound24Layout.setHorizontalGroup(
            panelRound24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound24Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelRound24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbSeat13)
                            .addComponent(lbDoor13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbGas13)
                            .addComponent(lbType13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge13)
                            .addComponent(lbSmall13))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound24Layout.setVerticalGroup(
            panelRound24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound24Layout.createSequentialGroup()
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelRound24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound24Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSmall13))
                    .addGroup(panelRound24Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbType13))
                    .addGroup(panelRound24Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDoor13))
                    .addGroup(panelRound24Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(panelRound24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge13)
                            .addComponent(lbGas13)
                            .addComponent(lbSeat13))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jLabel30)
                .addContainerGap())
        );

        txtDifference13.setBackground(new java.awt.Color(51, 51, 51));
        txtDifference13.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txtDifference13.setForeground(new java.awt.Color(51, 51, 51));
        txtDifference13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDifference13.setText("Paga ahora y ahorra $1");

        buttonCounter13.setBackground(new java.awt.Color(255, 255, 255));
        buttonCounter13.setText("PAGAR EN CAJA");
        buttonCounter13.setColor2(new java.awt.Color(204, 204, 204));
        buttonCounter13.setEffectColor(new java.awt.Color(0, 0, 0));
        buttonCounter13.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonCounter13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCounter13ActionPerformed(evt);
            }
        });

        buttonNow13.setBackground(new java.awt.Color(0, 102, 255));
        buttonNow13.setForeground(new java.awt.Color(255, 255, 255));
        buttonNow13.setText("PAGAR YA");
        buttonNow13.setColor1(new java.awt.Color(0, 102, 255));
        buttonNow13.setColor2(new java.awt.Color(0, 102, 255));
        buttonNow13.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonNow13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNow13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout car13Layout = new javax.swing.GroupLayout(car13);
        car13.setLayout(car13Layout);
        car13Layout.setHorizontalGroup(
            car13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car13Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(car13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTypeCar13)
                    .addGroup(car13Layout.createSequentialGroup()
                        .addGroup(car13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbName13, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(car13Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(lbCar13)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addComponent(panelRound24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(car13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCounter13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceCounter13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceNow13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonNow13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDifference13, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        car13Layout.setVerticalGroup(
            car13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car13Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbPriceCounter13)
                .addGap(8, 8, 8)
                .addGroup(car13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car13Layout.createSequentialGroup()
                        .addComponent(buttonCounter13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbPriceNow13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonNow13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelRound24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(txtDifference13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(car13Layout.createSequentialGroup()
                .addGroup(car13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car13Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lbName13))
                    .addComponent(lbCar13, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(car13Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbTypeCar13)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        car14.setBackground(new java.awt.Color(255, 255, 255));

        lbCar14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/mazda_cx5.png"))); // NOI18N

        lbTypeCar14.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbTypeCar14.setForeground(new java.awt.Color(51, 51, 51));
        lbTypeCar14.setText("Type of Car");

        lbPriceCounter14.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceCounter14.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceCounter14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceCounter14.setText("$ Values");

        lbPriceNow14.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceNow14.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceNow14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceNow14.setText("$ Values");

        lbName14.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbName14.setForeground(new java.awt.Color(51, 51, 51));
        lbName14.setText("Name of car");

        lbDoor14.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbDoor14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbDoor14.setText("1");

        lbSeat14.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSeat14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSeat14.setText("1");

        lbType14.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbType14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbType14.setText("1");

        lbGas14.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbGas14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbGas14.setText("1");

        lbSmall14.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSmall14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSmall14.setText("1");

        lbLarge14.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbLarge14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbLarge14.setText("1");

        jLabel32.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Libre de humo");

        jLabel33.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(51, 51, 51));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Caracteristicas del Vehiculo");

        javax.swing.GroupLayout panelRound25Layout = new javax.swing.GroupLayout(panelRound25);
        panelRound25.setLayout(panelRound25Layout);
        panelRound25Layout.setHorizontalGroup(
            panelRound25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound25Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelRound25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbSeat14)
                            .addComponent(lbDoor14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbGas14)
                            .addComponent(lbType14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge14)
                            .addComponent(lbSmall14))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound25Layout.setVerticalGroup(
            panelRound25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound25Layout.createSequentialGroup()
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelRound25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound25Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSmall14))
                    .addGroup(panelRound25Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbType14))
                    .addGroup(panelRound25Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDoor14))
                    .addGroup(panelRound25Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(panelRound25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge14)
                            .addComponent(lbGas14)
                            .addComponent(lbSeat14))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jLabel32)
                .addContainerGap())
        );

        txtDifference14.setBackground(new java.awt.Color(51, 51, 51));
        txtDifference14.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txtDifference14.setForeground(new java.awt.Color(51, 51, 51));
        txtDifference14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDifference14.setText("Paga ahora y ahorra $1");

        buttonCounter14.setBackground(new java.awt.Color(255, 255, 255));
        buttonCounter14.setText("PAGAR EN CAJA");
        buttonCounter14.setColor2(new java.awt.Color(204, 204, 204));
        buttonCounter14.setEffectColor(new java.awt.Color(0, 0, 0));
        buttonCounter14.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonCounter14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCounter14ActionPerformed(evt);
            }
        });

        buttonNow14.setBackground(new java.awt.Color(0, 102, 255));
        buttonNow14.setForeground(new java.awt.Color(255, 255, 255));
        buttonNow14.setText("PAGAR YA");
        buttonNow14.setColor1(new java.awt.Color(0, 102, 255));
        buttonNow14.setColor2(new java.awt.Color(0, 102, 255));
        buttonNow14.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonNow14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNow14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout car14Layout = new javax.swing.GroupLayout(car14);
        car14.setLayout(car14Layout);
        car14Layout.setHorizontalGroup(
            car14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car14Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(car14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTypeCar14)
                    .addGroup(car14Layout.createSequentialGroup()
                        .addGroup(car14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbName14, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(car14Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(lbCar14)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addComponent(panelRound25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(car14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCounter14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceCounter14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceNow14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonNow14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDifference14, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        car14Layout.setVerticalGroup(
            car14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car14Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbPriceCounter14)
                .addGap(8, 8, 8)
                .addGroup(car14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car14Layout.createSequentialGroup()
                        .addComponent(buttonCounter14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbPriceNow14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonNow14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelRound25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(txtDifference14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(car14Layout.createSequentialGroup()
                .addGroup(car14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car14Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lbName14))
                    .addComponent(lbCar14, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(car14Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbTypeCar14)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        car15.setBackground(new java.awt.Color(255, 255, 255));

        lbCar15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/mazda_cx5.png"))); // NOI18N

        lbTypeCar15.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbTypeCar15.setForeground(new java.awt.Color(51, 51, 51));
        lbTypeCar15.setText("Type of Car");

        lbPriceCounter15.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceCounter15.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceCounter15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceCounter15.setText("$ Values");

        lbPriceNow15.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceNow15.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceNow15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceNow15.setText("$ Values");

        lbName15.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbName15.setForeground(new java.awt.Color(51, 51, 51));
        lbName15.setText("Name of car");

        lbDoor15.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbDoor15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbDoor15.setText("1");

        lbSeat15.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSeat15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSeat15.setText("1");

        lbType15.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbType15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbType15.setText("1");

        lbGas15.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbGas15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbGas15.setText("1");

        lbSmall15.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSmall15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSmall15.setText("1");

        lbLarge15.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbLarge15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbLarge15.setText("1");

        jLabel34.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Libre de humo");

        jLabel35.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(51, 51, 51));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Caracteristicas del Vehiculo");

        javax.swing.GroupLayout panelRound26Layout = new javax.swing.GroupLayout(panelRound26);
        panelRound26.setLayout(panelRound26Layout);
        panelRound26Layout.setHorizontalGroup(
            panelRound26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound26Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelRound26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbSeat15)
                            .addComponent(lbDoor15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbGas15)
                            .addComponent(lbType15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge15)
                            .addComponent(lbSmall15))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound26Layout.setVerticalGroup(
            panelRound26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound26Layout.createSequentialGroup()
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelRound26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound26Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSmall15))
                    .addGroup(panelRound26Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbType15))
                    .addGroup(panelRound26Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDoor15))
                    .addGroup(panelRound26Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(panelRound26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge15)
                            .addComponent(lbGas15)
                            .addComponent(lbSeat15))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jLabel34)
                .addContainerGap())
        );

        txtDifference15.setBackground(new java.awt.Color(51, 51, 51));
        txtDifference15.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txtDifference15.setForeground(new java.awt.Color(51, 51, 51));
        txtDifference15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDifference15.setText("Paga ahora y ahorra $1");

        buttonCounter15.setBackground(new java.awt.Color(255, 255, 255));
        buttonCounter15.setText("PAGAR EN CAJA");
        buttonCounter15.setColor2(new java.awt.Color(204, 204, 204));
        buttonCounter15.setEffectColor(new java.awt.Color(0, 0, 0));
        buttonCounter15.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonCounter15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCounter15ActionPerformed(evt);
            }
        });

        buttonNow15.setBackground(new java.awt.Color(0, 102, 255));
        buttonNow15.setForeground(new java.awt.Color(255, 255, 255));
        buttonNow15.setText("PAGAR YA");
        buttonNow15.setColor1(new java.awt.Color(0, 102, 255));
        buttonNow15.setColor2(new java.awt.Color(0, 102, 255));
        buttonNow15.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonNow15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNow15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout car15Layout = new javax.swing.GroupLayout(car15);
        car15.setLayout(car15Layout);
        car15Layout.setHorizontalGroup(
            car15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car15Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(car15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTypeCar15)
                    .addGroup(car15Layout.createSequentialGroup()
                        .addGroup(car15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbName15, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(car15Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(lbCar15)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addComponent(panelRound26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(car15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCounter15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceCounter15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceNow15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonNow15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDifference15, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        car15Layout.setVerticalGroup(
            car15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car15Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbPriceCounter15)
                .addGap(8, 8, 8)
                .addGroup(car15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car15Layout.createSequentialGroup()
                        .addComponent(buttonCounter15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbPriceNow15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonNow15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelRound26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(txtDifference15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(car15Layout.createSequentialGroup()
                .addGroup(car15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car15Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lbName15))
                    .addComponent(lbCar15, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(car15Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbTypeCar15)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        car16.setBackground(new java.awt.Color(255, 255, 255));

        lbCar16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/mazda_cx5.png"))); // NOI18N

        lbTypeCar16.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbTypeCar16.setForeground(new java.awt.Color(51, 51, 51));
        lbTypeCar16.setText("Type of Car");

        lbPriceCounter16.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceCounter16.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceCounter16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceCounter16.setText("$ Values");

        lbPriceNow16.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceNow16.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceNow16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceNow16.setText("$ Values");

        lbName16.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbName16.setForeground(new java.awt.Color(51, 51, 51));
        lbName16.setText("Name of car");

        lbDoor16.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbDoor16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbDoor16.setText("1");

        lbSeat16.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSeat16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSeat16.setText("1");

        lbType16.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbType16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbType16.setText("1");

        lbGas16.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbGas16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbGas16.setText("1");

        lbSmall16.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSmall16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSmall16.setText("1");

        lbLarge16.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbLarge16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbLarge16.setText("1");

        jLabel36.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Libre de humo");

        jLabel37.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(51, 51, 51));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Caracteristicas del Vehiculo");

        javax.swing.GroupLayout panelRound27Layout = new javax.swing.GroupLayout(panelRound27);
        panelRound27.setLayout(panelRound27Layout);
        panelRound27Layout.setHorizontalGroup(
            panelRound27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound27Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelRound27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbSeat16)
                            .addComponent(lbDoor16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbGas16)
                            .addComponent(lbType16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge16)
                            .addComponent(lbSmall16))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound27Layout.setVerticalGroup(
            panelRound27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound27Layout.createSequentialGroup()
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelRound27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound27Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSmall16))
                    .addGroup(panelRound27Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbType16))
                    .addGroup(panelRound27Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDoor16))
                    .addGroup(panelRound27Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(panelRound27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge16)
                            .addComponent(lbGas16)
                            .addComponent(lbSeat16))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jLabel36)
                .addContainerGap())
        );

        txtDifference16.setBackground(new java.awt.Color(51, 51, 51));
        txtDifference16.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txtDifference16.setForeground(new java.awt.Color(51, 51, 51));
        txtDifference16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDifference16.setText("Paga ahora y ahorra $1");

        buttonCounter16.setBackground(new java.awt.Color(255, 255, 255));
        buttonCounter16.setText("PAGAR EN CAJA");
        buttonCounter16.setColor2(new java.awt.Color(204, 204, 204));
        buttonCounter16.setEffectColor(new java.awt.Color(0, 0, 0));
        buttonCounter16.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonCounter16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCounter16ActionPerformed(evt);
            }
        });

        buttonNow16.setBackground(new java.awt.Color(0, 102, 255));
        buttonNow16.setForeground(new java.awt.Color(255, 255, 255));
        buttonNow16.setText("PAGAR YA");
        buttonNow16.setColor1(new java.awt.Color(0, 102, 255));
        buttonNow16.setColor2(new java.awt.Color(0, 102, 255));
        buttonNow16.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonNow16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNow16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout car16Layout = new javax.swing.GroupLayout(car16);
        car16.setLayout(car16Layout);
        car16Layout.setHorizontalGroup(
            car16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car16Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(car16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTypeCar16)
                    .addGroup(car16Layout.createSequentialGroup()
                        .addGroup(car16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbName16, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(car16Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(lbCar16)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addComponent(panelRound27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(car16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCounter16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceCounter16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceNow16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonNow16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDifference16, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        car16Layout.setVerticalGroup(
            car16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car16Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(lbPriceCounter16)
                .addGap(8, 8, 8)
                .addGroup(car16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car16Layout.createSequentialGroup()
                        .addComponent(buttonCounter16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbPriceNow16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonNow16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelRound27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(txtDifference16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(car16Layout.createSequentialGroup()
                .addGroup(car16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car16Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lbName16))
                    .addComponent(lbCar16, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(car16Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbTypeCar16)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        car17.setBackground(new java.awt.Color(255, 255, 255));

        lbCar17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/mazda_cx5.png"))); // NOI18N

        lbTypeCar17.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbTypeCar17.setForeground(new java.awt.Color(51, 51, 51));
        lbTypeCar17.setText("Type of Car");

        lbPriceCounter17.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceCounter17.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceCounter17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceCounter17.setText("$ Values");

        lbPriceNow17.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceNow17.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceNow17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceNow17.setText("$ Values");

        lbName17.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbName17.setForeground(new java.awt.Color(51, 51, 51));
        lbName17.setText("Name of car");

        lbDoor17.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbDoor17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbDoor17.setText("1");

        lbSeat17.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSeat17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSeat17.setText("1");

        lbType17.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbType17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbType17.setText("1");

        lbGas17.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbGas17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbGas17.setText("1");

        lbSmall17.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSmall17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSmall17.setText("1");

        lbLarge17.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbLarge17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbLarge17.setText("1");

        jLabel38.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Libre de humo");

        jLabel39.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(51, 51, 51));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Caracteristicas del Vehiculo");

        javax.swing.GroupLayout panelRound28Layout = new javax.swing.GroupLayout(panelRound28);
        panelRound28.setLayout(panelRound28Layout);
        panelRound28Layout.setHorizontalGroup(
            panelRound28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound28Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelRound28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbSeat17)
                            .addComponent(lbDoor17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbGas17)
                            .addComponent(lbType17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge17)
                            .addComponent(lbSmall17))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound28Layout.setVerticalGroup(
            panelRound28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound28Layout.createSequentialGroup()
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelRound28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound28Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSmall17))
                    .addGroup(panelRound28Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbType17))
                    .addGroup(panelRound28Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDoor17))
                    .addGroup(panelRound28Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(panelRound28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge17)
                            .addComponent(lbGas17)
                            .addComponent(lbSeat17))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jLabel38)
                .addContainerGap())
        );

        txtDifference17.setBackground(new java.awt.Color(51, 51, 51));
        txtDifference17.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txtDifference17.setForeground(new java.awt.Color(51, 51, 51));
        txtDifference17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDifference17.setText("Paga ahora y ahorra $1");

        buttonCounter17.setBackground(new java.awt.Color(255, 255, 255));
        buttonCounter17.setText("PAGAR EN CAJA");
        buttonCounter17.setColor2(new java.awt.Color(204, 204, 204));
        buttonCounter17.setEffectColor(new java.awt.Color(0, 0, 0));
        buttonCounter17.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonCounter17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCounter17ActionPerformed(evt);
            }
        });

        buttonNow17.setBackground(new java.awt.Color(0, 102, 255));
        buttonNow17.setForeground(new java.awt.Color(255, 255, 255));
        buttonNow17.setText("PAGAR YA");
        buttonNow17.setColor1(new java.awt.Color(0, 102, 255));
        buttonNow17.setColor2(new java.awt.Color(0, 102, 255));
        buttonNow17.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonNow17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNow17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout car17Layout = new javax.swing.GroupLayout(car17);
        car17.setLayout(car17Layout);
        car17Layout.setHorizontalGroup(
            car17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car17Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(car17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTypeCar17)
                    .addGroup(car17Layout.createSequentialGroup()
                        .addGroup(car17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbName17, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(car17Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(lbCar17)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addComponent(panelRound28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(car17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCounter17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceCounter17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceNow17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonNow17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDifference17, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        car17Layout.setVerticalGroup(
            car17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car17Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(lbPriceCounter17)
                .addGap(8, 8, 8)
                .addGroup(car17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car17Layout.createSequentialGroup()
                        .addComponent(buttonCounter17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbPriceNow17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonNow17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelRound28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(txtDifference17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(car17Layout.createSequentialGroup()
                .addGroup(car17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car17Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lbName17))
                    .addComponent(lbCar17, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(car17Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbTypeCar17)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        car18.setBackground(new java.awt.Color(255, 255, 255));

        lbCar18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/mazda_cx5.png"))); // NOI18N

        lbTypeCar18.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbTypeCar18.setForeground(new java.awt.Color(51, 51, 51));
        lbTypeCar18.setText("Type of Car");

        lbPriceCounter18.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceCounter18.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceCounter18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceCounter18.setText("$ Values");

        lbPriceNow18.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceNow18.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceNow18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceNow18.setText("$ Values");

        lbName18.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbName18.setForeground(new java.awt.Color(51, 51, 51));
        lbName18.setText("Name of car");

        lbDoor18.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbDoor18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbDoor18.setText("1");

        lbSeat18.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSeat18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSeat18.setText("1");

        lbType18.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbType18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbType18.setText("1");

        lbGas18.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbGas18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbGas18.setText("1");

        lbSmall18.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSmall18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSmall18.setText("1");

        lbLarge18.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbLarge18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbLarge18.setText("1");

        jLabel40.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Libre de humo");

        jLabel41.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(51, 51, 51));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Caracteristicas del Vehiculo");

        javax.swing.GroupLayout panelRound29Layout = new javax.swing.GroupLayout(panelRound29);
        panelRound29.setLayout(panelRound29Layout);
        panelRound29Layout.setHorizontalGroup(
            panelRound29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound29Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelRound29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbSeat18)
                            .addComponent(lbDoor18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbGas18)
                            .addComponent(lbType18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge18)
                            .addComponent(lbSmall18))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound29Layout.setVerticalGroup(
            panelRound29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound29Layout.createSequentialGroup()
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelRound29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound29Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSmall18))
                    .addGroup(panelRound29Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbType18))
                    .addGroup(panelRound29Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDoor18))
                    .addGroup(panelRound29Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(panelRound29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge18)
                            .addComponent(lbGas18)
                            .addComponent(lbSeat18))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jLabel40)
                .addContainerGap())
        );

        txtDifference18.setBackground(new java.awt.Color(51, 51, 51));
        txtDifference18.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txtDifference18.setForeground(new java.awt.Color(51, 51, 51));
        txtDifference18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDifference18.setText("Paga ahora y ahorra $1");

        buttonCounter18.setBackground(new java.awt.Color(255, 255, 255));
        buttonCounter18.setText("PAGAR EN CAJA");
        buttonCounter18.setColor2(new java.awt.Color(204, 204, 204));
        buttonCounter18.setEffectColor(new java.awt.Color(0, 0, 0));
        buttonCounter18.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonCounter18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCounter18ActionPerformed(evt);
            }
        });

        buttonNow18.setBackground(new java.awt.Color(0, 102, 255));
        buttonNow18.setForeground(new java.awt.Color(255, 255, 255));
        buttonNow18.setText("PAGAR YA");
        buttonNow18.setColor1(new java.awt.Color(0, 102, 255));
        buttonNow18.setColor2(new java.awt.Color(0, 102, 255));
        buttonNow18.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonNow18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNow18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout car18Layout = new javax.swing.GroupLayout(car18);
        car18.setLayout(car18Layout);
        car18Layout.setHorizontalGroup(
            car18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car18Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(car18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTypeCar18)
                    .addGroup(car18Layout.createSequentialGroup()
                        .addGroup(car18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbName18, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(car18Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(lbCar18)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addComponent(panelRound29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(car18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCounter18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceCounter18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceNow18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonNow18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDifference18, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        car18Layout.setVerticalGroup(
            car18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car18Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbPriceCounter18)
                .addGap(8, 8, 8)
                .addGroup(car18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car18Layout.createSequentialGroup()
                        .addComponent(buttonCounter18, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbPriceNow18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonNow18, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelRound29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(txtDifference18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(car18Layout.createSequentialGroup()
                .addGroup(car18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car18Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lbName18))
                    .addComponent(lbCar18, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(car18Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbTypeCar18)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        car2.setBackground(new java.awt.Color(255, 255, 255));

        lbCar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/mazda_cx5.png"))); // NOI18N

        lbTypeCar2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbTypeCar2.setForeground(new java.awt.Color(51, 51, 51));
        lbTypeCar2.setText("Type of Car");

        lbPriceCounter2.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceCounter2.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceCounter2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceCounter2.setText("$ Values");

        lbPriceNow2.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbPriceNow2.setForeground(new java.awt.Color(51, 51, 51));
        lbPriceNow2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPriceNow2.setText("$ Values");

        lbName2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbName2.setForeground(new java.awt.Color(51, 51, 51));
        lbName2.setText("Name of car");

        lbDoor2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbDoor2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbDoor2.setText("1");

        lbSeat2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSeat2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSeat2.setText("1");

        lbType2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbType2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbType2.setText("1");

        lbGas2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbGas2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbGas2.setText("1");

        lbSmall2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbSmall2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbSmall2.setText("1");

        lbLarge2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbLarge2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/door.png"))); // NOI18N
        lbLarge2.setText("1");

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Libre de humo");

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Caracteristicas del Vehiculo");

        javax.swing.GroupLayout panelRound13Layout = new javax.swing.GroupLayout(panelRound13);
        panelRound13.setLayout(panelRound13Layout);
        panelRound13Layout.setHorizontalGroup(
            panelRound13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound13Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelRound13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbSeat2)
                            .addComponent(lbDoor2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbGas2)
                            .addComponent(lbType2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge2)
                            .addComponent(lbSmall2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelRound13Layout.setVerticalGroup(
            panelRound13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound13Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelRound13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound13Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSmall2))
                    .addGroup(panelRound13Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbType2))
                    .addGroup(panelRound13Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDoor2))
                    .addGroup(panelRound13Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(panelRound13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLarge2)
                            .addComponent(lbGas2)
                            .addComponent(lbSeat2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap())
        );

        txtDifference2.setBackground(new java.awt.Color(51, 51, 51));
        txtDifference2.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        txtDifference2.setForeground(new java.awt.Color(51, 51, 51));
        txtDifference2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDifference2.setText("Paga ahora y ahorra $1");

        buttonCounter2.setBackground(new java.awt.Color(255, 255, 255));
        buttonCounter2.setText("PAGAR EN CAJA");
        buttonCounter2.setColor2(new java.awt.Color(204, 204, 204));
        buttonCounter2.setEffectColor(new java.awt.Color(0, 0, 0));
        buttonCounter2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonCounter2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCounter2ActionPerformed(evt);
            }
        });

        buttonNow2.setBackground(new java.awt.Color(0, 102, 255));
        buttonNow2.setForeground(new java.awt.Color(255, 255, 255));
        buttonNow2.setText("PAGAR YA");
        buttonNow2.setColor1(new java.awt.Color(0, 102, 255));
        buttonNow2.setColor2(new java.awt.Color(0, 102, 255));
        buttonNow2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonNow2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNow2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout car2Layout = new javax.swing.GroupLayout(car2);
        car2.setLayout(car2Layout);
        car2Layout.setHorizontalGroup(
            car2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(car2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTypeCar2)
                    .addGroup(car2Layout.createSequentialGroup()
                        .addGroup(car2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbName2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(car2Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(lbCar2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addComponent(panelRound13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(car2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCounter2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceCounter2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbPriceNow2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonNow2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDifference2, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        car2Layout.setVerticalGroup(
            car2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(car2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbPriceCounter2)
                .addGap(8, 8, 8)
                .addGroup(car2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car2Layout.createSequentialGroup()
                        .addComponent(buttonCounter2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbPriceNow2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonNow2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelRound13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(txtDifference2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(car2Layout.createSequentialGroup()
                .addGroup(car2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(car2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lbName2))
                    .addComponent(lbCar2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(car2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbTypeCar2)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setHorizontalScrollBar(null);

        panelRound2.setBackground(new java.awt.Color(245, 245, 245));

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1080, Short.MAX_VALUE)
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 664, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panelRound2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/Part2.png"))); // NOI18N

        buttonBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/login/back1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        comboSelect.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos" }));
        comboSelect.setSelectedIndex(-1);
        comboSelect.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        comboSelect.setLabeText("Mostrar:");
        comboSelect.setLineColor(new java.awt.Color(0, 102, 255));

        comboOrder.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Precio (Menor a Mayor)", "Alfabeticamente", "Kilometraje (Mayor a Menor)", "Numero de Asientos" }));
        comboOrder.setSelectedIndex(-1);
        comboOrder.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        comboOrder.setLabeText("Ordenar por:");
        comboOrder.setLineColor(new java.awt.Color(0, 102, 255));

        detailsReturn.setBackground(new java.awt.Color(255, 255, 255));

        detailsPU.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setForeground(new java.awt.Color(153, 153, 153));

        panelBar.setBackground(new java.awt.Color(204, 204, 204));
        panelBar.setLayout(new java.awt.CardLayout());

        buttonSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/search.png"))); // NOI18N
        buttonSearch.setEffectColor(new java.awt.Color(0, 0, 0));
        buttonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(detailsPU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(detailsReturn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboOrder, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addComponent(panelBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(comboSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(detailsPU, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(detailsReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCounterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCounterActionPerformed
        clear();
        car0.setBackground(new Color(220, 220, 220));
        setCarSelected(lbName.getText());
        setTypeRent("Counter");
        panelBar.removeAll();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
    }//GEN-LAST:event_buttonCounterActionPerformed

    private void buttonNowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNowActionPerformed
        clear();
        car0.setBackground(new Color(153, 204, 255));
        setCarSelected(lbName.getText());
        setTypeRent("Now");
        panelBar.removeAll();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
    }//GEN-LAST:event_buttonNowActionPerformed

    private void buttonCounter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCounter1ActionPerformed
        clear();
        car1.setBackground(new Color(220, 220, 220));
        setCarSelected(lbName1.getText());
        setTypeRent("Counter");
        panelBar.removeAll();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
    }//GEN-LAST:event_buttonCounter1ActionPerformed

    private void buttonNow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNow1ActionPerformed
        clear();
        car1.setBackground(new Color(153, 204, 255));
        setCarSelected(lbName1.getText());
        setTypeRent("Now");
        panelBar.removeAll();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
    }//GEN-LAST:event_buttonNow1ActionPerformed

    private void buttonCounter2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCounter2ActionPerformed
        clear();
        car2.setBackground(new Color(220, 220, 220));
        setCarSelected(lbName2.getText());
        setTypeRent("Counter");
        panelBar.removeAll();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
    }//GEN-LAST:event_buttonCounter2ActionPerformed

    private void buttonNow2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNow2ActionPerformed
        clear();
        car2.setBackground(new Color(153, 204, 255));
        setCarSelected(lbName2.getText());
        setTypeRent("Now");
        panelBar.removeAll();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
    }//GEN-LAST:event_buttonNow2ActionPerformed

    private void buttonCounter3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCounter3ActionPerformed
        clear();
        car3.setBackground(new Color(220, 220, 220));
        setCarSelected(lbName3.getText());
        setTypeRent("Counter");
        panelBar.removeAll();
        panelBar.add(panelContinue);
    }//GEN-LAST:event_buttonCounter3ActionPerformed

    private void buttonNow3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNow3ActionPerformed
        clear();
        car3.setBackground(new Color(153, 204, 255));
        setCarSelected(lbName3.getText());
        setTypeRent("Now");
        panelBar.removeAll();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
    }//GEN-LAST:event_buttonNow3ActionPerformed

    private void buttonCounter4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCounter4ActionPerformed
        clear();
        car4.setBackground(new Color(220, 220, 220));
        setCarSelected(lbName4.getText());
        setTypeRent("Counter");
        panelBar.removeAll();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
    }//GEN-LAST:event_buttonCounter4ActionPerformed

    private void buttonNow4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNow4ActionPerformed
        clear();
        car4.setBackground(new Color(153, 204, 255));
        setCarSelected(lbName4.getText());
        setTypeRent("Now");
        panelBar.removeAll();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
    }//GEN-LAST:event_buttonNow4ActionPerformed

    private void buttonCounter5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCounter5ActionPerformed
        clear();
        car5.setBackground(new Color(220, 220, 220));
        setCarSelected(lbName5.getText());
        setTypeRent("Counter");
        panelBar.removeAll();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
    }//GEN-LAST:event_buttonCounter5ActionPerformed

    private void buttonNow5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNow5ActionPerformed
        clear();
        car5.setBackground(new Color(153, 204, 255));
        setCarSelected(lbName5.getText());
        setTypeRent("Now");
        panelBar.removeAll();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
    }//GEN-LAST:event_buttonNow5ActionPerformed

    private void buttonCounter6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCounter6ActionPerformed
        clear();
        car6.setBackground(new Color(220, 220, 220));
        setCarSelected(lbName6.getText());
        setTypeRent("Counter");
        panelBar.removeAll();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
    }//GEN-LAST:event_buttonCounter6ActionPerformed

    private void buttonNow6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNow6ActionPerformed
        clear();
        car6.setBackground(new Color(153, 204, 255));
        setCarSelected(lbName6.getText());
        setTypeRent("Now");
        panelBar.removeAll();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
    }//GEN-LAST:event_buttonNow6ActionPerformed

    private void buttonCounter7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCounter7ActionPerformed
        clear();
        car7.setBackground(new Color(220, 220, 220));
        setCarSelected(lbName7.getText());
        setTypeRent("Counter");
        panelBar.removeAll();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
    }//GEN-LAST:event_buttonCounter7ActionPerformed

    private void buttonNow7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNow7ActionPerformed
        clear();
        car7.setBackground(new Color(153, 204, 255));
        setCarSelected(lbName7.getText());
        setTypeRent("Now");
        panelBar.removeAll();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
    }//GEN-LAST:event_buttonNow7ActionPerformed

    private void buttonCounter8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCounter8ActionPerformed
        clear();
        car8.setBackground(new Color(220, 220, 220));
        setCarSelected(lbName8.getText());
        setTypeRent("Counter");
        panelBar.removeAll();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
    }//GEN-LAST:event_buttonCounter8ActionPerformed

    private void buttonNow8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNow8ActionPerformed
        clear();
        car8.setBackground(new Color(153, 204, 255));
        setCarSelected(lbName8.getText());
        setTypeRent("Now");
        panelBar.removeAll();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
    }//GEN-LAST:event_buttonNow8ActionPerformed

    private void buttonCounter9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCounter9ActionPerformed
        clear();
        car9.setBackground(new Color(220, 220, 220));
        setCarSelected(lbName9.getText());
        setTypeRent("Counter");
        panelBar.removeAll();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
    }//GEN-LAST:event_buttonCounter9ActionPerformed

    private void buttonNow9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNow9ActionPerformed
        clear();
        car9.setBackground(new Color(153, 204, 255));
        setCarSelected(lbName9.getText());
        setTypeRent("Now");
        panelBar.removeAll();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
    }//GEN-LAST:event_buttonNow9ActionPerformed

    private void buttonCounter10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCounter10ActionPerformed
        clear();
        car10.setBackground(new Color(220, 220, 220));
        setCarSelected(lbName10.getText());
        setTypeRent("Counter");
        panelBar.removeAll();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
    }//GEN-LAST:event_buttonCounter10ActionPerformed

    private void buttonNow10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNow10ActionPerformed
        clear();
        car10.setBackground(new Color(153, 204, 255));
        setCarSelected(lbName10.getText());
        setTypeRent("Now");
        panelBar.removeAll();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
    }//GEN-LAST:event_buttonNow10ActionPerformed

    private void buttonCounter11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCounter11ActionPerformed
        clear();
        car11.setBackground(new Color(220, 220, 220));
        setCarSelected(lbName11.getText());
        setTypeRent("Counter");
        panelBar.removeAll();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
    }//GEN-LAST:event_buttonCounter11ActionPerformed

    private void buttonNow11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNow11ActionPerformed
        clear();
        car11.setBackground(new Color(153, 204, 255));
        setCarSelected(lbName11.getText());
        setTypeRent("Now");
        panelBar.removeAll();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
    }//GEN-LAST:event_buttonNow11ActionPerformed

    private void buttonCounter12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCounter12ActionPerformed
        clear();
        car12.setBackground(new Color(220, 220, 220));
        setCarSelected(lbName12.getText());
        setTypeRent("Counter");
        panelBar.removeAll();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
    }//GEN-LAST:event_buttonCounter12ActionPerformed

    private void buttonNow12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNow12ActionPerformed
        clear();
        car12.setBackground(new Color(153, 204, 255));
        setCarSelected(lbName12.getText());
        setTypeRent("Now");
        panelBar.removeAll();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
    }//GEN-LAST:event_buttonNow12ActionPerformed

    private void buttonCounter13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCounter13ActionPerformed
        clear();
        car13.setBackground(new Color(220, 220, 220));
        setCarSelected(lbName13.getText());
        setTypeRent("Counter");
        panelBar.removeAll();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
    }//GEN-LAST:event_buttonCounter13ActionPerformed

    private void buttonNow13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNow13ActionPerformed
        clear();
        car13.setBackground(new Color(153, 204, 255));
        setCarSelected(lbName13.getText());
        setTypeRent("Now");
        panelBar.removeAll();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
    }//GEN-LAST:event_buttonNow13ActionPerformed

    private void buttonCounter14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCounter14ActionPerformed
        clear();
        car14.setBackground(new Color(220, 220, 220));
        setCarSelected(lbName14.getText());
        setTypeRent("Counter");
        panelBar.removeAll();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
    }//GEN-LAST:event_buttonCounter14ActionPerformed

    private void buttonNow14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNow14ActionPerformed
        clear();
        car14.setBackground(new Color(153, 204, 255));
        setCarSelected(lbName14.getText());
        setTypeRent("Now");
        panelBar.removeAll();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
    }//GEN-LAST:event_buttonNow14ActionPerformed

    private void buttonCounter15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCounter15ActionPerformed
        clear();
        car15.setBackground(new Color(220, 220, 220));
        setCarSelected(lbName15.getText());
        setTypeRent("Counter");
        panelBar.removeAll();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
    }//GEN-LAST:event_buttonCounter15ActionPerformed

    private void buttonNow15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNow15ActionPerformed
        clear();
        car15.setBackground(new Color(153, 204, 255));
        setCarSelected(lbName15.getText());
        setTypeRent("Now");
        panelBar.removeAll();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
    }//GEN-LAST:event_buttonNow15ActionPerformed

    private void buttonCounter16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCounter16ActionPerformed
        clear();
        car16.setBackground(new Color(220, 220, 220));
        setCarSelected(lbName16.getText());
        setTypeRent("Counter");
        panelBar.removeAll();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
    }//GEN-LAST:event_buttonCounter16ActionPerformed

    private void buttonNow16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNow16ActionPerformed
        clear();
        car16.setBackground(new Color(153, 204, 255));
        setCarSelected(lbName16.getText());
        setTypeRent("Now");
        panelBar.removeAll();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
    }//GEN-LAST:event_buttonNow16ActionPerformed

    private void buttonCounter17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCounter17ActionPerformed
        clear();
        car17.setBackground(new Color(220, 220, 220));
        setCarSelected(lbName17.getText());
        setTypeRent("Counter");
        panelBar.removeAll();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
    }//GEN-LAST:event_buttonCounter17ActionPerformed

    private void buttonNow17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNow17ActionPerformed
        clear();
        car17.setBackground(new Color(153, 204, 255));
        setCarSelected(lbName17.getText());
        setTypeRent("Now");
        panelBar.removeAll();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
    }//GEN-LAST:event_buttonNow17ActionPerformed

    private void buttonCounter18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCounter18ActionPerformed
        clear();
        car18.setBackground(new Color(220, 220, 220));
        setCarSelected(lbName18.getText());
        setTypeRent("Counter");
        panelBar.removeAll();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
    }//GEN-LAST:event_buttonCounter18ActionPerformed

    private void buttonNow18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNow18ActionPerformed
        clear();
        car18.setBackground(new Color(153, 204, 255));
        setCarSelected(lbName18.getText());
        setTypeRent("Now");
        panelBar.removeAll();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
    }//GEN-LAST:event_buttonNow18ActionPerformed

    private void buttonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchActionPerformed
        panelRound2.removeAll();
        panelRound2.repaint();
        panelRound2.revalidate();
        panelBar.removeAll();
        panelBar.repaint();
        panelBar.revalidate();
        clear();
        if (comboSelect.getSelectedIndex() != -1 && comboOrder.getSelectedIndex() != -1) {
            initTableData(comboSelect.getSelectedItem().toString(), comboOrder.getSelectedItem().toString());
        } else if (comboSelect.getSelectedIndex() != -1) {
            initTableData(comboSelect.getSelectedItem().toString(), "");
        } else if (comboOrder.getSelectedIndex() != -1) {
            initTableData("", comboOrder.getSelectedItem().toString());
        } else {
            initTableData("", "");
        }
    }//GEN-LAST:event_buttonSearchActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.login.Close1Button buttonBack;
    private swing.login.Button buttonContinue;
    private swing.login.Button1 buttonCounter;
    private swing.login.Button1 buttonCounter1;
    private swing.login.Button1 buttonCounter10;
    private swing.login.Button1 buttonCounter11;
    private swing.login.Button1 buttonCounter12;
    private swing.login.Button1 buttonCounter13;
    private swing.login.Button1 buttonCounter14;
    private swing.login.Button1 buttonCounter15;
    private swing.login.Button1 buttonCounter16;
    private swing.login.Button1 buttonCounter17;
    private swing.login.Button1 buttonCounter18;
    private swing.login.Button1 buttonCounter2;
    private swing.login.Button1 buttonCounter3;
    private swing.login.Button1 buttonCounter4;
    private swing.login.Button1 buttonCounter5;
    private swing.login.Button1 buttonCounter6;
    private swing.login.Button1 buttonCounter7;
    private swing.login.Button1 buttonCounter8;
    private swing.login.Button1 buttonCounter9;
    private swing.login.Button1 buttonNow;
    private swing.login.Button1 buttonNow1;
    private swing.login.Button1 buttonNow10;
    private swing.login.Button1 buttonNow11;
    private swing.login.Button1 buttonNow12;
    private swing.login.Button1 buttonNow13;
    private swing.login.Button1 buttonNow14;
    private swing.login.Button1 buttonNow15;
    private swing.login.Button1 buttonNow16;
    private swing.login.Button1 buttonNow17;
    private swing.login.Button1 buttonNow18;
    private swing.login.Button1 buttonNow2;
    private swing.login.Button1 buttonNow3;
    private swing.login.Button1 buttonNow4;
    private swing.login.Button1 buttonNow5;
    private swing.login.Button1 buttonNow6;
    private swing.login.Button1 buttonNow7;
    private swing.login.Button1 buttonNow8;
    private swing.login.Button1 buttonNow9;
    private swing.login.Button buttonSearch;
    private javax.swing.JPanel car0;
    private javax.swing.JPanel car1;
    private javax.swing.JPanel car10;
    private javax.swing.JPanel car11;
    private javax.swing.JPanel car12;
    private javax.swing.JPanel car13;
    private javax.swing.JPanel car14;
    private javax.swing.JPanel car15;
    private javax.swing.JPanel car16;
    private javax.swing.JPanel car17;
    private javax.swing.JPanel car18;
    private javax.swing.JPanel car2;
    private javax.swing.JPanel car3;
    private javax.swing.JPanel car4;
    private javax.swing.JPanel car5;
    private javax.swing.JPanel car6;
    private javax.swing.JPanel car7;
    private javax.swing.JPanel car8;
    private javax.swing.JPanel car9;
    private swing.login.Combobox comboOrder;
    private swing.login.Combobox comboSelect;
    private com.raven.component.DetailsCard detailsPU;
    private com.raven.component.DetailsCard detailsReturn;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbCar;
    private javax.swing.JLabel lbCar1;
    private javax.swing.JLabel lbCar10;
    private javax.swing.JLabel lbCar11;
    private javax.swing.JLabel lbCar12;
    private javax.swing.JLabel lbCar13;
    private javax.swing.JLabel lbCar14;
    private javax.swing.JLabel lbCar15;
    private javax.swing.JLabel lbCar16;
    private javax.swing.JLabel lbCar17;
    private javax.swing.JLabel lbCar18;
    private javax.swing.JLabel lbCar2;
    private javax.swing.JLabel lbCar3;
    private javax.swing.JLabel lbCar4;
    private javax.swing.JLabel lbCar5;
    private javax.swing.JLabel lbCar6;
    private javax.swing.JLabel lbCar7;
    private javax.swing.JLabel lbCar8;
    private javax.swing.JLabel lbCar9;
    private javax.swing.JLabel lbDoor;
    private javax.swing.JLabel lbDoor1;
    private javax.swing.JLabel lbDoor10;
    private javax.swing.JLabel lbDoor11;
    private javax.swing.JLabel lbDoor12;
    private javax.swing.JLabel lbDoor13;
    private javax.swing.JLabel lbDoor14;
    private javax.swing.JLabel lbDoor15;
    private javax.swing.JLabel lbDoor16;
    private javax.swing.JLabel lbDoor17;
    private javax.swing.JLabel lbDoor18;
    private javax.swing.JLabel lbDoor2;
    private javax.swing.JLabel lbDoor3;
    private javax.swing.JLabel lbDoor4;
    private javax.swing.JLabel lbDoor5;
    private javax.swing.JLabel lbDoor6;
    private javax.swing.JLabel lbDoor7;
    private javax.swing.JLabel lbDoor8;
    private javax.swing.JLabel lbDoor9;
    private javax.swing.JLabel lbGas;
    private javax.swing.JLabel lbGas1;
    private javax.swing.JLabel lbGas10;
    private javax.swing.JLabel lbGas11;
    private javax.swing.JLabel lbGas12;
    private javax.swing.JLabel lbGas13;
    private javax.swing.JLabel lbGas14;
    private javax.swing.JLabel lbGas15;
    private javax.swing.JLabel lbGas16;
    private javax.swing.JLabel lbGas17;
    private javax.swing.JLabel lbGas18;
    private javax.swing.JLabel lbGas2;
    private javax.swing.JLabel lbGas3;
    private javax.swing.JLabel lbGas4;
    private javax.swing.JLabel lbGas5;
    private javax.swing.JLabel lbGas6;
    private javax.swing.JLabel lbGas7;
    private javax.swing.JLabel lbGas8;
    private javax.swing.JLabel lbGas9;
    private javax.swing.JLabel lbLarge;
    private javax.swing.JLabel lbLarge1;
    private javax.swing.JLabel lbLarge10;
    private javax.swing.JLabel lbLarge11;
    private javax.swing.JLabel lbLarge12;
    private javax.swing.JLabel lbLarge13;
    private javax.swing.JLabel lbLarge14;
    private javax.swing.JLabel lbLarge15;
    private javax.swing.JLabel lbLarge16;
    private javax.swing.JLabel lbLarge17;
    private javax.swing.JLabel lbLarge18;
    private javax.swing.JLabel lbLarge2;
    private javax.swing.JLabel lbLarge3;
    private javax.swing.JLabel lbLarge4;
    private javax.swing.JLabel lbLarge5;
    private javax.swing.JLabel lbLarge6;
    private javax.swing.JLabel lbLarge7;
    private javax.swing.JLabel lbLarge8;
    private javax.swing.JLabel lbLarge9;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbName1;
    private javax.swing.JLabel lbName10;
    private javax.swing.JLabel lbName11;
    private javax.swing.JLabel lbName12;
    private javax.swing.JLabel lbName13;
    private javax.swing.JLabel lbName14;
    private javax.swing.JLabel lbName15;
    private javax.swing.JLabel lbName16;
    private javax.swing.JLabel lbName17;
    private javax.swing.JLabel lbName18;
    private javax.swing.JLabel lbName2;
    private javax.swing.JLabel lbName3;
    private javax.swing.JLabel lbName4;
    private javax.swing.JLabel lbName5;
    private javax.swing.JLabel lbName6;
    private javax.swing.JLabel lbName7;
    private javax.swing.JLabel lbName8;
    private javax.swing.JLabel lbName9;
    private javax.swing.JLabel lbPriceCounter;
    private javax.swing.JLabel lbPriceCounter1;
    private javax.swing.JLabel lbPriceCounter10;
    private javax.swing.JLabel lbPriceCounter11;
    private javax.swing.JLabel lbPriceCounter12;
    private javax.swing.JLabel lbPriceCounter13;
    private javax.swing.JLabel lbPriceCounter14;
    private javax.swing.JLabel lbPriceCounter15;
    private javax.swing.JLabel lbPriceCounter16;
    private javax.swing.JLabel lbPriceCounter17;
    private javax.swing.JLabel lbPriceCounter18;
    private javax.swing.JLabel lbPriceCounter2;
    private javax.swing.JLabel lbPriceCounter3;
    private javax.swing.JLabel lbPriceCounter4;
    private javax.swing.JLabel lbPriceCounter5;
    private javax.swing.JLabel lbPriceCounter6;
    private javax.swing.JLabel lbPriceCounter7;
    private javax.swing.JLabel lbPriceCounter8;
    private javax.swing.JLabel lbPriceCounter9;
    private javax.swing.JLabel lbPriceNow;
    private javax.swing.JLabel lbPriceNow1;
    private javax.swing.JLabel lbPriceNow10;
    private javax.swing.JLabel lbPriceNow11;
    private javax.swing.JLabel lbPriceNow12;
    private javax.swing.JLabel lbPriceNow13;
    private javax.swing.JLabel lbPriceNow14;
    private javax.swing.JLabel lbPriceNow15;
    private javax.swing.JLabel lbPriceNow16;
    private javax.swing.JLabel lbPriceNow17;
    private javax.swing.JLabel lbPriceNow18;
    private javax.swing.JLabel lbPriceNow2;
    private javax.swing.JLabel lbPriceNow3;
    private javax.swing.JLabel lbPriceNow4;
    private javax.swing.JLabel lbPriceNow5;
    private javax.swing.JLabel lbPriceNow6;
    private javax.swing.JLabel lbPriceNow7;
    private javax.swing.JLabel lbPriceNow8;
    private javax.swing.JLabel lbPriceNow9;
    private javax.swing.JLabel lbSeat;
    private javax.swing.JLabel lbSeat1;
    private javax.swing.JLabel lbSeat10;
    private javax.swing.JLabel lbSeat11;
    private javax.swing.JLabel lbSeat12;
    private javax.swing.JLabel lbSeat13;
    private javax.swing.JLabel lbSeat14;
    private javax.swing.JLabel lbSeat15;
    private javax.swing.JLabel lbSeat16;
    private javax.swing.JLabel lbSeat17;
    private javax.swing.JLabel lbSeat18;
    private javax.swing.JLabel lbSeat2;
    private javax.swing.JLabel lbSeat3;
    private javax.swing.JLabel lbSeat4;
    private javax.swing.JLabel lbSeat5;
    private javax.swing.JLabel lbSeat6;
    private javax.swing.JLabel lbSeat7;
    private javax.swing.JLabel lbSeat8;
    private javax.swing.JLabel lbSeat9;
    private javax.swing.JLabel lbSmall;
    private javax.swing.JLabel lbSmall1;
    private javax.swing.JLabel lbSmall10;
    private javax.swing.JLabel lbSmall11;
    private javax.swing.JLabel lbSmall12;
    private javax.swing.JLabel lbSmall13;
    private javax.swing.JLabel lbSmall14;
    private javax.swing.JLabel lbSmall15;
    private javax.swing.JLabel lbSmall16;
    private javax.swing.JLabel lbSmall17;
    private javax.swing.JLabel lbSmall18;
    private javax.swing.JLabel lbSmall2;
    private javax.swing.JLabel lbSmall3;
    private javax.swing.JLabel lbSmall4;
    private javax.swing.JLabel lbSmall5;
    private javax.swing.JLabel lbSmall6;
    private javax.swing.JLabel lbSmall7;
    private javax.swing.JLabel lbSmall8;
    private javax.swing.JLabel lbSmall9;
    private javax.swing.JLabel lbType;
    private javax.swing.JLabel lbType1;
    private javax.swing.JLabel lbType10;
    private javax.swing.JLabel lbType11;
    private javax.swing.JLabel lbType12;
    private javax.swing.JLabel lbType13;
    private javax.swing.JLabel lbType14;
    private javax.swing.JLabel lbType15;
    private javax.swing.JLabel lbType16;
    private javax.swing.JLabel lbType17;
    private javax.swing.JLabel lbType18;
    private javax.swing.JLabel lbType2;
    private javax.swing.JLabel lbType3;
    private javax.swing.JLabel lbType4;
    private javax.swing.JLabel lbType5;
    private javax.swing.JLabel lbType6;
    private javax.swing.JLabel lbType7;
    private javax.swing.JLabel lbType8;
    private javax.swing.JLabel lbType9;
    private javax.swing.JLabel lbTypeCar;
    private javax.swing.JLabel lbTypeCar1;
    private javax.swing.JLabel lbTypeCar10;
    private javax.swing.JLabel lbTypeCar11;
    private javax.swing.JLabel lbTypeCar12;
    private javax.swing.JLabel lbTypeCar13;
    private javax.swing.JLabel lbTypeCar14;
    private javax.swing.JLabel lbTypeCar15;
    private javax.swing.JLabel lbTypeCar16;
    private javax.swing.JLabel lbTypeCar17;
    private javax.swing.JLabel lbTypeCar18;
    private javax.swing.JLabel lbTypeCar2;
    private javax.swing.JLabel lbTypeCar3;
    private javax.swing.JLabel lbTypeCar4;
    private javax.swing.JLabel lbTypeCar5;
    private javax.swing.JLabel lbTypeCar6;
    private javax.swing.JLabel lbTypeCar7;
    private javax.swing.JLabel lbTypeCar8;
    private javax.swing.JLabel lbTypeCar9;
    private javax.swing.JPanel panelBar;
    private javax.swing.JPanel panelContinue;
    private swing.login.PanelRound1 panelRound11;
    private swing.login.PanelRound1 panelRound12;
    private swing.login.PanelRound1 panelRound13;
    private swing.login.PanelRound1 panelRound14;
    private swing.login.PanelRound1 panelRound15;
    private swing.login.PanelRound1 panelRound16;
    private swing.login.PanelRound1 panelRound17;
    private swing.login.PanelRound1 panelRound18;
    private swing.login.PanelRound1 panelRound19;
    private javax.swing.JPanel panelRound2;
    private swing.login.PanelRound1 panelRound20;
    private swing.login.PanelRound1 panelRound21;
    private swing.login.PanelRound1 panelRound22;
    private swing.login.PanelRound1 panelRound23;
    private swing.login.PanelRound1 panelRound24;
    private swing.login.PanelRound1 panelRound25;
    private swing.login.PanelRound1 panelRound26;
    private swing.login.PanelRound1 panelRound27;
    private swing.login.PanelRound1 panelRound28;
    private swing.login.PanelRound1 panelRound29;
    private javax.swing.JLabel txtDifference;
    private javax.swing.JLabel txtDifference1;
    private javax.swing.JLabel txtDifference10;
    private javax.swing.JLabel txtDifference11;
    private javax.swing.JLabel txtDifference12;
    private javax.swing.JLabel txtDifference13;
    private javax.swing.JLabel txtDifference14;
    private javax.swing.JLabel txtDifference15;
    private javax.swing.JLabel txtDifference16;
    private javax.swing.JLabel txtDifference17;
    private javax.swing.JLabel txtDifference18;
    private javax.swing.JLabel txtDifference2;
    private javax.swing.JLabel txtDifference3;
    private javax.swing.JLabel txtDifference4;
    private javax.swing.JLabel txtDifference5;
    private javax.swing.JLabel txtDifference6;
    private javax.swing.JLabel txtDifference7;
    private javax.swing.JLabel txtDifference8;
    private javax.swing.JLabel txtDifference9;
    // End of variables declaration//GEN-END:variables
}
