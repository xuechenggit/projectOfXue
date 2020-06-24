package com.xue.foundation.lru;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

public class UseSizeLRU<K, V> extends LinkedHashMap<K, V> {

    private int size;

    public UseSizeLRU(int size) {
        super(16, 0.75f, true);
        this.size = size;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size()>size;
    }
    }
