package MyProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Data {
    static BufferedReader reader;
    public static void pullData(int finalI){
        try {
        reader = new BufferedReader(new FileReader(
                "1."+finalI +".txt"));
        String line = reader.readLine();
        String[] s;
        int key = 0;
        while (line != null) {
            s = line.split(",");
            for (int i = 0; i < s.length; i++) {
                Table.data[key][i] = s[i];
            }
            // read next line
            line = reader.readLine();
            key = key+1;
        }
        reader.close();
    } catch (IOException e) {
            System.out.println("Нет файла");;
    }
    }
}
