package com.example.ttrizza.twittsafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.*;
import com.twitter.sdk.android.core.identity.*;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Fabric;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;
public class MainActivity extends AppCompatActivity {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "wiZuSfV0du7PSPRpFDAUUHqYS";
    private static final String TWITTER_SECRET = "rBQ51SEm1T6L1hZRlDqf6wcIGFObcHxgfxwEbM843Fkupz9knQ";


    private TwitterLoginButton loginButton;
    private Button fireButton;
    private Button buttonFlood;
    private Button buttonAccident;
    private Button buttonRiots;
    private Button buttonWild;
    private Button buttonRob;
    private Button buttonSaveTXT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //TwitterAuthConfig authConfig =  new TwitterAuthConfig("consumerKey", "consumerSecret");
        // Fabric.with(this, new TwitterCore(authConfig), new TweetComposer());

        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig), new TweetComposer());
        setContentView(R.layout.activity_main);





        fireButton = (Button) findViewById(R.id.buttonFire);
        fireButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                composeTweet();
            }
        });

        buttonFlood = (Button) findViewById(R.id.buttonFlood);
        buttonFlood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                composeTweet1();
            }
        });

        buttonAccident = (Button) findViewById(R.id.buttonAccident);
        buttonAccident.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                composeTweet2();
            }
        });

        buttonRiots = (Button) findViewById(R.id.buttonRiots);
        buttonRiots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                composeTweet3();
            }
        });

        buttonWild = (Button) findViewById(R.id.buttonWild);
        buttonWild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                composeTweet4();
            }
        });

        buttonRob = (Button) findViewById(R.id.buttonRob);
        buttonRob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                composeTweet5();
            }
        });


        loginButton = (TwitterLoginButton) findViewById(R.id.twitter_login_button);
        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                // The TwitterSession is also available through:
                // Twitter.getInstance().core.getSessionManager().getActiveSession()
                TwitterSession session = result.data;
                // TODO: Remove toast and use the TwitterSession's userID
                // with your app's user model
                String msg = "@" + session.getUserName() + " logged in! (#" + session.getUserId() + ")";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }


            @Override
            public void failure(TwitterException exception) {
                Log.d("TwitterKit", "Login with Twitter failure", exception);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Make sure that the loginButton hears the result from any
        // Activity that it triggered.
        loginButton.onActivityResult(requestCode, resultCode, data);

    }


    public void composeTweet() {
        TweetComposer.Builder builder = new TweetComposer.Builder(this)
                .text("I'm on fire!! Please help @AlernLangert @anto_Tonyz @MugiluriDiPeppa @alf_deetacs #@FireBrigade  " );
               // .image(myImageUri);
        builder.show();
    }

    public void composeTweet1() {
        TweetComposer.Builder builder = new TweetComposer.Builder(this)
                .text("I'm on drowning in floods!! Please help @AlernLangert @anto_Tonyz @MugiluriDiPeppa @alf_deetacs #@Elnino_Org  " );
        // .image(myImageUri);
        builder.show();
    }

    public void composeTweet2() {
        TweetComposer.Builder builder = new TweetComposer.Builder(this)
                .text("Accident alert!! Please help @AlernLangert @anto_Tonyz @MugiluriDiPeppa @alf_deetacs #@St. johns " );
        // .image(myImageUri);
        builder.show();
    }

    public void composeTweet3() {
        TweetComposer.Builder builder = new TweetComposer.Builder(this)
                .text("Riots Alert!! Please help @AlernLangert @anto_Tonyz @MugiluriDiPeppa @alf_deetacs #@gsu  " );
        // .image(myImageUri);
        builder.show();
    }

    public void composeTweet4() {
        TweetComposer.Builder builder = new TweetComposer.Builder(this)
                .text("Wildlife On The Loose!! Please help @AlernLangert @anto_Tonyz @MugiluriDiPeppa @alf_deetacs #@kws " );
        // .image(myImageUri);
        builder.show();
    }

    public void composeTweet5() {
        TweetComposer.Builder builder = new TweetComposer.Builder(this)
                .text("Robbery alert!! Please help @AlernLangert @anto_Tonyz @MugiluriDiPeppa @alf_deetacs #@Police  " );
        // .image(myImageUri);
        builder.show();
    }


}