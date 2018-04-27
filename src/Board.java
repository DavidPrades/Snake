
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
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

    private class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (direction != DirectionType.RIGHT) {
                        direction = DirectionType.LEFT;
                        canTurned =false;
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direction != DirectionType.LEFT) {
                        direction = DirectionType.RIGHT;
                        canTurned =false;
                    }

                    break;
                case KeyEvent.VK_SPACE:

                    break;

                case KeyEvent.VK_UP:

                    if (direction != DirectionType.DOWN) {
                        direction = DirectionType.UP;
                        canTurned =false;
                    }

                    break;

                case KeyEvent.VK_DOWN:

                    if (direction != DirectionType.UP) {
                        direction = DirectionType.DOWN;
                        canTurned =false;
                    }

                    break;
                case KeyEvent.VK_P:
                    if (isPlaying) {
                        if (timer.isRunning()) {
                            timer.stop();
                        } else {
                            timer.start();
                        }
                    }
                    break;
                case KeyEvent.VK_ENTER:
                    if (!timer.isRunning()) {
                        initGame();
                    }
                    break;
                default:
                    break;

            }

            repaint();
        }
    }
    
    private boolean canTurned;
    private IncrementScorer scorerDelegate;
    private int num_rows = 30;
    private int num_cols = 40;
    private DirectionType direction;
    private int deltaTime;
    private int currentRow;
    private int currenCol;
    private Food currentFood;
    private boolean isPlaying;
    private Timer timer;
    private Snake snake;
    private Food food;
    private int foodGenerator;
    private SpecialFood specialFood;

    public Board() {
        super();
        initValues();
        timer = new Timer(deltaTime, this);
        canTurned =true;
        snake = null;
        MyKeyAdapter keyb = new MyKeyAdapter();
        addKeyListener(keyb);
        currentFood = null;
        specialFood = null;
    }

    public void setScorer(IncrementScorer scorer) {
        this.scorerDelegate = scorer;
    }

    public void initValues() {

        setFocusable(true);

        deltaTime = 250;
        direction = DirectionType.RIGHT;

    }

    public void initGame() {
        timer.restart();
        foodGenerator = 0;
        direction= DirectionType.RIGHT;

        snake = new Snake(new Node(num_rows / 2, num_cols / 2));
        isPlaying = true;
        
        timer.start();
        scorerDelegate.reset();

    }

    //Game Main Loop
    @Override
    public void actionPerformed(ActionEvent ae) {
        canTurned =true;
        generateFood();

        if (canMove(direction)) {
            snake.moveTo(direction, hasEaten());
        } else {
            timer.stop();
        }
        repaint();
        Toolkit.getDefaultToolkit().sync();
    }

    public boolean hasEaten() {

        if (currentFood != null && currentFood.getFoodPosition().isEqual(snake.getHead())) {
            currentFood = null;
            scorerDelegate.increment(12);
            if (scorerDelegate.getScore() > scorerDelegate.getLevel() * 50) {
                scorerDelegate.incrementLevel();
                decrementDelay();
            }
            return true;
        }

        if (specialFood != null && specialFood.getFoodPosition().isEqual(snake.getHead())) {

            specialFood = null;
            scorerDelegate.increment(50);

            if (scorerDelegate.getScore() > scorerDelegate.getLevel() * 50) {
                scorerDelegate.incrementLevel();
                decrementDelay();
            }
            return true;
        }
        return false;
    }

    public void decrementDelay() {
        deltaTime *= 0.9;
        timer.setDelay(deltaTime);
    }

    public void generateFood() {

        if (foodGenerator % 5 == 0 && currentFood == null && specialFood == null) {
            specialFood = new SpecialFood(snake, num_rows, num_cols);

        } else {

            if (currentFood == null && specialFood == null) {
                currentFood = new Food(snake, num_rows, num_cols);
            }
        }
        
        foodGenerator++;
    }

    public void gameOver() {
        timer.stop();
        scorerDelegate.getScore();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
         //drawBoard(g);
        if (snake != null) {

            snake.draw(g, squareWidth(), squareHeight());

        }
        if (currentFood != null) {
            currentFood.draw(g, squareWidth(), squareHeight());
        }
         if (specialFood != null) {
            specialFood.draw(g, squareWidth(), squareHeight());
        }
        drawBorder(g);
    }
    

    public boolean canMove(DirectionType direction) {

        Node nextMove = snake.nextMove(direction);
        ArrayList<Node> bodySnake = snake.getNodes();
        for (Node body : bodySnake) {
            if (body.isEqual(nextMove)) {
                return false;
            }
        }
        if (nextMove.col < 0 || nextMove.col >= num_cols || nextMove.row < 0 || nextMove.row >= num_rows) {

            return false;
        }
        return true;
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

    public void drawBorder(Graphics g) {
        g.setColor(Color.red);
        g.drawRect(0, 0, num_cols * squareWidth(), num_rows * squareHeight());
    }

}
