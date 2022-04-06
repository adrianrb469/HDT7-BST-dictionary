package com.adrian.dictionary;

import java.util.ArrayList;

public class StringTraversal<K, V> implements ITreeTraversal<K,V> {

    @Override
    public void Walk(K key, V value) {
        System.out.println("("+key+", "+value+")");
    }


}
