package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

public final class cc
{
  public static boolean a(Context paramContext, ce paramce, cl paramcl)
  {
    if (paramce == null)
    {
      eu.D("No intent data for launcher overlay.");
      return false;
    }
    Intent localIntent = new Intent();
    if (TextUtils.isEmpty(paramce.ob))
    {
      eu.D("Open GMSG did not contain a URL.");
      return false;
    }
    if (!TextUtils.isEmpty(paramce.mimeType)) {
      localIntent.setDataAndType(Uri.parse(paramce.ob), paramce.mimeType);
    }
    String[] arrayOfString;
    for (;;)
    {
      localIntent.setAction("android.intent.action.VIEW");
      if (!TextUtils.isEmpty(paramce.packageName)) {
        localIntent.setPackage(paramce.packageName);
      }
      if (TextUtils.isEmpty(paramce.oc)) {
        break label172;
      }
      arrayOfString = paramce.oc.split("/", 2);
      if (arrayOfString.length >= 2) {
        break;
      }
      eu.D("Could not parse component name from open GMSG: " + paramce.oc);
      return false;
      localIntent.setData(Uri.parse(paramce.ob));
    }
    localIntent.setClassName(arrayOfString[0], arrayOfString[1]);
    try
    {
      label172:
      eu.C("Launching an intent: " + localIntent);
      paramContext.startActivity(localIntent);
      paramcl.Y();
      return true;
    }
    catch (ActivityNotFoundException paramContext)
    {
      eu.D(paramContext.getMessage());
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */