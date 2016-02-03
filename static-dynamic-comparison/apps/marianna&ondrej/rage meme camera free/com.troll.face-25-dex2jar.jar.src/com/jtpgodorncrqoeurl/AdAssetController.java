package com.jtpgodorncrqoeurl;

import android.content.Context;
import android.os.StatFs;
import java.io.File;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class AdAssetController
  extends AdController
{
  private static final char[] c = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  public AdAssetController(AdView paramAdView, Context paramContext)
  {
    super(paramAdView, paramContext);
  }
  
  private String a()
  {
    return this.a.getFilesDir().getPath();
  }
  
  private static String a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new File(paramString2 + File.separator + paramString1);
    new File(paramString2 + File.separator + "ad").mkdir();
    paramString2 = new File(paramString2 + File.separator + "ad" + File.separator + paramString3);
    paramString2.mkdir();
    paramString1.renameTo(new File(paramString2, paramString1.getName()));
    return paramString2.getPath() + File.separator;
  }
  
  private static String a(MessageDigest paramMessageDigest)
  {
    int j = 0;
    paramMessageDigest = paramMessageDigest.digest();
    char[] arrayOfChar = new char[paramMessageDigest.length << 1];
    int i = 0;
    while (i < paramMessageDigest.length)
    {
      int k = j + 1;
      arrayOfChar[j] = c[(paramMessageDigest[i] >>> 4 & 0xF)];
      j = k + 1;
      arrayOfChar[k] = c[(paramMessageDigest[i] & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  private static HttpEntity a(String paramString)
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
  
  private File b(String paramString)
  {
    File localFile = this.a.getFilesDir();
    return new File(localFile.getPath() + File.separator + paramString);
  }
  
  private static String c(String paramString)
  {
    int i = paramString.lastIndexOf(File.separatorChar);
    String str = "/";
    if (i >= 0) {
      str = paramString.substring(0, paramString.lastIndexOf(File.separatorChar));
    }
    return str;
  }
  
  private static String d(String paramString)
  {
    String str = paramString;
    if (paramString.lastIndexOf(File.separatorChar) >= 0) {
      str = paramString.substring(paramString.lastIndexOf(File.separatorChar) + 1);
    }
    return str;
  }
  
  public static boolean deleteDirectory(File paramFile)
  {
    if (paramFile.exists())
    {
      File[] arrayOfFile = paramFile.listFiles();
      int i = 0;
      if (i < arrayOfFile.length)
      {
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
    }
    return paramFile.delete();
  }
  
  public static boolean deleteDirectory(String paramString)
  {
    if (paramString != null) {
      return deleteDirectory(new File(paramString));
    }
    return false;
  }
  
  /* Error */
  public void addAsset(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 158	com/jtpgodorncrqoeurl/AdAssetController:a	(Ljava/lang/String;)Lorg/apache/http/HttpEntity;
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_3
    //   8: aconst_null
    //   9: astore_2
    //   10: aload 5
    //   12: invokeinterface 164 1 0
    //   17: astore 4
    //   19: aload 4
    //   21: astore_2
    //   22: aload 4
    //   24: astore_3
    //   25: aload_0
    //   26: aload 4
    //   28: aload_1
    //   29: iconst_0
    //   30: invokevirtual 168	com/jtpgodorncrqoeurl/AdAssetController:writeToDisk	(Ljava/io/InputStream;Ljava/lang/String;Z)Ljava/lang/String;
    //   33: pop
    //   34: aload 4
    //   36: astore_2
    //   37: aload 4
    //   39: astore_3
    //   40: new 50	java/lang/StringBuilder
    //   43: dup
    //   44: ldc -86
    //   46: invokespecial 171	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   49: aload_1
    //   50: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc -83
    //   55: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: astore_1
    //   62: aload 4
    //   64: astore_2
    //   65: aload 4
    //   67: astore_3
    //   68: aload_0
    //   69: getfield 176	com/jtpgodorncrqoeurl/AdAssetController:b	Lcom/jtpgodorncrqoeurl/AdView;
    //   72: aload_1
    //   73: invokevirtual 181	com/jtpgodorncrqoeurl/AdView:injectJavaScript	(Ljava/lang/String;)V
    //   76: aload 4
    //   78: ifnull +8 -> 86
    //   81: aload 4
    //   83: invokevirtual 186	java/io/InputStream:close	()V
    //   86: aload 5
    //   88: invokeinterface 189 1 0
    //   93: return
    //   94: astore_1
    //   95: aload_2
    //   96: astore_3
    //   97: aload_1
    //   98: invokevirtual 116	java/lang/Exception:printStackTrace	()V
    //   101: aload_2
    //   102: ifnull -16 -> 86
    //   105: aload_2
    //   106: invokevirtual 186	java/io/InputStream:close	()V
    //   109: goto -23 -> 86
    //   112: astore_1
    //   113: goto -27 -> 86
    //   116: astore_1
    //   117: aload_3
    //   118: ifnull +7 -> 125
    //   121: aload_3
    //   122: invokevirtual 186	java/io/InputStream:close	()V
    //   125: aload_1
    //   126: athrow
    //   127: astore_1
    //   128: aload_1
    //   129: invokevirtual 116	java/lang/Exception:printStackTrace	()V
    //   132: return
    //   133: astore_1
    //   134: goto -48 -> 86
    //   137: astore_2
    //   138: goto -13 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	AdAssetController
    //   0	141	1	paramString1	String
    //   0	141	2	paramString2	String
    //   7	115	3	localObject	Object
    //   17	65	4	localInputStream	java.io.InputStream
    //   4	83	5	localHttpEntity	HttpEntity
    // Exception table:
    //   from	to	target	type
    //   10	19	94	java/lang/Exception
    //   25	34	94	java/lang/Exception
    //   40	62	94	java/lang/Exception
    //   68	76	94	java/lang/Exception
    //   105	109	112	java/lang/Exception
    //   10	19	116	finally
    //   25	34	116	finally
    //   40	62	116	finally
    //   68	76	116	finally
    //   97	101	116	finally
    //   86	93	127	java/lang/Exception
    //   81	86	133	java/lang/Exception
    //   121	125	137	java/lang/Exception
  }
  
  public int cacheRemaining()
  {
    StatFs localStatFs = new StatFs(this.a.getFilesDir().getPath());
    return localStatFs.getFreeBlocks() * localStatFs.getBlockSize();
  }
  
  /* Error */
  public String copyTextFromJarIntoAssetDir(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: ldc 2
    //   5: invokevirtual 208	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   8: aload_2
    //   9: invokevirtual 214	java/lang/ClassLoader:getResource	(Ljava/lang/String;)Ljava/net/URL;
    //   12: invokevirtual 219	java/net/URL:getFile	()Ljava/lang/String;
    //   15: astore 5
    //   17: aload 5
    //   19: astore 4
    //   21: aload 5
    //   23: ldc -35
    //   25: invokevirtual 224	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   28: ifeq +11 -> 39
    //   31: aload 5
    //   33: iconst_5
    //   34: invokevirtual 137	java/lang/String:substring	(I)Ljava/lang/String;
    //   37: astore 4
    //   39: aload 4
    //   41: ldc -30
    //   43: invokevirtual 230	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   46: istore_3
    //   47: aload 4
    //   49: astore 5
    //   51: iload_3
    //   52: ifle +12 -> 64
    //   55: aload 4
    //   57: iconst_0
    //   58: iload_3
    //   59: invokevirtual 133	java/lang/String:substring	(II)Ljava/lang/String;
    //   62: astore 5
    //   64: new 232	java/util/jar/JarFile
    //   67: dup
    //   68: aload 5
    //   70: invokespecial 233	java/util/jar/JarFile:<init>	(Ljava/lang/String;)V
    //   73: astore 4
    //   75: aload 4
    //   77: aload 4
    //   79: aload_2
    //   80: invokevirtual 237	java/util/jar/JarFile:getJarEntry	(Ljava/lang/String;)Ljava/util/jar/JarEntry;
    //   83: invokevirtual 241	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   86: astore_2
    //   87: aload_2
    //   88: astore 4
    //   90: aload_0
    //   91: aload_2
    //   92: aload_1
    //   93: iconst_0
    //   94: invokevirtual 168	com/jtpgodorncrqoeurl/AdAssetController:writeToDisk	(Ljava/io/InputStream;Ljava/lang/String;Z)Ljava/lang/String;
    //   97: astore_1
    //   98: aload_1
    //   99: astore 4
    //   101: aload_2
    //   102: ifnull +10 -> 112
    //   105: aload_2
    //   106: invokevirtual 186	java/io/InputStream:close	()V
    //   109: aload_1
    //   110: astore 4
    //   112: aload 4
    //   114: areturn
    //   115: astore_1
    //   116: aconst_null
    //   117: astore_2
    //   118: aload_2
    //   119: astore 4
    //   121: ldc -13
    //   123: aload_1
    //   124: invokestatic 248	com/jtpgodorncrqoeurl/AdLog:printStackTrace	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   127: aload 6
    //   129: astore 4
    //   131: aload_2
    //   132: ifnull -20 -> 112
    //   135: aload_2
    //   136: invokevirtual 186	java/io/InputStream:close	()V
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
    //   155: invokevirtual 186	java/io/InputStream:close	()V
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
    //   172: goto -54 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	AdAssetController
    //   0	175	1	paramString1	String
    //   0	175	2	paramString2	String
    //   46	13	3	i	int
    //   19	135	4	localObject1	Object
    //   15	54	5	localObject2	Object
    //   1	127	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   3	17	115	java/lang/Exception
    //   21	39	115	java/lang/Exception
    //   39	47	115	java/lang/Exception
    //   55	64	115	java/lang/Exception
    //   64	87	115	java/lang/Exception
    //   135	139	141	java/lang/Exception
    //   3	17	144	finally
    //   21	39	144	finally
    //   39	47	144	finally
    //   55	64	144	finally
    //   64	87	144	finally
    //   105	109	160	java/lang/Exception
    //   153	158	163	java/lang/Exception
    //   90	98	167	finally
    //   121	127	167	finally
    //   90	98	171	java/lang/Exception
  }
  
  public void deleteOldAds()
  {
    String str = a();
    deleteDirectory(new File(str + File.separator + "ad"));
  }
  
  public FileOutputStream getAssetOutputString(String paramString)
  {
    File localFile = b(c(paramString));
    localFile.mkdirs();
    return new FileOutputStream(new File(localFile, d(paramString)));
  }
  
  public String getAssetPath()
  {
    return "file://" + this.a.getFilesDir() + "/";
  }
  
  public void removeAsset(String paramString)
  {
    File localFile = b(c(paramString));
    localFile.mkdirs();
    new File(localFile, d(paramString)).delete();
    paramString = "AdOrmmaAdController.assetRemoved('" + paramString + "' )";
    this.b.injectJavaScript(paramString);
  }
  
  public void stopAllListeners() {}
  
  /* Error */
  public String writeHTMLToDiskWrap(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 4
    //   9: new 287	java/lang/StringBuffer
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 288	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   17: astore 10
    //   19: iload_3
    //   20: ifeq +219 -> 239
    //   23: ldc_w 290
    //   26: invokestatic 294	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   29: astore 8
    //   31: aload_1
    //   32: ifnull +105 -> 137
    //   35: aload_1
    //   36: ldc_w 296
    //   39: invokevirtual 300	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   42: ifne +95 -> 137
    //   45: aload 10
    //   47: ldc_w 302
    //   50: invokevirtual 303	java/lang/StringBuffer:indexOf	(Ljava/lang/String;)I
    //   53: istore 7
    //   55: iload 7
    //   57: ifle +34 -> 91
    //   60: aload 10
    //   62: iload 7
    //   64: iload 7
    //   66: bipush 8
    //   68: iadd
    //   69: new 50	java/lang/StringBuilder
    //   72: dup
    //   73: ldc_w 270
    //   76: invokespecial 171	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   79: aload 6
    //   81: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokevirtual 307	java/lang/StringBuffer:replace	(IILjava/lang/String;)Ljava/lang/StringBuffer;
    //   90: pop
    //   91: aload 10
    //   93: ldc_w 309
    //   96: invokevirtual 303	java/lang/StringBuffer:indexOf	(Ljava/lang/String;)I
    //   99: istore 7
    //   101: iload 7
    //   103: ifle +34 -> 137
    //   106: aload 10
    //   108: iload 7
    //   110: iload 7
    //   112: bipush 8
    //   114: iadd
    //   115: new 50	java/lang/StringBuilder
    //   118: dup
    //   119: ldc_w 270
    //   122: invokespecial 171	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   125: aload 6
    //   127: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokevirtual 307	java/lang/StringBuffer:replace	(IILjava/lang/String;)Ljava/lang/StringBuffer;
    //   136: pop
    //   137: aload 9
    //   139: astore_1
    //   140: aload_0
    //   141: aload_2
    //   142: invokevirtual 311	com/jtpgodorncrqoeurl/AdAssetController:getAssetOutputString	(Ljava/lang/String;)Ljava/io/FileOutputStream;
    //   145: astore 6
    //   147: aload 6
    //   149: astore 4
    //   151: aload 6
    //   153: astore 5
    //   155: aload 6
    //   157: astore_1
    //   158: aload 6
    //   160: aload 10
    //   162: invokevirtual 312	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   165: invokevirtual 315	java/lang/String:getBytes	()[B
    //   168: invokevirtual 319	java/io/FileOutputStream:write	([B)V
    //   171: aload 6
    //   173: astore 4
    //   175: aload 6
    //   177: astore 5
    //   179: aload 6
    //   181: astore_1
    //   182: aload 6
    //   184: invokevirtual 322	java/io/FileOutputStream:flush	()V
    //   187: aload 6
    //   189: ifnull +8 -> 197
    //   192: aload 6
    //   194: invokevirtual 323	java/io/FileOutputStream:close	()V
    //   197: aload_0
    //   198: invokespecial 251	com/jtpgodorncrqoeurl/AdAssetController:a	()Ljava/lang/String;
    //   201: astore 4
    //   203: aload 4
    //   205: astore_1
    //   206: iload_3
    //   207: ifeq +23 -> 230
    //   210: aload 4
    //   212: astore_1
    //   213: aload 8
    //   215: ifnull +15 -> 230
    //   218: aload_2
    //   219: aload 4
    //   221: aload 8
    //   223: invokestatic 325	com/jtpgodorncrqoeurl/AdAssetController:a	(Ljava/security/MessageDigest;)Ljava/lang/String;
    //   226: invokestatic 327	com/jtpgodorncrqoeurl/AdAssetController:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   229: astore_1
    //   230: aload_1
    //   231: areturn
    //   232: astore 8
    //   234: aload 8
    //   236: invokevirtual 328	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   239: aconst_null
    //   240: astore 8
    //   242: goto -211 -> 31
    //   245: astore_1
    //   246: ldc -13
    //   248: aload_1
    //   249: invokestatic 248	com/jtpgodorncrqoeurl/AdLog:printStackTrace	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   252: goto -161 -> 91
    //   255: astore_1
    //   256: ldc -13
    //   258: aload_1
    //   259: invokestatic 248	com/jtpgodorncrqoeurl/AdLog:printStackTrace	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   262: goto -125 -> 137
    //   265: astore 5
    //   267: aload 4
    //   269: astore_1
    //   270: aload 5
    //   272: invokevirtual 329	java/io/FileNotFoundException:printStackTrace	()V
    //   275: aload 4
    //   277: ifnull -80 -> 197
    //   280: aload 4
    //   282: invokevirtual 323	java/io/FileOutputStream:close	()V
    //   285: goto -88 -> 197
    //   288: astore_1
    //   289: goto -92 -> 197
    //   292: astore 4
    //   294: aload 5
    //   296: astore_1
    //   297: aload 4
    //   299: invokevirtual 330	java/io/IOException:printStackTrace	()V
    //   302: aload 5
    //   304: ifnull -107 -> 197
    //   307: aload 5
    //   309: invokevirtual 323	java/io/FileOutputStream:close	()V
    //   312: goto -115 -> 197
    //   315: astore_1
    //   316: goto -119 -> 197
    //   319: astore_2
    //   320: aload_1
    //   321: ifnull +7 -> 328
    //   324: aload_1
    //   325: invokevirtual 323	java/io/FileOutputStream:close	()V
    //   328: aload_2
    //   329: athrow
    //   330: astore_1
    //   331: goto -134 -> 197
    //   334: astore_1
    //   335: goto -7 -> 328
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	338	0	this	AdAssetController
    //   0	338	1	paramString1	String
    //   0	338	2	paramString2	String
    //   0	338	3	paramBoolean	boolean
    //   0	338	4	paramString3	String
    //   0	338	5	paramString4	String
    //   0	338	6	paramString5	String
    //   53	62	7	i	int
    //   29	193	8	localMessageDigest	MessageDigest
    //   232	3	8	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   240	1	8	localObject1	Object
    //   4	134	9	localObject2	Object
    //   17	144	10	localStringBuffer	StringBuffer
    // Exception table:
    //   from	to	target	type
    //   23	31	232	java/security/NoSuchAlgorithmException
    //   45	55	245	java/lang/Exception
    //   60	91	245	java/lang/Exception
    //   91	101	255	java/lang/Exception
    //   106	137	255	java/lang/Exception
    //   140	147	265	java/io/FileNotFoundException
    //   158	171	265	java/io/FileNotFoundException
    //   182	187	265	java/io/FileNotFoundException
    //   280	285	288	java/lang/Exception
    //   140	147	292	java/io/IOException
    //   158	171	292	java/io/IOException
    //   182	187	292	java/io/IOException
    //   307	312	315	java/lang/Exception
    //   140	147	319	finally
    //   158	171	319	finally
    //   182	187	319	finally
    //   270	275	319	finally
    //   297	302	319	finally
    //   192	197	330	java/lang/Exception
    //   324	328	334	java/lang/Exception
  }
  
  /* Error */
  public String writeToDisk(java.io.InputStream paramInputStream, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: sipush 1024
    //   6: newarray <illegal type>
    //   8: astore 8
    //   10: iload_3
    //   11: ifeq +92 -> 103
    //   14: ldc_w 290
    //   17: invokestatic 294	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   20: astore 5
    //   22: aload_0
    //   23: aload_2
    //   24: invokevirtual 311	com/jtpgodorncrqoeurl/AdAssetController:getAssetOutputString	(Ljava/lang/String;)Ljava/io/FileOutputStream;
    //   27: astore 7
    //   29: aload 7
    //   31: astore 6
    //   33: aload_1
    //   34: aload 8
    //   36: invokevirtual 334	java/io/InputStream:read	([B)I
    //   39: istore 4
    //   41: iload 4
    //   43: ifle +66 -> 109
    //   46: iload_3
    //   47: ifeq +19 -> 66
    //   50: aload 5
    //   52: ifnull +14 -> 66
    //   55: aload 7
    //   57: astore 6
    //   59: aload 5
    //   61: aload 8
    //   63: invokevirtual 337	java/security/MessageDigest:update	([B)V
    //   66: aload 7
    //   68: astore 6
    //   70: aload 7
    //   72: aload 8
    //   74: iconst_0
    //   75: iload 4
    //   77: invokevirtual 340	java/io/FileOutputStream:write	([BII)V
    //   80: goto -51 -> 29
    //   83: astore_1
    //   84: aload 6
    //   86: ifnull +8 -> 94
    //   89: aload 6
    //   91: invokevirtual 323	java/io/FileOutputStream:close	()V
    //   94: aload_1
    //   95: athrow
    //   96: astore 5
    //   98: aload 5
    //   100: invokevirtual 328	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   103: aconst_null
    //   104: astore 5
    //   106: goto -84 -> 22
    //   109: aload 7
    //   111: astore 6
    //   113: aload 7
    //   115: invokevirtual 322	java/io/FileOutputStream:flush	()V
    //   118: aload 7
    //   120: ifnull +8 -> 128
    //   123: aload 7
    //   125: invokevirtual 323	java/io/FileOutputStream:close	()V
    //   128: aload_0
    //   129: invokespecial 251	com/jtpgodorncrqoeurl/AdAssetController:a	()Ljava/lang/String;
    //   132: astore_1
    //   133: iload_3
    //   134: ifeq +46 -> 180
    //   137: aload 5
    //   139: ifnull +41 -> 180
    //   142: aload_2
    //   143: aload_1
    //   144: aload 5
    //   146: invokestatic 325	com/jtpgodorncrqoeurl/AdAssetController:a	(Ljava/security/MessageDigest;)Ljava/lang/String;
    //   149: invokestatic 327	com/jtpgodorncrqoeurl/AdAssetController:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   152: astore_1
    //   153: new 50	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   160: aload_1
    //   161: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload_2
    //   165: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: areturn
    //   172: astore_1
    //   173: goto -45 -> 128
    //   176: astore_2
    //   177: goto -83 -> 94
    //   180: goto -27 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	AdAssetController
    //   0	183	1	paramInputStream	java.io.InputStream
    //   0	183	2	paramString	String
    //   0	183	3	paramBoolean	boolean
    //   39	37	4	i	int
    //   20	40	5	localMessageDigest1	MessageDigest
    //   96	3	5	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   104	41	5	localMessageDigest2	MessageDigest
    //   1	111	6	localObject	Object
    //   27	97	7	localFileOutputStream	FileOutputStream
    //   8	65	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   22	29	83	finally
    //   33	41	83	finally
    //   59	66	83	finally
    //   70	80	83	finally
    //   113	118	83	finally
    //   14	22	96	java/security/NoSuchAlgorithmException
    //   123	128	172	java/lang/Exception
    //   89	94	176	java/lang/Exception
  }
  
  /* Error */
  public String writeToDiskWrap(java.io.InputStream paramInputStream, String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: sipush 1024
    //   6: newarray <illegal type>
    //   8: astore 13
    //   10: iload_3
    //   11: ifeq +99 -> 110
    //   14: ldc_w 290
    //   17: invokestatic 294	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   20: astore 9
    //   22: new 344	java/io/ByteArrayOutputStream
    //   25: dup
    //   26: invokespecial 345	java/io/ByteArrayOutputStream:<init>	()V
    //   29: astore 12
    //   31: aload 11
    //   33: astore 10
    //   35: aload_1
    //   36: aload 13
    //   38: invokevirtual 334	java/io/InputStream:read	([B)I
    //   41: istore 7
    //   43: iload 7
    //   45: ifle +71 -> 116
    //   48: iload_3
    //   49: ifeq +19 -> 68
    //   52: aload 9
    //   54: ifnull +14 -> 68
    //   57: aload 11
    //   59: astore 10
    //   61: aload 9
    //   63: aload 13
    //   65: invokevirtual 337	java/security/MessageDigest:update	([B)V
    //   68: aload 11
    //   70: astore 10
    //   72: aload 12
    //   74: aload 13
    //   76: iconst_0
    //   77: iload 7
    //   79: invokevirtual 346	java/io/ByteArrayOutputStream:write	([BII)V
    //   82: goto -51 -> 31
    //   85: astore_1
    //   86: aload 12
    //   88: invokevirtual 347	java/io/ByteArrayOutputStream:close	()V
    //   91: aload 10
    //   93: ifnull +8 -> 101
    //   96: aload 10
    //   98: invokevirtual 323	java/io/FileOutputStream:close	()V
    //   101: aload_1
    //   102: athrow
    //   103: astore 9
    //   105: aload 9
    //   107: invokevirtual 328	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   110: aconst_null
    //   111: astore 9
    //   113: goto -91 -> 22
    //   116: aload 11
    //   118: astore 10
    //   120: aload 12
    //   122: invokevirtual 348	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   125: astore_1
    //   126: aload 11
    //   128: astore 10
    //   130: aload_1
    //   131: ldc_w 350
    //   134: invokevirtual 230	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   137: iflt +552 -> 689
    //   140: iconst_1
    //   141: istore 8
    //   143: aload 11
    //   145: astore 10
    //   147: ldc_w 352
    //   150: new 50	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   157: aload_1
    //   158: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: ldc_w 354
    //   164: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: iload 8
    //   169: invokevirtual 357	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   172: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 362	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   178: pop
    //   179: iload 8
    //   181: ifeq +583 -> 764
    //   184: aload 11
    //   186: astore 10
    //   188: new 287	java/lang/StringBuffer
    //   191: dup
    //   192: aload_1
    //   193: invokespecial 288	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   196: astore_1
    //   197: aload 11
    //   199: astore 10
    //   201: aload_1
    //   202: ldc_w 302
    //   205: invokevirtual 303	java/lang/StringBuffer:indexOf	(Ljava/lang/String;)I
    //   208: istore 7
    //   210: iload 7
    //   212: ifle +37 -> 249
    //   215: aload 11
    //   217: astore 10
    //   219: aload_1
    //   220: iload 7
    //   222: iload 7
    //   224: bipush 8
    //   226: iadd
    //   227: new 50	java/lang/StringBuilder
    //   230: dup
    //   231: ldc_w 270
    //   234: invokespecial 171	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   237: aload 6
    //   239: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: invokevirtual 307	java/lang/StringBuffer:replace	(IILjava/lang/String;)Ljava/lang/StringBuffer;
    //   248: pop
    //   249: aload 11
    //   251: astore 10
    //   253: aload_1
    //   254: ldc_w 309
    //   257: invokevirtual 303	java/lang/StringBuffer:indexOf	(Ljava/lang/String;)I
    //   260: istore 7
    //   262: iload 7
    //   264: ifle +37 -> 301
    //   267: aload 11
    //   269: astore 10
    //   271: aload_1
    //   272: iload 7
    //   274: iload 7
    //   276: bipush 8
    //   278: iadd
    //   279: new 50	java/lang/StringBuilder
    //   282: dup
    //   283: ldc_w 270
    //   286: invokespecial 171	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   289: aload 6
    //   291: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokevirtual 307	java/lang/StringBuffer:replace	(IILjava/lang/String;)Ljava/lang/StringBuffer;
    //   300: pop
    //   301: aload 11
    //   303: astore 10
    //   305: ldc_w 364
    //   308: new 50	java/lang/StringBuilder
    //   311: dup
    //   312: ldc_w 366
    //   315: invokespecial 171	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   318: aload_1
    //   319: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   322: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokestatic 362	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   328: pop
    //   329: aload 11
    //   331: astore 10
    //   333: aload_0
    //   334: aload_2
    //   335: invokevirtual 311	com/jtpgodorncrqoeurl/AdAssetController:getAssetOutputString	(Ljava/lang/String;)Ljava/io/FileOutputStream;
    //   338: astore 11
    //   340: iload 8
    //   342: ifne +229 -> 571
    //   345: aload 11
    //   347: astore 10
    //   349: aload 11
    //   351: ldc_w 368
    //   354: invokevirtual 315	java/lang/String:getBytes	()[B
    //   357: invokevirtual 319	java/io/FileOutputStream:write	([B)V
    //   360: aload 11
    //   362: astore 10
    //   364: aload 11
    //   366: ldc_w 370
    //   369: invokevirtual 315	java/lang/String:getBytes	()[B
    //   372: invokevirtual 319	java/io/FileOutputStream:write	([B)V
    //   375: aload 11
    //   377: astore 10
    //   379: aload 11
    //   381: ldc_w 372
    //   384: invokevirtual 315	java/lang/String:getBytes	()[B
    //   387: invokevirtual 319	java/io/FileOutputStream:write	([B)V
    //   390: aload 11
    //   392: astore 10
    //   394: aload 11
    //   396: ldc_w 374
    //   399: invokevirtual 315	java/lang/String:getBytes	()[B
    //   402: invokevirtual 319	java/io/FileOutputStream:write	([B)V
    //   405: aload 11
    //   407: astore 10
    //   409: aload 11
    //   411: new 50	java/lang/StringBuilder
    //   414: dup
    //   415: ldc_w 376
    //   418: invokespecial 171	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   421: aload 5
    //   423: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: ldc_w 378
    //   429: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokevirtual 315	java/lang/String:getBytes	()[B
    //   438: invokevirtual 319	java/io/FileOutputStream:write	([B)V
    //   441: aload 11
    //   443: astore 10
    //   445: aload 11
    //   447: new 50	java/lang/StringBuilder
    //   450: dup
    //   451: ldc_w 376
    //   454: invokespecial 171	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   457: aload 6
    //   459: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: ldc_w 378
    //   465: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   471: invokevirtual 315	java/lang/String:getBytes	()[B
    //   474: invokevirtual 319	java/io/FileOutputStream:write	([B)V
    //   477: aload 4
    //   479: ifnull +47 -> 526
    //   482: aload 11
    //   484: astore 10
    //   486: aload 11
    //   488: ldc_w 380
    //   491: invokevirtual 315	java/lang/String:getBytes	()[B
    //   494: invokevirtual 319	java/io/FileOutputStream:write	([B)V
    //   497: aload 11
    //   499: astore 10
    //   501: aload 11
    //   503: aload 4
    //   505: invokevirtual 315	java/lang/String:getBytes	()[B
    //   508: invokevirtual 319	java/io/FileOutputStream:write	([B)V
    //   511: aload 11
    //   513: astore 10
    //   515: aload 11
    //   517: ldc_w 382
    //   520: invokevirtual 315	java/lang/String:getBytes	()[B
    //   523: invokevirtual 319	java/io/FileOutputStream:write	([B)V
    //   526: aload 11
    //   528: astore 10
    //   530: aload 11
    //   532: ldc_w 384
    //   535: invokevirtual 315	java/lang/String:getBytes	()[B
    //   538: invokevirtual 319	java/io/FileOutputStream:write	([B)V
    //   541: aload 11
    //   543: astore 10
    //   545: aload 11
    //   547: ldc_w 386
    //   550: invokevirtual 315	java/lang/String:getBytes	()[B
    //   553: invokevirtual 319	java/io/FileOutputStream:write	([B)V
    //   556: aload 11
    //   558: astore 10
    //   560: aload 11
    //   562: ldc_w 388
    //   565: invokevirtual 315	java/lang/String:getBytes	()[B
    //   568: invokevirtual 319	java/io/FileOutputStream:write	([B)V
    //   571: iload 8
    //   573: ifne +154 -> 727
    //   576: aload 11
    //   578: astore 10
    //   580: aload 11
    //   582: aload 12
    //   584: invokevirtual 391	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   587: invokevirtual 319	java/io/FileOutputStream:write	([B)V
    //   590: iload 8
    //   592: ifne +48 -> 640
    //   595: aload 11
    //   597: astore 10
    //   599: aload 11
    //   601: ldc_w 393
    //   604: invokevirtual 315	java/lang/String:getBytes	()[B
    //   607: invokevirtual 319	java/io/FileOutputStream:write	([B)V
    //   610: aload 11
    //   612: astore 10
    //   614: aload 11
    //   616: ldc_w 395
    //   619: invokevirtual 315	java/lang/String:getBytes	()[B
    //   622: invokevirtual 319	java/io/FileOutputStream:write	([B)V
    //   625: aload 11
    //   627: astore 10
    //   629: aload 11
    //   631: ldc_w 397
    //   634: invokevirtual 315	java/lang/String:getBytes	()[B
    //   637: invokevirtual 319	java/io/FileOutputStream:write	([B)V
    //   640: aload 11
    //   642: astore 10
    //   644: aload 11
    //   646: invokevirtual 322	java/io/FileOutputStream:flush	()V
    //   649: aload 12
    //   651: invokevirtual 347	java/io/ByteArrayOutputStream:close	()V
    //   654: aload 11
    //   656: ifnull +8 -> 664
    //   659: aload 11
    //   661: invokevirtual 323	java/io/FileOutputStream:close	()V
    //   664: aload_0
    //   665: invokespecial 251	com/jtpgodorncrqoeurl/AdAssetController:a	()Ljava/lang/String;
    //   668: astore_1
    //   669: iload_3
    //   670: ifeq +92 -> 762
    //   673: aload 9
    //   675: ifnull +87 -> 762
    //   678: aload_2
    //   679: aload_1
    //   680: aload 9
    //   682: invokestatic 325	com/jtpgodorncrqoeurl/AdAssetController:a	(Ljava/security/MessageDigest;)Ljava/lang/String;
    //   685: invokestatic 327	com/jtpgodorncrqoeurl/AdAssetController:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   688: areturn
    //   689: iconst_0
    //   690: istore 8
    //   692: goto -549 -> 143
    //   695: astore 13
    //   697: aload 11
    //   699: astore 10
    //   701: ldc -13
    //   703: aload 13
    //   705: invokestatic 248	com/jtpgodorncrqoeurl/AdLog:printStackTrace	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   708: goto -459 -> 249
    //   711: astore 13
    //   713: aload 11
    //   715: astore 10
    //   717: ldc -13
    //   719: aload 13
    //   721: invokestatic 248	com/jtpgodorncrqoeurl/AdLog:printStackTrace	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   724: goto -423 -> 301
    //   727: aload 11
    //   729: astore 10
    //   731: aload 11
    //   733: aload_1
    //   734: invokevirtual 312	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   737: invokevirtual 315	java/lang/String:getBytes	()[B
    //   740: invokevirtual 319	java/io/FileOutputStream:write	([B)V
    //   743: goto -153 -> 590
    //   746: astore_1
    //   747: goto -93 -> 654
    //   750: astore_1
    //   751: goto -87 -> 664
    //   754: astore_2
    //   755: goto -664 -> 91
    //   758: astore_2
    //   759: goto -658 -> 101
    //   762: aload_1
    //   763: areturn
    //   764: aconst_null
    //   765: astore_1
    //   766: goto -465 -> 301
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	769	0	this	AdAssetController
    //   0	769	1	paramInputStream	java.io.InputStream
    //   0	769	2	paramString1	String
    //   0	769	3	paramBoolean	boolean
    //   0	769	4	paramString2	String
    //   0	769	5	paramString3	String
    //   0	769	6	paramString4	String
    //   41	238	7	i	int
    //   141	550	8	bool	boolean
    //   20	42	9	localMessageDigest1	MessageDigest
    //   103	3	9	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   111	570	9	localMessageDigest2	MessageDigest
    //   33	697	10	localFileOutputStream1	FileOutputStream
    //   1	731	11	localFileOutputStream2	FileOutputStream
    //   29	621	12	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   8	67	13	arrayOfByte	byte[]
    //   695	9	13	localException1	Exception
    //   711	9	13	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   35	43	85	finally
    //   61	68	85	finally
    //   72	82	85	finally
    //   120	126	85	finally
    //   130	140	85	finally
    //   147	179	85	finally
    //   188	197	85	finally
    //   201	210	85	finally
    //   219	249	85	finally
    //   253	262	85	finally
    //   271	301	85	finally
    //   305	329	85	finally
    //   333	340	85	finally
    //   349	360	85	finally
    //   364	375	85	finally
    //   379	390	85	finally
    //   394	405	85	finally
    //   409	441	85	finally
    //   445	477	85	finally
    //   486	497	85	finally
    //   501	511	85	finally
    //   515	526	85	finally
    //   530	541	85	finally
    //   545	556	85	finally
    //   560	571	85	finally
    //   580	590	85	finally
    //   599	610	85	finally
    //   614	625	85	finally
    //   629	640	85	finally
    //   644	649	85	finally
    //   701	708	85	finally
    //   717	724	85	finally
    //   731	743	85	finally
    //   14	22	103	java/security/NoSuchAlgorithmException
    //   201	210	695	java/lang/Exception
    //   219	249	695	java/lang/Exception
    //   253	262	711	java/lang/Exception
    //   271	301	711	java/lang/Exception
    //   649	654	746	java/lang/Exception
    //   659	664	750	java/lang/Exception
    //   86	91	754	java/lang/Exception
    //   96	101	758	java/lang/Exception
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/AdAssetController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */