package com.millennialmedia.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class MMAdView
  extends FrameLayout
  implements View.OnClickListener, Animation.AnimationListener
{
  public static final String BANNER_AD_BOTTOM = "MMBannerAdBottom";
  public static final String BANNER_AD_RECTANGLE = "MMBannerAdRectangle";
  public static final String BANNER_AD_TOP = "MMBannerAdTop";
  public static final String FULLSCREEN_AD_LAUNCH = "MMFullScreenAdLaunch";
  public static final String FULLSCREEN_AD_TRANSITION = "MMFullScreenAdTransition";
  public static final String KEY_AGE = "age";
  public static final String KEY_CHILDREN = "children";
  public static final String KEY_EDUCATION = "education";
  public static final String KEY_ETHNICITY = "ethnicity";
  public static final String KEY_GENDER = "gender";
  public static final String KEY_HEIGHT = "height";
  public static final String KEY_INCOME = "income";
  public static final String KEY_KEYWORDS = "keywords";
  public static final String KEY_MARITAL_STATUS = "marital";
  public static final String KEY_ORIENTATION = "orientation";
  public static final String KEY_POLITICS = "politics";
  public static final String KEY_VENDOR = "vendor";
  public static final String KEY_WIDTH = "width";
  public static final String KEY_ZIP_CODE = "zip";
  public static final int REFRESH_INTERVAL_OFF = -1;
  public static final int TRANSITION_DOWN = 3;
  public static final int TRANSITION_FADE = 1;
  public static final int TRANSITION_NONE = 0;
  public static final int TRANSITION_RANDOM = 4;
  public static final int TRANSITION_UP = 2;
  private static boolean appInit;
  private static long nextAdViewId = 1L;
  String acid = null;
  String adType;
  Long adViewId;
  String apid = "28911";
  MMAdViewController controller;
  Request deferedRequest;
  private GestureDetector gestureDetector;
  String goalId;
  String height = null;
  boolean ignoreDensityScaling = false;
  ImageView imageView;
  long lastAdRequest;
  MMAdListener listener;
  String mxsdk = null;
  int refreshInterval = 60;
  int transitionType = 4;
  public String userData;
  String width = null;
  boolean xmlLayout = false;
  
  public MMAdView(Context paramContext)
  {
    super(paramContext);
    MMAdViewSDK.Log.d("Creating new MMAdView for conversion tracking.");
    checkPermissions(paramContext);
  }
  
  public MMAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  /* Error */
  public MMAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial 178	android/widget/FrameLayout:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: bipush 60
    //   10: putfield 142	com/millennialmedia/android/MMAdView:refreshInterval	I
    //   13: aload_0
    //   14: ldc -112
    //   16: putfield 146	com/millennialmedia/android/MMAdView:apid	Ljava/lang/String;
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 148	com/millennialmedia/android/MMAdView:acid	Ljava/lang/String;
    //   24: aload_0
    //   25: aconst_null
    //   26: putfield 150	com/millennialmedia/android/MMAdView:mxsdk	Ljava/lang/String;
    //   29: aload_0
    //   30: aconst_null
    //   31: putfield 152	com/millennialmedia/android/MMAdView:height	Ljava/lang/String;
    //   34: aload_0
    //   35: aconst_null
    //   36: putfield 154	com/millennialmedia/android/MMAdView:width	Ljava/lang/String;
    //   39: aload_0
    //   40: iconst_0
    //   41: putfield 156	com/millennialmedia/android/MMAdView:xmlLayout	Z
    //   44: aload_0
    //   45: iconst_0
    //   46: putfield 158	com/millennialmedia/android/MMAdView:ignoreDensityScaling	Z
    //   49: aload_0
    //   50: iconst_4
    //   51: putfield 160	com/millennialmedia/android/MMAdView:transitionType	I
    //   54: aload_0
    //   55: invokevirtual 182	com/millennialmedia/android/MMAdView:isInEditMode	()Z
    //   58: ifne +350 -> 408
    //   61: ldc -72
    //   63: invokestatic 168	com/millennialmedia/android/MMAdViewSDK$Log:d	(Ljava/lang/String;)V
    //   66: aload_2
    //   67: ifnull +330 -> 397
    //   70: aload_0
    //   71: aload_2
    //   72: ldc -70
    //   74: ldc -69
    //   76: invokeinterface 193 3 0
    //   81: putfield 146	com/millennialmedia/android/MMAdView:apid	Ljava/lang/String;
    //   84: aload_0
    //   85: aload_2
    //   86: ldc -70
    //   88: ldc -62
    //   90: invokeinterface 193 3 0
    //   95: putfield 148	com/millennialmedia/android/MMAdView:acid	Ljava/lang/String;
    //   98: aload_0
    //   99: aload_2
    //   100: ldc -70
    //   102: ldc -61
    //   104: invokeinterface 193 3 0
    //   109: putfield 197	com/millennialmedia/android/MMAdView:adType	Ljava/lang/String;
    //   112: aload_0
    //   113: aload_2
    //   114: ldc -70
    //   116: ldc -58
    //   118: bipush 60
    //   120: invokeinterface 202 4 0
    //   125: putfield 142	com/millennialmedia/android/MMAdView:refreshInterval	I
    //   128: aload_0
    //   129: aload_2
    //   130: ldc -70
    //   132: ldc -53
    //   134: iconst_0
    //   135: invokeinterface 207 4 0
    //   140: putfield 158	com/millennialmedia/android/MMAdView:ignoreDensityScaling	Z
    //   143: aload_0
    //   144: aload_2
    //   145: ldc -70
    //   147: ldc 67
    //   149: invokeinterface 193 3 0
    //   154: putfield 152	com/millennialmedia/android/MMAdView:height	Ljava/lang/String;
    //   157: aload_0
    //   158: aload_2
    //   159: ldc -70
    //   161: ldc 88
    //   163: invokeinterface 193 3 0
    //   168: putfield 154	com/millennialmedia/android/MMAdView:width	Ljava/lang/String;
    //   171: getstatic 213	com/millennialmedia/android/MMAdViewSDK:demographic	Lcom/millennialmedia/android/MMDemographic;
    //   174: ifnull +209 -> 383
    //   177: getstatic 213	com/millennialmedia/android/MMAdViewSDK:demographic	Lcom/millennialmedia/android/MMDemographic;
    //   180: aload_2
    //   181: ldc -70
    //   183: ldc 64
    //   185: invokeinterface 193 3 0
    //   190: putfield 217	com/millennialmedia/android/MMDemographic:gender	Ljava/lang/String;
    //   193: getstatic 213	com/millennialmedia/android/MMAdViewSDK:demographic	Lcom/millennialmedia/android/MMDemographic;
    //   196: aload_2
    //   197: ldc -70
    //   199: ldc 61
    //   201: invokeinterface 193 3 0
    //   206: putfield 219	com/millennialmedia/android/MMDemographic:ethnicity	Ljava/lang/String;
    //   209: getstatic 213	com/millennialmedia/android/MMAdViewSDK:demographic	Lcom/millennialmedia/android/MMDemographic;
    //   212: aload_2
    //   213: ldc -70
    //   215: ldc 79
    //   217: invokeinterface 193 3 0
    //   222: putfield 221	com/millennialmedia/android/MMDemographic:orientation	Ljava/lang/String;
    //   225: getstatic 213	com/millennialmedia/android/MMAdViewSDK:demographic	Lcom/millennialmedia/android/MMDemographic;
    //   228: aload_2
    //   229: ldc -70
    //   231: ldc 76
    //   233: invokeinterface 193 3 0
    //   238: putfield 223	com/millennialmedia/android/MMDemographic:marital	Ljava/lang/String;
    //   241: getstatic 213	com/millennialmedia/android/MMAdViewSDK:demographic	Lcom/millennialmedia/android/MMDemographic;
    //   244: aload_2
    //   245: ldc -70
    //   247: ldc 58
    //   249: invokeinterface 193 3 0
    //   254: putfield 225	com/millennialmedia/android/MMDemographic:education	Ljava/lang/String;
    //   257: getstatic 213	com/millennialmedia/android/MMAdViewSDK:demographic	Lcom/millennialmedia/android/MMDemographic;
    //   260: ldc 52
    //   262: aload_2
    //   263: ldc -70
    //   265: ldc 52
    //   267: invokeinterface 193 3 0
    //   272: invokevirtual 229	com/millennialmedia/android/MMDemographic:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   275: getstatic 213	com/millennialmedia/android/MMAdViewSDK:demographic	Lcom/millennialmedia/android/MMDemographic;
    //   278: ldc 91
    //   280: aload_2
    //   281: ldc -70
    //   283: ldc 91
    //   285: invokeinterface 193 3 0
    //   290: invokevirtual 229	com/millennialmedia/android/MMDemographic:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   293: getstatic 213	com/millennialmedia/android/MMAdViewSDK:demographic	Lcom/millennialmedia/android/MMDemographic;
    //   296: ldc 70
    //   298: aload_2
    //   299: ldc -70
    //   301: ldc 70
    //   303: invokeinterface 193 3 0
    //   308: invokevirtual 229	com/millennialmedia/android/MMDemographic:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   311: getstatic 213	com/millennialmedia/android/MMAdViewSDK:demographic	Lcom/millennialmedia/android/MMDemographic;
    //   314: ldc 73
    //   316: aload_2
    //   317: ldc -70
    //   319: ldc 73
    //   321: invokeinterface 193 3 0
    //   326: invokevirtual 229	com/millennialmedia/android/MMDemographic:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   329: getstatic 213	com/millennialmedia/android/MMAdViewSDK:demographic	Lcom/millennialmedia/android/MMDemographic;
    //   332: ldc 55
    //   334: aload_2
    //   335: ldc -70
    //   337: ldc 55
    //   339: invokeinterface 193 3 0
    //   344: invokevirtual 229	com/millennialmedia/android/MMDemographic:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   347: getstatic 213	com/millennialmedia/android/MMAdViewSDK:demographic	Lcom/millennialmedia/android/MMDemographic;
    //   350: ldc 82
    //   352: aload_2
    //   353: ldc -70
    //   355: ldc 82
    //   357: invokeinterface 193 3 0
    //   362: invokevirtual 229	com/millennialmedia/android/MMDemographic:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   365: getstatic 213	com/millennialmedia/android/MMAdViewSDK:demographic	Lcom/millennialmedia/android/MMDemographic;
    //   368: ldc 85
    //   370: aload_2
    //   371: ldc -70
    //   373: ldc 85
    //   375: invokeinterface 193 3 0
    //   380: invokevirtual 229	com/millennialmedia/android/MMDemographic:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   383: aload_0
    //   384: aload_2
    //   385: ldc -70
    //   387: ldc -26
    //   389: invokeinterface 193 3 0
    //   394: putfield 232	com/millennialmedia/android/MMAdView:goalId	Ljava/lang/String;
    //   397: aload_0
    //   398: iconst_1
    //   399: putfield 156	com/millennialmedia/android/MMAdView:xmlLayout	Z
    //   402: aload_0
    //   403: aload_1
    //   404: invokespecial 235	com/millennialmedia/android/MMAdView:init	(Landroid/content/Context;)V
    //   407: return
    //   408: new 237	android/widget/ImageView
    //   411: dup
    //   412: aload_1
    //   413: invokespecial 238	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   416: astore 14
    //   418: aconst_null
    //   419: astore 10
    //   421: aconst_null
    //   422: astore 11
    //   424: aconst_null
    //   425: astore 12
    //   427: aconst_null
    //   428: astore 8
    //   430: aconst_null
    //   431: astore 9
    //   433: aconst_null
    //   434: astore 5
    //   436: aload 10
    //   438: astore_2
    //   439: aload 8
    //   441: astore 6
    //   443: aload 11
    //   445: astore 4
    //   447: aload 9
    //   449: astore 7
    //   451: ldc -16
    //   453: invokestatic 246	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   456: astore 13
    //   458: aload 13
    //   460: astore_1
    //   461: aload 13
    //   463: ifnull +69 -> 532
    //   466: aload 13
    //   468: astore_1
    //   469: aload 10
    //   471: astore_2
    //   472: aload 8
    //   474: astore 6
    //   476: aload 11
    //   478: astore 4
    //   480: aload 9
    //   482: astore 7
    //   484: aload 13
    //   486: getstatic 251	java/io/File:separator	Ljava/lang/String;
    //   489: invokevirtual 257	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   492: ifne +40 -> 532
    //   495: aload 10
    //   497: astore_2
    //   498: aload 8
    //   500: astore 6
    //   502: aload 11
    //   504: astore 4
    //   506: aload 9
    //   508: astore 7
    //   510: new 259	java/lang/StringBuilder
    //   513: dup
    //   514: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   517: aload 13
    //   519: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: getstatic 251	java/io/File:separator	Ljava/lang/String;
    //   525: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   531: astore_1
    //   532: aload 10
    //   534: astore_2
    //   535: aload 8
    //   537: astore 6
    //   539: aload 11
    //   541: astore 4
    //   543: aload 9
    //   545: astore 7
    //   547: new 248	java/io/File
    //   550: dup
    //   551: new 259	java/lang/StringBuilder
    //   554: dup
    //   555: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   558: aload_1
    //   559: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: ldc_w 271
    //   565: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: invokevirtual 269	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   571: invokespecial 273	java/io/File:<init>	(Ljava/lang/String;)V
    //   574: astore 13
    //   576: aload 12
    //   578: astore_1
    //   579: aload 10
    //   581: astore_2
    //   582: aload 8
    //   584: astore 6
    //   586: aload 11
    //   588: astore 4
    //   590: aload 9
    //   592: astore 7
    //   594: aload 13
    //   596: invokevirtual 276	java/io/File:exists	()Z
    //   599: ifne +197 -> 796
    //   602: aload 10
    //   604: astore_2
    //   605: aload 8
    //   607: astore 6
    //   609: aload 11
    //   611: astore 4
    //   613: aload 9
    //   615: astore 7
    //   617: new 278	java/net/URL
    //   620: dup
    //   621: ldc_w 280
    //   624: invokespecial 281	java/net/URL:<init>	(Ljava/lang/String;)V
    //   627: invokevirtual 285	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   630: checkcast 287	java/net/HttpURLConnection
    //   633: astore_1
    //   634: aload 10
    //   636: astore_2
    //   637: aload 8
    //   639: astore 6
    //   641: aload 11
    //   643: astore 4
    //   645: aload 9
    //   647: astore 7
    //   649: aload_1
    //   650: iconst_1
    //   651: invokevirtual 291	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   654: aload 10
    //   656: astore_2
    //   657: aload 8
    //   659: astore 6
    //   661: aload 11
    //   663: astore 4
    //   665: aload 9
    //   667: astore 7
    //   669: aload_1
    //   670: sipush 3000
    //   673: invokevirtual 295	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   676: aload 10
    //   678: astore_2
    //   679: aload 8
    //   681: astore 6
    //   683: aload 11
    //   685: astore 4
    //   687: aload 9
    //   689: astore 7
    //   691: aload_1
    //   692: invokevirtual 298	java/net/HttpURLConnection:connect	()V
    //   695: aload 10
    //   697: astore_2
    //   698: aload 8
    //   700: astore 6
    //   702: aload 11
    //   704: astore 4
    //   706: aload 9
    //   708: astore 7
    //   710: aload_1
    //   711: invokevirtual 302	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   714: astore_1
    //   715: aload_1
    //   716: astore_2
    //   717: aload 8
    //   719: astore 6
    //   721: aload_1
    //   722: astore 4
    //   724: aload 9
    //   726: astore 7
    //   728: new 304	java/io/FileOutputStream
    //   731: dup
    //   732: aload 13
    //   734: invokespecial 307	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   737: astore 5
    //   739: sipush 1024
    //   742: newarray <illegal type>
    //   744: astore_2
    //   745: aload_1
    //   746: aload_2
    //   747: invokevirtual 313	java/io/InputStream:read	([B)I
    //   750: istore_3
    //   751: iload_3
    //   752: ifle +44 -> 796
    //   755: aload 5
    //   757: aload_2
    //   758: iconst_0
    //   759: iload_3
    //   760: invokevirtual 319	java/io/OutputStream:write	([BII)V
    //   763: goto -18 -> 745
    //   766: astore_2
    //   767: aload 5
    //   769: astore 7
    //   771: aload_1
    //   772: ifnull +7 -> 779
    //   775: aload_1
    //   776: invokevirtual 322	java/io/InputStream:close	()V
    //   779: aload 7
    //   781: ifnull +8 -> 789
    //   784: aload 7
    //   786: invokevirtual 323	java/io/OutputStream:close	()V
    //   789: aload_0
    //   790: aload 14
    //   792: invokevirtual 327	com/millennialmedia/android/MMAdView:addView	(Landroid/view/View;)V
    //   795: return
    //   796: aload_1
    //   797: astore_2
    //   798: aload 5
    //   800: astore 6
    //   802: aload_1
    //   803: astore 4
    //   805: aload 5
    //   807: astore 7
    //   809: aload 13
    //   811: invokevirtual 330	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   814: invokestatic 336	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   817: astore 8
    //   819: aload 14
    //   821: ifnull +28 -> 849
    //   824: aload 8
    //   826: ifnull +23 -> 849
    //   829: aload_1
    //   830: astore_2
    //   831: aload 5
    //   833: astore 6
    //   835: aload_1
    //   836: astore 4
    //   838: aload 5
    //   840: astore 7
    //   842: aload 14
    //   844: aload 8
    //   846: invokevirtual 340	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   849: aload_1
    //   850: ifnull +7 -> 857
    //   853: aload_1
    //   854: invokevirtual 322	java/io/InputStream:close	()V
    //   857: aload 5
    //   859: ifnull -70 -> 789
    //   862: aload 5
    //   864: invokevirtual 323	java/io/OutputStream:close	()V
    //   867: goto -78 -> 789
    //   870: astore_1
    //   871: goto -82 -> 789
    //   874: astore_1
    //   875: aload_2
    //   876: ifnull +7 -> 883
    //   879: aload_2
    //   880: invokevirtual 322	java/io/InputStream:close	()V
    //   883: aload 6
    //   885: ifnull +8 -> 893
    //   888: aload 6
    //   890: invokevirtual 323	java/io/OutputStream:close	()V
    //   893: aload_1
    //   894: athrow
    //   895: astore_2
    //   896: goto -3 -> 893
    //   899: astore 4
    //   901: aload_1
    //   902: astore_2
    //   903: aload 5
    //   905: astore 6
    //   907: aload 4
    //   909: astore_1
    //   910: goto -35 -> 875
    //   913: astore_1
    //   914: goto -125 -> 789
    //   917: astore_1
    //   918: aload 4
    //   920: astore_1
    //   921: goto -150 -> 771
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	924	0	this	MMAdView
    //   0	924	1	paramContext	Context
    //   0	924	2	paramAttributeSet	AttributeSet
    //   0	924	3	paramInt	int
    //   445	392	4	localObject1	Object
    //   899	20	4	localObject2	Object
    //   434	470	5	localFileOutputStream	java.io.FileOutputStream
    //   441	465	6	localObject3	Object
    //   449	392	7	localObject4	Object
    //   428	417	8	localBitmap	Bitmap
    //   431	294	9	localObject5	Object
    //   419	277	10	localObject6	Object
    //   422	281	11	localObject7	Object
    //   425	152	12	localObject8	Object
    //   456	354	13	localObject9	Object
    //   416	427	14	localImageView	ImageView
    // Exception table:
    //   from	to	target	type
    //   739	745	766	java/lang/Exception
    //   745	751	766	java/lang/Exception
    //   755	763	766	java/lang/Exception
    //   853	857	870	java/lang/Exception
    //   862	867	870	java/lang/Exception
    //   451	458	874	finally
    //   484	495	874	finally
    //   510	532	874	finally
    //   547	576	874	finally
    //   594	602	874	finally
    //   617	634	874	finally
    //   649	654	874	finally
    //   669	676	874	finally
    //   691	695	874	finally
    //   710	715	874	finally
    //   728	739	874	finally
    //   809	819	874	finally
    //   842	849	874	finally
    //   879	883	895	java/lang/Exception
    //   888	893	895	java/lang/Exception
    //   739	745	899	finally
    //   745	751	899	finally
    //   755	763	899	finally
    //   775	779	913	java/lang/Exception
    //   784	789	913	java/lang/Exception
    //   451	458	917	java/lang/Exception
    //   484	495	917	java/lang/Exception
    //   510	532	917	java/lang/Exception
    //   547	576	917	java/lang/Exception
    //   594	602	917	java/lang/Exception
    //   617	634	917	java/lang/Exception
    //   649	654	917	java/lang/Exception
    //   669	676	917	java/lang/Exception
    //   691	695	917	java/lang/Exception
    //   710	715	917	java/lang/Exception
    //   728	739	917	java/lang/Exception
    //   809	819	917	java/lang/Exception
    //   842	849	917	java/lang/Exception
  }
  
  public MMAdView(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    super(paramContext);
    MMAdViewSDK.Log.d("Creating new MMAdView.");
    this.apid = paramString1;
    this.adType = paramString2;
    this.refreshInterval = paramInt;
    init(paramContext);
  }
  
  public MMAdView(Context paramContext, String paramString1, String paramString2, int paramInt, Hashtable<String, String> paramHashtable)
  {
    super(paramContext);
    MMAdViewSDK.Log.d("Creating new MMAdView.");
    this.apid = paramString1;
    this.adType = paramString2;
    this.refreshInterval = paramInt;
    setMetaValues(paramHashtable);
    init(paramContext);
  }
  
  public MMAdView(Context paramContext, String paramString1, String paramString2, int paramInt, Hashtable<String, String> paramHashtable, boolean paramBoolean)
  {
    super(paramContext);
    MMAdViewSDK.Log.d("Creating new MMAdView.");
    this.apid = paramString1;
    this.adType = paramString2;
    this.refreshInterval = paramInt;
    setMetaValues(paramHashtable);
    init(paramContext);
  }
  
  public MMAdView(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, Hashtable<String, String> paramHashtable)
  {
    super(paramContext);
    MMAdViewSDK.Log.d("Creating new MMAdView.");
    this.apid = paramString1;
    this.adType = paramString2;
    this.refreshInterval = -1;
    setMetaValues(paramHashtable);
    init(paramContext);
  }
  
  private static void checkActivity(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      localPackageManager.getActivityInfo(new ComponentName(paramContext, "com.millennialmedia.android.MMActivity"), 128);
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException2)
    {
      for (;;)
      {
        try
        {
          localPackageManager.getActivityInfo(new ComponentName(paramContext, "com.millennialmedia.android.VideoPlayer"), 128);
          return;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException1)
        {
          AlertDialog localAlertDialog;
          MMAdViewSDK.Log.e("Activity VideoPlayer not declared in AndroidManifest.xml");
          localNameNotFoundException1.printStackTrace();
          paramContext = new AlertDialog.Builder(paramContext).create();
          paramContext.setTitle("Whoops!");
          paramContext.setMessage("The developer has forgot to declare the VideoPlayer in the manifest file. Please reach out to the developer to remove this error.");
          paramContext.setButton(-3, "OK", new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              this.val$activityDialog.cancel();
            }
          });
          paramContext.show();
        }
        localNameNotFoundException2 = localNameNotFoundException2;
        MMAdViewSDK.Log.e("Activity MMActivity not declared in AndroidManifest.xml");
        localNameNotFoundException2.printStackTrace();
        localAlertDialog = new AlertDialog.Builder(paramContext).create();
        localAlertDialog.setTitle("Whoops!");
        localAlertDialog.setMessage("The developer has forgot to declare the MMActivity in the manifest file. Please reach out to the developer to remove this error.");
        localAlertDialog.setButton(-3, "OK", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            this.val$activityDialog.cancel();
          }
        });
        localAlertDialog.show();
      }
    }
  }
  
  private static void checkPermissions(Context paramContext)
  {
    AlertDialog localAlertDialog;
    if (paramContext.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == -1)
    {
      localAlertDialog = new AlertDialog.Builder(paramContext).create();
      localAlertDialog.setTitle("Whoops!");
      localAlertDialog.setMessage("The developer has forgot to declare the READ_PHONE_STATE permission in the manifest file. Please reach out to the developer to remove this error.");
      localAlertDialog.setButton(-3, "OK", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          this.val$phoneStateDialog.cancel();
        }
      });
      localAlertDialog.show();
    }
    if (paramContext.checkCallingOrSelfPermission("android.permission.INTERNET") == -1)
    {
      localAlertDialog = new AlertDialog.Builder(paramContext).create();
      localAlertDialog.setTitle("Whoops!");
      localAlertDialog.setMessage("The developer has forgot to declare the INTERNET permission in the manifest file. Please reach out to the developer to remove this error.");
      localAlertDialog.setButton(-3, "OK", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          this.val$internetDialog.cancel();
        }
      });
      localAlertDialog.show();
    }
    if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == -1)
    {
      paramContext = new AlertDialog.Builder(paramContext).create();
      paramContext.setTitle("Whoops!");
      paramContext.setMessage("The developer has forgot to declare the ACCESS_NETWORK_STATE permission in the manifest file. Please reach out to the developer to remove this error.");
      paramContext.setButton(-3, "OK", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          this.val$networkStateDialog.cancel();
        }
      });
      paramContext.show();
    }
  }
  
  static String[] getAdTypes()
  {
    return new String[] { "MMBannerAdTop", "MMBannerAdBottom", "MMBannerAdRectangle", "MMFullScreenAdLaunch", "MMFullScreenAdTransition" };
  }
  
  private void init(Context paramContext)
  {
    for (;;)
    {
      try
      {
        MMAdViewSDK.Log.d("Initializing MMAdView.");
      }
      catch (Exception localException)
      {
        MMAdViewSDK.Log.e("There was an exception initializing the MMAdView. %s", new Object[] { localException.getMessage() });
        localException.printStackTrace();
        continue;
        HandShake.apid = this.apid;
        continue;
      }
      try
      {
        this.adViewId = new Long(nextAdViewId);
        nextAdViewId += 1L;
        MMAdViewSDK.Log.v("Assigning MMAdView internal id: %d", new Object[] { this.adViewId });
        checkPermissions(paramContext);
        checkActivity(paramContext);
        setBackgroundColor(0);
        setOnClickListener(this);
        setFocusable(true);
        setDescendantFocusability(393216);
        if (this.apid == null)
        {
          MMAdViewSDK.Log.e("MMAdView initialized without an apid. New ad requests will be disabled.");
          HandShake.apid = "28911";
          HandShake.sharedHandShake(paramContext).overrideAdRefresh(this);
          if (((this.adType == "MMFullScreenAdTransition") || (this.adType == "MMFullScreenAdLaunch")) && (this.refreshInterval != -1))
          {
            MMAdViewSDK.Log.w("Turning off interstitial refresh interval.");
            this.refreshInterval = -1;
          }
          this.imageView = new ImageView(paramContext);
          this.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
          this.imageView.setVisibility(8);
          addView(this.imageView, new FrameLayout.LayoutParams(-1, -1));
          setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
          this.gestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener()
          {
            public boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
            {
              boolean bool2 = false;
              boolean bool1 = bool2;
              if (Math.abs((int)(paramAnonymousMotionEvent2.getX() - paramAnonymousMotionEvent1.getX())) > 200)
              {
                bool1 = bool2;
                if (Math.abs(paramAnonymousFloat1) > Math.abs(paramAnonymousFloat2))
                {
                  if (paramAnonymousFloat1 <= 0.0F) {
                    break label82;
                  }
                  if (MMAdViewSDK.logLevel != 0) {
                    break label70;
                  }
                  MMAdViewSDK.Log.i("Enabling debug and verbose logging.");
                  MMAdViewSDK.logLevel = 2;
                }
              }
              for (;;)
              {
                bool1 = true;
                return bool1;
                label70:
                MMAdViewSDK.Log.i("Disabling debug and verbose logging.");
                MMAdViewSDK.logLevel = 0;
                continue;
                label82:
                MMAdView.this.printDiagnostics();
              }
            }
          });
          if (!appInit)
          {
            MMAdViewSDK.Log.d("********** Millennial Device Id *****************");
            MMAdViewSDK.Log.d(MMAdViewSDK.getHdid(paramContext));
            MMAdViewSDK.Log.d("Use the above identifier to register this device and receive test ads. Test devices can be registered and administered through your account at http://mmedia.com.");
            MMAdViewSDK.Log.d("*************************************************");
            AdCache.cleanUpExpiredAds(paramContext);
            MMFileManager.cleanupCache(paramContext, false);
            appInit = true;
          }
          return;
        }
      }
      finally {}
    }
  }
  
  private void printDiagnostics()
  {
    Context localContext = getContext();
    MMAdViewSDK.Log.i("MMAdView ID: %d", new Object[] { Integer.valueOf(getId()) });
    MMAdViewSDK.Log.i("APID: %s", new Object[] { this.apid });
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      str = "";
      MMAdViewSDK.Log.i("SD card is %savailable.", new Object[] { str });
      if (localContext != null)
      {
        MMAdViewSDK.Log.i("Package: %s", new Object[] { localContext.getPackageName() });
        MMAdViewSDK.Log.i("HDID: %s", new Object[] { MMAdViewSDK.getHdid(localContext) });
        MMAdViewSDK.Log.i("Permissions:");
        if (localContext.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") != -1) {
          break label346;
        }
        str = "not ";
        label131:
        MMAdViewSDK.Log.i("android.permission.READ_PHONE_STATE is %spresent", new Object[] { str });
        if (localContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != -1) {
          break label353;
        }
        str = "not ";
        label160:
        MMAdViewSDK.Log.i("android.permission.ACCESS_NETWORK_STATE is %spresent", new Object[] { str });
        if (localContext.checkCallingOrSelfPermission("android.permission.INTERNET") != -1) {
          break label360;
        }
        str = "not ";
        label189:
        MMAdViewSDK.Log.i("android.permission.INTERNET is %spresent", new Object[] { str });
        if (localContext.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != -1) {
          break label367;
        }
        str = "not ";
        label218:
        MMAdViewSDK.Log.i("android.permission.WRITE_EXTERNAL_STORAGE is %spresent", new Object[] { str });
        if (localContext.checkCallingOrSelfPermission("android.permission.VIBRATE") != -1) {
          break label374;
        }
        str = "not ";
        label247:
        MMAdViewSDK.Log.i("android.permission.VIBRATE is %spresent", new Object[] { str });
        if (localContext.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != -1) {
          break label381;
        }
        str = "not ";
        label276:
        MMAdViewSDK.Log.i("android.permission.ACCESS_COARSE_LOCATION is %spresent", new Object[] { str });
        if (localContext.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") != -1) {
          break label388;
        }
      }
    }
    label346:
    label353:
    label360:
    label367:
    label374:
    label381:
    label388:
    for (String str = "not ";; str = "")
    {
      MMAdViewSDK.Log.i("android.permission.ACCESS_FINE_LOCATION is %spresent", new Object[] { str });
      MMAdViewSDK.Log.i("Cached Ads:");
      AdCache.iterateCachedAds(localContext, 2, new AdCache.Iterator()
      {
        boolean callback(CachedAd paramAnonymousCachedAd)
        {
          String str2 = paramAnonymousCachedAd.getTypeString();
          String str3 = paramAnonymousCachedAd.id;
          String str1;
          if (paramAnonymousCachedAd.isOnDisk(MMAdView.this.getContext()))
          {
            str1 = "";
            if (!paramAnonymousCachedAd.isExpired()) {
              break label72;
            }
          }
          label72:
          for (paramAnonymousCachedAd = "";; paramAnonymousCachedAd = "not ")
          {
            MMAdViewSDK.Log.i("%s %s is %son disk. Is %sexpired.", new Object[] { str2, str3, str1, paramAnonymousCachedAd });
            return true;
            str1 = "not ";
            break;
          }
        }
      });
      return;
      str = "not ";
      break;
      str = "";
      break label131;
      str = "";
      break label160;
      str = "";
      break label189;
      str = "";
      break label218;
      str = "";
      break label247;
      str = "";
      break label276;
    }
  }
  
  public static void startConversionTrackerWithGoalId(Context paramContext, String paramString)
  {
    checkPermissions(paramContext);
    MMConversionTracker.trackConversion(paramContext, paramString);
  }
  
  void animateTransition()
  {
    if (this.imageView.getDrawable() != null) {
      MMAdViewSDK.runOnUiThread(new Runnable()
      {
        public void run()
        {
          int j = MMAdView.this.transitionType;
          int i = j;
          if (j == 4) {
            i = new Random().nextInt(4);
          }
          Object localObject;
          switch (i)
          {
          default: 
            localObject = new AlphaAnimation(1.0F, 0.0F);
          }
          for (;;)
          {
            ((Animation)localObject).setDuration(1000L);
            ((Animation)localObject).setAnimationListener(MMAdView.this);
            ((Animation)localObject).setFillEnabled(true);
            ((Animation)localObject).setFillBefore(true);
            ((Animation)localObject).setFillAfter(true);
            MMAdView.this.imageView.startAnimation((Animation)localObject);
            return;
            localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, -MMAdView.this.getHeight());
            continue;
            localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, MMAdView.this.getHeight());
          }
        }
      });
    }
  }
  
  public void callForAd()
  {
    Request localRequest = new Request(this.apid, null, false);
    if (!canRequestAd())
    {
      MMAdViewSDK.Event.requestFailed(getContext(), this, localRequest, new MMError(16));
      return;
    }
    requestAd(localRequest);
  }
  
  boolean canRequestAd()
  {
    if (MMAdViewSDK.disableAdMinRefresh) {
      return true;
    }
    if ((System.currentTimeMillis() - this.lastAdRequest) / 1000L >= 15L)
    {
      this.lastAdRequest = System.currentTimeMillis();
      return true;
    }
    int i = (int)((System.currentTimeMillis() - this.lastAdRequest) / 1000L);
    MMAdViewSDK.Log.d("Cannot request ad. Last ad request was %d seconds ago. Next ad can be requested in %d seconds.", new Object[] { Integer.valueOf(i), Integer.valueOf(15 - i) });
    return false;
  }
  
  public boolean check()
  {
    if (!MMAdViewSDK.isUiThread()) {
      MMAdViewSDK.Log.e("Only the main thread can access an MMAdView.");
    }
    while (checkInternal() != 0) {
      return false;
    }
    return true;
  }
  
  int checkInternal()
  {
    int i = 100;
    try
    {
      MMAdViewController.assignAdViewController(this);
      if (this.controller != null) {
        i = this.controller.check(this);
      }
      return i;
    }
    catch (Exception localException)
    {
      MMAdViewSDK.Log.e("There was an exception checking for a cached ad. %s", new Object[] { localException.getMessage() });
      localException.printStackTrace();
    }
    return 100;
  }
  
  public boolean display()
  {
    if (!MMAdViewSDK.isUiThread()) {
      MMAdViewSDK.Log.e("Only the main thread can access an MMAdView.");
    }
    while (displayInternal() != 0) {
      return false;
    }
    return true;
  }
  
  int displayInternal()
  {
    int i = 100;
    try
    {
      MMAdViewController.assignAdViewController(this);
      if (this.controller != null) {
        i = this.controller.display(this);
      }
      return i;
    }
    catch (Exception localException)
    {
      MMAdViewSDK.Log.e("There was an exception displaying a cached ad. %s", new Object[] { localException.getMessage() });
      localException.printStackTrace();
    }
    return 100;
  }
  
  public void fetch()
  {
    if (check())
    {
      MMAdViewSDK.Log.d("Ad already fetched and ready for display...");
      if (this.listener != null) {}
      try
      {
        this.listener.MMAdFailed(this);
        return;
      }
      catch (Exception localException)
      {
        MMAdViewSDK.Log.w("Exception raised in your MMAdListener: " + localException.getMessage());
        return;
      }
    }
    Request localRequest = new Request(this.apid, null, true);
    if (!canRequestAd())
    {
      MMAdViewSDK.Event.requestFailed(getContext(), this, localRequest, new MMError(16));
      return;
    }
    MMAdViewSDK.Log.d("Fetching new ad...");
    requestAd(localRequest);
  }
  
  protected void finalize()
    throws Throwable
  {
    if ((getId() == -1) || (isInterstitial())) {
      MMAdViewController.removeAdViewController(this, true);
    }
  }
  
  String getCachedName()
  {
    if ((this.adType != null) && (this.apid != null)) {
      return this.adType + "_" + this.apid;
    }
    return null;
  }
  
  public MMAdListener getListener()
  {
    return this.listener;
  }
  
  boolean isInterstitial()
  {
    return (this.adType.equals("MMFullScreenAdTransition")) || (this.adType.equals("MMFullScreenAdLaunch"));
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.imageView.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (!isInEditMode())
    {
      MMAdViewSDK.Log.d("onAttachedToWindow");
      MMAdViewController.assignAdViewController(this);
      if (this.deferedRequest != null) {
        requestAd(this.deferedRequest);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    onTouchEvent(MotionEvent.obtain(0L, System.currentTimeMillis(), 1, 0.0F, 0.0F, 0));
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    MMAdViewSDK.Log.d("onDetachedFromWindow");
    MMAdViewController.removeAdViewController(this, false);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.width == null) {
      this.width = Integer.toString((int)(getWidth() / getContext().getResources().getDisplayMetrics().density));
    }
    if (this.height == null) {
      this.height = Integer.toString((int)(getHeight() / getContext().getResources().getDisplayMetrics().density));
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (Bundle)paramParcelable;
    MMAdViewSDK.Log.d("onRestoreInstanceState");
    this.adViewId = new Long(paramParcelable.getLong("MMAdView"));
    super.onRestoreInstanceState(paramParcelable.getParcelable("super"));
  }
  
  protected Parcelable onSaveInstanceState()
  {
    MMAdViewSDK.Log.d("onSaveInstanceState");
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("super", super.onSaveInstanceState());
    localBundle.putLong("MMAdView", this.adViewId.longValue());
    return localBundle;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.gestureDetector.onTouchEvent(paramMotionEvent)) {}
    do
    {
      do
      {
        return true;
      } while ((this.controller == null) || (!isClickable()));
      if (paramMotionEvent.getAction() == 1)
      {
        MMAdViewSDK.Log.v("Ad clicked: action=%d x=%f y=%f", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()) });
        if (this.controller.nextUrl != null)
        {
          if ((this.controller.nextUrl.startsWith("javascript")) || (this.controller.nextUrl.startsWith("mmsdk")))
          {
            this.controller.loadUrl(this.controller.nextUrl);
            return true;
          }
          if ((this.controller.nextUrl.startsWith("mmvideo")) || (this.controller.nextUrl.endsWith("content.once"))) {
            this.controller.settings.shouldLaunchToOverlay = true;
          }
          if (this.controller.nextUrl.startsWith("https")) {
            this.controller.settings.shouldLaunchToOverlay = false;
          }
        }
        if (this.controller.settings.shouldLaunchToOverlay == true)
        {
          if (this.listener != null) {}
          try
          {
            this.listener.MMAdClickedToOverlay(this);
            if (this.controller.nextUrl != null)
            {
              this.controller.handleClick(this.controller.nextUrl);
              return true;
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              MMAdViewSDK.Log.w("Exception raised in your MMAdListener: ", new Object[] { localException });
            }
            this.controller.touchWebView(paramMotionEvent);
            return true;
          }
        }
        if (this.controller.nextUrl != null)
        {
          MMAdViewSDK.Log.d("Ad clicked, launching new browser");
          paramMotionEvent = getContext();
          if (paramMotionEvent == null)
          {
            MMAdViewSDK.Log.e("The reference to the ad view was broken.");
            return true;
          }
          try
          {
            Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(this.controller.nextUrl));
            localIntent.setFlags(603979776);
            if (!(paramMotionEvent instanceof Activity)) {
              localIntent.addFlags(268435456);
            }
            if ((this.controller.nextUrl.startsWith("http")) || (this.controller.nextUrl.startsWith("https"))) {
              MMAdViewSDK.Event.intentStarted(paramMotionEvent, null, "browser");
            }
            paramMotionEvent.startActivity(localIntent);
            return true;
          }
          catch (ActivityNotFoundException paramMotionEvent)
          {
            MMAdViewSDK.Log.d("Could not find activity for: %s", new Object[] { this.controller.nextUrl });
            return true;
          }
        }
        MMAdViewSDK.Log.e("No ad returned, no new browser launched");
        return true;
      }
    } while (paramMotionEvent.getAction() == 2);
    this.controller.touchWebView(paramMotionEvent);
    return true;
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    boolean bool = true;
    if (this.controller != null)
    {
      if (paramInt == 0) {
        this.controller.resumeTimer(false);
      }
    }
    else {
      if (paramInt != 0) {
        break label54;
      }
    }
    for (;;)
    {
      MMAdViewSDK.Log.d("Window Visibility Changed. Window is visible?: %b", new Object[] { Boolean.valueOf(bool) });
      return;
      this.controller.pauseTimer(false);
      break;
      label54:
      bool = false;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (this.controller != null)
    {
      if (!paramBoolean) {
        break label134;
      }
      this.controller.resumeTimer(false);
      this.controller.settings.state = "default";
      this.controller.loadUrl("javascript:MMSDK.mraid.stateChange('default')");
      this.controller.loadUrl("javascript:MMSDK.mraid.viewableChange(true)");
      this.controller.loadUrl("javascript:MMSDK.mraid.ready()");
    }
    for (;;)
    {
      MMAdViewSDK.Log.d("Window Focus Changed. Window in focus?: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      if ((!paramBoolean) && ((getContext() instanceof Activity)))
      {
        Activity localActivity = (Activity)getContext();
        if ((localActivity == null) || (localActivity.isFinishing())) {
          MMAdViewController.removeAdViewController(this, true);
        }
      }
      MMMedia.Audio.sharedAudio(getContext()).stop();
      return;
      label134:
      this.controller.pauseTimer(false);
      this.controller.settings.state = "hidden";
      this.controller.loadUrl("javascript:MMSDK.mraid.stateChange('hidden')");
      this.controller.loadUrl("javascript:MMSDK.mraid.viewableChange(false)");
    }
  }
  
  public void pause()
  {
    if (this.controller != null) {
      this.controller.pauseTimer(true);
    }
  }
  
  void prepareTransition(Bitmap paramBitmap)
  {
    this.imageView.setImageBitmap(paramBitmap);
    this.imageView.setVisibility(0);
    this.imageView.bringToFront();
  }
  
  void requestAd(Request paramRequest)
  {
    if (!MMAdViewSDK.isUiThread())
    {
      MMAdViewSDK.Log.e("Only the main thread can access an MMAdView.");
      MMAdViewSDK.Event.requestFailed(getContext(), this, paramRequest, new MMError(3));
      return;
    }
    if (HandShake.sharedHandShake(getContext()).kill)
    {
      MMAdViewSDK.Log.i("The server is no longer allowing ads.");
      MMAdViewSDK.Event.requestFailed(getContext(), this, paramRequest, new MMError(16));
      return;
    }
    try
    {
      MMAdViewSDK.Log.d("callForAd");
      if ((getWindowToken() == null) && (this.xmlLayout))
      {
        this.deferedRequest = paramRequest;
        return;
      }
    }
    catch (Exception paramRequest)
    {
      MMAdViewSDK.Log.e("There was an exception with the ad request. %s", new Object[] { paramRequest.getMessage() });
      paramRequest.printStackTrace();
      return;
    }
    if (this.refreshInterval < 0)
    {
      MMAdViewController.assignAdViewController(this);
      if (this.controller != null)
      {
        if (!paramRequest.fetch) {
          break label156;
        }
        this.controller.fetch(paramRequest);
      }
    }
    for (;;)
    {
      this.deferedRequest = null;
      return;
      label156:
      this.controller.requestAd(paramRequest);
    }
  }
  
  public void resume()
  {
    if (this.controller != null) {
      this.controller.resumeTimer(true);
    }
  }
  
  public void setAcid(String paramString)
  {
    this.acid = paramString;
  }
  
  public void setAdType(String paramString)
  {
    this.adType = paramString;
  }
  
  public void setAge(String paramString)
  {
    if (MMAdViewSDK.demographic != null) {
      MMAdViewSDK.demographic.put("age", paramString);
    }
  }
  
  public void setApid(String paramString)
  {
    this.apid = paramString;
  }
  
  public void setEducation(String paramString)
  {
    if (MMAdViewSDK.demographic != null) {
      MMAdViewSDK.demographic.education = paramString;
    }
  }
  
  public void setEthnicity(String paramString)
  {
    if (MMAdViewSDK.demographic != null) {
      MMAdViewSDK.demographic.ethnicity = paramString;
    }
  }
  
  public void setGender(String paramString)
  {
    if (MMAdViewSDK.demographic != null) {
      MMAdViewSDK.demographic.gender = paramString;
    }
  }
  
  public void setHeight(String paramString)
  {
    this.height = paramString;
  }
  
  public void setIgnoresDensityScaling(boolean paramBoolean)
  {
    try
    {
      this.ignoreDensityScaling = paramBoolean;
      return;
    }
    finally {}
  }
  
  public void setIncome(String paramString)
  {
    if (MMAdViewSDK.demographic != null) {
      MMAdViewSDK.demographic.put("income", paramString);
    }
  }
  
  public void setListener(MMAdListener paramMMAdListener)
  {
    try
    {
      this.listener = paramMMAdListener;
      return;
    }
    finally {}
  }
  
  public void setMarital(String paramString)
  {
    if (MMAdViewSDK.demographic != null) {
      MMAdViewSDK.demographic.marital = paramString;
    }
  }
  
  public void setMetaValues(Hashtable<String, String> paramHashtable)
  {
    if (paramHashtable == null) {}
    for (;;)
    {
      return;
      if (paramHashtable.containsKey("mmacid")) {
        this.acid = ((String)paramHashtable.get("mmacid"));
      }
      if (paramHashtable.containsKey("mxsdk")) {
        this.mxsdk = ((String)paramHashtable.get("mxsdk"));
      }
      if (paramHashtable.containsKey("height")) {
        this.height = ((String)paramHashtable.get("height"));
      }
      if (paramHashtable.containsKey("width")) {
        this.width = ((String)paramHashtable.get("width"));
      }
      if (MMAdViewSDK.demographic != null)
      {
        paramHashtable = paramHashtable.entrySet().iterator();
        while (paramHashtable.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramHashtable.next();
          MMAdViewSDK.demographic.put((String)localEntry.getKey(), (String)localEntry.getValue());
        }
      }
    }
  }
  
  public void setMxsdk(String paramString)
  {
    this.mxsdk = paramString;
  }
  
  public void setOrientation(String paramString)
  {
    if (MMAdViewSDK.demographic != null) {
      MMAdViewSDK.demographic.orientation = paramString;
    }
  }
  
  public void setPolitics(String paramString)
  {
    if (MMAdViewSDK.demographic != null) {
      MMAdViewSDK.demographic.put("politics", paramString);
    }
  }
  
  public void setTransitionType(int paramInt)
  {
    this.transitionType = paramInt;
  }
  
  public void setVendor(String paramString)
  {
    if (MMAdViewSDK.demographic != null) {
      MMAdViewSDK.demographic.put("vendor", paramString);
    }
  }
  
  public void setWidth(String paramString)
  {
    this.width = paramString;
  }
  
  public void setZip(String paramString)
  {
    if (MMAdViewSDK.demographic != null) {
      MMAdViewSDK.demographic.put("zip", paramString);
    }
  }
  
  public void startConversionTrackerWithGoalId(String paramString)
  {
    MMConversionTracker.trackConversion(getContext(), paramString);
  }
  
  public void updateUserLocation(Location paramLocation)
  {
    if (paramLocation == null) {
      return;
    }
    MMAdViewSDK.location = paramLocation;
  }
  
  public static abstract interface MMAdListener
  {
    public abstract void MMAdCachingCompleted(MMAdView paramMMAdView, boolean paramBoolean);
    
    public abstract void MMAdClickedToOverlay(MMAdView paramMMAdView);
    
    public abstract void MMAdFailed(MMAdView paramMMAdView);
    
    public abstract void MMAdOverlayLaunched(MMAdView paramMMAdView);
    
    public abstract void MMAdRequestIsCaching(MMAdView paramMMAdView);
    
    public abstract void MMAdReturned(MMAdView paramMMAdView);
  }
  
  static class Request
  {
    String apid;
    boolean fetch;
    MMAdView.RequestListener requestListener;
    
    Request(String paramString, MMAdView.RequestListener paramRequestListener, boolean paramBoolean)
    {
      this.apid = paramString;
      this.requestListener = paramRequestListener;
      this.fetch = paramBoolean;
    }
  }
  
  public static class RequestListener
  {
    public void requestFailed(MMAdView paramMMAdView, MMError paramMMError)
    {
      MMAdViewSDK.Log.d("Ad request failed with error: %d %s.", new Object[] { Integer.valueOf(paramMMError.getCode()), paramMMError.getMessage() });
    }
    
    public void requestSucceeded(MMAdView paramMMAdView)
    {
      MMAdViewSDK.Log.d("Ad request succeeded.");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/millennialmedia/android/MMAdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */