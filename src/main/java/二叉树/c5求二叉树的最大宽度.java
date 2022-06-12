package 二叉树;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 解题思路：
 * 稍微改造层级遍历，记录下来每一层的层号在额外的map中
 * 遍历每个元素，比较当前层级号如果相同，那么层元素个数+1, 如果不同，说明换层了，那么更新层号和层元素个数
 * 每一次元素比较完都取最大值。
 */
public class c5求二叉树的最大宽度 {

    public static Integer getBigWith(Node node) {
        Queue<Node>            queue = new LinkedList<>(); // 保存所有元素到队列
        HashMap<Node, Integer> map   = new HashMap<>(); //key:节点，value:层号
        queue.add(node);
        map.put(node, 1); //root节点是第一层
        int maxWith         = 0;
        int currentLevel    = 1;
        int currentLevelNum = 0;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.left != null) {
                queue.add(poll.left);
                map.put(poll.left, map.get(poll) + 1); //记录每一个 node的层级，父层级+1
            }
            if (poll.right != null) {
                queue.add(poll.right);
                map.put(poll.right, map.get(poll) + 1);
            }

            System.out.println("当前层：" + currentLevel + "层级：" + map.get(poll));

            // 如果当前层级=当前 node层级，那么当前层级元素个数+1
            if (currentLevel == map.get(poll)) {
                currentLevelNum++;
            } else {
                // 否则，说明换层了，重置层号，层元素也重置
                currentLevel = map.get(poll);
                currentLevelNum = 1;
            }
            maxWith = Math.max(maxWith, currentLevelNum);
        }
        return maxWith;
    }

    public static void main(String[] args) {
        // 层序遍历是 4-2-5-1-3-6
        Node node6 = new Node(6, null, null);
        Node node2 = new Node(5, null, node6);
        Node node3 = new Node(1, null, null);
        Node node4 = new Node(3, null, null);
        Node node1 = new Node(2, node3, node4);
        Node root  = new Node(4, node1, node2);
        System.out.println("最大宽度：" + getBigWith(root));
    }


}
