package fish.list;

// 0207 链表相交

// 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
public class Inter0207 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 思路1：貌似做过这题，快慢指针 - -只要以相同速度前行，就一定会遇上
        // hash表貌似也可以判断是否相同
        ListNode curA = headA;
        ListNode curB = headB;
        //要么相遇即节点相等，要么均为next即为空。（循环次数是长度的最小公倍数，就会同时为空)
        while (curA != curB) {
            // 相同速度往前走，走完自己的路则换路。
            // 当走完各自的路时，再“跳”至对方的路上。（起点平齐速度相同，终点即为相遇点）

            // 沿着路径走A+B路程，必定会在第一个点相遇
            curA = (curA == null ? headB : curA.next);
            curB = (curB == null ? headA : curB.next);
        }
        return curA;
    }
    
}
