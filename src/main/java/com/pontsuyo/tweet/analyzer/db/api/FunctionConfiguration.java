package com.pontsuyo.tweet.analyzer.db.api;

import com.pontsuyo.tweet.analyzer.db.api.domain.model.Tweet;
import com.pontsuyo.tweet.analyzer.db.api.domain.service.TweetService;
import java.util.List;
import java.util.function.Function;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FunctionConfiguration {

  private final TweetService tweetService;

  public FunctionConfiguration(TweetService tweetService) {
    this.tweetService = tweetService;
  }

  public static void main(String[] args) {
    SpringApplication.run(FunctionConfiguration.class, args);
  }

  @Bean
  public Function<Long, List<Tweet>> getTweet() {
    return id -> tweetService.get();
  }
}
