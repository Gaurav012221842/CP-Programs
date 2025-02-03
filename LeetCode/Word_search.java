public class Word_search {
    public static boolean backtrack(char[][] board,String word,boolean[][] vis,int i,int j,int idx){
        if(idx==word.length())return true;
        if(i<0||i>=board.length||j<0||j>=board[0].length||vis[i][j]||board[i][j]!=word.charAt(idx)){
                return false;
            }
        vis[i][j]=true;
        if(backtrack(board, word, vis, i+1, j, idx+1)||backtrack(board, word, vis, i-1, j, idx+1)||
        backtrack(board, word, vis, i, j-1, idx+1)||backtrack(board, word, vis, i, j+1, idx+1)){
            return true;
        }
        vis[i][j]=false;
        return false;
    }
    public static boolean exist(char[][] board,String word){
        int m=board.length;
        int n=board[0].length;
        boolean[][] vis=new boolean[m][n];
        boolean res=false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    res=backtrack(board,word,vis,i,j,0);
                    if(res)return true;

                }

            }
        }
        return false;
    }
    static public boolean isWordExist(char[][] mat, String word) {
        // Code here
        int m=mat.length;
        int n=mat[0].length;
        boolean res=false;
        boolean[][] vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==word.charAt(0)){
                    res=find(mat,i,vis,j,word,0);
                    if(res)return true;
                }
            }
        }
        return false;
    }
    static public boolean find(char[][] mat,int i,boolean[][] vis,int j,String word,int idx){
        if(idx==word.length())return true;
        if(i<0||j<0||i>=mat.length||j>=mat[0].length||vis[i][j]||mat[i][j]!=word.charAt(idx)){
            return false;
        }
        vis[i][j]=true;
        if( find(mat,i+1,vis,j,word,idx+1)||
            find(mat,i-1,vis,j,word,idx+1)||
            find(mat,i,vis,j+1,word,idx+1)||
            find(mat,i,vis,j-1,word,idx+1)){
            return true;
        }
        vis[i][j]=false;
        return false;
    }   
    public static void main(String[] args) {
        char[][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word="ABCCE";
        System.out.println(isWordExist(board, word));
    }
    
}
