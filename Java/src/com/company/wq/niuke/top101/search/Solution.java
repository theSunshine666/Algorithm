package com.company.wq.niuke.top101.search;

public class Solution {

    public static void main(String[] args) {

    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 测试用例1：[-1,0,3,4,6,10,13,14]
     * 
     * @param nums int整型一维数组 
     * @param target int整型 
     * @return int整型
     */
    public int search (int[] nums, int target) {
        // write code here
        //定义左右端点
        int left = 0, right = nums.length - 1;
        //左右端点未相遇就进入循环
        while (left <= right){
            //下标折半
            int mid = (left + right) / 2;
            if (nums[mid] == target){
                //目标值与中间值相等直接返回下标mid
                return mid;
            }else if (nums[mid] > target){
                //目标值比中间值小，说明在左半边区域
                right = mid - 1;
            }else {
                //目标值比中间值大，说明在右半边区域
                left = mid + 1;
            }
        }
        //未找到输出-1
        return -1;
    }
}