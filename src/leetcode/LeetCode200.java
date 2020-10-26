package leetcode;

/*
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。

示例 1:

输入:
[
['1','1','1','1','0'],
['1','1','0','1','0'],
['1','1','0','0','0'],
['0','0','0','0','0']
]
输出: 1
示例 2:

输入:
[
['1','1','0','0','0'],
['1','1','0','0','0'],
['0','0','1','0','0'],
['0','0','0','1','1']
]
输出: 3
解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-islands
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode200 {
    private int[][] directions ;
    private char[][] grid;
    private boolean[][] visited;
    int rows;
    int columns;
    int count = 0;
    private int numsIlands(char[][] grid){
        this.grid = grid;
        rows = grid.length;
        columns = grid[0].length;
        directions = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        visited = new boolean[rows][columns];
        if (rows == 0)
            return 0;
        for (int i = 0 ; i < rows ; i ++)
            for (int j = 0; j < columns ; j ++)
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(i,j);
                    count ++;
                }
        return count;
    }
    /*没有回溯*/
    private void dfs (int i , int j){
        visited[i][j] = true;
        for (int k = 0 ; k < 4 ; k ++ ) {
            int newX = i + directions[k][0];
            int newY = j + directions[k][1];
            if (inArea(newX,newY) && !visited[newX][newY] && grid[newX][newY] == '1')
                dfs(newX,newY);
    }

    }
    private boolean inArea(int i,int j){
        return i >= 0 && i < rows && j >= 0 && j < columns;
    }
    public static void main(String[] args){
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};


        System.out.println(new LeetCode200().numsIlands(grid1));


    }
}
