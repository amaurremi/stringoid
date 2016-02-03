package com.getjar.sdk.rewards;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.getjar.sdk.data.usage.AnalyticsManager;
import com.getjar.sdk.exceptions.AuthException;
import com.getjar.sdk.exceptions.UnauthorizedException;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.GlobalActivityRegistrar;
import com.getjar.sdk.utilities.StringUtility;
import java.util.UUID;

public class GetJarActivity
  extends Activity
{
  private String _activityInstanceId = null;
  private GetJarSubActivity _getJarSubActivity = null;
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    try
    {
      this._getJarSubActivity.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    catch (UnauthorizedException paramIntent)
    {
      Logger.e(Area.OS_ENTRY_POINT.value() | Area.UI.value(), paramIntent, "GetJarActivity: onActivityResult() failed", new Object[0]);
      setResult(5);
      finish();
      return;
    }
    catch (AuthException paramIntent)
    {
      Logger.e(Area.OS_ENTRY_POINT.value() | Area.UI.value(), paramIntent, "GetJarActivity: onActivityResult() failed", new Object[0]);
      setResult(3);
      finish();
      return;
    }
    catch (Exception paramIntent)
    {
      Logger.e(Area.OS_ENTRY_POINT.value() | Area.UI.value(), paramIntent, "GetJarActivity: onActivityResult() failed", new Object[0]);
      setResult(4);
      finish();
    }
  }
  
  public void onBackPressed()
  {
    try
    {
      this._getJarSubActivity.onBackPressed();
      return;
    }
    catch (UnauthorizedException localUnauthorizedException)
    {
      Logger.e(Area.OS_ENTRY_POINT.value() | Area.UI.value(), localUnauthorizedException, "GetJarActivity: onBackPressed() failed", new Object[0]);
      setResult(5);
      finish();
      return;
    }
    catch (AuthException localAuthException)
    {
      Logger.e(Area.OS_ENTRY_POINT.value() | Area.UI.value(), localAuthException, "GetJarActivity: onBackPressed() failed", new Object[0]);
      setResult(3);
      finish();
      return;
    }
    catch (Exception localException)
    {
      Logger.e(Area.OS_ENTRY_POINT.value() | Area.UI.value(), localException, "GetJarActivity: onBackPressed() failed", new Object[0]);
      setResult(4);
      finish();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    try
    {
      this._getJarSubActivity.onConfigurationChanged(paramConfiguration);
      return;
    }
    catch (UnauthorizedException paramConfiguration)
    {
      Logger.e(Area.OS_ENTRY_POINT.value() | Area.UI.value(), paramConfiguration, "GetJarActivity: onConfigurationChanged() failed", new Object[0]);
      setResult(5);
      finish();
      return;
    }
    catch (AuthException paramConfiguration)
    {
      Logger.e(Area.OS_ENTRY_POINT.value() | Area.UI.value(), paramConfiguration, "GetJarActivity: onConfigurationChanged() failed", new Object[0]);
      setResult(3);
      finish();
      return;
    }
    catch (Exception paramConfiguration)
    {
      Logger.e(Area.OS_ENTRY_POINT.value() | Area.UI.value(), paramConfiguration, "GetJarActivity: onConfigurationChanged() failed", new Object[0]);
      setResult(4);
      finish();
    }
  }
  
  @SuppressLint({"NewApi"})
  protected void onCreate(Bundle paramBundle)
  {
    Logger.i(Area.OS_ENTRY_POINT.value() | Area.UI.value(), "GetJarActivity: onCreate() START", new Object[0]);
    for (;;)
    {
      String str1;
      String str2;
      try
      {
        AnalyticsManager.getInstance(getApplicationContext()).startSession(this);
        super.onCreate(paramBundle);
        localStringBuilder = new StringBuilder("onCreate");
        GlobalActivityRegistrar.getInstance().registerActivity(this);
        localClass = null;
        if (this._getJarSubActivity != null) {
          localClass = this._getJarSubActivity.getClass();
        }
        if (!StringUtility.isNullOrEmpty(this._activityInstanceId))
        {
          localStringBuilder.append(".oldId.");
          localStringBuilder.append(this._activityInstanceId);
        }
        this._activityInstanceId = UUID.randomUUID().toString();
        str1 = getIntent().getStringExtra("getjarIntentType");
        str2 = getIntent().getStringExtra("uiSpecifier");
        if (!"accountPicker".equalsIgnoreCase(str1)) {
          continue;
        }
        this._getJarSubActivity = new GetJarUserAuthSubActivity(this);
      }
      catch (UnauthorizedException paramBundle)
      {
        StringBuilder localStringBuilder;
        Class localClass;
        Logger.e(Area.OS_ENTRY_POINT.value() | Area.UI.value(), paramBundle, "GetJarActivity: onCreate() failed", new Object[0]);
        setResult(5);
        finish();
        return;
        if (!"showEarn".equalsIgnoreCase(str1)) {
          continue;
        }
        this._getJarSubActivity = new EarnSubActivity(this, str2);
        Logger.i(Area.OS_ENTRY_POINT.value() | Area.UI.value(), "GetJarActivity: Using EarnSubActivity [uiSpecifier:%1$s]", new Object[] { str2 });
        continue;
      }
      catch (AuthException paramBundle)
      {
        Logger.e(Area.OS_ENTRY_POINT.value() | Area.UI.value(), paramBundle, "GetJarActivity: onCreate() failed", new Object[0]);
        setResult(3);
        finish();
        return;
        if (!"showPurchase".equalsIgnoreCase(str1)) {
          continue;
        }
        this._getJarSubActivity = new PurchaseSubActivity(this, str2);
        Logger.i(Area.OS_ENTRY_POINT.value() | Area.UI.value(), "GetJarActivity: Using PurchaseSubActivity [uiSpecifier:%1$s]", new Object[] { str2 });
        continue;
      }
      catch (Exception paramBundle)
      {
        Logger.e(Area.OS_ENTRY_POINT.value() | Area.UI.value(), paramBundle, "GetJarActivity: onCreate() failed", new Object[0]);
        setResult(4);
        finish();
        return;
        if (!"showManagedPurchase".equalsIgnoreCase(str1)) {
          break label651;
        }
        this._getJarSubActivity = new ManagedPurchaseSubActivity(this, str2);
        Logger.i(Area.OS_ENTRY_POINT.value() | Area.UI.value(), "GetJarActivity: Using ManagedPurchaseSubActivity [uiSpecifier:%1$s]", new Object[] { str2 });
        continue;
      }
      finally
      {
        Logger.i(Area.OS_ENTRY_POINT.value() | Area.UI.value(), "GetJarActivity: onCreate() DONE", new Object[0]);
      }
      this._getJarSubActivity.onCreate(paramBundle);
      if (localClass != null)
      {
        localStringBuilder.append(".oldType.");
        localStringBuilder.append(localClass.getName());
      }
      localStringBuilder.append(".type.");
      localStringBuilder.append(this._getJarSubActivity.getClass().getName());
      Logger.i(Area.OS_ENTRY_POINT.value() | Area.UI.value(), "GetJarActivity: onCreate() DONE", new Object[0]);
      return;
      if ("accountPickerOld".equalsIgnoreCase(str1))
      {
        this._getJarSubActivity = new GetJarUserAuthSubActivityOLD(this);
        Logger.i(Area.OS_ENTRY_POINT.value() | Area.UI.value(), "GetJarActivity: Using GetJarUserAuthSubActivityOLD", new Object[0]);
      }
      else
      {
        label651:
        if ("showShop".equalsIgnoreCase(str1))
        {
          this._getJarSubActivity = new ShopSubActivity(this, str2);
          Logger.i(Area.OS_ENTRY_POINT.value() | Area.UI.value(), "GetJarActivity: Using ShopSubActivity [uiSpecifier:%1$s]", new Object[] { str2 });
        }
        else if ("showInterstitial".equalsIgnoreCase(str1))
        {
          this._getJarSubActivity = new InterstitialAdsSubActivity(this, str2);
          Logger.i(Area.OS_ENTRY_POINT.value() | Area.UI.value(), "GetJarActivity: Using InterstitialSubActivity [uiSpecifier:%1$s]", new Object[] { str2 });
        }
        else
        {
          if (!"showWallet".equalsIgnoreCase(str1)) {
            break;
          }
          this._getJarSubActivity = new WalletSubActivity(this, str2);
          Logger.i(Area.OS_ENTRY_POINT.value() | Area.UI.value(), "GetJarActivity: Using WalletAdsSubActivity [uiSpecifier:%1$s]", new Object[] { str2 });
        }
      }
    }
    Logger.e(Area.OS_ENTRY_POINT.value() | Area.UI.value(), "GetJarActivity: unknown UI requested", new Object[0]);
    throw new IllegalStateException("GetJarActivity: unknown UI requested");
  }
  
  protected void onDestroy()
  {
    try
    {
      AnalyticsManager.getInstance(getApplicationContext()).endSession();
      if (this._getJarSubActivity != null) {
        this._getJarSubActivity.onDestroy();
      }
      return;
    }
    catch (UnauthorizedException localUnauthorizedException)
    {
      Logger.e(Area.OS_ENTRY_POINT.value() | Area.UI.value(), localUnauthorizedException, "GetJarActivity: onDestroy() failed", new Object[0]);
      setResult(5);
      finish();
      return;
    }
    catch (AuthException localAuthException)
    {
      Logger.e(Area.OS_ENTRY_POINT.value() | Area.UI.value(), localAuthException, "GetJarActivity: onDestroy() failed", new Object[0]);
      setResult(3);
      finish();
      return;
    }
    catch (Exception localException)
    {
      Logger.e(Area.OS_ENTRY_POINT.value() | Area.UI.value(), localException, "GetJarActivity: onDestroy() failed", new Object[0]);
      setResult(4);
      finish();
      return;
    }
    finally
    {
      super.onDestroy();
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    try
    {
      this._getJarSubActivity.onNewIntent(paramIntent);
      return;
    }
    catch (UnauthorizedException paramIntent)
    {
      Logger.e(Area.OS_ENTRY_POINT.value() | Area.UI.value(), paramIntent, "GetJarActivity: onNewIntent() failed", new Object[0]);
      setResult(5);
      finish();
      return;
    }
    catch (AuthException paramIntent)
    {
      Logger.e(Area.OS_ENTRY_POINT.value() | Area.UI.value(), paramIntent, "GetJarActivity: onNewIntent() failed", new Object[0]);
      setResult(3);
      finish();
      return;
    }
    catch (Exception paramIntent)
    {
      Logger.e(Area.OS_ENTRY_POINT.value() | Area.UI.value(), paramIntent, "GetJarActivity: onNewIntent() failed", new Object[0]);
      setResult(4);
      finish();
    }
  }
  
  protected void onPause()
  {
    try
    {
      this._getJarSubActivity.onPause();
      return;
    }
    catch (UnauthorizedException localUnauthorizedException)
    {
      Logger.e(Area.OS_ENTRY_POINT.value() | Area.UI.value(), localUnauthorizedException, "GetJarActivity: onPause() failed", new Object[0]);
      setResult(5);
      finish();
      return;
    }
    catch (AuthException localAuthException)
    {
      Logger.e(Area.OS_ENTRY_POINT.value() | Area.UI.value(), localAuthException, "GetJarActivity: onPause() failed", new Object[0]);
      setResult(3);
      finish();
      return;
    }
    catch (Exception localException)
    {
      Logger.e(Area.OS_ENTRY_POINT.value() | Area.UI.value(), localException, "GetJarActivity: onPause() failed", new Object[0]);
      setResult(4);
      finish();
      return;
    }
    finally
    {
      super.onPause();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    try
    {
      this._getJarSubActivity.onResume();
      return;
    }
    catch (UnauthorizedException localUnauthorizedException)
    {
      Logger.e(Area.OS_ENTRY_POINT.value() | Area.UI.value(), localUnauthorizedException, "GetJarActivity: onResume() failed", new Object[0]);
      setResult(5);
      finish();
      return;
    }
    catch (AuthException localAuthException)
    {
      Logger.e(Area.OS_ENTRY_POINT.value() | Area.UI.value(), localAuthException, "GetJarActivity: onResume() failed", new Object[0]);
      setResult(3);
      finish();
      return;
    }
    catch (Exception localException)
    {
      Logger.e(Area.OS_ENTRY_POINT.value() | Area.UI.value(), localException, "GetJarActivity: onResume() failed", new Object[0]);
      setResult(4);
      finish();
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    try
    {
      this._getJarSubActivity.onSaveInstanceState(paramBundle);
      return;
    }
    catch (UnauthorizedException paramBundle)
    {
      Logger.e(Area.OS_ENTRY_POINT.value() | Area.UI.value(), paramBundle, "GetJarActivity: onSaveInstanceState() failed", new Object[0]);
      setResult(5);
      finish();
      return;
    }
    catch (AuthException paramBundle)
    {
      Logger.e(Area.OS_ENTRY_POINT.value() | Area.UI.value(), paramBundle, "GetJarActivity: onSaveInstanceState() failed", new Object[0]);
      setResult(3);
      finish();
      return;
    }
    catch (Exception paramBundle)
    {
      Logger.e(Area.OS_ENTRY_POINT.value() | Area.UI.value(), paramBundle, "GetJarActivity: onSaveInstanceState() failed", new Object[0]);
      setResult(4);
      finish();
    }
  }
  
  protected void onStart()
  {
    Logger.i(Area.OS_ENTRY_POINT.value() | Area.UI.value(), "GetJarActivity: onStart()", new Object[0]);
    super.onStart();
    try
    {
      this._getJarSubActivity.onStart();
      return;
    }
    catch (UnauthorizedException localUnauthorizedException)
    {
      Logger.e(Area.OS_ENTRY_POINT.value() | Area.UI.value(), localUnauthorizedException, "GetJarActivity: onStart() failed", new Object[0]);
      setResult(5);
      finish();
      return;
    }
    catch (AuthException localAuthException)
    {
      Logger.e(Area.OS_ENTRY_POINT.value() | Area.UI.value(), localAuthException, "GetJarActivity: onStart() failed", new Object[0]);
      setResult(3);
      finish();
      return;
    }
    catch (Exception localException)
    {
      Logger.e(Area.OS_ENTRY_POINT.value() | Area.UI.value(), localException, "GetJarActivity: onStart() failed", new Object[0]);
      setResult(4);
      finish();
    }
  }
  
  protected void onStop()
  {
    Logger.i(Area.OS_ENTRY_POINT.value() | Area.UI.value(), "GetJarActivity: onStop()", new Object[0]);
    try
    {
      this._getJarSubActivity.onStop();
      return;
    }
    catch (UnauthorizedException localUnauthorizedException)
    {
      Logger.e(Area.OS_ENTRY_POINT.value() | Area.UI.value(), localUnauthorizedException, "GetJarActivity: onStop() failed", new Object[0]);
      setResult(5);
      finish();
      return;
    }
    catch (AuthException localAuthException)
    {
      Logger.e(Area.OS_ENTRY_POINT.value() | Area.UI.value(), localAuthException, "GetJarActivity: onStop() failed", new Object[0]);
      setResult(3);
      finish();
      return;
    }
    catch (Exception localException)
    {
      Logger.e(Area.OS_ENTRY_POINT.value() | Area.UI.value(), localException, "GetJarActivity: onStop() failed", new Object[0]);
      setResult(4);
      finish();
      return;
    }
    finally
    {
      super.onStop();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/rewards/GetJarActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */