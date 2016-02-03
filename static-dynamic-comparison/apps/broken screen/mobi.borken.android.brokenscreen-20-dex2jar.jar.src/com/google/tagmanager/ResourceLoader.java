package com.google.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.analytics.containertag.proto.Serving.SupplementedResource;
import com.google.android.gms.common.util.VisibleForTesting;

class ResourceLoader
  implements Runnable
{
  private static final String CTFE_URL_PREFIX = "/r?id=";
  private static final String CTFE_URL_SUFFIX = "&v=a62676326";
  private static final String PREVIOUS_CONTAINER_VERSION_QUERY_NAME = "pv";
  @VisibleForTesting
  static final String SDK_VERSION = "a62676326";
  private LoadCallback<Serving.SupplementedResource> mCallback;
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
    //   29: astore_2
    //   30: aload_0
    //   31: getfield 49	com/google/tagmanager/ResourceLoader:mClientFactory	Lcom/google/tagmanager/NetworkClientFactory;
    //   34: invokevirtual 109	com/google/tagmanager/NetworkClientFactory:createNetworkClient	()Lcom/google/tagmanager/NetworkClient;
    //   37: astore_1
    //   38: aload_1
    //   39: aload_2
    //   40: invokeinterface 115 2 0
    //   45: astore_3
    //   46: new 117	java/io/ByteArrayOutputStream
    //   49: dup
    //   50: invokespecial 118	java/io/ByteArrayOutputStream:<init>	()V
    //   53: astore 4
    //   55: aload_3
    //   56: aload 4
    //   58: invokestatic 124	com/google/tagmanager/ResourceUtil:copyStream	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   61: aload 4
    //   63: invokevirtual 128	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   66: invokestatic 134	com/google/analytics/containertag/proto/Serving$SupplementedResource:parseFrom	([B)Lcom/google/analytics/containertag/proto/Serving$SupplementedResource;
    //   69: astore_3
    //   70: new 55	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   77: ldc -120
    //   79: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_3
    //   83: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 102	com/google/tagmanager/Log:v	(Ljava/lang/String;)V
    //   92: aload_3
    //   93: getfield 143	com/google/analytics/containertag/proto/Serving$SupplementedResource:resource	Lcom/google/analytics/containertag/proto/Serving$Resource;
    //   96: ifnonnull +28 -> 124
    //   99: new 55	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   106: ldc -111
    //   108: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_0
    //   112: getfield 51	com/google/tagmanager/ResourceLoader:mContainerId	Ljava/lang/String;
    //   115: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 102	com/google/tagmanager/Log:v	(Ljava/lang/String;)V
    //   124: aload_0
    //   125: getfield 82	com/google/tagmanager/ResourceLoader:mCallback	Lcom/google/tagmanager/LoadCallback;
    //   128: aload_3
    //   129: invokeinterface 149 2 0
    //   134: aload_1
    //   135: invokeinterface 152 1 0
    //   140: ldc -102
    //   142: invokestatic 102	com/google/tagmanager/Log:v	(Ljava/lang/String;)V
    //   145: return
    //   146: astore_3
    //   147: new 55	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   154: ldc -100
    //   156: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_2
    //   160: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: ldc -98
    //   165: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload_0
    //   169: getfield 51	com/google/tagmanager/ResourceLoader:mContainerId	Ljava/lang/String;
    //   172: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: ldc -96
    //   177: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 163	com/google/tagmanager/Log:w	(Ljava/lang/String;)V
    //   186: aload_0
    //   187: getfield 82	com/google/tagmanager/ResourceLoader:mCallback	Lcom/google/tagmanager/LoadCallback;
    //   190: getstatic 166	com/google/tagmanager/LoadCallback$Failure:SERVER_ERROR	Lcom/google/tagmanager/LoadCallback$Failure;
    //   193: invokeinterface 94 2 0
    //   198: aload_1
    //   199: invokeinterface 152 1 0
    //   204: return
    //   205: astore_3
    //   206: new 55	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   213: ldc -88
    //   215: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload_2
    //   219: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: ldc -86
    //   224: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload_3
    //   228: invokevirtual 173	java/io/IOException:getMessage	()Ljava/lang/String;
    //   231: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: aload_3
    //   238: invokestatic 176	com/google/tagmanager/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   241: aload_0
    //   242: getfield 82	com/google/tagmanager/ResourceLoader:mCallback	Lcom/google/tagmanager/LoadCallback;
    //   245: getstatic 179	com/google/tagmanager/LoadCallback$Failure:IO_ERROR	Lcom/google/tagmanager/LoadCallback$Failure;
    //   248: invokeinterface 94 2 0
    //   253: aload_1
    //   254: invokeinterface 152 1 0
    //   259: return
    //   260: astore_3
    //   261: new 55	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   268: ldc -75
    //   270: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: aload_2
    //   274: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: ldc -86
    //   279: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload_3
    //   283: invokevirtual 173	java/io/IOException:getMessage	()Ljava/lang/String;
    //   286: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: aload_3
    //   293: invokestatic 176	com/google/tagmanager/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   296: aload_0
    //   297: getfield 82	com/google/tagmanager/ResourceLoader:mCallback	Lcom/google/tagmanager/LoadCallback;
    //   300: getstatic 166	com/google/tagmanager/LoadCallback$Failure:SERVER_ERROR	Lcom/google/tagmanager/LoadCallback$Failure;
    //   303: invokeinterface 94 2 0
    //   308: aload_1
    //   309: invokeinterface 152 1 0
    //   314: return
    //   315: astore_2
    //   316: aload_1
    //   317: invokeinterface 152 1 0
    //   322: aload_2
    //   323: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	324	0	this	ResourceLoader
    //   37	280	1	localNetworkClient	NetworkClient
    //   29	245	2	str	String
    //   315	8	2	localObject1	Object
    //   45	84	3	localObject2	Object
    //   146	1	3	localFileNotFoundException	java.io.FileNotFoundException
    //   205	33	3	localIOException1	java.io.IOException
    //   260	33	3	localIOException2	java.io.IOException
    //   53	9	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   38	46	146	java/io/FileNotFoundException
    //   38	46	205	java/io/IOException
    //   46	124	260	java/io/IOException
    //   124	134	260	java/io/IOException
    //   38	46	315	finally
    //   46	124	315	finally
    //   124	134	315	finally
    //   147	198	315	finally
    //   206	253	315	finally
    //   261	308	315	finally
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
    Object localObject2 = this.mCtfeHost.getCtfeServerAddress() + this.mCtfeUrlPathAndQuery + "&v=a62676326";
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
  
  void setLoadCallback(LoadCallback<Serving.SupplementedResource> paramLoadCallback)
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/ResourceLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */