package MyProject;


import javax.swing.*;

import java.awt.*;

import static MyProject.Main.pari;
import static java.awt.image.ImageObserver.WIDTH;


public class Table {
   public static Object[] colums = new String[]{ "Korpus","Kab", "Name", "Prepod"};
   public static void DrawPari(JPanel panel) {

      for (int i = 0; i < 6; i++) {
         pari[i][0] = "K1";
         pari[i][1] = "406";
         pari[i][2] = "Математика";
         pari[i][3] = "Бибиков";
      }//Будет  браться  из БД!!
      for (int i = 0; i < 6; i++) {
         for (int j = 0; j < 4; j++) {
         }
      }

      JTable table = new JTable(pari, colums);

      int width = Main.WIDTH/3;
      int height = Main.HEIGHT;
      table.setPreferredScrollableViewportSize(new Dimension(width,height));
      panel.add(new JScrollPane(table));



   }// Метод  отрисовки пар!
}


