package com.pontsuyo.tweet.analyzer.db.api.controller;

import com.pontsuyo.tweet.analyzer.db.api.domain.model.Tweet;
import com.pontsuyo.tweet.analyzer.db.api.domain.service.TweetService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TweetController {

  private final TweetService tweetService;

  public TweetController(TweetService tweetService) {
    this.tweetService = tweetService;
  }

  /**
   * Cassandra twifavから現在格納されているtweetを全て取得する．
   *
   * @return いいねtweetのリスト
   */
  @GetMapping(path = "/get")
  @ResponseBody
  public ResponseEntity<List<Tweet>> findAll() {
    return ResponseEntity.ok().body(tweetService.get());
  }

}
