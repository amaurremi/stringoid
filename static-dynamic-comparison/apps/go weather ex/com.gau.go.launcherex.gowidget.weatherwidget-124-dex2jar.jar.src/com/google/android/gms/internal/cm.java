package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.SystemClock;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class cm
  extends cn.a
{
  private String lh;
  private Context mContext;
  private String oD;
  private ArrayList<String> oE;
  
  public cm(String paramString1, ArrayList<String> paramArrayList, Context paramContext, String paramString2)
  {
    this.oD = paramString1;
    this.oE = paramArrayList;
    this.lh = paramString2;
    this.mContext = paramContext;
  }
  
  private void aX()
  {
    try
    {
      this.mContext.getClassLoader().loadClass("com.google.ads.conversiontracking.IAPConversionReporter").getDeclaredMethod("reportWithProductId", new Class[] { Context.class, String.class, String.class, Boolean.TYPE }).invoke(null, new Object[] { this.mContext, this.oD, "", Boolean.valueOf(true) });
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      dw.z("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      dw.z("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
      return;
    }
    catch (Exception localException)
    {
      dw.c("Fail to report a conversion.", localException);
    }
  }
  
  protected String a(String paramString, HashMap<String, String> paramHashMap)
  {
    String str3 = this.mContext.getPackageName();
    long l1;
    long l2;
    String str2;
    try
    {
      String str1 = this.mContext.getPackageManager().getPackageInfo(str3, 0).versionName;
      l1 = SystemClock.elapsedRealtime();
      l2 = dj.bu().bw();
      Iterator localIterator = paramHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str4 = (String)localIterator.next();
        paramString = paramString.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", new Object[] { str4 }), String.format("$1%s$2", new Object[] { paramHashMap.get(str4) }));
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        dw.c("Error to retrieve app version", localNameNotFoundException);
        str2 = "";
      }
    }
    return paramString.replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", tmp135_132), String.format("$1%s$2", tmp149_146)).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", tmp167_164), String.format("$1%s$2", tmp181_178)).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", tmp198_195), String.format("$1%s$2", tmp212_209)).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", tmp233_230), String.format("$1%s$2", tmp247_244)).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", tmp266_263), String.format("$1%s$2", tmp280_277)).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", tmp297_294), String.format("$1%s$2", tmp311_308)).replaceAll(String.format("(?<!@)((?:@@)*)@%s(?<!@)((?:@@)*)@", tmp333_330), String.format("$1%s$2", tmp347_344)).replaceAll("@@", "@");
  }
  
  public String getProductId()
  {
    return this.oD;
  }
  
  protected int j(int paramInt)
  {
    if (paramInt == 0) {
      return 1;
    }
    if (paramInt == 1) {
      return 2;
    }
    if (paramInt == 4) {
      return 3;
    }
    return 0;
  }
  
  public void recordPlayBillingResolution(int paramInt)
  {
    if (paramInt == 0) {
      aX();
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("google_play_status", String.valueOf(paramInt));
    localHashMap.put("sku", this.oD);
    localHashMap.put("status", String.valueOf(j(paramInt)));
    Iterator localIterator = this.oE.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      new du(this.mContext, this.lh, a(str, localHashMap)).start();
    }
  }
  
  public void recordResolution(int paramInt)
  {
    if (paramInt == 1) {
      aX();
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("status", String.valueOf(paramInt));
    localHashMap.put("sku", this.oD);
    Iterator localIterator = this.oE.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      new du(this.mContext, this.lh, a(str, localHashMap)).start();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/cm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */