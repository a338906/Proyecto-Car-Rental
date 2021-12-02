package com.raven.form;

import com.raven.component.CarReceipt;
import javax.swing.*;
import java.sql.*;
import connection.DatabaseConnection;
import com.raven.model.ModelCar;
import com.raven.model.ModelDetails;
import com.raven.model.ModelOptionals;
import com.raven.model.Model_Data;
import component.login.Message;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;

public final class Form_Reservation2 extends javax.swing.JPanel {

    //PACKS
    boolean show = false;
    boolean show2 = false;
    boolean show3 = false;
    boolean show4 = false;
    //COVERAGE
    boolean show5 = false;
    boolean show6 = false;
    boolean show7 = false;
    boolean show8 = false;
    //SERVICE
    boolean show9 = false;
    boolean show10 = false;
    boolean show11 = false;
    //EXTRA
    boolean show12 = false;
    boolean show13 = false;
    boolean show14 = false;
    
    float packCost;
    float packCost2;
    float packCost3;
    float packCost4;

    public Form_Reservation2() {
        initComponents();
    }

    public void restartReceipt(String carName) {
        panelReceipt.removeAll();
        CarReceipt carReceipt = new CarReceipt();
        ModelCar car = getCar(carName);
        carReceipt.setData(car);
        carReceipt.setCarName(car.getName());
        panelReceipt.add(carReceipt);
    }

    public void startForm(String carName) {
        CarReceipt carReceipt = new CarReceipt();
        ModelCar car = getCar(carName);
        carReceipt.setData(car);
        carReceipt.setCarName(car.getName());
        panelReceipt.add(carReceipt);
        panelBackground.setVisible(true);
        panelBgCoverage.setBorder(new EmptyBorder(0, 10, 0, 0));
        panelBgExtra.setBorder(new EmptyBorder(0, 10, 0, 0));
        panelBgService.setBorder(new EmptyBorder(0, 10, 0, 0));
        setOpaque(false);
        setVisible(true);
        showPack();
        showCoverage();
        showServices();
        showExtras();
        panelBar.add(panelContinue);
        panelBar.repaint();
        panelBar.revalidate();
        buttonOption.setColor1(new Color(102, 204, 255));
        buttonOption.setColor2(new Color(0, 102, 255));
    }

    public void showPack() {
        coverageCard();
        serviceCard();
        extraCard();
        float total = packPrice(1);
        total *= 0.75;
        setPackCost(total);
        panelPack.setPrice("ENTRETENIMIENTO", total);
        panelPack.addItem(new Model_Data(true, "AHORRA UN 25%"));
        panelPack.addItem(new Model_Data(true, "Radio Satelital"));
        panelPack.addItem(new Model_Data(true, "Wi-Fi Movil"));
        panelPack.addEventSelect(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!show) {
                    panelPack.setColor1(new Color(102, 204, 255));
                    panelPack.setColor2(new Color(0, 102, 255));
                    show = true;

                    show9 = false;
                    show10 = false;
                    show11 = false;

                    extra.setColor1(new Color(255, 255, 255));
                    extra.setColor2(new Color(255, 255, 255));
                    extra3.setColor1(new Color(255, 255, 255));
                    extra3.setColor2(new Color(255, 255, 255));
                    panelPack.repaint();
                    showMessage(Message.MessageType.COMMENT, "Este paquete no te permite seleccionar dichos opcionales.", ae);
                } else {
                    panelPack.setColor1(new Color(153, 153, 153));
                    panelPack.setColor2(new Color(51, 51, 51));
                    show = false;
                    panelPack.repaint();
                }
            }
        });

        float total2 = packPrice(2);
        total2 *= 0.90;
        setPackCost2(total2);
        panelPack2.setPrice("COBERTURA", total2);
        panelPack2.addItem(new Model_Data(true, "AHORRA UN 10%"));
        panelPack2.addItem(new Model_Data(true, "Vehículo"));
        panelPack2.addItem(new Model_Data(true, "Responsabilidad"));
        panelPack2.addItem(new Model_Data(true, "Personal"));
        panelPack2.addItem(new Model_Data(true, "Objetos Personales"));
        panelPack2.addEventSelect(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!show2) {
                    panelPack2.setColor1(new Color(102, 204, 255));
                    panelPack2.setColor2(new Color(0, 102, 255));
                    show2 = true;

                    show5 = false;
                    show6 = false;
                    show7 = false;
                    show8 = false;
                    optional.setColor1(new Color(255, 255, 255));
                    optional.setColor2(new Color(255, 255, 255));
                    optional1.setColor1(new Color(255, 255, 255));
                    optional1.setColor2(new Color(255, 255, 255));
                    optional2.setColor1(new Color(255, 255, 255));
                    optional2.setColor2(new Color(255, 255, 255));
                    optional3.setColor1(new Color(255, 255, 255));
                    optional3.setColor2(new Color(255, 255, 255));
                    panelPack2.repaint();
                    showMessage(Message.MessageType.COMMENT, "Este paquete no te permite seleccionar dichos opcionales.", ae);

                } else {
                    panelPack2.setColor1(new Color(153, 153, 153));
                    panelPack2.setColor2(new Color(51, 51, 51));
                    show2 = false;
                    panelPack2.repaint();
                }
            }
        });

        float total3 = packPrice(3);
        total3 *= 0.70;
        setPackCost3(total3);
        panelPack3.setPrice("SERVICIOS", total3);
        panelPack3.addItem(new Model_Data(true, "AHORRA UN 30%"));
        panelPack3.addItem(new Model_Data(true, "Servicio 24/7"));
        panelPack3.addItem(new Model_Data(true, "Conductor Adicional"));
        panelPack3.addItem(new Model_Data(true, "Plan de Abastecimiento"));
        panelPack3.addEventSelect(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!show3) {
                    panelPack3.setColor1(new Color(102, 204, 255));
                    panelPack3.setColor2(new Color(0, 102, 255));
                    show3 = true;

                    show12 = false;
                    show13 = false;
                    show14 = false;
                    service.setColor1(new Color(255, 255, 255));
                    service.setColor2(new Color(255, 255, 255));
                    service2.setColor1(new Color(255, 255, 255));
                    service2.setColor2(new Color(255, 255, 255));
                    service3.setColor1(new Color(255, 255, 255));
                    service3.setColor2(new Color(255, 255, 255));
                    panelPack3.repaint();
                    showMessage(Message.MessageType.COMMENT, "Este paquete no te permite seleccionar dichos opcionales.", ae);
                } else {
                    panelPack3.setColor1(new Color(153, 153, 153));
                    panelPack3.setColor2(new Color(51, 51, 51));
                    show3 = false;
                    panelPack3.repaint();
                }
            }
        });

        float total4 = packPrice(4);
        total4 *= 0.80;
        setPackCost4(total4);
        panelPack4.setPrice("PROTECCION", total4);
        panelPack4.addItem(new Model_Data(true, "AHORRA UN 20%"));
        panelPack4.addItem(new Model_Data(true, "Cobertura de Vehículo"));
        panelPack4.addItem(new Model_Data(true, "Servicio 24/7"));
        panelPack4.addEventSelect(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!show4) {
                    panelPack4.setColor1(new Color(102, 204, 255));
                    panelPack4.setColor2(new Color(0, 102, 255));
                    show4 = true;

                    show5 = false;
                    show12 = false;
                    optional.setColor1(new Color(255, 255, 255));
                    optional.setColor2(new Color(255, 255, 255));
                    service.setColor1(new Color(255, 255, 255));
                    service.setColor2(new Color(255, 255, 255));

                    panelPack4.repaint();
                    showMessage(Message.MessageType.COMMENT, "Este paquete no te permite seleccionar dichos opcionales.", ae);
                } else {
                    panelPack4.setColor1(new Color(153, 153, 153));
                    panelPack4.setColor2(new Color(51, 51, 51));
                    show4 = false;
                    panelPack4.repaint();
                }
            }
        });
    }

    public void showCoverage() {
        optional.addEventSelect(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!show4 || !show2) {
                    if (!show5) {
                        optional.setColor1(new Color(102, 204, 255));
                        optional.setColor2(new Color(0, 102, 255));
                        show5 = true;
                    } else {
                        optional.setColor1(new Color(255, 255, 255));
                        optional.setColor2(new Color(255, 255, 255));
                        show5 = false;
                    }
                    optional.repaint();
                } else {
                    showMessage(Message.MessageType.ERROR, "Paquete Seleccionado", ae);
                }
            }
        });

        optional1.addEventSelect(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!show2) {
                    if (!show6) {
                        optional1.setColor1(new Color(102, 204, 255));
                        optional1.setColor2(new Color(0, 102, 255));
                        show6 = true;
                    } else {
                        optional1.setColor1(new Color(255, 255, 255));
                        optional1.setColor2(new Color(255, 255, 255));
                        show6 = false;
                    }
                    optional1.repaint();
                } else {
                    showMessage(Message.MessageType.ERROR, "Paquete Seleccionado", ae);
                }
            }
        });

        optional2.addEventSelect(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!show2) {
                    if (!show7) {
                        optional2.setColor1(new Color(102, 204, 255));
                        optional2.setColor2(new Color(0, 102, 255));
                        show7 = true;
                    } else {
                        optional2.setColor1(new Color(255, 255, 255));
                        optional2.setColor2(new Color(255, 255, 255));
                        show7 = false;
                    }
                    optional2.repaint();
                } else {
                    showMessage(Message.MessageType.ERROR, "Paquete Seleccionado", ae);
                }
            }
        });

        optional3.addEventSelect(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!show2) {
                    if (!show8) {
                        optional3.setColor1(new Color(102, 204, 255));
                        optional3.setColor2(new Color(0, 102, 255));
                        show8 = true;
                    } else {
                        optional3.setColor1(new Color(255, 255, 255));
                        optional3.setColor2(new Color(255, 255, 255));
                        show8 = false;
                    }
                    optional3.repaint();
                } else {
                    showMessage(Message.MessageType.ERROR, "Paquete Seleccionado", ae);
                }
            }
        });
    }

    public void showServices() {
        service.addEventSelect(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!show3) {
                    if (!show9) {
                        service.setColor1(new Color(102, 204, 255));
                        service.setColor2(new Color(0, 102, 255));
                        show9 = true;
                    } else {
                        service.setColor1(new Color(255, 255, 255));
                        service.setColor2(new Color(255, 255, 255));
                        show9 = false;
                    }
                    service.repaint();
                } else {
                    showMessage(Message.MessageType.ERROR, "Paquete Seleccionado", ae);
                }
            }
        });

        service2.addEventSelect(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!show3) {
                    if (!show10) {
                        service2.setColor1(new Color(102, 204, 255));
                        service2.setColor2(new Color(0, 102, 255));
                        show10 = true;
                    } else {
                        service2.setColor1(new Color(255, 255, 255));
                        service2.setColor2(new Color(255, 255, 255));
                        show10 = false;
                    }
                    service2.repaint();
                } else {
                    showMessage(Message.MessageType.ERROR, "Paquete Seleccionado", ae);
                }
            }
        });

        service3.addEventSelect(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!show4 || !show3) {
                    if (!show11) {
                        service3.setColor1(new Color(102, 204, 255));
                        service3.setColor2(new Color(0, 102, 255));
                        show11 = true;
                    } else {
                        service3.setColor1(new Color(255, 255, 255));
                        service3.setColor2(new Color(255, 255, 255));
                        show11 = false;
                    }
                    service3.repaint();
                } else {
                    showMessage(Message.MessageType.ERROR, "Paquete Seleccionado", ae);
                }
            }
        });
    }

    public void showExtras() {
        extra.addEventSelect(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!show) {
                    if (!show12) {
                        extra.setColor1(new Color(102, 204, 255));
                        extra.setColor2(new Color(0, 102, 255));
                        show12 = true;
                    } else {
                        extra.setColor1(new Color(255, 255, 255));
                        extra.setColor2(new Color(255, 255, 255));
                        show12 = false;
                    }
                    extra.repaint();
                } else {
                    showMessage(Message.MessageType.ERROR, "Paquete Seleccionado", ae);
                }
            }
        });

        extra2.addEventSelect(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!show) {
                    if (!show13) {
                        extra2.setColor1(new Color(102, 204, 255));
                        extra2.setColor2(new Color(0, 102, 255));
                        show13 = true;
                    } else {
                        extra2.setColor1(new Color(255, 255, 255));
                        extra2.setColor2(new Color(255, 255, 255));
                        show13 = false;
                    }
                    extra2.repaint();
                } else {
                    showMessage(Message.MessageType.ERROR, "Paquete Seleccionado", ae);
                }
            }
        });

        extra3.addEventSelect(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!show14) {
                    extra3.setColor1(new Color(102, 204, 255));
                    extra3.setColor2(new Color(0, 102, 255));
                    show14 = true;
                } else {
                    extra3.setColor1(new Color(255, 255, 255));
                    extra3.setColor2(new Color(255, 255, 255));
                    show14 = false;
                }
                extra3.repaint();
            }
        });
    }

    public float packPrice(int idPack) {
        float price = 0;
        try {
            String sql = "SELECT Costo, OpcionalID FROM Opcional";
            PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                if (idPack == 1) {
                    if (r.getInt("OpcionalID") == 5 || r.getInt("OpcionalID") == 6) {
                        price += r.getFloat("Costo");
                    }
                } else if (idPack == 2) {
                    if (r.getInt("OpcionalID") < 5) {
                        price += r.getFloat("Costo");
                    }
                } else if (idPack == 3) {
                    if (r.getInt("OpcionalID") >= 8) {
                        price += r.getFloat("Costo");
                    }
                } else {
                    if (r.getInt("OpcionalID") == 1 || r.getInt("OpcionalID") == 8) {
                        price += r.getFloat("Costo");
                    }
                }
            }
            r.close();
            p.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return price;
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

    public void coverageCard() {
        ModelOptionals data;
        try {
            String sql = "SELECT Descripcion, Costo, Opcional, OpcionalID FROM Opcional";
            PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                if (r.getInt("OpcionalID") == 1) {
                    data = new ModelOptionals(r.getString("Opcional"), r.getString("Descripcion"),
                            new ImageIcon(getClass().getResource("/icon/optionals/carcoverage.png")), r.getFloat("Costo"));
                    optional.setData(data);
                } else if (r.getInt("OpcionalID") == 2) {
                    data = new ModelOptionals(r.getString("Opcional"), r.getString("Descripcion"),
                            new ImageIcon(getClass().getResource("/icon/optionals/carresponsability.png")), r.getFloat("Costo"));
                    optional1.setData(data);
                } else if (r.getInt("OpcionalID") == 3) {
                    data = new ModelOptionals(r.getString("Opcional"), r.getString("Descripcion"),
                            new ImageIcon(getClass().getResource("/icon/optionals/carpersonal.png")), r.getFloat("Costo"));
                    optional2.setData(data);
                } else if (r.getInt("OpcionalID") == 4) {
                    data = new ModelOptionals(r.getString("Opcional"), r.getString("Descripcion"),
                            new ImageIcon(getClass().getResource("/icon/optionals/carlugage.png")), r.getFloat("Costo"));
                    optional3.setData(data);
                }
            }
            r.close();
            p.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void extraCard() {
        ModelOptionals data;
        try {
            String sql = "SELECT Descripcion, Costo, Opcional, OpcionalID FROM Opcional";
            PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                if (r.getInt("OpcionalID") == 5) {
                    data = new ModelOptionals(r.getString("Opcional"), r.getString("Descripcion"),
                            new ImageIcon(getClass().getResource("/icon/optionals/roadassistance.png")), r.getFloat("Costo"));
                    extra.setData(data);
                } else if (r.getInt("OpcionalID") == 6) {
                    data = new ModelOptionals(r.getString("Opcional"), r.getString("Descripcion"),
                            new ImageIcon(getClass().getResource("/icon/optionals/additional.png")), r.getFloat("Costo"));
                    extra2.setData(data);
                } else if (r.getInt("OpcionalID") == 7) {
                    data = new ModelOptionals(r.getString("Opcional"), r.getString("Descripcion"),
                            new ImageIcon(getClass().getResource("/icon/optionals/plangas.png")), r.getFloat("Costo"));
                    extra3.setData(data);
                }
            }
            r.close();
            p.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void serviceCard() {
        ModelOptionals data;
        try {
            String sql = "SELECT Descripcion, Costo, Opcional, OpcionalID FROM Opcional";
            PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                if (r.getInt("OpcionalID") == 8) {
                    data = new ModelOptionals(r.getString("Opcional"), r.getString("Descripcion"),
                            new ImageIcon(getClass().getResource("/icon/optionals/radio.png")), r.getFloat("Costo"));
                    service.setData(data);
                } else if (r.getInt("OpcionalID") == 9) {
                    data = new ModelOptionals(r.getString("Opcional"), r.getString("Descripcion"),
                            new ImageIcon(getClass().getResource("/icon/optionals/wifi.png")), r.getFloat("Costo"));
                    service2.setData(data);
                } else if (r.getInt("OpcionalID") == 10) {
                    data = new ModelOptionals(r.getString("Opcional"), r.getString("Descripcion"),
                            new ImageIcon(getClass().getResource("/icon/optionals/babyseat.png")), r.getFloat("Costo"));
                    service3.setData(data);
                }
            }
            r.close();
            p.close();
        } catch (Exception e) {
            System.err.println(e);
        }
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
    
    public void retrievePickUp(ModelDetails dataPickUp) {
        detailsPU.setData(dataPickUp);
    }

    public void retrieveReturn(ModelDetails dataReturn) {
        detailsReturn.setData(dataReturn);
    }

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

    public Boolean[] optionalsList() {
        Boolean[] boolArray = new Boolean[14];
        boolArray[0] = show;
        boolArray[1] = show2;
        boolArray[2] = show3;
        boolArray[3] = show4;
        boolArray[4] = show5;
        boolArray[5] = show6;
        boolArray[6] = show7;
        boolArray[7] = show8;
        boolArray[8] = show9;
        boolArray[9] = show10;
        boolArray[10] = show11;
        boolArray[11] = show12;
        boolArray[12] = show13;
        boolArray[13] = show14;
        return boolArray;
    }

    public String carSelected;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContinue = new javax.swing.JPanel();
        buttonContinue = new swing.login.Button();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        buttonBack = new swing.login.Close1Button();
        detailsReturn = new com.raven.component.DetailsCard();
        detailsPU = new com.raven.component.DetailsCard();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        panelBar = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        buttonOption = new swing.login.Button1();
        buttonOption1 = new swing.login.Button1();
        buttonOption2 = new swing.login.Button1();
        buttonOption3 = new swing.login.Button1();
        panelBackground = new javax.swing.JPanel();
        panelBgPack = new javax.swing.JPanel();
        panelPack = new com.raven.component.PanelPricing();
        panelPack2 = new com.raven.component.PanelPricing();
        panelPack3 = new com.raven.component.PanelPricing();
        panelPack4 = new com.raven.component.PanelPricing();
        panelBgCoverage = new javax.swing.JPanel();
        optional = new com.raven.component.CardOptionals();
        optional1 = new com.raven.component.CardOptionals();
        optional2 = new com.raven.component.CardOptionals();
        optional3 = new com.raven.component.CardOptionals();
        panelBgService = new javax.swing.JPanel();
        service = new com.raven.component.CardOptionals();
        service2 = new com.raven.component.CardOptionals();
        service3 = new com.raven.component.CardOptionals();
        panelBgExtra = new javax.swing.JPanel();
        extra = new com.raven.component.CardOptionals();
        extra2 = new com.raven.component.CardOptionals();
        extra3 = new com.raven.component.CardOptionals();
        panelReceipt = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();

        panelContinue.setBackground(new java.awt.Color(255, 255, 255));

        buttonContinue.setBackground(new java.awt.Color(0, 153, 255));
        buttonContinue.setForeground(new java.awt.Color(255, 255, 255));
        buttonContinue.setText("CONTINUAR");
        buttonContinue.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Seleccione o no los opcionales y presione continuar");

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

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dashboard/Part3.png"))); // NOI18N

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

        detailsReturn.setBackground(new java.awt.Color(255, 255, 255));

        detailsPU.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setForeground(new java.awt.Color(153, 153, 153));

        panelBar.setBackground(new java.awt.Color(204, 204, 204));
        panelBar.setLayout(new java.awt.CardLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        buttonOption.setText("PAQUETES");
        buttonOption.setEffectColor(new java.awt.Color(0, 0, 0));
        buttonOption.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOptionActionPerformed(evt);
            }
        });

        buttonOption1.setText("SEGUROS");
        buttonOption1.setEffectColor(new java.awt.Color(0, 0, 0));
        buttonOption1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonOption1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOption1ActionPerformed(evt);
            }
        });

        buttonOption2.setText("SERVICIOS");
        buttonOption2.setEffectColor(new java.awt.Color(0, 0, 0));
        buttonOption2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonOption2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOption2ActionPerformed(evt);
            }
        });

        buttonOption3.setText("EXTRAS");
        buttonOption3.setEffectColor(new java.awt.Color(0, 0, 0));
        buttonOption3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        buttonOption3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOption3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonOption, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonOption1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonOption2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonOption3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonOption2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonOption1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonOption3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        panelBackground.setLayout(new java.awt.CardLayout());

        panelBgPack.setBackground(new java.awt.Color(255, 255, 255));
        panelBgPack.setLayout(new javax.swing.BoxLayout(panelBgPack, javax.swing.BoxLayout.LINE_AXIS));

        panelPack.setColor1(new java.awt.Color(153, 153, 153));
        panelPack.setColor2(new java.awt.Color(51, 51, 51));
        panelBgPack.add(panelPack);

        panelPack2.setColor1(new java.awt.Color(153, 153, 153));
        panelPack2.setColor2(new java.awt.Color(51, 51, 51));
        panelBgPack.add(panelPack2);

        panelPack3.setColor1(new java.awt.Color(153, 153, 153));
        panelPack3.setColor2(new java.awt.Color(51, 51, 51));
        panelBgPack.add(panelPack3);

        panelPack4.setColor1(new java.awt.Color(153, 153, 153));
        panelPack4.setColor2(new java.awt.Color(51, 51, 51));
        panelBgPack.add(panelPack4);

        panelBackground.add(panelBgPack, "card2");

        panelBgCoverage.setBackground(new java.awt.Color(255, 255, 255));
        panelBgCoverage.setLayout(new javax.swing.BoxLayout(panelBgCoverage, javax.swing.BoxLayout.LINE_AXIS));
        panelBgCoverage.add(optional);
        panelBgCoverage.add(optional1);
        panelBgCoverage.add(optional2);
        panelBgCoverage.add(optional3);

        panelBackground.add(panelBgCoverage, "card2");

        panelBgService.setBackground(new java.awt.Color(255, 255, 255));
        panelBgService.setLayout(new javax.swing.BoxLayout(panelBgService, javax.swing.BoxLayout.LINE_AXIS));
        panelBgService.add(service);
        panelBgService.add(service2);
        panelBgService.add(service3);

        panelBackground.add(panelBgService, "card2");

        panelBgExtra.setBackground(new java.awt.Color(255, 255, 255));
        panelBgExtra.setLayout(new javax.swing.BoxLayout(panelBgExtra, javax.swing.BoxLayout.LINE_AXIS));
        panelBgExtra.add(extra);
        panelBgExtra.add(extra2);
        panelBgExtra.add(extra3);

        panelBackground.add(panelBgExtra, "card2");

        panelReceipt.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator3.setForeground(new java.awt.Color(153, 153, 153));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panelBackground, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(detailsPU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(detailsReturn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelReceipt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(detailsReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(detailsPU, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOptionActionPerformed
        buttonOption.setEffectColor(Color.WHITE);
        buttonOption.setColor1(new Color(255, 255, 255));
        buttonOption.setColor2(new Color(200, 200, 200));
        buttonOption1.setColor1(new Color(255, 255, 255));
        buttonOption1.setColor2(new Color(200, 200, 200));
        buttonOption2.setColor1(new Color(255, 255, 255));
        buttonOption2.setColor2(new Color(200, 200, 200));
        buttonOption3.setColor1(new Color(255, 255, 255));
        buttonOption3.setColor2(new Color(200, 200, 200));
        buttonOption.setColor1(new Color(102, 204, 255));
        buttonOption.setColor2(new Color(0, 102, 255));
        panelBackground.removeAll();
        panelBackground.add(panelBgPack);
        panelBackground.repaint();
        panelBackground.revalidate();
        buttonOption.setEffectColor(Color.BLACK);
        buttonOption.repaint();
        buttonOption1.repaint();
        buttonOption2.repaint();
        buttonOption3.repaint();
    }//GEN-LAST:event_buttonOptionActionPerformed

    private void buttonOption1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOption1ActionPerformed
        buttonOption1.setEffectColor(Color.WHITE);
        buttonOption.setColor1(new Color(255, 255, 255));
        buttonOption.setColor2(new Color(200, 200, 200));
        buttonOption1.setColor1(new Color(255, 255, 255));
        buttonOption1.setColor2(new Color(200, 200, 200));
        buttonOption2.setColor1(new Color(255, 255, 255));
        buttonOption2.setColor2(new Color(200, 200, 200));
        buttonOption3.setColor1(new Color(255, 255, 255));
        buttonOption3.setColor2(new Color(200, 200, 200));
        buttonOption1.setColor1(new Color(102, 204, 255));
        buttonOption1.setColor2(new Color(0, 102, 255));
        panelBackground.removeAll();
        panelBackground.add(panelBgCoverage);
        panelBackground.repaint();
        panelBackground.revalidate();
        buttonOption1.setEffectColor(Color.BLACK);
        buttonOption.repaint();
        buttonOption1.repaint();
        buttonOption2.repaint();
        buttonOption3.repaint();
    }//GEN-LAST:event_buttonOption1ActionPerformed

    private void buttonOption2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOption2ActionPerformed
        buttonOption2.setEffectColor(Color.WHITE);
        buttonOption.setColor1(new Color(255, 255, 255));
        buttonOption.setColor2(new Color(200, 200, 200));
        buttonOption1.setColor1(new Color(255, 255, 255));
        buttonOption1.setColor2(new Color(200, 200, 200));
        buttonOption2.setColor1(new Color(255, 255, 255));
        buttonOption2.setColor2(new Color(200, 200, 200));
        buttonOption3.setColor1(new Color(255, 255, 255));
        buttonOption3.setColor2(new Color(200, 200, 200));
        buttonOption2.setColor1(new Color(102, 204, 255));
        buttonOption2.setColor2(new Color(0, 102, 255));
        panelBackground.removeAll();
        panelBackground.add(panelBgExtra);
        panelBackground.repaint();
        panelBackground.revalidate();
        buttonOption2.setEffectColor(Color.BLACK);
        buttonOption.repaint();
        buttonOption1.repaint();
        buttonOption2.repaint();
        buttonOption3.repaint();
    }//GEN-LAST:event_buttonOption2ActionPerformed

    private void buttonOption3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOption3ActionPerformed
        buttonOption3.setEffectColor(Color.WHITE);
        buttonOption.setColor1(new Color(255, 255, 255));
        buttonOption.setColor2(new Color(200, 200, 200));
        buttonOption1.setColor1(new Color(255, 255, 255));
        buttonOption1.setColor2(new Color(200, 200, 200));
        buttonOption2.setColor1(new Color(255, 255, 255));
        buttonOption2.setColor2(new Color(200, 200, 200));
        buttonOption3.setColor1(new Color(255, 255, 255));
        buttonOption3.setColor2(new Color(200, 200, 200));
        buttonOption3.setColor1(new Color(102, 204, 255));
        buttonOption3.setColor2(new Color(0, 102, 255));
        panelBackground.removeAll();
        panelBackground.add(panelBgService);
        panelBackground.repaint();
        panelBackground.revalidate();
        buttonOption3.setEffectColor(Color.BLACK);
        buttonOption.repaint();
        buttonOption1.repaint();
        buttonOption2.repaint();
        buttonOption3.repaint();
    }//GEN-LAST:event_buttonOption3ActionPerformed

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

    public static enum MessageType {
        SUCCESS, ERROR, COMMENT
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.login.Close1Button buttonBack;
    private swing.login.Button buttonContinue;
    private swing.login.Button1 buttonOption;
    private swing.login.Button1 buttonOption1;
    private swing.login.Button1 buttonOption2;
    private swing.login.Button1 buttonOption3;
    private com.raven.component.DetailsCard detailsPU;
    private com.raven.component.DetailsCard detailsReturn;
    private com.raven.component.CardOptionals extra;
    private com.raven.component.CardOptionals extra2;
    private com.raven.component.CardOptionals extra3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private com.raven.component.CardOptionals optional;
    private com.raven.component.CardOptionals optional1;
    private com.raven.component.CardOptionals optional2;
    private com.raven.component.CardOptionals optional3;
    private javax.swing.JPanel panelBackground;
    private javax.swing.JPanel panelBar;
    private javax.swing.JPanel panelBgCoverage;
    private javax.swing.JPanel panelBgExtra;
    private javax.swing.JPanel panelBgPack;
    private javax.swing.JPanel panelBgService;
    private javax.swing.JPanel panelContinue;
    private com.raven.component.PanelPricing panelPack;
    private com.raven.component.PanelPricing panelPack2;
    private com.raven.component.PanelPricing panelPack3;
    private com.raven.component.PanelPricing panelPack4;
    private javax.swing.JPanel panelReceipt;
    private com.raven.component.CardOptionals service;
    private com.raven.component.CardOptionals service2;
    private com.raven.component.CardOptionals service3;
    // End of variables declaration//GEN-END:variables
}
