package chouzi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstNonRepeatingTest {

    @Test
    void solve() {
        assertEquals('a', new FirstNonRepeating().solve("bbac"));
    }
}