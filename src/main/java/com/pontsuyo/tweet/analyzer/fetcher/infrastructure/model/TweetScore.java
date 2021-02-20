package com.pontsuyo.tweet.analyzer.fetcher.infrastructure.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
@DynamoDBTable(tableName = "tweet-analyzer-score")
public class TweetScore implements Serializable {

  @DynamoDBHashKey(attributeName = "tweet_id")
  private Long tweetId;

  @DynamoDBHashKey(attributeName = "time")
  private Long time;

  @DynamoDBAttribute(attributeName = "favorite_count")
  private Integer favoriteCount;

  @DynamoDBAttribute(attributeName = "retweet_count")
  private Integer retweetCount;
}
