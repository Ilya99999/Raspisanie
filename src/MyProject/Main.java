package MyProject;

import javax.swing.*;
import java.awt.*;
import java.util.*;

import static MyProject.Clalend.calendar;
import static MyProject.Clalend.calendar2;
import static MyProject.Clalend.time;

public  class Main extends JFrame {
    public static int WIDTH = 1000;
    public static int HEIGHT = 1000;
    JPanel panelCalc = new JPanel(new GridBagLayout());
    JPanel panel1 = new JPanel(new GridLayout(0, 7));
    public static JPanel panel2 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    public static JTextField tfdata = new JTextField();
    static JTextField tfDay = new JTextField();
    static JButton[] buttons;
    static String[] raspisanie;
    static String[][] pari;
    public static JFrame jpf = new JFrame();


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }

    Main() {
        jpf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocation(200, 200);
        setAlwaysOnTop(true);
        setResizable(true);
        setVisible(true);
        GridBagConstraints constraints = new GridBagConstraints();

        panelCalc.setBackground(new Color(55, 0, 0, 254));
        panelCalc.setSize(jpf.getWidth(),jpf.getHeight());
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
        constraints.gridheight = 3;
        constraints.gridy = 0;
        constraints.gridx = 1;
        tfDay.setPreferredSize(new Dimension(250, 30));
        tfDay.setHorizontalAlignment(JTextField.CENTER);
        panel2.add(tfDay);
        panelCalc.add(panel2, constraints);// Паналь 2!

        constraints.gridheight = 1;
        JButton btnBack = new JButton("Back");
        JButton btnNext = new JButton("Next");
        btnNext.addActionListener(e -> {
            Clalend.Switch(true);
            RepaintCal();
        });
        btnBack.addActionListener(e -> {
            Clalend.Switch(false);
            RepaintCal();
        });
        tfdata.setPreferredSize(new Dimension(250, 30));
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
        calendar2.set(calendar2.get(Calendar.YEAR), calendar2.get(Calendar.MONTH), 1);
        Clalend.DrawCal(panel1);
        Clalend.CalcListener();

        raspisanie = new String[buttons.length];   //исправить
        for (int i = 0; i < raspisanie.length; i++) {
           raspisanie[i] = "Первая пара дня " + (i + 1);
        }
        pari = new String[6][4];



    }

    private void panelCalc(JPanel panel, double v) {
//        panel.setMaximumSize(new Dimension(WIDTH / 2, (int) (HEIGHT * v)));
        panel.setPreferredSize(new Dimension(WIDTH / 2, (int) (HEIGHT * v)));
        panel.setMinimumSize(new Dimension(WIDTH / 2, (int) (HEIGHT * v)));
    }

    private void RepaintCal() {
        panel1.removeAll();
        panel1.revalidate();
        panel1.repaint();
        Clalend.DrawCal(panel1);
        raspisanie = new String[buttons.length];   //исправить
        for (int i = 0; i < raspisanie.length; i++) {
            raspisanie[i] = "Первая пара дня" + (i + 1);
        }
        Clalend.CalcListener();
        // Метод для кнопок, перехода  месяца!

    }
}
