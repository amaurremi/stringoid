package com.jaysquared.games.whereishd.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import com.google.analytics.tracking.android.EasyTracker;
import com.jaysquared.games.whereishd.ApplicationManager;
import com.jaysquared.games.whereishd.GameManager;
import com.jaysquared.games.whereishd.utils.InAppSupportHelper;
import com.jaysquared.games.whereishd.utils.PayStatus;
import com.jaysquared.games.whereishd.utils.PersistantSettings;
import com.jaysquared.games.whereishd.utils.SLog;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubView;
import com.mopub.mobileads.MoPubView.BannerAdListener;

public class SingleDialogActivity
  extends Activity
  implements MoPubView.BannerAdListener
{
  private static final String LOG_TAG = SingleDialogActivity.class.getSimpleName();
  private ImageButton againButton;
  private String category_id = null;
  private Button feedbackButton;
  private TextView highScoreTextView;
  private TextView highScoreValueTextView;
  private int highscore;
  private ImageButton homeButton;
  private MoPubView moPubView = null;
  private RatingBar ratingBar;
  private Button removeButton;
  private TextView resultTextView;
  private TextView scoreTextView;
  private TextView scoreValueTextView;
  private String subtitle;
  private TextView subtitleTextView;
  private String title;
  private TextView titleTextView;
  
  private void SetupListeners()
  {
    this.removeButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        try
        {
          paramAnonymousView = new Intent("android.intent.action.VIEW");
          paramAnonymousView.setData(Uri.parse("market://details?id=com.jaysquared.games.whereishd.release"));
          SingleDialogActivity.this.startActivity(paramAnonymousView);
          return;
        }
        catch (ActivityNotFoundException paramAnonymousView)
        {
          SLog.d(SingleDialogActivity.LOG_TAG, "market works only on a device");
        }
      }
    });
    this.againButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        SLog.v(SingleDialogActivity.LOG_TAG, "againButton onClick()");
        paramAnonymousView = new Intent(SingleDialogActivity.this, GameActivity.class);
        Bundle localBundle = new Bundle();
        localBundle.putString("category_id", SingleDialogActivity.this.category_id);
        paramAnonymousView.putExtras(localBundle);
        SingleDialogActivity.this.setResult(90001, paramAnonymousView);
        SingleDialogActivity.this.finish();
      }
    });
    this.homeButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        SLog.v(SingleDialogActivity.LOG_TAG, "homeButton onClick()");
        paramAnonymousView = new Intent(SingleDialogActivity.this, MainMenuActivity.class);
        SingleDialogActivity.this.setResult(90001, paramAnonymousView);
        SingleDialogActivity.this.finish();
      }
    });
    this.feedbackButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        InAppSupportHelper.openSupportChannel(SingleDialogActivity.this);
      }
    });
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBannerClicked(MoPubView paramMoPubView) {}
  
  public void onBannerCollapsed(MoPubView paramMoPubView) {}
  
  public void onBannerExpanded(MoPubView paramMoPubView) {}
  
  public void onBannerFailed(MoPubView paramMoPubView, MoPubErrorCode paramMoPubErrorCode) {}
  
  public void onBannerLoaded(MoPubView paramMoPubView)
  {
    findViewById(2131230816).setVisibility(0);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    SLog.d(LOG_TAG, "Creating activity...");
    setContentView(2130903081);
    paramBundle = getIntent().getExtras();
    int i = paramBundle.getInt("score");
    this.highscore = paramBundle.getInt("highscore");
    this.title = paramBundle.getString("title");
    this.subtitle = paramBundle.getString("subtitle");
    this.category_id = paramBundle.getString("category_id");
    this.removeButton = ((Button)findViewById(2131230878));
    this.removeButton.setVisibility(4);
    this.feedbackButton = ((Button)findViewById(2131230815));
    this.againButton = ((ImageButton)findViewById(2131230879));
    this.homeButton = ((ImageButton)findViewById(2131230804));
    this.highScoreTextView = ((TextView)findViewById(2131230970));
    this.scoreValueTextView = ((TextView)findViewById(2131230969));
    this.highScoreValueTextView = ((TextView)findViewById(2131230971));
    this.scoreTextView = ((TextView)findViewById(2131230792));
    this.resultTextView = ((TextView)findViewById(2131230904));
    this.titleTextView = ((TextView)findViewById(2131230782));
    this.subtitleTextView = ((TextView)findViewById(2131230820));
    paramBundle = ApplicationManager.getInstance().getGameManager().getTypeface();
    this.scoreValueTextView.setTypeface(paramBundle);
    this.highScoreValueTextView.setTypeface(paramBundle);
    this.highScoreTextView.setTypeface(paramBundle);
    this.scoreTextView.setTypeface(paramBundle);
    this.resultTextView.setTypeface(paramBundle);
    this.titleTextView.setTypeface(paramBundle);
    this.subtitleTextView.setTypeface(paramBundle);
    this.removeButton.setTypeface(paramBundle);
    this.feedbackButton.setTypeface(paramBundle);
    this.highScoreValueTextView.setText(String.format("%,d", new Object[] { Integer.valueOf(this.highscore) }));
    this.scoreValueTextView.setText(String.format("%,d", new Object[] { Integer.valueOf(i) }));
    this.titleTextView.setText(this.title);
    this.subtitleTextView.setText(this.subtitle);
    SetupListeners();
    this.ratingBar = ((RatingBar)findViewById(2131230966));
    this.ratingBar.setEnabled(false);
    this.ratingBar.setMax(3);
    this.ratingBar.setNumStars(3);
    if (i < 120000) {
      this.ratingBar.setRating(0.0F);
    }
    while (ApplicationManager.getInstance().getSettings().getPayStatus() == PayStatus.NOADS)
    {
      this.removeButton.setVisibility(8);
      this.moPubView = ((MoPubView)findViewById(2131230817));
      return;
      if (i < 200000) {
        this.ratingBar.setRating(1.0F);
      } else if (i < 280000) {
        this.ratingBar.setRating(2.0F);
      } else if (i >= 280000) {
        this.ratingBar.setRating(3.0F);
      }
    }
    this.moPubView = ((MoPubView)findViewById(2131230817));
    this.moPubView.setAdUnitId("839ee51f8b814b948645d5f0268a1aae");
    this.moPubView.setBannerAdListener(this);
    this.moPubView.loadAd();
  }
  
  protected void onDestroy()
  {
    SLog.d(LOG_TAG, "Destroying activity...");
    if (this.moPubView != null) {
      this.moPubView.destroy();
    }
    super.onDestroy();
  }
  
  protected void onStart()
  {
    super.onStart();
    EasyTracker.getInstance(this).activityStart(this);
  }
  
  protected void onStop()
  {
    super.onStop();
    EasyTracker.getInstance(this).activityStop(this);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jaysquared/games/whereishd/ui/SingleDialogActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */