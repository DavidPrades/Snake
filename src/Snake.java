
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alu20908719v
 */
public class Snake {
    
    private ArrayList<Node> body;
    
    
    public Snake(Node start){
        body = new ArrayList<Node>();
        
        initSnake(start);
    }
    
    public void initSnake(Node start){
        
        body.add(0, start);
        body.add(1, start.decrementCol());
        body.add(2, body.get(1).decrementCol());
        
    }
    
    public ArrayList<Node> getNodes(){
        
        return body;
    }
    
    public void draw(Graphics g, int squareWidth, int squareHeight) {
        
        
        for (Node part: body) {
            
            Util.drawSquare(g, part, Color.yellow, squareWidth, squareHeight);
           
            
        }

    }
}
