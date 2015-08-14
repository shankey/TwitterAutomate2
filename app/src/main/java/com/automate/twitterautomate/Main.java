package com.automate.twitterautomate;

import android.os.AsyncTask;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

/**
 * Created by aditya on 11/08/15.
 */
public class Main extends AsyncTask<Void, Void, Void> {

    private static final String TWITTER_KEY = "ExHisnogNbJJbUIawTdtIByN9";
    private static final String TWITTER_SECRET = "NVo0aoGz1sPtt4gbeVmpELJd9TlXf9eU7GK3XbUoSZAjWQaId8";

    public  void main2()  throws TwitterException {
        TwitterFactory factory = new TwitterFactory();
        AccessToken accessToken = loadAccessToken(1);
        Twitter twitter = factory.getInstance();
        twitter.setOAuthConsumer(TWITTER_KEY, TWITTER_SECRET);
        twitter.setOAuthAccessToken(accessToken);
        twitter4j.Status status = twitter.updateStatus("update from twitter4j");
        System.out.println("Successfully updated the status to [" + status.getText() + "].");

    }

    private static AccessToken loadAccessToken(int useId){
        String token = "87388689-SepUV6J2DrowcQj0Zy4BU7qd5YyHpu0BrKF9sFPch";  // load from a persistent store
        String tokenSecret = "ZgYjbB9eZ0IHgVGeQZaNEQh1n2CU0YAFoJuNeFxqeUXMD"; // load from a persistent store
        return new AccessToken(token, tokenSecret);
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            main2();
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return null;
    }
}
