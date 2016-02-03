package com.millennialmedia.android;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

class BridgeMMMedia$PickerActivity
        extends MMBaseActivity {
    boolean a = false;
    private Uri b;

    /* Error */
    protected void a(int paramInt1, int paramInt2, Intent paramIntent) {
        // Byte code:
        //   0: aconst_null
        //   1: astore 7
        //   3: aconst_null
        //   4: astore 6
        //   6: aload_0
        //   7: iload_1
        //   8: iload_2
        //   9: aload_3
        //   10: invokespecial 20	com/millennialmedia/android/MMBaseActivity:a	(IILandroid/content/Intent;)V
        //   13: aload_3
        //   14: ifnull +174 -> 188
        //   17: aload_3
        //   18: invokevirtual 26	android/content/Intent:getData	()Landroid/net/Uri;
        //   21: astore 4
        //   23: aload 4
        //   25: ifnonnull +285 -> 310
        //   28: aload_3
        //   29: invokevirtual 30	android/content/Intent:getExtras	()Landroid/os/Bundle;
        //   32: ifnull +156 -> 188
        //   35: aload_3
        //   36: invokevirtual 30	android/content/Intent:getExtras	()Landroid/os/Bundle;
        //   39: ldc 32
        //   41: invokevirtual 38	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
        //   44: checkcast 40	android/graphics/Bitmap
        //   47: astore 4
        //   49: new 42	java/io/File
        //   52: dup
        //   53: aload_0
        //   54: invokevirtual 46	com/millennialmedia/android/BridgeMMMedia$PickerActivity:getIntent	()Landroid/content/Intent;
        //   57: invokevirtual 26	android/content/Intent:getData	()Landroid/net/Uri;
        //   60: invokevirtual 52	android/net/Uri:getPath	()Ljava/lang/String;
        //   63: invokespecial 55	java/io/File:<init>	(Ljava/lang/String;)V
        //   66: astore_3
        //   67: new 57	java/io/ByteArrayOutputStream
        //   70: dup
        //   71: invokespecial 58	java/io/ByteArrayOutputStream:<init>	()V
        //   74: astore 5
        //   76: aload 4
        //   78: getstatic 64	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
        //   81: iconst_0
        //   82: aload 5
        //   84: invokevirtual 68	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
        //   87: pop
        //   88: new 70	java/io/ByteArrayInputStream
        //   91: dup
        //   92: aload 5
        //   94: invokevirtual 74	java/io/ByteArrayOutputStream:toByteArray	()[B
        //   97: invokespecial 77	java/io/ByteArrayInputStream:<init>	([B)V
        //   100: astore 5
        //   102: new 79	java/io/FileOutputStream
        //   105: dup
        //   106: aload_3
        //   107: invokespecial 82	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   110: astore 4
        //   112: aload 4
        //   114: astore_3
        //   115: sipush 1024
        //   118: newarray <illegal type>
        //   120: astore 6
        //   122: aload 4
        //   124: astore_3
        //   125: aload 5
        //   127: aload 6
        //   129: invokevirtual 86	java/io/ByteArrayInputStream:read	([B)I
        //   132: istore_1
        //   133: iload_1
        //   134: ifle +76 -> 210
        //   137: aload 4
        //   139: astore_3
        //   140: aload 4
        //   142: aload 6
        //   144: iconst_0
        //   145: iload_1
        //   146: invokevirtual 92	java/io/OutputStream:write	([BII)V
        //   149: goto -27 -> 122
        //   152: astore 5
        //   154: aload 4
        //   156: astore_3
        //   157: ldc 94
        //   159: ldc 96
        //   161: aload 5
        //   163: invokestatic 101	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   166: iconst_0
        //   167: ifeq +11 -> 178
        //   170: new 103	java/lang/NullPointerException
        //   173: dup
        //   174: invokespecial 104	java/lang/NullPointerException:<init>	()V
        //   177: athrow
        //   178: aload 4
        //   180: ifnull +8 -> 188
        //   183: aload 4
        //   185: invokevirtual 107	java/io/OutputStream:close	()V
        //   188: invokestatic 112	com/millennialmedia/android/BridgeMMMedia:a	()Ljava/lang/Object;
        //   191: astore 4
        //   193: aload 4
        //   195: monitorenter
        //   196: invokestatic 112	com/millennialmedia/android/BridgeMMMedia:a	()Ljava/lang/Object;
        //   199: invokevirtual 117	java/lang/Object:notify	()V
        //   202: aload 4
        //   204: monitorexit
        //   205: aload_0
        //   206: invokevirtual 120	com/millennialmedia/android/BridgeMMMedia$PickerActivity:finish	()V
        //   209: return
        //   210: iconst_0
        //   211: ifeq +11 -> 222
        //   214: new 103	java/lang/NullPointerException
        //   217: dup
        //   218: invokespecial 104	java/lang/NullPointerException:<init>	()V
        //   221: athrow
        //   222: aload 4
        //   224: ifnull -36 -> 188
        //   227: aload 4
        //   229: invokevirtual 107	java/io/OutputStream:close	()V
        //   232: goto -44 -> 188
        //   235: astore_3
        //   236: ldc 94
        //   238: ldc 122
        //   240: aload_3
        //   241: invokestatic 101	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   244: goto -56 -> 188
        //   247: astore_3
        //   248: ldc 94
        //   250: ldc 124
        //   252: aload_3
        //   253: invokestatic 101	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   256: goto -68 -> 188
        //   259: astore_3
        //   260: ldc 94
        //   262: ldc 122
        //   264: aload_3
        //   265: invokestatic 101	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   268: goto -80 -> 188
        //   271: astore 4
        //   273: aconst_null
        //   274: astore_3
        //   275: iconst_0
        //   276: ifeq +11 -> 287
        //   279: new 103	java/lang/NullPointerException
        //   282: dup
        //   283: invokespecial 104	java/lang/NullPointerException:<init>	()V
        //   286: athrow
        //   287: aload_3
        //   288: ifnull +7 -> 295
        //   291: aload_3
        //   292: invokevirtual 107	java/io/OutputStream:close	()V
        //   295: aload 4
        //   297: athrow
        //   298: astore_3
        //   299: ldc 94
        //   301: ldc 122
        //   303: aload_3
        //   304: invokestatic 101	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   307: goto -12 -> 295
        //   310: aload 4
        //   312: ifnull -124 -> 188
        //   315: aload_0
        //   316: invokevirtual 128	com/millennialmedia/android/BridgeMMMedia$PickerActivity:getContentResolver	()Landroid/content/ContentResolver;
        //   319: astore_3
        //   320: aload_3
        //   321: ifnull -133 -> 188
        //   324: aload_3
        //   325: aload 4
        //   327: iconst_1
        //   328: anewarray 130	java/lang/String
        //   331: dup
        //   332: iconst_0
        //   333: ldc -124
        //   335: aastore
        //   336: aconst_null
        //   337: aconst_null
        //   338: aconst_null
        //   339: invokevirtual 138	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //   342: astore_3
        //   343: aload_3
        //   344: ifnull -156 -> 188
        //   347: aload_3
        //   348: ldc -124
        //   350: invokeinterface 144 2 0
        //   355: istore_1
        //   356: iload_1
        //   357: iconst_m1
        //   358: if_icmpeq -170 -> 188
        //   361: aload_3
        //   362: invokeinterface 148 1 0
        //   367: pop
        //   368: new 42	java/io/File
        //   371: dup
        //   372: aload_3
        //   373: iload_1
        //   374: invokeinterface 152 2 0
        //   379: invokespecial 55	java/io/File:<init>	(Ljava/lang/String;)V
        //   382: astore 4
        //   384: aload_3
        //   385: invokeinterface 153 1 0
        //   390: new 42	java/io/File
        //   393: dup
        //   394: aload_0
        //   395: invokevirtual 46	com/millennialmedia/android/BridgeMMMedia$PickerActivity:getIntent	()Landroid/content/Intent;
        //   398: invokevirtual 26	android/content/Intent:getData	()Landroid/net/Uri;
        //   401: invokevirtual 52	android/net/Uri:getPath	()Ljava/lang/String;
        //   404: invokespecial 55	java/io/File:<init>	(Ljava/lang/String;)V
        //   407: astore_3
        //   408: new 155	java/io/FileInputStream
        //   411: dup
        //   412: aload 4
        //   414: invokespecial 156	java/io/FileInputStream:<init>	(Ljava/io/File;)V
        //   417: astore 4
        //   419: new 79	java/io/FileOutputStream
        //   422: dup
        //   423: aload_3
        //   424: invokespecial 82	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   427: astore_3
        //   428: sipush 1024
        //   431: newarray <illegal type>
        //   433: astore 5
        //   435: aload 4
        //   437: aload 5
        //   439: invokevirtual 159	java/io/InputStream:read	([B)I
        //   442: istore_1
        //   443: iload_1
        //   444: ifle +72 -> 516
        //   447: aload_3
        //   448: aload 5
        //   450: iconst_0
        //   451: iload_1
        //   452: invokevirtual 92	java/io/OutputStream:write	([BII)V
        //   455: goto -20 -> 435
        //   458: astore 6
        //   460: aload 4
        //   462: astore 5
        //   464: aload_3
        //   465: astore 4
        //   467: aload 5
        //   469: astore_3
        //   470: aload 6
        //   472: astore 5
        //   474: ldc 94
        //   476: ldc -95
        //   478: aload 5
        //   480: invokestatic 101	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   483: aload_3
        //   484: ifnull +7 -> 491
        //   487: aload_3
        //   488: invokevirtual 162	java/io/InputStream:close	()V
        //   491: aload 4
        //   493: ifnull -305 -> 188
        //   496: aload 4
        //   498: invokevirtual 107	java/io/OutputStream:close	()V
        //   501: goto -313 -> 188
        //   504: astore_3
        //   505: ldc 94
        //   507: ldc 122
        //   509: aload_3
        //   510: invokestatic 101	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   513: goto -325 -> 188
        //   516: aload 4
        //   518: ifnull +8 -> 526
        //   521: aload 4
        //   523: invokevirtual 162	java/io/InputStream:close	()V
        //   526: aload_3
        //   527: ifnull -339 -> 188
        //   530: aload_3
        //   531: invokevirtual 107	java/io/OutputStream:close	()V
        //   534: goto -346 -> 188
        //   537: astore_3
        //   538: ldc 94
        //   540: ldc 122
        //   542: aload_3
        //   543: invokestatic 101	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   546: goto -358 -> 188
        //   549: astore_3
        //   550: aconst_null
        //   551: astore 5
        //   553: aload 7
        //   555: astore 4
        //   557: aload 5
        //   559: ifnull +8 -> 567
        //   562: aload 5
        //   564: invokevirtual 162	java/io/InputStream:close	()V
        //   567: aload 4
        //   569: ifnull +8 -> 577
        //   572: aload 4
        //   574: invokevirtual 107	java/io/OutputStream:close	()V
        //   577: aload_3
        //   578: athrow
        //   579: astore 4
        //   581: ldc 94
        //   583: ldc 122
        //   585: aload 4
        //   587: invokestatic 101	com/millennialmedia/android/MMLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   590: goto -13 -> 577
        //   593: astore_3
        //   594: aload 4
        //   596: monitorexit
        //   597: aload_3
        //   598: athrow
        //   599: astore_3
        //   600: aload 4
        //   602: astore 5
        //   604: aload 7
        //   606: astore 4
        //   608: goto -51 -> 557
        //   611: astore 5
        //   613: aload_3
        //   614: astore 6
        //   616: aload 5
        //   618: astore_3
        //   619: aload 4
        //   621: astore 5
        //   623: aload 6
        //   625: astore 4
        //   627: goto -70 -> 557
        //   630: astore 6
        //   632: aload_3
        //   633: astore 5
        //   635: aload 6
        //   637: astore_3
        //   638: goto -81 -> 557
        //   641: astore 5
        //   643: aconst_null
        //   644: astore_3
        //   645: aload 6
        //   647: astore 4
        //   649: goto -175 -> 474
        //   652: astore 5
        //   654: aload 4
        //   656: astore_3
        //   657: aload 6
        //   659: astore 4
        //   661: goto -187 -> 474
        //   664: astore 4
        //   666: goto -391 -> 275
        //   669: astore 5
        //   671: aconst_null
        //   672: astore 4
        //   674: goto -520 -> 154
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	677	0	this	PickerActivity
        //   0	677	1	paramInt1	int
        //   0	677	2	paramInt2	int
        //   0	677	3	paramIntent	Intent
        //   21	207	4	localObject1	Object
        //   271	55	4	localUri	Uri
        //   382	191	4	localObject2	Object
        //   579	22	4	localException1	Exception
        //   606	54	4	localObject3	Object
        //   664	1	4	localObject4	Object
        //   672	1	4	localObject5	Object
        //   74	52	5	localObject6	Object
        //   152	10	5	localException2	Exception
        //   433	170	5	localObject7	Object
        //   611	6	5	localObject8	Object
        //   621	13	5	localObject9	Object
        //   641	1	5	localException3	Exception
        //   652	1	5	localException4	Exception
        //   669	1	5	localException5	Exception
        //   4	139	6	arrayOfByte	byte[]
        //   458	13	6	localException6	Exception
        //   614	10	6	localIntent	Intent
        //   630	28	6	localObject10	Object
        //   1	604	7	localObject11	Object
        // Exception table:
        //   from	to	target	type
        //   115	122	152	java/lang/Exception
        //   125	133	152	java/lang/Exception
        //   140	149	152	java/lang/Exception
        //   214	222	235	java/lang/Exception
        //   227	232	235	java/lang/Exception
        //   17	23	247	java/lang/Exception
        //   28	49	247	java/lang/Exception
        //   236	244	247	java/lang/Exception
        //   260	268	247	java/lang/Exception
        //   295	298	247	java/lang/Exception
        //   299	307	247	java/lang/Exception
        //   315	320	247	java/lang/Exception
        //   324	343	247	java/lang/Exception
        //   347	356	247	java/lang/Exception
        //   361	390	247	java/lang/Exception
        //   505	513	247	java/lang/Exception
        //   538	546	247	java/lang/Exception
        //   577	579	247	java/lang/Exception
        //   581	590	247	java/lang/Exception
        //   170	178	259	java/lang/Exception
        //   183	188	259	java/lang/Exception
        //   49	112	271	finally
        //   279	287	298	java/lang/Exception
        //   291	295	298	java/lang/Exception
        //   428	435	458	java/lang/Exception
        //   435	443	458	java/lang/Exception
        //   447	455	458	java/lang/Exception
        //   487	491	504	java/lang/Exception
        //   496	501	504	java/lang/Exception
        //   521	526	537	java/lang/Exception
        //   530	534	537	java/lang/Exception
        //   390	419	549	finally
        //   562	567	579	java/lang/Exception
        //   572	577	579	java/lang/Exception
        //   196	205	593	finally
        //   594	597	593	finally
        //   419	428	599	finally
        //   428	435	611	finally
        //   435	443	611	finally
        //   447	455	611	finally
        //   474	483	630	finally
        //   390	419	641	java/lang/Exception
        //   419	428	652	java/lang/Exception
        //   115	122	664	finally
        //   125	133	664	finally
        //   140	149	664	finally
        //   157	166	664	finally
        //   49	112	669	java/lang/Exception
    }

    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        if (getLastNonConfigurationInstance() != null) {
            this.a = ((Bundle) getLastNonConfigurationInstance()).getBoolean("hasRequestedPic");
        }
        if (!this.a) {
            if (getIntent().getStringExtra("type").equalsIgnoreCase("Camera")) {
                paramBundle = new Intent("android.media.action.IMAGE_CAPTURE");
                this.b = getIntent().getData();
                paramBundle.putExtra("return-data", true);
                this.a = true;
                startActivityForResult(paramBundle, 0);
            }
        } else {
            return;
        }
        paramBundle = new Intent();
        paramBundle.setType("image/*");
        paramBundle.setAction("android.intent.action.GET_CONTENT");
        this.a = true;
        startActivityForResult(paramBundle, 0);
    }

    public Object onRetainNonConfigurationInstance() {
        super.onRetainNonConfigurationInstance();
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("hasRequestedPic", this.a);
        return localBundle;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/BridgeMMMedia$PickerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */