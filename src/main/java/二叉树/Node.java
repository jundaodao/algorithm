package 二叉树;

/**
 * @Description 二叉树结构体.
 * @Author jjk
 * @Date 2022/6/9 9:38 PM
 */
public class Node {
    public Integer value;
    public Node    left;
    public Node    right;

    public Node(Integer value, Node left ,Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
