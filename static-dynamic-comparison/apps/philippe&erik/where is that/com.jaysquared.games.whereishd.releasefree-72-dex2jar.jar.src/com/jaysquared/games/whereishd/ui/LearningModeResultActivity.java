package com.jaysquared.games.whereishd.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.analytics.tracking.android.EasyTracker;
import com.jaysquared.games.whereishd.ApplicationManager;
import com.jaysquared.games.whereishd.GameManager;
import com.jaysquared.games.whereishd.db.Categories;
import com.jaysquared.games.whereishd.db.CategoriesUserdata;
import com.jaysquared.games.whereishd.db.DatabaseManager;
import com.jaysquared.games.whereishd.utils.DisplaySize;
import com.jaysquared.games.whereishd.utils.InAppSupportHelper;
import com.jaysquared.games.whereishd.utils.PayStatus;
import com.jaysquared.games.whereishd.utils.PersistantSettings;
import com.jaysquared.games.whereishd.utils.SLog;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubView;
import com.mopub.mobileads.MoPubView.BannerAdListener;

public class LearningModeResultActivity
  extends Activity
  implements MoPubView.BannerAdListener
{
  private static final String LOG_TAG = LearningModeResultActivity.class.getSimpleName();
  private ImageButton againButton;
  private String category_id;
  private Button feedbackButton;
  private ImageButton homeButton;
  private TextView mainTitleTextView;
  private TextView missedTextView1;
  private TextView missedTextView2;
  private TextView missedTextViewValue1;
  private TextView missedTextViewValue2;
  private MoPubView moPubView = null;
  private TextView ratioTextView1;
  private TextView ratioTextView2;
  private TextView ratioTextViewValue1;
  private TextView ratioTextViewValue2;
  private Button removeButton;
  private TextView roundsTextView;
  private TextView roundsTextView1;
  private TextView roundsTextView2;
  private TextView roundsTextViewValue1;
  private TextView roundsTextViewValue2;
  private String string_round_missed_learning;
  private String string_round_rounds_learning;
  private String string_round_succesRatio;
  private String string_total_missed_learning;
  private String string_total_rounds_learning;
  private String string_total_succesRatio;
  private String subtitle;
  private TextView subtitleTextView;
  private String title;
  private TextView titleTextView;
  private TextView totalTextView;
  
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
          LearningModeResultActivity.this.startActivity(paramAnonymousView);
          return;
        }
        catch (ActivityNotFoundException paramAnonymousView)
        {
          SLog.d(LearningModeResultActivity.LOG_TAG, "market works only on a device");
        }
      }
    });
    this.againButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ApplicationManager.getInstance().getGameManager().setShouldResetLearning(true);
        paramAnonymousView = new Intent(LearningModeResultActivity.this, GameActivity.class);
        Bundle localBundle = new Bundle();
        localBundle.putString("category_id", LearningModeResultActivity.this.category_id);
        paramAnonymousView.putExtras(localBundle);
        LearningModeResultActivity.this.setResult(90001, paramAnonymousView);
        LearningModeResultActivity.this.finish();
      }
    });
    this.homeButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(LearningModeResultActivity.this, MainMenuActivity.class);
        LearningModeResultActivity.this.setResult(90001, paramAnonymousView);
        LearningModeResultActivity.this.finish();
      }
    });
    this.feedbackButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        InAppSupportHelper.openSupportChannel(LearningModeResultActivity.this);
      }
    });
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
    setContentView(2130903072);
    paramBundle = getIntent().getExtras();
    this.string_round_rounds_learning = paramBundle.getString("string_round_rounds_learning");
    this.string_round_missed_learning = paramBundle.getString("string_round_missed_learning");
    this.string_round_succesRatio = paramBundle.getString("string_round_succesRatio");
    this.string_total_rounds_learning = paramBundle.getString("string_total_rounds_learning");
    this.string_total_missed_learning = paramBundle.getString("string_total_missed_learning");
    this.string_total_succesRatio = paramBundle.getString("string_total_succesRatio");
    this.title = paramBundle.getString("title");
    this.subtitle = paramBundle.getString("subtitle");
    this.category_id = paramBundle.getString("category_id");
    paramBundle = DatabaseManager.getInstance().getCategory(this.category_id).getUserdata();
    this.roundsTextView = ((TextView)findViewById(2131230856));
    this.titleTextView = ((TextView)findViewById(2131230782));
    this.titleTextView.setText(this.title);
    this.subtitleTextView = ((TextView)findViewById(2131230820));
    this.subtitleTextView.setText(this.subtitle);
    this.mainTitleTextView = ((TextView)findViewById(2131230854));
    this.feedbackButton = ((Button)findViewById(2131230815));
    this.removeButton = ((Button)findViewById(2131230878));
    this.removeButton.setVisibility(4);
    this.againButton = ((ImageButton)findViewById(2131230879));
    this.homeButton = ((ImageButton)findViewById(2131230804));
    this.roundsTextView1 = ((TextView)findViewById(2131230859));
    this.missedTextView1 = ((TextView)findViewById(2131230860));
    this.ratioTextView1 = ((TextView)findViewById(2131230861));
    this.roundsTextViewValue1 = ((TextView)findViewById(2131230863));
    this.missedTextViewValue1 = ((TextView)findViewById(2131230864));
    this.ratioTextViewValue1 = ((TextView)findViewById(2131230865));
    this.totalTextView = ((TextView)findViewById(2131230867));
    this.roundsTextView2 = ((TextView)findViewById(2131230870));
    this.missedTextView2 = ((TextView)findViewById(2131230871));
    this.ratioTextView2 = ((TextView)findViewById(2131230872));
    this.roundsTextViewValue2 = ((TextView)findViewById(2131230873));
    this.missedTextViewValue2 = ((TextView)findViewById(2131230874));
    this.ratioTextViewValue2 = ((TextView)findViewById(2131230875));
    Object localObject = ApplicationManager.getInstance().getGameManager().getTypeface();
    this.roundsTextView.setTypeface((Typeface)localObject);
    this.titleTextView.setTypeface((Typeface)localObject);
    this.subtitleTextView.setTypeface((Typeface)localObject);
    this.mainTitleTextView.setTypeface((Typeface)localObject);
    this.feedbackButton.setTypeface((Typeface)localObject);
    this.removeButton.setTypeface((Typeface)localObject);
    this.roundsTextView1.setTypeface((Typeface)localObject);
    this.missedTextView1.setTypeface((Typeface)localObject);
    this.ratioTextView1.setTypeface((Typeface)localObject);
    this.roundsTextViewValue1.setTypeface((Typeface)localObject);
    this.missedTextViewValue1.setTypeface((Typeface)localObject);
    this.ratioTextViewValue1.setTypeface((Typeface)localObject);
    this.totalTextView.setTypeface((Typeface)localObject);
    this.roundsTextView2.setTypeface((Typeface)localObject);
    this.missedTextView2.setTypeface((Typeface)localObject);
    this.ratioTextView2.setTypeface((Typeface)localObject);
    this.roundsTextViewValue2.setTypeface((Typeface)localObject);
    this.missedTextViewValue2.setTypeface((Typeface)localObject);
    this.ratioTextViewValue2.setTypeface((Typeface)localObject);
    this.roundsTextViewValue1.setText(this.string_round_rounds_learning);
    this.missedTextViewValue1.setText(this.string_round_missed_learning);
    this.ratioTextViewValue1.setText(this.string_round_succesRatio + " %");
    this.roundsTextViewValue2.setText(this.string_total_rounds_learning);
    this.missedTextViewValue2.setText(this.string_total_missed_learning);
    this.ratioTextViewValue2.setText(this.string_total_succesRatio + " %");
    if (ApplicationManager.getInstance().getSettings().getPayStatus() == PayStatus.NOADS)
    {
      this.removeButton.setVisibility(8);
      this.moPubView = ((MoPubView)findViewById(2131230817));
    }
    for (;;)
    {
      localObject = ApplicationManager.getInstance().getGameManager().getDisplaySize();
      if ((localObject == DisplaySize.NORMAL) || (localObject == DisplaySize.SMALL)) {
        ((LinearLayout)findViewById(2131230852)).setVisibility(8);
      }
      if (paramBundle.getLocations() == 0) {
        this.againButton.setEnabled(false);
      }
      SetupListeners();
      return;
      this.moPubView = ((MoPubView)findViewById(2131230817));
      this.moPubView.setBannerAdListener(this);
      this.moPubView.setAdUnitId("839ee51f8b814b948645d5f0268a1aae");
      this.moPubView.loadAd();
    }
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jaysquared/games/whereishd/ui/LearningModeResultActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */