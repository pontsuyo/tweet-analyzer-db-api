package com.pontsuyo.tweet.analyzer.fetcher.infrastructure.model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScoreLists {

  private List<Map<Long, Integer>> favoriteCount;

  private List<Map<Long, Integer>> retweetCount;

  public static ScoreLists list2scores(List<TweetScore> scoreList) {
    var favList = scoreList.stream()
        .map(s -> Map.of(s.getTime(), s.getFavoriteCount()))
        // sort by time (assending)
        .sorted()
        .collect(Collectors.toList());

    var retweetList = scoreList.stream()
        .map(s -> Map.of(s.getTime(), s.getRetweetCount()))
        // sort by time (assending)
        .sorted()
        .collect(Collectors.toList());

    return new ScoreLists(favList, retweetList);
  }
}
