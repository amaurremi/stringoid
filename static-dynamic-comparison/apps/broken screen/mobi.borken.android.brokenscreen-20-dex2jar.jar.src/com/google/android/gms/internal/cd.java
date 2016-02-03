package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

public final class cd
{
  public static boolean a(Context paramContext, cf paramcf, cm paramcm)
  {
    if (paramcf == null)
    {
      ev.D("No intent data for launcher overlay.");
      return false;
    }
    Intent localIntent = new Intent();
    if (TextUtils.isEmpty(paramcf.nZ))
    {
      ev.D("Open GMSG did not contain a URL.");
      return false;
    }
    if (!TextUtils.isEmpty(paramcf.mimeType)) {
      localIntent.setDataAndType(Uri.parse(paramcf.nZ), paramcf.mimeType);
    }
    String[] arrayOfString;
    for (;;)
    {
      localIntent.setAction("android.intent.action.VIEW");
      if (!TextUtils.isEmpty(paramcf.packageName)) {
        localIntent.setPackage(paramcf.packageName);
      }
      if (TextUtils.isEmpty(paramcf.oa)) {
        break label172;
      }
      arrayOfString = paramcf.oa.split("/", 2);
      if (arrayOfString.length >= 2) {
        break;
      }
      ev.D("Could not parse component name from open GMSG: " + paramcf.oa);
      return false;
      localIntent.setData(Uri.parse(paramcf.nZ));
    }
    localIntent.setClassName(arrayOfString[0], arrayOfString[1]);
    try
    {
      label172:
      ev.C("Launching an intent: " + localIntent);
      paramContext.startActivity(localIntent);
      paramcm.T();
      return true;
    }
    catch (ActivityNotFoundException paramContext)
    {
      ev.D(paramContext.getMessage());
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */