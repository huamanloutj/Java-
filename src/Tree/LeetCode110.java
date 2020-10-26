package Tree;

/*
给定一个二叉树，判断它是否是高度平衡的二叉树。
 */
public class LeetCode110 {

    public boolean isBalanced(TreeNode root) {

        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        //
        if (root == null) {
            return 0;
        }
        System.out.println("进入" + root.val);
        int left = recur(root.left);
        //System.out.println(left);
        System.out.println("返回" + root.val);
        //这里是层层向上传递的值
        if(left == -1) return -1;
        int right = recur(root.right);

        if(right == -1) return -1;
        System.out.println(left + " " + right + " " + root.val);
        //逻辑
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
    public static void main(String[] args){
        Integer[] tree = new Integer[]{1,2,null,3,null,4,null,5};
        CreateTree ct = new CreateTree();
        TreeNode root = ct.arrayToTreeNode(tree);
        System.out.println(new LeetCode110().recur(root));
    }

}
