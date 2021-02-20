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
@DynamoDBTable(tableName = "tweet-analyzer")
public class TweetFeature implements Serializable {

  @DynamoDBHashKey(attributeName = "tweet_id")
  private Long tweetId;

  @DynamoDBAttribute(attributeName = "user_id")
  private Long userId;

  @DynamoDBAttribute(attributeName = "text")
  private String text;

  @DynamoDBAttribute(attributeName = "image_urls")
  private String imageUrls;
}
