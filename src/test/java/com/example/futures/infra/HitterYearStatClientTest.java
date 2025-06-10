package com.example.futures.infra;

import org.junit.jupiter.api.Test;

class HitterYearStatClientTest {

     @Test
     void readYearStat() {
         final var sut = new HitterYearStatClient();
         final var year = 2025;

         sut.getHitterYearStats(year);
     }
}
