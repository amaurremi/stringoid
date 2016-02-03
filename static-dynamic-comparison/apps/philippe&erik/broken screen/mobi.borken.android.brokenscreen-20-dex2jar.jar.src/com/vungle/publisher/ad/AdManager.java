package com.vungle.publisher.ad;

import android.database.SQLException;
import com.vungle.publisher.al;
import com.vungle.publisher.am;
import com.vungle.publisher.bc;
import com.vungle.publisher.bg;
import com.vungle.publisher.bh;
import com.vungle.publisher.br;
import com.vungle.publisher.db.model.Ad;
import com.vungle.publisher.db.model.Ad.a;
import com.vungle.publisher.db.model.LocalAd;
import com.vungle.publisher.db.model.LocalAd.Factory;
import com.vungle.publisher.db.model.StreamingAd;
import com.vungle.publisher.db.model.StreamingAd.Factory;
import com.vungle.publisher.di;
import com.vungle.publisher.env.SdkConfig;
import com.vungle.publisher.log.Logger;
import com.vungle.publisher.protocol.ProtocolHttpGateway;
import com.vungle.publisher.protocol.message.RequestStreamingAdResponse;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
public class AdManager
{
  public volatile Ad a;
  @Inject
  public AdPreparer b;
  @Inject
  bc c;
  @Inject
  public di d;
  @Inject
  public LocalAd.Factory e;
  @Inject
  br f;
  @Inject
  Provider<PrepareStreamingAdEventListener> g;
  @Inject
  ProtocolHttpGateway h;
  @Inject
  SdkConfig i;
  @Inject
  public StreamingAd.Factory j;
  
  public final LocalAd a()
  {
    if (this.c.g())
    {
      LocalAd localLocalAd = this.e.c();
      if (localLocalAd == null)
      {
        Logger.d("VunglePrepare", "no local ad available");
        this.h.d();
        return null;
      }
      Logger.v("VunglePrepare", "local ad already available");
      return localLocalAd;
    }
    Logger.w("VunglePrepare", "unable to fetch local ad -  no external storage available");
    return null;
  }
  
  /* Error */
  public final StreamingAd a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: iconst_0
    //   4: istore_3
    //   5: aload_0
    //   6: getfield 83	com/vungle/publisher/ad/AdManager:i	Lcom/vungle/publisher/env/SdkConfig;
    //   9: getfield 88	com/vungle/publisher/env/SdkConfig:b	Z
    //   12: ifeq +246 -> 258
    //   15: aload_0
    //   16: getfield 90	com/vungle/publisher/ad/AdManager:f	Lcom/vungle/publisher/br;
    //   19: invokeinterface 95 1 0
    //   24: astore 12
    //   26: aload_0
    //   27: getfield 83	com/vungle/publisher/ad/AdManager:i	Lcom/vungle/publisher/env/SdkConfig;
    //   30: getfield 98	com/vungle/publisher/env/SdkConfig:c	Ljava/util/Set;
    //   33: aload 12
    //   35: invokeinterface 104 2 0
    //   40: istore_3
    //   41: new 106	java/lang/StringBuilder
    //   44: dup
    //   45: ldc 108
    //   47: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   50: astore 13
    //   52: iload_3
    //   53: ifeq +198 -> 251
    //   56: ldc 113
    //   58: astore 10
    //   60: ldc 53
    //   62: aload 13
    //   64: aload 10
    //   66: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc 119
    //   71: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload 12
    //   76: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   79: ldc 124
    //   81: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 60	com/vungle/publisher/log/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: iload_3
    //   91: ifeq +292 -> 383
    //   94: ldc 53
    //   96: ldc -126
    //   98: invokestatic 60	com/vungle/publisher/log/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: aload_0
    //   102: getfield 132	com/vungle/publisher/ad/AdManager:g	Ljavax/inject/Provider;
    //   105: invokeinterface 138 1 0
    //   110: checkcast 8	com/vungle/publisher/ad/AdManager$PrepareStreamingAdEventListener
    //   113: astore 12
    //   115: aload 12
    //   117: invokevirtual 140	com/vungle/publisher/ad/AdManager$PrepareStreamingAdEventListener:b	()V
    //   120: aload_0
    //   121: getfield 62	com/vungle/publisher/ad/AdManager:h	Lcom/vungle/publisher/protocol/ProtocolHttpGateway;
    //   124: astore 10
    //   126: aload 10
    //   128: getfield 143	com/vungle/publisher/protocol/ProtocolHttpGateway:g	Lcom/vungle/publisher/protocol/RequestStreamingAdHttpTransactionFactory;
    //   131: astore 13
    //   133: aload 10
    //   135: new 145	com/vungle/publisher/net/http/HttpTransaction
    //   138: dup
    //   139: aload 13
    //   141: getfield 150	com/vungle/publisher/protocol/RequestStreamingAdHttpTransactionFactory:a	Lcom/vungle/publisher/protocol/RequestStreamingAdHttpRequest$Factory;
    //   144: aload_1
    //   145: invokevirtual 155	com/vungle/publisher/protocol/RequestStreamingAdHttpRequest$Factory:a	(Ljava/lang/String;)Lcom/vungle/publisher/protocol/RequestStreamingAdHttpRequest;
    //   148: aload 13
    //   150: getfield 158	com/vungle/publisher/protocol/RequestStreamingAdHttpTransactionFactory:b	Lcom/vungle/publisher/protocol/RequestStreamingAdHttpResponseHandler;
    //   153: invokespecial 161	com/vungle/publisher/net/http/HttpTransaction:<init>	(Lcom/vungle/publisher/net/http/HttpRequest;Lcom/vungle/publisher/bw;)V
    //   156: invokevirtual 164	com/vungle/publisher/protocol/ProtocolHttpGateway:a	(Lcom/vungle/publisher/net/http/HttpTransaction;)V
    //   159: aload 12
    //   161: getfield 167	com/vungle/publisher/ad/AdManager$PrepareStreamingAdEventListener:d	J
    //   164: lstore 4
    //   166: aload_0
    //   167: getfield 83	com/vungle/publisher/ad/AdManager:i	Lcom/vungle/publisher/env/SdkConfig;
    //   170: getfield 170	com/vungle/publisher/env/SdkConfig:d	I
    //   173: istore_2
    //   174: ldc -84
    //   176: new 106	java/lang/StringBuilder
    //   179: dup
    //   180: ldc -82
    //   182: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   185: iload_2
    //   186: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   189: ldc -77
    //   191: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 60	com/vungle/publisher/log/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: iload_2
    //   201: i2l
    //   202: lstore 6
    //   204: aload 12
    //   206: monitorenter
    //   207: aload 12
    //   209: getfield 180	com/vungle/publisher/ad/AdManager$PrepareStreamingAdEventListener:b	Z
    //   212: ifne +71 -> 283
    //   215: invokestatic 186	java/lang/System:currentTimeMillis	()J
    //   218: lstore 8
    //   220: lload 6
    //   222: lload 4
    //   224: ladd
    //   225: lload 8
    //   227: lsub
    //   228: lstore 8
    //   230: lload 8
    //   232: lconst_0
    //   233: lcmp
    //   234: ifle +49 -> 283
    //   237: aload 12
    //   239: lload 8
    //   241: invokevirtual 190	java/lang/Object:wait	(J)V
    //   244: goto -37 -> 207
    //   247: astore_1
    //   248: goto -41 -> 207
    //   251: ldc -64
    //   253: astore 10
    //   255: goto -195 -> 60
    //   258: ldc 53
    //   260: ldc -62
    //   262: invokestatic 60	com/vungle/publisher/log/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   265: goto -175 -> 90
    //   268: astore 10
    //   270: aconst_null
    //   271: astore_1
    //   272: ldc 53
    //   274: ldc -60
    //   276: aload 10
    //   278: invokestatic 199	com/vungle/publisher/log/Logger:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   281: aload_1
    //   282: areturn
    //   283: aload 12
    //   285: getfield 180	com/vungle/publisher/ad/AdManager$PrepareStreamingAdEventListener:b	Z
    //   288: ifeq +38 -> 326
    //   291: aload 12
    //   293: getfield 202	com/vungle/publisher/ad/AdManager$PrepareStreamingAdEventListener:c	Lcom/vungle/publisher/db/model/StreamingAd;
    //   296: astore_1
    //   297: ldc 53
    //   299: new 106	java/lang/StringBuilder
    //   302: dup
    //   303: ldc -52
    //   305: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   308: aload_1
    //   309: invokevirtual 209	com/vungle/publisher/db/model/StreamingAd:u	()Ljava/lang/String;
    //   312: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokestatic 60	com/vungle/publisher/log/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   321: aload 12
    //   323: monitorexit
    //   324: aload_1
    //   325: areturn
    //   326: ldc 53
    //   328: new 106	java/lang/StringBuilder
    //   331: dup
    //   332: ldc -45
    //   334: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   337: invokestatic 186	java/lang/System:currentTimeMillis	()J
    //   340: lload 4
    //   342: lsub
    //   343: invokevirtual 214	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   346: ldc -77
    //   348: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: invokestatic 60	com/vungle/publisher/log/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   357: aload 12
    //   359: invokevirtual 216	com/vungle/publisher/ad/AdManager$PrepareStreamingAdEventListener:a	()V
    //   362: aload 11
    //   364: astore_1
    //   365: goto -44 -> 321
    //   368: astore 10
    //   370: aconst_null
    //   371: astore_1
    //   372: aload 12
    //   374: monitorexit
    //   375: aload 10
    //   377: athrow
    //   378: astore 10
    //   380: goto -108 -> 272
    //   383: aconst_null
    //   384: areturn
    //   385: astore 10
    //   387: goto -15 -> 372
    //   390: astore 10
    //   392: goto -20 -> 372
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	395	0	this	AdManager
    //   0	395	1	paramString	String
    //   173	28	2	k	int
    //   4	87	3	bool	boolean
    //   164	177	4	l1	long
    //   202	19	6	l2	long
    //   218	22	8	l3	long
    //   58	196	10	localObject1	Object
    //   268	9	10	localException1	Exception
    //   368	8	10	localObject2	Object
    //   378	1	10	localException2	Exception
    //   385	1	10	localObject3	Object
    //   390	1	10	localObject4	Object
    //   1	362	11	localObject5	Object
    //   24	349	12	localObject6	Object
    //   50	99	13	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   237	244	247	java/lang/InterruptedException
    //   5	52	268	java/lang/Exception
    //   60	90	268	java/lang/Exception
    //   94	200	268	java/lang/Exception
    //   204	207	268	java/lang/Exception
    //   258	265	268	java/lang/Exception
    //   207	220	368	finally
    //   237	244	368	finally
    //   283	297	368	finally
    //   326	362	368	finally
    //   372	378	378	java/lang/Exception
    //   297	321	385	finally
    //   321	324	390	finally
  }
  
  static class PrepareStreamingAdEventListener
    extends bh
  {
    final String a = "VunglePrepare";
    volatile boolean b;
    volatile StreamingAd c;
    final long d = System.currentTimeMillis();
    @Inject
    StreamingAd.Factory e;
    
    final void a()
    {
      this.b = true;
      try
      {
        notifyAll();
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public void onEvent(al paramal)
    {
      d();
      Logger.d("VunglePrepare", "request streaming ad failure after " + (paramal.c - this.d) + " ms");
      a();
    }
    
    public void onEvent(am paramam)
    {
      d();
      long l = paramam.c - this.d;
      RequestStreamingAdResponse localRequestStreamingAdResponse = paramam.a;
      Object localObject;
      if (Boolean.TRUE.equals(localRequestStreamingAdResponse.r))
      {
        Logger.d("VunglePrepare", "received streaming ad " + localRequestStreamingAdResponse.f() + " after " + l + " ms");
        localObject = localRequestStreamingAdResponse.f();
        paramam = (StreamingAd)this.e.a(localObject, true);
        if (paramam == null)
        {
          paramam = this.e.a(localRequestStreamingAdResponse);
          this.c = paramam;
          Logger.d("VunglePrepare", "inserting new " + paramam.u());
        }
      }
      for (;;)
      {
        try
        {
          paramam.k();
          a();
          return;
        }
        catch (SQLException paramam)
        {
          Logger.d("VunglePrepare", "did not insert streaming ad - possible duplicate");
          continue;
        }
        try
        {
          this.e.a(paramam, localRequestStreamingAdResponse);
          localObject = paramam.h();
          switch (AdManager.1.a[localObject.ordinal()])
          {
          case 2: 
          default: 
            Logger.w("VunglePrepare", "existing " + paramam.u() + " with status " + localObject + " - ignoring");
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Logger.w("VunglePrepare", "error updating ad " + (String)localObject, localException);
          }
          Logger.w("VunglePrepare", "unexpected ad status " + localObject + " for " + paramam.u());
          Logger.d("VunglePrepare", "existing " + paramam.u() + " with status " + localObject);
          if (localObject != Ad.a.e)
          {
            paramam.a(Ad.a.e);
            paramam.l();
          }
          this.c = paramam;
        }
        continue;
        Logger.d("VunglePrepare", "no streaming ad to play after " + l + " ms");
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/vungle/publisher/ad/AdManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */