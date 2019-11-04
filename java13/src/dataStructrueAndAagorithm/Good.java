package dataStructrueAndAagorithm;

import java.math.BigDecimal;

/**
 * 货物，大小为[0, 1]
 */
public class Good {
    public BigDecimal size;

    public Good(BigDecimal size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return String.valueOf(size);
    }
}
