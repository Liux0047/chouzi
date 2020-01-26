package chouzi;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class LowestPriceTest {

    @Test
    void solve() {
        int[][] data = {
                {0, 4, 5},
                {2, 8, 3},
                {7, 11, 10}
        };
        List<List<Integer>> expected = asList(
                asList(0, 2, 5),
                asList(2, 8, 3),
                asList(8, 11, 10)
        );
        assertEquals(expected, new LowestPrice().solve(data));
    }
}