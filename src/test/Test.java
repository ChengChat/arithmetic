package test;

import com.sun.jmx.remote.internal.ArrayQueue;
import graph.DFS;
import graph.struct.AdjacencyMatrix;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        System.out.println(3 % 3);
        /*Long b = new Long(-662679659L);
        Long c = new Long(662679658L);
        int[] arr = {1,2,3};
        int[] add = {1,2,3};
        Map<Integer,Integer> e = new HashMap<>();
        Map<Integer,Integer> f = new HashMap<>();
        System.out.println(arr.hashCode());
        System.out.println(arr.equals(add));
        System.out.println(add.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());
        System.out.println(b.equals(c));*/
        int i01 = 59;
        Integer i02 = 59;
        Integer i03 = Integer.valueOf(59);
        Integer i04 = new Integer(59);
        System.out.println(i01 == i02);
        System.out.println(i03 == i01);
        // i02与i04比较，值类型与引用类型用等号比较，
        // 比较的是值(引用类型自动拆箱为int)，故返回true;
        System.out.println(i04 == i01);
        System.out.println(i04 == i03);
        System.out.println(i04 == i02);

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("sdf,");
        stringBuffer.append("345,");
        stringBuffer.delete(stringBuffer.length()-1,stringBuffer.length());
        System.out.println(stringBuffer.toString());

    }


    private static void update(Integer integer) {
        integer = integer + 3;
        System.out.println(integer);
    }

    private static void update(List<String> strings) {
        strings.add("gd");

    }

}
