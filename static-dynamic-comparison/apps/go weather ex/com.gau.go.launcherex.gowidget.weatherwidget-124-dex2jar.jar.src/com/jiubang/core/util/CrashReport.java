package com.jiubang.core.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.gtp.a.a.b.c;

public class CrashReport
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  protected static final String LOG_TAG = "ACRA";
  public static final int NOTIF_CRASH_ID = 666;
  private static final String PRERFERENCE_KEY = "pref_key_report";
  public static final String RES_DIALOG_COMMENT_PROMPT = "RES_DIALOG_COMMENT_PROMPT";
  public static final String RES_DIALOG_ICON = "RES_DIALOG_ICON";
  public static final String RES_DIALOG_OK_TOAST = "RES_DIALOG_OK_TOAST";
  public static final String RES_DIALOG_TEXT = "RES_DIALOG_TEXT";
  public static final String RES_DIALOG_TITLE = "RES_DIALOG_TITLE";
  public static final String RES_NOTIF_ICON = "RES_NOTIF_ICON";
  public static final String RES_NOTIF_TEXT = "RES_NOTIF_TEXT";
  public static final String RES_NOTIF_TICKER_TEXT = "RES_NOTIF_TICKER_TEXT";
  public static final String RES_NOTIF_TITLE = "RES_NOTIF_TITLE";
  public static final String RES_TOAST_TEXT = "RES_TOAST_TEXT";
  private Context mApp = null;
  SharedPreferences mSharedPreferences = null;
  
  private SharedPreferences getACRASharedPreferences()
  {
    return PreferenceManager.getDefaultSharedPreferences(this.mApp);
  }
  
  private void initAcra()
  {
    c.a("ACRA", "ACRA is enabled for " + this.mApp.getPackageName() + ", intializing...");
    ErrorReporter localErrorReporter = ErrorReporter.getInstance();
    localErrorReporter.setFormUri(getFormUri());
    localErrorReporter.setReportingInteractionMode(getReportingInteractionMode());
    localErrorReporter.setCrashResources(getCrashResources());
    localErrorReporter.init(this.mApp.getApplicationContext());
    localErrorReporter.checkReportsOnApplicationStart();
  }
  
  public Bundle getCrashResources()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("RES_NOTIF_ICON", 17301624);
    localBundle.putInt("RES_NOTIF_TICKER_TEXT", 2131165486);
    localBundle.putInt("RES_NOTIF_TITLE", 2131165487);
    localBundle.putInt("RES_NOTIF_TEXT", 2131165488);
    localBundle.putInt("RES_DIALOG_ICON", 17301659);
    localBundle.putInt("RES_DIALOG_TITLE", 2131165489);
    localBundle.putInt("RES_DIALOG_TEXT", 2131165490);
    return localBundle;
  }
  
  public String getFormId()
  {
    return "dEM4SDNGX0tvaDVxSjk0NVM5ZTl4Y3c6MQ";
  }
  
  public Uri getFormUri()
  {
    return Uri.parse("http://spreadsheets.google.com/formResponse?formkey=" + getFormId() + "&amp;ifq");
  }
  
  ReportingInteractionMode getReportingInteractionMode()
  {
    return ReportingInteractionMode.NOTIFICATION;
  }
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    if ("pref_key_report".equals(paramString)) {
      paramSharedPreferences = Boolean.valueOf(false);
    }
    try
    {
      boolean bool = this.mSharedPreferences.getBoolean("pref_key_report", true);
      paramSharedPreferences = Boolean.valueOf(bool);
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
    if (paramSharedPreferences.booleanValue())
    {
      initAcra();
      return;
    }
    ErrorReporter.getInstance().disable();
  }
  
  public void start(Context paramContext)
  {
    this.mApp = paramContext;
    this.mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext.getApplicationContext());
    this.mSharedPreferences.registerOnSharedPreferenceChangeListener(this);
    initAcra();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/util/CrashReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */