package com.raven.datechooser;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public final class DateChooser extends javax.swing.JPanel {

    public JTextField getTextRefernce() {
        return textRefernce;
    }

    private JTextField textRefernce;
    private final String MONTH_SPANISH[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    private String dateFormat = "dd/MM/yyyy";
    private int MONTH = 1;
    private int YEAR = 2021;
    private int DAY = 1;
    private int STATUS = 1;
    private SelectedDate selectedDate = new SelectedDate();
    
    public DateChooser() {
        initComponents();
        execute();
    }

    private void execute() {
        setForeground(new Color(0, 102, 255));
        popup.add(this);
        toDay();
    }

    public void setTextRefernce(JTextField txt) {
        this.textRefernce = txt;
        this.textRefernce.setEditable(false);
        this.textRefernce.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (textRefernce.isEnabled()) {
                    showPopup();
                }
            }
        });
        setText();
    }

    private void setText() {
        if (textRefernce != null) {
            try {
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                Date date = df.parse(DAY + "/" + MONTH + "/" + YEAR);
                textRefernce.setText(new SimpleDateFormat(dateFormat).format(date));
            } catch (ParseException e) {
                System.err.println(e);
            }
        }
    }

    private Event getEventDay(Dates dates) {
        return (MouseEvent evt, int num) -> {
            dates.clearSelected();
            dates.setSelected(num);
            DAY = num;
            selectedDate.setDay(DAY);
            selectedDate.setMonth(MONTH);
            selectedDate.setYear(YEAR);
            setText();
            if (evt != null && evt.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(evt)) {
                popup.setVisible(false);
            }
        };
    }
    
    public void toDay() {
        Dates dates = new Dates();
        dates.setForeground(getForeground());
        dates.setEvent(getEventDay(dates), MONTH, YEAR);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String toDay = df.format(date);
        DAY = Integer.valueOf(toDay.split("/")[0]);
        MONTH = Integer.valueOf(toDay.split("/")[1]);
        YEAR = Integer.valueOf(toDay.split("/")[2]);
        selectedDate.setDay(DAY);
        selectedDate.setMonth(MONTH);
        selectedDate.setYear(YEAR);
        dates.showDate(MONTH, YEAR, selectedDate);
        slide.slideNon(dates);
        cmdMonth.setText(MONTH_SPANISH[MONTH - 1]);
        cmdYear.setText(YEAR + "");
        setText();
    }
    
    private void setDateNext() {
        Dates dates = new Dates();
        dates.setForeground(getForeground());
        dates.setEvent(getEventDay(dates), MONTH, YEAR);
        dates.showDate(MONTH, YEAR, selectedDate);
        if (slide.slideToLeft(dates)) {
            cmdMonth.setText(MONTH_SPANISH[MONTH - 1]);
            cmdYear.setText(YEAR + "");
        }
    }

    private void setDateBack() {
        Dates dates = new Dates();
        dates.setForeground(getForeground());
        dates.setEvent(getEventDay(dates), MONTH, YEAR);
        dates.showDate(MONTH, YEAR, selectedDate);
        if (slide.slideToRight(dates)) {
                cmdMonth.setText(MONTH_SPANISH[MONTH - 1]);
                cmdYear.setText(YEAR + "");
        }
    }

    public void showPopup(Component com, int x, int y) {
        popup.show(com, x, y);
    }

    public void showPopup() {
        popup.show(textRefernce, 0, textRefernce.getHeight());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popup = new javax.swing.JPopupMenu(){
            @Override
            protected void paintComponent(Graphics grphcs) {
                grphcs.setColor(new Color(114, 113, 113));
                grphcs.fillRect(0, 0, getWidth(), getHeight());
                grphcs.setColor(Color.WHITE);
                grphcs.fillRect(1, 1, getWidth() - 2, getHeight() - 2);
            }
        };
        header = new javax.swing.JPanel();
        cmdForward = new com.raven.datechooser.Button();
        MY = new javax.swing.JLayeredPane();
        cmdMonth = new com.raven.datechooser.Button();
        cmdYear = new com.raven.datechooser.Button();
        cmdPrevious = new com.raven.datechooser.Button();
        slide = new com.raven.datechooser.Slider();

        setBackground(new java.awt.Color(255, 255, 255));

        header.setBackground(new java.awt.Color(0, 102, 255));
        header.setMaximumSize(new java.awt.Dimension(262, 40));

        cmdForward.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdForward.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/datechooser/forward.png"))); // NOI18N
        cmdForward.setFocusable(true);
        cmdForward.setPaintBackground(false);
        cmdForward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdForwardActionPerformed(evt);
            }
        });

        MY.setLayout(new java.awt.FlowLayout());

        cmdMonth.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdMonth.setForeground(new java.awt.Color(255, 255, 255));
        cmdMonth.setText("January");
        cmdMonth.setEnabled(false);
        cmdMonth.setFocusPainted(false);
        cmdMonth.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        cmdMonth.setPaintBackground(false);
        MY.add(cmdMonth);

        cmdYear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdYear.setForeground(new java.awt.Color(255, 255, 255));
        cmdYear.setText("2018");
        cmdYear.setEnabled(false);
        cmdYear.setFocusPainted(false);
        cmdYear.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        cmdYear.setPaintBackground(false);
        MY.add(cmdYear);

        cmdPrevious.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdPrevious.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/datechooser/previous.png"))); // NOI18N
        cmdPrevious.setFocusable(true);
        cmdPrevious.setPaintBackground(false);
        cmdPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdPreviousActionPerformed(evt);
            }
        });
        cmdPrevious.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmdPreviousKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(cmdPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MY, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdForward, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(MY, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmdForward, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmdPrevious, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        slide.setLayout(new javax.swing.BoxLayout(slide, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(slide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(slide, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdPreviousActionPerformed
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String toDay = df.format(date);
        int toMONTH = Integer.valueOf(toDay.split("/")[1]);
        int toYEAR = Integer.valueOf(toDay.split("/")[2]);
        if (STATUS == 1) {   //  Date
            if (MONTH == 1) {
                MONTH = 12;
                YEAR--;
            } else if(MONTH == toMONTH && YEAR == toYEAR){
                
            }else {
                MONTH--;
            }
            setDateBack();
        } else if (STATUS == 3) {    //  Year
        } else {
            if (YEAR > selectedDate.getYear()) {
                YEAR--;
                cmdYear.setText(YEAR + "");
            }
        }
    }//GEN-LAST:event_cmdPreviousActionPerformed

    private void cmdForwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdForwardActionPerformed
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String toDay = df.format(date);
        int toMONTH = Integer.valueOf(toDay.split("/")[1]);
        int toYEAR = Integer.valueOf(toDay.split("/")[2]);
        if (STATUS == 1) {   //  Date
            if (MONTH == 12) {
                MONTH = 1;
                YEAR++;
            } else if(YEAR == toYEAR+1 && MONTH == toMONTH){
            }else {
                MONTH++;
            }
            setDateNext();
        } else if (STATUS == 3) {
        } else {
            if (YEAR < selectedDate.getYear()+1){
            YEAR++;
            cmdYear.setText(YEAR + "");}
        }
    }//GEN-LAST:event_cmdForwardActionPerformed

    private void cmdPreviousKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmdPreviousKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
            Component com = slide.getComponent(0);
            if (com instanceof Dates) {
                Dates d = (Dates) com;
                d.back();
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            Component com = slide.getComponent(0);
            if (com instanceof Dates) {
                Dates d = (Dates) com;
                d.next();
            }
        }
    }//GEN-LAST:event_cmdPreviousKeyPressed

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public void setSelectedDate(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String d = df.format(date);
        DAY = Integer.valueOf(d.split("/")[0]);
        MONTH = Integer.valueOf(d.split("/")[1]);
        YEAR = Integer.valueOf(d.split("/")[2]);
        selectedDate.setDay(DAY);
        selectedDate.setMonth(MONTH);
        selectedDate.setYear(YEAR);
        Dates dates = new Dates();
        dates.setForeground(getForeground());
        dates.setEvent(getEventDay(dates), MONTH, YEAR);
        dates.setSelected(DAY);
        dates.showDate(MONTH, YEAR, selectedDate);
        slide.slideNon(dates);
        cmdMonth.setText(MONTH_SPANISH[MONTH - 1]);
        cmdYear.setText(YEAR + "");
        setText();
        STATUS = 1;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane MY;
    private com.raven.datechooser.Button cmdForward;
    private com.raven.datechooser.Button cmdMonth;
    private com.raven.datechooser.Button cmdPrevious;
    private com.raven.datechooser.Button cmdYear;
    private javax.swing.JPanel header;
    private javax.swing.JPopupMenu popup;
    private com.raven.datechooser.Slider slide;
    // End of variables declaration//GEN-END:variables

    public SelectedDate getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(SelectedDate selectedDate) {
        this.selectedDate = selectedDate;
        DAY = selectedDate.getDay();
        MONTH = selectedDate.getMonth();
        YEAR = selectedDate.getYear();
        Dates dates = new Dates();
        dates.setForeground(getForeground());
        dates.setEvent(getEventDay(dates), MONTH, YEAR);
        dates.setSelected(DAY);
        dates.showDate(MONTH, YEAR, selectedDate);
        slide.slideNon(dates);
        cmdMonth.setText(MONTH_SPANISH[MONTH - 1]);
        cmdYear.setText(YEAR + "");
        setText();
        STATUS = 1;
    }
    
    @Override
    public void setForeground(Color color) {
        super.setForeground(color);
        if (header != null) {
            header.setBackground(color);
            toDay();
        }
    }
}
