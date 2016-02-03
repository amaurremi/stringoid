package com.android.volley;

import java.util.concurrent.BlockingQueue;

public class NetworkDispatcher
  extends Thread
{
  private final Cache mCache;
  private final ResponseDelivery mDelivery;
  private final Network mNetwork;
  private final BlockingQueue<Request> mQueue;
  private volatile boolean mQuit = false;
  
  public NetworkDispatcher(BlockingQueue<Request> paramBlockingQueue, Network paramNetwork, Cache paramCache, ResponseDelivery paramResponseDelivery)
  {
    this.mQueue = paramBlockingQueue;
    this.mNetwork = paramNetwork;
    this.mCache = paramCache;
    this.mDelivery = paramResponseDelivery;
  }
  
  private void parseAndDeliverNetworkError(Request<?> paramRequest, VolleyError paramVolleyError)
  {
    paramVolleyError = paramRequest.parseNetworkError(paramVolleyError);
    this.mDelivery.postError(paramRequest, paramVolleyError);
  }
  
  public void quit()
  {
    this.mQuit = true;
    interrupt();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: bipush 10
    //   2: invokestatic 64	android/os/Process:setThreadPriority	(I)V
    //   5: aload_0
    //   6: getfield 24	com/android/volley/NetworkDispatcher:mQueue	Ljava/util/concurrent/BlockingQueue;
    //   9: invokeinterface 70 1 0
    //   14: checkcast 37	com/android/volley/Request
    //   17: astore_1
    //   18: aload_1
    //   19: ldc 72
    //   21: invokevirtual 76	com/android/volley/Request:addMarker	(Ljava/lang/String;)V
    //   24: aload_1
    //   25: invokevirtual 80	com/android/volley/Request:isCanceled	()Z
    //   28: ifeq +31 -> 59
    //   31: aload_1
    //   32: ldc 82
    //   34: invokevirtual 85	com/android/volley/Request:finish	(Ljava/lang/String;)V
    //   37: goto -32 -> 5
    //   40: astore_2
    //   41: aload_0
    //   42: aload_1
    //   43: aload_2
    //   44: invokespecial 87	com/android/volley/NetworkDispatcher:parseAndDeliverNetworkError	(Lcom/android/volley/Request;Lcom/android/volley/VolleyError;)V
    //   47: goto -42 -> 5
    //   50: astore_1
    //   51: aload_0
    //   52: getfield 22	com/android/volley/NetworkDispatcher:mQuit	Z
    //   55: ifeq -50 -> 5
    //   58: return
    //   59: getstatic 93	android/os/Build$VERSION:SDK_INT	I
    //   62: bipush 14
    //   64: if_icmplt +10 -> 74
    //   67: aload_1
    //   68: invokevirtual 97	com/android/volley/Request:getTrafficStatsTag	()I
    //   71: invokestatic 102	android/net/TrafficStats:setThreadStatsTag	(I)V
    //   74: aload_0
    //   75: getfield 26	com/android/volley/NetworkDispatcher:mNetwork	Lcom/android/volley/Network;
    //   78: aload_1
    //   79: invokeinterface 108 2 0
    //   84: astore_2
    //   85: aload_1
    //   86: ldc 110
    //   88: invokevirtual 76	com/android/volley/Request:addMarker	(Ljava/lang/String;)V
    //   91: aload_2
    //   92: getfield 115	com/android/volley/NetworkResponse:notModified	Z
    //   95: ifeq +58 -> 153
    //   98: aload_1
    //   99: invokevirtual 118	com/android/volley/Request:hasHadResponseDelivered	()Z
    //   102: ifeq +51 -> 153
    //   105: aload_1
    //   106: ldc 120
    //   108: invokevirtual 85	com/android/volley/Request:finish	(Ljava/lang/String;)V
    //   111: goto -106 -> 5
    //   114: astore_2
    //   115: aload_2
    //   116: ldc 122
    //   118: iconst_1
    //   119: anewarray 124	java/lang/Object
    //   122: dup
    //   123: iconst_0
    //   124: aload_2
    //   125: invokevirtual 128	java/lang/Exception:toString	()Ljava/lang/String;
    //   128: aastore
    //   129: invokestatic 134	com/android/volley/VolleyLog:e	(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   132: aload_0
    //   133: getfield 30	com/android/volley/NetworkDispatcher:mDelivery	Lcom/android/volley/ResponseDelivery;
    //   136: aload_1
    //   137: new 56	com/android/volley/VolleyError
    //   140: dup
    //   141: aload_2
    //   142: invokespecial 137	com/android/volley/VolleyError:<init>	(Ljava/lang/Throwable;)V
    //   145: invokeinterface 46 3 0
    //   150: goto -145 -> 5
    //   153: aload_1
    //   154: aload_2
    //   155: invokevirtual 141	com/android/volley/Request:parseNetworkResponse	(Lcom/android/volley/NetworkResponse;)Lcom/android/volley/Response;
    //   158: astore_2
    //   159: aload_1
    //   160: ldc -113
    //   162: invokevirtual 76	com/android/volley/Request:addMarker	(Ljava/lang/String;)V
    //   165: aload_1
    //   166: invokevirtual 146	com/android/volley/Request:shouldCache	()Z
    //   169: ifeq +33 -> 202
    //   172: aload_2
    //   173: getfield 152	com/android/volley/Response:cacheEntry	Lcom/android/volley/Cache$Entry;
    //   176: ifnull +26 -> 202
    //   179: aload_0
    //   180: getfield 28	com/android/volley/NetworkDispatcher:mCache	Lcom/android/volley/Cache;
    //   183: aload_1
    //   184: invokevirtual 155	com/android/volley/Request:getCacheKey	()Ljava/lang/String;
    //   187: aload_2
    //   188: getfield 152	com/android/volley/Response:cacheEntry	Lcom/android/volley/Cache$Entry;
    //   191: invokeinterface 161 3 0
    //   196: aload_1
    //   197: ldc -93
    //   199: invokevirtual 76	com/android/volley/Request:addMarker	(Ljava/lang/String;)V
    //   202: aload_1
    //   203: invokevirtual 166	com/android/volley/Request:markDelivered	()V
    //   206: aload_0
    //   207: getfield 30	com/android/volley/NetworkDispatcher:mDelivery	Lcom/android/volley/ResponseDelivery;
    //   210: aload_1
    //   211: aload_2
    //   212: invokeinterface 170 3 0
    //   217: goto -212 -> 5
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	NetworkDispatcher
    //   17	26	1	localRequest	Request
    //   50	161	1	localInterruptedException	InterruptedException
    //   40	4	2	localVolleyError	VolleyError
    //   84	8	2	localNetworkResponse	NetworkResponse
    //   114	41	2	localException	Exception
    //   158	54	2	localResponse	Response
    // Exception table:
    //   from	to	target	type
    //   18	37	40	com/android/volley/VolleyError
    //   59	74	40	com/android/volley/VolleyError
    //   74	111	40	com/android/volley/VolleyError
    //   153	202	40	com/android/volley/VolleyError
    //   202	217	40	com/android/volley/VolleyError
    //   5	18	50	java/lang/InterruptedException
    //   18	37	114	java/lang/Exception
    //   59	74	114	java/lang/Exception
    //   74	111	114	java/lang/Exception
    //   153	202	114	java/lang/Exception
    //   202	217	114	java/lang/Exception
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/android/volley/NetworkDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */