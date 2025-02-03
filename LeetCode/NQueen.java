import java.util.ArrayList;
import java.util.List;
class NQueen { 
    static boolean canwego(int row, int col, int n, List<String> grid) { 
        for (int i = row - 1; i >= 0; i--) {
            if (grid.get(i).charAt(col) == 'Q') {
                return false;
            }
        } 
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (grid.get(i).charAt(j) == 'Q') {
                return false;
            }
        } 
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (grid.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }
    static void  f(int row, int n, List<String> grid, List<List<String>> result) { 
        if (row == n) {
            result.add(new ArrayList<>(grid));
            return;
        } 
        for (int col = 0; col < n; col++) {
            if (canwego(row, col, n, grid)) {
                char[] charArray = grid.get(row).toCharArray();
                charArray[col] = 'Q';
                grid.set(row, new String(charArray));
                f(row + 1, n, grid, result); 
                charArray[col] = '.';
                grid.set(row, new String(charArray));
            }
        }
    } 
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> grid = new ArrayList<>();
        // Initialize the grid with empty cells
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            for (int j = 0; j < n; j++) {
                row[j] = '.';
            }
            grid.add(new String(row));
        }
         
        f(0, n, grid, result);
        return result;
    }

    public static void main(String[] args) {
       
        int n = 4; // For example
        List<List<String>> solutions = solveNQueens(n);
        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
        System.out.println(solutions.size());
    }
    //OTHER METHODS ----------------------------------------------------------------
    // Other methods to solve the N-Queens problem can be added here
    // row array of size=row;
    // mid diagonal of size=row+n-1-col;
    // sc of size=row+col;

}

