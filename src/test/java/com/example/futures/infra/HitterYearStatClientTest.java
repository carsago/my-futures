package com.example.futures.infra;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class HitterYearStatClientTest {

     @Test
     void readYearStat() {
         final var sut = new HitterYearStatClient();
         final var year = 2025;

         List<HitterYearStat> actual = sut.getHitterYearStats(year);

         assertThat(actual).isNotEmpty();
     }
}
