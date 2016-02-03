package com.google.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.analytics.containertag.proto.Serving.Resource;
import com.google.android.gms.common.util.VisibleForTesting;

class ResourceLoader
  implements Runnable
{
  private static final String CTFE_URL_PREFIX = "/r?id=";
  private static final String CTFE_URL_SUFFIX = "&v=a50788154";
  private static final String PREVIOUS_CONTAINER_VERSION_QUERY_NAME = "pv";
  @VisibleForTesting
  static final String SDK_VERSION = "a50788154";
  private LoadCallback<Serving.Resource> mCallback;
  private final NetworkClientFactory mClientFactory;
  private final String mContainerId;
  private final Context mContext;
  private volatile CtfeHost mCtfeHost;
  private volatile String mCtfeUrlPathAndQuery;
  private final String mDefaultCtfeUrlPathAndQuery;
  private volatile String mPreviousVersion;
  
  public ResourceLoader(Context paramContext, String paramString, CtfeHost paramCtfeHost)
  {
    this(paramContext, paramString, new NetworkClientFactory(), paramCtfeHost);
  }
  
  @VisibleForTesting
  ResourceLoader(Context paramContext, String paramString, NetworkClientFactory paramNetworkClientFactory, CtfeHost paramCtfeHost)
  {
    this.mContext = paramContext;
    this.mClientFactory = paramNetworkClientFactory;
    this.mContainerId = paramString;
    this.mCtfeHost = paramCtfeHost;
    this.mDefaultCtfeUrlPathAndQuery = ("/r?id=" + paramString);
    this.mCtfeUrlPathAndQuery = this.mDefaultCtfeUrlPathAndQuery;
    this.mPreviousVersion = null;
  }
  
  /* Error */
  private void loadResource()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 80	com/google/tagmanager/ResourceLoader:okToLoad	()Z
    //   4: ifne +16 -> 20
    //   7: aload_0
    //   8: getfield 82	com/google/tagmanager/ResourceLoader:mCallback	Lcom/google/tagmanager/LoadCallback;
    //   11: getstatic 88	com/google/tagmanager/LoadCallback$Failure:NOT_AVAILABLE	Lcom/google/tagmanager/LoadCallback$Failure;
    //   14: invokeinterface 94 2 0
    //   19: return
    //   20: ldc 96
    //   22: invokestatic 102	com/google/tagmanager/Log:v	(Ljava/lang/String;)V
    //   25: aload_0
    //   26: invokevirtual 105	com/google/tagmanager/ResourceLoader:getCtfeUrl	()Ljava/lang/String;
    //   29: astore_3
    //   30: aload_0
    //   31: getfield 49	com/google/tagmanager/ResourceLoader:mClientFactory	Lcom/google/tagmanager/NetworkClientFactory;
    //   34: invokevirtual 109	com/google/tagmanager/NetworkClientFactory:createNetworkClient	()Lcom/google/tagmanager/NetworkClient;
    //   37: astore_2
    //   38: aload_2
    //   39: aload_3
    //   40: invokeinterface 115 2 0
    //   45: astore_1
    //   46: aload_1
    //   47: invokestatic 121	com/google/tagmanager/ProtoExtensionRegistry:getRegistry	()Lcom/google/tagmanager/protobuf/ExtensionRegistryLite;
    //   50: invokestatic 127	com/google/analytics/containertag/proto/Serving$OptionalResource:parseFrom	(Ljava/io/InputStream;Lcom/google/tagmanager/protobuf/ExtensionRegistryLite;)Lcom/google/analytics/containertag/proto/Serving$OptionalResource;
    //   53: astore_1
    //   54: new 55	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   61: ldc -127
    //   63: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_1
    //   67: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 102	com/google/tagmanager/Log:v	(Ljava/lang/String;)V
    //   76: aload_1
    //   77: invokevirtual 135	com/google/analytics/containertag/proto/Serving$OptionalResource:hasResource	()Z
    //   80: ifne +28 -> 108
    //   83: new 55	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   90: ldc -119
    //   92: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload_0
    //   96: getfield 51	com/google/tagmanager/ResourceLoader:mContainerId	Ljava/lang/String;
    //   99: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 102	com/google/tagmanager/Log:v	(Ljava/lang/String;)V
    //   108: aload_0
    //   109: getfield 82	com/google/tagmanager/ResourceLoader:mCallback	Lcom/google/tagmanager/LoadCallback;
    //   112: astore 4
    //   114: aload_1
    //   115: invokevirtual 135	com/google/analytics/containertag/proto/Serving$OptionalResource:hasResource	()Z
    //   118: ifeq +142 -> 260
    //   121: aload_1
    //   122: invokevirtual 141	com/google/analytics/containertag/proto/Serving$OptionalResource:getResource	()Lcom/google/analytics/containertag/proto/Serving$Resource;
    //   125: astore_1
    //   126: aload 4
    //   128: aload_1
    //   129: invokeinterface 145 2 0
    //   134: aload_2
    //   135: invokeinterface 148 1 0
    //   140: ldc -106
    //   142: invokestatic 102	com/google/tagmanager/Log:v	(Ljava/lang/String;)V
    //   145: return
    //   146: astore_1
    //   147: new 55	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   154: ldc -104
    //   156: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_3
    //   160: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: ldc -102
    //   165: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload_0
    //   169: getfield 51	com/google/tagmanager/ResourceLoader:mContainerId	Ljava/lang/String;
    //   172: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: ldc -100
    //   177: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 159	com/google/tagmanager/Log:w	(Ljava/lang/String;)V
    //   186: aload_0
    //   187: getfield 82	com/google/tagmanager/ResourceLoader:mCallback	Lcom/google/tagmanager/LoadCallback;
    //   190: getstatic 162	com/google/tagmanager/LoadCallback$Failure:SERVER_ERROR	Lcom/google/tagmanager/LoadCallback$Failure;
    //   193: invokeinterface 94 2 0
    //   198: aload_2
    //   199: invokeinterface 148 1 0
    //   204: return
    //   205: astore_1
    //   206: new 55	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   213: ldc -92
    //   215: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload_3
    //   219: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: ldc -90
    //   224: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload_1
    //   228: invokevirtual 169	java/io/IOException:getMessage	()Ljava/lang/String;
    //   231: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: aload_1
    //   238: invokestatic 172	com/google/tagmanager/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   241: aload_0
    //   242: getfield 82	com/google/tagmanager/ResourceLoader:mCallback	Lcom/google/tagmanager/LoadCallback;
    //   245: getstatic 175	com/google/tagmanager/LoadCallback$Failure:IO_ERROR	Lcom/google/tagmanager/LoadCallback$Failure;
    //   248: invokeinterface 94 2 0
    //   253: aload_2
    //   254: invokeinterface 148 1 0
    //   259: return
    //   260: aconst_null
    //   261: astore_1
    //   262: goto -136 -> 126
    //   265: astore_1
    //   266: new 55	java/lang/StringBuilder
    //   269: dup
    //   270: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   273: ldc -79
    //   275: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload_3
    //   279: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: ldc -90
    //   284: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload_1
    //   288: invokevirtual 169	java/io/IOException:getMessage	()Ljava/lang/String;
    //   291: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: aload_1
    //   298: invokestatic 172	com/google/tagmanager/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   301: aload_0
    //   302: getfield 82	com/google/tagmanager/ResourceLoader:mCallback	Lcom/google/tagmanager/LoadCallback;
    //   305: getstatic 162	com/google/tagmanager/LoadCallback$Failure:SERVER_ERROR	Lcom/google/tagmanager/LoadCallback$Failure;
    //   308: invokeinterface 94 2 0
    //   313: aload_2
    //   314: invokeinterface 148 1 0
    //   319: return
    //   320: astore_1
    //   321: aload_2
    //   322: invokeinterface 148 1 0
    //   327: aload_1
    //   328: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	329	0	this	ResourceLoader
    //   45	84	1	localObject1	Object
    //   146	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   205	33	1	localIOException1	java.io.IOException
    //   261	1	1	localObject2	Object
    //   265	33	1	localIOException2	java.io.IOException
    //   320	8	1	localObject3	Object
    //   37	285	2	localNetworkClient	NetworkClient
    //   29	250	3	str	String
    //   112	15	4	localLoadCallback	LoadCallback
    // Exception table:
    //   from	to	target	type
    //   38	46	146	java/io/FileNotFoundException
    //   38	46	205	java/io/IOException
    //   46	108	265	java/io/IOException
    //   108	126	265	java/io/IOException
    //   126	134	265	java/io/IOException
    //   38	46	320	finally
    //   46	108	320	finally
    //   108	126	320	finally
    //   126	134	320	finally
    //   147	198	320	finally
    //   206	253	320	finally
    //   266	313	320	finally
  }
  
  private boolean okToLoad()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo == null) || (!localNetworkInfo.isConnected()))
    {
      Log.v("...no network connectivity");
      return false;
    }
    return true;
  }
  
  @VisibleForTesting
  String getCtfeUrl()
  {
    Object localObject2 = this.mCtfeHost.getCtfeServerAddress() + this.mCtfeUrlPathAndQuery + "&v=a50788154";
    Object localObject1 = localObject2;
    if (this.mPreviousVersion != null)
    {
      localObject1 = localObject2;
      if (!this.mPreviousVersion.trim().equals("")) {
        localObject1 = (String)localObject2 + "&pv=" + this.mPreviousVersion;
      }
    }
    localObject2 = localObject1;
    if (PreviewManager.getInstance().getPreviewMode().equals(PreviewManager.PreviewMode.CONTAINER_DEBUG)) {
      localObject2 = (String)localObject1 + "&gtm_debug=x";
    }
    return (String)localObject2;
  }
  
  public void run()
  {
    if (this.mCallback == null) {
      throw new IllegalStateException("callback must be set before execute");
    }
    this.mCallback.startLoad();
    loadResource();
  }
  
  @VisibleForTesting
  void setCtfeURLPathAndQuery(String paramString)
  {
    if (paramString == null)
    {
      this.mCtfeUrlPathAndQuery = this.mDefaultCtfeUrlPathAndQuery;
      return;
    }
    Log.d("Setting CTFE URL path: " + paramString);
    this.mCtfeUrlPathAndQuery = paramString;
  }
  
  void setLoadCallback(LoadCallback<Serving.Resource> paramLoadCallback)
  {
    this.mCallback = paramLoadCallback;
  }
  
  @VisibleForTesting
  void setPreviousVersion(String paramString)
  {
    Log.d("Setting previous container version: " + paramString);
    this.mPreviousVersion = paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/ResourceLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */