package com.duckrace;

import java.util.List;

import static com.duckrace.Reward.*;  // OK to use * for static imports

class DuckRacerTest {

    public static void main(String[] args) {
        DuckRacer racer5 = new DuckRacer(5,"Chris");

        System.out.println(racer5); // toString() automatically called

        racer5.win(DEBIT_CARD);
        racer5.win(DEBIT_CARD);
        racer5.win(PRIZES);
        racer5.win(DEBIT_CARD);

        System.out.println(racer5);

//       // Hey, I can cheat - I can just call getRewards(), get that List back, and add()
//        List<Reward> rewards = racer5.getRewards(); // 4 IN HERE NOW
//        rewards.add(PRIZES);
//        rewards.add(PRIZES);
//        racer5.win(PRIZES);
//        racer5.win(PRIZES);
//        System.out.println(rewards); // you will see 6 now
    }
}