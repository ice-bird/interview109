package fish;
// 面试01.06 字符串压缩
// 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）

public class Inter04 {
    public String compressString(String s) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < s.length();) {
            char c = s.charAt(i);
            // 字符串底层是char[] 实现了randomAccess接口 O(1)复杂度
            int cNum = 1;
            // 注意这里的逻辑，先++i下标移动，判断是否越界，
            // 然后比较是否相等
            // 当最后一个char时，若相等，则cNum++ 
            // 不同的，则不会进入循环
            while (++i < s.length() - 1 && c == s.charAt(i)) {
                cNum++;
            }
            sb.append(c);
            sb.append(cNum);
        }
        String res = new String(sb);
        return res.length() >= s.length() ? s : res;
    }
    
    // 方法2：快慢指针 慢指针指向不同的字母，快指针遇到连续相同则右移
    // 需要计数、且前面处理玩对后续无影响，一般都是双指针思路
    public static void main(String[] args) {
        System.out.println("nihap ");
    }
}
