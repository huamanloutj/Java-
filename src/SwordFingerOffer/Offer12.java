package SwordFingerOffer;

public class Offer12 {
    private int[][] directions ;
    private char[][] grid;
    private boolean[][] visited;
    int rows;
    int columns;
    //int count = 0;
    static StringBuffer res;
    static String word;
    boolean isExist;
    /*
    用flag表示也是可以的，统一返回flag
     */
    private boolean exist(char[][] grid,String word){
        //word = "aabbbbabbaababaaaabababbaaba";
        //word = "SEE";
        res = new StringBuffer();
        this.grid = grid;
        rows = grid.length;
        if (rows == 0)
            isExist = false;
            //return false;
        columns = grid[0].length;
        directions = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        visited = new boolean[rows][columns];
        for (int i = 0 ; i < rows ; i ++)
            for (int j = 0; j < columns ; j ++)
                if (dfs(i,j,0,grid,word) ) {
                    isExist = true;
                    //return true;
                    //dfs(i,j);

                    //count ++;
                }
        //return false;
        return isExist;
    }
    private boolean dfs (int i , int j, int start,char[][] grid,String word){
        if (start == word.length() - 1 ){
            isExist =  grid[i][j] == word.charAt(start);
            //return grid[i][j] == word.charAt(start);
//            if (grid[i][j] == word.charAt(start))
//                isExist = true;
//            else isExist = false;
            return isExist;
        }
        if (grid[i][j] == word.charAt(start)) {

            visited[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int newX = i + directions[k][0];
                int newY = j + directions[k][1];
                if (inArea(newX,newY) && !visited[newX][newY])
                    if (dfs(newX,newY,start + 1,grid,word)) {
                        //return true;
                        isExist = true;
                        break;
                    }
            }
            visited[i][j] = false;
        }
        //return false;
        return isExist;
    }
    private boolean inArea(int i,int j){
        return i >= 0 && i < rows && j >= 0 && j < columns;
    }
    public static void main(String[] args){
//        char[][] grid1 = {{'b','a','a','b','a','b'},
//                          {'a','b','a','a','a','a'},
//                          {'a','b','a','a','a','b'},
//                          {'a','b','a','b','b','a'},
//                          {'a','a','b','b','a','b'},
//                          {'a','a','b','b','b','a'},
//                          {'a','a','b','a','a','b'}
//                          };
        char[][] grid1 = {{'C','A','A'},{'A','A','B'},{'B','C','D'}};


        word = "AAB";
        System.out.println(new Offer12().exist(grid1,word));


    }
}

