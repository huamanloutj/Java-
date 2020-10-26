package Tree;

import java.util.Stack;

public class InOrder {
    private void inOrder(TreeNode root){
//        try {
//            System.out.println("进入递归" +root.val);
//        }catch (Exception e){
//
//        }
        if (root == null) return;
        inOrder(root.left);
        System.out.println(root.val + " ");
        inOrder(root.right);
    }
    private void inOrderStack(TreeNode node){
        Stack<TreeNode> resStack = new Stack<>();
        if (node == null) return;
        while(node != null || !resStack.isEmpty()){
            while (node != null){
                resStack.push(node);
                node = node.left;
            }
            node = resStack.pop();;

            System.out.print(node.val + " ");
            //resStack.push(node);
            node = node.right;

        }
    }
    public static void main(String[] args){
        Integer[] tree = new Integer[]{1,2,null,3,null,4,null,5};
        CreateTree ct = new CreateTree();
        TreeNode root = ct.arrayToTreeNode(tree);
        new InOrder().inOrder(root);
        System.out.println();
        //new InOrder().inOrderStack(root);
    }
}
