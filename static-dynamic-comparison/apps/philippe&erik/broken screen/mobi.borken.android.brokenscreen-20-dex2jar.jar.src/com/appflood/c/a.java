package com.appflood.c;

import android.content.Context;
import android.view.View;
import com.appflood.AppFlood.AFRequestDelegate;
import com.appflood.b.b.a;
import com.appflood.e.j;
import com.appflood.mraid.AFBannerWebView;
import java.util.HashMap;
import java.util.TimerTask;
import org.json.JSONObject;

public final class a
  implements AppFlood.AFRequestDelegate, b.a, b
{
  private boolean a = false;
  private b b;
  private int c = 14;
  private int d = 100;
  private int e = 100;
  private Context f;
  private boolean g = false;
  private boolean h = false;
  private View i;
  private JSONObject j;
  private int k = 0;
  private boolean l = false;
  private boolean m = false;
  
  public a(Context paramContext)
  {
    this.f = paramContext;
  }
  
  private void a(HashMap<String, Object> paramHashMap)
  {
    if (this.b != null) {
      this.b.onFinish(paramHashMap);
    }
    boolean bool2 = ((Boolean)paramHashMap.get("result")).booleanValue();
    Object localObject = paramHashMap.get("try");
    if (localObject != null) {}
    for (boolean bool1 = ((Boolean)localObject).booleanValue();; bool1 = true)
    {
      if (bool2) {
        if (((this.i instanceof AFBannerWebView)) && (((AFBannerWebView)this.i).b())) {
          j.a();
        }
      }
      do
      {
        do
        {
          return;
        } while (!bool1);
        new StringBuilder(" need Try mGoNextOnErrored = ").append(this.m).toString();
        j.a();
      } while ((!this.m) || (!paramHashMap.containsKey("video_error")));
      f.a(new TimerTask()
      {
        public final void run()
        {
          a.this.b();
        }
      }, 1000L);
      return;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.b != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("result", Boolean.valueOf(false));
      localHashMap.put("w", Integer.valueOf(0));
      localHashMap.put("h", Integer.valueOf(0));
      localHashMap.put("try", Boolean.valueOf(paramBoolean));
      a(localHashMap);
    }
  }
  
  /* Error */
  private void e()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: getstatic 172	com/appflood/c/d:H	Z
    //   6: ifne +4 -> 10
    //   9: return
    //   10: getstatic 175	com/appflood/c/d:F	I
    //   13: iconst_1
    //   14: iand
    //   15: ifgt +11 -> 26
    //   18: getstatic 175	com/appflood/c/d:F	I
    //   21: iconst_4
    //   22: iand
    //   23: ifle -14 -> 9
    //   26: invokestatic 180	com/appflood/c/g:a	()Lcom/appflood/c/g;
    //   29: astore 10
    //   31: aload_0
    //   32: getfield 62	com/appflood/c/a:f	Landroid/content/Context;
    //   35: astore 12
    //   37: aload_0
    //   38: getfield 48	com/appflood/c/a:d	I
    //   41: istore_1
    //   42: aload_0
    //   43: getfield 50	com/appflood/c/a:e	I
    //   46: istore_2
    //   47: aload_0
    //   48: getfield 56	com/appflood/c/a:k	I
    //   51: istore 4
    //   53: aload_0
    //   54: getfield 46	com/appflood/c/a:c	I
    //   57: istore 5
    //   59: aload_0
    //   60: getfield 58	com/appflood/c/a:l	Z
    //   63: istore 7
    //   65: getstatic 172	com/appflood/c/d:H	Z
    //   68: ifeq -59 -> 9
    //   71: getstatic 175	com/appflood/c/d:F	I
    //   74: iconst_1
    //   75: iand
    //   76: ifgt +11 -> 87
    //   79: getstatic 175	com/appflood/c/d:F	I
    //   82: iconst_4
    //   83: iand
    //   84: ifle -75 -> 9
    //   87: iload 5
    //   89: bipush 15
    //   91: if_icmpne +6 -> 97
    //   94: iconst_1
    //   95: istore 6
    //   97: new 91	java/util/HashMap
    //   100: dup
    //   101: invokespecial 143	java/util/HashMap:<init>	()V
    //   104: astore 9
    //   106: aload 9
    //   108: ldc -74
    //   110: iload_1
    //   111: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   114: invokevirtual 151	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   117: pop
    //   118: aload 9
    //   120: ldc -72
    //   122: iload_2
    //   123: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   126: invokevirtual 151	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   129: pop
    //   130: new 186	org/json/JSONArray
    //   133: dup
    //   134: invokespecial 187	org/json/JSONArray:<init>	()V
    //   137: astore 11
    //   139: aload 11
    //   141: ldc -67
    //   143: invokevirtual 192	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   146: pop
    //   147: aload 11
    //   149: ldc -62
    //   151: invokevirtual 192	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   154: pop
    //   155: aload 11
    //   157: ldc -60
    //   159: invokevirtual 192	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   162: pop
    //   163: aload 11
    //   165: ldc -58
    //   167: invokevirtual 192	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   170: pop
    //   171: aload 9
    //   173: ldc -56
    //   175: aload 11
    //   177: invokevirtual 201	org/json/JSONArray:toString	()Ljava/lang/String;
    //   180: invokevirtual 151	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   183: pop
    //   184: aload 9
    //   186: ldc -53
    //   188: ldc -51
    //   190: invokevirtual 151	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   193: pop
    //   194: new 207	org/json/JSONObject
    //   197: dup
    //   198: invokespecial 208	org/json/JSONObject:<init>	()V
    //   201: astore 11
    //   203: aload 11
    //   205: ldc -46
    //   207: getstatic 215	com/appflood/e/c:d	Ljava/lang/String;
    //   210: invokevirtual 218	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   213: pop
    //   214: aload 11
    //   216: ldc -36
    //   218: getstatic 222	com/appflood/e/c:l	Ljava/lang/String;
    //   221: invokevirtual 218	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   224: pop
    //   225: aload 11
    //   227: ldc -32
    //   229: getstatic 226	com/appflood/e/c:c	Ljava/lang/String;
    //   232: invokevirtual 218	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   235: pop
    //   236: aload 11
    //   238: ldc -28
    //   240: getstatic 230	com/appflood/e/c:k	Ljava/lang/String;
    //   243: invokevirtual 218	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   246: pop
    //   247: aload 11
    //   249: ldc -24
    //   251: getstatic 234	com/appflood/e/c:m	Ljava/lang/String;
    //   254: invokevirtual 218	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   257: pop
    //   258: aload 11
    //   260: ldc -20
    //   262: getstatic 239	com/appflood/e/c:n	Ljava/lang/String;
    //   265: invokevirtual 218	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   268: pop
    //   269: aload 11
    //   271: ldc -15
    //   273: getstatic 243	com/appflood/e/c:f	Ljava/lang/String;
    //   276: invokevirtual 218	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   279: pop
    //   280: aload 11
    //   282: ldc -11
    //   284: getstatic 248	com/appflood/e/c:o	Ljava/lang/String;
    //   287: invokevirtual 218	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   290: pop
    //   291: aload 11
    //   293: ldc -6
    //   295: getstatic 253	com/appflood/e/c:p	Ljava/lang/String;
    //   298: invokevirtual 218	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   301: pop
    //   302: aload 11
    //   304: ldc -1
    //   306: getstatic 258	com/appflood/e/c:s	I
    //   309: invokevirtual 261	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   312: pop
    //   313: aload 11
    //   315: ldc_w 263
    //   318: getstatic 266	com/appflood/e/c:u	Z
    //   321: invokevirtual 269	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   324: pop
    //   325: aload 11
    //   327: ldc_w 271
    //   330: getstatic 274	com/appflood/e/c:v	Z
    //   333: invokevirtual 269	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   336: pop
    //   337: aload 11
    //   339: ldc_w 276
    //   342: getstatic 278	com/appflood/e/c:w	Ljava/lang/String;
    //   345: invokevirtual 218	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   348: pop
    //   349: aload 11
    //   351: ldc_w 280
    //   354: getstatic 283	com/appflood/e/c:x	Ljava/lang/String;
    //   357: invokevirtual 218	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   360: pop
    //   361: getstatic 285	com/appflood/e/c:g	I
    //   364: istore_1
    //   365: getstatic 287	com/appflood/e/c:h	I
    //   368: istore_2
    //   369: aload 12
    //   371: instanceof 289
    //   374: ifeq +604 -> 978
    //   377: aload 12
    //   379: checkcast 289	android/app/Activity
    //   382: invokestatic 294	com/appflood/AFListActivity$1:b	(Landroid/app/Activity;)Z
    //   385: istore 8
    //   387: iload 8
    //   389: ifeq +592 -> 981
    //   392: iload_1
    //   393: iload_2
    //   394: if_icmpgt +597 -> 991
    //   397: goto +584 -> 981
    //   400: aload 11
    //   402: ldc_w 296
    //   405: iload_1
    //   406: invokevirtual 261	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   409: pop
    //   410: aload 11
    //   412: ldc_w 298
    //   415: iload_2
    //   416: invokevirtual 261	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   419: pop
    //   420: aload 11
    //   422: ldc_w 300
    //   425: aload 12
    //   427: invokevirtual 305	android/content/Context:getPackageName	()Ljava/lang/String;
    //   430: invokevirtual 218	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   433: pop
    //   434: aload 12
    //   436: invokevirtual 309	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   439: astore 13
    //   441: aload 13
    //   443: aload 12
    //   445: invokevirtual 305	android/content/Context:getPackageName	()Ljava/lang/String;
    //   448: iconst_0
    //   449: invokevirtual 315	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   452: aload 13
    //   454: invokevirtual 321	android/content/pm/ApplicationInfo:loadLabel	(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
    //   457: checkcast 323	java/lang/String
    //   460: astore 14
    //   462: aload 13
    //   464: aload 12
    //   466: invokevirtual 305	android/content/Context:getPackageName	()Ljava/lang/String;
    //   469: iconst_0
    //   470: invokevirtual 327	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   473: getfield 332	android/content/pm/PackageInfo:versionCode	I
    //   476: istore_1
    //   477: new 111	java/lang/StringBuilder
    //   480: dup
    //   481: ldc_w 334
    //   484: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   487: aload 14
    //   489: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: ldc_w 339
    //   495: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: iload_1
    //   499: invokevirtual 342	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   502: ldc_w 344
    //   505: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: aload 12
    //   510: invokevirtual 305	android/content/Context:getPackageName	()Ljava/lang/String;
    //   513: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   519: pop
    //   520: invokestatic 109	com/appflood/e/j:a	()V
    //   523: aload 14
    //   525: invokestatic 347	com/appflood/e/j:a	(Ljava/lang/CharSequence;)Z
    //   528: ifne +14 -> 542
    //   531: aload 11
    //   533: ldc_w 349
    //   536: aload 14
    //   538: invokevirtual 218	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   541: pop
    //   542: iload_1
    //   543: ifle +13 -> 556
    //   546: aload 11
    //   548: ldc_w 351
    //   551: iload_1
    //   552: invokevirtual 261	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   555: pop
    //   556: aload 11
    //   558: ldc_w 353
    //   561: iload 4
    //   563: invokevirtual 261	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   566: pop
    //   567: aload 11
    //   569: ldc_w 355
    //   572: getstatic 358	com/appflood/e/c:A	Ljava/lang/String;
    //   575: invokevirtual 218	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   578: pop
    //   579: getstatic 362	com/appflood/e/c:q	D
    //   582: dconst_0
    //   583: dcmpl
    //   584: ifeq +27 -> 611
    //   587: aload 11
    //   589: ldc_w 364
    //   592: getstatic 362	com/appflood/e/c:q	D
    //   595: invokevirtual 367	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   598: pop
    //   599: aload 11
    //   601: ldc_w 369
    //   604: getstatic 372	com/appflood/e/c:r	D
    //   607: invokevirtual 367	org/json/JSONObject:put	(Ljava/lang/String;D)Lorg/json/JSONObject;
    //   610: pop
    //   611: aload 9
    //   613: ldc_w 374
    //   616: aload 11
    //   618: invokevirtual 375	org/json/JSONObject:toString	()Ljava/lang/String;
    //   621: invokestatic 380	com/appflood/e/k:d	(Ljava/lang/String;)Ljava/lang/String;
    //   624: invokevirtual 151	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   627: pop
    //   628: getstatic 383	com/appflood/c/d:i	Ljava/util/HashMap;
    //   631: invokestatic 386	com/appflood/e/j:a	(Ljava/util/HashMap;)Ljava/lang/String;
    //   634: astore 11
    //   636: new 111	java/lang/StringBuilder
    //   639: dup
    //   640: ldc_w 388
    //   643: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   646: aload 11
    //   648: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   651: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   654: pop
    //   655: invokestatic 109	com/appflood/e/j:a	()V
    //   658: aload 11
    //   660: invokestatic 347	com/appflood/e/j:a	(Ljava/lang/CharSequence;)Z
    //   663: ifne +14 -> 677
    //   666: aload 9
    //   668: ldc_w 390
    //   671: aload 11
    //   673: invokevirtual 151	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   676: pop
    //   677: getstatic 392	com/appflood/e/c:a	Ljava/lang/String;
    //   680: invokestatic 347	com/appflood/e/j:a	(Ljava/lang/CharSequence;)Z
    //   683: ifne +33 -> 716
    //   686: aload 9
    //   688: ldc_w 394
    //   691: getstatic 392	com/appflood/e/c:a	Ljava/lang/String;
    //   694: invokestatic 398	com/appflood/e/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   697: invokevirtual 151	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   700: pop
    //   701: aload 9
    //   703: ldc_w 400
    //   706: getstatic 392	com/appflood/e/c:a	Ljava/lang/String;
    //   709: invokestatic 402	com/appflood/e/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   712: invokevirtual 151	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   715: pop
    //   716: getstatic 404	com/appflood/e/c:b	Ljava/lang/String;
    //   719: invokestatic 347	com/appflood/e/j:a	(Ljava/lang/CharSequence;)Z
    //   722: ifne +33 -> 755
    //   725: aload 9
    //   727: ldc_w 406
    //   730: getstatic 404	com/appflood/e/c:b	Ljava/lang/String;
    //   733: invokestatic 398	com/appflood/e/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   736: invokevirtual 151	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   739: pop
    //   740: aload 9
    //   742: ldc_w 408
    //   745: getstatic 404	com/appflood/e/c:b	Ljava/lang/String;
    //   748: invokestatic 402	com/appflood/e/a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   751: invokevirtual 151	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   754: pop
    //   755: getstatic 409	com/appflood/c/d:k	Ljava/lang/String;
    //   758: invokestatic 347	com/appflood/e/j:a	(Ljava/lang/CharSequence;)Z
    //   761: ifne -752 -> 9
    //   764: new 411	com/appflood/b/b
    //   767: dup
    //   768: getstatic 409	com/appflood/c/d:k	Ljava/lang/String;
    //   771: ldc_w 413
    //   774: iload 5
    //   776: invokestatic 416	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   779: invokevirtual 420	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   782: aload 9
    //   784: invokespecial 423	com/appflood/b/b:<init>	(Ljava/lang/String;Ljava/util/Map;)V
    //   787: astore 11
    //   789: ldc 89
    //   791: iconst_1
    //   792: invokestatic 158	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   795: invokestatic 425	com/appflood/e/j:a	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   798: astore 12
    //   800: iload 6
    //   802: ifeq +124 -> 926
    //   805: aload 10
    //   807: getfield 427	com/appflood/c/g:d	Lorg/json/JSONObject;
    //   810: astore 9
    //   812: new 111	java/lang/StringBuilder
    //   815: dup
    //   816: invokespecial 428	java/lang/StringBuilder:<init>	()V
    //   819: iload 7
    //   821: invokevirtual 120	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   824: ldc_w 430
    //   827: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   830: iload 6
    //   832: invokevirtual 120	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   835: ldc_w 432
    //   838: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   841: aload 9
    //   843: invokevirtual 435	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   846: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   849: pop
    //   850: invokestatic 109	com/appflood/e/j:a	()V
    //   853: aload 9
    //   855: ifnull +88 -> 943
    //   858: iload 7
    //   860: ifeq +8 -> 868
    //   863: iload 6
    //   865: ifeq +8 -> 873
    //   868: iload 6
    //   870: ifeq +73 -> 943
    //   873: aload 12
    //   875: ldc_w 374
    //   878: aload 9
    //   880: invokevirtual 218	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   883: pop
    //   884: aload_0
    //   885: ifnull +58 -> 943
    //   888: aload_0
    //   889: aload 12
    //   891: invokeinterface 438 2 0
    //   896: iload 6
    //   898: ifeq +38 -> 936
    //   901: aload 10
    //   903: aconst_null
    //   904: putfield 427	com/appflood/c/g:d	Lorg/json/JSONObject;
    //   907: return
    //   908: astore 12
    //   910: aload 12
    //   912: ldc_w 440
    //   915: invokestatic 443	com/appflood/e/j:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   918: goto -362 -> 556
    //   921: astore 12
    //   923: goto -312 -> 611
    //   926: aload 10
    //   928: getfield 445	com/appflood/c/g:c	Lorg/json/JSONObject;
    //   931: astore 9
    //   933: goto -121 -> 812
    //   936: aload 10
    //   938: aconst_null
    //   939: putfield 445	com/appflood/c/g:c	Lorg/json/JSONObject;
    //   942: return
    //   943: aload 11
    //   945: new 447	com/appflood/c/g$2
    //   948: dup
    //   949: aload 10
    //   951: aload 9
    //   953: iload 6
    //   955: iload 7
    //   957: aload 12
    //   959: aload_0
    //   960: invokespecial 450	com/appflood/c/g$2:<init>	(Lcom/appflood/c/g;Lorg/json/JSONObject;ZZLorg/json/JSONObject;Lcom/appflood/AppFlood$AFRequestDelegate;)V
    //   963: invokevirtual 453	com/appflood/b/b:a	(Lcom/appflood/b/b$a;)Lcom/appflood/b/b;
    //   966: pop
    //   967: aload 11
    //   969: invokevirtual 455	com/appflood/b/b:f	()V
    //   972: return
    //   973: astore 13
    //   975: goto -91 -> 884
    //   978: goto -578 -> 400
    //   981: iload 8
    //   983: ifne -5 -> 978
    //   986: iload_1
    //   987: iload_2
    //   988: if_icmpge -10 -> 978
    //   991: iload_2
    //   992: istore_3
    //   993: iload_1
    //   994: istore_2
    //   995: iload_3
    //   996: istore_1
    //   997: goto -597 -> 400
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1000	0	this	a
    //   41	956	1	n	int
    //   46	949	2	i1	int
    //   992	4	3	i2	int
    //   51	511	4	i3	int
    //   57	718	5	i4	int
    //   1	953	6	bool1	boolean
    //   63	893	7	bool2	boolean
    //   385	597	8	bool3	boolean
    //   104	848	9	localObject1	Object
    //   29	921	10	localg	g
    //   137	831	11	localObject2	Object
    //   35	855	12	localObject3	Object
    //   908	3	12	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    //   921	37	12	localThrowable	Throwable
    //   439	24	13	localPackageManager	android.content.pm.PackageManager
    //   973	1	13	localJSONException	org.json.JSONException
    //   460	77	14	str	String
    // Exception table:
    //   from	to	target	type
    //   441	542	908	android/content/pm/PackageManager$NameNotFoundException
    //   546	556	908	android/content/pm/PackageManager$NameNotFoundException
    //   203	387	921	java/lang/Throwable
    //   400	441	921	java/lang/Throwable
    //   441	542	921	java/lang/Throwable
    //   546	556	921	java/lang/Throwable
    //   556	611	921	java/lang/Throwable
    //   910	918	921	java/lang/Throwable
    //   873	884	973	org/json/JSONException
  }
  
  public final void a()
  {
    this.m = true;
  }
  
  public final void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.d = paramInt1;
    this.e = paramInt2;
    this.k = paramInt3;
    d.a(new d.a()
    {
      public final void a()
      {
        a.a(a.this);
      }
    });
  }
  
  public final void a(com.appflood.b.b paramb)
  {
    paramb = paramb.c();
    if (paramb.length() <= 200)
    {
      new StringBuilder(" cont ").append(paramb).toString();
      j.a();
    }
    paramb = j.e(paramb);
    if (j.a(paramb, "ret", 0) == 0)
    {
      this.j = j.a(paramb, "data");
      paramb = j.a(this.j, "type", "");
      if (!"banner".equals(paramb)) {}
      for (boolean bool = true;; bool = false)
      {
        this.g = bool;
        new StringBuilder(" is video ").append(this.g).append(" type ").append(paramb).append("  --------- ").toString();
        j.a();
        String str = j.a(this.j, "data", "");
        final HashMap localHashMap = new HashMap();
        localHashMap.put("click_cb_url", j.a(this.j, "click_cb_url", ""));
        localHashMap.put("show_cb_url", j.a(this.j, "show_cb_url", ""));
        localHashMap.put("redirect_url", j.a(this.j, "redirect_url", ""));
        localHashMap.put("width", Integer.valueOf(j.a(this.j, "width", 0)));
        localHashMap.put("height", Integer.valueOf(j.a(this.j, "height", 0)));
        localHashMap.put("html_content", str);
        localHashMap.put("type", paramb);
        f.a(new Runnable()
        {
          public final void run()
          {
            a.a(a.this, localHashMap);
          }
        });
        return;
      }
    }
    c(false);
  }
  
  public final void a(com.appflood.b.b paramb, int paramInt)
  {
    c(true);
  }
  
  public final void a(b paramb)
  {
    this.b = paramb;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public final void b()
  {
    if (!this.h) {
      e();
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public final View c()
  {
    return this.i;
  }
  
  public final void d()
  {
    this.h = true;
    if ((this.i instanceof AFBannerWebView)) {
      ((AFBannerWebView)this.i).destroy();
    }
    while (!(this.i instanceof com.appflood.d.a)) {
      return;
    }
    ((com.appflood.d.a)this.i).a();
  }
  
  public final void onClick()
  {
    int n = 4;
    new StringBuilder(" onclick in bannerAdapter ").append(this.c).toString();
    j.a();
    if (this.b != null) {
      this.b.onClick();
    }
    e locale = e.a();
    if (this.c == 15) {}
    for (;;)
    {
      locale.a(true, j.a("type", Integer.valueOf(n)));
      return;
      if (this.c != 25) {
        n = 1;
      }
    }
  }
  
  public final void onClose()
  {
    if (this.b != null) {
      this.b.onClose();
    }
  }
  
  public final void onComplete()
  {
    if (this.b != null) {
      this.b.onComplete();
    }
    if ((this.a) && (!this.h)) {
      e();
    }
  }
  
  public final void onFinish(HashMap<String, Object> paramHashMap)
  {
    a(paramHashMap);
  }
  
  public final void onFinish(JSONObject paramJSONObject)
  {
    int n = j.a(paramJSONObject, "result", 0);
    new StringBuilder(" onFinish ").append(n).toString();
    j.a();
    if (n == 1)
    {
      this.j = j.a(paramJSONObject, "data");
      paramJSONObject = j.a(this.j, "type", "");
      String str = j.a(this.j, "data", "");
      final HashMap localHashMap = new HashMap();
      localHashMap.put("click_cb_url", j.a(this.j, "click_cb_url", ""));
      localHashMap.put("show_cb_url", j.a(this.j, "show_cb_url", ""));
      localHashMap.put("redirect_url", j.a(this.j, "redirect_url", ""));
      localHashMap.put("width", Integer.valueOf(j.a(this.j, "width", 0)));
      localHashMap.put("height", Integer.valueOf(j.a(this.j, "height", 0)));
      localHashMap.put("html_content", str);
      localHashMap.put("type", paramJSONObject);
      localHashMap.put("show_type", Integer.valueOf(this.c));
      f.a(new Runnable()
      {
        public final void run()
        {
          a.a(a.this, localHashMap);
        }
      });
      return;
    }
    c(false);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appflood/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */