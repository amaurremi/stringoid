package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class bz<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters>
  extends bu.a
{
  private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> nU;
  private final NETWORK_EXTRAS nV;
  
  public bz(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> paramMediationAdapter, NETWORK_EXTRAS paramNETWORK_EXTRAS)
  {
    this.nU = paramMediationAdapter;
    this.nV = paramNETWORK_EXTRAS;
  }
  
  private SERVER_PARAMETERS b(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1 != null) {
      try
      {
        localObject = new JSONObject(paramString1);
        paramString2 = new HashMap(((JSONObject)localObject).length());
        Iterator localIterator = ((JSONObject)localObject).keys();
        for (;;)
        {
          paramString1 = paramString2;
          if (!localIterator.hasNext()) {
            break;
          }
          paramString1 = (String)localIterator.next();
          paramString2.put(paramString1, ((JSONObject)localObject).getString(paramString1));
        }
        paramString1 = new HashMap(0);
      }
      catch (Throwable paramString1)
      {
        eu.c("Could not get MediationServerParameters.", paramString1);
        throw new RemoteException();
      }
    }
    Object localObject = this.nU.getServerParametersType();
    paramString2 = null;
    if (localObject != null)
    {
      paramString2 = (MediationServerParameters)((Class)localObject).newInstance();
      paramString2.load(paramString1);
    }
    return paramString2;
  }
  
  public void a(d paramd, ai paramai, String paramString, bv parambv)
  {
    a(paramd, paramai, paramString, null, parambv);
  }
  
  public void a(d paramd, ai paramai, String paramString1, String paramString2, bv parambv)
  {
    if (!(this.nU instanceof MediationInterstitialAdapter))
    {
      eu.D("MediationAdapter is not a MediationInterstitialAdapter: " + this.nU.getClass().getCanonicalName());
      throw new RemoteException();
    }
    eu.z("Requesting interstitial ad from adapter.");
    try
    {
      ((MediationInterstitialAdapter)this.nU).requestInterstitialAd(new ca(parambv), (Activity)e.e(paramd), b(paramString1, paramai.lW, paramString2), cb.e(paramai), this.nV);
      return;
    }
    catch (Throwable paramd)
    {
      eu.c("Could not request interstitial ad from adapter.", paramd);
      throw new RemoteException();
    }
  }
  
  public void a(d paramd, al paramal, ai paramai, String paramString, bv parambv)
  {
    a(paramd, paramal, paramai, paramString, null, parambv);
  }
  
  public void a(d paramd, al paramal, ai paramai, String paramString1, String paramString2, bv parambv)
  {
    if (!(this.nU instanceof MediationBannerAdapter))
    {
      eu.D("MediationAdapter is not a MediationBannerAdapter: " + this.nU.getClass().getCanonicalName());
      throw new RemoteException();
    }
    eu.z("Requesting banner ad from adapter.");
    try
    {
      ((MediationBannerAdapter)this.nU).requestBannerAd(new ca(parambv), (Activity)e.e(paramd), b(paramString1, paramai.lW, paramString2), cb.b(paramal), cb.e(paramai), this.nV);
      return;
    }
    catch (Throwable paramd)
    {
      eu.c("Could not request banner ad from adapter.", paramd);
      throw new RemoteException();
    }
  }
  
  public void destroy()
  {
    try
    {
      this.nU.destroy();
      return;
    }
    catch (Throwable localThrowable)
    {
      eu.c("Could not destroy adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public d getView()
  {
    if (!(this.nU instanceof MediationBannerAdapter))
    {
      eu.D("MediationAdapter is not a MediationBannerAdapter: " + this.nU.getClass().getCanonicalName());
      throw new RemoteException();
    }
    try
    {
      d locald = e.h(((MediationBannerAdapter)this.nU).getBannerView());
      return locald;
    }
    catch (Throwable localThrowable)
    {
      eu.c("Could not get banner view from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void pause()
  {
    throw new RemoteException();
  }
  
  public void resume()
  {
    throw new RemoteException();
  }
  
  public void showInterstitial()
  {
    if (!(this.nU instanceof MediationInterstitialAdapter))
    {
      eu.D("MediationAdapter is not a MediationInterstitialAdapter: " + this.nU.getClass().getCanonicalName());
      throw new RemoteException();
    }
    eu.z("Showing interstitial from adapter.");
    try
    {
      ((MediationInterstitialAdapter)this.nU).showInterstitial();
      return;
    }
    catch (Throwable localThrowable)
    {
      eu.c("Could not show interstitial from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */