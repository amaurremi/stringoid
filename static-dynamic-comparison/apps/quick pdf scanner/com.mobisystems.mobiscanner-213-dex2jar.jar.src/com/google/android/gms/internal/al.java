package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.a.a;
import com.google.ads.mediation.b;
import com.google.ads.mediation.e;
import com.google.ads.mediation.g;
import com.google.android.gms.dynamic.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class al<NETWORK_EXTRAS extends g, SERVER_PARAMETERS extends MediationServerParameters>
  extends aj.a
{
  private final b<NETWORK_EXTRAS, SERVER_PARAMETERS> Cp;
  private final NETWORK_EXTRAS Cq;
  
  public al(b<NETWORK_EXTRAS, SERVER_PARAMETERS> paramb, NETWORK_EXTRAS paramNETWORK_EXTRAS)
  {
    this.Cp = paramb;
    this.Cq = paramNETWORK_EXTRAS;
  }
  
  private SERVER_PARAMETERS a(String paramString1, int paramInt, String paramString2)
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
        localObject2 = this.Cp.ft();
      }
      catch (Throwable paramString1)
      {
        ce.c("Could not get MediationServerParameters.", paramString1);
        throw new RemoteException();
      }
    }
    for (;;)
    {
      localObject1 = null;
      if (localObject2 != null)
      {
        localObject1 = (MediationServerParameters)((Class)localObject2).newInstance();
        ((MediationServerParameters)localObject1).a(paramString1);
      }
      if (!(localObject1 instanceof a)) {
        break;
      }
      paramString1 = (a)localObject1;
      paramString1.gT = paramString2;
      paramString1.gU = paramInt;
      return (SERVER_PARAMETERS)localObject1;
      paramString1 = new HashMap(0);
    }
    return (SERVER_PARAMETERS)localObject1;
  }
  
  public void a(com.google.android.gms.dynamic.c paramc, ab paramab, z paramz, String paramString, ak paramak)
  {
    a(paramc, paramab, paramz, paramString, null, paramak);
  }
  
  public void a(com.google.android.gms.dynamic.c paramc, ab paramab, z paramz, String paramString1, String paramString2, ak paramak)
  {
    if (!(this.Cp instanceof com.google.ads.mediation.c))
    {
      ce.D("MediationAdapter is not a MediationBannerAdapter: " + this.Cp.getClass().getCanonicalName());
      throw new RemoteException();
    }
    ce.aG("Requesting banner ad from adapter.");
    try
    {
      ((com.google.ads.mediation.c)this.Cp).a(new an(paramak), (Activity)d.a(paramc), a(paramString1, paramz.gU, paramString2), ao.b(paramab), ao.b(paramz), this.Cq);
      return;
    }
    catch (Throwable paramc)
    {
      ce.c("Could not request banner ad from adapter.", paramc);
      throw new RemoteException();
    }
  }
  
  public void a(com.google.android.gms.dynamic.c paramc, z paramz, String paramString, ak paramak)
  {
    a(paramc, paramz, paramString, null, paramak);
  }
  
  public void a(com.google.android.gms.dynamic.c paramc, z paramz, String paramString1, String paramString2, ak paramak)
  {
    if (!(this.Cp instanceof e))
    {
      ce.D("MediationAdapter is not a MediationInterstitialAdapter: " + this.Cp.getClass().getCanonicalName());
      throw new RemoteException();
    }
    ce.aG("Requesting interstitial ad from adapter.");
    try
    {
      ((e)this.Cp).a(new an(paramak), (Activity)d.a(paramc), a(paramString1, paramz.gU, paramString2), ao.b(paramz), this.Cq);
      return;
    }
    catch (Throwable paramc)
    {
      ce.c("Could not request interstitial ad from adapter.", paramc);
      throw new RemoteException();
    }
  }
  
  public void destroy()
  {
    try
    {
      this.Cp.destroy();
      return;
    }
    catch (Throwable localThrowable)
    {
      ce.c("Could not destroy adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void fv()
  {
    if (!(this.Cp instanceof e))
    {
      ce.D("MediationAdapter is not a MediationInterstitialAdapter: " + this.Cp.getClass().getCanonicalName());
      throw new RemoteException();
    }
    ce.aG("Showing interstitial from adapter.");
    try
    {
      ((e)this.Cp).fv();
      return;
    }
    catch (Throwable localThrowable)
    {
      ce.c("Could not show interstitial from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public com.google.android.gms.dynamic.c pi()
  {
    if (!(this.Cp instanceof com.google.ads.mediation.c))
    {
      ce.D("MediationAdapter is not a MediationBannerAdapter: " + this.Cp.getClass().getCanonicalName());
      throw new RemoteException();
    }
    try
    {
      com.google.android.gms.dynamic.c localc = d.J(((com.google.ads.mediation.c)this.Cp).fu());
      return localc;
    }
    catch (Throwable localThrowable)
    {
      ce.c("Could not get banner view from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */