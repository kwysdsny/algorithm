package leetcode75;

import java.util.ArrayList;
import java.util.Arrays;

public class 相等行列对 {
    public int equalPairs(int[][] grid) {
        int sum = 0;
        ArrayList<ArrayList<Integer>> listsum = new ArrayList<>();
        ArrayList<ArrayList<Integer>> listsum2 = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            ArrayList list = new ArrayList();
            for (int j = 0; j < grid[i].length; j++) {
                list.add(grid[i][j]);
            }
            listsum.add(list);
        }
        for (int j = 0; j < grid[0].length; j++) {
            ArrayList list = new ArrayList();
            for (int i = 0; i < grid.length; i++) {
                list.add(grid[i][j]);
            }
            listsum2.add(list);
        }
        for (int i = 0; i < listsum.size(); i++) {
            for (int j = 0; j < listsum2.size(); j++) {
                if (listsum.get(i).equals(listsum2.get(j)))
                    sum++;

            }
        }
        return sum;
    }
}
