package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.widget.ImageView;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.g.a;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public final class n
{
  private static volatile n a = null;
  private static Handler b = new Handler();
  private d c = new d(Chartboost.sharedChartboost().getContext());
  private Map<String, g.a> d = new HashMap();
  
  private g.a a(String paramString)
  {
    if (c(paramString))
    {
      if (this.d.containsKey(paramString)) {
        return (g.a)this.d.get(paramString);
      }
      g.a locala = new g.a(paramString, b(paramString));
      this.d.put(paramString, locala);
      return locala;
    }
    if (this.d.containsKey(paramString)) {
      this.d.remove(paramString);
    }
    return null;
  }
  
  public static n a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new n();
      }
      return a;
    }
    finally {}
  }
  
  private boolean a(String paramString, byte[] paramArrayOfByte)
    throws IOException
  {
    paramString = this.c.a(paramString + ".png");
    if (paramString == null) {
      return false;
    }
    try
    {
      ah.a(paramString, paramArrayOfByte);
      return true;
    }
    catch (Exception paramString)
    {
      CBLogging.b("CBWebImageCache", "Exception writing image content to a file", paramString);
    }
    return false;
  }
  
  private static a b(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      paramImageView = paramImageView.getDrawable();
      if ((paramImageView instanceof c)) {
        return ((c)paramImageView).a();
      }
    }
    return null;
  }
  
  private File b(String paramString)
  {
    return this.c.a(paramString + ".png");
  }
  
  private boolean c(String paramString)
  {
    paramString = b(paramString);
    if (paramString == null) {
      return false;
    }
    return paramString.exists();
  }
  
  public void a(String paramString1, String paramString2, b paramb, ImageView paramImageView, Bundle paramBundle)
  {
    g.a locala = a(paramString2);
    if (locala != null)
    {
      if (paramImageView != null) {
        paramImageView.setImageBitmap(locala.a());
      }
      if (paramb != null) {
        paramb.a(locala, paramBundle);
      }
      return;
    }
    paramString1 = new a(paramImageView, paramb, paramString2, paramBundle, paramString1);
    k.a().execute(paramString1);
  }
  
  public void b()
  {
    this.c.a();
    this.d.clear();
  }
  
  private class a
    implements Runnable
  {
    private String b;
    private final WeakReference<ImageView> c;
    private n.b d;
    private String e;
    private Bundle f;
    
    public a(ImageView paramImageView, n.b paramb, String paramString1, Bundle paramBundle, String paramString2)
    {
      this.c = new WeakReference(paramImageView);
      this$1 = new n.c(this);
      if (paramImageView != null) {
        paramImageView.setImageDrawable(n.this);
      }
      this.e = paramString1;
      this.d = paramb;
      this.f = paramBundle;
      this.b = paramString2;
    }
    
    private g.a b()
    {
      return (g.a)n.a(n.this).get(this.e);
    }
    
    public void a()
    {
      final g.a locala = b();
      if ((locala != null) && (this.c != null) && (this.c.get() != null) && (this == n.a((ImageView)this.c.get()))) {
        locala.b();
      }
      n.c().post(new Runnable()
      {
        public void run()
        {
          if (n.a.a(n.a.this) != null)
          {
            ImageView localImageView = (ImageView)n.a.a(n.a.this).get();
            n.a locala = n.a(localImageView);
            if ((locala != null) && (n.a.this == locala)) {
              localImageView.setImageBitmap(locala.a());
            }
          }
          if (n.a.b(n.a.this) != null) {
            n.a.b(n.a.this).a(locala, n.a.c(n.a.this));
          }
        }
      });
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 5
      //   3: aconst_null
      //   4: astore 4
      //   6: aload_0
      //   7: getfield 26	com/chartboost/sdk/impl/n$a:a	Lcom/chartboost/sdk/impl/n;
      //   10: aload_0
      //   11: getfield 49	com/chartboost/sdk/impl/n$a:e	Ljava/lang/String;
      //   14: invokestatic 103	com/chartboost/sdk/impl/n:a	(Lcom/chartboost/sdk/impl/n;Ljava/lang/String;)Z
      //   17: ifeq +8 -> 25
      //   20: aload_0
      //   21: invokevirtual 105	com/chartboost/sdk/impl/n$a:a	()V
      //   24: return
      //   25: invokestatic 110	com/chartboost/sdk/impl/k:b	()Lorg/apache/http/client/HttpClient;
      //   28: astore_3
      //   29: new 112	org/apache/http/client/methods/HttpGet
      //   32: dup
      //   33: aload_0
      //   34: getfield 55	com/chartboost/sdk/impl/n$a:b	Ljava/lang/String;
      //   37: invokespecial 115	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
      //   40: astore 6
      //   42: ldc 117
      //   44: new 119	java/lang/StringBuilder
      //   47: dup
      //   48: invokespecial 120	java/lang/StringBuilder:<init>	()V
      //   51: ldc 122
      //   53: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   56: aload_0
      //   57: getfield 55	com/chartboost/sdk/impl/n$a:b	Ljava/lang/String;
      //   60: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   63: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   66: invokestatic 135	com/chartboost/sdk/Libraries/CBLogging:a	(Ljava/lang/Object;Ljava/lang/String;)V
      //   69: aload_3
      //   70: aload 6
      //   72: invokeinterface 141 2 0
      //   77: astore_3
      //   78: aload_3
      //   79: invokeinterface 147 1 0
      //   84: invokeinterface 153 1 0
      //   89: istore_1
      //   90: iload_1
      //   91: sipush 200
      //   94: if_icmpeq +99 -> 193
      //   97: ldc -101
      //   99: new 119	java/lang/StringBuilder
      //   102: dup
      //   103: invokespecial 120	java/lang/StringBuilder:<init>	()V
      //   106: ldc -99
      //   108: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   111: iload_1
      //   112: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   115: ldc -94
      //   117: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   120: aload_0
      //   121: getfield 55	com/chartboost/sdk/impl/n$a:b	Ljava/lang/String;
      //   124: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   127: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   130: invokestatic 164	com/chartboost/sdk/Libraries/CBLogging:c	(Ljava/lang/Object;Ljava/lang/String;)V
      //   133: aload_3
      //   134: invokestatic 169	com/chartboost/sdk/Libraries/CBUtility:a	(Lorg/apache/http/HttpResponse;)V
      //   137: aload_0
      //   138: invokevirtual 105	com/chartboost/sdk/impl/n$a:a	()V
      //   141: return
      //   142: astore 5
      //   144: aload_3
      //   145: astore 4
      //   147: aload 5
      //   149: astore_3
      //   150: aload 6
      //   152: invokevirtual 172	org/apache/http/client/methods/HttpGet:abort	()V
      //   155: aload 4
      //   157: invokestatic 169	com/chartboost/sdk/Libraries/CBUtility:a	(Lorg/apache/http/HttpResponse;)V
      //   160: ldc 117
      //   162: new 119	java/lang/StringBuilder
      //   165: dup
      //   166: invokespecial 120	java/lang/StringBuilder:<init>	()V
      //   169: ldc -82
      //   171: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   174: aload_0
      //   175: getfield 55	com/chartboost/sdk/impl/n$a:b	Ljava/lang/String;
      //   178: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   181: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   184: aload_3
      //   185: invokestatic 177	com/chartboost/sdk/Libraries/CBLogging:d	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   188: aload_0
      //   189: invokevirtual 105	com/chartboost/sdk/impl/n$a:a	()V
      //   192: return
      //   193: aload_3
      //   194: invokeinterface 181 1 0
      //   199: astore 7
      //   201: aload 7
      //   203: ifnull -15 -> 188
      //   206: aload 5
      //   208: astore 4
      //   210: aload 7
      //   212: invokeinterface 187 1 0
      //   217: astore 5
      //   219: aload 5
      //   221: astore 4
      //   223: aload 5
      //   225: invokestatic 192	com/chartboost/sdk/impl/ai:a	(Ljava/io/InputStream;)[B
      //   228: astore 8
      //   230: aload 5
      //   232: astore 4
      //   234: aload 8
      //   236: invokestatic 197	com/chartboost/sdk/Libraries/b:a	([B)[B
      //   239: invokestatic 200	com/chartboost/sdk/Libraries/b:b	([B)Ljava/lang/String;
      //   242: aload_0
      //   243: getfield 49	com/chartboost/sdk/impl/n$a:e	Ljava/lang/String;
      //   246: invokevirtual 206	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   249: istore_2
      //   250: iload_2
      //   251: ifne +118 -> 369
      //   254: aload 5
      //   256: ifnull +58 -> 314
      //   259: aload 5
      //   261: invokevirtual 211	java/io/InputStream:close	()V
      //   264: return
      //   265: astore 5
      //   267: aload_3
      //   268: astore 4
      //   270: aload 5
      //   272: astore_3
      //   273: aload 6
      //   275: invokevirtual 172	org/apache/http/client/methods/HttpGet:abort	()V
      //   278: aload 4
      //   280: invokestatic 169	com/chartboost/sdk/Libraries/CBUtility:a	(Lorg/apache/http/HttpResponse;)V
      //   283: ldc 117
      //   285: new 119	java/lang/StringBuilder
      //   288: dup
      //   289: invokespecial 120	java/lang/StringBuilder:<init>	()V
      //   292: ldc -43
      //   294: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   297: aload_0
      //   298: getfield 55	com/chartboost/sdk/impl/n$a:b	Ljava/lang/String;
      //   301: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   304: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   307: aload_3
      //   308: invokestatic 177	com/chartboost/sdk/Libraries/CBLogging:d	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   311: goto -123 -> 188
      //   314: aload 7
      //   316: invokestatic 216	com/chartboost/sdk/Libraries/CBUtility:a	(Lorg/apache/http/HttpEntity;)V
      //   319: return
      //   320: astore 5
      //   322: aload_3
      //   323: astore 4
      //   325: aload 5
      //   327: astore_3
      //   328: aload 6
      //   330: invokevirtual 172	org/apache/http/client/methods/HttpGet:abort	()V
      //   333: aload 4
      //   335: invokestatic 169	com/chartboost/sdk/Libraries/CBUtility:a	(Lorg/apache/http/HttpResponse;)V
      //   338: ldc 117
      //   340: new 119	java/lang/StringBuilder
      //   343: dup
      //   344: invokespecial 120	java/lang/StringBuilder:<init>	()V
      //   347: ldc -38
      //   349: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   352: aload_0
      //   353: getfield 55	com/chartboost/sdk/impl/n$a:b	Ljava/lang/String;
      //   356: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   359: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   362: aload_3
      //   363: invokestatic 177	com/chartboost/sdk/Libraries/CBLogging:d	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   366: goto -178 -> 188
      //   369: aload 5
      //   371: astore 4
      //   373: aload_0
      //   374: getfield 26	com/chartboost/sdk/impl/n$a:a	Lcom/chartboost/sdk/impl/n;
      //   377: aload_0
      //   378: getfield 49	com/chartboost/sdk/impl/n$a:e	Ljava/lang/String;
      //   381: aload 8
      //   383: invokestatic 221	com/chartboost/sdk/impl/n:a	(Lcom/chartboost/sdk/impl/n;Ljava/lang/String;[B)Z
      //   386: pop
      //   387: aload 5
      //   389: astore 4
      //   391: aload_0
      //   392: getfield 26	com/chartboost/sdk/impl/n$a:a	Lcom/chartboost/sdk/impl/n;
      //   395: aload_0
      //   396: getfield 49	com/chartboost/sdk/impl/n$a:e	Ljava/lang/String;
      //   399: invokestatic 224	com/chartboost/sdk/impl/n:b	(Lcom/chartboost/sdk/impl/n;Ljava/lang/String;)Lcom/chartboost/sdk/Libraries/g$a;
      //   402: pop
      //   403: aload 5
      //   405: ifnull +11 -> 416
      //   408: aload 5
      //   410: invokevirtual 211	java/io/InputStream:close	()V
      //   413: goto -225 -> 188
      //   416: aload 7
      //   418: invokestatic 216	com/chartboost/sdk/Libraries/CBUtility:a	(Lorg/apache/http/HttpEntity;)V
      //   421: goto -233 -> 188
      //   424: astore 5
      //   426: aload 4
      //   428: ifnull +11 -> 439
      //   431: aload 4
      //   433: invokevirtual 211	java/io/InputStream:close	()V
      //   436: aload 5
      //   438: athrow
      //   439: aload 7
      //   441: invokestatic 216	com/chartboost/sdk/Libraries/CBUtility:a	(Lorg/apache/http/HttpEntity;)V
      //   444: goto -8 -> 436
      //   447: astore_3
      //   448: aconst_null
      //   449: astore 4
      //   451: goto -123 -> 328
      //   454: astore_3
      //   455: aconst_null
      //   456: astore 4
      //   458: goto -185 -> 273
      //   461: astore_3
      //   462: goto -312 -> 150
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	465	0	this	a
      //   89	23	1	i	int
      //   249	2	2	bool	boolean
      //   28	335	3	localObject1	Object
      //   447	1	3	localThrowable1	Throwable
      //   454	1	3	localIllegalStateException1	IllegalStateException
      //   461	1	3	localIOException1	IOException
      //   4	453	4	localObject2	Object
      //   1	1	5	localObject3	Object
      //   142	65	5	localIOException2	IOException
      //   217	43	5	localInputStream	java.io.InputStream
      //   265	6	5	localIllegalStateException2	IllegalStateException
      //   320	89	5	localThrowable2	Throwable
      //   424	13	5	localObject4	Object
      //   40	289	6	localHttpGet	org.apache.http.client.methods.HttpGet
      //   199	241	7	localHttpEntity	org.apache.http.HttpEntity
      //   228	154	8	arrayOfByte	byte[]
      // Exception table:
      //   from	to	target	type
      //   78	90	142	java/io/IOException
      //   97	141	142	java/io/IOException
      //   193	201	142	java/io/IOException
      //   259	264	142	java/io/IOException
      //   314	319	142	java/io/IOException
      //   408	413	142	java/io/IOException
      //   416	421	142	java/io/IOException
      //   431	436	142	java/io/IOException
      //   436	439	142	java/io/IOException
      //   439	444	142	java/io/IOException
      //   78	90	265	java/lang/IllegalStateException
      //   97	141	265	java/lang/IllegalStateException
      //   193	201	265	java/lang/IllegalStateException
      //   259	264	265	java/lang/IllegalStateException
      //   314	319	265	java/lang/IllegalStateException
      //   408	413	265	java/lang/IllegalStateException
      //   416	421	265	java/lang/IllegalStateException
      //   431	436	265	java/lang/IllegalStateException
      //   436	439	265	java/lang/IllegalStateException
      //   439	444	265	java/lang/IllegalStateException
      //   78	90	320	java/lang/Throwable
      //   97	141	320	java/lang/Throwable
      //   193	201	320	java/lang/Throwable
      //   259	264	320	java/lang/Throwable
      //   314	319	320	java/lang/Throwable
      //   408	413	320	java/lang/Throwable
      //   416	421	320	java/lang/Throwable
      //   431	436	320	java/lang/Throwable
      //   436	439	320	java/lang/Throwable
      //   439	444	320	java/lang/Throwable
      //   210	219	424	finally
      //   223	230	424	finally
      //   234	250	424	finally
      //   373	387	424	finally
      //   391	403	424	finally
      //   69	78	447	java/lang/Throwable
      //   69	78	454	java/lang/IllegalStateException
      //   69	78	461	java/io/IOException
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(g.a parama, Bundle paramBundle);
  }
  
  static class c
    extends BitmapDrawable
  {
    private final WeakReference<n.a> a;
    
    public c(n.a parama)
    {
      this.a = new WeakReference(parama);
    }
    
    public n.a a()
    {
      return (n.a)this.a.get();
    }
  }
  
  private static class d
  {
    private File a = null;
    private File b = null;
    private File c = null;
    
    public d(Context paramContext)
    {
      a(paramContext);
    }
    
    private void a(Context paramContext)
    {
      if (paramContext == null) {
        return;
      }
      for (;;)
      {
        try
        {
          if (paramContext.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            continue;
          }
          i = 1;
          if ((i != 0) && (Environment.getExternalStorageState().equals("mounted"))) {
            this.b = paramContext.getExternalFilesDir("cache");
          }
          if (this.b != null)
          {
            this.b = new File(this.b, "__chartboost");
            this.b = new File(this.b, "images");
            if ((this.b != null) && (!this.b.exists())) {
              this.b.mkdirs();
            }
          }
        }
        catch (Exception localException)
        {
          int i;
          this.b = null;
          continue;
          paramContext = this.c;
          continue;
        }
        this.c = paramContext.getCacheDir();
        if (this.c != null)
        {
          this.c = new File(this.c, "__chartboost");
          this.c = new File(this.c, "images");
          if (!this.c.exists()) {
            this.c.mkdirs();
          }
        }
        if (this.b == null) {
          continue;
        }
        paramContext = this.b;
        this.a = paramContext;
        return;
        i = 0;
      }
    }
    
    public File a(String paramString)
    {
      if (this.a == null) {
        a(Chartboost.sharedChartboost().getContext());
      }
      if (this.a == null) {
        return null;
      }
      return new File(this.a, paramString);
    }
    
    public void a()
    {
      int j = 0;
      if (this.a == null) {}
      for (;;)
      {
        return;
        try
        {
          if (this.b != null)
          {
            arrayOfFile = this.b.listFiles();
            if (arrayOfFile != null)
            {
              k = arrayOfFile.length;
              i = 0;
              while (i < k)
              {
                arrayOfFile[i].delete();
                i += 1;
              }
            }
          }
          if (this.c == null) {
            continue;
          }
          File[] arrayOfFile = this.c.listFiles();
          if (arrayOfFile == null) {
            continue;
          }
          int k = arrayOfFile.length;
          int i = j;
          while (i < k)
          {
            arrayOfFile[i].delete();
            i += 1;
          }
          return;
        }
        catch (Exception localException) {}
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/impl/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */