package com.pontsuyo.tweet.analyzer.fetcher.domain.repository;


import com.pontsuyo.tweet.analyzer.fetcher.domain.model.Tweet;
import java.util.List;

public interface TweetRepository {
  List<Tweet> getTweets();
}
