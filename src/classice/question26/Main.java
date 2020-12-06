package classice.question26;


import static sort.SortUtlis.swap;

public class Main {
    public static void main(String[] args) {
        print(0,"123".toCharArray());

    }

    private static void print(int n, char[] array) {
        if(n >= array.length){
            System.out.println(new String(array).toString());
            return;
        }
        for (int i = n; i < array.length; i++) {
            swap(array,i,n);
            print(n+1,array);
            swap(array,i,n);
        }
    }
}
