package 图;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import 图.模板.Graph;
import 图.模板.Node;

/**
 * 假如一个大型项目，项目之前相互有依赖关系，如果排好序，让依赖后才能跑呢？
 * 这就是拓扑排序
 */
public class d3拓扑排序 {
    public static List<Node> topologySort(Graph graph) {
        List<Node> results = new ArrayList<>(); // 最终返回的结果

        // key：节点; value：剩余入度
        Map<Node, Integer> inMap = new HashMap();
        // 入度为 0 的放入其中
        LinkedList<Node> zeroInQueue = new LinkedList<>();

        // 第一次循环将所有结点的入度都放入 map,并且收集了第一波入度为 0的节点
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }

        // 第二次循环,依赖他的入度都-1
        while (!zeroInQueue.isEmpty()) {
            Node poll = zeroInQueue.poll();
            results.add(poll);
            for (Node next : poll.nexts) {
                //所有依赖他的，入度都-1
                inMap.put(next, inMap.get(next) - 1);
                if(inMap.get(next) == 0){
                    zeroInQueue.add(next);
                }
            }

        }

        return results;


    }
}
