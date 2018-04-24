/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alu20908719v
 */
public class Node  {
    
    public int row;
    public int col;
    
    public Node(int row, int col){
        
        this.row=row;
        this.col=col;
        
    }
    
    public Node decrementCol(){
        this.col--;
        return new Node(row, col);
    }

    
    public boolean isEqual(Node t) {
        if(t.row ==  row && t.col == col){
            return true;
        }
        return false;
    }
    
    
}
