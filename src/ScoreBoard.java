
import java.awt.Color;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alu20925473g
 */
public class ScoreBoard extends JLabel implements IncrementScorer {

    private int score;
  
    private int level;

    public ScoreBoard() {
        super();
        score = 0;
       
        level = 1;
    }

    public void increment(int points) {
        score += points;
        setText("Score: " + score + "  Level: " + level);
    }

    public void reset() {
        score = 0;
       
        level = 1;
        setText("Score: " + score + " Level: " + level);
    }

    @Override
    public int getScore() {
        return score;
    }

    public int getLevel() {
        return level;
    }

    public void incrementLevel() {
        level++;
        setText("Score: " + score + "  Level: " + level);
    }

  

    @Override
    public void paintFinalScore() {
        setText("your final score is " + score);
        setForeground(Color.RED);
    }
}
