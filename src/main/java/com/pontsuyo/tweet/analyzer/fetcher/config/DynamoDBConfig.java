package com.pontsuyo.tweet.analyzer.fetcher.config;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.pontsuyo.tweet.analyzer.fetcher.infrastructure.repository")
public class DynamoDBConfig {

  /**
   * AWS DynamoDBの設定 credential情報は環境変数に設定しておけばOK。参考↓
   *
   * @return
   * @see com.amazonaws.auth.DefaultAWSCredentialsProviderChain
   */
  @Bean
  public AmazonDynamoDB amazonDynamoDB() {
    return AmazonDynamoDBClientBuilder.standard()
        .withCredentials(DefaultAWSCredentialsProviderChain.getInstance())
        .withRegion(Regions.AP_NORTHEAST_1)
        .build();
  }
}
