package com.inneractive.api.ads.sdk;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.view.View;

final class IAadViewController
        implements P.a, d.b {
    private final Context a;
    private InneractiveAdView b;
    private final f c;
    private final T d;
    private IAnetworkFetcher e;
    private IAadConfig f;
    private final Runnable g;
    private IAadViewController.BannerRequestState h;
    private boolean i;
    private Handler j;
    private String k;
    private boolean l = true;
    private LocationListener m;

    IAadViewController(Context paramContext, InneractiveAdView paramInneractiveAdView) {
        this.a = paramContext;
        this.b = paramInneractiveAdView;
        this.c = new f(paramContext);
        this.d = new T();
        this.f = new IAadConfig(this.a);
        paramContext = this.f;
        this.e = O.a(IAadConfig.g(), this);
        this.g = new IAadViewController .1 (this);
        this.j = new Handler();
        this.h = IAadViewController.BannerRequestState.a;
        this.m = new IAadViewController .2 (this);
        paramContext = this.a;
        paramInneractiveAdView = this.m;
        LocationManager localLocationManager = (LocationManager) paramContext.getSystemService("location");
        try {
            localLocationManager.requestLocationUpdates("gps", 900000L, 200.0F, paramInneractiveAdView, paramContext.getMainLooper());
            return;
        } catch (SecurityException paramContext) {
            InneractiveAdView.Log.d("Inneractive_debug", "Error retrieved when trying to get the network location - access appears to be disabled.");
            return;
        } catch (IllegalArgumentException paramContext) {
            InneractiveAdView.Log.d("Inneractive_debug", "Error retrieved when trying to get the network location - device has no network provider.");
        }
    }

    private void c(InneractiveAdView.InneractiveErrorCode paramInneractiveErrorCode) {
        this.h = IAadViewController.BannerRequestState.d;
        this.b.b(paramInneractiveErrorCode);
    }

    private void p() {
        this.j.removeCallbacks(this.g);
    }

    final void a() {
        int n;
        if (this.a == null) {
            InneractiveAdView.Log.e("Inneractive_fatal", "Context is null! Please provide a valid Context and re-try.");
            n = 0;
            if (n != 0) {
                break label116;
            }
        }
        label116:
        Object localObject1;
        label321:
        label389:
        label424:
        do {
            do {
                return;
                if (c.b(this.f.a)) {
                    InneractiveAdView.Log.e("Inneractive_fatal", "appID is null or empty. Please provide a valid appID and re-try.");
                    n = 0;
                    break;
                }
                if (this.a.checkCallingOrSelfPermission("android.permission.INTERNET") == -1) {
                    InneractiveAdView.Log.e("Inneractive_fatal", "INTERNET permission is missing. Please add it to the Manifest and re-try, otherwise ads will not be requested and displayed! ");
                    n = 0;
                    break;
                }
                if (this.a.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == -1) {
                    InneractiveAdView.Log.e("Inneractive_fatal", "It is recommended to add ACCESS_NETWORK_STATE permission to the Manifest for better targetting");
                }
                if (this.a.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == -1) {
                    InneractiveAdView.Log.w("Inneractive_warning", "It is recomended to add the READ_PHONE_STATE permission to the manifest for better targetting");
                }
                n = 1;
                break;
                localObject1 = ((ConnectivityManager) this.a.getSystemService("connectivity")).getActiveNetworkInfo();
                if ((localObject1 != null) && (((NetworkInfo) localObject1).isConnected())) {
                }
                for (n = 1; n == 0; n = 0) {
                    InneractiveAdView.Log.w("Inneractive_warning", "Network is not connected");
                    c(InneractiveAdView.InneractiveErrorCode.CONNECTION_ERROR);
                    return;
                }
                localObject2 = this.c.b(this.f.a).e(this.f.c()).a(this.f.e()).c(this.f.d()).d(this.f.f()).f(this.f.j()).a(this.f.A()).a(this.f.b).a(this.f.F()).b(this.f.I()).c(this.f.J());
                if (!(this.b instanceof InneractiveInterstitialView)) {
                    break label389;
                }
                localObject1 = this.f.k() + IAdefines.f;
                localObject1 = ((f) localObject2).a((String) localObject1);
            } while (localObject1 == null);
            InneractiveAdView.Log.d("Inneractive_debug", "Ad request URL: " + (String) localObject1);
            if (this.h == IAadViewController.BannerRequestState.b) {
            }
            for (n = 1; ; n = 0) {
                if (n == 0) {
                    break label424;
                }
                if (this.f.a == null) {
                    break;
                }
                InneractiveAdView.Log.i("Inneractive_info", "Loading is already in progress for this ad spot.");
                return;
                localObject1 = this.f.k() + IAdefines.e;
                break label321;
            }
            this.h = IAadViewController.BannerRequestState.b;
            this.k = ((String) localObject1);
            localObject1 = this.k;
        } while (this.e == null);
        Object localObject2 = this.e;
        Context localContext = this.a;
        ((IAnetworkFetcher) localObject2).a((String) localObject1);
    }

    final void a(int paramInt) {
        int n;
        if (this.f.F() == null) {
            if (this.h == IAadViewController.BannerRequestState.a) {
                n = 1;
                if (n != 0) {
                    break label87;
                }
                p();
                if ((this.l) && (paramInt > 0)) {
                    InneractiveAdView.Log.v("Inneractive_verbose", "schedule refresh timer If it's enabled. " + this.b);
                    this.j.postDelayed(this.g, paramInt);
                }
            }
        }
        label87:
        while (this.f.F() == null) {
            return;
            n = 0;
            break;
        }
        InneractiveAdView.Log.d("Inneractive_debug", "As you're using a mediation, the autoRefresh will be turned off and the refresh interval will be set to 0");
    }

    final void a(Location paramLocation) {
        IAadConfig localIAadConfig = this.f;
        IAadConfig.a(paramLocation);
    }

    final void a(View paramView) {
        this.j.post(new IAadViewController .5 (this, paramView));
    }

    final void a(IAdefines.IAIntegratedSdksTrackingAction paramIAIntegratedSdksTrackingAction) {
        if (paramIAIntegratedSdksTrackingAction != null) {
            if (this.f != null) {
                if (IAdefines.IAIntegratedSdksTrackingAction.a.equals(paramIAIntegratedSdksTrackingAction)) {
                    this.f.l("");
                    this.f.k("");
                }
                while (!IAdefines.IAIntegratedSdksTrackingAction.b.equals(paramIAIntegratedSdksTrackingAction)) {
                    return;
                }
                this.f.m("");
                return;
            }
            InneractiveAdView.Log.v("Inneractive_verbose", "ad config is NULL, could not reset tracking data.");
            return;
        }
        InneractiveAdView.Log.v("Inneractive_verbose", "tracking type is NULL, could not reset tracking data.");
    }

    /* Error */
    public final void a(IAresponseData paramIAresponseData) {
        // Byte code:
        //   0: aload_0
        //   1: getfield 65	com/inneractive/api/ads/sdk/IAadViewController:f	Lcom/inneractive/api/ads/sdk/IAadConfig;
        //   4: aload_1
        //   5: invokevirtual 364	com/inneractive/api/ads/sdk/IAadConfig:b	(Lcom/inneractive/api/ads/sdk/IAresponseData;)V
        //   8: aload_1
        //   9: getfield 368	com/inneractive/api/ads/sdk/IAresponseData:h	Ljava/lang/String;
        //   12: astore 4
        //   14: aload_1
        //   15: getfield 370	com/inneractive/api/ads/sdk/IAresponseData:b	Ljava/lang/String;
        //   18: astore 7
        //   20: aload_1
        //   21: getfield 372	com/inneractive/api/ads/sdk/IAresponseData:c	Ljava/lang/String;
        //   24: astore 8
        //   26: aload_1
        //   27: getfield 373	com/inneractive/api/ads/sdk/IAresponseData:f	Ljava/lang/String;
        //   30: astore 9
        //   32: aload_1
        //   33: getfield 374	com/inneractive/api/ads/sdk/IAresponseData:a	Ljava/lang/String;
        //   36: astore 10
        //   38: aload_1
        //   39: getfield 376	com/inneractive/api/ads/sdk/IAresponseData:g	Ljava/lang/String;
        //   42: astore 11
        //   44: aload_1
        //   45: getfield 378	com/inneractive/api/ads/sdk/IAresponseData:d	Ljava/lang/String;
        //   48: astore 6
        //   50: aload_1
        //   51: getfield 379	com/inneractive/api/ads/sdk/IAresponseData:e	Ljava/lang/String;
        //   54: astore 5
        //   56: aload 7
        //   58: invokestatic 160	com/inneractive/api/ads/sdk/c:b	(Ljava/lang/String;)Z
        //   61: ifne +12 -> 73
        //   64: aload_0
        //   65: getfield 65	com/inneractive/api/ads/sdk/IAadViewController:f	Lcom/inneractive/api/ads/sdk/IAadConfig;
        //   68: aload 7
        //   70: invokevirtual 381	com/inneractive/api/ads/sdk/IAadConfig:g	(Ljava/lang/String;)V
        //   73: aload 8
        //   75: invokestatic 160	com/inneractive/api/ads/sdk/c:b	(Ljava/lang/String;)Z
        //   78: ifne +12 -> 90
        //   81: aload_0
        //   82: getfield 65	com/inneractive/api/ads/sdk/IAadViewController:f	Lcom/inneractive/api/ads/sdk/IAadConfig;
        //   85: aload 8
        //   87: invokevirtual 383	com/inneractive/api/ads/sdk/IAadConfig:h	(Ljava/lang/String;)V
        //   90: aload 9
        //   92: invokestatic 160	com/inneractive/api/ads/sdk/c:b	(Ljava/lang/String;)Z
        //   95: ifne +12 -> 107
        //   98: aload_0
        //   99: getfield 65	com/inneractive/api/ads/sdk/IAadViewController:f	Lcom/inneractive/api/ads/sdk/IAadConfig;
        //   102: aload 9
        //   104: invokevirtual 385	com/inneractive/api/ads/sdk/IAadConfig:i	(Ljava/lang/String;)V
        //   107: aload 10
        //   109: invokestatic 160	com/inneractive/api/ads/sdk/c:b	(Ljava/lang/String;)Z
        //   112: ifne +12 -> 124
        //   115: aload_0
        //   116: getfield 65	com/inneractive/api/ads/sdk/IAadViewController:f	Lcom/inneractive/api/ads/sdk/IAadConfig;
        //   119: aload 10
        //   121: invokevirtual 386	com/inneractive/api/ads/sdk/IAadConfig:a	(Ljava/lang/String;)V
        //   124: aload 11
        //   126: invokestatic 160	com/inneractive/api/ads/sdk/c:b	(Ljava/lang/String;)Z
        //   129: istore_3
        //   130: iload_3
        //   131: ifne +40 -> 171
        //   134: aload 11
        //   136: invokestatic 391	java/lang/Integer:parseInt	(Ljava/lang/String;)I
        //   139: istore_2
        //   140: aload_0
        //   141: getfield 65	com/inneractive/api/ads/sdk/IAadViewController:f	Lcom/inneractive/api/ads/sdk/IAadConfig;
        //   144: iload_2
        //   145: invokevirtual 393	com/inneractive/api/ads/sdk/IAadConfig:f	(I)V
        //   148: ldc_w 308
        //   151: new 265	java/lang/StringBuilder
        //   154: dup
        //   155: ldc_w 395
        //   158: invokespecial 287	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   161: iload_2
        //   162: invokevirtual 398	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   165: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   168: invokestatic 316	com/inneractive/api/ads/sdk/InneractiveAdView$Log:v	(Ljava/lang/String;Ljava/lang/String;)V
        //   171: aload 6
        //   173: invokestatic 160	com/inneractive/api/ads/sdk/c:b	(Ljava/lang/String;)Z
        //   176: istore_3
        //   177: iload_3
        //   178: ifne +40 -> 218
        //   181: aload 6
        //   183: invokestatic 391	java/lang/Integer:parseInt	(Ljava/lang/String;)I
        //   186: istore_2
        //   187: aload_0
        //   188: getfield 65	com/inneractive/api/ads/sdk/IAadViewController:f	Lcom/inneractive/api/ads/sdk/IAadConfig;
        //   191: iload_2
        //   192: invokevirtual 400	com/inneractive/api/ads/sdk/IAadConfig:d	(I)V
        //   195: ldc_w 308
        //   198: new 265	java/lang/StringBuilder
        //   201: dup
        //   202: ldc_w 402
        //   205: invokespecial 287	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   208: iload_2
        //   209: invokevirtual 398	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   212: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   215: invokestatic 316	com/inneractive/api/ads/sdk/InneractiveAdView$Log:v	(Ljava/lang/String;Ljava/lang/String;)V
        //   218: aload 5
        //   220: invokestatic 160	com/inneractive/api/ads/sdk/c:b	(Ljava/lang/String;)Z
        //   223: istore_3
        //   224: iload_3
        //   225: ifne +40 -> 265
        //   228: aload 5
        //   230: invokestatic 391	java/lang/Integer:parseInt	(Ljava/lang/String;)I
        //   233: istore_2
        //   234: aload_0
        //   235: getfield 65	com/inneractive/api/ads/sdk/IAadViewController:f	Lcom/inneractive/api/ads/sdk/IAadConfig;
        //   238: iload_2
        //   239: invokevirtual 404	com/inneractive/api/ads/sdk/IAadConfig:e	(I)V
        //   242: ldc_w 308
        //   245: new 265	java/lang/StringBuilder
        //   248: dup
        //   249: ldc_w 406
        //   252: invokespecial 287	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   255: iload_2
        //   256: invokevirtual 398	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   259: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   262: invokestatic 316	com/inneractive/api/ads/sdk/InneractiveAdView$Log:v	(Ljava/lang/String;Ljava/lang/String;)V
        //   265: aload_0
        //   266: getfield 65	com/inneractive/api/ads/sdk/IAadViewController:f	Lcom/inneractive/api/ads/sdk/IAadConfig;
        //   269: aload_1
        //   270: invokevirtual 364	com/inneractive/api/ads/sdk/IAadConfig:b	(Lcom/inneractive/api/ads/sdk/IAresponseData;)V
        //   273: aload_0
        //   274: getfield 65	com/inneractive/api/ads/sdk/IAadViewController:f	Lcom/inneractive/api/ads/sdk/IAadConfig;
        //   277: ifnull +338 -> 615
        //   280: aload_0
        //   281: getfield 65	com/inneractive/api/ads/sdk/IAadViewController:f	Lcom/inneractive/api/ads/sdk/IAadConfig;
        //   284: invokevirtual 409	com/inneractive/api/ads/sdk/IAadConfig:y	()Ljava/lang/String;
        //   287: astore 4
        //   289: aload 4
        //   291: ifnull +324 -> 615
        //   294: ldc_w 411
        //   297: aload 4
        //   299: invokevirtual 414	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   302: ifeq +116 -> 418
        //   305: aload_0
        //   306: getstatic 416	com/inneractive/api/ads/sdk/IAadViewController$BannerRequestState:c	Lcom/inneractive/api/ads/sdk/IAadViewController$BannerRequestState;
        //   309: putfield 93	com/inneractive/api/ads/sdk/IAadViewController:h	Lcom/inneractive/api/ads/sdk/IAadViewController$BannerRequestState;
        //   312: aload_0
        //   313: getfield 48	com/inneractive/api/ads/sdk/IAadViewController:b	Lcom/inneractive/api/ads/sdk/InneractiveAdView;
        //   316: astore 4
        //   318: ldc_w 308
        //   321: ldc_w 418
        //   324: invokestatic 316	com/inneractive/api/ads/sdk/InneractiveAdView$Log:v	(Ljava/lang/String;Ljava/lang/String;)V
        //   327: aload 4
        //   329: iconst_0
        //   330: putfield 420	com/inneractive/api/ads/sdk/InneractiveAdView:c	Z
        //   333: aload 4
        //   335: getfield 422	com/inneractive/api/ads/sdk/InneractiveAdView:b	Z
        //   338: ifeq +9 -> 347
        //   341: aload 4
        //   343: aload_1
        //   344: invokevirtual 424	com/inneractive/api/ads/sdk/InneractiveAdView:a	(Lcom/inneractive/api/ads/sdk/IAresponseData;)V
        //   347: return
        //   348: astore 7
        //   350: ldc_w 308
        //   353: ldc_w 426
        //   356: invokestatic 316	com/inneractive/api/ads/sdk/InneractiveAdView$Log:v	(Ljava/lang/String;Ljava/lang/String;)V
        //   359: goto -188 -> 171
        //   362: astore 5
        //   364: ldc 123
        //   366: new 265	java/lang/StringBuilder
        //   369: dup
        //   370: ldc_w 428
        //   373: invokespecial 287	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   376: aload 4
        //   378: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   381: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   384: invokestatic 130	com/inneractive/api/ads/sdk/InneractiveAdView$Log:d	(Ljava/lang/String;Ljava/lang/String;)V
        //   387: goto -114 -> 273
        //   390: astore 6
        //   392: ldc_w 308
        //   395: ldc_w 430
        //   398: invokestatic 316	com/inneractive/api/ads/sdk/InneractiveAdView$Log:v	(Ljava/lang/String;Ljava/lang/String;)V
        //   401: goto -183 -> 218
        //   404: astore 5
        //   406: ldc_w 308
        //   409: ldc_w 432
        //   412: invokestatic 316	com/inneractive/api/ads/sdk/InneractiveAdView$Log:v	(Ljava/lang/String;Ljava/lang/String;)V
        //   415: goto -150 -> 265
        //   418: ldc_w 434
        //   421: aload 4
        //   423: invokevirtual 414	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   426: ifeq +111 -> 537
        //   429: aload_0
        //   430: getstatic 416	com/inneractive/api/ads/sdk/IAadViewController$BannerRequestState:c	Lcom/inneractive/api/ads/sdk/IAadViewController$BannerRequestState;
        //   433: putfield 93	com/inneractive/api/ads/sdk/IAadViewController:h	Lcom/inneractive/api/ads/sdk/IAadViewController$BannerRequestState;
        //   436: aload_0
        //   437: getfield 48	com/inneractive/api/ads/sdk/IAadViewController:b	Lcom/inneractive/api/ads/sdk/InneractiveAdView;
        //   440: astore 4
        //   442: ldc_w 308
        //   445: ldc_w 436
        //   448: invokestatic 316	com/inneractive/api/ads/sdk/InneractiveAdView$Log:v	(Ljava/lang/String;Ljava/lang/String;)V
        //   451: aload 4
        //   453: iconst_0
        //   454: putfield 420	com/inneractive/api/ads/sdk/InneractiveAdView:c	Z
        //   457: aload 4
        //   459: getfield 422	com/inneractive/api/ads/sdk/InneractiveAdView:b	Z
        //   462: ifeq -115 -> 347
        //   465: aload 4
        //   467: invokevirtual 440	com/inneractive/api/ads/sdk/InneractiveAdView:getContext	()Landroid/content/Context;
        //   470: ldc_w 442
        //   473: invokestatic 445	com/inneractive/api/ads/sdk/c:b	(Landroid/content/Context;Ljava/lang/String;)Z
        //   476: ifeq +54 -> 530
        //   479: aload 4
        //   481: invokevirtual 449	com/inneractive/api/ads/sdk/InneractiveAdView:n	()Lcom/inneractive/api/ads/sdk/IAadViewController;
        //   484: ifnull +46 -> 530
        //   487: aload 4
        //   489: invokevirtual 449	com/inneractive/api/ads/sdk/InneractiveAdView:n	()Lcom/inneractive/api/ads/sdk/IAadViewController;
        //   492: getfield 65	com/inneractive/api/ads/sdk/IAadViewController:f	Lcom/inneractive/api/ads/sdk/IAadConfig;
        //   495: invokevirtual 453	com/inneractive/api/ads/sdk/IAadConfig:o	()Ljava/util/Map;
        //   498: ifnull +32 -> 530
        //   501: aload 4
        //   503: invokevirtual 449	com/inneractive/api/ads/sdk/InneractiveAdView:n	()Lcom/inneractive/api/ads/sdk/IAadViewController;
        //   506: getfield 65	com/inneractive/api/ads/sdk/IAadViewController:f	Lcom/inneractive/api/ads/sdk/IAadConfig;
        //   509: invokevirtual 453	com/inneractive/api/ads/sdk/IAadConfig:o	()Ljava/util/Map;
        //   512: ldc_w 442
        //   515: invokeinterface 459 2 0
        //   520: ifnull +10 -> 530
        //   523: aload_1
        //   524: ldc_w 461
        //   527: putfield 368	com/inneractive/api/ads/sdk/IAresponseData:h	Ljava/lang/String;
        //   530: aload 4
        //   532: aload_1
        //   533: invokevirtual 424	com/inneractive/api/ads/sdk/InneractiveAdView:a	(Lcom/inneractive/api/ads/sdk/IAresponseData;)V
        //   536: return
        //   537: ldc_w 463
        //   540: aload 4
        //   542: invokevirtual 414	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   545: ifeq +18 -> 563
        //   548: aload_0
        //   549: getstatic 91	com/inneractive/api/ads/sdk/IAadViewController$BannerRequestState:a	Lcom/inneractive/api/ads/sdk/IAadViewController$BannerRequestState;
        //   552: putfield 93	com/inneractive/api/ads/sdk/IAadViewController:h	Lcom/inneractive/api/ads/sdk/IAadViewController$BannerRequestState;
        //   555: aload_0
        //   556: getstatic 466	com/inneractive/api/ads/sdk/InneractiveAdView$InneractiveErrorCode:SERVER_INTERNAL_ERROR	Lcom/inneractive/api/ads/sdk/InneractiveAdView$InneractiveErrorCode;
        //   559: invokespecial 207	com/inneractive/api/ads/sdk/IAadViewController:c	(Lcom/inneractive/api/ads/sdk/InneractiveAdView$InneractiveErrorCode;)V
        //   562: return
        //   563: ldc_w 468
        //   566: aload 4
        //   568: invokevirtual 414	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   571: ifeq +18 -> 589
        //   574: aload_0
        //   575: getstatic 91	com/inneractive/api/ads/sdk/IAadViewController$BannerRequestState:a	Lcom/inneractive/api/ads/sdk/IAadViewController$BannerRequestState;
        //   578: putfield 93	com/inneractive/api/ads/sdk/IAadViewController:h	Lcom/inneractive/api/ads/sdk/IAadViewController$BannerRequestState;
        //   581: aload_0
        //   582: getstatic 471	com/inneractive/api/ads/sdk/InneractiveAdView$InneractiveErrorCode:INVALID_INPUT	Lcom/inneractive/api/ads/sdk/InneractiveAdView$InneractiveErrorCode;
        //   585: invokespecial 207	com/inneractive/api/ads/sdk/IAadViewController:c	(Lcom/inneractive/api/ads/sdk/InneractiveAdView$InneractiveErrorCode;)V
        //   588: return
        //   589: ldc_w 473
        //   592: aload 4
        //   594: invokevirtual 414	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   597: ifeq +18 -> 615
        //   600: aload_0
        //   601: getstatic 91	com/inneractive/api/ads/sdk/IAadViewController$BannerRequestState:a	Lcom/inneractive/api/ads/sdk/IAadViewController$BannerRequestState;
        //   604: putfield 93	com/inneractive/api/ads/sdk/IAadViewController:h	Lcom/inneractive/api/ads/sdk/IAadViewController$BannerRequestState;
        //   607: aload_0
        //   608: getstatic 476	com/inneractive/api/ads/sdk/InneractiveAdView$InneractiveErrorCode:UNKNOWN_APP_ID	Lcom/inneractive/api/ads/sdk/InneractiveAdView$InneractiveErrorCode;
        //   611: invokespecial 207	com/inneractive/api/ads/sdk/IAadViewController:c	(Lcom/inneractive/api/ads/sdk/InneractiveAdView$InneractiveErrorCode;)V
        //   614: return
        //   615: aload_0
        //   616: getstatic 91	com/inneractive/api/ads/sdk/IAadViewController$BannerRequestState:a	Lcom/inneractive/api/ads/sdk/IAadViewController$BannerRequestState;
        //   619: putfield 93	com/inneractive/api/ads/sdk/IAadViewController:h	Lcom/inneractive/api/ads/sdk/IAadViewController$BannerRequestState;
        //   622: aload_0
        //   623: getstatic 479	com/inneractive/api/ads/sdk/InneractiveAdView$InneractiveErrorCode:UNSPECIFIED	Lcom/inneractive/api/ads/sdk/InneractiveAdView$InneractiveErrorCode;
        //   626: invokespecial 207	com/inneractive/api/ads/sdk/IAadViewController:c	(Lcom/inneractive/api/ads/sdk/InneractiveAdView$InneractiveErrorCode;)V
        //   629: return
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	630	0	this	IAadViewController
        //   0	630	1	paramIAresponseData	IAresponseData
        //   139	117	2	n	int
        //   129	96	3	bool	boolean
        //   12	581	4	localObject	Object
        //   54	175	5	str1	String
        //   362	1	5	localException1	Exception
        //   404	1	5	localException2	Exception
        //   48	134	6	str2	String
        //   390	1	6	localException3	Exception
        //   18	51	7	str3	String
        //   348	1	7	localException4	Exception
        //   24	62	8	str4	String
        //   30	73	9	str5	String
        //   36	84	10	str6	String
        //   42	93	11	str7	String
        // Exception table:
        //   from	to	target	type
        //   134	171	348	java/lang/Exception
        //   14	73	362	java/lang/Exception
        //   73	90	362	java/lang/Exception
        //   90	107	362	java/lang/Exception
        //   107	124	362	java/lang/Exception
        //   124	130	362	java/lang/Exception
        //   171	177	362	java/lang/Exception
        //   218	224	362	java/lang/Exception
        //   265	273	362	java/lang/Exception
        //   350	359	362	java/lang/Exception
        //   392	401	362	java/lang/Exception
        //   406	415	362	java/lang/Exception
        //   181	218	390	java/lang/Exception
        //   228	265	404	java/lang/Exception
    }

    final void a(InneractiveAdView.Gender paramGender) {
        this.f.a(paramGender);
    }

    public final void a(InneractiveAdView.InneractiveErrorCode paramInneractiveErrorCode) {
        c(paramInneractiveErrorCode);
    }

    final void a(InneractiveAdView.InternalAdType paramInternalAdType) {
        IAadConfig localIAadConfig = this.f;
        if (paramInternalAdType != null) {
            localIAadConfig.b = paramInternalAdType;
            return;
        }
        InneractiveAdView.Log.w("Inneractive_warning", "The adType is invalid! setting the adType to the default - Banner");
        localIAadConfig.b = InneractiveAdView.InternalAdType.a;
    }

    final void a(InneractiveAdView.MediationName paramMediationName) {
        this.f.a(paramMediationName);
    }

    public final void a(d paramd) {
        paramd.a();
        paramd.b();
    }

    final void a(String paramString) {
        this.f.d(paramString);
    }

    final void a(boolean paramBoolean) {
        this.f.c(paramBoolean);
    }

    final String b(IAdefines.IAIntegratedSdksTrackingAction paramIAIntegratedSdksTrackingAction) {
        String str1 = null;
        if (paramIAIntegratedSdksTrackingAction != null) {
            String str2 = this.f.l() + IAdefines.c;
            InneractiveAdView.Log.v("Inneractive_verbose", "integrated sdks tracking server host: " + str2);
            if (str2 != null) {
                if (IAdefines.IAIntegratedSdksTrackingAction.a.equals(paramIAIntegratedSdksTrackingAction)) {
                    str1 = this.d.a(this.f.A()).b(this.f.a).c(this.f.n()).d(this.f.D()).b().f(this.f.C()).a(str2, paramIAIntegratedSdksTrackingAction);
                }
                while (!IAdefines.IAIntegratedSdksTrackingAction.b.equals(paramIAIntegratedSdksTrackingAction)) {
                    return str1;
                }
                return this.d.a(this.f.A()).b(this.f.a).c(this.f.n()).h(this.f.E()).e("paying").a(str2, paramIAIntegratedSdksTrackingAction);
            }
            InneractiveAdView.Log.v("Inneractive_verbose", "getTrackingServerHostname(" + paramIAIntegratedSdksTrackingAction + ") = null!");
            return null;
        }
        InneractiveAdView.Log.d("Inneractive_debug", "generateIntegratedSdksTrackingUrl. trackingType is NULL");
        return null;
    }

    final void b() {
        a();
    }

    final void b(int paramInt) {
        this.f.a(paramInt);
    }

    public final void b(InneractiveAdView.InneractiveErrorCode paramInneractiveErrorCode) {
        c(paramInneractiveErrorCode);
    }

    final void b(String paramString) {
        IAadConfig localIAadConfig = this.f;
        if (!c.b(paramString)) {
            localIAadConfig.a = paramString;
            return;
        }
        InneractiveAdView.Log.e("Inneractive_fatal", "The appID is invalid! Please provide the appID that you generated in inneractive's console under your account in order to get ads and track your performance and revenues!");
    }

    final void b(boolean paramBoolean) {
        this.f.d(paramBoolean);
    }

    protected final InneractiveAdView c() {
        return this.b;
    }

    final void c(int paramInt) {
        this.f.b(paramInt);
    }

    final void c(String paramString) {
        this.f.e(paramString);
    }

    final void c(boolean paramBoolean) {
        if (this.f.F() == null) {
            InneractiveAdView.Log.v("Inneractive_verbose", "setting auto refresh to be enabled " + paramBoolean);
            this.l = paramBoolean;
            if (this.f.a != null) {
                InneractiveAdView.Log.d("Inneractive_debug", "Automatic refresh for appId: " + this.f.a + " just set to: " + paramBoolean + "." + this.b);
            }
            if (this.l) {
                a(1000);
                return;
            }
            InneractiveAdView.Log.v("Inneractive_verbose", "no autoRefresh - canceling the refresh timer");
            p();
            return;
        }
        InneractiveAdView.Log.d("Inneractive_debug", "As you're using a mediation, the autoRefresh will be turned off and the refresh interval will be set to 0");
    }

    final String d() {
        return this.f.c();
    }

    final void d(String paramString) {
        this.f.b(paramString);
    }

    final String e() {
        return this.f.d();
    }

    final void e(String paramString) {
        this.f.c(paramString);
    }

    final int f() {
        return this.f.e();
    }

    final int g() {
        return this.f.c;
    }

    final String h() {
        return this.f.f();
    }

    final int i() {
        return this.f.p();
    }

    final int j() {
        return this.f.q();
    }

    final boolean k() {
        return this.l;
    }

    final IAresponseData l() {
        return this.f.z();
    }

    final IAadConfig m() {
        return this.f;
    }

    final void n() {
        if (this.i) {
            return;
        }
        InneractiveAdView.Log.d("Inneractive_debug", "Controller cleanup");
        c(false);
        InneractiveAdView.Log.v("Inneractive_verbose", "cleanup - canceling the refresh timer");
        p();
        InneractiveAdView.Log.v("Inneractive_verbose", "cleanup - unregistering location manager");
        Object localObject = this.a;
        LocationListener localLocationListener = this.m;
        localObject = (LocationManager) ((Context) localObject).getSystemService("location");
        try {
            ((LocationManager) localObject).removeUpdates(localLocationListener);
            this.e.a();
            this.e = null;
            this.f.a();
            this.b = null;
            this.i = true;
            return;
        } catch (Exception localException) {
            for (; ; ) {
                InneractiveAdView.Log.d("Inneractive_debug", "Error retrieved when trying to stop location updates - updates were already paused.");
            }
        }
    }

    final Integer o() {
        IAadConfig localIAadConfig = this.f;
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inneractive/api/ads/sdk/IAadViewController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */