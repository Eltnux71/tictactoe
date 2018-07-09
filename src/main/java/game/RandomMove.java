package game;

public class RandomMove extends MoveStrategy {

    public RandomMove(Model model) {
        super(model);
    }
    @Override
    protected void doNextMove() {
        while(true) {
            int number = getRandomNumberInRange();
            Cell cell = Cell.getCellByNumber(number);
            if (model.isEmpty(cell.getX(), cell.getY())) {
                model.setValue(TicTacToe.COMPUTER_VALUE, cell.getX(), cell.getY());
                break;
            }
        }
    }
}
