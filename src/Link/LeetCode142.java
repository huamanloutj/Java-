package Link;

import java.util.*;

/*
给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

说明：不允许修改给定的链表。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
示例 1：

输入：head = [3,2,0,-4], pos = 1
输出：tail connects to node index 1
解释：链表中有一个环，其尾部连接到第二个节点。


示例 2：

输入：head = [1,2], pos = 0
输出：tail connects to node index 0
解释：链表中有一个环，其尾部连接到第一个节点。


示例 3：

输入：head = [1], pos = -1
输出：no cycle
解释：链表中没有环。


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode142 {
    public ListNode detectCycle(ListNode head) {
        /*最好分离出来head，防止操作失误*/
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if (set.contains(head))
                return head;
            else {
                set.add(head);
                head = head.next;
            }
        }
        return null;
    }
    public ListNode detectCycle(ListNode head,int flag){
        Queue<Integer> res = new LinkedList<>();
        List<Integer> temp = new ArrayList<>();
        int[] nums = new int[3];
        Collections.reverse(temp);


        return head;
    }
}
