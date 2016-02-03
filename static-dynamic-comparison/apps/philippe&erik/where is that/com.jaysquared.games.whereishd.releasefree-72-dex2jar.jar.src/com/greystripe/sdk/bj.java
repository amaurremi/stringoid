package com.greystripe.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

final class bj
{
  private static String a = "com.greystripe.settings.providers";
  private static String b = a + ".SettingsContentProvider";
  private static Map c = new HashMap();
  private static SharedPreferences d;
  private static final Set e;
  private static final Set f;
  private static boolean g = false;
  private static bl h = null;
  
  static
  {
    e = new HashSet();
    f = new HashSet();
    e.add(bk.GUID);
    f.add(bk.GUID);
    f.add(bk.AD_SERVER_URL);
  }
  
  static bl a()
  {
    if (h == null) {
      h = new bl((byte)0);
    }
    return h;
  }
  
  static String a(bk parambk)
  {
    return c(parambk.name());
  }
  
  static void a(Context paramContext)
  {
    if (!g)
    {
      d = paramContext.getSharedPreferences("gs_preferences_" + GSSdkInfo.getVersion(), 0);
      c(paramContext);
      g = true;
    }
  }
  
  static void a(String paramString)
  {
    a(bk.GUID.name(), paramString);
  }
  
  static void a(String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (f(paramString1))) {
      c.put(paramString1, paramString2);
    }
  }
  
  static String b()
  {
    return c(bk.GUID.name());
  }
  
  static void b(String paramString)
  {
    a(bk.AD_SERVER_URL.name(), paramString);
  }
  
  private static boolean b(Context paramContext)
  {
    boolean bool2 = false;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(a, 8).providers;
      boolean bool1 = bool2;
      int j;
      int i;
      if (paramContext != null)
      {
        j = paramContext.length;
        i = 0;
      }
      for (;;)
      {
        bool1 = bool2;
        if (i < j)
        {
          bool1 = paramContext[i].authority.equals(b);
          if (bool1) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        i += 1;
      }
      return false;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
  }
  
  static boolean b(bk parambk)
  {
    return d(parambk.name());
  }
  
  static String c()
  {
    return c(bk.AD_SERVER_URL.name());
  }
  
  static String c(String paramString)
  {
    if (c.containsKey(paramString)) {
      return (String)c.get(paramString);
    }
    return d.getString(paramString, null);
  }
  
  /* Error */
  private static void c(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 166	com/greystripe/sdk/bj:b	(Landroid/content/Context;)Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: new 26	java/lang/StringBuilder
    //   11: dup
    //   12: ldc -88
    //   14: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   17: getstatic 41	com/greystripe/sdk/bj:b	Ljava/lang/String;
    //   20: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc -86
    //   25: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 176	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   34: astore 4
    //   36: aload_0
    //   37: invokevirtual 180	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   40: aload 4
    //   42: iconst_3
    //   43: anewarray 145	java/lang/String
    //   46: dup
    //   47: iconst_0
    //   48: ldc -74
    //   50: aastore
    //   51: dup
    //   52: iconst_1
    //   53: ldc -72
    //   55: aastore
    //   56: dup
    //   57: iconst_2
    //   58: ldc -70
    //   60: aastore
    //   61: aconst_null
    //   62: aconst_null
    //   63: aconst_null
    //   64: invokevirtual 192	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   67: astore_0
    //   68: aload_0
    //   69: ifnonnull +14 -> 83
    //   72: aload_0
    //   73: ifnull -66 -> 7
    //   76: aload_0
    //   77: invokeinterface 197 1 0
    //   82: return
    //   83: aload_0
    //   84: invokeinterface 201 1 0
    //   89: ifeq +65 -> 154
    //   92: aload_0
    //   93: ldc -72
    //   95: invokeinterface 205 2 0
    //   100: istore_1
    //   101: aload_0
    //   102: ldc -70
    //   104: invokeinterface 205 2 0
    //   109: istore_2
    //   110: aload_0
    //   111: iload_1
    //   112: invokeinterface 208 2 0
    //   117: astore 4
    //   119: aload_0
    //   120: iload_2
    //   121: invokeinterface 208 2 0
    //   126: astore 5
    //   128: aload 4
    //   130: invokestatic 210	com/greystripe/sdk/bj:g	(Ljava/lang/String;)Z
    //   133: ifeq +10 -> 143
    //   136: aload 4
    //   138: aload 5
    //   140: invokestatic 110	com/greystripe/sdk/bj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: aload_0
    //   144: invokeinterface 213 1 0
    //   149: istore_3
    //   150: iload_3
    //   151: ifne -41 -> 110
    //   154: aload_0
    //   155: ifnull -148 -> 7
    //   158: aload_0
    //   159: invokeinterface 197 1 0
    //   164: return
    //   165: astore 4
    //   167: aconst_null
    //   168: astore_0
    //   169: aload_0
    //   170: ifnull +9 -> 179
    //   173: aload_0
    //   174: invokeinterface 197 1 0
    //   179: aload 4
    //   181: athrow
    //   182: astore 4
    //   184: goto -15 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	paramContext	Context
    //   100	12	1	i	int
    //   109	12	2	j	int
    //   149	2	3	bool	boolean
    //   34	103	4	localObject1	Object
    //   165	15	4	localObject2	Object
    //   182	1	4	localObject3	Object
    //   126	13	5	str	String
    // Exception table:
    //   from	to	target	type
    //   8	68	165	finally
    //   83	110	182	finally
    //   110	143	182	finally
    //   143	150	182	finally
  }
  
  static long d()
  {
    return e(bk.AD_READY_TIME.name());
  }
  
  static boolean d(String paramString)
  {
    return (c.containsKey(paramString)) || (d.contains(paramString));
  }
  
  static long e()
  {
    return e(bk.AD_LOAD_TIME.name());
  }
  
  private static long e(String paramString)
  {
    paramString = c(paramString);
    if (paramString == null) {
      return 30000L;
    }
    return Long.parseLong(paramString);
  }
  
  static void f()
  {
    a(bk.STOP_REQUESTING_ADS_ALWAYS_AND_FOREVER.name(), "true");
    String str = bk.STOP_REQUESTING_ADS_ALWAYS_AND_FOREVER.name();
    if (c.containsKey(str))
    {
      d.edit().putString(str, (String)c.get(str)).commit();
      c.remove(str);
    }
  }
  
  private static boolean f(String paramString)
  {
    try
    {
      paramString = bk.valueOf(paramString);
      if (e.contains(paramString))
      {
        boolean bool = d(paramString.name());
        if (bool) {
          return false;
        }
      }
    }
    catch (IllegalArgumentException paramString) {}
    return true;
  }
  
  static boolean g()
  {
    return d(bk.STOP_REQUESTING_ADS_ALWAYS_AND_FOREVER.name());
  }
  
  private static boolean g(String paramString)
  {
    try
    {
      bk localbk = bk.valueOf(paramString);
      boolean bool = f.contains(localbk);
      if (bool) {
        return false;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
    return f(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/greystripe/sdk/bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */