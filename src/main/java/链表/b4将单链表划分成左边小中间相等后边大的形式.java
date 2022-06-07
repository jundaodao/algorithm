package 链表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 将单链表划分成左边小中间相等后边大的形式,同样，左右内部可以不区分大小
 * 思路：
 * 笔试：将 node放入数组中，然后做 partition,荷兰国旗了，然后再串起来，就完事了，空间复杂度 O(n)
 * <p>
 * 面试：空间复杂度 O(1)
 * 思路 2: 搞 6 个变量，
 * 1） 小于指定数的头 sh , 小于指定数的尾 st
 * 2)  等于指定数的头 eh, 等于指定数的尾 et
 * 3) 大于指定数的头  bh, 大于指定数的尾 bt
 * <p>
 * 当发现小于n时候，sh,st =arr[i] ,当再次发现小于n的时候,st=arr[i], sh->st 指向
 * 当发现大于n时候，bh,bt =arr[i],当再次发现大于n的时候，bt=arr[i],bh->bt 指向
 * 当发现等于n时候，eh,et =arr[i],当再次发现等于n的时候，et=arr[i]， eh->et 指向
 * <p>
 * 最后将这三个链表头尾相连，就成了左边都是比 n 小的，有边都是比 n大的，中间都是 n
 * 并且这么做就只有 6 个变量，空间复杂度 O(1)
 */
public class b4将单链表划分成左边小中间相等后边大的形式 {
    public static void partitionFun1(Node node, int num) {
        // 把链表内容放到数组中
        List<Node> nodes = new ArrayList<>();
        Node tmp = node;
        while (tmp != null) {
            nodes.add(tmp);
            tmp = tmp.next;
        }
        Node[] arr = nodes.toArray(new Node[nodes.size()]);
        // 利用partition分数据到左右两边
        partition(arr, num);
        System.out.println(Arrays.toString(arr));

    }

    private static void partition(Node[] arr, int num) {
        // 左夹板
        int l = 0;
        // 右夹板
        int r = arr.length - 1;
        // 当前的位置
        int current = 0;

        while (current <= r) {
            Node node = arr[current];
            if (node.value < num) {
                // 例如num=3  1-3-2 这种就必须交换
                swap(arr, l++, current++);
            } else if (node.value > num) {
                swap(arr, current, r--);
            } else {
                current++;
            }
        }
    }

    private static void swap(Node[] arr, int l, int r) {
        Node tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(4);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        partitionFun1(node1, 2);
    }

}
