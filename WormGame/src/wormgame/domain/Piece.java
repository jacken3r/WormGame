/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

/**
 *
 * @author J4cken3R
 */
public class Piece {

    private int x;
    private int y;

    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean runsInto(Piece piece) {
        if (getX() == piece.getX() && getY() == piece.getY()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        //(x,y)
        return "(" + getX() + "," + getY() + ")";
    }

}
