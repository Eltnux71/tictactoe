package game;

import java.io.IOException;

public final class GraphUtils {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    
    public static void clear() throws IOException, InterruptedException {
        new ProcessBuilder("clear").inheritIO().start().waitFor();
    } 
    
    public static void draw(Model model) {
        int[][] field = model.getField();
        System.out.println("---- Tic Tac Toe Game!!! --------");
        System.out.println(" ");
        System.out.println("-------");
        int j = 0;
        for(int i = 0; i < 3; i++) {
           String a1 = (field[i][0] == -1) ? "" : Integer.toString(field[i][0]); 
           String a2 = (field[i][1] == -1) ? "" : Integer.toString(field[i][1]); 
           String a3 = (field[i][2] == -1) ? "" : Integer.toString(field[i][2]); 
           
           j++;
           if (a1.isEmpty()) {             
               a1 = ANSI_CYAN + Integer.toString(j) + ANSI_RESET;
           }
           j++;
           if (a2.isEmpty()) {
               a2 = ANSI_CYAN + Integer.toString(j) + ANSI_RESET;
           }
           j++;
           if (a3.isEmpty()) {
               a3 = ANSI_CYAN + Integer.toString(j) + ANSI_RESET;
           }           

           System.out.println("|" + a1 + "|" + a2 + "|" + a3 + "|");
           System.out.println("-------");
        }
    }      
}
