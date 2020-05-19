package MyProject;


import javax.swing.JFrame;

import static MyProject.Main.pari;
import static MyProject.Main.textArea;

public class Table {

   public static void DrawPari() {

      for (int i = 0; i < 6; i++) {
         pari[i][0] = "| K1 - 406 |";
         pari[i][1] = "Математика |";
         pari[i][2] = "Бибиков";
      }//Будет  браться  из БД!!
      for (int i = 0; i < 6; i++) {
         textArea.append(String.valueOf(i + 1));
         for (int j = 0; j < 3; j++) {
            textArea.append(pari[i][j] + " ");
            //JTable table = new JTable(pari[][]);
            //table.setRowHeight(70);

         }
         textArea.append("\n");
      }// Метод  отрисовки пар!
   }

   }


