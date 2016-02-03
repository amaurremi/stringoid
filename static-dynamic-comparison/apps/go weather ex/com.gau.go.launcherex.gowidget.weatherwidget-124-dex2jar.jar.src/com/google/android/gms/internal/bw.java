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

public final class bw<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters>
  extends br.a
{
  private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> nH;
  private final NETWORK_EXTRAS nI;
  
  public bw(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> paramMediationAdapter, NETWORK_EXTRAS paramNETWORK_EXTRAS)
  {
    this.nH = paramMediationAdapter;
    this.nI = paramNETWORK_EXTRAS;
  }
  
  private SERVER_PARAMETERS b(String paramString1, int paramInt, String paramString2)
    throws RemoteException
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
        dw.c("Could not get MediationServerParameters.", paramString1);
        throw new RemoteException();
      }
    }
    Object localObject = this.nH.getServerParametersType();
    paramString2 = null;
    if (localObject != null)
    {
      paramString2 = (MediationServerParameters)((Class)localObject).newInstance();
      paramString2.load(paramString1);
    }
    return paramString2;
  }
  
  public void a(d paramd, ah paramah, String paramString, bs parambs)
    throws RemoteException
  {
    a(paramd, paramah, paramString, null, parambs);
  }
  
  public void a(d paramd, ah paramah, String paramString1, String paramString2, bs parambs)
    throws RemoteException
  {
    if (!(this.nH instanceof MediationInterstitialAdapter))
    {
      dw.z("MediationAdapter is not a MediationInterstitialAdapter: " + this.nH.getClass().getCanonicalName());
      throw new RemoteException();
    }
    dw.v("Requesting interstitial ad from adapter.");
    try
    {
      ((MediationInterstitialAdapter)this.nH).requestInterstitialAd(new bx(parambs), (Activity)e.d(paramd), b(paramString1, paramah.lL, paramString2), by.e(paramah), this.nI);
      return;
    }
    catch (Throwable paramd)
    {
      dw.c("Could not request interstitial ad from adapter.", paramd);
      throw new RemoteException();
    }
  }
  
  public void a(d paramd, ak paramak, ah paramah, String paramString, bs parambs)
    throws RemoteException
  {
    a(paramd, paramak, paramah, paramString, null, parambs);
  }
  
  public void a(d paramd, ak paramak, ah paramah, String paramString1, String paramString2, bs parambs)
    throws RemoteException
  {
    if (!(this.nH instanceof MediationBannerAdapter))
    {
      dw.z("MediationAdapter is not a MediationBannerAdapter: " + this.nH.getClass().getCanonicalName());
      throw new RemoteException();
    }
    dw.v("Requesting banner ad from adapter.");
    try
    {
      ((MediationBannerAdapter)this.nH).requestBannerAd(new bx(parambs), (Activity)e.d(paramd), b(paramString1, paramah.lL, paramString2), by.b(paramak), by.e(paramah), this.nI);
      return;
    }
    catch (Throwable paramd)
    {
      dw.c("Could not request banner ad from adapter.", paramd);
      throw new RemoteException();
    }
  }
  
  public void destroy()
    throws RemoteException
  {
    try
    {
      this.nH.destroy();
      return;
    }
    catch (Throwable localThrowable)
    {
      dw.c("Could not destroy adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public d getView()
    throws RemoteException
  {
    if (!(this.nH instanceof MediationBannerAdapter))
    {
      dw.z("MediationAdapter is not a MediationBannerAdapter: " + this.nH.getClass().getCanonicalName());
      throw new RemoteException();
    }
    try
    {
      d locald = e.h(((MediationBannerAdapter)this.nH).getBannerView());
      return locald;
    }
    catch (Throwable localThrowable)
    {
      dw.c("Could not get banner view from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public void pause()
    throws RemoteException
  {
    throw new RemoteException();
  }
  
  public void resume()
    throws RemoteException
  {
    throw new RemoteException();
  }
  
  public void showInterstitial()
    throws RemoteException
  {
    if (!(this.nH instanceof MediationInterstitialAdapter))
    {
      dw.z("MediationAdapter is not a MediationInterstitialAdapter: " + this.nH.getClass().getCanonicalName());
      throw new RemoteException();
    }
    dw.v("Showing interstitial from adapter.");
    try
    {
      ((MediationInterstitialAdapter)this.nH).showInterstitial();
      return;
    }
    catch (Throwable localThrowable)
    {
      dw.c("Could not show interstitial from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */