package com.gau.go.launcherex.gowidget.weather.globaltheme.a.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.jiubang.goweather.b.d;
import com.jiubang.goweather.b.e;
import com.jiubang.goweather.e.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

public final class b
{
  public static Bitmap a(String paramString, Context paramContext)
  {
    localObject1 = null;
    Object localObject2 = null;
    e locale;
    com.jiubang.goweather.b.f localf;
    com.jiubang.goweather.b.c localc;
    if (!TextUtils.isEmpty(paramString))
    {
      locale = new e(paramString, "GET");
      localf = new com.jiubang.goweather.b.f();
      localc = d.a();
      localObject1 = localObject2;
      if (!localc.a(localf, paramContext)) {}
    }
    try
    {
      paramString = localc.a(paramString, locale, localf);
      localObject1 = localObject2;
      if (paramString != null) {
        paramContext = BitmapFactory.decodeStream(paramString);
      }
      try
      {
        paramString.close();
        localObject1 = paramContext;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          localObject1 = paramContext;
          if (com.gtp.a.a.b.c.a())
          {
            paramString.printStackTrace();
            localObject1 = paramContext;
          }
        }
      }
      localc.a();
      return (Bitmap)localObject1;
    }
    catch (IllegalArgumentException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  public static String a(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    e locale = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = paramString2;
    if (paramInt1 == 1) {}
    try
    {
      localObject1 = com.gau.go.launcherex.gowidget.d.f.a(paramString2, "UTF-8", "ISO-8859-1");
      paramString2 = locale;
      if (localObject1 != null)
      {
        locale = new e(paramString1, "POST");
        paramString2 = new ArrayList();
        paramString2.add(new BasicNameValuePair("handle", paramInt1 + ""));
        paramString2.add(new BasicNameValuePair("data", (String)localObject1));
        paramString2.add(new BasicNameValuePair("shandle", paramInt2 + ""));
        locale.a(paramString2);
        com.jiubang.goweather.b.f localf = new com.jiubang.goweather.b.f();
        localObject1 = d.a();
        paramString2 = (String)localObject2;
        if (((com.jiubang.goweather.b.c)localObject1).a(localf, paramContext))
        {
          paramString1 = ((com.jiubang.goweather.b.c)localObject1).a(paramString1, locale, localf);
          paramString2 = (String)localObject2;
          if (paramString1 != null) {
            paramContext = (Context)localObject3;
          }
        }
      }
      try
      {
        paramString1 = a.a(paramString1, "ISO-8859-1");
        paramString2 = paramString1;
        if (paramInt2 == 1)
        {
          paramContext = paramString1;
          paramString2 = com.gau.go.launcherex.gowidget.d.f.b(paramString1, "ISO-8859-1", "UTF-8");
        }
      }
      catch (IOException paramString1)
      {
        for (;;)
        {
          paramString2 = paramContext;
          if (com.gtp.a.a.b.c.a())
          {
            paramString1.printStackTrace();
            paramString2 = paramContext;
          }
        }
      }
      ((com.jiubang.goweather.b.c)localObject1).a();
      return paramString2;
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        if (com.gtp.a.a.b.c.a()) {
          paramString2.printStackTrace();
        }
        localObject1 = null;
      }
    }
  }
  
  /* Error */
  public static boolean a(String paramString1, Context paramContext, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +136 -> 140
    //   7: aload_2
    //   8: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifne +129 -> 140
    //   14: new 18	com/jiubang/goweather/b/e
    //   17: dup
    //   18: aload_0
    //   19: ldc 20
    //   21: invokespecial 24	com/jiubang/goweather/b/e:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: astore 4
    //   26: new 26	com/jiubang/goweather/b/f
    //   29: dup
    //   30: invokespecial 29	com/jiubang/goweather/b/f:<init>	()V
    //   33: astore 6
    //   35: invokestatic 34	com/jiubang/goweather/b/d:a	()Lcom/jiubang/goweather/b/c;
    //   38: astore 5
    //   40: aload 5
    //   42: aload 6
    //   44: aload_1
    //   45: invokevirtual 39	com/jiubang/goweather/b/c:a	(Lcom/jiubang/goweather/b/f;Landroid/content/Context;)Z
    //   48: ifeq +123 -> 171
    //   51: aload 5
    //   53: aload_0
    //   54: aload 4
    //   56: aload 6
    //   58: invokevirtual 42	com/jiubang/goweather/b/c:a	(Ljava/lang/String;Lcom/jiubang/goweather/b/e;Lcom/jiubang/goweather/b/f;)Ljava/io/InputStream;
    //   61: astore 4
    //   63: aload 4
    //   65: ifnull +106 -> 171
    //   68: new 129	java/io/FileOutputStream
    //   71: dup
    //   72: aload_2
    //   73: invokespecial 132	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   76: astore_1
    //   77: aload_1
    //   78: astore_0
    //   79: sipush 8192
    //   82: newarray <illegal type>
    //   84: astore_2
    //   85: aload_1
    //   86: astore_0
    //   87: aload 4
    //   89: aload_2
    //   90: iconst_0
    //   91: sipush 8192
    //   94: invokevirtual 136	java/io/InputStream:read	([BII)I
    //   97: istore_3
    //   98: iload_3
    //   99: iconst_m1
    //   100: if_icmpeq +53 -> 153
    //   103: aload_1
    //   104: astore_0
    //   105: aload_1
    //   106: aload_2
    //   107: iconst_0
    //   108: iload_3
    //   109: invokevirtual 140	java/io/FileOutputStream:write	([BII)V
    //   112: goto -27 -> 85
    //   115: astore_2
    //   116: aload_1
    //   117: astore_0
    //   118: aload_2
    //   119: invokevirtual 141	java/io/FileNotFoundException:printStackTrace	()V
    //   122: aload_1
    //   123: ifnull +7 -> 130
    //   126: aload_1
    //   127: invokevirtual 142	java/io/FileOutputStream:close	()V
    //   130: aload 4
    //   132: ifnull +8 -> 140
    //   135: aload 4
    //   137: invokevirtual 53	java/io/InputStream:close	()V
    //   140: iconst_0
    //   141: ireturn
    //   142: astore_0
    //   143: aload_0
    //   144: invokevirtual 58	java/lang/IllegalArgumentException:printStackTrace	()V
    //   147: aconst_null
    //   148: astore 4
    //   150: goto -87 -> 63
    //   153: aload_1
    //   154: ifnull +7 -> 161
    //   157: aload_1
    //   158: invokevirtual 142	java/io/FileOutputStream:close	()V
    //   161: aload 4
    //   163: ifnull +8 -> 171
    //   166: aload 4
    //   168: invokevirtual 53	java/io/InputStream:close	()V
    //   171: aload 5
    //   173: invokevirtual 55	com/jiubang/goweather/b/c:a	()V
    //   176: iconst_1
    //   177: ireturn
    //   178: astore_0
    //   179: aload_0
    //   180: invokevirtual 143	java/lang/Exception:printStackTrace	()V
    //   183: goto -22 -> 161
    //   186: astore_0
    //   187: aload_0
    //   188: invokevirtual 143	java/lang/Exception:printStackTrace	()V
    //   191: goto -20 -> 171
    //   194: astore_0
    //   195: aload_0
    //   196: invokevirtual 143	java/lang/Exception:printStackTrace	()V
    //   199: goto -69 -> 130
    //   202: astore_0
    //   203: aload_0
    //   204: invokevirtual 143	java/lang/Exception:printStackTrace	()V
    //   207: iconst_0
    //   208: ireturn
    //   209: astore_2
    //   210: aconst_null
    //   211: astore_1
    //   212: aload_1
    //   213: astore_0
    //   214: aload_2
    //   215: invokevirtual 143	java/lang/Exception:printStackTrace	()V
    //   218: aload_1
    //   219: ifnull +7 -> 226
    //   222: aload_1
    //   223: invokevirtual 142	java/io/FileOutputStream:close	()V
    //   226: aload 4
    //   228: ifnull -88 -> 140
    //   231: aload 4
    //   233: invokevirtual 53	java/io/InputStream:close	()V
    //   236: iconst_0
    //   237: ireturn
    //   238: astore_0
    //   239: aload_0
    //   240: invokevirtual 143	java/lang/Exception:printStackTrace	()V
    //   243: iconst_0
    //   244: ireturn
    //   245: astore_0
    //   246: aload_0
    //   247: invokevirtual 143	java/lang/Exception:printStackTrace	()V
    //   250: goto -24 -> 226
    //   253: astore_1
    //   254: aconst_null
    //   255: astore_0
    //   256: aload_0
    //   257: ifnull +7 -> 264
    //   260: aload_0
    //   261: invokevirtual 142	java/io/FileOutputStream:close	()V
    //   264: aload 4
    //   266: ifnull +8 -> 274
    //   269: aload 4
    //   271: invokevirtual 53	java/io/InputStream:close	()V
    //   274: aload_1
    //   275: athrow
    //   276: astore_0
    //   277: aload_0
    //   278: invokevirtual 143	java/lang/Exception:printStackTrace	()V
    //   281: goto -17 -> 264
    //   284: astore_0
    //   285: aload_0
    //   286: invokevirtual 143	java/lang/Exception:printStackTrace	()V
    //   289: goto -15 -> 274
    //   292: astore_1
    //   293: goto -37 -> 256
    //   296: astore_2
    //   297: goto -85 -> 212
    //   300: astore_2
    //   301: aconst_null
    //   302: astore_1
    //   303: goto -187 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	306	0	paramString1	String
    //   0	306	1	paramContext	Context
    //   0	306	2	paramString2	String
    //   97	12	3	i	int
    //   24	246	4	localObject	Object
    //   38	134	5	localc	com.jiubang.goweather.b.c
    //   33	24	6	localf	com.jiubang.goweather.b.f
    // Exception table:
    //   from	to	target	type
    //   79	85	115	java/io/FileNotFoundException
    //   87	98	115	java/io/FileNotFoundException
    //   105	112	115	java/io/FileNotFoundException
    //   51	63	142	java/lang/IllegalArgumentException
    //   157	161	178	java/lang/Exception
    //   166	171	186	java/lang/Exception
    //   126	130	194	java/lang/Exception
    //   135	140	202	java/lang/Exception
    //   68	77	209	java/lang/Exception
    //   231	236	238	java/lang/Exception
    //   222	226	245	java/lang/Exception
    //   68	77	253	finally
    //   260	264	276	java/lang/Exception
    //   269	274	284	java/lang/Exception
    //   79	85	292	finally
    //   87	98	292	finally
    //   105	112	292	finally
    //   118	122	292	finally
    //   214	218	292	finally
    //   79	85	296	java/lang/Exception
    //   87	98	296	java/lang/Exception
    //   105	112	296	java/lang/Exception
    //   68	77	300	java/io/FileNotFoundException
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/globaltheme/a/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */