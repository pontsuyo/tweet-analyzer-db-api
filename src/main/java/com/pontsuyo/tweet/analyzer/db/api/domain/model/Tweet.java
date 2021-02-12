package com.pontsuyo.tweet.analyzer.db.api.domain.model;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
public class Tweet implements Serializable {
  private final Long tweetId;

  private final Long userId;

  private final String text;

  private final Integer favoriteCount;

  private final Integer retweetCount;

  private final List<String> imageUrls;

}
