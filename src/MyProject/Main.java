package MyProject;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public  class Main extends JFrame {
    private static  int WIDTH = 800;
    private static  int HEIGHT = 800;



    GregorianCalendar calendar = new GregorianCalendar();
    GregorianCalendar calendar2 = new GregorianCalendar();
    Date time = new Date();
    JPanel panelCalc = new JPanel(new GridBagLayout());
    JPanel panel1 = new JPanel(new GridLayout(0,7));
    JPanel panel2 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JTextField tfdata = new JTextField();
    JTextField tfDay = new JTextField();
    JButton[] buttons;
    String[] raspisanie;




    public static void main (String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new Main();
                }
            });
        }

    Main () {
        JFrame jpf = new JFrame();
        jpf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocation(200, 200);
        setAlwaysOnTop(true);
        setResizable(true);
        setVisible(true);
        GridBagConstraints constraints = new GridBagConstraints();

        panelCalc.setBackground(new Color(55, 0, 0, 254));
        getContentPane().add(panelCalc);

        panel1.setBackground(new Color(55, 223, 69));
        panel2.setBackground(new Color(195, 233, 69));
        panel3.setBackground(new Color(155, 22, 169));
        panel4.setBackground(new Color(235, 133, 19));

        panelCalc(panel1, 0.4);
        constraints.gridy = 0;
        constraints.gridx = 0;
        panelCalc.add(panel1, constraints);// Паналь 1!

        panelCalc(panel2, 1);
        constraints.gridheight=3;
        constraints.gridy = 0;
        constraints.gridx = 1;
        tfDay.setPreferredSize(new Dimension(250,30));
        tfDay.setHorizontalAlignment(JTextField.CENTER);
        panel2.add(tfDay);
        panelCalc.add(panel2, constraints);// Паналь 2!

        constraints.gridheight=1;
        JButton btnBack = new JButton("Back");
        JButton btnNext = new JButton("Next");

        btnNext.addActionListener(e -> {
            Switch(true);
            RepaintCal();

        });
        btnBack.addActionListener(e -> {
            Switch(false);
            RepaintCal();
        });
        tfdata.setPreferredSize(new Dimension(250,30));
        panel3.add(btnBack);
        panel3.add(tfdata);
        panel3.add(btnNext);
        panelCalc(panel3, 0.1);
        constraints.gridy = 1;
        constraints.gridx = 0;
        panelCalc.add(panel3, constraints);// Паналь 3!


        panelCalc(panel4, 0.5);
        constraints.gridy = 2;
        constraints.gridx = 0;
        panelCalc.add(panel4, constraints);// Паналь 4!

        calendar.setTime(time);
        calendar2.setTime(time);
        calendar2.set(calendar2.get(Calendar.YEAR),calendar2.get(Calendar.MONTH), 1);
        DrawCal(panel1);
        CalcListener();
        raspisanie = new String[buttons.length];   //исправить
        for (int i = 0; i < raspisanie.length; i++) {
            raspisanie[i] = "Первая пара дня " + (i+1);
        }

    }

    private void panelCalc(JPanel panel, double v) {
        panel.setMaximumSize(new Dimension(WIDTH / 2, (int) (HEIGHT * v)));
        panel.setPreferredSize(new Dimension(WIDTH / 2, (int) (HEIGHT * v)));
        panel.setMinimumSize(new Dimension(WIDTH / 2, (int) (HEIGHT * v)));
    }

    private void CalcListener() {
        for (int i = 0; i < buttons.length; i++) {
            int finalI = i;
            buttons[i].addActionListener(e -> {
                tfDay.setText(buttons[finalI].getText()+" "+calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH)+ " " + calendar.get(Calendar.YEAR));
                System.out.println(raspisanie[finalI]);
            });
        }
    }

    private void RepaintCal() {
        panel1.removeAll();
        panel1.revalidate();
        panel1.repaint();
        DrawCal(panel1);

        raspisanie = new String[buttons.length];   //исправить
        for (int i = 0; i < raspisanie.length; i++) {
            raspisanie[i] = "Первая пара дня" + (i+1);
        }
        CalcListener();

        // Метод для кнопок, перехода  месяца!
    }


    private void DrawCal(JPanel panel) {
        buttons = new JButton[calendar.getActualMaximum(Calendar.DAY_OF_MONTH)];
            String[] header = {"Пн", "Вт", "Ср", "Чт", "Пт", "Сб","Вc" };
            for (String s : header) {
                panel.add(new JTextField(s, 0));
            }
            for (int i = 0; i < calendar2.get(Calendar.DAY_OF_WEEK) -2 ; i++) {
                JButton btn = new JButton("*");
                btn.setEnabled(false);
                panel.add(btn);
            }


        for (int i = 0; i < buttons.length; i++) {
            buttons[i]= new JButton(Integer.toString(i+1));
            panel.add(buttons[i]);

        }
        }


        public  void Switch (boolean key){
            if (key){
                calendar2.set(calendar2.get(Calendar.YEAR),calendar2.get(Calendar.MONTH)+1, 1);
                calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)+1, calendar.get(Calendar.DAY_OF_MONTH));
            } else{
                calendar2.set(calendar2.get(Calendar.YEAR),calendar2.get(Calendar.MONTH)-1, 1);
                calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)-1, calendar.get(Calendar.DAY_OF_MONTH));
            }
            tfdata.setText(calendar.getDisplayName
                    (Calendar.MONTH, Calendar.LONG, Locale.ENGLISH)+ " " + calendar.get(Calendar.YEAR));
                  }// Алгоритм для  календаря!
    //Тест GIT
}

