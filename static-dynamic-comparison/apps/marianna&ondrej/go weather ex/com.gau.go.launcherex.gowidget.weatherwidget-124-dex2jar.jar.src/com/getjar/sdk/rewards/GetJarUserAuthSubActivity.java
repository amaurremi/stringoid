package com.getjar.sdk.rewards;

import android.os.Bundle;
import com.getjar.sdk.GetjarClient;
import com.getjar.sdk.comm.CommContext;
import com.getjar.sdk.comm.CommManager;
import com.getjar.sdk.comm.auth.AuthManager;
import com.getjar.sdk.comm.auth.UserAuthResult;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.utilities.GlobalActivityRegistrar;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GetJarUserAuthSubActivity
  extends GetJarSubActivityBase
{
  private static final ExecutorService _ExecutorService = ;
  private CommContext _commContext = null;
  
  public GetJarUserAuthSubActivity(GetJarActivity paramGetJarActivity)
  {
    super(paramGetJarActivity);
  }
  
  /* Error */
  private void exitActivity(boolean paramBoolean, UserAuthResult paramUserAuthResult)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 39	com/getjar/sdk/rewards/GetJarUserAuthSubActivity:_waitDialogWasShowing	Z
    //   4: ifeq +7 -> 11
    //   7: aload_0
    //   8: invokevirtual 42	com/getjar/sdk/rewards/GetJarUserAuthSubActivity:waitDialogHide	()V
    //   11: iload_1
    //   12: ifeq +19 -> 31
    //   15: aload_0
    //   16: getfield 46	com/getjar/sdk/rewards/GetJarUserAuthSubActivity:getJarActivity	Lcom/getjar/sdk/rewards/GetJarActivity;
    //   19: iconst_m1
    //   20: invokevirtual 52	com/getjar/sdk/rewards/GetJarActivity:setResult	(I)V
    //   23: aload_0
    //   24: getfield 46	com/getjar/sdk/rewards/GetJarUserAuthSubActivity:getJarActivity	Lcom/getjar/sdk/rewards/GetJarActivity;
    //   27: invokevirtual 55	com/getjar/sdk/rewards/GetJarActivity:finish	()V
    //   30: return
    //   31: bipush 13
    //   33: istore 4
    //   35: iload 4
    //   37: istore_3
    //   38: aload_2
    //   39: ifnull +30 -> 69
    //   42: iload 4
    //   44: istore_3
    //   45: aload_2
    //   46: invokevirtual 61	com/getjar/sdk/comm/auth/UserAuthResult:getState	()Lcom/getjar/sdk/comm/auth/AuthResult$State;
    //   49: ifnull +20 -> 69
    //   52: aload_2
    //   53: invokevirtual 65	com/getjar/sdk/comm/auth/UserAuthResult:mapAuthStateToErrorCode	()Ljava/lang/Integer;
    //   56: astore_2
    //   57: iload 4
    //   59: istore_3
    //   60: aload_2
    //   61: ifnull +8 -> 69
    //   64: aload_2
    //   65: invokevirtual 71	java/lang/Integer:intValue	()I
    //   68: istore_3
    //   69: new 73	android/content/Intent
    //   72: dup
    //   73: invokespecial 75	android/content/Intent:<init>	()V
    //   76: astore_2
    //   77: aload_2
    //   78: ldc 77
    //   80: iload_3
    //   81: invokevirtual 81	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   84: pop
    //   85: aload_0
    //   86: getfield 46	com/getjar/sdk/rewards/GetJarUserAuthSubActivity:getJarActivity	Lcom/getjar/sdk/rewards/GetJarActivity;
    //   89: iconst_1
    //   90: aload_2
    //   91: invokevirtual 84	com/getjar/sdk/rewards/GetJarActivity:setResult	(ILandroid/content/Intent;)V
    //   94: goto -71 -> 23
    //   97: astore_2
    //   98: getstatic 90	com/getjar/sdk/logging/Area:OS_ENTRY_POINT	Lcom/getjar/sdk/logging/Area;
    //   101: invokevirtual 94	com/getjar/sdk/logging/Area:value	()J
    //   104: getstatic 97	com/getjar/sdk/logging/Area:AUTH	Lcom/getjar/sdk/logging/Area;
    //   107: invokevirtual 94	com/getjar/sdk/logging/Area:value	()J
    //   110: lor
    //   111: getstatic 100	com/getjar/sdk/logging/Area:UI	Lcom/getjar/sdk/logging/Area;
    //   114: invokevirtual 94	com/getjar/sdk/logging/Area:value	()J
    //   117: lor
    //   118: aload_2
    //   119: ldc 102
    //   121: iconst_0
    //   122: anewarray 104	java/lang/Object
    //   125: invokestatic 110	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: aload_0
    //   129: getfield 46	com/getjar/sdk/rewards/GetJarUserAuthSubActivity:getJarActivity	Lcom/getjar/sdk/rewards/GetJarActivity;
    //   132: invokevirtual 55	com/getjar/sdk/rewards/GetJarActivity:finish	()V
    //   135: return
    //   136: astore_2
    //   137: aload_0
    //   138: getfield 46	com/getjar/sdk/rewards/GetJarUserAuthSubActivity:getJarActivity	Lcom/getjar/sdk/rewards/GetJarActivity;
    //   141: invokevirtual 55	com/getjar/sdk/rewards/GetJarActivity:finish	()V
    //   144: aload_2
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	GetJarUserAuthSubActivity
    //   0	146	1	paramBoolean	boolean
    //   0	146	2	paramUserAuthResult	UserAuthResult
    //   37	44	3	i	int
    //   33	25	4	j	int
    // Exception table:
    //   from	to	target	type
    //   0	11	97	java/lang/Exception
    //   15	23	97	java/lang/Exception
    //   45	57	97	java/lang/Exception
    //   64	69	97	java/lang/Exception
    //   69	94	97	java/lang/Exception
    //   0	11	136	finally
    //   15	23	136	finally
    //   45	57	136	finally
    //   64	69	136	finally
    //   69	94	136	finally
    //   98	128	136	finally
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
    Logger.d(Area.OS_ENTRY_POINT.value() | Area.AUTH.value() | Area.UI.value(), "GetJarUserAuthSubActivity: onResume() START", new Object[0]);
    try
    {
      CommManager.initialize(this.getJarActivity);
      this._commContext = null;
      List localList = CommManager.getAllRegisteredGetjarClients();
      if ((localList != null) && (localList.size() > 0)) {
        this._commContext = CommManager.retrieveContext(((GetjarClient)localList.get(0)).getClientId());
      }
      if (this._commContext == null)
      {
        Logger.e(Area.OS_ENTRY_POINT.value() | Area.UI.value(), "No CommContext instance found to use!", new Object[0]);
        exitActivity(false, null);
        return;
      }
      Logger.d(Area.OS_ENTRY_POINT.value() | Area.UI.value(), "GetJarUserAuthSubActivity: onResume() Using CommContext.ID: %1$s", new Object[] { this._commContext.getCommContextId() });
      waitDialogShow();
      this._waitDialogWasShowing = true;
      AuthManager.initialize(this._commContext.getApplicationContext());
      AuthManager.getInstance().ensureAuthWithUI(this);
      _ExecutorService.execute(new Runnable()
      {
        public void run()
        {
          try
          {
            Logger.d(Area.OS_ENTRY_POINT.value() | Area.AUTH.value() | Area.UI.value(), "GetJarUserAuthSubActivity: waitOnAuth() START", new Object[0]);
            AuthManager.getInstance().waitOnAuth();
            UserAuthResult localUserAuthResult = AuthManager.getInstance().getLatestAuthResult();
            Logger.d(Area.OS_ENTRY_POINT.value() | Area.AUTH.value() | Area.UI.value(), "GetJarUserAuthSubActivity: waitOnAuth() FINISHED", new Object[0]);
            GetJarUserAuthSubActivity.this.exitActivity(AuthManager.getInstance().isAuthed(), localUserAuthResult);
            return;
          }
          catch (Exception localException)
          {
            Logger.e(Area.OS_ENTRY_POINT.value() | Area.AUTH.value() | Area.UI.value(), localException, "GetJarUserAuthSubActivity: waitOnAuth() failed", new Object[0]);
            return;
          }
          finally
          {
            Logger.d(Area.OS_ENTRY_POINT.value() | Area.AUTH.value() | Area.UI.value(), "GetJarUserAuthSubActivity: waitOnAuth() FINISHED", new Object[0]);
            GetJarUserAuthSubActivity.this.exitActivity(AuthManager.getInstance().isAuthed(), null);
          }
        }
      });
      return;
    }
    catch (Exception localException)
    {
      Logger.e(Area.OS_ENTRY_POINT.value() | Area.AUTH.value() | Area.UI.value(), localException, "GetJarUserAuthSubActivity: onResume() failed", new Object[0]);
      exitActivity(false, null);
      return;
    }
    finally
    {
      Logger.d(Area.OS_ENTRY_POINT.value() | Area.AUTH.value() | Area.UI.value(), "GetJarUserAuthSubActivity: onResume() FINISHED", new Object[0]);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/rewards/GetJarUserAuthSubActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */