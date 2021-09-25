package fish.array;
// 面试宝典03 ：将字符串的空格 替换为 %20
// URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）

public class Inter03 {
    public String replaceSpace(String s, int lenght) {
        // char[] sChar = s.toCharArray();
        // 一个字符变两个，数组不可变 可使用ArrayList<>()
        // 或者先遍历一遍看有多少空格，则知道最终的长度
        int countSpace = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                countSpace++;
            }
        }
        char[] sChar = new char[s.length() + countSpace * 2];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sChar[index++] = '%';
                sChar[index++] = '2';
                sChar[index++] = '0';
            } else {
                sChar[index++] = c;
            }
        }
        return new String(sChar);

    }
    // 题目中已经假设好了长度足够，无语了,就当做是char，然后步新增新的空间
    // 双指针法：从末尾开始处理
    // 这个题目就极其恶心，根本不知道你的输入规范，最后字符算不算
    // 预留的空间如果多了，又要删掉前面的空格
    // 全空格如何处理 " "  要用到length这个参数

    public char[] replaceSpace(char[] s, int length) {
        // char[] 已经预留好了扩充的空间
        int i = length - 1; //这就是需要转换的起点
        // 确定终点（因为可能预留过长）
        // 那和
        int spaceNum = 0;
        for (int k = 0; k < length; k++) {
            if (s[k] == ' ') {
                spaceNum++;
            }
        }
        // 注意while一定要索引检查
        for (int j = length + spaceNum * 2 - 1; i >= 0;) {
            if (s[i] != ' ') {
                s[j] = s[i];
                j--;
                i--;
            } else {
                s[j--] = '0';
                s[j--] = '2';
                s[j--] = '%';
                i--;
            }
        }
        return s;

    }
}

// 11ms 45.5MB  太TM傻逼了，最后subString或者子数组切割不还是用了多余空间
// 还不如解法1呢。这算哪门子原地修改
class Solution {
    public String replaceSpaces(String S, int length) {
        char[] s= S.toCharArray();
        int i = length - 1; //这就是需要转换的起点
        // 确定终点（因为可能预留过长）
        // 那和
        int spaceNum = 0;
        for (int k = 0; k < length; k++) {
            if (s[k] == ' ') {
                spaceNum++;
            }
        }
        // 注意while一定要索引检查
        int resLength = length+spaceNum*2;
        for (int j = resLength-1; i >= 0;) {
            if (s[i] != ' ') {
                s[j] = s[i];
                j--;
                i--;
            } else {
                s[j--] = '0';
                s[j--] = '2';
                s[j--] = '%';
                i--;
            }
        }
        // 这里还要截取数组
        String s1 =  new String(s);
        return s1.substring(0,resLength);
    }
}
