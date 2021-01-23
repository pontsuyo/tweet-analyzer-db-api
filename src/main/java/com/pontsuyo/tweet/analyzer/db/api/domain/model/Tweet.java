package com.pontsuyo.tweet.analyzer.db.api.domain.model;

import java.io.Serializable;
import lombok.Data;

@Data
public class Tweet implements Serializable {
  private String tweetId;
}
