package com.gtp.go.weather.sharephoto.photo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.gtp.a.a.c.a;
import com.gtp.go.weather.sharephoto.takephoto.ab;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.HashMap;

public class b
{
  private HashMap a = new HashMap();
  private int b = 1;
  
  public static Drawable a(Context paramContext, String paramString, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    File localFile;
    if (paramContext != null)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramString))
      {
        localFile = new File(paramString);
        localObject1 = localObject2;
        if (localFile != null)
        {
          localObject1 = localObject2;
          if (!localFile.exists()) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
        ((BitmapFactory.Options)localObject1).inSampleSize = paramInt;
        if ((a.a() != 1) && (ab.a(localFile) != Bitmap.CompressFormat.PNG)) {
          ((BitmapFactory.Options)localObject1).inPreferredConfig = Bitmap.Config.RGB_565;
        }
        paramString = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject1);
        if (paramString == null) {
          break label135;
        }
        paramContext = new BitmapDrawable(paramContext.getResources(), paramString);
        localObject1 = paramContext;
      }
      catch (OutOfMemoryError paramContext)
      {
        localObject1 = localObject2;
        if (!com.gtp.a.a.b.c.a()) {
          continue;
        }
        paramContext.printStackTrace();
        return null;
      }
      return (Drawable)localObject1;
      label135:
      paramContext = null;
    }
  }
  
  /* Error */
  public static Drawable b(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 7
    //   9: aload 6
    //   11: astore 4
    //   13: aload_0
    //   14: ifnull +108 -> 122
    //   17: aload 6
    //   19: astore 4
    //   21: aload_1
    //   22: invokestatic 29	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   25: ifne +97 -> 122
    //   28: aload_0
    //   29: invokevirtual 105	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   32: aload_1
    //   33: invokevirtual 111	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   36: astore_1
    //   37: aload 7
    //   39: astore_3
    //   40: aload_1
    //   41: ifnull +67 -> 108
    //   44: aload_1
    //   45: astore_3
    //   46: new 40	android/graphics/BitmapFactory$Options
    //   49: dup
    //   50: invokespecial 41	android/graphics/BitmapFactory$Options:<init>	()V
    //   53: astore 4
    //   55: aload_1
    //   56: astore_3
    //   57: aload 4
    //   59: iconst_0
    //   60: putfield 45	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   63: aload_1
    //   64: astore_3
    //   65: aload 4
    //   67: iload_2
    //   68: putfield 48	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   71: aload_1
    //   72: astore_3
    //   73: aload_1
    //   74: aconst_null
    //   75: aload 4
    //   77: invokestatic 115	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   80: astore 4
    //   82: aload 7
    //   84: astore_3
    //   85: aload 4
    //   87: ifnull +21 -> 108
    //   90: aload_1
    //   91: astore_3
    //   92: new 81	android/graphics/drawable/BitmapDrawable
    //   95: dup
    //   96: aload_0
    //   97: invokevirtual 87	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   100: aload 4
    //   102: invokespecial 90	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   105: astore_0
    //   106: aload_0
    //   107: astore_3
    //   108: aload_3
    //   109: astore 4
    //   111: aload_1
    //   112: ifnull +10 -> 122
    //   115: aload_1
    //   116: invokevirtual 120	java/io/InputStream:close	()V
    //   119: aload_3
    //   120: astore 4
    //   122: aload 4
    //   124: areturn
    //   125: astore_0
    //   126: aconst_null
    //   127: astore_1
    //   128: aload_1
    //   129: astore_3
    //   130: invokestatic 94	com/gtp/a/a/b/c:a	()Z
    //   133: ifeq +9 -> 142
    //   136: aload_1
    //   137: astore_3
    //   138: aload_0
    //   139: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   142: aload 6
    //   144: astore 4
    //   146: aload_1
    //   147: ifnull -25 -> 122
    //   150: aload_1
    //   151: invokevirtual 120	java/io/InputStream:close	()V
    //   154: aconst_null
    //   155: areturn
    //   156: astore_0
    //   157: aload 6
    //   159: astore 4
    //   161: invokestatic 94	com/gtp/a/a/b/c:a	()Z
    //   164: ifeq -42 -> 122
    //   167: aload 5
    //   169: astore_3
    //   170: aload_0
    //   171: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   174: aload_3
    //   175: areturn
    //   176: astore_0
    //   177: aconst_null
    //   178: astore_1
    //   179: aload_1
    //   180: astore_3
    //   181: invokestatic 94	com/gtp/a/a/b/c:a	()Z
    //   184: ifeq +9 -> 193
    //   187: aload_1
    //   188: astore_3
    //   189: aload_0
    //   190: invokevirtual 97	java/lang/OutOfMemoryError:printStackTrace	()V
    //   193: aload 6
    //   195: astore 4
    //   197: aload_1
    //   198: ifnull -76 -> 122
    //   201: aload_1
    //   202: invokevirtual 120	java/io/InputStream:close	()V
    //   205: aconst_null
    //   206: areturn
    //   207: astore_0
    //   208: aload 6
    //   210: astore 4
    //   212: invokestatic 94	com/gtp/a/a/b/c:a	()Z
    //   215: ifeq -93 -> 122
    //   218: aload 5
    //   220: astore_3
    //   221: goto -51 -> 170
    //   224: astore_0
    //   225: aconst_null
    //   226: astore_3
    //   227: aload_3
    //   228: ifnull +7 -> 235
    //   231: aload_3
    //   232: invokevirtual 120	java/io/InputStream:close	()V
    //   235: aload_0
    //   236: athrow
    //   237: astore_1
    //   238: invokestatic 94	com/gtp/a/a/b/c:a	()Z
    //   241: ifeq -6 -> 235
    //   244: aload_1
    //   245: invokevirtual 121	java/io/IOException:printStackTrace	()V
    //   248: goto -13 -> 235
    //   251: astore_0
    //   252: aload_3
    //   253: astore 4
    //   255: invokestatic 94	com/gtp/a/a/b/c:a	()Z
    //   258: ifeq -136 -> 122
    //   261: goto -91 -> 170
    //   264: astore_0
    //   265: goto -38 -> 227
    //   268: astore_0
    //   269: goto -90 -> 179
    //   272: astore_0
    //   273: goto -145 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	paramContext	Context
    //   0	276	1	paramString	String
    //   0	276	2	paramInt	int
    //   39	214	3	localObject1	Object
    //   11	243	4	localObject2	Object
    //   4	215	5	localObject3	Object
    //   1	208	6	localObject4	Object
    //   7	76	7	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   28	37	125	java/io/IOException
    //   150	154	156	java/io/IOException
    //   28	37	176	java/lang/OutOfMemoryError
    //   201	205	207	java/io/IOException
    //   28	37	224	finally
    //   231	235	237	java/io/IOException
    //   115	119	251	java/io/IOException
    //   46	55	264	finally
    //   57	63	264	finally
    //   65	71	264	finally
    //   73	82	264	finally
    //   92	106	264	finally
    //   130	136	264	finally
    //   138	142	264	finally
    //   181	187	264	finally
    //   189	193	264	finally
    //   46	55	268	java/lang/OutOfMemoryError
    //   57	63	268	java/lang/OutOfMemoryError
    //   65	71	268	java/lang/OutOfMemoryError
    //   73	82	268	java/lang/OutOfMemoryError
    //   92	106	268	java/lang/OutOfMemoryError
    //   46	55	272	java/io/IOException
    //   57	63	272	java/io/IOException
    //   65	71	272	java/io/IOException
    //   73	82	272	java/io/IOException
    //   92	106	272	java/io/IOException
  }
  
  public Drawable a(Context paramContext, String paramString1, String paramString2, String paramString3, e parame)
  {
    return a(paramContext, false, paramString1, paramString2, paramString3, parame);
  }
  
  @SuppressLint({"HandlerLeak"})
  public Drawable a(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, String paramString3, e parame)
  {
    if (this.a.containsKey(paramString1))
    {
      Drawable localDrawable = (Drawable)((SoftReference)this.a.get(paramString1)).get();
      if (localDrawable != null) {
        return localDrawable;
      }
    }
    new d(this, paramBoolean, paramContext, paramString1, new c(this, paramString1, parame, paramString2, paramString3)).start();
    return null;
  }
  
  public HashMap a()
  {
    return this.a;
  }
  
  public void b()
  {
    if (this.a != null) {
      this.a.clear();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/photo/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */