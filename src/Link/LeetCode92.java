package Link;

import jdk.nashorn.internal.objects.NativeUint8Array;

import java.util.List;
/*链表翻转困难*/
public class LeetCode92 {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3) ;
        head.next.next.next = new ListNode(4) ;
        head.next.next.next.next = new ListNode(5) ;

        ListNode res = new LeetCode92().reverseBetween(head,1,2);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }

    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null ) return null;
        if (head.next == null ) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode a = dummy;
        int k = 1;
        while ( k < m) {
            a = a.next;
            k ++;
        }
        //System.out.print(a.val);
        ListNode b = a.next;
        ListNode c ;
        //核心代码
        while (m < n){
            c = b.next;
            b.next = c.next;
            c.next = a.next;
            a.next = c;
            m ++;
        }
        /*遍历不要丢失头节点,这个过程头节点是变的，如果不涉及头节点的话可以用上述算法*/
        /*因为要处理head的问题多加一个节点可以很方便的找到head，*/
        return dummy.next;

    }
}
