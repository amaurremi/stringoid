package com.jirbo.adcolony;

import android.app.Activity;
import android.os.AsyncTask;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;

class AdColony$a
  extends AsyncTask<Void, Void, Void>
{
  Activity a;
  String b = "";
  boolean c;
  
  AdColony$a(Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  protected Void a(Void... paramVarArgs)
  {
    try
    {
      paramVarArgs = AdvertisingIdClient.getAdvertisingIdInfo(this.a);
      this.b = paramVarArgs.getId();
      this.c = paramVarArgs.isLimitAdTrackingEnabled();
      return null;
    }
    catch (NoClassDefFoundError paramVarArgs)
    {
      l.d.b("Google Play Services SDK not installed! Collecting Android Id instead of Advertising Id.");
      return null;
    }
    catch (Exception paramVarArgs)
    {
      l.d.b("Advertising Id not available! Collecting Android Id instead of Advertising Id.");
      paramVarArgs.printStackTrace();
    }
    return null;
  }
  
  protected void a(Void paramVoid)
  {
    g.a = this.b;
    g.b = this.c;
    AdColony.b = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/jirbo/adcolony/AdColony$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */