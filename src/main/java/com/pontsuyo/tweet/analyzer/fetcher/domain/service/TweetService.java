package com.pontsuyo.tweet.analyzer.fetcher.domain.service;

import com.pontsuyo.tweet.analyzer.fetcher.domain.model.Tweet;
import com.pontsuyo.tweet.analyzer.fetcher.infrastructure.model.ScoreLists;
import com.pontsuyo.tweet.analyzer.fetcher.infrastructure.repository.DynamoDBFeatureRepository;
import com.pontsuyo.tweet.analyzer.fetcher.infrastructure.repository.DynamoDBScoreRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class TweetService {

  private final DynamoDBFeatureRepository dynamoDBFeatureRepository;
  private final DynamoDBScoreRepository dynamoDBScoreRepository;

  public TweetService(
      DynamoDBFeatureRepository dynamoDBFeatureRepository,
      DynamoDBScoreRepository dynamoDBScoreRepository) {
    this.dynamoDBFeatureRepository = dynamoDBFeatureRepository;
    this.dynamoDBScoreRepository = dynamoDBScoreRepository;
  }

  public List<Tweet> get() {
    var scores = dynamoDBScoreRepository.findAll();

    // store score fields in each field
    var tweets = dynamoDBFeatureRepository.findAll().stream()
        .map(feature -> {
          var tweetId = feature.getTweetId();
          var tweetScoreList = scores.stream()
              .filter(score -> score.getTweetId().equals(tweetId))
              .collect(Collectors.toList());

          var scoreLists = ScoreLists.list2scores(tweetScoreList);

          return Tweet.assembleFeatureAndScore(feature, scoreLists);
        })
        .collect(Collectors.toList());

    return tweets;
  }
}
