package graph;

import graph.struct.AdjacencyMatrix;

import java.util.Collections;
import java.util.List;

import static graph.DFS.createAdjacencyMatrix;

/**
 * 最小生成树（Minimum Spanning Tree）
 * 将给出的所有点连接起来（即从一个点可到任意一个点），且连接路径之和最小的图叫最小生成树。
 */
public class MST {

    private static final int INFINITY = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] src = {
                {0, 10, INFINITY, INFINITY, INFINITY, 11, INFINITY, INFINITY, INFINITY},
                {10, 0, 18, INFINITY, INFINITY, INFINITY, 16, INFINITY, 12},
                {INFINITY, 18, 0, 22, INFINITY, INFINITY, INFINITY, INFINITY, 8},
                {INFINITY, INFINITY, 22, 0, 20, INFINITY, 24, 16, 21},
                {INFINITY, INFINITY, INFINITY, 20, 0, 26, INFINITY, 7, INFINITY},
                {11, INFINITY, INFINITY, INFINITY, 26, 0, 17, INFINITY, INFINITY},
                {INFINITY, 16, INFINITY, 24, INFINITY, 17, 0, 19, INFINITY},
                {INFINITY, INFINITY, INFINITY, 16, 7, INFINITY, 19, 0, INFINITY},
                {INFINITY, 12, 8, 21, INFINITY, INFINITY, INFINITY, INFINITY, 0}};
        /*
            普里姆算法：
            对于稠密图，即边数非常多的情况会好一些
         */
//        prim(src);

        // 生成边集数组，该数组只有n行3列，
        // n表示该图有n条边，
        // 3列的第一列表示边的起点，第二列表示边的终点，第三列表示权值。
        int[][] edgeArray = generateEdgeArray(src);

        sortEdgeArray(edgeArray);

        /*
            克鲁斯卡尔算法：
            针对边来展开，边数少时效率非常高，所以对稀疏图有很大优势
         */
        kruskal(edgeArray);
    }

    private static void sortEdgeArray(int[][] edgeArray) {
        for (int i = 1; i < edgeArray.length; i++) {
            for (int j = 0; j < edgeArray.length - i; j++) {
                if(edgeArray[j][2] > edgeArray[j+1][2]){
                    swap(edgeArray,j,j+1);
                }
            }
        }
    }

    private static void swap(int[][] edgeArray, int j, int i) {
        int[] temp = new int[3];
        temp = edgeArray[j];
        edgeArray[j] = edgeArray[i];
        edgeArray[i] = temp;
    }

    private static int[][] generateEdgeArray(int[][] src) {
        int[][] edgeArray = new int[15][3];
        int row = 0;
        for (int i = 0; i < src.length; i++) {
            for (int j = 0; j < i; j++) {
                if(src[i][j] != 0 && src[i][j] != INFINITY){
                    edgeArray[row][0] = j;
                    edgeArray[row][1] = i;
                    edgeArray[row][2] = src[i][j];
                    row++;
                }
            }
        }
        return edgeArray;
    }

    private static void kruskal(int[][] src) {
        int[] parent = new int[src.length];
        for (int i = 0; i < src.length; i++) {
            int m = find(parent,src[i][0]);
            int n = find(parent,src[i][1]);
            if(m != n){
                parent[m] = n;
                System.out.println(src[i][0] + " " + src[i][1] + " " + src[i][2]);
            }
        }
    }

    private static int find(int[] parent, int i) {

        while (parent[i] > 0) {
            i = parent[i];
        }
        return i;
    }

    private static void prim(int[][] src) {
        // 保存相关顶点下标
        int[] adjvex = new int[9];
        // 保存相关顶点间边的权值
        int[] lowcost = new int[9];

        // 将第一个顶点相关的权值先放入lowcost中
        for (int i = 1; i < src.length; i++){
            lowcost[i] = src[0][i];
            //表示lowcost中每个权值都是与0结点邻接的权值
            adjvex[i] = 0;
        }

        for (int i = 1; i < src.length; i++) {
            // 找出lowcost中最小的权值，所对应的角标即为要最小生成树要连接顶点
            int min = INFINITY;
            //保存当前最小权值的下标
            int k = 0;
            for (int j = 1; j < lowcost.length; j++) {
                if(lowcost[j] != 0 && lowcost[j] < min) {
                    min = lowcost[i];
                    k = j;
                }
            }
            System.out.println(adjvex[k] + " " + k);

            // 找出刚连接的顶点的相关权值，并与lowcost中的权值做比较，小的再放入lowcost中。
            lowcost[k] = 0;
            for (int j = 1; j < lowcost.length; j++) {
                if(lowcost[j] != 0 && src[k][j] < lowcost[j]){
                    lowcost[j] = src[k][j];
                    adjvex[j] = k;
                }

            }
        }
    }

}
