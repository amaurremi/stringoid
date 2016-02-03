package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationServerParameters;
import java.util.Map;

public final class ba
  extends bb.a
{
  private Map<Class<? extends com.google.android.gms.ads.mediation.NetworkExtras>, com.google.android.gms.ads.mediation.NetworkExtras> gf;
  
  private <NETWORK_EXTRAS extends com.google.ads.mediation.NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> bc m(String paramString)
    throws RemoteException
  {
    try
    {
      Class localClass = Class.forName(paramString, false, ba.class.getClassLoader());
      if (!MediationAdapter.class.isAssignableFrom(localClass))
      {
        ct.v("Could not instantiate mediation adapter: " + paramString + ".");
        throw new RemoteException();
      }
    }
    catch (Throwable localThrowable)
    {
      ct.v("Could not instantiate mediation adapter: " + paramString + ". " + localThrowable.getMessage());
      throw new RemoteException();
    }
    Object localObject = (MediationAdapter)localThrowable.newInstance();
    localObject = new be((MediationAdapter)localObject, (com.google.ads.mediation.NetworkExtras)this.gf.get(((MediationAdapter)localObject).getAdditionalParametersType()));
    return (bc)localObject;
  }
  
  public void c(Map<Class<? extends com.google.android.gms.ads.mediation.NetworkExtras>, com.google.android.gms.ads.mediation.NetworkExtras> paramMap)
  {
    this.gf = paramMap;
  }
  
  public bc l(String paramString)
    throws RemoteException
  {
    return m(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */