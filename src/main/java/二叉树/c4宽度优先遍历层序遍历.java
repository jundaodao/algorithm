package 二叉树;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 层序遍历又叫 广度优先遍历 BFS
 * 思路：
 * 拿到一个结点后，分别放入左结点和右节点到队列，然后分别打印。
 */
public class c4宽度优先遍历层序遍历 {

    public static void BFS(Node node) {
        BlockingQueue<Node> queue = new LinkedBlockingDeque();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            System.out.print(poll.value + "\t");
            Node left  = poll.left;
            Node right = poll.right;
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
        }
    }

    public static void main(String[] args) {
        // 层序遍历是 4-2-5-1-3
        Node node2 = new Node(5, null, null);
        Node node3 = new Node(1, null, null);
        Node node4 = new Node(3, null, null);
        Node node1 = new Node(2, node3, node4);
        Node root  = new Node(4, node1, node2);
        BFS(root);
    }
}
