package com.pontsuyo.tweet.analyzer.fetcher.infrastructure.model;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScoreLists {

  static final String TIME_KEY = "time";
  static final String FAVORITE_COUNT_KEY = "favorite_count";
  static final String RETWEET_COUNT_KEY = "retweet_count";

  private List<Map<String, Long>> favoriteCount;

  private List<Map<String, Long>> retweetCount;

  public static ScoreLists list2scores(List<TweetScore> scoreList) {
    var favList = scoreList.stream()
        // sort by time (assending)
        .sorted(Comparator.comparingInt(s -> s.getTime().intValue()))
        .map(s -> Map.of(
            TIME_KEY, s.getTime(),
            FAVORITE_COUNT_KEY, s.getFavoriteCount()
        ))
        .collect(Collectors.toList());

    var retweetList = scoreList.stream()
        // sort by time (assending)
        .sorted(Comparator.comparingInt(s -> s.getTime().intValue()))
        .map(s -> Map.of(
            TIME_KEY, s.getTime(),
            RETWEET_COUNT_KEY, s.getRetweetCount()
        ))
        .collect(Collectors.toList());

    return new ScoreLists(favList, retweetList);
  }
}
