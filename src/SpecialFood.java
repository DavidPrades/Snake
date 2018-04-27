
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alu20908719v
 */
public class SpecialFood {

    

    private int paint;

    private Node position;

    public SpecialFood(Snake snake, int totalRows, int totalCols) {
        
        boolean collisionWithSnake = true;

        while (collisionWithSnake) {
            collisionWithSnake = false;
            int row = (int) (Math.random() * totalRows);
            int col = (int) (Math.random() * totalCols);
            position = new Node(row, col);

            for (Node body : snake.getNodes()) {
                if (body.isEqual(position)) {
                    collisionWithSnake = true;

                }
            }
        }

    }

    public Node getFoodPosition() {
        return position;
    }

    public void draw(Graphics g, int squareWidth, int squareHeight) {
        
        if(paint == 3 || paint ==4 || paint ==5){
            Random random = new Random();
            
            int r = random.nextInt(255);
            int j = random.nextInt(255);
            int b = random.nextInt(255);
            Color c = new Color(r, j, b);
        Util.drawSquare(g, position, c, squareWidth, squareHeight);
        } 
        paint++;
        if(paint ==6){
            paint = 0;
        }

    }

}
