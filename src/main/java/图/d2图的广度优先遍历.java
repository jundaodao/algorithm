package 图;

/**
 * 广度优先遍历又叫深度优先遍历，什么意思呢？
 * 就是逮住一个点，一直往下面走。
 */

import java.util.HashSet;
import java.util.Stack;
import 图.模板.Node;

/**
 * 解题思路：
 * 1、来一个元素放入栈中，放入 set中
 * 2、弹出一个元素，往栈中加入弹出这个元素的所有直接节点，并且还要加入刚弹出的节点，加入栈的都放 set 中
 */
public class d2图的广度优先遍历 {

    public static void dfs(Node node) {
        Stack<Node>   stack = new Stack<>();
        HashSet<Node> sets  = new HashSet<>();
        stack.add(node);
        sets.add(node);
        System.out.println("图的dfs:" + node.value);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            for (Node next : pop.nexts) {
                if (!sets.contains(next)) {
                    stack.add(pop);
                    stack.add(next);
                    sets.add(next);
                    System.out.println("图的dfs:" + next.value);
                    break; //只要遇到一个，就直接 break，跟 bfs不同，他主要是想一直往下走。
                }
            }
        }
    }
}
