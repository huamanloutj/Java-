package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Permute {
    public static void main(String[] args){
        //Scanner in = new Scanner(System.in);
        //StringBuffer res = new StringBuffer();
        nums = new int[]{1,1,2};
        visited = new boolean[nums.length];
        res = new HashSet<>();
        temp = new ArrayList<>();
        new Permute().dfs(nums,0);
    }
    //static List<List<Integer>> res;
    static HashSet<List<Integer>> res;
    static List<Integer> temp;
    static int nums[];
    static boolean visited[] ;

    void dfs(int[] nums,int level){
        if (level >= nums.length){
            System.out.println("添加temp:"+temp);
            // 值传递，和引用传递
            // 错误代码 res.add(temp);
            //链接https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
            res.add(new ArrayList<>(temp));
            System.out.println("添加后res:"+res);
            return;
        }

        for (int i = 0 ; i < nums.length ; i ++){
            if(!visited[i]) {
                temp.add(nums[i]);
                visited[i] = true;
                dfs(nums, level + 1);
                visited[i] = false;
                temp.remove(temp.size() - 1);

            }
        }

    }
    void printRes(int nums[],int level){
        dfs(nums,level);
        System.out.println("最终结果:" + res);
    }

}
