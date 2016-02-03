package com.pioong;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Toast;
import com.crittercism.app.Crittercism;
import com.flurry.android.FlurryAgent;
import com.mocoplex.adlib.AdlibActivity;
import com.mocoplex.adlib.AdlibConfig;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseInstallation;
import com.parse.PushService;
import com.pioong.global.Network;
import com.pioong.global.Value;
import java.util.Locale;
import org.json.JSONObject;

public class IntroActivity
  extends AdlibActivity
{
  String lc;
  private Location mLoc = null;
  private boolean m_bFlag = false;
  private Handler m_hHandler;
  private LocationManager mlocManager;
  private Toast toast;
  
  protected void initAds()
  {
    AdlibConfig.getInstance().bindPlatform("ADMOB", "com.mocoplex.adlib.ads.SubAdlibAdViewAdmob");
    AdlibConfig.getInstance().bindPlatform("TAD", "com.mocoplex.adlib.ads.SubAdlibAdViewTAD");
    if (this.lc.equals("ko"))
    {
      AdlibConfig.getInstance().setAdlibKey("51b82369e4b05aca86e69d54");
      return;
    }
    AdlibConfig.getInstance().setAdlibKey("51ba8b89e4b05aca86e6a3f0");
  }
  
  public void onBackPressed()
  {
    if (!this.m_bFlag)
    {
      this.toast = Toast.makeText(getApplicationContext(), getString(2131034122), 0);
      this.toast.show();
      this.m_bFlag = true;
      this.m_hHandler.sendEmptyMessageDelayed(0, 4500L);
    }
    do
    {
      return;
      finish();
    } while (this.toast == null);
    this.toast.cancel();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903042);
    this.lc = getResources().getConfiguration().locale.getLanguage();
    initAds();
    FlurryAgent.onStartSession(this, "45YWRPDBR9HRFGMKQWQJ");
    Crittercism.init(getApplicationContext(), "51ba8558558d6a74aa000003", new JSONObject[0]);
    Parse.initialize(this, "jud2gHKZYlxVhu0SmFlLvz6L5cPNfby0s2GtzD44", "mv6Cr2QP83P9vIb2aBlLwh0jfjAHt7zTgrhB9yGE");
    PushService.setDefaultPushCallback(this, IntroActivity.class);
    if (this.lc.equals("ko"))
    {
      PushService.unsubscribe(this, "Other");
      PushService.subscribe(this, "Korea", IntroActivity.class);
    }
    for (;;)
    {
      ParseInstallation.getCurrentInstallation().saveInBackground();
      ParseAnalytics.trackAppOpened(getIntent());
      Network.getInstance().login(this);
      Value.getInstance().chkLocService(this);
      this.m_hHandler = new Handler()
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          if (paramAnonymousMessage.what == 0)
          {
            IntroActivity.this.m_bFlag = false;
            IntroActivity.this.toast = null;
          }
        }
      };
      return;
      PushService.unsubscribe(this, "Korea");
      PushService.subscribe(this, "Other", IntroActivity.class);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    FlurryAgent.onEndSession(this);
  }
  
  protected void onResume()
  {
    super.onResume();
    try
    {
      this.mlocManager = ((LocationManager)getSystemService("location"));
      this.mLoc = this.mlocManager.getLastKnownLocation("network");
      Value.getInstance().setLocation(this.mLoc);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.mLoc = null;
      }
    }
  }
  
  public void startChatting(View paramView)
  {
    startActivity(new Intent(this, ChattingActivity.class));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/pioong/IntroActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */