package com.gau.go.gostaticsdk.f;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

public class d
{
  private static boolean a = false;
  
  public static int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 1;
    }
    return 0;
  }
  
  public static File a(String paramString, boolean paramBoolean)
  {
    paramString = new File(paramString);
    if ((!paramBoolean) && (paramString.exists())) {
      paramString.delete();
    }
    if (!paramString.exists()) {}
    try
    {
      File localFile = paramString.getParentFile();
      if ((localFile != null) && (!localFile.exists())) {
        localFile.mkdirs();
      }
      paramString.createNewFile();
      return paramString;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramString;
  }
  
  public static String a()
  {
    return a(System.currentTimeMillis());
  }
  
  public static String a(long paramLong)
  {
    try
    {
      Object localObject = new Date(paramLong);
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
      localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
      localObject = localSimpleDateFormat.format((Date)localObject);
      return (String)localObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  /* Error */
  public static String a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 88	java/io/ByteArrayOutputStream
    //   5: dup
    //   6: invokespecial 90	java/io/ByteArrayOutputStream:<init>	()V
    //   9: astore 4
    //   11: new 92	java/util/zip/GZIPOutputStream
    //   14: dup
    //   15: aload 4
    //   17: invokespecial 95	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   20: astore_2
    //   21: aload_2
    //   22: astore_1
    //   23: aload_2
    //   24: aload_0
    //   25: invokevirtual 99	java/util/zip/GZIPOutputStream:write	([B)V
    //   28: aload_2
    //   29: astore_1
    //   30: aload_2
    //   31: invokevirtual 102	java/util/zip/GZIPOutputStream:flush	()V
    //   34: aload_2
    //   35: ifnull +7 -> 42
    //   38: aload_2
    //   39: invokevirtual 105	java/util/zip/GZIPOutputStream:close	()V
    //   42: aload_3
    //   43: astore_0
    //   44: aload 4
    //   46: ifnull +11 -> 57
    //   49: aload 4
    //   51: ldc 107
    //   53: invokevirtual 111	java/io/ByteArrayOutputStream:toString	(Ljava/lang/String;)Ljava/lang/String;
    //   56: astore_0
    //   57: aload_0
    //   58: areturn
    //   59: astore_0
    //   60: aconst_null
    //   61: astore_1
    //   62: aload_0
    //   63: athrow
    //   64: astore_0
    //   65: aload_1
    //   66: ifnull +7 -> 73
    //   69: aload_1
    //   70: invokevirtual 105	java/util/zip/GZIPOutputStream:close	()V
    //   73: aload_0
    //   74: athrow
    //   75: astore_0
    //   76: goto -34 -> 42
    //   79: astore_1
    //   80: goto -7 -> 73
    //   83: astore_0
    //   84: aconst_null
    //   85: astore_1
    //   86: goto -21 -> 65
    //   89: astore_0
    //   90: aload_2
    //   91: astore_1
    //   92: goto -30 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	paramArrayOfByte	byte[]
    //   22	48	1	localGZIPOutputStream1	java.util.zip.GZIPOutputStream
    //   79	1	1	localException	Exception
    //   85	7	1	localGZIPOutputStream2	java.util.zip.GZIPOutputStream
    //   20	71	2	localGZIPOutputStream3	java.util.zip.GZIPOutputStream
    //   1	42	3	localObject	Object
    //   9	41	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   11	21	59	java/lang/Exception
    //   23	28	64	finally
    //   30	34	64	finally
    //   62	64	64	finally
    //   38	42	75	java/lang/Exception
    //   69	73	79	java/lang/Exception
    //   11	21	83	finally
    //   23	28	89	java/lang/Exception
    //   30	34	89	java/lang/Exception
  }
  
  public static void a(Exception paramException)
  {
    if ((a) && (paramException != null)) {
      paramException.printStackTrace();
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (a) {
      Log.d(paramString1, paramString2);
    }
  }
  
  public static boolean a(Context paramContext)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (localNetworkInfo != null) && (localNetworkInfo.getType() == 0) && ((Proxy.getDefaultHost() != null) || (Proxy.getHost(paramContext) != null));
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
  
  public static JSONObject b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    do
    {
      return null;
      paramArrayOfByte = c(paramArrayOfByte);
    } while (paramArrayOfByte == null);
    try
    {
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (JSONException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = null;
      }
    }
  }
  
  public static void b(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  public static String c(Context paramContext)
  {
    return Proxy.getHost(paramContext);
  }
  
  public static String c(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = null;
      }
    }
  }
  
  public static int d(Context paramContext)
  {
    return Proxy.getPort(paramContext);
  }
  
  public static String e(Context paramContext)
  {
    Object localObject2 = null;
    for (;;)
    {
      try
      {
        localObject1 = paramContext.getSharedPreferences("go_static_id" + paramContext.getPackageName(), 1).getString("go_static_id", null);
        localObject2 = localObject1;
        if (localObject1 != null) {}
      }
      catch (Exception localException1)
      {
        Object localObject1;
        Object localObject4;
        continue;
      }
      try
      {
        localObject4 = paramContext.getPackageManager().queryIntentActivities(new Intent("com.jiubang.gau.ACTION_GOSTATICSDK"), 0);
        localObject2 = localObject1;
        if (localObject4 != null)
        {
          localObject2 = localObject1;
          if (!((List)localObject4).isEmpty())
          {
            localObject4 = ((List)localObject4).iterator();
            localObject2 = localObject1;
            if (!((Iterator)localObject4).hasNext()) {
              break label289;
            }
            localObject2 = localObject1;
            String str = ((ResolveInfo)((Iterator)localObject4).next()).activityInfo.packageName;
            if (str == null) {
              continue;
            }
            localObject2 = localObject1;
            if (str.equals(paramContext.getPackageName())) {
              continue;
            }
            localObject2 = localObject1;
            Context localContext = paramContext.createPackageContext(str, 2);
            if (localContext == null) {
              continue;
            }
            localObject2 = localObject1;
            localObject1 = localContext.getSharedPreferences("go_static_id" + str, 1).getString("go_static_id", null);
            localObject2 = localObject1;
            localObject1 = localObject2;
            if (localObject2 == null) {
              continue;
            }
          }
        }
      }
      catch (Exception localException2)
      {
        Object localObject3 = localException1;
        continue;
        localObject3 = localException1;
        continue;
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = System.currentTimeMillis() + c.g(paramContext);
      }
      paramContext.getSharedPreferences("go_static_id" + paramContext.getPackageName(), 1).edit().putString("go_static_id", (String)localObject1).commit();
      localObject2 = localObject1;
      return (String)localObject2;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/gostaticsdk/f/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */