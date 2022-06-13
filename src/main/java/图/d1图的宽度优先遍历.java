package 图;

/**
 * 图的宽度优先bfs遍历和二叉树的bfs有什么区别呢？
 * 答案：二叉树的 bfs没有环，而图的可能有环
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import 图.模板.Node;

/**
 * 解题思路：
 * 1、给一个点放入队列中,同时放入set集合
 * 2、当弹出这个点的时候，将这个点的所有关联点都加入队列中，如果他还没有被访问到的话.
 */
public class d1图的宽度优先遍历 {
    public void bfs(Node node) {
        Queue<Node>   queue = new LinkedList<>();
        HashSet<Node> set   = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            // 弹出一个节点
            Node poll = queue.poll();
            System.out.println("图的宽度优先遍历：" + poll.value);
            // 加入弹出这个节点的所有直接关联节点，并且没有处理过的--防止死循环
            for (Node next : poll.nexts) {
                if (!set.contains(next)) {
                    queue.add(next);
                    set.add(poll);
                }
            }
        }
    }
}
