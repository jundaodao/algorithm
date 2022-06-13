package 图.模板;

/**
 * 模板边.
 */
public class Edge {
    public int  weight; //权重
    public Node from; //从哪个节点
    public Node to; //到哪个节点

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
