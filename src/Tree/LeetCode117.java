package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode117 {
//    public Node connect(Node root) {
//        if (root == null)
//            return null;
//        Queue<Node> queue = new LinkedList<>();
//        // Node pre = new Node(0);
//        // pre.next = null;
//        queue.offer(root);
//        while(!queue.isEmpty()){
//
//            Node pre = null;
//            int size = queue.size();
//            for (int i = 0 ; i < size ; i ++){
//                System.out.println("出队前" + queue);
//                Node node = queue.poll();
//                if (pre != null)
//                    pre.next = node;
//                pre = node;
//                if (node.left != null) queue.offer(node.left);
//                if (node.right != null) queue.offer(node.right);
//                System.out.println("更新后" + queue);
//            }
//        }
//        return root;
//    }
public Node connect(Node root) {
    if (root == null)
        return root;
    //cur我们可以把它看做是每一层的链表
    Node cur = root;
    while (cur != null) {
        //遍历当前层的时候，为了方便操作在下一
        //层前面添加一个哑结点（注意这里是访问
        //当前层的节点，然后把下一层的节点串起来）
        Node dummy = new Node(0);
        //pre表示访下一层节点的前一个节点
        Node pre = dummy;
        //然后开始遍历当前层的链表
        while (cur != null) {
            if (cur.left != null) {
                //如果当前节点的左子节点不为空，就让pre节点
                //的next指向他，也就是把它串起来
                pre.next = cur.left;
                //然后再更新pre
                pre = pre.next;
            }
            //同理参照左子树
            if (cur.right != null) {
                pre.next = cur.right;
                pre = pre.next;
            }
            //继续访问这一行的下一个节点
            cur = cur.next;
        }
        //把下一层串联成一个链表之后，让他赋值给cur，
        //后续继续循环，直到cur为空为止
        cur = dummy.next;
    }
    return root;
}

    public static void main(String[] args){
        Integer[] tree = new Integer[]{1,2,3,4,5,null,7};
        CreateTree ct = new CreateTree();
        TreeNode root = ct.arrayToTreeNode(tree);
        //new LeetCode117().connect(root);
    }
}
