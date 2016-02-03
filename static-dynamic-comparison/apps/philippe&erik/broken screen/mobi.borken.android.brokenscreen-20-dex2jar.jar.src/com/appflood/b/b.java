package com.appflood.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import com.appflood.c.f;
import com.appflood.e.j;
import com.appflood.e.k;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

public final class b
  implements Runnable
{
  protected boolean a = false;
  private URL b;
  private a c = null;
  private int d = -1;
  private int e = -1;
  private byte[] f;
  
  public b(String paramString)
  {
    this.b = k.a(paramString);
  }
  
  public b(String paramString, byte paramByte)
  {
    this.b = k.a(paramString);
    this.a = true;
  }
  
  public b(String paramString, Map<String, Object> paramMap)
  {
    this.b = k.b(paramString, paramMap);
  }
  
  public b(JSONObject paramJSONObject)
  {
    this(j.a(paramJSONObject, "url", null), (byte)0);
  }
  
  private void a(int paramInt)
  {
    if (this.c != null) {
      this.c.a(this, paramInt);
    }
    try
    {
      synchronized (f.d())
      {
        j.c("connection failed " + paramInt + " " + this.b.toString());
        ???.a.remove(this);
        ???.a();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  public final b a(a parama)
  {
    this.c = parama;
    return this;
  }
  
  public final URL a()
  {
    return this.b;
  }
  
  public final void a(View paramView)
  {
    this.c = new a()
    {
      public final void a(b paramAnonymousb)
      {
        f.a(new Runnable()
        {
          public final void run()
          {
            try
            {
              if ((b.this instanceof ImageView))
              {
                ((ImageView)b.this).setImageBitmap(this.a);
                return;
              }
              b.this.setBackgroundDrawable(new BitmapDrawable(this.a));
              return;
            }
            catch (Throwable localThrowable)
            {
              j.a(localThrowable, "set view image failed!");
            }
          }
        });
      }
      
      public final void a(b paramAnonymousb, int paramAnonymousInt)
      {
        j.c("UI image download failed. statuscode = " + paramAnonymousInt);
      }
    };
    f();
  }
  
  protected final void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.a) && (this.f != null)) {
      f.c().a(this.b.toString(), this.f);
    }
    if (this.c != null) {
      this.c.a(this);
    }
    if (paramBoolean) {
      f.d().a(this);
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      f.d().c(this);
      return;
    }
    f.d().b(this);
  }
  
  public final byte[] b()
  {
    return this.f;
  }
  
  public final String c()
  {
    return j.a(this.f, "");
  }
  
  public final Bitmap d()
  {
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeByteArray(this.f, 0, this.f.length);
      return localBitmap;
    }
    catch (Throwable localThrowable)
    {
      j.b(localThrowable, "broken image");
    }
    return null;
  }
  
  public final boolean e()
  {
    File localFile = f.c().a(this.b.toString());
    if (!localFile.exists()) {
      return false;
    }
    this.f = com.appflood.e.a.a(localFile);
    return true;
  }
  
  public final void f()
  {
    if (f.d() != null) {
      f.d().b(this);
    }
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: sipush 1024
    //   9: newarray <illegal type>
    //   11: astore 4
    //   13: aload_0
    //   14: getfield 43	com/appflood/b/b:b	Ljava/net/URL;
    //   17: invokevirtual 172	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   20: checkcast 174	java/net/HttpURLConnection
    //   23: astore_3
    //   24: aload_0
    //   25: getfield 32	com/appflood/b/b:d	I
    //   28: ifle +288 -> 316
    //   31: aload_0
    //   32: getfield 32	com/appflood/b/b:d	I
    //   35: istore_1
    //   36: aload_3
    //   37: iload_1
    //   38: invokevirtual 177	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   41: aload_0
    //   42: getfield 34	com/appflood/b/b:e	I
    //   45: ifle +138 -> 183
    //   48: aload_3
    //   49: aload_0
    //   50: getfield 34	com/appflood/b/b:e	I
    //   53: invokevirtual 180	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   56: aload_3
    //   57: invokevirtual 183	java/net/HttpURLConnection:connect	()V
    //   60: aload_3
    //   61: invokevirtual 187	java/net/HttpURLConnection:getResponseCode	()I
    //   64: istore_1
    //   65: iload_1
    //   66: sipush 200
    //   69: if_icmpne +192 -> 261
    //   72: aload_3
    //   73: invokestatic 190	com/appflood/e/a:a	(Ljava/net/URLConnection;)Ljava/io/InputStream;
    //   76: astore_2
    //   77: aload_3
    //   78: invokevirtual 193	java/net/HttpURLConnection:getContentLength	()I
    //   81: iconst_m1
    //   82: if_icmpne +136 -> 218
    //   85: sipush 1024
    //   88: istore_1
    //   89: new 195	java/io/ByteArrayOutputStream
    //   92: dup
    //   93: iload_1
    //   94: invokespecial 197	java/io/ByteArrayOutputStream:<init>	(I)V
    //   97: astore_3
    //   98: aload_2
    //   99: aload 4
    //   101: invokevirtual 203	java/io/InputStream:read	([B)I
    //   104: istore_1
    //   105: iload_1
    //   106: iconst_m1
    //   107: if_icmpeq +119 -> 226
    //   110: aload_3
    //   111: aload 4
    //   113: iconst_0
    //   114: iload_1
    //   115: invokevirtual 207	java/io/ByteArrayOutputStream:write	([BII)V
    //   118: goto -20 -> 98
    //   121: astore 5
    //   123: aload_2
    //   124: astore 4
    //   126: aload 5
    //   128: astore_2
    //   129: aload_2
    //   130: new 74	java/lang/StringBuilder
    //   133: dup
    //   134: ldc -47
    //   136: invokespecial 78	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   139: aload_0
    //   140: getfield 43	com/appflood/b/b:b	Ljava/net/URL;
    //   143: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 214	com/appflood/e/j:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   152: aload 4
    //   154: invokestatic 217	com/appflood/e/a:a	(Ljava/io/Closeable;)Z
    //   157: pop
    //   158: aload_3
    //   159: invokestatic 217	com/appflood/e/a:a	(Ljava/io/Closeable;)Z
    //   162: pop
    //   163: iconst_0
    //   164: istore_1
    //   165: iload_1
    //   166: ifeq +88 -> 254
    //   169: aload_0
    //   170: aload_3
    //   171: invokevirtual 220	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   174: putfield 119	com/appflood/b/b:f	[B
    //   177: aload_0
    //   178: iconst_1
    //   179: invokevirtual 222	com/appflood/b/b:a	(Z)V
    //   182: return
    //   183: aload_0
    //   184: getfield 36	com/appflood/b/b:a	Z
    //   187: ifne +22 -> 209
    //   190: aload_3
    //   191: ldc -33
    //   193: invokevirtual 180	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   196: goto -140 -> 56
    //   199: astore_2
    //   200: aload_0
    //   201: iconst_m1
    //   202: invokespecial 225	com/appflood/b/b:a	(I)V
    //   205: return
    //   206: astore_2
    //   207: aload_2
    //   208: athrow
    //   209: aload_3
    //   210: ldc -30
    //   212: invokevirtual 180	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   215: goto -159 -> 56
    //   218: aload_3
    //   219: invokevirtual 193	java/net/HttpURLConnection:getContentLength	()I
    //   222: istore_1
    //   223: goto -134 -> 89
    //   226: aload_2
    //   227: invokestatic 217	com/appflood/e/a:a	(Ljava/io/Closeable;)Z
    //   230: pop
    //   231: aload_3
    //   232: invokestatic 217	com/appflood/e/a:a	(Ljava/io/Closeable;)Z
    //   235: pop
    //   236: iconst_1
    //   237: istore_1
    //   238: goto -73 -> 165
    //   241: aload 4
    //   243: invokestatic 217	com/appflood/e/a:a	(Ljava/io/Closeable;)Z
    //   246: pop
    //   247: aload_3
    //   248: invokestatic 217	com/appflood/e/a:a	(Ljava/io/Closeable;)Z
    //   251: pop
    //   252: aload_2
    //   253: athrow
    //   254: aload_0
    //   255: bipush -2
    //   257: invokespecial 225	com/appflood/b/b:a	(I)V
    //   260: return
    //   261: aload_0
    //   262: iload_1
    //   263: invokespecial 225	com/appflood/b/b:a	(I)V
    //   266: return
    //   267: astore_3
    //   268: aload_2
    //   269: astore 4
    //   271: aload_3
    //   272: astore_2
    //   273: aload 6
    //   275: astore_3
    //   276: goto -35 -> 241
    //   279: astore 5
    //   281: aload_2
    //   282: astore 4
    //   284: aload 5
    //   286: astore_2
    //   287: goto -46 -> 241
    //   290: astore_2
    //   291: goto -50 -> 241
    //   294: astore_2
    //   295: aconst_null
    //   296: astore 4
    //   298: aload 5
    //   300: astore_3
    //   301: goto -172 -> 129
    //   304: astore_3
    //   305: aload_2
    //   306: astore 4
    //   308: aload_3
    //   309: astore_2
    //   310: aload 5
    //   312: astore_3
    //   313: goto -184 -> 129
    //   316: ldc -29
    //   318: istore_1
    //   319: goto -283 -> 36
    //   322: astore_2
    //   323: aconst_null
    //   324: astore 4
    //   326: aload 6
    //   328: astore_3
    //   329: goto -88 -> 241
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	this	b
    //   35	284	1	i	int
    //   76	54	2	localObject1	Object
    //   199	1	2	localThrowable1	Throwable
    //   206	63	2	localCloseable	java.io.Closeable
    //   272	15	2	localObject2	Object
    //   290	1	2	localObject3	Object
    //   294	12	2	localThrowable2	Throwable
    //   309	1	2	localThrowable3	Throwable
    //   322	1	2	localObject4	Object
    //   23	225	3	localObject5	Object
    //   267	5	3	localObject6	Object
    //   275	26	3	localObject7	Object
    //   304	5	3	localThrowable4	Throwable
    //   312	17	3	localObject8	Object
    //   11	314	4	localObject9	Object
    //   4	1	5	localObject10	Object
    //   121	6	5	localThrowable5	Throwable
    //   279	32	5	localObject11	Object
    //   1	326	6	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   98	105	121	java/lang/Throwable
    //   110	118	121	java/lang/Throwable
    //   13	36	199	java/lang/Throwable
    //   36	56	199	java/lang/Throwable
    //   56	65	199	java/lang/Throwable
    //   152	163	199	java/lang/Throwable
    //   169	182	199	java/lang/Throwable
    //   183	196	199	java/lang/Throwable
    //   209	215	199	java/lang/Throwable
    //   226	236	199	java/lang/Throwable
    //   241	254	199	java/lang/Throwable
    //   254	260	199	java/lang/Throwable
    //   261	266	199	java/lang/Throwable
    //   13	36	206	finally
    //   36	56	206	finally
    //   56	65	206	finally
    //   152	163	206	finally
    //   169	182	206	finally
    //   183	196	206	finally
    //   200	205	206	finally
    //   209	215	206	finally
    //   226	236	206	finally
    //   241	254	206	finally
    //   254	260	206	finally
    //   261	266	206	finally
    //   77	85	267	finally
    //   89	98	267	finally
    //   218	223	267	finally
    //   98	105	279	finally
    //   110	118	279	finally
    //   129	152	290	finally
    //   72	77	294	java/lang/Throwable
    //   77	85	304	java/lang/Throwable
    //   89	98	304	java/lang/Throwable
    //   218	223	304	java/lang/Throwable
    //   72	77	322	finally
  }
  
  public static abstract interface a
  {
    public abstract void a(b paramb);
    
    public abstract void a(b paramb, int paramInt);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */