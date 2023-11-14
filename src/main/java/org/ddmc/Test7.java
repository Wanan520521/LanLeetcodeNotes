package org.ddmc;

import java.util.Arrays;

/**
 * @author Lan
 * @date 2023/11/10
 */
//11.盛水最多的容器
// 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
//
//找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
//返回容器可以储存的最大水量。
//
//说明：你不能倾斜容器
//结论 双指针  永远移动短板指针

public class Test7 {
    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int x = 0, y = height.length - 1;
        int max = Math.min(height[x], height[y]) * (y-x);
        while (true) {
            if (x == y) break;
            if (height[x] < height[y]) {
                x++;
                max = Math.max(max,Math.min(height[x], height[y]) * (height.length - x-1));
            } else {
                y--;
                max = Math.max(max,Math.min(height[x], height[y]) * (y-1));
            }
        }
        return max;
    }
}
