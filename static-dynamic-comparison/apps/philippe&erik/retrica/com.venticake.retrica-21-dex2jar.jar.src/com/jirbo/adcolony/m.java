package com.jirbo.adcolony;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.HashMap;

class m
{
  WebView a;
  Activity b;
  ADCVideo c;
  Handler d;
  Runnable e;
  AdColonyAd f;
  String g;
  
  public m(ADCVideo paramADCVideo, WebView paramWebView, Activity paramActivity)
  {
    this.a = paramWebView;
    this.b = paramActivity;
    this.c = paramADCVideo;
    this.d = new Handler();
    this.e = new Runnable()
    {
      public void run()
      {
        a.A = false;
      }
    };
  }
  
  void a()
  {
    a.A = true;
    this.d.postDelayed(this.e, 1000L);
    a.a("html5_interaction", this.g, this.c.F);
    String str = Environment.getExternalStorageDirectory().toString() + "/Pictures/AdColony_Screenshots/" + "AdColony_Screenshot_" + System.currentTimeMillis() + ".jpg";
    Object localObject2 = this.a.getRootView();
    ((View)localObject2).setDrawingCacheEnabled(true);
    Object localObject1 = Bitmap.createBitmap(((View)localObject2).getDrawingCache());
    ((View)localObject2).setDrawingCacheEnabled(false);
    localObject2 = new File(Environment.getExternalStorageDirectory().toString() + "/Pictures");
    File localFile = new File(Environment.getExternalStorageDirectory().toString() + "/Pictures/AdColony_Screenshots");
    try
    {
      ((File)localObject2).mkdir();
      localFile.mkdir();
      localObject2 = new File(str);
      try
      {
        localObject2 = new FileOutputStream((File)localObject2);
        ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 90, (OutputStream)localObject2);
        ((OutputStream)localObject2).flush();
        ((OutputStream)localObject2).close();
        localObject1 = this.b;
        localObject2 = new MediaScannerConnection.OnScanCompletedListener()
        {
          public void onScanCompleted(String paramAnonymousString, Uri paramAnonymousUri)
          {
            Toast.makeText(m.this.b, "Screenshot saved to Gallery!", 0).show();
          }
        };
        MediaScannerConnection.scanFile((Context)localObject1, new String[] { str }, null, (MediaScannerConnection.OnScanCompletedListener)localObject2);
        return;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        Toast.makeText(this.b, "Error saving screenshot.", 0).show();
        l.a.a("ADC [info] FileNotFoundException in MRAIDCommandTakeScreenshot");
        return;
      }
      catch (IOException localIOException)
      {
        Toast.makeText(this.b, "Error saving screenshot.", 0).show();
        l.a.a("ADC [info] IOException in MRAIDCommandTakeScreenshot");
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  void a(String paramString)
  {
    paramString = paramString.replace("mraid://", "");
    if (paramString.contains("?"))
    {
      arrayOfString = paramString.split("\\?");
      paramString = arrayOfString[0];
      if (arrayOfString == null) {
        break label110;
      }
    }
    HashMap localHashMap;
    label110:
    for (String[] arrayOfString = arrayOfString[1].split("&");; arrayOfString = new String[0])
    {
      localHashMap = new HashMap();
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        localHashMap.put(str.split("=")[0], str.split("=")[1]);
        i += 1;
      }
      arrayOfString = null;
      break;
    }
    this.f = a.H;
    this.g = ("{\"ad_slot\":" + this.f.h.k.d + "}");
    if (paramString.equals("send_adc_event")) {
      b((String)localHashMap.get("type"));
    }
    for (;;)
    {
      f("adc_bridge.nativeCallComplete()");
      return;
      if (paramString.equals("close")) {
        b();
      } else if ((paramString.equals("open_store")) && (!a.A)) {
        c((String)localHashMap.get("item"));
      } else if ((paramString.equals("open")) && (!a.A)) {
        d((String)localHashMap.get("url"));
      } else if (paramString.equals("expand")) {
        e((String)localHashMap.get("url"));
      } else if ((paramString.equals("create_calendar_event")) && (!a.A)) {
        b(localHashMap);
      } else if ((paramString.equals("mail")) && (!a.A)) {
        c(localHashMap);
      } else if ((paramString.equals("sms")) && (!a.A)) {
        d(localHashMap);
      } else if ((paramString.equals("tel")) && (!a.A)) {
        e(localHashMap);
      } else if (paramString.equals("custom_event")) {
        f(localHashMap);
      } else if ((paramString.equals("launch_app")) && (!a.A)) {
        g(localHashMap);
      } else if (paramString.equals("check_app_presence")) {
        h(localHashMap);
      } else if (paramString.equals("auto_play")) {
        i(localHashMap);
      } else if (paramString.equals("save_screenshot")) {
        a();
      } else if ((paramString.equals("social_post")) && (!a.A)) {
        a(localHashMap);
      }
    }
  }
  
  void a(HashMap paramHashMap)
  {
    a.A = true;
    this.d.postDelayed(this.e, 1000L);
    String str = g((String)paramHashMap.get("text"));
    paramHashMap = g((String)paramHashMap.get("url"));
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setType("text/plain");
    localIntent.putExtra("android.intent.extra.TEXT", str + " " + paramHashMap);
    this.b.startActivity(Intent.createChooser(localIntent, "Share this post using..."));
  }
  
  void b()
  {
    l.a.b("ADC [info] MRAIDCommandClose called");
    this.b.finish();
    a.K.a(this.c.F);
  }
  
  void b(String paramString)
  {
    l.a.a("ADC [info] MRAIDCommandSendADCEvent called with type: ").b(paramString);
    a.a(paramString, this.c.F);
  }
  
  /* Error */
  void b(HashMap paramHashMap)
  {
    // Byte code:
    //   0: getstatic 190	com/jirbo/adcolony/l:a	Lcom/jirbo/adcolony/l;
    //   3: ldc_w 396
    //   6: invokevirtual 195	com/jirbo/adcolony/l:a	(Ljava/lang/String;)Lcom/jirbo/adcolony/l;
    //   9: aload_1
    //   10: invokevirtual 377	com/jirbo/adcolony/l:b	(Ljava/lang/Object;)Lcom/jirbo/adcolony/l;
    //   13: pop
    //   14: iconst_1
    //   15: putstatic 56	com/jirbo/adcolony/a:A	Z
    //   18: aload_0
    //   19: getfield 38	com/jirbo/adcolony/m:d	Landroid/os/Handler;
    //   22: aload_0
    //   23: getfield 43	com/jirbo/adcolony/m:e	Ljava/lang/Runnable;
    //   26: ldc2_w 57
    //   29: invokevirtual 62	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   32: pop
    //   33: ldc 64
    //   35: aload_0
    //   36: getfield 66	com/jirbo/adcolony/m:g	Ljava/lang/String;
    //   39: aload_0
    //   40: getfield 33	com/jirbo/adcolony/m:c	Lcom/jirbo/adcolony/ADCVideo;
    //   43: getfield 71	com/jirbo/adcolony/ADCVideo:F	Lcom/jirbo/adcolony/AdColonyAd;
    //   46: invokestatic 74	com/jirbo/adcolony/a:a	(Ljava/lang/String;Ljava/lang/String;Lcom/jirbo/adcolony/AdColonyAd;)V
    //   49: new 398	java/text/SimpleDateFormat
    //   52: dup
    //   53: ldc_w 400
    //   56: invokespecial 401	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   59: astore 20
    //   61: new 398	java/text/SimpleDateFormat
    //   64: dup
    //   65: ldc_w 403
    //   68: invokespecial 401	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   71: astore 15
    //   73: new 398	java/text/SimpleDateFormat
    //   76: dup
    //   77: ldc_w 405
    //   80: invokespecial 401	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   83: astore 18
    //   85: aload_0
    //   86: aload_1
    //   87: ldc_w 407
    //   90: invokevirtual 269	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   93: checkcast 168	java/lang/String
    //   96: checkcast 168	java/lang/String
    //   99: invokevirtual 341	com/jirbo/adcolony/m:g	(Ljava/lang/String;)Ljava/lang/String;
    //   102: astore 16
    //   104: aload_0
    //   105: aload_1
    //   106: ldc_w 409
    //   109: invokevirtual 269	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   112: checkcast 168	java/lang/String
    //   115: checkcast 168	java/lang/String
    //   118: invokevirtual 341	com/jirbo/adcolony/m:g	(Ljava/lang/String;)Ljava/lang/String;
    //   121: pop
    //   122: aload_0
    //   123: aload_1
    //   124: ldc_w 411
    //   127: invokevirtual 269	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   130: checkcast 168	java/lang/String
    //   133: checkcast 168	java/lang/String
    //   136: invokevirtual 341	com/jirbo/adcolony/m:g	(Ljava/lang/String;)Ljava/lang/String;
    //   139: astore 14
    //   141: aload_0
    //   142: aload_1
    //   143: ldc_w 413
    //   146: invokevirtual 269	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   149: checkcast 168	java/lang/String
    //   152: checkcast 168	java/lang/String
    //   155: invokevirtual 341	com/jirbo/adcolony/m:g	(Ljava/lang/String;)Ljava/lang/String;
    //   158: astore 19
    //   160: aload_0
    //   161: aload_1
    //   162: ldc_w 415
    //   165: invokevirtual 269	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   168: checkcast 168	java/lang/String
    //   171: checkcast 168	java/lang/String
    //   174: invokevirtual 341	com/jirbo/adcolony/m:g	(Ljava/lang/String;)Ljava/lang/String;
    //   177: astore 10
    //   179: aload_0
    //   180: aload_1
    //   181: ldc_w 417
    //   184: invokevirtual 269	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   187: checkcast 168	java/lang/String
    //   190: checkcast 168	java/lang/String
    //   193: invokevirtual 341	com/jirbo/adcolony/m:g	(Ljava/lang/String;)Ljava/lang/String;
    //   196: astore 17
    //   198: ldc -55
    //   200: astore 13
    //   202: ldc -55
    //   204: astore 11
    //   206: new 221	java/util/HashMap
    //   209: dup
    //   210: invokespecial 222	java/util/HashMap:<init>	()V
    //   213: astore 12
    //   215: aload 17
    //   217: ldc_w 419
    //   220: ldc -55
    //   222: invokevirtual 205	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   225: ldc_w 421
    //   228: ldc -55
    //   230: invokevirtual 205	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   233: ldc_w 257
    //   236: ldc -55
    //   238: invokevirtual 205	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   241: astore 17
    //   243: aload 17
    //   245: ldc -55
    //   247: invokevirtual 263	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   250: ifne +151 -> 401
    //   253: aload 17
    //   255: ldc_w 423
    //   258: invokevirtual 217	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   261: astore 11
    //   263: aload 11
    //   265: arraylength
    //   266: istore_3
    //   267: iconst_0
    //   268: istore_2
    //   269: iload_2
    //   270: iload_3
    //   271: if_icmpge +42 -> 313
    //   274: aload 11
    //   276: iload_2
    //   277: aaload
    //   278: astore 13
    //   280: aload 12
    //   282: aload 13
    //   284: ldc_w 425
    //   287: invokevirtual 217	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   290: iconst_0
    //   291: aaload
    //   292: aload 13
    //   294: ldc_w 425
    //   297: invokevirtual 217	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   300: iconst_1
    //   301: aaload
    //   302: invokevirtual 228	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   305: pop
    //   306: iload_2
    //   307: iconst_1
    //   308: iadd
    //   309: istore_2
    //   310: goto -41 -> 269
    //   313: aload_0
    //   314: aload 12
    //   316: ldc_w 427
    //   319: invokevirtual 269	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   322: checkcast 168	java/lang/String
    //   325: checkcast 168	java/lang/String
    //   328: invokevirtual 341	com/jirbo/adcolony/m:g	(Ljava/lang/String;)Ljava/lang/String;
    //   331: astore 13
    //   333: aload_0
    //   334: aload 12
    //   336: ldc_w 429
    //   339: invokevirtual 269	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   342: checkcast 168	java/lang/String
    //   345: checkcast 168	java/lang/String
    //   348: invokevirtual 341	com/jirbo/adcolony/m:g	(Ljava/lang/String;)Ljava/lang/String;
    //   351: invokevirtual 432	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   354: astore 11
    //   356: getstatic 190	com/jirbo/adcolony/l:a	Lcom/jirbo/adcolony/l;
    //   359: ldc_w 434
    //   362: invokevirtual 195	com/jirbo/adcolony/l:a	(Ljava/lang/String;)Lcom/jirbo/adcolony/l;
    //   365: aload 17
    //   367: invokevirtual 377	com/jirbo/adcolony/l:b	(Ljava/lang/Object;)Lcom/jirbo/adcolony/l;
    //   370: pop
    //   371: getstatic 190	com/jirbo/adcolony/l:a	Lcom/jirbo/adcolony/l;
    //   374: ldc_w 436
    //   377: invokevirtual 195	com/jirbo/adcolony/l:a	(Ljava/lang/String;)Lcom/jirbo/adcolony/l;
    //   380: aload 11
    //   382: invokevirtual 377	com/jirbo/adcolony/l:b	(Ljava/lang/Object;)Lcom/jirbo/adcolony/l;
    //   385: pop
    //   386: getstatic 190	com/jirbo/adcolony/l:a	Lcom/jirbo/adcolony/l;
    //   389: ldc_w 438
    //   392: invokevirtual 195	com/jirbo/adcolony/l:a	(Ljava/lang/String;)Lcom/jirbo/adcolony/l;
    //   395: aload 13
    //   397: invokevirtual 377	com/jirbo/adcolony/l:b	(Ljava/lang/Object;)Lcom/jirbo/adcolony/l;
    //   400: pop
    //   401: aload 10
    //   403: astore 12
    //   405: aload 10
    //   407: ldc -55
    //   409: invokevirtual 263	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   412: ifeq +22 -> 434
    //   415: aload_0
    //   416: aload_1
    //   417: ldc_w 407
    //   420: invokevirtual 269	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   423: checkcast 168	java/lang/String
    //   426: checkcast 168	java/lang/String
    //   429: invokevirtual 341	com/jirbo/adcolony/m:g	(Ljava/lang/String;)Ljava/lang/String;
    //   432: astore 12
    //   434: aload 20
    //   436: aload 14
    //   438: invokevirtual 444	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   441: astore_1
    //   442: aload 20
    //   444: aload 19
    //   446: invokevirtual 444	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   449: astore 10
    //   451: aload_1
    //   452: ifnonnull +418 -> 870
    //   455: aload 15
    //   457: aload 14
    //   459: invokevirtual 444	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   462: astore 14
    //   464: aload 14
    //   466: astore_1
    //   467: aload 15
    //   469: aload 19
    //   471: invokevirtual 444	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   474: astore 15
    //   476: aload 15
    //   478: astore 10
    //   480: aload 14
    //   482: astore_1
    //   483: aload 18
    //   485: aload 13
    //   487: invokevirtual 444	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   490: astore 13
    //   492: aload_1
    //   493: ifnonnull +40 -> 533
    //   496: aload_0
    //   497: getfield 31	com/jirbo/adcolony/m:b	Landroid/app/Activity;
    //   500: ldc_w 446
    //   503: iconst_0
    //   504: invokestatic 182	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   507: invokevirtual 185	android/widget/Toast:show	()V
    //   510: return
    //   511: astore_1
    //   512: aconst_null
    //   513: astore_1
    //   514: aconst_null
    //   515: astore 10
    //   517: goto -66 -> 451
    //   520: astore 14
    //   522: goto -39 -> 483
    //   525: astore 13
    //   527: aconst_null
    //   528: astore 13
    //   530: goto -38 -> 492
    //   533: aload_1
    //   534: invokevirtual 451	java/util/Date:getTime	()J
    //   537: lstore 6
    //   539: aload 10
    //   541: invokevirtual 451	java/util/Date:getTime	()J
    //   544: lstore 8
    //   546: lconst_0
    //   547: lstore 4
    //   549: aload 13
    //   551: ifnull +19 -> 570
    //   554: aload 13
    //   556: invokevirtual 451	java/util/Date:getTime	()J
    //   559: aload_1
    //   560: invokevirtual 451	java/util/Date:getTime	()J
    //   563: lsub
    //   564: ldc2_w 57
    //   567: ldiv
    //   568: lstore 4
    //   570: aload 11
    //   572: ldc_w 453
    //   575: invokevirtual 263	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   578: ifeq +157 -> 735
    //   581: lload 4
    //   583: ldc2_w 454
    //   586: ldiv
    //   587: lconst_1
    //   588: ladd
    //   589: lstore 4
    //   591: aload 17
    //   593: ldc -55
    //   595: invokevirtual 263	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   598: ifne +209 -> 807
    //   601: new 343	android/content/Intent
    //   604: dup
    //   605: ldc_w 457
    //   608: invokespecial 346	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   611: ldc_w 459
    //   614: invokevirtual 352	android/content/Intent:setType	(Ljava/lang/String;)Landroid/content/Intent;
    //   617: ldc_w 461
    //   620: aload 12
    //   622: invokevirtual 360	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   625: ldc_w 407
    //   628: aload 16
    //   630: invokevirtual 360	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   633: ldc_w 463
    //   636: lload 6
    //   638: invokevirtual 466	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   641: ldc_w 468
    //   644: lload 8
    //   646: invokevirtual 466	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   649: ldc_w 470
    //   652: new 76	java/lang/StringBuilder
    //   655: dup
    //   656: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   659: ldc_w 472
    //   662: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: aload 11
    //   667: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: ldc_w 474
    //   673: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: ldc_w 476
    //   679: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: lload 4
    //   684: invokevirtual 106	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   687: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   690: invokevirtual 360	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   693: astore_1
    //   694: getstatic 190	com/jirbo/adcolony/l:a	Lcom/jirbo/adcolony/l;
    //   697: ldc_w 478
    //   700: invokevirtual 195	com/jirbo/adcolony/l:a	(Ljava/lang/String;)Lcom/jirbo/adcolony/l;
    //   703: lload 4
    //   705: l2d
    //   706: invokevirtual 481	com/jirbo/adcolony/l:b	(D)Lcom/jirbo/adcolony/l;
    //   709: pop
    //   710: aload_0
    //   711: getfield 31	com/jirbo/adcolony/m:b	Landroid/app/Activity;
    //   714: aload_1
    //   715: invokevirtual 372	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   718: return
    //   719: astore_1
    //   720: aload_0
    //   721: getfield 31	com/jirbo/adcolony/m:b	Landroid/app/Activity;
    //   724: ldc_w 446
    //   727: iconst_0
    //   728: invokestatic 182	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   731: invokevirtual 185	android/widget/Toast:show	()V
    //   734: return
    //   735: aload 11
    //   737: ldc_w 483
    //   740: invokevirtual 263	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   743: ifeq +16 -> 759
    //   746: lload 4
    //   748: ldc2_w 484
    //   751: ldiv
    //   752: lconst_1
    //   753: ladd
    //   754: lstore 4
    //   756: goto -165 -> 591
    //   759: aload 11
    //   761: ldc_w 487
    //   764: invokevirtual 263	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   767: ifeq +16 -> 783
    //   770: lload 4
    //   772: ldc2_w 488
    //   775: ldiv
    //   776: lconst_1
    //   777: ladd
    //   778: lstore 4
    //   780: goto -189 -> 591
    //   783: aload 11
    //   785: ldc_w 491
    //   788: invokevirtual 263	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   791: ifeq +73 -> 864
    //   794: lload 4
    //   796: ldc2_w 492
    //   799: ldiv
    //   800: lconst_1
    //   801: ladd
    //   802: lstore 4
    //   804: goto -213 -> 591
    //   807: new 343	android/content/Intent
    //   810: dup
    //   811: ldc_w 457
    //   814: invokespecial 346	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   817: ldc_w 459
    //   820: invokevirtual 352	android/content/Intent:setType	(Ljava/lang/String;)Landroid/content/Intent;
    //   823: ldc_w 461
    //   826: aload 12
    //   828: invokevirtual 360	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   831: ldc_w 407
    //   834: aload 16
    //   836: invokevirtual 360	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   839: ldc_w 463
    //   842: lload 6
    //   844: invokevirtual 466	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   847: ldc_w 468
    //   850: lload 8
    //   852: invokevirtual 466	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   855: astore_1
    //   856: goto -146 -> 710
    //   859: astore 10
    //   861: goto -347 -> 514
    //   864: lconst_0
    //   865: lstore 4
    //   867: goto -276 -> 591
    //   870: goto -387 -> 483
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	873	0	this	m
    //   0	873	1	paramHashMap	HashMap
    //   268	42	2	i	int
    //   266	6	3	j	int
    //   547	319	4	l1	long
    //   537	306	6	l2	long
    //   544	307	8	l3	long
    //   177	363	10	localObject1	Object
    //   859	1	10	localException1	Exception
    //   204	580	11	localObject2	Object
    //   213	614	12	localObject3	Object
    //   200	291	13	localObject4	Object
    //   525	1	13	localException2	Exception
    //   528	27	13	localObject5	Object
    //   139	342	14	localObject6	Object
    //   520	1	14	localException3	Exception
    //   71	406	15	localObject7	Object
    //   102	733	16	str1	String
    //   196	396	17	str2	String
    //   83	401	18	localSimpleDateFormat1	java.text.SimpleDateFormat
    //   158	312	19	str3	String
    //   59	384	20	localSimpleDateFormat2	java.text.SimpleDateFormat
    // Exception table:
    //   from	to	target	type
    //   434	442	511	java/lang/Exception
    //   455	464	520	java/lang/Exception
    //   467	476	520	java/lang/Exception
    //   483	492	525	java/lang/Exception
    //   710	718	719	java/lang/Exception
    //   442	451	859	java/lang/Exception
  }
  
  void c(String paramString)
  {
    l.a.a("ADC [info] MRAIDCommandOpenStore called with item: ").b(paramString);
    a.A = true;
    this.d.postDelayed(this.e, 1000L);
    a.a("html5_interaction", this.g, this.c.F);
    paramString = g(paramString);
    try
    {
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      this.b.startActivity(paramString);
      return;
    }
    catch (Exception paramString)
    {
      Toast.makeText(this.b, "Unable to open store.", 0).show();
    }
  }
  
  void c(HashMap paramHashMap)
  {
    l.a.a("ADC [info] MRAIDCommandMail called with parameters: ").b(paramHashMap);
    a.A = true;
    this.d.postDelayed(this.e, 1000L);
    String str1 = g((String)paramHashMap.get("subject"));
    String str2 = g((String)paramHashMap.get("body"));
    paramHashMap = g((String)paramHashMap.get("to"));
    a.a("html5_interaction", this.g, this.c.F);
    try
    {
      Intent localIntent = new Intent("android.intent.action.SEND");
      localIntent.setType("plain/text");
      localIntent.putExtra("android.intent.extra.SUBJECT", str1).putExtra("android.intent.extra.TEXT", str2).putExtra("android.intent.extra.EMAIL", new String[] { paramHashMap });
      this.b.startActivity(localIntent);
      return;
    }
    catch (Exception paramHashMap)
    {
      paramHashMap.printStackTrace();
      Toast.makeText(this.b, "Unable to launch email client.", 0).show();
    }
  }
  
  void d(String paramString)
  {
    l.a.a("ADC [info] MRAIDCommandOpen called with url: ").b(paramString);
    a.A = true;
    this.d.postDelayed(this.e, 1000L);
    Object localObject = g(paramString);
    if (((String)localObject).startsWith("adcvideo"))
    {
      paramString = ((String)localObject).replace("adcvideo", "http");
      this.c.a(paramString);
      return;
    }
    String str;
    if (paramString.contains("youtube")) {
      try
      {
        localObject = ((String)localObject).substring(((String)localObject).indexOf('v') + 2);
        localObject = new Intent("android.intent.action.VIEW", Uri.parse("vnd.youtube:" + (String)localObject));
        this.b.startActivity((Intent)localObject);
        return;
      }
      catch (Exception localException)
      {
        str = g(paramString);
        paramString = str;
        if (str.contains("safari")) {
          paramString = str.replace("safari", "http");
        }
        paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        this.b.startActivity(paramString);
        return;
      }
    }
    if (str.startsWith("browser"))
    {
      a.a("html5_interaction", this.c.F);
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(str.replace("browser", "http")));
      this.b.startActivity(paramString);
      return;
    }
    a.a("html5_interaction", this.g, this.c.F);
    AdColonyBrowser.url = str;
    paramString = new Intent(this.b, AdColonyBrowser.class);
    this.b.startActivity(paramString);
  }
  
  void d(HashMap paramHashMap)
  {
    l.a.a("ADC [info] MRAIDCommandSMS called with parameters: ").b(paramHashMap);
    a.A = true;
    this.d.postDelayed(this.e, 1000L);
    String str = g((String)paramHashMap.get("to"));
    paramHashMap = g((String)paramHashMap.get("body"));
    a.a("html5_interaction", this.g, this.c.F);
    try
    {
      paramHashMap = new Intent("android.intent.action.VIEW", Uri.parse("sms:" + str)).putExtra("sms_body", paramHashMap);
      this.b.startActivity(paramHashMap);
      return;
    }
    catch (Exception paramHashMap)
    {
      paramHashMap.printStackTrace();
      Toast.makeText(this.b, "Failed to create sms.", 0).show();
    }
  }
  
  void e(String paramString)
  {
    l.a.a("ADC [info] MRAIDCommandExpand called with url: ").b(paramString);
    f("adc_bridge.fireChangeEvent({state:'expanded'});");
  }
  
  void e(HashMap paramHashMap)
  {
    l.a.a("ADC [info] MRAIDCommandTel called with parameters: ").b(paramHashMap);
    a.A = true;
    this.d.postDelayed(this.e, 1000L);
    paramHashMap = g((String)paramHashMap.get("number"));
    a.a("html5_interaction", this.g, this.c.F);
    try
    {
      paramHashMap = new Intent("android.intent.action.DIAL").setData(Uri.parse("tel:" + paramHashMap));
      this.b.startActivity(paramHashMap);
      return;
    }
    catch (Exception paramHashMap)
    {
      Toast.makeText(this.b, "Failed to dial number.", 0).show();
    }
  }
  
  void f(String paramString)
  {
    this.a.loadUrl("javascript:" + paramString);
  }
  
  void f(HashMap paramHashMap)
  {
    l.a.a("ADC [info] MRAIDCommandSendCustomADCEvent called with parameters: ").b(paramHashMap);
    paramHashMap = g((String)paramHashMap.get("event_type"));
    a.a("custom_event", "{\"event_type\":\"" + paramHashMap + "\",\"ad_slot\":" + this.f.h.k.d + "}", this.c.F);
  }
  
  String g(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return URLDecoder.decode(paramString);
  }
  
  void g(HashMap paramHashMap)
  {
    l.a.a("ADC [info] MRAIDCommandLaunchApp called with parameters: ").b(paramHashMap);
    a.A = true;
    this.d.postDelayed(this.e, 1000L);
    paramHashMap = g((String)paramHashMap.get("handle"));
    a.a("html5_interaction", this.g, this.c.F);
    try
    {
      paramHashMap = this.b.getPackageManager().getLaunchIntentForPackage(paramHashMap);
      this.b.startActivity(paramHashMap);
      return;
    }
    catch (Exception paramHashMap)
    {
      Toast.makeText(this.b, "Failed to launch external application.", 0).show();
    }
  }
  
  void h(HashMap paramHashMap)
  {
    l.a.a("ADC [info] MRAIDCommandCheckAppPresence called with parameters: ").b(paramHashMap);
    paramHashMap = g((String)paramHashMap.get("handle"));
    boolean bool = ab.a(paramHashMap);
    f("adc_bridge.fireAppPresenceEvent('" + paramHashMap + "'," + bool + ")");
  }
  
  void i(HashMap paramHashMap)
  {
    l.a.a("ADC [info] MRAIDCommandCheckAutoPlay called with parameters: ").b(paramHashMap);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */