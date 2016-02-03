package com.mobileapptracker;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class g {
    private static final Uri g = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
    private static final List h = Arrays.asList(new String[]{"ir", "d", "db", "dm", "ma", "ov", "cc", "l", "an", "pn", "av", "dc", "ad", "android_id_md5", "android_id_sha1", "android_id_sha256", "r", "c", "id", "ua", "tpid", "ar", "ti", "age", "gender", "latitude", "longitude", "altitude", "connection_type", "mobile_country_code", "mobile_network_code", "screen_density", "screen_layout_size", "android_purchase_status", "referral_source", "referral_url", "google_aid", "google_ad_tracking_disabled", "app_ad_tracking", "facebook_user_id", "google_user_id", "twitter_user_id", "attribute_sub1", "attribute_sub2", "attribute_sub3", "attribute_sub4", "attribute_sub5", "user_name", "user_email"});
    private static volatile g t = null;
    protected e a;
    protected f b;
    protected boolean c;
    protected BroadcastReceiver d;
    protected Context e;
    protected b f;
    private j i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private ConcurrentHashMap q;
    private a r;
    private ScheduledExecutorService s;

    private int a(String paramString1, String paramString2, double paramDouble, String paramString3, String paramString4, String paramString5, String paramString6) {
        for (; ; ) {
            Object localObject;
            try {
                boolean bool = this.o;
                if (!bool) {
                    i1 = -1;
                    return i1;
                }
                b();
                l("conversion");
                localObject = new Date();
                if (o(paramString1)) {
                    if (paramString1.equals("close")) {
                        i1 = -1;
                        continue;
                    }
                    if ((paramString1.equals("open")) || (paramString1.equals("install")) || (paramString1.equals("update")) || (paramString1.equals("session"))) {
                        l("session");
                        paramString1 = new Date(((Date) localObject).getTime() + 5000L);
                        localObject = v();
                        if (localObject != null) {
                            break label177;
                        }
                        if (!this.m) {
                            break label282;
                        }
                        Log.d("MobileAppTracker", "Error constructing url for tracking call");
                        break label282;
                    }
                    n(paramString1);
                    paramString1 = (String) localObject;
                    continue;
                }
                m(paramString1);
            } finally {
            }
            paramString1 = (String) localObject;
            continue;
            label177:
            a((String) localObject, paramString2, e(), paramDouble, paramString3, paramString4, paramString5, paramString6, h(), i(), j(), k(), l(), true, paramString1);
            b();
            m(null);
            n(null);
            a(0.0D);
            b("USD");
            a("ar", null);
            c(null);
            d(null);
            e(null);
            f(null);
            g(null);
            int i1 = 1;
            continue;
            label282:
            i1 = -1;
        }
    }

    public static g a() {
        try {
            g localg = t;
            return localg;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    private String a(String paramString1, double paramDouble, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8) {
        StringBuilder localStringBuilder = new StringBuilder(paramString1);
        a(paramDouble);
        if (paramString2 != null) {
            b(paramString2);
        }
        a("ar", paramString3);
        c(paramString4);
        d(paramString5);
        e(paramString6);
        f(paramString7);
        g(paramString8);
        if ((n() == null) || (n().length() == 0)) {
            h(b(this.e, "mat_referrer", "referrer"));
        }
        if (m().length() > 0) {
            localStringBuilder.append("&install_log_id=" + m());
        }
        for (; ; ) {
            if (p().length() > 0) {
                localStringBuilder.append("&open_log_id=" + p());
            }
            if (o().length() > 0) {
                localStringBuilder.append("&last_open_log_id=" + o());
            }
            try {
                paramString1 = a(this.e.getContentResolver());
                if (paramString1 != null) {
                    localStringBuilder.append("&fb_cookie_id=").append(paramString1);
                }
            } catch (Exception paramString1) {
                for (; ; ) {
                    paramString1.printStackTrace();
                }
            }
            paramString1 = b(this.e, "mat_fb_intent", "action");
            if (paramString1.length() != 0) {
            }
            try {
                paramString2 = URLEncoder.encode(paramString1, "UTF-8");
                paramString1 = paramString2;
            } catch (UnsupportedEncodingException paramString2) {
                for (; ; ) {
                    long l1;
                    paramString2.printStackTrace();
                    continue;
                    paramString3 = (String) paramString2.next();
                    if (this.q.get(paramString3) != null) {
                        paramString1.append("&").append(paramString3).append("=").append((String) this.q.get(paramString3));
                    }
                }
            }
            localStringBuilder.append("&source=").append(paramString1);
            paramString1 = this.e.getSharedPreferences("mat_fb_intent", 0).edit();
            paramString1.remove("action");
            paramString1.commit();
            paramString1 = new StringBuilder();
            paramString2 = h.iterator();
            if (paramString2.hasNext()) {
                break;
            }
            l1 = new Date().getTime() / 1000L;
            paramString1.append("&sd=").append(Long.toString(l1));
            if (this.b != null) {
                this.b.a(paramString1.toString());
            }
            try {
                paramString2 = new StringBuilder(a.a(this.r.a(paramString1.toString())));
                paramString1 = paramString2;
            } catch (Exception paramString2) {
                for (; ; ) {
                    paramString2.printStackTrace();
                }
            }
            localStringBuilder.append("&da=").append(paramString1.toString());
            return localStringBuilder.toString();
            if (u().length() > 0) {
                localStringBuilder.append("&update_log_id=" + u());
            }
        }
    }

    private void a(double paramDouble) {
        a("r", Double.toString(paramDouble));
    }

    private void a(int paramInt) {
        a("av", Integer.toString(paramInt));
    }

    private void a(int paramInt, String paramString) {
        a("attribute_sub" + paramInt, paramString);
    }

    public static void a(Context paramContext, String paramString1, String paramString2) {
        a(paramContext, paramString1, paramString2, true, true);
    }

    private static void a(Context paramContext, String paramString1, String paramString2, String paramString3) {
        paramContext.getSharedPreferences(paramString1, 0).edit().putString(paramString2, paramString3).commit();
    }

    public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2) {
        g localg = new g();
        t = localg;
        localg.b(paramContext, paramString1, paramString2, paramBoolean1, paramBoolean2);
    }

    private void a(String paramString1, String paramString2) {
        if ((paramString1 != null) && (paramString2 != null)) {
            if (paramString2.equals("")) {
                this.q.remove(paramString1);
            }
        }
        while ((paramString1 == null) || (paramString2 != null)) {
            return;
            try {
                String str = URLEncoder.encode(paramString2, "UTF-8");
                paramString2 = str;
            } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
                for (; ; ) {
                    localUnsupportedEncodingException.printStackTrace();
                }
            }
            this.q.put(paramString1, paramString2);
            return;
        }
        this.q.remove(paramString1);
    }

    /* Error */
    private boolean a(Context paramContext, String paramString) {
        // Byte code:
        //   0: aload_0
        //   1: new 399	java/util/concurrent/ConcurrentHashMap
        //   4: dup
        //   5: invokespecial 451	java/util/concurrent/ConcurrentHashMap:<init>	()V
        //   8: putfield 397	com/mobileapptracker/g:q	Ljava/util/concurrent/ConcurrentHashMap;
        //   11: aload_1
        //   12: ldc_w 453
        //   15: invokevirtual 457	android/content/Context:checkCallingOrSelfPermission	(Ljava/lang/String;)I
        //   18: ifne +749 -> 767
        //   21: iconst_1
        //   22: istore_3
        //   23: aload_1
        //   24: ldc_w 459
        //   27: invokevirtual 457	android/content/Context:checkCallingOrSelfPermission	(Ljava/lang/String;)I
        //   30: ifne +742 -> 772
        //   33: iconst_1
        //   34: istore 4
        //   36: aload_0
        //   37: ldc_w 461
        //   40: aload_2
        //   41: invokevirtual 464	java/lang/String:trim	()Ljava/lang/String;
        //   44: invokespecial 242	com/mobileapptracker/g:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   47: aload_0
        //   48: ldc -90
        //   50: invokespecial 169	com/mobileapptracker/g:l	(Ljava/lang/String;)V
        //   53: aload_1
        //   54: invokevirtual 467	android/content/Context:getPackageName	()Ljava/lang/String;
        //   57: astore_2
        //   58: aload_0
        //   59: aload_2
        //   60: invokevirtual 469	com/mobileapptracker/g:i	(Ljava/lang/String;)V
        //   63: aload_1
        //   64: invokevirtual 473	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
        //   67: astore 7
        //   69: aload_0
        //   70: ldc 67
        //   72: aload 7
        //   74: aload 7
        //   76: aload_2
        //   77: iconst_0
        //   78: invokevirtual 479	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
        //   81: invokevirtual 483	android/content/pm/PackageManager:getApplicationLabel	(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;
        //   84: invokeinterface 486 1 0
        //   89: invokespecial 242	com/mobileapptracker/g:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   92: aload_0
        //   93: ldc 85
        //   95: new 171	java/util/Date
        //   98: dup
        //   99: new 488	java/io/File
        //   102: dup
        //   103: aload 7
        //   105: aload_2
        //   106: iconst_0
        //   107: invokevirtual 479	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
        //   110: getfield 494	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
        //   113: invokespecial 495	java/io/File:<init>	(Ljava/lang/String;)V
        //   116: invokevirtual 498	java/io/File:lastModified	()J
        //   119: invokespecial 198	java/util/Date:<init>	(J)V
        //   122: invokevirtual 193	java/util/Date:getTime	()J
        //   125: ldc2_w 356
        //   128: ldiv
        //   129: invokestatic 364	java/lang/Long:toString	(J)Ljava/lang/String;
        //   132: invokespecial 242	com/mobileapptracker/g:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   135: aload_0
        //   136: aload 7
        //   138: aload_2
        //   139: iconst_0
        //   140: invokevirtual 502	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
        //   143: getfield 508	android/content/pm/PackageInfo:versionCode	I
        //   146: invokespecial 510	com/mobileapptracker/g:a	(I)V
        //   149: aload_0
        //   150: ldc 58
        //   152: getstatic 515	android/os/Build:MODEL	Ljava/lang/String;
        //   155: invokespecial 242	com/mobileapptracker/g:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   158: aload_0
        //   159: ldc 56
        //   161: getstatic 518	android/os/Build:MANUFACTURER	Ljava/lang/String;
        //   164: invokespecial 242	com/mobileapptracker/g:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   167: aload_0
        //   168: ldc 62
        //   170: getstatic 523	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
        //   173: invokespecial 242	com/mobileapptracker/g:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   176: aload_0
        //   177: ldc 111
        //   179: aload_1
        //   180: invokevirtual 527	android/content/Context:getResources	()Landroid/content/res/Resources;
        //   183: invokevirtual 533	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
        //   186: getfield 539	android/util/DisplayMetrics:density	F
        //   189: invokestatic 544	java/lang/Float:toString	(F)Ljava/lang/String;
        //   192: invokespecial 242	com/mobileapptracker/g:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   195: aload_1
        //   196: ldc_w 546
        //   199: invokevirtual 550	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
        //   202: checkcast 552	android/view/WindowManager
        //   205: astore_2
        //   206: getstatic 555	android/os/Build$VERSION:SDK_INT	I
        //   209: bipush 13
        //   211: if_icmplt +451 -> 662
        //   214: new 557	android/graphics/Point
        //   217: dup
        //   218: invokespecial 558	android/graphics/Point:<init>	()V
        //   221: astore 7
        //   223: aload_2
        //   224: invokeinterface 562 1 0
        //   229: aload 7
        //   231: invokevirtual 568	android/view/Display:getSize	(Landroid/graphics/Point;)V
        //   234: aload 7
        //   236: getfield 571	android/graphics/Point:x	I
        //   239: istore 6
        //   241: aload 7
        //   243: getfield 574	android/graphics/Point:y	I
        //   246: istore 5
        //   248: aload_0
        //   249: ldc 113
        //   251: new 260	java/lang/StringBuilder
        //   254: dup
        //   255: iload 6
        //   257: invokestatic 418	java/lang/Integer:toString	(I)Ljava/lang/String;
        //   260: invokestatic 578	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
        //   263: invokespecial 262	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   266: ldc_w 579
        //   269: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   272: iload 5
        //   274: invokestatic 418	java/lang/Integer:toString	(I)Ljava/lang/String;
        //   277: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   280: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   283: invokespecial 242	com/mobileapptracker/g:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   286: aload_1
        //   287: ldc_w 581
        //   290: invokevirtual 550	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
        //   293: checkcast 583	android/net/ConnectivityManager
        //   296: iconst_1
        //   297: invokevirtual 587	android/net/ConnectivityManager:getNetworkInfo	(I)Landroid/net/NetworkInfo;
        //   300: invokevirtual 592	android/net/NetworkInfo:isConnected	()Z
        //   303: ifeq +384 -> 687
        //   306: aload_0
        //   307: ldc 105
        //   309: ldc_w 594
        //   312: invokespecial 242	com/mobileapptracker/g:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   315: aload_0
        //   316: ldc 65
        //   318: invokestatic 600	java/util/Locale:getDefault	()Ljava/util/Locale;
        //   321: getstatic 604	java/util/Locale:US	Ljava/util/Locale;
        //   324: invokevirtual 608	java/util/Locale:getDisplayLanguage	(Ljava/util/Locale;)Ljava/lang/String;
        //   327: invokespecial 242	com/mobileapptracker/g:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   330: aload_1
        //   331: ldc_w 610
        //   334: invokevirtual 550	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
        //   337: checkcast 612	android/telephony/TelephonyManager
        //   340: astore_2
        //   341: aload_2
        //   342: ifnull +408 -> 750
        //   345: aload_2
        //   346: invokevirtual 615	android/telephony/TelephonyManager:getNetworkCountryIso	()Ljava/lang/String;
        //   349: ifnull +350 -> 699
        //   352: aload_0
        //   353: ldc 64
        //   355: aload_2
        //   356: invokevirtual 615	android/telephony/TelephonyManager:getNetworkCountryIso	()Ljava/lang/String;
        //   359: invokespecial 242	com/mobileapptracker/g:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   362: aload_0
        //   363: ldc 73
        //   365: aload_2
        //   366: invokevirtual 618	android/telephony/TelephonyManager:getNetworkOperatorName	()Ljava/lang/String;
        //   369: invokespecial 242	com/mobileapptracker/g:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   372: aload_2
        //   373: invokevirtual 621	android/telephony/TelephonyManager:getNetworkOperator	()Ljava/lang/String;
        //   376: astore 7
        //   378: aload 7
        //   380: ifnull +34 -> 414
        //   383: aload 7
        //   385: iconst_0
        //   386: iconst_3
        //   387: invokevirtual 625	java/lang/String:substring	(II)Ljava/lang/String;
        //   390: astore_2
        //   391: aload 7
        //   393: iconst_3
        //   394: invokevirtual 627	java/lang/String:substring	(I)Ljava/lang/String;
        //   397: astore 7
        //   399: aload_0
        //   400: ldc 107
        //   402: aload_2
        //   403: invokespecial 242	com/mobileapptracker/g:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   406: aload_0
        //   407: ldc 109
        //   409: aload 7
        //   411: invokespecial 242	com/mobileapptracker/g:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   414: new 629	android/os/Handler
        //   417: dup
        //   418: invokestatic 635	android/os/Looper:getMainLooper	()Landroid/os/Looper;
        //   421: invokespecial 638	android/os/Handler:<init>	(Landroid/os/Looper;)V
        //   424: new 640	com/mobileapptracker/i
        //   427: dup
        //   428: aload_0
        //   429: aload_1
        //   430: invokespecial 643	com/mobileapptracker/i:<init>	(Lcom/mobileapptracker/g;Landroid/content/Context;)V
        //   433: invokevirtual 647	android/os/Handler:post	(Ljava/lang/Runnable;)Z
        //   436: pop
        //   437: aload_0
        //   438: ldc -19
        //   440: invokevirtual 239	com/mobileapptracker/g:b	(Ljava/lang/String;)V
        //   443: aload_1
        //   444: ldc_w 649
        //   447: ldc_w 649
        //   450: invokestatic 277	com/mobileapptracker/g:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   453: astore 7
        //   455: aload 7
        //   457: astore_2
        //   458: aload 7
        //   460: invokevirtual 268	java/lang/String:length	()I
        //   463: ifne +21 -> 484
        //   466: invokestatic 655	java/util/UUID:randomUUID	()Ljava/util/UUID;
        //   469: invokevirtual 656	java/util/UUID:toString	()Ljava/lang/String;
        //   472: astore_2
        //   473: aload_1
        //   474: ldc_w 649
        //   477: ldc_w 649
        //   480: aload_2
        //   481: invokestatic 658	com/mobileapptracker/g:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   484: aload_0
        //   485: ldc_w 660
        //   488: aload_2
        //   489: invokespecial 242	com/mobileapptracker/g:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   492: aload_0
        //   493: ldc 75
        //   495: aload_1
        //   496: invokevirtual 304	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
        //   499: ldc_w 662
        //   502: invokestatic 668	android/provider/Settings$Secure:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
        //   505: invokespecial 242	com/mobileapptracker/g:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   508: aload_0
        //   509: getfield 670	com/mobileapptracker/g:k	Z
        //   512: ifeq +26 -> 538
        //   515: iload_3
        //   516: ifeq +22 -> 538
        //   519: aload_0
        //   520: ldc 54
        //   522: aload_1
        //   523: ldc_w 610
        //   526: invokevirtual 550	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
        //   529: checkcast 612	android/telephony/TelephonyManager
        //   532: invokevirtual 673	android/telephony/TelephonyManager:getDeviceId	()Ljava/lang/String;
        //   535: invokespecial 242	com/mobileapptracker/g:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   538: aload_0
        //   539: getfield 675	com/mobileapptracker/g:l	Z
        //   542: ifeq +223 -> 765
        //   545: iload 4
        //   547: ifeq +218 -> 765
        //   550: aload_1
        //   551: ldc_w 677
        //   554: invokevirtual 550	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
        //   557: checkcast 679	android/net/wifi/WifiManager
        //   560: astore_1
        //   561: aload_1
        //   562: ifnull +203 -> 765
        //   565: aload_1
        //   566: invokevirtual 683	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
        //   569: astore_1
        //   570: aload_1
        //   571: ifnull +194 -> 765
        //   574: aload_1
        //   575: invokevirtual 688	android/net/wifi/WifiInfo:getMacAddress	()Ljava/lang/String;
        //   578: ifnull +187 -> 765
        //   581: aload_0
        //   582: ldc 60
        //   584: aload_1
        //   585: invokevirtual 688	android/net/wifi/WifiInfo:getMacAddress	()Ljava/lang/String;
        //   588: invokespecial 242	com/mobileapptracker/g:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   591: iconst_1
        //   592: ireturn
        //   593: astore 8
        //   595: aload_0
        //   596: getfield 204	com/mobileapptracker/g:m	Z
        //   599: ifeq -464 -> 135
        //   602: ldc -50
        //   604: ldc_w 690
        //   607: invokestatic 213	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   610: pop
        //   611: goto -476 -> 135
        //   614: astore_1
        //   615: aload_0
        //   616: getfield 204	com/mobileapptracker/g:m	Z
        //   619: ifeq +16 -> 635
        //   622: ldc -50
        //   624: ldc_w 692
        //   627: invokestatic 213	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   630: pop
        //   631: aload_1
        //   632: invokevirtual 390	java/lang/Exception:printStackTrace	()V
        //   635: iconst_0
        //   636: ireturn
        //   637: astore_2
        //   638: aload_0
        //   639: getfield 204	com/mobileapptracker/g:m	Z
        //   642: ifeq +12 -> 654
        //   645: ldc -50
        //   647: ldc_w 694
        //   650: invokestatic 213	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   653: pop
        //   654: aload_0
        //   655: iconst_0
        //   656: invokespecial 510	com/mobileapptracker/g:a	(I)V
        //   659: goto -510 -> 149
        //   662: aload_2
        //   663: invokeinterface 562 1 0
        //   668: invokevirtual 697	android/view/Display:getWidth	()I
        //   671: istore 6
        //   673: aload_2
        //   674: invokeinterface 562 1 0
        //   679: invokevirtual 700	android/view/Display:getHeight	()I
        //   682: istore 5
        //   684: goto -436 -> 248
        //   687: aload_0
        //   688: ldc 105
        //   690: ldc_w 702
        //   693: invokespecial 242	com/mobileapptracker/g:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   696: goto -381 -> 315
        //   699: aload_0
        //   700: getfield 670	com/mobileapptracker/g:k	Z
        //   703: ifeq -341 -> 362
        //   706: iload_3
        //   707: ifeq -345 -> 362
        //   710: aload_2
        //   711: invokevirtual 705	android/telephony/TelephonyManager:getSimCountryIso	()Ljava/lang/String;
        //   714: ifnull -352 -> 362
        //   717: aload_0
        //   718: ldc 64
        //   720: aload_2
        //   721: invokevirtual 705	android/telephony/TelephonyManager:getSimCountryIso	()Ljava/lang/String;
        //   724: invokespecial 242	com/mobileapptracker/g:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   727: goto -365 -> 362
        //   730: astore_2
        //   731: aload_0
        //   732: getfield 204	com/mobileapptracker/g:m	Z
        //   735: ifeq -321 -> 414
        //   738: ldc -50
        //   740: ldc_w 707
        //   743: invokestatic 213	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   746: pop
        //   747: goto -333 -> 414
        //   750: aload_0
        //   751: ldc 64
        //   753: invokestatic 600	java/util/Locale:getDefault	()Ljava/util/Locale;
        //   756: invokevirtual 710	java/util/Locale:getCountry	()Ljava/lang/String;
        //   759: invokespecial 242	com/mobileapptracker/g:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   762: goto -348 -> 414
        //   765: iconst_1
        //   766: ireturn
        //   767: iconst_0
        //   768: istore_3
        //   769: goto -746 -> 23
        //   772: iconst_0
        //   773: istore 4
        //   775: goto -739 -> 36
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	778	0	this	g
        //   0	778	1	paramContext	Context
        //   0	778	2	paramString	String
        //   22	747	3	i1	int
        //   34	740	4	i2	int
        //   246	437	5	i3	int
        //   239	433	6	i4	int
        //   67	392	7	localObject	Object
        //   593	1	8	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
        // Exception table:
        //   from	to	target	type
        //   69	135	593	android/content/pm/PackageManager$NameNotFoundException
        //   36	69	614	java/lang/Exception
        //   69	135	614	java/lang/Exception
        //   135	149	614	java/lang/Exception
        //   149	248	614	java/lang/Exception
        //   248	315	614	java/lang/Exception
        //   315	341	614	java/lang/Exception
        //   345	362	614	java/lang/Exception
        //   362	378	614	java/lang/Exception
        //   383	414	614	java/lang/Exception
        //   414	455	614	java/lang/Exception
        //   458	484	614	java/lang/Exception
        //   484	515	614	java/lang/Exception
        //   519	538	614	java/lang/Exception
        //   538	545	614	java/lang/Exception
        //   550	561	614	java/lang/Exception
        //   565	570	614	java/lang/Exception
        //   574	591	614	java/lang/Exception
        //   595	611	614	java/lang/Exception
        //   638	654	614	java/lang/Exception
        //   654	659	614	java/lang/Exception
        //   662	684	614	java/lang/Exception
        //   687	696	614	java/lang/Exception
        //   699	706	614	java/lang/Exception
        //   710	727	614	java/lang/Exception
        //   731	747	614	java/lang/Exception
        //   750	762	614	java/lang/Exception
        //   135	149	637	android/content/pm/PackageManager$NameNotFoundException
        //   383	414	730	java/lang/IndexOutOfBoundsException
    }

    private static String b(Context paramContext, String paramString1, String paramString2) {
        return paramContext.getSharedPreferences(paramString1, 0).getString(paramString2, "");
    }

    private void l(String paramString) {
        a("ac", paramString);
    }

    private void m(String paramString) {
        a("ei", paramString);
    }

    private void n(String paramString) {
        a("en", paramString);
    }

    private static boolean o(String paramString) {
        paramString = paramString.toCharArray();
        int i2 = paramString.length;
        int i1 = 0;
        for (; ; ) {
            if (i1 >= i2) {
                return false;
            }
            if (Character.isLetter(paramString[i1])) {
                return true;
            }
            i1 += 1;
        }
    }

    private String v() {
        StringBuilder localStringBuilder = new StringBuilder("https://").append(f()).append(".");
        Object localObject;
        if (this.m) {
            localStringBuilder.append("debug.engine.mobileapptracking.com");
            localStringBuilder.append("/serve?s=android&ver=3.0.3");
            localObject = r();
            if (localObject != null) {
                localStringBuilder.append("&sdk_plugin=").append((String) localObject);
            }
            localStringBuilder.append("&pn=").append(q());
            localObject = this.q.keySet().iterator();
        }
        for (; ; ) {
            if (!((Iterator) localObject).hasNext()) {
                if (this.j) {
                    localStringBuilder.append("&skip_dup=1");
                }
                if (this.m) {
                    localStringBuilder.append("&debug=1");
                }
                if (this.p) {
                    localStringBuilder.append("&post_conversion=1");
                }
                if (this.n) {
                    localStringBuilder.append("&existing_user=1");
                }
            }
            for (; ; ) {
                try {
                    localObject = Uri.parse("content://" + q() + "/referrer_apps");
                    localCursor = this.e.getContentResolver().query((Uri) localObject, null, null, null, "publisher_package_name desc");
                    if ((localCursor != null) && (localCursor.moveToFirst())) {
                        localObject = localCursor.getString(localCursor.getColumnIndex("tracking_id"));
                    }
                } catch (Exception localException) {
                    Cursor localCursor;
                    String str;
                    if (!this.m) {
                        continue;
                    }
                    Log.d("MobileAppTracker", "Error reading app-to-app values");
                    localException.printStackTrace();
                    continue;
                }
                try {
                    str = URLEncoder.encode((String) localObject, "UTF-8");
                    localObject = str;
                } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
                    localUnsupportedEncodingException.printStackTrace();
                }
            }
            this.q.put("ti", localObject);
            localCursor.close();
            return localStringBuilder.toString();
            localStringBuilder.append("engine.mobileapptracking.com");
            break;
            str = (String) ((Iterator) localObject).next();
            if (!h.contains(str)) {
                localStringBuilder.append("&").append(str).append("=").append((String) this.q.get(str));
            }
        }
    }

    public int a(String paramString) {
        return a(paramString, null, 0.0D, g(), null, null, null);
    }

    protected String a(ContentResolver paramContentResolver) {
        paramContentResolver = paramContentResolver.query(g, new String[]{"aid"}, null, null, null);
        if ((paramContentResolver == null) || (!paramContentResolver.moveToFirst())) {
            return null;
        }
        String str = paramContentResolver.getString(paramContentResolver.getColumnIndex("aid"));
        paramContentResolver.close();
        return str;
    }

    public void a(Activity paramActivity) {
        a("referral_source", paramActivity.getCallingPackage());
        paramActivity = paramActivity.getIntent();
        if (paramActivity != null) {
            paramActivity = paramActivity.getData();
            if (paramActivity != null) {
                a("referral_url", paramActivity.toString());
            }
        }
    }

    protected void a(String paramString1, String paramString2, String paramString3, double paramDouble, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, boolean paramBoolean) {
        if (paramBoolean) {
            paramString1 = a(paramString1, paramDouble, paramString4, paramString5, paramString8, paramString9, paramString10, paramString11, paramString12);
        }
        JSONObject localJSONObject;
        for (; ; ) {
            localJSONObject = new JSONObject();
            if (paramString2 != null) {
            }
            try {
                localJSONObject.put("data", new JSONArray(paramString2));
                if (paramString6 != null) {
                    localJSONObject.put("store_iap_data", paramString6);
                }
                if (paramString7 != null) {
                    localJSONObject.put("store_iap_signature", paramString7);
                }
            } catch (JSONException localJSONException) {
                do {
                    do {
                        for (; ; ) {
                            if (this.m) {
                                Log.d("MobileAppTracker", "Could not build JSON for event items or verification values");
                            }
                            localJSONException.printStackTrace();
                            continue;
                            try {
                                if (localJSONObject.getString("success") == null) {
                                    a(paramString1, paramString2, paramString3, paramDouble, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, false, new Date());
                                    if (!this.m) {
                                        continue;
                                    }
                                    Log.d("MobileAppTracker", "Request failed: track will be queued");
                                    return;
                                }
                            } catch (JSONException paramString1) {
                                paramString1.printStackTrace();
                                return;
                            }
                            if (this.a != null) {
                            }
                            try {
                                if (localJSONObject.getString("success").equals("true")) {
                                    this.a.a(localJSONObject);
                                }
                                for (; ; ) {
                                    try {
                                        if (localJSONObject.getString("site_event_type").equals("open")) {
                                            paramString1 = localJSONObject.getString("log_id");
                                            if (p() == null) {
                                                a(this.e, "mat_log_id_open", "logId", paramString1);
                                            }
                                            a(this.e, "mat_log_id_last_open", "logId", paramString1);
                                        }
                                    } catch (JSONException paramString1) {
                                        continue;
                                    }
                                    if (!this.m) {
                                        break;
                                    }
                                    Log.d("MobileAppTracker", "Server response: " + localJSONObject.toString());
                                    if (localJSONObject.length() <= 0) {
                                        break;
                                    }
                                    try {
                                        if ((!localJSONObject.has("log_action")) || (localJSONObject.getString("log_action").equals("null"))) {
                                            continue;
                                        }
                                        paramString1 = localJSONObject.getJSONObject("log_action");
                                        if (!paramString1.has("conversion")) {
                                            break;
                                        }
                                        paramString1 = paramString1.getJSONObject("conversion");
                                        if (!paramString1.has("status")) {
                                            break;
                                        }
                                        if (!paramString1.getString("status").equals("rejected")) {
                                            continue;
                                        }
                                        paramString1 = paramString1.getString("status_code");
                                        Log.d("MobileAppTracker", "Event was rejected by server: status code " + paramString1);
                                        return;
                                    } catch (JSONException paramString1) {
                                        Log.d("MobileAppTracker", "Server response status could not be parsed");
                                        paramString1.printStackTrace();
                                        return;
                                    }
                                    this.a.b(localJSONObject);
                                }
                            } catch (JSONException paramString1) {
                                for (; ; ) {
                                    paramString1.printStackTrace();
                                }
                                Log.d("MobileAppTracker", "Event was accepted by server");
                                return;
                            }
                        }
                    } while (!localJSONObject.has("options"));
                    paramString1 = localJSONObject.getJSONObject("options");
                } while (!paramString1.has("conversion_status"));
                paramString1 = paramString1.getString("conversion_status");
                Log.d("MobileAppTracker", "Event was " + paramString1 + " by server");
                return;
            }
            if (this.b != null) {
                this.b.a(paramString1, localJSONObject);
            }
            if (this.m) {
                Log.d("MobileAppTracker", "Sending " + paramString3 + " event to server...");
            }
            localJSONObject = this.i.a(paramString1, localJSONObject);
            if (localJSONObject == null) {
                return;
            }
        }
    }

    protected void a(String paramString1, String paramString2, String paramString3, double paramDouble, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, boolean paramBoolean, Date paramDate) {
        ScheduledExecutorService localScheduledExecutorService = this.s;
        b localb = this.f;
        localb.getClass();
        localScheduledExecutorService.execute(new c(localb, paramString1, paramString2, paramString3, paramDouble, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramBoolean, paramDate));
    }

    public void a(String paramString, boolean paramBoolean) {
        a("google_aid", paramString);
        if (paramBoolean) {
        }
        for (int i1 = 1; ; i1 = 0) {
            a("google_ad_tracking_disabled", Integer.toString(i1));
            return;
        }
    }

    public void a(boolean paramBoolean) {
        this.n = paramBoolean;
    }

    public boolean a(Context paramContext) {
        paramContext = ((ConnectivityManager) paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        return (paramContext != null) && (paramContext.isConnected());
    }

    protected void b() {
        if (!a(this.e)) {
            return;
        }
        ScheduledExecutorService localScheduledExecutorService = this.s;
        b localb = this.f;
        localb.getClass();
        localScheduledExecutorService.execute(new d(localb));
    }

    protected void b(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2) {
        this.e = paramContext.getApplicationContext();
        this.s = Executors.newSingleThreadScheduledExecutor();
        this.i = new j();
        this.r = new a(paramString2.trim(), "heF9BATUfWuISyO8");
        this.c = false;
        this.j = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.k = paramBoolean1;
        this.l = paramBoolean2;
        this.o = a(paramContext, paramString1);
        this.f = new b(paramContext, t);
        if (this.o) {
            b();
        }
        this.d = new h(this);
        if (this.c) {
            paramContext.getApplicationContext().unregisterReceiver(this.d);
            this.c = false;
        }
        paramString1 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        paramContext.getApplicationContext().registerReceiver(this.d, paramString1);
        this.c = true;
    }

    public void b(String paramString) {
        if ((paramString == null) || (paramString.equals(""))) {
            b("USD");
            return;
        }
        a("c", paramString);
    }

    public int c() {
        return a("session", null, t().doubleValue(), g(), s(), null, null);
    }

    public void c(String paramString) {
        a(1, paramString);
    }

    final void d() {
        this.p = true;
        a("session", null, 0.0D, null, null, null, null);
        this.p = false;
    }

    public void d(String paramString) {
        a(2, paramString);
    }

    public String e() {
        return (String) this.q.get("ac");
    }

    public void e(String paramString) {
        a(3, paramString);
    }

    public String f() {
        return (String) this.q.get("adv");
    }

    public void f(String paramString) {
        a(4, paramString);
    }

    public String g() {
        return (String) this.q.get("c");
    }

    public void g(String paramString) {
        a(5, paramString);
    }

    public String h() {
        return (String) this.q.get("attribute_sub1");
    }

    public void h(String paramString) {
        a("ir", paramString);
    }

    public String i() {
        return (String) this.q.get("attribute_sub2");
    }

    public void i(String paramString) {
        if ((paramString == null) || (paramString.equals(""))) {
            i(this.e.getPackageName());
            return;
        }
        a("pn", paramString);
    }

    public String j() {
        return (String) this.q.get("attribute_sub3");
    }

    public void j(String paramString) {
        a("ui", paramString);
    }

    public String k() {
        return (String) this.q.get("attribute_sub4");
    }

    public void k(String paramString) {
        a("user_name", paramString);
    }

    public String l() {
        return (String) this.q.get("attribute_sub5");
    }

    public String m() {
        return b(this.e, "mat_log_id_install", "logId");
    }

    public String n() {
        return (String) this.q.get("ir");
    }

    public String o() {
        return b(this.e, "mat_log_id_last_open", "logId");
    }

    public String p() {
        return b(this.e, "mat_log_id_open", "logId");
    }

    public String q() {
        return (String) this.q.get("pn");
    }

    public String r() {
        return (String) this.q.get("sdk_plugin");
    }

    public String s() {
        return (String) this.q.get("ar");
    }

    public Double t() {
        if (this.q.get("r") == null) {
            return Double.valueOf(0.0D);
        }
        return Double.valueOf(Double.parseDouble((String) this.q.get("r")));
    }

    public String u() {
        return b(this.e, "mat_log_id_update", "logId");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mobileapptracker/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */