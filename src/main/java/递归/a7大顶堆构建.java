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
public class a7大顶堆构建 {
    int[] heap     = new int[10];          //初始化构造一个堆
    int   heapSize = 0;                   //通过 heapSize来区分堆的边界

    /**
     * 思路：先将这个数字放在最后面，heapSize++,然后一直找他的父做比较
     * 如果比父结点大，就杀父，自己做，一直向上，直到遇阻
     */
    public void buildHeap(int num) {
        int father = (heapSize - 1) / 2; //父结点下标
        int child  = heapSize;  //子节点下标
        heap[heapSize++] = num; // 放在最后面
        // 子节点比父结点值大
        while (heap[child] > heap[father]) {
            swap(heap, father, child); //交换父子位置
            child = father; //更新下标
            father = (child - 1) / 2; //更新下标
        }
    }

    private static void swap(int[] heap, int father, int child) {
        int tmp = heap[father];
        heap[father] = heap[child];
        heap[child] = tmp;
    }

    public static void main(String[] args) {
        a7大顶堆构建 topN = new a7大顶堆构建();
        topN.buildHeap(1);
        topN.buildHeap(5);
        topN.buildHeap(3);
        topN.buildHeap(8);
        topN.buildHeap(6);
        topN.buildHeap(9);
        topN.buildHeap(7);
        topN.buildHeap(10);
        topN.buildHeap(2);
        topN.buildHeap(4);

        System.out.println("大顶堆topN：" + Arrays.toString(topN.heap));
    }

}
