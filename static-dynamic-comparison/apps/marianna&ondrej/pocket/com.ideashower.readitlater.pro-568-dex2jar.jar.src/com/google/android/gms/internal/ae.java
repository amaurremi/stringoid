package com.google.android.gms.internal;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;

public class ae
{
  private static final Uri a = Uri.parse("http://plus.google.com/");
  private static final Uri b = a.buildUpon().appendPath("circles").appendPath("find").build();
  
  public static Intent a()
  {
    return new Intent("android.settings.DATE_SETTINGS");
  }
  
  public static Intent a(String paramString)
  {
    paramString = Uri.fromParts("package", paramString, null);
    Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
    localIntent.setData(paramString);
    return localIntent;
  }
  
  public static Intent b(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(d(paramString));
    localIntent.setPackage("com.android.vending");
    localIntent.addFlags(524288);
    return localIntent;
  }
  
  public static Intent c(String paramString)
  {
    paramString = Uri.parse("bazaar://search?q=pname:" + paramString);
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(paramString);
    localIntent.setFlags(524288);
    return localIntent;
  }
  
  private static Uri d(String paramString)
  {
    return Uri.parse("market://details").buildUpon().appendQueryParameter("id", paramString).build();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */