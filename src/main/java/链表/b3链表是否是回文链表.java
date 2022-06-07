package 链表;

/**
 * @Description 简单 coding
 */

import java.util.Stack;

/**
 * 思路 1：放栈里面去，比较原有链表和弹出栈的链表，只要有一个不同就不是回文
 * 思路 2：放入链表的一半到栈中，然后比较链表的另外一半跟栈中数据，只要有一个不同就不是回文
 * 除了遍历直到一半的位置，还有什么更好的办法吗？
 * 快慢指针，快指针走二步，慢指针走一步，当快指针走完的时候，慢指针所在的位置就是链表中间的位置。
 * 思路 3：不用栈，要求空间复杂度为 O(1)，那么还是快慢指针，快指针走完的时候，慢指针在的就是中间位置，
 * 然后慢指针之后的数据，就给他翻转过来。这样继续一个指针从头开始，一个指针从尾开始遍历，发现不一样的就不是回文。
 */
public class b3链表是否是回文链表 {
    /**
     * 方法一太简单，不解释
     */
    public static Boolean fun1(Node node) {
        Stack<Node> stack = new Stack<>();
        Node tmp = node;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }

        // 判断回文
        while (node != null) {
            Node pop = stack.pop();
            if (pop.value != node.value) {
                return false;
            }
            node = node.next;
        }
        return true;
    }

    /**
     * 方法二，做改进，放一半到栈,快慢指针
     * 奇数的情况：1-2-3-2-1  快指针的 node.next.next 不为空
     * 偶数的情况  1-2-2-1    快指针的 node.next.next 为空
     */
    public static Boolean fun2(Node node) {
        Node fast = node;
        Node slow = node;

        Stack<Node> stack = new Stack<>();
        boolean isOu = false;
        // 判断链表长度的奇数偶数
        while (fast != null && fast.next != null) {
            stack.push(slow);
            // 偶数
            if (fast.next.next == null) {
                isOu = true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        if (isOu) {
            while (slow != null) {
                Node pop = stack.pop();
                if (pop.value != slow.value) {
                    return false;
                }
                slow = slow.next;
            }
            return true;
        } else {
            slow = slow.next;
            while (slow != null) {
                Node pop = stack.pop();
                if (pop.value != slow.value) {
                    return false;
                }
                slow = slow.next;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(fun1(node1));

        Node node6 = new Node(1);
        Node node7 = new Node(2);
        Node node8 = new Node(3);
        Node node9 = new Node(1);

        node6.next = node7;
        node7.next = node8;
        node8.next = node9;

        System.out.println(fun2(node1));
        System.out.println(fun2(node6));
    }
}
