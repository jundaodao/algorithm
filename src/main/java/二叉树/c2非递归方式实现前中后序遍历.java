package 二叉树;

import java.util.Stack;

/**
 * 非递归就是自己用栈实现
 */
public class c2非递归方式实现前中后序遍历 {

    // todo 前序遍历

    /**
     * 一、先序遍历
     * 1、先往栈中放入头节点
     * 2、如果栈中有数据就弹出
     * 3、如果右节点!=null,压右节点，如果左节点!=null，压左节点 「先压右，再压左，这样弹出的才是左右」
     * 4、重复 2-3
     */
    public static void printPre(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node); //先放入头结点
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            System.out.println(pop.value);  //输出头结点
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }

    // todo 后续遍历：

    /**
     * 思考：前序是直接打印出来了，如果我们不打印，把他放入另外一个栈，然后再打印另外一个栈，
     * 那不就是轻松的是后续遍历了
     */
    public static void printAfter(Node node) {
        Stack<Node> stack = new Stack<>();
        Stack<Node> tmp   = new Stack<>();
        stack.push(node); //先放入头结点
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            tmp.push(pop);
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
        }

        // todo 最后将第二个栈里面的输出，不就从前序变后续了嘛
        while (!tmp.isEmpty()) {
            System.out.println(tmp.pop().value);
        }
    }

    // todo 中序遍历
    /**
     * 1、一次性将所有的左子树全压到栈里面
     * 2、从栈弹出一个，压入右边 1 个后，弹出，再将该弹出节点的所有左节点压入
     * 3、反复1-2
     *
     * 理解：一下子干到左树的最下面，弹出一个，回到父结点，再压入右 1 个，如果右子树还有左子树，一下子全压
     */
    public static void printMiddle(Node root) {
        if (root != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    System.out.println(root.value);
                    root = root.right;
                }
            }
        }
    }


    public static void main(String[] args) {
        Node node4 = new Node(4, null, null);
        Node node5 = new Node(5, null, null);
        Node node2 = new Node(2, node4, node5);
        Node node3 = new Node(3, null, null);
        Node root  = new Node(1, node2, node3);

        //测试先序
        printPre(root);  //1-2-4-5-3;
        System.out.println("==========");
        //测试后续
        printAfter(root); //4-5-2-3-1
        System.out.println("==========");
        //测试中序
        printMiddle(root); //4-2-5-1-3
    }
}
