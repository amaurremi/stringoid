package com.inmobi.androidsdk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.provider.MediaStore.Images.Media;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.WrapperFunctions;
import com.inmobi.re.container.CustomView;
import com.inmobi.re.container.CustomView.SwitchIconType;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.IMWebView.IMWebViewListener;
import com.inmobi.re.container.IMWebView.ViewState;
import com.inmobi.re.container.mraidimpl.MRAIDAudioVideoController;
import com.inmobi.re.container.mraidimpl.MRAIDExpandController;
import com.inmobi.re.container.mraidimpl.MRAIDInterstitialController;
import com.inmobi.re.controller.util.StartActivityForResultCallback;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;

@SuppressLint({"UseSparseArrays"})
public class IMBrowserActivity
        extends Activity {
    public static final String ANIMATED = "isAnimationEnabledOnDimiss";
    public static final int BROWSER_ACTIVITY = 100;
    public static final int CLOSE_BUTTON_VIEW_ID = 225;
    public static final int CLOSE_REGION_VIEW_ID = 226;
    public static final String EXPANDDATA = "data";
    public static final int EXPAND_ACTIVITY = 102;
    public static final String EXTRA_BROWSER_ACTIVITY_TYPE = "extra_browser_type";
    public static final String EXTRA_URL = "extra_url";
    public static final int GET_IMAGE = 101;
    public static final int INTERSTITIAL_ACTIVITY = 101;
    private static IMWebView b;
    private static IMWebView.IMWebViewListener c;
    private static IMWebView d;
    private static FrameLayout e;
    private static Message f;
    private static Map<Integer, StartActivityForResultCallback> l = new HashMap();
    private static int m = 0;
    private static Activity o;
    private IMWebView a;
    private RelativeLayout g;
    private float h;
    private Boolean i;
    private CustomView j;
    private long k = 0L;
    private int n;
    private WebViewClient p = new a(this);

    /* Error */
    private String a(String paramString) {
        // Byte code:
        //   0: iconst_0
        //   1: istore_3
        //   2: aconst_null
        //   3: astore 6
        //   5: aload 6
        //   7: astore 5
        //   9: aload_1
        //   10: ifnull +93 -> 103
        //   13: aload 6
        //   15: astore 5
        //   17: ldc 94
        //   19: aload_1
        //   20: invokevirtual 100	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   23: ifne +80 -> 103
        //   26: getstatic 106	com/inmobi/re/controller/JSUtilityController:formats	[Ljava/text/SimpleDateFormat;
        //   29: astore 7
        //   31: aload 7
        //   33: arraylength
        //   34: istore 4
        //   36: iconst_0
        //   37: istore_2
        //   38: iload_2
        //   39: iload 4
        //   41: if_icmpge +83 -> 124
        //   44: aload 7
        //   46: iload_2
        //   47: aaload
        //   48: astore 5
        //   50: aload 5
        //   52: aload_1
        //   53: invokevirtual 112	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
        //   56: astore 5
        //   58: aload 5
        //   60: astore_1
        //   61: getstatic 115	com/inmobi/re/controller/JSUtilityController:calendarUntiFormats	[Ljava/text/SimpleDateFormat;
        //   64: astore 7
        //   66: aload 7
        //   68: arraylength
        //   69: istore 4
        //   71: iload_3
        //   72: istore_2
        //   73: aload 6
        //   75: astore 5
        //   77: iload_2
        //   78: iload 4
        //   80: if_icmpge +23 -> 103
        //   83: aload 7
        //   85: iload_2
        //   86: aaload
        //   87: astore 5
        //   89: aload 5
        //   91: aload_1
        //   92: invokevirtual 121	java/util/Date:getTime	()J
        //   95: invokestatic 127	java/lang/Long:valueOf	(J)Ljava/lang/Long;
        //   98: invokevirtual 131	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
        //   101: astore 5
        //   103: aload 5
        //   105: areturn
        //   106: astore 5
        //   108: iload_2
        //   109: iconst_1
        //   110: iadd
        //   111: istore_2
        //   112: goto -74 -> 38
        //   115: astore 5
        //   117: iload_2
        //   118: iconst_1
        //   119: iadd
        //   120: istore_2
        //   121: goto -48 -> 73
        //   124: aconst_null
        //   125: astore_1
        //   126: goto -65 -> 61
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	129	0	this	IMBrowserActivity
        //   0	129	1	paramString	String
        //   37	84	2	i1	int
        //   1	71	3	i2	int
        //   34	47	4	i3	int
        //   7	97	5	localObject1	Object
        //   106	1	5	localException1	Exception
        //   115	1	5	localException2	Exception
        //   3	71	6	localObject2	Object
        //   29	55	7	arrayOfSimpleDateFormat	java.text.SimpleDateFormat[]
        // Exception table:
        //   from	to	target	type
        //   50	58	106	java/lang/Exception
        //   89	103	115	java/lang/Exception
    }

    private String a(JSONArray paramJSONArray) {
        int i1 = 0;
        if (paramJSONArray != null) {
            try {
                if (paramJSONArray.length() != 0) {
                    Object localObject1 = new StringBuilder();
                    while (i1 < paramJSONArray.length()) {
                        Object localObject2 = paramJSONArray.get(i1);
                        ((StringBuilder) localObject1).append(localObject2 + ",");
                        i1 += 1;
                    }
                    localObject1 = ((StringBuilder) localObject1).toString();
                    i1 = ((String) localObject1).length();
                    if (i1 == 0) {
                        paramJSONArray = null;
                    }
                    for (; ; ) {
                        return paramJSONArray;
                        paramJSONArray = (JSONArray) localObject1;
                        try {
                            if (((String) localObject1).charAt(i1 - 1) == ',') {
                                paramJSONArray = ((String) localObject1).substring(0, i1 - 1);
                                return paramJSONArray;
                            }
                        } catch (Exception paramJSONArray) {
                            Log.internal("[InMobi]-4.5.1", "Couldn't parse json in create calendar event", paramJSONArray);
                            return (String) localObject1;
                        }
                    }
                }
                return null;
            } catch (Exception paramJSONArray) {
                paramJSONArray.printStackTrace();
                Log.internal("[InMobi]-[RE]-4.5.1", "Exception parsing recurrence rule", paramJSONArray);
            }
        }
    }

    private String a(JSONArray paramJSONArray, int paramInt1, int paramInt2) {
        int i1 = 0;
        if (paramJSONArray != null) {
        }
        for (; ; ) {
            Object localObject;
            try {
                if (paramJSONArray.length() != 0) {
                    localObject = new StringBuilder();
                    if (i1 >= paramJSONArray.length()) {
                        break label101;
                    }
                    int i2 = paramJSONArray.getInt(i1);
                    if ((i2 < paramInt1) || (i2 > paramInt2)) {
                        break label160;
                    }
                    ((StringBuilder) localObject).append(i2 + ",");
                }
            } catch (Exception paramJSONArray) {
                paramJSONArray.printStackTrace();
                Log.internal("[InMobi]-[RE]-4.5.1", "Exception parsing recurrence rule", paramJSONArray);
            }
            paramJSONArray = null;
            for (; ; ) {
                return paramJSONArray;
                label101:
                localObject = ((StringBuilder) localObject).toString();
                paramInt1 = ((String) localObject).length();
                if (paramInt1 == 0) {
                    return null;
                }
                paramJSONArray = (JSONArray) localObject;
                try {
                    if (((String) localObject).charAt(paramInt1 - 1) == ',') {
                        paramJSONArray = ((String) localObject).substring(0, paramInt1 - 1);
                        return paramJSONArray;
                    }
                } catch (Exception paramJSONArray) {
                    Log.internal("[InMobi]-4.5.1", "Couldn't parse json in create calendar event", paramJSONArray);
                    return (String) localObject;
                }
            }
            label160:
            i1 += 1;
        }
    }

    private void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2) {
        String str1;
        switch (paramInt1) {
            default:
                str1 = null;
        }
        String str2;
        for (; ; ) {
            str2 = paramString1 + " " + paramString2 + " " + paramString3;
            Intent localIntent = new Intent();
            localIntent.setType("text/plain");
            localIntent.setPackage(str1);
            localIntent.putExtra("android.intent.extra.TEXT", str2);
            try {
                startActivityForResult(localIntent, paramInt2);
                return;
            } catch (Exception localException) {
                switch (paramInt1) {
                }
                for (; ; ) {
                    paramString1 = null;
                    while (paramString1 != null) {
                        paramString2 = new Intent("android.intent.action.VIEW");
                        paramString2.setData(Uri.parse(paramString1));
                        try {
                            startActivityForResult(paramString2, paramInt2);
                            return;
                        } catch (Exception paramString1) {
                            onActivityResult(paramInt2, 0, null);
                            return;
                        }
                        try {
                            paramString1 = "https://www.facebook.com/dialog/feed?app_id=181821551957328&link=" + URLEncoder.encode(paramString2, "UTF-8") + "&picture=" + URLEncoder.encode(paramString3, "UTF-8") + "&name=&description=" + URLEncoder.encode(paramString1, "UTF-8") + "&redirect_uri=" + URLEncoder.encode(paramString2, "UTF-8");
                        } catch (UnsupportedEncodingException paramString1) {
                            Log.internal("[InMobi]-[RE]-4.5.1", "UTF-8 encoding not supported? What sorcery is this?", paramString1);
                        }
                        paramString1 = "https://m.google.com/app/plus/x/?v=compose&content=" + URLEncoder.encode(str2, "UTF-8");
                        continue;
                        paramString1 = "http://twitter.com/home?status=" + URLEncoder.encode(str2, "UTF-8");
                    }
                }
                paramString1 = new Intent();
                paramString1.setType("text/plain");
                paramString1.putExtra("android.intent.extra.TEXT", str2);
                try {
                    startActivityForResult(paramString1, paramInt2);
                    return;
                } catch (Exception paramString1) {
                    onActivityResult(paramInt2, 0, null);
                }
            }
            str1 = "";
            continue;
            str1 = "com.google.android.apps.plus";
            continue;
            str1 = "com.twitter.android";
        }
    }

    /* Error */
    private void a(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt) {
        // Byte code:
        //   0: new 199	android/content/Intent
        //   3: dup
        //   4: ldc_w 266
        //   7: invokespecial 228	android/content/Intent:<init>	(Ljava/lang/String;)V
        //   10: astore 11
        //   12: aload 11
        //   14: ldc_w 268
        //   17: invokevirtual 206	android/content/Intent:setType	(Ljava/lang/String;)Landroid/content/Intent;
        //   20: pop
        //   21: aload 11
        //   23: ldc_w 270
        //   26: lload_1
        //   27: invokevirtual 273	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
        //   30: pop
        //   31: aload 11
        //   33: ldc_w 275
        //   36: iconst_0
        //   37: invokevirtual 278	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
        //   40: pop
        //   41: aload 11
        //   43: ldc_w 280
        //   46: lload_3
        //   47: invokevirtual 273	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
        //   50: pop
        //   51: aload 11
        //   53: ldc_w 282
        //   56: aload 6
        //   58: invokevirtual 215	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   61: pop
        //   62: aload 11
        //   64: ldc_w 284
        //   67: aload 5
        //   69: invokevirtual 215	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   72: pop
        //   73: aload 11
        //   75: ldc_w 286
        //   78: aload 7
        //   80: invokevirtual 215	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   83: pop
        //   84: aload 8
        //   86: ldc_w 288
        //   89: invokevirtual 100	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   92: ifeq +625 -> 717
        //   95: aload 11
        //   97: ldc_w 290
        //   100: iconst_1
        //   101: invokevirtual 293	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
        //   104: pop
        //   105: ldc 94
        //   107: aload 9
        //   109: invokevirtual 100	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   112: ifne +596 -> 708
        //   115: getstatic 298	android/os/Build$VERSION:SDK_INT	I
        //   118: bipush 8
        //   120: if_icmple +588 -> 708
        //   123: new 140	java/lang/StringBuilder
        //   126: dup
        //   127: invokespecial 141	java/lang/StringBuilder:<init>	()V
        //   130: astore 5
        //   132: new 300	org/json/JSONObject
        //   135: dup
        //   136: aload 9
        //   138: invokespecial 301	org/json/JSONObject:<init>	(Ljava/lang/String;)V
        //   141: astore 6
        //   143: aload 6
        //   145: ldc_w 303
        //   148: invokevirtual 306	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
        //   151: astore 7
        //   153: aload 7
        //   155: ifnull +597 -> 752
        //   158: ldc 94
        //   160: aload 7
        //   162: invokevirtual 100	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   165: ifne +587 -> 752
        //   168: ldc_w 308
        //   171: aload 7
        //   173: invokevirtual 100	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   176: ifne +36 -> 212
        //   179: ldc_w 310
        //   182: aload 7
        //   184: invokevirtual 100	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   187: ifne +25 -> 212
        //   190: ldc_w 312
        //   193: aload 7
        //   195: invokevirtual 100	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   198: ifne +14 -> 212
        //   201: ldc_w 314
        //   204: aload 7
        //   206: invokevirtual 100	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   209: ifeq +36 -> 245
        //   212: aload 5
        //   214: new 140	java/lang/StringBuilder
        //   217: dup
        //   218: invokespecial 141	java/lang/StringBuilder:<init>	()V
        //   221: ldc_w 316
        //   224: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   227: aload 7
        //   229: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   232: ldc_w 318
        //   235: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   238: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   241: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   244: pop
        //   245: aload 6
        //   247: ldc_w 320
        //   250: invokevirtual 306	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
        //   253: astore 7
        //   255: aload 7
        //   257: ifnull +49 -> 306
        //   260: ldc 94
        //   262: aload 7
        //   264: invokevirtual 100	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   267: ifne +39 -> 306
        //   270: aload 5
        //   272: new 140	java/lang/StringBuilder
        //   275: dup
        //   276: invokespecial 141	java/lang/StringBuilder:<init>	()V
        //   279: ldc_w 322
        //   282: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   285: aload 7
        //   287: invokestatic 328	java/lang/Integer:parseInt	(Ljava/lang/String;)I
        //   290: invokevirtual 192	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   293: ldc_w 318
        //   296: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   299: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   302: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   305: pop
        //   306: aload_0
        //   307: aload 6
        //   309: ldc_w 330
        //   312: invokevirtual 306	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
        //   315: invokespecial 332	com/inmobi/androidsdk/IMBrowserActivity:a	(Ljava/lang/String;)Ljava/lang/String;
        //   318: astore 7
        //   320: aload 7
        //   322: ifnull +508 -> 830
        //   325: aload 5
        //   327: new 140	java/lang/StringBuilder
        //   330: dup
        //   331: invokespecial 141	java/lang/StringBuilder:<init>	()V
        //   334: ldc_w 334
        //   337: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   340: aload 7
        //   342: ldc_w 336
        //   345: ldc_w 338
        //   348: invokevirtual 342	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
        //   351: ldc_w 344
        //   354: ldc_w 346
        //   357: invokevirtual 342	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
        //   360: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   363: ldc_w 318
        //   366: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   369: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   372: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   375: pop
        //   376: aload_0
        //   377: aload 6
        //   379: ldc_w 348
        //   382: invokevirtual 352	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
        //   385: invokespecial 354	com/inmobi/androidsdk/IMBrowserActivity:a	(Lorg/json/JSONArray;)Ljava/lang/String;
        //   388: astore 7
        //   390: aload 7
        //   392: ifnull +36 -> 428
        //   395: aload 5
        //   397: new 140	java/lang/StringBuilder
        //   400: dup
        //   401: invokespecial 141	java/lang/StringBuilder:<init>	()V
        //   404: ldc_w 356
        //   407: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   410: aload 7
        //   412: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   415: ldc_w 318
        //   418: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   421: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   424: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   427: pop
        //   428: aload_0
        //   429: aload 6
        //   431: ldc_w 358
        //   434: invokevirtual 352	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
        //   437: bipush -30
        //   439: bipush 31
        //   441: invokespecial 360	com/inmobi/androidsdk/IMBrowserActivity:a	(Lorg/json/JSONArray;II)Ljava/lang/String;
        //   444: astore 7
        //   446: aload 7
        //   448: ifnull +36 -> 484
        //   451: aload 5
        //   453: new 140	java/lang/StringBuilder
        //   456: dup
        //   457: invokespecial 141	java/lang/StringBuilder:<init>	()V
        //   460: ldc_w 362
        //   463: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   466: aload 7
        //   468: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   471: ldc_w 318
        //   474: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   477: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   480: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   483: pop
        //   484: aload_0
        //   485: aload 6
        //   487: ldc_w 364
        //   490: invokevirtual 352	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
        //   493: sipush 65172
        //   496: sipush 365
        //   499: invokespecial 360	com/inmobi/androidsdk/IMBrowserActivity:a	(Lorg/json/JSONArray;II)Ljava/lang/String;
        //   502: astore 7
        //   504: aload 7
        //   506: ifnull +36 -> 542
        //   509: aload 5
        //   511: new 140	java/lang/StringBuilder
        //   514: dup
        //   515: invokespecial 141	java/lang/StringBuilder:<init>	()V
        //   518: ldc_w 366
        //   521: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   524: aload 7
        //   526: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   529: ldc_w 318
        //   532: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   535: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   538: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   541: pop
        //   542: aload_0
        //   543: aload 6
        //   545: ldc_w 368
        //   548: invokevirtual 352	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
        //   551: bipush -3
        //   553: iconst_4
        //   554: invokespecial 360	com/inmobi/androidsdk/IMBrowserActivity:a	(Lorg/json/JSONArray;II)Ljava/lang/String;
        //   557: astore 7
        //   559: aload 7
        //   561: ifnull +36 -> 597
        //   564: aload 5
        //   566: new 140	java/lang/StringBuilder
        //   569: dup
        //   570: invokespecial 141	java/lang/StringBuilder:<init>	()V
        //   573: ldc_w 370
        //   576: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   579: aload 7
        //   581: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   584: ldc_w 318
        //   587: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   590: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   593: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   596: pop
        //   597: aload_0
        //   598: aload 6
        //   600: ldc_w 372
        //   603: invokevirtual 352	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
        //   606: iconst_1
        //   607: bipush 12
        //   609: invokespecial 360	com/inmobi/androidsdk/IMBrowserActivity:a	(Lorg/json/JSONArray;II)Ljava/lang/String;
        //   612: astore 6
        //   614: aload 6
        //   616: ifnull +36 -> 652
        //   619: aload 5
        //   621: new 140	java/lang/StringBuilder
        //   624: dup
        //   625: invokespecial 141	java/lang/StringBuilder:<init>	()V
        //   628: ldc_w 374
        //   631: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   634: aload 6
        //   636: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   639: ldc_w 318
        //   642: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   645: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   648: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   651: pop
        //   652: ldc -74
        //   654: new 140	java/lang/StringBuilder
        //   657: dup
        //   658: invokespecial 141	java/lang/StringBuilder:<init>	()V
        //   661: ldc_w 376
        //   664: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   667: aload 5
        //   669: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   672: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   675: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   678: invokestatic 379	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;)V
        //   681: ldc 94
        //   683: aload 5
        //   685: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   688: invokevirtual 100	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   691: ifne +17 -> 708
        //   694: aload 11
        //   696: ldc_w 381
        //   699: aload 5
        //   701: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   704: invokevirtual 215	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   707: pop
        //   708: aload_0
        //   709: aload 11
        //   711: iload 10
        //   713: invokevirtual 219	com/inmobi/androidsdk/IMBrowserActivity:startActivityForResult	(Landroid/content/Intent;I)V
        //   716: return
        //   717: aload 8
        //   719: ldc_w 383
        //   722: invokevirtual 100	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   725: ifeq -620 -> 105
        //   728: aload 11
        //   730: ldc_w 290
        //   733: iconst_0
        //   734: invokevirtual 293	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
        //   737: pop
        //   738: goto -633 -> 105
        //   741: astore 5
        //   743: aload_0
        //   744: iload 10
        //   746: iconst_0
        //   747: aconst_null
        //   748: invokevirtual 241	com/inmobi/androidsdk/IMBrowserActivity:onActivityResult	(IILandroid/content/Intent;)V
        //   751: return
        //   752: aload_0
        //   753: getfield 89	com/inmobi/androidsdk/IMBrowserActivity:a	Lcom/inmobi/re/container/IMWebView;
        //   756: ifnull +16 -> 772
        //   759: aload_0
        //   760: getfield 89	com/inmobi/androidsdk/IMBrowserActivity:a	Lcom/inmobi/re/container/IMWebView;
        //   763: ldc_w 385
        //   766: ldc_w 387
        //   769: invokevirtual 392	com/inmobi/re/container/IMWebView:raiseError	(Ljava/lang/String;Ljava/lang/String;)V
        //   772: aload_0
        //   773: aload 11
        //   775: iload 10
        //   777: invokevirtual 219	com/inmobi/androidsdk/IMBrowserActivity:startActivityForResult	(Landroid/content/Intent;I)V
        //   780: return
        //   781: astore 6
        //   783: ldc -74
        //   785: ldc -72
        //   787: aload 6
        //   789: invokestatic 177	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   792: goto -111 -> 681
        //   795: astore 7
        //   797: aload_0
        //   798: getfield 89	com/inmobi/androidsdk/IMBrowserActivity:a	Lcom/inmobi/re/container/IMWebView;
        //   801: ifnull +16 -> 817
        //   804: aload_0
        //   805: getfield 89	com/inmobi/androidsdk/IMBrowserActivity:a	Lcom/inmobi/re/container/IMWebView;
        //   808: ldc_w 394
        //   811: ldc_w 387
        //   814: invokevirtual 392	com/inmobi/re/container/IMWebView:raiseError	(Ljava/lang/String;Ljava/lang/String;)V
        //   817: ldc -74
        //   819: ldc_w 396
        //   822: aload 7
        //   824: invokestatic 177	com/inmobi/commons/internal/Log:internal	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   827: goto -521 -> 306
        //   830: aload_0
        //   831: getfield 89	com/inmobi/androidsdk/IMBrowserActivity:a	Lcom/inmobi/re/container/IMWebView;
        //   834: ifnull -458 -> 376
        //   837: aload_0
        //   838: getfield 89	com/inmobi/androidsdk/IMBrowserActivity:a	Lcom/inmobi/re/container/IMWebView;
        //   841: ldc_w 398
        //   844: ldc_w 387
        //   847: invokevirtual 392	com/inmobi/re/container/IMWebView:raiseError	(Ljava/lang/String;Ljava/lang/String;)V
        //   850: goto -474 -> 376
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	853	0	this	IMBrowserActivity
        //   0	853	1	paramLong1	long
        //   0	853	3	paramLong2	long
        //   0	853	5	paramString1	String
        //   0	853	6	paramString2	String
        //   0	853	7	paramString3	String
        //   0	853	8	paramString4	String
        //   0	853	9	paramString5	String
        //   0	853	10	paramInt	int
        //   10	764	11	localIntent	Intent
        // Exception table:
        //   from	to	target	type
        //   0	105	741	java/lang/Exception
        //   105	132	741	java/lang/Exception
        //   681	708	741	java/lang/Exception
        //   708	716	741	java/lang/Exception
        //   717	738	741	java/lang/Exception
        //   783	792	741	java/lang/Exception
        //   132	153	781	java/lang/Exception
        //   158	212	781	java/lang/Exception
        //   212	245	781	java/lang/Exception
        //   245	255	781	java/lang/Exception
        //   306	320	781	java/lang/Exception
        //   325	376	781	java/lang/Exception
        //   376	390	781	java/lang/Exception
        //   395	428	781	java/lang/Exception
        //   428	446	781	java/lang/Exception
        //   451	484	781	java/lang/Exception
        //   484	504	781	java/lang/Exception
        //   509	542	781	java/lang/Exception
        //   542	559	781	java/lang/Exception
        //   564	597	781	java/lang/Exception
        //   597	614	781	java/lang/Exception
        //   619	652	781	java/lang/Exception
        //   652	681	781	java/lang/Exception
        //   752	772	781	java/lang/Exception
        //   772	780	781	java/lang/Exception
        //   797	817	781	java/lang/Exception
        //   817	827	781	java/lang/Exception
        //   830	850	781	java/lang/Exception
        //   260	306	795	java/lang/Exception
    }

    private void a(Intent paramIntent) {
        Object localObject = paramIntent.getStringExtra("action");
        int i1 = paramIntent.getIntExtra("id", 0);
        if (((String) localObject).equals("takeCameraPicture")) {
            paramIntent = (Uri) paramIntent.getExtras().get("URI");
            localObject = new Intent("android.media.action.IMAGE_CAPTURE");
            ((Intent) localObject).putExtra("output", paramIntent);
        }
        do {
            try {
                startActivityForResult((Intent) localObject, i1);
                return;
            } catch (Exception paramIntent) {
                onActivityResult(i1, 0, null);
                return;
            }
            if (((String) localObject).equals("getGalleryImage")) {
                paramIntent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                try {
                    startActivityForResult(paramIntent, i1);
                    return;
                } catch (Exception paramIntent) {
                    onActivityResult(i1, 0, null);
                    return;
                }
            }
            if (((String) localObject).equals("postToSocial")) {
                a(paramIntent.getIntExtra("socialType", 0), paramIntent.getStringExtra("text"), paramIntent.getStringExtra("link"), paramIntent.getStringExtra("image"), i1);
                return;
            }
        } while (!((String) localObject).equals("createCalendarEvent"));
        a(paramIntent.getLongExtra("start", 0L), paramIntent.getLongExtra("end", 0L), paramIntent.getStringExtra("location"), paramIntent.getStringExtra("description"), paramIntent.getStringExtra("summary"), paramIntent.getStringExtra("transparency"), paramIntent.getStringExtra("recurrence"), i1);
    }

    private void a(ViewGroup paramViewGroup) {
        LinearLayout localLinearLayout = new LinearLayout(this);
        localLinearLayout.setOrientation(0);
        localLinearLayout.setId(100);
        localLinearLayout.setWeightSum(100.0F);
        localLinearLayout.setOnTouchListener(new IMBrowserActivity.h(this));
        localLinearLayout.setBackgroundResource(17301658);
        localLinearLayout.setBackgroundColor(-7829368);
        Object localObject = new RelativeLayout.LayoutParams(WrapperFunctions.getParamFillParent(), (int) (44.0F * this.h));
        ((RelativeLayout.LayoutParams) localObject).addRule(12);
        paramViewGroup.addView(localLinearLayout, (ViewGroup.LayoutParams) localObject);
        paramViewGroup = new LinearLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
        paramViewGroup.weight = 25.0F;
        localObject = new CustomView(this, this.h, CustomView.SwitchIconType.CLOSE_ICON);
        localLinearLayout.addView((View) localObject, paramViewGroup);
        ((CustomView) localObject).setOnTouchListener(new IMBrowserActivity.e(this));
        localObject = new CustomView(this, this.h, CustomView.SwitchIconType.REFRESH);
        localLinearLayout.addView((View) localObject, paramViewGroup);
        ((CustomView) localObject).setOnTouchListener(new IMBrowserActivity.f(this));
        localObject = new CustomView(this, this.h, CustomView.SwitchIconType.BACK);
        localLinearLayout.addView((View) localObject, paramViewGroup);
        ((CustomView) localObject).setOnTouchListener(new IMBrowserActivity.j(this));
        this.j = new CustomView(this, this.h, CustomView.SwitchIconType.FORWARD_INACTIVE);
        localLinearLayout.addView(this.j, paramViewGroup);
        this.j.setOnTouchListener(new IMBrowserActivity.k(this));
    }

    public static int generateId(StartActivityForResultCallback paramStartActivityForResultCallback) {
        m += 1;
        l.put(Integer.valueOf(m), paramStartActivityForResultCallback);
        return m;
    }

    public static void requestOnAdDismiss(Message paramMessage) {
        f = paramMessage;
    }

    public static void setExpandedLayout(FrameLayout paramFrameLayout) {
        if (paramFrameLayout != null) {
            e = paramFrameLayout;
        }
    }

    public static void setExpandedWebview(IMWebView paramIMWebView) {
        if (paramIMWebView != null) {
            d = paramIMWebView;
        }
    }

    public static void setOriginalActivity(Activity paramActivity) {
        if (paramActivity != null) {
            o = paramActivity;
        }
    }

    public static void setWebViewListener(IMWebView.IMWebViewListener paramIMWebViewListener) {
        c = paramIMWebViewListener;
    }

    public static void setWebview(IMWebView paramIMWebView) {
        if (paramIMWebView != null) {
            b = paramIMWebView;
        }
    }

    protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        try {
            ((StartActivityForResultCallback) l.get(Integer.valueOf(paramInt1))).onActivityResult(paramInt2, paramIntent);
            l.remove(Integer.valueOf(paramInt2));
            if (this.a == null) {
                finish();
            }
            return;
        } catch (Exception paramIntent) {
            for (; ; ) {
                Log.internal("[InMobi]-[RE]-4.5.1", "onActivityResult failed", paramIntent);
            }
        }
    }

    public void onBackPressed() {
        if ((d != null) && (this.n == 102)) {
            d.close();
            finish();
        }
        super.onBackPressed();
    }

    public void onConfigurationChanged(Configuration paramConfiguration) {
        if (paramConfiguration.orientation == 2) {
            Log.internal("[InMobi]-[RE]-4.5.1", "In allow true,  device orientation:ORIENTATION_LANDSCAPE");
        }
        for (; ; ) {
            if (this.a != null) {
                this.a.onOrientationEventChange();
            }
            super.onConfigurationChanged(paramConfiguration);
            return;
            Log.internal("[InMobi]-[RE]-4.5.1", "In allow true,  device orientation:ORIENTATION_PORTRAIT");
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        try {
            CookieSyncManager.createInstance(this);
            CookieSyncManager.getInstance().startSync();
            paramBundle = getIntent();
            this.n = paramBundle.getIntExtra("extra_browser_type", 100);
            this.k = paramBundle.getLongExtra("isAnimationEnabledOnDimiss", 0L);
            if (this.n == 100) {
                requestWindowFeature(1);
                if ((Build.VERSION.SDK_INT < 9) || (Build.VERSION.SDK_INT >= 11)) {
                    getWindow().setFlags(1024, 1024);
                }
                Object localObject = (WindowManager) getSystemService("window");
                DisplayMetrics localDisplayMetrics = new DisplayMetrics();
                ((WindowManager) localObject).getDefaultDisplay().getMetrics(localDisplayMetrics);
                if (paramBundle.getStringExtra("action") != null) {
                    a(paramBundle);
                }
                this.h = getResources().getDisplayMetrics().density;
                localObject = paramBundle.getStringExtra("extra_url");
                this.i = Boolean.valueOf(paramBundle.getBooleanExtra("FIRST_INSTANCE", false));
                Log.debug("[InMobi]-[RE]-4.5.1", "IMBrowserActivity-> onCreate");
                this.g = new RelativeLayout(this);
                if (localObject == null) {
                    return;
                }
                boolean bool = paramBundle.getBooleanExtra("QAMODE", false);
                this.a = new IMWebView(this, c, true, true);
                paramBundle = new RelativeLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
                paramBundle.addRule(10);
                paramBundle.addRule(2, 100);
                this.g.setBackgroundColor(-1);
                this.g.addView(this.a, paramBundle);
                a(this.g);
                this.a.getSettings().setJavaScriptEnabled(true);
                this.a.setExternalWebViewClient(this.p);
                this.a.getSettings().setLoadWithOverviewMode(true);
                this.a.getSettings().setUseWideViewPort(true);
                if (Build.VERSION.SDK_INT >= 8) {
                    this.a.loadUrl((String) localObject, null);
                }
                for (; ; ) {
                    if (bool) {
                        paramBundle = new HashMap();
                        paramBundle.put("mk-carrier", "117.97.87.6");
                        paramBundle.put("x-real-ip", "117.97.87.6");
                    }
                    setContentView(this.g);
                    return;
                    this.a.loadUrl((String) localObject);
                }
            }
            if (this.n != 101) {
                break label503;
            }
        } catch (Exception paramBundle) {
            Log.internal("[InMobi]-[RE]-4.5.1", "Exception rendering ad in ImBrowser Activity", paramBundle);
            return;
        }
        b.setActivity(this);
        b.mInterstitialController.setActivity(this);
        b.mInterstitialController.changeContentAreaForInterstitials(this.k);
        paramBundle = findViewById(225);
        if (paramBundle != null) {
            paramBundle.setOnClickListener(new IMBrowserActivity.i(this));
        }
        paramBundle = findViewById(226);
        if (paramBundle != null) {
            paramBundle.setOnClickListener(new IMBrowserActivity.c(this));
        }
        b.setOnKeyListener(new IMBrowserActivity.d(this));
        return;
        label503:
        if (this.n == 102) {
            if ((e != null) && (e.getParent() != null)) {
                ((ViewGroup) e.getParent()).removeView(e);
            }
            setContentView(e);
            d.setState(IMWebView.ViewState.EXPANDED);
            d.mIsViewable = true;
            d.mExpandController.setActivity(this);
            d.setBrowserActivity(this);
            d.mExpandController.handleOrientationForExpand();
            paramBundle = findViewById(225);
            if (paramBundle != null) {
                paramBundle.setOnClickListener(new IMBrowserActivity.a(this));
            }
            paramBundle = findViewById(226);
            if (paramBundle != null) {
                paramBundle.setOnClickListener(new IMBrowserActivity.b(this));
            }
            d.setOnKeyListener(new IMBrowserActivity.g(this));
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        try {
            c = null;
            if (this.a != null) {
                this.a.mAudioVideoController.releaseAllPlayers();
            }
            if ((f != null) && (this.i.booleanValue())) {
                f.sendToTarget();
                f = null;
            }
            if (b != null) {
                b.mAudioVideoController.releaseAllPlayers();
                b = null;
            }
            if ((e != null) && (this.n == 102)) {
                e = null;
            }
            if ((d != null) && (this.n == 102)) {
                d.setOnKeyListener(null);
                d = null;
            }
            return;
        } catch (Exception localException) {
            Log.debug("[InMobi]-[RE]-4.5.1", "Exception in onDestroy ", localException);
        }
    }

    protected void onPause() {
        super.onPause();
        try {
            CookieSyncManager.getInstance().stopSync();
            return;
        } catch (Exception localException) {
            Log.internal("[InMobi]-[RE]-4.5.1", "Exception pausing cookies");
        }
    }

    protected void onResume() {
        super.onResume();
        try {
            CookieSyncManager.getInstance().startSync();
            return;
        } catch (Exception localException) {
            Log.internal("[InMobi]-[RE]-4.5.1", "Exception syncing cookies");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/androidsdk/IMBrowserActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */