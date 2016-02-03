package com.tapjoy.mraid.controller;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import com.tapjoy.TapjoyLog;
import com.tapjoy.mraid.view.MraidView;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.ByteArrayBuffer;

public class Assets
  extends Abstract
{
  private static final char[] HEX_CHARS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final String TAG = "MRAID Assets";
  private int imageNameCounter = 0;
  
  public Assets(MraidView paramMraidView, Context paramContext)
  {
    super(paramMraidView, paramContext);
  }
  
  private String asHex(MessageDigest paramMessageDigest)
  {
    paramMessageDigest = paramMessageDigest.digest();
    char[] arrayOfChar = new char[paramMessageDigest.length * 2];
    int i = 0;
    int j = 0;
    while (i < paramMessageDigest.length)
    {
      int k = j + 1;
      arrayOfChar[j] = HEX_CHARS[(paramMessageDigest[i] >>> 4 & 0xF)];
      j = k + 1;
      arrayOfChar[k] = HEX_CHARS[(paramMessageDigest[i] & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  private boolean contains(StringBuffer paramStringBuffer, String paramString)
  {
    try
    {
      int i = paramStringBuffer.indexOf(paramString);
      if (i >= 0) {
        return true;
      }
    }
    catch (Exception paramStringBuffer)
    {
      TapjoyLog.d("contains", "html file does not contain " + paramString);
    }
    return false;
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
  
  private File getAssetDir(String paramString)
  {
    File localFile = this.mContext.getFilesDir();
    return new File(localFile.getPath() + File.separator + paramString);
  }
  
  private String getAssetName(String paramString)
  {
    int i = paramString.lastIndexOf(File.separatorChar);
    String str = paramString;
    if (i >= 0) {
      str = paramString.substring(paramString.lastIndexOf(File.separatorChar) + 1);
    }
    return str;
  }
  
  private String getAssetPath(String paramString)
  {
    int i = paramString.lastIndexOf(File.separatorChar);
    String str = "/";
    if (i >= 0) {
      str = paramString.substring(0, paramString.lastIndexOf(File.separatorChar));
    }
    return str;
  }
  
  private String getFilesDir()
  {
    return this.mContext.getFilesDir().getPath();
  }
  
  private HttpEntity getHttpEntity(String paramString)
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
  
  private String moveToAdDirectory(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new File(paramString2 + File.separator + paramString1);
    new File(paramString2 + File.separator + "ad").mkdir();
    paramString2 = new File(paramString2 + File.separator + "ad" + File.separator + paramString3);
    paramString2.mkdir();
    paramString1.renameTo(new File(paramString2, paramString1.getName()));
    return paramString2.getPath() + File.separator;
  }
  
  private void replace(StringBuffer paramStringBuffer, String paramString1, String paramString2)
  {
    int i = paramStringBuffer.indexOf(paramString1);
    TapjoyLog.d("replace ", paramString2);
    paramStringBuffer.replace(i, paramString1.length() + i, "file://" + paramString2);
  }
  
  /* Error */
  public void addAsset(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: invokespecial 200	com/tapjoy/mraid/controller/Assets:getHttpEntity	(Ljava/lang/String;)Lorg/apache/http/HttpEntity;
    //   5: astore 5
    //   7: aconst_null
    //   8: astore_3
    //   9: aconst_null
    //   10: astore_2
    //   11: aload 5
    //   13: invokeinterface 206 1 0
    //   18: astore 4
    //   20: aload 4
    //   22: astore_2
    //   23: aload 4
    //   25: astore_3
    //   26: aload_0
    //   27: aload 4
    //   29: aload_1
    //   30: iconst_0
    //   31: invokevirtual 210	com/tapjoy/mraid/controller/Assets:writeToDisk	(Ljava/io/InputStream;Ljava/lang/String;Z)Ljava/lang/String;
    //   34: pop
    //   35: aload 4
    //   37: astore_2
    //   38: aload 4
    //   40: astore_3
    //   41: new 67	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   48: ldc -44
    //   50: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload_1
    //   54: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc -42
    //   59: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: astore_1
    //   66: aload 4
    //   68: astore_2
    //   69: aload 4
    //   71: astore_3
    //   72: aload_0
    //   73: getfield 218	com/tapjoy/mraid/controller/Assets:mMraidView	Lcom/tapjoy/mraid/view/MraidView;
    //   76: aload_1
    //   77: invokevirtual 223	com/tapjoy/mraid/view/MraidView:injectMraidJavaScript	(Ljava/lang/String;)V
    //   80: aload 4
    //   82: ifnull +8 -> 90
    //   85: aload 4
    //   87: invokevirtual 228	java/io/InputStream:close	()V
    //   90: aload 5
    //   92: invokeinterface 231 1 0
    //   97: return
    //   98: astore_1
    //   99: aload_2
    //   100: astore_3
    //   101: aload_1
    //   102: invokevirtual 168	java/lang/Exception:printStackTrace	()V
    //   105: aload_2
    //   106: ifnull -16 -> 90
    //   109: aload_2
    //   110: invokevirtual 228	java/io/InputStream:close	()V
    //   113: goto -23 -> 90
    //   116: astore_1
    //   117: aload_3
    //   118: ifnull +7 -> 125
    //   121: aload_3
    //   122: invokevirtual 228	java/io/InputStream:close	()V
    //   125: aload_1
    //   126: athrow
    //   127: astore_1
    //   128: aload_1
    //   129: invokevirtual 168	java/lang/Exception:printStackTrace	()V
    //   132: return
    //   133: astore_1
    //   134: goto -44 -> 90
    //   137: astore_1
    //   138: goto -25 -> 113
    //   141: astore_2
    //   142: goto -17 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	Assets
    //   0	145	1	paramString1	String
    //   0	145	2	paramString2	String
    //   8	114	3	localObject	Object
    //   18	68	4	localInputStream	java.io.InputStream
    //   5	86	5	localHttpEntity	HttpEntity
    // Exception table:
    //   from	to	target	type
    //   11	20	98	java/lang/Exception
    //   26	35	98	java/lang/Exception
    //   41	66	98	java/lang/Exception
    //   72	80	98	java/lang/Exception
    //   11	20	116	finally
    //   26	35	116	finally
    //   41	66	116	finally
    //   72	80	116	finally
    //   101	105	116	finally
    //   90	97	127	java/lang/Exception
    //   85	90	133	java/lang/Exception
    //   109	113	137	java/lang/Exception
    //   121	125	141	java/lang/Exception
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
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 8
    //   6: aload 8
    //   8: astore 5
    //   10: aload 9
    //   12: astore 4
    //   14: ldc 2
    //   16: invokevirtual 249	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   19: aload_2
    //   20: invokevirtual 255	java/lang/ClassLoader:getResource	(Ljava/lang/String;)Ljava/net/URL;
    //   23: astore 6
    //   25: aload 6
    //   27: ifnonnull +47 -> 74
    //   30: aload 8
    //   32: astore 5
    //   34: aload 9
    //   36: astore 4
    //   38: aload_0
    //   39: getfield 115	com/tapjoy/mraid/controller/Assets:mContext	Landroid/content/Context;
    //   42: invokevirtual 259	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   45: aload_2
    //   46: invokevirtual 265	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   49: astore_2
    //   50: aload_2
    //   51: astore 5
    //   53: aload_2
    //   54: astore 4
    //   56: aload_0
    //   57: aload_2
    //   58: aload_1
    //   59: iconst_0
    //   60: invokevirtual 210	com/tapjoy/mraid/controller/Assets:writeToDisk	(Ljava/io/InputStream;Ljava/lang/String;Z)Ljava/lang/String;
    //   63: astore_1
    //   64: aload_2
    //   65: ifnull +7 -> 72
    //   68: aload_2
    //   69: invokevirtual 228	java/io/InputStream:close	()V
    //   72: aload_1
    //   73: areturn
    //   74: aload 8
    //   76: astore 5
    //   78: aload 9
    //   80: astore 4
    //   82: aload 6
    //   84: invokevirtual 270	java/net/URL:getFile	()Ljava/lang/String;
    //   87: astore 7
    //   89: aload 7
    //   91: astore 6
    //   93: aload 8
    //   95: astore 5
    //   97: aload 9
    //   99: astore 4
    //   101: aload 7
    //   103: ldc_w 272
    //   106: invokevirtual 275	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   109: ifeq +19 -> 128
    //   112: aload 8
    //   114: astore 5
    //   116: aload 9
    //   118: astore 4
    //   120: aload 7
    //   122: iconst_4
    //   123: invokevirtual 141	java/lang/String:substring	(I)Ljava/lang/String;
    //   126: astore 6
    //   128: aload 6
    //   130: astore 7
    //   132: aload 8
    //   134: astore 5
    //   136: aload 9
    //   138: astore 4
    //   140: aload 6
    //   142: ldc_w 277
    //   145: invokevirtual 275	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   148: ifeq +19 -> 167
    //   151: aload 8
    //   153: astore 5
    //   155: aload 9
    //   157: astore 4
    //   159: aload 6
    //   161: iconst_5
    //   162: invokevirtual 141	java/lang/String:substring	(I)Ljava/lang/String;
    //   165: astore 7
    //   167: aload 8
    //   169: astore 5
    //   171: aload 9
    //   173: astore 4
    //   175: aload 7
    //   177: ldc_w 279
    //   180: invokevirtual 280	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   183: istore_3
    //   184: aload 7
    //   186: astore 6
    //   188: iload_3
    //   189: ifle +20 -> 209
    //   192: aload 8
    //   194: astore 5
    //   196: aload 9
    //   198: astore 4
    //   200: aload 7
    //   202: iconst_0
    //   203: iload_3
    //   204: invokevirtual 147	java/lang/String:substring	(II)Ljava/lang/String;
    //   207: astore 6
    //   209: aload 8
    //   211: astore 5
    //   213: aload 9
    //   215: astore 4
    //   217: new 282	java/util/jar/JarFile
    //   220: dup
    //   221: aload 6
    //   223: invokespecial 283	java/util/jar/JarFile:<init>	(Ljava/lang/String;)V
    //   226: astore 6
    //   228: aload 8
    //   230: astore 5
    //   232: aload 9
    //   234: astore 4
    //   236: aload 6
    //   238: aload 6
    //   240: aload_2
    //   241: invokevirtual 287	java/util/jar/JarFile:getJarEntry	(Ljava/lang/String;)Ljava/util/jar/JarEntry;
    //   244: invokevirtual 291	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   247: astore_2
    //   248: goto -198 -> 50
    //   251: astore_1
    //   252: aload 5
    //   254: astore 4
    //   256: ldc 12
    //   258: new 67	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   265: ldc_w 293
    //   268: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: aload_1
    //   272: invokevirtual 294	java/lang/Exception:toString	()Ljava/lang/String;
    //   275: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 297	com/tapjoy/TapjoyLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: aload 5
    //   286: ifnull +8 -> 294
    //   289: aload 5
    //   291: invokevirtual 228	java/io/InputStream:close	()V
    //   294: aconst_null
    //   295: areturn
    //   296: astore_1
    //   297: aload 4
    //   299: ifnull +8 -> 307
    //   302: aload 4
    //   304: invokevirtual 228	java/io/InputStream:close	()V
    //   307: aload_1
    //   308: athrow
    //   309: astore_2
    //   310: goto -238 -> 72
    //   313: astore_1
    //   314: goto -20 -> 294
    //   317: astore_2
    //   318: goto -11 -> 307
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	321	0	this	Assets
    //   0	321	1	paramString1	String
    //   0	321	2	paramString2	String
    //   183	21	3	i	int
    //   12	291	4	localObject1	Object
    //   8	282	5	localObject2	Object
    //   23	216	6	localObject3	Object
    //   87	114	7	localObject4	Object
    //   4	225	8	localObject5	Object
    //   1	232	9	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   14	25	251	java/lang/Exception
    //   38	50	251	java/lang/Exception
    //   56	64	251	java/lang/Exception
    //   82	89	251	java/lang/Exception
    //   101	112	251	java/lang/Exception
    //   120	128	251	java/lang/Exception
    //   140	151	251	java/lang/Exception
    //   159	167	251	java/lang/Exception
    //   175	184	251	java/lang/Exception
    //   200	209	251	java/lang/Exception
    //   217	228	251	java/lang/Exception
    //   236	248	251	java/lang/Exception
    //   14	25	296	finally
    //   38	50	296	finally
    //   56	64	296	finally
    //   82	89	296	finally
    //   101	112	296	finally
    //   120	128	296	finally
    //   140	151	296	finally
    //   159	167	296	finally
    //   175	184	296	finally
    //   200	209	296	finally
    //   217	228	296	finally
    //   236	248	296	finally
    //   256	284	296	finally
    //   68	72	309	java/lang/Exception
    //   289	294	313	java/lang/Exception
    //   302	307	317	java/lang/Exception
  }
  
  /* Error */
  public String copyTextFromJarIntoString(String paramString)
  {
    // Byte code:
    //   0: sipush 1024
    //   3: newarray <illegal type>
    //   5: astore 9
    //   7: new 60	java/lang/StringBuffer
    //   10: dup
    //   11: invokespecial 299	java/lang/StringBuffer:<init>	()V
    //   14: astore 10
    //   16: aconst_null
    //   17: astore 8
    //   19: aconst_null
    //   20: astore 7
    //   22: aload 7
    //   24: astore 4
    //   26: aload 8
    //   28: astore_3
    //   29: ldc 2
    //   31: invokevirtual 249	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   34: aload_1
    //   35: invokevirtual 255	java/lang/ClassLoader:getResource	(Ljava/lang/String;)Ljava/net/URL;
    //   38: astore 5
    //   40: aload 5
    //   42: ifnonnull +61 -> 103
    //   45: aload 7
    //   47: astore 4
    //   49: aload 8
    //   51: astore_3
    //   52: aload_0
    //   53: getfield 115	com/tapjoy/mraid/controller/Assets:mContext	Landroid/content/Context;
    //   56: invokevirtual 259	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   59: aload_1
    //   60: invokevirtual 265	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   63: astore_1
    //   64: aload_1
    //   65: astore 4
    //   67: aload_1
    //   68: astore_3
    //   69: aload_1
    //   70: aload 9
    //   72: invokevirtual 303	java/io/InputStream:read	([B)I
    //   75: istore_2
    //   76: iload_2
    //   77: ifgt +194 -> 271
    //   80: aload_1
    //   81: astore 4
    //   83: aload_1
    //   84: astore_3
    //   85: aload 10
    //   87: invokevirtual 304	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   90: astore 5
    //   92: aload_1
    //   93: ifnull +7 -> 100
    //   96: aload_1
    //   97: invokevirtual 228	java/io/InputStream:close	()V
    //   100: aload 5
    //   102: areturn
    //   103: aload 7
    //   105: astore 4
    //   107: aload 8
    //   109: astore_3
    //   110: aload 5
    //   112: invokevirtual 270	java/net/URL:getFile	()Ljava/lang/String;
    //   115: astore 6
    //   117: aload 6
    //   119: astore 5
    //   121: aload 7
    //   123: astore 4
    //   125: aload 8
    //   127: astore_3
    //   128: aload 6
    //   130: ldc_w 272
    //   133: invokevirtual 275	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   136: ifeq +18 -> 154
    //   139: aload 7
    //   141: astore 4
    //   143: aload 8
    //   145: astore_3
    //   146: aload 6
    //   148: iconst_4
    //   149: invokevirtual 141	java/lang/String:substring	(I)Ljava/lang/String;
    //   152: astore 5
    //   154: aload 5
    //   156: astore 6
    //   158: aload 7
    //   160: astore 4
    //   162: aload 8
    //   164: astore_3
    //   165: aload 5
    //   167: ldc_w 277
    //   170: invokevirtual 275	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   173: ifeq +18 -> 191
    //   176: aload 7
    //   178: astore 4
    //   180: aload 8
    //   182: astore_3
    //   183: aload 5
    //   185: iconst_5
    //   186: invokevirtual 141	java/lang/String:substring	(I)Ljava/lang/String;
    //   189: astore 6
    //   191: aload 7
    //   193: astore 4
    //   195: aload 8
    //   197: astore_3
    //   198: aload 6
    //   200: ldc_w 279
    //   203: invokevirtual 280	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   206: istore_2
    //   207: aload 6
    //   209: astore 5
    //   211: iload_2
    //   212: ifle +19 -> 231
    //   215: aload 7
    //   217: astore 4
    //   219: aload 8
    //   221: astore_3
    //   222: aload 6
    //   224: iconst_0
    //   225: iload_2
    //   226: invokevirtual 147	java/lang/String:substring	(II)Ljava/lang/String;
    //   229: astore 5
    //   231: aload 7
    //   233: astore 4
    //   235: aload 8
    //   237: astore_3
    //   238: new 282	java/util/jar/JarFile
    //   241: dup
    //   242: aload 5
    //   244: invokespecial 283	java/util/jar/JarFile:<init>	(Ljava/lang/String;)V
    //   247: astore 5
    //   249: aload 7
    //   251: astore 4
    //   253: aload 8
    //   255: astore_3
    //   256: aload 5
    //   258: aload 5
    //   260: aload_1
    //   261: invokevirtual 287	java/util/jar/JarFile:getJarEntry	(Ljava/lang/String;)Ljava/util/jar/JarEntry;
    //   264: invokevirtual 291	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   267: astore_1
    //   268: goto -204 -> 64
    //   271: aload_1
    //   272: astore 4
    //   274: aload_1
    //   275: astore_3
    //   276: aload 10
    //   278: new 51	java/lang/String
    //   281: dup
    //   282: aload 9
    //   284: invokespecial 307	java/lang/String:<init>	([B)V
    //   287: iconst_0
    //   288: iload_2
    //   289: invokevirtual 147	java/lang/String:substring	(II)Ljava/lang/String;
    //   292: invokevirtual 310	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   295: pop
    //   296: goto -232 -> 64
    //   299: astore_1
    //   300: aload 4
    //   302: astore_3
    //   303: ldc 12
    //   305: new 67	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   312: ldc_w 312
    //   315: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload_1
    //   319: invokevirtual 294	java/lang/Exception:toString	()Ljava/lang/String;
    //   322: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 85	com/tapjoy/TapjoyLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   331: aload 4
    //   333: astore_3
    //   334: aload_1
    //   335: invokevirtual 168	java/lang/Exception:printStackTrace	()V
    //   338: aload 4
    //   340: ifnull +8 -> 348
    //   343: aload 4
    //   345: invokevirtual 228	java/io/InputStream:close	()V
    //   348: aconst_null
    //   349: areturn
    //   350: astore_1
    //   351: aload_3
    //   352: ifnull +7 -> 359
    //   355: aload_3
    //   356: invokevirtual 228	java/io/InputStream:close	()V
    //   359: aload_1
    //   360: athrow
    //   361: astore_1
    //   362: goto -262 -> 100
    //   365: astore_1
    //   366: goto -18 -> 348
    //   369: astore_3
    //   370: goto -11 -> 359
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	373	0	this	Assets
    //   0	373	1	paramString	String
    //   75	214	2	i	int
    //   28	328	3	localObject1	Object
    //   369	1	3	localException	Exception
    //   24	320	4	localObject2	Object
    //   38	221	5	localObject3	Object
    //   115	108	6	localObject4	Object
    //   20	230	7	localObject5	Object
    //   17	237	8	localObject6	Object
    //   5	278	9	arrayOfByte	byte[]
    //   14	263	10	localStringBuffer	StringBuffer
    // Exception table:
    //   from	to	target	type
    //   29	40	299	java/lang/Exception
    //   52	64	299	java/lang/Exception
    //   69	76	299	java/lang/Exception
    //   85	92	299	java/lang/Exception
    //   110	117	299	java/lang/Exception
    //   128	139	299	java/lang/Exception
    //   146	154	299	java/lang/Exception
    //   165	176	299	java/lang/Exception
    //   183	191	299	java/lang/Exception
    //   198	207	299	java/lang/Exception
    //   222	231	299	java/lang/Exception
    //   238	249	299	java/lang/Exception
    //   256	268	299	java/lang/Exception
    //   276	296	299	java/lang/Exception
    //   29	40	350	finally
    //   52	64	350	finally
    //   69	76	350	finally
    //   85	92	350	finally
    //   110	117	350	finally
    //   128	139	350	finally
    //   146	154	350	finally
    //   165	176	350	finally
    //   183	191	350	finally
    //   198	207	350	finally
    //   222	231	350	finally
    //   238	249	350	finally
    //   256	268	350	finally
    //   276	296	350	finally
    //   303	331	350	finally
    //   334	338	350	finally
    //   96	100	361	java/lang/Exception
    //   343	348	365	java/lang/Exception
    //   355	359	369	java/lang/Exception
  }
  
  public void deleteOldAds()
  {
    String str = getFilesDir();
    deleteDirectory(new File(str + File.separator + "ad"));
  }
  
  public FileOutputStream getAssetOutputString(String paramString)
    throws FileNotFoundException
  {
    File localFile = getAssetDir(getAssetPath(paramString));
    localFile.mkdirs();
    return new FileOutputStream(new File(localFile, getAssetName(paramString)));
  }
  
  public String getAssetPath()
  {
    return "file://" + this.mContext.getFilesDir() + "/";
  }
  
  public void removeAsset(String paramString)
  {
    File localFile = getAssetDir(getAssetPath(paramString));
    localFile.mkdirs();
    new File(localFile, getAssetName(paramString)).delete();
    paramString = "MraidAdController.assetRemoved('" + paramString + "' )";
    this.mMraidView.injectMraidJavaScript(paramString);
  }
  
  public void stopAllListeners() {}
  
  public void storePicture(String paramString)
  {
    TapjoyLog.d("MRAID Assets", "Storing media from " + paramString + " to device photo album.  Output directory: " + Environment.getExternalStorageDirectory() + " state: " + Environment.getExternalStorageState());
    this.imageNameCounter += 1;
    Object localObject1;
    long l;
    try
    {
      localObject1 = new URL(paramString);
      Object localObject2 = "MraidMedia" + this.imageNameCounter + ".jpg";
      paramString = new File(Environment.getExternalStorageDirectory().toString() + "/" + (String)localObject2);
      l = System.currentTimeMillis();
      Log.d("MRAID Assets", "download beginning");
      Log.d("MRAID Assets", "download url:" + localObject1);
      Log.d("MRAID Assets", "downloaded file name:" + (String)localObject2);
      localObject2 = new BufferedInputStream(((URL)localObject1).openConnection().getInputStream());
      localObject1 = new ByteArrayBuffer(50);
      for (;;)
      {
        int i = ((BufferedInputStream)localObject2).read();
        if (i == -1) {
          break;
        }
        ((ByteArrayBuffer)localObject1).append((byte)i);
      }
      paramString = new FileOutputStream(paramString);
    }
    catch (IOException paramString)
    {
      Log.d("MRAID Assets", "Error: " + paramString);
      return;
    }
    paramString.write(((ByteArrayBuffer)localObject1).toByteArray());
    paramString.close();
    Log.d("MRAID Assets", "download ready in" + (System.currentTimeMillis() - l) / 1000L + " sec");
  }
  
  public void storePictureInit(final String paramString)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.mContext);
    localBuilder.setMessage("Are you sure you want to save file from " + paramString + " to your SD card?");
    localBuilder.setCancelable(false);
    localBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        Assets.this.storePicture(paramString);
      }
    });
    localBuilder.setNegativeButton("No", null);
    localBuilder.show();
  }
  
  /* Error */
  public String writeToDisk(java.io.InputStream paramInputStream, String paramString, boolean paramBoolean)
    throws java.lang.IllegalStateException, IOException
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: sipush 1024
    //   6: newarray <illegal type>
    //   8: astore 9
    //   10: aconst_null
    //   11: astore 7
    //   13: aload 7
    //   15: astore 6
    //   17: iload_3
    //   18: ifeq +11 -> 29
    //   21: ldc_w 466
    //   24: invokestatic 470	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   27: astore 6
    //   29: aconst_null
    //   30: astore 7
    //   32: aload_0
    //   33: aload_2
    //   34: invokevirtual 472	com/tapjoy/mraid/controller/Assets:getAssetOutputString	(Ljava/lang/String;)Ljava/io/FileOutputStream;
    //   37: astore 8
    //   39: aload 8
    //   41: astore 7
    //   43: aload_1
    //   44: aload 9
    //   46: invokevirtual 303	java/io/InputStream:read	([B)I
    //   49: istore 5
    //   51: iload 5
    //   53: ifgt +90 -> 143
    //   56: aload 8
    //   58: astore 7
    //   60: aload 8
    //   62: invokevirtual 475	java/io/FileOutputStream:flush	()V
    //   65: aload 8
    //   67: ifnull +8 -> 75
    //   70: aload 8
    //   72: invokevirtual 415	java/io/FileOutputStream:close	()V
    //   75: aload_0
    //   76: invokespecial 315	com/tapjoy/mraid/controller/Assets:getFilesDir	()Ljava/lang/String;
    //   79: astore 7
    //   81: aload 7
    //   83: astore_1
    //   84: iload_3
    //   85: ifeq +25 -> 110
    //   88: aload 7
    //   90: astore_1
    //   91: aload 6
    //   93: ifnull +17 -> 110
    //   96: aload_0
    //   97: aload_2
    //   98: aload 7
    //   100: aload_0
    //   101: aload 6
    //   103: invokespecial 477	com/tapjoy/mraid/controller/Assets:asHex	(Ljava/security/MessageDigest;)Ljava/lang/String;
    //   106: invokespecial 479	com/tapjoy/mraid/controller/Assets:moveToAdDirectory	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   109: astore_1
    //   110: new 67	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   117: aload_1
    //   118: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload_2
    //   122: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: areturn
    //   129: astore 6
    //   131: aload 6
    //   133: invokevirtual 480	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   136: aload 7
    //   138: astore 6
    //   140: goto -111 -> 29
    //   143: iload_3
    //   144: ifeq +19 -> 163
    //   147: aload 6
    //   149: ifnull +14 -> 163
    //   152: aload 8
    //   154: astore 7
    //   156: aload 6
    //   158: aload 9
    //   160: invokevirtual 483	java/security/MessageDigest:update	([B)V
    //   163: aload 8
    //   165: astore 7
    //   167: aload 8
    //   169: aload 9
    //   171: iconst_0
    //   172: iload 5
    //   174: invokevirtual 486	java/io/FileOutputStream:write	([BII)V
    //   177: iload 4
    //   179: iconst_1
    //   180: iadd
    //   181: istore 4
    //   183: goto -144 -> 39
    //   186: astore_1
    //   187: aload 7
    //   189: ifnull +8 -> 197
    //   192: aload 7
    //   194: invokevirtual 415	java/io/FileOutputStream:close	()V
    //   197: aload_1
    //   198: athrow
    //   199: astore_1
    //   200: goto -125 -> 75
    //   203: astore_2
    //   204: goto -7 -> 197
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	Assets
    //   0	207	1	paramInputStream	java.io.InputStream
    //   0	207	2	paramString	String
    //   0	207	3	paramBoolean	boolean
    //   1	181	4	i	int
    //   49	124	5	j	int
    //   15	87	6	localObject1	Object
    //   129	3	6	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   138	19	6	localObject2	Object
    //   11	182	7	localObject3	Object
    //   37	131	8	localFileOutputStream	FileOutputStream
    //   8	162	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   21	29	129	java/security/NoSuchAlgorithmException
    //   32	39	186	finally
    //   43	51	186	finally
    //   60	65	186	finally
    //   156	163	186	finally
    //   167	177	186	finally
    //   70	75	199	java/lang/Exception
    //   192	197	203	java/lang/Exception
  }
  
  /* Error */
  public String writeToDiskWrap(java.io.InputStream paramInputStream, String paramString1, boolean paramBoolean, String paramString2, String paramString3)
    throws java.lang.IllegalStateException, IOException
  {
    // Byte code:
    //   0: sipush 1024
    //   3: newarray <illegal type>
    //   5: astore 10
    //   7: aconst_null
    //   8: astore 8
    //   10: aload 8
    //   12: astore 7
    //   14: iload_3
    //   15: ifeq +11 -> 26
    //   18: ldc_w 466
    //   21: invokestatic 470	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   24: astore 7
    //   26: new 490	java/io/ByteArrayOutputStream
    //   29: dup
    //   30: invokespecial 491	java/io/ByteArrayOutputStream:<init>	()V
    //   33: astore 11
    //   35: aconst_null
    //   36: astore 9
    //   38: aload 9
    //   40: astore 8
    //   42: aload_1
    //   43: aload 10
    //   45: invokevirtual 303	java/io/InputStream:read	([B)I
    //   48: istore 6
    //   50: iload 6
    //   52: ifgt +403 -> 455
    //   55: aload 9
    //   57: astore 8
    //   59: aload 11
    //   61: invokevirtual 492	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   64: astore_1
    //   65: aload 9
    //   67: astore 8
    //   69: aload_1
    //   70: ldc_w 494
    //   73: invokevirtual 280	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   76: iflt +439 -> 515
    //   79: iconst_1
    //   80: istore 6
    //   82: aload 9
    //   84: astore 8
    //   86: new 60	java/lang/StringBuffer
    //   89: dup
    //   90: aload_1
    //   91: invokespecial 495	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   94: astore 10
    //   96: iload 6
    //   98: ifeq +34 -> 132
    //   101: aload 9
    //   103: astore 8
    //   105: aload_0
    //   106: aload 10
    //   108: ldc_w 497
    //   111: invokespecial 499	com/tapjoy/mraid/controller/Assets:contains	(Ljava/lang/StringBuffer;Ljava/lang/String;)Z
    //   114: ifeq +407 -> 521
    //   117: aload 9
    //   119: astore 8
    //   121: aload_0
    //   122: aload 10
    //   124: ldc_w 497
    //   127: aload 5
    //   129: invokespecial 501	com/tapjoy/mraid/controller/Assets:replace	(Ljava/lang/StringBuffer;Ljava/lang/String;Ljava/lang/String;)V
    //   132: aload 9
    //   134: astore 8
    //   136: aload_0
    //   137: aload_2
    //   138: invokevirtual 472	com/tapjoy/mraid/controller/Assets:getAssetOutputString	(Ljava/lang/String;)Ljava/io/FileOutputStream;
    //   141: astore_1
    //   142: iload 6
    //   144: ifne +174 -> 318
    //   147: aload_1
    //   148: astore 8
    //   150: aload_1
    //   151: ldc_w 503
    //   154: invokevirtual 506	java/lang/String:getBytes	()[B
    //   157: invokevirtual 414	java/io/FileOutputStream:write	([B)V
    //   160: aload_1
    //   161: astore 8
    //   163: aload_1
    //   164: ldc_w 508
    //   167: invokevirtual 506	java/lang/String:getBytes	()[B
    //   170: invokevirtual 414	java/io/FileOutputStream:write	([B)V
    //   173: aload_1
    //   174: astore 8
    //   176: aload_1
    //   177: ldc_w 510
    //   180: invokevirtual 506	java/lang/String:getBytes	()[B
    //   183: invokevirtual 414	java/io/FileOutputStream:write	([B)V
    //   186: aload_1
    //   187: astore 8
    //   189: aload_1
    //   190: ldc_w 512
    //   193: invokevirtual 506	java/lang/String:getBytes	()[B
    //   196: invokevirtual 414	java/io/FileOutputStream:write	([B)V
    //   199: aload_1
    //   200: astore 8
    //   202: aload_1
    //   203: new 67	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   210: ldc_w 514
    //   213: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload 5
    //   218: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: ldc_w 516
    //   224: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokevirtual 506	java/lang/String:getBytes	()[B
    //   233: invokevirtual 414	java/io/FileOutputStream:write	([B)V
    //   236: aload 4
    //   238: ifnull +41 -> 279
    //   241: aload_1
    //   242: astore 8
    //   244: aload_1
    //   245: ldc_w 518
    //   248: invokevirtual 506	java/lang/String:getBytes	()[B
    //   251: invokevirtual 414	java/io/FileOutputStream:write	([B)V
    //   254: aload_1
    //   255: astore 8
    //   257: aload_1
    //   258: aload 4
    //   260: invokevirtual 506	java/lang/String:getBytes	()[B
    //   263: invokevirtual 414	java/io/FileOutputStream:write	([B)V
    //   266: aload_1
    //   267: astore 8
    //   269: aload_1
    //   270: ldc_w 520
    //   273: invokevirtual 506	java/lang/String:getBytes	()[B
    //   276: invokevirtual 414	java/io/FileOutputStream:write	([B)V
    //   279: aload_1
    //   280: astore 8
    //   282: aload_1
    //   283: ldc_w 522
    //   286: invokevirtual 506	java/lang/String:getBytes	()[B
    //   289: invokevirtual 414	java/io/FileOutputStream:write	([B)V
    //   292: aload_1
    //   293: astore 8
    //   295: aload_1
    //   296: ldc_w 524
    //   299: invokevirtual 506	java/lang/String:getBytes	()[B
    //   302: invokevirtual 414	java/io/FileOutputStream:write	([B)V
    //   305: aload_1
    //   306: astore 8
    //   308: aload_1
    //   309: ldc_w 526
    //   312: invokevirtual 506	java/lang/String:getBytes	()[B
    //   315: invokevirtual 414	java/io/FileOutputStream:write	([B)V
    //   318: iload 6
    //   320: ifne +269 -> 589
    //   323: aload_1
    //   324: astore 8
    //   326: aload_1
    //   327: aload 11
    //   329: invokevirtual 527	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   332: invokevirtual 414	java/io/FileOutputStream:write	([B)V
    //   335: iload 6
    //   337: ifne +42 -> 379
    //   340: aload_1
    //   341: astore 8
    //   343: aload_1
    //   344: ldc_w 529
    //   347: invokevirtual 506	java/lang/String:getBytes	()[B
    //   350: invokevirtual 414	java/io/FileOutputStream:write	([B)V
    //   353: aload_1
    //   354: astore 8
    //   356: aload_1
    //   357: ldc_w 531
    //   360: invokevirtual 506	java/lang/String:getBytes	()[B
    //   363: invokevirtual 414	java/io/FileOutputStream:write	([B)V
    //   366: aload_1
    //   367: astore 8
    //   369: aload_1
    //   370: ldc_w 533
    //   373: invokevirtual 506	java/lang/String:getBytes	()[B
    //   376: invokevirtual 414	java/io/FileOutputStream:write	([B)V
    //   379: aload_1
    //   380: astore 8
    //   382: aload_1
    //   383: invokevirtual 475	java/io/FileOutputStream:flush	()V
    //   386: aload 11
    //   388: ifnull +8 -> 396
    //   391: aload 11
    //   393: invokevirtual 534	java/io/ByteArrayOutputStream:close	()V
    //   396: aload_1
    //   397: ifnull +7 -> 404
    //   400: aload_1
    //   401: invokevirtual 415	java/io/FileOutputStream:close	()V
    //   404: aload_0
    //   405: invokespecial 315	com/tapjoy/mraid/controller/Assets:getFilesDir	()Ljava/lang/String;
    //   408: astore 4
    //   410: aload 4
    //   412: astore_1
    //   413: iload_3
    //   414: ifeq +25 -> 439
    //   417: aload 4
    //   419: astore_1
    //   420: aload 7
    //   422: ifnull +17 -> 439
    //   425: aload_0
    //   426: aload_2
    //   427: aload 4
    //   429: aload_0
    //   430: aload 7
    //   432: invokespecial 477	com/tapjoy/mraid/controller/Assets:asHex	(Ljava/security/MessageDigest;)Ljava/lang/String;
    //   435: invokespecial 479	com/tapjoy/mraid/controller/Assets:moveToAdDirectory	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   438: astore_1
    //   439: aload_1
    //   440: areturn
    //   441: astore 7
    //   443: aload 7
    //   445: invokevirtual 480	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   448: aload 8
    //   450: astore 7
    //   452: goto -426 -> 26
    //   455: iload_3
    //   456: ifeq +19 -> 475
    //   459: aload 7
    //   461: ifnull +14 -> 475
    //   464: aload 9
    //   466: astore 8
    //   468: aload 7
    //   470: aload 10
    //   472: invokevirtual 483	java/security/MessageDigest:update	([B)V
    //   475: aload 9
    //   477: astore 8
    //   479: aload 11
    //   481: aload 10
    //   483: iconst_0
    //   484: iload 6
    //   486: invokevirtual 535	java/io/ByteArrayOutputStream:write	([BII)V
    //   489: goto -451 -> 38
    //   492: astore_1
    //   493: aload 11
    //   495: ifnull +8 -> 503
    //   498: aload 11
    //   500: invokevirtual 534	java/io/ByteArrayOutputStream:close	()V
    //   503: aload 8
    //   505: ifnull +8 -> 513
    //   508: aload 8
    //   510: invokevirtual 415	java/io/FileOutputStream:close	()V
    //   513: aload_1
    //   514: athrow
    //   515: iconst_0
    //   516: istore 6
    //   518: goto -436 -> 82
    //   521: aload 9
    //   523: astore 8
    //   525: aload_0
    //   526: aload 10
    //   528: ldc_w 537
    //   531: invokespecial 499	com/tapjoy/mraid/controller/Assets:contains	(Ljava/lang/StringBuffer;Ljava/lang/String;)Z
    //   534: ifeq +21 -> 555
    //   537: aload 9
    //   539: astore 8
    //   541: aload_0
    //   542: aload 10
    //   544: ldc_w 537
    //   547: aload 5
    //   549: invokespecial 501	com/tapjoy/mraid/controller/Assets:replace	(Ljava/lang/StringBuffer;Ljava/lang/String;Ljava/lang/String;)V
    //   552: goto -420 -> 132
    //   555: aload 9
    //   557: astore 8
    //   559: aload_0
    //   560: aload 10
    //   562: ldc_w 539
    //   565: invokespecial 499	com/tapjoy/mraid/controller/Assets:contains	(Ljava/lang/StringBuffer;Ljava/lang/String;)Z
    //   568: ifeq -436 -> 132
    //   571: aload 9
    //   573: astore 8
    //   575: aload_0
    //   576: aload 10
    //   578: ldc_w 539
    //   581: aload 5
    //   583: invokespecial 501	com/tapjoy/mraid/controller/Assets:replace	(Ljava/lang/StringBuffer;Ljava/lang/String;Ljava/lang/String;)V
    //   586: goto -454 -> 132
    //   589: aload_1
    //   590: astore 8
    //   592: aload_1
    //   593: aload 10
    //   595: invokevirtual 304	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   598: invokevirtual 506	java/lang/String:getBytes	()[B
    //   601: invokevirtual 414	java/io/FileOutputStream:write	([B)V
    //   604: goto -269 -> 335
    //   607: astore 4
    //   609: goto -213 -> 396
    //   612: astore_1
    //   613: goto -209 -> 404
    //   616: astore_2
    //   617: goto -114 -> 503
    //   620: astore_2
    //   621: goto -108 -> 513
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	624	0	this	Assets
    //   0	624	1	paramInputStream	java.io.InputStream
    //   0	624	2	paramString1	String
    //   0	624	3	paramBoolean	boolean
    //   0	624	4	paramString2	String
    //   0	624	5	paramString3	String
    //   48	469	6	i	int
    //   12	419	7	localObject1	Object
    //   441	3	7	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   450	19	7	localObject2	Object
    //   8	583	8	localObject3	Object
    //   36	536	9	localObject4	Object
    //   5	589	10	localObject5	Object
    //   33	466	11	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   18	26	441	java/security/NoSuchAlgorithmException
    //   42	50	492	finally
    //   59	65	492	finally
    //   69	79	492	finally
    //   86	96	492	finally
    //   105	117	492	finally
    //   121	132	492	finally
    //   136	142	492	finally
    //   150	160	492	finally
    //   163	173	492	finally
    //   176	186	492	finally
    //   189	199	492	finally
    //   202	236	492	finally
    //   244	254	492	finally
    //   257	266	492	finally
    //   269	279	492	finally
    //   282	292	492	finally
    //   295	305	492	finally
    //   308	318	492	finally
    //   326	335	492	finally
    //   343	353	492	finally
    //   356	366	492	finally
    //   369	379	492	finally
    //   382	386	492	finally
    //   468	475	492	finally
    //   479	489	492	finally
    //   525	537	492	finally
    //   541	552	492	finally
    //   559	571	492	finally
    //   575	586	492	finally
    //   592	604	492	finally
    //   391	396	607	java/lang/Exception
    //   400	404	612	java/lang/Exception
    //   498	503	616	java/lang/Exception
    //   508	513	620	java/lang/Exception
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/mraid/controller/Assets.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */