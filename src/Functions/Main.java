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
public class Main {
    
    //========================================
    //                  MAIN                 =
    //========================================

    public static void main(String[] args) {
        // Create object
        MovieReviews mr = new MovieReviews();
        // Initialize it
        mr.init();
        
        // Input
        Scanner input = new Scanner(System.in);
        System.out.print("Input a word: ");
        String word = input.nextLine();
        
        double score = mr.wordScore(word);
        
        System.out.print("Input a review: ");
        String review = input.nextLine();

        System.out.println("Score: " + score);
        System.out.println("Highest Score: " + mr.mostPositive());
        System.out.println("Lowest Score: " + mr.mostNegative());
        System.out.println("Review Score: " + review + " --> " + mr.reviewScore(review));
    }
}
