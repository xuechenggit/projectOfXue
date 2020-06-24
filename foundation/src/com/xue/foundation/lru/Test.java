package com.xue.foundation.lru;

import java.util.Iterator;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        UseSizeLRU<Integer, String> u = new UseSizeLRU<>(5);
        u.put(1, "aa");
        u.put(2, "b");
        u.put(3, "vv");
        u.put(4, "gg");
        u.put(5, "ddd");
        u.put(7, "ddd");
        Iterator i = u.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry<Integer, String> m = (Map.Entry<Integer, String>) i.next();
            System.out.println(m.getKey() + "   " + m.getValue());
        }
    }
}
