package fish.dp;
// 递归乘法

// 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些
// B+(A-1)*B 就这样转为多步加法？
// 因为是递归的关系，递归越少，应该走哪条路 A>B 就A*(B-1)
public class Inter0805 {
    public int multiply(int A, int B) {
        // 加减位移
        if (A == 0 || B == 0) {
            return 0;
        }
        if (A > B) {
            return A + multiply(A, B - 1);
        } else {
            return B + multiply(A - 1, B);
        }
    }
    
    // 除法分治：除以2可以位运算实现
    // A是偶数,则A*B=(A/2)*B
    // A是奇数，则A*B=A+(A-1)*B
    // 返回条件：A==1 返回B

    public int multiply02(int A, int B) {
        if (A == 1) {
            return B;
        }
        if (B == 1) {
            return A;
        }
        if (A > B) {
            if ((B & 1) == 1) {
                // 奇数
                return A+multiply(A, B - 1);
            } else {
                int C = multiply(A, B >> 1);
                return C + C;
                // 右移1位即乘2
            } 
        } else {
            // A更小,则A/2或A-1 -- 减少递归次数
            if ((A & 1) == 1) {
                // 奇数
                return B + multiply(A - 1, B);
            } else {
                int C = multiply(A >> 1, B);
                return C + C;
                // 右移1位即乘2
            }
        }
        
        // 若不管AB大小，因为logN差别不大 可以 multiply(A,B>>1)+multiply(A,B>>1)+C
        // 偶数则C=0 奇数C=A
        // 代码简单 
    }
}
