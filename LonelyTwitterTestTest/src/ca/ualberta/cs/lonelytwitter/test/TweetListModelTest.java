package ca.ualberta.cs.lonelytwitter.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.lonelytwitter.LonelyTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.TweetListModel;

public class TweetListModelTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {
	
	public TweetListModelTest() {
		super(LonelyTwitterActivity.class);
	}
	
	public void testFiveIsFive(){
		assertEquals(5, 5);
	}
	
	public void testTweetListModel(){
		TweetListModel tlm = new TweetListModel();
	}
	
	public void testAddTweet(){
		TweetListModel tlm = new TweetListModel();
		tlm.addTweet(new LonelyTweetModel("test"));
		assertTrue(tlm.getCount() == 1);
	}
	
	public void testRemoveTweet(){
		TweetListModel tlm = new TweetListModel();
		LonelyTweetModel lonelyTweet = new LonelyTweetModel("test");
		tlm.addTweet(lonelyTweet);
		assertTrue(tlm.getCount() == 1);
		tlm.removeTweet(lonelyTweet);
		assertTrue(tlm.getCount() == 0);
	}
	
	public void testGetCount(){
		TweetListModel tlm = new TweetListModel();
		Random rand = new Random();
		int randNum = rand.nextInt((10 - 1) + 1) + 1;
		int count;
		for(count = 0; count <= randNum; count++){
			tlm.addTweet(new LonelyTweetModel("test" + count));
		}
		assertEquals(count, tlm.getCount());
	}
	
	public void testGetTweets(){
		TweetListModel tlm = new TweetListModel();
		LonelyTweetModel currentLonelyTweet = new LonelyTweetModel("current", new Date());
		LonelyTweetModel pastLonelyTweet = new LonelyTweetModel("old", new Date(System.currentTimeMillis()-10000));
		LonelyTweetModel futureLonelyTweet = new LonelyTweetModel("new", new Date(System.currentTimeMillis()+10000));
		tlm.addTweet(currentLonelyTweet);
		tlm.addTweet(pastLonelyTweet);
		tlm.addTweet(futureLonelyTweet);
		ArrayList<LonelyTweetModel> ltm = tlm.getTweets();
		assertEquals(tlm.getCount(), ltm.size());
		long currentTime = 0;
		for(LonelyTweetModel tweet : ltm){
			assertTrue(currentTime < tweet.getTimestamp().getTime());
			currentTime=tweet.getTimestamp().getTime();
		}
	}
	
	public void testHasTweet(){
		TweetListModel tlm = new TweetListModel();
		LonelyTweetModel lonelyTweet = new LonelyTweetModel("test");
		LonelyTweetModel dontAddhisTweet = new LonelyTweetModel("don't add");
		tlm.addTweet(lonelyTweet);
		assertTrue(tlm.hasTweet(lonelyTweet));
		assertFalse(tlm.hasTweet(dontAddhisTweet));
	}
	
	public void testAddDuplicateTweet(){
		TweetListModel tlm = new TweetListModel();
		boolean threwException = false;
		tlm.addTweet(new LonelyTweetModel("test"));
		try{
			tlm.addTweet(new LonelyTweetModel("test"));
		}
		catch(IllegalArgumentException e){
			threwException = true;
		}
		assertTrue(tlm.getCount() == 1);
		assertTrue(threwException);
	}
}
