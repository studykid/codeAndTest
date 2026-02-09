package com.example;

public class RemoveDuplicates {

    /**
     * 给定一个有序数组 nums ，原地 去掉重复元素，使每个元素只出现一次 ，返回删除后数组的新长度 k 。
     * 原地修改数组，不使用额外空间。
     *
     * @param nums 有序数组
     * @return 删除重复元素后的新长度
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // 使用双指针：i 指向当前已处理好的非重复序列的末尾
        int i = 0;
        
        for (int j = 1; j < nums.length; j++) {
            // 如果发现新元素与当前末尾元素不同，则将其加入到非重复序列中
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        
        // 长度为索引 + 1
        return i + 1;
    }
}
