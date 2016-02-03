package com.gau.go.launcherex.gowidget.billing;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.telephony.TelephonyManager;
import java.util.Locale;

public class v
{
  private static String a = "";
  
  public static String a(Context paramContext)
  {
    if (("".equals(a)) && (paramContext != null))
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if ((localTelephonyManager.getSimState() == 5) && (localTelephonyManager.getSimCountryIso() != null)) {
        a = localTelephonyManager.getSimCountryIso().toLowerCase();
      }
      if ("".equals(a))
      {
        paramContext = paramContext.getResources().getConfiguration().locale;
        if ((paramContext == null) || (paramContext.getCountry() == null)) {
          break label97;
        }
        a = paramContext.getCountry().toLowerCase();
      }
    }
    for (;;)
    {
      return a;
      label97:
      if (Locale.getDefault().getCountry() != null) {
        a = Locale.getDefault().getCountry().toLowerCase();
      } else {
        a = "ZZ";
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/billing/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */