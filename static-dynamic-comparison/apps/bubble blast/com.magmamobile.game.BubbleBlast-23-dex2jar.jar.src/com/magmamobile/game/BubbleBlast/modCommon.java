package com.magmamobile.game.BubbleBlast;

import android.app.Activity;
import android.app.AlertDialog;
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
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.provider.Settings.System;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import com.magmamobile.game.BubbleBlast.utils.GoogleAnalytics;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.UUID;

public class modCommon
{
  public static String GUID = "";
  private static final String TAG = "BubbleBlast";
  public static final boolean USE_DEBUG = false;
  private static final char[] charTab = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
  private static float mDensity = 0.0F;
  public static final boolean useAnalytics = true;
  
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
  
  public static String XorDecrypt(byte[] paramArrayOfByte, String paramString)
  {
    paramString = paramString.getBytes();
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte.length) {
        return new String(paramArrayOfByte);
      }
      paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] ^ paramString[j]));
      j = (j + 1) % paramString.length;
      i += 1;
    }
  }
  
  public static byte[] XorEncrypt(String paramString1, String paramString2)
  {
    paramString1 = paramString1.getBytes();
    paramString2 = paramString2.getBytes();
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (i >= paramString1.length) {
        return paramString1;
      }
      paramString1[i] = ((byte)(paramString1[i] ^ paramString2[j]));
      j = (j + 1) % paramString2.length;
      i += 1;
    }
  }
  
  public static byte[] base64Decode(String paramString)
  {
    int i = 0;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int j = paramString.length();
    for (;;)
    {
      if ((i >= j) || (paramString.charAt(i) > ' ')) {
        if (i != j) {
          break label49;
        }
      }
      label49:
      int k;
      do
      {
        do
        {
          return localByteArrayOutputStream.toByteArray();
          i += 1;
          break;
          k = (decode(paramString.charAt(i)) << 18) + (decode(paramString.charAt(i + 1)) << 12) + (decode(paramString.charAt(i + 2)) << 6) + decode(paramString.charAt(i + 3));
          localByteArrayOutputStream.write(k >> 16 & 0xFF);
        } while (paramString.charAt(i + 2) == '=');
        localByteArrayOutputStream.write(k >> 8 & 0xFF);
      } while (paramString.charAt(i + 3) == '=');
      localByteArrayOutputStream.write(k & 0xFF);
      i += 4;
    }
  }
  
  public static String base64Encode(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length * 3 / 2);
    int m = paramArrayOfByte.length;
    int i = 0;
    int j = 0;
    if (i > m - 3)
    {
      if (i != 0 + m - 2) {
        break label260;
      }
      i = (paramArrayOfByte[i] & 0xFF) << 16 | (paramArrayOfByte[(i + 1)] & 0xFF) << 8;
      localStringBuffer.append(charTab[(i >> 18 & 0x3F)]);
      localStringBuffer.append(charTab[(i >> 12 & 0x3F)]);
      localStringBuffer.append(charTab[(i >> 6 & 0x3F)]);
      localStringBuffer.append("=");
    }
    for (;;)
    {
      return localStringBuffer.toString();
      int k = (paramArrayOfByte[i] & 0xFF) << 16 | (paramArrayOfByte[(i + 1)] & 0xFF) << 8 | paramArrayOfByte[(i + 2)] & 0xFF;
      localStringBuffer.append(charTab[(k >> 18 & 0x3F)]);
      localStringBuffer.append(charTab[(k >> 12 & 0x3F)]);
      localStringBuffer.append(charTab[(k >> 6 & 0x3F)]);
      localStringBuffer.append(charTab[(k & 0x3F)]);
      k = i + 3;
      i = j + 1;
      if (j >= 14)
      {
        i = 0;
        localStringBuffer.append("\r\n");
      }
      j = i;
      i = k;
      break;
      label260:
      if (i == 0 + m - 1)
      {
        i = (paramArrayOfByte[i] & 0xFF) << 16;
        localStringBuffer.append(charTab[(i >> 18 & 0x3F)]);
        localStringBuffer.append(charTab[(i >> 12 & 0x3F)]);
        localStringBuffer.append("==");
      }
    }
  }
  
  static int decode(char paramChar)
  {
    int i = 0;
    if ((paramChar >= 'A') && (paramChar <= 'Z'))
    {
      i = paramChar - 'A';
      return i;
    }
    if ((paramChar >= 'a') && (paramChar <= 'z')) {
      return paramChar - 'a' + 26;
    }
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return paramChar - '0' + 26 + 26;
    }
    switch (paramChar)
    {
    case '=': 
    default: 
      return 0;
    case '+': 
      return 62;
    }
    return 63;
  }
  
  public static String dkryp(Context paramContext, String paramString)
  {
    return XorDecrypt(base64Decode(paramString), getDeviceID(paramContext));
  }
  
  public static final int dpi(int paramInt)
  {
    if (mDensity == 1.0F) {
      return paramInt;
    }
    return (int)(paramInt * mDensity);
  }
  
  public static final int dpi2px(int paramInt)
  {
    if (mDensity == 1.0F) {
      return paramInt;
    }
    return (int)(paramInt / mDensity);
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
  
  public static String getAppVersion(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
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
    String str1;
    try
    {
      String str2 = Settings.System.getString(paramContext.getContentResolver(), "android_id");
      if (str2 == null)
      {
        str2 = getDIDPref(paramContext);
        if (!str2.equals(""))
        {
          str1 = str2;
          if (str2 != null) {}
        }
        else
        {
          str1 = "emulator/" + UUID.randomUUID().toString();
          setDIDPref(paramContext, str1);
          return str1;
        }
      }
      else
      {
        str1 = str2;
        if (str2.toLowerCase().equals("9774d56d682e549c"))
        {
          str2 = getDIDPref(paramContext);
          if (!str2.equals(""))
          {
            str1 = str2;
            if (str2 != null) {}
          }
          else
          {
            str1 = "9774d56d682e549c/" + UUID.randomUUID().toString();
            setDIDPref(paramContext, str1);
            return str1;
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      str1 = "";
      paramContext.printStackTrace();
    }
    return str1;
  }
  
  public static Typeface getTypeFace(Context paramContext, String paramString)
  {
    return Typeface.DEFAULT_BOLD;
  }
  
  public static String int2String000(int paramInt)
  {
    String str = String.valueOf(paramInt);
    return "000".substring(0, "000".length() - str.length()).concat(str);
  }
  
  public static String kryp(Context paramContext, String paramString)
  {
    return base64Encode(XorEncrypt(paramString, getDeviceID(paramContext)));
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
      Toast.makeText(paramContext, paramContext.getString(2131034133), 2000).show();
    }
  }
  
  public static void openUrl(Context paramContext, String paramString)
  {
    try
    {
      ((Activity)paramContext).startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse(paramString)), 2000);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static final int sdkVersion()
  {
    return Integer.valueOf(Build.VERSION.SDK).intValue();
  }
  
  private static void setDIDPref(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putString("DIDBIS", paramString);
    paramContext.commit();
  }
  
  public static void showAbout(Context paramContext)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramContext);
    View localView = LayoutInflater.from(paramContext).inflate(2130903040, null);
    ((WebView)localView.findViewById(2131099648)).loadDataWithBaseURL(null, paramContext.getString(2131034131).replace("¤1¤", getAppVersion(paramContext)), "text/html", "utf-8", "about:blank");
    localBuilder.setView(localView);
    localBuilder.setIcon(2130837519);
    localBuilder.setCancelable(true);
    localBuilder.setTitle(paramContext.getString(2131034130));
    localBuilder.setPositiveButton(paramContext.getString(2131034115), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    localBuilder.show();
  }
  
  public static void showAsk4Rate(final Context paramContext)
  {
    Object localObject = new AlertDialog.Builder(paramContext);
    View localView = LayoutInflater.from(paramContext).inflate(2130903041, null);
    Button localButton1 = (Button)localView.findViewById(2131099650);
    Button localButton2 = (Button)localView.findViewById(2131099651);
    final CheckBox localCheckBox = (CheckBox)localView.findViewById(2131099652);
    localCheckBox.setChecked(false);
    ((AlertDialog.Builder)localObject).setView(localView);
    ((AlertDialog.Builder)localObject).setIcon(2130837519);
    ((AlertDialog.Builder)localObject).setCancelable(true);
    ((AlertDialog.Builder)localObject).setTitle(paramContext.getString(2131034130));
    localObject = ((AlertDialog.Builder)localObject).show();
    localButton1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        modCommon.this.dismiss();
        modCommon.openMarket(paramContext, "com.magmamobile.game.BubbleBlast");
        modPreferences.prefAsk4RateNeverAskAgain = true;
        modPreferences.savePreferences(paramContext);
        GoogleAnalytics.trackAndDispatch("Ask4Rate/Yes");
      }
    });
    localButton2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        modCommon.this.dismiss();
        modPreferences.prefAsk4RateNeverAskAgain = localCheckBox.isChecked();
        modPreferences.savePreferences(paramContext);
        if (modPreferences.prefAsk4RateNeverAskAgain)
        {
          GoogleAnalytics.trackAndDispatch("Ask4Rate/Later/NeverAgain");
          return;
        }
        GoogleAnalytics.trackAndDispatch("Ask4Rate/Later");
      }
    });
  }
  
  public static final void useDpi(Context paramContext)
  {
    mDensity = getDensity(paramContext);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/magmamobile/game/BubbleBlast/modCommon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */