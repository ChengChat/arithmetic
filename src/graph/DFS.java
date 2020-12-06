package graph;

import graph.struct.AdjacencyList;
import graph.struct.AdjacencyMatrix;
import graph.struct.EdgeNode;
import graph.struct.VertexNode;

import java.util.Iterator;


public class DFS {
    static boolean[] visited = new boolean[5];

    public static void main(String[] args) {
   /*     AdjacencyMatrix adjacencyMatrix = createAdjacencyMatrix();
        dfsForAdjacencyMatrix(adjacencyMatrix,0);*/


        AdjacencyList adjacencyList = createAdjacencyList();
        dfsForAdjacencyList(adjacencyList, 0);

    }

    private static void dfsForAdjacencyList(AdjacencyList adjacencyList, int i) {
        System.out.println(adjacencyList.getVertexNodes()[i].getData());
        visited[i] = true;
        Iterator<EdgeNode> iterator = adjacencyList.getVertexNodes()[i].getAdjvexList().iterator();
        while (iterator.hasNext()) {
            EdgeNode next = iterator.next();
            if (!visited[next.getAdjvex()]) {
                dfsForAdjacencyList(adjacencyList, next.getAdjvex());
            }
        }
    }

    private static void dfsForAdjacencyMatrix(AdjacencyMatrix adjacencyMatrix, int i) {
        System.out.println(adjacencyMatrix.getVertex()[i]);
        visited[i] = true;
        for (int j = 0; j < adjacencyMatrix.getNumVertexes(); j++) {
            if (adjacencyMatrix.getSrc()[i][j] == 1 && !visited[j]) {
                dfsForAdjacencyMatrix(adjacencyMatrix, j);
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
