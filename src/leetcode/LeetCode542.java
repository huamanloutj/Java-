package leetcode;

public class LeetCode542 {
    static int[][] res;
    static int distance;
    static boolean[][] visited;
    static int[][] directions;
    static int rows;
    static int columns;
    public boolean inArea(int i , int j){
        return i >= 0 &&   i < rows && j >=0 && j < columns;
    }
    public void dfs(int[][] matrix,int i ,int j){

         if (matrix[i][j] == 0 || i < 0 || i >= rows || j < 0 || j > columns) {
             res[i][j] = Math.max(res[i][j], distance);
             return;
         }

        for (int k = 0 ; k < 4 ; k ++){
            distance = 0;
            int newX = i + directions[k][0];
            int newY = j + directions[k][1];
            if (inArea(newX,newY) && !visited[newX][newY]){
                visited[i][j] = true;
                distance ++;
                dfs(matrix,newX,newY);
                visited[i][j] = false;
            }
        }
    }
    public int[][] updateMatrix(int[][] matrix) {

        directions = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        rows = matrix.length;
        if (rows == 0) return new int[][]{{0}};
        columns = matrix[0].length;
        res = new int[rows][columns];
        visited = new boolean[rows][columns];
        for (int i = 0 ; i < rows ;i ++) {

            for (int j = 0; j < columns; j++) {
                //System.out.println("matrix[i][j]:" + matrix[i][j] + ",visited[i][j]" + visited[i][j]);
                if (!visited[i][j] && matrix[i][j] == 1) {
                    //System.out.println("zheli");
                    dfs(matrix, i, j);
                }
            }
        }
        return res;
    }
    public void main(){
       int[][] matrix = new int[][]{
               {0, 0 ,0},
               {0 ,1, 0},
               {1 ,1 ,1},

       };

       updateMatrix(matrix);
        for (int i = 0 ; i < rows ;i ++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println("\n");
        }
    }
    public static void main(String[] args){
        new LeetCode542().main();
    }
}

