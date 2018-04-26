
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

    public Snake(Node start) {
        body = new ArrayList<Node>();

        initSnake(start);
    }

    public void initSnake(Node start) {

        body.add(new Node(start.row, start.col));
        body.add(new Node(start.row, start.col - 1));
        body.add(new Node(start.row, start.col - 2));
        body.add(new Node(start.row, start.col - 3));
        body.add(new Node(start.row, start.col - 4));

    }

    public ArrayList<Node> getNodes() {

        return body;
    }

    public void moveTo(DirectionType direction) {

        Node head = body.get(0);
        switch (direction) {

            case RIGHT:
                body.add(0, new Node(head.row, head.col + 1));
                body.remove(body.size() - 1);
                break;
            case LEFT:
                body.add(0, new Node(head.row, head.col - 1));
                body.remove(body.size() - 1);
                break;
            case UP:
                body.add(0, new Node(head.row - 1, head.col));
                body.remove(body.size() - 1);
                break;
            case DOWN:
                body.add(0, new Node(head.row + 1, head.col));
                body.remove(body.size() - 1);
                break;
        }
    }
    
        

    public Node nextMove(DirectionType direction) {
        Node head = body.get(0);
        switch (direction) {

            case RIGHT:
                return new Node(head.row, head.col +1);

            case LEFT:
                return new Node(head.row, head.col-1);

            case UP:
                return new Node(head.row -1, head.col);

            case DOWN:
                return new Node(head.row+1, head.col);

        }
        return null;
    }

    public void draw(Graphics g, int squareWidth, int squareHeight) {

        int i = 0;

        for (Node part : body) {
            if (i == 0) {
                Util.drawSquare(g, part, Color.GRAY, squareWidth, squareHeight);
            } else {
                Util.drawSquare(g, part, Color.WHITE, squareWidth, squareHeight);
            }

            i++;
        }
        

    }
}
