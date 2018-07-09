package game;

import java.util.Random;

public abstract class MoveStrategy {
    protected Model model;
    private int max = 9;
    private int min = 1;
    public MoveStrategy(final Model model) {
        this.model = model;
    }
    protected int getRandomNumberInRange() {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    protected abstract void doNextMove();
}
