package com.gtp.go.weather.sharephoto;

import android.os.AsyncTask;
import android.widget.Toast;
import com.gtp.a.a.c.c;
import java.io.File;

class k
  extends AsyncTask
{
  k(PhotoDetailActivity paramPhotoDetailActivity) {}
  
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
    //   17: invokestatic 26	com/gtp/go/weather/sharephoto/PhotoDetailActivity:a	()Ljava/lang/String;
    //   20: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   23: astore_1
    //   24: aload_1
    //   25: invokevirtual 33	java/io/File:exists	()Z
    //   28: ifeq +58 -> 86
    //   31: aload_1
    //   32: invokevirtual 36	java/io/File:delete	()Z
    //   35: pop
    //   36: new 38	java/io/FileOutputStream
    //   39: dup
    //   40: aload_1
    //   41: invokespecial 41	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   44: astore 6
    //   46: aload 6
    //   48: ifnull +19 -> 67
    //   51: aload 6
    //   53: astore_1
    //   54: aload 7
    //   56: getstatic 47	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   59: bipush 100
    //   61: aload 6
    //   63: invokevirtual 53	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   66: istore_2
    //   67: iload_2
    //   68: istore_3
    //   69: aload 6
    //   71: ifnull +10 -> 81
    //   74: aload 6
    //   76: invokevirtual 56	java/io/FileOutputStream:close	()V
    //   79: iload_2
    //   80: istore_3
    //   81: iload_3
    //   82: invokestatic 62	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   85: areturn
    //   86: aload_1
    //   87: invokevirtual 66	java/io/File:getParentFile	()Ljava/io/File;
    //   90: astore 6
    //   92: aload 6
    //   94: invokevirtual 33	java/io/File:exists	()Z
    //   97: ifne -61 -> 36
    //   100: aload 6
    //   102: invokevirtual 69	java/io/File:mkdirs	()Z
    //   105: pop
    //   106: goto -70 -> 36
    //   109: astore 7
    //   111: aconst_null
    //   112: astore 6
    //   114: aload 6
    //   116: astore_1
    //   117: aload 7
    //   119: invokevirtual 72	java/io/FileNotFoundException:printStackTrace	()V
    //   122: iload 4
    //   124: istore_3
    //   125: aload 6
    //   127: ifnull -46 -> 81
    //   130: aload 6
    //   132: invokevirtual 56	java/io/FileOutputStream:close	()V
    //   135: iload 4
    //   137: istore_3
    //   138: goto -57 -> 81
    //   141: astore_1
    //   142: iload 5
    //   144: istore_2
    //   145: aload_1
    //   146: invokevirtual 73	java/lang/Exception:printStackTrace	()V
    //   149: iload_2
    //   150: istore_3
    //   151: goto -70 -> 81
    //   154: astore 6
    //   156: aconst_null
    //   157: astore_1
    //   158: aload_1
    //   159: ifnull +7 -> 166
    //   162: aload_1
    //   163: invokevirtual 56	java/io/FileOutputStream:close	()V
    //   166: aload 6
    //   168: athrow
    //   169: astore_1
    //   170: aload_1
    //   171: invokevirtual 73	java/lang/Exception:printStackTrace	()V
    //   174: goto -8 -> 166
    //   177: astore_1
    //   178: goto -33 -> 145
    //   181: astore 6
    //   183: goto -25 -> 158
    //   186: astore 7
    //   188: goto -74 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	k
    //   0	191	1	paramVarArgs	android.graphics.Bitmap[]
    //   7	143	2	bool1	boolean
    //   68	83	3	bool2	boolean
    //   1	135	4	bool3	boolean
    //   4	139	5	bool4	boolean
    //   44	87	6	localObject1	Object
    //   154	13	6	localObject2	Object
    //   181	1	6	localObject3	Object
    //   11	44	7	localBitmap	android.graphics.Bitmap
    //   109	9	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   186	1	7	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   36	46	109	java/io/FileNotFoundException
    //   130	135	141	java/lang/Exception
    //   36	46	154	finally
    //   162	166	169	java/lang/Exception
    //   74	79	177	java/lang/Exception
    //   54	67	181	finally
    //   117	122	181	finally
    //   54	67	186	java/io/FileNotFoundException
  }
  
  protected void a(Boolean paramBoolean)
  {
    PhotoDetailActivity.r(this.a);
    if (paramBoolean.booleanValue())
    {
      PhotoDetailActivity.a(this.a, new File(PhotoDetailActivity.a()));
      return;
    }
    Toast.makeText(this.a.getApplicationContext(), 2131166365, 0).show();
  }
  
  protected void onPreExecute()
  {
    if (c.b()) {
      PhotoDetailActivity.a(this.a, "", true, false);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gtp/go/weather/sharephoto/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */