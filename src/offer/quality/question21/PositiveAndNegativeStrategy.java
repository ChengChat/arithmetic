package offer.quality.question21;

/**
 * 负数放前，正数放后
 */
public class PositiveAndNegativeStrategy  implements Strategy {
    @Override
    public boolean putInFront(int num) {
        return num < 0;
    }

    @Override
    public boolean putBehind(int num) {
        return num > 0;
    }
}