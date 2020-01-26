package chouzi;

import java.util.LinkedHashMap;

public class FirstNonRepeating {

    public char solve(String s) {
        // use linked hash map because keys are sorted in insertion order
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.remove(c);
            } else {
                map.put(c, i);
            }
        }
        if (map.size() > 0) {
            return map.keySet().iterator().next();
        } else {
            return ' ';
        }
    }
}
