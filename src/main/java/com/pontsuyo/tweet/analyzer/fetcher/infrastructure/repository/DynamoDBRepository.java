package com.pontsuyo.tweet.analyzer.fetcher.infrastructure.repository;

import com.pontsuyo.tweet.analyzer.fetcher.infrastructure.model.InfraTweet;
import java.util.List;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface DynamoDBRepository extends CrudRepository<InfraTweet, Long> {
  List<InfraTweet> findAll();
}
