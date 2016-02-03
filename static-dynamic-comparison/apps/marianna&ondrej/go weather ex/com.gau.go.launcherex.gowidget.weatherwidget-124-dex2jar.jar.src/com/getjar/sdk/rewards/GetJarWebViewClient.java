package com.getjar.sdk.rewards;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Message;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.getjar.sdk.comm.CommContext;
import com.getjar.sdk.config.GetJarConfig;
import com.getjar.sdk.config.SettingsManager.Scope;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.NotificationsUtility;
import com.getjar.sdk.utilities.NotificationsUtility.NotificationType;
import com.getjar.sdk.utilities.RewardUtility;
import com.getjar.sdk.utilities.StringUtility;
import com.getjar.sdk.utilities.Utility;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class GetJarWebViewClient
  extends WebViewClient
{
  private GetJarWebViewSubActivity _parentActivity = null;
  CommContext mCommContext;
  Context mContext;
  
  public GetJarWebViewClient(GetJarWebViewSubActivity paramGetJarWebViewSubActivity, CommContext paramCommContext)
  {
    this.mContext = paramGetJarWebViewSubActivity.getParentActivity();
    this.mCommContext = paramCommContext;
    this._parentActivity = paramGetJarWebViewSubActivity;
  }
  
  public static void saveUrl(String paramString, CommContext paramCommContext, Context paramContext)
  {
    try
    {
      if ((!shouldFilterUrl(paramString)) && (Utility.convertMillSec(Long.parseLong(GetJarConfig.getInstance(paramCommContext, true).getDirectiveValue("webview.saved_url.ttl", SettingsManager.Scope.CLIENT))) > 0L)) {
        RewardUtility.saveWebUrlData(paramContext, paramString);
      }
      return;
    }
    catch (Exception paramCommContext)
    {
      Logger.e(Area.STORAGE.value(), paramCommContext, "saveUrl(%1$s) failed", new Object[] { paramString });
    }
  }
  
  private static boolean shouldFilterUrl(String paramString)
  {
    String str = paramString;
    for (;;)
    {
      int i;
      try
      {
        Object localObject2 = new URL(paramString);
        str = paramString;
        Object localObject1 = ((URL)localObject2).getQuery();
        str = paramString;
        paramString = String.format(Locale.US, "%1$s://%2$s%3$s", new Object[] { ((URL)localObject2).getProtocol(), ((URL)localObject2).getAuthority(), ((URL)localObject2).getPath() });
        str = paramString;
        Logger.d(Area.CONFIG.value(), "shouldFilterUrl(%1$s)", new Object[] { paramString });
        str = paramString;
        if (!StringUtility.isNullOrEmpty((String)localObject1))
        {
          str = paramString;
          localObject1 = ((String)localObject1).split("&");
          str = paramString;
          int j = localObject1.length;
          i = 0;
          if (i < j)
          {
            str = paramString;
            localObject2 = localObject1[i].split("=");
            str = paramString;
            if (localObject2.length < 2) {
              break label209;
            }
            str = paramString;
            if (!localObject2[0].equalsIgnoreCase("override.header.Cache-Control")) {
              break label209;
            }
            str = paramString;
            boolean bool = localObject2[1].equalsIgnoreCase("no-cache");
            if (!bool) {
              break label209;
            }
            return true;
          }
        }
        return false;
      }
      catch (MalformedURLException paramString)
      {
        Logger.e(Area.CONFIG.value(), paramString, "shouldFilterUrl(%1$s) failed", new Object[] { str });
        return false;
      }
      label209:
      i += 1;
    }
  }
  
  public void onFormResubmission(WebView paramWebView, Message paramMessage1, Message paramMessage2)
  {
    try
    {
      Logger.d(Area.UI.value() | Area.OS_ENTRY_POINT.value(), "GetJarWebViewClient: onFormResubmission()", new Object[0]);
      paramMessage2.sendToTarget();
      return;
    }
    catch (Exception paramWebView)
    {
      Logger.e(Area.UI.value() | Area.OS_ENTRY_POINT.value(), paramWebView, "GetJarWebViewClient: onFormResubmission() failed", new Object[0]);
    }
  }
  
  public void onLoadResource(WebView paramWebView, String paramString)
  {
    try
    {
      Logger.i(Area.UI.value() | Area.OS_ENTRY_POINT.value(), "GetJarWebViewClient: onLoadResource() Loading Resource '%1$s'", new Object[] { paramString });
      return;
    }
    catch (Exception paramWebView)
    {
      Logger.e(Area.UI.value() | Area.OS_ENTRY_POINT.value(), paramWebView, "GetJarWebViewClient: onLoadResource() failed", new Object[0]);
    }
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    try
    {
      Logger.d(Area.UI.value() | Area.OS_ENTRY_POINT.value(), "GetJarWebViewClient: onPageFinished() URL:%1$s", new Object[] { paramString });
      if (this._parentActivity.getShouldShowLoadingUI())
      {
        Logger.d(Area.UI.value() | Area.OS_ENTRY_POINT.value(), "GetJarWebViewClient: onPageFinished() Setting ShouldShowLoadingUI to FALSE", new Object[0]);
        this._parentActivity.setShouldShowLoadingUI(false);
      }
      this._parentActivity.waitDialogHide();
      this._parentActivity.mJavaScriptInterface.setLastReloadTime();
      CookieSyncManager.getInstance().sync();
      if (!paramString.equals("file:///android_asset/errorMessage.html")) {
        break label264;
      }
      if (GetJarWebViewSubActivity.sErrorSource.mErrorType == GetJarWebViewSubActivity.ErrorType.NETWORK)
      {
        GetJarWebViewSubActivity.loadUrlInWebView(paramWebView, "javascript:GJ.onError(\"NETWORK\",\"" + GetJarWebViewSubActivity.sErrorSource.mSubCode + "\")");
        return;
      }
      if (GetJarWebViewSubActivity.sErrorSource.mErrorType == GetJarWebViewSubActivity.ErrorType.AUTH)
      {
        GetJarWebViewSubActivity.loadUrlInWebView(paramWebView, "javascript:GJ.onError(\"AUTH\",\"" + GetJarWebViewSubActivity.sErrorSource.mSubCode + "\")");
        return;
      }
    }
    catch (Exception paramWebView)
    {
      Logger.e(Area.UI.value() | Area.OS_ENTRY_POINT.value(), paramWebView, "GetJarWebViewClient: onPageFinished() failed", new Object[0]);
      return;
    }
    if (GetJarWebViewSubActivity.sErrorSource.mErrorType == GetJarWebViewSubActivity.ErrorType.SERVICE)
    {
      GetJarWebViewSubActivity.loadUrlInWebView(paramWebView, "javascript:GJ.onError(\"SERVICE\",\"" + GetJarWebViewSubActivity.sErrorSource.mSubCode + "\")");
      return;
      label264:
      if ((!"file:///android_asset/errorMessage.html".equals(paramWebView.getUrl())) && (this._parentActivity.getNotificationTypesToClearOnLoad() != null)) {
        paramWebView = this._parentActivity.getNotificationTypesToClearOnLoad().iterator();
      }
    }
    for (;;)
    {
      if (paramWebView.hasNext()) {
        paramString = (NotificationsUtility.NotificationType)paramWebView.next();
      }
      switch (paramString)
      {
      case ???: 
        NotificationsUtility.clearRedeemNotification(this.mContext);
        continue;
        return;
      }
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    try
    {
      Logger.d(Area.UI.value() | Area.OS_ENTRY_POINT.value(), "GetJarWebViewClient: onPageStarted()", new Object[0]);
      this._parentActivity.waitDialogHide();
      return;
    }
    catch (Exception paramWebView)
    {
      Logger.e(Area.UI.value() | Area.OS_ENTRY_POINT.value(), paramWebView, "GetJarWebViewClient: onPageStarted() failed", new Object[0]);
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    try
    {
      Logger.d(Area.UI.value() | Area.OS_ENTRY_POINT.value(), "GetJarWebViewClient: onReceivedError() Error while loading URL '%1$s' [errorCode:%2$d description:%3$s]", new Object[] { paramString2, Integer.valueOf(paramInt), paramString1 });
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      this._parentActivity.setShouldShowLoadingUI(false);
      this._parentActivity.waitDialogHide();
      GetJarWebViewSubActivity.loadUrlInWebView(paramWebView, "file:///android_asset/errorMessage.html");
      return;
    }
    catch (Exception paramWebView)
    {
      Logger.e(Area.UI.value() | Area.OS_ENTRY_POINT.value(), paramWebView, "GetJarWebViewClient: onReceivedError() failed", new Object[0]);
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    try
    {
      Logger.d(Area.UI.value() | Area.OS_ENTRY_POINT.value(), "GetJarWebViewClient: shouldOverrideUrlLoading() OverrideURl: %1$s", new Object[] { paramString });
      if (!paramString.equals("file:///android_asset/errorMessage.html")) {
        saveUrl(paramString, this.mCommContext, this.mContext);
      }
      GetJarWebViewSubActivity.loadUrlInWebView(paramWebView, paramString);
      return true;
    }
    catch (Exception paramWebView)
    {
      Logger.e(Area.UI.value() | Area.OS_ENTRY_POINT.value(), paramWebView, "GetJarWebViewClient: shouldOverrideUrlLoading() failed", new Object[0]);
    }
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/rewards/GetJarWebViewClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */