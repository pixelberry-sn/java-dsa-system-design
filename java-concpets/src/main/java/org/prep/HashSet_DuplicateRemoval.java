package org.prep;

import java.util.HashSet;
import java.util.Set;

public class HashSet_DuplicateRemoval {
    public static void main(String[] args){

        Set<Integer> set = new HashSet<>();

        set.add(10);
        set.add(56);
        set.add(99);
        set.add(10);

        System.out.println(set);
        System.out.println("Size of set: " + set.size());
    }

}
