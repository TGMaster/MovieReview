/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author TGMaster
 */
public class Test {

    public final static String[] Words = {"I", "you", "it", "he", "she", "we", "they", "a", "an", "the", "and", "or", "but"};

    public static void main(String[] args) {
        String test = "A series's step-by-step -LBR- ab he She It 123 ";
        int size = Words.length;

        for (int i = 0; i < size; i++) {
            test = test.replaceAll("\\b(?i)"+Words[i]+"\\b\\s*", "")
                    .replaceAll("\\p{Punct}{1,2}", "")
                    .replaceAll("\\b[\\w]{1,2}\\b\\s*", "")
                    .replaceAll("[\\d]\\s*", "");
//            line = line.replaceAll("\t", "")
//                    .replaceAll("\\b[A-Za-z]{2}\\b\\s", "")
//                    .replaceAll("\\p{Punct}{1,2}\\s", "")
//                    .replaceAll("[\\d]\\s", "");
        }
        System.out.println(test);
    }
}
