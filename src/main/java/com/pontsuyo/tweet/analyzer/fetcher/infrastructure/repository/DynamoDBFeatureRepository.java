package com.pontsuyo.tweet.analyzer.fetcher.infrastructure.repository;

import com.pontsuyo.tweet.analyzer.fetcher.infrastructure.model.TweetFeature;
import java.util.List;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface DynamoDBFeatureRepository extends CrudRepository<TweetFeature, Long> {

  List<TweetFeature> findAll();
}
