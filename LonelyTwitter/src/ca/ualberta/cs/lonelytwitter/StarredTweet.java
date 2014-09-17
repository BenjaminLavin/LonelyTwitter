package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class StarredTweet extends AbstractTweet{

	public StarredTweet(Date tweetDate, String tweetBody) {
		super();
		this.tweetDate = tweetDate;
		this.tweetBody = tweetBody;
	}

	public String getTweetBody() {
		return "\u2605 " + tweetBody;
	}

	public String toString() {
		return getTweetBody();
	}

}
