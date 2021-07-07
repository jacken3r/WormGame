/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import java.util.ArrayList;
import java.util.List;
import wormgame.Direction;

/**
 *
 * @author J4cken3R
 */
public class Worm {

    private int x;
    private int y;
    private Direction direction;
    private ArrayList<Piece> pezziDelVerme;
    private boolean grow;

    public Worm(int originalX, int originalY, Direction originalDirection) {
        this.x = originalX;
        this.y = originalY;
        this.direction = originalDirection;
        this.pezziDelVerme = new ArrayList<Piece>();
        pezziDelVerme.add(new Piece(this.x, this.y));
        this.grow = false;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction dir) {
        this.direction = dir;
    }

    public int getLength() {
        return pezziDelVerme.size();
    }

    public List<Piece> getPieces() {
        return pezziDelVerme;
    }

    public void move() {
        int nuovaX = pezziDelVerme.get(pezziDelVerme.size() - 1).getX();
        int nuovaY = pezziDelVerme.get(pezziDelVerme.size() - 1).getY();

        if (getDirection() == Direction.UP) {
            nuovaY--;
        }
        if (getDirection() == Direction.DOWN) {
            nuovaY++;
        }
        if (getDirection() == Direction.LEFT) {
            nuovaX--;
        }
        if (getDirection() == Direction.RIGHT) {
            nuovaX++;
        }

        if (getLength() > 2 && !grow) {
            pezziDelVerme.remove(0);
        }
        if (grow) {
            grow = false;
        }
        pezziDelVerme.add(new Piece(nuovaX, nuovaY));

    }

    public void grow() {
        grow = true;
    }

    public boolean runsInto(Piece piece) {
        for (Piece p : pezziDelVerme) {
            if (p.getX() == piece.getX() && p.getY() == piece.getY()) {
                return true;
            }
        }
        return false;
    }

    public boolean runsIntoItself() {
        Piece testa = pezziDelVerme.get(getLength() - 1);
        for (int i = 0; i < getLength() - 1; i++) {
            if (testa.getX() == pezziDelVerme.get(i).getX() && testa.getY() == pezziDelVerme.get(i).getY()) {
                return true;
            }
        }
        return false;
    }
}
