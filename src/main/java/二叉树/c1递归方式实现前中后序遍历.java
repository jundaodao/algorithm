package 二叉树;

/**
 * c0递归序告诉我们，每个结点都会经过3次，假如说我们代码什么都不做，那么他就是上图的顺序在做递归。
 * <p>
 * 所以：
 * 先序，中序，后序遍历就很好理解了！反正每个节点递归都会经过 3 次，也就是输出第几次的结果，就变换成这这种序了~
 */
public class c1递归方式实现前中后序遍历 {

    // todo 先序遍历
    public void printPre(Node node) {
        if (node == null) {
            return;
        }
        // 只在第一次递归的时候打印
        System.out.println(node.value);
        printPre(node.left);
        printPre(node.right);
    }

    // todo 中序遍历
    public void printMiddle(Node node) {
        if (node == null) {
            return;
        }
        printMiddle(node.left);
        // 只在第二次递归的时候打印
        System.out.println(node.value);
        printMiddle(node.right);
    }

    // todo 后序遍历
    public void printAfter(Node node) {
        if (node == null) {
            return;
        }
        printAfter(node.left);
        // 只在第三次递归的时候打印
        System.out.println(node.value);
        printAfter(node.right);
    }
}
