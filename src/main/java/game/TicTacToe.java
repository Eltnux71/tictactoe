package game;

import static game.GraphUtils.clear;
import static game.GraphUtils.draw;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {   
    public static final int USER_VALUE = 1;
    public static final int COMPUTER_VALUE = 0;
    
    private MoveStrategy strategy;
    private Model model;
  
    public TicTacToe() {
        init();
    }
    
    private void init() {
        this.model = new Model();
        this.strategy = new AIMove(this.model);
    }
    
    public void start() throws IOException, InterruptedException {
        Scanner sc=new Scanner(System.in);  
        clear();
        draw(model);
        while(true) {
            System.out.print("Enter cell number: ");  
            int index = sc.nextInt();  
            Cell cell = Cell.getCellByNumber(index);
            if (!model.isEmpty(cell.getX(), cell.getY())) {
                clear();
                draw(model);
                continue;
            }
            model.setValue(USER_VALUE, cell.getX(), cell.getY());
            clear();
            draw(model);
            if (model.checkWinCombination(USER_VALUE)) {
                System.out.println("You won!!!");
                System.exit(1);
            }
            if (model.isOver()) {
                System.out.println("Draw ;(");
                System.exit(1);
            }
            this.strategy.doNextMove();
            clear();
            draw(model);
            if (model.checkWinCombination(COMPUTER_VALUE)) {
                System.out.println("Computer won!!!");
                System.exit(1);
            }
        }  
    }
    
    public static void main(String[] args) throws IOException, InterruptedException {
        TicTacToe game = new TicTacToe();
        game.start();
    }
}
