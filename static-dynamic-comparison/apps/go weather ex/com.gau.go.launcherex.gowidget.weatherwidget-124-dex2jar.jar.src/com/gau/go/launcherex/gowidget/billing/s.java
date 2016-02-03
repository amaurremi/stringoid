package com.gau.go.launcherex.gowidget.billing;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.gau.go.launcherex.gowidget.weather.globalview.c;
import java.util.Locale;

final class s
  implements c
{
  s(Activity paramActivity) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Object localObject = Locale.getDefault();
      localObject = new Intent("android.intent.action.VIEW", Uri.parse("http://market.android.com/support/bin/answer.py?answer=1050566&hl=%lang%&dl=%region%".replace("%lang%", ((Locale)localObject).getLanguage().toLowerCase(Locale.US)).replace("%region%", ((Locale)localObject).getCountry().toLowerCase(Locale.US))));
      ((Intent)localObject).addFlags(268435456);
      this.a.startActivity((Intent)localObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/billing/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */