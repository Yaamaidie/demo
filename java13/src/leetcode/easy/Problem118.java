package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> out = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> line = new ArrayList<>();
            line.add(1);

            if (i != 0) {
                int lineSize = i + 1;
                List<Integer> prev = out.get(i - 1);
                int j;
                for (j = 1; j < lineSize - 1; j++) {
                    line.add(prev.get(j - 1) + prev.get(j));
                }
                if (j >= lineSize - 1) {
                    line.add(1);
                }
            }

            out.add(line);
        }

        return out;
    }

    public static void main(String[] args) {
        Problem118 main = new Problem118();
        for (int i = 0; i < 10; i++) {
            System.out.println(main.generate(i));
        }
    }
}
