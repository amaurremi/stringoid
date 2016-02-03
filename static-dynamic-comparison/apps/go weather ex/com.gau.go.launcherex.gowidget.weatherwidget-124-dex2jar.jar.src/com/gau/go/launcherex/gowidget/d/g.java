package com.gau.go.launcherex.gowidget.d;

import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.gau.go.launcherex.gowidget.statistics.y;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class g
{
  /* Error */
  public static File a(android.graphics.Bitmap paramBitmap, String paramString1, String paramString2, android.graphics.Bitmap.CompressFormat paramCompressFormat, int paramInt, Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: invokestatic 15	com/gau/go/launcherex/gowidget/statistics/y:a	()Z
    //   9: ifeq +109 -> 118
    //   12: new 17	java/io/File
    //   15: dup
    //   16: invokestatic 23	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   19: aload_1
    //   20: invokespecial 27	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   23: astore_1
    //   24: aload_1
    //   25: invokevirtual 30	java/io/File:exists	()Z
    //   28: ifne +8 -> 36
    //   31: aload_1
    //   32: invokevirtual 33	java/io/File:mkdirs	()Z
    //   35: pop
    //   36: new 17	java/io/File
    //   39: dup
    //   40: new 35	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 38	java/lang/StringBuilder:<init>	()V
    //   47: aload_1
    //   48: invokevirtual 42	java/io/File:getPath	()Ljava/lang/String;
    //   51: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: getstatic 50	java/io/File:separator	Ljava/lang/String;
    //   57: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: aload_2
    //   61: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokespecial 56	java/io/File:<init>	(Ljava/lang/String;)V
    //   70: astore_1
    //   71: new 58	java/io/BufferedOutputStream
    //   74: dup
    //   75: new 60	java/io/FileOutputStream
    //   78: dup
    //   79: aload_1
    //   80: invokespecial 63	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   83: invokespecial 66	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   86: astore_2
    //   87: aload_0
    //   88: aload_3
    //   89: iload 4
    //   91: aload_2
    //   92: invokevirtual 72	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   95: pop
    //   96: aload_2
    //   97: invokevirtual 75	java/io/BufferedOutputStream:flush	()V
    //   100: aload_2
    //   101: invokevirtual 78	java/io/BufferedOutputStream:close	()V
    //   104: aload_1
    //   105: astore_0
    //   106: aload_0
    //   107: areturn
    //   108: astore_1
    //   109: aconst_null
    //   110: astore_0
    //   111: aload_1
    //   112: invokevirtual 81	java/lang/Exception:printStackTrace	()V
    //   115: goto -9 -> 106
    //   118: iload 6
    //   120: ifeq +33 -> 153
    //   123: aload_0
    //   124: aload_3
    //   125: iload 4
    //   127: aload 5
    //   129: aload_2
    //   130: iconst_0
    //   131: invokevirtual 87	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   134: invokevirtual 72	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   137: pop
    //   138: aload 5
    //   140: aload_2
    //   141: invokevirtual 91	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
    //   144: astore_0
    //   145: goto -39 -> 106
    //   148: astore_0
    //   149: aload_0
    //   150: invokevirtual 92	java/io/FileNotFoundException:printStackTrace	()V
    //   153: aconst_null
    //   154: astore_0
    //   155: goto -49 -> 106
    //   158: astore_2
    //   159: aload_1
    //   160: astore_0
    //   161: aload_2
    //   162: astore_1
    //   163: goto -52 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	paramBitmap	android.graphics.Bitmap
    //   0	166	1	paramString1	String
    //   0	166	2	paramString2	String
    //   0	166	3	paramCompressFormat	android.graphics.Bitmap.CompressFormat
    //   0	166	4	paramInt	int
    //   0	166	5	paramContext	Context
    //   0	166	6	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   36	71	108	java/lang/Exception
    //   123	145	148	java/io/FileNotFoundException
    //   71	104	158	java/lang/Exception
  }
  
  public static String a(String paramString)
  {
    try
    {
      paramString = MessageDigest.getInstance("MD5").digest(paramString.getBytes("UTF-8"));
      StringBuilder localStringBuilder = new StringBuilder(paramString.length * 2);
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        int k = paramString[i];
        if ((k & 0xFF) < 16) {
          localStringBuilder.append("0");
        }
        localStringBuilder.append(Integer.toHexString(k & 0xFF));
        i += 1;
      }
      return localStringBuilder.toString();
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new RuntimeException("oh, MD5 not be supported?", paramString);
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("oh, UTF-8 should be supported?", paramString);
    }
  }
  
  public static void a(Context paramContext, int[] paramArrayOfInt)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length >= 2))
    {
      paramArrayOfInt[0] = Math.min(paramContext.widthPixels, paramContext.heightPixels);
      paramArrayOfInt[1] = Math.max(paramContext.widthPixels, paramContext.heightPixels);
    }
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if ((paramContext != null) && (paramContext.isConnected())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (y.a())
    {
      paramString1 = new File(Environment.getExternalStorageDirectory(), paramString1);
      paramString1 = new File(paramString1.getPath() + File.separator + paramString2);
      bool1 = bool2;
      if (paramString1.exists()) {
        bool1 = paramString1.delete();
      }
    }
    if (paramBoolean) {
      bool1 = paramContext.deleteFile(paramString2);
    }
    return bool1;
  }
  
  public static int b(Context paramContext)
  {
    paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSimOperator();
    if (paramContext != null)
    {
      if ((paramContext.startsWith("46000")) || (paramContext.startsWith("46002"))) {
        return 0;
      }
      if (paramContext.startsWith("46001")) {
        return 1;
      }
      if (paramContext.startsWith("46003")) {
        return 2;
      }
    }
    return -1;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/d/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */