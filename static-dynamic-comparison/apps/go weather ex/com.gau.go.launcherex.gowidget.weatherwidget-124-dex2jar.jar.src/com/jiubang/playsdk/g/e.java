package com.jiubang.playsdk.g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.jiubang.playsdk.h;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

public class e
{
  public static boolean a(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      int i;
      if (paramContext.getSimState() != 5)
      {
        i = 1;
        paramContext = paramContext.getSimOperator();
        if ((i == 0) && (!TextUtils.isEmpty(paramContext))) {
          break label69;
        }
        paramContext = Locale.getDefault().getCountry();
        if ((paramContext == null) || (!paramContext.contains("CN"))) {
          break label67;
        }
      }
      label67:
      label69:
      while (paramContext.startsWith("460"))
      {
        return true;
        i = 0;
        break;
        return false;
      }
    }
    return false;
  }
  
  public static String b(Context paramContext)
  {
    k localk = new k(paramContext, "request_info");
    Object localObject = localk.a("device_id", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      try
      {
        paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
        ((Exception)localObject).printStackTrace();
      }
      catch (Exception localException2)
      {
        try
        {
          localk.b("device_id", paramContext);
          localk.a();
          return paramContext;
        }
        catch (Exception localException1)
        {
          for (;;) {}
        }
        localException2 = localException2;
        paramContext = (Context)localObject;
        localObject = localException2;
      }
      return paramContext;
    }
    return localException1;
  }
  
  public static String c(Context paramContext)
  {
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSimOperator();
        return paramContext;
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        return "000";
      }
      paramContext = "000";
    }
  }
  
  /* Error */
  public static String d(Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 36	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   3: astore_3
    //   4: aload_0
    //   5: ldc 8
    //   7: invokevirtual 14	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   10: checkcast 16	android/telephony/TelephonyManager
    //   13: invokevirtual 94	android/telephony/TelephonyManager:getSimCountryIso	()Ljava/lang/String;
    //   16: astore_1
    //   17: aload_1
    //   18: astore_0
    //   19: aload_1
    //   20: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   23: ifne +30 -> 53
    //   26: ldc 96
    //   28: iconst_2
    //   29: anewarray 4	java/lang/Object
    //   32: dup
    //   33: iconst_0
    //   34: aload_3
    //   35: invokevirtual 99	java/util/Locale:getLanguage	()Ljava/lang/String;
    //   38: invokevirtual 102	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   41: aastore
    //   42: dup
    //   43: iconst_1
    //   44: aload_1
    //   45: invokevirtual 102	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   48: aastore
    //   49: invokestatic 106	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   52: astore_0
    //   53: aload_0
    //   54: astore_1
    //   55: aload_0
    //   56: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   59: ifeq +33 -> 92
    //   62: ldc 96
    //   64: iconst_2
    //   65: anewarray 4	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: aload_3
    //   71: invokevirtual 99	java/util/Locale:getLanguage	()Ljava/lang/String;
    //   74: invokevirtual 102	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   77: aastore
    //   78: dup
    //   79: iconst_1
    //   80: aload_3
    //   81: invokevirtual 39	java/util/Locale:getCountry	()Ljava/lang/String;
    //   84: invokevirtual 102	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   87: aastore
    //   88: invokestatic 106	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   91: astore_1
    //   92: aload_1
    //   93: astore_0
    //   94: aload_1
    //   95: ifnonnull +6 -> 101
    //   98: ldc 108
    //   100: astore_0
    //   101: aload_0
    //   102: areturn
    //   103: astore_1
    //   104: aconst_null
    //   105: astore_0
    //   106: aload_1
    //   107: invokevirtual 88	java/lang/Throwable:printStackTrace	()V
    //   110: goto -57 -> 53
    //   113: astore_2
    //   114: aload_1
    //   115: astore_0
    //   116: aload_2
    //   117: astore_1
    //   118: goto -12 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	paramContext	Context
    //   16	79	1	localObject1	Object
    //   103	12	1	localThrowable1	Throwable
    //   117	1	1	localObject2	Object
    //   113	4	2	localThrowable2	Throwable
    //   3	78	3	localLocale	Locale
    // Exception table:
    //   from	to	target	type
    //   4	17	103	java/lang/Throwable
    //   19	53	113	java/lang/Throwable
  }
  
  public static String e(Context paramContext)
  {
    Locale localLocale = Locale.getDefault();
    try
    {
      localObject = ((TelephonyManager)paramContext.getSystemService("phone")).getSimCountryIso();
      paramContext = (Context)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramContext = localLocale.getCountry().toLowerCase();
      }
      localObject = paramContext;
      if (paramContext == null) {
        localObject = "error";
      }
      return (String)localObject;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        Object localObject = null;
      }
    }
  }
  
  public static String f(Context paramContext)
  {
    String str = new k(paramContext, "request_info").a("channel_id", "");
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    InputStream localInputStream = paramContext.getResources().openRawResource(h.a);
    paramContext = new byte['Ѐ'];
    for (;;)
    {
      int j;
      byte[] arrayOfByte;
      int i;
      try
      {
        j = localInputStream.read(paramContext);
        if (j <= 0) {
          try
          {
            localInputStream.close();
            return "200";
          }
          catch (IOException paramContext)
          {
            paramContext.printStackTrace();
            continue;
          }
        }
        arrayOfByte = new byte[j];
        i = 0;
        break label173;
      }
      catch (IOException paramContext)
      {
        paramContext = paramContext;
        paramContext.printStackTrace();
        try
        {
          localInputStream.close();
          return "200";
        }
        catch (IOException paramContext)
        {
          paramContext.printStackTrace();
          continue;
        }
      }
      finally {}
      str = new String(arrayOfByte).trim();
      paramContext = str;
      if (arrayOfByte != null)
      {
        paramContext = str;
        if (str.contains("\n")) {
          paramContext = str.replaceAll("\n", "");
        }
      }
      try
      {
        localInputStream.close();
        return paramContext;
      }
      catch (IOException localIOException1)
      {
        localIOException1.printStackTrace();
        return paramContext;
      }
      try
      {
        localInputStream.close();
        throw paramContext;
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          localIOException2.printStackTrace();
        }
      }
      label173:
      while (i < j)
      {
        arrayOfByte[i] = paramContext[i];
        i += 1;
      }
    }
  }
  
  public static String g(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i = localDisplayMetrics.widthPixels;
    int j = localDisplayMetrics.heightPixels;
    return i + "*" + j;
  }
  
  public static String h(Context paramContext)
  {
    return Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
  }
  
  public static String i(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  public static boolean j(Context paramContext)
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
  
  public static String k(Context paramContext)
  {
    for (;;)
    {
      try
      {
        paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (paramContext == null) {
          return "";
        }
        if (paramContext.getType() == 1)
        {
          paramContext = "WIFI";
        }
        else
        {
          if (paramContext.getType() == 0) {}
          switch (paramContext.getSubtype())
          {
          case 1: 
            paramContext = "UNKNOW(typeid = " + paramContext.getType() + "  typename = " + paramContext.getTypeName() + "  subtypeid = " + paramContext.getSubtype() + "  subtypename = " + paramContext.getSubtypeName() + ")";
            break;
          case 2: 
          case 4: 
          case 7: 
          case 11: 
            paramContext = "2G(typeid = " + paramContext.getType() + "  typename = " + paramContext.getTypeName() + "  subtypeid = " + paramContext.getSubtype() + "  subtypename = " + paramContext.getSubtypeName() + ")";
            break;
          case 3: 
          case 5: 
          case 6: 
          case 8: 
          case 9: 
          case 10: 
            paramContext = "3G/4G(typeid = " + paramContext.getType() + "  typename = " + paramContext.getTypeName() + "  subtypeid = " + paramContext.getSubtype() + "  subtypename = " + paramContext.getSubtypeName() + ")";
            break;
            paramContext = "UNKNOW(typeid = " + paramContext.getType() + "  typename = " + paramContext.getTypeName() + ")";
          }
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        paramContext = "";
      }
      return paramContext;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/playsdk/g/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */