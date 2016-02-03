package com.badlogic.gdx.backends.android;

import android.content.res.AssetManager;
import com.badlogic.gdx.c.a;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class c
  extends a
{
  final AssetManager a;
  
  c(AssetManager paramAssetManager, String paramString, com.badlogic.gdx.f paramf)
  {
    super(paramString.replace('\\', '/'), paramf);
    this.a = paramAssetManager;
  }
  
  public InputStream a()
  {
    if (this.c == com.badlogic.gdx.f.b) {
      try
      {
        InputStream localInputStream = this.a.open(this.b.getPath());
        return localInputStream;
      }
      catch (IOException localIOException)
      {
        throw new com.badlogic.gdx.utils.f("Error reading file: " + this.b + " (" + this.c + ")", localIOException);
      }
    }
    return super.a();
  }
  
  /* Error */
  public long b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 27	com/badlogic/gdx/backends/android/c:c	Lcom/badlogic/gdx/f;
    //   4: getstatic 32	com/badlogic/gdx/f:b	Lcom/badlogic/gdx/f;
    //   7: if_acmpne +49 -> 56
    //   10: aconst_null
    //   11: astore_3
    //   12: aload_0
    //   13: getfield 19	com/badlogic/gdx/backends/android/c:a	Landroid/content/res/AssetManager;
    //   16: aload_0
    //   17: getfield 35	com/badlogic/gdx/backends/android/c:b	Ljava/io/File;
    //   20: invokevirtual 41	java/io/File:getPath	()Ljava/lang/String;
    //   23: invokevirtual 80	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   26: astore 4
    //   28: aload 4
    //   30: astore_3
    //   31: aload_3
    //   32: invokevirtual 85	android/content/res/AssetFileDescriptor:getLength	()J
    //   35: lstore_1
    //   36: aload_3
    //   37: ifnull +7 -> 44
    //   40: aload_3
    //   41: invokevirtual 88	android/content/res/AssetFileDescriptor:close	()V
    //   44: lload_1
    //   45: lreturn
    //   46: astore 4
    //   48: aload_3
    //   49: ifnull +7 -> 56
    //   52: aload_3
    //   53: invokevirtual 88	android/content/res/AssetFileDescriptor:close	()V
    //   56: aload_0
    //   57: invokespecial 90	com/badlogic/gdx/c/a:b	()J
    //   60: lreturn
    //   61: astore 4
    //   63: aconst_null
    //   64: astore_3
    //   65: aload_3
    //   66: ifnull +7 -> 73
    //   69: aload_3
    //   70: invokevirtual 88	android/content/res/AssetFileDescriptor:close	()V
    //   73: aload 4
    //   75: athrow
    //   76: astore_3
    //   77: lload_1
    //   78: lreturn
    //   79: astore_3
    //   80: goto -24 -> 56
    //   83: astore_3
    //   84: goto -11 -> 73
    //   87: astore 4
    //   89: goto -24 -> 65
    //   92: astore 4
    //   94: goto -46 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	c
    //   35	43	1	l	long
    //   11	59	3	localObject1	Object
    //   76	1	3	localIOException1	IOException
    //   79	1	3	localIOException2	IOException
    //   83	1	3	localIOException3	IOException
    //   26	3	4	localAssetFileDescriptor	android.content.res.AssetFileDescriptor
    //   46	1	4	localIOException4	IOException
    //   61	13	4	localObject2	Object
    //   87	1	4	localObject3	Object
    //   92	1	4	localIOException5	IOException
    // Exception table:
    //   from	to	target	type
    //   12	28	46	java/io/IOException
    //   12	28	61	finally
    //   40	44	76	java/io/IOException
    //   52	56	79	java/io/IOException
    //   69	73	83	java/io/IOException
    //   31	36	87	finally
    //   31	36	92	java/io/IOException
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/badlogic/gdx/backends/android/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */