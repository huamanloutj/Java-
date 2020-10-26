package Link;
/*
 三种方法可以使用
 1、使用数组的方法，存储链表中的节点，然后对数组下标访问即可
 通用的方法可以使用，记录下标和数组的位置
 2、两次遍历的方法，第一次找到链表的数量，第二次找到链表的中间节点
 3、快慢指针法，一个节点走一步，另外一个节点走两步那么就可以
 */
public class LeetCode876 {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        //为什么要fast.next因为fast.next可能为空，那么就会出现空指针异常
        //一种情况是[1,2,3,4,5],那么此时fast = 5时，这时候循环没有结束，就应该进入循环，
        //可是fast.next为空无法再next
        while (fast != null && fast.next != null){

            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
