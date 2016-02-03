package com.google.android.apps.analytics;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Locale;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.ParseException;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

class NetworkDispatcher
  implements Dispatcher
{
  private static final String GOOGLE_ANALYTICS_HOST_NAME = "www.google-analytics.com";
  private static final int GOOGLE_ANALYTICS_HOST_PORT = 80;
  private static final int MAX_EVENTS_PER_PIPELINE = 30;
  private static final int MAX_GET_LENGTH = 2036;
  private static final int MAX_POST_LENGTH = 8192;
  private static final int MAX_SEQUENTIAL_REQUESTS = 5;
  private static final long MIN_RETRY_INTERVAL = 2L;
  private static final String USER_AGENT_TEMPLATE = "%s/%s (Linux; U; Android %s; %s-%s; %s Build/%s)";
  private DispatcherThread dispatcherThread;
  private boolean dryRun = false;
  private final HttpHost googleAnalyticsHost;
  private final String userAgent;
  
  public NetworkDispatcher()
  {
    this("GoogleAnalytics", "1.5.1");
  }
  
  public NetworkDispatcher(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, "www.google-analytics.com", 80);
  }
  
  NetworkDispatcher(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.googleAnalyticsHost = new HttpHost(paramString3, paramInt);
    Object localObject = Locale.getDefault();
    String str = Build.VERSION.RELEASE;
    if (((Locale)localObject).getLanguage() != null)
    {
      paramString3 = ((Locale)localObject).getLanguage().toLowerCase();
      if (((Locale)localObject).getCountry() == null) {
        break label124;
      }
    }
    label124:
    for (localObject = ((Locale)localObject).getCountry().toLowerCase();; localObject = "")
    {
      this.userAgent = String.format("%s/%s (Linux; U; Android %s; %s-%s; %s Build/%s)", new Object[] { paramString1, paramString2, str, paramString3, localObject, Build.MODEL, Build.ID });
      return;
      paramString3 = "en";
      break;
    }
  }
  
  public void dispatchHits(Hit[] paramArrayOfHit)
  {
    if (this.dispatcherThread == null) {
      return;
    }
    this.dispatcherThread.dispatchHits(paramArrayOfHit);
  }
  
  String getUserAgent()
  {
    return this.userAgent;
  }
  
  public void init(Dispatcher.Callbacks paramCallbacks)
  {
    stop();
    this.dispatcherThread = new DispatcherThread(paramCallbacks, this.userAgent, this, null);
    this.dispatcherThread.start();
  }
  
  public void init(Dispatcher.Callbacks paramCallbacks, PipelinedRequester paramPipelinedRequester, HitStore paramHitStore)
  {
    stop();
    this.dispatcherThread = new DispatcherThread(paramCallbacks, paramPipelinedRequester, this.userAgent, this, null);
    this.dispatcherThread.start();
  }
  
  public boolean isDryRun()
  {
    return this.dryRun;
  }
  
  public void setDryRun(boolean paramBoolean)
  {
    this.dryRun = paramBoolean;
  }
  
  public void stop()
  {
    if ((this.dispatcherThread != null) && (this.dispatcherThread.getLooper() != null))
    {
      this.dispatcherThread.getLooper().quit();
      this.dispatcherThread = null;
    }
  }
  
  void waitForThreadLooper()
  {
    this.dispatcherThread.getLooper();
    while (this.dispatcherThread.handlerExecuteOnDispatcherThread == null) {
      Thread.yield();
    }
  }
  
  private static class DispatcherThread
    extends HandlerThread
  {
    private final Dispatcher.Callbacks callbacks;
    private AsyncDispatchTask currentTask = null;
    volatile Handler handlerExecuteOnDispatcherThread;
    private int lastStatusCode;
    private int maxEventsPerRequest = 30;
    private final NetworkDispatcher parent;
    private final PipelinedRequester pipelinedRequester;
    private final RequesterCallbacks requesterCallBacks;
    private long retryInterval;
    private final String userAgent;
    
    private DispatcherThread(Dispatcher.Callbacks paramCallbacks, PipelinedRequester paramPipelinedRequester, String paramString, NetworkDispatcher paramNetworkDispatcher)
    {
      super();
      this.callbacks = paramCallbacks;
      this.userAgent = paramString;
      this.pipelinedRequester = paramPipelinedRequester;
      this.requesterCallBacks = new RequesterCallbacks(null);
      this.pipelinedRequester.installCallbacks(this.requesterCallBacks);
      this.parent = paramNetworkDispatcher;
    }
    
    private DispatcherThread(Dispatcher.Callbacks paramCallbacks, String paramString, NetworkDispatcher paramNetworkDispatcher)
    {
      this(paramCallbacks, new PipelinedRequester(paramNetworkDispatcher.googleAnalyticsHost), paramString, paramNetworkDispatcher);
    }
    
    public void dispatchHits(Hit[] paramArrayOfHit)
    {
      if (this.handlerExecuteOnDispatcherThread == null) {
        return;
      }
      this.handlerExecuteOnDispatcherThread.post(new AsyncDispatchTask(paramArrayOfHit));
    }
    
    protected void onLooperPrepared()
    {
      this.handlerExecuteOnDispatcherThread = new Handler();
    }
    
    private class AsyncDispatchTask
      implements Runnable
    {
      private final LinkedList<Hit> hits = new LinkedList();
      
      public AsyncDispatchTask(Hit[] paramArrayOfHit)
      {
        Collections.addAll(this.hits, paramArrayOfHit);
      }
      
      private void dispatchSomePendingHits(boolean paramBoolean)
        throws IOException, ParseException, HttpException
      {
        if ((GoogleAnalyticsTracker.getInstance().getDebug()) && (paramBoolean)) {
          Log.v("GoogleAnalyticsTracker", "dispatching hits in dry run mode");
        }
        Hit[] arrayOfHit = (Hit[])this.hits.toArray(new Hit[0]);
        int i = 0;
        if ((i < arrayOfHit.length) && (i < NetworkDispatcher.DispatcherThread.this.maxEventsPerRequest))
        {
          Object localObject3 = Utils.addQueueTimeParameter(arrayOfHit[i].hitString, System.currentTimeMillis());
          int j = ((String)localObject3).indexOf('?');
          Object localObject1;
          Object localObject2;
          if (j < 0)
          {
            localObject1 = "";
            localObject2 = localObject3;
            if (((String)localObject1).length() >= 2036) {
              break label346;
            }
            localObject2 = new BasicHttpEntityEnclosingRequest("GET", (String)localObject3);
          }
          for (;;)
          {
            Object localObject4 = NetworkDispatcher.this.googleAnalyticsHost.getHostName();
            localObject3 = localObject4;
            if (NetworkDispatcher.this.googleAnalyticsHost.getPort() != 80) {
              localObject3 = (String)localObject4 + ":" + NetworkDispatcher.this.googleAnalyticsHost.getPort();
            }
            ((HttpEntityEnclosingRequest)localObject2).addHeader("Host", (String)localObject3);
            ((HttpEntityEnclosingRequest)localObject2).addHeader("User-Agent", NetworkDispatcher.DispatcherThread.this.userAgent);
            if (!GoogleAnalyticsTracker.getInstance().getDebug()) {
              break label456;
            }
            localObject3 = new StringBuffer();
            localObject4 = ((HttpEntityEnclosingRequest)localObject2).getAllHeaders();
            int k = localObject4.length;
            j = 0;
            while (j < k)
            {
              ((StringBuffer)localObject3).append(localObject4[j].toString()).append("\n");
              j += 1;
            }
            if (j > 0) {}
            for (localObject1 = ((String)localObject3).substring(0, j);; localObject1 = "")
            {
              if (j >= ((String)localObject3).length() - 2) {
                break label335;
              }
              localObject4 = ((String)localObject3).substring(j + 1);
              localObject2 = localObject1;
              localObject1 = localObject4;
              break;
            }
            label335:
            localObject2 = localObject1;
            localObject1 = "";
            break;
            label346:
            localObject2 = new BasicHttpEntityEnclosingRequest("POST", "/p" + (String)localObject2);
            ((HttpEntityEnclosingRequest)localObject2).addHeader("Content-Length", Integer.toString(((String)localObject1).length()));
            ((HttpEntityEnclosingRequest)localObject2).addHeader("Content-Type", "text/plain");
            ((HttpEntityEnclosingRequest)localObject2).setEntity(new StringEntity((String)localObject1));
          }
          ((StringBuffer)localObject3).append(((HttpEntityEnclosingRequest)localObject2).getRequestLine().toString()).append("\n");
          Log.i("GoogleAnalyticsTracker", ((StringBuffer)localObject3).toString());
          label456:
          if (((String)localObject1).length() > 8192)
          {
            Log.w("GoogleAnalyticsTracker", "Hit too long (> 8192 bytes)--not sent");
            NetworkDispatcher.DispatcherThread.this.requesterCallBacks.requestSent();
          }
          for (;;)
          {
            i += 1;
            break;
            if (paramBoolean) {
              NetworkDispatcher.DispatcherThread.this.requesterCallBacks.requestSent();
            } else {
              NetworkDispatcher.DispatcherThread.this.pipelinedRequester.addRequest((HttpEntityEnclosingRequest)localObject2);
            }
          }
        }
        if (!paramBoolean) {
          NetworkDispatcher.DispatcherThread.this.pipelinedRequester.sendRequests();
        }
      }
      
      public Hit removeNextHit()
      {
        return (Hit)this.hits.poll();
      }
      
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 21	com/google/android/apps/analytics/NetworkDispatcher$DispatcherThread$AsyncDispatchTask:this$0	Lcom/google/android/apps/analytics/NetworkDispatcher$DispatcherThread;
        //   4: aload_0
        //   5: invokestatic 248	com/google/android/apps/analytics/NetworkDispatcher$DispatcherThread:access$402	(Lcom/google/android/apps/analytics/NetworkDispatcher$DispatcherThread;Lcom/google/android/apps/analytics/NetworkDispatcher$DispatcherThread$AsyncDispatchTask;)Lcom/google/android/apps/analytics/NetworkDispatcher$DispatcherThread$AsyncDispatchTask;
        //   8: pop
        //   9: iconst_0
        //   10: istore_1
        //   11: iload_1
        //   12: iconst_5
        //   13: if_icmpge +143 -> 156
        //   16: aload_0
        //   17: getfield 29	com/google/android/apps/analytics/NetworkDispatcher$DispatcherThread$AsyncDispatchTask:hits	Ljava/util/LinkedList;
        //   20: invokevirtual 251	java/util/LinkedList:size	()I
        //   23: ifle +133 -> 156
        //   26: lconst_0
        //   27: lstore_2
        //   28: aload_0
        //   29: getfield 21	com/google/android/apps/analytics/NetworkDispatcher$DispatcherThread$AsyncDispatchTask:this$0	Lcom/google/android/apps/analytics/NetworkDispatcher$DispatcherThread;
        //   32: invokestatic 254	com/google/android/apps/analytics/NetworkDispatcher$DispatcherThread:access$500	(Lcom/google/android/apps/analytics/NetworkDispatcher$DispatcherThread;)I
        //   35: sipush 500
        //   38: if_icmpeq +16 -> 54
        //   41: aload_0
        //   42: getfield 21	com/google/android/apps/analytics/NetworkDispatcher$DispatcherThread$AsyncDispatchTask:this$0	Lcom/google/android/apps/analytics/NetworkDispatcher$DispatcherThread;
        //   45: invokestatic 254	com/google/android/apps/analytics/NetworkDispatcher$DispatcherThread:access$500	(Lcom/google/android/apps/analytics/NetworkDispatcher$DispatcherThread;)I
        //   48: sipush 503
        //   51: if_icmpne +78 -> 129
        //   54: invokestatic 260	java/lang/Math:random	()D
        //   57: aload_0
        //   58: getfield 21	com/google/android/apps/analytics/NetworkDispatcher$DispatcherThread$AsyncDispatchTask:this$0	Lcom/google/android/apps/analytics/NetworkDispatcher$DispatcherThread;
        //   61: invokestatic 264	com/google/android/apps/analytics/NetworkDispatcher$DispatcherThread:access$600	(Lcom/google/android/apps/analytics/NetworkDispatcher$DispatcherThread;)J
        //   64: l2d
        //   65: dmul
        //   66: d2l
        //   67: lstore 4
        //   69: lload 4
        //   71: lstore_2
        //   72: aload_0
        //   73: getfield 21	com/google/android/apps/analytics/NetworkDispatcher$DispatcherThread$AsyncDispatchTask:this$0	Lcom/google/android/apps/analytics/NetworkDispatcher$DispatcherThread;
        //   76: invokestatic 264	com/google/android/apps/analytics/NetworkDispatcher$DispatcherThread:access$600	(Lcom/google/android/apps/analytics/NetworkDispatcher$DispatcherThread;)J
        //   79: ldc2_w 265
        //   82: lcmp
        //   83: ifge +17 -> 100
        //   86: aload_0
        //   87: getfield 21	com/google/android/apps/analytics/NetworkDispatcher$DispatcherThread$AsyncDispatchTask:this$0	Lcom/google/android/apps/analytics/NetworkDispatcher$DispatcherThread;
        //   90: ldc2_w 267
        //   93: invokestatic 272	com/google/android/apps/analytics/NetworkDispatcher$DispatcherThread:access$630	(Lcom/google/android/apps/analytics/NetworkDispatcher$DispatcherThread;J)J
        //   96: pop2
        //   97: lload 4
        //   99: lstore_2
        //   100: lload_2
        //   101: ldc2_w 273
        //   104: lmul
        //   105: invokestatic 280	java/lang/Thread:sleep	(J)V
        //   108: aload_0
        //   109: aload_0
        //   110: getfield 21	com/google/android/apps/analytics/NetworkDispatcher$DispatcherThread$AsyncDispatchTask:this$0	Lcom/google/android/apps/analytics/NetworkDispatcher$DispatcherThread;
        //   113: invokestatic 115	com/google/android/apps/analytics/NetworkDispatcher$DispatcherThread:access$700	(Lcom/google/android/apps/analytics/NetworkDispatcher$DispatcherThread;)Lcom/google/android/apps/analytics/NetworkDispatcher;
        //   116: invokevirtual 283	com/google/android/apps/analytics/NetworkDispatcher:isDryRun	()Z
        //   119: invokespecial 285	com/google/android/apps/analytics/NetworkDispatcher$DispatcherThread$AsyncDispatchTask:dispatchSomePendingHits	(Z)V
        //   122: iload_1
        //   123: iconst_1
        //   124: iadd
        //   125: istore_1
        //   126: goto -115 -> 11
        //   129: aload_0
        //   130: getfield 21	com/google/android/apps/analytics/NetworkDispatcher$DispatcherThread$AsyncDispatchTask:this$0	Lcom/google/android/apps/analytics/NetworkDispatcher$DispatcherThread;
        //   133: ldc2_w 267
        //   136: invokestatic 288	com/google/android/apps/analytics/NetworkDispatcher$DispatcherThread:access$602	(Lcom/google/android/apps/analytics/NetworkDispatcher$DispatcherThread;J)J
        //   139: pop2
        //   140: goto -40 -> 100
        //   143: astore 6
        //   145: ldc 56
        //   147: ldc_w 290
        //   150: aload 6
        //   152: invokestatic 293	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   155: pop
        //   156: aload_0
        //   157: getfield 21	com/google/android/apps/analytics/NetworkDispatcher$DispatcherThread$AsyncDispatchTask:this$0	Lcom/google/android/apps/analytics/NetworkDispatcher$DispatcherThread;
        //   160: invokestatic 225	com/google/android/apps/analytics/NetworkDispatcher$DispatcherThread:access$800	(Lcom/google/android/apps/analytics/NetworkDispatcher$DispatcherThread;)Lcom/google/android/apps/analytics/PipelinedRequester;
        //   163: invokevirtual 296	com/google/android/apps/analytics/PipelinedRequester:finishedCurrentRequests	()V
        //   166: aload_0
        //   167: getfield 21	com/google/android/apps/analytics/NetworkDispatcher$DispatcherThread$AsyncDispatchTask:this$0	Lcom/google/android/apps/analytics/NetworkDispatcher$DispatcherThread;
        //   170: invokestatic 300	com/google/android/apps/analytics/NetworkDispatcher$DispatcherThread:access$900	(Lcom/google/android/apps/analytics/NetworkDispatcher$DispatcherThread;)Lcom/google/android/apps/analytics/Dispatcher$Callbacks;
        //   173: invokeinterface 305 1 0
        //   178: aload_0
        //   179: getfield 21	com/google/android/apps/analytics/NetworkDispatcher$DispatcherThread$AsyncDispatchTask:this$0	Lcom/google/android/apps/analytics/NetworkDispatcher$DispatcherThread;
        //   182: aconst_null
        //   183: invokestatic 248	com/google/android/apps/analytics/NetworkDispatcher$DispatcherThread:access$402	(Lcom/google/android/apps/analytics/NetworkDispatcher$DispatcherThread;Lcom/google/android/apps/analytics/NetworkDispatcher$DispatcherThread$AsyncDispatchTask;)Lcom/google/android/apps/analytics/NetworkDispatcher$DispatcherThread$AsyncDispatchTask;
        //   186: pop
        //   187: return
        //   188: astore 6
        //   190: ldc 56
        //   192: ldc_w 307
        //   195: aload 6
        //   197: invokestatic 293	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   200: pop
        //   201: goto -45 -> 156
        //   204: astore 6
        //   206: ldc 56
        //   208: ldc_w 309
        //   211: aload 6
        //   213: invokestatic 293	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   216: pop
        //   217: goto -61 -> 156
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	220	0	this	AsyncDispatchTask
        //   10	116	1	i	int
        //   27	74	2	l1	long
        //   67	31	4	l2	long
        //   143	8	6	localInterruptedException	InterruptedException
        //   188	8	6	localIOException	IOException
        //   204	8	6	localHttpException	HttpException
        // Exception table:
        //   from	to	target	type
        //   28	54	143	java/lang/InterruptedException
        //   54	69	143	java/lang/InterruptedException
        //   72	97	143	java/lang/InterruptedException
        //   100	122	143	java/lang/InterruptedException
        //   129	140	143	java/lang/InterruptedException
        //   28	54	188	java/io/IOException
        //   54	69	188	java/io/IOException
        //   72	97	188	java/io/IOException
        //   100	122	188	java/io/IOException
        //   129	140	188	java/io/IOException
        //   28	54	204	org/apache/http/HttpException
        //   54	69	204	org/apache/http/HttpException
        //   72	97	204	org/apache/http/HttpException
        //   100	122	204	org/apache/http/HttpException
        //   129	140	204	org/apache/http/HttpException
      }
    }
    
    private class RequesterCallbacks
      implements PipelinedRequester.Callbacks
    {
      private RequesterCallbacks() {}
      
      public void pipelineModeChanged(boolean paramBoolean)
      {
        if (paramBoolean)
        {
          NetworkDispatcher.DispatcherThread.access$1002(NetworkDispatcher.DispatcherThread.this, 30);
          return;
        }
        NetworkDispatcher.DispatcherThread.access$1002(NetworkDispatcher.DispatcherThread.this, 1);
      }
      
      public void requestSent()
      {
        if (NetworkDispatcher.DispatcherThread.this.currentTask == null) {}
        Hit localHit;
        do
        {
          return;
          localHit = NetworkDispatcher.DispatcherThread.this.currentTask.removeNextHit();
        } while (localHit == null);
        NetworkDispatcher.DispatcherThread.this.callbacks.hitDispatched(localHit.hitId);
      }
      
      public void serverError(int paramInt)
      {
        NetworkDispatcher.DispatcherThread.access$502(NetworkDispatcher.DispatcherThread.this, paramInt);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/android/apps/analytics/NetworkDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */