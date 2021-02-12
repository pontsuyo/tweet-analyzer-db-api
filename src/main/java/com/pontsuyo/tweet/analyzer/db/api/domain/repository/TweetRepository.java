package com.pontsuyo.tweet.analyzer.db.api.domain.repository;


import com.pontsuyo.tweet.analyzer.db.api.domain.model.Tweet;
import java.util.List;

public interface TweetRepository {
  List<Tweet> getTweets();
}
