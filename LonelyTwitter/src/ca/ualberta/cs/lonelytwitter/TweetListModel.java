package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TweetListModel {

	private ArrayList<LonelyTweetModel> mTweets;
	
	public TweetListModel(){
		super();
		mTweets = new ArrayList<LonelyTweetModel>();
	}
	
	public void addTweet(LonelyTweetModel ltm){

		if(hasTweet(ltm)){
			throw new IllegalArgumentException();
		}
		else{
			mTweets.add(ltm);
		} 
	}
	
	public int getCount(){
		return mTweets.size();
	}
	
	public ArrayList<LonelyTweetModel> getTweets(){
		Collections.sort(mTweets, new Comparator<LonelyTweetModel>() {

			public int compare(LonelyTweetModel lhs, LonelyTweetModel rhs) {
				return lhs.getTimestamp().compareTo(rhs.getTimestamp());
			}
		});
		return mTweets;
	}
	
	public void removeTweet(LonelyTweetModel lonelyTweet){
		mTweets.remove(lonelyTweet);
	}
	
	public boolean hasTweet(LonelyTweetModel lonelyTweet){
		return mTweets.contains(lonelyTweet);
	}

}
