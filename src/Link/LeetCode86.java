package Link;
/*
分割链表
给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。

你应当保留两个分区中每个节点的初始相对位置。

 

示例:

输入: head = 1->4->3->2->5->2, x = 3
输出: 1->2->2->4->3->5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/partition-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode86 {
    public ListNode partition(ListNode head, int x) {
        //不开辟额外节点
        // if (head == null) return null;
        // if (head.next == null ) return head;
        // ListNode before = new ListNode(-1);
        // if(head.val >= x) {
        //     before.next = head;
        //     ListNode dummy = before;
        //     ListNode pre = before;
        //     ListNode current = pre.next;
        //     while(current != null){
        //         if (current.val < x){
        //             pre.next = current.next;
        //             current.next = before.next;
        //             before.next = current;
        //             current = pre.next;
        //             before = before.next;
        //         }
        //         else{
        //             pre = pre.next;
        //             current = pre.next;
        //         }
        //     }
        //     return dummy.next;
        // }
        // else{
        //     before = head;
        //     while (before.next != null && before.next.val < x ){
        //         before = before.next;
        //     }
        //     //System.out.println(before.val);
        //     ListNode pre = before;
        //     ListNode dummy = before;
        //     ListNode current = pre.next;
        //     while(current != null){
        //         if (current.val < x){
        //             pre.next = current.next;
        //             current.next = before.next;
        //             before.next = current;
        //             current = pre.next;
        //             before = before.next;
        //         }
        //         else{
        //             pre = pre.next;
        //             current = pre.next;
        //         }
        //     }
        //     return head;
        // }
        //使用心得链表来拆分链接
        ListNode left = new ListNode(-1);
        ListNode right = new ListNode(-1);
        ListNode current = head;
        ListNode lHead = left;
        ListNode rhead = right;
        while (current != null){
            if (current.val < x){
                ListNode node = new ListNode(current.val);
                left.next = node;
                left = left.next;

            }
            else{
                ListNode node = new ListNode(current.val);
                right.next = node;
                right = right.next;
                node.next = null;

            }
            current = current.next;
        }
        left.next = rhead.next;
        return lHead.next;
    }
}
