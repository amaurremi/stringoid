package com.inmobi.androidsdk.ai.controller;

import android.content.Context;
import android.os.StatFs;
import com.inmobi.androidsdk.ai.container.IMWebView;
import com.inmobi.commons.internal.IMLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class JSAssetController
  extends JSController
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  public JSAssetController(IMWebView paramIMWebView, Context paramContext)
  {
    super(paramIMWebView, paramContext);
  }
  
  private String a()
  {
    return this.mContext.getFilesDir().getPath();
  }
  
  private String a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new File(paramString2 + File.separator + paramString1);
    new File(paramString2 + File.separator + "ad").mkdir();
    paramString2 = new File(paramString2 + File.separator + "ad" + File.separator + paramString3);
    paramString2.mkdir();
    paramString1.renameTo(new File(paramString2, paramString1.getName()));
    return paramString2.getPath() + File.separator;
  }
  
  private String a(MessageDigest paramMessageDigest)
  {
    int j = 0;
    paramMessageDigest = paramMessageDigest.digest();
    char[] arrayOfChar = new char[paramMessageDigest.length * 2];
    int i = 0;
    for (;;)
    {
      if (i >= paramMessageDigest.length) {
        return new String(arrayOfChar);
      }
      int k = j + 1;
      arrayOfChar[j] = a[(paramMessageDigest[i] >>> 4 & 0xF)];
      j = k + 1;
      arrayOfChar[k] = a[(paramMessageDigest[i] & 0xF)];
      i += 1;
    }
  }
  
  private HttpEntity a(String paramString)
  {
    try
    {
      paramString = new DefaultHttpClient().execute(new HttpGet(paramString)).getEntity();
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private FileOutputStream b(String paramString)
    throws FileNotFoundException
  {
    File localFile = c(d(paramString));
    localFile.mkdirs();
    return new FileOutputStream(new File(localFile, e(paramString)));
  }
  
  private File c(String paramString)
  {
    File localFile = this.mContext.getFilesDir();
    IMLog.debug("InMobiAndroidSDK_3.6.1", "Tmp File dir: " + localFile);
    return new File(localFile.getPath() + File.separator + paramString);
  }
  
  private String d(String paramString)
  {
    int i = paramString.lastIndexOf(File.separatorChar);
    String str = "/";
    if (i >= 0) {
      str = paramString.substring(0, paramString.lastIndexOf(File.separatorChar));
    }
    return str;
  }
  
  public static boolean deleteDirectory(File paramFile)
  {
    File[] arrayOfFile;
    int i;
    if (paramFile.exists())
    {
      arrayOfFile = paramFile.listFiles();
      i = 0;
      if (i < arrayOfFile.length) {}
    }
    else
    {
      return paramFile.delete();
    }
    if (arrayOfFile[i].isDirectory()) {
      deleteDirectory(arrayOfFile[i]);
    }
    for (;;)
    {
      i += 1;
      break;
      arrayOfFile[i].delete();
    }
  }
  
  public static boolean deleteDirectory(String paramString)
  {
    if (paramString != null) {
      return deleteDirectory(new File(paramString));
    }
    return false;
  }
  
  private String e(String paramString)
  {
    String str = paramString;
    if (paramString.lastIndexOf(File.separatorChar) >= 0) {
      str = paramString.substring(paramString.lastIndexOf(File.separatorChar) + 1);
    }
    return str;
  }
  
  /* Error */
  public void addAsset(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: invokespecial 194	com/inmobi/androidsdk/ai/controller/JSAssetController:a	(Ljava/lang/String;)Lorg/apache/http/HttpEntity;
    //   5: astore 5
    //   7: aconst_null
    //   8: astore_3
    //   9: aconst_null
    //   10: astore_2
    //   11: aload 5
    //   13: invokeinterface 200 1 0
    //   18: astore 4
    //   20: aload 4
    //   22: astore_2
    //   23: aload 4
    //   25: astore_3
    //   26: aload_0
    //   27: aload 4
    //   29: aload_1
    //   30: iconst_0
    //   31: invokevirtual 204	com/inmobi/androidsdk/ai/controller/JSAssetController:writeToDisk	(Ljava/io/InputStream;Ljava/lang/String;Z)Ljava/lang/String;
    //   34: pop
    //   35: aload 4
    //   37: astore_2
    //   38: aload 4
    //   40: astore_3
    //   41: new 50	java/lang/StringBuilder
    //   44: dup
    //   45: ldc -50
    //   47: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   50: aload_1
    //   51: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: ldc -48
    //   56: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: astore_1
    //   63: aload 4
    //   65: astore_2
    //   66: aload 4
    //   68: astore_3
    //   69: aload_0
    //   70: getfield 212	com/inmobi/androidsdk/ai/controller/JSAssetController:imWebView	Lcom/inmobi/androidsdk/ai/container/IMWebView;
    //   73: aload_1
    //   74: invokevirtual 217	com/inmobi/androidsdk/ai/container/IMWebView:injectJavaScript	(Ljava/lang/String;)V
    //   77: aload 4
    //   79: ifnull +8 -> 87
    //   82: aload 4
    //   84: invokevirtual 222	java/io/InputStream:close	()V
    //   87: aload 5
    //   89: invokeinterface 225 1 0
    //   94: return
    //   95: astore_1
    //   96: aload_2
    //   97: astore_3
    //   98: aload_1
    //   99: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   102: aload_2
    //   103: ifnull -16 -> 87
    //   106: aload_2
    //   107: invokevirtual 222	java/io/InputStream:close	()V
    //   110: goto -23 -> 87
    //   113: astore_1
    //   114: goto -27 -> 87
    //   117: astore_1
    //   118: aload_3
    //   119: ifnull +7 -> 126
    //   122: aload_3
    //   123: invokevirtual 222	java/io/InputStream:close	()V
    //   126: aload_1
    //   127: athrow
    //   128: astore_1
    //   129: aload_1
    //   130: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   133: return
    //   134: astore_2
    //   135: goto -9 -> 126
    //   138: astore_1
    //   139: goto -52 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	JSAssetController
    //   0	142	1	paramString1	String
    //   0	142	2	paramString2	String
    //   8	115	3	localObject	Object
    //   18	65	4	localInputStream	java.io.InputStream
    //   5	83	5	localHttpEntity	HttpEntity
    // Exception table:
    //   from	to	target	type
    //   11	20	95	java/lang/Exception
    //   26	35	95	java/lang/Exception
    //   41	63	95	java/lang/Exception
    //   69	77	95	java/lang/Exception
    //   106	110	113	java/lang/Exception
    //   11	20	117	finally
    //   26	35	117	finally
    //   41	63	117	finally
    //   69	77	117	finally
    //   98	102	117	finally
    //   87	94	128	java/lang/Exception
    //   122	126	134	java/lang/Exception
    //   82	87	138	java/lang/Exception
  }
  
  public int cacheRemaining()
  {
    StatFs localStatFs = new StatFs(this.mContext.getFilesDir().getPath());
    return localStatFs.getFreeBlocks() * localStatFs.getBlockSize();
  }
  
  /* Error */
  public String copyTextFromJarIntoAssetDir(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: ldc 2
    //   5: invokevirtual 244	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   8: aload_2
    //   9: invokevirtual 250	java/lang/ClassLoader:getResource	(Ljava/lang/String;)Ljava/net/URL;
    //   12: invokevirtual 255	java/net/URL:getFile	()Ljava/lang/String;
    //   15: astore 5
    //   17: aload 5
    //   19: astore 4
    //   21: aload 5
    //   23: ldc_w 257
    //   26: invokevirtual 260	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   29: ifeq +11 -> 40
    //   32: aload 5
    //   34: iconst_5
    //   35: invokevirtual 191	java/lang/String:substring	(I)Ljava/lang/String;
    //   38: astore 4
    //   40: aload 4
    //   42: ldc_w 262
    //   45: invokevirtual 266	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   48: istore_3
    //   49: aload 4
    //   51: astore 5
    //   53: iload_3
    //   54: ifle +12 -> 66
    //   57: aload 4
    //   59: iconst_0
    //   60: iload_3
    //   61: invokevirtual 171	java/lang/String:substring	(II)Ljava/lang/String;
    //   64: astore 5
    //   66: new 268	java/util/jar/JarFile
    //   69: dup
    //   70: aload 5
    //   72: invokespecial 269	java/util/jar/JarFile:<init>	(Ljava/lang/String;)V
    //   75: astore 4
    //   77: aload 4
    //   79: aload 4
    //   81: aload_2
    //   82: invokevirtual 273	java/util/jar/JarFile:getJarEntry	(Ljava/lang/String;)Ljava/util/jar/JarEntry;
    //   85: invokevirtual 277	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   88: astore_2
    //   89: aload_2
    //   90: astore 4
    //   92: aload_0
    //   93: aload_2
    //   94: aload_1
    //   95: iconst_0
    //   96: invokevirtual 204	com/inmobi/androidsdk/ai/controller/JSAssetController:writeToDisk	(Ljava/io/InputStream;Ljava/lang/String;Z)Ljava/lang/String;
    //   99: astore_1
    //   100: aload_1
    //   101: astore 4
    //   103: aload_2
    //   104: ifnull +10 -> 114
    //   107: aload_2
    //   108: invokevirtual 222	java/io/InputStream:close	()V
    //   111: aload_1
    //   112: astore 4
    //   114: aload 4
    //   116: areturn
    //   117: astore_1
    //   118: aconst_null
    //   119: astore_2
    //   120: aload_2
    //   121: astore 4
    //   123: aload_1
    //   124: invokevirtual 120	java/lang/Exception:printStackTrace	()V
    //   127: aload 6
    //   129: astore 4
    //   131: aload_2
    //   132: ifnull -18 -> 114
    //   135: aload_2
    //   136: invokevirtual 222	java/io/InputStream:close	()V
    //   139: aconst_null
    //   140: areturn
    //   141: astore_1
    //   142: aconst_null
    //   143: areturn
    //   144: astore_1
    //   145: aconst_null
    //   146: astore 4
    //   148: aload 4
    //   150: ifnull +8 -> 158
    //   153: aload 4
    //   155: invokevirtual 222	java/io/InputStream:close	()V
    //   158: aload_1
    //   159: athrow
    //   160: astore_2
    //   161: aload_1
    //   162: areturn
    //   163: astore_2
    //   164: goto -6 -> 158
    //   167: astore_1
    //   168: goto -20 -> 148
    //   171: astore_1
    //   172: goto -52 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	JSAssetController
    //   0	175	1	paramString1	String
    //   0	175	2	paramString2	String
    //   48	13	3	i	int
    //   19	135	4	localObject1	Object
    //   15	56	5	localObject2	Object
    //   1	127	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   3	17	117	java/lang/Exception
    //   21	40	117	java/lang/Exception
    //   40	49	117	java/lang/Exception
    //   57	66	117	java/lang/Exception
    //   66	89	117	java/lang/Exception
    //   135	139	141	java/lang/Exception
    //   3	17	144	finally
    //   21	40	144	finally
    //   40	49	144	finally
    //   57	66	144	finally
    //   66	89	144	finally
    //   107	111	160	java/lang/Exception
    //   153	158	163	java/lang/Exception
    //   92	100	167	finally
    //   123	127	167	finally
    //   92	100	171	java/lang/Exception
  }
  
  public void deleteOldAds()
  {
    deleteDirectory(new File(a() + File.separator + "ad"));
  }
  
  public String getAssetPath()
  {
    return "file://" + this.mContext.getFilesDir() + "/";
  }
  
  public void removeAsset(String paramString)
  {
    File localFile = c(d(paramString));
    localFile.mkdirs();
    new File(localFile, e(paramString)).delete();
    paramString = "mraidAdController.assetRemoved('" + paramString + "' )";
    this.imWebView.injectJavaScript(paramString);
  }
  
  public void stopAllListeners() {}
  
  /* Error */
  public String writeToDisk(java.io.InputStream paramInputStream, String paramString, boolean paramBoolean)
    throws java.lang.IllegalStateException, java.io.IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: sipush 1024
    //   6: newarray <illegal type>
    //   8: astore 8
    //   10: iload_3
    //   11: ifeq +107 -> 118
    //   14: ldc_w 295
    //   17: invokestatic 299	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   20: astore 5
    //   22: aload_0
    //   23: aload_2
    //   24: invokespecial 301	com/inmobi/androidsdk/ai/controller/JSAssetController:b	(Ljava/lang/String;)Ljava/io/FileOutputStream;
    //   27: astore 7
    //   29: aload 7
    //   31: astore 6
    //   33: aload_1
    //   34: aload 8
    //   36: invokevirtual 305	java/io/InputStream:read	([B)I
    //   39: istore 4
    //   41: iload 4
    //   43: ifgt +81 -> 124
    //   46: aload 7
    //   48: astore 6
    //   50: aload 7
    //   52: invokevirtual 308	java/io/FileOutputStream:flush	()V
    //   55: aload 7
    //   57: ifnull +8 -> 65
    //   60: aload 7
    //   62: invokevirtual 309	java/io/FileOutputStream:close	()V
    //   65: aload_0
    //   66: invokespecial 280	com/inmobi/androidsdk/ai/controller/JSAssetController:a	()Ljava/lang/String;
    //   69: astore_1
    //   70: iload_3
    //   71: ifeq +111 -> 182
    //   74: aload 5
    //   76: ifnull +106 -> 182
    //   79: aload_0
    //   80: aload_2
    //   81: aload_1
    //   82: aload_0
    //   83: aload 5
    //   85: invokespecial 311	com/inmobi/androidsdk/ai/controller/JSAssetController:a	(Ljava/security/MessageDigest;)Ljava/lang/String;
    //   88: invokespecial 313	com/inmobi/androidsdk/ai/controller/JSAssetController:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   91: astore_1
    //   92: new 50	java/lang/StringBuilder
    //   95: dup
    //   96: aload_1
    //   97: invokestatic 56	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   100: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   103: aload_2
    //   104: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: areturn
    //   111: astore 5
    //   113: aload 5
    //   115: invokevirtual 314	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   118: aconst_null
    //   119: astore 5
    //   121: goto -99 -> 22
    //   124: iload_3
    //   125: ifeq +19 -> 144
    //   128: aload 5
    //   130: ifnull +14 -> 144
    //   133: aload 7
    //   135: astore 6
    //   137: aload 5
    //   139: aload 8
    //   141: invokevirtual 318	java/security/MessageDigest:update	([B)V
    //   144: aload 7
    //   146: astore 6
    //   148: aload 7
    //   150: aload 8
    //   152: iconst_0
    //   153: iload 4
    //   155: invokevirtual 322	java/io/FileOutputStream:write	([BII)V
    //   158: goto -129 -> 29
    //   161: astore_1
    //   162: aload 6
    //   164: ifnull +8 -> 172
    //   167: aload 6
    //   169: invokevirtual 309	java/io/FileOutputStream:close	()V
    //   172: aload_1
    //   173: athrow
    //   174: astore_2
    //   175: goto -3 -> 172
    //   178: astore_1
    //   179: goto -114 -> 65
    //   182: goto -90 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	JSAssetController
    //   0	185	1	paramInputStream	java.io.InputStream
    //   0	185	2	paramString	String
    //   0	185	3	paramBoolean	boolean
    //   39	115	4	i	int
    //   20	64	5	localMessageDigest	MessageDigest
    //   111	3	5	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   119	19	5	localObject1	Object
    //   1	167	6	localObject2	Object
    //   27	122	7	localFileOutputStream	FileOutputStream
    //   8	143	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   14	22	111	java/security/NoSuchAlgorithmException
    //   22	29	161	finally
    //   33	41	161	finally
    //   50	55	161	finally
    //   137	144	161	finally
    //   148	158	161	finally
    //   167	172	174	java/lang/Exception
    //   60	65	178	java/lang/Exception
  }
  
  /* Error */
  public String writeToDiskWrap(java.io.InputStream paramInputStream, String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4)
    throws java.lang.IllegalStateException, java.io.IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: sipush 1024
    //   6: newarray <illegal type>
    //   8: astore 13
    //   10: iload_3
    //   11: ifeq +558 -> 569
    //   14: ldc_w 295
    //   17: invokestatic 299	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   20: astore 9
    //   22: new 326	java/io/ByteArrayOutputStream
    //   25: dup
    //   26: invokespecial 327	java/io/ByteArrayOutputStream:<init>	()V
    //   29: astore 12
    //   31: aload 11
    //   33: astore 10
    //   35: aload_1
    //   36: aload 13
    //   38: invokevirtual 305	java/io/InputStream:read	([B)I
    //   41: istore 7
    //   43: iload 7
    //   45: ifgt +530 -> 575
    //   48: aload 11
    //   50: astore 10
    //   52: aload 12
    //   54: invokevirtual 328	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   57: astore_1
    //   58: aload 11
    //   60: astore 10
    //   62: aload_1
    //   63: ldc_w 330
    //   66: invokevirtual 266	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   69: iflt +566 -> 635
    //   72: iconst_1
    //   73: istore 7
    //   75: iload 7
    //   77: ifeq +601 -> 678
    //   80: aload 11
    //   82: astore 10
    //   84: new 332	java/lang/StringBuffer
    //   87: dup
    //   88: aload_1
    //   89: invokespecial 333	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   92: astore_1
    //   93: aload 11
    //   95: astore 10
    //   97: aload_1
    //   98: ldc_w 335
    //   101: invokevirtual 336	java/lang/StringBuffer:indexOf	(Ljava/lang/String;)I
    //   104: istore 8
    //   106: aload 11
    //   108: astore 10
    //   110: aload_1
    //   111: iload 8
    //   113: ldc_w 335
    //   116: invokevirtual 339	java/lang/String:length	()I
    //   119: iload 8
    //   121: iadd
    //   122: new 50	java/lang/StringBuilder
    //   125: dup
    //   126: ldc_w 341
    //   129: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   132: aload 5
    //   134: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokevirtual 345	java/lang/StringBuffer:replace	(IILjava/lang/String;)Ljava/lang/StringBuffer;
    //   143: pop
    //   144: aload 11
    //   146: astore 10
    //   148: aload_1
    //   149: ldc_w 347
    //   152: invokevirtual 336	java/lang/StringBuffer:indexOf	(Ljava/lang/String;)I
    //   155: istore 8
    //   157: aload 11
    //   159: astore 10
    //   161: aload_1
    //   162: iload 8
    //   164: ldc_w 347
    //   167: invokevirtual 339	java/lang/String:length	()I
    //   170: iload 8
    //   172: iadd
    //   173: new 50	java/lang/StringBuilder
    //   176: dup
    //   177: ldc_w 341
    //   180: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   183: aload 6
    //   185: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokevirtual 345	java/lang/StringBuffer:replace	(IILjava/lang/String;)Ljava/lang/StringBuffer;
    //   194: pop
    //   195: aload 11
    //   197: astore 10
    //   199: aload_0
    //   200: aload_2
    //   201: invokespecial 301	com/inmobi/androidsdk/ai/controller/JSAssetController:b	(Ljava/lang/String;)Ljava/io/FileOutputStream;
    //   204: astore 11
    //   206: iload 7
    //   208: ifne +229 -> 437
    //   211: aload 11
    //   213: astore 10
    //   215: aload 11
    //   217: ldc_w 349
    //   220: invokevirtual 352	java/lang/String:getBytes	()[B
    //   223: invokevirtual 354	java/io/FileOutputStream:write	([B)V
    //   226: aload 11
    //   228: astore 10
    //   230: aload 11
    //   232: ldc_w 356
    //   235: invokevirtual 352	java/lang/String:getBytes	()[B
    //   238: invokevirtual 354	java/io/FileOutputStream:write	([B)V
    //   241: aload 11
    //   243: astore 10
    //   245: aload 11
    //   247: ldc_w 358
    //   250: invokevirtual 352	java/lang/String:getBytes	()[B
    //   253: invokevirtual 354	java/io/FileOutputStream:write	([B)V
    //   256: aload 11
    //   258: astore 10
    //   260: aload 11
    //   262: ldc_w 360
    //   265: invokevirtual 352	java/lang/String:getBytes	()[B
    //   268: invokevirtual 354	java/io/FileOutputStream:write	([B)V
    //   271: aload 11
    //   273: astore 10
    //   275: aload 11
    //   277: new 50	java/lang/StringBuilder
    //   280: dup
    //   281: ldc_w 362
    //   284: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   287: aload 5
    //   289: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: ldc_w 364
    //   295: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokevirtual 352	java/lang/String:getBytes	()[B
    //   304: invokevirtual 354	java/io/FileOutputStream:write	([B)V
    //   307: aload 11
    //   309: astore 10
    //   311: aload 11
    //   313: new 50	java/lang/StringBuilder
    //   316: dup
    //   317: ldc_w 362
    //   320: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   323: aload 6
    //   325: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: ldc_w 364
    //   331: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: invokevirtual 352	java/lang/String:getBytes	()[B
    //   340: invokevirtual 354	java/io/FileOutputStream:write	([B)V
    //   343: aload 4
    //   345: ifnull +47 -> 392
    //   348: aload 11
    //   350: astore 10
    //   352: aload 11
    //   354: ldc_w 366
    //   357: invokevirtual 352	java/lang/String:getBytes	()[B
    //   360: invokevirtual 354	java/io/FileOutputStream:write	([B)V
    //   363: aload 11
    //   365: astore 10
    //   367: aload 11
    //   369: aload 4
    //   371: invokevirtual 352	java/lang/String:getBytes	()[B
    //   374: invokevirtual 354	java/io/FileOutputStream:write	([B)V
    //   377: aload 11
    //   379: astore 10
    //   381: aload 11
    //   383: ldc_w 368
    //   386: invokevirtual 352	java/lang/String:getBytes	()[B
    //   389: invokevirtual 354	java/io/FileOutputStream:write	([B)V
    //   392: aload 11
    //   394: astore 10
    //   396: aload 11
    //   398: ldc_w 370
    //   401: invokevirtual 352	java/lang/String:getBytes	()[B
    //   404: invokevirtual 354	java/io/FileOutputStream:write	([B)V
    //   407: aload 11
    //   409: astore 10
    //   411: aload 11
    //   413: ldc_w 372
    //   416: invokevirtual 352	java/lang/String:getBytes	()[B
    //   419: invokevirtual 354	java/io/FileOutputStream:write	([B)V
    //   422: aload 11
    //   424: astore 10
    //   426: aload 11
    //   428: ldc_w 374
    //   431: invokevirtual 352	java/lang/String:getBytes	()[B
    //   434: invokevirtual 354	java/io/FileOutputStream:write	([B)V
    //   437: iload 7
    //   439: ifne +202 -> 641
    //   442: aload 11
    //   444: astore 10
    //   446: aload 11
    //   448: aload 12
    //   450: invokevirtual 377	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   453: invokevirtual 354	java/io/FileOutputStream:write	([B)V
    //   456: iload 7
    //   458: ifne +48 -> 506
    //   461: aload 11
    //   463: astore 10
    //   465: aload 11
    //   467: ldc_w 379
    //   470: invokevirtual 352	java/lang/String:getBytes	()[B
    //   473: invokevirtual 354	java/io/FileOutputStream:write	([B)V
    //   476: aload 11
    //   478: astore 10
    //   480: aload 11
    //   482: ldc_w 381
    //   485: invokevirtual 352	java/lang/String:getBytes	()[B
    //   488: invokevirtual 354	java/io/FileOutputStream:write	([B)V
    //   491: aload 11
    //   493: astore 10
    //   495: aload 11
    //   497: ldc_w 383
    //   500: invokevirtual 352	java/lang/String:getBytes	()[B
    //   503: invokevirtual 354	java/io/FileOutputStream:write	([B)V
    //   506: aload 11
    //   508: astore 10
    //   510: aload 11
    //   512: invokevirtual 308	java/io/FileOutputStream:flush	()V
    //   515: aload 12
    //   517: ifnull +8 -> 525
    //   520: aload 12
    //   522: invokevirtual 384	java/io/ByteArrayOutputStream:close	()V
    //   525: aload 11
    //   527: ifnull +8 -> 535
    //   530: aload 11
    //   532: invokevirtual 309	java/io/FileOutputStream:close	()V
    //   535: aload_0
    //   536: invokespecial 280	com/inmobi/androidsdk/ai/controller/JSAssetController:a	()Ljava/lang/String;
    //   539: astore_1
    //   540: iload_3
    //   541: ifeq +135 -> 676
    //   544: aload 9
    //   546: ifnull +130 -> 676
    //   549: aload_0
    //   550: aload_2
    //   551: aload_1
    //   552: aload_0
    //   553: aload 9
    //   555: invokespecial 311	com/inmobi/androidsdk/ai/controller/JSAssetController:a	(Ljava/security/MessageDigest;)Ljava/lang/String;
    //   558: invokespecial 313	com/inmobi/androidsdk/ai/controller/JSAssetController:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   561: areturn
    //   562: astore 9
    //   564: aload 9
    //   566: invokevirtual 314	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   569: aconst_null
    //   570: astore 9
    //   572: goto -550 -> 22
    //   575: iload_3
    //   576: ifeq +19 -> 595
    //   579: aload 9
    //   581: ifnull +14 -> 595
    //   584: aload 11
    //   586: astore 10
    //   588: aload 9
    //   590: aload 13
    //   592: invokevirtual 318	java/security/MessageDigest:update	([B)V
    //   595: aload 11
    //   597: astore 10
    //   599: aload 12
    //   601: aload 13
    //   603: iconst_0
    //   604: iload 7
    //   606: invokevirtual 385	java/io/ByteArrayOutputStream:write	([BII)V
    //   609: goto -578 -> 31
    //   612: astore_1
    //   613: aload 12
    //   615: ifnull +8 -> 623
    //   618: aload 12
    //   620: invokevirtual 384	java/io/ByteArrayOutputStream:close	()V
    //   623: aload 10
    //   625: ifnull +8 -> 633
    //   628: aload 10
    //   630: invokevirtual 309	java/io/FileOutputStream:close	()V
    //   633: aload_1
    //   634: athrow
    //   635: iconst_0
    //   636: istore 7
    //   638: goto -563 -> 75
    //   641: aload 11
    //   643: astore 10
    //   645: aload 11
    //   647: aload_1
    //   648: invokevirtual 386	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   651: invokevirtual 352	java/lang/String:getBytes	()[B
    //   654: invokevirtual 354	java/io/FileOutputStream:write	([B)V
    //   657: goto -201 -> 456
    //   660: astore_2
    //   661: goto -38 -> 623
    //   664: astore_2
    //   665: goto -32 -> 633
    //   668: astore_1
    //   669: goto -144 -> 525
    //   672: astore_1
    //   673: goto -138 -> 535
    //   676: aload_1
    //   677: areturn
    //   678: aconst_null
    //   679: astore_1
    //   680: goto -485 -> 195
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	683	0	this	JSAssetController
    //   0	683	1	paramInputStream	java.io.InputStream
    //   0	683	2	paramString1	String
    //   0	683	3	paramBoolean	boolean
    //   0	683	4	paramString2	String
    //   0	683	5	paramString3	String
    //   0	683	6	paramString4	String
    //   41	596	7	i	int
    //   104	69	8	j	int
    //   20	534	9	localMessageDigest	MessageDigest
    //   562	3	9	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   570	19	9	localObject	Object
    //   33	611	10	localFileOutputStream1	FileOutputStream
    //   1	645	11	localFileOutputStream2	FileOutputStream
    //   29	590	12	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   8	594	13	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   14	22	562	java/security/NoSuchAlgorithmException
    //   35	43	612	finally
    //   52	58	612	finally
    //   62	72	612	finally
    //   84	93	612	finally
    //   97	106	612	finally
    //   110	144	612	finally
    //   148	157	612	finally
    //   161	195	612	finally
    //   199	206	612	finally
    //   215	226	612	finally
    //   230	241	612	finally
    //   245	256	612	finally
    //   260	271	612	finally
    //   275	307	612	finally
    //   311	343	612	finally
    //   352	363	612	finally
    //   367	377	612	finally
    //   381	392	612	finally
    //   396	407	612	finally
    //   411	422	612	finally
    //   426	437	612	finally
    //   446	456	612	finally
    //   465	476	612	finally
    //   480	491	612	finally
    //   495	506	612	finally
    //   510	515	612	finally
    //   588	595	612	finally
    //   599	609	612	finally
    //   645	657	612	finally
    //   618	623	660	java/lang/Exception
    //   628	633	664	java/lang/Exception
    //   520	525	668	java/lang/Exception
    //   530	535	672	java/lang/Exception
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/inmobi/androidsdk/ai/controller/JSAssetController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */