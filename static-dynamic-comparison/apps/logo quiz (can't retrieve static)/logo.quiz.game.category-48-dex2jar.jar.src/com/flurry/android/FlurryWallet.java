package com.flurry.android;

import android.content.Context;
import android.net.Uri;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.flurry.android.impl.appcloud.AppCloudModule;
import com.flurry.android.monolithic.sdk.impl.f;
import com.flurry.android.monolithic.sdk.impl.fk;
import com.flurry.android.monolithic.sdk.impl.ft;
import com.flurry.android.monolithic.sdk.impl.fy;
import com.flurry.android.monolithic.sdk.impl.g;
import com.flurry.android.monolithic.sdk.impl.ga;
import com.flurry.android.monolithic.sdk.impl.go;
import com.flurry.android.monolithic.sdk.impl.hd;
import com.flurry.android.monolithic.sdk.impl.ja;
import java.util.UUID;

public class FlurryWallet
{
  private static Context a = null;
  
  private static String a()
  {
    if (a == null)
    {
      ja.a(6, "FlurryWallet", "Please call initWalletModule first.");
      return null;
    }
    try
    {
      Object localObject = (TelephonyManager)a.getSystemService("phone");
      localObject = "" + ((TelephonyManager)localObject).getDeviceId();
      long l1 = ("" + Settings.Secure.getString(a.getContentResolver(), "android_id")).hashCode();
      long l2 = ((String)localObject).hashCode();
      localObject = new UUID(l1, "".hashCode() | l2 << 32).toString();
      return (String)localObject;
    }
    catch (Exception localException)
    {
      ja.a(6, "FlurryWallet", "Could not get device id.");
      localException.printStackTrace();
    }
    return null;
  }
  
  public static void a(String paramString, FlurryWalletHandler paramFlurryWalletHandler)
  {
    ft localft = ft.f();
    if (localft == null)
    {
      paramFlurryWalletHandler.onError(new FlurryWalletError(400, "Please assign an object id."));
      return;
    }
    AppCloudModule.getInstance().b().a(localft.a(), paramString, new ga(paramFlurryWalletHandler));
    AppCloudModule.getInstance().b().b(localft.a());
  }
  
  static void a(String paramString1, String paramString2, String paramString3, String paramString4, FlurryWalletHandler paramFlurryWalletHandler)
  {
    try
    {
      ft.a(paramString1, paramString2, paramString3, true, new f(paramString4, paramFlurryWalletHandler));
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void addObserverForCurrencyKey(String paramString, FlurryWalletHandler paramFlurryWalletHandler)
  {
    String str1 = fy.d();
    String str2 = fy.h();
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
    {
      ja.a(4, "FlurryWallet", "There is no last logged in user");
      str1 = a();
      if (str1 == null)
      {
        ja.a(6, "FlurryWallet", "Could not generate Wallet user.");
        return;
      }
      a(str1, str1, str1 + "@" + str1 + ".flurry.com", paramString, paramFlurryWalletHandler);
      return;
    }
    a(paramString, paramFlurryWalletHandler);
  }
  
  private static void b(String paramString, float paramFloat, FlurryWalletOperationHandler paramFlurryWalletOperationHandler)
  {
    ft localft = ft.f();
    if (localft == null)
    {
      paramFlurryWalletOperationHandler.onError(new FlurryWalletError(400, "Please assign an object id."));
      return;
    }
    if (paramFloat <= 0.0F)
    {
      paramFlurryWalletOperationHandler.onError(new FlurryWalletError(400, "decrementWalletForCurrencyKey may only be called with a positive value."));
      return;
    }
    localft.a(paramString, paramFloat, new fk(paramFlurryWalletOperationHandler));
  }
  
  public static void decrementWalletForCurrencyKey(String paramString, float paramFloat, FlurryWalletOperationHandler paramFlurryWalletOperationHandler)
  {
    String str1 = fy.d();
    String str2 = fy.h();
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
    {
      ja.a(4, "FlurryWallet", "There is no last logged in user");
      str1 = a();
      if (str1 == null)
      {
        ja.a(6, "FlurryWallet", "Could not generate Wallet user.");
        return;
      }
      str2 = str1 + "@" + str1 + ".flurry.com";
      try
      {
        ft.a(str1, str1, str2, true, new g(paramString, paramFloat, paramFlurryWalletOperationHandler));
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    b(paramString, paramFloat, paramFlurryWalletOperationHandler);
  }
  
  public static FlurryWalletInfo getLastReceivedValueForCurrencyKey(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    ft localft;
    do
    {
      return null;
      localft = ft.f();
    } while (localft == null);
    return new FlurryWalletInfo(paramString, localft.a(paramString));
  }
  
  public static void initWalletModule(Context paramContext)
  {
    if (paramContext == null) {
      throw new NullPointerException("Null context");
    }
    a = paramContext.getApplicationContext();
    go.a(paramContext);
  }
  
  public static boolean removeAllObservers()
  {
    ft localft = ft.f();
    if (localft != null) {
      return localft.c();
    }
    return false;
  }
  
  public static boolean removeObserver(FlurryWalletHandler paramFlurryWalletHandler)
  {
    Object localObject = ft.f();
    if (localObject != null)
    {
      localObject = ((ft)localObject).a();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    else
    {
      return false;
    }
    return AppCloudModule.getInstance().b().a((String)localObject, new ga(paramFlurryWalletHandler));
  }
  
  public static boolean removeObserversForCurrencyKey(String paramString)
  {
    Object localObject = ft.f();
    if (localObject != null)
    {
      localObject = ((ft)localObject).a();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    else
    {
      return false;
    }
    return AppCloudModule.getInstance().b().a((String)localObject, paramString);
  }
  
  public static void setWalletServerUrl(String paramString)
  {
    String str = null;
    if (!TextUtils.isEmpty(paramString)) {
      str = Uri.parse(paramString).getHost();
    }
    go.b(str);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/FlurryWallet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */