public class Word_Search2 {
     
        public static boolean backtrack(char[][] board,String word,boolean[][] vis,int i,int j,int idx){
            if(idx==word.length())return true;
            if(i<0||i>=board.length||j<0||j>=board[0].length||vis[i][j]||board[i][j]!=word.charAt(idx))return false;
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
        public static void main(String[] args) {
            char[][] board={{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
            String[] words={"oath","pea","eat","rain"};
            for(String word: words){
                System.out.println(word + ": " + exist(board, word));
            }
        }
}
    
