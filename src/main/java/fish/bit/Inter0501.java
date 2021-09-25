package fish.bit;
// 面试宝典：0501 插入
// 给定两个整型数字 N 与 M，以及表示比特位置的 i 与 j（i <= j，且从 0 位开始计算）。

// 编写一种方法，使 M 对应的二进制数字插入 N 对应的二进制数字的第 i ~ j 位区域，不足之处用 0 补齐。具体插入过程如图所示。
// 已经保证能够放下
public class Inter0501 {

    public int insertBits(int N, int M, int i, int j) {
        // 判断输入合法性 - -能否放下
        if (M >= Math.pow(2, j - i)) {
            System.out.println("Error");
            // 应该用异常处理
        }
        // 第一步:i-j位置为0 使用一个掩码 & 111 0000 11 (不变的1，要修改为0的0)
        // 第二步：M左移i位
        // 相加即可
        
        // 如何高效地生成掩码
        for (int k = i; k <= j; k++) {
            // 1000 - -取反 01111 
            // 与运算，则置为0，低位不变
            int mask = ~(1 << k);
            N = N & mask;

        }
        int m = M << i;
        return N+m;
        
    }
    
    
}
