package game;

public class Cell {

    private int x;
    private int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static Cell getCellByNumber(int i) {
        Cell result = null;
        switch (i) {
            case 1:
                result = new Cell(0, 0);
                break;
            case 2:
                result = new Cell(0, 1);
                break;
            case 3:
                result = new Cell(0, 2);
                break;
            case 4:
                result = new Cell(1, 0);
                break;
            case 5:
                result = new Cell(1, 1);
                break;
            case 6:
                result = new Cell(1, 2);
                break;
            case 7:
                result = new Cell(2, 0);
                break;
            case 8:
                result = new Cell(2, 1);
                break;
            case 9:
                result = new Cell(2, 2);
                break;
        }
        return result;
    }
}
