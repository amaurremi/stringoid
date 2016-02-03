package com.mobisystems.mobiscanner.common;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.media.ExifInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.b.a;
import com.google.api.a.a.a.b;
import com.google.api.a.a.a.b.a;
import com.google.api.client.http.i;
import com.google.api.client.http.q;
import com.google.api.client.http.r;
import com.mobisystems.mobiscanner.controller.AutoCropService;
import com.mobisystems.mobiscanner.controller.DocumentListActivity;
import com.mobisystems.mobiscanner.controller.MyApplication;
import com.mobisystems.mobiscanner.controller.MyApplication.TrackerName;
import com.mobisystems.mobiscanner.controller.OCRService;
import com.mobisystems.mobiscanner.controller.PageGridActivity;
import com.mobisystems.mobiscanner.controller.ac;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class d
{
  private static final c apd = new c();
  private static Random aww = new Random();
  static Random awx = new Random();
  
  public static boolean DA()
  {
    return Build.VERSION.SDK_INT >= 17;
  }
  
  public static boolean DB()
  {
    return Build.VERSION.SDK_INT >= 18;
  }
  
  public static boolean DC()
  {
    return Build.VERSION.SDK_INT >= 19;
  }
  
  public static boolean DD()
  {
    return Build.MANUFACTURER.contains("Amazon");
  }
  
  public static boolean DE()
  {
    String str = Build.MODEL;
    return (str.equals("NOOKcolor")) || (str.equals("BNRV200")) || (str.startsWith("BNTV"));
  }
  
  public static boolean DF()
  {
    return (Build.MODEL.equals("Nexus 7")) && (DB());
  }
  
  @TargetApi(18)
  public static Intent DG()
  {
    Intent localIntent = new Intent();
    localIntent.setType("image/*");
    localIntent.setAction("android.intent.action.GET_CONTENT");
    if (DB()) {
      localIntent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
    }
    return localIntent;
  }
  
  public static String DH()
  {
    int j = awx.nextInt(9) + 1;
    StringBuilder localStringBuilder = new StringBuilder(j);
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(awx.nextInt("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".length())));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static boolean DI()
  {
    return Build.MANUFACTURER.toLowerCase().contains("sony");
  }
  
  private static File Dt()
  {
    return Environment.getExternalStorageDirectory();
  }
  
  @TargetApi(9)
  public static int Du()
  {
    if (Dv())
    {
      int m = Camera.getNumberOfCameras();
      int i = 0;
      int j = -1;
      if (i < m)
      {
        Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i, localCameraInfo);
        if (localCameraInfo.facing != 0) {}
      }
      for (;;)
      {
        if (i > -1) {
          j = i;
        }
        return j;
        int k = j;
        if (j == -1) {
          k = i;
        }
        i += 1;
        j = k;
        break;
        i = -1;
      }
    }
    return -1;
  }
  
  public static boolean Dv()
  {
    return Build.VERSION.SDK_INT >= 9;
  }
  
  public static boolean Dw()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  public static boolean Dx()
  {
    return Build.VERSION.SDK_INT >= 12;
  }
  
  public static boolean Dy()
  {
    return Build.VERSION.SDK_INT >= 14;
  }
  
  public static boolean Dz()
  {
    return Build.VERSION.SDK_INT >= 16;
  }
  
  private static File X(Context paramContext)
  {
    return paramContext.getExternalFilesDir(null);
  }
  
  public static File Y(Context paramContext)
  {
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      paramContext = new File(X(paramContext).getPath() + File.separator + "transfer");
      paramContext.mkdirs();
    }
    while ((!paramContext.exists()) || (!paramContext.isDirectory()))
    {
      throw new IOException("Can not retrieve transfer dir");
      paramContext = paramContext.getDir("transfer", 2);
    }
    return paramContext;
  }
  
  public static File Z(Context paramContext)
  {
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      paramContext = new File(X(paramContext).getPath() + File.separator + "backup");
      paramContext.mkdirs();
    }
    while ((!paramContext.exists()) || (!paramContext.isDirectory()))
    {
      throw new IOException("Can not retrieve backup dir");
      paramContext = paramContext.getDir("backup", 2);
    }
    return paramContext;
  }
  
  public static double a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return Math.sqrt(Math.pow(paramFloat1 - paramFloat3, 2.0D) + Math.pow(paramFloat2 - paramFloat4, 2.0D));
  }
  
  public static double a(Point paramPoint1, Point paramPoint2)
  {
    return a(paramPoint1.x, paramPoint1.y, paramPoint2.x, paramPoint2.y);
  }
  
  public static Intent a(Context paramContext, com.mobisystems.mobiscanner.model.b paramb)
  {
    Intent localIntent = new Intent();
    if (paramb.getId() >= 0L)
    {
      localIntent.setAction("android.intent.action.MAIN");
      localIntent.setFlags(67108864);
      localIntent.setClass(paramContext, PageGridActivity.class);
      paramContext = new com.mobisystems.mobiscanner.controller.t();
      localIntent.putExtra("OPEN_DOCUMENT_SELECTED_DOC_ID", paramb.getId());
      localIntent.putExtra("OPEN_DOCUMENT_CURRENT_LIST_FAVORITE_RANK", 0);
      paramContext.f(localIntent);
      paramb.f(localIntent);
    }
    return localIntent;
  }
  
  public static AdView a(Context paramContext, ViewGroup paramViewGroup, AdView paramAdView, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AdView localAdView = paramAdView;
    if (paramViewGroup != null)
    {
      paramViewGroup.removeAllViews();
      if ((!am(paramContext)) || (paramBoolean1)) {
        break label126;
      }
      if ((paramAdView == null) || (paramBoolean2))
      {
        paramAdView = new AdView(paramContext);
        paramAdView.a(com.google.android.gms.ads.c.lK);
        if (!DI()) {
          break label116;
        }
        paramAdView.L("ca-app-pub-1502790013205637/6612686303");
      }
    }
    for (;;)
    {
      paramViewGroup.addView(paramAdView);
      paramAdView.a(new b.a().K(com.google.android.gms.ads.b.lC).K("60BDFF5692548A9AD995C20FE98494D6").K("5D2D75AC4DC7648B664C5C57FD30063B").kt());
      paramAdView.a(new com.google.android.gms.ads.a()
      {
        public void ba(int paramAnonymousInt)
        {
          d.DJ().dl("onAdFailedToLoad errorCode = " + paramAnonymousInt);
          super.ba(paramAnonymousInt);
        }
        
        public void ko()
        {
          d.DJ().dl("onAdClosed");
          super.ko();
        }
        
        public void kp()
        {
          d.DJ().dl("onAdLeftApplication");
          super.kp();
        }
        
        public void kq()
        {
          super.kq();
          if ((this.awz instanceof Activity)) {
            ((MyApplication)((Activity)this.awz).getApplication()).a(MyApplication.TrackerName.aDE).c(new com.google.android.gms.analytics.d.a().O("AdMob Advertisement Click").P(Build.MANUFACTURER).Q(Build.MODEL).kg());
          }
        }
      });
      localAdView = paramAdView;
      return localAdView;
      label116:
      paramAdView.L("ca-app-pub-1502790013205637/8404148306");
    }
    label126:
    a(paramContext, paramViewGroup, paramString);
    return paramAdView;
  }
  
  private static File a(Context paramContext)
  {
    return paramContext.getExternalCacheDir();
  }
  
  private static InputStream a(com.google.api.a.a.a parama, com.google.api.a.a.a.a parama1)
  {
    parama1 = (String)parama1.zb().get("text/plain");
    System.out.println("url = " + parama1);
    if ((parama1 != null) && (parama1.length() > 0)) {
      try
      {
        parama = parama.wY().f(new i(parama1)).xJ().getContent();
        return parama;
      }
      catch (IOException parama)
      {
        parama.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  public static <T> T a(ViewGroup paramViewGroup, Class<T> paramClass)
  {
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject1 = paramViewGroup.getChildAt(i);
      if (paramClass.isInstance(localObject1)) {}
      Object localObject2;
      do
      {
        return (T)localObject1;
        if (!ViewGroup.class.isInstance(localObject1)) {
          break;
        }
        localObject2 = a((ViewGroup)localObject1, paramClass);
        localObject1 = localObject2;
      } while (localObject2 != null);
      i += 1;
    }
    return null;
  }
  
  public static String a(Context paramContext, double paramDouble1, double paramDouble2)
  {
    paramContext = new Geocoder(paramContext);
    StringBuilder localStringBuilder;
    try
    {
      paramContext = paramContext.getFromLocation(paramDouble1, paramDouble2, 1);
      localStringBuilder = new StringBuilder();
      if ((paramContext != null) && (paramContext.size() > 0))
      {
        paramContext = (Address)paramContext.get(0);
        if (paramContext != null)
        {
          int j = paramContext.getMaxAddressLineIndex();
          int i = 0;
          while (i < j)
          {
            localStringBuilder.append(paramContext.getAddressLine(i));
            if (i < j - 1) {
              localStringBuilder.append(" ");
            }
            i += 1;
          }
        }
      }
    }
    catch (IOException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = null;
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    Date localDate = new Date(paramLong);
    int i = ah(paramContext);
    if (2 == i) {
      return DateFormat.format("MMM dd, yyyy", localDate).toString();
    }
    if (1 == i) {
      return DateFormat.format("MMM dd", localDate).toString();
    }
    return DateFormat.format("MMM dd", localDate).toString();
  }
  
  /* Error */
  public static String a(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_1
    //   7: ifnull +582 -> 589
    //   10: aload_1
    //   11: invokevirtual 506	android/net/Uri:getScheme	()Ljava/lang/String;
    //   14: ifnull +380 -> 394
    //   17: aload_1
    //   18: invokevirtual 506	android/net/Uri:getScheme	()Ljava/lang/String;
    //   21: ldc_w 508
    //   24: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   27: ifeq +349 -> 376
    //   30: iconst_1
    //   31: anewarray 58	java/lang/String
    //   34: astore_2
    //   35: aload_2
    //   36: iconst_0
    //   37: ldc_w 510
    //   40: aastore
    //   41: aload_0
    //   42: invokevirtual 514	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   45: aload_1
    //   46: aload_2
    //   47: aconst_null
    //   48: aconst_null
    //   49: aconst_null
    //   50: invokevirtual 520	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   53: astore_3
    //   54: aload_3
    //   55: ifnull +541 -> 596
    //   58: aload_3
    //   59: invokeinterface 525 1 0
    //   64: ifeq +527 -> 591
    //   67: aload_3
    //   68: aload_3
    //   69: aload_2
    //   70: iconst_0
    //   71: aaload
    //   72: invokeinterface 529 2 0
    //   77: invokeinterface 532 2 0
    //   82: astore_2
    //   83: aload_3
    //   84: invokeinterface 535 1 0
    //   89: aload_2
    //   90: astore_3
    //   91: aload_2
    //   92: invokestatic 540	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   95: ifeq +87 -> 182
    //   98: aload_2
    //   99: astore 4
    //   101: aload_0
    //   102: invokevirtual 514	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   105: aload_1
    //   106: invokevirtual 544	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   109: astore_1
    //   110: aload_0
    //   111: invokestatic 547	com/mobisystems/mobiscanner/common/d:af	(Landroid/content/Context;)Ljava/io/File;
    //   114: astore_3
    //   115: new 549	java/io/BufferedOutputStream
    //   118: dup
    //   119: new 551	java/io/FileOutputStream
    //   122: dup
    //   123: aload_3
    //   124: invokespecial 554	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   127: invokespecial 557	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   130: astore_0
    //   131: aload_1
    //   132: aload_0
    //   133: aconst_null
    //   134: invokestatic 560	com/mobisystems/mobiscanner/common/d:a	(Ljava/io/InputStream;Ljava/io/OutputStream;Lcom/mobisystems/mobiscanner/common/a;)V
    //   137: aload_1
    //   138: invokevirtual 563	java/io/InputStream:close	()V
    //   141: aload_0
    //   142: invokevirtual 564	java/io/BufferedOutputStream:close	()V
    //   145: aload_3
    //   146: invokevirtual 200	java/io/File:getPath	()Ljava/lang/String;
    //   149: astore_0
    //   150: iconst_0
    //   151: ifeq +14 -> 165
    //   154: aload_0
    //   155: astore 4
    //   157: new 566	java/lang/NullPointerException
    //   160: dup
    //   161: invokespecial 567	java/lang/NullPointerException:<init>	()V
    //   164: athrow
    //   165: aload_0
    //   166: astore_3
    //   167: iconst_0
    //   168: ifeq +14 -> 182
    //   171: aload_0
    //   172: astore 4
    //   174: new 566	java/lang/NullPointerException
    //   177: dup
    //   178: invokespecial 567	java/lang/NullPointerException:<init>	()V
    //   181: athrow
    //   182: aload_3
    //   183: areturn
    //   184: astore_3
    //   185: aconst_null
    //   186: astore_2
    //   187: aload_3
    //   188: invokevirtual 568	java/lang/IllegalArgumentException:printStackTrace	()V
    //   191: goto -102 -> 89
    //   194: astore_3
    //   195: aconst_null
    //   196: astore_2
    //   197: aload_3
    //   198: invokevirtual 569	java/lang/SecurityException:printStackTrace	()V
    //   201: goto -112 -> 89
    //   204: astore_1
    //   205: aload_0
    //   206: astore 4
    //   208: getstatic 28	com/mobisystems/mobiscanner/common/d:apd	Lcom/mobisystems/mobiscanner/common/c;
    //   211: ldc_w 571
    //   214: aload_1
    //   215: invokevirtual 575	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   218: goto -53 -> 165
    //   221: astore_0
    //   222: aload_0
    //   223: invokevirtual 576	java/io/FileNotFoundException:printStackTrace	()V
    //   226: aload 4
    //   228: areturn
    //   229: astore_1
    //   230: aload_0
    //   231: astore 4
    //   233: getstatic 28	com/mobisystems/mobiscanner/common/d:apd	Lcom/mobisystems/mobiscanner/common/c;
    //   236: ldc_w 578
    //   239: aload_1
    //   240: invokevirtual 575	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   243: aload_0
    //   244: areturn
    //   245: astore_3
    //   246: aconst_null
    //   247: astore_0
    //   248: aload_3
    //   249: invokevirtual 579	java/lang/Exception:printStackTrace	()V
    //   252: aload_1
    //   253: ifnull +10 -> 263
    //   256: aload_2
    //   257: astore 4
    //   259: aload_1
    //   260: invokevirtual 563	java/io/InputStream:close	()V
    //   263: aload_2
    //   264: astore_3
    //   265: aload_0
    //   266: ifnull -84 -> 182
    //   269: aload_2
    //   270: astore 4
    //   272: aload_0
    //   273: invokevirtual 564	java/io/BufferedOutputStream:close	()V
    //   276: aload_2
    //   277: areturn
    //   278: astore_0
    //   279: aload_2
    //   280: astore 4
    //   282: getstatic 28	com/mobisystems/mobiscanner/common/d:apd	Lcom/mobisystems/mobiscanner/common/c;
    //   285: ldc_w 578
    //   288: aload_0
    //   289: invokevirtual 575	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   292: aload_2
    //   293: areturn
    //   294: astore_1
    //   295: aload_2
    //   296: astore 4
    //   298: getstatic 28	com/mobisystems/mobiscanner/common/d:apd	Lcom/mobisystems/mobiscanner/common/c;
    //   301: ldc_w 571
    //   304: aload_1
    //   305: invokevirtual 575	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   308: goto -45 -> 263
    //   311: astore_0
    //   312: aload 6
    //   314: astore_3
    //   315: aload_1
    //   316: ifnull +10 -> 326
    //   319: aload_2
    //   320: astore 4
    //   322: aload_1
    //   323: invokevirtual 563	java/io/InputStream:close	()V
    //   326: aload_3
    //   327: ifnull +10 -> 337
    //   330: aload_2
    //   331: astore 4
    //   333: aload_3
    //   334: invokevirtual 564	java/io/BufferedOutputStream:close	()V
    //   337: aload_2
    //   338: astore 4
    //   340: aload_0
    //   341: athrow
    //   342: astore_1
    //   343: aload_2
    //   344: astore 4
    //   346: getstatic 28	com/mobisystems/mobiscanner/common/d:apd	Lcom/mobisystems/mobiscanner/common/c;
    //   349: ldc_w 571
    //   352: aload_1
    //   353: invokevirtual 575	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   356: goto -30 -> 326
    //   359: astore_1
    //   360: aload_2
    //   361: astore 4
    //   363: getstatic 28	com/mobisystems/mobiscanner/common/d:apd	Lcom/mobisystems/mobiscanner/common/c;
    //   366: ldc_w 578
    //   369: aload_1
    //   370: invokevirtual 575	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   373: goto -36 -> 337
    //   376: aload_1
    //   377: invokevirtual 506	android/net/Uri:getScheme	()Ljava/lang/String;
    //   380: ldc_w 581
    //   383: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   386: ifeq +203 -> 589
    //   389: aload_1
    //   390: invokevirtual 582	android/net/Uri:getPath	()Ljava/lang/String;
    //   393: areturn
    //   394: aload_1
    //   395: invokevirtual 582	android/net/Uri:getPath	()Ljava/lang/String;
    //   398: astore_1
    //   399: new 584	java/net/URL
    //   402: dup
    //   403: aload_1
    //   404: invokespecial 585	java/net/URL:<init>	(Ljava/lang/String;)V
    //   407: astore_2
    //   408: aload_2
    //   409: invokevirtual 588	java/net/URL:getProtocol	()Ljava/lang/String;
    //   412: astore 4
    //   414: ldc_w 581
    //   417: aload 4
    //   419: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   422: ifeq +8 -> 430
    //   425: aload_2
    //   426: invokevirtual 589	java/net/URL:getPath	()Ljava/lang/String;
    //   429: areturn
    //   430: ldc_w 591
    //   433: aload 4
    //   435: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   438: ifne +27 -> 465
    //   441: ldc_w 593
    //   444: aload 4
    //   446: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   449: ifne +16 -> 465
    //   452: aload_1
    //   453: astore_3
    //   454: ldc_w 595
    //   457: aload 4
    //   459: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   462: ifeq -280 -> 182
    //   465: aload_0
    //   466: invokestatic 547	com/mobisystems/mobiscanner/common/d:af	(Landroid/content/Context;)Ljava/io/File;
    //   469: astore_0
    //   470: aload_2
    //   471: aload_0
    //   472: invokestatic 598	com/mobisystems/mobiscanner/common/d:a	(Ljava/net/URL;Ljava/io/File;)V
    //   475: aload_0
    //   476: invokevirtual 601	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   479: astore_0
    //   480: aload_0
    //   481: areturn
    //   482: astore_0
    //   483: getstatic 28	com/mobisystems/mobiscanner/common/d:apd	Lcom/mobisystems/mobiscanner/common/c;
    //   486: ldc_w 603
    //   489: aload_0
    //   490: invokevirtual 575	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   493: aload_1
    //   494: areturn
    //   495: astore_0
    //   496: getstatic 28	com/mobisystems/mobiscanner/common/d:apd	Lcom/mobisystems/mobiscanner/common/c;
    //   499: ldc_w 605
    //   502: invokevirtual 608	com/mobisystems/mobiscanner/common/c:A	(Ljava/lang/String;)V
    //   505: aload_1
    //   506: areturn
    //   507: astore_0
    //   508: getstatic 28	com/mobisystems/mobiscanner/common/d:apd	Lcom/mobisystems/mobiscanner/common/c;
    //   511: ldc_w 610
    //   514: aload_0
    //   515: invokevirtual 575	com/mobisystems/mobiscanner/common/c:g	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   518: aload_1
    //   519: areturn
    //   520: astore 4
    //   522: aload_0
    //   523: astore_3
    //   524: aload 4
    //   526: astore_0
    //   527: goto -212 -> 315
    //   530: astore 4
    //   532: aconst_null
    //   533: astore_1
    //   534: aload_0
    //   535: astore_3
    //   536: aload 4
    //   538: astore_0
    //   539: goto -224 -> 315
    //   542: astore_0
    //   543: aconst_null
    //   544: astore_1
    //   545: aload 6
    //   547: astore_3
    //   548: goto -233 -> 315
    //   551: astore 4
    //   553: aload_0
    //   554: astore_3
    //   555: aload 4
    //   557: astore_0
    //   558: goto -243 -> 315
    //   561: astore_3
    //   562: goto -314 -> 248
    //   565: astore_3
    //   566: aload 5
    //   568: astore_1
    //   569: goto -321 -> 248
    //   572: astore_3
    //   573: aconst_null
    //   574: astore_0
    //   575: aload 5
    //   577: astore_1
    //   578: goto -330 -> 248
    //   581: astore_3
    //   582: goto -385 -> 197
    //   585: astore_3
    //   586: goto -399 -> 187
    //   589: aconst_null
    //   590: areturn
    //   591: aconst_null
    //   592: astore_2
    //   593: goto -510 -> 83
    //   596: aconst_null
    //   597: astore_2
    //   598: goto -509 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	601	0	paramContext	Context
    //   0	601	1	paramUri	Uri
    //   34	564	2	localObject1	Object
    //   53	130	3	localObject2	Object
    //   184	4	3	localIllegalArgumentException1	IllegalArgumentException
    //   194	4	3	localSecurityException1	SecurityException
    //   245	4	3	localException1	Exception
    //   264	291	3	localObject3	Object
    //   561	1	3	localException2	Exception
    //   565	1	3	localException3	Exception
    //   572	1	3	localException4	Exception
    //   581	1	3	localSecurityException2	SecurityException
    //   585	1	3	localIllegalArgumentException2	IllegalArgumentException
    //   99	359	4	localObject4	Object
    //   520	5	4	localObject5	Object
    //   530	7	4	localObject6	Object
    //   551	5	4	localObject7	Object
    //   4	572	5	localObject8	Object
    //   1	545	6	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   41	54	184	java/lang/IllegalArgumentException
    //   58	83	184	java/lang/IllegalArgumentException
    //   41	54	194	java/lang/SecurityException
    //   58	83	194	java/lang/SecurityException
    //   157	165	204	java/io/IOException
    //   101	110	221	java/io/FileNotFoundException
    //   157	165	221	java/io/FileNotFoundException
    //   174	182	221	java/io/FileNotFoundException
    //   208	218	221	java/io/FileNotFoundException
    //   233	243	221	java/io/FileNotFoundException
    //   259	263	221	java/io/FileNotFoundException
    //   272	276	221	java/io/FileNotFoundException
    //   282	292	221	java/io/FileNotFoundException
    //   298	308	221	java/io/FileNotFoundException
    //   322	326	221	java/io/FileNotFoundException
    //   333	337	221	java/io/FileNotFoundException
    //   340	342	221	java/io/FileNotFoundException
    //   346	356	221	java/io/FileNotFoundException
    //   363	373	221	java/io/FileNotFoundException
    //   174	182	229	java/io/IOException
    //   110	131	245	java/lang/Exception
    //   272	276	278	java/io/IOException
    //   259	263	294	java/io/IOException
    //   110	131	311	finally
    //   322	326	342	java/io/IOException
    //   333	337	359	java/io/IOException
    //   399	430	482	java/net/MalformedURLException
    //   430	452	482	java/net/MalformedURLException
    //   454	465	482	java/net/MalformedURLException
    //   465	480	482	java/net/MalformedURLException
    //   399	430	495	java/net/SocketTimeoutException
    //   430	452	495	java/net/SocketTimeoutException
    //   454	465	495	java/net/SocketTimeoutException
    //   465	480	495	java/net/SocketTimeoutException
    //   399	430	507	java/io/IOException
    //   430	452	507	java/io/IOException
    //   454	465	507	java/io/IOException
    //   465	480	507	java/io/IOException
    //   131	141	520	finally
    //   141	145	530	finally
    //   145	150	542	finally
    //   248	252	551	finally
    //   131	141	561	java/lang/Exception
    //   141	145	565	java/lang/Exception
    //   145	150	572	java/lang/Exception
    //   83	89	581	java/lang/SecurityException
    //   83	89	585	java/lang/IllegalArgumentException
  }
  
  /* Error */
  public static String a(com.google.api.a.a.a parama, File paramFile, String paramString)
  {
    // Byte code:
    //   0: new 613	com/google/api/client/http/g
    //   3: dup
    //   4: ldc_w 615
    //   7: aload_1
    //   8: invokespecial 618	com/google/api/client/http/g:<init>	(Ljava/lang/String;Ljava/io/File;)V
    //   11: astore_1
    //   12: new 369	com/google/api/a/a/a/a
    //   15: dup
    //   16: invokespecial 619	com/google/api/a/a/a/a:<init>	()V
    //   19: astore 4
    //   21: invokestatic 622	com/mobisystems/mobiscanner/common/d:getFileName	()Ljava/lang/String;
    //   24: astore_3
    //   25: aload 4
    //   27: aload_3
    //   28: invokevirtual 626	com/google/api/a/a/a/a:cH	(Ljava/lang/String;)Lcom/google/api/a/a/a/a;
    //   31: pop
    //   32: aload 4
    //   34: ldc_w 615
    //   37: invokevirtual 629	com/google/api/a/a/a/a:cG	(Ljava/lang/String;)Lcom/google/api/a/a/a/a;
    //   40: pop
    //   41: aload_0
    //   42: invokevirtual 633	com/google/api/a/a/a:yX	()Lcom/google/api/a/a/a$b;
    //   45: aload 4
    //   47: aload_1
    //   48: invokevirtual 638	com/google/api/a/a/a$b:a	(Lcom/google/api/a/a/a/a;Lcom/google/api/client/http/b;)Lcom/google/api/a/a/a$b$b;
    //   51: iconst_1
    //   52: invokestatic 644	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   55: invokevirtual 650	com/google/api/a/a/a$b$b:e	(Ljava/lang/Boolean;)Lcom/google/api/a/a/a$b$b;
    //   58: iconst_1
    //   59: invokestatic 644	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   62: invokevirtual 653	com/google/api/a/a/a$b$b:d	(Ljava/lang/Boolean;)Lcom/google/api/a/a/a$b$b;
    //   65: aload_2
    //   66: invokevirtual 657	com/google/api/a/a/a$b$b:cE	(Ljava/lang/String;)Lcom/google/api/a/a/a$b$b;
    //   69: invokevirtual 661	com/google/api/a/a/a$b$b:xe	()Ljava/lang/Object;
    //   72: checkcast 369	com/google/api/a/a/a/a
    //   75: astore_2
    //   76: aload_2
    //   77: ifnull +128 -> 205
    //   80: aload_0
    //   81: aload_2
    //   82: invokestatic 663	com/mobisystems/mobiscanner/common/d:a	(Lcom/google/api/a/a/a;Lcom/google/api/a/a/a/a;)Ljava/io/InputStream;
    //   85: astore 4
    //   87: aload 4
    //   89: ifnonnull +19 -> 108
    //   92: aload_2
    //   93: ifnull +207 -> 300
    //   96: aload_0
    //   97: aload_2
    //   98: invokevirtual 665	com/google/api/a/a/a/a:getId	()Ljava/lang/String;
    //   101: invokestatic 668	com/mobisystems/mobiscanner/common/d:a	(Lcom/google/api/a/a/a;Ljava/lang/String;)V
    //   104: ldc_w 670
    //   107: areturn
    //   108: new 672	java/io/BufferedReader
    //   111: dup
    //   112: new 674	java/io/InputStreamReader
    //   115: dup
    //   116: aload 4
    //   118: invokespecial 677	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   121: invokespecial 680	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   124: astore 5
    //   126: new 119	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   133: astore_1
    //   134: aload 5
    //   136: invokevirtual 683	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   139: astore 6
    //   141: aload 6
    //   143: ifnull +28 -> 171
    //   146: aload_1
    //   147: aload 6
    //   149: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: goto -19 -> 134
    //   156: astore_1
    //   157: aload_2
    //   158: ifnull +63 -> 221
    //   161: aload_0
    //   162: aload_2
    //   163: invokevirtual 665	com/google/api/a/a/a/a:getId	()Ljava/lang/String;
    //   166: invokestatic 668	com/mobisystems/mobiscanner/common/d:a	(Lcom/google/api/a/a/a;Ljava/lang/String;)V
    //   169: aload_1
    //   170: athrow
    //   171: aload 4
    //   173: invokevirtual 563	java/io/InputStream:close	()V
    //   176: aload_1
    //   177: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: astore_1
    //   181: aload_2
    //   182: ifnull +197 -> 379
    //   185: aload_0
    //   186: aload_2
    //   187: invokevirtual 665	com/google/api/a/a/a/a:getId	()Ljava/lang/String;
    //   190: invokestatic 668	com/mobisystems/mobiscanner/common/d:a	(Lcom/google/api/a/a/a;Ljava/lang/String;)V
    //   193: aload_1
    //   194: areturn
    //   195: astore 4
    //   197: aload 4
    //   199: invokevirtual 423	java/io/IOException:printStackTrace	()V
    //   202: goto -26 -> 176
    //   205: aload_2
    //   206: ifnull +252 -> 458
    //   209: aload_0
    //   210: aload_2
    //   211: invokevirtual 665	com/google/api/a/a/a/a:getId	()Ljava/lang/String;
    //   214: invokestatic 668	com/mobisystems/mobiscanner/common/d:a	(Lcom/google/api/a/a/a;Ljava/lang/String;)V
    //   217: ldc_w 670
    //   220: areturn
    //   221: aload_0
    //   222: invokevirtual 633	com/google/api/a/a/a:yX	()Lcom/google/api/a/a/a$b;
    //   225: invokevirtual 687	com/google/api/a/a/a$b:yZ	()Lcom/google/api/a/a/a$b$c;
    //   228: new 119	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   235: ldc_w 689
    //   238: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload_3
    //   242: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: ldc_w 691
    //   248: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokevirtual 697	com/google/api/a/a/a$b$c:cF	(Ljava/lang/String;)Lcom/google/api/a/a/a$b$c;
    //   257: invokevirtual 698	com/google/api/a/a/a$b$c:xe	()Ljava/lang/Object;
    //   260: checkcast 700	com/google/api/a/a/a/b
    //   263: invokevirtual 704	com/google/api/a/a/a/b:zh	()Ljava/util/List;
    //   266: invokeinterface 708 1 0
    //   271: astore_2
    //   272: aload_2
    //   273: invokeinterface 713 1 0
    //   278: ifeq -109 -> 169
    //   281: aload_0
    //   282: aload_2
    //   283: invokeinterface 716 1 0
    //   288: checkcast 369	com/google/api/a/a/a/a
    //   291: invokevirtual 665	com/google/api/a/a/a/a:getId	()Ljava/lang/String;
    //   294: invokestatic 668	com/mobisystems/mobiscanner/common/d:a	(Lcom/google/api/a/a/a;Ljava/lang/String;)V
    //   297: goto -25 -> 272
    //   300: aload_0
    //   301: invokevirtual 633	com/google/api/a/a/a:yX	()Lcom/google/api/a/a/a$b;
    //   304: invokevirtual 687	com/google/api/a/a/a$b:yZ	()Lcom/google/api/a/a/a$b$c;
    //   307: new 119	java/lang/StringBuilder
    //   310: dup
    //   311: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   314: ldc_w 689
    //   317: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: aload_3
    //   321: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: ldc_w 691
    //   327: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: invokevirtual 697	com/google/api/a/a/a$b$c:cF	(Ljava/lang/String;)Lcom/google/api/a/a/a$b$c;
    //   336: invokevirtual 698	com/google/api/a/a/a$b$c:xe	()Ljava/lang/Object;
    //   339: checkcast 700	com/google/api/a/a/a/b
    //   342: invokevirtual 704	com/google/api/a/a/a/b:zh	()Ljava/util/List;
    //   345: invokeinterface 708 1 0
    //   350: astore_1
    //   351: aload_1
    //   352: invokeinterface 713 1 0
    //   357: ifeq -253 -> 104
    //   360: aload_0
    //   361: aload_1
    //   362: invokeinterface 716 1 0
    //   367: checkcast 369	com/google/api/a/a/a/a
    //   370: invokevirtual 665	com/google/api/a/a/a/a:getId	()Ljava/lang/String;
    //   373: invokestatic 668	com/mobisystems/mobiscanner/common/d:a	(Lcom/google/api/a/a/a;Ljava/lang/String;)V
    //   376: goto -25 -> 351
    //   379: aload_0
    //   380: invokevirtual 633	com/google/api/a/a/a:yX	()Lcom/google/api/a/a/a$b;
    //   383: invokevirtual 687	com/google/api/a/a/a$b:yZ	()Lcom/google/api/a/a/a$b$c;
    //   386: new 119	java/lang/StringBuilder
    //   389: dup
    //   390: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   393: ldc_w 689
    //   396: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: aload_3
    //   400: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: ldc_w 691
    //   406: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: invokevirtual 697	com/google/api/a/a/a$b$c:cF	(Ljava/lang/String;)Lcom/google/api/a/a/a$b$c;
    //   415: invokevirtual 698	com/google/api/a/a/a$b$c:xe	()Ljava/lang/Object;
    //   418: checkcast 700	com/google/api/a/a/a/b
    //   421: invokevirtual 704	com/google/api/a/a/a/b:zh	()Ljava/util/List;
    //   424: invokeinterface 708 1 0
    //   429: astore_2
    //   430: aload_2
    //   431: invokeinterface 713 1 0
    //   436: ifeq -243 -> 193
    //   439: aload_0
    //   440: aload_2
    //   441: invokeinterface 716 1 0
    //   446: checkcast 369	com/google/api/a/a/a/a
    //   449: invokevirtual 665	com/google/api/a/a/a/a:getId	()Ljava/lang/String;
    //   452: invokestatic 668	com/mobisystems/mobiscanner/common/d:a	(Lcom/google/api/a/a/a;Ljava/lang/String;)V
    //   455: goto -25 -> 430
    //   458: aload_0
    //   459: invokevirtual 633	com/google/api/a/a/a:yX	()Lcom/google/api/a/a/a$b;
    //   462: invokevirtual 687	com/google/api/a/a/a$b:yZ	()Lcom/google/api/a/a/a$b$c;
    //   465: new 119	java/lang/StringBuilder
    //   468: dup
    //   469: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   472: ldc_w 689
    //   475: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: aload_3
    //   479: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: ldc_w 691
    //   485: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   491: invokevirtual 697	com/google/api/a/a/a$b$c:cF	(Ljava/lang/String;)Lcom/google/api/a/a/a$b$c;
    //   494: invokevirtual 698	com/google/api/a/a/a$b$c:xe	()Ljava/lang/Object;
    //   497: checkcast 700	com/google/api/a/a/a/b
    //   500: invokevirtual 704	com/google/api/a/a/a/b:zh	()Ljava/util/List;
    //   503: invokeinterface 708 1 0
    //   508: astore_1
    //   509: aload_1
    //   510: invokeinterface 713 1 0
    //   515: ifeq -298 -> 217
    //   518: aload_0
    //   519: aload_1
    //   520: invokeinterface 716 1 0
    //   525: checkcast 369	com/google/api/a/a/a/a
    //   528: invokevirtual 665	com/google/api/a/a/a/a:getId	()Ljava/lang/String;
    //   531: invokestatic 668	com/mobisystems/mobiscanner/common/d:a	(Lcom/google/api/a/a/a;Ljava/lang/String;)V
    //   534: goto -25 -> 509
    //   537: astore_1
    //   538: aconst_null
    //   539: astore_2
    //   540: goto -383 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	543	0	parama	com.google.api.a.a.a
    //   0	543	1	paramFile	File
    //   0	543	2	paramString	String
    //   24	455	3	str1	String
    //   19	153	4	localObject	Object
    //   195	3	4	localIOException	IOException
    //   124	11	5	localBufferedReader	java.io.BufferedReader
    //   139	9	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   80	87	156	finally
    //   108	134	156	finally
    //   134	141	156	finally
    //   146	153	156	finally
    //   171	176	156	finally
    //   176	181	156	finally
    //   197	202	156	finally
    //   171	176	195	java/io/IOException
    //   41	76	537	finally
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, int paramInt5, DialogInterface.OnClickListener paramOnClickListener1, int paramInt6, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    a(paramContext, paramInt1, paramInt2, paramInt3, paramInt4, paramString, paramInt5, paramOnClickListener1, paramInt6, paramOnClickListener2, paramOnDismissListener, paramOnCheckedChangeListener, false);
  }
  
  @SuppressLint({"NewApi"})
  public static void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, int paramInt5, DialogInterface.OnClickListener paramOnClickListener1, int paramInt6, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener, boolean paramBoolean)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramContext);
    localBuilder.setTitle(paramInt3);
    if (paramInt4 > 0) {
      localBuilder.setIcon(paramInt4);
    }
    paramContext = paramContext.getSystemService("layout_inflater");
    if (!(paramContext instanceof LayoutInflater)) {
      return;
    }
    paramContext = ((LayoutInflater)paramContext).inflate(paramInt1, null);
    ((TextView)paramContext.findViewById(2131165361)).setText(paramString);
    paramString = (CheckBox)paramContext.findViewById(2131165362);
    if (paramString != null)
    {
      paramString.setChecked(paramBoolean);
      if (paramOnCheckedChangeListener != null) {
        paramString.setOnCheckedChangeListener(paramOnCheckedChangeListener);
      }
      if (paramInt2 > 0) {
        paramString.setText(paramInt2);
      }
    }
    localBuilder.setView(paramContext);
    if (paramInt5 > 0) {
      localBuilder.setPositiveButton(paramInt5, paramOnClickListener1);
    }
    if (paramInt6 > 0) {
      localBuilder.setNegativeButton(paramInt6, paramOnClickListener2);
    }
    if (DA()) {
      localBuilder.setOnDismissListener(paramOnDismissListener);
    }
    paramContext = localBuilder.create();
    if (!DA()) {
      paramContext.setOnDismissListener(paramOnDismissListener);
    }
    paramContext.show();
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, String paramString, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, int paramInt4, DialogInterface.OnClickListener paramOnClickListener2)
  {
    a(paramContext, paramInt1, paramInt2, paramString, paramInt3, paramOnClickListener1, paramInt4, paramOnClickListener2, null);
  }
  
  @SuppressLint({"NewApi"})
  public static void a(Context paramContext, int paramInt1, int paramInt2, String paramString, int paramInt3, DialogInterface.OnClickListener paramOnClickListener1, int paramInt4, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramContext);
    localBuilder.setTitle(paramInt1);
    if (paramInt2 > 0) {
      localBuilder.setIcon(paramInt2);
    }
    paramContext = paramContext.getSystemService("layout_inflater");
    if (!(paramContext instanceof LayoutInflater)) {
      return;
    }
    paramContext = ((LayoutInflater)paramContext).inflate(2130903078, null);
    ((TextView)paramContext.findViewById(2131165361)).setText(paramString);
    localBuilder.setView(paramContext);
    if (paramInt3 > 0) {
      localBuilder.setPositiveButton(paramInt3, paramOnClickListener1);
    }
    if (paramInt4 > 0) {
      localBuilder.setNegativeButton(paramInt4, paramOnClickListener2);
    }
    if (DA()) {
      localBuilder.setOnDismissListener(paramOnDismissListener);
    }
    paramContext = localBuilder.create();
    if (!DA()) {
      paramContext.setOnDismissListener(paramOnDismissListener);
    }
    paramContext.show();
  }
  
  public static void a(final Context paramContext, ViewGroup paramViewGroup, String paramString)
  {
    View localView = new View(paramContext);
    paramViewGroup.addView(localView);
    localView.getLayoutParams().height = c(paramContext, 50);
    localView.getLayoutParams().width = -1;
    localView.setBackgroundResource(2130837619);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent();
        paramAnonymousView.setAction("android.intent.action.VIEW");
        paramAnonymousView.addCategory("android.intent.category.BROWSABLE");
        paramAnonymousView.setData(Uri.parse("http://mobisystems.com?app=qpsf" + this.awy));
        paramContext.startActivity(paramAnonymousView);
      }
    });
  }
  
  /* Error */
  public static void a(Context paramContext, b paramb)
  {
    // Byte code:
    //   0: new 834	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 835	java/util/ArrayList:<init>	()V
    //   7: astore 8
    //   9: aload_0
    //   10: ldc_w 836
    //   13: invokevirtual 837	android/content/Context:getString	(I)Ljava/lang/String;
    //   16: astore 9
    //   18: new 839	java/util/zip/ZipInputStream
    //   21: dup
    //   22: new 841	java/io/BufferedInputStream
    //   25: dup
    //   26: new 843	java/io/FileInputStream
    //   29: dup
    //   30: aload_0
    //   31: invokestatic 846	com/mobisystems/mobiscanner/common/d:aa	(Landroid/content/Context;)Ljava/io/File;
    //   34: invokespecial 847	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   37: invokespecial 848	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   40: invokespecial 849	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   43: astore 10
    //   45: aconst_null
    //   46: astore 5
    //   48: iconst_0
    //   49: istore_3
    //   50: iconst_0
    //   51: istore_2
    //   52: aload 10
    //   54: invokevirtual 853	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   57: astore 6
    //   59: aload 6
    //   61: ifnull +390 -> 451
    //   64: aload 6
    //   66: invokevirtual 858	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   69: astore 6
    //   71: iload_3
    //   72: ifne +71 -> 143
    //   75: ldc_w 860
    //   78: aload 6
    //   80: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   83: ifeq +60 -> 143
    //   86: new 551	java/io/FileOutputStream
    //   89: dup
    //   90: aload_0
    //   91: new 119	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   98: ldc_w 862
    //   101: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload 9
    //   106: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokevirtual 865	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   115: invokespecial 554	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   118: astore 6
    //   120: aload 10
    //   122: aload 6
    //   124: invokestatic 868	com/mobisystems/mobiscanner/common/d:c	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   127: aload 6
    //   129: invokevirtual 869	java/io/FileOutputStream:close	()V
    //   132: aload 6
    //   134: astore 5
    //   136: iconst_1
    //   137: istore_2
    //   138: iconst_1
    //   139: istore_3
    //   140: goto -88 -> 52
    //   143: aload 6
    //   145: ldc_w 871
    //   148: invokevirtual 875	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   151: astore 6
    //   153: new 194	java/io/File
    //   156: dup
    //   157: aload_0
    //   158: aload 6
    //   160: iconst_0
    //   161: aaload
    //   162: ldc_w 877
    //   165: ldc_w 670
    //   168: invokevirtual 881	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   171: aload 6
    //   173: iconst_1
    //   174: aaload
    //   175: invokestatic 884	com/mobisystems/mobiscanner/common/d:f	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   178: invokevirtual 200	java/io/File:getPath	()Ljava/lang/String;
    //   181: new 119	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   188: aload 6
    //   190: iconst_2
    //   191: aaload
    //   192: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload 9
    //   197: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokespecial 887	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   206: astore 7
    //   208: new 551	java/io/FileOutputStream
    //   211: dup
    //   212: aload 7
    //   214: invokespecial 554	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   217: astore 6
    //   219: aload 10
    //   221: aload 6
    //   223: invokestatic 868	com/mobisystems/mobiscanner/common/d:c	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   226: aload 8
    //   228: aload 7
    //   230: invokevirtual 601	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   233: invokevirtual 890	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   236: pop
    //   237: aload 6
    //   239: invokevirtual 869	java/io/FileOutputStream:close	()V
    //   242: aload 6
    //   244: astore 5
    //   246: goto -106 -> 140
    //   249: astore 5
    //   251: iload_2
    //   252: istore_3
    //   253: aload 10
    //   255: invokevirtual 891	java/util/zip/ZipInputStream:close	()V
    //   258: aload 6
    //   260: ifnull +10 -> 270
    //   263: iload_2
    //   264: istore_3
    //   265: aload 6
    //   267: invokevirtual 869	java/io/FileOutputStream:close	()V
    //   270: iload_2
    //   271: istore_3
    //   272: aload 5
    //   274: athrow
    //   275: astore 5
    //   277: iload_2
    //   278: istore_3
    //   279: aload 5
    //   281: invokevirtual 423	java/io/IOException:printStackTrace	()V
    //   284: iconst_0
    //   285: istore 4
    //   287: aload_1
    //   288: iload 4
    //   290: invokeinterface 894 2 0
    //   295: return
    //   296: aload_1
    //   297: athrow
    //   298: astore_1
    //   299: iconst_0
    //   300: istore_3
    //   301: iload_3
    //   302: ifeq -6 -> 296
    //   305: aload_0
    //   306: new 119	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   313: ldc_w 862
    //   316: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: aload 9
    //   321: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: invokevirtual 865	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   330: astore 5
    //   332: aload_0
    //   333: ldc_w 862
    //   336: invokevirtual 865	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   339: astore_0
    //   340: aload 5
    //   342: aload_0
    //   343: invokestatic 897	com/mobisystems/mobiscanner/common/d:a	(Ljava/io/File;Ljava/io/File;)V
    //   346: aload 5
    //   348: invokevirtual 900	java/io/File:delete	()Z
    //   351: pop
    //   352: aload 9
    //   354: invokevirtual 128	java/lang/String:length	()I
    //   357: istore_2
    //   358: aload 8
    //   360: invokevirtual 901	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   363: astore_0
    //   364: aload_0
    //   365: invokeinterface 713 1 0
    //   370: ifeq -74 -> 296
    //   373: aload_0
    //   374: invokeinterface 716 1 0
    //   379: checkcast 58	java/lang/String
    //   382: astore 6
    //   384: new 194	java/io/File
    //   387: dup
    //   388: aload 6
    //   390: invokespecial 211	java/io/File:<init>	(Ljava/lang/String;)V
    //   393: astore 5
    //   395: new 194	java/io/File
    //   398: dup
    //   399: aload 6
    //   401: iconst_0
    //   402: aload 6
    //   404: invokevirtual 128	java/lang/String:length	()I
    //   407: iload_2
    //   408: isub
    //   409: invokevirtual 905	java/lang/String:substring	(II)Ljava/lang/String;
    //   412: invokespecial 211	java/io/File:<init>	(Ljava/lang/String;)V
    //   415: astore 6
    //   417: aload 5
    //   419: aload 6
    //   421: invokestatic 897	com/mobisystems/mobiscanner/common/d:a	(Ljava/io/File;Ljava/io/File;)V
    //   424: aload 5
    //   426: invokevirtual 900	java/io/File:delete	()Z
    //   429: pop
    //   430: goto -66 -> 364
    //   433: astore 5
    //   435: aload 5
    //   437: invokevirtual 423	java/io/IOException:printStackTrace	()V
    //   440: goto -76 -> 364
    //   443: astore_0
    //   444: aload_0
    //   445: invokevirtual 423	java/io/IOException:printStackTrace	()V
    //   448: goto -96 -> 352
    //   451: iload_2
    //   452: istore_3
    //   453: aload 10
    //   455: invokevirtual 891	java/util/zip/ZipInputStream:close	()V
    //   458: aload 5
    //   460: ifnull +10 -> 470
    //   463: iload_2
    //   464: istore_3
    //   465: aload 5
    //   467: invokevirtual 869	java/io/FileOutputStream:close	()V
    //   470: iload_2
    //   471: ifeq +184 -> 655
    //   474: aload_0
    //   475: new 119	java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   482: ldc_w 862
    //   485: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: aload 9
    //   490: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   496: invokevirtual 865	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   499: astore 5
    //   501: aload_0
    //   502: ldc_w 862
    //   505: invokevirtual 865	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   508: astore_0
    //   509: aload 5
    //   511: aload_0
    //   512: invokestatic 897	com/mobisystems/mobiscanner/common/d:a	(Ljava/io/File;Ljava/io/File;)V
    //   515: aload 5
    //   517: invokevirtual 900	java/io/File:delete	()Z
    //   520: pop
    //   521: aload 9
    //   523: invokevirtual 128	java/lang/String:length	()I
    //   526: istore_2
    //   527: aload 8
    //   529: invokevirtual 901	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   532: astore_0
    //   533: aload_0
    //   534: invokeinterface 713 1 0
    //   539: ifeq +81 -> 620
    //   542: aload_0
    //   543: invokeinterface 716 1 0
    //   548: checkcast 58	java/lang/String
    //   551: astore 6
    //   553: new 194	java/io/File
    //   556: dup
    //   557: aload 6
    //   559: invokespecial 211	java/io/File:<init>	(Ljava/lang/String;)V
    //   562: astore 5
    //   564: new 194	java/io/File
    //   567: dup
    //   568: aload 6
    //   570: iconst_0
    //   571: aload 6
    //   573: invokevirtual 128	java/lang/String:length	()I
    //   576: iload_2
    //   577: isub
    //   578: invokevirtual 905	java/lang/String:substring	(II)Ljava/lang/String;
    //   581: invokespecial 211	java/io/File:<init>	(Ljava/lang/String;)V
    //   584: astore 6
    //   586: aload 5
    //   588: aload 6
    //   590: invokestatic 897	com/mobisystems/mobiscanner/common/d:a	(Ljava/io/File;Ljava/io/File;)V
    //   593: aload 5
    //   595: invokevirtual 900	java/io/File:delete	()Z
    //   598: pop
    //   599: goto -66 -> 533
    //   602: astore 5
    //   604: aload 5
    //   606: invokevirtual 423	java/io/IOException:printStackTrace	()V
    //   609: goto -76 -> 533
    //   612: astore_0
    //   613: aload_0
    //   614: invokevirtual 423	java/io/IOException:printStackTrace	()V
    //   617: goto -96 -> 521
    //   620: iconst_1
    //   621: istore 4
    //   623: goto -336 -> 287
    //   626: astore_1
    //   627: goto -326 -> 301
    //   630: astore 5
    //   632: iconst_0
    //   633: istore_2
    //   634: goto -357 -> 277
    //   637: astore 5
    //   639: goto -388 -> 251
    //   642: astore 7
    //   644: aload 5
    //   646: astore 6
    //   648: aload 7
    //   650: astore 5
    //   652: goto -401 -> 251
    //   655: iconst_0
    //   656: istore 4
    //   658: goto -371 -> 287
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	661	0	paramContext	Context
    //   0	661	1	paramb	b
    //   51	583	2	i	int
    //   49	416	3	j	int
    //   285	372	4	bool	boolean
    //   46	199	5	localObject1	Object
    //   249	24	5	localObject2	Object
    //   275	5	5	localIOException1	IOException
    //   330	95	5	localFile1	File
    //   433	33	5	localIOException2	IOException
    //   499	95	5	localFile2	File
    //   602	3	5	localIOException3	IOException
    //   630	1	5	localIOException4	IOException
    //   637	8	5	localObject3	Object
    //   650	1	5	localObject4	Object
    //   57	590	6	localObject5	Object
    //   206	23	7	localFile3	File
    //   642	7	7	localObject6	Object
    //   7	521	8	localArrayList	java.util.ArrayList
    //   16	506	9	str	String
    //   43	411	10	localZipInputStream	java.util.zip.ZipInputStream
    // Exception table:
    //   from	to	target	type
    //   219	242	249	finally
    //   253	258	275	java/io/IOException
    //   265	270	275	java/io/IOException
    //   272	275	275	java/io/IOException
    //   453	458	275	java/io/IOException
    //   465	470	275	java/io/IOException
    //   18	45	298	finally
    //   417	430	433	java/io/IOException
    //   340	352	443	java/io/IOException
    //   586	599	602	java/io/IOException
    //   509	521	612	java/io/IOException
    //   253	258	626	finally
    //   265	270	626	finally
    //   272	275	626	finally
    //   279	284	626	finally
    //   453	458	626	finally
    //   465	470	626	finally
    //   18	45	630	java/io/IOException
    //   120	132	637	finally
    //   52	59	642	finally
    //   64	71	642	finally
    //   75	120	642	finally
    //   143	219	642	finally
  }
  
  private static void a(com.google.api.a.a.a parama, String paramString)
  {
    try
    {
      parama.yX().cD(paramString).xe();
      return;
    }
    catch (IOException parama)
    {
      System.out.println("An error occurred: " + parama);
    }
  }
  
  public static void a(File paramFile1, File paramFile2)
  {
    try
    {
      a(paramFile1, paramFile2, null);
      return;
    }
    catch (InterruptedException paramFile1) {}
  }
  
  /* Error */
  public static void a(File paramFile1, File paramFile2, a<Integer> parama)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokevirtual 601	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   6: aload_1
    //   7: invokevirtual 601	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   10: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   13: ifne +43 -> 56
    //   16: new 843	java/io/FileInputStream
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 847	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   24: astore_0
    //   25: new 551	java/io/FileOutputStream
    //   28: dup
    //   29: aload_1
    //   30: invokespecial 554	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   33: astore_1
    //   34: aload_0
    //   35: aload_1
    //   36: aload_2
    //   37: invokestatic 560	com/mobisystems/mobiscanner/common/d:a	(Ljava/io/InputStream;Ljava/io/OutputStream;Lcom/mobisystems/mobiscanner/common/a;)V
    //   40: aload_0
    //   41: ifnull +7 -> 48
    //   44: aload_0
    //   45: invokevirtual 923	java/io/FileInputStream:close	()V
    //   48: aload_1
    //   49: ifnull +7 -> 56
    //   52: aload_1
    //   53: invokevirtual 869	java/io/FileOutputStream:close	()V
    //   56: return
    //   57: astore_0
    //   58: aconst_null
    //   59: astore_1
    //   60: aload_3
    //   61: astore_2
    //   62: aload_2
    //   63: ifnull +7 -> 70
    //   66: aload_2
    //   67: invokevirtual 923	java/io/FileInputStream:close	()V
    //   70: aload_1
    //   71: ifnull +7 -> 78
    //   74: aload_1
    //   75: invokevirtual 869	java/io/FileOutputStream:close	()V
    //   78: aload_0
    //   79: athrow
    //   80: astore_0
    //   81: goto -33 -> 48
    //   84: astore_0
    //   85: return
    //   86: astore_2
    //   87: goto -17 -> 70
    //   90: astore_1
    //   91: goto -13 -> 78
    //   94: astore_3
    //   95: aconst_null
    //   96: astore_1
    //   97: aload_0
    //   98: astore_2
    //   99: aload_3
    //   100: astore_0
    //   101: goto -39 -> 62
    //   104: astore_3
    //   105: aload_0
    //   106: astore_2
    //   107: aload_3
    //   108: astore_0
    //   109: goto -47 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	paramFile1	File
    //   0	112	1	paramFile2	File
    //   0	112	2	parama	a<Integer>
    //   1	60	3	localObject1	Object
    //   94	6	3	localObject2	Object
    //   104	4	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   16	25	57	finally
    //   44	48	80	java/io/IOException
    //   52	56	84	java/io/IOException
    //   66	70	86	java/io/IOException
    //   74	78	90	java/io/IOException
    //   25	34	94	finally
    //   34	40	104	finally
  }
  
  public static void a(InputStream paramInputStream, OutputStream paramOutputStream, a<Integer> parama)
  {
    byte[] arrayOfByte = new byte[' '];
    if (FileInputStream.class.isInstance(paramInputStream)) {}
    for (long l1 = ((FileInputStream)paramInputStream).getChannel().size();; l1 = 0L)
    {
      long l2 = 0L;
      int k = 100;
      int j = 0;
      int i = 0;
      if (parama != null)
      {
        k = ((Integer)parama.getMaxProgress()).intValue();
        i = ((Integer)parama.getCurrentProgress()).intValue();
        j = i;
      }
      long l3 = System.currentTimeMillis();
      for (;;)
      {
        int m = paramInputStream.read(arrayOfByte);
        if (m <= 0) {
          break;
        }
        if ((parama != null) && (parama.isWorkCancelled())) {
          throw new InterruptedException("Cancelled");
        }
        paramOutputStream.write(arrayOfByte, 0, m);
        long l4 = l2 + m;
        l2 = l4;
        if (parama != null)
        {
          long l5 = System.currentTimeMillis();
          l2 = l4;
          if (l5 - l3 >= 1000L)
          {
            l2 = l4;
            if (l1 > 0L)
            {
              i = (int)(j + (k - j) * l4 / l1);
              parama.setProgress(Integer.valueOf(i));
              l3 = l5;
              l2 = l4;
            }
          }
        }
      }
      if ((parama != null) && (i < k)) {
        parama.setProgress(Integer.valueOf(k));
      }
      return;
    }
  }
  
  public static void a(String paramString, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    Location localLocation = new Location(d.class.getName());
    localLocation.setAltitude(paramDouble3);
    localLocation.setLatitude(paramDouble2);
    localLocation.setLongitude(paramDouble1);
    a(paramString, localLocation);
  }
  
  public static void a(String paramString, Location paramLocation)
  {
    for (;;)
    {
      try
      {
        paramString = new ExifInterface(paramString);
        paramString.setAttribute("GPSLatitude", o(paramLocation.getLatitude()));
        paramString.setAttribute("GPSLongitude", o(paramLocation.getLongitude()));
        if (paramLocation.getLatitude() > 0.0D)
        {
          paramString.setAttribute("GPSLatitudeRef", "N");
          if (paramLocation.getLongitude() > 0.0D)
          {
            paramString.setAttribute("GPSLongitudeRef", "E");
            paramString.setAttribute("GPSAltitude", String.valueOf(Math.abs(paramLocation.getAltitude())));
            if (paramLocation.getAltitude() < 0.0D) {
              break label151;
            }
            i = 0;
            paramString.setAttribute("GPSAltitudeRef", String.valueOf(i));
            paramString.saveAttributes();
          }
        }
        else
        {
          paramString.setAttribute("GPSLatitudeRef", "S");
          continue;
        }
        paramString.setAttribute("GPSLongitudeRef", "W");
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      continue;
      label151:
      int i = 1;
    }
  }
  
  public static void a(String paramString1, String paramString2, ZipOutputStream paramZipOutputStream)
  {
    if (paramZipOutputStream != null) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        paramZipOutputStream = new ZipOutputStream(new FileOutputStream(paramString2));
      }
      b("", paramString1, paramZipOutputStream);
      if (i == 0)
      {
        paramZipOutputStream.flush();
        paramZipOutputStream.close();
      }
      return;
    }
  }
  
  public static void a(URL paramURL, File paramFile)
  {
    try
    {
      a(paramURL, paramFile, null);
      return;
    }
    catch (InterruptedException paramURL) {}
  }
  
  /* Error */
  public static void a(URL paramURL, File paramFile, a<Integer> parama)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokevirtual 1060	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   6: astore_0
    //   7: aload_0
    //   8: sipush 10000
    //   11: invokevirtual 1065	java/net/URLConnection:setConnectTimeout	(I)V
    //   14: aload_0
    //   15: sipush 10000
    //   18: invokevirtual 1068	java/net/URLConnection:setReadTimeout	(I)V
    //   21: aload_0
    //   22: invokevirtual 1071	java/net/URLConnection:getInputStream	()Ljava/io/InputStream;
    //   25: astore_0
    //   26: new 551	java/io/FileOutputStream
    //   29: dup
    //   30: aload_1
    //   31: invokespecial 554	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   34: astore_1
    //   35: aload_0
    //   36: aload_1
    //   37: aload_2
    //   38: invokestatic 560	com/mobisystems/mobiscanner/common/d:a	(Ljava/io/InputStream;Ljava/io/OutputStream;Lcom/mobisystems/mobiscanner/common/a;)V
    //   41: aload_0
    //   42: ifnull +7 -> 49
    //   45: aload_0
    //   46: invokevirtual 563	java/io/InputStream:close	()V
    //   49: aload_1
    //   50: ifnull +7 -> 57
    //   53: aload_1
    //   54: invokevirtual 1072	java/io/OutputStream:close	()V
    //   57: return
    //   58: astore_0
    //   59: aconst_null
    //   60: astore_1
    //   61: aload_3
    //   62: astore_2
    //   63: aload_2
    //   64: ifnull +7 -> 71
    //   67: aload_2
    //   68: invokevirtual 563	java/io/InputStream:close	()V
    //   71: aload_1
    //   72: ifnull +7 -> 79
    //   75: aload_1
    //   76: invokevirtual 1072	java/io/OutputStream:close	()V
    //   79: aload_0
    //   80: athrow
    //   81: astore_0
    //   82: goto -33 -> 49
    //   85: astore_0
    //   86: return
    //   87: astore_2
    //   88: goto -17 -> 71
    //   91: astore_1
    //   92: goto -13 -> 79
    //   95: astore_3
    //   96: aconst_null
    //   97: astore_1
    //   98: aload_0
    //   99: astore_2
    //   100: aload_3
    //   101: astore_0
    //   102: goto -39 -> 63
    //   105: astore_3
    //   106: aload_0
    //   107: astore_2
    //   108: aload_3
    //   109: astore_0
    //   110: goto -47 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	paramURL	URL
    //   0	113	1	paramFile	File
    //   0	113	2	parama	a<Integer>
    //   1	61	3	localObject1	Object
    //   95	6	3	localObject2	Object
    //   105	4	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	58	finally
    //   45	49	81	java/io/IOException
    //   53	57	85	java/io/IOException
    //   67	71	87	java/io/IOException
    //   75	79	91	java/io/IOException
    //   26	35	95	finally
    //   35	41	105	finally
  }
  
  /* Error */
  public static void a(byte[] paramArrayOfByte, File paramFile)
  {
    // Byte code:
    //   0: new 551	java/io/FileOutputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 554	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   8: astore_1
    //   9: aload_1
    //   10: aload_0
    //   11: invokevirtual 1077	java/io/FileOutputStream:write	([B)V
    //   14: aload_1
    //   15: ifnull +7 -> 22
    //   18: aload_1
    //   19: invokevirtual 869	java/io/FileOutputStream:close	()V
    //   22: return
    //   23: astore_0
    //   24: aconst_null
    //   25: astore_1
    //   26: aload_1
    //   27: ifnull +7 -> 34
    //   30: aload_1
    //   31: invokevirtual 869	java/io/FileOutputStream:close	()V
    //   34: aload_0
    //   35: athrow
    //   36: astore_0
    //   37: return
    //   38: astore_1
    //   39: goto -5 -> 34
    //   42: astore_0
    //   43: goto -17 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	paramArrayOfByte	byte[]
    //   0	46	1	paramFile	File
    // Exception table:
    //   from	to	target	type
    //   0	9	23	finally
    //   18	22	36	java/io/IOException
    //   30	34	38	java/io/IOException
    //   9	14	42	finally
  }
  
  public static boolean a(Matrix paramMatrix, int paramInt1, int paramInt2)
  {
    int i = 100;
    boolean bool1 = true;
    boolean bool2 = bool1;
    int j;
    label19:
    float[] arrayOfFloat;
    if (i < paramInt1)
    {
      j = 100;
      bool2 = bool1;
      if (j < paramInt2)
      {
        arrayOfFloat = new float[2];
        arrayOfFloat[0] = i;
        arrayOfFloat[1] = j;
        paramMatrix.mapPoints(arrayOfFloat);
        if ((Math.abs(arrayOfFloat[0]) > Math.pow(2.0D, 14.0D)) || (Math.abs(arrayOfFloat[1]) > Math.pow(2.0D, 14.0D))) {
          bool2 = false;
        }
      }
      else
      {
        if (bool2) {
          break label222;
        }
      }
    }
    else
    {
      bool1 = bool2;
      if (bool2)
      {
        arrayOfFloat = new float[8];
        arrayOfFloat[0] = 0.0F;
        arrayOfFloat[1] = 0.0F;
        arrayOfFloat[2] = paramInt1;
        arrayOfFloat[3] = 0.0F;
        arrayOfFloat[4] = paramInt1;
        arrayOfFloat[5] = paramInt2;
        arrayOfFloat[6] = 0.0F;
        arrayOfFloat[7] = paramInt2;
        paramMatrix.mapPoints(arrayOfFloat);
        paramInt2 = arrayOfFloat.length;
        paramInt1 = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (paramInt1 < paramInt2)
      {
        if (Math.abs(arrayOfFloat[paramInt1]) > Math.pow(2.0D, 14.0D)) {
          bool1 = false;
        }
      }
      else
      {
        return bool1;
        j += 100;
        break label19;
        label222:
        i += 100;
        bool1 = bool2;
        break;
      }
      paramInt1 += 1;
    }
  }
  
  public static boolean a(com.mobisystems.mobiscanner.common.util.g paramg)
  {
    paramg.DZ();
    return true;
  }
  
  public static boolean a(float[] paramArrayOfFloat)
  {
    boolean bool = true;
    double d1 = a(paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[2], paramArrayOfFloat[3]);
    double d2 = a(paramArrayOfFloat[0], paramArrayOfFloat[1], paramArrayOfFloat[6], paramArrayOfFloat[7]);
    float f = (float)(d1 / d2);
    if ((d1 == 0.0D) || (d2 == 0.0D) || (f > 2.0F) || (f < 0.5F)) {
      bool = false;
    }
    return bool;
  }
  
  public static float[] a(ac paramac, List<Point> paramList)
  {
    try
    {
      paramac = paramac.n(paramList);
      if (a(paramac)) {
        return paramac;
      }
      throw new RuntimeException();
    }
    catch (RuntimeException paramac) {}
    return l(paramList);
  }
  
  public static com.mobisystems.mobiscanner.controller.b[] a(Context paramContext, List<ResolveInfo> paramList, String paramString)
  {
    String str = paramContext.getResources().getString(2131297029);
    PackageManager localPackageManager = paramContext.getPackageManager();
    Object localObject;
    CharSequence localCharSequence;
    if ("PAGE_EDIT".equals(paramString))
    {
      paramString = new com.mobisystems.mobiscanner.controller.b[1];
      if (DD()) {
        paramString[0] = new com.mobisystems.mobiscanner.controller.b(paramContext.getResources().getString(2131297024), paramContext.getResources().getDrawable(2130837870), str + "com.mobisystems.msgs", str + "com.mobisystems.msgs");
      }
      for (;;)
      {
        paramContext = paramList.iterator();
        do
        {
          do
          {
            if (!paramContext.hasNext()) {
              break;
            }
            localObject = (ResolveInfo)paramContext.next();
            paramList = ((ResolveInfo)localObject).activityInfo.packageName;
            str = ((ResolveInfo)localObject).activityInfo.name;
            localCharSequence = ((ResolveInfo)localObject).loadLabel(localPackageManager);
            localObject = ((ResolveInfo)localObject).loadIcon(localPackageManager);
          } while (!paramList.startsWith("com.mobisystems.msgs"));
          paramString[0] = new com.mobisystems.mobiscanner.controller.b(localCharSequence.toString(), (Drawable)localObject, paramList, str);
        } while (paramList.startsWith("com.mobisystems.msgsreg"));
        return paramString;
        paramString[0] = new com.mobisystems.mobiscanner.controller.b(paramContext.getResources().getString(2131297023), paramContext.getResources().getDrawable(2130837870), str + "com.mobisystems.msgsreg", str + "com.mobisystems.msgsreg");
      }
    }
    if ("DOCUMENT_PRINT".equals(paramString))
    {
      paramString = new com.mobisystems.mobiscanner.controller.b[1];
      paramString[0] = new com.mobisystems.mobiscanner.controller.b(paramContext.getResources().getString(2131297027), paramContext.getResources().getDrawable(2130837870), str + "com.google.android.apps.cloudprint", str + "com.google.android.apps.cloudprint");
      paramContext = paramList.iterator();
      while (paramContext.hasNext())
      {
        localObject = (ResolveInfo)paramContext.next();
        paramList = ((ResolveInfo)localObject).activityInfo.packageName;
        str = ((ResolveInfo)localObject).activityInfo.name;
        localCharSequence = ((ResolveInfo)localObject).loadLabel(localPackageManager);
        localObject = ((ResolveInfo)localObject).loadIcon(localPackageManager);
        if (paramList.startsWith("com.google.android.apps.cloudprint")) {
          paramString[0] = new com.mobisystems.mobiscanner.controller.b(localCharSequence.toString(), (Drawable)localObject, paramList, str);
        }
      }
      return paramString;
    }
    if ("DOCUMENT_FAX".equals(paramString))
    {
      paramString = new com.mobisystems.mobiscanner.controller.b[1];
      paramString[0] = new com.mobisystems.mobiscanner.controller.b(paramContext.getResources().getString(2131297028), paramContext.getResources().getDrawable(2130837870), str + "com.perceptionsystem.faxpro", str + "com.perceptionsystem.faxpro");
      paramContext = paramList.iterator();
      while (paramContext.hasNext())
      {
        localObject = (ResolveInfo)paramContext.next();
        paramList = ((ResolveInfo)localObject).activityInfo.packageName;
        str = ((ResolveInfo)localObject).activityInfo.name;
        localCharSequence = ((ResolveInfo)localObject).loadLabel(localPackageManager);
        localObject = ((ResolveInfo)localObject).loadIcon(localPackageManager);
        if (paramList.startsWith("com.perceptionsystem.faxpro")) {
          paramString[0] = new com.mobisystems.mobiscanner.controller.b(localCharSequence.toString(), (Drawable)localObject, paramList, str);
        }
      }
      return paramString;
    }
    return null;
  }
  
  public static File aa(Context paramContext)
  {
    return new File(Z(paramContext), aj(paramContext));
  }
  
  public static File ab(Context paramContext)
  {
    return new File(Z(paramContext), ak(paramContext));
  }
  
  public static File ac(Context paramContext)
  {
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      paramContext = new File(X(paramContext).getPath() + File.separator + "error");
      paramContext.mkdirs();
    }
    while ((!paramContext.exists()) || (!paramContext.isDirectory()))
    {
      throw new IOException("Can not retrieve error dir");
      paramContext = paramContext.getDir("error", 2);
    }
    return paramContext;
  }
  
  public static File ad(Context paramContext)
  {
    File localFile = null;
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      localFile = new File(Dt(), ae(paramContext));
      localFile.mkdirs();
    }
    if ((localFile == null) || (!localFile.exists()) || (!localFile.isDirectory())) {
      throw new IOException("Can not retrieve export directory");
    }
    return localFile;
  }
  
  public static String ae(Context paramContext)
  {
    return paramContext.getString(paramContext.getApplicationInfo().labelRes);
  }
  
  public static File af(Context paramContext)
  {
    paramContext = Y(paramContext);
    return new File(paramContext.getPath() + File.separator + "TMP_" + String.valueOf(aww.nextInt()));
  }
  
  public static File ag(Context paramContext)
  {
    paramContext = ad(paramContext);
    return new File(paramContext.getPath() + File.separator + "TMPExport_" + String.valueOf(aww.nextInt()));
  }
  
  public static int ah(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().orientation;
  }
  
  @TargetApi(17)
  public static a ai(Context paramContext)
  {
    a locala = new a();
    Object localObject = paramContext.getResources().getConfiguration();
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    int i = paramContext.getRotation();
    locala.rotation = i;
    locala.awA = 1;
    if (((i != 0) && (i != 2)) || ((((Configuration)localObject).orientation == 2) || (((i == 1) || (i == 3)) && (((Configuration)localObject).orientation == 1)))) {
      locala.awA = 2;
    }
    localObject = new DisplayMetrics();
    paramContext.getMetrics((DisplayMetrics)localObject);
    locala.height = ((DisplayMetrics)localObject).heightPixels;
    locala.width = ((DisplayMetrics)localObject).widthPixels;
    locala.awB = locala.height;
    locala.awC = locala.width;
    if (DA())
    {
      localObject = new DisplayMetrics();
      paramContext.getRealMetrics((DisplayMetrics)localObject);
      locala.awB = ((DisplayMetrics)localObject).heightPixels;
      locala.awC = ((DisplayMetrics)localObject).widthPixels;
    }
    for (;;)
    {
      locala.awD = (locala.awC - locala.width);
      if (locala.awB - locala.height > 0) {
        locala.awD = (locala.awB - locala.height);
      }
      return locala;
      try
      {
        localObject = Display.class.getMethod("getRawHeight", new Class[0]);
        Method localMethod = Display.class.getMethod("getRawWidth", new Class[0]);
        locala.awB = ((Integer)((Method)localObject).invoke(paramContext, new Object[0])).intValue();
        locala.awC = ((Integer)localMethod.invoke(paramContext, new Object[0])).intValue();
      }
      catch (IllegalArgumentException paramContext)
      {
        apd.h("IllegalArgumentException in getNotificationBarHeight", paramContext);
      }
      catch (IllegalAccessException paramContext)
      {
        apd.h("IllegalAccessException in getNotificationBarHeight", paramContext);
      }
      catch (InvocationTargetException paramContext)
      {
        apd.h("InvocationTargetException in getNotificationBarHeight", paramContext);
      }
      catch (NoSuchMethodException paramContext)
      {
        apd.h("NoSuchMethodException in getNotificationBarHeight", paramContext);
      }
    }
  }
  
  public static String aj(Context paramContext)
  {
    return paramContext.getString(2131297102) + "." + paramContext.getString(2131297103);
  }
  
  public static String ak(Context paramContext)
  {
    return paramContext.getString(2131297105) + "." + paramContext.getString(2131297106);
  }
  
  /* Error */
  public static long al(Context paramContext)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_3
    //   2: new 843	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokestatic 1325	com/mobisystems/mobiscanner/common/d:ab	(Landroid/content/Context;)Ljava/io/File;
    //   10: invokespecial 847	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   13: astore 5
    //   15: aload 5
    //   17: astore_0
    //   18: new 672	java/io/BufferedReader
    //   21: dup
    //   22: new 674	java/io/InputStreamReader
    //   25: dup
    //   26: aload 5
    //   28: invokespecial 677	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   31: invokespecial 680	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   34: invokevirtual 683	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   37: astore 6
    //   39: lload_3
    //   40: lstore_1
    //   41: aload 5
    //   43: astore_0
    //   44: aload 6
    //   46: invokestatic 540	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   49: ifne +14 -> 63
    //   52: aload 5
    //   54: astore_0
    //   55: aload 6
    //   57: bipush 10
    //   59: invokestatic 1331	java/lang/Long:parseLong	(Ljava/lang/String;I)J
    //   62: lstore_1
    //   63: lload_1
    //   64: lstore_3
    //   65: aload 5
    //   67: ifnull +10 -> 77
    //   70: aload 5
    //   72: invokevirtual 563	java/io/InputStream:close	()V
    //   75: lload_1
    //   76: lstore_3
    //   77: lload_3
    //   78: lreturn
    //   79: astore_0
    //   80: aload_0
    //   81: invokevirtual 423	java/io/IOException:printStackTrace	()V
    //   84: lload_1
    //   85: lreturn
    //   86: astore 6
    //   88: aconst_null
    //   89: astore 5
    //   91: aload 5
    //   93: astore_0
    //   94: aload 6
    //   96: invokevirtual 423	java/io/IOException:printStackTrace	()V
    //   99: aload 5
    //   101: ifnull -24 -> 77
    //   104: aload 5
    //   106: invokevirtual 563	java/io/InputStream:close	()V
    //   109: lconst_0
    //   110: lreturn
    //   111: astore_0
    //   112: aload_0
    //   113: invokevirtual 423	java/io/IOException:printStackTrace	()V
    //   116: lconst_0
    //   117: lreturn
    //   118: astore 5
    //   120: aconst_null
    //   121: astore_0
    //   122: aload_0
    //   123: ifnull +7 -> 130
    //   126: aload_0
    //   127: invokevirtual 563	java/io/InputStream:close	()V
    //   130: aload 5
    //   132: athrow
    //   133: astore_0
    //   134: aload_0
    //   135: invokevirtual 423	java/io/IOException:printStackTrace	()V
    //   138: goto -8 -> 130
    //   141: astore 5
    //   143: goto -21 -> 122
    //   146: astore 6
    //   148: goto -57 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	paramContext	Context
    //   40	45	1	l1	long
    //   1	77	3	l2	long
    //   13	92	5	localFileInputStream	FileInputStream
    //   118	13	5	localObject1	Object
    //   141	1	5	localObject2	Object
    //   37	19	6	str	String
    //   86	9	6	localIOException1	IOException
    //   146	1	6	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   70	75	79	java/io/IOException
    //   2	15	86	java/io/IOException
    //   104	109	111	java/io/IOException
    //   2	15	118	finally
    //   126	130	133	java/io/IOException
    //   18	39	141	finally
    //   44	52	141	finally
    //   55	63	141	finally
    //   94	99	141	finally
    //   18	39	146	java/io/IOException
    //   44	52	146	java/io/IOException
    //   55	63	146	java/io/IOException
  }
  
  public static boolean am(Context paramContext)
  {
    return ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo() != null;
  }
  
  public static void an(Context paramContext)
  {
    if (PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean(CommonPreferences.Keys.apU.getKey(), false)) {
      paramContext.startService(new Intent(paramContext, OCRService.class));
    }
  }
  
  public static void ao(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.MAIN");
    localIntent.setClass(paramContext, DocumentListActivity.class);
    localIntent.addFlags(67108864);
    paramContext.startActivity(localIntent);
  }
  
  public static boolean ap(Context paramContext)
  {
    int i = paramContext.getSharedPreferences(paramContext.getString(2131297115), 4).getInt(CommonPreferences.Keys.apV.getKey(), Integer.parseInt(paramContext.getString(2131296520)));
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((paramContext != null) && (paramContext.isConnected()))
    {
      int j = paramContext.getType();
      if ((i == 1) || ((i == 2) && (j == 1))) {
        return true;
      }
    }
    return false;
  }
  
  public static String ay(Object paramObject)
  {
    if (paramObject != null) {
      return String.format("%08X", new Object[] { Integer.valueOf(System.identityHashCode(paramObject)) });
    }
    return "null";
  }
  
  public static void b(Context paramContext, long paramLong)
  {
    Intent localIntent = new Intent(paramContext, AutoCropService.class);
    localIntent.putExtra("AUTO_CROP_SERVICE_PAGE_ID", paramLong);
    paramContext.startService(localIntent);
  }
  
  public static void b(File paramFile1, File paramFile2)
  {
    try
    {
      b(paramFile1, paramFile2, null);
      return;
    }
    catch (InterruptedException paramFile1) {}
  }
  
  public static void b(File paramFile1, File paramFile2, a<Integer> parama)
  {
    if ((paramFile2.exists()) && (!paramFile2.delete())) {
      throw new IOException("moveFile: Could not delete destination file " + paramFile2.getAbsolutePath());
    }
    if (!paramFile1.renameTo(paramFile2))
    {
      a(paramFile1, paramFile2, parama);
      if (!paramFile1.delete()) {
        throw new IOException("moveFile: Could not delete the source file " + paramFile1.getAbsolutePath());
      }
    }
  }
  
  private static void b(String paramString1, String paramString2, ZipOutputStream paramZipOutputStream)
  {
    File localFile = new File(paramString2);
    if (localFile.isDirectory())
    {
      c(paramString1, paramString2, paramZipOutputStream);
      return;
    }
    byte[] arrayOfByte = new byte['Ѐ'];
    paramString2 = new FileInputStream(paramString2);
    paramZipOutputStream.putNextEntry(new ZipEntry(paramString1 + "/" + localFile.getName()));
    for (;;)
    {
      int i = paramString2.read(arrayOfByte);
      if (i <= 0) {
        break;
      }
      paramZipOutputStream.write(arrayOfByte, 0, i);
    }
    paramString2.close();
    paramZipOutputStream.closeEntry();
  }
  
  public static float[] b(float paramFloat, int paramInt)
  {
    float[] arrayOfFloat = new float[8];
    if (paramFloat >= 1.0F)
    {
      arrayOfFloat[0] = 0.0F;
      arrayOfFloat[1] = 0.0F;
      arrayOfFloat[2] = (paramInt * paramFloat);
      arrayOfFloat[3] = 0.0F;
      arrayOfFloat[4] = (paramInt * paramFloat);
      arrayOfFloat[5] = paramInt;
      arrayOfFloat[6] = 0.0F;
      arrayOfFloat[7] = paramInt;
      return arrayOfFloat;
    }
    arrayOfFloat[0] = 0.0F;
    arrayOfFloat[1] = 0.0F;
    arrayOfFloat[2] = paramInt;
    arrayOfFloat[3] = 0.0F;
    arrayOfFloat[4] = paramInt;
    arrayOfFloat[5] = (paramInt / paramFloat);
    arrayOfFloat[6] = 0.0F;
    arrayOfFloat[7] = (paramInt / paramFloat);
    return arrayOfFloat;
  }
  
  public static int c(Context paramContext, int paramInt)
  {
    return (int)Math.ceil(paramContext.getResources().getDisplayMetrics().density * paramInt);
  }
  
  public static void c(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    try
    {
      a(paramInputStream, paramOutputStream, null);
      return;
    }
    catch (InterruptedException paramInputStream)
    {
      paramInputStream.printStackTrace();
    }
  }
  
  private static void c(String paramString1, String paramString2, ZipOutputStream paramZipOutputStream)
  {
    File localFile = new File(paramString2);
    String[] arrayOfString = localFile.list();
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      String str = arrayOfString[i];
      if (paramString1.equals("")) {
        b(localFile.getName(), paramString2 + "/" + str, paramZipOutputStream);
      }
      for (;;)
      {
        i += 1;
        break;
        b(paramString1 + "/" + localFile.getName(), paramString2 + "/" + str, paramZipOutputStream);
      }
    }
  }
  
  public static void d(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      String[] arrayOfString = paramFile.list();
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        File localFile = new File(paramFile, arrayOfString[i]);
        if (!localFile.delete()) {
          apd.dl("cleanDirectory: could not delete " + localFile.getAbsolutePath());
        }
        i += 1;
      }
    }
  }
  
  @TargetApi(16)
  public static String[] d(Context paramContext, Intent paramIntent)
  {
    int k = 1;
    String[] arrayOfString1;
    if (DB())
    {
      ClipData localClipData = paramIntent.getClipData();
      if (localClipData != null)
      {
        int m = localClipData.getItemCount();
        String[] arrayOfString2 = new String[m];
        int j = 0;
        for (;;)
        {
          i = k;
          arrayOfString1 = arrayOfString2;
          if (j >= m) {
            break;
          }
          arrayOfString2[j] = a(paramContext, localClipData.getItemAt(j).getUri());
          j += 1;
        }
      }
      arrayOfString1 = new String[1];
    }
    for (int i = 0;; i = 0)
    {
      if (i == 0) {
        arrayOfString1[0] = a(paramContext, paramIntent.getData());
      }
      return arrayOfString1;
      arrayOfString1 = new String[1];
    }
  }
  
  public static String dm(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      localObject = s(((MessageDigest)localObject).digest());
      return (String)localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
    return String.valueOf(paramString.hashCode());
  }
  
  @SuppressLint({"DefaultLocale"})
  public static String dn(String paramString)
  {
    paramString = paramString.toLowerCase().toCharArray();
    int j = 0;
    int i = 0;
    if (j < paramString.length)
    {
      if ((i == 0) && (Character.isLetter(paramString[j]))) {
        paramString[j] = Character.toUpperCase(paramString[j]);
      }
      for (i = 1;; i = 0) {
        do
        {
          j += 1;
          break;
        } while ((!Character.isWhitespace(paramString[j])) && (paramString[j] != '.') && (paramString[j] != '\''));
      }
    }
    return String.valueOf(paramString);
  }
  
  public static String jdMethod_do(String paramString)
  {
    if (DD())
    {
      String str = "amzn://apps/android?p=" + paramString;
      if (paramString.contains("aviary")) {
        str = "amzn://apps/android?asin=B00BD6RLIO";
      }
      return str;
    }
    return "market://details?id=" + paramString;
  }
  
  public static String dp(String paramString)
  {
    if (DD())
    {
      String str = "http://www.amazon.com/gp/mas/dl/android?p=" + paramString;
      if (paramString.contains("aviary")) {
        str = "http://www.amazon.com/gp/mas/dl/android?asin=B00BD6RLIO";
      }
      return str;
    }
    return "http://play.google.com/store/apps/details?id=" + paramString;
  }
  
  public static String e(File paramFile)
  {
    Object localObject = null;
    if (paramFile != null)
    {
      String str = paramFile.getAbsolutePath();
      localObject = str;
      if ("mounted".equals(Environment.getExternalStorageState()))
      {
        File localFile = Dt();
        localObject = str;
        if (localFile != null)
        {
          paramFile = localFile.toURI().relativize(paramFile.toURI()).getPath();
          localObject = paramFile;
          if (paramFile.endsWith(File.separator)) {
            localObject = paramFile.substring(0, paramFile.length() - File.separator.length());
          }
        }
      }
    }
    return (String)localObject;
  }
  
  public static File f(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getDir(paramString1, 0);
    if ((!paramContext.exists()) || (!paramContext.isDirectory())) {
      throw new IOException("Can not create directory: " + paramString1);
    }
    if ((paramString2 != null) && (!paramString2.equals("")))
    {
      File localFile = new File(paramContext, paramString2);
      localFile.mkdir();
      if (localFile.exists())
      {
        paramContext = localFile;
        if (localFile.isDirectory()) {}
      }
      else
      {
        throw new IOException("Can not create directory: " + paramString1 + File.separator + paramString2);
      }
    }
    return paramContext;
  }
  
  private static String getFileName()
  {
    return "qpdf_tmp_" + DH();
  }
  
  public static File k(Context paramContext, String paramString)
  {
    if ("mounted".equals(Environment.getExternalStorageState())) {}
    for (paramContext = a(paramContext).getPath();; paramContext = paramContext.getCacheDir().getPath())
    {
      paramContext = new File(paramContext + File.separator + paramString);
      paramContext.mkdirs();
      if ((paramContext.exists()) && (paramContext.isDirectory())) {
        break;
      }
      throw new IOException("Can not retrieve disk cache dir");
    }
    return paramContext;
  }
  
  public static void l(Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      ((android.text.ClipboardManager)paramContext.getSystemService("clipboard")).setText(paramString);
      return;
    }
    ((android.content.ClipboardManager)paramContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Copied Text", paramString));
  }
  
  public static float[] l(List<Point> paramList)
  {
    double d1 = a((Point)paramList.get(0), (Point)paramList.get(1));
    double d2 = a((Point)paramList.get(1), (Point)paramList.get(2));
    double d3 = a((Point)paramList.get(2), (Point)paramList.get(3));
    double d4 = a((Point)paramList.get(3), (Point)paramList.get(0));
    float f1 = (float)((d1 + d3) / 2.0D);
    float f2 = (float)((d4 + d2) / 2.0D);
    return b(f1 / f2, (int)Math.min(f1, f2));
  }
  
  static String o(double paramDouble)
  {
    if (paramDouble > 0.0D) {}
    for (;;)
    {
      String str = Integer.toString((int)paramDouble) + "/1,";
      paramDouble = paramDouble % 1.0D * 60.0D;
      str = str + Integer.toString((int)paramDouble) + "/1,";
      return str + Integer.toString((int)(paramDouble % 1.0D * 60000.0D)) + "/1000";
      paramDouble = -paramDouble;
    }
  }
  
  private static String s(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() == 1) {
        localStringBuilder.append('0');
      }
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static class a
  {
    public int awA;
    public int awB;
    public int awC;
    public int awD;
    public int height;
    public int rotation;
    public int width;
  }
  
  public static abstract interface b
  {
    public abstract void aT(boolean paramBoolean);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/mobisystems/mobiscanner/common/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */