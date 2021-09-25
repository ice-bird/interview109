package fish;
// 面试题 10.01. 合并排序的数组
// 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。

// 初始化 A 和 B 的元素数量分别为 m 和 n。

public class Inter1001 {
    public void merge(int[] A, int m, int[] B, int n) {
        int i=m-1;
        int j = n - 1;
        int k = A.length-1;
        while (i >= 0 && j >= 0 && k>=0) {
            // 或者这里if(i<0) {A[i]=Long.MIN_VALUE} 用最小的数代替，肯定会进入else分支线
            if (A[i] > B[j]) {
                A[k--] = A[i--];
            } else {
                A[k--] = B[j--];
            }
        }
        while (i >= 0) {
            A[k--] = A[i--];
        }
        while (j >= 0) {
            A[k--] = B[j--];
        }
    }
}
