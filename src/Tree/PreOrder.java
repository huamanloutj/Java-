package Tree;

import java.util.Stack;

public class PreOrder {
    private void preOrder(TreeNode root){
        if (root == null) return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    private void preOrderStack(TreeNode root){
        if (root == null) return;
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode curNode = root;
        while (curNode != null || !nodeStack.isEmpty()){
            while(curNode != null){
                nodeStack.push(curNode);
                System.out.println(curNode.val);
                curNode = curNode.left;
            }
            curNode = nodeStack.pop();
            curNode = curNode.right;
        }
    }
    public static void main(String[] args){
        Integer[] tree = new Integer[]{1,2,3,4,5,null,7};
        CreateTree ct = new CreateTree();
        TreeNode root = ct.arrayToTreeNode(tree);
        new PreOrder().preOrder(root);
        System.out.println();
        //new InOrder().inOrderStack(root);
    }
}
