package dataStructrueAndAagorithm.algorithmDesingTechniques_10;

import dataStructrueAndAagorithm.Box;
import dataStructrueAndAagorithm.Good;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

/**
 * 近似装箱问题
 */
public class BinPackingProblem {

    //联机算法：下项适合算法
    public List<Box> nexFitAlgorithm(List<Good> goods) {
        List<Box> ret = new ArrayList<>();
        Box prev = new Box();
        for (Good good : goods) {
            if (!prev.addGood(good)) {
                ret.add(prev);
                prev = new Box();
                prev.addGood(good);
            }
        }
        if (prev.remainingCapacity.compareTo(BigDecimal.ONE) < 0) {
            ret.add(prev);
        }

        return ret;
    }

    //联机算法：首次适合算法，时间复杂度为O(N^2)
    public List<Box> firstFitAlgorithm(List<Good> goods) {
        List<Box> ret = new ArrayList<>();
        for (Good good : goods) {
            boolean addSuccess = false;
            for (Box box : ret) {
                if (box.addGood(good)) {
                    addSuccess = true;
                    break;
                }
            }
            if (!addSuccess) {
                Box cur = new Box();
                cur.addGood(good);
                ret.add(cur);
            }
        }

        return ret;
    }

    //联机算法：最佳适合算法，时间复杂度为O(NlogN)
    public List<Box> bestFitAlgorithm(List<Good> goods) {
        //使用TreeMap保证每次可以拿到容量最小的箱子来装当前货物
        TreeMap<Box, BigDecimal> treeMap = new TreeMap<>((a, b) -> Integer.compare(a.remainingCapacity.compareTo(b.remainingCapacity), 0));
        for (Good good : goods) {
            Box cur = new Box();
            cur.addGood(good);
            Box couldAdd = new Box();
            couldAdd.addGood(new Good(BigDecimal.ONE.subtract(good.size)));
            //容量大于等于当前货物的size
            Box ceilingKey = treeMap.ceilingKey(couldAdd);
            if (ceilingKey != null) {
                ceilingKey.addGood(good);
                //删除再插入保证排序
                treeMap.remove(ceilingKey);
                treeMap.put(ceilingKey, ceilingKey.remainingCapacity);
            } else {
                treeMap.put(cur, cur.remainingCapacity);
            }
        }

        return new ArrayList<>(treeMap.keySet());
    }

    //脱机算法：首次适合递减算法，时间复杂度为O(NlogN)
    public List<Box> fisrtFitDecreasingAlgorithm(List<Good> goods) {
        goods.sort((a, b) -> Integer.compare(b.size.compareTo(a.size), 0));
        return firstFitAlgorithm(goods);
    }

    public static void main(String[] args) {
        BinPackingProblem main = new BinPackingProblem();
        List<Good> input = new ArrayList<>();
        int inputNum = 10;
        Random random = new Random();
        for (int i = 0; i < inputNum; i++) {
            BigDecimal size = new BigDecimal(random.nextDouble());
            input.add(new Good(size.setScale(2, RoundingMode.HALF_UP)));
        }
        System.out.println(inputNum + "->" + input);
        List<Box> result;
        result = main.nexFitAlgorithm(input);
        System.out.println(result.size() + "->" + result);
        result = main.firstFitAlgorithm(input);
        System.out.println(result.size() + "->" + result);
        result = main.bestFitAlgorithm(input);
        System.out.println(result.size() + "->" + result);
        result = main.fisrtFitDecreasingAlgorithm(input);
        System.out.println(result.size() + "->" + result);

    }
}
