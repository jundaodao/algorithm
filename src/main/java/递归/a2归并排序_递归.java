package 递归;

import java.util.Arrays;

/**
 * @Description 递归排序：
 * 一个数组折一半，先让左边排好序，再让右边排好序，两个一组合
 * 哇塞，这不就是递归吗？
 * @Author jjk
 * @Date 2022/6/1 8:49 PM
 */
public class a2归并排序_递归 {

    // todo 对l到r长度的数据进行排序
    public static void process(int[] arr, int l, int r) {
        // todo 只有一个元素不用排序
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);// 获取一个中间值
        process(arr, l, mid); //左边排序
        process(arr, mid + 1, r);//右边排序
        //左右组合在一起变有序
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        // 申请一个临时空间
        int[] tmp = new int[r - l + 1]; //大小： r到l的距离+1
        int   i   = 0;       //临时空间的指针1下标
        int   p1  = l;       //指针2 从最左边开始
        int   p2  = mid + 1; //指针 3，从中间开始
        // 左右都不越界的时候
        // todo 左边最大只能到 mid, 右边最大只能到 r
        while (p1 <= mid && p2 <= r) {
            // todo 谁小就把谁放临时空间, 并且指针+1
            tmp[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        // todo 左边先结束了，把右边的剩下的拷贝过去就行
        while (p2 <= r) {
            tmp[i++] = arr[p2++];
        }
        // todo 右边先结束了，把左边剩下的拷贝临时空间就行
        while (p1 <= mid) {
            tmp[i++] = arr[p1++];
        }
        // todo 把临时空间的拷贝到 arr 里面
        for (int j = 0; j < tmp.length; j++) {
            arr[l + j] = tmp[j];
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 5, 100, 60};
        process(arr, 0, arr.length - 1);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

}
