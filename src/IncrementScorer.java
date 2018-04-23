/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alu20925473g
 */
public interface IncrementScorer {

    public void increment(int points);

    public void reset();

    public int getScore();

    public void paintFinalScore();

    public int getLevel();

    public void incrementLevel();

    public void incrementLines();

}
