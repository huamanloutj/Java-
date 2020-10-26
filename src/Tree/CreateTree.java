package Tree;

import java.util.Queue;
import java.util.LinkedList;
public class CreateTree {
    public  TreeNode arrayToTreeNode(Integer[] array){
        if(array.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeft = true;
        for(int i = 1; i < array.length; i++){
            TreeNode node = queue.peek();
            if(isLeft){
                if(array[i] != null){
                    node.left = new TreeNode(array[i]);
                    queue.offer(node.left);
                }
                    isLeft = false;
            }else{
                if(array[i] != null){
                    node.right = new TreeNode(array[i]);
                    queue.offer(node.right);
                }
                queue.poll();
                isLeft = true;
            }
        }
        return root;
    }
    public void InOrder(TreeNode root){
        if(root != null){
            InOrder(root.left);
            System.out.println(root.val);
            InOrder(root.right);
        }
    }
    public static void main(String[] args){
        Integer[] tree = new Integer[]{1,2,3,4,5,null,7};
        CreateTree ct = new CreateTree();
        TreeNode root = ct.arrayToTreeNode(tree);
        ct.InOrder(root);
    }
}

