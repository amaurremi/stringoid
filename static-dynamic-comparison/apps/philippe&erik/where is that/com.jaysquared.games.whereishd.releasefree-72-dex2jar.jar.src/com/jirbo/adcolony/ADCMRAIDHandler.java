package com.jirbo.adcolony;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.webkit.WebView;
import android.widget.Toast;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

class ADCMRAIDHandler
{
  AdColonyAd ad;
  Activity ctx;
  WebView end_card_web_view;
  Handler h;
  String play_order_index_json;
  Runnable r;
  ADCVideo video;
  
  public ADCMRAIDHandler(ADCVideo paramADCVideo, WebView paramWebView, Activity paramActivity)
  {
    this.end_card_web_view = paramWebView;
    this.ctx = paramActivity;
    this.video = paramADCVideo;
    this.h = new Handler();
    this.r = new Runnable()
    {
      public void run()
      {
        ADC.mraid_block = false;
      }
    };
  }
  
  void MRAIDCommandAutoPlay(HashMap paramHashMap)
  {
    ADCLog.dev.print("ADC [info] MRAIDCommandCheckAutoPlay called with parameters: ").println(paramHashMap);
  }
  
  void MRAIDCommandCheckAppPresence(HashMap paramHashMap)
  {
    ADCLog.dev.print("ADC [info] MRAIDCommandCheckAppPresence called with parameters: ").println(paramHashMap);
    paramHashMap = decode((String)paramHashMap.get("handle"));
    boolean bool = ADCUtil.application_exists(paramHashMap);
    execute_javascript("adc_bridge.fireAppPresenceEvent('" + paramHashMap + "'," + bool + ")");
  }
  
  void MRAIDCommandClose()
  {
    ADCLog.dev.println("ADC [info] MRAIDCommandClose called");
    this.ctx.finish();
    ADC.end_card_finished_handler.notify_continuation();
  }
  
  void MRAIDCommandCreateCalendarEvent(HashMap paramHashMap)
  {
    ADCLog.dev.print("ADC [info] MRAIDCommandCreateCalendarEvent called with parameters: ").println(paramHashMap);
    ADC.mraid_block = true;
    this.h.postDelayed(this.r, 1000L);
    ADC.track_ad_event("html5_interaction", this.play_order_index_json);
    localObject1 = null;
    Object localObject3 = null;
    Object localObject7 = null;
    SimpleDateFormat localSimpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd'T'hh:mmZ");
    SimpleDateFormat localSimpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssZ");
    SimpleDateFormat localSimpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
    String str2 = decode((String)paramHashMap.get("description"));
    decode((String)paramHashMap.get("location"));
    String str5 = decode((String)paramHashMap.get("start"));
    String str4 = decode((String)paramHashMap.get("end"));
    localObject6 = decode((String)paramHashMap.get("summary"));
    String str3 = decode((String)paramHashMap.get("recurrence"));
    String str1 = "";
    Object localObject4 = "";
    long l1 = 0L;
    Object localObject5 = new HashMap();
    str3 = str3.replace("\"", "").replace("{", "").replace("}", "");
    if (!str3.equals(""))
    {
      localObject4 = str3.split(",");
      int j = localObject4.length;
      int i = 0;
      while (i < j)
      {
        str1 = localObject4[i];
        ((HashMap)localObject5).put(str1.split(":")[0], str1.split(":")[1]);
        i += 1;
      }
      str1 = decode((String)((HashMap)localObject5).get("expires"));
      localObject4 = decode((String)((HashMap)localObject5).get("frequency")).toUpperCase();
      ADCLog.dev.print("Calendar Recurrence - ").println(str3);
      ADCLog.dev.print("Calendar Recurrence - frequency = ").println(localObject4);
      ADCLog.dev.print("Calendar Recurrence - expires =  ").println(str1);
    }
    localObject5 = localObject6;
    if (((String)localObject6).equals("")) {
      localObject5 = decode((String)paramHashMap.get("description"));
    }
    paramHashMap = (HashMap)localObject1;
    try
    {
      localObject1 = localSimpleDateFormat3.parse(str5);
      paramHashMap = (HashMap)localObject1;
      localObject6 = localSimpleDateFormat3.parse(str4);
      localObject3 = localObject6;
      paramHashMap = (HashMap)localObject1;
      localObject1 = localObject3;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        HashMap localHashMap;
        Object localObject2 = localHashMap;
      }
    }
    localObject6 = localObject1;
    localObject3 = paramHashMap;
    if (paramHashMap == null) {}
    for (;;)
    {
      try
      {
        localObject3 = localSimpleDateFormat2.parse(str5);
        paramHashMap = (HashMap)localObject3;
        localObject6 = localSimpleDateFormat2.parse(str4);
      }
      catch (Exception localException2)
      {
        long l3;
        long l4;
        long l2;
        localObject6 = localObject1;
        localHashMap = paramHashMap;
        continue;
      }
      try
      {
        paramHashMap = localSimpleDateFormat1.parse(str1);
        if (localObject3 == null)
        {
          Toast.makeText(this.ctx, "Unable to create Calendar Event.", 0).show();
          return;
        }
        l3 = ((Date)localObject3).getTime();
        l4 = ((Date)localObject6).getTime();
        l2 = 0L;
        if (paramHashMap != null) {
          l2 = (paramHashMap.getTime() - ((Date)localObject3).getTime()) / 1000L;
        }
        if (((String)localObject4).equals("DAILY"))
        {
          l1 = l2 / 86400L + 1L;
          if (str3.equals("")) {
            continue;
          }
          paramHashMap = new Intent("android.intent.action.EDIT").setType("vnd.android.cursor.item/event").putExtra("title", (String)localObject5).putExtra("description", str2).putExtra("beginTime", l3).putExtra("endTime", l4).putExtra("rrule", "FREQ=" + (String)localObject4 + ";" + "COUNT=" + l1);
          ADCLog.dev.print("Calendar Recurrence - count = ").println(l1);
          try
          {
            this.ctx.startActivity(paramHashMap);
            return;
          }
          catch (Exception paramHashMap)
          {
            Toast.makeText(this.ctx, "Unable to create Calendar Event.", 0).show();
            return;
          }
        }
        if (((String)localObject4).equals("WEEKLY"))
        {
          l1 = l2 / 604800L + 1L;
          continue;
        }
        if (((String)localObject4).equals("MONTHLY"))
        {
          l1 = l2 / 2629800L + 1L;
          continue;
        }
        if (!((String)localObject4).equals("YEARLY")) {
          continue;
        }
        l1 = l2 / 31557600L + 1L;
        continue;
        paramHashMap = new Intent("android.intent.action.EDIT").setType("vnd.android.cursor.item/event").putExtra("title", (String)localObject5).putExtra("description", str2).putExtra("beginTime", l3).putExtra("endTime", l4);
      }
      catch (Exception paramHashMap)
      {
        paramHashMap = (HashMap)localObject7;
      }
    }
  }
  
  void MRAIDCommandExpand(String paramString)
  {
    ADCLog.dev.print("ADC [info] MRAIDCommandExpand called with url: ").println(paramString);
    execute_javascript("adc_bridge.fireChangeEvent({state:'expanded'});");
  }
  
  void MRAIDCommandLaunchApp(HashMap paramHashMap)
  {
    ADCLog.dev.print("ADC [info] MRAIDCommandLaunchApp called with parameters: ").println(paramHashMap);
    ADC.mraid_block = true;
    this.h.postDelayed(this.r, 1000L);
    paramHashMap = decode((String)paramHashMap.get("handle"));
    ADC.track_ad_event("html5_interaction", this.play_order_index_json);
    try
    {
      paramHashMap = this.ctx.getPackageManager().getLaunchIntentForPackage(paramHashMap);
      this.ctx.startActivity(paramHashMap);
      return;
    }
    catch (Exception paramHashMap)
    {
      Toast.makeText(this.ctx, "Failed to launch external application.", 0).show();
    }
  }
  
  void MRAIDCommandMail(HashMap paramHashMap)
  {
    ADCLog.dev.print("ADC [info] MRAIDCommandMail called with parameters: ").println(paramHashMap);
    ADC.mraid_block = true;
    this.h.postDelayed(this.r, 1000L);
    String str1 = decode((String)paramHashMap.get("subject"));
    String str2 = decode((String)paramHashMap.get("body"));
    paramHashMap = decode((String)paramHashMap.get("to"));
    ADC.track_ad_event("html5_interaction", this.play_order_index_json);
    try
    {
      Intent localIntent = new Intent("android.intent.action.SEND");
      localIntent.setType("plain/text");
      localIntent.putExtra("android.intent.extra.SUBJECT", str1).putExtra("android.intent.extra.TEXT", str2).putExtra("android.intent.extra.EMAIL", new String[] { paramHashMap });
      this.ctx.startActivity(localIntent);
      return;
    }
    catch (Exception paramHashMap)
    {
      paramHashMap.printStackTrace();
      Toast.makeText(this.ctx, "Unable to launch email client.", 0).show();
    }
  }
  
  void MRAIDCommandOpen(String paramString)
  {
    ADCLog.dev.print("ADC [info] MRAIDCommandOpen called with url: ").println(paramString);
    ADC.mraid_block = true;
    this.h.postDelayed(this.r, 1000L);
    Object localObject = decode(paramString);
    if (((String)localObject).startsWith("adcvideo"))
    {
      paramString = ((String)localObject).replace("adcvideo", "http");
      this.video.playVideo(paramString);
      return;
    }
    String str;
    if (paramString.contains("youtube")) {
      try
      {
        localObject = ((String)localObject).substring(((String)localObject).indexOf('v') + 2);
        localObject = new Intent("android.intent.action.VIEW", Uri.parse("vnd.youtube:" + (String)localObject));
        this.ctx.startActivity((Intent)localObject);
        return;
      }
      catch (Exception localException)
      {
        str = decode(paramString);
        paramString = str;
        if (str.contains("safari")) {
          paramString = str.replace("safari", "http");
        }
        paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        this.ctx.startActivity(paramString);
        return;
      }
    }
    if (str.startsWith("browser"))
    {
      ADC.track_ad_event("html5_interaction");
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(str.replace("browser", "http")));
      this.ctx.startActivity(paramString);
      return;
    }
    ADC.track_ad_event("html5_interaction", this.play_order_index_json);
    AdColonyBrowser.url = str;
    paramString = new Intent(this.ctx, AdColonyBrowser.class);
    this.ctx.startActivity(paramString);
  }
  
  void MRAIDCommandOpenStore(String paramString)
  {
    ADCLog.dev.print("ADC [info] MRAIDCommandOpenStore called with item: ").println(paramString);
    ADC.mraid_block = true;
    this.h.postDelayed(this.r, 1000L);
    ADC.track_ad_event("html5_interaction", this.play_order_index_json);
    paramString = decode(paramString);
    try
    {
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      this.ctx.startActivity(paramString);
      return;
    }
    catch (Exception paramString)
    {
      Toast.makeText(this.ctx, "Unable to open store.", 0).show();
    }
  }
  
  void MRAIDCommandSMS(HashMap paramHashMap)
  {
    ADCLog.dev.print("ADC [info] MRAIDCommandSMS called with parameters: ").println(paramHashMap);
    ADC.mraid_block = true;
    this.h.postDelayed(this.r, 1000L);
    String str = decode((String)paramHashMap.get("to"));
    paramHashMap = decode((String)paramHashMap.get("body"));
    ADC.track_ad_event("html5_interaction", this.play_order_index_json);
    try
    {
      paramHashMap = new Intent("android.intent.action.VIEW", Uri.parse("sms:" + str)).putExtra("sms_body", paramHashMap);
      this.ctx.startActivity(paramHashMap);
      return;
    }
    catch (Exception paramHashMap)
    {
      paramHashMap.printStackTrace();
      Toast.makeText(this.ctx, "Failed to create sms.", 0).show();
    }
  }
  
  void MRAIDCommandSendADCEvent(String paramString)
  {
    ADCLog.dev.print("ADC [info] MRAIDCommandSendADCEvent called with type: ").println(paramString);
    ADC.track_ad_event(paramString);
  }
  
  void MRAIDCommandSendCustomADCEvent(HashMap paramHashMap)
  {
    ADCLog.dev.print("ADC [info] MRAIDCommandSendCustomADCEvent called with parameters: ").println(paramHashMap);
    paramHashMap = decode((String)paramHashMap.get("event_type"));
    ADC.track_ad_event("custom_event", "{\"event_type\":\"" + paramHashMap + "\",\"ad_slot\":" + this.ad.zone_info.state.session_play_count + "}");
  }
  
  /* Error */
  void MRAIDCommandTakeScreenshot()
  {
    // Byte code:
    //   0: iconst_1
    //   1: putstatic 135	com/jirbo/adcolony/ADC:mraid_block	Z
    //   4: aload_0
    //   5: getfield 36	com/jirbo/adcolony/ADCMRAIDHandler:h	Landroid/os/Handler;
    //   8: aload_0
    //   9: getfield 41	com/jirbo/adcolony/ADCMRAIDHandler:r	Ljava/lang/Runnable;
    //   12: ldc2_w 136
    //   15: invokevirtual 141	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   18: pop
    //   19: ldc -113
    //   21: aload_0
    //   22: getfield 145	com/jirbo/adcolony/ADCMRAIDHandler:play_order_index_json	Ljava/lang/String;
    //   25: invokestatic 149	com/jirbo/adcolony/ADC:track_ad_event	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: new 85	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   35: invokestatic 459	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   38: invokevirtual 462	java/io/File:toString	()Ljava/lang/String;
    //   41: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc_w 464
    //   47: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc_w 466
    //   53: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokestatic 471	java/lang/System:currentTimeMillis	()J
    //   59: invokevirtual 275	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   62: ldc_w 473
    //   65: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: astore_2
    //   72: aload_0
    //   73: getfield 27	com/jirbo/adcolony/ADCMRAIDHandler:end_card_web_view	Landroid/webkit/WebView;
    //   76: invokevirtual 479	android/webkit/WebView:getRootView	()Landroid/view/View;
    //   79: astore_3
    //   80: aload_3
    //   81: iconst_1
    //   82: invokevirtual 485	android/view/View:setDrawingCacheEnabled	(Z)V
    //   85: aload_3
    //   86: invokevirtual 489	android/view/View:getDrawingCache	()Landroid/graphics/Bitmap;
    //   89: invokestatic 495	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   92: astore_1
    //   93: aload_3
    //   94: iconst_0
    //   95: invokevirtual 485	android/view/View:setDrawingCacheEnabled	(Z)V
    //   98: new 461	java/io/File
    //   101: dup
    //   102: new 85	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   109: invokestatic 459	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   112: invokevirtual 462	java/io/File:toString	()Ljava/lang/String;
    //   115: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: ldc_w 497
    //   121: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokespecial 498	java/io/File:<init>	(Ljava/lang/String;)V
    //   130: astore_3
    //   131: new 461	java/io/File
    //   134: dup
    //   135: new 85	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   142: invokestatic 459	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   145: invokevirtual 462	java/io/File:toString	()Ljava/lang/String;
    //   148: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: ldc_w 500
    //   154: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokespecial 498	java/io/File:<init>	(Ljava/lang/String;)V
    //   163: astore 4
    //   165: aload_3
    //   166: invokevirtual 504	java/io/File:mkdir	()Z
    //   169: pop
    //   170: aload 4
    //   172: invokevirtual 504	java/io/File:mkdir	()Z
    //   175: pop
    //   176: new 461	java/io/File
    //   179: dup
    //   180: aload_2
    //   181: invokespecial 498	java/io/File:<init>	(Ljava/lang/String;)V
    //   184: astore_2
    //   185: new 506	java/io/FileOutputStream
    //   188: dup
    //   189: aload_2
    //   190: invokespecial 509	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   193: astore_2
    //   194: aload_1
    //   195: getstatic 515	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   198: bipush 90
    //   200: aload_2
    //   201: invokevirtual 519	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   204: pop
    //   205: aload_2
    //   206: invokevirtual 524	java/io/OutputStream:flush	()V
    //   209: aload_2
    //   210: invokevirtual 527	java/io/OutputStream:close	()V
    //   213: aload_0
    //   214: getfield 29	com/jirbo/adcolony/ADCMRAIDHandler:ctx	Landroid/app/Activity;
    //   217: ldc_w 529
    //   220: iconst_0
    //   221: invokestatic 227	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   224: invokevirtual 230	android/widget/Toast:show	()V
    //   227: aload_0
    //   228: getfield 29	com/jirbo/adcolony/ADCMRAIDHandler:ctx	Landroid/app/Activity;
    //   231: new 242	android/content/Intent
    //   234: dup
    //   235: ldc_w 531
    //   238: new 85	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   245: ldc_w 533
    //   248: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokestatic 459	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   254: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   257: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 380	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   263: invokespecial 383	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   266: invokevirtual 539	android/app/Activity:sendBroadcast	(Landroid/content/Intent;)V
    //   269: return
    //   270: astore_1
    //   271: aload_0
    //   272: getfield 29	com/jirbo/adcolony/ADCMRAIDHandler:ctx	Landroid/app/Activity;
    //   275: ldc_w 541
    //   278: iconst_0
    //   279: invokestatic 227	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   282: invokevirtual 230	android/widget/Toast:show	()V
    //   285: getstatic 50	com/jirbo/adcolony/ADCLog:dev	Lcom/jirbo/adcolony/ADCLog;
    //   288: ldc_w 543
    //   291: invokevirtual 56	com/jirbo/adcolony/ADCLog:print	(Ljava/lang/String;)Lcom/jirbo/adcolony/ADCLog;
    //   294: pop
    //   295: goto -68 -> 227
    //   298: astore_1
    //   299: aload_0
    //   300: getfield 29	com/jirbo/adcolony/ADCMRAIDHandler:ctx	Landroid/app/Activity;
    //   303: ldc_w 541
    //   306: iconst_0
    //   307: invokestatic 227	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   310: invokevirtual 230	android/widget/Toast:show	()V
    //   313: getstatic 50	com/jirbo/adcolony/ADCLog:dev	Lcom/jirbo/adcolony/ADCLog;
    //   316: ldc_w 545
    //   319: invokevirtual 56	com/jirbo/adcolony/ADCLog:print	(Ljava/lang/String;)Lcom/jirbo/adcolony/ADCLog;
    //   322: pop
    //   323: goto -96 -> 227
    //   326: astore_1
    //   327: goto -28 -> 299
    //   330: astore_1
    //   331: goto -60 -> 271
    //   334: astore_3
    //   335: goto -159 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	338	0	this	ADCMRAIDHandler
    //   92	103	1	localBitmap	android.graphics.Bitmap
    //   270	1	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   298	1	1	localIOException1	java.io.IOException
    //   326	1	1	localIOException2	java.io.IOException
    //   330	1	1	localFileNotFoundException2	java.io.FileNotFoundException
    //   71	139	2	localObject1	Object
    //   79	87	3	localObject2	Object
    //   334	1	3	localException	Exception
    //   163	8	4	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   185	194	270	java/io/FileNotFoundException
    //   185	194	298	java/io/IOException
    //   194	227	326	java/io/IOException
    //   194	227	330	java/io/FileNotFoundException
    //   165	176	334	java/lang/Exception
  }
  
  void MRAIDCommandTel(HashMap paramHashMap)
  {
    ADCLog.dev.print("ADC [info] MRAIDCommandTel called with parameters: ").println(paramHashMap);
    ADC.mraid_block = true;
    this.h.postDelayed(this.r, 1000L);
    paramHashMap = decode((String)paramHashMap.get("number"));
    ADC.track_ad_event("html5_interaction", this.play_order_index_json);
    try
    {
      paramHashMap = new Intent("android.intent.action.DIAL").setData(Uri.parse("tel:" + paramHashMap));
      this.ctx.startActivity(paramHashMap);
      return;
    }
    catch (Exception paramHashMap)
    {
      Toast.makeText(this.ctx, "Failed to dial number.", 0).show();
    }
  }
  
  String decode(String paramString)
  {
    if (paramString.equals(null)) {
      return "";
    }
    return URLDecoder.decode(paramString);
  }
  
  void execute_javascript(String paramString)
  {
    this.end_card_web_view.loadUrl("javascript:" + paramString);
  }
  
  void handleMRAIDCommand(String paramString)
  {
    paramString = paramString.replace("mraid://", "");
    if (paramString.contains("?"))
    {
      arrayOfString = paramString.split("\\?");
      paramString = arrayOfString[0];
      if (arrayOfString == null) {
        break label116;
      }
    }
    HashMap localHashMap;
    label116:
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
    this.ad = ADC.current_ad;
    this.play_order_index_json = ("{\"ad_slot\":" + this.ad.zone_info.state.session_play_count + "}");
    if (paramString.contains("send_adc_event")) {
      MRAIDCommandSendADCEvent((String)localHashMap.get("type"));
    }
    for (;;)
    {
      execute_javascript("adc_bridge.nativeCallComplete()");
      return;
      if (paramString.contains("close")) {
        MRAIDCommandClose();
      } else if ((paramString.contains("open_store")) && (!ADC.mraid_block)) {
        MRAIDCommandOpenStore((String)localHashMap.get("item"));
      } else if ((paramString.contains("open")) && (!ADC.mraid_block)) {
        MRAIDCommandOpen((String)localHashMap.get("url"));
      } else if (paramString.contains("expand")) {
        MRAIDCommandExpand((String)localHashMap.get("url"));
      } else if ((paramString.contains("create_calendar_event")) && (!ADC.mraid_block)) {
        MRAIDCommandCreateCalendarEvent(localHashMap);
      } else if ((paramString.contains("mail")) && (!ADC.mraid_block)) {
        MRAIDCommandMail(localHashMap);
      } else if ((paramString.contains("sms")) && (!ADC.mraid_block)) {
        MRAIDCommandSMS(localHashMap);
      } else if ((paramString.contains("tel")) && (!ADC.mraid_block)) {
        MRAIDCommandTel(localHashMap);
      } else if (paramString.contains("custom_event")) {
        MRAIDCommandSendCustomADCEvent(localHashMap);
      } else if ((paramString.contains("launch_app")) && (!ADC.mraid_block)) {
        MRAIDCommandLaunchApp(localHashMap);
      } else if (paramString.contains("check_app_presence")) {
        MRAIDCommandCheckAppPresence(localHashMap);
      } else if (paramString.contains("auto_play")) {
        MRAIDCommandAutoPlay(localHashMap);
      } else if (paramString.contains("save_screenshot")) {
        MRAIDCommandTakeScreenshot();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/jirbo/adcolony/ADCMRAIDHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */