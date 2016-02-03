package com.getjar.sdk.remote;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.text.TextUtils;
import com.getjar.sdk.GetjarClient;
import com.getjar.sdk.GetjarLicense;
import com.getjar.sdk.GetjarLicense.Scope;
import com.getjar.sdk.OnAdAvailableListener;
import com.getjar.sdk.OnGetjarLicensesReceivedListener;
import com.getjar.sdk.logging.Area;
import com.getjar.sdk.logging.Logger;
import com.getjar.sdk.remote.implementation.IRemoteService;
import com.getjar.sdk.remote.implementation.IRemoteService.Stub;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RemoteClient
{
  private static volatile boolean _IsUsed = false;
  private final Context _context;
  private ExecutorService _executorService = Executors.newSingleThreadExecutor();
  
  public RemoteClient(Context paramContext)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("'context' cannot be NULL");
    }
    this._context = paramContext;
    Logger.d(Area.DEVELOPER_API.value(), "RemoteClient() [PID:%1$d]", new Object[] { Integer.valueOf(Process.myPid()) });
    if (GetjarClient.IsUsed()) {
      throw new IllegalStateException("Any given process may only use either GetjarClient or RemoteClient, but never both.");
    }
    _IsUsed = true;
    if (!this._context.bindService(getServiceBindingIntent(), new ServiceConnection()
    {
      private ServiceConnection serviceConnection = this;
      
      public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        try
        {
          RemoteClient.this._context.unbindService(this.serviceConnection);
          return;
        }
        catch (Exception paramAnonymousComponentName)
        {
          Logger.w(Area.DEVELOPER_API.value(), paramAnonymousComponentName.getMessage(), new Object[0]);
        }
      }
      
      public void onServiceDisconnected(ComponentName paramAnonymousComponentName) {}
    }, 1)) {
      throw new IllegalStateException(String.format(Locale.US, "Unable to bind to the com.getjar.sdk.rewards.GetJarService service, does '%1$s' have a manifest entry for it?", new Object[] { paramContext.getPackageName() }));
    }
  }
  
  public static boolean IsUsed()
  {
    return _IsUsed;
  }
  
  private Intent getServiceBindingIntent()
  {
    Intent localIntent = new Intent();
    localIntent.setClassName(this._context.getPackageName(), "com.getjar.sdk.rewards.GetJarService");
    return localIntent;
  }
  
  public void getInterstitialIntent(final String paramString1, final String paramString2, final OnInterstitialIntentReceivedListener paramOnInterstitialIntentReceivedListener)
  {
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException("'placementTag' cannot be NULL or empty");
    }
    if (TextUtils.isEmpty(paramString2)) {
      throw new IllegalArgumentException("'currencyKey' cannot be NULL or empty");
    }
    if (paramOnInterstitialIntentReceivedListener == null) {
      throw new IllegalArgumentException("'resultListener' cannot be NULL");
    }
    Logger.d(Area.DEVELOPER_API.value(), "RemoteClient.getInterstitialIntent() START [PID:%1$d]", new Object[] { Integer.valueOf(Process.myPid()) });
    if (!this._context.bindService(getServiceBindingIntent(), new ServiceConnection()
    {
      private final ServiceConnection serviceConnection = this;
      
      public void onServiceConnected(ComponentName paramAnonymousComponentName, final IBinder paramAnonymousIBinder)
      {
        try
        {
          RemoteClient.this._executorService.execute(new Runnable()
          {
            public void run()
            {
              int j = 1;
              int k = 1;
              i = 1;
              Logger.d(Area.DEVELOPER_API.value(), "RemoteClient.getInterstitialIntent() onServiceConnected() run() START [PID:%1$d]", new Object[] { Integer.valueOf(Process.myPid()) });
              Object localObject1 = null;
              Object localObject4;
              try
              {
                localObject4 = IRemoteService.Stub.asInterface(paramAnonymousIBinder).getInterstitialIntent(RemoteClient.4.this.val$placementTag, RemoteClient.4.this.val$currencyKey);
                if (localObject4 == null) {
                  throw new IllegalStateException("Failed to get a result from IRemoteService.getInterstitialIntent()");
                }
              }
              catch (Exception localException1)
              {
                Logger.e(Area.DEVELOPER_API.value(), localException1, "RemoteClient.getInterstitialIntent() onServiceConnected() run() failed", new Object[0]);
                Logger.d(Area.DEVELOPER_API.value(), "RemoteClient.getInterstitialIntent() onServiceConnected() run() FINISHED [PID:%1$d]", new Object[] { Integer.valueOf(Process.myPid()) });
                for (;;)
                {
                  try
                  {
                    localObject2 = RemoteClient.4.this.val$resultListener;
                    if (0 == 0) {
                      ((OnInterstitialIntentReceivedListener)localObject2).onPendingIntentReceived(i, null);
                    }
                  }
                  catch (Exception localException4)
                  {
                    Object localObject2;
                    Logger.e(Area.DEVELOPER_API.value(), localException4, "RemoteClient.getInterstitialIntent() onServiceConnected() run() onPendingIntentReceived() failed", new Object[0]);
                    continue;
                  }
                  try
                  {
                    RemoteClient.this._context.unbindService(RemoteClient.4.this.serviceConnection);
                    return;
                  }
                  catch (Exception localException5)
                  {
                    Logger.w(Area.DEVELOPER_API.value(), localException5.getMessage(), new Object[0]);
                    return;
                  }
                  if (((Bundle)localObject4).getInt("getjar.response_code", 1) == 0) {
                    localObject2 = (PendingIntent)((Bundle)localObject4).getParcelable("getjar.interstitial_intent");
                  }
                  Logger.d(Area.DEVELOPER_API.value(), "RemoteClient.getInterstitialIntent() onServiceConnected() run() FINISHED [PID:%1$d]", new Object[] { Integer.valueOf(Process.myPid()) });
                  try
                  {
                    localObject4 = RemoteClient.4.this.val$resultListener;
                    if (localObject2 != null) {
                      continue;
                    }
                    i = j;
                    ((OnInterstitialIntentReceivedListener)localObject4).onPendingIntentReceived(i, (PendingIntent)localObject2);
                  }
                  catch (Exception localException3)
                  {
                    Logger.e(Area.DEVELOPER_API.value(), localException3, "RemoteClient.getInterstitialIntent() onServiceConnected() run() onPendingIntentReceived() failed", new Object[0]);
                    continue;
                  }
                  try
                  {
                    RemoteClient.this._context.unbindService(RemoteClient.4.this.serviceConnection);
                    return;
                  }
                  catch (Exception localException2)
                  {
                    Logger.w(Area.DEVELOPER_API.value(), localException2.getMessage(), new Object[0]);
                    return;
                  }
                  i = 0;
                  continue;
                  i = 0;
                }
              }
              finally
              {
                Logger.d(Area.DEVELOPER_API.value(), "RemoteClient.getInterstitialIntent() onServiceConnected() run() FINISHED [PID:%1$d]", new Object[] { Integer.valueOf(Process.myPid()) });
              }
              try
              {
                localObject4 = RemoteClient.4.this.val$resultListener;
                if (0 != 0) {
                  break label425;
                }
                i = k;
              }
              catch (Exception localException6)
              {
                try
                {
                  for (;;)
                  {
                    RemoteClient.this._context.unbindService(RemoteClient.4.this.serviceConnection);
                    throw ((Throwable)localObject3);
                    i = 0;
                    continue;
                    localException6 = localException6;
                    Logger.e(Area.DEVELOPER_API.value(), localException6, "RemoteClient.getInterstitialIntent() onServiceConnected() run() onPendingIntentReceived() failed", new Object[0]);
                  }
                }
                catch (Exception localException7)
                {
                  for (;;)
                  {
                    Logger.w(Area.DEVELOPER_API.value(), localException7.getMessage(), new Object[0]);
                  }
                }
              }
              ((OnInterstitialIntentReceivedListener)localObject4).onPendingIntentReceived(i, null);
            }
          });
          return;
        }
        catch (Exception paramAnonymousComponentName)
        {
          Logger.e(Area.DEVELOPER_API.value(), paramAnonymousComponentName, "RemoteClient.getInterstitialIntent() onServiceConnected() failed", new Object[0]);
          try
          {
            paramOnInterstitialIntentReceivedListener.onPendingIntentReceived(1, null);
            return;
          }
          catch (Exception paramAnonymousComponentName)
          {
            Logger.e(Area.DEVELOPER_API.value(), paramAnonymousComponentName, "RemoteClient.getInterstitialIntent() onServiceConnected() onPendingIntentReceived() failed", new Object[0]);
          }
        }
      }
      
      public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        Logger.d(Area.DEVELOPER_API.value(), "RemoteClient.getInterstitialIntent() onServiceDisconnected() [PID:%1$d]", new Object[] { Integer.valueOf(Process.myPid()) });
      }
    }, 1)) {
      throw new IllegalStateException(String.format(Locale.US, "Unable to bind to the com.getjar.sdk.rewards.GetJarService service, does '%1$s' have a manifest entry for it?", new Object[] { this._context.getPackageName() }));
    }
    Logger.d(Area.DEVELOPER_API.value(), "RemoteClient.getInterstitialIntent() FINISH [PID:%1$d]", new Object[] { Integer.valueOf(Process.myPid()) });
  }
  
  public void getLicense(final String paramString, final OnGetjarLicensesReceivedListener paramOnGetjarLicensesReceivedListener)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("'developerProductID' cannot be null or empty");
    }
    if (paramOnGetjarLicensesReceivedListener == null) {
      throw new IllegalArgumentException("'resultListener' cannot be null");
    }
    Logger.d(Area.DEVELOPER_API.value(), "RemoteClient.getLicense() START [PID:%1$d]", new Object[] { Integer.valueOf(Process.myPid()) });
    if (!this._context.bindService(getServiceBindingIntent(), new ServiceConnection()
    {
      private final ServiceConnection serviceConnection = this;
      
      public void onServiceConnected(ComponentName paramAnonymousComponentName, final IBinder paramAnonymousIBinder)
      {
        try
        {
          RemoteClient.this._executorService.execute(new Runnable()
          {
            /* Error */
            public void run()
            {
              // Byte code:
              //   0: getstatic 34	com/getjar/sdk/logging/Area:DEVELOPER_API	Lcom/getjar/sdk/logging/Area;
              //   3: invokevirtual 38	com/getjar/sdk/logging/Area:value	()J
              //   6: ldc 40
              //   8: iconst_1
              //   9: anewarray 4	java/lang/Object
              //   12: dup
              //   13: iconst_0
              //   14: invokestatic 46	android/os/Process:myPid	()I
              //   17: invokestatic 52	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
              //   20: aastore
              //   21: invokestatic 58	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
              //   24: aload_0
              //   25: getfield 21	com/getjar/sdk/remote/RemoteClient$2$1:val$service	Landroid/os/IBinder;
              //   28: invokestatic 64	com/getjar/sdk/remote/implementation/IRemoteService$Stub:asInterface	(Landroid/os/IBinder;)Lcom/getjar/sdk/remote/implementation/IRemoteService;
              //   31: aload_0
              //   32: getfield 19	com/getjar/sdk/remote/RemoteClient$2$1:this$1	Lcom/getjar/sdk/remote/RemoteClient$2;
              //   35: getfield 68	com/getjar/sdk/remote/RemoteClient$2:val$developerProductID	Ljava/lang/String;
              //   38: invokeinterface 74 2 0
              //   43: astore_1
              //   44: aload_1
              //   45: ifnonnull +89 -> 134
              //   48: new 76	java/lang/IllegalStateException
              //   51: dup
              //   52: ldc 78
              //   54: invokespecial 81	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
              //   57: athrow
              //   58: astore_1
              //   59: getstatic 34	com/getjar/sdk/logging/Area:DEVELOPER_API	Lcom/getjar/sdk/logging/Area;
              //   62: invokevirtual 38	com/getjar/sdk/logging/Area:value	()J
              //   65: aload_1
              //   66: ldc 83
              //   68: iconst_0
              //   69: anewarray 4	java/lang/Object
              //   72: invokestatic 87	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
              //   75: aload_0
              //   76: getfield 19	com/getjar/sdk/remote/RemoteClient$2$1:this$1	Lcom/getjar/sdk/remote/RemoteClient$2;
              //   79: getfield 91	com/getjar/sdk/remote/RemoteClient$2:val$resultListener	Lcom/getjar/sdk/OnGetjarLicensesReceivedListener;
              //   82: iconst_1
              //   83: aconst_null
              //   84: invokeinterface 97 3 0
              //   89: getstatic 34	com/getjar/sdk/logging/Area:DEVELOPER_API	Lcom/getjar/sdk/logging/Area;
              //   92: invokevirtual 38	com/getjar/sdk/logging/Area:value	()J
              //   95: ldc 99
              //   97: iconst_1
              //   98: anewarray 4	java/lang/Object
              //   101: dup
              //   102: iconst_0
              //   103: invokestatic 46	android/os/Process:myPid	()I
              //   106: invokestatic 52	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
              //   109: aastore
              //   110: invokestatic 58	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
              //   113: aload_0
              //   114: getfield 19	com/getjar/sdk/remote/RemoteClient$2$1:this$1	Lcom/getjar/sdk/remote/RemoteClient$2;
              //   117: getfield 103	com/getjar/sdk/remote/RemoteClient$2:this$0	Lcom/getjar/sdk/remote/RemoteClient;
              //   120: invokestatic 109	com/getjar/sdk/remote/RemoteClient:access$000	(Lcom/getjar/sdk/remote/RemoteClient;)Landroid/content/Context;
              //   123: aload_0
              //   124: getfield 19	com/getjar/sdk/remote/RemoteClient$2$1:this$1	Lcom/getjar/sdk/remote/RemoteClient$2;
              //   127: invokestatic 113	com/getjar/sdk/remote/RemoteClient$2:access$100	(Lcom/getjar/sdk/remote/RemoteClient$2;)Landroid/content/ServiceConnection;
              //   130: invokevirtual 119	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
              //   133: return
              //   134: aload_1
              //   135: ldc 121
              //   137: invokevirtual 127	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
              //   140: ifeq +239 -> 379
              //   143: aload_1
              //   144: ldc -127
              //   146: invokevirtual 127	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
              //   149: ifeq +230 -> 379
              //   152: aload_1
              //   153: ldc -125
              //   155: invokevirtual 127	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
              //   158: ifeq +221 -> 379
              //   161: aload_1
              //   162: ldc -123
              //   164: invokevirtual 127	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
              //   167: ifeq +212 -> 379
              //   170: aload_1
              //   171: ldc -121
              //   173: invokevirtual 127	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
              //   176: ifeq +203 -> 379
              //   179: aload_1
              //   180: ldc -119
              //   182: invokevirtual 127	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
              //   185: ifeq +194 -> 379
              //   188: new 139	com/getjar/sdk/remote/RemoteClient$RemoteGetjarLicense
              //   191: dup
              //   192: aload_0
              //   193: getfield 19	com/getjar/sdk/remote/RemoteClient$2$1:this$1	Lcom/getjar/sdk/remote/RemoteClient$2;
              //   196: getfield 103	com/getjar/sdk/remote/RemoteClient$2:this$0	Lcom/getjar/sdk/remote/RemoteClient;
              //   199: aload_0
              //   200: getfield 19	com/getjar/sdk/remote/RemoteClient$2$1:this$1	Lcom/getjar/sdk/remote/RemoteClient$2;
              //   203: getfield 68	com/getjar/sdk/remote/RemoteClient$2:val$developerProductID	Ljava/lang/String;
              //   206: aload_1
              //   207: ldc 121
              //   209: invokevirtual 143	android/os/Bundle:getInt	(Ljava/lang/String;)I
              //   212: aload_1
              //   213: ldc -127
              //   215: invokevirtual 147	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
              //   218: aload_1
              //   219: ldc -125
              //   221: invokevirtual 147	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
              //   224: new 149	java/util/Date
              //   227: dup
              //   228: aload_1
              //   229: ldc -121
              //   231: invokevirtual 153	android/os/Bundle:getLong	(Ljava/lang/String;)J
              //   234: invokespecial 156	java/util/Date:<init>	(J)V
              //   237: new 149	java/util/Date
              //   240: dup
              //   241: aload_1
              //   242: ldc -119
              //   244: invokevirtual 153	android/os/Bundle:getLong	(Ljava/lang/String;)J
              //   247: invokespecial 156	java/util/Date:<init>	(J)V
              //   250: new 149	java/util/Date
              //   253: dup
              //   254: aload_1
              //   255: ldc -123
              //   257: invokevirtual 153	android/os/Bundle:getLong	(Ljava/lang/String;)J
              //   260: invokespecial 156	java/util/Date:<init>	(J)V
              //   263: invokespecial 159	com/getjar/sdk/remote/RemoteClient$RemoteGetjarLicense:<init>	(Lcom/getjar/sdk/remote/RemoteClient;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;)V
              //   266: astore_1
              //   267: aload_0
              //   268: getfield 19	com/getjar/sdk/remote/RemoteClient$2$1:this$1	Lcom/getjar/sdk/remote/RemoteClient$2;
              //   271: getfield 91	com/getjar/sdk/remote/RemoteClient$2:val$resultListener	Lcom/getjar/sdk/OnGetjarLicensesReceivedListener;
              //   274: iconst_0
              //   275: iconst_1
              //   276: anewarray 161	com/getjar/sdk/GetjarLicense
              //   279: dup
              //   280: iconst_0
              //   281: aload_1
              //   282: aastore
              //   283: invokestatic 167	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
              //   286: invokeinterface 97 3 0
              //   291: getstatic 34	com/getjar/sdk/logging/Area:DEVELOPER_API	Lcom/getjar/sdk/logging/Area;
              //   294: invokevirtual 38	com/getjar/sdk/logging/Area:value	()J
              //   297: ldc 99
              //   299: iconst_1
              //   300: anewarray 4	java/lang/Object
              //   303: dup
              //   304: iconst_0
              //   305: invokestatic 46	android/os/Process:myPid	()I
              //   308: invokestatic 52	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
              //   311: aastore
              //   312: invokestatic 58	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
              //   315: aload_0
              //   316: getfield 19	com/getjar/sdk/remote/RemoteClient$2$1:this$1	Lcom/getjar/sdk/remote/RemoteClient$2;
              //   319: getfield 103	com/getjar/sdk/remote/RemoteClient$2:this$0	Lcom/getjar/sdk/remote/RemoteClient;
              //   322: invokestatic 109	com/getjar/sdk/remote/RemoteClient:access$000	(Lcom/getjar/sdk/remote/RemoteClient;)Landroid/content/Context;
              //   325: aload_0
              //   326: getfield 19	com/getjar/sdk/remote/RemoteClient$2$1:this$1	Lcom/getjar/sdk/remote/RemoteClient$2;
              //   329: invokestatic 113	com/getjar/sdk/remote/RemoteClient$2:access$100	(Lcom/getjar/sdk/remote/RemoteClient$2;)Landroid/content/ServiceConnection;
              //   332: invokevirtual 119	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
              //   335: return
              //   336: astore_1
              //   337: getstatic 34	com/getjar/sdk/logging/Area:DEVELOPER_API	Lcom/getjar/sdk/logging/Area;
              //   340: invokevirtual 38	com/getjar/sdk/logging/Area:value	()J
              //   343: aload_1
              //   344: invokevirtual 171	java/lang/Exception:getMessage	()Ljava/lang/String;
              //   347: iconst_0
              //   348: anewarray 4	java/lang/Object
              //   351: invokestatic 174	com/getjar/sdk/logging/Logger:w	(JLjava/lang/String;[Ljava/lang/Object;)V
              //   354: return
              //   355: astore_1
              //   356: getstatic 34	com/getjar/sdk/logging/Area:DEVELOPER_API	Lcom/getjar/sdk/logging/Area;
              //   359: invokevirtual 38	com/getjar/sdk/logging/Area:value	()J
              //   362: aload_1
              //   363: ldc -80
              //   365: iconst_0
              //   366: anewarray 4	java/lang/Object
              //   369: invokestatic 87	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
              //   372: goto -81 -> 291
              //   375: astore_1
              //   376: goto -317 -> 59
              //   379: aload_0
              //   380: getfield 19	com/getjar/sdk/remote/RemoteClient$2$1:this$1	Lcom/getjar/sdk/remote/RemoteClient$2;
              //   383: getfield 91	com/getjar/sdk/remote/RemoteClient$2:val$resultListener	Lcom/getjar/sdk/OnGetjarLicensesReceivedListener;
              //   386: iconst_0
              //   387: new 178	java/util/ArrayList
              //   390: dup
              //   391: invokespecial 179	java/util/ArrayList:<init>	()V
              //   394: invokeinterface 97 3 0
              //   399: goto -108 -> 291
              //   402: astore_1
              //   403: getstatic 34	com/getjar/sdk/logging/Area:DEVELOPER_API	Lcom/getjar/sdk/logging/Area;
              //   406: invokevirtual 38	com/getjar/sdk/logging/Area:value	()J
              //   409: aload_1
              //   410: ldc -80
              //   412: iconst_0
              //   413: anewarray 4	java/lang/Object
              //   416: invokestatic 87	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
              //   419: goto -128 -> 291
              //   422: astore_1
              //   423: getstatic 34	com/getjar/sdk/logging/Area:DEVELOPER_API	Lcom/getjar/sdk/logging/Area;
              //   426: invokevirtual 38	com/getjar/sdk/logging/Area:value	()J
              //   429: aload_1
              //   430: ldc -80
              //   432: iconst_0
              //   433: anewarray 4	java/lang/Object
              //   436: invokestatic 87	com/getjar/sdk/logging/Logger:e	(JLjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
              //   439: goto -350 -> 89
              //   442: astore_1
              //   443: getstatic 34	com/getjar/sdk/logging/Area:DEVELOPER_API	Lcom/getjar/sdk/logging/Area;
              //   446: invokevirtual 38	com/getjar/sdk/logging/Area:value	()J
              //   449: ldc 99
              //   451: iconst_1
              //   452: anewarray 4	java/lang/Object
              //   455: dup
              //   456: iconst_0
              //   457: invokestatic 46	android/os/Process:myPid	()I
              //   460: invokestatic 52	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
              //   463: aastore
              //   464: invokestatic 58	com/getjar/sdk/logging/Logger:d	(JLjava/lang/String;[Ljava/lang/Object;)V
              //   467: aload_0
              //   468: getfield 19	com/getjar/sdk/remote/RemoteClient$2$1:this$1	Lcom/getjar/sdk/remote/RemoteClient$2;
              //   471: getfield 103	com/getjar/sdk/remote/RemoteClient$2:this$0	Lcom/getjar/sdk/remote/RemoteClient;
              //   474: invokestatic 109	com/getjar/sdk/remote/RemoteClient:access$000	(Lcom/getjar/sdk/remote/RemoteClient;)Landroid/content/Context;
              //   477: aload_0
              //   478: getfield 19	com/getjar/sdk/remote/RemoteClient$2$1:this$1	Lcom/getjar/sdk/remote/RemoteClient$2;
              //   481: invokestatic 113	com/getjar/sdk/remote/RemoteClient$2:access$100	(Lcom/getjar/sdk/remote/RemoteClient$2;)Landroid/content/ServiceConnection;
              //   484: invokevirtual 119	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
              //   487: aload_1
              //   488: athrow
              //   489: astore_1
              //   490: getstatic 34	com/getjar/sdk/logging/Area:DEVELOPER_API	Lcom/getjar/sdk/logging/Area;
              //   493: invokevirtual 38	com/getjar/sdk/logging/Area:value	()J
              //   496: aload_1
              //   497: invokevirtual 171	java/lang/Exception:getMessage	()Ljava/lang/String;
              //   500: iconst_0
              //   501: anewarray 4	java/lang/Object
              //   504: invokestatic 174	com/getjar/sdk/logging/Logger:w	(JLjava/lang/String;[Ljava/lang/Object;)V
              //   507: return
              //   508: astore_2
              //   509: getstatic 34	com/getjar/sdk/logging/Area:DEVELOPER_API	Lcom/getjar/sdk/logging/Area;
              //   512: invokevirtual 38	com/getjar/sdk/logging/Area:value	()J
              //   515: aload_2
              //   516: invokevirtual 171	java/lang/Exception:getMessage	()Ljava/lang/String;
              //   519: iconst_0
              //   520: anewarray 4	java/lang/Object
              //   523: invokestatic 174	com/getjar/sdk/logging/Logger:w	(JLjava/lang/String;[Ljava/lang/Object;)V
              //   526: goto -39 -> 487
              //   529: astore_1
              //   530: goto -87 -> 443
              // Local variable table:
              //   start	length	slot	name	signature
              //   0	533	0	this	1
              //   43	2	1	localBundle	Bundle
              //   58	197	1	localException1	Exception
              //   266	16	1	localRemoteGetjarLicense	RemoteClient.RemoteGetjarLicense
              //   336	8	1	localException2	Exception
              //   355	8	1	localException3	Exception
              //   375	1	1	localException4	Exception
              //   402	8	1	localException5	Exception
              //   422	8	1	localException6	Exception
              //   442	46	1	localObject1	Object
              //   489	8	1	localException7	Exception
              //   529	1	1	localObject2	Object
              //   508	8	2	localException8	Exception
              // Exception table:
              //   from	to	target	type
              //   24	44	58	java/lang/Exception
              //   48	58	58	java/lang/Exception
              //   134	267	58	java/lang/Exception
              //   403	419	58	java/lang/Exception
              //   315	335	336	java/lang/Exception
              //   267	291	355	java/lang/Exception
              //   356	372	375	java/lang/Exception
              //   379	399	402	java/lang/Exception
              //   75	89	422	java/lang/Exception
              //   59	75	442	finally
              //   75	89	442	finally
              //   267	291	442	finally
              //   356	372	442	finally
              //   423	439	442	finally
              //   113	133	489	java/lang/Exception
              //   467	487	508	java/lang/Exception
              //   24	44	529	finally
              //   48	58	529	finally
              //   134	267	529	finally
              //   379	399	529	finally
              //   403	419	529	finally
            }
          });
          return;
        }
        catch (Exception paramAnonymousComponentName)
        {
          Logger.e(Area.DEVELOPER_API.value(), paramAnonymousComponentName, "RemoteClient.getLicense() onServiceConnected() failed", new Object[0]);
          try
          {
            paramOnGetjarLicensesReceivedListener.onLicensesReceived(1, null);
            return;
          }
          catch (Exception paramAnonymousComponentName)
          {
            Logger.e(Area.DEVELOPER_API.value(), paramAnonymousComponentName, "RemoteClient.getLicense() onServiceConnected() onLicensesReceived() failed", new Object[0]);
          }
        }
      }
      
      public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        Logger.d(Area.DEVELOPER_API.value(), "RemoteClient.getLicense() onServiceDisconnected() [PID:%1$d]", new Object[] { Integer.valueOf(Process.myPid()) });
      }
    }, 1)) {
      throw new IllegalStateException(String.format(Locale.US, "Unable to bind to the com.getjar.sdk.rewards.GetJarService service, does '%1$s' have a manifest entry for it?", new Object[] { this._context.getPackageName() }));
    }
    Logger.d(Area.DEVELOPER_API.value(), "RemoteClient.getLicense() FINISH [PID:%1$d]", new Object[] { Integer.valueOf(Process.myPid()) });
  }
  
  public void getPurchaseIntent(final String paramString1, final String paramString2, final String paramString3, final long paramLong, final GetjarLicense.Scope paramScope, OnPurchaseIntentReceivedListener paramOnPurchaseIntentReceivedListener)
  {
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException("'developerProductID' cannot be null or empty");
    }
    if (TextUtils.isEmpty(paramString2)) {
      throw new IllegalArgumentException("'productName' cannot be null or empty");
    }
    if (TextUtils.isEmpty(paramString3)) {
      throw new IllegalArgumentException("'productDesc' cannot be null or empty");
    }
    if (paramLong < 0L) {
      throw new IllegalArgumentException("'amount' needs to be greater than or equal to zero");
    }
    if (paramOnPurchaseIntentReceivedListener == null) {
      throw new IllegalArgumentException("'resultListener' cannot be NULL");
    }
    Logger.d(Area.DEVELOPER_API.value(), "RemoteClient.getPurchaseIntent() START [PID:%1$d]", new Object[] { Integer.valueOf(Process.myPid()) });
    if (!this._context.bindService(getServiceBindingIntent(), new ServiceConnection()
    {
      private final ServiceConnection serviceConnection = this;
      
      public void onServiceConnected(ComponentName paramAnonymousComponentName, final IBinder paramAnonymousIBinder)
      {
        try
        {
          RemoteClient.this._executorService.execute(new Runnable()
          {
            public void run()
            {
              int j = 1;
              i = 1;
              Logger.d(Area.DEVELOPER_API.value(), "RemoteClient.getPurchaseIntent() onServiceConnected() run() START [PID:%1$d]", new Object[] { Integer.valueOf(Process.myPid()) });
              OnPurchaseIntentReceivedListener localOnPurchaseIntentReceivedListener = null;
              try
              {
                localObject3 = IRemoteService.Stub.asInterface(paramAnonymousIBinder);
                if (RemoteClient.5.this.val$licenseScope != null) {
                  break label187;
                }
                str = null;
              }
              catch (Exception localException1)
              {
                Object localObject3;
                String str;
                Logger.e(Area.DEVELOPER_API.value(), localException1, "RemoteClient.getPurchaseIntent() onServiceConnected() run() failed", new Object[0]);
                Logger.d(Area.DEVELOPER_API.value(), "RemoteClient.getPurchaseIntent() onServiceConnected() run() FINISHED [PID:%1$d]", new Object[] { Integer.valueOf(Process.myPid()) });
                for (;;)
                {
                  try
                  {
                    localObject1 = RemoteClient.5.this.val$resultListener;
                    if (0 == 0) {
                      ((OnPurchaseIntentReceivedListener)localObject1).onPendingIntentReceived(i, null);
                    }
                  }
                  catch (Exception localException4)
                  {
                    label187:
                    Logger.e(Area.DEVELOPER_API.value(), localException4, "RemoteClient.getPurchaseIntent() onServiceConnected() run() onPendingIntentReceived() failed", new Object[0]);
                    continue;
                  }
                  try
                  {
                    RemoteClient.this._context.unbindService(RemoteClient.5.this.serviceConnection);
                    return;
                  }
                  catch (Exception localException5)
                  {
                    Logger.w(Area.DEVELOPER_API.value(), localException5.getMessage(), new Object[0]);
                    return;
                  }
                  localObject1 = RemoteClient.5.this.val$licenseScope.name();
                  break;
                  localObject1 = localOnPurchaseIntentReceivedListener;
                  if (((Bundle)localObject3).getInt("getjar.response_code", 1) == 0) {
                    localObject1 = (PendingIntent)((Bundle)localObject3).getParcelable("getjar.purchase_intent");
                  }
                  Logger.d(Area.DEVELOPER_API.value(), "RemoteClient.getPurchaseIntent() onServiceConnected() run() FINISHED [PID:%1$d]", new Object[] { Integer.valueOf(Process.myPid()) });
                  try
                  {
                    localOnPurchaseIntentReceivedListener = RemoteClient.5.this.val$resultListener;
                    if (localObject1 != null) {
                      continue;
                    }
                    i = j;
                    localOnPurchaseIntentReceivedListener.onPendingIntentReceived(i, (PendingIntent)localObject1);
                  }
                  catch (Exception localException3)
                  {
                    Logger.e(Area.DEVELOPER_API.value(), localException3, "RemoteClient.getPurchaseIntent() onServiceConnected() run() onPendingIntentReceived() failed", new Object[0]);
                    continue;
                  }
                  try
                  {
                    RemoteClient.this._context.unbindService(RemoteClient.5.this.serviceConnection);
                    return;
                  }
                  catch (Exception localException2)
                  {
                    Logger.w(Area.DEVELOPER_API.value(), localException2.getMessage(), new Object[0]);
                    return;
                  }
                  i = 0;
                  continue;
                  i = 0;
                }
              }
              finally
              {
                Logger.d(Area.DEVELOPER_API.value(), "RemoteClient.getPurchaseIntent() onServiceConnected() run() FINISHED [PID:%1$d]", new Object[] { Integer.valueOf(Process.myPid()) });
              }
              localObject3 = ((IRemoteService)localObject3).getPurchaseIntent(RemoteClient.5.this.val$developerProductID, RemoteClient.5.this.val$productName, RemoteClient.5.this.val$productDesc, RemoteClient.5.this.val$amount, str);
              if (localObject3 == null) {
                throw new IllegalStateException("Failed to get a result from IRemoteService.getPurchaseIntent()");
              }
              try
              {
                Object localObject1;
                localOnPurchaseIntentReceivedListener = RemoteClient.5.this.val$resultListener;
                if (0 != 0) {
                  break label454;
                }
                i = 1;
              }
              catch (Exception localException6)
              {
                try
                {
                  for (;;)
                  {
                    RemoteClient.this._context.unbindService(RemoteClient.5.this.serviceConnection);
                    throw ((Throwable)localObject2);
                    i = 0;
                    continue;
                    localException6 = localException6;
                    Logger.e(Area.DEVELOPER_API.value(), localException6, "RemoteClient.getPurchaseIntent() onServiceConnected() run() onPendingIntentReceived() failed", new Object[0]);
                  }
                }
                catch (Exception localException7)
                {
                  for (;;)
                  {
                    Logger.w(Area.DEVELOPER_API.value(), localException7.getMessage(), new Object[0]);
                  }
                }
              }
              localOnPurchaseIntentReceivedListener.onPendingIntentReceived(i, null);
            }
          });
          return;
        }
        catch (Exception paramAnonymousComponentName)
        {
          Logger.e(Area.DEVELOPER_API.value(), paramAnonymousComponentName, "RemoteClient.getPurchaseIntent() onServiceConnected() failed", new Object[0]);
          try
          {
            this.val$resultListener.onPendingIntentReceived(1, null);
            return;
          }
          catch (Exception paramAnonymousComponentName)
          {
            Logger.e(Area.DEVELOPER_API.value(), paramAnonymousComponentName, "RemoteClient.getPurchaseIntent() onServiceConnected() onPendingIntentReceived() failed", new Object[0]);
          }
        }
      }
      
      public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        Logger.d(Area.DEVELOPER_API.value(), "RemoteClient.getPurchaseIntent() onServiceDisconnected() [PID:%1$d]", new Object[] { Integer.valueOf(Process.myPid()) });
      }
    }, 1)) {
      throw new IllegalStateException(String.format(Locale.US, "Unable to bind to the com.getjar.sdk.rewards.GetJarService service, does '%1$s' have a manifest entry for it?", new Object[] { this._context.getPackageName() }));
    }
    Logger.d(Area.DEVELOPER_API.value(), "RemoteClient.getPurchaseIntent() FINISH [PID:%1$d]", new Object[] { Integer.valueOf(Process.myPid()) });
  }
  
  public void prepareAd(final String paramString, final OnAdAvailableListener paramOnAdAvailableListener)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("'currencyKey' cannot be null or empty");
    }
    if (paramOnAdAvailableListener == null) {
      throw new IllegalArgumentException("'resultListener' cannot be null");
    }
    Logger.d(Area.DEVELOPER_API.value(), "RemoteClient.prepareAd() START [PID:%1$d]", new Object[] { Integer.valueOf(Process.myPid()) });
    if (!this._context.bindService(getServiceBindingIntent(), new ServiceConnection()
    {
      private final ServiceConnection serviceConnection = this;
      
      public void onServiceConnected(ComponentName paramAnonymousComponentName, final IBinder paramAnonymousIBinder)
      {
        try
        {
          RemoteClient.this._executorService.execute(new Runnable()
          {
            public void run()
            {
              Logger.d(Area.DEVELOPER_API.value(), "RemoteClient.prepareAd() onServiceConnected() run() START [PID:%1$d]", new Object[] { Integer.valueOf(Process.myPid()) });
              boolean bool = false;
              try
              {
                Bundle localBundle = IRemoteService.Stub.asInterface(paramAnonymousIBinder).prepareAd(RemoteClient.3.this.val$currencyKey);
                if (localBundle == null) {
                  throw new IllegalStateException("Failed to get a result from IRemoteService.prepareAd()");
                }
              }
              catch (Exception localException1)
              {
                Logger.e(Area.DEVELOPER_API.value(), localException1, "RemoteClient.prepareAd() onServiceConnected() run() failed", new Object[0]);
                Logger.d(Area.DEVELOPER_API.value(), "RemoteClient.prepareAd() onServiceConnected() run() FINISHED [PID:%1$d]", new Object[] { Integer.valueOf(Process.myPid()) });
                try
                {
                  RemoteClient.3.this.val$resultListener.onAdAvailable(false);
                  try
                  {
                    RemoteClient.this._context.unbindService(RemoteClient.3.this.serviceConnection);
                    return;
                  }
                  catch (Exception localException5)
                  {
                    Logger.w(Area.DEVELOPER_API.value(), localException5.getMessage(), new Object[0]);
                    return;
                  }
                  if (localException1.containsKey("getjar.is_ad_available")) {
                    bool = localException1.getBoolean("getjar.is_ad_available");
                  }
                  Logger.d(Area.DEVELOPER_API.value(), "RemoteClient.prepareAd() onServiceConnected() run() FINISHED [PID:%1$d]", new Object[] { Integer.valueOf(Process.myPid()) });
                  try
                  {
                    RemoteClient.3.this.val$resultListener.onAdAvailable(bool);
                    try
                    {
                      RemoteClient.this._context.unbindService(RemoteClient.3.this.serviceConnection);
                      return;
                    }
                    catch (Exception localException2)
                    {
                      Logger.w(Area.DEVELOPER_API.value(), localException2.getMessage(), new Object[0]);
                      return;
                    }
                  }
                  catch (Exception localException3)
                  {
                    for (;;)
                    {
                      Logger.e(Area.DEVELOPER_API.value(), localException3, "RemoteClient.prepareAd() onServiceConnected() onAdAvailable() failed", new Object[0]);
                    }
                  }
                }
                catch (Exception localException4)
                {
                  for (;;)
                  {
                    Logger.e(Area.DEVELOPER_API.value(), localException4, "RemoteClient.prepareAd() onServiceConnected() onAdAvailable() failed", new Object[0]);
                  }
                }
              }
              finally
              {
                Logger.d(Area.DEVELOPER_API.value(), "RemoteClient.prepareAd() onServiceConnected() run() FINISHED [PID:%1$d]", new Object[] { Integer.valueOf(Process.myPid()) });
              }
              try
              {
                RemoteClient.3.this.val$resultListener.onAdAvailable(false);
              }
              catch (Exception localException6)
              {
                try
                {
                  for (;;)
                  {
                    RemoteClient.this._context.unbindService(RemoteClient.3.this.serviceConnection);
                    throw ((Throwable)localObject);
                    localException6 = localException6;
                    Logger.e(Area.DEVELOPER_API.value(), localException6, "RemoteClient.prepareAd() onServiceConnected() onAdAvailable() failed", new Object[0]);
                  }
                }
                catch (Exception localException7)
                {
                  for (;;)
                  {
                    Logger.w(Area.DEVELOPER_API.value(), localException7.getMessage(), new Object[0]);
                  }
                }
              }
            }
          });
          return;
        }
        catch (Exception paramAnonymousComponentName)
        {
          Logger.e(Area.DEVELOPER_API.value(), paramAnonymousComponentName, "RemoteClient.prepareAd() onServiceConnected() failed", new Object[0]);
          try
          {
            paramOnAdAvailableListener.onAdAvailable(false);
            return;
          }
          catch (Exception paramAnonymousComponentName)
          {
            Logger.e(Area.DEVELOPER_API.value(), paramAnonymousComponentName, "RemoteClient.prepareAd() onServiceConnected() onAdAvailable() failed", new Object[0]);
          }
        }
      }
      
      public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        Logger.d(Area.DEVELOPER_API.value(), "RemoteClient.prepareAd() onServiceDisconnected() [PID:%1$d]", new Object[] { Integer.valueOf(Process.myPid()) });
      }
    }, 1)) {
      throw new IllegalStateException(String.format(Locale.US, "Unable to bind to the com.getjar.sdk.rewards.GetJarService service, does '%1$s' have a manifest entry for it?", new Object[] { this._context.getPackageName() }));
    }
    Logger.d(Area.DEVELOPER_API.value(), "RemoteClient.prepareAd() FINISH [PID:%1$d]", new Object[] { Integer.valueOf(Process.myPid()) });
  }
  
  private class RemoteGetjarLicense
    extends GetjarLicense
  {
    protected RemoteGetjarLicense(String paramString1, int paramInt, String paramString2, String paramString3, Date paramDate1, Date paramDate2, Date paramDate3)
    {
      super(paramInt, paramString2, paramString3, paramDate1, paramDate2, paramDate3);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/getjar/sdk/remote/RemoteClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */