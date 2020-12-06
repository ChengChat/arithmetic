package offer.quality.question21;

import sort.SortUtlis;

public class ReOrder {
    public Strategy strategy;

    public ReOrder(Strategy strategy) {
        this.strategy = strategy;
    }

    public void reOrder(int[] arr){
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException();
        }

        int begin = 0;
        int end = arr.length - 1;
        while (begin < end) {
            while (begin < end && strategy.putInFront(arr[begin])) {
                begin++;
            }
            while (begin < end && strategy.putBehind(arr[end])) {
                end--;
            }
            if (begin < end) {
                SortUtlis.swap(arr, begin, end);
            }
        }
    }
}
