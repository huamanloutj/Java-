package Link;

import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import java.util.List;
import java.util.Scanner;

public class CreateLink {
    public ListNode headInsert(){
        ListNode head = new ListNode(-1);
        ListNode dummy = head;
        Scanner in = new Scanner(System.in);
        int value = in.nextInt();
        while(value != -1 ){
            ListNode node = new ListNode(value);
            head.next = node;
            head = head.next;
            node.next = null;
            value = in.nextInt();
        }
        printLink(dummy.next);
        return dummy.next;
    }
    public ListNode tailInsert(){
        ListNode dummy = new ListNode(-1);
        dummy.next = null;

        Scanner in = new Scanner(System.in);
        int value = in.nextInt();
        while(value != -1){
            ListNode node = new ListNode(value);
            node.next = dummy.next;
            dummy.next = node;
            value = in.nextInt();
        }
        printLink(dummy.next);
        return dummy.next;
    }
    public void printLink(ListNode head){
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static void main(String[] args){
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(4);
//        head.next.next = new ListNode(3) ;
//        head.next.next.next = new ListNode(5) ;
//        head.next.next.next.next = new ListNode(2) ;
//        head.next.next.next.next.next  = new ListNode(2);
//        ListNode before = new ListNode(-1);
//        if (head.val == 1) System.out.println();
        new CreateLink().headInsert();

    }
}
