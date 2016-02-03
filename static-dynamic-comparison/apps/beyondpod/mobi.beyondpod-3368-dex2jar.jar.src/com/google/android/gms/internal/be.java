package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.ads.mediation.admob.AdMobServerParameters;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class be<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters>
  extends bc.a
{
  private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> gg;
  private final NETWORK_EXTRAS gh;
  
  public be(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> paramMediationAdapter, NETWORK_EXTRAS paramNETWORK_EXTRAS)
  {
    this.gg = paramMediationAdapter;
    this.gh = paramNETWORK_EXTRAS;
  }
  
  private SERVER_PARAMETERS a(String paramString1, int paramInt, String paramString2)
    throws RemoteException
  {
    Object localObject1;
    Object localObject2;
    if (paramString1 != null) {
      try
      {
        localObject1 = new JSONObject(paramString1);
        paramString1 = new HashMap(((JSONObject)localObject1).length());
        localObject2 = ((JSONObject)localObject1).keys();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          paramString1.put(str, ((JSONObject)localObject1).getString(str));
        }
        localObject2 = this.gg.getServerParametersType();
      }
      catch (Throwable paramString1)
      {
        ct.b("Could not get MediationServerParameters.", paramString1);
        throw new RemoteException();
      }
    }
    for (;;)
    {
      localObject1 = null;
      if (localObject2 != null)
      {
        localObject1 = (MediationServerParameters)((Class)localObject2).newInstance();
        ((MediationServerParameters)localObject1).load(paramString1);
      }
      if (!(localObject1 instanceof AdMobServerParameters)) {
        break;
      }
      paramString1 = (AdMobServerParameters)localObject1;
      paramString1.adJson = paramString2;
      paramString1.tagForChildDirectedTreatment = paramInt;
      return (SERVER_PARAMETERS)localObject1;
      paramString1 = new HashMap(0);
    }
    return (SERVER_PARAMETERS)localObject1;
  }
  
  public void a(b paramb, v paramv, String paramString, bd parambd)
    throws RemoteException
  {
    a(paramb, paramv, paramString, null, parambd);
  }
  
  public void a(b paramb, v paramv, String paramString1, String paramString2, bd parambd)
    throws RemoteException
  {
    if (!(this.gg instanceof MediationInterstitialAdapter))
    {
      ct.v("MediationAdapter is not a MediationInterstitialAdapter: " + this.gg.getClass().getCanonicalName());
      throw new RemoteException();
    }
    ct.r("Requesting interstitial ad from adapter.");
    try
    {
      ((MediationInterstitialAdapter)this.gg).requestInterstitialAd(new bf(parambd), (Activity)c.b(paramb), a(paramString1, paramv.tagForChildDirectedTreatment, paramString2), bg.e(paramv), this.gh);
      return;
    }
    catch (Throwable paramb)
    {
      ct.b("Could not request interstitial ad from adapter.", paramb);
      throw new RemoteException();
    }
  }
  
  public void a(b paramb, x paramx, v paramv, String paramString, bd parambd)
    throws RemoteException
  {
    a(paramb, paramx, paramv, paramString, null, parambd);
  }
  
  public void a(b paramb, x paramx, v paramv, String paramString1, String paramString2, bd parambd)
    throws RemoteException
  {
    if (!(this.gg instanceof MediationBannerAdapter))
    {
      ct.v("MediationAdapter is not a MediationBannerAdapter: " + this.gg.getClass().getCanonicalName());
      throw new RemoteException();
    }
    ct.r("Requesting banner ad from adapter.");
    try
    {
      ((MediationBannerAdapter)this.gg).requestBannerAd(new bf(parambd), (Activity)c.b(paramb), a(paramString1, paramv.tagForChildDirectedTreatment, paramString2), bg.b(paramx), bg.e(paramv), this.gh);
      return;
    }
    catch (Throwable paramb)
    {
      ct.b("Could not request banner ad from adapter.", paramb);
      throw new RemoteException();
    }
  }
  
  public void destroy()
    throws RemoteException
  {
    try
    {
      this.gg.destroy();
      return;
    }
    catch (Throwable localThrowable)
    {
      ct.b("Could not destroy adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public b getView()
    throws RemoteException
  {
    if (!(this.gg instanceof MediationBannerAdapter))
    {
      ct.v("MediationAdapter is not a MediationBannerAdapter: " + this.gg.getClass().getCanonicalName());
      throw new RemoteException();
    }
    try
    {
      b localb = c.h(((MediationBannerAdapter)this.gg).getBannerView());
      return localb;
    }
    catch (Throwable localThrowable)
    {
      ct.b("Could not get banner view from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void showInterstitial()
    throws RemoteException
  {
    if (!(this.gg instanceof MediationInterstitialAdapter))
    {
      ct.v("MediationAdapter is not a MediationInterstitialAdapter: " + this.gg.getClass().getCanonicalName());
      throw new RemoteException();
    }
    ct.r("Showing interstitial from adapter.");
    try
    {
      ((MediationInterstitialAdapter)this.gg).showInterstitial();
      return;
    }
    catch (Throwable localThrowable)
    {
      ct.b("Could not show interstitial from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */