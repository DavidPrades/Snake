/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alu20908719v
 */
public class Food {

    private Node position;
    

    public Food(Snake snake, int totalRows, int totalCols) {

        boolean collisionWithSnake = true;

        while (collisionWithSnake) {
            collisionWithSnake = false;
            int row = (int) (Math.random() * totalRows + 1);
            int col = (int) (Math.random() * totalCols + 1);

            position = new Node(totalRows, totalCols);
            for (Node body : snake.getNodes()) {

                if (!body.isEqual(position)) {
                    collisionWithSnake = true;

                }
            }
        }
        
        

    }

}
