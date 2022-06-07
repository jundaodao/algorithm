package 链表;

/**
 * @Description 自己练习就行，简单 coding
 * 解题思路：双指针
 * 1、node1的值比node2大，node2前进一步
 * 2、node1的值比node2小，node1前进一步
 * 3、node1的值等于node2, 打印node1或node2的值，node1,node2各前进一步
 */
public class b2打印两个有序链表的公共部分 {

    public static void printCommon(Node node1, Node node2) {
        while (node1 != null && node2 != null){
            if (node1.value > node2.value) {
                node2 = node2.next;
            } else if (node1.value < node2.value) {
                node1 = node1.next;
            } else {
                System.out.println("相等的值："+ node1.value);
                node1 = node1.next;
                node2 = node2.next;
            }
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

        Node node5 = new Node(3);
        Node node6 = new Node(5);
        node5.next = node6;

        printCommon(node1,node5);
    }
}
