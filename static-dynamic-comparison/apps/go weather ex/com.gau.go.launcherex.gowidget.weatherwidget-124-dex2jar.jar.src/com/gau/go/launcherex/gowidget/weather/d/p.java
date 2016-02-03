package com.gau.go.launcherex.gowidget.weather.d;

import android.content.Context;
import android.content.Intent;
import com.gau.go.launcherex.gowidget.a.i;
import com.gau.go.launcherex.gowidget.a.j;
import com.gau.go.launcherex.gowidget.a.l;
import com.gau.go.launcherex.gowidget.framework.GoWidgetApplication;
import com.gau.go.launcherex.gowidget.googleplay.IabHelper;
import com.gau.go.launcherex.gowidget.googleplay.IabHelper.OnIabSetupFinishedListener;
import com.gau.go.launcherex.gowidget.googleplay.IabResult;
import com.gau.go.launcherex.gowidget.statistics.y;
import com.getjar.sdk.GetjarConnectionResult;
import com.getjar.sdk.GetjarLicense;
import com.getjar.sdk.GetjarLicense.State;
import com.gtp.a.a.b.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class p
  implements i, j, l, IabHelper.OnIabSetupFinishedListener
{
  private static volatile p d;
  private Context a;
  private f b;
  private IabHelper c;
  private com.gau.go.launcherex.gowidget.a.g e;
  private boolean f;
  
  private p(Context paramContext)
  {
    this.a = paramContext;
    this.b = GoWidgetApplication.b(paramContext);
  }
  
  public static p a(Context paramContext)
  {
    try
    {
      if (d == null) {
        d = new p(paramContext);
      }
      paramContext = d;
      return paramContext;
    }
    finally {}
  }
  
  private boolean a(ArrayList paramArrayList)
  {
    String str = "";
    if (paramArrayList.contains("com.gau.go.launcherex.gowidget.weatherwidge.billingpay1")) {
      str = "com.gau.go.launcherex.gowidget.weatherwidge.billingpay1";
    }
    while (!"".equals(str))
    {
      if (this.b.a(str, true)) {
        this.b.b(str);
      }
      return true;
      if (paramArrayList.contains("go_weather_ex_premium_pack_promotions")) {
        str = "go_weather_ex_premium_pack_promotions";
      }
    }
    if (this.b.a("com.gau.go.launcherex.gowidget.weatherwidge.billingpay1", false)) {
      this.b.b("com.gau.go.launcherex.gowidget.weatherwidge.billingpay1");
    }
    for (;;)
    {
      return false;
      if (this.b.a("go_weather_ex_premium_pack_promotions", false)) {
        this.b.b("go_weather_ex_premium_pack_promotions");
      }
    }
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    boolean bool = GetjarLicense.State.ACQUIRED.name().equals(paramJSONObject.getString("license_state"));
    paramJSONObject = paramJSONObject.getString("developer_product_id");
    if (paramJSONObject == null) {}
    while ((!paramJSONObject.equals("goweatherex_getjar_id")) || (!bool)) {
      return false;
    }
    return true;
  }
  
  private boolean b(ArrayList paramArrayList)
  {
    String str = "";
    if (paramArrayList.contains("go_weather_ex_premium_pack_theme_vip")) {
      str = "go_weather_ex_premium_pack_theme_vip";
    }
    while (!"".equals(str))
    {
      if (this.b.a(str, true)) {
        this.b.b(str);
      }
      return true;
      if (paramArrayList.contains("go_weather_ex_premium_pack_theme_vip_promo")) {
        str = "go_weather_ex_premium_pack_theme_vip_promo";
      }
    }
    if (this.b.a("go_weather_ex_premium_pack_theme_vip", false)) {
      this.b.b("go_weather_ex_premium_pack_theme_vip");
    }
    for (;;)
    {
      return false;
      if (this.b.a("go_weather_ex_premium_pack_theme_vip_promo", false)) {
        this.b.b("go_weather_ex_premium_pack_theme_vip_promo");
      }
    }
  }
  
  private boolean c(ArrayList paramArrayList)
  {
    String str = "";
    if (paramArrayList.contains("go_weather_ex_premium_pack_vip")) {
      str = "go_weather_ex_premium_pack_vip";
    }
    while (!"".equals(str))
    {
      if (this.b.a(str, true)) {
        this.b.b(str);
      }
      return true;
      if (paramArrayList.contains("go_weather_ex_premium_pack_vip_promo")) {
        str = "go_weather_ex_premium_pack_vip_promo";
      }
    }
    if (this.b.a("go_weather_ex_premium_pack_vip", false)) {
      this.b.b("go_weather_ex_premium_pack_vip");
    }
    for (;;)
    {
      return false;
      if (this.b.a("go_weather_ex_premium_pack_vip_promo", false)) {
        this.b.b("go_weather_ex_premium_pack_vip_promo");
      }
    }
  }
  
  public void a()
  {
    this.e.a();
  }
  
  public void a(int paramInt, List paramList)
  {
    if ((paramInt != 0) || (paramList == null)) {
      return;
    }
    paramList = paramList.iterator();
    boolean bool1 = false;
    label18:
    GetjarLicense localGetjarLicense;
    if (paramList.hasNext()) {
      localGetjarLicense = (GetjarLicense)paramList.next();
    }
    for (;;)
    {
      try
      {
        bool2 = a(new JSONObject(localGetjarLicense.getSignedLicenseData()));
        bool1 = bool2;
        bool2 = bool1;
        if (bool1)
        {
          c.a("adid", "InterstitialAdvertisementHandler: grant : " + bool1);
          if (!bool1) {
            break label148;
          }
          if ((this.b.a("goweatherex_getjar_id").a()) || (!this.b.a("goweatherex_getjar_id", true))) {
            break;
          }
          this.b.b("goweatherex_getjar_id");
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        boolean bool2 = bool1;
        bool1 = bool2;
      }
      break label18;
      label148:
      if ((!this.b.a("goweatherex_getjar_id").a()) || (!this.b.a("goweatherex_getjar_id", false))) {
        break;
      }
      this.b.b("goweatherex_getjar_id");
      return;
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.e.a(paramIntent);
  }
  
  public void a(com.gau.go.launcherex.gowidget.a.g paramg)
  {
    if (this.e == null)
    {
      this.e = paramg;
      this.e.a(this);
      this.e.a(this);
      this.e.a(this);
    }
  }
  
  public void a(GetjarConnectionResult paramGetjarConnectionResult) {}
  
  public void b()
  {
    if (((!this.b.e()) && (this.b.a(16))) || (!y.s(this.a))) {}
    while (this.f) {
      return;
    }
    this.c = new IabHelper(this.a, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjMLLCo3hpiezV/bPOi83lz3DktmKGQpvsxjE10fF1h+L62vnazigqi+P6m4NFO+jOFT5RX0VPM9SzM6vCGOo9Xjjuk219queZr9SQUKoytfMTsgrtcI1YGDy9maP1owggij0hxWfaBsP4375zP+R89Pzz0R9Ap2tmLLlfIzRZPwqPcnONlQ/8ZqfdxWwCiOOOLHQJ4k1aN6jUPx8ipKWFxo7ORI0TmqgiJvhsFJuBr6QCqoN2BF6QgOfz6fMac1e+EaeJD3/pzUsuzzvvEnh70aoq+6mqZyZmyJb4840OddTGUHX8z3Qeoa/Dti+YQiXtSO3T2ANuF9pzkyBIAQQLwIDAQAB");
    this.c.enableDebugLogging(true);
    this.c.startSetup(this);
    this.f = true;
  }
  
  public void c()
  {
    if (this.e != null)
    {
      this.e.b(this);
      this.e.b(this);
      this.e.b(this);
    }
    d = null;
  }
  
  public void onIabSetupFinished(IabResult paramIabResult)
  {
    if (!paramIabResult.isSuccess())
    {
      if (paramIabResult.getResponse() == 3) {}
      while (this.c == null) {
        return;
      }
      this.c.logDebug("Problem setting up In-app Billing: " + paramIabResult);
      this.c.dispose();
      return;
    }
    this.c.logDebug("IAB is fully set up!: " + paramIabResult);
    new q(this).c(new IabHelper[] { this.c });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/gau/go/launcherex/gowidget/weather/d/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */