package Tree;

import java.util.LinkedList;
import java.util.Queue;

/*
513. 找树左下角的值
给定一个二叉树，在树的最后一行找到最左边的值。

示例 1:

输入:

    2
   / \
  1   3

输出:
1


示例 2:

输入:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

输出:
7
 */
/*
解法二：bfs换个思路，可以直接一遍BFS就行了，避免求树高度。借鉴了这个题解，感谢这位老哥分享。@nuclear30
思路：在循环中将每层结点按从右往左的顺序放入链表，这样左下角的结点即为最后一个结点
 */
public class LeetCode513 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int res = 0;
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0 ; i < size ; i ++){
                TreeNode node = queue.poll();
                res = node.val;
                if (node.right != null){
                    queue.offer(node.right);
                }
                if (node.left != null){
                    queue.offer(node.left);
                }
            }
        }
        return res;
    }
}
