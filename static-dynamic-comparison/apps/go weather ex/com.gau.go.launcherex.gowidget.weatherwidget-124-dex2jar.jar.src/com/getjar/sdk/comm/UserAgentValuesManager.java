package com.getjar.sdk.comm;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.getjar.sdk.comm.auth.AuthMetadataUtility;
import com.getjar.sdk.exceptions.CommunicationException;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.ManualResetEvent;
import com.getjar.sdk.utilities.OverridesUtility;
import com.getjar.sdk.utilities.StringUtility;
import com.getjar.sdk.utilities.Utility;

public class UserAgentValuesManager
{
  private static volatile UserAgentValuesManager _Instance = null;
  private static final String _PrefsKeyUserAgent = "UserAgent";
  private volatile String _sdkUserAgent = null;
  private Object _sdkUserAgentLock = new Object();
  private ManualResetEvent _uiWorkEvent = new ManualResetEvent(false);
  private volatile String _webKitUserAgent = null;
  private Object _webKitUserAgentLock = new Object();
  
  public static UserAgentValuesManager getInstance()
  {
    if (_Instance == null) {
      makeTheInstance();
    }
    return _Instance;
  }
  
  private String getWebKitUserAgentInternal(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("Must have a valid context.");
    }
    return new WebView(paramContext).getSettings().getUserAgentString();
  }
  
  private static void makeTheInstance()
  {
    try
    {
      if (_Instance == null) {
        _Instance = new UserAgentValuesManager();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getSdkUserAgent(Context paramContext)
  {
    if (StringUtility.isNullOrEmpty(this._sdkUserAgent)) {}
    synchronized (this._sdkUserAgentLock)
    {
      StringBuilder localStringBuilder;
      if (StringUtility.isNullOrEmpty(this._sdkUserAgent))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("GetJarSDK");
        localStringBuilder.append("/");
        localStringBuilder.append("20140923.02");
        localStringBuilder.append(" (");
        localStringBuilder.append(AuthMetadataUtility.SDK_LEVEL);
        localStringBuilder.append(") ");
      }
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getApplicationContext().getPackageName(), 0);
        localStringBuilder.append(paramContext.packageName).append("/").append(paramContext.versionCode);
        localStringBuilder.append(" ").append("android").append("/").append(Build.VERSION.RELEASE).append(" (").append(Build.BRAND).append("; ").append(Build.PRODUCT).append("; ").append(Build.MODEL).append(")");
        this._sdkUserAgent = localStringBuilder.toString();
        Logger.i(Area.COMM.value(), "SDK User Agent value: '%1$s'", new Object[] { this._sdkUserAgent });
        return this._sdkUserAgent;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          localStringBuilder.append("unknown/0000");
        }
      }
    }
  }
  
  public String getWebKitUserAgent(final Context paramContext)
  {
    Logger.v(Area.COMM.value(), "UserAgentValuesManager: getWebKitUserAgent() START", new Object[0]);
    final Object localObject2;
    try
    {
      if (!StringUtility.isNullOrEmpty(this._webKitUserAgent)) {
        break label410;
      }
      synchronized (this._webKitUserAgentLock)
      {
        if (!StringUtility.isNullOrEmpty(this._webKitUserAgent)) {
          break label408;
        }
        Logger.v(Area.COMM.value(), "UserAgentValuesManager: getWebKitUserAgent() checking overrides", new Object[0]);
        OverridesUtility.initialize(paramContext);
        localObject2 = OverridesUtility.getValue("webkit.user.agent");
        if (!StringUtility.isNullOrEmpty((String)localObject2))
        {
          Logger.v(Area.COMM.value(), "[*** OVERRIDE ***] Override value being used: 'webkit.user.agent' = '%1$s'", new Object[] { localObject2 });
          return (String)localObject2;
        }
        Logger.v(Area.COMM.value(), "UserAgentValuesManager: getWebKitUserAgent() checking shared prefs", new Object[0]);
        localObject2 = paramContext.getSharedPreferences("GetJarClientPrefs", 0);
        if (((SharedPreferences)localObject2).contains("UserAgent")) {
          this._webKitUserAgent = ((SharedPreferences)localObject2).getString("UserAgent", "");
        }
        if (!StringUtility.isNullOrEmpty(this._webKitUserAgent)) {
          break label385;
        }
        Logger.v(Area.COMM.value(), "UserAgentValuesManager: getWebKitUserAgent() creating WebView instance", new Object[0]);
        if (!Utility.isCurrentThreadTheUIThread())
        {
          Logger.v(Area.COMM.value(), "UserAgentValuesManager: getWebKitUserAgent() sending work to the UI thread", new Object[0]);
          this._uiWorkEvent.close();
          new Handler(paramContext.getMainLooper()).post(new Runnable()
          {
            public void run()
            {
              Logger.v(Area.COMM.value(), "UserAgentValuesManager: getWebKitUserAgent() work starting on UI thread", new Object[0]);
              try
              {
                UserAgentValuesManager.access$002(UserAgentValuesManager.this, UserAgentValuesManager.this.getWebKitUserAgentInternal(paramContext));
                if (!StringUtility.isNullOrEmpty(UserAgentValuesManager.this._webKitUserAgent)) {
                  localObject2.edit().putString("UserAgent", UserAgentValuesManager.this._webKitUserAgent).commit();
                }
                return;
              }
              catch (Exception localException)
              {
                Logger.e(Area.COMM.value(), localException, "UserAgentValuesManager: getWebKitUserAgent() failed", new Object[0]);
                return;
              }
              finally
              {
                Logger.v(Area.COMM.value(), "UserAgentValuesManager: getWebKitUserAgent() work finished on UI thread", new Object[0]);
                UserAgentValuesManager.this._uiWorkEvent.open();
              }
            }
          });
          try
          {
            Logger.v(Area.COMM.value(), "UserAgentValuesManager: getWebKitUserAgent() waiting for UI thread work", new Object[0]);
            this._uiWorkEvent.waitForOpen(250L);
            if (!StringUtility.isNullOrEmpty(this._webKitUserAgent)) {
              break label352;
            }
            Logger.v(Area.COMM.value(), "UserAgentValuesManager: getWebKitUserAgent() failed to get value from UI thread work, returning empty string", new Object[0]);
            return "";
          }
          catch (InterruptedException paramContext)
          {
            throw new CommunicationException(paramContext);
          }
        }
      }
      this._webKitUserAgent = getWebKitUserAgentInternal(paramContext);
    }
    finally
    {
      Logger.v(Area.COMM.value(), "UserAgentValuesManager: getWebKitUserAgent() FINISHED", new Object[0]);
    }
    label352:
    if (!StringUtility.isNullOrEmpty(this._webKitUserAgent)) {
      ((SharedPreferences)localObject2).edit().putString("UserAgent", this._webKitUserAgent).commit();
    }
    label385:
    Logger.i(Area.COMM.value(), "WebKit User Agent value: '%1$s'", new Object[] { this._webKitUserAgent });
    label408:
    label410:
    paramContext = this._webKitUserAgent;
    Logger.v(Area.COMM.value(), "UserAgentValuesManager: getWebKitUserAgent() FINISHED", new Object[0]);
    return paramContext;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/comm/UserAgentValuesManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */