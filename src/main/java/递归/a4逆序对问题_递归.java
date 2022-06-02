package 递归;

/**
 * @Description 什么叫逆序对
 * 只要左边的数比右边的数大，就是一个逆序对
 * 例如
 * [1,3,4,2,5]
 * 对于 1 来讲没有逆序对
 * 对于 3 来讲有一个逆序对 3-2
 * 对于 4 来讲有 1 个逆序对 4-2
 * 对于 2 来讲没有
 * 对于 5 来讲没有
 * 所以结果是 2 个逆序对
 * 这就是递归问题-小和问题的延续
 */

/**
 * 思路还是归并排序的时候，统计逆序对个数；
 * 这个没有跑通，需要再研究下~，都是 a4 前面的变形
 */
public class a4逆序对问题_递归 {

    public static int process(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return process(arr, l, mid) + process(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    private static int merge(int[] arr, int l, int mid, int r) {
        //todo 外排序
        int[] tmp    = new int[r - l + 1];
        int   i      = 0;
        int   p1     = l;
        int   p2     = mid + 1;
        int   result = 0;

        while (p1 <= mid && p2 <= l) {
            if(arr[p1] > arr[p2]){
                System.out.println("====");
            }
            result += arr[p1] > arr[p2] ? (mid-l+1) : 0;
            tmp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++]; //排序
        }
        // 下面不会产生逆序问题
        while (p1 <= mid) {
            tmp[i++] = arr[p1++];
        }
        while (p2 <= r) {
            tmp[i++] = arr[p2++];
        }
        for (int j = 0; j < tmp.length; j++) {
            arr[l + j] = tmp[j];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr    = {1, 3, 4, 2, 5};
        int   result = process(arr, 0, arr.length - 1);
        System.out.println("逆序问题：" + result);

    }

}
