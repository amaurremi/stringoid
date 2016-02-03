package com.millennialmedia.android;

import android.content.Context;
import android.os.StatFs;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONArray;

class MMFileManager
  extends MMJSObject
{
  static final String CREATIVE_CACHE_DIR = "creativecache";
  private boolean isInitialized;
  private File root;
  
  static void cleanupCache(Context paramContext, boolean paramBoolean)
  {
    for (;;)
    {
      File localFile;
      try
      {
        localFile = AdCache.getCacheDirectory(paramContext);
        if (localFile == null) {
          return;
        }
        localFile = new File(localFile, "creativecache");
        if (localFile.exists())
        {
          boolean bool = localFile.isDirectory();
          if (bool) {
            if (paramBoolean) {
              l = 0L;
            }
          }
        }
      }
      catch (Exception paramContext) {}
      try
      {
        cleanupDirectory(localFile, l);
        return;
      }
      catch (SecurityException paramContext) {}
      long l = HandShake.sharedHandShake(paramContext).creativeCacheTimeout;
    }
    return;
  }
  
  private static void cleanupDirectory(File paramFile, long paramLong)
    throws SecurityException
  {
    paramFile = paramFile.listFiles();
    int j = paramFile.length;
    int i = 0;
    if (i < j)
    {
      File localFile = paramFile[i];
      if (localFile.isFile()) {
        if (System.currentTimeMillis() - localFile.lastModified() > paramLong) {
          localFile.delete();
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (localFile.isDirectory()) {
          try
          {
            cleanupDirectory(localFile, paramLong);
            if (localFile.list().length == 0) {
              localFile.delete();
            }
          }
          catch (SecurityException localSecurityException) {}
        }
      }
    }
  }
  
  static File getCreativeCacheDirectory(Context paramContext)
  {
    if (paramContext != null) {}
    try
    {
      paramContext = AdCache.getCacheDirectory(paramContext);
      if (paramContext != null)
      {
        paramContext = new File(paramContext, "creativecache" + File.separator);
        if (!paramContext.exists())
        {
          if (paramContext.mkdirs()) {
            return paramContext;
          }
        }
        else
        {
          boolean bool = paramContext.isDirectory();
          if (bool) {
            return paramContext;
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
    return null;
    return paramContext;
  }
  
  private boolean initialize()
  {
    if (!this.isInitialized)
    {
      Object localObject = (Context)this.contextRef.get();
      if (localObject != null)
      {
        localObject = getCreativeCacheDirectory((Context)localObject);
        this.root = ((File)localObject);
        if (localObject != null) {
          this.isInitialized = true;
        }
      }
    }
    return this.isInitialized;
  }
  
  public MMJSResponse cleanupCache(HashMap<String, String> paramHashMap)
  {
    boolean bool = false;
    long l = 259200000L;
    if (initialize())
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
        cleanupDirectory(this.root, l);
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
  
  /* Error */
  public MMJSResponse downloadFile(HashMap<String, String> paramHashMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 121	com/millennialmedia/android/MMFileManager:initialize	()Z
    //   4: ifeq +403 -> 407
    //   7: aconst_null
    //   8: astore 12
    //   10: aconst_null
    //   11: astore 5
    //   13: aconst_null
    //   14: astore 10
    //   16: aconst_null
    //   17: astore 11
    //   19: iconst_0
    //   20: istore_3
    //   21: aconst_null
    //   22: astore 9
    //   24: aconst_null
    //   25: astore 7
    //   27: aload_1
    //   28: ldc -111
    //   30: invokevirtual 129	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   33: ifeq +374 -> 407
    //   36: aload 5
    //   38: astore 6
    //   40: aload 12
    //   42: astore 8
    //   44: new 147	java/net/URL
    //   47: dup
    //   48: aload_1
    //   49: ldc -111
    //   51: invokevirtual 132	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   54: checkcast 134	java/lang/String
    //   57: invokespecial 150	java/net/URL:<init>	(Ljava/lang/String;)V
    //   60: invokevirtual 154	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   63: checkcast 156	java/net/HttpURLConnection
    //   66: astore 4
    //   68: aload 5
    //   70: astore 6
    //   72: aload 4
    //   74: astore 7
    //   76: aload 12
    //   78: astore 8
    //   80: aload 4
    //   82: astore 9
    //   84: aload 4
    //   86: sipush 30000
    //   89: invokevirtual 160	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   92: aload 5
    //   94: astore 6
    //   96: aload 4
    //   98: astore 7
    //   100: aload 12
    //   102: astore 8
    //   104: aload 4
    //   106: astore 9
    //   108: aload 4
    //   110: invokevirtual 164	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   113: astore 5
    //   115: aload 5
    //   117: astore 6
    //   119: aload 4
    //   121: astore 7
    //   123: aload 5
    //   125: astore 8
    //   127: aload 4
    //   129: astore 9
    //   131: sipush 4096
    //   134: newarray <illegal type>
    //   136: astore 12
    //   138: aload 5
    //   140: astore 6
    //   142: aload 4
    //   144: astore 7
    //   146: aload 5
    //   148: astore 8
    //   150: aload 4
    //   152: astore 9
    //   154: aload_1
    //   155: ldc -90
    //   157: invokevirtual 129	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   160: ifeq +130 -> 290
    //   163: aload 5
    //   165: astore 6
    //   167: aload 4
    //   169: astore 7
    //   171: aload 5
    //   173: astore 8
    //   175: aload 4
    //   177: astore 9
    //   179: aload_1
    //   180: ldc -90
    //   182: invokevirtual 132	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   185: checkcast 134	java/lang/String
    //   188: astore_1
    //   189: aload 5
    //   191: astore 6
    //   193: aload 4
    //   195: astore 7
    //   197: aload 5
    //   199: astore 8
    //   201: aload 4
    //   203: astore 9
    //   205: new 168	java/io/FileOutputStream
    //   208: dup
    //   209: new 31	java/io/File
    //   212: dup
    //   213: aload_0
    //   214: getfield 116	com/millennialmedia/android/MMFileManager:root	Ljava/io/File;
    //   217: aload_1
    //   218: invokespecial 34	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   221: invokespecial 171	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   224: astore_1
    //   225: aload 5
    //   227: aload 12
    //   229: invokevirtual 177	java/io/InputStream:read	([B)I
    //   232: istore_2
    //   233: iload_2
    //   234: ifle +91 -> 325
    //   237: aload_1
    //   238: aload 12
    //   240: iconst_0
    //   241: iload_2
    //   242: invokevirtual 181	java/io/FileOutputStream:write	([BII)V
    //   245: goto -20 -> 225
    //   248: astore 6
    //   250: aload 4
    //   252: ifnull +8 -> 260
    //   255: aload 4
    //   257: invokevirtual 184	java/net/HttpURLConnection:disconnect	()V
    //   260: aload 5
    //   262: ifnull +8 -> 270
    //   265: aload 5
    //   267: invokevirtual 187	java/io/InputStream:close	()V
    //   270: iload_3
    //   271: istore_2
    //   272: aload_1
    //   273: ifnull +9 -> 282
    //   276: aload_1
    //   277: invokevirtual 188	java/io/FileOutputStream:close	()V
    //   280: iload_3
    //   281: istore_2
    //   282: iload_2
    //   283: ifeq +124 -> 407
    //   286: invokestatic 194	com/millennialmedia/android/MMJSResponse:responseWithSuccess	()Lcom/millennialmedia/android/MMJSResponse;
    //   289: areturn
    //   290: aload 5
    //   292: astore 6
    //   294: aload 4
    //   296: astore 7
    //   298: aload 5
    //   300: astore 8
    //   302: aload 4
    //   304: astore 9
    //   306: aload_1
    //   307: ldc -111
    //   309: invokevirtual 132	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   312: checkcast 134	java/lang/String
    //   315: invokestatic 200	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   318: invokevirtual 203	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   321: astore_1
    //   322: goto -133 -> 189
    //   325: iconst_1
    //   326: istore_2
    //   327: aload 4
    //   329: ifnull +8 -> 337
    //   332: aload 4
    //   334: invokevirtual 184	java/net/HttpURLConnection:disconnect	()V
    //   337: aload 5
    //   339: ifnull +8 -> 347
    //   342: aload 5
    //   344: invokevirtual 187	java/io/InputStream:close	()V
    //   347: aload_1
    //   348: ifnull +7 -> 355
    //   351: aload_1
    //   352: invokevirtual 188	java/io/FileOutputStream:close	()V
    //   355: goto -73 -> 282
    //   358: astore_1
    //   359: goto -77 -> 282
    //   362: astore_1
    //   363: aload 7
    //   365: astore 4
    //   367: aload 6
    //   369: astore 5
    //   371: aload 10
    //   373: astore 6
    //   375: aload 4
    //   377: ifnull +8 -> 385
    //   380: aload 4
    //   382: invokevirtual 184	java/net/HttpURLConnection:disconnect	()V
    //   385: aload 5
    //   387: ifnull +8 -> 395
    //   390: aload 5
    //   392: invokevirtual 187	java/io/InputStream:close	()V
    //   395: aload 6
    //   397: ifnull +8 -> 405
    //   400: aload 6
    //   402: invokevirtual 188	java/io/FileOutputStream:close	()V
    //   405: aload_1
    //   406: athrow
    //   407: aconst_null
    //   408: areturn
    //   409: astore 4
    //   411: goto -6 -> 405
    //   414: astore 7
    //   416: aload_1
    //   417: astore 6
    //   419: aload 7
    //   421: astore_1
    //   422: goto -47 -> 375
    //   425: astore_1
    //   426: iload_3
    //   427: istore_2
    //   428: goto -146 -> 282
    //   431: astore_1
    //   432: aload 11
    //   434: astore_1
    //   435: aload 8
    //   437: astore 5
    //   439: aload 9
    //   441: astore 4
    //   443: goto -193 -> 250
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	446	0	this	MMFileManager
    //   0	446	1	paramHashMap	HashMap<String, String>
    //   232	196	2	i	int
    //   20	407	3	j	int
    //   66	315	4	localObject1	Object
    //   409	1	4	localException1	Exception
    //   441	1	4	localObject2	Object
    //   11	427	5	localObject3	Object
    //   38	154	6	localObject4	Object
    //   248	1	6	localException2	Exception
    //   292	126	6	localObject5	Object
    //   25	339	7	localObject6	Object
    //   414	6	7	localObject7	Object
    //   42	394	8	localObject8	Object
    //   22	418	9	localObject9	Object
    //   14	358	10	localObject10	Object
    //   17	416	11	localObject11	Object
    //   8	231	12	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   225	233	248	java/lang/Exception
    //   237	245	248	java/lang/Exception
    //   342	347	358	java/lang/Exception
    //   351	355	358	java/lang/Exception
    //   44	68	362	finally
    //   84	92	362	finally
    //   108	115	362	finally
    //   131	138	362	finally
    //   154	163	362	finally
    //   179	189	362	finally
    //   205	225	362	finally
    //   306	322	362	finally
    //   390	395	409	java/lang/Exception
    //   400	405	409	java/lang/Exception
    //   225	233	414	finally
    //   237	245	414	finally
    //   265	270	425	java/lang/Exception
    //   276	280	425	java/lang/Exception
    //   44	68	431	java/lang/Exception
    //   84	92	431	java/lang/Exception
    //   108	115	431	java/lang/Exception
    //   131	138	431	java/lang/Exception
    //   154	163	431	java/lang/Exception
    //   179	189	431	java/lang/Exception
    //   205	225	431	java/lang/Exception
    //   306	322	431	java/lang/Exception
  }
  
  public MMJSResponse getDirectoryContents(HashMap<String, String> paramHashMap)
  {
    if (initialize())
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
    //   1: invokespecial 121	com/millennialmedia/android/MMFileManager:initialize	()Z
    //   4: ifeq +140 -> 144
    //   7: aconst_null
    //   8: astore_2
    //   9: aconst_null
    //   10: astore_3
    //   11: aload_1
    //   12: ldc -90
    //   14: invokevirtual 129	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   17: ifeq +127 -> 144
    //   20: new 31	java/io/File
    //   23: dup
    //   24: aload_0
    //   25: getfield 116	com/millennialmedia/android/MMFileManager:root	Ljava/io/File;
    //   28: aload_1
    //   29: ldc -90
    //   31: invokevirtual 132	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   34: checkcast 134	java/lang/String
    //   37: invokespecial 34	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   40: astore 4
    //   42: new 223	java/io/FileInputStream
    //   45: dup
    //   46: aload 4
    //   48: invokespecial 224	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   51: astore_1
    //   52: aload 4
    //   54: invokevirtual 227	java/io/File:length	()J
    //   57: l2i
    //   58: newarray <illegal type>
    //   60: astore_2
    //   61: aload_1
    //   62: aload_2
    //   63: invokevirtual 228	java/io/FileInputStream:read	([B)I
    //   66: pop
    //   67: aload_1
    //   68: ifnull +7 -> 75
    //   71: aload_1
    //   72: invokevirtual 229	java/io/FileInputStream:close	()V
    //   75: aload_2
    //   76: astore_1
    //   77: aload_1
    //   78: ifnull +66 -> 144
    //   81: new 190	com/millennialmedia/android/MMJSResponse
    //   84: dup
    //   85: invokespecial 212	com/millennialmedia/android/MMJSResponse:<init>	()V
    //   88: astore_2
    //   89: aload_2
    //   90: iconst_1
    //   91: putfield 216	com/millennialmedia/android/MMJSResponse:result	I
    //   94: aload_2
    //   95: aload_1
    //   96: putfield 233	com/millennialmedia/android/MMJSResponse:dataResponse	[B
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
    //   119: invokevirtual 229	java/io/FileInputStream:close	()V
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
    //   139: invokevirtual 229	java/io/FileInputStream:close	()V
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
    //   0	164	0	this	MMFileManager
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
    if (initialize())
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
    if (initialize())
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
    if (initialize()) {
      try
      {
        String str = (String)paramHashMap.get("fromPath");
        paramHashMap = (String)paramHashMap.get("toPath");
        if ((str != null) && (paramHashMap != null) && (new File(this.root, str).renameTo(new File(this.root, paramHashMap))))
        {
          paramHashMap = MMJSResponse.responseWithSuccess();
          return paramHashMap;
        }
      }
      catch (Exception paramHashMap) {}
    }
    return null;
  }
  
  public MMJSResponse removeAtPath(HashMap<String, String> paramHashMap)
  {
    if (initialize()) {
      try
      {
        paramHashMap = (String)paramHashMap.get("path");
        if ((paramHashMap != null) && (new File(this.root, paramHashMap).delete()))
        {
          paramHashMap = MMJSResponse.responseWithSuccess();
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
    //   1: invokespecial 121	com/millennialmedia/android/MMFileManager:initialize	()Z
    //   4: ifeq +143 -> 147
    //   7: aconst_null
    //   8: astore 4
    //   10: aconst_null
    //   11: astore 5
    //   13: iconst_0
    //   14: istore_3
    //   15: aload_1
    //   16: ldc -90
    //   18: invokevirtual 129	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   21: ifeq +126 -> 147
    //   24: aload_1
    //   25: ldc_w 282
    //   28: invokevirtual 129	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   31: ifeq +116 -> 147
    //   34: new 31	java/io/File
    //   37: dup
    //   38: aload_0
    //   39: getfield 116	com/millennialmedia/android/MMFileManager:root	Ljava/io/File;
    //   42: aload_1
    //   43: ldc -90
    //   45: invokevirtual 132	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   48: checkcast 134	java/lang/String
    //   51: invokespecial 34	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   54: astore 6
    //   56: aload_1
    //   57: ldc_w 282
    //   60: invokevirtual 132	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: checkcast 134	java/lang/String
    //   66: invokestatic 288	com/millennialmedia/android/Base64:decode	(Ljava/lang/String;)[B
    //   69: astore 7
    //   71: new 168	java/io/FileOutputStream
    //   74: dup
    //   75: aload 6
    //   77: invokespecial 171	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   80: astore_1
    //   81: aload_1
    //   82: aload 7
    //   84: invokevirtual 291	java/io/FileOutputStream:write	([B)V
    //   87: iconst_1
    //   88: istore_2
    //   89: aload_1
    //   90: ifnull +7 -> 97
    //   93: aload_1
    //   94: invokevirtual 188	java/io/FileOutputStream:close	()V
    //   97: iload_2
    //   98: ifeq +49 -> 147
    //   101: invokestatic 194	com/millennialmedia/android/MMJSResponse:responseWithSuccess	()Lcom/millennialmedia/android/MMJSResponse;
    //   104: areturn
    //   105: astore_1
    //   106: goto -9 -> 97
    //   109: astore_1
    //   110: aload 5
    //   112: astore_1
    //   113: iload_3
    //   114: istore_2
    //   115: aload_1
    //   116: ifnull -19 -> 97
    //   119: aload_1
    //   120: invokevirtual 188	java/io/FileOutputStream:close	()V
    //   123: iload_3
    //   124: istore_2
    //   125: goto -28 -> 97
    //   128: astore_1
    //   129: iload_3
    //   130: istore_2
    //   131: goto -34 -> 97
    //   134: astore_1
    //   135: aload 4
    //   137: ifnull +8 -> 145
    //   140: aload 4
    //   142: invokevirtual 188	java/io/FileOutputStream:close	()V
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
    //   0	170	0	this	MMFileManager
    //   0	170	1	paramHashMap	HashMap<String, String>
    //   88	43	2	i	int
    //   14	116	3	j	int
    //   8	133	4	localObject1	Object
    //   149	1	4	localException1	Exception
    //   157	1	4	localHashMap	HashMap<String, String>
    //   165	1	4	localException2	Exception
    //   11	100	5	localObject2	Object
    //   154	6	5	localObject3	Object
    //   54	22	6	localFile	File
    //   69	14	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   93	97	105	java/lang/Exception
    //   34	81	109	java/lang/Exception
    //   119	123	128	java/lang/Exception
    //   34	81	134	finally
    //   140	145	149	java/lang/Exception
    //   81	87	154	finally
    //   81	87	165	java/lang/Exception
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/millennialmedia/android/MMFileManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */