package 递归;

import java.util.Arrays;

/**
 * 需求：
 * 已经构建好的大顶堆，用户希望将最顶上的数字去掉。
 * <p>
 * 分析：
 * 去掉最顶上的元素，堆肯定会发生变化，我们可以将最顶上的跟最后面的元素做替换，并且 heapSize-1
 * 替换后最顶上的有可能是一个小数，此时就需要往下去比较，这个动作就叫 heapify; 而替换的数就是这一次的最大值；
 * <p>
 * 当前元素的子下标 = 2*i+1 或 2*i+2
 */
public class a8大顶堆构建_heapify {

    // arr:大顶堆数组，index:要替换的数据下标「总是 0，root节点的下标」，heapSize:堆大小「用于控制最后数的位置」
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = 2 * index + 1; //左孩子下标
        //todo 存在 左孩子
        while (left < heapSize) {
            // todo 两个孩子谁值大，就把值大的，把下标给 largest
            int largest = ((left + 1) < heapSize && arr[left + 1] > arr[left]) ?
                    left + 1 : left;
            // todo 两个孩子的最大值与父做比较，返回下标
            largest = arr[largest] > arr[index] ? largest : index;
            if (index == largest) { //todo 这种情况就不用交换位置了
                return;
            }
            swap(arr, index, largest); //交换位置
            index = largest;
            left = 2 * index + 1;  //再往下继续找
        }
    }

    private static void swap(int[] heap, int father, int child) {
        int tmp = heap[father];
        heap[father] = heap[child];
        heap[child] = tmp;
    }

    public static void main(String[] args) {
        int[] arr      = {9, 6, 8, 1, 5, 3};
        int   heapSize = arr.length;
        //todo 最顶上的元素跟后面元素做交换
        swap(arr, 0, arr.length - 1);
        heapify(arr, 0, heapSize - 1);
        System.out.println("heapify 后：" + Arrays.toString(arr));

    }
}
