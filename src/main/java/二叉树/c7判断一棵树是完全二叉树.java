package 二叉树;

/**
 * 完全二叉树概念：
 * 堆排序就是完全二叉树，结点都挨着，也就是每一层都是满的（1，2，4），只有最后一层是不满的。
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 解题思路：
 * 层序遍历：
 * 1、碰到只有右孩子没有左孩子的，必然不是完全二叉树
 * 2、找到第一个只有左孩子并且没有右孩子的节点n1，从n1开始所有的节点都应该是叶子节点,否则他必然不是完全二叉树
 * <p>
 * 自己画图理解去，很简单~
 */
public class c7判断一棵树是完全二叉树 {
    public static boolean isTrue(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        boolean isLeaf = false;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }

            // 如果预期是叶子节点，左右都应该为空，否则就不是完全二叉树
            if (isLeaf && (poll.left != null || poll.right != null)) {
                return false;
            }
            // 只有右节点，没有左节点肯定不是完全二叉树
            if (poll.left == null && poll.right != null) {
                return false;
            } else if (poll.left != null && poll.right == null) {
                // 只有左没有右，那么该层和下一层剩余的元素，都应该是叶子节点
                isLeaf = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // 层序遍历是 4-2-5-1-3-6
        Node node6 = new Node(6, null, null);
        Node node2 = new Node(5, node6, null);
        Node node3 = new Node(1, null, null);
        Node node4 = new Node(3, null, null);
        Node node1 = new Node(2, node3, node4);
        Node root  = new Node(4, node1, node2);
        System.out.println("是否是完全二叉树：" + isTrue(root));
    }
}
