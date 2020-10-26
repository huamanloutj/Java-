package Link;
/*链表翻转*/
public class LeetCode25 {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3) ;
        head.next.next.next = new ListNode(4) ;
        head.next.next.next.next = new ListNode(5) ;

        //ListNode res = new LeetCode25().reverseMN(head,2);
        ListNode res = new LeetCode25().reverseKGroup(head,3);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }

    }

    /*链表的头结点非常重要,要记得传入*/
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
        //尽量不要用传入的头结点
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
    public ListNode reverseKGroup(ListNode head, int k) {
        int start = 1,end = start + k - 1;
       /* ListNode dummy = new ListNode(-1);
        dummy.next = head;*/
        ListNode pos = head;
        int nodeNumbers = 0;
        while (head != null){
            nodeNumbers ++;
            head = head.next;
        }
        /*nodeNumbers意味着什么*/
        while (nodeNumbers - start + 1 >= k){
            pos = reverseBetween(pos,start ,end);
            start = end + 1;
            end   = start + k - 1;
        }
        return pos;
    }


}
