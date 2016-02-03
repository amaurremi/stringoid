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
    //   47: aload_2
    //   48: invokestatic 172	com/google/tagmanager/ProtoExtensionRegistry:getRegistry	()Lcom/google/tagmanager/protobuf/ExtensionRegistryLite;
    //   51: invokestatic 178	com/google/analytics/containertag/proto/Serving$Resource:parseFrom	(Ljava/io/InputStream;Lcom/google/tagmanager/protobuf/ExtensionRegistryLite;)Lcom/google/analytics/containertag/proto/Serving$Resource;
    //   54: astore_3
    //   55: new 90	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   62: ldc -76
    //   64: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_3
    //   68: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 120	com/google/tagmanager/Log:v	(Ljava/lang/String;)V
    //   77: aload_2
    //   78: invokevirtual 146	java/io/InputStream:close	()V
    //   81: aload_3
    //   82: areturn
    //   83: astore_1
    //   84: aload_3
    //   85: areturn
    //   86: astore_2
    //   87: new 90	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   94: ldc -108
    //   96: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_1
    //   100: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc -74
    //   105: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 129	com/google/tagmanager/Log:w	(Ljava/lang/String;)V
    //   114: aconst_null
    //   115: areturn
    //   116: astore_3
    //   117: new 90	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   124: ldc -72
    //   126: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_1
    //   130: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 129	com/google/tagmanager/Log:w	(Ljava/lang/String;)V
    //   139: aload_2
    //   140: invokevirtual 146	java/io/InputStream:close	()V
    //   143: aconst_null
    //   144: areturn
    //   145: astore_1
    //   146: aload_2
    //   147: invokevirtual 146	java/io/InputStream:close	()V
    //   150: aload_1
    //   151: athrow
    //   152: astore_1
    //   153: goto -10 -> 143
    //   156: astore_2
    //   157: goto -7 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	ResourceStorageImpl
    //   0	160	1	paramString	String
    //   29	49	2	localObject	Object
    //   86	61	2	localIOException1	IOException
    //   156	1	2	localIOException2	IOException
    //   54	31	3	localResource	com.google.analytics.containertag.proto.Serving.Resource
    //   116	1	3	localIOException3	IOException
    // Exception table:
    //   from	to	target	type
    //   77	81	83	java/io/IOException
    //   41	47	86	java/io/IOException
    //   47	77	116	java/io/IOException
    //   47	77	145	finally
    //   117	139	145	finally
    //   139	143	152	java/io/IOException
    //   146	150	156	java/io/IOException
  }
  
  /* Error */
  @VisibleForTesting
  void loadResourceFromDisk()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 189	com/google/tagmanager/ResourceStorageImpl:mCallback	Lcom/google/tagmanager/LoadCallback;
    //   4: ifnonnull +13 -> 17
    //   7: new 191	java/lang/IllegalStateException
    //   10: dup
    //   11: ldc -63
    //   13: invokespecial 195	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: aload_0
    //   18: getfield 189	com/google/tagmanager/ResourceStorageImpl:mCallback	Lcom/google/tagmanager/LoadCallback;
    //   21: invokeinterface 200 1 0
    //   26: ldc -54
    //   28: invokestatic 120	com/google/tagmanager/Log:v	(Ljava/lang/String;)V
    //   31: invokestatic 208	com/google/tagmanager/PreviewManager:getInstance	()Lcom/google/tagmanager/PreviewManager;
    //   34: invokevirtual 212	com/google/tagmanager/PreviewManager:getPreviewMode	()Lcom/google/tagmanager/PreviewManager$PreviewMode;
    //   37: getstatic 218	com/google/tagmanager/PreviewManager$PreviewMode:CONTAINER	Lcom/google/tagmanager/PreviewManager$PreviewMode;
    //   40: if_acmpeq +15 -> 55
    //   43: invokestatic 208	com/google/tagmanager/PreviewManager:getInstance	()Lcom/google/tagmanager/PreviewManager;
    //   46: invokevirtual 212	com/google/tagmanager/PreviewManager:getPreviewMode	()Lcom/google/tagmanager/PreviewManager$PreviewMode;
    //   49: getstatic 221	com/google/tagmanager/PreviewManager$PreviewMode:CONTAINER_DEBUG	Lcom/google/tagmanager/PreviewManager$PreviewMode;
    //   52: if_acmpne +32 -> 84
    //   55: aload_0
    //   56: getfield 34	com/google/tagmanager/ResourceStorageImpl:mContainerId	Ljava/lang/String;
    //   59: invokestatic 208	com/google/tagmanager/PreviewManager:getInstance	()Lcom/google/tagmanager/PreviewManager;
    //   62: invokevirtual 224	com/google/tagmanager/PreviewManager:getContainerId	()Ljava/lang/String;
    //   65: invokevirtual 230	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   68: ifeq +16 -> 84
    //   71: aload_0
    //   72: getfield 189	com/google/tagmanager/ResourceStorageImpl:mCallback	Lcom/google/tagmanager/LoadCallback;
    //   75: getstatic 236	com/google/tagmanager/LoadCallback$Failure:NOT_AVAILABLE	Lcom/google/tagmanager/LoadCallback$Failure;
    //   78: invokeinterface 240 2 0
    //   83: return
    //   84: new 242	java/io/FileInputStream
    //   87: dup
    //   88: aload_0
    //   89: invokevirtual 244	com/google/tagmanager/ResourceStorageImpl:getResourceFile	()Ljava/io/File;
    //   92: invokespecial 247	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   95: astore_1
    //   96: aload_0
    //   97: getfield 189	com/google/tagmanager/ResourceStorageImpl:mCallback	Lcom/google/tagmanager/LoadCallback;
    //   100: aload_1
    //   101: invokestatic 172	com/google/tagmanager/ProtoExtensionRegistry:getRegistry	()Lcom/google/tagmanager/protobuf/ExtensionRegistryLite;
    //   104: invokestatic 252	com/google/tagmanager/proto/Resource$ResourceWithMetadata:parseFrom	(Ljava/io/InputStream;Lcom/google/tagmanager/protobuf/ExtensionRegistryLite;)Lcom/google/tagmanager/proto/Resource$ResourceWithMetadata;
    //   107: invokeinterface 256 2 0
    //   112: aload_1
    //   113: invokevirtual 257	java/io/FileInputStream:close	()V
    //   116: ldc_w 259
    //   119: invokestatic 120	com/google/tagmanager/Log:v	(Ljava/lang/String;)V
    //   122: return
    //   123: astore_1
    //   124: ldc_w 261
    //   127: invokestatic 264	com/google/tagmanager/Log:d	(Ljava/lang/String;)V
    //   130: aload_0
    //   131: getfield 189	com/google/tagmanager/ResourceStorageImpl:mCallback	Lcom/google/tagmanager/LoadCallback;
    //   134: getstatic 236	com/google/tagmanager/LoadCallback$Failure:NOT_AVAILABLE	Lcom/google/tagmanager/LoadCallback$Failure;
    //   137: invokeinterface 240 2 0
    //   142: return
    //   143: astore_1
    //   144: ldc_w 266
    //   147: invokestatic 129	com/google/tagmanager/Log:w	(Ljava/lang/String;)V
    //   150: goto -34 -> 116
    //   153: astore_2
    //   154: ldc_w 268
    //   157: invokestatic 129	com/google/tagmanager/Log:w	(Ljava/lang/String;)V
    //   160: aload_0
    //   161: getfield 189	com/google/tagmanager/ResourceStorageImpl:mCallback	Lcom/google/tagmanager/LoadCallback;
    //   164: getstatic 271	com/google/tagmanager/LoadCallback$Failure:IO_ERROR	Lcom/google/tagmanager/LoadCallback$Failure;
    //   167: invokeinterface 240 2 0
    //   172: aload_1
    //   173: invokevirtual 257	java/io/FileInputStream:close	()V
    //   176: goto -60 -> 116
    //   179: astore_1
    //   180: ldc_w 266
    //   183: invokestatic 129	com/google/tagmanager/Log:w	(Ljava/lang/String;)V
    //   186: goto -70 -> 116
    //   189: astore_2
    //   190: aload_1
    //   191: invokevirtual 257	java/io/FileInputStream:close	()V
    //   194: aload_2
    //   195: athrow
    //   196: astore_1
    //   197: ldc_w 266
    //   200: invokestatic 129	com/google/tagmanager/Log:w	(Ljava/lang/String;)V
    //   203: goto -9 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	ResourceStorageImpl
    //   95	18	1	localFileInputStream	java.io.FileInputStream
    //   123	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   143	30	1	localIOException1	IOException
    //   179	12	1	localIOException2	IOException
    //   196	1	1	localIOException3	IOException
    //   153	1	2	localIOException4	IOException
    //   189	6	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   84	96	123	java/io/FileNotFoundException
    //   112	116	143	java/io/IOException
    //   96	112	153	java/io/IOException
    //   172	176	179	java/io/IOException
    //   96	112	189	finally
    //   154	172	189	finally
    //   190	194	196	java/io/IOException
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
    //   1: invokevirtual 244	com/google/tagmanager/ResourceStorageImpl:getResourceFile	()Ljava/io/File;
    //   4: astore_3
    //   5: new 283	java/io/FileOutputStream
    //   8: dup
    //   9: aload_3
    //   10: invokespecial 284	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   13: astore_2
    //   14: aload_1
    //   15: aload_2
    //   16: invokevirtual 288	com/google/tagmanager/proto/Resource$ResourceWithMetadata:writeTo	(Ljava/io/OutputStream;)V
    //   19: aload_2
    //   20: invokevirtual 289	java/io/FileOutputStream:close	()V
    //   23: iconst_1
    //   24: ireturn
    //   25: astore_1
    //   26: ldc_w 291
    //   29: invokestatic 166	com/google/tagmanager/Log:e	(Ljava/lang/String;)V
    //   32: iconst_0
    //   33: ireturn
    //   34: astore_1
    //   35: ldc_w 293
    //   38: invokestatic 129	com/google/tagmanager/Log:w	(Ljava/lang/String;)V
    //   41: goto -18 -> 23
    //   44: astore_1
    //   45: ldc_w 295
    //   48: invokestatic 129	com/google/tagmanager/Log:w	(Ljava/lang/String;)V
    //   51: aload_3
    //   52: invokevirtual 299	java/io/File:delete	()Z
    //   55: pop
    //   56: aload_2
    //   57: invokevirtual 289	java/io/FileOutputStream:close	()V
    //   60: iconst_0
    //   61: ireturn
    //   62: astore_1
    //   63: ldc_w 293
    //   66: invokestatic 129	com/google/tagmanager/Log:w	(Ljava/lang/String;)V
    //   69: goto -9 -> 60
    //   72: astore_1
    //   73: aload_2
    //   74: invokevirtual 289	java/io/FileOutputStream:close	()V
    //   77: aload_1
    //   78: athrow
    //   79: astore_2
    //   80: ldc_w 293
    //   83: invokestatic 129	com/google/tagmanager/Log:w	(Ljava/lang/String;)V
    //   86: goto -9 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	ResourceStorageImpl
    //   0	89	1	paramResourceWithMetadata	Resource.ResourceWithMetadata
    //   13	61	2	localFileOutputStream	java.io.FileOutputStream
    //   79	1	2	localIOException	IOException
    //   4	48	3	localFile	File
    // Exception table:
    //   from	to	target	type
    //   5	14	25	java/io/FileNotFoundException
    //   19	23	34	java/io/IOException
    //   14	19	44	java/io/IOException
    //   56	60	62	java/io/IOException
    //   14	19	72	finally
    //   45	56	72	finally
    //   73	77	79	java/io/IOException
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/ResourceStorageImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */