package com.millennialmedia.android;

import android.content.Context;
import android.net.Uri;
import android.os.StatFs;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONArray;

class BridgeMMFileManager
  extends MMJSObject
{
  private File root;
  
  private boolean hasCreativeDirectory()
  {
    Object localObject = (Context)this.contextRef.get();
    if (localObject != null)
    {
      localObject = AdCache.getCacheDirectory((Context)localObject);
      this.root = ((File)localObject);
      if (localObject != null) {
        return true;
      }
    }
    return false;
  }
  
  public MMJSResponse cleanupCache(HashMap<String, String> paramHashMap)
  {
    boolean bool = false;
    long l = 259200000L;
    if (hasCreativeDirectory())
    {
      if (paramHashMap.containsKey("clear")) {
        bool = Boolean.parseBoolean((String)paramHashMap.get("clear"));
      }
      if (!bool) {
        break label51;
      }
      l = 0L;
    }
    try
    {
      for (;;)
      {
        AdCache.cleanupDirectory(this.root, l);
        return null;
        label51:
        paramHashMap = (Context)this.contextRef.get();
        if (paramHashMap != null) {
          l = HandShake.sharedHandShake(paramHashMap).creativeCacheTimeout;
        }
      }
    }
    catch (SecurityException paramHashMap)
    {
      for (;;) {}
    }
  }
  
  public MMJSResponse downloadFile(HashMap<String, String> paramHashMap)
  {
    Context localContext = (Context)this.contextRef.get();
    String str = (String)paramHashMap.get("url");
    if ((!TextUtils.isEmpty(str)) && (localContext != null))
    {
      if (paramHashMap.containsKey("path")) {}
      for (paramHashMap = (String)paramHashMap.get("path"); AdCache.downloadComponentToCache(str, paramHashMap, localContext); paramHashMap = Uri.parse((String)paramHashMap.get("url")).getLastPathSegment()) {
        return MMJSResponse.responseWithSuccess(paramHashMap);
      }
    }
    return null;
  }
  
  public MMJSResponse getDirectoryContents(HashMap<String, String> paramHashMap)
  {
    if (hasCreativeDirectory())
    {
      if (paramHashMap.containsKey("path")) {}
      JSONArray localJSONArray;
      for (paramHashMap = new File(this.root, (String)paramHashMap.get("path"));; paramHashMap = this.root)
      {
        localJSONArray = new JSONArray();
        paramHashMap = paramHashMap.list();
        int j = paramHashMap.length;
        int i = 0;
        while (i < j)
        {
          localJSONArray.put(paramHashMap[i]);
          i += 1;
        }
      }
      paramHashMap = new MMJSResponse();
      paramHashMap.result = 1;
      paramHashMap.response = localJSONArray;
      return paramHashMap;
    }
    return null;
  }
  
  /* Error */
  public MMJSResponse getFileContents(HashMap<String, String> paramHashMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 41	com/millennialmedia/android/BridgeMMFileManager:hasCreativeDirectory	()Z
    //   4: ifeq +140 -> 144
    //   7: aconst_null
    //   8: astore_2
    //   9: aconst_null
    //   10: astore_3
    //   11: aload_1
    //   12: ldc 87
    //   14: invokevirtual 49	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   17: ifeq +127 -> 144
    //   20: new 110	java/io/File
    //   23: dup
    //   24: aload_0
    //   25: getfield 33	com/millennialmedia/android/BridgeMMFileManager:root	Ljava/io/File;
    //   28: aload_1
    //   29: ldc 87
    //   31: invokevirtual 52	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   34: checkcast 54	java/lang/String
    //   37: invokespecial 113	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   40: astore 4
    //   42: new 138	java/io/FileInputStream
    //   45: dup
    //   46: aload 4
    //   48: invokespecial 141	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   51: astore_1
    //   52: aload 4
    //   54: invokevirtual 145	java/io/File:length	()J
    //   57: l2i
    //   58: newarray <illegal type>
    //   60: astore_2
    //   61: aload_1
    //   62: aload_2
    //   63: invokevirtual 149	java/io/FileInputStream:read	([B)I
    //   66: pop
    //   67: aload_1
    //   68: ifnull +7 -> 75
    //   71: aload_1
    //   72: invokevirtual 152	java/io/FileInputStream:close	()V
    //   75: aload_2
    //   76: astore_1
    //   77: aload_1
    //   78: ifnull +66 -> 144
    //   81: new 93	com/millennialmedia/android/MMJSResponse
    //   84: dup
    //   85: invokespecial 125	com/millennialmedia/android/MMJSResponse:<init>	()V
    //   88: astore_2
    //   89: aload_2
    //   90: iconst_1
    //   91: putfield 129	com/millennialmedia/android/MMJSResponse:result	I
    //   94: aload_2
    //   95: aload_1
    //   96: putfield 156	com/millennialmedia/android/MMJSResponse:dataResponse	[B
    //   99: aload_2
    //   100: areturn
    //   101: astore_1
    //   102: aload_2
    //   103: astore_1
    //   104: goto -27 -> 77
    //   107: astore_1
    //   108: aload_3
    //   109: astore_2
    //   110: aconst_null
    //   111: astore_3
    //   112: aload_3
    //   113: astore_1
    //   114: aload_2
    //   115: ifnull -38 -> 77
    //   118: aload_2
    //   119: invokevirtual 152	java/io/FileInputStream:close	()V
    //   122: aload_3
    //   123: astore_1
    //   124: goto -47 -> 77
    //   127: astore_1
    //   128: aload_3
    //   129: astore_1
    //   130: goto -53 -> 77
    //   133: astore_1
    //   134: aload_2
    //   135: ifnull +7 -> 142
    //   138: aload_2
    //   139: invokevirtual 152	java/io/FileInputStream:close	()V
    //   142: aload_1
    //   143: athrow
    //   144: aconst_null
    //   145: areturn
    //   146: astore_2
    //   147: goto -5 -> 142
    //   150: astore_3
    //   151: aload_1
    //   152: astore_2
    //   153: aload_3
    //   154: astore_1
    //   155: goto -21 -> 134
    //   158: astore_2
    //   159: aload_1
    //   160: astore_2
    //   161: goto -51 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	BridgeMMFileManager
    //   0	164	1	paramHashMap	HashMap<String, String>
    //   8	131	2	localObject1	Object
    //   146	1	2	localException1	Exception
    //   152	1	2	localHashMap1	HashMap<String, String>
    //   158	1	2	localException2	Exception
    //   160	1	2	localHashMap2	HashMap<String, String>
    //   10	119	3	localObject2	Object
    //   150	4	3	localObject3	Object
    //   40	13	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   71	75	101	java/lang/Exception
    //   20	52	107	java/lang/Exception
    //   118	122	127	java/lang/Exception
    //   20	52	133	finally
    //   138	142	146	java/lang/Exception
    //   52	67	150	finally
    //   52	67	158	java/lang/Exception
  }
  
  public MMJSResponse getFreeDiskSpace(HashMap<String, String> paramHashMap)
  {
    if (hasCreativeDirectory())
    {
      paramHashMap = new MMJSResponse();
      paramHashMap.result = 1;
      StatFs localStatFs = new StatFs(this.root.getAbsolutePath());
      paramHashMap.response = new Long(localStatFs.getAvailableBlocks() * localStatFs.getBlockSize());
      return paramHashMap;
    }
    return null;
  }
  
  public MMJSResponse getMimeType(HashMap<String, String> paramHashMap)
  {
    if (hasCreativeDirectory())
    {
      paramHashMap = ((String)paramHashMap.get("path")).split("\\.");
      paramHashMap = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramHashMap[(paramHashMap.length - 1)]);
      if (paramHashMap != null)
      {
        MMJSResponse localMMJSResponse = new MMJSResponse();
        localMMJSResponse.result = 1;
        localMMJSResponse.response = paramHashMap;
        return localMMJSResponse;
      }
    }
    return null;
  }
  
  public MMJSResponse moveFile(HashMap<String, String> paramHashMap)
  {
    if (hasCreativeDirectory()) {
      try
      {
        String str = (String)paramHashMap.get("fromPath");
        paramHashMap = (String)paramHashMap.get("toPath");
        if ((str != null) && (paramHashMap != null) && (new File(this.root, str).renameTo(new File(this.root, paramHashMap))))
        {
          paramHashMap = MMJSResponse.responseWithSuccess("File moved successfully");
          return paramHashMap;
        }
      }
      catch (Exception paramHashMap) {}
    }
    return null;
  }
  
  public MMJSResponse removeAtPath(HashMap<String, String> paramHashMap)
  {
    if (hasCreativeDirectory()) {
      try
      {
        paramHashMap = (String)paramHashMap.get("path");
        if ((paramHashMap != null) && (new File(this.root, paramHashMap).delete()))
        {
          paramHashMap = MMJSResponse.responseWithSuccess("File removed successfully");
          return paramHashMap;
        }
      }
      catch (Exception paramHashMap) {}
    }
    return null;
  }
  
  /* Error */
  public MMJSResponse writeData(HashMap<String, String> paramHashMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 41	com/millennialmedia/android/BridgeMMFileManager:hasCreativeDirectory	()Z
    //   4: ifeq +143 -> 147
    //   7: aconst_null
    //   8: astore 4
    //   10: aconst_null
    //   11: astore 5
    //   13: iconst_0
    //   14: istore_3
    //   15: aload_1
    //   16: ldc 87
    //   18: invokevirtual 49	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   21: ifeq +126 -> 147
    //   24: aload_1
    //   25: ldc -42
    //   27: invokevirtual 49	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   30: ifeq +117 -> 147
    //   33: new 110	java/io/File
    //   36: dup
    //   37: aload_0
    //   38: getfield 33	com/millennialmedia/android/BridgeMMFileManager:root	Ljava/io/File;
    //   41: aload_1
    //   42: ldc 87
    //   44: invokevirtual 52	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   47: checkcast 54	java/lang/String
    //   50: invokespecial 113	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   53: astore 6
    //   55: aload_1
    //   56: ldc -42
    //   58: invokevirtual 52	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   61: checkcast 54	java/lang/String
    //   64: invokestatic 220	com/millennialmedia/android/Base64:decode	(Ljava/lang/String;)[B
    //   67: astore 7
    //   69: new 222	java/io/FileOutputStream
    //   72: dup
    //   73: aload 6
    //   75: invokespecial 223	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   78: astore_1
    //   79: aload_1
    //   80: aload 7
    //   82: invokevirtual 227	java/io/FileOutputStream:write	([B)V
    //   85: iconst_1
    //   86: istore_2
    //   87: aload_1
    //   88: ifnull +7 -> 95
    //   91: aload_1
    //   92: invokevirtual 228	java/io/FileOutputStream:close	()V
    //   95: iload_2
    //   96: ifeq +51 -> 147
    //   99: ldc -26
    //   101: invokestatic 97	com/millennialmedia/android/MMJSResponse:responseWithSuccess	(Ljava/lang/String;)Lcom/millennialmedia/android/MMJSResponse;
    //   104: areturn
    //   105: astore_1
    //   106: goto -11 -> 95
    //   109: astore_1
    //   110: aload 5
    //   112: astore_1
    //   113: iload_3
    //   114: istore_2
    //   115: aload_1
    //   116: ifnull -21 -> 95
    //   119: aload_1
    //   120: invokevirtual 228	java/io/FileOutputStream:close	()V
    //   123: iload_3
    //   124: istore_2
    //   125: goto -30 -> 95
    //   128: astore_1
    //   129: iload_3
    //   130: istore_2
    //   131: goto -36 -> 95
    //   134: astore_1
    //   135: aload 4
    //   137: ifnull +8 -> 145
    //   140: aload 4
    //   142: invokevirtual 228	java/io/FileOutputStream:close	()V
    //   145: aload_1
    //   146: athrow
    //   147: aconst_null
    //   148: areturn
    //   149: astore 4
    //   151: goto -6 -> 145
    //   154: astore 5
    //   156: aload_1
    //   157: astore 4
    //   159: aload 5
    //   161: astore_1
    //   162: goto -27 -> 135
    //   165: astore 4
    //   167: goto -54 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	BridgeMMFileManager
    //   0	170	1	paramHashMap	HashMap<String, String>
    //   86	45	2	i	int
    //   14	116	3	j	int
    //   8	133	4	localObject1	Object
    //   149	1	4	localException1	Exception
    //   157	1	4	localHashMap	HashMap<String, String>
    //   165	1	4	localException2	Exception
    //   11	100	5	localObject2	Object
    //   154	6	5	localObject3	Object
    //   53	21	6	localFile	File
    //   67	14	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   91	95	105	java/lang/Exception
    //   33	79	109	java/lang/Exception
    //   119	123	128	java/lang/Exception
    //   33	79	134	finally
    //   140	145	149	java/lang/Exception
    //   79	85	154	finally
    //   79	85	165	java/lang/Exception
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/millennialmedia/android/BridgeMMFileManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */