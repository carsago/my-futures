package com.example.futures.infra;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class HitterYearStatClientTest {

    @Autowired
    HitterYearStatClient sut;

     @Test
     void readYearStat() {
         final var year = 2025;

         List<HitterYearStat> actual = sut.getHitterYearStats(year);

         assertThat(actual).isNotEmpty();
     }
}
