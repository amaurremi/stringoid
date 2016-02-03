package com.google.android.gms.internal;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;

public class dz
{
  private static final Uri pK = Uri.parse("http://plus.google.com/");
  private static final Uri pL = pK.buildUpon().appendPath("circles").appendPath("find").build();
  
  public static Intent Q(String paramString)
  {
    paramString = Uri.fromParts("package", paramString, null);
    Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
    localIntent.setData(paramString);
    return localIntent;
  }
  
  private static Uri R(String paramString)
  {
    return Uri.parse("market://details").buildUpon().appendQueryParameter("id", paramString).build();
  }
  
  public static Intent S(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(R(paramString));
    localIntent.setPackage("com.android.vending");
    localIntent.addFlags(524288);
    return localIntent;
  }
  
  public static Intent T(String paramString)
  {
    paramString = Uri.parse("bazaar://search?q=pname:" + paramString);
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(paramString);
    localIntent.setFlags(524288);
    return localIntent;
  }
  
  public static Intent bX()
  {
    return new Intent("android.settings.DATE_SETTINGS");
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/dz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */