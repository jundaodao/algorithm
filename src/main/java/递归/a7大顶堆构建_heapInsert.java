package 递归;

import java.util.Arrays;

/**
 * 大顶堆：父结点永远比子节点大「注意子节点此时不一定有顺序」
 * 小顶堆：父几点永远比子节点小「同上」
 * <p>
 * 数据存放在数组中，通过下标来模拟完全二叉树，因为如果成连续的时候，模拟完全二叉树就会有一个规律
 * 1、左孩子下标= 2*i+1
 * 2、右孩子下标= 2*i+2
 * 3、父亲的下标= i-1/2
 * <p>
 * 物理存储在数组
 * 逻辑概念在完全二叉树
 */
public class a7大顶堆构建_heapInsert {
    /**
     * 思路：
     * arr 是需要构建大顶堆的数组
     * index 是要构建数字的下标
     * <p>
     * 如果子节点比父节点大「判断」，就杀父，自己做「交换」，一直向上，直到遇阻「循环」;
     * 一直往上走操作就是 「heapInsert」
     * 调用这个方法一次，index及以前的数就是个大顶堆
     * 可以自己想象来一个数「index」我构建一次,直到构建完~
     */
    public static void heapInsert(int[] arr, int index) {
        //todo 子节点比父结点值大，就交换位置，然后继续循环
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2); //交换父子位置
            index = (index - 1) / 2;
        }
    }

    private static void swap(int[] heap, int father, int child) {
        int tmp = heap[father];
        heap[father] = heap[child];
        heap[child] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 8, 6, 9, 7, 10, 2, 4};
        heapInsert(arr, 0);
        heapInsert(arr, 1);
        heapInsert(arr, 2);
        heapInsert(arr, 3);
        heapInsert(arr, 4);
        heapInsert(arr, 5);
        heapInsert(arr, 6);
        heapInsert(arr, 7);
        heapInsert(arr, 8);
        heapInsert(arr, 9);

        System.out.println("大顶堆heapInsert：" + Arrays.toString(arr));
    }

}
