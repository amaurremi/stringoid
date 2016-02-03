package com.venticake.retrica;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import com.venticake.retrica.engine.RetricaEngine.BitmapApplyProgressCallback;

class m
  extends AsyncTask<Object, Integer, Boolean>
{
  Uri a = null;
  
  private m(MainActivity paramMainActivity) {}
  
  /* Error */
  protected Boolean a(Object... paramVarArgs)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 36	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   9: aload_1
    //   10: iconst_0
    //   11: aaload
    //   12: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   15: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   18: invokestatic 51	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   21: istore_3
    //   22: aload_0
    //   23: iconst_1
    //   24: anewarray 47	java/lang/Integer
    //   27: dup
    //   28: iconst_0
    //   29: bipush 10
    //   31: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   34: aastore
    //   35: invokevirtual 29	com/venticake/retrica/m:publishProgress	([Ljava/lang/Object;)V
    //   38: aload_1
    //   39: iconst_2
    //   40: aaload
    //   41: checkcast 57	[B
    //   44: iconst_0
    //   45: aload_1
    //   46: iconst_2
    //   47: aaload
    //   48: checkcast 57	[B
    //   51: arraylength
    //   52: invokestatic 63	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   55: astore 6
    //   57: aload_0
    //   58: iconst_1
    //   59: anewarray 47	java/lang/Integer
    //   62: dup
    //   63: iconst_0
    //   64: bipush 30
    //   66: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   69: aastore
    //   70: invokevirtual 29	com/venticake/retrica/m:publishProgress	([Ljava/lang/Object;)V
    //   73: new 65	com/venticake/retrica/engine/RetricaEngine
    //   76: dup
    //   77: getstatic 70	com/venticake/retrica/MainActivity:a	Landroid/content/Context;
    //   80: aload_0
    //   81: getfield 15	com/venticake/retrica/m:b	Lcom/venticake/retrica/MainActivity;
    //   84: getfield 74	com/venticake/retrica/MainActivity:n	Lcom/venticake/retrica/engine/RetricaEngine;
    //   87: invokevirtual 78	com/venticake/retrica/engine/RetricaEngine:getCurrentLens	()Lcom/venticake/retrica/engine/a/g;
    //   90: getstatic 70	com/venticake/retrica/MainActivity:a	Landroid/content/Context;
    //   93: invokevirtual 83	com/venticake/retrica/engine/a/g:a	(Landroid/content/Context;)Lcom/venticake/retrica/engine/a/g;
    //   96: iconst_1
    //   97: invokespecial 86	com/venticake/retrica/engine/RetricaEngine:<init>	(Landroid/content/Context;Lcom/venticake/retrica/engine/a/g;Z)V
    //   100: astore 7
    //   102: aload 7
    //   104: invokevirtual 78	com/venticake/retrica/engine/RetricaEngine:getCurrentLens	()Lcom/venticake/retrica/engine/a/g;
    //   107: astore 8
    //   109: aload 8
    //   111: iconst_1
    //   112: invokevirtual 89	com/venticake/retrica/engine/a/g:a	(Z)V
    //   115: aload 7
    //   117: iload_3
    //   118: aload_0
    //   119: getfield 15	com/venticake/retrica/m:b	Lcom/venticake/retrica/MainActivity;
    //   122: invokevirtual 93	com/venticake/retrica/MainActivity:p	()Z
    //   125: invokestatic 98	com/venticake/retrica/setting/a:a	()Lcom/venticake/retrica/setting/a;
    //   128: invokevirtual 101	com/venticake/retrica/setting/a:r	()Z
    //   131: invokevirtual 105	com/venticake/retrica/engine/RetricaEngine:setOrientation	(IZZ)V
    //   134: aload 7
    //   136: new 7	com/venticake/retrica/m$1
    //   139: dup
    //   140: aload_0
    //   141: invokespecial 108	com/venticake/retrica/m$1:<init>	(Lcom/venticake/retrica/m;)V
    //   144: invokevirtual 112	com/venticake/retrica/engine/RetricaEngine:setBitmapApplyProgressCallback	(Lcom/venticake/retrica/engine/RetricaEngine$BitmapApplyProgressCallback;)V
    //   147: aload_0
    //   148: getfield 15	com/venticake/retrica/m:b	Lcom/venticake/retrica/MainActivity;
    //   151: invokestatic 115	com/venticake/retrica/MainActivity:b	(Lcom/venticake/retrica/MainActivity;)Lcom/venticake/retrica/h;
    //   154: aload_0
    //   155: getfield 15	com/venticake/retrica/m:b	Lcom/venticake/retrica/MainActivity;
    //   158: getfield 119	com/venticake/retrica/MainActivity:f	I
    //   161: aload 6
    //   163: invokevirtual 125	android/graphics/Bitmap:getWidth	()I
    //   166: aload 6
    //   168: invokevirtual 128	android/graphics/Bitmap:getHeight	()I
    //   171: invokevirtual 133	com/venticake/retrica/h:a	(III)V
    //   174: aload 8
    //   176: aload_0
    //   177: getfield 15	com/venticake/retrica/m:b	Lcom/venticake/retrica/MainActivity;
    //   180: invokestatic 115	com/venticake/retrica/MainActivity:b	(Lcom/venticake/retrica/MainActivity;)Lcom/venticake/retrica/h;
    //   183: invokevirtual 137	com/venticake/retrica/h:d	()[F
    //   186: invokevirtual 140	com/venticake/retrica/engine/a/g:a	([F)V
    //   189: aload_0
    //   190: getfield 15	com/venticake/retrica/m:b	Lcom/venticake/retrica/MainActivity;
    //   193: invokestatic 115	com/venticake/retrica/MainActivity:b	(Lcom/venticake/retrica/MainActivity;)Lcom/venticake/retrica/h;
    //   196: invokevirtual 143	com/venticake/retrica/h:e	()I
    //   199: istore 4
    //   201: aload_0
    //   202: getfield 15	com/venticake/retrica/m:b	Lcom/venticake/retrica/MainActivity;
    //   205: invokestatic 115	com/venticake/retrica/MainActivity:b	(Lcom/venticake/retrica/MainActivity;)Lcom/venticake/retrica/h;
    //   208: invokevirtual 145	com/venticake/retrica/h:f	()I
    //   211: istore 5
    //   213: ldc -109
    //   215: new 36	java/lang/StringBuilder
    //   218: dup
    //   219: ldc -107
    //   221: invokespecial 152	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   224: aload 6
    //   226: invokevirtual 125	android/graphics/Bitmap:getWidth	()I
    //   229: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   232: ldc -99
    //   234: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload 6
    //   239: invokevirtual 128	android/graphics/Bitmap:getHeight	()I
    //   242: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   245: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 165	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   251: pop
    //   252: ldc -109
    //   254: new 36	java/lang/StringBuilder
    //   257: dup
    //   258: ldc -89
    //   260: invokespecial 152	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   263: iload_3
    //   264: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   267: ldc -87
    //   269: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: iload_3
    //   273: invokestatic 174	com/venticake/retrica/f:a	(I)Ljava/lang/String;
    //   276: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: ldc -80
    //   281: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: ldc -78
    //   286: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: aload_0
    //   290: getfield 15	com/venticake/retrica/m:b	Lcom/venticake/retrica/MainActivity;
    //   293: invokevirtual 93	com/venticake/retrica/MainActivity:p	()Z
    //   296: invokevirtual 181	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   299: ldc -73
    //   301: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: invokestatic 98	com/venticake/retrica/setting/a:a	()Lcom/venticake/retrica/setting/a;
    //   307: invokevirtual 101	com/venticake/retrica/setting/a:r	()Z
    //   310: invokevirtual 181	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   313: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 165	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   319: pop
    //   320: ldc -109
    //   322: new 36	java/lang/StringBuilder
    //   325: dup
    //   326: ldc -71
    //   328: invokespecial 152	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   331: iload 4
    //   333: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   336: ldc -99
    //   338: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: iload 5
    //   343: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   346: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokestatic 165	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   352: pop
    //   353: aload 8
    //   355: iconst_1
    //   356: invokevirtual 187	com/venticake/retrica/engine/a/g:b	(Z)V
    //   359: aload 8
    //   361: iload_3
    //   362: aload_0
    //   363: getfield 15	com/venticake/retrica/m:b	Lcom/venticake/retrica/MainActivity;
    //   366: invokevirtual 93	com/venticake/retrica/MainActivity:p	()Z
    //   369: invokestatic 98	com/venticake/retrica/setting/a:a	()Lcom/venticake/retrica/setting/a;
    //   372: invokevirtual 101	com/venticake/retrica/setting/a:r	()Z
    //   375: aload_0
    //   376: getfield 15	com/venticake/retrica/m:b	Lcom/venticake/retrica/MainActivity;
    //   379: invokestatic 191	com/venticake/retrica/MainActivity:c	(Lcom/venticake/retrica/MainActivity;)Lcom/venticake/retrica/view/RetricaGLSurfaceView;
    //   382: invokevirtual 197	com/venticake/retrica/view/RetricaGLSurfaceView:eventDispatcher	()Lcom/venticake/retrica/view/RetricaBlurTouchEventDispatcher;
    //   385: invokevirtual 203	com/venticake/retrica/view/RetricaBlurTouchEventDispatcher:getCenterX	()F
    //   388: aload_0
    //   389: getfield 15	com/venticake/retrica/m:b	Lcom/venticake/retrica/MainActivity;
    //   392: invokestatic 191	com/venticake/retrica/MainActivity:c	(Lcom/venticake/retrica/MainActivity;)Lcom/venticake/retrica/view/RetricaGLSurfaceView;
    //   395: invokevirtual 197	com/venticake/retrica/view/RetricaGLSurfaceView:eventDispatcher	()Lcom/venticake/retrica/view/RetricaBlurTouchEventDispatcher;
    //   398: invokevirtual 206	com/venticake/retrica/view/RetricaBlurTouchEventDispatcher:getCenterY	()F
    //   401: aload_0
    //   402: getfield 15	com/venticake/retrica/m:b	Lcom/venticake/retrica/MainActivity;
    //   405: invokestatic 191	com/venticake/retrica/MainActivity:c	(Lcom/venticake/retrica/MainActivity;)Lcom/venticake/retrica/view/RetricaGLSurfaceView;
    //   408: invokevirtual 197	com/venticake/retrica/view/RetricaGLSurfaceView:eventDispatcher	()Lcom/venticake/retrica/view/RetricaBlurTouchEventDispatcher;
    //   411: invokevirtual 209	com/venticake/retrica/view/RetricaBlurTouchEventDispatcher:getRadius	()F
    //   414: invokevirtual 212	com/venticake/retrica/engine/a/g:a	(IZZFFF)V
    //   417: aload_0
    //   418: iconst_1
    //   419: anewarray 47	java/lang/Integer
    //   422: dup
    //   423: iconst_0
    //   424: bipush 40
    //   426: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   429: aastore
    //   430: invokevirtual 29	com/venticake/retrica/m:publishProgress	([Ljava/lang/Object;)V
    //   433: aload 7
    //   435: aload 6
    //   437: iload 4
    //   439: iload 5
    //   441: iconst_1
    //   442: invokevirtual 216	com/venticake/retrica/engine/RetricaEngine:getBitmapWithFilterApplied	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   445: astore 7
    //   447: aload 6
    //   449: invokevirtual 219	android/graphics/Bitmap:recycle	()V
    //   452: aload 8
    //   454: iconst_1
    //   455: invokevirtual 187	com/venticake/retrica/engine/a/g:b	(Z)V
    //   458: aload_0
    //   459: iconst_1
    //   460: anewarray 47	java/lang/Integer
    //   463: dup
    //   464: iconst_0
    //   465: bipush 60
    //   467: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   470: aastore
    //   471: invokevirtual 29	com/venticake/retrica/m:publishProgress	([Ljava/lang/Object;)V
    //   474: aload 7
    //   476: astore 6
    //   478: invokestatic 98	com/venticake/retrica/setting/a:a	()Lcom/venticake/retrica/setting/a;
    //   481: invokevirtual 222	com/venticake/retrica/setting/a:j	()Z
    //   484: ifeq +14 -> 498
    //   487: aload 7
    //   489: iload 4
    //   491: iload 5
    //   493: invokestatic 227	com/venticake/retrica/i:a	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   496: astore 6
    //   498: aload_0
    //   499: iconst_1
    //   500: anewarray 47	java/lang/Integer
    //   503: dup
    //   504: iconst_0
    //   505: bipush 80
    //   507: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   510: aastore
    //   511: invokevirtual 29	com/venticake/retrica/m:publishProgress	([Ljava/lang/Object;)V
    //   514: aconst_null
    //   515: astore 8
    //   517: aload 6
    //   519: astore 7
    //   521: invokestatic 98	com/venticake/retrica/setting/a:a	()Lcom/venticake/retrica/setting/a;
    //   524: invokevirtual 230	com/venticake/retrica/setting/a:q	()Z
    //   527: ifeq +24 -> 551
    //   530: getstatic 70	com/venticake/retrica/MainActivity:a	Landroid/content/Context;
    //   533: aload 6
    //   535: iload_3
    //   536: iconst_0
    //   537: iconst_0
    //   538: invokestatic 235	com/venticake/retrica/setting/b:a	(Landroid/content/Context;Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   541: astore 6
    //   543: aload 6
    //   545: astore 7
    //   547: aload 6
    //   549: astore 8
    //   551: aload_0
    //   552: iconst_1
    //   553: anewarray 47	java/lang/Integer
    //   556: dup
    //   557: iconst_0
    //   558: bipush 90
    //   560: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   563: aastore
    //   564: invokevirtual 29	com/venticake/retrica/m:publishProgress	([Ljava/lang/Object;)V
    //   567: aload_0
    //   568: aload_0
    //   569: getfield 15	com/venticake/retrica/m:b	Lcom/venticake/retrica/MainActivity;
    //   572: invokestatic 238	com/venticake/retrica/MainActivity:d	(Lcom/venticake/retrica/MainActivity;)Lcom/venticake/retrica/g;
    //   575: aload 7
    //   577: iload_3
    //   578: iconst_1
    //   579: iconst_1
    //   580: iconst_0
    //   581: aload_1
    //   582: iconst_1
    //   583: aaload
    //   584: checkcast 240	android/location/Location
    //   587: invokevirtual 245	com/venticake/retrica/g:a	(Landroid/graphics/Bitmap;IZZZLandroid/location/Location;)Landroid/net/Uri;
    //   590: putfield 20	com/venticake/retrica/m:a	Landroid/net/Uri;
    //   593: aload 7
    //   595: invokevirtual 219	android/graphics/Bitmap:recycle	()V
    //   598: aload 8
    //   600: ifnull +8 -> 608
    //   603: aload 8
    //   605: invokevirtual 219	android/graphics/Bitmap:recycle	()V
    //   608: aload_0
    //   609: iconst_1
    //   610: anewarray 47	java/lang/Integer
    //   613: dup
    //   614: iconst_0
    //   615: bipush 100
    //   617: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   620: aastore
    //   621: invokevirtual 29	com/venticake/retrica/m:publishProgress	([Ljava/lang/Object;)V
    //   624: iload_2
    //   625: ifne +3 -> 628
    //   628: aconst_null
    //   629: areturn
    //   630: astore_1
    //   631: ldc -9
    //   633: ldc -7
    //   635: invokestatic 252	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   638: pop
    //   639: aload_1
    //   640: invokevirtual 255	java/lang/OutOfMemoryError:printStackTrace	()V
    //   643: aload_0
    //   644: iconst_1
    //   645: anewarray 47	java/lang/Integer
    //   648: dup
    //   649: iconst_0
    //   650: bipush 60
    //   652: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   655: aastore
    //   656: invokevirtual 29	com/venticake/retrica/m:publishProgress	([Ljava/lang/Object;)V
    //   659: aload_0
    //   660: getfield 15	com/venticake/retrica/m:b	Lcom/venticake/retrica/MainActivity;
    //   663: invokestatic 257	com/venticake/retrica/MainActivity:e	(Lcom/venticake/retrica/MainActivity;)V
    //   666: aload_0
    //   667: iconst_1
    //   668: anewarray 47	java/lang/Integer
    //   671: dup
    //   672: iconst_0
    //   673: bipush 70
    //   675: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   678: aastore
    //   679: invokevirtual 29	com/venticake/retrica/m:publishProgress	([Ljava/lang/Object;)V
    //   682: aload_0
    //   683: getfield 15	com/venticake/retrica/m:b	Lcom/venticake/retrica/MainActivity;
    //   686: iconst_0
    //   687: invokestatic 260	com/venticake/retrica/MainActivity:a	(Lcom/venticake/retrica/MainActivity;Z)V
    //   690: aload_0
    //   691: getfield 15	com/venticake/retrica/m:b	Lcom/venticake/retrica/MainActivity;
    //   694: invokestatic 262	com/venticake/retrica/MainActivity:f	(Lcom/venticake/retrica/MainActivity;)V
    //   697: aload_0
    //   698: iconst_1
    //   699: anewarray 47	java/lang/Integer
    //   702: dup
    //   703: iconst_0
    //   704: bipush 100
    //   706: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   709: aastore
    //   710: invokevirtual 29	com/venticake/retrica/m:publishProgress	([Ljava/lang/Object;)V
    //   713: getstatic 268	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   716: astore_1
    //   717: aload_1
    //   718: areturn
    //   719: astore_1
    //   720: iconst_0
    //   721: istore_2
    //   722: aload_1
    //   723: invokevirtual 269	java/lang/Exception:printStackTrace	()V
    //   726: goto -102 -> 624
    //   729: astore_1
    //   730: iconst_1
    //   731: istore_2
    //   732: goto -10 -> 722
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	735	0	this	m
    //   0	735	1	paramVarArgs	Object[]
    //   1	731	2	i	int
    //   21	557	3	j	int
    //   199	291	4	k	int
    //   211	281	5	m	int
    //   55	493	6	localObject1	Object
    //   100	494	7	localObject2	Object
    //   107	497	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   433	474	630	java/lang/OutOfMemoryError
    //   478	498	630	java/lang/OutOfMemoryError
    //   498	514	630	java/lang/OutOfMemoryError
    //   521	543	630	java/lang/OutOfMemoryError
    //   551	598	630	java/lang/OutOfMemoryError
    //   603	608	630	java/lang/OutOfMemoryError
    //   608	624	630	java/lang/OutOfMemoryError
    //   38	433	719	java/lang/Exception
    //   433	474	719	java/lang/Exception
    //   478	498	719	java/lang/Exception
    //   498	514	719	java/lang/Exception
    //   521	543	719	java/lang/Exception
    //   551	598	719	java/lang/Exception
    //   603	608	719	java/lang/Exception
    //   608	624	719	java/lang/Exception
    //   631	666	719	java/lang/Exception
    //   666	717	729	java/lang/Exception
  }
  
  protected void a(Boolean paramBoolean)
  {
    if (this.a != null)
    {
      Log.i("Retrica", "hjh MainActivity showQuickView() " + this.a);
      this.b.a(this.a, "StillPicture");
      return;
    }
    this.b.u();
  }
  
  protected void a(Integer... paramVarArgs)
  {
    MainActivity.a(this.b).setProgress(paramVarArgs[0].intValue());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */