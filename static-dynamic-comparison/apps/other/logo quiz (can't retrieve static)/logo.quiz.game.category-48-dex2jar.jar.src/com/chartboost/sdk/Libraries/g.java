package com.chartboost.sdk.Libraries;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import com.chartboost.sdk.c;
import com.chartboost.sdk.impl.n;
import com.chartboost.sdk.impl.n.b;
import java.io.File;
import org.json.JSONObject;

public final class g
{
  private a a;
  private c b;
  private float c = 1.0F;
  private n.b d = new n.b()
  {
    public void a(g.a paramAnonymousa, Bundle paramAnonymousBundle)
    {
      g.a(g.this, paramAnonymousa);
      g.a(g.this).a(g.this);
    }
  };
  
  public g(c paramc)
  {
    this.b = paramc;
  }
  
  public int a()
  {
    return this.a.d() * a.a(this.a);
  }
  
  public void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    a(this.b.g(), paramString, localBundle);
  }
  
  public void a(JSONObject paramJSONObject, String paramString, Bundle paramBundle)
  {
    paramJSONObject = paramJSONObject.optJSONObject(paramString);
    String str;
    if (paramJSONObject != null)
    {
      this.b.a();
      paramString = paramJSONObject.optString("url");
      str = paramJSONObject.optString("checksum");
      this.c = ((float)paramJSONObject.optDouble("scale", 1.0D));
      if (paramBundle != null) {
        break label81;
      }
    }
    label81:
    for (paramJSONObject = new Bundle();; paramJSONObject = paramBundle)
    {
      n.a().a(paramString, str, this.d, null, paramJSONObject);
      return;
      this.b.a(null);
      return;
    }
  }
  
  public int b()
  {
    return this.a.e() * a.a(this.a);
  }
  
  public void c()
  {
    if (this.a != null) {
      this.a.c();
    }
  }
  
  public boolean d()
  {
    return this.a != null;
  }
  
  public Bitmap e()
  {
    if (this.a != null) {
      return this.a.a();
    }
    return null;
  }
  
  public float f()
  {
    return this.c;
  }
  
  public static class a
  {
    private int a;
    private String b;
    private File c;
    private Bitmap d;
    private int e = -1;
    private int f = -1;
    
    public a(String paramString, File paramFile)
    {
      this.c = paramFile;
      this.b = paramString;
      this.d = null;
      this.a = 1;
    }
    
    private void f()
    {
      if (this.d != null)
      {
        this.e = this.d.getWidth();
        this.f = this.d.getHeight();
        return;
      }
      try
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(this.c.getAbsolutePath(), localOptions);
        this.e = localOptions.outWidth;
        this.f = localOptions.outHeight;
        return;
      }
      catch (Exception localException)
      {
        CBLogging.b("MemoryBitmap", "Error decoding file size", localException);
      }
    }
    
    public Bitmap a()
    {
      if (this.d == null) {
        b();
      }
      return this.d;
    }
    
    /* Error */
    public void b()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 5
      //   3: aconst_null
      //   4: astore 7
      //   6: aload_0
      //   7: getfield 31	com/chartboost/sdk/Libraries/g$a:d	Landroid/graphics/Bitmap;
      //   10: ifnull +4 -> 14
      //   13: return
      //   14: ldc 73
      //   16: new 89	java/lang/StringBuilder
      //   19: dup
      //   20: invokespecial 90	java/lang/StringBuilder:<init>	()V
      //   23: ldc 92
      //   25: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   28: aload_0
      //   29: getfield 29	com/chartboost/sdk/Libraries/g$a:b	Ljava/lang/String;
      //   32: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   35: ldc 98
      //   37: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   40: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   43: invokestatic 104	com/chartboost/sdk/Libraries/CBLogging:a	(Ljava/lang/Object;Ljava/lang/String;)V
      //   46: new 106	java/io/BufferedInputStream
      //   49: dup
      //   50: new 108	java/io/FileInputStream
      //   53: dup
      //   54: aload_0
      //   55: getfield 27	com/chartboost/sdk/Libraries/g$a:c	Ljava/io/File;
      //   58: invokespecial 111	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   61: invokespecial 114	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
      //   64: astore 6
      //   66: aload 7
      //   68: astore 5
      //   70: aload 6
      //   72: astore 4
      //   74: aload_0
      //   75: getfield 27	com/chartboost/sdk/Libraries/g$a:c	Ljava/io/File;
      //   78: invokevirtual 118	java/io/File:length	()J
      //   81: lstore_2
      //   82: lload_2
      //   83: ldc2_w 119
      //   86: lcmp
      //   87: ifle +76 -> 163
      //   90: aload 6
      //   92: astore 4
      //   94: aload 6
      //   96: invokevirtual 123	java/io/BufferedInputStream:close	()V
      //   99: aload 7
      //   101: astore 5
      //   103: aload 6
      //   105: astore 4
      //   107: new 85	java/io/IOException
      //   110: dup
      //   111: ldc 125
      //   113: invokespecial 128	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   116: athrow
      //   117: astore 7
      //   119: aload 6
      //   121: astore 4
      //   123: ldc 73
      //   125: ldc -126
      //   127: aload 7
      //   129: invokestatic 80	com/chartboost/sdk/Libraries/CBLogging:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   132: aload 5
      //   134: astore 4
      //   136: aload 6
      //   138: ifnull +12 -> 150
      //   141: aload 6
      //   143: invokevirtual 123	java/io/BufferedInputStream:close	()V
      //   146: aload 5
      //   148: astore 4
      //   150: aload 4
      //   152: ifnonnull +134 -> 286
      //   155: ldc 73
      //   157: ldc -124
      //   159: invokestatic 134	com/chartboost/sdk/Libraries/CBLogging:b	(Ljava/lang/Object;Ljava/lang/String;)V
      //   162: return
      //   163: lload_2
      //   164: l2i
      //   165: istore_1
      //   166: aload 7
      //   168: astore 5
      //   170: aload 6
      //   172: astore 4
      //   174: iload_1
      //   175: newarray <illegal type>
      //   177: astore 7
      //   179: aload 7
      //   181: astore 5
      //   183: aload 6
      //   185: astore 4
      //   187: aload 6
      //   189: aload 7
      //   191: iconst_0
      //   192: iload_1
      //   193: invokevirtual 138	java/io/BufferedInputStream:read	([BII)I
      //   196: pop
      //   197: aload 7
      //   199: astore 4
      //   201: aload 6
      //   203: ifnull -53 -> 150
      //   206: aload 6
      //   208: invokevirtual 123	java/io/BufferedInputStream:close	()V
      //   211: aload 7
      //   213: astore 4
      //   215: goto -65 -> 150
      //   218: astore 4
      //   220: ldc 73
      //   222: ldc -116
      //   224: aload 4
      //   226: invokestatic 80	com/chartboost/sdk/Libraries/CBLogging:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   229: aload 7
      //   231: astore 4
      //   233: goto -83 -> 150
      //   236: astore 4
      //   238: ldc 73
      //   240: ldc -116
      //   242: aload 4
      //   244: invokestatic 80	com/chartboost/sdk/Libraries/CBLogging:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   247: aload 5
      //   249: astore 4
      //   251: goto -101 -> 150
      //   254: astore 5
      //   256: aconst_null
      //   257: astore 4
      //   259: aload 4
      //   261: ifnull +8 -> 269
      //   264: aload 4
      //   266: invokevirtual 123	java/io/BufferedInputStream:close	()V
      //   269: aload 5
      //   271: athrow
      //   272: astore 4
      //   274: ldc 73
      //   276: ldc -116
      //   278: aload 4
      //   280: invokestatic 80	com/chartboost/sdk/Libraries/CBLogging:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   283: goto -14 -> 269
      //   286: new 48	android/graphics/BitmapFactory$Options
      //   289: dup
      //   290: invokespecial 49	android/graphics/BitmapFactory$Options:<init>	()V
      //   293: astore 5
      //   295: aload 5
      //   297: iconst_1
      //   298: putfield 53	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
      //   301: aload 4
      //   303: iconst_0
      //   304: aload 4
      //   306: arraylength
      //   307: aload 5
      //   309: invokestatic 144	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
      //   312: pop
      //   313: new 48	android/graphics/BitmapFactory$Options
      //   316: dup
      //   317: invokespecial 49	android/graphics/BitmapFactory$Options:<init>	()V
      //   320: astore 5
      //   322: aload 5
      //   324: iconst_0
      //   325: putfield 53	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
      //   328: aload 5
      //   330: iconst_0
      //   331: putfield 147	android/graphics/BitmapFactory$Options:inDither	Z
      //   334: aload 5
      //   336: iconst_1
      //   337: putfield 150	android/graphics/BitmapFactory$Options:inPurgeable	Z
      //   340: aload 5
      //   342: iconst_1
      //   343: putfield 153	android/graphics/BitmapFactory$Options:inInputShareable	Z
      //   346: aload 5
      //   348: ldc -102
      //   350: newarray <illegal type>
      //   352: putfield 158	android/graphics/BitmapFactory$Options:inTempStorage	[B
      //   355: aload 5
      //   357: iconst_1
      //   358: putfield 161	android/graphics/BitmapFactory$Options:inSampleSize	I
      //   361: aload 5
      //   363: getfield 161	android/graphics/BitmapFactory$Options:inSampleSize	I
      //   366: bipush 32
      //   368: if_icmpge +18 -> 386
      //   371: aload_0
      //   372: aload 4
      //   374: iconst_0
      //   375: aload 4
      //   377: arraylength
      //   378: aload 5
      //   380: invokestatic 144	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
      //   383: putfield 31	com/chartboost/sdk/Libraries/g$a:d	Landroid/graphics/Bitmap;
      //   386: aload_0
      //   387: aload 5
      //   389: getfield 161	android/graphics/BitmapFactory$Options:inSampleSize	I
      //   392: putfield 33	com/chartboost/sdk/Libraries/g$a:a	I
      //   395: return
      //   396: astore 6
      //   398: ldc 73
      //   400: ldc -93
      //   402: aload 6
      //   404: invokestatic 80	com/chartboost/sdk/Libraries/CBLogging:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   407: aload 5
      //   409: aload 5
      //   411: getfield 161	android/graphics/BitmapFactory$Options:inSampleSize	I
      //   414: iconst_2
      //   415: imul
      //   416: putfield 161	android/graphics/BitmapFactory$Options:inSampleSize	I
      //   419: goto -58 -> 361
      //   422: astore 4
      //   424: ldc 73
      //   426: ldc -91
      //   428: aload 4
      //   430: invokestatic 80	com/chartboost/sdk/Libraries/CBLogging:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   433: goto -47 -> 386
      //   436: astore 4
      //   438: goto -339 -> 99
      //   441: astore 5
      //   443: goto -184 -> 259
      //   446: astore 7
      //   448: aconst_null
      //   449: astore 6
      //   451: goto -332 -> 119
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	454	0	this	a
      //   165	28	1	i	int
      //   81	83	2	l	long
      //   72	142	4	localObject1	Object
      //   218	7	4	localIOException1	java.io.IOException
      //   231	1	4	arrayOfByte1	byte[]
      //   236	7	4	localIOException2	java.io.IOException
      //   249	16	4	localObject2	Object
      //   272	104	4	localIOException3	java.io.IOException
      //   422	7	4	localException	Exception
      //   436	1	4	localIOException4	java.io.IOException
      //   1	247	5	localObject3	Object
      //   254	16	5	localObject4	Object
      //   293	117	5	localOptions	BitmapFactory.Options
      //   441	1	5	localObject5	Object
      //   64	143	6	localBufferedInputStream	java.io.BufferedInputStream
      //   396	7	6	localOutOfMemoryError	OutOfMemoryError
      //   449	1	6	localObject6	Object
      //   4	96	7	localObject7	Object
      //   117	50	7	localIOException5	java.io.IOException
      //   177	53	7	arrayOfByte2	byte[]
      //   446	1	7	localIOException6	java.io.IOException
      // Exception table:
      //   from	to	target	type
      //   74	82	117	java/io/IOException
      //   107	117	117	java/io/IOException
      //   174	179	117	java/io/IOException
      //   187	197	117	java/io/IOException
      //   206	211	218	java/io/IOException
      //   141	146	236	java/io/IOException
      //   46	66	254	finally
      //   264	269	272	java/io/IOException
      //   371	386	396	java/lang/OutOfMemoryError
      //   371	386	422	java/lang/Exception
      //   94	99	436	java/io/IOException
      //   74	82	441	finally
      //   94	99	441	finally
      //   107	117	441	finally
      //   123	132	441	finally
      //   174	179	441	finally
      //   187	197	441	finally
      //   46	66	446	java/io/IOException
    }
    
    public void c()
    {
      try
      {
        if ((this.d != null) && (!this.d.isRecycled())) {
          this.d.recycle();
        }
        this.d = null;
        return;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
    
    public int d()
    {
      if (this.d != null) {
        return this.d.getWidth();
      }
      if (this.e >= 0) {
        return this.e;
      }
      f();
      return this.e;
    }
    
    public int e()
    {
      if (this.d != null) {
        return this.d.getHeight();
      }
      if (this.f >= 0) {
        return this.f;
      }
      f();
      return this.f;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/chartboost/sdk/Libraries/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */