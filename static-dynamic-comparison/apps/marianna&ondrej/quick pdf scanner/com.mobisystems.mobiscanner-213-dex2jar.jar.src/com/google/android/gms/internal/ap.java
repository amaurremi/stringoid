package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

public final class ap
{
  public static boolean a(Context paramContext, bn parambn, at paramat)
  {
    if (parambn == null)
    {
      ce.D("No intent data for launcher overlay.");
      return false;
    }
    Intent localIntent = new Intent();
    if (TextUtils.isEmpty(parambn.Cu))
    {
      ce.D("Open GMSG did not contain a URL.");
      return false;
    }
    if (!TextUtils.isEmpty(parambn.mimeType)) {
      localIntent.setDataAndType(Uri.parse(parambn.Cu), parambn.mimeType);
    }
    String[] arrayOfString;
    for (;;)
    {
      localIntent.setAction("android.intent.action.VIEW");
      if (!TextUtils.isEmpty(parambn.packageName)) {
        localIntent.setPackage(parambn.packageName);
      }
      if (TextUtils.isEmpty(parambn.Cv)) {
        break label172;
      }
      arrayOfString = parambn.Cv.split("/", 2);
      if (arrayOfString.length >= 2) {
        break;
      }
      ce.D("Could not parse component name from open GMSG: " + parambn.Cv);
      return false;
      localIntent.setData(Uri.parse(parambn.Cu));
    }
    localIntent.setClassName(arrayOfString[0], arrayOfString[1]);
    try
    {
      label172:
      ce.C("Launching an intent: " + localIntent);
      paramContext.startActivity(localIntent);
      paramat.px();
      return true;
    }
    catch (ActivityNotFoundException paramContext)
    {
      ce.D(paramContext.getMessage());
    }
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */