package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;
import java.util.Random;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Worm verme;
    private Apple mela;

    public WormGame(int width, int height) {
        super(1000, null);

        this.width = width;
        this.height = height;
        this.continues = true;
        this.verme = new Worm(width / 2, height / 2, Direction.DOWN);
        this.mela = new Apple(new Random().nextInt(width), new Random().nextInt(height));

        while (mela.getX() == width / 2 && mela.getY() == height / 2) {
            this.mela = new Apple(new Random().nextInt(width), new Random().nextInt(height));
        }

        addActionListener(this);
        setInitialDelay(2000);

    }

    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Worm getWorm() {
        return verme;
    }

    public void setWorm(Worm worm) {
        this.verme = worm;

    }

    public Apple getApple() {
        return mela;
    }

    public void setApple(Apple mela) {
        this.mela = mela;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        verme.move();

        if (verme.runsInto(mela)) {
            setApple(new Apple(new Random().nextInt(width), new Random().nextInt(height)));//da fixare per non spawnare su verme           
            verme.grow();
        }

        if (verme.runsIntoItself()) {
            continues = false;
        }

        if (verme.getPieces().get(verme.getLength() - 1).getX() == width || verme.getPieces().get(verme.getLength() - 1).getX() == 0 || verme.getPieces().get(verme.getLength() - 1).getY() == height || verme.getPieces().get(verme.getLength() - 1).getY() == 0) {
            continues = false;

        }
        updatable.update();

        setDelay(1000 / verme.getLength());
    }

}
