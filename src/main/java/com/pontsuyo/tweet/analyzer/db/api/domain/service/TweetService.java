package com.pontsuyo.tweet.analyzer.db.api.domain.service;

import com.pontsuyo.tweet.analyzer.db.api.domain.model.Tweet;
import com.pontsuyo.tweet.analyzer.db.api.domain.repository.TweetRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TweetService {

  private final TweetRepository tweetRepository;

  public TweetService(TweetRepository tweetRepository) {
    this.tweetRepository = tweetRepository;
  }

  public List<Tweet> get() {
    return tweetRepository.getTweets();
  }
}
