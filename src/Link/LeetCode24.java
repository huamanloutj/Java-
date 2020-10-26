package Link;
/*
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class LeetCode24 {
    public ListNode swapPairs(ListNode head) {
//        if(head == null || head.next == null) return head;
//        ListNode before = head;
//        ListNode current = before.next;
//        ListNode dummy = current;
//        ListNode beforeBefore = new ListNode(-1);
//        beforeBefore.next = before;
//        while (current != null ){
//            beforeBefore.next = current;
//            before.next = current.next;
//            current.next = before;
//            beforeBefore = before;
//            // before = before.next;
//            // current = before.next;
//            if ( before.next != null ){
//                //System.out.println(before.val);
//                before = before.next;
//                current = before.next;
//            }
//            else{
//                before = null;
//                current = null;
//            }
//
//        }
//
//        return dummy;

    //递归解法
    // If the list has no node or has only one node left.
    if ((head == null) || (head.next == null)) {
        return head;
    }

    // Nodes to be swapped
    ListNode firstNode = head;
    ListNode secondNode = head.next;

    // Swapping
    firstNode.next  = swapPairs(secondNode.next);
    secondNode.next = firstNode;

    // Now the head is the second node
    return secondNode;


    }
}
