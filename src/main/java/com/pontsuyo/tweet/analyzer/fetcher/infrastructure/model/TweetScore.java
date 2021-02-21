package com.pontsuyo.tweet.analyzer.fetcher.infrastructure.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;

@Slf4j
@Data
@NoArgsConstructor
@DynamoDBTable(tableName = "tweet-analyzer-score")
public class TweetScore implements Serializable {
  @Id
  private TweetScoreId tweetScoreId;

  @DynamoDBHashKey(attributeName = "tweet_id")
  private Long tweetId;

  @DynamoDBRangeKey(attributeName = "time")
  private Long time;

  @DynamoDBAttribute(attributeName = "favorite_count")
  private Long favoriteCount;

  @DynamoDBAttribute(attributeName = "retweet_count")
  private Long retweetCount;

  @Data
  @NoArgsConstructor
  public static class TweetScoreId implements Serializable{
    @DynamoDBHashKey
    private Long tweetId;

    @DynamoDBRangeKey
    private Long time;
  }
}
