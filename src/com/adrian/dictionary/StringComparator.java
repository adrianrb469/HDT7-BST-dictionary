package com.adrian.dictionary;

import java.util.Comparator;

public class StringComparator<K> implements Comparator<K>{

    @Override
    public int compare(K o1, K o2){
        String s1 = String.valueOf(o1);
        String s2 = String.valueOf(o2);

        if (s1.compareToIgnoreCase(s2) > 0){
            return 1;
        } else if (s1.compareToIgnoreCase(s2) < 0){
            return -1;
        } else{
            return 0;
        }

    }
}
