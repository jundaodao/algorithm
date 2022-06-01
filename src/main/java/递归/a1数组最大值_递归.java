package 递归;

/**
 * @Description 普通解法：O(n) 选一个最大的，我们用递归实现一下。
 * @Author jjk
 * @Date 2022/6/1 8:12 PM
 */
public class a1数组最大值_递归 {
    public static void main(String[] args) {
        int[] arr = {10, 20, 5, 100, 60};
        int   max = process(arr, 0, arr.length - 1);
        System.out.println("最大值：" + max);
    }

    // todo 求出左右下边范围内arr的最大值
    public static int process(int[] arr, int l, int r) {
        // todo 当只有一个元素的时候，就返回他本身
        if (l == r) {
            return arr[l];
        }
        // todo 解释这里为什么不 （l+r）/2呢？ 加入 l和 r都很大，加起来就越界了
        // todo l + 他俩距离的一半不就是中间位置吗？左移一位比除法快
        int mid   = l + ((r - l) >> 1);
        // todo 求出左边的最大值
        int left  = process(arr, l, mid);
        // todo 求出右边的最大值
        int right = process(arr, mid + 1, r);
        // todo 返回一个最大值
        return Math.max(left, right);
    }

    /**
     * 延伸：master公式求时间复杂度
     * 如果母问题可以简化成若干个子问题进行解决，就可以套用 master公式求时间复杂度
     * T(N)=a*T(N/b) +O(N^d)
     * a：求解问题的次数
     * b: 子问题中求解的次数
     * O(N^d) ：表示子问题无法解决的其他时间复杂度
     * 上面的例子 T(5) = 2*T(5/2) = O(N*log b^a) = O(5*log2^2) 就是这么多的时间复杂度
     * */

}
