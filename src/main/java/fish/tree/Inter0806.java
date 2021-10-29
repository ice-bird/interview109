package fish.tree;

import java.util.List;

// 面试题 08.06. 汉诺塔问题
// 3个穿孔圆盘，大盘在下，小盘在上，从A移动至C
public class Inter0806 {

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        // 采用栈的思路
        // 每一层都是相同的操作
        // 1-C 2-B  1-B 这样就是3 12 0 然后把3-C 这样就移动好了第一步，第二步是把12的最底层2 放在C上（3不需要动了）
        // 动态规划 - - 递归 分解为小问题

        // f(n)=f(n-1)-->B n-->C f(n-1)-->C
        int N = A.size();
        move(N, A, B, C);

    }
    // move函数：A柱 经过B 移动到C
    public void move(int N,List<Integer> A, List<Integer> B, List<Integer> C) {
        if (N == 1) {
            C.add(0, A.remove(0));
            return;
        }
        move(N - 1, A, C, B);
        // 这一步就是把A的最大一个，搬到C的第一个
        // 注意此处是用list实现栈，add(index,value)的含义是插入
        C.add(0, A.remove(0));
        move(N - 1, B, A, C);
    }
}
