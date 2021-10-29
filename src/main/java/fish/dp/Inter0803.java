package fish.dp;
// 魔术索引
// 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个

public class Inter0803 {
    // 这题目有什么玄机？
    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                return i;
            }
        }
        return -1;

    }
    // 此题的玄机在于：有序 - 因此可以往二分去靠
    // nums[i]>i 则nums[i+1]>i+1 --因为是不重复且有序的 右侧直接排除  --- 第一小问 二分法logN查找到magicIndex
    // 若包含重复元素，则右边依然有可能 nums[i]=i+1 但nums[i+1]=i+1  --- 无法排除
    // 分治写了个寂寞，先左后右，复杂度不还是ON？

    // 因为是有序数组，若 nums[i]!=i , 下标[i,nums[i])区间内将不会产生结果
    // 在此区间内遍历属于无用功，则i可以直接跳到nums[i]位置继续向后遍历
    // i=nums[i]>i? nums[i]:i+1  i在for循环中可变，若nums[1]=6,,则1-5索引肯定大于6，可跳过

}
