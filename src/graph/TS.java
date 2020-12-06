package graph;

import graph.struct.AdjacencyList;
import graph.struct.EdgeNode;
import graph.struct.VertexNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 拓扑排序：
 * 从AOV网中选择一个入度为0的顶点输出，然后删去此顶点，并删除以此顶点为尾的弧，
 * 继续重复此步骤，直到输出全表顶点或者AOV网中不存在入度为0的顶点为止
 */
public class TS {
    public static void main(String[] args) {
        AdjacencyList adjacencyList = createAdjacencyList();
        TopologyicalSort(adjacencyList);
    }

    private static void TopologyicalSort(AdjacencyList adjacencyList) {
        //把入度为0的顶点入栈
        Stack<VertexNode> stack = new Stack<>();
        VertexNode[] vertexNodes = adjacencyList.getVertexNodes();
        for (int i = 0; i < adjacencyList.getNumVertexes(); i++) {
            if(vertexNodes[i].getIn() == 0){
                stack.push(adjacencyList.getVertexNodes()[i]);
            }
        }
        while (!stack.empty()){
            VertexNode vertexNode = stack.pop();
            System.out.println(vertexNode.getData());
            LinkedList<EdgeNode> adjvexList = vertexNode.getAdjvexList();
            for (EdgeNode edgeNode : adjvexList) {
                VertexNode node = adjacencyList.getVertexNodes()[edgeNode.getAdjvex()];
                node.setIn(node.getIn() - 1);
                if(node.getIn() <= 0){
                    stack.push(node);
                }
            }
        }
    }

    private static AdjacencyList createAdjacencyList() {
        //这里构造的是有向图
        VertexNode[] vertexNodes = new VertexNode[5];
        vertexNodes[0] = new VertexNode('A',0);
        vertexNodes[0].addAdjvex(1).addAdjvex(2).addAdjvex(3);
        vertexNodes[1] = new VertexNode('B',3);
        vertexNodes[1].addAdjvex(4);
        vertexNodes[2] = new VertexNode('C',1);
        vertexNodes[2].addAdjvex(1);
        vertexNodes[3] = new VertexNode('D',1);
        vertexNodes[3].addAdjvex(1);
        vertexNodes[4] = new VertexNode('E',1);
        return new AdjacencyList(vertexNodes, 6);
    }
}
