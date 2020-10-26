package Tree;

import java.util.*;

public class Test {


    public static void main(String[] args) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(new TreeNode(1));
        queue.offer(new TreeNode(2));
        queue.poll();
        queue.poll();
        TreeNode p = queue.peek();
        System.out.println(p);
//        while (!queue.isEmpty()){
//
//        }
    }
}
