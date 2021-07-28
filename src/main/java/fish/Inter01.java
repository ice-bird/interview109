package fish;
// 面试题 01.01. 判定字符是否唯一

// 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。

    // 所以我期望面试者不要急于解答，我希望他先问我问题：

        // 字符串的字符范围，如果我告诉他，26个小写英文字母，那可能一开头直接判断如果字符长度>26, 直接返回False，做到这一点的，80分
        // 如果我告诉他ascii字符集，然后他的代码里有边界检查，并且针对不同的范围有不同的侧重点，比如说ascii字符集，那也就是128个可能性，16个字节的位运算比较好
        // 如果我告诉他是unicode，没有字符范围，老老实实排序再判断是比较符合我对工程师的要求的，因为算法性能稳定，没有额外资源要求，一眼看出没什么不可预见的风险，100分。
        // 就是说，有些东西，没想到或者一时没想到根本不是问题，日常工作中稍微提示一下即可，但是缜密的思维对于程序员来说更重要。
public class Inter01 {

    public boolean isUnique(String astr) {
        // 相同问题：hash  只有字母？ int[26] 遍历1遍
        // 想到剑指的：n长度只有0 - n-2 必有一个重复，O(1)空间找出

        // 要求：不使用额外空间- -

        // 位运算是什么含义？
        // 在工程中重要的点：边界检查，空指针检查(==null)  校验参数合法性
        // 位操作：用一比特代表一个位置 如26个字母，4字节：0000 0000 表示abcd efgh 字符有无
        // 如何找到这一位？0001  0010 0100 1000 先产生这些数，然后异或 0001 左移(?-'a')位
        // 第一步检验satr是否有效
        if (astr == null) {
            return true;
        }
        int mark = 0;
        // 异或 
        for (int i = 0; i < astr.length(); i++) {
            // 拆分开可读性更高
            int bit_move = astr.charAt(i) - 'a';

            // mark & (1 << bit_move);
            // 111101101这样的才是符合的
            // !=0 可以省略，因为只要不等于0，就是true
            if ((mark & (1 << bit_move)) != 0) {
                // 0110  
                // 0100 结果010 表名有重复的
                // 1000 结果才是0（不重复就是这一位必须是0，新来的1 其余0 结果为0
                return false;
            } else {
                // 如果不重复，则或运算，表示含义此符号
                mark = mark | (1 << bit_move);
            }
        }
        return true;

    }
    // 如果是ASCII码则需要128位
}
