
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alu20908719v
 */
public class Board extends JPanel implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

    private int num_rows = 30;
    private int num_cols = 40;
    private int deltaTime;
    private int currentRow;
    private int currenCol;

    
    private Timer timer;
    private Snake snake;
    private Food food;
    
    
    public Board(){
        super();
        
       snake =  new Snake(new Node(num_rows/2, num_cols/2 ));
        
       
    }
     protected void paintComponent(Graphics g) {
        super.paintComponent(g);
       // drawBoard(g);
        if (snake != null) {
            
           snake.draw(g, squareWidth(), squareHeight());
            

        }
        //drawBorder(g);
    }

    public int getNum_rows() {
        return num_rows;
    }

    public int getNum_cols() {
        return num_cols;
    }

    public void setNum_rows(int num_rows) {
        this.num_rows = num_rows;
    }

    public void setNum_cols(int num_cols) {
        this.num_cols = num_cols;
    }
    
     private int squareWidth() {
        return getWidth() / num_cols;
    }

    private int squareHeight() {
        return getHeight() / num_rows;
    }
    
    
    
}
