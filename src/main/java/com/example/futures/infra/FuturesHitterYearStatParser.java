package com.example.futures.infra;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FuturesHitterYearStatParser {

    private static final String WEB_ID_PREFIX = "playerId=";

    public List<HitterYearStat> parse(final String html) {
        final Document document = Jsoup.parse(html);
        final Elements elements = document.select("div.tbl-futures01 table tbody tr");
        List<HitterYearStat> stats = new ArrayList<>();
        for (final Element element : elements) {
            final Elements tds = element.select("td");
            final Element nameAnchor = tds.get(1).selectFirst("a");
            final String webId = extractWebId(nameAnchor);
            final String name = nameAnchor.text();
            final String team = tds.get(2).text();

            HitterYearStat stat = new HitterYearStat(
                    webId,
                    name,
                    team,
                    parseInt(tds.get(4).text()),  // 경기수
                    parseInt(tds.get(5).text()),  // 타석
                    parseInt(tds.get(6).text()),  // 타수
                    parseInt(tds.get(7).text()),  // 득점
                    parseInt(tds.get(8).text()),  // 안타
                    parseInt(tds.get(9).text()),  // 2루타
                    parseInt(tds.get(10).text()), // 3루타
                    parseInt(tds.get(11).text()), // 홈런
                    parseInt(tds.get(12).text()), // 타점
                    parseInt(tds.get(13).text()), // 도루
                    parseInt(tds.get(14).text()), // 볼넷
                    parseInt(tds.get(15).text()), // 사구
                    parseInt(tds.get(16).text()), // 삼진
                    parseDouble(tds.get(17).text()),  // 장타율
                    parseDouble(tds.get(18).text()) // 출루율
            );

            stats.add(stat);
        }

        return stats;
    }

    private String extractWebId(final Element anchor) {
        final String href = anchor.attr("href");
        return href.substring(href.indexOf(WEB_ID_PREFIX))
                .replace(WEB_ID_PREFIX, "");
    }

    private Integer parseInt(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private Double parseDouble(String text) {
        try {
            return Double.parseDouble(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
