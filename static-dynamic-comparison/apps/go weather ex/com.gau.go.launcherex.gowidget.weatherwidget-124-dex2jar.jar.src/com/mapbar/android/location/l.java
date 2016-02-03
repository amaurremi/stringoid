package com.mapbar.android.location;

import android.os.SystemClock;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.zip.DeflaterOutputStream;

public final class l
{
  public static String a = "000000000000001";
  public static String b = "";
  public static int c;
  public static int d;
  public static int e;
  public static String f = "";
  public static long g;
  public static int h;
  public static int i;
  public static int j;
  public static String k = "";
  public static String l = "";
  public static int m;
  public static boolean n = true;
  public static int o;
  public static int p;
  public static int q;
  public static int r;
  public static int s;
  public static int t;
  public static int u;
  public static String v;
  public static String w = "";
  private static MessageDigest x;
  
  static
  {
    try
    {
      x = MessageDigest.getInstance("MD5");
      return;
    }
    catch (Exception localException) {}
  }
  
  static String a()
  {
    long l1 = 0L;
    int i2 = 1;
    Object localObject2 = new StringBuilder();
    long l2 = (SystemClock.elapsedRealtime() - g) / 1000L;
    if ("wd".equals(f))
    {
      if (l2 <= 5L) {
        break label563;
      }
      c = 0;
      d = 0;
      e = 0;
      h = 0;
      i = 0;
      j = 0;
    }
    for (;;)
    {
      ((StringBuilder)localObject2).append(c).append(",").append(d).append(",").append(e).append(",").append(l1).append(",").append(h).append(",").append(i).append(",").append(j).append(";");
      int i1;
      if (n)
      {
        ((StringBuilder)localObject2).append(k).append(",").append(l).append(",").append(t).append(",").append(u).append(",").append(m).append("|").append(v).append(";");
        if ((!b.b.a(k)) || (t < 0) || (u < 0)) {
          break label558;
        }
        i1 = 1;
      }
      for (;;)
      {
        label246:
        if (b.b.a(w))
        {
          ((StringBuilder)localObject2).append(w).append(";");
          i1 = i2;
        }
        for (;;)
        {
          String str;
          Object localObject1;
          if (i1 != 0)
          {
            i.a("MapTags", "maptag = " + ((StringBuilder)localObject2).toString());
            str = a(((StringBuilder)localObject2).toString());
            localObject1 = "";
          }
          try
          {
            localObject2 = a.a(b(((StringBuilder)localObject2).toString()), "iso-8859-1");
            localObject1 = localObject2;
            localObject2 = ((String)localObject2).replaceAll("\n", "").replaceAll("\r", "");
            localObject1 = localObject2;
          }
          catch (Exception localException)
          {
            for (;;) {}
          }
          return "[Android][" + str + "]" + (String)localObject1;
          if (l2 <= 60L) {
            break label563;
          }
          c = 0;
          d = 0;
          e = 0;
          h = 0;
          i = 0;
          j = 0;
          break;
          ((StringBuilder)localObject2).append(k).append(",").append(l).append(",").append(o).append(",").append(p).append(",").append(q).append(",").append(r).append(",").append(s).append(",").append(m).append(";");
          if ((!b.b.a(k)) || (o < 0) || (p < 0)) {
            break label558;
          }
          i1 = 1;
          break label246;
          return new String();
        }
        label558:
        i1 = 0;
      }
      label563:
      l1 = l2;
    }
  }
  
  /* Error */
  public static String a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: lconst_0
    //   7: lstore_1
    //   8: ldc 2
    //   10: monitorenter
    //   11: aload 6
    //   13: astore 5
    //   15: aload_0
    //   16: ldc -69
    //   18: iconst_0
    //   19: invokevirtual 193	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   22: astore 8
    //   24: aload 6
    //   26: astore 5
    //   28: aload 8
    //   30: ldc -61
    //   32: lconst_0
    //   33: invokeinterface 201 4 0
    //   38: lstore_3
    //   39: aload 7
    //   41: astore_0
    //   42: aload 6
    //   44: astore 5
    //   46: lload_3
    //   47: aload 8
    //   49: ldc -53
    //   51: lconst_0
    //   52: invokeinterface 201 4 0
    //   57: lcmp
    //   58: ifge +87 -> 145
    //   61: aload 6
    //   63: astore 5
    //   65: aload 8
    //   67: invokeinterface 207 1 0
    //   72: astore 7
    //   74: aload 6
    //   76: astore 5
    //   78: aload 8
    //   80: new 72	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   87: ldc -47
    //   89: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: lload_3
    //   93: ldc2_w 210
    //   96: lrem
    //   97: invokevirtual 117	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   100: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: aconst_null
    //   104: invokeinterface 214 3 0
    //   109: astore_0
    //   110: lconst_1
    //   111: lload_3
    //   112: ladd
    //   113: lstore_3
    //   114: lload_3
    //   115: lconst_0
    //   116: lcmp
    //   117: ifge +46 -> 163
    //   120: aload_0
    //   121: astore 5
    //   123: aload 7
    //   125: ldc -61
    //   127: lload_1
    //   128: invokeinterface 220 4 0
    //   133: pop
    //   134: aload_0
    //   135: astore 5
    //   137: aload 7
    //   139: invokeinterface 224 1 0
    //   144: pop
    //   145: ldc 2
    //   147: monitorexit
    //   148: aload_0
    //   149: areturn
    //   150: astore_0
    //   151: ldc 2
    //   153: monitorexit
    //   154: aload_0
    //   155: athrow
    //   156: astore_0
    //   157: aload 5
    //   159: astore_0
    //   160: goto -15 -> 145
    //   163: lload_3
    //   164: lstore_1
    //   165: goto -45 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	paramContext	android.content.Context
    //   7	158	1	l1	long
    //   38	126	3	l2	long
    //   13	145	5	localObject1	Object
    //   1	74	6	localObject2	Object
    //   4	134	7	localEditor	android.content.SharedPreferences.Editor
    //   22	57	8	localSharedPreferences	android.content.SharedPreferences
    // Exception table:
    //   from	to	target	type
    //   15	24	150	finally
    //   28	39	150	finally
    //   46	61	150	finally
    //   65	74	150	finally
    //   78	110	150	finally
    //   123	134	150	finally
    //   137	145	150	finally
    //   15	24	156	java/lang/Exception
    //   28	39	156	java/lang/Exception
    //   46	61	156	java/lang/Exception
    //   65	74	156	java/lang/Exception
    //   78	110	156	java/lang/Exception
    //   123	134	156	java/lang/Exception
    //   137	145	156	java/lang/Exception
  }
  
  private static String a(String paramString)
  {
    for (;;)
    {
      String str2;
      String str1;
      try
      {
        str2 = new String();
        str1 = str2;
      }
      finally {}
      try
      {
        if (x != null)
        {
          paramString = x.digest(("MAPBAR" + paramString + "ANDROID").getBytes());
          str1 = str2;
          if (paramString != null) {
            str1 = a.a(paramString, "iso-8859-1");
          }
        }
      }
      catch (Exception paramString)
      {
        str1 = str2;
      }
    }
    return str1;
  }
  
  /* Error */
  public static void a(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: invokestatic 134	com/mapbar/android/location/b$b:a	(Ljava/lang/String;)Z
    //   7: istore_2
    //   8: iload_2
    //   9: ifne +7 -> 16
    //   12: ldc 2
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: ldc -69
    //   19: iconst_0
    //   20: invokevirtual 193	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   23: astore_0
    //   24: aload_0
    //   25: ldc -53
    //   27: lconst_0
    //   28: invokeinterface 201 4 0
    //   33: lstore_3
    //   34: aload_0
    //   35: invokeinterface 207 1 0
    //   40: astore_0
    //   41: aload_0
    //   42: new 72	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   49: ldc -47
    //   51: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: lload_3
    //   55: ldc2_w 210
    //   58: lrem
    //   59: invokevirtual 117	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   62: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: aload_1
    //   66: invokeinterface 241 3 0
    //   71: pop
    //   72: lload_3
    //   73: lconst_1
    //   74: ladd
    //   75: lstore_3
    //   76: lload_3
    //   77: lconst_0
    //   78: lcmp
    //   79: ifge +33 -> 112
    //   82: aload_0
    //   83: ldc -53
    //   85: lconst_0
    //   86: invokeinterface 220 4 0
    //   91: pop
    //   92: aload_0
    //   93: ldc -61
    //   95: lconst_0
    //   96: invokeinterface 220 4 0
    //   101: pop
    //   102: aload_0
    //   103: invokeinterface 224 1 0
    //   108: pop
    //   109: goto -97 -> 12
    //   112: aload_0
    //   113: ldc -53
    //   115: lload_3
    //   116: invokeinterface 220 4 0
    //   121: pop
    //   122: goto -20 -> 102
    //   125: astore_0
    //   126: ldc 2
    //   128: monitorexit
    //   129: aload_0
    //   130: athrow
    //   131: astore_0
    //   132: goto -120 -> 12
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	paramContext	android.content.Context
    //   0	135	1	paramString	String
    //   7	2	2	bool	boolean
    //   33	83	3	l1	long
    // Exception table:
    //   from	to	target	type
    //   3	8	125	finally
    //   16	72	125	finally
    //   82	102	125	finally
    //   102	109	125	finally
    //   112	122	125	finally
    //   3	8	131	java/lang/Exception
    //   16	72	131	java/lang/Exception
    //   82	102	131	java/lang/Exception
    //   102	109	131	java/lang/Exception
    //   112	122	131	java/lang/Exception
  }
  
  private static byte[] b(String paramString)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      DeflaterOutputStream localDeflaterOutputStream = new DeflaterOutputStream(localByteArrayOutputStream);
      localDeflaterOutputStream.write(paramString.getBytes());
      localDeflaterOutputStream.close();
      try
      {
        localByteArrayOutputStream.close();
        paramString = localByteArrayOutputStream.toByteArray();
        return paramString;
      }
      catch (IOException paramString)
      {
        for (;;) {}
      }
      return null;
    }
    catch (Exception paramString) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/mapbar/android/location/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */