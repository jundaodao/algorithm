package 递归;

/**
 * @Description 什么是小和问题：
 * 例子
 * [1,3,4,2,5]
 * 1左边比1小的数：没有
 * 3左边比3小的数：1
 * 4左边比4小的数：1,3
 * 2左边比2小的数：1
 * 5左边比5小的数：1,3,4,2
 * 所以小和为1+1+3+1+1+3+4+2=16
 * <p>
 * 思路转换
 * [1,3,4,2,5]
 * 也可以理解为
 * 1 右边有4个数比他大，1*4
 * 3 右边有 2 个数比他大 3*2
 * 4 右边有 1 个数比他大 4*1
 * 2 右边有 1 个数比他大 2*1
 * 5 右边没有比他大的了
 * 1*4+3*2+4*1+2*1 =4+6+4+2=16
 * <p>
 * 思路转换
 * [1,3,4,2,5]
 * 也可以理解为
 * 1 右边有4个数比他大，1*4
 * 3 右边有 2 个数比他大 3*2
 * 4 右边有 1 个数比他大 4*1
 * 2 右边有 1 个数比他大 2*1
 * 5 右边没有比他大的了
 * 1*4+3*2+4*1+2*1 =4+6+4+2=16
 * <p>
 * 思路转换
 * [1,3,4,2,5]
 * 也可以理解为
 * 1 右边有4个数比他大，1*4
 * 3 右边有 2 个数比他大 3*2
 * 4 右边有 1 个数比他大 4*1
 * 2 右边有 1 个数比他大 2*1
 * 5 右边没有比他大的了
 * 1*4+3*2+4*1+2*1 =4+6+4+2=16
 * <p>
 * 思路转换
 * [1,3,4,2,5]
 * 也可以理解为
 * 1 右边有4个数比他大，1*4
 * 3 右边有 2 个数比他大 3*2
 * 4 右边有 1 个数比他大 4*1
 * 2 右边有 1 个数比他大 2*1
 * 5 右边没有比他大的了
 * 1*4+3*2+4*1+2*1 =4+6+4+2=16
 * <p>
 * 思路转换
 * [1,3,4,2,5]
 * 也可以理解为
 * 1 右边有4个数比他大，1*4
 * 3 右边有 2 个数比他大 3*2
 * 4 右边有 1 个数比他大 4*1
 * 2 右边有 1 个数比他大 2*1
 * 5 右边没有比他大的了
 * 1*4+3*2+4*1+2*1 =4+6+4+2=16
 * <p>
 * 思路转换
 * [1,3,4,2,5]
 * 也可以理解为
 * 1 右边有4个数比他大，1*4
 * 3 右边有 2 个数比他大 3*2
 * 4 右边有 1 个数比他大 4*1
 * 2 右边有 1 个数比他大 2*1
 * 5 右边没有比他大的了
 * 1*4+3*2+4*1+2*1 =4+6+4+2=16
 * <p>
 * 思路转换
 * [1,3,4,2,5]
 * 也可以理解为
 * 1 右边有4个数比他大，1*4
 * 3 右边有 2 个数比他大 3*2
 * 4 右边有 1 个数比他大 4*1
 * 2 右边有 1 个数比他大 2*1
 * 5 右边没有比他大的了
 * 1*4+3*2+4*1+2*1 =4+6+4+2=16
 * <p>
 * 思路转换
 * [1,3,4,2,5]
 * 也可以理解为
 * 1 右边有4个数比他大，1*4
 * 3 右边有 2 个数比他大 3*2
 * 4 右边有 1 个数比他大 4*1
 * 2 右边有 1 个数比他大 2*1
 * 5 右边没有比他大的了
 * 1*4+3*2+4*1+2*1 =4+6+4+2=16
 * <p>
 * 思路转换
 * [1,3,4,2,5]
 * 也可以理解为
 * 1 右边有4个数比他大，1*4
 * 3 右边有 2 个数比他大 3*2
 * 4 右边有 1 个数比他大 4*1
 * 2 右边有 1 个数比他大 2*1
 * 5 右边没有比他大的了
 * 1*4+3*2+4*1+2*1 =4+6+4+2=16
 * <p>
 * 思路转换
 * [1,3,4,2,5]
 * 也可以理解为
 * 1 右边有4个数比他大，1*4
 * 3 右边有 2 个数比他大 3*2
 * 4 右边有 1 个数比他大 4*1
 * 2 右边有 1 个数比他大 2*1
 * 5 右边没有比他大的了
 * 1*4+3*2+4*1+2*1 =4+6+4+2=16
 * <p>
 * 思路转换
 * [1,3,4,2,5]
 * 也可以理解为
 * 1 右边有4个数比他大，1*4
 * 3 右边有 2 个数比他大 3*2
 * 4 右边有 1 个数比他大 4*1
 * 2 右边有 1 个数比他大 2*1
 * 5 右边没有比他大的了
 * 1*4+3*2+4*1+2*1 =4+6+4+2=16
 * <p>
 * 思路转换
 * [1,3,4,2,5]
 * 也可以理解为
 * 1 右边有4个数比他大，1*4
 * 3 右边有 2 个数比他大 3*2
 * 4 右边有 1 个数比他大 4*1
 * 2 右边有 1 个数比他大 2*1
 * 5 右边没有比他大的了
 * 1*4+3*2+4*1+2*1 =4+6+4+2=16
 * <p>
 * 思路转换
 * [1,3,4,2,5]
 * 也可以理解为
 * 1 右边有4个数比他大，1*4
 * 3 右边有 2 个数比他大 3*2
 * 4 右边有 1 个数比他大 4*1
 * 2 右边有 1 个数比他大 2*1
 * 5 右边没有比他大的了
 * 1*4+3*2+4*1+2*1 =4+6+4+2=16
 */

/**
 * 思路转换
 * [1,3,4,2,5]
 * 也可以理解为
 * 1 右边有4个数比他大，1*4
 * 3 右边有 2 个数比他大 3*2
 * 4 右边有 1 个数比他大 4*1
 * 2 右边有 1 个数比他大 2*1
 * 5 右边没有比他大的了
 * 1*4+3*2+4*1+2*1 =4+6+4+2=16
 *
 * */

/**
 * 暴力解法 O(n^2)
 * 递归解法：归并排序稍微改造一下就可以求小和问题
 *
 * **/
public class a3小和问题_递归 {

    public static int process(int[] arr, int l, int r) {
        // 一个数不会产生
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        // 左边小和 + 右边小和+ 他俩汇总的小和
        return process(arr, l, mid) +
                process(arr, mid + 1, r) +
                merge(arr, l, mid, r);
    }

    private static int merge(int[] arr, int l, int mid, int r) {
        int[] tmp    = new int[r - l + 1];
        int   i      = 0; //tmp 的小标
        int   p1     = l;
        int   p2     = mid + 1;
        int   result = 0; //用于临时小和
        // todo 都没有越界
        while (p1 <= mid && p2 <= r) {
            // todo 如果p1 的值小于 p2 的值，那么就产生小和，个数是 r-p2+1 ,否则小和是 0
            result += arr[p1] < arr[p2] ? arr[p1] * (r - p2 +1) : 0;
            tmp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++]; //排序
        }
        // todo 左边先结束,就不会产生小和
        while (p2 <= r) {
            tmp[i++] = arr[p2++];
        }
        // todo 右边先结束，也不会产生小和
        while (p1 <= mid) {
            tmp[i++] = arr[p1++];
        }
        for (int j = 0; j < tmp.length; j++) {
            arr[l + j] = tmp[j];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr    = {1, 3, 4, 2, 5};
        int   result = process(arr, 0, arr.length - 1);
        System.out.println("该数组小和：" + result);
    }
}
