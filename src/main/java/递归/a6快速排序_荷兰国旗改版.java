package 递归;

import java.util.Arrays;

/**
 * 快排思路：
 * 一个数组先切成 2 块，就是一个荷兰国旗问题，保证大的方向是有顺序的
 * 然后在局部再切 2 块，这时候边界就需要定义一下，左右边界就是去除相等的元素的边界，继续递归
 * 整体排序简化为若干个荷兰国旗问题，从大的方向有序，子问题再有序
 */
public class a6快速排序_荷兰国旗改版 {

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            // 首先随机取一个数「随机取一个数跟末尾交换」
            // 这么做从概率学上说可以保证 O(nlogn)的时间复杂度，可以排除正好正序的时候，O(n^2)的可能性
            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
            // todo 国旗问题，获取左右边界在数组
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0]);
            quickSort(arr, p[1] + 1, r);
        }
    }

    // 返回数组的左右边界，国旗的改版, 也就是单次国旗问题
    // 默认以 r做划分，arr[r]-> p   <p   =p   >p
    private static int[] partition(int[] arr, int l, int r) {
        int less = l - 1; //左边界
        int more = r; //右边界
        // l作为开始的位置
        while (l < more) {
            // 左边小于arr[r]=m基准值
            if (arr[l] < arr[r]) {
                //交换位置，左边界+1，l+1
                swap(arr, l++, ++less);
            } else if (arr[l] > arr[r]) {
                //交换位置，右边界-1，l不变
                swap(arr, l, --more);
            } else {
                // 前进1步
                l++;
            }
        }
        swap(arr, more, r);
        return new int[]{less + 1, more};
    }

    public static void swap(int[] arr, int i, int j) {
        int swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, 5, 1, 6, 8, 10, 5, 1, 3, -1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("快排结果：" + Arrays.toString(arr));
    }

}
