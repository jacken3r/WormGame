/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import wormgame.domain.Piece;
import wormgame.game.WormGame;

/**
 *
 * @author J4cken3R
 */
public class DrawingBoard extends JPanel implements Updatable {

    private WormGame game;
    private int pezzi;

    public DrawingBoard(WormGame game, int pieceLength) {
        this.game = game;
        this.pezzi = pieceLength;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        for (Piece p : game.getWorm().getPieces()) {
            g.fill3DRect(p.getX() * pezzi, p.getY() * pezzi, pezzi, pezzi, true);
        }
        g.setColor(Color.RED);
        g.fillOval(pezzi * game.getApple().getX(), pezzi * game.getApple().getY(), pezzi, pezzi);

    }

    @Override
    public void update() {
        super.repaint();
    }

}
