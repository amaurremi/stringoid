package com.jtpgodorncrqoeurl;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import org.json.JSONObject;

final class ae
  extends WebViewClient
{
  private Context a;
  private AdController b;
  private AdWebView c;
  private boolean d = true;
  private boolean e = false;
  private boolean f = false;
  
  public ae(AdWebView paramAdWebView1, Context paramContext, AdController paramAdController, AdWebView paramAdWebView2)
  {
    this.a = paramContext;
    this.b = paramAdController;
    this.c = paramAdWebView2;
  }
  
  /* Error */
  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    // Byte code:
    //   0: ldc 41
    //   2: ldc 42
    //   4: invokestatic 48	com/jtpgodorncrqoeurl/AdLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: aload_0
    //   8: getfield 26	com/jtpgodorncrqoeurl/ae:e	Z
    //   11: ifne +8 -> 19
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 24	com/jtpgodorncrqoeurl/ae:d	Z
    //   19: aload_0
    //   20: getfield 19	com/jtpgodorncrqoeurl/ae:g	Lcom/jtpgodorncrqoeurl/AdWebView;
    //   23: invokestatic 53	com/jtpgodorncrqoeurl/AdWebView:f	(Lcom/jtpgodorncrqoeurl/AdWebView;)Landroid/app/ProgressDialog;
    //   26: ifnull +26 -> 52
    //   29: aload_0
    //   30: getfield 19	com/jtpgodorncrqoeurl/ae:g	Lcom/jtpgodorncrqoeurl/AdWebView;
    //   33: invokestatic 53	com/jtpgodorncrqoeurl/AdWebView:f	(Lcom/jtpgodorncrqoeurl/AdWebView;)Landroid/app/ProgressDialog;
    //   36: invokevirtual 59	android/app/ProgressDialog:isShowing	()Z
    //   39: ifeq +13 -> 52
    //   42: aload_0
    //   43: getfield 19	com/jtpgodorncrqoeurl/ae:g	Lcom/jtpgodorncrqoeurl/AdWebView;
    //   46: invokestatic 53	com/jtpgodorncrqoeurl/AdWebView:f	(Lcom/jtpgodorncrqoeurl/AdWebView;)Landroid/app/ProgressDialog;
    //   49: invokevirtual 62	android/app/ProgressDialog:dismiss	()V
    //   52: aload_0
    //   53: getfield 28	com/jtpgodorncrqoeurl/ae:f	Z
    //   56: ifeq +18 -> 74
    //   59: aload_0
    //   60: getfield 32	com/jtpgodorncrqoeurl/ae:b	Lcom/jtpgodorncrqoeurl/AdController;
    //   63: invokevirtual 67	com/jtpgodorncrqoeurl/AdController:destroyAd	()V
    //   66: aload_0
    //   67: getfield 32	com/jtpgodorncrqoeurl/ae:b	Lcom/jtpgodorncrqoeurl/AdController;
    //   70: invokevirtual 70	com/jtpgodorncrqoeurl/AdController:showInternetDialog	()V
    //   73: return
    //   74: aload_2
    //   75: aload_0
    //   76: getfield 19	com/jtpgodorncrqoeurl/ae:g	Lcom/jtpgodorncrqoeurl/AdWebView;
    //   79: invokestatic 73	com/jtpgodorncrqoeurl/AdWebView:a	(Lcom/jtpgodorncrqoeurl/AdWebView;)Ljava/lang/String;
    //   82: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   85: ifeq +481 -> 566
    //   88: aload_0
    //   89: getfield 19	com/jtpgodorncrqoeurl/ae:g	Lcom/jtpgodorncrqoeurl/AdWebView;
    //   92: invokestatic 82	com/jtpgodorncrqoeurl/AdWebView:c	(Lcom/jtpgodorncrqoeurl/AdWebView;)Lorg/json/JSONObject;
    //   95: ldc 84
    //   97: invokevirtual 90	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   100: ldc 92
    //   102: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   105: istore 4
    //   107: iload 4
    //   109: ifeq +335 -> 444
    //   112: aload_1
    //   113: iconst_0
    //   114: invokevirtual 98	android/webkit/WebView:setBackgroundColor	(I)V
    //   117: aload_0
    //   118: getfield 34	com/jtpgodorncrqoeurl/ae:c	Lcom/jtpgodorncrqoeurl/AdWebView;
    //   121: ldc 100
    //   123: invokevirtual 104	com/jtpgodorncrqoeurl/AdWebView:loadUrl	(Ljava/lang/String;)V
    //   126: new 106	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   133: aload_0
    //   134: getfield 30	com/jtpgodorncrqoeurl/ae:a	Landroid/content/Context;
    //   137: invokevirtual 113	android/content/Context:getPackageName	()Ljava/lang/String;
    //   140: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: ldc 119
    //   145: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 128	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   154: astore 5
    //   156: aload 5
    //   158: ldc -126
    //   160: invokevirtual 134	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   163: aload 5
    //   165: invokevirtual 140	java/lang/reflect/Field:getInt	(Ljava/lang/Object;)I
    //   168: istore_3
    //   169: aload_0
    //   170: getfield 19	com/jtpgodorncrqoeurl/ae:g	Lcom/jtpgodorncrqoeurl/AdWebView;
    //   173: iload_3
    //   174: invokestatic 143	com/jtpgodorncrqoeurl/AdWebView:a	(Lcom/jtpgodorncrqoeurl/AdWebView;I)Ljava/lang/String;
    //   177: astore 5
    //   179: aload 5
    //   181: ldc -111
    //   183: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   186: ifne +34 -> 220
    //   189: aload_1
    //   190: new 106	java/lang/StringBuilder
    //   193: dup
    //   194: ldc -109
    //   196: invokespecial 149	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   199: aload 5
    //   201: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: ldc -105
    //   206: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: ldc -103
    //   211: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokevirtual 154	android/webkit/WebView:loadUrl	(Ljava/lang/String;)V
    //   220: aload_0
    //   221: getfield 30	com/jtpgodorncrqoeurl/ae:a	Landroid/content/Context;
    //   224: ldc -100
    //   226: invokevirtual 160	android/content/Context:checkCallingOrSelfPermission	(Ljava/lang/String;)I
    //   229: ifne +312 -> 541
    //   232: aload_0
    //   233: getfield 30	com/jtpgodorncrqoeurl/ae:a	Landroid/content/Context;
    //   236: invokestatic 166	android/accounts/AccountManager:get	(Landroid/content/Context;)Landroid/accounts/AccountManager;
    //   239: invokevirtual 170	android/accounts/AccountManager:getAccounts	()[Landroid/accounts/Account;
    //   242: astore_1
    //   243: iconst_0
    //   244: istore_3
    //   245: iload_3
    //   246: aload_1
    //   247: arraylength
    //   248: if_icmpge +58 -> 306
    //   251: aload_1
    //   252: iload_3
    //   253: aaload
    //   254: astore 5
    //   256: aload 5
    //   258: getfield 176	android/accounts/Account:type	Ljava/lang/String;
    //   261: ldc -78
    //   263: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   266: ifeq +268 -> 534
    //   269: aload_0
    //   270: getfield 34	com/jtpgodorncrqoeurl/ae:c	Lcom/jtpgodorncrqoeurl/AdWebView;
    //   273: new 106	java/lang/StringBuilder
    //   276: dup
    //   277: ldc -76
    //   279: invokespecial 149	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   282: aload 5
    //   284: getfield 183	android/accounts/Account:name	Ljava/lang/String;
    //   287: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: ldc -71
    //   292: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: ldc -103
    //   297: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokevirtual 104	com/jtpgodorncrqoeurl/AdWebView:loadUrl	(Ljava/lang/String;)V
    //   306: aload_0
    //   307: getfield 24	com/jtpgodorncrqoeurl/ae:d	Z
    //   310: ifeq +241 -> 551
    //   313: aload_0
    //   314: getfield 26	com/jtpgodorncrqoeurl/ae:e	Z
    //   317: ifne +234 -> 551
    //   320: ldc 41
    //   322: ldc -69
    //   324: invokestatic 48	com/jtpgodorncrqoeurl/AdLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   327: aload_0
    //   328: getfield 19	com/jtpgodorncrqoeurl/ae:g	Lcom/jtpgodorncrqoeurl/AdWebView;
    //   331: iconst_0
    //   332: invokevirtual 190	com/jtpgodorncrqoeurl/AdWebView:setVisibility	(I)V
    //   335: aload_0
    //   336: getfield 32	com/jtpgodorncrqoeurl/ae:b	Lcom/jtpgodorncrqoeurl/AdController;
    //   339: invokevirtual 193	com/jtpgodorncrqoeurl/AdController:showElements	()V
    //   342: aload_0
    //   343: getfield 19	com/jtpgodorncrqoeurl/ae:g	Lcom/jtpgodorncrqoeurl/AdWebView;
    //   346: iconst_0
    //   347: invokestatic 196	com/jtpgodorncrqoeurl/AdWebView:a	(Lcom/jtpgodorncrqoeurl/AdWebView;Z)Z
    //   350: pop
    //   351: aload_0
    //   352: getfield 32	com/jtpgodorncrqoeurl/ae:b	Lcom/jtpgodorncrqoeurl/AdController;
    //   355: aload_0
    //   356: getfield 19	com/jtpgodorncrqoeurl/ae:g	Lcom/jtpgodorncrqoeurl/AdWebView;
    //   359: invokestatic 199	com/jtpgodorncrqoeurl/AdWebView:b	(Lcom/jtpgodorncrqoeurl/AdWebView;)Z
    //   362: invokevirtual 203	com/jtpgodorncrqoeurl/AdController:setLoading	(Z)V
    //   365: aload_0
    //   366: getfield 34	com/jtpgodorncrqoeurl/ae:c	Lcom/jtpgodorncrqoeurl/AdWebView;
    //   369: sipush 130
    //   372: invokevirtual 207	com/jtpgodorncrqoeurl/AdWebView:requestFocus	(I)Z
    //   375: pop
    //   376: aload_2
    //   377: ldc -47
    //   379: invokevirtual 213	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   382: ifeq +16 -> 398
    //   385: ldc2_w 214
    //   388: invokestatic 221	java/lang/Thread:sleep	(J)V
    //   391: aload_0
    //   392: getfield 32	com/jtpgodorncrqoeurl/ae:b	Lcom/jtpgodorncrqoeurl/AdController;
    //   395: invokevirtual 67	com/jtpgodorncrqoeurl/AdController:destroyAd	()V
    //   398: aload_0
    //   399: getfield 24	com/jtpgodorncrqoeurl/ae:d	Z
    //   402: ifeq -329 -> 73
    //   405: aload_0
    //   406: getfield 28	com/jtpgodorncrqoeurl/ae:f	Z
    //   409: ifeq -336 -> 73
    //   412: aload_0
    //   413: getfield 19	com/jtpgodorncrqoeurl/ae:g	Lcom/jtpgodorncrqoeurl/AdWebView;
    //   416: bipush 8
    //   418: invokevirtual 190	com/jtpgodorncrqoeurl/AdWebView:setVisibility	(I)V
    //   421: aload_0
    //   422: getfield 32	com/jtpgodorncrqoeurl/ae:b	Lcom/jtpgodorncrqoeurl/AdController;
    //   425: invokevirtual 224	com/jtpgodorncrqoeurl/AdController:hideElements	()V
    //   428: ldc 41
    //   430: ldc -30
    //   432: invokestatic 228	com/jtpgodorncrqoeurl/AdLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   435: return
    //   436: astore 5
    //   438: iconst_0
    //   439: istore 4
    //   441: goto -334 -> 107
    //   444: aconst_null
    //   445: astore 5
    //   447: aload_0
    //   448: getfield 19	com/jtpgodorncrqoeurl/ae:g	Lcom/jtpgodorncrqoeurl/AdWebView;
    //   451: invokestatic 82	com/jtpgodorncrqoeurl/AdWebView:c	(Lcom/jtpgodorncrqoeurl/AdWebView;)Lorg/json/JSONObject;
    //   454: ldc -26
    //   456: invokevirtual 90	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   459: astore 6
    //   461: aload 6
    //   463: astore 5
    //   465: aload 5
    //   467: ifnull +25 -> 492
    //   470: aload 5
    //   472: ldc -111
    //   474: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   477: ifne +15 -> 492
    //   480: aload_1
    //   481: aload 5
    //   483: invokestatic 235	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   486: invokevirtual 98	android/webkit/WebView:setBackgroundColor	(I)V
    //   489: goto -372 -> 117
    //   492: aload_1
    //   493: iconst_m1
    //   494: invokevirtual 98	android/webkit/WebView:setBackgroundColor	(I)V
    //   497: goto -380 -> 117
    //   500: astore_1
    //   501: ldc 41
    //   503: new 106	java/lang/StringBuilder
    //   506: dup
    //   507: ldc -19
    //   509: invokespecial 149	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   512: aload_1
    //   513: invokevirtual 240	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   516: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   522: invokestatic 242	com/jtpgodorncrqoeurl/AdLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   525: ldc 41
    //   527: aload_1
    //   528: invokestatic 246	com/jtpgodorncrqoeurl/AdLog:printStackTrace	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   531: goto -311 -> 220
    //   534: iload_3
    //   535: iconst_1
    //   536: iadd
    //   537: istore_3
    //   538: goto -293 -> 245
    //   541: ldc 41
    //   543: ldc -8
    //   545: invokestatic 228	com/jtpgodorncrqoeurl/AdLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   548: goto -242 -> 306
    //   551: ldc 41
    //   553: ldc -6
    //   555: invokestatic 48	com/jtpgodorncrqoeurl/AdLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   558: aload_0
    //   559: iconst_0
    //   560: putfield 26	com/jtpgodorncrqoeurl/ae:e	Z
    //   563: goto -221 -> 342
    //   566: aload_0
    //   567: getfield 19	com/jtpgodorncrqoeurl/ae:g	Lcom/jtpgodorncrqoeurl/AdWebView;
    //   570: invokestatic 252	com/jtpgodorncrqoeurl/AdWebView:d	(Lcom/jtpgodorncrqoeurl/AdWebView;)Z
    //   573: ifne +52 -> 625
    //   576: aload_2
    //   577: ldc -2
    //   579: invokevirtual 258	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   582: ifne +43 -> 625
    //   585: aload_2
    //   586: ldc_w 260
    //   589: invokevirtual 258	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   592: ifne +33 -> 625
    //   595: aload_2
    //   596: ldc_w 262
    //   599: invokevirtual 258	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   602: ifne +23 -> 625
    //   605: aload_2
    //   606: ldc_w 264
    //   609: invokevirtual 258	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   612: ifne +13 -> 625
    //   615: aload_2
    //   616: ldc_w 266
    //   619: invokevirtual 258	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   622: ifeq +34 -> 656
    //   625: aload_0
    //   626: getfield 32	com/jtpgodorncrqoeurl/ae:b	Lcom/jtpgodorncrqoeurl/AdController;
    //   629: invokevirtual 67	com/jtpgodorncrqoeurl/AdController:destroyAd	()V
    //   632: aload_0
    //   633: getfield 30	com/jtpgodorncrqoeurl/ae:a	Landroid/content/Context;
    //   636: new 268	android/content/Intent
    //   639: dup
    //   640: ldc_w 270
    //   643: aload_2
    //   644: invokestatic 276	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   647: invokespecial 279	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   650: invokevirtual 283	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   653: goto -311 -> 342
    //   656: aload_2
    //   657: ldc_w 285
    //   660: invokevirtual 213	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   663: ifeq +34 -> 697
    //   666: aload_0
    //   667: getfield 32	com/jtpgodorncrqoeurl/ae:b	Lcom/jtpgodorncrqoeurl/AdController;
    //   670: invokevirtual 67	com/jtpgodorncrqoeurl/AdController:destroyAd	()V
    //   673: aload_0
    //   674: getfield 30	com/jtpgodorncrqoeurl/ae:a	Landroid/content/Context;
    //   677: new 268	android/content/Intent
    //   680: dup
    //   681: ldc_w 270
    //   684: aload_2
    //   685: invokestatic 276	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   688: invokespecial 279	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   691: invokevirtual 283	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   694: goto -352 -> 342
    //   697: aload_2
    //   698: ldc_w 287
    //   701: invokevirtual 258	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   704: ifeq +34 -> 738
    //   707: aload_0
    //   708: getfield 32	com/jtpgodorncrqoeurl/ae:b	Lcom/jtpgodorncrqoeurl/AdController;
    //   711: invokevirtual 67	com/jtpgodorncrqoeurl/AdController:destroyAd	()V
    //   714: aload_0
    //   715: getfield 30	com/jtpgodorncrqoeurl/ae:a	Landroid/content/Context;
    //   718: new 268	android/content/Intent
    //   721: dup
    //   722: ldc_w 270
    //   725: aload_2
    //   726: invokestatic 276	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   729: invokespecial 279	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   732: invokevirtual 283	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   735: goto -393 -> 342
    //   738: aload_0
    //   739: getfield 24	com/jtpgodorncrqoeurl/ae:d	Z
    //   742: ifeq +43 -> 785
    //   745: aload_0
    //   746: getfield 26	com/jtpgodorncrqoeurl/ae:e	Z
    //   749: ifne +36 -> 785
    //   752: ldc 41
    //   754: ldc_w 289
    //   757: invokestatic 48	com/jtpgodorncrqoeurl/AdLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   760: aload_0
    //   761: getfield 19	com/jtpgodorncrqoeurl/ae:g	Lcom/jtpgodorncrqoeurl/AdWebView;
    //   764: iconst_0
    //   765: invokevirtual 190	com/jtpgodorncrqoeurl/AdWebView:setVisibility	(I)V
    //   768: aload_0
    //   769: getfield 32	com/jtpgodorncrqoeurl/ae:b	Lcom/jtpgodorncrqoeurl/AdController;
    //   772: invokevirtual 193	com/jtpgodorncrqoeurl/AdController:showElements	()V
    //   775: aload_0
    //   776: getfield 32	com/jtpgodorncrqoeurl/ae:b	Lcom/jtpgodorncrqoeurl/AdController;
    //   779: invokevirtual 292	com/jtpgodorncrqoeurl/AdController:onLinkClicked	()V
    //   782: goto -440 -> 342
    //   785: ldc 41
    //   787: ldc_w 294
    //   790: invokestatic 48	com/jtpgodorncrqoeurl/AdLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   793: aload_0
    //   794: iconst_0
    //   795: putfield 26	com/jtpgodorncrqoeurl/ae:e	Z
    //   798: goto -456 -> 342
    //   801: astore_1
    //   802: goto -404 -> 398
    //   805: astore 6
    //   807: goto -342 -> 465
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	810	0	this	ae
    //   0	810	1	paramWebView	WebView
    //   0	810	2	paramString	String
    //   168	370	3	i	int
    //   105	335	4	bool	boolean
    //   154	129	5	localObject1	Object
    //   436	1	5	localException1	Exception
    //   445	37	5	localObject2	Object
    //   459	3	6	str	String
    //   805	1	6	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   88	107	436	java/lang/Exception
    //   126	220	500	java/lang/Exception
    //   385	398	801	java/lang/Exception
    //   447	461	805	java/lang/Exception
  }
  
  public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AdLog.i("LBAdController", "onPageStarted");
    this.d = false;
    paramWebView.setPadding(0, 0, 0, 0);
    paramWebView.setInitialScale(100);
    paramWebView.setVerticalScrollBarEnabled(false);
    paramWebView.setHorizontalScrollBarEnabled(false);
    if (((InputMethodManager)this.a.getSystemService("input_method")).isAcceptingText()) {
      paramWebView.setVerticalScrollBarEnabled(true);
    }
    this.g.setVisibility(8);
    this.b.hideElements();
    if (this.f) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!paramString.equals(AdWebView.a(this.g))) {
            break;
          }
          AdLog.i("LBAdController", "Home loaded - loading = " + AdWebView.b(this.g));
        } while (AdWebView.b(this.g));
        try
        {
          if (AdWebView.c(this.g).get("useclickwindow").equals("1"))
          {
            AdLog.i("LBAdController", "Going to use ClickWindow details");
            this.b.setHomeLoaded(true);
            AdWebView.a(this.g, false);
            this.b.setLoading(AdWebView.b(this.g));
            return;
          }
        }
        catch (Exception paramWebView)
        {
          AdLog.e("LBAdController", "Exception - " + paramWebView.getMessage());
          return;
        }
        AdLog.i("LBAdController", "Normal window to be used");
        return;
        AdLog.d("LBAdController", "Link clicked!!");
      } while (AdWebView.b(this.g));
      if ((AdWebView.d(this.g)) || (paramString.startsWith("market://")) || (paramString.startsWith("http://market.android.com")) || (paramString.startsWith("https://market.android.com")) || (paramString.startsWith("https://play.google.com/")) || (paramString.startsWith("http://play.google.com/")))
      {
        paramWebView.stopLoading();
        this.b.destroyAd();
        return;
      }
      if (paramString.contains("usenative=1"))
      {
        paramWebView.stopLoading();
        this.b.destroyAd();
        return;
      }
      if (paramString.startsWith("tel:"))
      {
        paramWebView.stopLoading();
        this.b.destroyAd();
        return;
      }
      int i = AdWebView.e(this.g);
      paramWebView = new String[] { "Loading....Please Wait!", "Loading....Connecting!" }[(i % 2)];
    } while ((AdWebView.f(this.g) != null) && (AdWebView.f(this.g).isShowing()));
    AdWebView.a(this.g, ProgressDialog.show(this.a, "", paramWebView, true));
  }
  
  public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if (paramInt != -10)
    {
      this.g.setVisibility(8);
      AdLog.d("LBAdController", "Error received - Code=" + paramInt + ", Description = " + paramString1 + ", failURL - " + paramString2);
      this.f = true;
    }
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    AdLog.i("LBAdController", "shouldOverrideUrlLoading");
    if (!this.d) {
      this.e = true;
    }
    this.d = false;
    this.f = false;
    paramWebView.loadUrl(paramString);
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/jtpgodorncrqoeurl/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */