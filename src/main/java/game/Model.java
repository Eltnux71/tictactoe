package game;

public final class Model {
    private static int[][] field = new int[3][3];  
    public Model() {
        for(int i = 0; i < 3; i++) {
           for(int j = 0; j < 3; j++) {
               field[i][j] = -1;
           }         
        }        
    }
    public int[][] getField() {
        return field;
    }
    public boolean isEmpty(int x, int y) {
        return (field[x][y] == -1);
    }
    public void setValue(int val, int x, int y) {
        field[x][y] = val;
    }
    public boolean checkWinCombination(int val) {
        for (int i = 0; i < 3; i++) {
            boolean win = true;
            for (int j = 0; j < 3; j++) {
                if (field[i][j] != val) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            boolean win = true;
            for (int j = 0; j < 3; j++) {
                if (field[j][i] != val) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }            
        if (field[0][0] == val && field[1][1] == val && field[2][2] == val) {
            return true;
        }
        if (field[0][2] == val && field[1][1] == val && field[2][0] == val) {
            return true;
        }        
        return false;
    }
    public boolean isOver() {
        for(int i = 0; i < 3; i++) {
           for(int j = 0; j < 3; j++) {
               if (field[i][j] == -1) {
                   return false;
               }
           }         
        }
        return true;
    }
}
