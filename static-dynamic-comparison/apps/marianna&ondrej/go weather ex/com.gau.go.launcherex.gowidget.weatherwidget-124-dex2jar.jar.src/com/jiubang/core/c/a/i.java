package com.jiubang.core.c.a;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import java.io.File;
import java.util.HashMap;

class i
  extends AsyncTask
{
  private i(g paramg) {}
  
  /* Error */
  protected a a(a... paramVarArgs)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_1
    //   3: iconst_0
    //   4: aaload
    //   5: astore 5
    //   7: new 24	java/io/File
    //   10: dup
    //   11: aload 5
    //   13: getfield 30	com/jiubang/core/c/a/a:b	Ljava/lang/String;
    //   16: invokespecial 33	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore_1
    //   20: aload_1
    //   21: invokevirtual 37	java/io/File:exists	()Z
    //   24: ifne +215 -> 239
    //   27: aload_1
    //   28: invokevirtual 40	java/io/File:mkdirs	()Z
    //   31: ifeq +5 -> 36
    //   34: iconst_1
    //   35: istore_2
    //   36: iload_2
    //   37: ifeq +199 -> 236
    //   40: new 42	com/jiubang/goweather/b/e
    //   43: dup
    //   44: aload 5
    //   46: getfield 44	com/jiubang/core/c/a/a:a	Ljava/lang/String;
    //   49: ldc 46
    //   51: invokespecial 49	com/jiubang/goweather/b/e:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: astore_1
    //   55: new 51	com/jiubang/goweather/b/f
    //   58: dup
    //   59: invokespecial 52	com/jiubang/goweather/b/f:<init>	()V
    //   62: astore_3
    //   63: invokestatic 57	com/jiubang/goweather/b/d:a	()Lcom/jiubang/goweather/b/c;
    //   66: astore 6
    //   68: aload 6
    //   70: aload_3
    //   71: aload_0
    //   72: getfield 10	com/jiubang/core/c/a/i:a	Lcom/jiubang/core/c/a/g;
    //   75: invokestatic 62	com/jiubang/core/c/a/g:a	(Lcom/jiubang/core/c/a/g;)Landroid/content/Context;
    //   78: invokevirtual 67	com/jiubang/goweather/b/c:a	(Lcom/jiubang/goweather/b/f;Landroid/content/Context;)Z
    //   81: ifeq +150 -> 231
    //   84: aload 6
    //   86: aload 5
    //   88: getfield 44	com/jiubang/core/c/a/a:a	Ljava/lang/String;
    //   91: aload_1
    //   92: aload_3
    //   93: invokevirtual 70	com/jiubang/goweather/b/c:a	(Ljava/lang/String;Lcom/jiubang/goweather/b/e;Lcom/jiubang/goweather/b/f;)Ljava/io/InputStream;
    //   96: astore 7
    //   98: aload 7
    //   100: ifnull +131 -> 231
    //   103: aconst_null
    //   104: astore_3
    //   105: aconst_null
    //   106: astore 4
    //   108: new 72	java/io/FileOutputStream
    //   111: dup
    //   112: new 24	java/io/File
    //   115: dup
    //   116: aload 5
    //   118: getfield 30	com/jiubang/core/c/a/a:b	Ljava/lang/String;
    //   121: aload 5
    //   123: getfield 75	com/jiubang/core/c/a/a:c	Ljava/lang/String;
    //   126: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: invokespecial 79	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   132: astore_1
    //   133: aload_1
    //   134: astore_3
    //   135: sipush 1024
    //   138: newarray <illegal type>
    //   140: astore 4
    //   142: aload_1
    //   143: astore_3
    //   144: aload 7
    //   146: aload 4
    //   148: iconst_0
    //   149: sipush 1024
    //   152: invokevirtual 85	java/io/InputStream:read	([BII)I
    //   155: istore_2
    //   156: iload_2
    //   157: iconst_m1
    //   158: if_icmpeq +86 -> 244
    //   161: aload_1
    //   162: astore_3
    //   163: aload_1
    //   164: aload 4
    //   166: iconst_0
    //   167: iload_2
    //   168: invokevirtual 89	java/io/FileOutputStream:write	([BII)V
    //   171: goto -29 -> 142
    //   174: astore 4
    //   176: aload_1
    //   177: astore_3
    //   178: aload 4
    //   180: invokevirtual 92	java/io/FileNotFoundException:printStackTrace	()V
    //   183: aload 5
    //   185: getfield 96	com/jiubang/core/c/a/a:f	I
    //   188: iconst_1
    //   189: if_icmpeq +24 -> 213
    //   192: new 24	java/io/File
    //   195: dup
    //   196: aload 5
    //   198: getfield 30	com/jiubang/core/c/a/a:b	Ljava/lang/String;
    //   201: aload 5
    //   203: getfield 75	com/jiubang/core/c/a/a:c	Ljava/lang/String;
    //   206: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   209: invokevirtual 99	java/io/File:delete	()Z
    //   212: pop
    //   213: aload_1
    //   214: ifnull +7 -> 221
    //   217: aload_1
    //   218: invokevirtual 102	java/io/FileOutputStream:close	()V
    //   221: aload 7
    //   223: ifnull +8 -> 231
    //   226: aload 7
    //   228: invokevirtual 103	java/io/InputStream:close	()V
    //   231: aload 6
    //   233: invokevirtual 105	com/jiubang/goweather/b/c:a	()V
    //   236: aload 5
    //   238: areturn
    //   239: iconst_1
    //   240: istore_2
    //   241: goto -205 -> 36
    //   244: aload_1
    //   245: astore_3
    //   246: aload 5
    //   248: iconst_1
    //   249: putfield 96	com/jiubang/core/c/a/a:f	I
    //   252: aload 5
    //   254: getfield 96	com/jiubang/core/c/a/a:f	I
    //   257: iconst_1
    //   258: if_icmpeq +24 -> 282
    //   261: new 24	java/io/File
    //   264: dup
    //   265: aload 5
    //   267: getfield 30	com/jiubang/core/c/a/a:b	Ljava/lang/String;
    //   270: aload 5
    //   272: getfield 75	com/jiubang/core/c/a/a:c	Ljava/lang/String;
    //   275: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   278: invokevirtual 99	java/io/File:delete	()Z
    //   281: pop
    //   282: aload_1
    //   283: ifnull +7 -> 290
    //   286: aload_1
    //   287: invokevirtual 102	java/io/FileOutputStream:close	()V
    //   290: aload 7
    //   292: ifnull -61 -> 231
    //   295: aload 7
    //   297: invokevirtual 103	java/io/InputStream:close	()V
    //   300: goto -69 -> 231
    //   303: astore_1
    //   304: aload_1
    //   305: invokevirtual 106	java/lang/Exception:printStackTrace	()V
    //   308: goto -77 -> 231
    //   311: astore_3
    //   312: aload 4
    //   314: astore_1
    //   315: aload_3
    //   316: astore 4
    //   318: aload_1
    //   319: astore_3
    //   320: aload 4
    //   322: invokevirtual 106	java/lang/Exception:printStackTrace	()V
    //   325: aload 5
    //   327: getfield 96	com/jiubang/core/c/a/a:f	I
    //   330: iconst_1
    //   331: if_icmpeq +24 -> 355
    //   334: new 24	java/io/File
    //   337: dup
    //   338: aload 5
    //   340: getfield 30	com/jiubang/core/c/a/a:b	Ljava/lang/String;
    //   343: aload 5
    //   345: getfield 75	com/jiubang/core/c/a/a:c	Ljava/lang/String;
    //   348: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   351: invokevirtual 99	java/io/File:delete	()Z
    //   354: pop
    //   355: aload_1
    //   356: ifnull +7 -> 363
    //   359: aload_1
    //   360: invokevirtual 102	java/io/FileOutputStream:close	()V
    //   363: aload 7
    //   365: ifnull -134 -> 231
    //   368: aload 7
    //   370: invokevirtual 103	java/io/InputStream:close	()V
    //   373: goto -142 -> 231
    //   376: astore_1
    //   377: goto -73 -> 304
    //   380: astore_1
    //   381: aload 5
    //   383: getfield 96	com/jiubang/core/c/a/a:f	I
    //   386: iconst_1
    //   387: if_icmpeq +24 -> 411
    //   390: new 24	java/io/File
    //   393: dup
    //   394: aload 5
    //   396: getfield 30	com/jiubang/core/c/a/a:b	Ljava/lang/String;
    //   399: aload 5
    //   401: getfield 75	com/jiubang/core/c/a/a:c	Ljava/lang/String;
    //   404: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   407: invokevirtual 99	java/io/File:delete	()Z
    //   410: pop
    //   411: aload_3
    //   412: ifnull +7 -> 419
    //   415: aload_3
    //   416: invokevirtual 102	java/io/FileOutputStream:close	()V
    //   419: aload 7
    //   421: ifnull +8 -> 429
    //   424: aload 7
    //   426: invokevirtual 103	java/io/InputStream:close	()V
    //   429: aload_1
    //   430: athrow
    //   431: astore_3
    //   432: aload_3
    //   433: invokevirtual 106	java/lang/Exception:printStackTrace	()V
    //   436: goto -17 -> 419
    //   439: astore_3
    //   440: aload_3
    //   441: invokevirtual 106	java/lang/Exception:printStackTrace	()V
    //   444: goto -15 -> 429
    //   447: astore_1
    //   448: aload_1
    //   449: invokevirtual 106	java/lang/Exception:printStackTrace	()V
    //   452: goto -231 -> 221
    //   455: astore_1
    //   456: goto -152 -> 304
    //   459: astore_1
    //   460: aload_1
    //   461: invokevirtual 106	java/lang/Exception:printStackTrace	()V
    //   464: goto -101 -> 363
    //   467: astore_1
    //   468: aload_1
    //   469: invokevirtual 106	java/lang/Exception:printStackTrace	()V
    //   472: goto -182 -> 290
    //   475: astore_1
    //   476: goto -95 -> 381
    //   479: astore 4
    //   481: goto -163 -> 318
    //   484: astore 4
    //   486: aconst_null
    //   487: astore_1
    //   488: goto -312 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	491	0	this	i
    //   0	491	1	paramVarArgs	a[]
    //   1	240	2	i	int
    //   62	184	3	localObject	Object
    //   311	5	3	localException1	Exception
    //   319	97	3	arrayOfa	a[]
    //   431	2	3	localException2	Exception
    //   439	2	3	localException3	Exception
    //   106	59	4	arrayOfByte	byte[]
    //   174	139	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   316	5	4	localException4	Exception
    //   479	1	4	localException5	Exception
    //   484	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   5	395	5	locala	a
    //   66	166	6	localc	com.jiubang.goweather.b.c
    //   96	329	7	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   135	142	174	java/io/FileNotFoundException
    //   144	156	174	java/io/FileNotFoundException
    //   163	171	174	java/io/FileNotFoundException
    //   246	252	174	java/io/FileNotFoundException
    //   295	300	303	java/lang/Exception
    //   108	133	311	java/lang/Exception
    //   368	373	376	java/lang/Exception
    //   108	133	380	finally
    //   320	325	380	finally
    //   415	419	431	java/lang/Exception
    //   424	429	439	java/lang/Exception
    //   217	221	447	java/lang/Exception
    //   226	231	455	java/lang/Exception
    //   359	363	459	java/lang/Exception
    //   286	290	467	java/lang/Exception
    //   135	142	475	finally
    //   144	156	475	finally
    //   163	171	475	finally
    //   178	183	475	finally
    //   246	252	475	finally
    //   135	142	479	java/lang/Exception
    //   144	156	479	java/lang/Exception
    //   163	171	479	java/lang/Exception
    //   246	252	479	java/lang/Exception
    //   108	133	484	java/io/FileNotFoundException
  }
  
  protected void a(a parama)
  {
    g.b(this.a).remove(parama.a);
    if (parama.f == 1)
    {
      Intent localIntent = new Intent("com.gau.go.launcherex.gowidget.weatherwidget.ACTION_DOWNLOAD_PHOTO");
      localIntent.putExtra("extra_photo_path", parama.b + File.separator + parama.c);
      localIntent.putExtra("extra_photo_url", parama.a);
      g.a(this.a).sendBroadcast(localIntent);
    }
    g.c(this.a);
    g.d(this.a);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/jiubang/core/c/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */