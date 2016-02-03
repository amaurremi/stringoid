package com.chartboost.sdk.Libraries;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings.Secure;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.impl.aq;
import com.chartboost.sdk.impl.ar;
import com.chartboost.sdk.impl.i;
import java.util.UUID;

public final class c
{
  private static String a = null;
  private static String b = null;
  private static a c = a.a;
  private static String d = null;
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: ldc 34
    //   2: monitorenter
    //   3: invokestatic 37	com/chartboost/sdk/Libraries/c:c	()Lcom/chartboost/sdk/Libraries/c$a;
    //   6: getstatic 22	com/chartboost/sdk/Libraries/c$a:a	Lcom/chartboost/sdk/Libraries/c$a;
    //   9: if_acmpeq +7 -> 16
    //   12: ldc 34
    //   14: monitorexit
    //   15: return
    //   16: getstatic 39	com/chartboost/sdk/Libraries/c$a:b	Lcom/chartboost/sdk/Libraries/c$a;
    //   19: invokestatic 42	com/chartboost/sdk/Libraries/c:a	(Lcom/chartboost/sdk/Libraries/c$a;)V
    //   22: ldc 34
    //   24: monitorexit
    //   25: aconst_null
    //   26: astore_0
    //   27: ldc 44
    //   29: invokestatic 50	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   32: astore_1
    //   33: aload_1
    //   34: astore_0
    //   35: aload_0
    //   36: ifnonnull +13 -> 49
    //   39: invokestatic 53	com/chartboost/sdk/Libraries/c:f	()V
    //   42: return
    //   43: astore_0
    //   44: ldc 34
    //   46: monitorexit
    //   47: aload_0
    //   48: athrow
    //   49: invokestatic 58	com/chartboost/sdk/impl/k:a	()Ljava/util/concurrent/ExecutorService;
    //   52: new 6	com/chartboost/sdk/Libraries/c$1
    //   55: dup
    //   56: invokespecial 59	com/chartboost/sdk/Libraries/c$1:<init>	()V
    //   59: invokeinterface 65 2 0
    //   64: return
    //   65: astore_1
    //   66: goto -31 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   26	10	0	localObject1	Object
    //   43	5	0	localObject2	Object
    //   32	2	1	localClass	Class
    //   65	1	1	localClassNotFoundException	ClassNotFoundException
    // Exception table:
    //   from	to	target	type
    //   3	15	43	finally
    //   16	25	43	finally
    //   44	47	43	finally
    //   27	33	65	java/lang/ClassNotFoundException
  }
  
  protected static void a(a parama)
  {
    try
    {
      c = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public static String b()
  {
    if (a == null) {
      a = b.b(g());
    }
    return a;
  }
  
  private static void b(String paramString)
  {
    try
    {
      b = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static a c()
  {
    try
    {
      a locala = c;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static String d()
  {
    try
    {
      String str = b;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static void f()
  {
    CBLogging.b("CBIdentity", "WARNING: It looks like you've forgotten to include the Google Play Services library in your project. Please review the SDK documentation for more details.");
    a(a.c);
    i.a();
  }
  
  private static byte[] g()
  {
    String str2 = h();
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (!"9774d56d682e549c".equals(str2)) {}
    }
    else
    {
      str1 = i();
    }
    str2 = j();
    String str3 = d();
    ar localar = new ar();
    localar.a("uuid", str1);
    localar.a("macid", str2);
    localar.a("ifa", str3);
    return new aq().a(localar);
  }
  
  private static String h()
  {
    return Settings.Secure.getString(Chartboost.sharedChartboost().getContext().getContentResolver(), "android_id");
  }
  
  private static String i()
  {
    if (d == null)
    {
      Object localObject = CBUtility.a();
      d = ((SharedPreferences)localObject).getString("cbUUID", null);
      if (d == null)
      {
        d = UUID.randomUUID().toString();
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString("cbUUID", d);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
    return d;
  }
  
  private static String j()
  {
    return b.b(b.a(k()));
  }
  
  private static byte[] k()
  {
    try
    {
      Object localObject = ((WifiManager)Chartboost.sharedChartboost().getContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
      if ((localObject != null) && (!((String)localObject).equals("")))
      {
        String[] arrayOfString = ((String)localObject).split(":");
        byte[] arrayOfByte2 = new byte[6];
        int i = 0;
        for (;;)
        {
          localObject = arrayOfByte2;
          if (i >= arrayOfString.length) {
            break;
          }
          arrayOfByte2[i] = Integer.valueOf(Integer.parseInt(arrayOfString[i], 16)).byteValue();
          i += 1;
        }
      }
      arrayOfByte1 = null;
    }
    catch (Exception localException)
    {
      return null;
    }
    byte[] arrayOfByte1;
    return arrayOfByte1;
  }
  
  public static enum a
  {
    private int f;
    
    private a(int paramInt)
    {
      this.f = paramInt;
    }
    
    public int a()
    {
      return this.f;
    }
    
    public boolean b()
    {
      return this.f != -1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/Libraries/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */