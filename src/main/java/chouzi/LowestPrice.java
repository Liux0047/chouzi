package chouzi;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparingInt;

public class LowestPrice {

    public List<List<Integer>> solve(int[][] data) {
        List<List<Integer>> res = new ArrayList<>();
        if (data == null || data.length == 0) {
            return res;
        }
        // store data in a Queue sorted by starting time
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                comparingInt((int[] a) -> a[0])
                        .thenComparing(a -> a[1]));
        for (int[] d: data) {
            queue.offer(d);
        }

        int[] interval = queue.poll();
        int currPrice = interval[2];
        int start = interval[0];
        int end = interval[1];
        while (!queue.isEmpty()) {
            int[] next = queue.poll();
            if (next[0] >= end) {
                res.add(asList(start, end, currPrice));
                start = next[0];
                end = next[1];
                currPrice = next[2];
            }
            if (next[2] < currPrice) {  //found a cheaper interval
                if (start < next[0]) {
                    res.add(asList(start, next[0], currPrice)); // new interval is found
                }
                if (end > next[1]) {
                    // if current interval continues after the new cheaper interval ends
                    // create another interval starting at the cheaper interval's end
                    queue.offer(new int[]{next[1], end, currPrice});
                }
                // update current interval to the cheaper one
                start = next[0];
                end = next[1];
                currPrice = next[2];
            } else if (next[1] > end) {
                // if next interval is not cheaper but continues after current cheaper one
                queue.offer(new int[] {end, next[1], next[2]});
            }
        }
        if (end > start) {  // last interval
            res.add(asList(start, end, currPrice));
        }
        return res;
    }
}
