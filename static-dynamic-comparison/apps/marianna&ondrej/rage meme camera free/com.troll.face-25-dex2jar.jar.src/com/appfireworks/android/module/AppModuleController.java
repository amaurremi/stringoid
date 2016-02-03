package com.appfireworks.android.module;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.appfireworks.android.advert.AppWebView;
import com.appfireworks.android.listener.AppListener;
import com.appfireworks.android.listener.AppModuleListener;
import com.appfireworks.android.request.AppRequest;
import com.appfireworks.android.request.AppRequest.TYPE;
import com.appfireworks.android.track.AppTracker;
import com.appfireworks.android.util.AppLog;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

public class AppModuleController
{
  private static Activity activity;
  private static boolean adDestroyed;
  private static boolean adLoaded;
  private static boolean backgroundLoad = true;
  private static HashMap<String, String> clickTrackUrls;
  private static String closeTrackUrl;
  private static boolean completed;
  protected static Context context;
  private static boolean isFullScreen;
  private static RelativeLayout layout;
  private static AppModuleListener listener;
  private static boolean loading;
  private static ProgressDialog loadingDialog;
  private static float mAlpha;
  private static int mHeight;
  private static int mWidth;
  private static WebView mainView;
  private static ViewGroup mainViewParent;
  private static ImageView mask = null;
  private static boolean needRealtimeClickTrack;
  private static boolean needRealtimeCloseTrack;
  private static boolean needTrack;
  private static boolean onAdLoaded;
  private static int sHeight;
  private static int sWidth;
  private static AppWebView webview;
  private static int xPos;
  private static int yPos;
  
  static
  {
    completed = false;
    loadingDialog = null;
    needTrack = false;
    needRealtimeClickTrack = false;
    needRealtimeCloseTrack = false;
    isFullScreen = true;
    mAlpha = 0.5F;
    adLoaded = false;
    adDestroyed = false;
    onAdLoaded = false;
    listener = null;
  }
  
  public AppModuleController(Activity paramActivity)
  {
    this(paramActivity, new RelativeLayout(paramActivity));
  }
  
  public AppModuleController(Activity paramActivity, RelativeLayout paramRelativeLayout)
  {
    activity = paramActivity;
    RelativeLayout localRelativeLayout = paramRelativeLayout;
    if (paramRelativeLayout == null) {
      localRelativeLayout = new RelativeLayout(paramActivity);
    }
    layout = localRelativeLayout;
    mainView = null;
  }
  
  private static void closeUnlocker()
  {
    try
    {
      webview.setLoadingURL(null);
      webview.stopLoading();
      AppLog.i("AppFireworks", "closeUnlocker called");
      completed = false;
      adDestroyed = true;
      adLoaded = false;
      onAdLoaded = false;
      backgroundLoad = true;
      try
      {
        activity.runOnUiThread(new Runnable()
        {
          public void run()
          {
            if (AppModuleController.webview != null) {
              AppModuleController.destroyAllViews(AppModuleController.webview);
            }
          }
        });
        if (mainView != null) {
          mainView.setOnTouchListener(null);
        }
        if (listener != null) {
          listener.onModuleClosed();
        }
        return;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          AppLog.e("AppFireworks", "CloseUnlocker error - " + localException1.getMessage());
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
  }
  
  private static void destroyAllViews(View paramView)
  {
    paramView.setVisibility(8);
    removeMask();
    layout.removeView(webview);
    try
    {
      ((ViewGroup)layout.getParent()).removeView(layout);
      return;
    }
    catch (Exception paramView)
    {
      AppLog.e("AppFireworks", "Error when trying to remove layout - " + paramView.getMessage());
    }
  }
  
  private static void displayAd()
  {
    AppLog.d("AppFireworks", "........... in displayAd");
    Object localObject1;
    Object localObject2;
    if (!completed)
    {
      if (layout == null) {
        AppLog.d("AppFireworks", "layout is null ");
      }
      localObject1 = new ViewGroup.MarginLayoutParams(sWidth, sHeight);
      ((ViewGroup.MarginLayoutParams)localObject1).setMargins(0, 0, 0, 0);
      localObject1 = new RelativeLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
      localObject2 = new ViewGroup.MarginLayoutParams(mWidth, mHeight);
      ((ViewGroup.MarginLayoutParams)localObject2).setMargins(xPos, yPos, 0, 0);
      localObject2 = new RelativeLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject2);
      AppLog.d("AppFireworks", "screen width & height: " + sWidth + " " + sHeight);
      if (mainView != null)
      {
        AppLog.d("AppFireworks", "mainView is NOT null");
        mainViewParent = (ViewGroup)mainView.getParent();
        mainViewParent.removeView(mainView);
        layout.addView(mainView, (ViewGroup.LayoutParams)localObject1);
        mainView.setOnTouchListener(new View.OnTouchListener()
        {
          public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            return false;
          }
        });
      }
    }
    for (;;)
    {
      try
      {
        if (isFullScreen)
        {
          AppLog.d("AppFireworks", "isFullScreen so add the mask");
          mask = new ImageView(activity);
          mask.setMinimumHeight(sHeight);
          mask.setMinimumWidth(sWidth);
          mask.setImageBitmap(Bitmap.createBitmap(sWidth, sHeight, Bitmap.Config.ARGB_8888));
          mask.setBackgroundColor(-16777216);
          int i = (int)(mAlpha * 255.0F);
          mask.getBackground().setAlpha(i);
          mask.setVisibility(1);
          mask.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView) {}
          });
          layout.addView(mask, (ViewGroup.LayoutParams)localObject1);
          AppLog.d("AppFireworks", "MASK is added");
        }
        if (webview != null)
        {
          AppLog.d("AppFireworks", "Going to add webview to layout now...");
          mainViewParent = (ViewGroup)webview.getParent();
          if (mainViewParent == null)
          {
            AppLog.d("AppFireworks", "webview's parent is null");
            layout.addView(webview, (ViewGroup.LayoutParams)localObject2);
            AppLog.d("AppFireworks", "DONE!");
            webview.setBackgroundColor(0);
          }
        }
        else
        {
          localObject1 = new ViewGroup.MarginLayoutParams(-1, -1);
          ((ViewGroup.MarginLayoutParams)localObject1).setMargins(0, 0, 0, 0);
          localObject1 = new RelativeLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
        }
        try
        {
          activity.addContentView(layout, (ViewGroup.LayoutParams)localObject1);
          AppLog.d("AppFireworks", "All done in displayAd");
          return;
        }
        catch (Exception localException2)
        {
          AppLog.d("AppFireworks", "Problem adding layout to contentview");
        }
        AppLog.d("AppFireworks", "mainView is null");
        continue;
      }
      catch (Exception localException1)
      {
        AppLog.e("AppFireworks", localException1.getMessage());
        continue;
        mainViewParent.removeView(webview);
        continue;
      }
      try
      {
        ((ViewGroup)layout.getParent()).removeView(layout);
        activity.addContentView(layout, localException1);
      }
      catch (Exception localException3)
      {
        for (;;)
        {
          AppLog.printStackTrace("AppFireworks", localException3);
          AppLog.e("AppFireworks", "Issue attaching layout to activity - " + localException3.getMessage());
        }
      }
      loading = false;
      closeUnlocker();
    }
  }
  
  private static void displayModule(String paramString)
  {
    if (paramString == null)
    {
      AppLog.d("AppFireworks", "no html content in displayModule");
      return;
    }
    AppLog.d("AppFireworks", "displaying: " + paramString);
    completed = false;
    webview.setLoadingURL(null);
    AppLog.d("AppFireworks", "in displayModule with width:" + mWidth + " height:" + mHeight + " pos: " + xPos + "," + yPos);
    webview.loadData(paramString, "text/html", "UTF-8");
    displayAd();
  }
  
  /* Error */
  private static void parseModuleServerData(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc_w 360
    //   3: astore 4
    //   5: getstatic 362	com/appfireworks/android/module/AppModuleController:context	Landroid/content/Context;
    //   8: invokevirtual 368	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   11: invokevirtual 374	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   14: astore 5
    //   16: aload 5
    //   18: getfield 379	android/util/DisplayMetrics:heightPixels	I
    //   21: putstatic 226	com/appfireworks/android/module/AppModuleController:sHeight	I
    //   24: aload 5
    //   26: getfield 382	android/util/DisplayMetrics:widthPixels	I
    //   29: putstatic 224	com/appfireworks/android/module/AppModuleController:sWidth	I
    //   32: getstatic 226	com/appfireworks/android/module/AppModuleController:sHeight	I
    //   35: putstatic 242	com/appfireworks/android/module/AppModuleController:mHeight	I
    //   38: getstatic 224	com/appfireworks/android/module/AppModuleController:sWidth	I
    //   41: putstatic 240	com/appfireworks/android/module/AppModuleController:mWidth	I
    //   44: new 384	java/util/HashMap
    //   47: dup
    //   48: invokespecial 385	java/util/HashMap:<init>	()V
    //   51: putstatic 387	com/appfireworks/android/module/AppModuleController:clickTrackUrls	Ljava/util/HashMap;
    //   54: aload_0
    //   55: ldc_w 389
    //   58: invokevirtual 395	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   61: checkcast 397	java/lang/String
    //   64: astore 5
    //   66: aload 5
    //   68: astore 4
    //   70: ldc -110
    //   72: new 174	java/lang/StringBuilder
    //   75: dup
    //   76: ldc_w 399
    //   79: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   82: aload 5
    //   84: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 218	com/appfireworks/android/util/AppLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: aload 5
    //   95: astore 4
    //   97: aload_0
    //   98: ldc_w 401
    //   101: invokevirtual 405	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   104: astore_0
    //   105: aload 5
    //   107: astore 4
    //   109: aload_0
    //   110: ifnull +254 -> 364
    //   113: aload 5
    //   115: astore 4
    //   117: ldc -110
    //   119: ldc_w 407
    //   122: invokestatic 218	com/appfireworks/android/util/AppLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: aload_0
    //   126: ldc_w 409
    //   129: invokevirtual 413	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   132: putstatic 242	com/appfireworks/android/module/AppModuleController:mHeight	I
    //   135: aload_0
    //   136: ldc_w 415
    //   139: invokevirtual 413	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   142: putstatic 240	com/appfireworks/android/module/AppModuleController:mWidth	I
    //   145: aload 5
    //   147: astore 4
    //   149: aload_0
    //   150: ldc_w 417
    //   153: invokevirtual 413	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   156: putstatic 244	com/appfireworks/android/module/AppModuleController:xPos	I
    //   159: aload 5
    //   161: astore 4
    //   163: aload_0
    //   164: ldc_w 419
    //   167: invokevirtual 413	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   170: putstatic 246	com/appfireworks/android/module/AppModuleController:yPos	I
    //   173: aload 5
    //   175: astore 4
    //   177: aload_0
    //   178: ldc_w 421
    //   181: invokevirtual 413	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   184: iconst_1
    //   185: if_icmpne +502 -> 687
    //   188: iconst_1
    //   189: istore_3
    //   190: aload 5
    //   192: astore 4
    //   194: iload_3
    //   195: putstatic 69	com/appfireworks/android/module/AppModuleController:needTrack	Z
    //   198: aload 5
    //   200: astore 4
    //   202: aload_0
    //   203: ldc_w 423
    //   206: invokevirtual 413	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   209: iconst_1
    //   210: if_icmpne +482 -> 692
    //   213: iconst_1
    //   214: istore_3
    //   215: aload 5
    //   217: astore 4
    //   219: iload_3
    //   220: putstatic 73	com/appfireworks/android/module/AppModuleController:needRealtimeCloseTrack	Z
    //   223: aload 5
    //   225: astore 4
    //   227: aload_0
    //   228: ldc_w 425
    //   231: invokevirtual 413	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   234: iconst_1
    //   235: if_icmpne +462 -> 697
    //   238: iconst_1
    //   239: istore_3
    //   240: aload 5
    //   242: astore 4
    //   244: iload_3
    //   245: putstatic 71	com/appfireworks/android/module/AppModuleController:needRealtimeClickTrack	Z
    //   248: aload 5
    //   250: astore 4
    //   252: aload_0
    //   253: ldc_w 427
    //   256: invokevirtual 431	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   259: putstatic 433	com/appfireworks/android/module/AppModuleController:closeTrackUrl	Ljava/lang/String;
    //   262: aload 5
    //   264: astore 4
    //   266: aload_0
    //   267: ldc_w 435
    //   270: invokevirtual 413	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   273: iconst_1
    //   274: if_icmpne +428 -> 702
    //   277: iconst_1
    //   278: istore_3
    //   279: aload 5
    //   281: astore 4
    //   283: iload_3
    //   284: putstatic 75	com/appfireworks/android/module/AppModuleController:isFullScreen	Z
    //   287: aload_0
    //   288: ldc_w 437
    //   291: invokevirtual 395	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   294: checkcast 397	java/lang/String
    //   297: invokestatic 443	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   300: putstatic 78	com/appfireworks/android/module/AppModuleController:mAlpha	F
    //   303: aload 5
    //   305: astore 4
    //   307: aload_0
    //   308: ldc_w 445
    //   311: invokevirtual 449	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   314: astore_0
    //   315: aload 5
    //   317: astore 4
    //   319: ldc -110
    //   321: new 174	java/lang/StringBuilder
    //   324: dup
    //   325: ldc_w 451
    //   328: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   331: aload_0
    //   332: invokevirtual 457	org/json/JSONArray:length	()I
    //   335: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   338: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 218	com/appfireworks/android/util/AppLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   344: iconst_0
    //   345: istore_1
    //   346: aload 5
    //   348: astore 4
    //   350: aload_0
    //   351: invokevirtual 457	org/json/JSONArray:length	()I
    //   354: istore_2
    //   355: iload_1
    //   356: iload_2
    //   357: if_icmplt +183 -> 540
    //   360: aload 5
    //   362: astore 4
    //   364: ldc -110
    //   366: new 174	java/lang/StringBuilder
    //   369: dup
    //   370: ldc_w 459
    //   373: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   376: getstatic 240	com/appfireworks/android/module/AppModuleController:mWidth	I
    //   379: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   382: ldc_w 461
    //   385: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: getstatic 242	com/appfireworks/android/module/AppModuleController:mHeight	I
    //   391: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   394: ldc_w 463
    //   397: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: getstatic 244	com/appfireworks/android/module/AppModuleController:xPos	I
    //   403: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   406: ldc_w 350
    //   409: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: getstatic 246	com/appfireworks/android/module/AppModuleController:yPos	I
    //   415: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   418: ldc_w 465
    //   421: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   427: invokestatic 218	com/appfireworks/android/util/AppLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   430: ldc -110
    //   432: new 174	java/lang/StringBuilder
    //   435: dup
    //   436: ldc_w 467
    //   439: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   442: getstatic 69	com/appfireworks/android/module/AppModuleController:needTrack	Z
    //   445: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   448: ldc_w 472
    //   451: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: getstatic 73	com/appfireworks/android/module/AppModuleController:needRealtimeCloseTrack	Z
    //   457: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   460: ldc_w 474
    //   463: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: getstatic 71	com/appfireworks/android/module/AppModuleController:needRealtimeClickTrack	Z
    //   469: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   472: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: invokestatic 218	com/appfireworks/android/util/AppLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   478: aload 4
    //   480: invokestatic 476	com/appfireworks/android/module/AppModuleController:displayModule	(Ljava/lang/String;)V
    //   483: return
    //   484: astore 4
    //   486: aload 5
    //   488: astore 4
    //   490: getstatic 226	com/appfireworks/android/module/AppModuleController:sHeight	I
    //   493: putstatic 242	com/appfireworks/android/module/AppModuleController:mHeight	I
    //   496: goto -361 -> 135
    //   499: astore_0
    //   500: ldc -110
    //   502: ldc_w 478
    //   505: invokestatic 218	com/appfireworks/android/util/AppLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   508: goto -144 -> 364
    //   511: astore 4
    //   513: aload 5
    //   515: astore 4
    //   517: getstatic 224	com/appfireworks/android/module/AppModuleController:sWidth	I
    //   520: putstatic 240	com/appfireworks/android/module/AppModuleController:mWidth	I
    //   523: goto -378 -> 145
    //   526: astore 4
    //   528: aload 5
    //   530: astore 4
    //   532: ldc 76
    //   534: putstatic 78	com/appfireworks/android/module/AppModuleController:mAlpha	F
    //   537: goto -234 -> 303
    //   540: aload 5
    //   542: astore 4
    //   544: aload_0
    //   545: iload_1
    //   546: invokevirtual 481	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   549: astore 7
    //   551: aload 5
    //   553: astore 4
    //   555: ldc -110
    //   557: new 174	java/lang/StringBuilder
    //   560: dup
    //   561: ldc_w 483
    //   564: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   567: aload 7
    //   569: invokevirtual 484	org/json/JSONObject:toString	()Ljava/lang/String;
    //   572: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   578: invokestatic 218	com/appfireworks/android/util/AppLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   581: aload 5
    //   583: astore 4
    //   585: aload 7
    //   587: ldc_w 486
    //   590: invokevirtual 431	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   593: astore 6
    //   595: aload 5
    //   597: astore 4
    //   599: aload 7
    //   601: ldc_w 488
    //   604: invokevirtual 431	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   607: astore 7
    //   609: aload 5
    //   611: astore 4
    //   613: ldc -110
    //   615: new 174	java/lang/StringBuilder
    //   618: dup
    //   619: ldc_w 490
    //   622: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   625: aload 7
    //   627: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: ldc_w 492
    //   633: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: aload 6
    //   638: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: invokevirtual 189	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   644: invokestatic 218	com/appfireworks/android/util/AppLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   647: aload 6
    //   649: ifnull +31 -> 680
    //   652: aload 5
    //   654: astore 4
    //   656: aload 6
    //   658: invokevirtual 493	java/lang/String:length	()I
    //   661: iconst_1
    //   662: if_icmple +18 -> 680
    //   665: aload 5
    //   667: astore 4
    //   669: getstatic 387	com/appfireworks/android/module/AppModuleController:clickTrackUrls	Ljava/util/HashMap;
    //   672: aload 7
    //   674: aload 6
    //   676: invokevirtual 497	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   679: pop
    //   680: iload_1
    //   681: iconst_1
    //   682: iadd
    //   683: istore_1
    //   684: goto -338 -> 346
    //   687: iconst_0
    //   688: istore_3
    //   689: goto -499 -> 190
    //   692: iconst_0
    //   693: istore_3
    //   694: goto -479 -> 215
    //   697: iconst_0
    //   698: istore_3
    //   699: goto -459 -> 240
    //   702: iconst_0
    //   703: istore_3
    //   704: goto -425 -> 279
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	707	0	paramJSONObject	JSONObject
    //   345	339	1	i	int
    //   354	4	2	j	int
    //   189	515	3	bool	boolean
    //   3	476	4	localObject1	Object
    //   484	1	4	localException1	Exception
    //   488	1	4	localObject2	Object
    //   511	1	4	localException2	Exception
    //   515	1	4	localObject3	Object
    //   526	1	4	localException3	Exception
    //   530	138	4	localObject4	Object
    //   14	652	5	localObject5	Object
    //   593	82	6	str	String
    //   549	124	7	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   125	135	484	java/lang/Exception
    //   54	66	499	java/lang/Exception
    //   70	93	499	java/lang/Exception
    //   97	105	499	java/lang/Exception
    //   117	125	499	java/lang/Exception
    //   149	159	499	java/lang/Exception
    //   163	173	499	java/lang/Exception
    //   177	188	499	java/lang/Exception
    //   194	198	499	java/lang/Exception
    //   202	213	499	java/lang/Exception
    //   219	223	499	java/lang/Exception
    //   227	238	499	java/lang/Exception
    //   244	248	499	java/lang/Exception
    //   252	262	499	java/lang/Exception
    //   266	277	499	java/lang/Exception
    //   283	287	499	java/lang/Exception
    //   307	315	499	java/lang/Exception
    //   319	344	499	java/lang/Exception
    //   350	355	499	java/lang/Exception
    //   490	496	499	java/lang/Exception
    //   517	523	499	java/lang/Exception
    //   532	537	499	java/lang/Exception
    //   544	551	499	java/lang/Exception
    //   555	581	499	java/lang/Exception
    //   585	595	499	java/lang/Exception
    //   599	609	499	java/lang/Exception
    //   613	647	499	java/lang/Exception
    //   656	665	499	java/lang/Exception
    //   669	680	499	java/lang/Exception
    //   135	145	511	java/lang/Exception
    //   287	303	526	java/lang/Exception
  }
  
  private static void removeMask()
  {
    AppLog.d("AppFireworks", "Removing MASK");
    try
    {
      layout.removeView(mask);
      return;
    }
    catch (Exception localException)
    {
      AppLog.e("AppFireworks", "Error when trying to remove mask - " + localException.getMessage());
    }
  }
  
  public static void trackClick(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppRequest.requestBatchAction(paramContext, paramString, null, AppTracker.getApiKey(), paramBoolean, new AppListener()
    {
      public void onServerSync(ArrayList<String> paramAnonymousArrayList)
      {
        if ((paramAnonymousArrayList != null) && (paramAnonymousArrayList.size() > 0)) {
          AppTracker.storeActions(paramAnonymousArrayList, 0);
        }
      }
    });
  }
  
  public void destroyAd()
  {
    AppLog.i("AppFireworks", "destroyAd called");
    adDestroyed = true;
    closeUnlocker();
  }
  
  public boolean getAdDestroyed()
  {
    return adDestroyed;
  }
  
  public boolean getAdLoaded()
  {
    return adLoaded;
  }
  
  public boolean getOnAdLoaded()
  {
    return onAdLoaded;
  }
  
  public void hideElements()
  {
    try
    {
      webview.setVisibility(8);
      layout.setVisibility(8);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void loadingModule(Context paramContext, String paramString)
  {
    context = paramContext;
    if (isFullScreen) {
      loadingDialog = ProgressDialog.show(activity, "", "Loading ... Please wait", true);
    }
    webview = new AppWebView(activity, this);
    if (listener != null) {
      webview.setListener(listener);
    }
    AppRequest.requestModule(context, AppRequest.TYPE.MODULE, null, AppTracker.getApiKey(), paramString, new AppListener()
    {
      public void onServerSync(ArrayList<String> paramAnonymousArrayList)
      {
        if (paramAnonymousArrayList != null)
        {
          paramAnonymousArrayList = (String)paramAnonymousArrayList.get(0);
          if (paramAnonymousArrayList.length() <= 0) {}
        }
        do
        {
          try
          {
            AppModuleController.parseModuleServerData(new JSONObject(paramAnonymousArrayList));
            AppLog.d("AppFireworks", "Successfully obtained Module data from server");
            return;
          }
          catch (Exception paramAnonymousArrayList)
          {
            for (;;)
            {
              AppLog.e("AppFireworks", "Error in converting string to JSONObject");
              if (AppModuleController.listener != null) {
                AppModuleController.listener.onModuleClosed();
              }
            }
          }
          AppModuleController.this.setLoading(false);
        } while (AppModuleController.listener == null);
        AppModuleController.listener.onModuleClosed();
      }
    });
  }
  
  public void onCloseClick()
  {
    AppLog.d("AppFireworks", "ModuleController's onCloseClick");
    if (needTrack) {
      if ((closeTrackUrl != null) && (closeTrackUrl.length() > 0))
      {
        AppLog.d("AppFireworks", "tracking onCloseClick with: " + closeTrackUrl);
        trackClick(context, closeTrackUrl, needRealtimeCloseTrack);
      }
    }
    for (;;)
    {
      destroyAd();
      return;
      AppLog.d("AppFireworks", "Not tracking closeClick");
    }
  }
  
  public void onLinkClick(String paramString)
  {
    AppLog.d("AppFireworks", "linkClicked called with hyperlink: " + paramString);
    String str;
    if ((needTrack) && (clickTrackUrls != null))
    {
      AppLog.d("AppFireworks", "tracking flag is TRUE ");
      str = (String)clickTrackUrls.get(paramString);
      if (str == null)
      {
        paramString = (String)clickTrackUrls.get("");
        if (paramString != null)
        {
          AppLog.d("AppFireworks", "Found a default trackUrl");
          trackClick(context, paramString, needRealtimeClickTrack);
        }
      }
    }
    for (;;)
    {
      destroyAd();
      return;
      AppLog.d("AppFireworks", "Found matching landing link: " + paramString);
      trackClick(context, str, needRealtimeClickTrack);
      continue;
      AppLog.d("AppFireworks", "Not tracking the link click");
    }
  }
  
  public void setAdDestroyed(boolean paramBoolean)
  {
    adDestroyed = paramBoolean;
  }
  
  public void setAdLoaded(boolean paramBoolean)
  {
    adLoaded = paramBoolean;
  }
  
  public void setLayout(RelativeLayout paramRelativeLayout)
  {
    layout = paramRelativeLayout;
  }
  
  public void setListener(AppModuleListener paramAppModuleListener)
  {
    listener = paramAppModuleListener;
  }
  
  public void setLoading(boolean paramBoolean)
  {
    loading = paramBoolean;
    if (!loading)
    {
      AppLog.i("AppFireworks", "loading set to FALSE");
      if (loadingDialog == null) {
        break label43;
      }
      AppLog.i("AppFireworks", "dismissing loadingDialog");
    }
    try
    {
      loadingDialog.dismiss();
      loadingDialog = null;
      return;
      label43:
      AppLog.i("AppFireworks", "loadingDialog is null");
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void setOnAdLoaded(boolean paramBoolean)
  {
    onAdLoaded = paramBoolean;
    if ((backgroundLoad) && (!adDestroyed)) {
      activity.runOnUiThread(new Runnable()
      {
        public void run()
        {
          AppModuleController.backgroundLoad = false;
          AppModuleController.access$5();
          AppModuleController.loading = false;
        }
      });
    }
  }
  
  public void showElements()
  {
    try
    {
      webview.setVisibility(0);
      layout.setVisibility(0);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void triggerOnModuleClosed()
  {
    if (listener != null) {
      listener.onModuleClosed();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/rage meme camera free/com.troll.face-25-dex2jar.jar!/com/appfireworks/android/module/AppModuleController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */