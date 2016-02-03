package com.jaysquared.games.whereishd.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
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

@SuppressLint({"SetJavaScriptEnabled"})
public class InfoDialogActivity
  extends Activity
  implements MoPubView.BannerAdListener
{
  private static final String LOG_TAG = InfoDialogActivity.class.getSimpleName();
  private Button feedbackButton;
  private TextView mainText;
  private MoPubView moPubView = null;
  private Button quitButton;
  
  private void SetupListeners()
  {
    this.quitButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        InfoDialogActivity.this.setResult(-1);
        InfoDialogActivity.this.finish();
      }
    });
    this.feedbackButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        InAppSupportHelper.openSupportChannel(InfoDialogActivity.this);
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
    setContentView(2130903068);
    this.quitButton = ((Button)findViewById(2131230813));
    this.mainText = ((TextView)findViewById(2131230814));
    this.feedbackButton = ((Button)findViewById(2131230815));
    this.mainText.setTypeface(ApplicationManager.getInstance().getGameManager().getTypeface());
    this.feedbackButton.setTypeface(ApplicationManager.getInstance().getGameManager().getTypeface());
    paramBundle = Html.fromHtml(getString(2131427446));
    this.mainText.setText(paramBundle);
    SetupListeners();
    if (ApplicationManager.getInstance().getSettings().getPayStatus() == PayStatus.NOADS)
    {
      this.moPubView = ((MoPubView)findViewById(2131230817));
      return;
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jaysquared/games/whereishd/ui/InfoDialogActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */