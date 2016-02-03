package com.vungle.publisher;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import com.vungle.publisher.ad.AdManager;
import com.vungle.publisher.async.ScheduledPriorityExecutor;
import com.vungle.publisher.async.ScheduledPriorityExecutor.b;
import com.vungle.publisher.db.DatabaseBroadcastReceiver;
import com.vungle.publisher.db.DatabaseHelper;
import com.vungle.publisher.db.DatabaseHelper.1;
import com.vungle.publisher.db.model.AdReport;
import com.vungle.publisher.db.model.LocalAd;
import com.vungle.publisher.db.model.LocalAd.Factory;
import com.vungle.publisher.db.model.LocalAdReport.Factory;
import com.vungle.publisher.db.model.StreamingAd.Factory;
import com.vungle.publisher.device.ExternalStorageStateBroadcastReceiver;
import com.vungle.publisher.env.SdkConfig;
import com.vungle.publisher.env.SdkState;
import com.vungle.publisher.env.SdkState.PlayAdEndEventListener;
import com.vungle.publisher.event.ClientEventListenerAdapter;
import com.vungle.publisher.event.ClientEventListenerAdapter.Factory;
import com.vungle.publisher.inject.Injector;
import com.vungle.publisher.inject.annotations.FullScreenAdActivityClass;
import com.vungle.publisher.log.Logger;
import com.vungle.publisher.net.http.HttpTransaction;
import com.vungle.publisher.protocol.ProtocolHttpGateway;
import com.vungle.publisher.reporting.ReportManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

public class VunglePub
{
  public static final String VERSION = "VungleDroid/3.0.7";
  private static final VunglePub p = new VunglePub();
  @Inject
  AdManager a;
  @Inject
  Context b;
  @Inject
  DatabaseBroadcastReceiver c;
  @Inject
  DatabaseHelper d;
  @Inject
  DatabaseOpenEventListener e;
  @Inject
  Demographic f;
  @Inject
  di g;
  @FullScreenAdActivityClass
  @Inject
  Class h;
  @Inject
  AdConfig i;
  @Inject
  ProtocolHttpGateway j;
  @Inject
  ReportManager k;
  @Inject
  SdkConfig l;
  @Inject
  SdkState m;
  @Inject
  ScheduledPriorityExecutor n;
  @Inject
  ExternalStorageStateBroadcastReceiver o;
  private boolean q;
  
  private boolean a(boolean paramBoolean, String paramString)
  {
    boolean bool = this.q;
    if (bool) {
      Logger.v("Vungle", "VunglePub was initialized");
    }
    while (!paramBoolean) {
      return bool;
    }
    Logger.w("Vungle", "Please call VunglePub.init() before " + paramString);
    return bool;
  }
  
  public static VunglePub getInstance()
  {
    return p;
  }
  
  public Demographic getDemographic()
  {
    Demographic localDemographic = null;
    try
    {
      if (a(true, "getDemographic()")) {
        localDemographic = this.f;
      }
      return localDemographic;
    }
    catch (Exception localException)
    {
      Logger.e("Vungle", "error getting demographic info");
    }
    return null;
  }
  
  public AdConfig getGlobalAdConfig()
  {
    if (a(true, "getGlobalAdConfig()")) {
      return this.i;
    }
    return null;
  }
  
  public void init(Context paramContext, String paramString)
  {
    int i2 = 1;
    for (;;)
    {
      int i1;
      try
      {
        if (this.q)
        {
          Logger.d("Vungle", "already initialized");
          return;
        }
        i1 = 0;
        if (i1 < 3)
        {
          localObject = new String[] { "android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WRITE_EXTERNAL_STORAGE" }[i1];
          if (paramContext.checkCallingOrSelfPermission((String)localObject) == 0) {
            break label308;
          }
          Logger.w("VungleConfig", "Missing permission - did you remember to add <uses-permission android:name=\"" + (String)localObject + "\"/> to your AndroidManifest.xml?");
          i2 = 0;
          break label308;
        }
        if (i2 == 0) {
          break label299;
        }
        Object localObject = Injector.getInstance();
        ((Injector)localObject).a(paramContext, paramString);
        ((Injector)localObject).a.a(this);
        Logger.i("Vungle", "VungleDroid/3.0.7 init(" + paramString + ")");
        paramContext = this.k;
        if (paramContext.c.h.getBoolean("IsVgAppInstalled", false))
        {
          Logger.v("VungleReport", "install already reported");
          this.o.a();
          this.e.b();
          paramContext = this.d;
          paramContext.c.a(new DatabaseHelper.1(paramContext), ScheduledPriorityExecutor.b.a);
          paramContext = this.c;
          if (!paramContext.a)
          {
            paramContext.b.registerReceiver(paramContext, new IntentFilter("com.vungle.publisher.db.DUMP_TABLES"));
            paramContext.a = true;
          }
          Logger.v("Vungle", "initialization successful");
          this.q = true;
          return;
        }
      }
      catch (Exception paramContext)
      {
        Logger.e("Vungle", "VunglePub initialization failed", paramContext);
        return;
      }
      Logger.d("VungleReport", "reporting install");
      paramContext = paramContext.b;
      paramContext.a((HttpTransaction)paramContext.j.get());
      continue;
      label299:
      Logger.w("Vungle", "initialization failed");
      return;
      label308:
      i1 += 1;
    }
  }
  
  public boolean isCachedAdAvailable()
  {
    boolean bool = false;
    try
    {
      LocalAd localLocalAd = this.a.a();
      if (localLocalAd != null) {
        bool = true;
      }
      return bool;
    }
    catch (Exception localException)
    {
      Logger.e("Vungle", "error checking if cached ad is available");
    }
    return false;
  }
  
  public void onPause()
  {
    try
    {
      if (a(false, "onPause()"))
      {
        this.m.d();
        ExternalStorageStateBroadcastReceiver localExternalStorageStateBroadcastReceiver = this.o;
        localExternalStorageStateBroadcastReceiver.b.unregisterReceiver(localExternalStorageStateBroadcastReceiver);
      }
      return;
    }
    catch (Exception localException)
    {
      Logger.e("Vungle", "error onPause()", localException);
    }
  }
  
  public void onResume()
  {
    try
    {
      if (a(false, "onResume()"))
      {
        this.m.c();
        this.o.a();
        this.a.a();
      }
      return;
    }
    catch (Exception localException)
    {
      Logger.e("Vungle", "error onResume()", localException);
    }
  }
  
  public void playAd()
  {
    playAd(null);
  }
  
  public void playAd(final AdConfig paramAdConfig)
  {
    int i3 = 0;
    for (;;)
    {
      SdkState localSdkState;
      int i4;
      try
      {
        Logger.d("Vungle", "playAd()");
        if (!a(true, "playAd()")) {
          break;
        }
        localSdkState = this.m;
        long l1 = SdkState.b();
        long l2 = localSdkState.a();
        i2 = (int)((SdkState.b() - localSdkState.a()) / 1000L);
        if (i2 < 0)
        {
          Logger.d("VungleAd", "negative adDelayElapsedSeconds " + i2 + ", currentTimestampMillis " + l1 + ", lastAdEndMillis " + l2);
          i1 = 1;
          i2 = i3;
          if (i1 != 0)
          {
            if (!localSdkState.f.compareAndSet(false, true)) {
              break label310;
            }
            ((SdkState.PlayAdEndEventListener)localSdkState.c.get()).b();
            i2 = 1;
          }
          if (i2 == 0) {
            break;
          }
          this.n.a(new Runnable()
          {
            /* Error */
            public final void run()
            {
              // Byte code:
              //   0: iconst_0
              //   1: istore_1
              //   2: aload_0
              //   3: getfield 19	com/vungle/publisher/VunglePub$1:b	Lcom/vungle/publisher/VunglePub;
              //   6: getfield 31	com/vungle/publisher/VunglePub:a	Lcom/vungle/publisher/ad/AdManager;
              //   9: astore 6
              //   11: aload 6
              //   13: invokevirtual 36	com/vungle/publisher/ad/AdManager:a	()Lcom/vungle/publisher/db/model/LocalAd;
              //   16: astore 4
              //   18: aload 4
              //   20: ifnonnull +106 -> 126
              //   23: aconst_null
              //   24: astore_3
              //   25: aload 6
              //   27: aload_3
              //   28: invokevirtual 39	com/vungle/publisher/ad/AdManager:a	(Ljava/lang/String;)Lcom/vungle/publisher/db/model/StreamingAd;
              //   31: astore 5
              //   33: aload 5
              //   35: astore_3
              //   36: aload 5
              //   38: ifnonnull +6 -> 44
              //   41: aload 4
              //   43: astore_3
              //   44: aload 6
              //   46: aload_3
              //   47: putfield 42	com/vungle/publisher/ad/AdManager:a	Lcom/vungle/publisher/db/model/Ad;
              //   50: new 44	java/lang/StringBuilder
              //   53: dup
              //   54: ldc 46
              //   56: invokespecial 49	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
              //   59: astore 5
              //   61: aload_3
              //   62: ifnonnull +73 -> 135
              //   65: aconst_null
              //   66: astore 4
              //   68: ldc 51
              //   70: aload 5
              //   72: aload 4
              //   74: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   77: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
              //   80: invokestatic 65	com/vungle/publisher/log/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
              //   83: aload_3
              //   84: ifnonnull +60 -> 144
              //   87: ldc 67
              //   89: ldc 69
              //   91: invokestatic 72	com/vungle/publisher/log/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
              //   94: aload_0
              //   95: getfield 19	com/vungle/publisher/VunglePub$1:b	Lcom/vungle/publisher/VunglePub;
              //   98: getfield 76	com/vungle/publisher/VunglePub:g	Lcom/vungle/publisher/di;
              //   101: new 78	com/vungle/publisher/aa
              //   104: dup
              //   105: invokespecial 79	com/vungle/publisher/aa:<init>	()V
              //   108: invokevirtual 84	com/vungle/publisher/di:b	(Ljava/lang/Object;)V
              //   111: iload_1
              //   112: ifne +13 -> 125
              //   115: aload_0
              //   116: getfield 19	com/vungle/publisher/VunglePub$1:b	Lcom/vungle/publisher/VunglePub;
              //   119: getfield 88	com/vungle/publisher/VunglePub:j	Lcom/vungle/publisher/protocol/ProtocolHttpGateway;
              //   122: invokevirtual 93	com/vungle/publisher/protocol/ProtocolHttpGateway:e	()V
              //   125: return
              //   126: aload 4
              //   128: invokevirtual 97	com/vungle/publisher/db/model/LocalAd:d	()Ljava/lang/String;
              //   131: astore_3
              //   132: goto -107 -> 25
              //   135: aload_3
              //   136: invokevirtual 102	com/vungle/publisher/db/model/Ad:u	()Ljava/lang/String;
              //   139: astore 4
              //   141: goto -73 -> 68
              //   144: aload_0
              //   145: getfield 19	com/vungle/publisher/VunglePub$1:b	Lcom/vungle/publisher/VunglePub;
              //   148: getfield 106	com/vungle/publisher/VunglePub:k	Lcom/vungle/publisher/reporting/ReportManager;
              //   151: aload_3
              //   152: invokevirtual 111	com/vungle/publisher/reporting/ReportManager:a	(Lcom/vungle/publisher/db/model/Ad;)Lcom/vungle/publisher/db/model/AdReport;
              //   155: astore 4
              //   157: aload_0
              //   158: getfield 19	com/vungle/publisher/VunglePub$1:b	Lcom/vungle/publisher/VunglePub;
              //   161: getfield 113	com/vungle/publisher/VunglePub:i	Lcom/vungle/publisher/AdConfig;
              //   164: astore 5
              //   166: aload_0
              //   167: getfield 21	com/vungle/publisher/VunglePub$1:a	Lcom/vungle/publisher/AdConfig;
              //   170: astore_3
              //   171: aload 5
              //   173: getfield 118	com/vungle/publisher/AdConfig:a	Lcom/vungle/publisher/bb;
              //   176: astore 5
              //   178: aload_3
              //   179: ifnonnull +113 -> 292
              //   182: aconst_null
              //   183: astore_3
              //   184: new 120	com/vungle/publisher/bf
              //   187: dup
              //   188: iconst_2
              //   189: anewarray 122	com/vungle/publisher/bb
              //   192: dup
              //   193: iconst_0
              //   194: aload 5
              //   196: aastore
              //   197: dup
              //   198: iconst_1
              //   199: aload_3
              //   200: aastore
              //   201: invokespecial 125	com/vungle/publisher/bf:<init>	([Lcom/vungle/publisher/bb;)V
              //   204: astore_3
              //   205: aload_3
              //   206: invokevirtual 129	com/vungle/publisher/bf:isIncentivized	()Z
              //   209: istore_2
              //   210: aload 4
              //   212: iload_2
              //   213: invokevirtual 134	com/vungle/publisher/db/model/AdReport:b	(Z)V
              //   216: iload_2
              //   217: ifeq +12 -> 229
              //   220: aload 4
              //   222: aload_3
              //   223: invokevirtual 136	com/vungle/publisher/bf:a	()Ljava/lang/String;
              //   226: invokevirtual 138	com/vungle/publisher/db/model/AdReport:b	(Ljava/lang/String;)V
              //   229: aload 4
              //   231: invokevirtual 142	com/vungle/publisher/db/model/AdReport:t	()Ljava/lang/Object;
              //   234: pop
              //   235: new 144	android/content/Intent
              //   238: dup
              //   239: aload_0
              //   240: getfield 19	com/vungle/publisher/VunglePub$1:b	Lcom/vungle/publisher/VunglePub;
              //   243: getfield 147	com/vungle/publisher/VunglePub:b	Landroid/content/Context;
              //   246: aload_0
              //   247: getfield 19	com/vungle/publisher/VunglePub$1:b	Lcom/vungle/publisher/VunglePub;
              //   250: getfield 151	com/vungle/publisher/VunglePub:h	Ljava/lang/Class;
              //   253: invokespecial 154	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
              //   256: astore 4
              //   258: aload 4
              //   260: ldc -101
              //   262: invokevirtual 159	android/content/Intent:addFlags	(I)Landroid/content/Intent;
              //   265: pop
              //   266: aload 4
              //   268: ldc -95
              //   270: aload_3
              //   271: invokevirtual 165	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
              //   274: pop
              //   275: aload_0
              //   276: getfield 19	com/vungle/publisher/VunglePub$1:b	Lcom/vungle/publisher/VunglePub;
              //   279: getfield 147	com/vungle/publisher/VunglePub:b	Landroid/content/Context;
              //   282: aload 4
              //   284: invokevirtual 171	android/content/Context:startActivity	(Landroid/content/Intent;)V
              //   287: iconst_1
              //   288: istore_1
              //   289: goto -178 -> 111
              //   292: aload_3
              //   293: getfield 118	com/vungle/publisher/AdConfig:a	Lcom/vungle/publisher/bb;
              //   296: astore_3
              //   297: goto -113 -> 184
              //   300: astore_3
              //   301: ldc 67
              //   303: ldc -83
              //   305: aload_3
              //   306: invokestatic 176	com/vungle/publisher/log/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
              //   309: aload_0
              //   310: getfield 19	com/vungle/publisher/VunglePub$1:b	Lcom/vungle/publisher/VunglePub;
              //   313: getfield 76	com/vungle/publisher/VunglePub:g	Lcom/vungle/publisher/di;
              //   316: new 178	com/vungle/publisher/v
              //   319: dup
              //   320: invokespecial 179	com/vungle/publisher/v:<init>	()V
              //   323: invokevirtual 84	com/vungle/publisher/di:b	(Ljava/lang/Object;)V
              //   326: aload_0
              //   327: getfield 19	com/vungle/publisher/VunglePub$1:b	Lcom/vungle/publisher/VunglePub;
              //   330: getfield 88	com/vungle/publisher/VunglePub:j	Lcom/vungle/publisher/protocol/ProtocolHttpGateway;
              //   333: invokevirtual 93	com/vungle/publisher/protocol/ProtocolHttpGateway:e	()V
              //   336: return
              //   337: astore_3
              //   338: aload_0
              //   339: getfield 19	com/vungle/publisher/VunglePub$1:b	Lcom/vungle/publisher/VunglePub;
              //   342: getfield 88	com/vungle/publisher/VunglePub:j	Lcom/vungle/publisher/protocol/ProtocolHttpGateway;
              //   345: invokevirtual 93	com/vungle/publisher/protocol/ProtocolHttpGateway:e	()V
              //   348: aload_3
              //   349: athrow
              // Local variable table:
              //   start	length	slot	name	signature
              //   0	350	0	this	1
              //   1	288	1	i	int
              //   209	8	2	bool	boolean
              //   24	273	3	localObject1	Object
              //   300	6	3	localException	Exception
              //   337	12	3	localObject2	Object
              //   16	267	4	localObject3	Object
              //   31	164	5	localObject4	Object
              //   9	36	6	localAdManager	AdManager
              // Exception table:
              //   from	to	target	type
              //   2	18	300	java/lang/Exception
              //   25	33	300	java/lang/Exception
              //   44	61	300	java/lang/Exception
              //   68	83	300	java/lang/Exception
              //   87	111	300	java/lang/Exception
              //   126	132	300	java/lang/Exception
              //   135	141	300	java/lang/Exception
              //   144	178	300	java/lang/Exception
              //   184	216	300	java/lang/Exception
              //   220	229	300	java/lang/Exception
              //   229	287	300	java/lang/Exception
              //   292	297	300	java/lang/Exception
              //   2	18	337	finally
              //   25	33	337	finally
              //   44	61	337	finally
              //   68	83	337	finally
              //   87	111	337	finally
              //   126	132	337	finally
              //   135	141	337	finally
              //   144	178	337	finally
              //   184	216	337	finally
              //   220	229	337	finally
              //   229	287	337	finally
              //   292	297	337	finally
              //   301	326	337	finally
            }
          }, ScheduledPriorityExecutor.b.j);
          return;
        }
        i4 = localSdkState.h.getInt("VgAdDelayDuration", 0);
        if (i2 >= i4)
        {
          i1 = 1;
          if (i1 == 0) {
            break label252;
          }
          Logger.v("VungleAd", i2 + " / " + i4 + " ad delay seconds elapsed");
          continue;
        }
        int i1 = 0;
      }
      catch (Exception paramAdConfig)
      {
        Logger.e("Vungle", "error in playAd()", paramAdConfig);
        return;
      }
      continue;
      label252:
      Logger.d("VungleAd", i2 + " / " + i4 + " ad delay seconds elapsed");
      localSdkState.b.b(new z(i2, i4));
      continue;
      label310:
      Logger.d("VungleAd", "ad already playing");
      int i2 = i3;
    }
  }
  
  public void setEventListener(EventListener paramEventListener)
  {
    try
    {
      if (a(true, "setEventListener()"))
      {
        SdkConfig localSdkConfig = this.l;
        Logger.d("VungleEvent", "setting event listener " + paramEventListener);
        Object localObject = localSdkConfig.a;
        if (localObject != null)
        {
          Logger.v("VungleEvent", "unregistering previous event listener");
          ((bi)localObject).d();
        }
        if (paramEventListener == null)
        {
          localSdkConfig.a = null;
          return;
        }
        localObject = (ClientEventListenerAdapter)localSdkConfig.e.a.get();
        ((ClientEventListenerAdapter)localObject).a = paramEventListener;
        localSdkConfig.a = ((bi)localObject);
        ((bi)localObject).c();
        return;
      }
    }
    catch (Exception localException)
    {
      Logger.e("Vungle", "error setting event listener " + paramEventListener);
    }
  }
  
  @Singleton
  static class DatabaseOpenEventListener
    extends bh
  {
    @Inject
    AdManager a;
    @Inject
    ProtocolHttpGateway b;
    @Inject
    ReportManager c;
    
    public void onEvent(aq paramaq)
    {
      d();
      this.b.c();
      paramaq = this.c;
      Iterator localIterator = paramaq.a.c().iterator();
      while (localIterator.hasNext()) {
        paramaq.a((AdReport)localIterator.next());
      }
      paramaq = this.a;
      paramaq.e.d();
      paramaq.j.c();
      if (this.a.a() != null) {
        this.f.c(new ah());
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/VunglePub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */