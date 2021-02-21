package com.pontsuyo.tweet.analyzer.fetcher.infrastructure.repository;

import com.pontsuyo.tweet.analyzer.fetcher.infrastructure.model.TweetScore;
import com.pontsuyo.tweet.analyzer.fetcher.infrastructure.model.TweetScore.TweetScoreId;
import java.util.List;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface DynamoDBScoreRepository extends CrudRepository<TweetScore, TweetScoreId> {

  List<TweetScore> findAll();
}
