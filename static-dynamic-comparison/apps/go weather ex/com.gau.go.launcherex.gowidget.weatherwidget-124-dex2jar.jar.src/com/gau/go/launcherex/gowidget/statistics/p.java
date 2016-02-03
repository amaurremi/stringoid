package com.gau.go.launcherex.gowidget.statistics;

import android.content.Context;
import android.provider.Settings.Secure;
import android.text.format.Time;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class p
{
  private static String a = "";
  private Context b;
  private Time c;
  private final ExecutorService d;
  
  public p(Context paramContext)
  {
    this.b = paramContext;
    this.c = new Time();
    this.d = Executors.newFixedThreadPool(1);
    a = this.b.getApplicationContext().getFilesDir().getAbsolutePath() + "/payment_statistics.temp";
  }
  
  /* Error */
  private void a(String paramString)
  {
    // Byte code:
    //   0: new 53	java/io/File
    //   3: dup
    //   4: getstatic 18	com/gau/go/launcherex/gowidget/statistics/p:a	Ljava/lang/String;
    //   7: invokespecial 81	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_2
    //   11: aload_2
    //   12: invokevirtual 85	java/io/File:exists	()Z
    //   15: ifne +8 -> 23
    //   18: aload_2
    //   19: invokevirtual 88	java/io/File:createNewFile	()Z
    //   22: pop
    //   23: aload_2
    //   24: invokevirtual 85	java/io/File:exists	()Z
    //   27: ifeq +53 -> 80
    //   30: new 90	java/io/FileOutputStream
    //   33: dup
    //   34: aload_2
    //   35: iconst_1
    //   36: invokespecial 93	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   39: astore_3
    //   40: aload_3
    //   41: astore_2
    //   42: aload_3
    //   43: new 40	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   50: aload_1
    //   51: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: ldc 95
    //   56: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokevirtual 101	java/lang/String:getBytes	()[B
    //   65: invokevirtual 105	java/io/FileOutputStream:write	([B)V
    //   68: aload_3
    //   69: ifnull +11 -> 80
    //   72: aload_3
    //   73: invokevirtual 108	java/io/FileOutputStream:flush	()V
    //   76: aload_3
    //   77: invokevirtual 111	java/io/FileOutputStream:close	()V
    //   80: return
    //   81: astore_3
    //   82: aload_3
    //   83: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   86: goto -63 -> 23
    //   89: astore_1
    //   90: aload_1
    //   91: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   94: return
    //   95: astore 4
    //   97: aconst_null
    //   98: astore_1
    //   99: aload_1
    //   100: astore_2
    //   101: aload 4
    //   103: invokevirtual 115	java/lang/Exception:printStackTrace	()V
    //   106: aload_1
    //   107: ifnull -27 -> 80
    //   110: aload_1
    //   111: invokevirtual 108	java/io/FileOutputStream:flush	()V
    //   114: aload_1
    //   115: invokevirtual 111	java/io/FileOutputStream:close	()V
    //   118: return
    //   119: astore_1
    //   120: aload_1
    //   121: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   124: return
    //   125: astore_1
    //   126: aconst_null
    //   127: astore_2
    //   128: aload_2
    //   129: ifnull +11 -> 140
    //   132: aload_2
    //   133: invokevirtual 108	java/io/FileOutputStream:flush	()V
    //   136: aload_2
    //   137: invokevirtual 111	java/io/FileOutputStream:close	()V
    //   140: aload_1
    //   141: athrow
    //   142: astore_2
    //   143: aload_2
    //   144: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   147: goto -7 -> 140
    //   150: astore_1
    //   151: goto -23 -> 128
    //   154: astore 4
    //   156: aload_3
    //   157: astore_1
    //   158: goto -59 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	p
    //   0	161	1	paramString	String
    //   10	127	2	localObject	Object
    //   142	2	2	localIOException1	java.io.IOException
    //   39	38	3	localFileOutputStream	java.io.FileOutputStream
    //   81	76	3	localIOException2	java.io.IOException
    //   95	7	4	localException1	Exception
    //   154	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   18	23	81	java/io/IOException
    //   72	80	89	java/io/IOException
    //   30	40	95	java/lang/Exception
    //   110	118	119	java/io/IOException
    //   30	40	125	finally
    //   132	140	142	java/io/IOException
    //   42	68	150	finally
    //   101	106	150	finally
    //   42	68	154	java/lang/Exception
  }
  
  private String b(o paramo)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("6||");
    localStringBuffer.append(Settings.Secure.getString(this.b.getContentResolver(), "android_id"));
    localStringBuffer.append("||");
    this.c.setToNow();
    localStringBuffer.append(this.c.format("%Y-%m-%d %T"));
    localStringBuffer.append("||");
    localStringBuffer.append(paramo.a);
    localStringBuffer.append("||");
    localStringBuffer.append(paramo.b);
    localStringBuffer.append("||");
    localStringBuffer.append(paramo.c);
    localStringBuffer.append("||");
    localStringBuffer.append(paramo.d);
    localStringBuffer.append("||");
    localStringBuffer.append(paramo.e);
    localStringBuffer.append("||");
    localStringBuffer.append(paramo.f);
    localStringBuffer.append("||");
    String str = y.d(this.b);
    paramo = str;
    if (str == null) {
      paramo = "0000000000000000";
    }
    localStringBuffer.append(paramo);
    localStringBuffer.append("||");
    localStringBuffer.append(y.n(this.b));
    localStringBuffer.append("||");
    localStringBuffer.append(y.f(this.b));
    localStringBuffer.append("||");
    localStringBuffer.append(y.e(this.b));
    return localStringBuffer.toString();
  }
  
  /* Error */
  public java.util.List a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 53	java/io/File
    //   5: dup
    //   6: getstatic 18	com/gau/go/launcherex/gowidget/statistics/p:a	Ljava/lang/String;
    //   9: invokespecial 81	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: astore 4
    //   14: aload 4
    //   16: invokevirtual 85	java/io/File:exists	()Z
    //   19: ifeq +154 -> 173
    //   22: new 185	java/util/ArrayList
    //   25: dup
    //   26: invokespecial 186	java/util/ArrayList:<init>	()V
    //   29: astore 5
    //   31: new 188	java/io/BufferedReader
    //   34: dup
    //   35: new 190	java/io/FileReader
    //   38: dup
    //   39: aload 4
    //   41: invokespecial 193	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   44: invokespecial 196	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   47: astore_2
    //   48: aload_2
    //   49: astore_1
    //   50: aload_2
    //   51: invokevirtual 199	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   54: astore_3
    //   55: aload_3
    //   56: ifnull +41 -> 97
    //   59: aload_2
    //   60: astore_1
    //   61: aload 5
    //   63: aload_3
    //   64: invokeinterface 205 2 0
    //   69: pop
    //   70: goto -22 -> 48
    //   73: astore_3
    //   74: aload_2
    //   75: astore_1
    //   76: aload_3
    //   77: invokevirtual 115	java/lang/Exception:printStackTrace	()V
    //   80: aload_2
    //   81: ifnull +13 -> 94
    //   84: aload_2
    //   85: invokevirtual 206	java/io/BufferedReader:close	()V
    //   88: aload 4
    //   90: invokevirtual 209	java/io/File:delete	()Z
    //   93: pop
    //   94: aload 5
    //   96: areturn
    //   97: aload_2
    //   98: ifnull -4 -> 94
    //   101: aload_2
    //   102: invokevirtual 206	java/io/BufferedReader:close	()V
    //   105: aload 4
    //   107: invokevirtual 209	java/io/File:delete	()Z
    //   110: pop
    //   111: aload 5
    //   113: areturn
    //   114: astore_1
    //   115: aload_1
    //   116: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   119: aload 5
    //   121: areturn
    //   122: astore_1
    //   123: aload_1
    //   124: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   127: aload 5
    //   129: areturn
    //   130: astore_3
    //   131: aload_1
    //   132: astore_2
    //   133: aload_3
    //   134: astore_1
    //   135: aload_2
    //   136: ifnull +13 -> 149
    //   139: aload_2
    //   140: invokevirtual 206	java/io/BufferedReader:close	()V
    //   143: aload 4
    //   145: invokevirtual 209	java/io/File:delete	()Z
    //   148: pop
    //   149: aload_1
    //   150: athrow
    //   151: astore_2
    //   152: aload_2
    //   153: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   156: goto -7 -> 149
    //   159: astore_3
    //   160: aload_1
    //   161: astore_2
    //   162: aload_3
    //   163: astore_1
    //   164: goto -29 -> 135
    //   167: astore_3
    //   168: aconst_null
    //   169: astore_2
    //   170: goto -96 -> 74
    //   173: aconst_null
    //   174: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	p
    //   1	75	1	localObject1	Object
    //   114	2	1	localIOException1	java.io.IOException
    //   122	10	1	localIOException2	java.io.IOException
    //   134	30	1	localObject2	Object
    //   47	93	2	localObject3	Object
    //   151	2	2	localIOException3	java.io.IOException
    //   161	9	2	localObject4	Object
    //   54	10	3	str	String
    //   73	4	3	localException1	Exception
    //   130	4	3	localObject5	Object
    //   159	4	3	localObject6	Object
    //   167	1	3	localException2	Exception
    //   12	132	4	localFile	File
    //   29	99	5	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   50	55	73	java/lang/Exception
    //   61	70	73	java/lang/Exception
    //   101	111	114	java/io/IOException
    //   84	94	122	java/io/IOException
    //   31	48	130	finally
    //   139	149	151	java/io/IOException
    //   50	55	159	finally
    //   61	70	159	finally
    //   76	80	159	finally
    //   31	48	167	java/lang/Exception
  }
  
  public void a(o paramo)
  {
    this.d.execute(new q(this, paramo));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/statistics/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */