package com.appbrain.a;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.appbrain.e.j.h;
import com.appbrain.e.j.i;
import com.appbrain.e.j.i.a;

final class z
{
  private static void a(Context paramContext, Intent paramIntent)
  {
    if (!(paramContext instanceof Activity)) {
      paramIntent.setFlags(268435456);
    }
    paramContext.startActivity(paramIntent);
  }
  
  static void a(Context paramContext, j.i parami)
  {
    String str = parami.p();
    if (TextUtils.isEmpty(str)) {
      return;
    }
    h.a().sendConversionEvent("app_alert_action", 1);
    if (str.startsWith("offerwall://"))
    {
      a.a(paramContext, j.h.j, parami.r().name());
      return;
    }
    if (str.startsWith("activity://")) {
      try
      {
        parami = Class.forName(str.substring(11));
        a(paramContext, new Intent(paramContext, parami));
        return;
      }
      catch (ClassNotFoundException paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
    }
    try
    {
      parami = new Intent("android.intent.action.VIEW");
      parami.setData(Uri.parse(str));
      a(paramContext, parami);
      return;
    }
    catch (ActivityNotFoundException parami)
    {
      Toast.makeText(paramContext, "Couldn't open URL", 0).show();
    }
  }
  
  static String b(Context paramContext, j.i parami)
  {
    if (!TextUtils.isEmpty(parami.n())) {
      return parami.n();
    }
    return paramContext.getString(17039370);
  }
  
  static String c(Context paramContext, j.i parami)
  {
    if (!TextUtils.isEmpty(parami.l())) {
      return parami.l();
    }
    return paramContext.getString(17039360);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/appbrain/a/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */