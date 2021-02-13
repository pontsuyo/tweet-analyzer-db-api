package com.pontsuyo.tweet.analyzer.db.api.domain.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pontsuyo.tweet.analyzer.db.api.infrastructure.model.InfraTweet;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@Builder
public class Tweet implements Serializable {

  private final Long tweetId;

  private final Long userId;

  private final String text;

  private final Integer favoriteCount;

  private final Integer retweetCount;

  private final List<String> imageUrls;

  public static Tweet fromInfraTweet(InfraTweet infraTweet) {
    return Tweet.builder()
        .tweetId(infraTweet.getTweetId())
        .userId(infraTweet.getUserId())
        .text(infraTweet.getText())
        .favoriteCount(infraTweet.getFavoriteCount())
        .retweetCount(infraTweet.getRetweetCount())
        .imageUrls(getList(infraTweet.getImageUrls()))
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
