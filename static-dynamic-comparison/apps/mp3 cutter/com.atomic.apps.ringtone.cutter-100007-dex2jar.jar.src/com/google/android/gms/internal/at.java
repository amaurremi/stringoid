package com.google.android.gms.internal;

import android.os.RemoteException;
import com.atomic.apps.ringtone.cutter.aa;
import com.atomic.apps.ringtone.cutter.h;
import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class at
  extends an
{
  private final com.google.a.a.a a;
  private final h b;
  
  public at(com.google.a.a.a parama, h paramh)
  {
    this.a = parama;
    this.b = paramh;
  }
  
  private e a(String paramString)
  {
    if (paramString != null) {
      try
      {
        localObject2 = new JSONObject(paramString);
        localObject1 = new HashMap(((JSONObject)localObject2).length());
        Iterator localIterator = ((JSONObject)localObject2).keys();
        for (;;)
        {
          paramString = (String)localObject1;
          if (!localIterator.hasNext()) {
            break;
          }
          paramString = (String)localIterator.next();
          ((Map)localObject1).put(paramString, ((JSONObject)localObject2).getString(paramString));
        }
        paramString = new HashMap(0);
      }
      catch (Throwable paramString)
      {
        aa.b("Could not get MediationServerParameters.", paramString);
        throw new RemoteException();
      }
    }
    Object localObject2 = this.a.c();
    Object localObject1 = null;
    if (localObject2 != null)
    {
      localObject1 = (e)((Class)localObject2).newInstance();
      ((e)localObject1).a(paramString);
    }
    return (e)localObject1;
  }
  
  public final com.google.android.gms.a.a a()
  {
    if (!(this.a instanceof b))
    {
      aa.e("MediationAdapter is not a MediationBannerAdapter: " + this.a.getClass().getCanonicalName());
      throw new RemoteException();
    }
    try
    {
      com.google.android.gms.a.a locala = com.google.android.gms.a.d.a(((b)this.a).e());
      return locala;
    }
    catch (Throwable localThrowable)
    {
      aa.b("Could not get banner view from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public final void a(com.google.android.gms.a.a parama, ah paramah, String paramString, ap paramap)
  {
    a(parama, paramah, paramString, null, paramap);
  }
  
  public final void a(com.google.android.gms.a.a parama, ah paramah, String paramString1, String paramString2, ap paramap)
  {
    if (!(this.a instanceof com.google.a.a.d))
    {
      aa.e("MediationAdapter is not a MediationInterstitialAdapter: " + this.a.getClass().getCanonicalName());
      throw new RemoteException();
    }
    aa.a("Requesting interstitial ad from adapter.");
    try
    {
      paramString2 = (com.google.a.a.d)this.a;
      new c(paramap);
      com.google.android.gms.a.d.a(parama);
      int i = paramah.g;
      a(paramString1);
      aa.a(paramah);
      parama = this.b;
      paramString2.d();
      return;
    }
    catch (Throwable parama)
    {
      aa.b("Could not request interstitial ad from adapter.", parama);
      throw new RemoteException();
    }
  }
  
  public final void a(com.google.android.gms.a.a parama, ak paramak, ah paramah, String paramString, ap paramap)
  {
    a(parama, paramak, paramah, paramString, null, paramap);
  }
  
  public final void a(com.google.android.gms.a.a parama, ak paramak, ah paramah, String paramString1, String paramString2, ap paramap)
  {
    if (!(this.a instanceof b))
    {
      aa.e("MediationAdapter is not a MediationBannerAdapter: " + this.a.getClass().getCanonicalName());
      throw new RemoteException();
    }
    aa.a("Requesting banner ad from adapter.");
    try
    {
      paramString2 = (b)this.a;
      new c(paramap);
      com.google.android.gms.a.d.a(parama);
      int i = paramah.g;
      a(paramString1);
      aa.a(paramak);
      aa.a(paramah);
      parama = this.b;
      paramString2.d();
      return;
    }
    catch (Throwable parama)
    {
      aa.b("Could not request banner ad from adapter.", parama);
      throw new RemoteException();
    }
  }
  
  public final void b()
  {
    if (!(this.a instanceof com.google.a.a.d))
    {
      aa.e("MediationAdapter is not a MediationInterstitialAdapter: " + this.a.getClass().getCanonicalName());
      throw new RemoteException();
    }
    aa.a("Showing interstitial from adapter.");
    try
    {
      ((com.google.a.a.d)this.a).e();
      return;
    }
    catch (Throwable localThrowable)
    {
      aa.b("Could not show interstitial from adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public final void c()
  {
    try
    {
      this.a.a();
      return;
    }
    catch (Throwable localThrowable)
    {
      aa.b("Could not destroy adapter.", localThrowable);
      throw new RemoteException();
    }
  }
  
  public final void d()
  {
    throw new RemoteException();
  }
  
  public final void e()
  {
    throw new RemoteException();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */