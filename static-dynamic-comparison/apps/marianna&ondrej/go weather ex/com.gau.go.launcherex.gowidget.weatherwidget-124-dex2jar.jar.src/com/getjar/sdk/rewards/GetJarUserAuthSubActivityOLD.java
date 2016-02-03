package com.getjar.sdk.rewards;

import android.content.Intent;
import android.os.Bundle;
import com.getjar.sdk.GetjarClient;
import com.getjar.sdk.comm.CommContext;
import com.getjar.sdk.comm.CommManager;
import com.getjar.sdk.comm.auth.AuthManager;
import com.getjar.sdk.exceptions.AuthException;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.GlobalActivityRegistrar;
import com.getjar.sdk.utilities.StringUtility;
import java.util.List;

public class GetJarUserAuthSubActivityOLD
  extends GetJarSubActivityBase
{
  private CommContext commContext;
  
  public GetJarUserAuthSubActivityOLD(GetJarActivity paramGetJarActivity)
  {
    super(paramGetJarActivity);
  }
  
  private void exitActivity()
  {
    try
    {
      waitDialogHide();
      this.getJarActivity.finish();
      return;
    }
    catch (Exception localException)
    {
      Logger.e(Area.OS_ENTRY_POINT.value() | Area.AUTH.value() | Area.UI.value(), localException, "GetJarUserAuthSubActivityOLD: exitActivity() failed", new Object[0]);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    GlobalActivityRegistrar.getInstance().registerActivity(this.getJarActivity);
  }
  
  public void onDestroy()
  {
    waitDialogHide();
    super.onDestroy();
  }
  
  public void onResume()
  {
    List localList = null;
    String str4 = null;
    String str3 = str4;
    Object localObject1 = localList;
    try
    {
      Logger.d(Area.OS_ENTRY_POINT.value() | Area.AUTH.value() | Area.UI.value(), "GetJarUserAuthSubActivityOLD: onResume() START", new Object[0]);
      str3 = str4;
      localObject1 = localList;
      str4 = this.getJarActivity.getIntent().getStringExtra("auth.with.ui.id");
      str3 = str4;
      localObject1 = str4;
      if (!StringUtility.isNullOrEmpty(str4))
      {
        str3 = str4;
        localObject1 = str4;
        Logger.i(Area.OS_ENTRY_POINT.value() | Area.AUTH.value() | Area.UI.value(), "GetJarUserAuthSubActivityOLD: onResume() authWithUiId: '%1$s'", new Object[] { str4 });
      }
      str3 = str4;
      localObject1 = str4;
      CommManager.initialize(this.getJarActivity);
      str3 = str4;
      localObject1 = str4;
      CommManager.initialize(this.getJarActivity);
      str3 = str4;
      localObject1 = str4;
      this.commContext = null;
      str3 = str4;
      localObject1 = str4;
      localList = CommManager.getAllRegisteredGetjarClients();
      if (localList != null)
      {
        str3 = str4;
        localObject1 = str4;
        if (localList.size() > 0)
        {
          str3 = str4;
          localObject1 = str4;
          this.commContext = CommManager.retrieveContext(((GetjarClient)localList.get(0)).getClientId());
        }
      }
      str3 = str4;
      localObject1 = str4;
      if (this.commContext == null)
      {
        str3 = str4;
        localObject1 = str4;
        Logger.e(Area.OS_ENTRY_POINT.value() | Area.AUTH.value() | Area.UI.value(), "No CommContext instance found to use!", new Object[0]);
        str3 = str4;
        localObject1 = str4;
        this.getJarActivity.finish();
        try
        {
          if (!StringUtility.isNullOrEmpty(str4))
          {
            AuthManager.initialize(this.commContext.getApplicationContext());
            AuthManager.getInstance().observeAuthWithUiId(str4);
          }
          new Thread(new Runnable()
          {
            public void run()
            {
              try
              {
                Logger.d(Area.OS_ENTRY_POINT.value() | Area.AUTH.value() | Area.UI.value(), "GetJarUserAuthSubActivityOLD: waitForUserDevice START", new Object[0]);
                AuthManager.initialize(GetJarUserAuthSubActivityOLD.this.commContext.getApplicationContext());
                AuthManager.getInstance().waitOnAuth();
                return;
              }
              catch (AuthException localAuthException)
              {
                Logger.w(Area.OS_ENTRY_POINT.value() | Area.AUTH.value() | Area.UI.value(), "GetJarUserAuthSubActivityOLD: waitForUserDevice failed [auth failed]", new Object[0]);
                return;
              }
              catch (Exception localException)
              {
                Logger.e(Area.OS_ENTRY_POINT.value() | Area.AUTH.value() | Area.UI.value(), localException, "GetJarUserAuthSubActivityOLD: waitForUserDevice failed", new Object[0]);
                return;
              }
              finally
              {
                Logger.d(Area.OS_ENTRY_POINT.value() | Area.AUTH.value() | Area.UI.value(), "GetJarUserAuthSubActivityOLD: waitForUserDevice DONE", new Object[0]);
                GetJarUserAuthSubActivityOLD.this.exitActivity();
              }
            }
          }, "GetJarUserAuthSubActivityOLD Auth Wait Thread").start();
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            Logger.e(Area.OS_ENTRY_POINT.value() | Area.AUTH.value() | Area.UI.value(), localException1, "GetJarUserAuthSubActivityOLD: onResume() failed to start user auth wait thread", new Object[0]);
            exitActivity();
          }
        }
        Logger.d(Area.OS_ENTRY_POINT.value() | Area.AUTH.value() | Area.UI.value(), "GetJarUserAuthSubActivityOLD: onResume() DONE", new Object[0]);
        return;
      }
      str3 = str4;
      String str1 = str4;
      Logger.d(Area.OS_ENTRY_POINT.value() | Area.AUTH.value() | Area.UI.value(), "GetJarUserAuthSubActivityOLD: onResume() Using CommContext.ID: %1$s", new Object[] { this.commContext.getCommContextId() });
      str3 = str4;
      str1 = str4;
      waitDialogShow();
      str3 = str4;
      str1 = str4;
      this._waitDialogWasShowing = true;
      str3 = str4;
      str1 = str4;
      AuthManager.initialize(this.commContext.getApplicationContext());
      str3 = str4;
      str1 = str4;
      AuthManager.getInstance().ensureAuthWithUI(this);
      try
      {
        if (!StringUtility.isNullOrEmpty(str4))
        {
          AuthManager.initialize(this.commContext.getApplicationContext());
          AuthManager.getInstance().observeAuthWithUiId(str4);
        }
        new Thread(new Runnable()
        {
          public void run()
          {
            try
            {
              Logger.d(Area.OS_ENTRY_POINT.value() | Area.AUTH.value() | Area.UI.value(), "GetJarUserAuthSubActivityOLD: waitForUserDevice START", new Object[0]);
              AuthManager.initialize(GetJarUserAuthSubActivityOLD.this.commContext.getApplicationContext());
              AuthManager.getInstance().waitOnAuth();
              return;
            }
            catch (AuthException localAuthException)
            {
              Logger.w(Area.OS_ENTRY_POINT.value() | Area.AUTH.value() | Area.UI.value(), "GetJarUserAuthSubActivityOLD: waitForUserDevice failed [auth failed]", new Object[0]);
              return;
            }
            catch (Exception localException)
            {
              Logger.e(Area.OS_ENTRY_POINT.value() | Area.AUTH.value() | Area.UI.value(), localException, "GetJarUserAuthSubActivityOLD: waitForUserDevice failed", new Object[0]);
              return;
            }
            finally
            {
              Logger.d(Area.OS_ENTRY_POINT.value() | Area.AUTH.value() | Area.UI.value(), "GetJarUserAuthSubActivityOLD: waitForUserDevice DONE", new Object[0]);
              GetJarUserAuthSubActivityOLD.this.exitActivity();
            }
          }
        }, "GetJarUserAuthSubActivityOLD Auth Wait Thread").start();
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Logger.e(Area.OS_ENTRY_POINT.value() | Area.AUTH.value() | Area.UI.value(), localException2, "GetJarUserAuthSubActivityOLD: onResume() failed to start user auth wait thread", new Object[0]);
          exitActivity();
        }
      }
      Logger.d(Area.OS_ENTRY_POINT.value() | Area.AUTH.value() | Area.UI.value(), "GetJarUserAuthSubActivityOLD: onResume() DONE", new Object[0]);
      return;
    }
    catch (Exception localException5)
    {
      localException5 = localException5;
      String str2 = str3;
      Logger.e(Area.OS_ENTRY_POINT.value() | Area.AUTH.value() | Area.UI.value(), localException5, "GetJarUserAuthSubActivityOLD: onResume() failed", new Object[0]);
      try
      {
        if (!StringUtility.isNullOrEmpty(str3))
        {
          AuthManager.initialize(this.commContext.getApplicationContext());
          AuthManager.getInstance().observeAuthWithUiId(str3);
        }
        new Thread(new Runnable()
        {
          public void run()
          {
            try
            {
              Logger.d(Area.OS_ENTRY_POINT.value() | Area.AUTH.value() | Area.UI.value(), "GetJarUserAuthSubActivityOLD: waitForUserDevice START", new Object[0]);
              AuthManager.initialize(GetJarUserAuthSubActivityOLD.this.commContext.getApplicationContext());
              AuthManager.getInstance().waitOnAuth();
              return;
            }
            catch (AuthException localAuthException)
            {
              Logger.w(Area.OS_ENTRY_POINT.value() | Area.AUTH.value() | Area.UI.value(), "GetJarUserAuthSubActivityOLD: waitForUserDevice failed [auth failed]", new Object[0]);
              return;
            }
            catch (Exception localException)
            {
              Logger.e(Area.OS_ENTRY_POINT.value() | Area.AUTH.value() | Area.UI.value(), localException, "GetJarUserAuthSubActivityOLD: waitForUserDevice failed", new Object[0]);
              return;
            }
            finally
            {
              Logger.d(Area.OS_ENTRY_POINT.value() | Area.AUTH.value() | Area.UI.value(), "GetJarUserAuthSubActivityOLD: waitForUserDevice DONE", new Object[0]);
              GetJarUserAuthSubActivityOLD.this.exitActivity();
            }
          }
        }, "GetJarUserAuthSubActivityOLD Auth Wait Thread").start();
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          Logger.e(Area.OS_ENTRY_POINT.value() | Area.AUTH.value() | Area.UI.value(), localException3, "GetJarUserAuthSubActivityOLD: onResume() failed to start user auth wait thread", new Object[0]);
          exitActivity();
        }
      }
      Logger.d(Area.OS_ENTRY_POINT.value() | Area.AUTH.value() | Area.UI.value(), "GetJarUserAuthSubActivityOLD: onResume() DONE", new Object[0]);
      return;
    }
    finally {}
    try
    {
      if (!StringUtility.isNullOrEmpty(localException3))
      {
        AuthManager.initialize(this.commContext.getApplicationContext());
        AuthManager.getInstance().observeAuthWithUiId(localException3);
      }
      new Thread(new Runnable()
      {
        public void run()
        {
          try
          {
            Logger.d(Area.OS_ENTRY_POINT.value() | Area.AUTH.value() | Area.UI.value(), "GetJarUserAuthSubActivityOLD: waitForUserDevice START", new Object[0]);
            AuthManager.initialize(GetJarUserAuthSubActivityOLD.this.commContext.getApplicationContext());
            AuthManager.getInstance().waitOnAuth();
            return;
          }
          catch (AuthException localAuthException)
          {
            Logger.w(Area.OS_ENTRY_POINT.value() | Area.AUTH.value() | Area.UI.value(), "GetJarUserAuthSubActivityOLD: waitForUserDevice failed [auth failed]", new Object[0]);
            return;
          }
          catch (Exception localException)
          {
            Logger.e(Area.OS_ENTRY_POINT.value() | Area.AUTH.value() | Area.UI.value(), localException, "GetJarUserAuthSubActivityOLD: waitForUserDevice failed", new Object[0]);
            return;
          }
          finally
          {
            Logger.d(Area.OS_ENTRY_POINT.value() | Area.AUTH.value() | Area.UI.value(), "GetJarUserAuthSubActivityOLD: waitForUserDevice DONE", new Object[0]);
            GetJarUserAuthSubActivityOLD.this.exitActivity();
          }
        }
      }, "GetJarUserAuthSubActivityOLD Auth Wait Thread").start();
    }
    catch (Exception localException4)
    {
      for (;;)
      {
        Logger.e(Area.OS_ENTRY_POINT.value() | Area.AUTH.value() | Area.UI.value(), localException4, "GetJarUserAuthSubActivityOLD: onResume() failed to start user auth wait thread", new Object[0]);
        exitActivity();
      }
    }
    Logger.d(Area.OS_ENTRY_POINT.value() | Area.AUTH.value() | Area.UI.value(), "GetJarUserAuthSubActivityOLD: onResume() DONE", new Object[0]);
    throw ((Throwable)localObject2);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/rewards/GetJarUserAuthSubActivityOLD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */