package graph;

import graph.struct.AdjacencyList;
import graph.struct.AdjacencyMatrix;
import graph.struct.VertexNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先遍历：breadth first search
 */
public class BFS {
    public static void main(String[] args) {
/*        AdjacencyMatrix adjacencyMatrix = createAdjacencyMatrix();
        bfsForAdjacencyMatrix(adjacencyMatrix);*/


        AdjacencyList adjacencyList = createAdjacencyList();
        bfsForAdjacencyList(adjacencyList);
    }

    private static void bfsForAdjacencyList(AdjacencyList adjacencyList) {
        Queue<Integer> queue = new ArrayDeque<Integer>();
        int[] visited = new int[adjacencyList.getNumVertexes()];

        System.out.println(adjacencyList.getVertexNodes()[0].getData());
        visited[0] = 1;
        queue.offer(0);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            adjacencyList.getVertexNodes()[poll].getAdjvexList().forEach((item) -> {
                if (visited[item.getAdjvex()] == 0) {
                    System.out.println(adjacencyList.getVertexNodes()[item.getAdjvex()].getData());
                    visited[item.getAdjvex()] = 1;
                    queue.offer(item.getAdjvex());
                }
            });
        }
    }

    private static void bfsForAdjacencyMatrix(AdjacencyMatrix adjacencyMatrix) {
        Queue<Integer> queue = new ArrayDeque<Integer>();
        int[] visited = new int[adjacencyMatrix.getNumVertexes()];
        System.out.println(adjacencyMatrix.getVertex()[0]);
        visited[0] = 1;
        queue.offer(0);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (int k = 0; k < adjacencyMatrix.getNumVertexes(); k++) {
                if (adjacencyMatrix.getSrc()[poll][k] == 1 && visited[k] == 0) {
                    System.out.println(adjacencyMatrix.getVertex()[k]);
                    visited[k] = 1;
                    queue.offer(k);
                }
            }
        }
    }


    private static AdjacencyList createAdjacencyList() {
        VertexNode[] vertexNodes = new VertexNode[5];
        vertexNodes[0] = new VertexNode('A');
        vertexNodes[0].addAdjvex(1).addAdjvex(2).addAdjvex(3);
        vertexNodes[1] = new VertexNode('B');
        vertexNodes[1].addAdjvex(0).addAdjvex(2).addAdjvex(3).addAdjvex(4);
        vertexNodes[2] = new VertexNode('C');
        vertexNodes[2].addAdjvex(0).addAdjvex(1);
        vertexNodes[3] = new VertexNode('D');
        vertexNodes[3].addAdjvex(0).addAdjvex(1);
        vertexNodes[4] = new VertexNode('E');
        vertexNodes[4].addAdjvex(1);
        return new AdjacencyList(vertexNodes, 6);
    }

    public static AdjacencyMatrix createAdjacencyMatrix() {
        char[] vertex = {'A', 'B', 'C', 'D', 'E'};
        int[][] src = {
                {0, 1, 1, 1, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0}};
        return new AdjacencyMatrix(vertex, src, 6);
    }
}
