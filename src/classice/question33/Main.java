/*
package classice.question33;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = "1,2,3,4,5;5";
        String[] strs = s.split(";");
        String[] strings = strs[0].split(",");
        int[] values = new int[strings.length];
        int price = Integer.parseInt(strs[1]);
        for (int i = 0; i < strings.length; i++) {
            values[i] = Integer.parseInt(strings[i]);
        }
        Arrays.sort(values);
    }

    public static boolean method(int[] values, int index,int price, int current, List list){
        if(current > price){
            return false;
        }
        if(current == price){
            add(list);
            return true;
        }
        list.add(values[index+1]);
        return method(values,index+1,price,current + values[index+1],list)
                || method(values,index+1,price,current + values[index+1],list);
        list.remove(values[index+1]);

        method(values,index+1,price,current,list);
    }
}
*/
