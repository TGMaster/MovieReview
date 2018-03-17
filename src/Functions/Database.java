/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import java.io.*;
import java.util.*;

/**
 *
 * @author TGMaster
 */
public class Database {

    public List<String> readFile() {
        List<String> database = new ArrayList<>();
        try {
            String line = "";
            File f = new File("src/Functions/movieReviews.txt");

            BufferedReader b = new BufferedReader(new FileReader(f));

            while ((line = b.readLine()) != null) {
                database.add(line);
            }
        } catch (IOException e) {
            //e.printStackTrace();
        }
        return database;
    }

    public void writeString(String content) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\test\\filename.txt"))) {
            bw.write(content);
            System.out.println("Done");

        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

    public void writeList(ArrayList<String> content) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\test\\filename.txt"))) {
            for (int i = 0; i < content.size(); i++)
                bw.write(content.get(i));
            System.out.println("Done");

        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

}
