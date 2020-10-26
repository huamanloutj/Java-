package Link;
/*奇偶链表*/
public class LeetCode328 {
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

}
