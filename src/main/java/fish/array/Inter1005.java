package fish.array;
// 稀疏数组搜索：从String[]中找 单词  重点：排好序！！！ - -肯定二分查找法呀
public class Inter1005 {
    public int findString(String[] words, String s) {
        // 二分基本模板
        int left = 0, right = words.length - 1;
        // e
        while (left <= right) {
            // while()
            // 基本模板+ 如果是空，就直接移位
            while (left <= right && words[left].equals("")) {
                left++;
            }
            while (left <= right && words[right].equals("")) {
                right--;    
            }
            int mid = left + (right - left) / 2;
            // 此处也可以判断mid 是不是为"",然后mid--或++都可以，注意条件
            // 注意空字符串和有内容的比较，必定>(返回长度差值),因此，必须让mid有内容
            while (mid <= right && words[mid].equals("")) {
                mid++;
            }
            
            if (words[mid].compareTo(s) == 0) {
                return mid;
            }
            if (words[mid].compareTo(s) > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 无则-1
        return -1;
    }
    public static void main(String[] args) {
        System.out.println("abc".compareTo(""));
    }
}
