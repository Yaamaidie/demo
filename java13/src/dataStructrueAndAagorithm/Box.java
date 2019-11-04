package dataStructrueAndAagorithm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * 装货物的箱子，容量为1
 */
public class Box {
    public BigDecimal remainingCapacity = new BigDecimal("1.0");
    private List<Good> goods;

    public Box() {
        goods = new ArrayList<>();
    }

    public boolean addGood(Good good) {
        if (remainingCapacity.compareTo(good.size) < 0) {
            return false;
        }
        remainingCapacity = remainingCapacity.subtract(good.size);
        goods.add(good);
        return true;
    }

    @Override
    public String toString() {
        StringJoiner join = new StringJoiner(",", "(", ")");
        for (Good good : goods) {
            join.add(String.valueOf(good.size));
        }
        return join.toString();
    }
}
