package com.jaysquared.games.whereishd.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.analytics.tracking.android.EasyTracker;
import com.jaysquared.games.whereishd.ApplicationManager;
import com.jaysquared.games.whereishd.GameManager;
import com.jaysquared.games.whereishd.utils.AppPreferences;
import com.jaysquared.games.whereishd.utils.DisplaySize;
import com.jaysquared.games.whereishd.utils.InAppSupportHelper;
import com.jaysquared.games.whereishd.utils.PayStatus;
import com.jaysquared.games.whereishd.utils.PersistantSettings;
import com.jaysquared.games.whereishd.utils.PlayerScore;
import com.jaysquared.games.whereishd.utils.SLog;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubView;
import com.mopub.mobileads.MoPubView.BannerAdListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class MultiResultActivity
  extends Activity
  implements MoPubView.BannerAdListener
{
  private static final String LOG_TAG = MultiResultActivity.class.getSimpleName();
  private ImageButton againButton;
  private AppPreferences appPref;
  private String category_id = null;
  private Button feedbackButton;
  private ImageButton homeButton;
  private MoPubView moPubView = null;
  private TextView[] namesTxt;
  private Button removeButton;
  private TextView resultTextView;
  private TextView[] scoresTxt;
  private ArrayList<String> set;
  private String subtitle;
  private TextView subtitleTextView;
  private String title;
  private TextView titleTextView;
  private SurfaceView viewSurface2;
  private SurfaceView viewSurface2_120;
  private SurfaceView viewSurface3;
  private SurfaceView viewSurface3_120;
  private SurfaceView viewSurface3_80;
  
  private void SetListeners()
  {
    this.removeButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        try
        {
          paramAnonymousView = new Intent("android.intent.action.VIEW");
          paramAnonymousView.setData(Uri.parse("market://details?id=com.jaysquared.games.whereishd.release"));
          MultiResultActivity.this.startActivity(paramAnonymousView);
          return;
        }
        catch (ActivityNotFoundException paramAnonymousView)
        {
          SLog.d("market", "works only on a device");
        }
      }
    });
    this.againButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(MultiResultActivity.this, GameActivity.class);
        Bundle localBundle = new Bundle();
        localBundle.putString("play", "multiplayer");
        localBundle.putString("category_id", MultiResultActivity.this.category_id);
        paramAnonymousView.putExtras(localBundle);
        MultiResultActivity.this.setResult(90001, paramAnonymousView);
        MultiResultActivity.this.finish();
      }
    });
    this.homeButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(MultiResultActivity.this, MainMenuActivity.class);
        MultiResultActivity.this.setResult(90001, paramAnonymousView);
        MultiResultActivity.this.finish();
      }
    });
    this.feedbackButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        InAppSupportHelper.openSupportChannel(MultiResultActivity.this);
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
    setContentView(2130903077);
    Object localObject = getIntent().getExtras();
    this.title = ((Bundle)localObject).getString("title");
    this.subtitle = ((Bundle)localObject).getString("subtitle");
    this.category_id = ((Bundle)localObject).getString("category_id");
    this.scoresTxt = new TextView[10];
    this.namesTxt = new TextView[10];
    this.scoresTxt[0] = ((TextView)findViewById(2131230918));
    this.scoresTxt[1] = ((TextView)findViewById(2131230915));
    this.scoresTxt[2] = ((TextView)findViewById(2131230923));
    this.scoresTxt[3] = ((TextView)findViewById(2131230933));
    this.scoresTxt[4] = ((TextView)findViewById(2131230934));
    this.scoresTxt[5] = ((TextView)findViewById(2131230935));
    this.scoresTxt[6] = ((TextView)findViewById(2131230936));
    this.scoresTxt[7] = ((TextView)findViewById(2131230937));
    this.scoresTxt[8] = ((TextView)findViewById(2131230938));
    this.scoresTxt[9] = ((TextView)findViewById(2131230939));
    this.namesTxt[0] = ((TextView)findViewById(2131230908));
    this.namesTxt[1] = ((TextView)findViewById(2131230907));
    this.namesTxt[2] = ((TextView)findViewById(2131230909));
    this.namesTxt[3] = ((TextView)findViewById(2131230925));
    this.namesTxt[4] = ((TextView)findViewById(2131230926));
    this.namesTxt[5] = ((TextView)findViewById(2131230927));
    this.namesTxt[6] = ((TextView)findViewById(2131230928));
    this.namesTxt[7] = ((TextView)findViewById(2131230929));
    this.namesTxt[8] = ((TextView)findViewById(2131230930));
    this.namesTxt[9] = ((TextView)findViewById(2131230931));
    int i = 0;
    if (i < this.scoresTxt.length)
    {
      this.scoresTxt[i].setTypeface(ApplicationManager.getInstance().getGameManager().getTypeface());
      if (i < 3) {
        this.scoresTxt[i].setTextSize(30.0F);
      }
      for (;;)
      {
        i += 1;
        break;
        this.scoresTxt[i].setTextSize(16.0F);
      }
    }
    i = 0;
    while (i < this.namesTxt.length)
    {
      this.namesTxt[i].setTypeface(ApplicationManager.getInstance().getGameManager().getTypeface());
      this.namesTxt[i].setTextSize(16.0F);
      i += 1;
    }
    this.appPref = new AppPreferences(getApplicationContext());
    this.set = new ArrayList();
    this.set = this.appPref.getMember();
    SLog.d("set", "set =" + this.set);
    paramBundle = new ArrayList();
    i = 0;
    while (i < this.set.size())
    {
      paramBundle.add(new PlayerScore(i, (int)((Bundle)localObject).getDouble("value" + i), (String)this.set.get(i)));
      i += 1;
    }
    Collections.sort(paramBundle, new Comparator()
    {
      public int compare(PlayerScore paramAnonymousPlayerScore1, PlayerScore paramAnonymousPlayerScore2)
      {
        return paramAnonymousPlayerScore2.getScore() - paramAnonymousPlayerScore1.getScore();
      }
    });
    localObject = paramBundle.iterator();
    while (((Iterator)localObject).hasNext())
    {
      PlayerScore localPlayerScore = (PlayerScore)((Iterator)localObject).next();
      SLog.d("SCORES", "Index: " + localPlayerScore.getIndex() + " Score: " + localPlayerScore.getScore() + " Name: " + localPlayerScore.getName());
    }
    i = 0;
    while (i < this.set.size())
    {
      this.scoresTxt[i].setText(Integer.toString(((PlayerScore)paramBundle.get(i)).getScore()));
      this.scoresTxt[i].setVisibility(0);
      i += 1;
    }
    i = 0;
    while (i < this.set.size())
    {
      this.namesTxt[i].setText(((PlayerScore)paramBundle.get(i)).getName());
      this.namesTxt[i].setVisibility(0);
      i += 1;
    }
    this.viewSurface2 = ((SurfaceView)findViewById(2131230912));
    this.viewSurface2_120 = ((SurfaceView)findViewById(2131230913));
    this.viewSurface3 = ((SurfaceView)findViewById(2131230920));
    this.viewSurface3_120 = ((SurfaceView)findViewById(2131230921));
    this.viewSurface3_80 = ((SurfaceView)findViewById(2131230922));
    if (paramBundle.size() == 2) {
      if (((PlayerScore)paramBundle.get(0)).getScore() == ((PlayerScore)paramBundle.get(1)).getScore())
      {
        this.viewSurface2.setVisibility(8);
        this.viewSurface2_120.setVisibility(0);
      }
    }
    for (;;)
    {
      if (ApplicationManager.getInstance().getGameManager().getDisplaySize() == DisplaySize.NORMAL) {
        ((LinearLayout)findViewById(2131230852)).setVisibility(8);
      }
      this.feedbackButton = ((Button)findViewById(2131230815));
      this.againButton = ((ImageButton)findViewById(2131230879));
      this.homeButton = ((ImageButton)findViewById(2131230804));
      this.resultTextView = ((TextView)findViewById(2131230904));
      this.subtitleTextView = ((TextView)findViewById(2131230820));
      this.removeButton = ((Button)findViewById(2131230878));
      this.removeButton.setVisibility(4);
      paramBundle = ApplicationManager.getInstance().getGameManager().getTypeface();
      this.titleTextView = ((TextView)findViewById(2131230782));
      this.resultTextView.setTypeface(paramBundle);
      this.titleTextView.setTypeface(paramBundle);
      this.subtitleTextView.setTypeface(paramBundle);
      this.feedbackButton.setTypeface(paramBundle);
      this.removeButton.setTypeface(paramBundle);
      SetListeners();
      this.titleTextView.setText(this.title);
      this.subtitleTextView.setText(this.subtitle);
      if (ApplicationManager.getInstance().getSettings().getPayStatus() != PayStatus.NOADS) {
        break;
      }
      this.removeButton.setVisibility(8);
      this.moPubView = ((MoPubView)findViewById(2131230817));
      return;
      if ((((PlayerScore)paramBundle.get(0)).getScore() == ((PlayerScore)paramBundle.get(1)).getScore()) && (((PlayerScore)paramBundle.get(0)).getScore() == ((PlayerScore)paramBundle.get(2)).getScore()))
      {
        this.viewSurface2.setVisibility(8);
        this.viewSurface2_120.setVisibility(0);
        this.viewSurface3.setVisibility(8);
        this.viewSurface3_120.setVisibility(0);
      }
      else if (((PlayerScore)paramBundle.get(0)).getScore() == ((PlayerScore)paramBundle.get(1)).getScore())
      {
        this.viewSurface2.setVisibility(8);
        this.viewSurface2_120.setVisibility(0);
      }
      else if (((PlayerScore)paramBundle.get(1)).getScore() == ((PlayerScore)paramBundle.get(2)).getScore())
      {
        this.viewSurface3.setVisibility(8);
        this.viewSurface3_80.setVisibility(0);
      }
    }
    this.moPubView = ((MoPubView)findViewById(2131230817));
    this.moPubView.setBannerAdListener(this);
    this.moPubView.setAdUnitId("839ee51f8b814b948645d5f0268a1aae");
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jaysquared/games/whereishd/ui/MultiResultActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */