package fish.list;
// 面试宝典0208：判断是否有环路,返回其开环节点（把环去掉）

import java.util.HashSet;

public class Inter0208 {
    // 方法1：用HashMap存已遍历的节点
    public ListNode deleteCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (set.contains(cur)) {
                return cur;
            } else {
                set.add(cur);
            }
            cur = cur.next;
        }
        return null; // 如果没有则返回null
    }
    // 时空复杂度o(N)

    // 方法2：快慢指针
    // 快2步，慢1步
    public ListNode detectCycle01(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
