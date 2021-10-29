package fish.bit;
// 面试题 0508 绘制直线
// 绘制直线。有个单色屏幕存储在一个一维数组中，使得32个连续像素可以存放在一个 int 里。屏幕宽度为w，且w可被32整除（即一个 int 不会分布在两行上），屏幕高度可由数组长度及屏幕宽度推算得出。请实现一个函数，绘制从点(x1, y)到点(x2, y)的水平线。

// 给出数组的长度 length，宽度 w（以比特为单位）、直线开始位置 x1（比特为单位）、直线结束位置 x2（比特为单位）、直线所在行数 y。返回绘制过后的数组

public class Inter0508 {
    public int[] drawLine(int length, int w, int x1, int x2, int y) {
        // w/32 一行   y行
        int[] res = new int[length];
        // 一行col=w/32 修改col*y+0 ---> col*y+col-1
        int col = w / 32;
        int start = col * y + x1 / 32;
        int end = col * y + x2 / 32;

        int offsetS = x1 % 32;
        int offsetE = 31 - x2 % 32;
        if (start == end) {
            int mask = 0xFFFFFFFF;
            // 先右移，再左移
            int a = mask >>> offsetS;
            int b = mask << offsetE;
            // 此mask左移得到需要保留的，右移得到需要保留的
            res[start] = (a & b) | res[start];
            return res;
        }
        for (int k = start + 1; k < end; k++) {
            res[k] = Integer.MAX_VALUE; //中间的全1
        }
        // 前后端移位处理
        int mask = 0xFFFFFFFF;
        // int a = mask >>> (offsetS);
        res[start] = (mask >>> (offsetS)) | res[start];

        // 左移有无符号都是一样的，最高位左移，右边补零，不区分
        int a = mask << offsetE;
        // 前面置1 后面全0，问题在于如果start==end 则比较麻烦
        res[end] = (mask << (offsetE)) | res[end];

        return res;

    }

    public static void main(String[] args) {
        Inter0508 test = new Inter0508();
        int[] a = test.drawLine(1, 32, 30, 31, 0);
        System.out.println(a[0]);
    }
    
    // 算是完成了任务
    // 步骤：找到对应的int 
    // 位运算置1
    public int[] drawLine(int[] screen,int k1,int k2, int x1, int x2) {
        // 应该给定scrern数组，第几个数据，然后是坐标
        // k1 k2 很容易算，略过，一行是w/32个int * y行+ x/32
        for (int i = x1; i < x2; i++) {
            // screen[k1+i/32]就是当前的那个int
            screen[k1 + i / 32] = screen[k1 + i / 32] | (1 << 31 - (i % 32));
            // 这一步是每次循环置一次1，而不是整理置1
            // 每一位都是从右往左 移动，不需要分开是开头还是结尾
            // 31-(i%32) 就是需要往左移的位数

            // 以后应该直觉：置 1 用移位 或的方法
        }
        return screen;

        
    }
}
