package 递归;

/**
 * * 1、堆结构就是用数组实现的完全二叉树
 * * 2、完全二叉树中如果每棵子数的最大值都在顶部，就是大顶堆
 * * 3、完全二叉树中如果每颗子树的最小值都在顶部，就是小顶堆
 * * 4、堆结构的 heapinsert 和 heapify操作
 * * 5、堆结构的增大和减小
 * * 6、优先队列结构就是用，就是堆结构
 */

import java.util.Arrays;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * 题目：
 * 已知一个几乎有序的数组，几乎有序是指，如果把数组排好序的话，每个元素移动距离不超过 K,并且 k 相对数组长度来讲比较小，
 * 请选择一种合适的排序算法，进行排序
 */

/**
 * 思路：
 * 先将数组(0，k）下标的数组构建小顶堆,然后(1,k+1),然后(2,k+2) 依次构建小顶堆，这样数组中的顺序就成从小到大依次有序了。
 * */
public class a10堆结构 {
    public static void myHeap(int[] arr, int k) {
        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();

        for (int j = 0; j < arr.length; j++) {
            queue.add(arr[j]);
        }
        int i = 0;
        while (!queue.isEmpty()) {
            arr[i++] = queue.poll();
        }
        System.out.println("堆排序：" + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 8, 9, 10, 20, 7};
        myHeap(arr, 5);
    }
}
