package com.magmamobile.mmusia;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.Toast;
import com.magmamobile.mmusia.data.LanguageBase;
import com.magmamobile.mmusia.views.PrefView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class MCommon
{
  public static String GUID = "";
  public static final String TAG = "MMUSIA";
  public static final boolean USE_DEBUG = false;
  public static Map<String, Drawable> drawableMap;
  public static String iconFileName = "icon";
  private static float mDensity = 0.0F;
  
  static
  {
    drawableMap = new HashMap();
  }
  
  public static void Log_d(String paramString) {}
  
  public static void Log_d(String paramString1, String paramString2) {}
  
  public static void Log_e(String paramString) {}
  
  public static void Log_e(String paramString1, String paramString2) {}
  
  public static void Log_i(String paramString) {}
  
  public static void Log_i(String paramString1, String paramString2) {}
  
  public static void Log_v(String paramString) {}
  
  public static void Log_v(String paramString1, String paramString2) {}
  
  public static void Log_w(String paramString) {}
  
  public static void Log_w(String paramString1, String paramString2) {}
  
  public static String alphaNum(String paramString1, String paramString2)
  {
    return paramString1.replaceAll("[^a-zA-Z0-9]", paramString2);
  }
  
  public static String alphaNumWithAccent(String paramString1, String paramString2)
  {
    return paramString1.replaceAll("[^a-zA-ZÀ-ÿ0-9]", paramString2);
  }
  
  public static List<NameValuePair> buildUrlParam(Context paramContext, int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicNameValuePair("di", getDeviceID(paramContext)));
    localArrayList.add(new BasicNameValuePair("lng", getLanguage()));
    localArrayList.add(new BasicNameValuePair("lid", paramInt));
    localArrayList.add(new BasicNameValuePair("ver", getAppVersionCode(paramContext)));
    localArrayList.add(new BasicNameValuePair("pn", getAppPackageName(paramContext)));
    localArrayList.add(new BasicNameValuePair("pm", getModelNumber()));
    localArrayList.add(new BasicNameValuePair("sw", getScreenSize(paramContext)));
    localArrayList.add(new BasicNameValuePair("sv", getSDK()));
    localArrayList.add(new BasicNameValuePair("mmver", getMMUSIAVersion()));
    if (paramBoolean) {
      localArrayList.add(new BasicNameValuePair("gu", "1"));
    }
    return localArrayList;
  }
  
  public static final int dpi(int paramInt)
  {
    if (mDensity == 1.0F) {
      return paramInt;
    }
    Log_d("dpi : value " + paramInt + " => " + (int)(paramInt * mDensity));
    return (int)(paramInt * mDensity);
  }
  
  public static final int dpiImage(int paramInt)
  {
    if (mDensity == 1.0F) {
      return paramInt;
    }
    if (mDensity == 1.5D)
    {
      Log_d("dpi : value " + paramInt + " x2 => " + (int)(paramInt * 3.0F));
      return (int)(paramInt * 3.0F);
    }
    Log_d("dpi : value " + paramInt + " => " + (int)(paramInt * mDensity));
    return (int)(paramInt * mDensity);
  }
  
  public static String generateString(InputStream paramInputStream)
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      str = localBufferedReader.readLine();
      if (str != null) {}
    }
    catch (IOException localIOException)
    {
      try
      {
        for (;;)
        {
          String str;
          paramInputStream.close();
          return localStringBuilder.toString();
          localStringBuilder.append(str);
          continue;
          localIOException = localIOException;
          localIOException.printStackTrace();
        }
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          paramInputStream.printStackTrace();
        }
      }
    }
  }
  
  public static String generateString(InputStream paramInputStream, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      try
      {
        paramString = new BufferedReader(new InputStreamReader(paramInputStream, paramString));
        str = paramString.readLine();
        if (str != null) {
          continue;
        }
        paramInputStream.close();
      }
      catch (IOException paramInputStream)
      {
        String str;
        paramInputStream.printStackTrace();
        continue;
      }
      return localStringBuilder.toString();
      localStringBuilder.append(str).append("\n");
    }
  }
  
  public static String getAppPackageName(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).packageName;
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  public static int getAppVersionCode(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public static Drawable getAssetDrawable(Activity paramActivity, String paramString)
  {
    try
    {
      paramActivity = BitmapUtils.loadDrawable(paramActivity, paramString);
      return paramActivity;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
    return null;
  }
  
  public static Drawable getAssetDrawableResize(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if (paramDrawable == null) {
      return null;
    }
    try
    {
      paramDrawable = new BitmapDrawable(Bitmap.createScaledBitmap(((BitmapDrawable)paramDrawable).getBitmap(), paramInt1, paramInt2, false));
      return paramDrawable;
    }
    catch (Exception paramDrawable)
    {
      paramDrawable.printStackTrace();
    }
    return null;
  }
  
  public static boolean getBeforeExitDontShow(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("bExitDshow", false);
  }
  
  private static String getDIDPref(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("DIDBIS", "");
  }
  
  public static final float getDensity(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics.density;
  }
  
  public static String getDeviceID(Context paramContext)
  {
    String str2;
    String str1;
    try
    {
      str2 = Settings.System.getString(paramContext.getContentResolver(), "android_id");
      if (str2 == null)
      {
        str2 = getDIDPref(paramContext);
        if (!str2.equals(""))
        {
          str1 = str2;
          if (str2 != null) {
            return str1;
          }
        }
        str1 = "emulator/" + UUID.randomUUID().toString();
        setDIDPref(paramContext, str1);
        return str1;
      }
      if (str2.toLowerCase().equals("9774d56d682e549c"))
      {
        str2 = getDIDPref(paramContext);
        if (!str2.equals(""))
        {
          str1 = str2;
          if (str2 != null) {
            return str1;
          }
        }
        str1 = "9774d56d682e549c/" + UUID.randomUUID().toString();
        setDIDPref(paramContext, str1);
        return str1;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return "";
    }
    if (str2.toLowerCase().equals("575c2ef207c21d5b"))
    {
      str2 = getDIDPref(paramContext);
      if (!str2.equals(""))
      {
        str1 = str2;
        if (str2 != null) {}
      }
      else
      {
        str1 = "575c2ef207c21d5b/" + UUID.randomUUID().toString();
        setDIDPref(paramContext, str1);
        return str1;
      }
    }
    else if (str2.toLowerCase().equals("22a000002457bbd5"))
    {
      str2 = getDIDPref(paramContext);
      if (!str2.equals(""))
      {
        str1 = str2;
        if (str2 != null) {}
      }
      else
      {
        str1 = "22a000002457bbd5/" + UUID.randomUUID().toString();
        setDIDPref(paramContext, str1);
        return str1;
      }
    }
    else if (str2.toLowerCase().equals("200146e3ff6bd264"))
    {
      str2 = getDIDPref(paramContext);
      if (!str2.equals(""))
      {
        str1 = str2;
        if (str2 != null) {}
      }
      else
      {
        str1 = "200146e3ff6bd264/" + UUID.randomUUID().toString();
        setDIDPref(paramContext, str1);
        return str1;
      }
    }
    else
    {
      str1 = str2;
      if (str2.toLowerCase().equals("emulator"))
      {
        str2 = getDIDPref(paramContext);
        if (!str2.equals(""))
        {
          str1 = str2;
          if (str2 != null) {}
        }
        else
        {
          str1 = "Emulator/" + UUID.randomUUID().toString();
          setDIDPref(paramContext, str1);
        }
      }
    }
    return str1;
  }
  
  public static String getLanguage()
  {
    if (MMUSIA.LANGUAGE == null) {
      MMUSIA.LANGUAGE = "en";
    }
    return MMUSIA.LANGUAGE;
  }
  
  public static int getLatestPromoIDPref1(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("PROMOID1", 0);
  }
  
  public static int getLatestPromoIDPref2(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("PROMOID2", 0);
  }
  
  public static int getLatestPromoIDPref3(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("PROMOID3", 0);
  }
  
  public static String getMMUSIAVersion()
  {
    return "5";
  }
  
  public static String getModelNumber()
  {
    return Build.MODEL;
  }
  
  public static String getOperatorName(Context paramContext)
  {
    return ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkOperatorName();
  }
  
  public static boolean getPrefNotifStatus(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getBoolean("mmusianotif", true);
  }
  
  public static int getPromoCount(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("PromoCount", 0);
  }
  
  public static String getSDK()
  {
    return Build.VERSION.SDK;
  }
  
  public static String getScreenSize(Context paramContext)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    return paramContext.getWidth() + "x" + paramContext.getHeight();
  }
  
  public static int getlaunchCount(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("LaunchCount", 0);
  }
  
  public static boolean isSDKAPI4Mini()
  {
    boolean bool = false;
    try
    {
      int i = Integer.parseInt(Build.VERSION.SDK);
      if (i >= 4) {
        bool = true;
      }
      return bool;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
    }
    return false;
  }
  
  public static void launchCountIncrement(Context paramContext)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    localEditor.putInt("LaunchCount", getlaunchCount(paramContext) + 1);
    localEditor.commit();
  }
  
  public static void openMarket(Context paramContext, String paramString)
  {
    try
    {
      ((Activity)paramContext).startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + paramString)), 2000);
      return;
    }
    catch (Exception paramString)
    {
      Toast.makeText(paramContext, LanguageBase.MARKET_NOT_FOUND, 2000).show();
    }
  }
  
  public static void openMarketLink(Context paramContext, String paramString)
  {
    try
    {
      ((Activity)paramContext).startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse(paramString)), 2000);
      return;
    }
    catch (Exception paramString)
    {
      Toast.makeText(paramContext, LanguageBase.MARKET_NOT_FOUND, 2000).show();
    }
  }
  
  public static void openUrlPage(Context paramContext, String paramString)
  {
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    ((Activity)paramContext).startActivityForResult(paramString, 9998);
  }
  
  public static void promoCountIncrement(Context paramContext)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    localEditor.putInt("PromoCount", getPromoCount(paramContext) + 1);
    localEditor.commit();
  }
  
  public static void resetPromoCount(Context paramContext)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("PromoCount", 0);
    paramContext.commit();
  }
  
  public static void setBeforeExitDontShow(Context paramContext, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("bExitDshow", paramBoolean);
    paramContext.commit();
  }
  
  private static void setDIDPref(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("DIDBIS", paramString);
    paramContext.commit();
  }
  
  public static void setLatestPromoIDPref1(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("PROMOID1", paramInt);
    paramContext.commit();
  }
  
  public static void setLatestPromoIDPref2(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("PROMOID2", paramInt);
    paramContext.commit();
  }
  
  public static void setLatestPromoIDPref3(Context paramContext, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("PROMOID3", paramInt);
    paramContext.commit();
  }
  
  public static void setPrefNotifStatus(Context paramContext, boolean paramBoolean)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("mmusianotif", paramBoolean);
    paramContext.commit();
  }
  
  public static void showPrefs(Context paramContext)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramContext);
    PrefView localPrefView = new PrefView(paramContext);
    final CheckBox localCheckBox = (CheckBox)localPrefView.findViewById(MMUSIA.RES_ID_PREF_CHECK_ENABLE);
    localCheckBox.setChecked(getPrefNotifStatus(paramContext));
    localBuilder.setView(localPrefView);
    localBuilder.setCancelable(true);
    localBuilder.setTitle(LanguageBase.DIALOG_SETTINGS_TITLE);
    localBuilder.setPositiveButton(LanguageBase.DIALOG_SETTINGS_CLOSE, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        MCommon.setPrefNotifStatus(MCommon.this, localCheckBox.isChecked());
        MMUSIA.activateNews(MCommon.this, localCheckBox.isChecked());
      }
    });
    localBuilder.show();
  }
  
  public static final void useDpi(Context paramContext)
  {
    mDensity = getDensity(paramContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/mmusia/MCommon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */