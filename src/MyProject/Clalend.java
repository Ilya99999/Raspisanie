package MyProject;

import javax.swing.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Clalend {
   static GregorianCalendar calendar = new GregorianCalendar();
   static GregorianCalendar calendar2 = new GregorianCalendar();
   static Date time = new Date();
    
    public static void DrawCal(JPanel panel) {
        Main.buttons = new JButton[calendar.getActualMaximum(Calendar.DAY_OF_MONTH)];
        System.out.println(calendar.getTime());
        String[] header = {"Пн", "Вт", "Ср", "Чт", "Пт", "Сб","Вc" };
        for (String s : header) {
            panel.add(new JTextField(s, 0));
        }
        for (int i = 0; i < calendar2.get(Calendar.DAY_OF_WEEK) -2 ; i++) {
            JButton btn = new JButton("*");
            btn.setEnabled(false);
            panel.add(btn);
        }
        for (int i = 0; i <  Main.buttons.length; i++) {
            Main.buttons[i]= new JButton(Integer.toString(i+1));
            panel.add( Main.buttons[i]);

        }
    }

        public static void Switch(boolean key){
            if (key){
                calendar2.set(calendar2.get(Calendar.YEAR),calendar2.get(Calendar.MONTH)+1, 1);
                calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)+1, calendar.get(Calendar.DAY_OF_MONTH));
            } else{
                calendar2.set(calendar2.get(Calendar.YEAR),calendar2.get(Calendar.MONTH)-1, 1);
                calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)-1, calendar.get(Calendar.DAY_OF_MONTH));
            }
            Main.tfdata.setText(calendar.getDisplayName
                    (Calendar.MONTH, Calendar.LONG, Locale.ENGLISH)+ " " + calendar.get(Calendar.YEAR));
        }// Алгоритм для  календаря!
    public static void CalcListener() {

        for (int i = 0; i < Main.buttons.length; i++) {
            int finalI = i;
            Main.buttons[i].addActionListener(e -> {
                Main.tfDay.setText(Main.buttons[finalI].getText()+" "+calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH)+ " " + calendar.get(Calendar.YEAR));
                System.out.println(Main.raspisanie[finalI]);
            });
        }
}
}

