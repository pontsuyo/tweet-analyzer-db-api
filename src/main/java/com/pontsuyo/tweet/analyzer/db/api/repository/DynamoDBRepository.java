package com.pontsuyo.tweet.analyzer.db.api.repository;

import com.pontsuyo.tweet.analyzer.db.api.domain.model.Tweet;
import com.pontsuyo.tweet.analyzer.db.api.domain.repository.TweetRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class DynamoDBRepository implements TweetRepository {

  public List<Tweet> getTweets() {
    return List.of(new Tweet(), new Tweet());
  }
}
