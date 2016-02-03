package com.getjar.sdk.rewards;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.getjar.sdk.comm.auth.AuthManager;
import com.getjar.sdk.comm.auth.ClaimsManager;
import com.getjar.sdk.config.GetJarConfig;
import com.getjar.sdk.config.SettingsManager.Scope;
import com.getjar.sdk.exceptions.UnauthorizedException;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import java.lang.reflect.Method;
import java.util.UUID;

public class ManagedPurchaseSubActivity
  extends GetJarWebViewSubActivity
{
  private final String _baseUrl;
  private volatile Integer _currentResultCode = null;
  private final JavaScriptAPI.JavaScriptCallbacks _javaScriptCallbacks = new JavaScriptAPI.JavaScriptCallbacks()
  {
    private final String _id = UUID.randomUUID().toString();
    
    public int compare(JavaScriptAPI.JavaScriptCallbacks paramAnonymousJavaScriptCallbacks1, JavaScriptAPI.JavaScriptCallbacks paramAnonymousJavaScriptCallbacks2)
    {
      return paramAnonymousJavaScriptCallbacks1.getUniqueId().compareTo(paramAnonymousJavaScriptCallbacks2.getUniqueId());
    }
    
    public boolean equals(Object paramAnonymousObject)
    {
      if ((paramAnonymousObject == null) || (!(paramAnonymousObject instanceof JavaScriptAPI.JavaScriptCallbacks))) {
        return false;
      }
      return getUniqueId().equals(((JavaScriptAPI.JavaScriptCallbacks)paramAnonymousObject).getUniqueId());
    }
    
    public String getUniqueId()
    {
      return this._id;
    }
    
    public int hashCode()
    {
      return getUniqueId().hashCode();
    }
    
    public void notifyOnError(String paramAnonymousString)
    {
      for (;;)
      {
        try
        {
          Logger.e(Area.UI.value(), "ManagedPurchaseSubActivity: _javaScriptCallbacks: notifyOnError() '%1$s'", new Object[] { paramAnonymousString });
          if (ManagedPurchaseSubActivity.this._currentResultCode == null)
          {
            if ("OFFER_LOOKUP_KEY_NOT_FOUND".equalsIgnoreCase(paramAnonymousString)) {
              ManagedPurchaseSubActivity.access$002(ManagedPurchaseSubActivity.this, Integer.valueOf(7));
            }
          }
          else
          {
            ManagedPurchaseSubActivity.this.getJarActivity.setResult(ManagedPurchaseSubActivity.this._currentResultCode.intValue());
            return;
          }
          if ("BAD_MARKETPLACE_COUNTRY_KEY".equalsIgnoreCase(paramAnonymousString))
          {
            ManagedPurchaseSubActivity.access$002(ManagedPurchaseSubActivity.this, Integer.valueOf(8));
            continue;
          }
          if (!"BAD_PRICING_BUCKETS".equalsIgnoreCase(paramAnonymousString)) {
            break label140;
          }
        }
        catch (Exception paramAnonymousString)
        {
          Logger.e(Area.UI.value(), paramAnonymousString, "ManagedPurchaseSubActivity: _javaScriptCallbacks: notifyOnError() failed", new Object[0]);
          return;
        }
        ManagedPurchaseSubActivity.access$002(ManagedPurchaseSubActivity.this, Integer.valueOf(9));
        continue;
        label140:
        if ("ALREADY_RESERVED".equalsIgnoreCase(paramAnonymousString)) {
          ManagedPurchaseSubActivity.access$002(ManagedPurchaseSubActivity.this, Integer.valueOf(15));
        } else if ("ALREADY_LICENSED".equalsIgnoreCase(paramAnonymousString)) {
          ManagedPurchaseSubActivity.access$002(ManagedPurchaseSubActivity.this, Integer.valueOf(10));
        } else if ("OUTSTANDING_REDEEM".equalsIgnoreCase(paramAnonymousString)) {
          ManagedPurchaseSubActivity.access$002(ManagedPurchaseSubActivity.this, Integer.valueOf(11));
        } else if ("MARKETPLACE".equalsIgnoreCase(paramAnonymousString)) {
          ManagedPurchaseSubActivity.access$002(ManagedPurchaseSubActivity.this, Integer.valueOf(12));
        } else if ("NETWORK".equalsIgnoreCase(paramAnonymousString)) {
          ManagedPurchaseSubActivity.access$002(ManagedPurchaseSubActivity.this, Integer.valueOf(13));
        } else if ("FUNDS_INSUFFICIENT_FAILURE".equalsIgnoreCase(paramAnonymousString)) {
          ManagedPurchaseSubActivity.access$002(ManagedPurchaseSubActivity.this, Integer.valueOf(14));
        } else {
          ManagedPurchaseSubActivity.access$002(ManagedPurchaseSubActivity.this, Integer.valueOf(4));
        }
      }
    }
    
    public void notifyOnLoaded(String paramAnonymousString)
    {
      Logger.d(Area.UI.value(), "ManagedPurchaseSubActivity: _javaScriptCallbacks: notifyOnLoaded() '%1$s'", new Object[] { paramAnonymousString });
    }
    
    public String toString()
    {
      return getUniqueId();
    }
  };
  private String _offerLookupKey = null;
  private final String _uiSpecifier;
  
  ManagedPurchaseSubActivity(GetJarActivity paramGetJarActivity, String paramString)
  {
    super(paramGetJarActivity, true);
    this._baseUrl = GetJarConfig.getInstance(paramGetJarActivity).getDirectiveValue("webview.managed_purchase_url", SettingsManager.Scope.CLIENT);
    this._uiSpecifier = paramString;
  }
  
  protected String getBaseUrl()
  {
    return this._baseUrl;
  }
  
  protected String getOfferLookupKey()
  {
    return this._offerLookupKey;
  }
  
  protected String getUiSpecifier()
  {
    return this._uiSpecifier;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this._allowWaitDialog = true;
    this._offerLookupKey = this.getJarActivity.getIntent().getStringExtra("offer_lookup_key");
    if (TextUtils.isEmpty(this._offerLookupKey))
    {
      Logger.e(Area.UI.value(), "ManagedPurchaseSubActivity: onCreate() no offer lookup key found", new Object[0]);
      this._currentResultCode = Integer.valueOf(7);
      this.getJarActivity.setResult(7);
      this.getJarActivity.finish();
    }
    do
    {
      return;
      super.onCreate(paramBundle);
      mWebView.setBackgroundColor(0);
    } while (Build.VERSION.SDK_INT < 11);
    try
    {
      View.class.getMethod("setLayerType", new Class[] { Integer.TYPE, Paint.class }).invoke(mWebView, new Object[] { Integer.valueOf(1), new Paint() });
      return;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.mJavaScriptInterface.unregisterCallbacks(this._javaScriptCallbacks);
  }
  
  public void onResume()
  {
    super.onResume();
    AuthManager.initialize(this.getJarActivity);
    if (!AuthManager.getInstance().getClaimsManager(this.getJarActivity).canPurchaseManagedProducts()) {
      throw new UnauthorizedException("The provided Application Token is not allowed to use Managed Purchase features");
    }
    this.mJavaScriptInterface.registerCallbacks(this._javaScriptCallbacks);
  }
  
  public void onStop()
  {
    try
    {
      Logger.d(Area.UI.value(), "ManagedPurchaseSubActivity: onStop() START [OfferLookupKey:'%1$s']", new Object[] { this._offerLookupKey });
      if (this._currentResultCode == null) {
        this._currentResultCode = Integer.valueOf(0);
      }
      Logger.d(Area.UI.value(), "ManagedPurchaseSubActivity: onStop() result is %1$d", new Object[] { this._currentResultCode });
      this.getJarActivity.setResult(this._currentResultCode.intValue());
      this._currentResultCode = null;
      super.onStop();
      return;
    }
    finally
    {
      Logger.d(Area.UI.value(), "ManagedPurchaseSubActivity: onStop() FINISH", new Object[0]);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/rewards/ManagedPurchaseSubActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */