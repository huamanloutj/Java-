package SwordFingerOffer;

import java.util.ArrayList;
import java.util.List;

public class Offer13 {
    static List<StringBuffer> res;
    static StringBuffer tmp;
    static char[][] matrix;
    static String   target;
    static boolean[][] visited;
    private void dfs(char[][] s,int x,int y){
        if ( x < 0 || y < 0 || x > s.length || y > s[0].length)
            return;
        for (int i = 0 ; i < s.length ; i ++)
            for (int j = 0 ; j < s[0].length ; j ++){
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    tmp.append(s[i][j]);
                    res.add(new StringBuffer(tmp));
                    dfs(s, i - 1, j);
                    visited[i][j] = false;
                    tmp.deleteCharAt(tmp.length() - 1);
                    if (i + 1 < s.length && j < s[0].length) {
                        dfs(s, i + 1, j);
                        visited[i][j] = false;
                        tmp.deleteCharAt(tmp.length() - 1);
                    }
                    dfs(s, i, j - 1);
                    visited[i][j] = false;
                    tmp.deleteCharAt(tmp.length() - 1);
                    dfs(s, i, j + 1);
                    visited[i][j] = false;
                    tmp.deleteCharAt(tmp.length() - 1);
                }
            }
    }
    public static void main(String[] args){
        matrix = new char[][]{{'A','B','C','E'},
                              {'S','F','C','S'},
                              {'A','D','E','E'},
                              };
        target = "ABCCED";
        tmp = new StringBuffer();
        res = new ArrayList<>();
        visited = new boolean[matrix.length][matrix[0].length];
        new Offer13().dfs(matrix,0,0);
        for (int i = 0 ; i < res.size() ; i ++)
            if (res.get(i).toString() == target)
                System.out.println("exisit");
        System.out.println(res);
    }
}
