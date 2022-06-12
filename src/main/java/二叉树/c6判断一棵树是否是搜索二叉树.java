package 二叉树;

/**
 * 搜索二叉树概念：
 * 他左比父小，父比右小
 * <p>
 * 思路：中序遍历的时候比较当前结点的值和前一个结点的值，如果不是搜索二叉树肯定不是升序的。
 */
public class c6判断一棵树是否是搜索二叉树 {
    private static Integer prev = Integer.MIN_VALUE;

    public static boolean isBST(Node node) {
        if (node == null) {
            return true;
        }
        isBST(node.left);
        // 中间处理的逻辑，比较
        if (node.value <= prev) {
            return false;
        } else {
            prev = node.value;
        }
        return isBST(node.right);
    }

    public static void main(String[] args) {
        // 中序遍历是 1-2-3-4-5
        Node node2 = new Node(5, null, null);
        Node node3 = new Node(1, null, null);
        Node node4 = new Node(3, null, null);
        Node node1 = new Node(2, node3, node4);
        Node root  = new Node(4, node1, node2);
        System.out.println("isBST:" + isBST(root));
    }
}
