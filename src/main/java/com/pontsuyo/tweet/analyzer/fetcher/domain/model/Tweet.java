package com.pontsuyo.tweet.analyzer.fetcher.domain.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.pontsuyo.tweet.analyzer.fetcher.infrastructure.model.ScoreLists;
import com.pontsuyo.tweet.analyzer.fetcher.infrastructure.model.TweetFeature;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Builder
public class Tweet implements Serializable {

  private final Long tweetId;

  private final Long userId;

  private final String text;

  // map<time, count>
  private final List<Map<Long, Integer>> favoriteCount;

  // map<time, count>
  private final List<Map<Long, Integer>> retweetCount;

  private final List<String> imageUrls;

  public static Tweet assembleFeatureAndScore(TweetFeature feature, ScoreLists scoreLists) {
    return Tweet.builder()
        .tweetId(feature.getTweetId())
        .userId(feature.getUserId())
        .text(feature.getText())
        .favoriteCount(scoreLists.getFavoriteCount())
        .retweetCount(scoreLists.getRetweetCount())
        .imageUrls(getList(feature.getImageUrls()))
        .build();
  }

  private static List<String> getList(String imageUrls) {
    // note staticメソッドにしたかったので内部でmapperを生成する。きれいではない。
    var objectMapper = new ObjectMapper();
    try {
      return objectMapper.readValue(imageUrls,
          objectMapper.getTypeFactory()
              .constructCollectionType(List.class, String.class)
      );
    } catch (JsonProcessingException e) {
      log.error("failed reading JSON string.", e);
      return Collections.emptyList();
    }
  }
}
