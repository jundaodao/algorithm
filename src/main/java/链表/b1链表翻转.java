package 链表;

/**
 * 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
 * @Description coding题，算不上算法
 * 解题思路：
 * 1、拿出来一个节点拼在新链表的头上，直到所有节点都取完
 */

class Node {
    private int value;
    public Node next;

    Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}

public class b1链表翻转 {
    public static void revertNode(Node node) {
        // todo 用于保存翻转后的链表
        Node newNode = new Node(-1);
        // todo 相当于取出一个节点
        Node tmp = null;
        // 循环完所有的链表
        while (node != null) {
            tmp = node; //保存在临时变量中
            node = node.next; //前进一步
            tmp.next = newNode; //相当于拿出一个节点改变他的连接
            newNode = tmp; //更新newNode

        }

        // 打印翻转后的结果
        while (tmp.next != null) {
            System.out.println(tmp);
            tmp = tmp.next;
        }

    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        revertNode(node1);

    }
}
