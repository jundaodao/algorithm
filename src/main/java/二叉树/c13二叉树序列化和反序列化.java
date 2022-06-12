package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 解题思路：
 * 使用先序遍历，如果遇到#代替，用_分割每个节点  -- 序列化
 * 然后再反序列化一下
 */
public class c13二叉树序列化和反序列化 {

    // 先序遍历的改版-- 序列化
    public static String serial(Node node) {
        if (node == null) {
            return "#_";
        }
        String res = node.value + "_";
        res += serial(node.left);
        res += serial(node.right);
        return res;
    }

    // 反序列化
    public static Node unSerial(String preStr) {
        //分割后，先放入到队列，消费队列，碰到一个解析一个
        String[]      split = preStr.split("_");
        Queue<String> queue = new LinkedList<>();
        for (String s : split) {
            queue.add(s);
        }
        return recordPreOrder(queue);
    }

    public static Node recordPreOrder(Queue<String> queue) {
        String poll = queue.poll();
        if (poll.equals("#")) {
            return null;
        }
        Integer value = Integer.valueOf(poll);
        Node    left  = recordPreOrder(queue);
        Node    right = recordPreOrder(queue);
        return new Node(value, left, right);
    }
}
