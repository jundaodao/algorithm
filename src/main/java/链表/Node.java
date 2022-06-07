package 链表;

public class Node {

    public int value;
    public 链表.Node next;

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
