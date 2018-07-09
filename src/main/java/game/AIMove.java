package game;

import java.util.ArrayList;
import java.util.List;

public class AIMove extends RandomMove {
    public AIMove(Model model) {
        super(model);
    }
    @Override
    protected void doNextMove() {
        // check for own 2 selected
        Cell cell = getNextMove(TicTacToe.COMPUTER_VALUE, 2);
        if (cell != null) {
            model.setValue(TicTacToe.COMPUTER_VALUE, cell.getX(), cell.getY());
            return;
        }
        // check for other 2 selected
        cell = getNextMove(TicTacToe.USER_VALUE, 2);
        if (cell != null) {
            model.setValue(TicTacToe.COMPUTER_VALUE, cell.getX(), cell.getY());
            return;
        }
        // check for own 1 selected
        cell = getNextMove(TicTacToe.COMPUTER_VALUE, 1);
        if (cell != null) {
            model.setValue(TicTacToe.COMPUTER_VALUE, cell.getX(), cell.getY());
            return;
        }
        super.doNextMove();
    }
    
    private Cell getNextMove(int val, int size) {
        int[][] field = model.getField();
        Cell cell = null;
        List<Boolean> list = null;
        for (int i = 0; i < 3; i++) {
            list = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                if (field[i][j] == val) {
                    list.add(Boolean.TRUE);
                } else if (field[i][j] == -1) {
                    cell = new Cell(i,j);
                } else {
                    cell = null;
                    break;
                }
            }
            if (list.size() == size) {
                return cell;
            }
        }
        for (int i = 0; i < 3; i++) {
            list = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                if (field[j][i] == val) {
                    list.add(Boolean.TRUE);
                } else if (field[j][i] == -1) {
                    cell = new Cell(j,i);
                } else {
                    cell = null;
                    break;
                }
            }
            if (list.size() == size) {
                return cell;
            }
        }   
        list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (field[i][i] == val) {
                list.add(Boolean.TRUE);
            } else if (field[i][i] == -1) {
                cell = new Cell(i, i);
            } else {
                cell = null;
                break;
            }
        }
        if (list.size() == size) {
            return cell;
        }
        list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (field[i][2-i] == val) {
                list.add(Boolean.TRUE);
            } else if (field[i][2-i] == -1) {
                cell = new Cell(i, 2-i);
            } else {
                cell = null;
                break;
            }
        }
        if (list.size() == size) {
            return cell;
        }              
        return null;
    }
    
}
