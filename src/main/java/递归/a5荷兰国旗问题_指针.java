package 递归;

/**
 * @Description 荷兰国旗问题：
 * 荷兰国旗是三色，给定一个数组，给定数组中的一个数m，在 O(N) 复杂度下，空间复杂度 O(1) 情况下，
 * 数组的左边都比m小，数组的右边都被 m大，数组的中间都是 m，左右两边数可以无须；
 */

import java.util.Arrays;

/***
 * 解题思路：分三种情况
 * arr[i]<m  交换位置，左边界+1，i++；
 * arr[i]>m  arr[i]跟右边界数交换，右边界扩 1，i不变
 * arr[i]=m  i++
 * 这样就把数据分成三部分，左：比 m小，右比 m大，中间是 m
 * */
public class a5荷兰国旗问题_指针 {
    public static void partition(int[] arr, int m) {
        int l       = 0; // todo 定义左边界
        int r       = arr.length - 1; //todo 定义右边界
        int current = 0;  //todo 当前指针
        while (current <= r) {
            // todo 目前值比给定值小
            if (arr[current] < m) {
                // todo 交换当前指针的值和左边界的值，左边界+1,当前下标+1
                swap(arr, current++, l++);
            } else if (arr[current] > m) {
                // todo 交换当前指针的值和右边界的值，右边界-1
                swap(arr, current, r--);
            } else {
                //todo 直接往前
                current++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }

    public static void main(String[] args) {
        int[] arr = {10,2, 5, 1, 6, 8, 10, 5,1,3,-1};
        partition(arr, 5);
        System.out.println(Arrays.toString(arr));
    }

}
