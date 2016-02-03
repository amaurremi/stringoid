package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

public final class bh
{
  public static boolean a(Context paramContext, bj parambj, bq parambq)
  {
    if (parambj == null)
    {
      ct.v("No intent data for launcher overlay.");
      return false;
    }
    Intent localIntent = new Intent();
    if (TextUtils.isEmpty(parambj.go))
    {
      ct.v("Open GMSG did not contain a URL.");
      return false;
    }
    if (!TextUtils.isEmpty(parambj.mimeType)) {
      localIntent.setDataAndType(Uri.parse(parambj.go), parambj.mimeType);
    }
    String[] arrayOfString;
    for (;;)
    {
      localIntent.setAction("android.intent.action.VIEW");
      if (!TextUtils.isEmpty(parambj.packageName)) {
        localIntent.setPackage(parambj.packageName);
      }
      if (TextUtils.isEmpty(parambj.gp)) {
        break label172;
      }
      arrayOfString = parambj.gp.split("/", 2);
      if (arrayOfString.length >= 2) {
        break;
      }
      ct.v("Could not parse component name from open GMSG: " + parambj.gp);
      return false;
      localIntent.setData(Uri.parse(parambj.go));
    }
    localIntent.setClassName(arrayOfString[0], arrayOfString[1]);
    try
    {
      label172:
      ct.u("Launching an intent: " + localIntent);
      paramContext.startActivity(localIntent);
      parambq.z();
      return true;
    }
    catch (ActivityNotFoundException paramContext)
    {
      ct.v(paramContext.getMessage());
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */