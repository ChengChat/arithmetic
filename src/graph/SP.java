package graph;

import java.io.*;
import java.util.Scanner;

/**
 * 最短路径：
 * 对于网图来说，最短路径，是指两顶点之间经过的边上权值之和最少的路径，
 * 并且我们称路径上的第一个顶点为源点，最后一个顶点为终点。
 */
public class SP {

    private static final int INFINITY = 65535;
    public static void main(String[] args) {

        int[][] src = {
                {0, 1, 5, INFINITY, INFINITY, INFINITY, INFINITY, INFINITY, INFINITY},
                {1, 0, 3, 7, 5, INFINITY, INFINITY, INFINITY, INFINITY},
                {5, 3, 0, INFINITY, 1, 7, INFINITY, INFINITY, INFINITY},
                {INFINITY, 7, INFINITY, 0, 2, INFINITY, 3, INFINITY, INFINITY},
                {INFINITY, 5, 1, 2, 0, 3, 6, 9, INFINITY},
                {INFINITY, INFINITY, 7, INFINITY, 3, 0, INFINITY, 5, INFINITY},
                {INFINITY, INFINITY, INFINITY, 3, 6, INFINITY, 0, 2, 7},
                {INFINITY, INFINITY, INFINITY, INFINITY, 9, 5, 2, 0, 4},
                {INFINITY, INFINITY, INFINITY, INFINITY, INFINITY, INFINITY, 7, 4, 0}};
        /**
         *
         * 迪杰斯特拉算法：
         *   与prim思想类似，
         */
//        dijkstra(src);

        /**
         *
         * 弗洛伊德算法：
         *      可以求除所有顶点到所有顶点的最短路径
         */
        floyd(src);
    }

    private static void floyd(int[][] src) {
        //用于存储各点最短路径下标的数组
        int[][] pathArc = new int[9][9];
        //用于存储到各点到各点的最短路径
        int[][] shortPathTable = new int[9][9];

        //对pathArc、shortPathTable进行初始化
        //初始a点到b点的最短路径即为 a -> b
        shortPathTable = src.clone();
        for (int i = 0; i < src.length; i++) {
            for (int j = 0; j < src.length; j++) {
                pathArc[i][j] = j;
            }
        }

        // 三重循环权值修正
        // k代表中转顶点
        for (int k = 0; k < src.length; k++) {
            for (int i = 0; i < src.length; i++) {
                for (int j = 0; j < src.length; j++) {
                    //如果 i直接到j的路径长度大于 i -> k -> j,那么修改最短路径表
                    if(shortPathTable[i][j] > shortPathTable[i][k] + shortPathTable[k][j]){
                        shortPathTable[i][j] = shortPathTable[i][k] + shortPathTable[k][j];
                        pathArc[i][j] = pathArc[i][k];
                    }
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(shortPathTable[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void dijkstra(int[][] src) {
        //用于存储最短路径下标的数组
        int[] pathArc = new int[9];
        //用于存储起点到各点最短路径的权值和
        int[] shortPathTable = new int[9];
        //flag[w] = 1,表示已经求得V（0）到V（w）的最短路径,当前全部为0
        int[] flag = new int[9];
        for (int i = 0; i < src.length; i++) {
            //表示当前 顶点0到顶点i的最短路径
            shortPathTable[i] = src[0][i];
        }
        //表示已经求得顶点到顶点的最短路径
        flag[0] = 1;

        for (int i = 0; i < src.length; i++) {
            //求得起点到某个顶点的最短路径
            int min = INFINITY;
            // 用来记录求得的是顶点到哪个顶点的最短路径
            int k = 0;
            for (int j = 0; j < shortPathTable.length; j++) {
                if(flag[j] == 0 && shortPathTable[j] < min){
                    min = shortPathTable[j];
                    k = j;
                }
            }
            flag[k] = 1;

            for (int j = 0; j < shortPathTable.length; j++) {
                if(flag[j] == 0 && (min + src[k][j]) < shortPathTable[j]){
                    shortPathTable[j] = min + src[k][j];
                    pathArc[j] = k;
                }
            }
        }
        for (int i : pathArc) {
            System.out.println(i);
        }
        for (int i : shortPathTable) {
            System.out.println(i);
        }
    }
}
