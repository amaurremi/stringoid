package com.bubble.tapjoy;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.widget.Toast;
import com.bubble.tapjoy.utils.TapjoyState;
import com.tapjoy.TapjoyConnect;
import com.tapjoy.TapjoyConnectNotifier;
import com.tapjoy.TapjoyEarnedPointsNotifier;
import com.tapjoy.TapjoyNotifier;
import com.tapjoy.TapjoyVideoNotifier;
import com.tapjoy.TapjoyViewNotifier;
import java.util.Hashtable;

public class TapjoySupport
{
  public static final String TAPJOY_POINT_TOTAL_KEY = "TAPJOY_POINT_TOTAL_KEY";
  private Activity activity;
  private Context context;
  private boolean shouldTransition;
  private TapjoyConnectNotifier tapjoyConnectNotifier;
  private TapjoyEarnedPointsNotifier tapjoyEarnedPointsNotifier;
  private TapjoyNotifier tapjoyNotifier;
  
  public TapjoySupport(TapjoyEarnedPointsNotifier paramTapjoyEarnedPointsNotifier, Activity paramActivity)
  {
    this.tapjoyEarnedPointsNotifier = paramTapjoyEarnedPointsNotifier;
    this.context = paramActivity.getApplicationContext();
    this.activity = paramActivity;
  }
  
  private void requestTapjpoyConnect()
  {
    Hashtable localHashtable = new Hashtable();
    TapjoyConnect.requestTapjoyConnect(this.context, getTapjoyAppId(), getTapjoySecret(), localHashtable, this.tapjoyConnectNotifier);
  }
  
  private void test(final String paramString)
  {
    this.activity.runOnUiThread(new Runnable()
    {
      public void run()
      {
        Toast.makeText(TapjoySupport.this.context, paramString, 1).show();
      }
    });
  }
  
  protected void connect()
  {
    if (TapjoyState.isTapjoyCheckEnable(this.context)) {}
    try
    {
      if (this.tapjoyNotifier == null) {
        this.tapjoyNotifier = new TapjoyNotifier()
        {
          public void getUpdatePoints(String paramAnonymousString, int paramAnonymousInt)
          {
            paramAnonymousString = PreferenceManager.getDefaultSharedPreferences(TapjoySupport.this.context);
            int i = paramAnonymousString.getInt("TAPJOY_POINT_TOTAL_KEY", -1);
            if (i == -1)
            {
              paramAnonymousString = paramAnonymousString.edit();
              paramAnonymousString.putInt("TAPJOY_POINT_TOTAL_KEY", paramAnonymousInt);
              paramAnonymousString.commit();
            }
            do
            {
              return;
              i = paramAnonymousInt - i;
            } while (i <= 0);
            TapjoySupport.this.tapjoyEarnedPointsNotifier.earnedTapPoints(i);
            paramAnonymousString = paramAnonymousString.edit();
            paramAnonymousString.putInt("TAPJOY_POINT_TOTAL_KEY", paramAnonymousInt);
            paramAnonymousString.commit();
          }
          
          public void getUpdatePointsFailed(String paramAnonymousString) {}
        };
      }
      if (this.tapjoyConnectNotifier == null) {
        this.tapjoyConnectNotifier = new TapjoyConnectNotifier()
        {
          public void connectFail() {}
          
          public void connectSuccess()
          {
            TapjoyConnect.getTapjoyConnectInstance().setTapjoyViewNotifier(new TapjoyViewNotifier()
            {
              public void viewDidClose(int paramAnonymous2Int)
              {
                TapjoyConnect.getTapjoyConnectInstance().getTapPoints(TapjoySupport.this.tapjoyNotifier);
              }
              
              public void viewDidOpen(int paramAnonymous2Int) {}
              
              public void viewWillClose(int paramAnonymous2Int) {}
              
              public void viewWillOpen(int paramAnonymous2Int) {}
            });
            TapjoyConnect.getTapjoyConnectInstance().setVideoNotifier(new TapjoyVideoNotifier()
            {
              public void videoComplete()
              {
                TapjoyConnect.getTapjoyConnectInstance().getTapPoints(TapjoySupport.this.tapjoyNotifier);
              }
              
              public void videoError(int paramAnonymous2Int) {}
              
              public void videoStart() {}
            });
          }
        };
      }
      requestTapjpoyConnect();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void enableTapjoy()
  {
    TapjoyState.enableTapjoy(this.context);
  }
  
  protected String getTapjoyAppId()
  {
    int i = this.context.getResources().getIdentifier("TAP_JOY_APP_ID", "string", this.context.getPackageName());
    return this.context.getString(i);
  }
  
  protected String getTapjoySecret()
  {
    int i = this.context.getResources().getIdentifier("TAP_JOY_APP_SECRET", "string", this.context.getPackageName());
    return this.context.getString(i);
  }
  
  public void onPause()
  {
    if (TapjoyState.isTapjoyCheckEnable(this.context)) {}
    try
    {
      TapjoyConnect.getTapjoyConnectInstance().enableDisplayAdAutoRefresh(false);
      if (!this.shouldTransition) {
        TapjoyConnect.getTapjoyConnectInstance().appPause();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onResume()
  {
    if (TapjoyState.isTapjoyCheckEnable(this.context)) {
      try
      {
        TapjoyConnect localTapjoyConnect2 = TapjoyConnect.getTapjoyConnectInstance();
        TapjoyConnect localTapjoyConnect1 = localTapjoyConnect2;
        if (localTapjoyConnect2 == null)
        {
          connect();
          localTapjoyConnect1 = TapjoyConnect.getTapjoyConnectInstance();
        }
        localTapjoyConnect1.enableDisplayAdAutoRefresh(true);
        if (this.shouldTransition) {
          this.shouldTransition = false;
        }
        for (;;)
        {
          localTapjoyConnect1.getTapPoints(this.tapjoyNotifier);
          return;
          localTapjoyConnect1.appResume();
        }
        return;
      }
      catch (Exception localException) {}
    }
  }
  
  public void showOffers()
  {
    TapjoyConnect.getTapjoyConnectInstance().showOffers();
    this.shouldTransition = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bubble/tapjoy/TapjoySupport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */