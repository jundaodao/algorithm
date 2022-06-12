package 二叉树;

/**
 * 题目：微软原题
 * 给一个纸条，对折纸条，假如对折 N 次，请打印对折的顺序
 * 第一次对折只有一个折痕，并且是下凹的
 * 第二次对折又出现了 2 个折痕，上面是凹的，下面是凸的
 * 第三次对折出现了 4 个折痕，在上面第二次对折的折痕上面都是凹，在上面第三次对折的折痕下都是凸的
 */

/**
 * 解题思路：
 * 用一颗二叉树模拟对折，
 * 1               凹
 * 2         凹          凸
 * 3     凹     凸     凹    凸
 * <p>
 * 所以模拟一个二叉树，左节点都是凹，右节点都是凸，root节点=凹
 */
public class c14折纸的问题 {
    public static void printAll(int N) {
        printProcess(1, N, true);
    }

    // i:节点层数  N:参数总层数 isDown=true=凹，否则就是凸
    private static void printProcess(int i, int N, boolean isDown) {
        if (i > N) {
            return;
        }
        //中序遍历
        printProcess(i + 1, N, true); //左凹
        System.out.println(isDown ? "凹" : "凸");
        printProcess(i + 1, N, false); //右凸
    }
}
