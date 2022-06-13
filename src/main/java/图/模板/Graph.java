package 图.模板;

import java.util.Map;
import java.util.Set;

/**
 * 模板图
 * 没有模板做图的算法题就跟裸奔差不多~
 */
public class Graph {
    public Map<Integer, Node> nodes; //保存所有结点，key：结点保存的值，value:封装的 node结构体
    public Set<Edge>          edges; //保存所有的边

    public Graph(Map<Integer, Node> nodes, Set<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }
}
