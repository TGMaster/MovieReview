/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

/**
 *
 * @author TGMaster
 */
public class Word {
    private double score;
    private String name;
    private int number;
    private int total;

    public Word() {
    }

    public Word(String name, int total, int number) {
        this.name = name;
        this.number = number;
        this.total = total;
    }
    
    public double getScore() {
        return total*1.0/(number*1.0);
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
}
