package com.pontsuyo.tweet.analyzer.fetcher.domain.service;

import com.pontsuyo.tweet.analyzer.fetcher.domain.model.Tweet;
import com.pontsuyo.tweet.analyzer.fetcher.infrastructure.repository.DynamoDBRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class TweetService {

  private final DynamoDBRepository dynamoDBRepository;

  public TweetService(DynamoDBRepository dynamoDBRepository) {
    this.dynamoDBRepository = dynamoDBRepository;
  }

  public List<Tweet> get() {
    return dynamoDBRepository.findAll().stream()
        .map(Tweet::fromInfraTweet)
        .collect(Collectors.toList());
  }
}
