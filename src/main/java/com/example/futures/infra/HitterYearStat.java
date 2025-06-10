package com.example.futures.infra;

public record HitterYearStat(
        String webId,
        String name,
        String team,
        Integer playedGames,
        Integer pa,
        Integer ab,
        Integer runs,
        Integer hits,
        Integer doubles,
        Integer triples,
        Integer homeRuns,
        Integer rbi,
        Integer stealBases,
        Integer baseOnBalls,
        Integer hitByPitch,
        Integer strikeouts,
        Double obp,
        Double slg
) {
}
