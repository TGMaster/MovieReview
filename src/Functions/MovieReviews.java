package Functions;

import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author TGMaster
 */
public class MovieReviews implements IgnoreWord {

    Database db = new Database();
    List<String> reviews = db.readFile();

    Processing pr = new Processing();

    public void init() {
        pr.addToList();
    }

    public void test() {
        for (Word w : LIBRARY) {
            System.out.println(w.getName() + " " + w.getScore());
        }
    }

    // Find score of a word
    public double wordScore(String word) {
        boolean isExist = false;

        for (Word o : LIBRARY) {
            if (o.getName().equals(word)) {
                isExist = true;
                break;
            }
        }

        if (isExist) {
            for (int i = 0; i < LIBRARY.size(); i++) {
                if (LIBRARY.get(i).getName().equals(word)) {
                    return LIBRARY.get(i).getScore();
                }
            }
        }
        return 2.0;
    }

    // Find word = highest score
    public String mostPositive() {
        List<Double> temp = new ArrayList<>();
        for (int i = 0; i < LIBRARY.size(); i++) {
            if (LIBRARY.get(i).getNumber() >= 2) {
                temp.add(LIBRARY.get(i).getScore());
            }
        }
        int index = maxIndex(temp);
        return LIBRARY.get(index).getName();
    }

    // Find word = lowest score
    public String mostNegative() {
        List<Double> temp = new ArrayList<>();
        for (int i = 0; i < LIBRARY.size(); i++) {
            if (LIBRARY.get(i).getNumber() >= 2) {
                temp.add(LIBRARY.get(i).getScore());
            }
        }
        int index = minIndex(temp);
        return LIBRARY.get(index).getName();
    }

    // Find the index of list = lowest number
    public static int minIndex(List<Double> list) {
        return list.indexOf(Collections.min(list));
    }

    // Find the index of list = highest number
    public static int maxIndex(List<Double> list) {
        return list.indexOf(Collections.max(list));
    }

    public double reviewScore(String review) {
        review = Processing.replace(review);
        List<String> temp = Arrays.asList(review.split(" "));
        Stack<Double> rvScore = new Stack<>();

        for (int i = 0; i < LIBRARY.size(); i++) {
            for (String j : temp) {
                if (LIBRARY.get(i).getName().equalsIgnoreCase(j))
                    rvScore.push(LIBRARY.get(i).getScore());
            }
        }
        double avg = 0.0;
        int size = rvScore.size();
        for (int i = 0; i < size; i++) {
            avg += rvScore.pop();
        }
        return avg/(size*1.0);
    }
}
