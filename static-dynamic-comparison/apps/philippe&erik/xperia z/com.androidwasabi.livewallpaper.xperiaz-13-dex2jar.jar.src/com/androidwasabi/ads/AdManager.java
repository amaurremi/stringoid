package com.androidwasabi.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.FloatMath;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class AdManager
{
  public static final String ADS_ACTIVITY_REQUEST_TIME = "ads_activity_request_time";
  public static final String ADS_CACHE = "ads_cache";
  public static final String ADS_CURRENT_VIEW = "ads_current_view";
  public static final int ADS_FETCHING_TIME = 4;
  public static final int ADS_PERCENTAGE_ALWAYS = 100;
  public static final int ADS_PERCENTAGE_HIGH = 50;
  public static final int ADS_PERCENTAGE_LOW = 25;
  public static final int ADS_PERCENTAGE_MEDIUM = 30;
  public static final String ADS_REQUEST_TIME = "ads_request_time";
  public static final int ADS_TYPE_ALL = 1;
  public static final int ADS_TYPE_SINGLE = 2;
  public static final int ADS_TYPE_WALL = 3;
  private static final String ADS_URL = "https://d21aw2xov4zz0i.cloudfront.net/android/ads/v2/";
  private static final String ADS_URL2 = "https://d21aw2xov4zz0i.cloudfront.net/android/ads/3rdparty/ads.json";
  public static final String ADS_VIEW = "ads_view";
  public static final String ADS_WALL_VIEW = "ads_wall_view";
  public static final String CID_CACHE = "cid_cache";
  public static final int CID_FETCHING_TIME = 24;
  public static final String CID_FETCHING_URL = "http://54.83.11.161/getcid.php";
  public static final String CID_REQUEST_TIME = "cid_request_time";
  private static final String GOOGLE_PLAY_STORE_PACKAGE_NAME = "com.android.vending";
  public static final String SHARED_PREFS_NAME = "wasabi_ads_settings";
  public static final String TAG = "AdManager";
  private static AdManager.OnAdListener adListener;
  private static int adPercentage = 50;
  private static int adType;
  private static Activity app;
  private static String cid;
  private static int currAd = 0;
  private static int currAdWall = 0;
  public static final boolean debug = false;
  private static boolean hasPlayStore = true;
  static ImageLoader imageLoader = new ImageLoader();
  private static boolean loadAdListOnly;
  private static boolean loading = false;
  private static SharedPreferences prefs;
  private static float screenSize;
  private static int sdkLevel;
  private static String url;
  
  static
  {
    loadAdListOnly = false;
    adType = 1;
    sdkLevel = 10;
    screenSize = 4.0F;
    cid = "";
    url = "";
  }
  
  public static void adHandler(Context paramContext, String paramString)
  {
    adHandler(paramContext, paramString, "0");
  }
  
  public static void adHandler(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramString1.startsWith("market://")) || (paramString1.startsWith("https://play.google.com/"))) {}
    try
    {
      paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString1)));
      return;
    }
    catch (ActivityNotFoundException paramContext) {}
    if (paramString2.equals("1")) {
      try
      {
        paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString1));
        paramString1.setFlags(1073741824);
        paramContext.startActivity(paramString1);
        return;
      }
      catch (ActivityNotFoundException paramContext)
      {
        return;
      }
    }
    if ((hasPlayStore) && (Build.VERSION.SDK_INT >= 14)) {
      try
      {
        paramString2 = new Intent(paramContext, AdHandler.class);
        paramString2.putExtra("url", paramString1);
        paramContext.startActivity(paramString2);
        return;
      }
      catch (ActivityNotFoundException paramString2)
      {
        try
        {
          paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString1));
          paramString1.setFlags(1073741824);
          paramContext.startActivity(paramString1);
          return;
        }
        catch (ActivityNotFoundException paramContext)
        {
          return;
        }
      }
    }
    try
    {
      paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString1));
      paramString1.setFlags(1073741824);
      paramContext.startActivity(paramString1);
      return;
    }
    catch (ActivityNotFoundException paramContext) {}
  }
  
  private static ArrayList<AdManager.AdItem> buildAdList(String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      paramString1 = (AdManager.AdItem[])new Gson().fromJson(paramString1, AdManager.AdItem[].class);
      int i1 = 0;
      for (;;)
      {
        if (i1 >= paramString1.length)
        {
          if (localArrayList.size() != 0) {
            break label773;
          }
          return null;
        }
        AdManager.AdItem localAdItem = new AdManager.AdItem();
        localAdItem.name = paramString1[i1].name;
        localAdItem.description = paramString1[i1].description;
        localAdItem.image = paramString1[i1].image;
        localAdItem.url = paramString1[i1].url;
        localAdItem.androidid = paramString1[i1].androidid;
        localAdItem.screentype = paramString1[i1].screentype;
        localAdItem.directlink = paramString1[i1].directlink;
        localAdItem.sdkmin = paramString1[i1].sdkmin;
        localAdItem.sdkmax = paramString1[i1].sdkmax;
        for (;;)
        {
          try
          {
            if (localAdItem.androidid != null)
            {
              localObject = Settings.Secure.getString(app.getContentResolver(), "android_id");
              if (localObject != null) {
                localAdItem.url = (paramString1[i1].url + "&" + localAdItem.androidid + "=" + (String)localObject);
              }
            }
          }
          catch (Exception localException3)
          {
            Object localObject;
            continue;
            continue;
            int i = 1;
            continue;
            int m = 1;
            continue;
            i2 = 1;
            int n = 0;
            continue;
          }
          try
          {
            if (localAdItem.screentype == null) {
              continue;
            }
            i = Integer.valueOf(localAdItem.screentype).intValue();
            if (i == 0) {
              i = 1;
            }
          }
          catch (Exception localException1)
          {
            try
            {
              if (localAdItem.directlink != null)
              {
                if (!localAdItem.directlink.equals("1")) {
                  localAdItem.directlink = "0";
                }
                n = 1;
                m = 1;
                j = m;
                k = n;
              }
              try
              {
                if (localAdItem.sdkmax != null)
                {
                  j = m;
                  k = n;
                  if (sdkLevel > Integer.valueOf(localAdItem.sdkmax).intValue()) {
                    j = 0;
                  }
                }
                k = j;
                if (localAdItem.sdkmin == null) {
                  continue;
                }
                k = j;
                m = sdkLevel;
                k = j;
                n = Integer.valueOf(localAdItem.sdkmin).intValue();
                if (m >= n) {
                  continue;
                }
                j = 0;
              }
              catch (Exception localException4)
              {
                Calendar localCalendar1;
                Calendar localCalendar2;
                int i2;
                float f;
                String[] arrayOfString;
                j = k;
                continue;
              }
              k = 1;
              localObject = paramString1[i1].expire.split("-");
              localCalendar1 = Calendar.getInstance();
              localCalendar2 = Calendar.getInstance();
              localCalendar2.set(Integer.valueOf(localObject[0]).intValue(), Integer.valueOf(localObject[1]).intValue() - 1, Integer.valueOf(localObject[2]).intValue());
              if (localCalendar1.getTimeInMillis() <= localCalendar2.getTimeInMillis()) {
                k = 0;
              }
              localObject = paramString1[i1].region;
              if (((String)localObject).equals("ALL")) {
                continue;
              }
              if (((String)localObject).equals(""))
              {
                continue;
                n = m;
                i2 = k;
                if (paramBoolean)
                {
                  if ((localAdItem.name.equals("AD")) || (localAdItem.description.equals("")) || (localAdItem.image.equals(""))) {
                    continue;
                  }
                  n = m;
                  i2 = k;
                  if (localAdItem.url.equals("")) {
                    continue;
                  }
                }
                if ((i2 == 0) && (n != 0) && (j != 0) && (i != 0)) {
                  localArrayList.add(localAdItem);
                }
                i1 += 1;
                break;
                if (Integer.valueOf(localAdItem.screentype).intValue() == 1)
                {
                  if (screenSize < 6.0F) {
                    continue;
                  }
                  i = 0;
                  continue;
                }
                if (Integer.valueOf(localAdItem.screentype).intValue() != 2) {
                  continue;
                }
                f = screenSize;
                if (f >= 6.0F) {
                  continue;
                }
                i = 0;
                continue;
                localException1 = localException1;
                i = 1;
                continue;
                localAdItem.directlink = "0";
                continue;
              }
            }
            catch (Exception localException2)
            {
              localAdItem.directlink = "0";
              continue;
              arrayOfString = localException2.split(",");
              n = 0;
              i2 = 0;
            }
          }
        }
      }
      for (;;)
      {
        m = n;
        if (i2 >= arrayOfString.length) {
          break;
        }
        boolean bool = arrayOfString[i2].equals(paramString2);
        if (bool) {
          n = 1;
        }
        i2 += 1;
      }
      label773:
      return localArrayList;
    }
    catch (Exception paramString1)
    {
      return null;
    }
  }
  
  private static AlertDialog createAd(ArrayList<AdManager.AdItem> paramArrayList, boolean paramBoolean)
  {
    Object localObject4 = (AdManager.AdItem)paramArrayList.get(currAd);
    Object localObject1 = ((AdManager.AdItem)localObject4).name;
    Object localObject2 = ((AdManager.AdItem)localObject4).description;
    Object localObject3 = ((AdManager.AdItem)localObject4).url;
    String str = ((AdManager.AdItem)localObject4).directlink;
    localObject4 = ((AdManager.AdItem)localObject4).image;
    Object localObject5 = (LayoutInflater)app.getSystemService("layout_inflater");
    if (paramBoolean) {}
    for (int i = R.layout.popup;; i = R.layout.popup2)
    {
      localObject5 = ((LayoutInflater)localObject5).inflate(i, null);
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(app);
      localBuilder.setView((View)localObject5);
      localBuilder.setTitle((CharSequence)localObject1).setCancelable(false).setPositiveButton(app.getString(R.string.ok_title_label), new AdManager.3((String)localObject3, str)).setNegativeButton(app.getString(R.string.skip_title_label), new AdManager.4());
      ((TextView)((View)localObject5).findViewById(R.id.ad_description)).setText((CharSequence)localObject2);
      localObject1 = localBuilder.create();
      ((AlertDialog)localObject1).setOnShowListener(new AdManager.5((String)localObject4));
      imageLoader.setListener(new AdManager.6((AlertDialog)localObject1, (String)localObject4));
      if (!paramBoolean) {
        break;
      }
      return (AlertDialog)localObject1;
    }
    localObject2 = (ImageButton)((View)localObject5).findViewById(R.id.next_btn);
    localObject3 = (ImageButton)((View)localObject5).findViewById(R.id.prev_btn);
    ((ImageButton)localObject2).setOnClickListener(new AdManager.7((AlertDialog)localObject1, paramArrayList));
    ((ImageButton)localObject3).setOnClickListener(new AdManager.8((AlertDialog)localObject1, paramArrayList));
    return (AlertDialog)localObject1;
  }
  
  private static AlertDialog createAdWall(ArrayList<AdManager.AdItem> paramArrayList, boolean paramBoolean)
  {
    Object localObject1 = (LayoutInflater)app.getSystemService("layout_inflater");
    int i;
    Object localObject3;
    label76:
    label120:
    int j;
    if (paramBoolean)
    {
      i = R.layout.wall;
      localObject2 = ((LayoutInflater)localObject1).inflate(i, null);
      localObject3 = new AlertDialog.Builder(app);
      ((AlertDialog.Builder)localObject3).setView((View)localObject2);
      if (new Random().nextInt(2) != 0) {
        break label237;
      }
      localObject1 = app.getString(R.string.app_wall2_title_label);
      ((AlertDialog.Builder)localObject3).setTitle((CharSequence)localObject1).setCancelable(false).setNegativeButton(app.getString(R.string.skip_title_label), new AdManager.11());
      currAdWall = 0;
      if (!paramBoolean) {
        break label251;
      }
      i = paramArrayList.size();
      localObject1 = new ArrayList();
      j = currAdWall;
      label133:
      if (j < i) {
        break label260;
      }
      localObject4 = new AdManager.FileListAdapter(app, R.layout.wall_item, (ArrayList)localObject1);
      ListView localListView = (ListView)((View)localObject2).findViewById(R.id.ad_list);
      localListView.setAdapter((ListAdapter)localObject4);
      localListView.setOnItemClickListener(new AdManager.12());
      localObject3 = ((AlertDialog.Builder)localObject3).create();
      ((AlertDialog)localObject3).setOnShowListener(new AdManager.13((ArrayList)localObject1));
      imageLoader.setListener(new AdManager.14((AlertDialog)localObject3));
      if (!paramBoolean) {
        break label290;
      }
    }
    label237:
    label251:
    label260:
    label290:
    while (paramBoolean)
    {
      return (AlertDialog)localObject3;
      i = R.layout.wall2;
      break;
      localObject1 = app.getString(R.string.app_wall3_title_label);
      break label76;
      i = currAdWall + 4;
      break label120;
      localObject4 = (AdManager.AdItem)paramArrayList.get(j);
      if (localObject4 != null) {
        ((ArrayList)localObject1).add(localObject4);
      }
      j += 1;
      break label133;
    }
    Object localObject4 = (ImageButton)((View)localObject2).findViewById(R.id.next_btn);
    Object localObject2 = (ImageButton)((View)localObject2).findViewById(R.id.prev_btn);
    ((ImageButton)localObject2).setEnabled(false);
    ((ImageButton)localObject4).setOnClickListener(new AdManager.15((AlertDialog)localObject3, paramArrayList, (ArrayList)localObject1, (ImageButton)localObject4, (ImageButton)localObject2));
    ((ImageButton)localObject2).setOnClickListener(new AdManager.16((AlertDialog)localObject3, paramArrayList, (ArrayList)localObject1, (ImageButton)localObject4, (ImageButton)localObject2));
    return (AlertDialog)localObject3;
  }
  
  public static void destroy()
  {
    app = null;
    adListener = null;
  }
  
  public static Bitmap getAdImageFromCache(String paramString)
  {
    return imageLoader.getImageFromCache(paramString);
  }
  
  public static ArrayList<AdManager.AdItem> getAdList()
  {
    Object localObject = prefs.getString("ads_cache", "");
    if (((String)localObject).equals("")) {}
    do
    {
      do
      {
        return null;
      } while (prefs.getLong("ads_request_time", 0L) <= System.currentTimeMillis());
      localObject = buildAdList((String)localObject, cid, true);
    } while ((localObject == null) || (((ArrayList)localObject).size() < 1));
    Collections.shuffle((List)localObject);
    return (ArrayList<AdManager.AdItem>)localObject;
  }
  
  public static ImageLoader getImageLoader()
  {
    return imageLoader;
  }
  
  public static boolean hasPlayStore()
  {
    return hasPlayStore;
  }
  
  public static void init(Activity paramActivity)
  {
    app = paramActivity;
    prefs = paramActivity.getSharedPreferences("wasabi_ads_settings", 0);
    adListener = null;
    cid = "";
    try
    {
      localObject = (TelephonyManager)paramActivity.getSystemService("phone");
      String str = ((TelephonyManager)localObject).getSimCountryIso();
      if ((str == null) || (str.length() != 2)) {
        break label228;
      }
      cid = str.toUpperCase(Locale.US);
    }
    catch (Exception localException)
    {
      try
      {
        for (;;)
        {
          Object localObject;
          paramActivity.getPackageManager().getPackageInfo("com.android.vending", 0);
          hasPlayStore = true;
          sdkLevel = Build.VERSION.SDK_INT;
          paramActivity = new DisplayMetrics();
          app.getWindowManager().getDefaultDisplay().getMetrics(paramActivity);
          screenSize = FloatMath.sqrt(paramActivity.widthPixels * paramActivity.widthPixels + paramActivity.heightPixels * paramActivity.heightPixels) / paramActivity.densityDpi;
          paramActivity = Locale.getDefault().getLanguage().toLowerCase();
          if (!hasPlayStore) {
            break;
          }
          paramActivity = "https://d21aw2xov4zz0i.cloudfront.net/android/ads/v2/ads_" + paramActivity + ".json";
          url = paramActivity;
          return;
          cid = "";
          continue;
          localException = localException;
          cid = "";
        }
        cid = "";
      }
      catch (PackageManager.NameNotFoundException paramActivity)
      {
        for (;;)
        {
          hasPlayStore = false;
          continue;
          paramActivity = "https://d21aw2xov4zz0i.cloudfront.net/android/ads/3rdparty/ads.json";
        }
      }
    }
    if (((TelephonyManager)localObject).getPhoneType() != 2)
    {
      localObject = ((TelephonyManager)localObject).getNetworkCountryIso();
      if ((localObject != null) && (((String)localObject).length() == 2)) {
        cid = ((String)localObject).toUpperCase(Locale.US);
      }
    }
    else
    {
      imageLoader.setCache(true, paramActivity.getCacheDir());
    }
  }
  
  public static void loadAd()
  {
    loadAd(100, 1, false);
  }
  
  public static void loadAd(int paramInt)
  {
    loadAd(paramInt, 1, false);
  }
  
  public static void loadAd(int paramInt1, int paramInt2)
  {
    loadAd(paramInt1, paramInt2, false);
  }
  
  public static void loadAd(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    loadAdListOnly = paramBoolean;
    int i = paramInt1;
    if (paramInt1 <= 0) {
      i = 10;
    }
    adPercentage = i;
    adType = paramInt2;
    if ((app == null) || (prefs == null)) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = ((ConnectivityManager)app.getSystemService("connectivity")).getActiveNetworkInfo();
        if ((localObject != null) && (((NetworkInfo)localObject).getState() == NetworkInfo.State.CONNECTED)) {}
        Boolean localBoolean;
        for (localObject = Boolean.valueOf(false);; localBoolean = Boolean.valueOf(true))
        {
          if (!((Boolean)localObject).booleanValue()) {
            break label106;
          }
          if (adListener == null) {
            break;
          }
          try
          {
            adListener.isOffline();
            return;
          }
          catch (Exception localException1)
          {
            return;
          }
        }
        label106:
        if (!loading)
        {
          loading = true;
          new AdManager.LoadAdTask(null).execute(new String[] { url });
          return;
        }
      }
      catch (Exception localException2) {}
    }
  }
  
  public static void loadAdList()
  {
    loadAd(100, 3, true);
  }
  
  private static void loadImageItem()
  {
    Object localObject = prefs.getString("ads_cache", "");
    if (!((String)localObject).equals(""))
    {
      int i;
      int j;
      do
      {
        try
        {
          localObject = buildAdList((String)localObject, cid, true);
          if ((localObject == null) || (((ArrayList)localObject).size() == 0)) {
            break;
          }
          imageLoader.setListener(null);
          if (((ArrayList)localObject).size() > 5) {
            i = 5;
          } else {
            i = ((ArrayList)localObject).size();
          }
        }
        catch (Exception localException)
        {
          Log.e("AdManager", "Can't Load image item to memory...");
          return;
        }
        imageLoader.loadImage(((AdManager.AdItem)((ArrayList)localObject).get(j)).image);
        j += 1;
        continue;
        j = 0;
      } while (j < i);
    }
  }
  
  /* Error */
  public static boolean maybeShowAdActivity(Activity paramActivity)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 694
    //   4: invokevirtual 366	android/app/Activity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   7: checkcast 696	android/net/ConnectivityManager
    //   10: invokevirtual 700	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   13: astore 5
    //   15: aload 5
    //   17: ifnull +30 -> 47
    //   20: aload 5
    //   22: invokevirtual 706	android/net/NetworkInfo:getState	()Landroid/net/NetworkInfo$State;
    //   25: getstatic 712	android/net/NetworkInfo$State:CONNECTED	Landroid/net/NetworkInfo$State;
    //   28: if_acmpne +19 -> 47
    //   31: iconst_0
    //   32: invokestatic 717	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   35: astore 5
    //   37: aload 5
    //   39: invokevirtual 720	java/lang/Boolean:booleanValue	()Z
    //   42: ifeq +17 -> 59
    //   45: iconst_0
    //   46: ireturn
    //   47: iconst_1
    //   48: invokestatic 717	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   51: astore 5
    //   53: goto -16 -> 37
    //   56: astore_0
    //   57: iconst_0
    //   58: ireturn
    //   59: invokestatic 751	com/androidwasabi/ads/AdManager:getAdList	()Ljava/util/ArrayList;
    //   62: astore 5
    //   64: aload 5
    //   66: ifnull +101 -> 167
    //   69: aload 5
    //   71: invokevirtual 247	java/util/ArrayList:size	()I
    //   74: iconst_3
    //   75: if_icmpgt +9 -> 84
    //   78: getstatic 95	com/androidwasabi/ads/AdManager:hasPlayStore	Z
    //   81: ifne +84 -> 165
    //   84: aload_0
    //   85: ldc 63
    //   87: iconst_0
    //   88: invokevirtual 595	android/app/Activity:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   91: putstatic 131	com/androidwasabi/ads/AdManager:prefs	Landroid/content/SharedPreferences;
    //   94: getstatic 131	com/androidwasabi/ads/AdManager:prefs	Landroid/content/SharedPreferences;
    //   97: ldc 8
    //   99: lconst_0
    //   100: invokeinterface 570 4 0
    //   105: lstore_1
    //   106: invokestatic 575	java/lang/System:currentTimeMillis	()J
    //   109: lstore_3
    //   110: lload_1
    //   111: lload_3
    //   112: lcmp
    //   113: ifgt +18 -> 131
    //   116: aload_0
    //   117: new 185	android/content/Intent
    //   120: dup
    //   121: aload_0
    //   122: ldc_w 753
    //   125: invokespecial 223	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   128: invokevirtual 754	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   131: getstatic 131	com/androidwasabi/ads/AdManager:prefs	Landroid/content/SharedPreferences;
    //   134: invokeinterface 758 1 0
    //   139: astore_0
    //   140: aload_0
    //   141: ldc 8
    //   143: invokestatic 575	java/lang/System:currentTimeMillis	()J
    //   146: ldc2_w 759
    //   149: ladd
    //   150: invokeinterface 766 4 0
    //   155: pop
    //   156: aload_0
    //   157: invokeinterface 769 1 0
    //   162: pop
    //   163: iconst_1
    //   164: ireturn
    //   165: iconst_0
    //   166: ireturn
    //   167: iconst_0
    //   168: ireturn
    //   169: astore_0
    //   170: iconst_0
    //   171: ireturn
    //   172: astore_0
    //   173: goto -42 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	paramActivity	Activity
    //   105	6	1	l1	long
    //   109	3	3	l2	long
    //   13	57	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	15	56	java/lang/Exception
    //   20	31	56	java/lang/Exception
    //   59	64	169	java/lang/Exception
    //   69	84	169	java/lang/Exception
    //   84	110	169	java/lang/Exception
    //   116	131	169	java/lang/Exception
    //   131	163	169	java/lang/Exception
    //   116	131	172	android/content/ActivityNotFoundException
  }
  
  public static boolean maybeShowAdActivityAtEnd(Activity paramActivity)
  {
    try
    {
      Object localObject = ((ConnectivityManager)paramActivity.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((localObject != null) && (((NetworkInfo)localObject).getState() == NetworkInfo.State.CONNECTED)) {}
      for (localObject = Boolean.valueOf(false); ((Boolean)localObject).booleanValue(); localObject = Boolean.valueOf(true)) {
        return false;
      }
      try
      {
        localObject = getAdList();
        if (localObject != null)
        {
          if ((((ArrayList)localObject).size() > 3) || (!hasPlayStore))
          {
            prefs = paramActivity.getSharedPreferences("wasabi_ads_settings", 0);
            if (prefs.getLong("ads_activity_request_time", 0L) <= System.currentTimeMillis())
            {
              Popup.createAdPopup(paramActivity, paramActivity.getString(R.string.more_app_title_label), new AdManager.2(paramActivity)).show();
              paramActivity = prefs.edit();
              paramActivity.putLong("ads_activity_request_time", System.currentTimeMillis() + 28800000L);
              paramActivity.commit();
              return true;
            }
            paramActivity.finish();
            return true;
          }
          return false;
        }
        return false;
      }
      catch (Exception paramActivity) {}
    }
    catch (Exception paramActivity)
    {
      return false;
    }
    return false;
  }
  
  private static String retrieveStreamString(String paramString)
  {
    Object localObject = new DefaultHttpClient();
    paramString = new HttpGet(paramString);
    try
    {
      localObject = ((DefaultHttpClient)localObject).execute(paramString);
      if (((HttpResponse)localObject).getStatusLine().getStatusCode() != 200) {
        return null;
      }
      localObject = EntityUtils.toString(((HttpResponse)localObject).getEntity(), "UTF-8");
      return (String)localObject;
    }
    catch (IOException localIOException)
    {
      paramString.abort();
    }
    return null;
  }
  
  private static void saveImageCache()
  {
    Object localObject = prefs.getString("ads_cache", "");
    if (!((String)localObject).equals("")) {
      try
      {
        localObject = buildAdList((String)localObject, cid, true);
        if ((localObject != null) && (((ArrayList)localObject).size() != 0))
        {
          String[] arrayOfString = new String[((ArrayList)localObject).size()];
          int i = 0;
          for (;;)
          {
            if (i >= ((ArrayList)localObject).size())
            {
              imageLoader.saveImageCache(arrayOfString);
              return;
            }
            arrayOfString[i] = ((AdManager.AdItem)((ArrayList)localObject).get(i)).image;
            i += 1;
          }
        }
        return;
      }
      catch (Exception localException)
      {
        Log.e("AdManager", "Can't save image cache...");
      }
    }
  }
  
  public static void setListener(AdManager.OnAdListener paramOnAdListener)
  {
    adListener = paramOnAdListener;
  }
  
  private static void showAd()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (adListener != null) {}
    try
    {
      adListener.adCacheLoaded();
      int i = 100 / adPercentage;
      if ((new Random().nextInt(i) == 0) || (adListener != null)) {}
      try
      {
        adListener.adNotShowed();
        loadImageItem();
        for (;;)
        {
          return;
          String str = prefs.getString("ads_cache", "");
          if (str.equals(""))
          {
            if (adListener == null) {
              continue;
            }
            try
            {
              adListener.failToLoad();
              return;
            }
            catch (Exception localException1)
            {
              return;
            }
          }
          if (loadAdListOnly)
          {
            ArrayList localArrayList1 = buildAdList(str, cid, true);
            if (localArrayList1 == null)
            {
              if (adListener == null) {
                continue;
              }
              try
              {
                adListener.failToLoad();
                return;
              }
              catch (Exception localException2)
              {
                return;
              }
            }
            Collections.shuffle(localException2);
            if (adListener == null) {
              continue;
            }
            try
            {
              adListener.adListloaded(localException2);
              return;
            }
            catch (Exception localException3)
            {
              return;
            }
          }
          if (adType == 2)
          {
            i = 0;
            label163:
            if (i == 0) {
              break label270;
            }
          }
          Object localObject1;
          label270:
          for (ArrayList localArrayList2 = buildAdList(str, cid, true);; localObject1 = buildAdList(str, cid, false))
          {
            if (localArrayList2 != null) {
              break label284;
            }
            if (adListener == null) {
              break;
            }
            try
            {
              adListener.failToLoad();
              return;
            }
            catch (Exception localException4)
            {
              return;
            }
            if (adType == 3)
            {
              i = 1;
              break label163;
            }
            j = prefs.getInt("ads_wall_view", 0);
            if (j % 2 == 0) {}
            for (i = 1;; i = 0)
            {
              localObject1 = prefs.edit();
              ((SharedPreferences.Editor)localObject1).putInt("ads_wall_view", j + 1);
              ((SharedPreferences.Editor)localObject1).commit();
              break;
            }
          }
          label284:
          int j = i;
          if (i != 0)
          {
            j = i;
            if (((ArrayList)localObject1).size() < 2) {
              j = 0;
            }
          }
          if (j != 0) {}
          try
          {
            Collections.shuffle((List)localObject1);
            if (((ArrayList)localObject1).size() < 6) {}
            for (;;)
            {
              createAdWall((ArrayList)localObject1, bool1).show();
              localObject1 = adListener;
              if (localObject1 == null) {
                break;
              }
              try
              {
                adListener.adWallShowed();
                return;
              }
              catch (Exception localException5)
              {
                return;
              }
              bool1 = false;
            }
            i = localException5.size();
            j = prefs.getInt("ads_view", 0);
            AdManager.AdItem localAdItem = (AdManager.AdItem)localException5.get(j % i);
            SharedPreferences.Editor localEditor = prefs.edit();
            localEditor.putInt("ads_view", j + 1);
            localEditor.commit();
            if ((localAdItem.name.equals("AD")) || (localAdItem.description.equals("")) || (localAdItem.image.equals("")) || (localAdItem.url.equals("")))
            {
              AdManager.OnAdListener localOnAdListener = adListener;
              if (localOnAdListener == null) {
                continue;
              }
              try
              {
                adListener.loadThirdPartyAd();
                return;
              }
              catch (Exception localException6)
              {
                return;
              }
            }
            if (localException6.size() <= 1) {
              break label652;
            }
            Object localObject2 = buildAdList(str, cid, true);
            i = prefs.getInt("ads_current_view", 0);
            currAd = i % ((ArrayList)localObject2).size();
            if (currAd >= ((ArrayList)localObject2).size()) {
              currAd = 0;
            }
            if (((ArrayList)localObject2).size() == 1) {}
            for (bool1 = bool2;; bool1 = false)
            {
              createAd((ArrayList)localObject2, bool1).show();
              localObject2 = prefs.edit();
              ((SharedPreferences.Editor)localObject2).putInt("ads_current_view", i + 1);
              ((SharedPreferences.Editor)localObject2).commit();
              localObject2 = adListener;
              if (localObject2 == null) {
                break;
              }
              try
              {
                adListener.adShowed();
                return;
              }
              catch (Exception localException7)
              {
                return;
              }
            }
            if (adListener == null) {}
          }
          catch (Exception localException8) {}
        }
        try
        {
          adListener.failToLoad();
          return;
        }
        catch (Exception localException9) {}
      }
      catch (Exception localException10)
      {
        for (;;) {}
      }
    }
    catch (Exception localException11)
    {
      label652:
      for (;;) {}
    }
  }
  
  /* Error */
  public static boolean showAdActivity(Activity paramActivity)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 694
    //   4: invokevirtual 366	android/app/Activity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   7: checkcast 696	android/net/ConnectivityManager
    //   10: invokevirtual 700	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull +27 -> 42
    //   18: aload_2
    //   19: invokevirtual 706	android/net/NetworkInfo:getState	()Landroid/net/NetworkInfo$State;
    //   22: getstatic 712	android/net/NetworkInfo$State:CONNECTED	Landroid/net/NetworkInfo$State;
    //   25: if_acmpne +17 -> 42
    //   28: iconst_0
    //   29: invokestatic 717	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   32: astore_2
    //   33: aload_2
    //   34: invokevirtual 720	java/lang/Boolean:booleanValue	()Z
    //   37: ifeq +16 -> 53
    //   40: iconst_0
    //   41: ireturn
    //   42: iconst_1
    //   43: invokestatic 717	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   46: astore_2
    //   47: goto -14 -> 33
    //   50: astore_0
    //   51: iconst_0
    //   52: ireturn
    //   53: invokestatic 751	com/androidwasabi/ads/AdManager:getAdList	()Ljava/util/ArrayList;
    //   56: astore_2
    //   57: aload_2
    //   58: ifnull +38 -> 96
    //   61: aload_2
    //   62: invokevirtual 247	java/util/ArrayList:size	()I
    //   65: iconst_3
    //   66: if_icmpgt +11 -> 77
    //   69: getstatic 95	com/androidwasabi/ads/AdManager:hasPlayStore	Z
    //   72: istore_1
    //   73: iload_1
    //   74: ifne +20 -> 94
    //   77: aload_0
    //   78: new 185	android/content/Intent
    //   81: dup
    //   82: aload_0
    //   83: ldc_w 753
    //   86: invokespecial 223	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   89: invokevirtual 754	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   92: iconst_1
    //   93: ireturn
    //   94: iconst_0
    //   95: ireturn
    //   96: iconst_0
    //   97: ireturn
    //   98: astore_0
    //   99: iconst_0
    //   100: ireturn
    //   101: astore_0
    //   102: goto -10 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	paramActivity	Activity
    //   72	2	1	bool	boolean
    //   13	49	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	14	50	java/lang/Exception
    //   18	28	50	java/lang/Exception
    //   53	57	98	java/lang/Exception
    //   61	73	98	java/lang/Exception
    //   77	92	98	java/lang/Exception
    //   77	92	101	android/content/ActivityNotFoundException
  }
  
  public static boolean showAdActivityAtEnd(Activity paramActivity)
  {
    try
    {
      Object localObject = ((ConnectivityManager)paramActivity.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((localObject != null) && (((NetworkInfo)localObject).getState() == NetworkInfo.State.CONNECTED)) {}
      for (localObject = Boolean.valueOf(false); ((Boolean)localObject).booleanValue(); localObject = Boolean.valueOf(true)) {
        return false;
      }
      try
      {
        localObject = getAdList();
        if (localObject != null)
        {
          if ((((ArrayList)localObject).size() > 3) || (!hasPlayStore))
          {
            Popup.createAdPopup(paramActivity, paramActivity.getString(R.string.more_app_title_label), new AdManager.1(paramActivity)).show();
            return true;
          }
          return false;
        }
        return false;
      }
      catch (Exception paramActivity) {}
    }
    catch (Exception paramActivity)
    {
      return false;
    }
    return false;
  }
  
  private static void updateAd(AdManager.AdItem paramAdItem, AlertDialog paramAlertDialog)
  {
    String str1 = paramAdItem.name;
    String str2 = paramAdItem.description;
    String str3 = paramAdItem.url;
    String str4 = paramAdItem.directlink;
    paramAdItem = paramAdItem.image;
    paramAlertDialog.setTitle(str1);
    ((TextView)paramAlertDialog.findViewById(R.id.ad_description)).setText(str2);
    paramAlertDialog.setButton(-1, app.getString(R.string.ok_title_label), new AdManager.9(str3, str4));
    imageLoader.setListener(new AdManager.10(paramAlertDialog, paramAdItem));
    imageLoader.loadImage(paramAdItem, paramAdItem);
  }
  
  private static void updateAdWall(ArrayList<AdManager.AdItem> paramArrayList, AlertDialog paramAlertDialog)
  {
    AdManager.FileListAdapter localFileListAdapter = new AdManager.FileListAdapter(app, R.layout.wall_item, paramArrayList);
    ListView localListView = (ListView)paramAlertDialog.findViewById(R.id.ad_list);
    localListView.setAdapter(localFileListAdapter);
    localListView.setOnItemClickListener(new AdManager.17());
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayList.size())
      {
        imageLoader.setListener(new AdManager.18(paramAlertDialog));
        return;
      }
      imageLoader.loadImage(((AdManager.AdItem)paramArrayList.get(i)).image, Integer.valueOf(i));
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/ads/AdManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */