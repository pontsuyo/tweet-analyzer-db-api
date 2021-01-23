package com.pontsuyo.tweet.analyzer.db.api.repository;

import com.pontsuyo.tweet.analyzer.db.api.domain.model.Tweet;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class TweetRepository {

  public List<Tweet> get(){
    // ここAurora接続
    return List.of(new Tweet(), new Tweet());
  }
}
