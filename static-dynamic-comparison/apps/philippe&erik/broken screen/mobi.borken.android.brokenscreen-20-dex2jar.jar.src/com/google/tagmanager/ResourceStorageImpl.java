package com.google.tagmanager;

import android.content.Context;
import android.content.res.AssetManager;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.proto.Resource.ResourceWithMetadata;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

class ResourceStorageImpl
  implements Container.ResourceStorage
{
  private static final String SAVED_RESOURCE_FILENAME_PREFIX = "resource_";
  private static final String SAVED_RESOURCE_SUB_DIR = "google_tagmanager";
  private LoadCallback<Resource.ResourceWithMetadata> mCallback;
  private final String mContainerId;
  private final Context mContext;
  private final ExecutorService mExecutor;
  
  ResourceStorageImpl(Context paramContext, String paramString)
  {
    this.mContext = paramContext;
    this.mContainerId = paramString;
    this.mExecutor = Executors.newSingleThreadExecutor();
  }
  
  private String stringFromInputStream(InputStream paramInputStream)
    throws IOException
  {
    StringWriter localStringWriter = new StringWriter();
    char[] arrayOfChar = new char['Ѐ'];
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream, "UTF-8"));
    for (;;)
    {
      int i = paramInputStream.read(arrayOfChar);
      if (i == -1) {
        break;
      }
      localStringWriter.write(arrayOfChar, 0, i);
    }
    return localStringWriter.toString();
  }
  
  public void close()
  {
    try
    {
      this.mExecutor.shutdown();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  @VisibleForTesting
  File getResourceFile()
  {
    String str = "resource_" + this.mContainerId;
    return new File(this.mContext.getDir("google_tagmanager", 0), str);
  }
  
  public ResourceUtil.ExpandedResource loadExpandedResourceFromJsonAsset(String paramString)
  {
    Object localObject6 = null;
    Log.v("loading default container from " + paramString);
    Object localObject5 = this.mContext.getAssets();
    if (localObject5 == null)
    {
      Log.w("Looking for default JSON container in package, but no assets were found.");
      paramString = (String)localObject6;
    }
    Object localObject2;
    for (;;)
    {
      return paramString;
      Object localObject4 = null;
      Object localObject1 = null;
      Object localObject3 = null;
      try
      {
        localObject5 = ((AssetManager)localObject5).open(paramString);
        localObject3 = localObject5;
        localObject4 = localObject5;
        localObject1 = localObject5;
        ResourceUtil.ExpandedResource localExpandedResource = JsonUtils.expandedResourceFromJsonString(stringFromInputStream((InputStream)localObject5));
        localObject1 = localExpandedResource;
        paramString = (String)localObject1;
        if (localObject5 != null) {
          try
          {
            ((InputStream)localObject5).close();
            return (ResourceUtil.ExpandedResource)localObject1;
          }
          catch (IOException paramString)
          {
            return (ResourceUtil.ExpandedResource)localObject1;
          }
        }
      }
      catch (IOException localIOException1)
      {
        localObject2 = localObject3;
        Log.w("No asset file: " + paramString + " found (or errors reading it).");
        paramString = (String)localObject6;
        if (localObject3 != null) {
          try
          {
            ((InputStream)localObject3).close();
            return null;
          }
          catch (IOException paramString)
          {
            return null;
          }
        }
      }
      catch (JSONException localJSONException)
      {
        localObject2 = localObject4;
        Log.w("Error parsing JSON file" + paramString + " : " + localJSONException);
        paramString = (String)localObject6;
        if (localObject4 != null) {
          try
          {
            ((InputStream)localObject4).close();
            return null;
          }
          catch (IOException paramString)
          {
            return null;
          }
        }
      }
      finally
      {
        if (localObject2 == null) {}
      }
    }
    try
    {
      ((InputStream)localObject2).close();
      throw paramString;
    }
    catch (IOException localIOException2)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  public com.google.analytics.containertag.proto.Serving.Resource loadResourceFromContainerAsset(String paramString)
  {
    // Byte code:
    //   0: new 90	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   7: ldc -95
    //   9: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12: aload_1
    //   13: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   19: invokestatic 120	com/google/tagmanager/Log:v	(Ljava/lang/String;)V
    //   22: aload_0
    //   23: getfield 32	com/google/tagmanager/ResourceStorageImpl:mContext	Landroid/content/Context;
    //   26: invokevirtual 124	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   29: astore_2
    //   30: aload_2
    //   31: ifnonnull +10 -> 41
    //   34: ldc -93
    //   36: invokestatic 166	com/google/tagmanager/Log:e	(Ljava/lang/String;)V
    //   39: aconst_null
    //   40: areturn
    //   41: aload_2
    //   42: aload_1
    //   43: invokevirtual 135	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   46: astore_2
    //   47: new 168	java/io/ByteArrayOutputStream
    //   50: dup
    //   51: invokespecial 169	java/io/ByteArrayOutputStream:<init>	()V
    //   54: astore_3
    //   55: aload_2
    //   56: aload_3
    //   57: invokestatic 175	com/google/tagmanager/ResourceUtil:copyStream	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   60: aload_3
    //   61: invokevirtual 179	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   64: invokestatic 185	com/google/analytics/containertag/proto/Serving$Resource:parseFrom	([B)Lcom/google/analytics/containertag/proto/Serving$Resource;
    //   67: astore_3
    //   68: new 90	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   75: ldc -69
    //   77: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_3
    //   81: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 120	com/google/tagmanager/Log:v	(Ljava/lang/String;)V
    //   90: aload_2
    //   91: invokevirtual 146	java/io/InputStream:close	()V
    //   94: aload_3
    //   95: areturn
    //   96: astore_1
    //   97: aload_3
    //   98: areturn
    //   99: astore_2
    //   100: new 90	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   107: ldc -108
    //   109: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_1
    //   113: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: ldc -67
    //   118: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 129	com/google/tagmanager/Log:w	(Ljava/lang/String;)V
    //   127: aconst_null
    //   128: areturn
    //   129: astore_3
    //   130: new 90	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   137: ldc -65
    //   139: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_1
    //   143: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 129	com/google/tagmanager/Log:w	(Ljava/lang/String;)V
    //   152: aload_2
    //   153: invokevirtual 146	java/io/InputStream:close	()V
    //   156: aconst_null
    //   157: areturn
    //   158: astore_1
    //   159: aload_2
    //   160: invokevirtual 146	java/io/InputStream:close	()V
    //   163: aload_1
    //   164: athrow
    //   165: astore_1
    //   166: goto -10 -> 156
    //   169: astore_2
    //   170: goto -7 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	ResourceStorageImpl
    //   0	173	1	paramString	String
    //   29	62	2	localObject1	Object
    //   99	61	2	localIOException1	IOException
    //   169	1	2	localIOException2	IOException
    //   54	44	3	localObject2	Object
    //   129	1	3	localIOException3	IOException
    // Exception table:
    //   from	to	target	type
    //   90	94	96	java/io/IOException
    //   41	47	99	java/io/IOException
    //   47	90	129	java/io/IOException
    //   47	90	158	finally
    //   130	152	158	finally
    //   152	156	165	java/io/IOException
    //   159	163	169	java/io/IOException
  }
  
  /* Error */
  @VisibleForTesting
  void loadResourceFromDisk()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 196	com/google/tagmanager/ResourceStorageImpl:mCallback	Lcom/google/tagmanager/LoadCallback;
    //   4: ifnonnull +13 -> 17
    //   7: new 198	java/lang/IllegalStateException
    //   10: dup
    //   11: ldc -56
    //   13: invokespecial 202	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: aload_0
    //   18: getfield 196	com/google/tagmanager/ResourceStorageImpl:mCallback	Lcom/google/tagmanager/LoadCallback;
    //   21: invokeinterface 207 1 0
    //   26: ldc -47
    //   28: invokestatic 120	com/google/tagmanager/Log:v	(Ljava/lang/String;)V
    //   31: invokestatic 215	com/google/tagmanager/PreviewManager:getInstance	()Lcom/google/tagmanager/PreviewManager;
    //   34: invokevirtual 219	com/google/tagmanager/PreviewManager:getPreviewMode	()Lcom/google/tagmanager/PreviewManager$PreviewMode;
    //   37: getstatic 225	com/google/tagmanager/PreviewManager$PreviewMode:CONTAINER	Lcom/google/tagmanager/PreviewManager$PreviewMode;
    //   40: if_acmpeq +15 -> 55
    //   43: invokestatic 215	com/google/tagmanager/PreviewManager:getInstance	()Lcom/google/tagmanager/PreviewManager;
    //   46: invokevirtual 219	com/google/tagmanager/PreviewManager:getPreviewMode	()Lcom/google/tagmanager/PreviewManager$PreviewMode;
    //   49: getstatic 228	com/google/tagmanager/PreviewManager$PreviewMode:CONTAINER_DEBUG	Lcom/google/tagmanager/PreviewManager$PreviewMode;
    //   52: if_acmpne +32 -> 84
    //   55: aload_0
    //   56: getfield 34	com/google/tagmanager/ResourceStorageImpl:mContainerId	Ljava/lang/String;
    //   59: invokestatic 215	com/google/tagmanager/PreviewManager:getInstance	()Lcom/google/tagmanager/PreviewManager;
    //   62: invokevirtual 231	com/google/tagmanager/PreviewManager:getContainerId	()Ljava/lang/String;
    //   65: invokevirtual 237	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   68: ifeq +16 -> 84
    //   71: aload_0
    //   72: getfield 196	com/google/tagmanager/ResourceStorageImpl:mCallback	Lcom/google/tagmanager/LoadCallback;
    //   75: getstatic 243	com/google/tagmanager/LoadCallback$Failure:NOT_AVAILABLE	Lcom/google/tagmanager/LoadCallback$Failure;
    //   78: invokeinterface 247 2 0
    //   83: return
    //   84: new 249	java/io/FileInputStream
    //   87: dup
    //   88: aload_0
    //   89: invokevirtual 251	com/google/tagmanager/ResourceStorageImpl:getResourceFile	()Ljava/io/File;
    //   92: invokespecial 254	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   95: astore_1
    //   96: new 168	java/io/ByteArrayOutputStream
    //   99: dup
    //   100: invokespecial 169	java/io/ByteArrayOutputStream:<init>	()V
    //   103: astore_2
    //   104: aload_1
    //   105: aload_2
    //   106: invokestatic 175	com/google/tagmanager/ResourceUtil:copyStream	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   109: aload_0
    //   110: getfield 196	com/google/tagmanager/ResourceStorageImpl:mCallback	Lcom/google/tagmanager/LoadCallback;
    //   113: aload_2
    //   114: invokevirtual 179	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   117: invokestatic 259	com/google/tagmanager/proto/Resource$ResourceWithMetadata:parseFrom	([B)Lcom/google/tagmanager/proto/Resource$ResourceWithMetadata;
    //   120: invokeinterface 263 2 0
    //   125: aload_1
    //   126: invokevirtual 264	java/io/FileInputStream:close	()V
    //   129: ldc_w 266
    //   132: invokestatic 120	com/google/tagmanager/Log:v	(Ljava/lang/String;)V
    //   135: return
    //   136: astore_1
    //   137: ldc_w 268
    //   140: invokestatic 271	com/google/tagmanager/Log:d	(Ljava/lang/String;)V
    //   143: aload_0
    //   144: getfield 196	com/google/tagmanager/ResourceStorageImpl:mCallback	Lcom/google/tagmanager/LoadCallback;
    //   147: getstatic 243	com/google/tagmanager/LoadCallback$Failure:NOT_AVAILABLE	Lcom/google/tagmanager/LoadCallback$Failure;
    //   150: invokeinterface 247 2 0
    //   155: return
    //   156: astore_1
    //   157: ldc_w 273
    //   160: invokestatic 129	com/google/tagmanager/Log:w	(Ljava/lang/String;)V
    //   163: goto -34 -> 129
    //   166: astore_2
    //   167: ldc_w 275
    //   170: invokestatic 129	com/google/tagmanager/Log:w	(Ljava/lang/String;)V
    //   173: aload_0
    //   174: getfield 196	com/google/tagmanager/ResourceStorageImpl:mCallback	Lcom/google/tagmanager/LoadCallback;
    //   177: getstatic 278	com/google/tagmanager/LoadCallback$Failure:IO_ERROR	Lcom/google/tagmanager/LoadCallback$Failure;
    //   180: invokeinterface 247 2 0
    //   185: aload_1
    //   186: invokevirtual 264	java/io/FileInputStream:close	()V
    //   189: goto -60 -> 129
    //   192: astore_1
    //   193: ldc_w 273
    //   196: invokestatic 129	com/google/tagmanager/Log:w	(Ljava/lang/String;)V
    //   199: goto -70 -> 129
    //   202: astore_2
    //   203: aload_1
    //   204: invokevirtual 264	java/io/FileInputStream:close	()V
    //   207: aload_2
    //   208: athrow
    //   209: astore_1
    //   210: ldc_w 273
    //   213: invokestatic 129	com/google/tagmanager/Log:w	(Ljava/lang/String;)V
    //   216: goto -9 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	ResourceStorageImpl
    //   95	31	1	localFileInputStream	java.io.FileInputStream
    //   136	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   156	30	1	localIOException1	IOException
    //   192	12	1	localIOException2	IOException
    //   209	1	1	localIOException3	IOException
    //   103	11	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   166	1	2	localIOException4	IOException
    //   202	6	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   84	96	136	java/io/FileNotFoundException
    //   125	129	156	java/io/IOException
    //   96	125	166	java/io/IOException
    //   185	189	192	java/io/IOException
    //   96	125	202	finally
    //   167	185	202	finally
    //   203	207	209	java/io/IOException
  }
  
  public void loadResourceFromDiskInBackground()
  {
    this.mExecutor.execute(new Runnable()
    {
      public void run()
      {
        ResourceStorageImpl.this.loadResourceFromDisk();
      }
    });
  }
  
  /* Error */
  @VisibleForTesting
  boolean saveResourceToDisk(Resource.ResourceWithMetadata paramResourceWithMetadata)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 251	com/google/tagmanager/ResourceStorageImpl:getResourceFile	()Ljava/io/File;
    //   4: astore_3
    //   5: new 290	java/io/FileOutputStream
    //   8: dup
    //   9: aload_3
    //   10: invokespecial 291	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   13: astore_2
    //   14: aload_2
    //   15: aload_1
    //   16: invokestatic 296	com/google/tagmanager/protobuf/nano/MessageNano:toByteArray	(Lcom/google/tagmanager/protobuf/nano/MessageNano;)[B
    //   19: invokevirtual 299	java/io/FileOutputStream:write	([B)V
    //   22: aload_2
    //   23: invokevirtual 300	java/io/FileOutputStream:close	()V
    //   26: iconst_1
    //   27: ireturn
    //   28: astore_1
    //   29: ldc_w 302
    //   32: invokestatic 166	com/google/tagmanager/Log:e	(Ljava/lang/String;)V
    //   35: iconst_0
    //   36: ireturn
    //   37: astore_1
    //   38: ldc_w 304
    //   41: invokestatic 129	com/google/tagmanager/Log:w	(Ljava/lang/String;)V
    //   44: goto -18 -> 26
    //   47: astore_1
    //   48: ldc_w 306
    //   51: invokestatic 129	com/google/tagmanager/Log:w	(Ljava/lang/String;)V
    //   54: aload_3
    //   55: invokevirtual 310	java/io/File:delete	()Z
    //   58: pop
    //   59: aload_2
    //   60: invokevirtual 300	java/io/FileOutputStream:close	()V
    //   63: iconst_0
    //   64: ireturn
    //   65: astore_1
    //   66: ldc_w 304
    //   69: invokestatic 129	com/google/tagmanager/Log:w	(Ljava/lang/String;)V
    //   72: goto -9 -> 63
    //   75: astore_1
    //   76: aload_2
    //   77: invokevirtual 300	java/io/FileOutputStream:close	()V
    //   80: aload_1
    //   81: athrow
    //   82: astore_2
    //   83: ldc_w 304
    //   86: invokestatic 129	com/google/tagmanager/Log:w	(Ljava/lang/String;)V
    //   89: goto -9 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	ResourceStorageImpl
    //   0	92	1	paramResourceWithMetadata	Resource.ResourceWithMetadata
    //   13	64	2	localFileOutputStream	java.io.FileOutputStream
    //   82	1	2	localIOException	IOException
    //   4	51	3	localFile	File
    // Exception table:
    //   from	to	target	type
    //   5	14	28	java/io/FileNotFoundException
    //   22	26	37	java/io/IOException
    //   14	22	47	java/io/IOException
    //   59	63	65	java/io/IOException
    //   14	22	75	finally
    //   48	59	75	finally
    //   76	80	82	java/io/IOException
  }
  
  public void saveResourceToDiskInBackground(final Resource.ResourceWithMetadata paramResourceWithMetadata)
  {
    this.mExecutor.execute(new Runnable()
    {
      public void run()
      {
        ResourceStorageImpl.this.saveResourceToDisk(paramResourceWithMetadata);
      }
    });
  }
  
  public void setLoadCallback(LoadCallback<Resource.ResourceWithMetadata> paramLoadCallback)
  {
    this.mCallback = paramLoadCallback;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/ResourceStorageImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */