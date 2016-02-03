package com.bluebird.mobile.tools.rate;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.bluebird.mobile.tools.R.id;
import com.bluebird.mobile.tools.R.style;
import com.bluebird.mobile.tools.net.NetUtils;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.Tracker;

public class AppRate
{
  private static Long getFirstDateLaunchAndSetIfNotPresent(SharedPreferences paramSharedPreferences, SharedPreferences.Editor paramEditor, long paramLong)
  {
    Long localLong = Long.valueOf(paramSharedPreferences.getLong("date_firstlaunch", 0L));
    paramSharedPreferences = localLong;
    if (localLong.longValue() == 0L)
    {
      paramSharedPreferences = Long.valueOf(paramLong);
      paramEditor.putLong("date_firstlaunch", paramSharedPreferences.longValue());
    }
    return paramSharedPreferences;
  }
  
  private static boolean shouldShowAfterDelay(AppRateConfiguration paramAppRateConfiguration, SharedPreferences paramSharedPreferences, long paramLong)
  {
    return paramLong - paramSharedPreferences.getLong("last_prompt", 0L) > paramAppRateConfiguration.getNextShowDelayInHours() * 60 * 60 * 1000;
  }
  
  public static void show(Activity paramActivity)
  {
    show(paramActivity, new AppRateConfiguration());
  }
  
  public static void show(Activity paramActivity, AppRateConfiguration paramAppRateConfiguration)
  {
    Object localObject = paramActivity.getSharedPreferences("apprater", 0);
    if (((SharedPreferences)localObject).getBoolean("dontshowagain", false)) {
      return;
    }
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
    long l1 = System.currentTimeMillis();
    long l2 = ((SharedPreferences)localObject).getLong("launch_count", 0L) + 1L;
    localEditor.putLong("launch_count", l2);
    boolean bool = shouldShowAfterDelay(paramAppRateConfiguration, (SharedPreferences)localObject, l1);
    localObject = getFirstDateLaunchAndSetIfNotPresent((SharedPreferences)localObject, localEditor, l1);
    if ((l2 >= paramAppRateConfiguration.getLaunchesUntilPrompt()) && (l1 >= ((Long)localObject).longValue() + paramAppRateConfiguration.getDaysUntilPrompt() * 24 * 60 * 60 * 1000) && ((!paramAppRateConfiguration.isShowOnlineOnly()) || ((paramAppRateConfiguration.isShowOnlineOnly()) && (NetUtils.isOnline(paramActivity)))) && (bool))
    {
      showDialog(paramActivity, localEditor, paramAppRateConfiguration);
      localEditor.putLong("last_prompt", l1);
    }
    localEditor.commit();
  }
  
  protected static void showDialog(Activity paramActivity, final SharedPreferences.Editor paramEditor, final AppRateConfiguration paramAppRateConfiguration)
  {
    try
    {
      final Dialog localDialog = new Dialog(paramActivity, R.style.PauseDialog);
      localDialog.requestWindowFeature(1);
      localDialog.setContentView(paramAppRateConfiguration.getDialogLayout());
      ((TextView)localDialog.findViewById(R.id.rate_app_header_text)).setText(Html.fromHtml(paramAppRateConfiguration.getHeaderText()));
      ((Button)localDialog.findViewById(R.id.rate_app_button)).setOnClickListener(new View.OnClickListener()
      {
        private String getRateURI()
        {
          String str2 = paramAppRateConfiguration.getRateURI();
          String str1 = str2;
          if (str2 == null) {
            str1 = "market://details?id=" + this.val$activity.getApplicationContext().getPackageName();
          }
          return str1;
        }
        
        public void onClick(View paramAnonymousView)
        {
          EasyTracker.getTracker().trackEvent("App Rate", "Button Clicked", "'Rate now' button", Long.valueOf(0L));
          this.val$activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getRateURI())));
          paramEditor.putBoolean("dontshowagain", true);
          paramEditor.commit();
          localDialog.dismiss();
        }
      });
      ((Button)localDialog.findViewById(R.id.rate_remind_button)).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          EasyTracker.getTracker().trackEvent("App Rate", "Button Clicked", "'Remind me later' button", Long.valueOf(0L));
          this.val$dialog.dismiss();
        }
      });
      ((Button)localDialog.findViewById(R.id.rate_cancel_button)).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          EasyTracker.getTracker().trackEvent("App Rate", "Button Clicked", "'No, thanks' button", Long.valueOf(0L));
          if (this.val$editor != null)
          {
            this.val$editor.putBoolean("dontshowagain", true);
            this.val$editor.commit();
          }
          localDialog.dismiss();
        }
      });
      localDialog.show();
      return;
    }
    catch (Exception paramActivity)
    {
      Log.e("ChainOfWords", "unable to add rate window", paramActivity);
      try
      {
        EasyTracker.getTracker().trackEvent("App Rate", "Error", "Error", null);
        return;
      }
      catch (Exception paramActivity) {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/bluebird/mobile/tools/rate/AppRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */