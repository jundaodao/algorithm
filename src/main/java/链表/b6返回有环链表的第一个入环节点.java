package 链表;

/**
 * 方法一：hash 表
 * hash表：来一个存一个，如果走的话，发现 hash表里面已经存在，那么他就是一个入环的节点；
 * 如果链表走完都没有在 hash表的，那就没有环；
 * 缺点：占用空间复杂度 O(N)
 * <p>
 * <p>
 * 方法二：快慢指针
 * 快指针：走两步
 * 慢指针：走一步
 * 相遇后，慢指针从相遇点出发，快指针从最开头出发，都是各走一步，他们再次相遇节点，就是第一个入环节点。
 * 为什么？-- 原理
 * 这就是结论，记住就行。
 */
public class b6返回有环链表的第一个入环节点 {

    public static Node ring(Node node1) {
        Node    slow       = node1;
        Node    fast       = node1;
        boolean existsRing = false;
        // 是否有环，返回第一次相交的节点
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                existsRing = true;
                break;
            }
        }

        // 有环的情况
        if (existsRing) {
            // 快指针从头开始
            fast = node1;
            while (true) { //已经证明有环了，所以直接死循环，肯定能退出
                slow = slow.next; //走一步
                fast = fast.next; //走一步
                if (slow == fast) {
                    return slow;
                }
            }
        }
        // 无环的情况
        return null;
    }


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;

        Node node = ring(node1);
        System.out.println("第一个相交的节点：" + node);

    }
}
