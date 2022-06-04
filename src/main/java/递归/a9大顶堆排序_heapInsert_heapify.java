package 递归;

import java.util.Arrays;

/**
 * 思路：
 * 1、先 heapInsert 将arr其变成一个大顶堆
 * 2、不断的做 heapify 直到遇到退出条件，每次 heapify 都会出现一个最大值，然后倒着就排好序了！
 * 3、时间复杂度是 O(NlogN)
 */
public class a9大顶堆排序_heapInsert_heapify {
    public static void heapSort(int[] arr) {
        // todo heapInsert 先构建一个大顶堆
        for (int i = 0; i < arr.length; i++) {  // O(N)
            a7大顶堆构建_heapInsert.heapInsert(arr, i); //O(logN)
        }
        // todo 不断的 heapify，每次都顶出一个最大值放最后
        int heapSize = arr.length;
        while (heapSize > 0) { //O(N)
            swap(arr, heapSize); //O(1)
            a8大顶堆构建_heapify.heapify(arr, 0, --heapSize); //O(logN)
        }
    }

    private static void swap(int[] heap, int heapSize) {
        // root元素跟最后一个元素做交换
        int tmp = heap[0];
        heap[0] = heap[heapSize - 1];
        heap[heapSize - 1] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 8, 9, 4, 6, 1, 5, 10};
        heapSort(arr);
        System.out.println("堆排序后：" + Arrays.toString(arr));
    }
}
