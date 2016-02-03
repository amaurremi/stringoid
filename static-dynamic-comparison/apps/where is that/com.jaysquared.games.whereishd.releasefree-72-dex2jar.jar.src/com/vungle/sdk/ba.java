package com.vungle.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Base64;
import java.io.File;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.TimeZone;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"NewApi"})
public final class ba
{
  public static String a()
  {
    String str = e.B;
    if (Build.VERSION.SDK_INT >= 9) {}
    try
    {
      str = Build.SERIAL;
      return str;
    }
    catch (NoSuchFieldError localNoSuchFieldError) {}
    return e.B;
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
      return paramContext;
    }
    catch (SecurityException paramContext) {}
    return null;
  }
  
  /* Error */
  private static String a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 58	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   9: astore_2
    //   10: aload_0
    //   11: aload_1
    //   12: invokevirtual 66	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   15: astore_0
    //   16: new 68	java/io/InputStreamReader
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 71	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   24: astore_1
    //   25: new 73	java/io/BufferedReader
    //   28: dup
    //   29: aload_1
    //   30: invokespecial 76	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   33: astore 4
    //   35: aload 4
    //   37: invokevirtual 79	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   40: astore_3
    //   41: aload_3
    //   42: ifnull +64 -> 106
    //   45: aload_2
    //   46: aload_3
    //   47: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: goto -16 -> 35
    //   54: astore 5
    //   56: aload_0
    //   57: astore_2
    //   58: aload_1
    //   59: astore_3
    //   60: aload 4
    //   62: astore_1
    //   63: aload 5
    //   65: astore_0
    //   66: aload_1
    //   67: ifnull +7 -> 74
    //   70: aload_1
    //   71: invokevirtual 86	java/io/BufferedReader:close	()V
    //   74: aload_3
    //   75: ifnull +7 -> 82
    //   78: aload_3
    //   79: invokevirtual 87	java/io/InputStreamReader:close	()V
    //   82: aload_2
    //   83: ifnull +7 -> 90
    //   86: aload_2
    //   87: invokevirtual 90	java/io/FileInputStream:close	()V
    //   90: aload_0
    //   91: athrow
    //   92: astore_0
    //   93: getstatic 93	com/vungle/sdk/e:u	Ljava/lang/String;
    //   96: ldc 95
    //   98: aload_0
    //   99: invokestatic 100	com/vungle/sdk/av:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   102: getstatic 17	com/vungle/sdk/e:B	Ljava/lang/String;
    //   105: areturn
    //   106: aload 4
    //   108: invokevirtual 86	java/io/BufferedReader:close	()V
    //   111: aload_1
    //   112: invokevirtual 87	java/io/InputStreamReader:close	()V
    //   115: aload_0
    //   116: ifnull +7 -> 123
    //   119: aload_0
    //   120: invokevirtual 90	java/io/FileInputStream:close	()V
    //   123: aload_2
    //   124: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: astore_0
    //   128: aload_0
    //   129: areturn
    //   130: astore_0
    //   131: getstatic 93	com/vungle/sdk/e:u	Ljava/lang/String;
    //   134: ldc 105
    //   136: aload_0
    //   137: invokestatic 100	com/vungle/sdk/av:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   140: goto -38 -> 102
    //   143: astore_0
    //   144: aconst_null
    //   145: astore_1
    //   146: aconst_null
    //   147: astore_2
    //   148: goto -82 -> 66
    //   151: astore 4
    //   153: aconst_null
    //   154: astore_1
    //   155: aload_0
    //   156: astore_2
    //   157: aload 4
    //   159: astore_0
    //   160: goto -94 -> 66
    //   163: astore 5
    //   165: aconst_null
    //   166: astore 4
    //   168: aload_1
    //   169: astore_3
    //   170: aload_0
    //   171: astore_2
    //   172: aload 5
    //   174: astore_0
    //   175: aload 4
    //   177: astore_1
    //   178: goto -112 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	paramContext	Context
    //   0	181	1	paramString	String
    //   9	163	2	localObject1	Object
    //   1	169	3	str	String
    //   33	74	4	localBufferedReader	java.io.BufferedReader
    //   151	7	4	localObject2	Object
    //   166	10	4	localObject3	Object
    //   54	10	5	localObject4	Object
    //   163	10	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   35	41	54	finally
    //   45	51	54	finally
    //   2	10	92	java/io/FileNotFoundException
    //   70	74	92	java/io/FileNotFoundException
    //   78	82	92	java/io/FileNotFoundException
    //   86	90	92	java/io/FileNotFoundException
    //   90	92	92	java/io/FileNotFoundException
    //   106	115	92	java/io/FileNotFoundException
    //   119	123	92	java/io/FileNotFoundException
    //   123	128	92	java/io/FileNotFoundException
    //   2	10	130	java/io/IOException
    //   70	74	130	java/io/IOException
    //   78	82	130	java/io/IOException
    //   86	90	130	java/io/IOException
    //   90	92	130	java/io/IOException
    //   106	115	130	java/io/IOException
    //   119	123	130	java/io/IOException
    //   123	128	130	java/io/IOException
    //   10	16	143	finally
    //   16	25	151	finally
    //   25	35	163	finally
  }
  
  private static String a(String paramString1, String paramString2)
  {
    try
    {
      Mac localMac = Mac.getInstance("HmacSHA256");
      localMac.init(new SecretKeySpec(paramString2.getBytes(), localMac.getAlgorithm()));
      paramString2 = Base64.encodeToString(localMac.doFinal(paramString1.getBytes()), 8);
      return paramString2;
    }
    catch (NoSuchAlgorithmException paramString2)
    {
      paramString2.printStackTrace();
      return paramString1;
    }
    catch (InvalidKeyException paramString2)
    {
      paramString2.printStackTrace();
    }
    return paramString1;
  }
  
  /* Error */
  static byte[] a(String paramString)
  {
    // Byte code:
    //   0: sipush 1024
    //   3: newarray <illegal type>
    //   5: astore_2
    //   6: new 89	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 154	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: astore_3
    //   15: ldc -100
    //   17: invokestatic 161	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   20: astore_0
    //   21: aload_3
    //   22: aload_2
    //   23: invokevirtual 167	java/io/InputStream:read	([B)I
    //   26: istore_1
    //   27: iload_1
    //   28: ifle +10 -> 38
    //   31: aload_0
    //   32: aload_2
    //   33: iconst_0
    //   34: iload_1
    //   35: invokevirtual 171	java/security/MessageDigest:update	([BII)V
    //   38: iload_1
    //   39: iconst_m1
    //   40: if_icmpne -19 -> 21
    //   43: aload_0
    //   44: invokevirtual 174	java/security/MessageDigest:digest	()[B
    //   47: astore_0
    //   48: aload_3
    //   49: invokevirtual 175	java/io/InputStream:close	()V
    //   52: aload_0
    //   53: areturn
    //   54: astore_0
    //   55: aconst_null
    //   56: astore_3
    //   57: aload_3
    //   58: ifnull +7 -> 65
    //   61: aload_3
    //   62: invokevirtual 175	java/io/InputStream:close	()V
    //   65: aload_0
    //   66: athrow
    //   67: astore_0
    //   68: aload_0
    //   69: astore_3
    //   70: aload_2
    //   71: astore_0
    //   72: getstatic 93	com/vungle/sdk/e:u	Ljava/lang/String;
    //   75: ldc 95
    //   77: aload_3
    //   78: invokestatic 100	com/vungle/sdk/av:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   81: aload_0
    //   82: areturn
    //   83: astore_3
    //   84: aload_0
    //   85: astore_2
    //   86: getstatic 93	com/vungle/sdk/e:u	Ljava/lang/String;
    //   89: ldc -79
    //   91: aload_3
    //   92: invokestatic 100	com/vungle/sdk/av:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   95: aload_2
    //   96: areturn
    //   97: astore_3
    //   98: aload_0
    //   99: astore_2
    //   100: getstatic 93	com/vungle/sdk/e:u	Ljava/lang/String;
    //   103: ldc 105
    //   105: aload_3
    //   106: invokestatic 100	com/vungle/sdk/av:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   109: aload_2
    //   110: areturn
    //   111: astore_0
    //   112: aload_0
    //   113: astore_3
    //   114: goto -14 -> 100
    //   117: astore_0
    //   118: aload_0
    //   119: astore_3
    //   120: goto -34 -> 86
    //   123: astore_3
    //   124: goto -52 -> 72
    //   127: astore_0
    //   128: goto -71 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramString	String
    //   26	15	1	i	int
    //   5	105	2	localObject1	Object
    //   14	64	3	localObject2	Object
    //   83	9	3	localNoSuchAlgorithmException	NoSuchAlgorithmException
    //   97	9	3	localIOException	java.io.IOException
    //   113	7	3	str	String
    //   123	1	3	localFileNotFoundException	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   6	15	54	finally
    //   61	65	67	java/io/FileNotFoundException
    //   65	67	67	java/io/FileNotFoundException
    //   48	52	83	java/security/NoSuchAlgorithmException
    //   48	52	97	java/io/IOException
    //   61	65	111	java/io/IOException
    //   65	67	111	java/io/IOException
    //   61	65	117	java/security/NoSuchAlgorithmException
    //   65	67	117	java/security/NoSuchAlgorithmException
    //   48	52	123	java/io/FileNotFoundException
    //   15	21	127	finally
    //   21	27	127	finally
    //   31	38	127	finally
    //   43	48	127	finally
  }
  
  public static String b()
  {
    String str = e.t;
    Locale.getDefault().getISO3Language();
    return Locale.getDefault().getISO3Language();
  }
  
  public static String b(Context paramContext)
  {
    return Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
  }
  
  public static boolean b(String paramString)
  {
    return (paramString == null) || (e.B.equals(paramString));
  }
  
  public static String c()
  {
    String str = e.t;
    TimeZone.getDefault().getID();
    return TimeZone.getDefault().getID();
  }
  
  public static String c(Context paramContext)
  {
    paramContext = b(paramContext);
    if ((paramContext != null) && (paramContext.length() != 0)) {
      return paramContext;
    }
    return a();
  }
  
  public static String c(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      String str = ((JSONObject)localObject).getString("campaign");
      localObject = ((JSONObject)localObject).getString("pubAppId");
      long l = System.currentTimeMillis();
      paramString = String.format("pubAppId=%s,SignedHeaders=host;x-vung-date;x-vung-target,Signature=%s", new Object[] { localObject, a(paramString, str + (String)localObject + l) });
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static String d()
  {
    for (;;)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder().append("");
        if (Build.MANUFACTURER != null)
        {
          String str1 = Build.MANUFACTURER;
          str1 = str1;
          str1 = str1 + ",";
          localStringBuilder = new StringBuilder().append(str1);
          if (Build.MODEL != null)
          {
            str1 = Build.MODEL;
            return str1;
          }
          str1 = "";
          continue;
        }
        String str2 = "";
      }
      catch (Throwable localThrowable)
      {
        return "<Unknown>";
      }
    }
  }
  
  public static String d(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkOperatorName();
      if (paramContext != null)
      {
        int i = paramContext.length();
        if (i != 0) {}
      }
      else
      {
        paramContext = null;
      }
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      ay.a(paramContext);
    }
    return null;
  }
  
  private static void e()
  {
    float f = ak.x;
    ak.x = ak.y;
    ak.y = f;
  }
  
  public static boolean e(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (paramContext != null) {
      return paramContext.isConnected();
    }
    return false;
  }
  
  public static String f(Context paramContext)
  {
    if (!e(paramContext)) {
      return "Network";
    }
    if (!aj.a()) {
      return "External Storage";
    }
    return null;
  }
  
  public static void g(Context paramContext)
  {
    int i = 0;
    Object localObject1 = e.t;
    localObject1 = new ArrayList(0);
    Object localObject3;
    if (new File(paramContext.getFilesDir().getAbsolutePath() + File.separator + "MetricDataQueue").exists())
    {
      localObject3 = a(paramContext, "MetricDataQueue");
      if (!b((String)localObject3)) {
        break label86;
      }
      ay.a((ArrayList)localObject1);
      paramContext = e.t;
    }
    for (;;)
    {
      return;
      try
      {
        label86:
        localObject3 = new JSONArray((String)localObject3);
        int j = ((JSONArray)localObject3).length();
        String str2 = e.t;
        new StringBuilder().append(j).append(" Pending metric data requests found");
        while (i < j)
        {
          ((ArrayList)localObject1).add(((JSONArray)localObject3).get(i).toString());
          i += 1;
        }
        ay.a((ArrayList)localObject1);
        return;
      }
      catch (JSONException localJSONException)
      {
        av.a(e.u, "JSONException", localJSONException);
        String str1;
        return;
      }
      finally
      {
        paramContext = new File(paramContext.getFilesDir().getAbsoluteFile() + File.separator + "MetricDataQueue");
        if (paramContext.exists())
        {
          localObject3 = e.t;
          new StringBuilder("Deleting : ").append(paramContext.getAbsolutePath());
          paramContext.delete();
        }
      }
    }
  }
  
  public static void h(Context paramContext)
  {
    int i = paramContext.getResources().getConfiguration().orientation;
    if ((i == 2) || (i == 3)) {
      if (ak.y > ak.x) {
        e();
      }
    }
    while (((i != 1) && (i != 0)) || (ak.x <= ak.y)) {
      return;
    }
    e();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/vungle/sdk/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */