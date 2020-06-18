package MyProject;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Table {


   private  final String[] columnNames = {"№-Par","Korpus","Kab", "Name", "Prepod"};
   public static Object[][] data = new Object[9][5];
   private  DefaultTableModel model = new DefaultTableModel(data, columnNames);
   private  final JTable table = new JTable(model);

   public void makeUI(JPanel pnl) {
      model.setColumnCount(5);
      JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
      sp.setResizeWeight(.3);
      sp.setTopComponent(new JScrollPane(table));
      pnl.add(sp);

   }
}// Метод  отрисовки пар!

