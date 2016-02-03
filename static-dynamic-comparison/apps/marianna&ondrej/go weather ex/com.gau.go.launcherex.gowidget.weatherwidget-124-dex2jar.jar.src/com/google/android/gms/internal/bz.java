package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

public final class bz
{
  public static boolean a(Context paramContext, cb paramcb, ci paramci)
  {
    if (paramcb == null)
    {
      dw.z("No intent data for launcher overlay.");
      return false;
    }
    Intent localIntent = new Intent();
    if (TextUtils.isEmpty(paramcb.nO))
    {
      dw.z("Open GMSG did not contain a URL.");
      return false;
    }
    if (!TextUtils.isEmpty(paramcb.mimeType)) {
      localIntent.setDataAndType(Uri.parse(paramcb.nO), paramcb.mimeType);
    }
    String[] arrayOfString;
    for (;;)
    {
      localIntent.setAction("android.intent.action.VIEW");
      if (!TextUtils.isEmpty(paramcb.packageName)) {
        localIntent.setPackage(paramcb.packageName);
      }
      if (TextUtils.isEmpty(paramcb.nP)) {
        break label172;
      }
      arrayOfString = paramcb.nP.split("/", 2);
      if (arrayOfString.length >= 2) {
        break;
      }
      dw.z("Could not parse component name from open GMSG: " + paramcb.nP);
      return false;
      localIntent.setData(Uri.parse(paramcb.nO));
    }
    localIntent.setClassName(arrayOfString[0], arrayOfString[1]);
    try
    {
      label172:
      dw.y("Launching an intent: " + localIntent);
      paramContext.startActivity(localIntent);
      paramci.U();
      return true;
    }
    catch (ActivityNotFoundException paramContext)
    {
      dw.z(paramContext.getMessage());
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */