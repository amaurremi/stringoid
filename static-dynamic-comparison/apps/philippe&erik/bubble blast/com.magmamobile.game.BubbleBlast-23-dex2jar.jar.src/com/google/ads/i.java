package com.google.ads;

import android.app.Activity;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.MediationServerParameters.MappingException;
import com.google.ads.mediation.NetworkExtras;
import com.google.ads.util.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

class i
  implements Runnable
{
  private final h a;
  private final String b;
  private final AdRequest c;
  private final HashMap<String, String> d;
  private final boolean e;
  private final WeakReference<Activity> f;
  
  public i(h paramh, Activity paramActivity, String paramString, AdRequest paramAdRequest, HashMap<String, String> paramHashMap)
  {
    this.a = paramh;
    this.b = paramString;
    this.f = new WeakReference(paramActivity);
    this.c = paramAdRequest;
    this.d = new HashMap(paramHashMap);
    this.e = a(this.d);
  }
  
  private <T extends NetworkExtras, U extends MediationServerParameters> void a(MediationAdapter<T, U> paramMediationAdapter)
    throws MediationServerParameters.MappingException, i.a, IllegalAccessException, InstantiationException
  {
    Activity localActivity = (Activity)this.f.get();
    if (localActivity == null) {
      throw new a("Activity became null while trying to instantiate adapter.");
    }
    this.a.a(paramMediationAdapter);
    Object localObject1 = paramMediationAdapter.getServerParametersType();
    if (localObject1 != null)
    {
      localObject1 = (MediationServerParameters)((Class)localObject1).newInstance();
      ((MediationServerParameters)localObject1).load(this.d);
    }
    for (;;)
    {
      Object localObject2 = paramMediationAdapter.getAdditionalParametersType();
      if (localObject2 != null) {}
      for (localObject2 = (NetworkExtras)this.c.getNetworkExtras((Class)localObject2);; localObject2 = null)
      {
        MediationAdRequest localMediationAdRequest = new MediationAdRequest(this.c, localActivity, this.e);
        if (this.a.a.a())
        {
          if (!(paramMediationAdapter instanceof MediationInterstitialAdapter)) {
            throw new a("Adapter " + this.b + " doesn't support the MediationInterstitialAdapter" + " interface.");
          }
          ((MediationInterstitialAdapter)paramMediationAdapter).requestInterstitialAd(new k(this.a), localActivity, (MediationServerParameters)localObject1, localMediationAdRequest, (NetworkExtras)localObject2);
        }
        for (;;)
        {
          this.a.k();
          return;
          if (!(paramMediationAdapter instanceof MediationBannerAdapter)) {
            throw new a("Adapter " + this.b + " doesn't support the MediationBannerAdapter interface");
          }
          ((MediationBannerAdapter)paramMediationAdapter).requestBannerAd(new j(this.a), localActivity, (MediationServerParameters)localObject1, this.a.a.c(), localMediationAdRequest, (NetworkExtras)localObject2);
        }
      }
      localObject1 = null;
    }
  }
  
  private void a(String paramString, Throwable paramThrowable, g.a parama)
  {
    b.b(paramString, paramThrowable);
    this.a.a(false, parama);
  }
  
  private static boolean a(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.remove("gwhirl_share_location");
    if ("1".equals(paramMap)) {
      return true;
    }
    if ((paramMap != null) && (!"0".equals(paramMap))) {
      b.b("Received an illegal value, '" + paramMap + "', for the special share location parameter from mediation server" + " (expected '0' or '1'). Will not share the location.");
    }
    return false;
  }
  
  public void run()
  {
    try
    {
      b.a("Trying to instantiate: " + this.b);
      a((MediationAdapter)g.a(this.b, MediationAdapter.class));
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      a("Cannot find adapter class '" + this.b + "'. Did you link the ad network's mediation adapter? Skipping ad network.", localClassNotFoundException, g.a.e);
      return;
    }
    catch (Throwable localThrowable)
    {
      a("Error while creating adapter and loading ad from ad network. Skipping ad network.", localThrowable, g.a.f);
    }
  }
  
  private static class a
    extends Exception
  {
    public a(String paramString)
    {
      super();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/bubble blast/com.magmamobile.game.BubbleBlast-23-dex2jar.jar!/com/google/ads/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */