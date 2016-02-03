package com.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.scoreloop.client.android.core.utils.Logger;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class a
  extends FrameLayout
{
  private static final String d = a.class.getSimpleName();
  private static final int e = a.a.a(0.42578125F, 0.515625F, 0.703125F, 1.0F);
  private static final int f = a.a.a(0.3F, 0.3F, 0.3F, 0.8F);
  protected c a;
  protected WebView b;
  protected Context c;
  private j g;
  private URL h;
  private TextView i;
  private ImageButton j;
  private LinearLayout k;
  private b l;
  
  public a(Context paramContext, c paramc)
  {
    super(paramContext);
    this.c = paramContext;
    this.g = null;
    this.a = paramc;
    this.h = null;
    setWillNotDraw(false);
    setPadding(20, 20, 20, 20);
    this.k = new LinearLayout(paramContext);
    this.k.setOrientation(1);
    this.k.setBackgroundColor(-1);
    this.k.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.i = new TextView(paramContext);
    this.i.setText("Connect to Facebook");
    this.i.setBackgroundColor(e);
    this.i.setTextColor(-1);
    this.i.setTypeface(Typeface.DEFAULT_BOLD);
    this.i.setPadding(8, 4, 8, 4);
    this.i.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    paramc = a.a.a(getClass(), "com/codecarpet/fbconnect/resources/fbicon.png");
    Drawable localDrawable = a.a.a(getClass(), "com/codecarpet/fbconnect/resources/close.png");
    this.i.setCompoundDrawablePadding(5);
    this.i.setCompoundDrawablesWithIntrinsicBounds(paramc, null, null, null);
    this.j = new ImageButton(paramContext);
    this.j.setBackgroundColor(0);
    this.j.setImageDrawable(localDrawable);
    this.j.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        switch (paramAnonymousMotionEvent.getAction())
        {
        default: 
          return false;
        case 0: 
          a.a(a.this).setBackgroundColor(a.d());
          return true;
        }
        a.a(a.this).setBackgroundColor(a.e());
        a.b(a.this);
        return true;
      }
    });
    this.b = new WebView(paramContext);
    this.b.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.l = new b(null);
    this.b.setWebViewClient(this.l);
    paramContext = this.b.getSettings();
    paramContext.setJavaScriptEnabled(true);
    paramContext.setDefaultTextEncodingName("UTF-8");
    this.k.addView(this.b);
    addView(this.k);
  }
  
  private String a(Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder("\r\n--").append("3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f").append("\r\n");
    localStringBuilder1.append("--").append("3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f").append("\r\n");
    paramMap = paramMap.entrySet().iterator();
    if (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localStringBuilder1.append("Content-Disposition: form-data; name=\"").append((String)localEntry.getKey()).append("\"\r\n\r\n");
      String str = (String)localEntry.getValue();
      if ("user_message_prompt".equals(localEntry.getKey())) {
        localStringBuilder1.append(str);
      }
      for (;;)
      {
        localStringBuilder1.append(localStringBuilder2);
        break;
        localStringBuilder1.append(a.a.a(str));
      }
    }
    return localStringBuilder1.toString();
  }
  
  private URL a(String paramString, Map<String, String> paramMap)
    throws MalformedURLException
  {
    paramString = new StringBuilder(paramString);
    paramMap = paramMap.entrySet().iterator();
    if (paramMap.hasNext()) {
      paramString.append('?');
    }
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      paramString.append((String)localEntry.getKey());
      paramString.append('=');
      paramString.append(a.a.a((CharSequence)localEntry.getValue()));
      if (paramMap.hasNext()) {
        paramString.append('&');
      }
    }
    return new URL(paramString.toString());
  }
  
  private void a(Canvas paramCanvas, Rect paramRect, int paramInt, float paramFloat)
  {
    Paint localPaint = new Paint();
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setColor(paramInt);
    localPaint.setAntiAlias(true);
    if (paramFloat > 0.0F)
    {
      paramCanvas.drawRoundRect(new RectF(paramRect), paramFloat, paramFloat, localPaint);
      return;
    }
    paramCanvas.drawRect(paramRect, localPaint);
  }
  
  /* Error */
  private void a(String paramString1, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, boolean paramBoolean, CookieSyncManager paramCookieSyncManager, CookieManager paramCookieManager)
    throws MalformedURLException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 14
    //   3: aconst_null
    //   4: astore 10
    //   6: aconst_null
    //   7: astore 13
    //   9: aload_0
    //   10: getfield 71	com/a/a/a:h	Ljava/net/URL;
    //   13: invokevirtual 329	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   16: checkcast 331	java/net/HttpURLConnection
    //   19: astore 11
    //   21: aload 11
    //   23: astore 13
    //   25: aload 11
    //   27: astore 14
    //   29: aload 11
    //   31: astore 10
    //   33: aload_1
    //   34: ldc_w 333
    //   37: invokevirtual 337	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   40: ifeq +21 -> 61
    //   43: aload 11
    //   45: astore 13
    //   47: aload 11
    //   49: astore 14
    //   51: aload 11
    //   53: astore 10
    //   55: aload 11
    //   57: iconst_0
    //   58: invokevirtual 340	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   61: aload 11
    //   63: astore 13
    //   65: aload 11
    //   67: astore 14
    //   69: aload 11
    //   71: astore 10
    //   73: aload 11
    //   75: iconst_1
    //   76: invokevirtual 343	java/net/HttpURLConnection:setDoInput	(Z)V
    //   79: aload_2
    //   80: ifnull +840 -> 920
    //   83: aload 11
    //   85: astore 13
    //   87: aload 11
    //   89: astore 14
    //   91: aload 11
    //   93: astore 10
    //   95: aload 11
    //   97: aload_2
    //   98: invokevirtual 346	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   101: aload 11
    //   103: astore 13
    //   105: aload 11
    //   107: astore 14
    //   109: aload 11
    //   111: astore 10
    //   113: ldc_w 348
    //   116: aload_2
    //   117: invokevirtual 261	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   120: ifeq +26 -> 146
    //   123: aload 11
    //   125: astore 13
    //   127: aload 11
    //   129: astore 14
    //   131: aload 11
    //   133: astore 10
    //   135: aload 11
    //   137: ldc_w 350
    //   140: ldc_w 352
    //   143: invokevirtual 356	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: iload 5
    //   148: ifeq +29 -> 177
    //   151: aload 11
    //   153: astore 13
    //   155: aload 11
    //   157: astore 14
    //   159: aload 11
    //   161: astore 10
    //   163: aload 11
    //   165: ldc_w 358
    //   168: aload 7
    //   170: aload_1
    //   171: invokevirtual 364	android/webkit/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   174: invokevirtual 356	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   177: aload 11
    //   179: astore 13
    //   181: aload 11
    //   183: astore 14
    //   185: aload 11
    //   187: astore 10
    //   189: aload 11
    //   191: invokevirtual 367	java/net/HttpURLConnection:connect	()V
    //   194: aload 11
    //   196: astore 13
    //   198: aload 11
    //   200: astore 14
    //   202: aload 11
    //   204: astore 10
    //   206: ldc_w 348
    //   209: aload_2
    //   210: invokevirtual 261	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   213: ifeq +701 -> 914
    //   216: aload 11
    //   218: astore 13
    //   220: aload 11
    //   222: astore 14
    //   224: aload 11
    //   226: astore 10
    //   228: aload 11
    //   230: iconst_1
    //   231: invokevirtual 370	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   234: aload 11
    //   236: astore 13
    //   238: aload 11
    //   240: astore 14
    //   242: aload 11
    //   244: astore 10
    //   246: aload 11
    //   248: invokevirtual 374	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   251: astore 12
    //   253: aload 12
    //   255: astore 13
    //   257: aload 12
    //   259: astore 14
    //   261: aload 12
    //   263: astore 15
    //   265: aload_0
    //   266: aload 4
    //   268: invokespecial 376	com/a/a/a:a	(Ljava/util/Map;)Ljava/lang/String;
    //   271: astore 16
    //   273: aload 12
    //   275: astore 10
    //   277: aload 16
    //   279: ifnull +31 -> 310
    //   282: aload 12
    //   284: astore 13
    //   286: aload 12
    //   288: astore 14
    //   290: aload 12
    //   292: astore 15
    //   294: aload 12
    //   296: aload 16
    //   298: ldc -66
    //   300: invokevirtual 380	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   303: invokevirtual 386	java/io/OutputStream:write	([B)V
    //   306: aload 12
    //   308: astore 10
    //   310: aload 10
    //   312: astore 13
    //   314: aload 10
    //   316: astore 14
    //   318: aload 10
    //   320: astore 15
    //   322: aload 11
    //   324: invokevirtual 390	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   327: astore 12
    //   329: iconst_0
    //   330: istore 8
    //   332: aconst_null
    //   333: astore 16
    //   335: aload 11
    //   337: astore 13
    //   339: aload 12
    //   341: astore 14
    //   343: aload 10
    //   345: astore 15
    //   347: aload 11
    //   349: iload 8
    //   351: invokevirtual 394	java/net/HttpURLConnection:getHeaderFieldKey	(I)Ljava/lang/String;
    //   354: astore 19
    //   356: aload 11
    //   358: astore 13
    //   360: aload 12
    //   362: astore 14
    //   364: aload 10
    //   366: astore 15
    //   368: aload 11
    //   370: iload 8
    //   372: invokevirtual 397	java/net/HttpURLConnection:getHeaderField	(I)Ljava/lang/String;
    //   375: astore 18
    //   377: aload 19
    //   379: ifnonnull +194 -> 573
    //   382: aload 16
    //   384: astore 17
    //   386: aload 18
    //   388: ifnonnull +540 -> 928
    //   391: aload 11
    //   393: astore 13
    //   395: aload 12
    //   397: astore 14
    //   399: aload 10
    //   401: astore 15
    //   403: aload 6
    //   405: invokevirtual 402	android/webkit/CookieSyncManager:sync	()V
    //   408: iconst_0
    //   409: istore 8
    //   411: aload 11
    //   413: astore 13
    //   415: aload 12
    //   417: astore 14
    //   419: aload 10
    //   421: astore 15
    //   423: aload 11
    //   425: invokevirtual 406	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   428: invokevirtual 407	java/net/URL:toString	()Ljava/lang/String;
    //   431: ldc_w 409
    //   434: invokevirtual 413	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   437: ifeq +470 -> 907
    //   440: aload 11
    //   442: astore 13
    //   444: aload 12
    //   446: astore 14
    //   448: aload 10
    //   450: astore 15
    //   452: aload 11
    //   454: invokevirtual 406	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   457: invokevirtual 407	java/net/URL:toString	()Ljava/lang/String;
    //   460: ldc_w 415
    //   463: ldc_w 409
    //   466: invokevirtual 419	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   469: astore 6
    //   471: iconst_1
    //   472: istore 8
    //   474: aload 11
    //   476: astore 13
    //   478: aload 12
    //   480: astore 14
    //   482: aload 10
    //   484: astore 15
    //   486: aload 11
    //   488: invokevirtual 423	java/net/HttpURLConnection:getResponseCode	()I
    //   491: sipush 302
    //   494: if_icmpne +447 -> 941
    //   497: iconst_1
    //   498: istore 9
    //   500: iload 9
    //   502: iload 8
    //   504: ior
    //   505: ifeq +147 -> 652
    //   508: aload 11
    //   510: astore 13
    //   512: aload 12
    //   514: astore 14
    //   516: aload 10
    //   518: astore 15
    //   520: aload 6
    //   522: ldc_w 409
    //   525: invokevirtual 426	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   528: ifeq +124 -> 652
    //   531: aload 11
    //   533: astore 13
    //   535: aload 12
    //   537: astore 14
    //   539: aload 10
    //   541: astore 15
    //   543: aload_0
    //   544: getfield 175	com/a/a/a:l	Lcom/a/a/a$b;
    //   547: aload_0
    //   548: getfield 169	com/a/a/a:b	Landroid/webkit/WebView;
    //   551: aload 6
    //   553: invokevirtual 430	com/a/a/a$b:shouldOverrideUrlLoading	(Landroid/webkit/WebView;Ljava/lang/String;)Z
    //   556: pop
    //   557: aload 12
    //   559: invokestatic 433	a/a:a	(Ljava/io/Closeable;)V
    //   562: aload 10
    //   564: invokestatic 433	a/a:a	(Ljava/io/Closeable;)V
    //   567: aload 11
    //   569: invokestatic 436	a/a:a	(Ljava/net/HttpURLConnection;)V
    //   572: return
    //   573: aload 11
    //   575: astore 13
    //   577: aload 12
    //   579: astore 14
    //   581: aload 10
    //   583: astore 15
    //   585: aload 19
    //   587: ldc_w 438
    //   590: invokevirtual 441	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   593: ifeq +25 -> 618
    //   596: aload 11
    //   598: astore 13
    //   600: aload 12
    //   602: astore 14
    //   604: aload 10
    //   606: astore 15
    //   608: aload 7
    //   610: ldc_w 443
    //   613: aload 18
    //   615: invokevirtual 446	android/webkit/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   618: aload 11
    //   620: astore 13
    //   622: aload 12
    //   624: astore 14
    //   626: aload 10
    //   628: astore 15
    //   630: aload 16
    //   632: astore 17
    //   634: aload 19
    //   636: ldc_w 448
    //   639: invokevirtual 441	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   642: ifeq +286 -> 928
    //   645: aload 18
    //   647: astore 17
    //   649: goto +279 -> 928
    //   652: aload 11
    //   654: astore 13
    //   656: aload 12
    //   658: astore 14
    //   660: aload 10
    //   662: astore 15
    //   664: aload_0
    //   665: aload_1
    //   666: aload_2
    //   667: aload_3
    //   668: aload 4
    //   670: iload 5
    //   672: aload 12
    //   674: invokestatic 451	a/a:a	(Ljava/io/InputStream;)Ljava/lang/StringBuilder;
    //   677: invokevirtual 270	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   680: invokespecial 454	com/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;ZLjava/lang/String;)V
    //   683: aload 10
    //   685: astore_1
    //   686: aload 12
    //   688: invokestatic 433	a/a:a	(Ljava/io/Closeable;)V
    //   691: aload_1
    //   692: invokestatic 433	a/a:a	(Ljava/io/Closeable;)V
    //   695: aload 11
    //   697: invokestatic 436	a/a:a	(Ljava/net/HttpURLConnection;)V
    //   700: return
    //   701: astore_1
    //   702: aconst_null
    //   703: astore 12
    //   705: aconst_null
    //   706: astore 10
    //   708: aload 13
    //   710: astore 11
    //   712: aload 11
    //   714: astore 13
    //   716: aload 12
    //   718: astore 14
    //   720: aload 10
    //   722: astore 15
    //   724: getstatic 43	com/a/a/a:d	Ljava/lang/String;
    //   727: ldc_w 456
    //   730: invokestatic 460	com/scoreloop/client/android/core/utils/Logger:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   733: aload 12
    //   735: invokestatic 433	a/a:a	(Ljava/io/Closeable;)V
    //   738: aload 10
    //   740: invokestatic 433	a/a:a	(Ljava/io/Closeable;)V
    //   743: aload 11
    //   745: invokestatic 436	a/a:a	(Ljava/net/HttpURLConnection;)V
    //   748: return
    //   749: astore 6
    //   751: aconst_null
    //   752: astore 12
    //   754: aconst_null
    //   755: astore 10
    //   757: aload 14
    //   759: astore 11
    //   761: iload 5
    //   763: ifeq +41 -> 804
    //   766: aload 11
    //   768: astore 13
    //   770: aload 12
    //   772: astore 14
    //   774: aload 10
    //   776: astore 15
    //   778: aload_0
    //   779: aload_1
    //   780: aload_2
    //   781: aload_3
    //   782: aload 4
    //   784: iconst_0
    //   785: invokevirtual 463	com/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Z)V
    //   788: aload 12
    //   790: invokestatic 433	a/a:a	(Ljava/io/Closeable;)V
    //   793: aload 10
    //   795: invokestatic 433	a/a:a	(Ljava/io/Closeable;)V
    //   798: aload 11
    //   800: invokestatic 436	a/a:a	(Ljava/net/HttpURLConnection;)V
    //   803: return
    //   804: aload 11
    //   806: astore 13
    //   808: aload 12
    //   810: astore 14
    //   812: aload 10
    //   814: astore 15
    //   816: getstatic 43	com/a/a/a:d	Ljava/lang/String;
    //   819: ldc_w 465
    //   822: invokestatic 460	com/scoreloop/client/android/core/utils/Logger:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   825: goto -37 -> 788
    //   828: astore_1
    //   829: aload 13
    //   831: astore 10
    //   833: aload 14
    //   835: invokestatic 433	a/a:a	(Ljava/io/Closeable;)V
    //   838: aload 15
    //   840: invokestatic 433	a/a:a	(Ljava/io/Closeable;)V
    //   843: aload 10
    //   845: invokestatic 436	a/a:a	(Ljava/net/HttpURLConnection;)V
    //   848: aload_1
    //   849: athrow
    //   850: astore_1
    //   851: aconst_null
    //   852: astore 14
    //   854: aconst_null
    //   855: astore 15
    //   857: goto -24 -> 833
    //   860: astore_1
    //   861: aconst_null
    //   862: astore 14
    //   864: aload 11
    //   866: astore 10
    //   868: aload 13
    //   870: astore 15
    //   872: goto -39 -> 833
    //   875: astore 6
    //   877: aconst_null
    //   878: astore 12
    //   880: aload 14
    //   882: astore 10
    //   884: goto -123 -> 761
    //   887: astore 6
    //   889: goto -128 -> 761
    //   892: astore_1
    //   893: aconst_null
    //   894: astore 12
    //   896: aload 15
    //   898: astore 10
    //   900: goto -188 -> 712
    //   903: astore_1
    //   904: goto -192 -> 712
    //   907: aload 16
    //   909: astore 6
    //   911: goto -437 -> 474
    //   914: aconst_null
    //   915: astore 10
    //   917: goto -607 -> 310
    //   920: aconst_null
    //   921: astore 12
    //   923: aconst_null
    //   924: astore_1
    //   925: goto -239 -> 686
    //   928: iload 8
    //   930: iconst_1
    //   931: iadd
    //   932: istore 8
    //   934: aload 17
    //   936: astore 16
    //   938: goto -603 -> 335
    //   941: iconst_0
    //   942: istore 9
    //   944: goto -444 -> 500
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	947	0	this	a
    //   0	947	1	paramString1	String
    //   0	947	2	paramString2	String
    //   0	947	3	paramMap1	Map<String, String>
    //   0	947	4	paramMap2	Map<String, String>
    //   0	947	5	paramBoolean	boolean
    //   0	947	6	paramCookieSyncManager	CookieSyncManager
    //   0	947	7	paramCookieManager	CookieManager
    //   330	603	8	m	int
    //   498	445	9	n	int
    //   4	912	10	localObject1	Object
    //   19	846	11	localObject2	Object
    //   251	671	12	localObject3	Object
    //   7	862	13	localObject4	Object
    //   1	880	14	localObject5	Object
    //   263	634	15	localObject6	Object
    //   271	666	16	localObject7	Object
    //   384	551	17	localObject8	Object
    //   375	271	18	str1	String
    //   354	281	19	str2	String
    // Exception table:
    //   from	to	target	type
    //   9	21	701	java/net/URISyntaxException
    //   33	43	701	java/net/URISyntaxException
    //   55	61	701	java/net/URISyntaxException
    //   73	79	701	java/net/URISyntaxException
    //   95	101	701	java/net/URISyntaxException
    //   113	123	701	java/net/URISyntaxException
    //   135	146	701	java/net/URISyntaxException
    //   163	177	701	java/net/URISyntaxException
    //   189	194	701	java/net/URISyntaxException
    //   206	216	701	java/net/URISyntaxException
    //   228	234	701	java/net/URISyntaxException
    //   246	253	701	java/net/URISyntaxException
    //   9	21	749	java/io/IOException
    //   33	43	749	java/io/IOException
    //   55	61	749	java/io/IOException
    //   73	79	749	java/io/IOException
    //   95	101	749	java/io/IOException
    //   113	123	749	java/io/IOException
    //   135	146	749	java/io/IOException
    //   163	177	749	java/io/IOException
    //   189	194	749	java/io/IOException
    //   206	216	749	java/io/IOException
    //   228	234	749	java/io/IOException
    //   246	253	749	java/io/IOException
    //   347	356	828	finally
    //   368	377	828	finally
    //   403	408	828	finally
    //   423	440	828	finally
    //   452	471	828	finally
    //   486	497	828	finally
    //   520	531	828	finally
    //   543	557	828	finally
    //   585	596	828	finally
    //   608	618	828	finally
    //   634	645	828	finally
    //   664	683	828	finally
    //   724	733	828	finally
    //   778	788	828	finally
    //   816	825	828	finally
    //   9	21	850	finally
    //   33	43	850	finally
    //   55	61	850	finally
    //   73	79	850	finally
    //   95	101	850	finally
    //   113	123	850	finally
    //   135	146	850	finally
    //   163	177	850	finally
    //   189	194	850	finally
    //   206	216	850	finally
    //   228	234	850	finally
    //   246	253	850	finally
    //   265	273	860	finally
    //   294	306	860	finally
    //   322	329	860	finally
    //   265	273	875	java/io/IOException
    //   294	306	875	java/io/IOException
    //   322	329	875	java/io/IOException
    //   347	356	887	java/io/IOException
    //   368	377	887	java/io/IOException
    //   403	408	887	java/io/IOException
    //   423	440	887	java/io/IOException
    //   452	471	887	java/io/IOException
    //   486	497	887	java/io/IOException
    //   520	531	887	java/io/IOException
    //   543	557	887	java/io/IOException
    //   585	596	887	java/io/IOException
    //   608	618	887	java/io/IOException
    //   634	645	887	java/io/IOException
    //   664	683	887	java/io/IOException
    //   265	273	892	java/net/URISyntaxException
    //   294	306	892	java/net/URISyntaxException
    //   322	329	892	java/net/URISyntaxException
    //   347	356	903	java/net/URISyntaxException
    //   368	377	903	java/net/URISyntaxException
    //   403	408	903	java/net/URISyntaxException
    //   423	440	903	java/net/URISyntaxException
    //   452	471	903	java/net/URISyntaxException
    //   486	497	903	java/net/URISyntaxException
    //   520	531	903	java/net/URISyntaxException
    //   543	557	903	java/net/URISyntaxException
    //   585	596	903	java/net/URISyntaxException
    //   608	618	903	java/net/URISyntaxException
    //   634	645	903	java/net/URISyntaxException
    //   664	683	903	java/net/URISyntaxException
  }
  
  private void a(String paramString1, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, boolean paramBoolean, String paramString3)
    throws URISyntaxException, MalformedURLException
  {
    if (paramString3 != "")
    {
      paramString2 = paramString3.replaceAll("http:\\\\/\\\\/www.facebook.com\\\\/fbconnect:", "fbconnect:");
      paramString1 = new URI(paramString1);
      this.b.loadDataWithBaseURL("http://" + paramString1.getHost(), paramString2, "text/html", "UTF-8", "http://" + paramString1.getHost());
    }
    while (!paramBoolean) {
      return;
    }
    a(paramString1, paramString2, paramMap1, paramMap2, false);
  }
  
  private void g()
  {
    b();
    this.h = null;
  }
  
  protected void a() {}
  
  public void a(j paramj)
  {
    this.g = paramj;
  }
  
  public void a(String paramString)
  {
    this.i.setText(paramString);
  }
  
  protected void a(String paramString1, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2)
    throws MalformedURLException
  {
    a(paramString1, paramString2, paramMap1, paramMap2, true);
  }
  
  protected void a(String paramString1, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, boolean paramBoolean)
    throws MalformedURLException
  {
    CookieSyncManager localCookieSyncManager = CookieSyncManager.createInstance(this.c);
    CookieManager localCookieManager = CookieManager.getInstance();
    localCookieManager.setAcceptCookie(true);
    this.h = a(paramString1, paramMap1);
    a(paramString1, paramString2, paramMap1, paramMap2, paramBoolean, localCookieSyncManager, localCookieManager);
  }
  
  protected void a(Throwable paramThrowable)
  {
    this.g.a(this, paramThrowable);
    g();
  }
  
  protected void a(URI paramURI)
  {
    a(true);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.g != null)
    {
      if (!paramBoolean) {
        break label55;
      }
      Logger.a(getClass().getName() + " :: succedeed");
      this.g.a(this);
    }
    for (;;)
    {
      g();
      return;
      label55:
      Logger.a(getClass().getName() + " :: cancelled");
      this.g.b(this);
    }
  }
  
  protected void b() {}
  
  public void c()
  {
    a();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Rect localRect = new Rect(new Rect(paramCanvas.getClipBounds()));
    localRect.inset(10, 10);
    a(paramCanvas, localRect, f, 10.0F);
  }
  
  public static abstract class a
    implements j
  {
    public void a(a parama) {}
    
    public void a(a parama, Throwable paramThrowable) {}
    
    public boolean a(a parama, URL paramURL)
    {
      return false;
    }
    
    public void b(a parama) {}
  }
  
  private final class b
    extends WebViewClient
  {
    private b() {}
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      d.a(a.this.getContext());
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      try
      {
        paramWebView = new URI(paramString);
        Logger.a("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
        Logger.a("FBDialog", "Web view URL = " + paramString);
        if (!paramWebView.isAbsolute()) {
          Logger.a(a.f(), "Something went wrong. You probably forgot to specify API key and secret?");
        }
        if ((paramWebView.getScheme() != null) && (paramString.contains("fbconnect:")))
        {
          if ((paramString.contains("fbconnect://cancel")) || (paramString.contains("fbconnect:cancel")))
          {
            Logger.a("shouldOverrideUrlLoading:fbconnect:cancel:" + paramString);
            a.this.a(false);
          }
          for (;;)
          {
            Logger.a("shouldOverrideUrlLoading:fbconnect:return true");
            Logger.a("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
            return true;
            Logger.a("shouldOverrideUrlLoading:fbconnect:success:" + paramString);
            a.this.a(paramWebView);
          }
        }
        return false;
      }
      catch (URISyntaxException paramWebView)
      {
        paramWebView.printStackTrace();
        Logger.a("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
        return false;
        if (a.c(a.this).toExternalForm().equals(paramString))
        {
          Logger.a("shouldOverrideUrlLoading:1:return false");
          Logger.a("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
          return false;
        }
        if ((a.d(a.this) != null) && (!a.d(a.this).a(a.this, paramWebView.toURL())))
        {
          Logger.a("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
          return true;
        }
      }
      catch (MalformedURLException paramWebView)
      {
        for (;;)
        {
          paramWebView.printStackTrace();
        }
        Logger.a("#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#");
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */