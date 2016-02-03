package com.magmamobile.mmusia;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.magmamobile.mmusia.activities.MMUSIAActivity;
import com.magmamobile.mmusia.activities.MMUSIABeforeExitActivity;
import com.magmamobile.mmusia.adapters.MoreGamesListAdapterEx;
import com.magmamobile.mmusia.data.LanguageBase;
import com.magmamobile.mmusia.parser.data.ApiBase;
import com.magmamobile.mmusia.parser.parsers.JSonNews;
import com.magmamobile.mmusia.utils.MMUtils;
import com.magmamobile.mmusia.views.MoreGamesDialogView;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;

public class MMUSIA
{
  public static String LANGUAGE;
  public static int RES_ID_BEFOREEXIT_BTN_CLOSE = 0;
  public static int RES_ID_BEFOREEXIT_CHK_DONTSHOW = 0;
  public static int RES_ID_IMG_MOREGAMES_HEAD = 0;
  public static int RES_ID_ITEM_DATE = 0;
  public static int RES_ID_ITEM_DESC = 0;
  public static int RES_ID_ITEM_IMG = 0;
  public static int RES_ID_ITEM_LINEARITEM = 0;
  public static int RES_ID_ITEM_TITLE = 0;
  public static int RES_ID_LISTVIEW_APPUPDATE = 10000;
  public static int RES_ID_LISTVIEW_MAINTAB = 0;
  public static int RES_ID_LISTVIEW_MOREGAMES = 0;
  public static int RES_ID_LISTVIEW_NEWSLIST = 10001;
  public static int RES_ID_MOREGAMES_ITEM_FREE = 0;
  public static int RES_ID_PREF_CHECK_ENABLE = 0;
  public static int RES_ID_TAB_NEWS = 0;
  public static int RES_ID_TAB_UPDATE = 0;
  public static int RES_ID_TITLE_MOREGAMES_HEAD = 0;
  public static String RefererComplement;
  public static boolean _notifAllowed = false;
  public static ApiBase api;
  public static ApiBase apiLog;
  public static final String apiUrl = "http://api.magmamobile.com/api/mmusia.ashx";
  public static int appIconID;
  public static MMUSIAHandler handler;
  private static NotificationManager mNotificationManager;
  private static String packageName = null;
  private static float screenDensity;
  public static Typeface tf;
  
  static
  {
    RES_ID_LISTVIEW_MAINTAB = 10002;
    RES_ID_TAB_UPDATE = 10003;
    RES_ID_TAB_NEWS = 10004;
    RES_ID_ITEM_LINEARITEM = 10005;
    RES_ID_ITEM_TITLE = 10006;
    RES_ID_ITEM_DATE = 10007;
    RES_ID_ITEM_DESC = 10008;
    RES_ID_ITEM_IMG = 10009;
    RES_ID_LISTVIEW_MOREGAMES = 10010;
    RES_ID_IMG_MOREGAMES_HEAD = 10011;
    RES_ID_TITLE_MOREGAMES_HEAD = 10012;
    RES_ID_MOREGAMES_ITEM_FREE = 10013;
    RES_ID_BEFOREEXIT_BTN_CLOSE = 10014;
    RES_ID_BEFOREEXIT_CHK_DONTSHOW = 10015;
    RES_ID_PREF_CHECK_ENABLE = 0;
    LANGUAGE = null;
    appIconID = 0;
    RefererComplement = "";
    tf = null;
    handler = null;
    screenDensity = 0.0F;
  }
  
  /* Error */
  public static Drawable ImageOperations(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 142	java/net/URL
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 145	java/net/URL:<init>	(Ljava/lang/String;)V
    //   10: invokevirtual 149	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   13: checkcast 151	java/net/HttpURLConnection
    //   16: astore_3
    //   17: iconst_1
    //   18: invokestatic 155	java/net/HttpURLConnection:setFollowRedirects	(Z)V
    //   21: aload_3
    //   22: sipush 3000
    //   25: invokevirtual 159	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   28: aload_3
    //   29: sipush 3000
    //   32: invokevirtual 162	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   35: aload_3
    //   36: invokevirtual 165	java/net/HttpURLConnection:connect	()V
    //   39: aload_3
    //   40: invokevirtual 169	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   43: astore 4
    //   45: aload_2
    //   46: astore_1
    //   47: aload 4
    //   49: ifnull +19 -> 68
    //   52: aload 4
    //   54: invokestatic 173	com/magmamobile/mmusia/MMUSIA:readBytes	(Ljava/io/InputStream;)[B
    //   57: astore_1
    //   58: aload 4
    //   60: invokevirtual 178	java/io/InputStream:close	()V
    //   63: aload_1
    //   64: invokestatic 182	com/magmamobile/mmusia/MMUSIA:loadResizedBitmap	([B)Landroid/graphics/drawable/Drawable;
    //   67: astore_1
    //   68: aload_3
    //   69: invokevirtual 185	java/net/HttpURLConnection:disconnect	()V
    //   72: aload_1
    //   73: areturn
    //   74: astore_1
    //   75: aload_1
    //   76: invokevirtual 188	java/lang/OutOfMemoryError:printStackTrace	()V
    //   79: aload_2
    //   80: astore_1
    //   81: goto -13 -> 68
    //   84: astore_1
    //   85: new 190	java/lang/StringBuilder
    //   88: dup
    //   89: ldc -64
    //   91: invokespecial 193	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   94: aload_0
    //   95: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 206	com/magmamobile/mmusia/MCommon:Log_e	(Ljava/lang/String;)V
    //   104: aconst_null
    //   105: areturn
    //   106: astore_1
    //   107: aload_1
    //   108: invokevirtual 207	java/lang/Exception:printStackTrace	()V
    //   111: aload_2
    //   112: astore_1
    //   113: goto -45 -> 68
    //   116: astore_1
    //   117: new 190	java/lang/StringBuilder
    //   120: dup
    //   121: ldc -47
    //   123: invokespecial 193	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   126: aload_1
    //   127: invokevirtual 212	java/io/IOException:getMessage	()Ljava/lang/String;
    //   130: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 206	com/magmamobile/mmusia/MCommon:Log_e	(Ljava/lang/String;)V
    //   139: aload_0
    //   140: invokestatic 206	com/magmamobile/mmusia/MCommon:Log_e	(Ljava/lang/String;)V
    //   143: aconst_null
    //   144: areturn
    //   145: astore_1
    //   146: new 190	java/lang/StringBuilder
    //   149: dup
    //   150: ldc -42
    //   152: invokespecial 193	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   155: aload_1
    //   156: invokevirtual 215	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   159: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 206	com/magmamobile/mmusia/MCommon:Log_e	(Ljava/lang/String;)V
    //   168: aload_0
    //   169: invokestatic 206	com/magmamobile/mmusia/MCommon:Log_e	(Ljava/lang/String;)V
    //   172: aconst_null
    //   173: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	paramString	String
    //   46	27	1	localObject1	Object
    //   74	2	1	localOutOfMemoryError	OutOfMemoryError
    //   80	1	1	localObject2	Object
    //   84	1	1	localMalformedURLException	java.net.MalformedURLException
    //   106	2	1	localException1	Exception
    //   112	1	1	localObject3	Object
    //   116	11	1	localIOException	IOException
    //   145	11	1	localException2	Exception
    //   1	111	2	localObject4	Object
    //   16	53	3	localHttpURLConnection	java.net.HttpURLConnection
    //   43	16	4	localInputStream	InputStream
    // Exception table:
    //   from	to	target	type
    //   63	68	74	java/lang/OutOfMemoryError
    //   2	45	84	java/net/MalformedURLException
    //   52	63	84	java/net/MalformedURLException
    //   63	68	84	java/net/MalformedURLException
    //   68	72	84	java/net/MalformedURLException
    //   75	79	84	java/net/MalformedURLException
    //   107	111	84	java/net/MalformedURLException
    //   63	68	106	java/lang/Exception
    //   2	45	116	java/io/IOException
    //   52	63	116	java/io/IOException
    //   63	68	116	java/io/IOException
    //   68	72	116	java/io/IOException
    //   75	79	116	java/io/IOException
    //   107	111	116	java/io/IOException
    //   2	45	145	java/lang/Exception
    //   52	63	145	java/lang/Exception
    //   68	72	145	java/lang/Exception
    //   75	79	145	java/lang/Exception
    //   107	111	145	java/lang/Exception
  }
  
  public static void LAppOfTheDay(Context paramContext, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("di", MCommon.getDeviceID(paramContext)));
    localArrayList.add(new BasicNameValuePair("aodid", paramInt));
    localArrayList.add(new BasicNameValuePair("pn", MCommon.getAppPackageName(paramContext)));
    localArrayList.add(new BasicNameValuePair("a", "appoday"));
    try
    {
      apiLog = JSonNews.loadItems(paramContext, "http://api.magmamobile.com/api/mmusia.ashx", localArrayList, true);
      return;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void LNews(Context paramContext, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("di", MCommon.getDeviceID(paramContext)));
    localArrayList.add(new BasicNameValuePair("nid", paramInt));
    localArrayList.add(new BasicNameValuePair("a", "click"));
    try
    {
      apiLog = JSonNews.loadItems(paramContext, "http://api.magmamobile.com/api/mmusia.ashx", localArrayList, true);
      return;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void LPromoDialog(Context paramContext, String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("di", MCommon.getDeviceID(paramContext)));
    localArrayList.add(new BasicNameValuePair("prid", paramInt));
    localArrayList.add(new BasicNameValuePair("pn", paramString));
    localArrayList.add(new BasicNameValuePair("a", "clickpromo"));
    localArrayList.add(new BasicNameValuePair("dlg", "1"));
    try
    {
      apiLog = JSonNews.loadItems(paramContext, "http://api.magmamobile.com/api/mmusia.ashx", localArrayList, true);
      return;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void LUpdate(Context paramContext, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("di", MCommon.getDeviceID(paramContext)));
    localArrayList.add(new BasicNameValuePair("pn", paramString));
    localArrayList.add(new BasicNameValuePair("a", "click"));
    try
    {
      apiLog = JSonNews.loadItems(paramContext, "http://api.magmamobile.com/api/mmusia.ashx", localArrayList, true);
      return;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void LUpdateDialog(Context paramContext, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("di", MCommon.getDeviceID(paramContext)));
    localArrayList.add(new BasicNameValuePair("pn", paramString));
    localArrayList.add(new BasicNameValuePair("a", "click"));
    localArrayList.add(new BasicNameValuePair("dlg", "1"));
    try
    {
      apiLog = JSonNews.loadItems(paramContext, "http://api.magmamobile.com/api/mmusia.ashx", localArrayList, true);
      return;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void activateNews(Context paramContext, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("di", MCommon.getDeviceID(paramContext)));
    if (paramBoolean) {
      localArrayList.add(new BasicNameValuePair("a", "activate"));
    }
    for (;;)
    {
      try
      {
        apiLog = JSonNews.loadItems(paramContext, "http://api.magmamobile.com/api/mmusia.ashx", localArrayList, true);
        return;
      }
      catch (JSONException paramContext)
      {
        paramContext.printStackTrace();
      }
      localArrayList.add(new BasicNameValuePair("a", "desactivate"));
    }
  }
  
  private static final MMUSIABundle createDialogView(Context paramContext)
  {
    MMUSIABundle localMMUSIABundle = new MMUSIABundle(null);
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    ImageView localImageView = new ImageView(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    localImageView.setImageResource(17301659);
    localLayoutParams.setMargins(dpii(10.0F), dpii(10.0F), dpii(10.0F), dpii(10.0F));
    localLayoutParams.width = dpii(48.0F);
    localLayoutParams.height = dpii(48.0F);
    localLinearLayout.addView(localImageView, localLayoutParams);
    paramContext = new TextView(paramContext);
    localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    localLayoutParams.setMargins(dpii(10.0F), dpii(10.0F), dpii(10.0F), dpii(10.0F));
    paramContext.setGravity(16);
    paramContext.setTextSize(2, 15.0F);
    localLinearLayout.addView(paramContext, localLayoutParams);
    localMMUSIABundle.viewImage = localImageView;
    localMMUSIABundle.viewText = paramContext;
    localMMUSIABundle.viewContent = localLinearLayout;
    return localMMUSIABundle;
  }
  
  private static final int dpii(float paramFloat)
  {
    return (int)(screenDensity * paramFloat);
  }
  
  public static void getLatestNews(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        api = JSonNews.loadItems(paramContext, "http://api.magmamobile.com/api/mmusia.ashx", MCommon.buildUrlParam(paramContext, 0, paramBoolean2), false);
        if (api == null) {
          return;
        }
        if (paramBoolean1)
        {
          Notification localNotification;
          String str1;
          String str2;
          Object localObject;
          if ((api.HasNewNews == 1) && (_notifAllowed))
          {
            MCommon.Log_d("NOTIF !!!");
            localNotification = new Notification(paramContext.getResources().getIdentifier(MCommon.iconFileName, "drawable", paramContext.getPackageName()), "Magma Mobile News", System.currentTimeMillis());
            str1 = LanguageBase.NOTIF_NEWS_TITLE;
            str2 = LanguageBase.NOTIF_NEWS_DESC;
            localObject = new Intent(paramContext, MMUSIAActivity.class);
            ((Intent)localObject).putExtra("tab", "news");
            localObject = PendingIntent.getActivity(paramContext, 0, (Intent)localObject, 0);
            localNotification.flags = 16;
            localNotification.setLatestEventInfo(paramContext, str1, str2, (PendingIntent)localObject);
            mNotificationManager.notify(999652, localNotification);
            MCommon.Log_d("NOTIF END !!!");
          }
          if ((api.HasNewUpdates == 1) && (_notifAllowed))
          {
            localNotification = new Notification(paramContext.getResources().getIdentifier(MCommon.iconFileName, "drawable", paramContext.getPackageName()), "Update available", System.currentTimeMillis());
            str1 = LanguageBase.NOTIF_UPDATE_TITLE;
            str2 = LanguageBase.NOTIF_UPDATE_DESC;
            localObject = new Intent(paramContext, MMUSIAActivity.class);
            ((Intent)localObject).putExtra("tab", "app");
            localObject = PendingIntent.getActivity(paramContext, 0, (Intent)localObject, 0);
            localNotification.flags = 16;
            localNotification.setLatestEventInfo(paramContext, str1, str2, (PendingIntent)localObject);
            mNotificationManager.notify(999652, localNotification);
          }
        }
        if (api.HasNewVersionAvailable == 1)
        {
          popupNewVersionDialog(paramContext);
          return;
        }
      }
      catch (JSONException paramContext)
      {
        paramContext.printStackTrace();
        return;
        if ((!_notifAllowed) || (MCommon.getlaunchCount(paramContext) <= 1)) {
          break;
        }
        j = 0;
        i = j;
        if (api.promoId > 0)
        {
          i = j;
          if (api.promoId != MCommon.getLatestPromoIDPref1(paramContext))
          {
            if (MMUtils.isPackageNameInDevice(paramContext, api.promoPName)) {
              break label603;
            }
            MCommon.resetPromoCount(paramContext);
            i = 1;
            popupPromoDialog(paramContext, api, 1);
            MCommon.setLatestPromoIDPref1(paramContext, api.promoId);
            MCommon.setLatestPromoIDPref2(paramContext, 0);
            MCommon.setLatestPromoIDPref3(paramContext, 0);
          }
        }
        j = i;
        if (api.promoId2 > 0)
        {
          j = i;
          if (i == 0)
          {
            j = i;
            if (MCommon.getPromoCount(paramContext) % 3 == 0)
            {
              j = i;
              if (api.promoId2 != MCommon.getLatestPromoIDPref2(paramContext))
              {
                if (MMUtils.isPackageNameInDevice(paramContext, api.promoPName2)) {
                  break label650;
                }
                MCommon.resetPromoCount(paramContext);
                j = 1;
                popupPromoDialog(paramContext, api, 2);
                MCommon.setLatestPromoIDPref2(paramContext, api.promoId2);
              }
            }
          }
        }
        if ((api.promoId3 > 0) && (j == 0) && (MCommon.getPromoCount(paramContext) % 3 == 0) && (api.promoId3 != MCommon.getLatestPromoIDPref3(paramContext)))
        {
          if (MMUtils.isPackageNameInDevice(paramContext, api.promoPName3)) {
            break label698;
          }
          MCommon.resetPromoCount(paramContext);
          popupPromoDialog(paramContext, api, 3);
          MCommon.setLatestPromoIDPref3(paramContext, api.promoId3);
        }
        MCommon.Log_d("Modulo : " + MCommon.getPromoCount(paramContext) + "%3=" + MCommon.getPromoCount(paramContext) % 3);
        MCommon.promoCountIncrement(paramContext);
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
      label603:
      MCommon.Log_w(api.promoPName + " ALREADY EXISTS");
      MCommon.resetPromoCount(paramContext);
      MCommon.setLatestPromoIDPref1(paramContext, api.promoId);
      int i = 0;
      continue;
      label650:
      MCommon.Log_w(api.promoPName2 + " ALREADY EXISTS");
      MCommon.resetPromoCount(paramContext);
      MCommon.setLatestPromoIDPref2(paramContext, api.promoId2);
      int j = 0;
      continue;
      label698:
      MCommon.Log_w(api.promoPName3 + " ALREADY EXISTS");
      MCommon.resetPromoCount(paramContext);
      MCommon.setLatestPromoIDPref3(paramContext, api.promoId3);
    }
  }
  
  public static Typeface getTypeFace()
  {
    if (tf != null) {
      return tf;
    }
    return Typeface.DEFAULT;
  }
  
  public static void lClickBeforeExit(Context paramContext, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("di", MCommon.getDeviceID(paramContext)));
    localArrayList.add(new BasicNameValuePair("pn", MCommon.getAppPackageName(paramContext)));
    localArrayList.add(new BasicNameValuePair("pn2", paramString));
    localArrayList.add(new BasicNameValuePair("a", "exit"));
    try
    {
      apiLog = JSonNews.loadItems(paramContext, "http://api.magmamobile.com/api/mmusia.ashx", localArrayList, true);
      return;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void lClickMoreApp(Context paramContext, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("di", MCommon.getDeviceID(paramContext)));
    localArrayList.add(new BasicNameValuePair("pn", MCommon.getAppPackageName(paramContext)));
    localArrayList.add(new BasicNameValuePair("pn2", paramString));
    localArrayList.add(new BasicNameValuePair("a", "moregame"));
    try
    {
      apiLog = JSonNews.loadItems(paramContext, "http://api.magmamobile.com/api/mmusia.ashx", localArrayList, true);
      return;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static final void launch(Activity paramActivity, int paramInt)
  {
    paramActivity.startActivityForResult(new Intent(paramActivity, MMUSIAActivity.class), paramInt);
  }
  
  public static final void launchBeforeExit(Activity paramActivity, int paramInt)
  {
    paramActivity.startActivityForResult(new Intent(paramActivity, MMUSIABeforeExitActivity.class), paramInt);
  }
  
  public static final void launchBeforeExitNoResult(Activity paramActivity)
  {
    paramActivity.startActivity(new Intent(paramActivity, MMUSIABeforeExitActivity.class));
  }
  
  private static final void loadNotifIconAsync(MMUSIABundle paramMMUSIABundle, final String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return;
    }
    new Thread()
    {
      public void run()
      {
        MMUSIA.this.drawable = MMUSIA.ImageOperations(paramString);
        if (MMUSIA.this.drawable != null) {
          MMUSIA.handler.sendMessage(MMUSIA.handler.obtainMessage(256, MMUSIA.this));
        }
      }
    }.start();
  }
  
  public static Drawable loadResizedBitmap(byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
    Object localObject1 = localObject2;
    if (localOptions.outHeight > 0)
    {
      localObject1 = localObject2;
      if (localOptions.outWidth > 0) {
        localOptions.inJustDecodeBounds = false;
      }
    }
    for (localOptions.inSampleSize = 1;; localOptions.inSampleSize += 1) {
      if ((localOptions.outWidth / localOptions.inSampleSize <= 64) || (localOptions.outHeight / localOptions.inSampleSize <= 64))
      {
        localObject1 = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
        return new BitmapDrawable((Bitmap)localObject1);
      }
    }
  }
  
  public static void notifNewVersionDialogThread(Context paramContext)
  {
    try
    {
      MMUSIABundle localMMUSIABundle = createDialogView(paramContext);
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramContext);
      localBuilder.setCancelable(true);
      if (appIconID != 0) {
        localMMUSIABundle.viewImage.setImageResource(appIconID);
      }
      localBuilder.setTitle(LanguageBase.DIALOG_UPDATE_TITLE);
      localMMUSIABundle.viewText.setText(LanguageBase.DIALOG_UPDATE_MESSAGE);
      localBuilder.setView(localMMUSIABundle.viewContent);
      localBuilder.setPositiveButton(LanguageBase.DIALOG_UPDATE_YES, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          MMUSIA.LUpdateDialog(MMUSIA.this, MCommon.getAppPackageName(MMUSIA.this));
          MCommon.openMarket(MMUSIA.this, MCommon.getAppPackageName(MMUSIA.this) + "&referrer=utm_source%3DMMUSIA%26utm_medium%3DMMUSIADialogUpdate%26utm_campaign%3DMMUSIADialogUpdate");
        }
      });
      localBuilder.setNegativeButton(LanguageBase.DIALOG_UPDATE_NO, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      localBuilder.setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      localBuilder.show();
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void notifPromoDialogThread(Context paramContext, ApiBase paramApiBase, final int paramInt)
  {
    String str1 = "";
    String str2 = "";
    Object localObject = "";
    final String str3 = "";
    int i = 0;
    switch (paramInt)
    {
    default: 
      paramInt = i;
      paramApiBase = (ApiBase)localObject;
    }
    for (;;)
    {
      try
      {
        localObject = new AlertDialog.Builder(paramContext);
        ((AlertDialog.Builder)localObject).setCancelable(true);
        MMUSIABundle localMMUSIABundle = createDialogView(paramContext);
        localMMUSIABundle.viewText.setText(paramApiBase);
        ((AlertDialog.Builder)localObject).setView(localMMUSIABundle.viewContent);
        ((AlertDialog.Builder)localObject).setTitle(str2);
        ((AlertDialog.Builder)localObject).setPositiveButton(LanguageBase.DIALOG_UPDATE_YES, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            MMUSIA.LPromoDialog(MMUSIA.this, MCommon.getAppPackageName(MMUSIA.this), paramInt);
            MCommon.openMarketLink(MMUSIA.this, str3);
          }
        });
        ((AlertDialog.Builder)localObject).setNegativeButton(LanguageBase.DIALOG_UPDATE_NO, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        ((AlertDialog.Builder)localObject).setOnCancelListener(new DialogInterface.OnCancelListener()
        {
          public void onCancel(DialogInterface paramAnonymousDialogInterface) {}
        });
        ((AlertDialog.Builder)localObject).show();
        loadNotifIconAsync(localMMUSIABundle, str1);
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
      str1 = paramApiBase.promoIconUrl;
      str2 = paramApiBase.promoTitle;
      localObject = paramApiBase.promoDesc;
      str3 = paramApiBase.promoUrl;
      paramInt = paramApiBase.promoId;
      paramApiBase = (ApiBase)localObject;
      continue;
      str1 = paramApiBase.promoIconUrl2;
      str2 = paramApiBase.promoTitle2;
      localObject = paramApiBase.promoDesc2;
      str3 = paramApiBase.promoUrl2;
      paramInt = paramApiBase.promoId2;
      paramApiBase = (ApiBase)localObject;
      continue;
      str1 = paramApiBase.promoIconUrl3;
      str2 = paramApiBase.promoTitle3;
      localObject = paramApiBase.promoDesc3;
      str3 = paramApiBase.promoUrl3;
      paramInt = paramApiBase.promoId3;
      paramApiBase = (ApiBase)localObject;
    }
  }
  
  public static final void openAppOfTheDay(Context paramContext)
  {
    try
    {
      if (!api.appodayUrl.equals(""))
      {
        if ((!api.appodayUrl.startsWith("http://")) && (!api.appodayUrl.startsWith("https://"))) {
          break label65;
        }
        MCommon.openUrlPage(paramContext, api.appodayUrl);
      }
      for (;;)
      {
        LAppOfTheDay(paramContext, api.appodayId);
        return;
        label65:
        MCommon.openMarketLink(paramContext, api.appodayUrl + RefererComplement);
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static final void ping(Context paramContext) {}
  
  private static final void popupNewVersionDialog(Context paramContext)
  {
    handler.post(new Runnable()
    {
      public void run()
      {
        MMUSIA.notifNewVersionDialogThread(MMUSIA.this);
      }
    });
  }
  
  private static final void popupPromoDialog(Context paramContext, final ApiBase paramApiBase, final int paramInt)
  {
    handler.post(new Runnable()
    {
      public void run()
      {
        MMUSIA.notifPromoDialogThread(MMUSIA.this, paramApiBase, paramInt);
      }
    });
  }
  
  public static byte[] readBytes(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['Ѐ'];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        return localByteArrayOutputStream.toByteArray();
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  public static void setTypeFace(Typeface paramTypeface)
  {
    tf = paramTypeface;
  }
  
  public static void showMoreGames(Activity paramActivity)
  {
    MCommon.useDpi(paramActivity);
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramActivity);
    AlertDialog localAlertDialog = localBuilder.create();
    MoreGamesDialogView localMoreGamesDialogView = new MoreGamesDialogView(paramActivity);
    localMoreGamesDialogView.setBackgroundColor(-1);
    localMoreGamesDialogView.setDrawingCacheBackgroundColor(-1);
    ListView localListView = (ListView)localMoreGamesDialogView.findViewById(RES_ID_LISTVIEW_MOREGAMES);
    MoreGamesListAdapterEx localMoreGamesListAdapterEx = new MoreGamesListAdapterEx(paramActivity);
    if (api != null)
    {
      localMoreGamesListAdapterEx.setData(api.moregames);
      MCommon.Log_e("MMUSIA MORE GAMES LIST : " + api.moregames.length);
    }
    try
    {
      for (;;)
      {
        localListView.setAdapter(localMoreGamesListAdapterEx);
        localListView.setBackgroundColor(16777215);
        localListView.setCacheColorHint(-1);
        localAlertDialog.getWindow().setFlags(1024, 1024);
        localAlertDialog.setView(localMoreGamesDialogView);
        localAlertDialog.setIcon(paramActivity.getResources().getIdentifier(MCommon.iconFileName, "drawable", paramActivity.getPackageName()));
        localAlertDialog.setCancelable(true);
        localAlertDialog.setTitle(LanguageBase.DIALOG_MOREGAMES_TITLE);
        localBuilder.setPositiveButton(LanguageBase.DIALOG_SETTINGS_CLOSE, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        localAlertDialog.show();
        localListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {}
        });
        return;
        MCommon.Log_e("MMUSIA EMPTY MORE GAMES LIST");
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        localIllegalStateException.printStackTrace();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void Init(Context paramContext, String paramString1, String paramString2)
  {
    Init(paramContext, paramString1, paramString2, true);
  }
  
  public void Init(final Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    MCommon.Log_i("MMUSIA INIT");
    Display localDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplay.getMetrics(localDisplayMetrics);
    screenDensity = localDisplayMetrics.density;
    packageName = paramContext.getPackageName();
    _notifAllowed = paramBoolean;
    RefererComplement = paramString2;
    handler = new MMUSIAHandler(null);
    appIconID = paramContext.getResources().getIdentifier("app_icon", "drawable", packageName);
    if (appIconID == 0) {
      appIconID = paramContext.getResources().getIdentifier("icon", "drawable", packageName);
    }
    if (paramString1.equals("fr")) {
      LanguageBase.setLanguageFR();
    }
    for (LANGUAGE = "fr";; LANGUAGE = "en")
    {
      mNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
      new Thread()
      {
        public void run()
        {
          boolean bool2 = false;
          Context localContext = paramContext;
          boolean bool1;
          if (MCommon.getPrefNotifStatus(paramContext))
          {
            bool1 = true;
            if (!MCommon.getPrefNotifStatus(paramContext)) {
              break label48;
            }
          }
          for (;;)
          {
            MMUSIA.getLatestNews(localContext, bool1, bool2);
            MMUSIA.ping(paramContext);
            return;
            bool1 = false;
            break;
            label48:
            bool2 = true;
          }
        }
      }.start();
      MCommon.launchCountIncrement(paramContext);
      return;
      LanguageBase.setLanguageEN();
    }
  }
  
  private static class MMUSIABundle
  {
    public Drawable drawable;
    public LinearLayout viewContent;
    public ImageView viewImage;
    public TextView viewText;
  }
  
  private static class MMUSIAHandler
    extends Handler
  {
    public void handleMessage(Message paramMessage)
    {
      try
      {
        if (paramMessage.what == 256)
        {
          paramMessage = (MMUSIA.MMUSIABundle)paramMessage.obj;
          paramMessage.viewImage.setImageDrawable(paramMessage.drawable);
          paramMessage.viewImage.setVisibility(0);
        }
        return;
      }
      catch (Exception paramMessage)
      {
        paramMessage.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/mmusia/MMUSIA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */