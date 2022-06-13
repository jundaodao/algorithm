package 图.模板;

import java.util.ArrayList;
import java.util.List;

/**
 * 模板节点
 */
public class Node {
    public int        value; //节点的值
    public int        in; //进来方向的个数
    public int        out; //出去方向的个数
    public List<Node> nexts; //指出去的节点
    public List<Edge> edges; //指出去的边

    public Node(int value) {
        this.value = value;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
}
