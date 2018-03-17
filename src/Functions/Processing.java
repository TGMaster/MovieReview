/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import java.util.*;

/**
 *
 * @author TGMaster
 */
interface IgnoreWord {

    public final static String[] IGNORE = {"I", "you", "it", "he", "she", "we", "they", "a", "an", "the", "and", "or", "but"};
    List<Word> LIBRARY = new ArrayList<>();
}

public class Processing implements IgnoreWord {

    Database db = new Database();
    List<String> data = db.readFile();

    public void addToList() {
        for (String line : data) {
            // Get the score
            int score = Character.getNumericValue(line.charAt(0));

            // Replace string
            line = replace(line);
            
            // Split line into single words
            List<String> temp = Arrays.asList(line.split(" "));

            for (String i : temp) {
                // The word is new and not stored in library
                if (!isContain(LIBRARY, i)) {
                    Word word = new Word(i, score, 1);
                    LIBRARY.add(word);

                    // The word is already stored in library
                } else {

                    // Update total and number of times it appears
                    for (int j = 0; j < LIBRARY.size(); j++) {
                        if (LIBRARY.get(j).getName().equals(i)) {
                            // Increase number of times
                            int count = LIBRARY.get(j).getNumber();
                            LIBRARY.get(j).setNumber(count + 1);

                            // Update total score
                            int total = LIBRARY.get(j).getTotal();
                            LIBRARY.get(j).setTotal(total + score);
                        }

                    }
                }
            }
        }
    }

    public boolean isContain(List<Word> list, String name) {
        for (Word w : list) {
            if (w.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static String replace(String line) {
        // Replace String
        for (String IGNORE1 : IGNORE) {
            line = line.replaceAll("\\b(?i)" + IGNORE1 + "\\b\\s*", "");
        }

        line = line.replaceAll("\t", "")
                .replaceAll("\\p{Punct}{1,2}", "")
                .replaceAll("\\b[\\w]{1,2}\\b\\s*", "")
                .replaceAll("[\\d]\\s*", "");
        return line;
    }

}
