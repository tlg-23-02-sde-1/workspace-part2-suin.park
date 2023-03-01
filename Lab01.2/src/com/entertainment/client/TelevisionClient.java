package com.entertainment.client;

import com.entertainment.Television;

import java.security.interfaces.DSAPrivateKey;
import java.util.*;

class TelevisionClient {
    public static void main(String[] args) {
        // compare behavior of == and equals()
        Television tvA = new Television("Sony", 50);
        Television tvB = new Television("Sony", 50);
        Television tvC = new Television("Sony", 52);
        Television tvD = new Television("Sony", 12);

        System.out.println("tvA == tvB:" + (tvA == tvB));         // always false
        System.out.println("tvA.equals(tvB):" + tvA.equals(tvB)); // true now!!

/*      // print each hashcode
        System.out.println(tvA.hashCode());
        System.out.println(tvB.hashCode());
*/
        // Let's create a Set<Television> and see what happens
        Set<Television> tvs = new TreeSet<>();
        tvs.add(tvA);
        tvs.add(tvB);
        tvs.add(tvC);
        tvs.add(tvD);

        // the size of the Set should be 3, because tvB is rejected as a duplicate
        System.out.println("The size of the Set is:" + tvs.size());  //
        for (Television television : tvs) {
            System.out.println(television);
        }
    }
}
