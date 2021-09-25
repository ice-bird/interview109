package fish.list;

import java.util.ArrayList;
import java.util.List;

// 面试题 02.06. 回文链表
// 编写一个函数，检查输入的链表是否是回文的。
public class Inter0206 {
    public boolean isPalindrome(ListNode head) {
        // 思路1：遍历存入list，然后首尾比较
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
            // System.out.println();
        }
        // 此时right就是尾部 
        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            if (list.get(i).equals(list.get(j))) {
                // 注意这里：Integer的比较要用equals, 用！=则（-129 !=-129 ，只要-127-127才缓存了，比较数值）
                return false;
            }
        }
        return true;
    }
    
    // 思路2：回文与栈结构 - - 入栈，然后出栈比较链表头部（出栈就是反的顺序）


    // 思路3：我们的目标是要倒序地遍历出来 - - DFS 就是这样的递归方法
    // dfs基本框架，然后，我们要记录下与当前cur比较的节点
    ListNode front;

    public boolean isPalindrome2(ListNode head) {
        this.front = head;
        return dfs(head);
    }

    boolean dfs(ListNode cur) {
        if (cur == null) {
            return true;
        }
        boolean res1 = dfs(cur.next);
        // System.out.println(cur.val);
        boolean res2 = cur.val == front.val;
        front = front.next;
        // front是全局的，访问到val时，则比较数值是否相等，再next

        return res1 && res2;
    }
    // 内存消耗反而更多，因为需要O(N)递归栈，递归开销较大

    // 方法3：快慢指针：找到中点，翻转，比较
    // 步骤1：遍历一遍，记下长度，根据长度到达前半部分的尾部（或者快指针走2步，慢指针走1步，则快指针到尾部时慢指针到len/2位置

    // 步骤2：链表反转：temp=cur.next; cur.next = pre;pre = cur ,cur = temp; 

    // 依次比较判断

    // 再反转链表

    // 把反转链表写为一个方法，方便理解与调用



}

    