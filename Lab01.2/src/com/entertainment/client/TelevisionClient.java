package com.entertainment.client;

import com.entertainment.Television;

import java.security.interfaces.DSAPrivateKey;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class TelevisionClient {
    public static void main(String[] args) {
        // compare behavior of == and equals()
        Television tvA = new Television("Sony", 50);
        Television tvB = new Television("Sony", 50);

        System.out.println("tvA == tvB:" + (tvA == tvB));         // always false
        System.out.println("tvA.equals(tvB):" + tvA.equals(tvB)); // true now!!

        Television tvC = new Television("Samsung", 47);
        Television tvD = new Television("LG", 52);

        // Let's create a Set<Television> and see what happens
        Set<Television> tvs = new TreeSet<>();
        tvs.add(tvA);
        tvs.add(tvB); // should be rejected as a "duplicate"
        tvs.add(tvC);
        tvs.add(tvD);


        // the size of the Set should be 3, because tvB is rejected as a duplicate
        System.out.println("The size of the Set is:" + tvs.size());  //
        for (Television television : tvs) {
            System.out.println(television);
        }
    }
}
