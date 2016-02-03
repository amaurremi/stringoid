package com.gtp.go.weather.sharephoto;

import android.os.AsyncTask;

class f
  extends AsyncTask
{
  f(PhotoDetailActivity paramPhotoDetailActivity) {}
  
  /* Error */
  protected Boolean a(android.graphics.Bitmap... paramVarArgs)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore 5
    //   6: iconst_0
    //   7: istore_2
    //   8: aload_1
    //   9: iconst_0
    //   10: aaload
    //   11: astore 7
    //   13: new 21	java/io/File
    //   16: dup
    //   17: getstatic 26	com/gtp/go/weather/sharephoto/x:a	Ljava/lang/String;
    //   20: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   23: astore_1
    //   24: aload_1
    //   25: invokevirtual 33	java/io/File:getParentFile	()Ljava/io/File;
    //   28: astore 6
    //   30: aload 6
    //   32: invokevirtual 37	java/io/File:exists	()Z
    //   35: ifne +9 -> 44
    //   38: aload 6
    //   40: invokevirtual 40	java/io/File:mkdirs	()Z
    //   43: pop
    //   44: new 42	java/io/FileOutputStream
    //   47: dup
    //   48: aload_1
    //   49: invokespecial 45	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   52: astore 6
    //   54: aload 6
    //   56: ifnull +19 -> 75
    //   59: aload 6
    //   61: astore_1
    //   62: aload 7
    //   64: getstatic 51	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   67: bipush 100
    //   69: aload 6
    //   71: invokevirtual 57	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   74: istore_2
    //   75: iload_2
    //   76: istore_3
    //   77: aload 6
    //   79: ifnull +10 -> 89
    //   82: aload 6
    //   84: invokevirtual 60	java/io/FileOutputStream:close	()V
    //   87: iload_2
    //   88: istore_3
    //   89: iload_3
    //   90: invokestatic 66	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   93: areturn
    //   94: astore 7
    //   96: aconst_null
    //   97: astore 6
    //   99: aload 6
    //   101: astore_1
    //   102: aload 7
    //   104: invokevirtual 69	java/io/FileNotFoundException:printStackTrace	()V
    //   107: iload 4
    //   109: istore_3
    //   110: aload 6
    //   112: ifnull -23 -> 89
    //   115: aload 6
    //   117: invokevirtual 60	java/io/FileOutputStream:close	()V
    //   120: iload 4
    //   122: istore_3
    //   123: goto -34 -> 89
    //   126: astore_1
    //   127: iload 5
    //   129: istore_2
    //   130: aload_1
    //   131: invokevirtual 70	java/lang/Exception:printStackTrace	()V
    //   134: iload_2
    //   135: istore_3
    //   136: goto -47 -> 89
    //   139: astore 6
    //   141: aconst_null
    //   142: astore_1
    //   143: aload_1
    //   144: ifnull +7 -> 151
    //   147: aload_1
    //   148: invokevirtual 60	java/io/FileOutputStream:close	()V
    //   151: aload 6
    //   153: athrow
    //   154: astore_1
    //   155: aload_1
    //   156: invokevirtual 70	java/lang/Exception:printStackTrace	()V
    //   159: goto -8 -> 151
    //   162: astore_1
    //   163: goto -33 -> 130
    //   166: astore 6
    //   168: goto -25 -> 143
    //   171: astore 7
    //   173: goto -74 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	f
    //   0	176	1	paramVarArgs	android.graphics.Bitmap[]
    //   7	128	2	bool1	boolean
    //   76	60	3	bool2	boolean
    //   1	120	4	bool3	boolean
    //   4	124	5	bool4	boolean
    //   28	88	6	localObject1	Object
    //   139	13	6	localObject2	Object
    //   166	1	6	localObject3	Object
    //   11	52	7	localBitmap	android.graphics.Bitmap
    //   94	9	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   171	1	7	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   44	54	94	java/io/FileNotFoundException
    //   115	120	126	java/lang/Exception
    //   44	54	139	finally
    //   147	151	154	java/lang/Exception
    //   82	87	162	java/lang/Exception
    //   62	75	166	finally
    //   102	107	166	finally
    //   62	75	171	java/io/FileNotFoundException
  }
  
  protected void a(Boolean paramBoolean)
  {
    PhotoDetailActivity.r(this.a);
    if (paramBoolean.booleanValue())
    {
      PhotoDetailActivity.b(this.a, this.a.getString(2131166379));
      PhotoDetailActivity.x(this.a);
      PhotoDetailActivity.a(this.a, PhotoDetailActivity.p(this.a));
      PhotoDetailActivity.b(this.a, PhotoDetailActivity.y(this.a));
      this.a.finish();
      return;
    }
    PhotoDetailActivity.b(this.a, this.a.getString(2131166380));
  }
  
  protected void onPreExecute()
  {
    PhotoDetailActivity.a(this.a, this.a.getString(2131166377), true, false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */