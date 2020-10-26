package leetcode;

public class LeetCode79 {
    static String word;
    static char[][] grid;
    private int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    private boolean[][] visited;
    int rows;
    int columns;
    StringBuffer res;
    boolean isExist;
    private boolean inArea(int i,int j){
        return i >= 0 && i < rows && j >= 0 && j < columns;
    }
    private boolean dfs (int i , int j,char grid[][],int start){
        if (start == word.length() - 1){
            isExist = grid[i][j] == word.charAt(start);
            return isExist;
        }
        if (grid[i][j] == word.charAt(start)){
            visited[i][j] = true;
            for (int k = 0 ; k < 4 ; k ++){
                int x = i + directions[k][0];
                int y = j + directions[k][1];
                if (inArea(x,y) && !visited[x][y])
                    if (dfs(x,y,grid,start + 1)){
                        isExist= true;

                    }
            }
            visited[i][j] = false;
        }
        return isExist;
    }
    public boolean exist(char[][] board, String word) {
        res = new StringBuffer();
        rows = board.length;
        if (rows == 0) isExist = false;
        columns = board[0].length;
        //directions = new int[][]{{0,-1},{0,1}{1,0},{-1,0}};
        visited = new boolean[rows][columns];
        for (int i = 0 ; i < rows ; i ++)
            for (int j = 0; j < columns ; j ++)
                if (dfs(i,j,board,0)){
                    isExist = true;
                }
        System.out.println(isExist);
        return isExist;
    }
    public static void main(String[] args){
        grid = new char[][]{{'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}

        };
        word = "SEE";
        new LeetCode79().exist(grid,word);
    }
}
